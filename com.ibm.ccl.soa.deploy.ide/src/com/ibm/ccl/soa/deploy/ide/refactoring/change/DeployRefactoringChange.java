/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.change.IRefactoringDataModelChangeProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.ChangeScribblerDomain;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.datamodels.ScribblerDefinitionDatamodel;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

public abstract class DeployRefactoringChange extends Change {

	private RefactoringChangeDescriptor descriptor;
	private IUndoableOperation operation;
	private Operation action = Operation.EXECUTE;
	private final IDataModel model;
	private ScribblerDefinitionDatamodel scribblerDefinition;

	private static enum Operation {
		EXECUTE, UNDO, REDO
	};

	/**
	 * Create a type-safe facade for the given datamodel.
	 * 
	 * @param mdl
	 *           The datamodel to provide a facade for.
	 * @generated (mde.utilities.datamodels)
	 */
	public DeployRefactoringChange(IDataModel mdl) {
		model = mdl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getDescriptor()
	 */
	@Override
	public ChangeDescriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(RefactoringChangeDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#getScribblerDefinition()
	 */
	public ScribblerDefinitionDatamodel getScribblerDefinition() {
		if (scribblerDefinition == null) {
			if (model.isNestedModel(IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION)) {
				IDataModel nestedModel = model
						.getNestedModel(IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION);
				scribblerDefinition = new ScribblerDefinitionDatamodel(nestedModel);
			} else {
				scribblerDefinition = ScribblerDefinitionDatamodel.createModel();
				model.addNestedModel(IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION,
						scribblerDefinition.getUnderlyingDataModel());
			}
		}
		return scribblerDefinition;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#validateScribblerDefinition()
	 */
	public IStatus validateScribblerDefinition() {
		return getScribblerDefinition().validate();

	}

	/**
	 * Determine the default value of the ScribblerDefinition property.
	 * 
	 * @return The default value of the ScribblerDefinition property.
	 * @see #getScribblerDefinition()
	 * 
	 * @generated (mde.utilities.datamodels)
	 */
	protected ScribblerDefinitionDatamodel getDefaultScribblerDefinition() {
		return (ScribblerDefinitionDatamodel) model
				.getDefaultProperty(IRefactoringDataModelChangeProperties.SCRIBBLER_DEFINITION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#getUnderlyingDataModel()
	 */
	public IDataModel getUnderlyingDataModel() {
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#createConfiguredOperation()
	 */
	public abstract IUndoableOperation createConfiguredOperation();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#validate()
	 */
	public IStatus validate() {
		return model.validate(false);
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		initializeScribblerDomain();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#getConfiguredOperation()
	 */
	public IUndoableOperation getConfiguredOperation() {
		if (null == operation) {
			operation = createConfiguredOperation();
		}
		return operation;
	}

	void initializeScribblerDomain() {

		if (!model.isPropertySet(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL)) {

			ScribblerDefinitionDatamodel scribblerDefinitionModel = getScribblerDefinition();
			List<IResource> resources = new ArrayList<IResource>();
			if (null != getModifiedElement()) {
				IResource resource = (IResource) adapt(getModifiedElement(), IResource.class);
				if (null != resource) {
					resources.add(resource);
				}
			}

			for (int i = 0; i < getAffectedObjects().length; i++) {
				IResource resource = (IResource) adapt(getAffectedObjects()[i], IResource.class);
				if (null != resource && !resources.contains(resource)) {
					resources.add(resource);
				}
			}

			if (resources.size() > 0) {

				ChangeScribblerDomain domain = new ChangeScribblerDomain(resources);
				model.setProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL, domain
						.getEditModelLabel());
				model.setProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME, resources.get(0)
						.getProject().getName());
				model.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
						new IScribblerDomain[] { domain });

				scribblerDefinitionModel.setEditModelLabel(domain.getEditModelLabel());
				scribblerDefinitionModel.setProjectName(resources.get(0).getProject().getName());
				scribblerDefinitionModel.setScribblerDomains(Arrays
						.asList(new IScribblerDomain[] { domain }));
			}
		}
	}

	private static Object adapt(Object adaptable, Class adapter) {
		Object adapted = null;
		if (adaptable instanceof IAdaptable) {
			adapted = ((IAdaptable) adaptable).getAdapter(adapter);
		}
		if (null == adapted) {
			adapted = Platform.getAdapterManager().getAdapter(adaptable, adapter);
		}
		return adapted;
	}

	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { getModifiedElement() };
	}

	private List<IResource> getAffectedResources() {
		// adapt the array of affected objects to instances of IResource
		Object[] affected = getAffectedObjects();
		final List<IResource> resources = new ArrayList<IResource>(affected.length + 2);
		for (int i = 0; i < affected.length; i++) {
			IResource resource = (IResource) adapt(affected[i], IResource.class);
			if (!resources.contains(resource)) {
				resources.add(resource);

				// add all associated diagram files of this resource ( if it's a model file )
				// since any change and subsequent save of the topology model will result in
				// a save of all of it's associated diagram files
				if (resource.getType() == IResource.FILE) {
					IFile file = (IFile) resource;
					if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
						List<IFile> diagrams = new ArrayList<IFile>(RefactoringUtils
								.getAssociatedDiagramFiles(file));
						for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {
							IFile diagram = iter.next();
							if (!resources.contains(diagram)) {
								resources.add(diagram);
							}
						}
					}
				}
			}
		}

		return resources;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#isValid(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		RefactoringStatus status = RefactoringStatus.create(validate());
		List<IResource> resources = getAffectedResources();
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			IResource resource = iter.next();
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (RefactoringUtils.isDirty(file)) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.FATAL, NLS.bind(
							Messages.DeployRefactoringChange_The_affected_resource_0_conta_, file
									.getFullPath())));
				}
			}
		}

		return status;
	}

	@Override
	public Change perform(IProgressMonitor monitor) throws CoreException {

		try {

			getConfiguredOperation();

			IStatus status = Status.OK_STATUS;
			if (action == Operation.REDO) {
				action = Operation.UNDO;
				status = operation.redo(monitor, null);
			} else if (action == Operation.UNDO) {
				action = Operation.REDO;
				status = operation.undo(monitor, null);
			} else {
				action = Operation.UNDO;
				operation.execute(monitor, null);
			}

			if (!status.isOK()) {
				IStatus highestSeverity = getStatusWithHighestSeverity(status);
				Throwable cause = highestSeverity.getException();
				String message = cause != null ? cause.toString() : highestSeverity.getMessage();
				throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0, message,
						cause));
			}

		} catch (ExecutionException ex) {
			throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, ex.toString(), ex));
		}

		return this;
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (IUndoableOperation.class.isAssignableFrom(adapter)) {
			return getConfiguredOperation();
		}

		return super.getAdapter(adapter);
	}

	private IStatus getStatusWithHighestSeverity(IStatus status) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.refactoring.change.DeployRefactoringChangeDescriptor#dispose()
	 */
	@Override
	public void dispose() {
		SafeRunner.run(new ISafeRunnable() {
			@SuppressWarnings("restriction")
			public void run() throws Exception {
				if (model != null) {
					model.dispose();
				}
			}

			public void handleException(Throwable ex) {
				IDEPlugin.logError(0, ex.toString(), ex);
			}
		});
	}

}
