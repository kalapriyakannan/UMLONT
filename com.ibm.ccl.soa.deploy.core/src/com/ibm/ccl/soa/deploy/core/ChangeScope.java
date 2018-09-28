/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.CompositeEMFOperation;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * 
 * A ChangeScope provides a simple abstraction for dealing with scribblers, undo, and etc. and also
 * manages the underlying resource reference counts. The ChangeScope is model specific through
 * generics.
 * 
 * @since 1.0
 * 
 * 
 * @param <T>
 *           The type of the target {@link DeployModelObject} that is expected to be managed by the
 *           returned ChangeScope.
 * @param <D>
 *           The type of the {@link IScribblerDomain} that is expected to be managed by the returned
 *           ChangeScope.
 */
public class ChangeScope<T extends EObject, D extends IScribblerDomain> implements IAdaptable {
	private boolean readOnly = false;

	private final class SaveOperation extends AbstractEMFOperation {
		private final boolean force;

		private SaveOperation(boolean force) {
			super(getTransactionalEditingDomain(),
					DeployCoreMessages.ChangeScope_Save_Changes_Operatio_);
			this.force = force;
		}

		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			try {
				if (scribbler != null) {
					scribbler.save(force, monitor);
				}
			} catch (EditModelException e) {
				throw new ExecutionException(e.getMessage(), e);
			}
			return Status.OK_STATUS;
		}
	}

	private final class CloseOperation extends AbstractEMFOperation {

		private CloseOperation() {
			super(getTransactionalEditingDomain(), NLS.bind(
					DeployCoreMessages.ChangeScope_Release_referencees_to_shared_resou_,
					getTopologyFile()));
		}

		@Override
		public boolean canUndo() {
			return false;
		}

		@Override
		public boolean canRedo() {
			return false;
		}

		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			try {
				if (scribbler != null && !scribbler.isClosed()) {
					scribbler.close(monitor);
				}

			} catch (EditModelException e) {
				throw new ExecutionException(e.getMessage(), e);
			} finally {
				scribbler = null;
			}
			return Status.OK_STATUS;
		}
	}

	private final class CreateOperation<CreateType extends EObject> extends AbstractEMFOperation {

		private CreateType created;
		private final Resource resource;
		private final EClass eClass;

		private CreateOperation(EClass eClass, Resource resource) {
			super(getTransactionalEditingDomain(), NLS.bind(
					DeployCoreMessages.ChangeScope_Create_model_of_type_0_, eClass.getName()));
			this.eClass = eClass;
			this.resource = resource;

		}

		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
			EFactory factory = eClass.getEPackage().getEFactoryInstance();
			created = (CreateType) factory.create(eClass);
			resource.getContents().add(created);
			return Status.OK_STATUS;
		}

		public CreateType getCreated() {
			return created;
		}

	}

	/**
	 * Indicates the results of the operation should not be persisted regardless of the underlying
	 * model sharing.
	 */
	public static final int OPTION_DO_NOT_SAVE = 0;
	/**
	 * Indicates the results of the operation should only be saved if no other clients of the model
	 * are holding a resource.
	 */
	public static final int OPTION_SAVE_IF_UNSHARED = 1;

	/**
	 * Indicates that the results of the operation should always be saved, regardless of whether the
	 * underlying model is shared with other clients.
	 */
	public static final int OPTION_FORCE_SAVE = 2;

	private static final Class<?> CHANGE_SCOPE_CLASS = ChangeScope.class;
	private static final Class<?> TOPOLOGY_CLASS = Topology.class;
	private static final Class<?> IEDITMODEL_SCRIBBLER_CLASS = IEditModelScribbler.class;

	private final Object lock = new Object();

	private final ChangeScope<?, D> parent;
	private final D domain;
	private final IFile topologyFile;
	private IEditModelScribbler scribbler;
	private Topology source;

	private T target;

	/**
	 * Provides a convenient method to fetch a ChangeScope from an {@link IAdaptable} element.
	 * 
	 * @param <TargetDMOType>
	 *           The type of the target {@link DeployModelObject} that is expected to be managed by
	 *           the returned ChangeScope.
	 * @param <ScribblerDomainType>
	 *           The type of the {@link IScribblerDomain} that is expected to be managed by the
	 *           returned ChangeScope.
	 * @param info
	 *           An adaptable element passed in through an
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method that is
	 *           expected to know about a ChangeScope.
	 * @return
	 */
	public static <TargetDMOType extends EObject, ScribblerDomainType extends IScribblerDomain> ChangeScope<TargetDMOType, ScribblerDomainType> findChangeScope(
			IAdaptable info) {
		if (info instanceof ChangeScope) {
			return (ChangeScope<TargetDMOType, ScribblerDomainType>) info;
		}
		return (ChangeScope<TargetDMOType, ScribblerDomainType>) info.getAdapter(ChangeScope.class);
	}

	// Specific to Deploy Tools API
	/**
	 * Create a {@link ChangeScope} on the given file. Any model access will use the shared resource
	 * loaded in memory.
	 * 
	 * @param topologyFile
	 *           The IFile of the Topology resource on disk.
	 * @return A ChangeScope using the Topology contained in the given IFile as its
	 *         {@link #getTarget()}.
	 */
	public static ChangeScope<Topology, DeploymentTopologyDomain> createChangeScopeForWrite(
			IFile topologyFile) {
		return new ChangeScope<Topology, DeploymentTopologyDomain>(topologyFile,
				new DeploymentTopologyDomain(topologyFile), false);
	}

	// Specific to Deploy Tools API
	/**
	 * Create a {@link ChangeScope} on the given {@link DeployModelObject}.
	 * 
	 * <p>
	 * Any model access will use the shared resource loaded in memory, but bump the reference count
	 * for this ChangeScope's usage.
	 * </p>
	 * 
	 * @param <TargetDMOType>
	 *           The type of the target {@link DeployModelObject} that is expected to be managed by
	 *           the returned ChangeScope.
	 * @param dmo
	 *           The target of the operation, which will be available from the {{@link #getTarget()}
	 *           method of the returned ChangeScope.
	 * @return A ChangeScope typed to the given {@link DeployModelObject} with all necessary
	 *         reference counts.
	 */
	public static <TargetDMOType extends EObject> ChangeScope<TargetDMOType, DeploymentTopologyDomain> createChangeScopeForWrite(
			TargetDMOType dmo) {
		IFile theTopologyFile = WorkbenchResourceHelper.getFile(dmo);
		return createChangeScopeForWrite(dmo, new DeploymentTopologyDomain(theTopologyFile));
	}

	// Specific to Deploy Tools API
	/**
	 * Create a {@link ChangeScope} on the given {@link DeployModelObject}.
	 * 
	 * <p>
	 * Any model access will use the read only shared resource loaded in memory, but bump the
	 * reference count for this ChangeScope's usage.
	 * </p>
	 * 
	 * @param <TargetDMOType>
	 *           The type of the target {@link DeployModelObject} that is expected to be managed by
	 *           the returned ChangeScope.
	 * @param dmo
	 *           The target of the operation, which will be available from the {{@link #getTarget()}
	 *           method of the returned ChangeScope.
	 * @return A ChangeScope typed to the given {@link DeployModelObject} with all necessary
	 *         reference counts.
	 */
	public static <TargetDMOType extends EObject> ChangeScope<TargetDMOType, DeploymentTopologyDomain> createChangeScopeForRead(
			TargetDMOType dmo) {

		IFile theTopologyFile = WorkbenchResourceHelper.getFile(dmo);
		return createChangeScopeForRead(dmo, new DeploymentTopologyDomain(theTopologyFile));
	}

	// Specific to Deploy Tools API
	/**
	 * Create a {@link ChangeScope} on the given file. Any model access will use the read only shared
	 * resource loaded in memory.
	 * 
	 * @param topologyFile
	 *           The IFile of the Topology resource on disk.
	 * @return A ChangeScope using the Topology contained in the given IFile as its
	 *         {@link #getTarget()}.
	 */
	public static ChangeScope<Topology, DeploymentTopologyDomain> createChangeScopeForRead(
			IFile topologyFile) {
		return new ChangeScope<Topology, DeploymentTopologyDomain>(topologyFile,
				new DeploymentTopologyDomain(topologyFile), true);
	}

	/**
	 * Create a {@link ChangeScope} on the given {@link DeployModelObject}.
	 * 
	 * <p>
	 * Any model access will use the shared read only resource loaded in memory, but bump the
	 * reference count for this ChangeScope's usage.
	 * </p>
	 * 
	 * @param <TargetDMOType>
	 *           The type of the target {@link EObject} that is expected to be managed by the
	 *           returned ChangeScope.
	 * @param <ScribblerDomainType>
	 *           The type of the {@link IScribblerDomain} that is expected to be managed by the
	 *           returned ChangeScope.
	 * @param dmo
	 *           The target of the operation, which will be available from the {{@link #getTarget()}
	 *           method of the returned ChangeScope.
	 * @param domain
	 *           The scribbler domain that describes the set of associated files managed under this
	 *           ChangeScope.
	 * @return A ChangeScope typed to the given {@link DeployModelObject} with all necessary
	 *         reference counts.
	 */
	public static <TargetDMOType extends EObject, ScribblerDomainType extends IScribblerDomain> ChangeScope<TargetDMOType, ScribblerDomainType> createChangeScopeForRead(
			TargetDMOType dmo, ScribblerDomainType domain) {
		return new ChangeScope<TargetDMOType, ScribblerDomainType>(dmo, domain, true);
	}

	/**
	 * Create a {@link ChangeScope} on the given {@link DeployModelObject}.
	 * 
	 * <p>
	 * Reuse the reference counts held by the given parent ChangeScope.
	 * </p>
	 * 
	 * @param
	 * <P>
	 * The type of the parent ChangeScope that was already created.
	 * @param <C>
	 *           The type of the object that will be the {@link #getTarget() target} ChangeScope.
	 * @param parent
	 *           A parent ChangeScope that already has its own reference count that will be shared by
	 *           the new child ChangeScope.
	 * @param dmo
	 *           The target of the operation, which will be available from the {{@link #getTarget()}
	 *           method of the returned ChangeScope.
	 * @return A ChangeScope typed to the given {@link DeployModelObject} with all necessary
	 *         reference counts.
	 */
	public static <ParentDMOType extends EObject, TargetDMOType extends EObject, ScribblerDomainType extends IScribblerDomain> ChangeScope<TargetDMOType, ScribblerDomainType> createChangeScopeForRead(
			ChangeScope<ParentDMOType, ScribblerDomainType> parent, TargetDMOType dmo) {
		return new ChangeScope<TargetDMOType, ScribblerDomainType>(parent, dmo, true);
	}

	/**
	 * Create a {@link ChangeScope} on the given {@link DeployModelObject}.
	 * 
	 * <p>
	 * Any model access will use the shared resource loaded in memory, but bump the reference count
	 * for this ChangeScope's usage.
	 * </p>
	 * 
	 * @param <TargetDMOType>
	 *           The type of the target {@link EObject} that is expected to be managed by the
	 *           returned ChangeScope.
	 * @param <ScribblerDomainType>
	 *           The type of the {@link IScribblerDomain} that is expected to be managed by the
	 *           returned ChangeScope.
	 * @param dmo
	 *           The target of the operation, which will be available from the {{@link #getTarget()}
	 *           method of the returned ChangeScope.
	 * @param domain
	 *           The scribbler domain that describes the set of associated files managed under this
	 *           ChangeScope.
	 * @return A ChangeScope typed to the given {@link DeployModelObject} with all necessary
	 *         reference counts.
	 */
	public static <TargetDMOType extends EObject, ScribblerDomainType extends IScribblerDomain> ChangeScope<TargetDMOType, ScribblerDomainType> createChangeScopeForWrite(
			TargetDMOType dmo, ScribblerDomainType domain) {
		return new ChangeScope<TargetDMOType, ScribblerDomainType>(dmo, domain, false);
	}

	/**
	 * Create a {@link ChangeScope} on the given {@link DeployModelObject}.
	 * 
	 * <p>
	 * Reuse the reference counts held by the given parent ChangeScope.
	 * </p>
	 * 
	 * @param
	 * <P>
	 * The type of the parent ChangeScope that was already created.
	 * @param <C>
	 *           The type of the object that will be the {@link #getTarget() target} ChangeScope.
	 * @param parent
	 *           A parent ChangeScope that already has its own reference count that will be shared by
	 *           the new child ChangeScope.
	 * @param dmo
	 *           The target of the operation, which will be available from the {{@link #getTarget()}
	 *           method of the returned ChangeScope.
	 * @return A ChangeScope typed to the given {@link DeployModelObject} with all necessary
	 *         reference counts.
	 */
	public static <ParentDMOType extends EObject, TargetDMOType extends EObject, ScribblerDomainType extends IScribblerDomain> ChangeScope<TargetDMOType, ScribblerDomainType> createChangeScopeForWrite(
			ChangeScope<ParentDMOType, ScribblerDomainType> parent, TargetDMOType dmo) {
		return new ChangeScope<TargetDMOType, ScribblerDomainType>(parent, dmo, false);
	}

	public static IStatus execute(IUndoableOperation op, IUndoContext context,
			IProgressMonitor monitor, IAdaptable args) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		IStatus status = null;
		try {
			op.addContext(context);
			status = OperationHistoryFactory.getOperationHistory().execute(op, monitor, args);

		} catch (ExecutionException e) {
			status = DeployCorePlugin.createErrorStatus(0, e.getMessage(), e);
		}
		return status;
	}

	public static IStatus undo(IUndoableOperation op, IUndoContext context,
			IProgressMonitor monitor, IAdaptable args) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		IStatus status = null;
		try {
			op.addContext(context);
			status = OperationHistoryFactory.getOperationHistory().undoOperation(op, monitor, args);

		} catch (ExecutionException e) {
			status = DeployCorePlugin.createErrorStatus(0, e.getMessage(), e);
		}
		return status;
	}

	protected ChangeScope(IFile theTopologyFile, D theDomain, boolean isReadOnly) {
		Assert.isNotNull(theTopologyFile);
		readOnly = isReadOnly;
		domain = theDomain;
		topologyFile = theTopologyFile;
		parent = null;

		openScribbler();
	}

	protected ChangeScope(T dmo, D theDomain, boolean isReadOnly) {
		Assert.isNotNull(dmo);
		readOnly = isReadOnly;
		IFile theTopologyFile = WorkbenchResourceHelper.getFile(dmo);

		Assert.isNotNull(theTopologyFile);

		domain = theDomain;
		topologyFile = theTopologyFile;
		parent = null;

		openScribbler();
		target = dmo;
	}

	protected <ParentDMOType extends EObject> ChangeScope(ChangeScope<ParentDMOType, D> parentScope,
			T dmo, boolean isReadOnly) {
		readOnly = isReadOnly;
		parent = parentScope;
		domain = parent.getDomain();
		topologyFile = parent.getTopologyFile();

		openScribbler();
		target = dmo;
	}

	private IEditModelScribbler openScribbler() {
		synchronized (lock) {
			if (scribbler == null) {

				if (parent == null) {
					// follow an "Open Scribbler" pattern from each method
					try {
						if (readOnly) {
							scribbler = IEditModelFactory.eINSTANCE.createScribblerForRead(topologyFile
									.getProject(), domain);
						} else {
							scribbler = IEditModelFactory.eINSTANCE.createScribblerForWrite(topologyFile
									.getProject(), domain);
						}
					} catch (EditModelException e) {
						DeployCorePlugin.logError(0, e.getMessage(), e);
					}
					Assert.isNotNull(scribbler);
				} else {
					scribbler = parent.openScribbler();
				}
			}
		}
		return scribbler;
	}

	/**
	 * Return the topology IFile that is being modified under this ChangeScope.
	 * 
	 * @return The topology IFile that is being modified under this ChangeScope.
	 */
	public IFile getTopologyFile() {
		return topologyFile;
	}

	/**
	 * Return the {@link IScribblerDomain domain} associated with this ChangeScope.
	 * 
	 * @return The {@link IScribblerDomain domain} associated with this ChangeScope.
	 */
	public D getDomain() {
		return domain;
	}

	/**
	 * @return The target of this ChangeScope.
	 */
	public T getTarget() {
		if (target == null) {
			return (T) openTopology();
		} else if (target.eIsProxy()) {
			target = (T) EcoreUtil.resolve(source, WorkbenchResourceHelper.getResourceSet(topologyFile
					.getProject()));
		}
		return target;
	}

	/**
	 * 
	 * Open a model contained in the given modelFile. The return type will be inferred from the type
	 * of the variable that the result is assigned to. The given eClass will determine the type of
	 * object to create if necessary.
	 * 
	 * @param <RootModelType>
	 *           The expected model type that will be found in the given modelFile.
	 * @param modelFile
	 *           A handle to the IFile that contains (or will contain) the model.
	 * @param eClass
	 *           The EMF Class of the type to be returned (defined on the EPackage of a given EMF
	 *           model).
	 * @return An instance of the type eClass.getInstanceClass() contained in the shared EMF resource
	 *         for given modelFile
	 */
	public <RootModelType extends EObject> RootModelType openModel(IFile modelFile, EClass eClass) {
		return openModel(modelFile, eClass, true);
	}

	/**
	 * 
	 * Open a model contained in the given modelFile. The return type will be inferred from the type
	 * of the variable that the result is assigned to. The given eClass will determine the type of
	 * object to create if necessary.
	 * 
	 * @param <RootModelType>
	 *           The expected model type that will be found in the given modelFile.
	 * @param modelFile
	 *           A handle to the IFile that contains (or will contain) the model.
	 * @param eClass
	 *           The EMF Class of the type to be returned (defined on the EPackage of a given EMF
	 *           model).
	 * @param forceLoad
	 *           Load the resource if it is not already.
	 * @return An instance of the type eClass.getInstanceClass() contained in the shared EMF resource
	 *         for given modelFile
	 */
	public <RootModelType extends EObject> RootModelType openModel(IFile modelFile, EClass eClass,
			boolean forceLoad) {

		Class<?> expected = eClass.getInstanceClass();

		final Resource resource;
		if (forceLoad) {
			resource = openScribbler().getResource(modelFile.getFullPath());
		} else {
			resource = openScribbler().getResource(modelFile.getFullPath(),
					IEditModelScribbler.OPTION_NONE);
		}
		List<EObject> contents = resource.getContents();
		if (contents.size() > 0) {
			for (Iterator<EObject> contentItr = contents.iterator(); contentItr.hasNext();) {
				EObject content = contentItr.next();
				if (content != null && expected.isInstance(content)) {
					return (RootModelType) content;
				}
			}
		}

		if (forceLoad) {
			CreateOperation<RootModelType> createOp = new CreateOperation<RootModelType>(eClass,
					resource);

			IStatus status = execute(createOp, new NullProgressMonitor());
			if (!status.isOK()) {
				DeployCorePlugin.log(status);
			}

			return createOp.getCreated();
		}
		return null;
	}

	/**
	 * <p>
	 * The initializeOperation will be called on a child ChangeScope of this ChangeScope, whose
	 * target will be the newly created root model object. For instance, if you call this method
	 * with:
	 * </p>
	 * 
	 * <pre>
	 * &lt;code&gt;
	 * MyRootType root = createModel(file, MyPackage.eINSTANCE.getMyRootType(), initOp);
	 * &lt;/code&gt;
	 * </pre>
	 * 
	 * <p>
	 * Then initOp will be called on a child ChangeScope (thus it will *not* bump the reference
	 * count), and that ChangeScope.getTarget() will return a instance of the type MyRootType.
	 * </p>
	 * <p>
	 * Use {@link #findChangeScope(IAdaptable)} to return an instance of
	 * <code>ChangeScope<RootModelType, D></code> where RootModelType is determined by this method
	 * and D is determined by this ChangeScope.
	 * </p>
	 * 
	 * @param <RootModelType>
	 *           The type of the expected root model.
	 * @param modelFile
	 *           The file that will contain the root model.
	 * @param eClass
	 *           The meta class for RootModelType.
	 * @param initializeOperation
	 *           An operation to execute if the model object must be created. The operation will be
	 *           supplied with the instance of the root object (of type eClass.getInstanceClass()) to
	 *           properly configure.
	 * @return An instance of the type eClass.getInstanceClass() contained in the shared EMF resource
	 *         for given modelFile
	 * @throws ExecutionException
	 *            If a problem occurs or any status other than OK is returned from the create
	 *            operation.
	 */
	public <RootModelType extends EObject> RootModelType createModel(IFile modelFile, EClass eClass,
			InitializeModelOperation<RootModelType> initializeOperation) throws ExecutionException {

		Class<?> expected = eClass.getInstanceClass();

		final Resource resource = scribbler.getResource(modelFile.getFullPath());
		List<EObject> contents = resource.getContents();
		if (contents.size() > 0) {
			for (Iterator<EObject> contentItr = contents.iterator(); contentItr.hasNext();) {
				EObject content = contentItr.next();
				if (content != null && expected.isInstance(content)) {
					return (RootModelType) content;
				}
			}
		}

		CreateOperation<RootModelType> createModelOp = new CreateOperation<RootModelType>(eClass,
				resource);
		IStatus status = execute(createModelOp, new NullProgressMonitor());
		if (!status.isOK()) {
			throw new ExecutionException(status.getMessage(), status.getException());
		}

		RootModelType model = createModelOp.getCreated();
		ChangeScope<RootModelType, D> childChangeScope = new ChangeScope<RootModelType, D>(this,
				model, readOnly);

		if (initializeOperation != null) {
			status = childChangeScope.execute(initializeOperation, new NullProgressMonitor());
			if (!status.isOK()) {
				throw new ExecutionException(status.getMessage(), status.getException());
			}
		}

		return model;
	}

	/**
	 * Open the Topology that is managed by this ChangeScope. If this ChangeScope was created with
	 * parent (see {@link ChangeScope#createChangeScopeForWrite(ChangeScope, DeployModelObject)},
	 * then the reference count will not be incremented as a resul of this method. Otherwise, the
	 * reference count of the shared resource will reflect the client's usage.
	 * 
	 * @return
	 */
	public Topology openTopology() {
		synchronized (lock) {
			if (source == null) {
				DeployCoreRoot root = openModel(topologyFile, CorePackage.eINSTANCE.getDeployCoreRoot());
				source = root.getTopology();
			} else if (source.eIsProxy()) {
				source = (Topology) EcoreUtil.resolve(source, openScribbler().getResource(
						topologyFile.getFullPath()));
			}
		}
		return source;
	}

	/**
	 * Creates a new Topology in the resource identified by this ChangeScope, but does not persist
	 * the new model.
	 * 
	 * @param namespace
	 *           The namespace to create the Topology within. Note that the actual contents of the
	 *           Topology will be persisted in the IFile that this ChangeScope knows about regardless
	 *           of the namespace given.
	 * @param topologyName
	 *           The name of the Topology to create
	 * @param monitor
	 *           A progress monitor to provide feedback to the user about the current step of the
	 *           operation.
	 * @return The Topology that was created as a result of this method or the cached version if
	 *         already created.
	 * @throws ExecutionException
	 *            If a problem occurs while creating the Topology.
	 * @see {@link #saveChangesAndClose(boolean, IProgressMonitor)}
	 */
	public Topology createTopology(String namespace, String topologyName, IProgressMonitor monitor)
			throws ExecutionException {

		synchronized (lock) {
			if (source == null) {
				final Resource resource = scribbler.getResource(topologyFile.getFullPath());
				EList contents = resource.getContents();
				if (contents.size() > 0) {
					Object content = contents.get(0);
					if (content != null && content instanceof DeployCoreRoot) {
						DeployCoreRoot root = (DeployCoreRoot) content;
						source = root.getTopology();
					}
				} else {
					// setup referencing topology
					final DeployCoreRoot root = CoreFactory.eINSTANCE.createDeployCoreRoot();
					source = CoreFactory.eINSTANCE.createTopology();
					source.setNamespace(namespace);
					source.setName(topologyName);
					root.setTopology(source);
					// do not execute against the command stack.
					IStatus status = new AbstractEMFOperation(getTransactionalEditingDomain(), NLS.bind(
							DeployCoreMessages.ChangeScope_Creating_Topology_0_, topologyName)) {

						public IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {

							resource.getContents().add(root);
							return Status.OK_STATUS;
						}
					}.execute(monitor, null);

					if (!status.isOK()) {
						throw new ExecutionException(status.getMessage(), status.getException());
					}
				}
			}
		}
		return source;
	}

	/**
	 * Return the scribbler used by this ChangeScope to maintain a reference count against the model.
	 * 
	 * @return The scribbler used by this ChangeScope to maintain a reference count against the
	 *         model.
	 */
	public IEditModelScribbler getScribbler() {
		return openScribbler();
	}

	/**
	 * Find or create the proper {@link TransactionalEditingDomain} to use when creating
	 * {@link AbstractEMFOperation operations} to execute against the model.
	 * 
	 * @return The proper {@link TransactionalEditingDomain} to use when creating
	 *         {@link AbstractEMFOperation operations} to execute against the model.
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() {
		IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE.getContext(topologyFile
				.getProject());
		ResourceSet resourceSet = context.getResourceSet();
		TransactionalEditingDomain txdomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(resourceSet);
		if (txdomain == null) {
			txdomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		}
		return txdomain;
	}

	/**
	 * Executes the given operation passing this ChangeScope as the IAdaptable arguments. Exactly
	 * equivalent to <code>execute(op, OPTION_DO_NOT_SAVE, monitor)</code>.
	 * 
	 * @param op
	 *           The operation to execute against the model managed by this ChangeScope. The
	 *           ChangeScope will pass itself as the {@link IAdaptable} argument of the
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method.
	 * 
	 * @param monitor
	 *           A progress monitor to provide feedback to the user about the current step of the
	 *           operation.
	 * @return The status returned from the operation after execution.
	 */
	public IStatus execute(IUndoableOperation op, IProgressMonitor monitor) {
		return execute(op, OPTION_DO_NOT_SAVE, monitor);
	}

	/**
	 * Executes the given operation passing this ChangeScope as the IAdaptable arguments.
	 * 
	 * @param op
	 *           The operation to execute against the model managed by this ChangeScope. The
	 *           ChangeScope will pass itself as the {@link IAdaptable} argument of the
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method.
	 * @param saveOptions
	 *           Indicate whether the results of the operation should be persisted after execution
	 *           via {@link #OPTION_DO_NOT_SAVE}, {@link #OPTION_FORCE_SAVE},
	 *           {@link #OPTION_SAVE_IF_UNSHARED},
	 * @param monitor
	 *           A progress monitor to supply to the operation.
	 * @return The status returned from the operation after execution.
	 */
	public IStatus execute(IUndoableOperation op, int saveOptions, IProgressMonitor monitor) {

		// if AbstractEMFOperation add the editing domain undo context
		IStatus status = null;
		if (readOnly) {
			return openScribbler().execute(op, monitor, this);
		}

		switch (saveOptions)
		{
		case OPTION_FORCE_SAVE:
		case OPTION_SAVE_IF_UNSHARED:
			CompositeEMFOperation compositeOp = new CompositeEMFOperation(
					getTransactionalEditingDomain(), op.getLabel());

			IUndoableOperation saveOp = new SaveOperation((saveOptions & OPTION_FORCE_SAVE) != 0);
			compositeOp.add(op);
			compositeOp.add(saveOp);
			status = openScribbler().execute(compositeOp, monitor, this);
			break;
		case OPTION_DO_NOT_SAVE:
		default:
			status = openScribbler().execute(op, monitor, this);
		}

		return status;
	}

	/**
	 * Executes the given operation passing this ChangeScope as the IAdaptable arguments. Exactly
	 * equivalent to <code>execute(op, OPTION_DO_NOT_SAVE, monitor)</code>.
	 * 
	 * @param op
	 *           The operation to execute against the model managed by this ChangeScope. The
	 *           ChangeScope will pass itself as the {@link IAdaptable} argument of the
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method.
	 * 
	 * @param monitor
	 *           A progress monitor to provide feedback to the user about the current step of the
	 *           operation.
	 * @return The status returned from the operation after execution.
	 */
	public IStatus undo(IUndoableOperation op, IProgressMonitor monitor) {
		return undo(op, OPTION_DO_NOT_SAVE, monitor);
	}

	/**
	 * Executes the given operation passing this ChangeScope as the IAdaptable arguments.
	 * 
	 * @param op
	 *           The operation to execute against the model managed by this ChangeScope. The
	 *           ChangeScope will pass itself as the {@link IAdaptable} argument of the
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method.
	 * @param saveOptions
	 *           Indicate whether the results of the operation should be persisted after execution
	 *           via {@link #OPTION_DO_NOT_SAVE}, {@link #OPTION_FORCE_SAVE},
	 *           {@link #OPTION_SAVE_IF_UNSHARED},
	 * @param monitor
	 *           A progress monitor to supply to the operation.
	 * @return The status returned from the operation after execution.
	 */
	public IStatus undo(IUndoableOperation op, int saveOptions, IProgressMonitor monitor) {

		IStatus status = null;
		switch (saveOptions)
		{
		case OPTION_FORCE_SAVE:
		case OPTION_SAVE_IF_UNSHARED:
			CompositeEMFOperation compositeOp = new CompositeEMFOperation(
					getTransactionalEditingDomain(), op.getLabel());

			IUndoableOperation saveOp = new SaveOperation((saveOptions & OPTION_FORCE_SAVE) != 0);
			compositeOp.add(op);
			compositeOp.add(saveOp);
			status = openScribbler().undo(compositeOp, monitor, this);
			break;
		case OPTION_DO_NOT_SAVE:
		default:
			status = openScribbler().undo(op, monitor, this);
		}

		return status;
	}

	/**
	 * Executes the given operation passing this ChangeScope as the IAdaptable arguments. Exactly
	 * equivalent to <code>execute(op, OPTION_DO_NOT_SAVE, monitor)</code>.
	 * 
	 * @param op
	 *           The operation to execute against the model managed by this ChangeScope. The
	 *           ChangeScope will pass itself as the {@link IAdaptable} argument of the
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method.
	 * 
	 * @param monitor
	 *           A progress monitor to provide feedback to the user about the current step of the
	 *           operation.
	 * @return The status returned from the operation after execution.
	 */
	public IStatus redo(IUndoableOperation op, IProgressMonitor monitor) {
		return redo(op, OPTION_DO_NOT_SAVE, monitor);
	}

	/**
	 * Executes the given operation passing this ChangeScope as the IAdaptable arguments.
	 * 
	 * @param op
	 *           The operation to execute against the model managed by this ChangeScope. The
	 *           ChangeScope will pass itself as the {@link IAdaptable} argument of the
	 *           {@link IUndoableOperation#execute(IProgressMonitor, IAdaptable)} method.
	 * @param saveOptions
	 *           Indicate whether the results of the operation should be persisted after execution
	 *           via {@link #OPTION_DO_NOT_SAVE}, {@link #OPTION_FORCE_SAVE},
	 *           {@link #OPTION_SAVE_IF_UNSHARED},
	 * @param monitor
	 *           A progress monitor to supply to the operation.
	 * @return The status returned from the operation after execution.
	 */
	public IStatus redo(IUndoableOperation op, int saveOptions, IProgressMonitor monitor) {

		IStatus status = null;
		switch (saveOptions)
		{
		case OPTION_FORCE_SAVE:
		case OPTION_SAVE_IF_UNSHARED:
			CompositeEMFOperation compositeOp = new CompositeEMFOperation(
					getTransactionalEditingDomain(), op.getLabel());

			IUndoableOperation saveOp = new SaveOperation((saveOptions & OPTION_FORCE_SAVE) != 0);
			compositeOp.add(op);
			compositeOp.add(saveOp);
			status = openScribbler().redo(compositeOp, monitor, this);
			break;
		case OPTION_DO_NOT_SAVE:
		default:
			status = openScribbler().redo(op, monitor, this);
		}

		return status;
	}

	public Object getAdapter(Class adapter) {
		if (adapter == CHANGE_SCOPE_CLASS) {
			return this;
		}
		if (adapter == TOPOLOGY_CLASS) {
			return openTopology();
		}
		if (adapter == IEDITMODEL_SCRIBBLER_CLASS) {
			return getScribbler();
		}
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	/**
	 * Save the changes that have been executed until this point.
	 * 
	 * @param force
	 *           True indicates that change a save should occur even if the underlying resource is
	 *           shared.
	 * @param monitor
	 *           A progress monitor to supply to the operation.
	 * @return The status from the save operation.
	 */
	public IStatus saveChanges(final boolean force, IProgressMonitor monitor) {
		if (readOnly) {
			return Status.OK_STATUS;
		}
		try {
			return new SaveOperation(force).execute(safeMonitor(monitor), null);
		} catch (ExecutionException e) {
			if (e.getCause() != null) {
				return DeployCorePlugin.createErrorStatus(0, e.getCause().getMessage(), e.getCause());
			}
			return DeployCorePlugin.createErrorStatus(0, e.getMessage(), e);
		}
	}

	/**
	 * Save the changes that have been executed until this point and close the scribbler.
	 * 
	 * @param force
	 *           True indicates that change a save should occur even if the underlying resource is
	 *           shared.
	 * @param monitor
	 *           A progress monitor to supply to the operation.
	 * @return The status from the save operation.
	 * @throws ExecutionException
	 *            If any problems are encountered during execution.
	 */
	public IStatus saveChangesAndClose(boolean force, IProgressMonitor monitor)
			throws ExecutionException {

		CompositeEMFOperation compositeOp = new CompositeEMFOperation(
				getTransactionalEditingDomain(), NLS.bind(
						DeployCoreMessages.ChangeScope_Release_referencees_to_shared_resou_,
						getTopologyFile()));

		compositeOp.add(new SaveOperation(force));
		compositeOp.add(new CloseOperation());

		try {
			return compositeOp.execute(safeMonitor(monitor), null);
		} catch (ExecutionException e) {
			if (e.getCause() != null) {
				return DeployCorePlugin.createErrorStatus(0, e.getCause().getMessage(), e.getCause());
			}
			return DeployCorePlugin.createErrorStatus(0, e.getMessage(), e);
		}
	}

	/**
	 * Save the changes that have been executed until this point.
	 * 
	 * @param monitor
	 *           A progress monitor to supply to the operation.
	 * @return The status from the save operation.
	 */
	public IStatus close(IProgressMonitor monitor) {
		try {
			if (topologyFile != null) {
				return new CloseOperation().execute(safeMonitor(monitor), this);
			}
		} catch (ExecutionException e) {
			if (e.getCause() != null) {
				return DeployCorePlugin.createErrorStatus(0, e.getCause().getMessage(), e.getCause());
			}
			return DeployCorePlugin.createErrorStatus(0, e.getMessage(), e);
		}
		return Status.OK_STATUS;

	}

	private IProgressMonitor safeMonitor(IProgressMonitor monitor) {
		return monitor != null ? monitor : new NullProgressMonitor();
	}

}
