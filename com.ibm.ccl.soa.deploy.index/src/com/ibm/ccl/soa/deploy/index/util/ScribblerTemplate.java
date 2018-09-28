package com.ibm.ccl.soa.deploy.index.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.index.internal.Messages;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.ITechnologyFlavorLifecycle;

public abstract class ScribblerTemplate {

	private final Map<String, IEditModelScribbler> scribblers = new HashMap<String, IEditModelScribbler>();

	public ScribblerTemplate() {
	}

	protected final IEditModelScribbler getScribbler(IFile aFile) throws CoreException {
		IEditModelScribbler scribbler = scribblers.get(aFile.getProject().getName());
		if (null == scribbler) {
			try {
				scribbler = IEditModelFactory.eINSTANCE.createScribblerForWrite(aFile.getProject(),
						new ScribblerDomain(aFile));
			} catch (EditModelException ex) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
						.getCause().getMessage(), ex.getCause()));
			}
			scribblers.put(aFile.getProject().getName(), scribbler);
		}

		return scribbler;
	}

	protected final Resource getResource(IFile aFile) throws CoreException {
		Resource resource = getScribbler(aFile).getResource(aFile);
		if (resource == null || resource.getContents().size() < 1) {
			throw new CoreException(
					new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS.bind(
							Messages.ScribblerTemplate_Cannot_read_EMF_resource_from_file_, aFile
									.getFullPath())));
		}

		IStatus status = diagnose(resource);
		if (getStatusWithHighestSeverity(status).getSeverity() > IStatus.WARNING) {
			throw new CoreException(getStatusWithHighestSeverity(status));
		}

		return resource;
	}

	protected final Topology getTopology(IFile aFile) throws CoreException {
		DeployCoreRoot root = (DeployCoreRoot) getResource(aFile).getContents().get(0);

		if (root == null) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS
					.bind(Messages.ScribblerTemplate_A_DeployCoreRoot_object_could_not_b_, aFile
							.getFullPath())));
		}

		Topology topology = root.getTopology();

		if (topology == null) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS
					.bind(Messages.ScribblerTemplate_A_Topology_EMF_object_was_not_found_, aFile
							.getFullPath())));
		}

		return topology;
	}

	protected final EObject getEObject(URI uri) throws CoreException {
		String platform = uri.toPlatformString(true);
		IPath path = new Path(platform);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource resource = getResource(file);
		return resource.getEObject(uri.fragment());
	}

	protected final Diagram getDiagram(IFile aFile) throws CoreException {

		Diagram diagram = null;
		EList<EObject> contents = getResource(aFile).getContents();
		for (Iterator<EObject> iter = contents.iterator(); iter.hasNext();) {
			EObject eObject = iter.next();
			if (NotationPackage.Literals.DIAGRAM.isSuperTypeOf(eObject.eClass())) {
				diagram = (Diagram) eObject;
			}
		}

		if (diagram == null) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, NLS
					.bind(Messages.ScribblerTemplate_A_Diagram_object_could_not_be_found_, aFile
							.getFullPath())));
		}

		return diagram;
	}

	private final TransactionalEditingDomain getEditingDomain(IResource resource) {
		IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE.getContext(resource
				.getProject());
		TransactionalEditingDomain txdomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(context.getResourceSet());

		if (txdomain == null) {
			txdomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(context
					.getResourceSet());
		}

		return txdomain;
	}

	private final IStatus diagnose(Resource resource) {
		Diagnostic diagnostic = EcoreUtil.computeDiagnostic(resource, true);
		return diagnose(diagnostic);
	}

	private final IStatus diagnose(Diagnostic diagnostic) {

		IStatus status = Status.OK_STATUS;

		if (diagnostic.getChildren().size() > 0) {
			status = new MultiStatus(diagnostic.getSource() != null ? diagnostic.getSource()
					: DeployCorePlugin.PLUGIN_ID, diagnostic.getCode(), diagnostic.getMessage(),
					diagnostic.getException());

			for (Iterator<Diagnostic> iter = diagnostic.getChildren().iterator(); iter.hasNext();) {
				((MultiStatus) status).add(diagnose(iter.next()));
			}
		} else {
			status = new Status(diagnostic.getSeverity(), diagnostic.getSource() != null ? diagnostic
					.getSource() : DeployCorePlugin.PLUGIN_ID, diagnostic.getCode(), diagnostic
					.getMessage(), diagnostic.getException());
		}

		return status;
	}

	private final IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}

	public final IUndoableOperation executeInTransaction(String title, final IProject project,
			IProgressMonitor monitor) throws CoreException {

		if (null == monitor) {
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask(title, 100);
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 100);
		subMonitor.beginTask(getClass().getSimpleName() + IConstants.DOT_SEPARATOR
				+ "runInTransaction", 100); //$NON-NLS-1$

		IUndoableOperation undo = null;

		try {

			TransactionalEditingDomain txdomain = getEditingDomain(project);
			EMFOperation operation = new EMFOperation(txdomain, title) {

				@Override
				protected IStatus run(IProgressMonitor monitor, IAdaptable info) throws Exception {

					IStatus status = ScribblerTemplate.this.inTransaction(monitor);
					if (status.getSeverity() > IStatus.WARNING) {
						throw new CoreException(status);
					}

					IEditModelScribbler scribbler = scribblers.get(project.getName());
					if (null != scribbler) {
						scribbler.save(true, monitor);
					}

					return Status.OK_STATUS;
				}
			};

			operation.execute(monitor, null);
			if (operation.canUndo()) {
				undo = operation;
			}
			subMonitor.worked(100);

		} catch (Exception ex) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
					.getMessage(), ex));
		} finally {
			try {
				IEditModelScribbler scribbler = scribblers.get(project.getName());
				if (null != scribbler) {
					scribbler.close(monitor);
				}
			} catch (EditModelException ex) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
						.getMessage(), ex));
			} finally {
				subMonitor.done();
				monitor.done();
			}
		}

		return undo;
	}

	public final Object executeInReadOnly(IProgressMonitor monitor) throws CoreException {

		if (null == monitor) {
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask(ScribblerTemplate.class.getSimpleName() + IConstants.DOT_SEPARATOR
				+ "executeReadOnly", 100); //$NON-NLS-1$

		try {
			return inReadOnly(monitor);
		} catch (Exception ex) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
					.getMessage(), ex));
		} finally {
			try {
				for (Iterator<Map.Entry<String, IEditModelScribbler>> iter = scribblers.entrySet()
						.iterator(); iter.hasNext();) {
					Map.Entry<String, IEditModelScribbler> entry = iter.next();
					IEditModelScribbler scribbler = entry.getValue();
					if (null != scribbler) {
						scribbler.close(monitor);
					}
				}
			} catch (EditModelException ex) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, ex
						.getMessage(), ex));
			} finally {
				monitor.done();
			}
		}
	}

	protected IStatus inTransaction(IProgressMonitor monitor) throws Exception {
		return Status.OK_STATUS;
	}

	protected Object inReadOnly(IProgressMonitor monitor) throws Exception {
		return null;
	}

	private static abstract class EMFOperation extends AbstractEMFOperation {

		private EMFOperation(TransactionalEditingDomain domain, String message) {
			super(domain, message);
		}

		@Override
		protected final IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			IStatus status = Status.OK_STATUS;
			try {
				status = run(monitor, info);
			} catch (Exception ex) {
				throw new ExecutionException(ex.getMessage(), ex);
			}

			return status;
		}

		protected abstract IStatus run(IProgressMonitor monitor, IAdaptable info) throws Exception;
	}

	private static class ScribblerDomain extends DefaultScribblerDomain {

		private final List<IFile> files;

		public ScribblerDomain(IFile file) {
			files = new ArrayList<IFile>();
			files.add(file);
		}

		public void addTechnologyFlavorLifecycle(ITechnologyFlavorLifecycle arg0) {
			// do nothing
		}

		public String getEditModelLabel() {
			return ScribblerTemplate.class.getName() + ".editmodel"; //$NON-NLS-1$
		}

		public IResourceDescriptor[] getResourceDescriptors() {
			return new IResourceDescriptor[0];
		}

		public ITechnologyFlavorLifecycle getTechnologyFlavorLifecycle(String arg0) {
			return null;
		}

		public ITechnologyFlavorLifecycle[] getTechnologyFlavorLifecycles() {
			return new ITechnologyFlavorLifecycle[0];
		}

		public boolean isContained(IResourceDescriptor arg0) {
			return false;
		}

		public boolean isContained(Resource aResource) {
			if (files.contains(aResource)) {
				return true;
			}
			return false;
		}

		public String getLabel() {
			return getEditModelLabel();
		}

		public boolean matches(IUndoContext context) {
			return false;
		}

	}
}
