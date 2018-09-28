/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.synchronization;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Constructs a {@link Change} object to carry out the default operation specified by the provided
 * datamodel. If the default operation is undoable ({@link IUndoableOperation#canUndo()}), then
 * the undoable version of the DatamodelDrivenChange will be returned from
 * {@link #perform(IProgressMonitor)}.
 * 
 * @since 1.0
 * 
 */
public class DatamodelDrivenChange extends Change {

	private IDataModel datamodel;
	private String name;
	private Object element;
	private boolean undo;

	/**
	 * Create a datamodel driven change with the given externalized label (name), on a particular
	 * target (element) using the specified arguments (datamodel).
	 * 
	 * @param name
	 *           An translated label to display to the user to describe this change
	 * @param element
	 *           The element undergoing some change
	 * @param datamodel
	 *           The set of arguments driven by the user to use when carrying out the given change.
	 */
	public DatamodelDrivenChange(String name, Object element, IDataModel datamodel) {

		this.name = name;
		this.element = element;
		this.datamodel = datamodel;
		this.undo = false;
	}

	private DatamodelDrivenChange(String name, Object element, IDataModel datamodel, boolean undo) {

		this.name = name;
		this.element = element;
		this.datamodel = datamodel;
		this.undo = undo;
	}

	public Object getModifiedElement() {
		return element;
	}

	public String getName() {
		return name;
	}

	public void initializeValidationData(IProgressMonitor pm) {

	}

	public RefactoringStatus isValid(IProgressMonitor pm) throws OperationCanceledException {

		/*
		 * Datamodels assume the workspace is in a proper state to continue, and in some cases, the
		 * worksapce will not be in the correct state until the changes before this change have been
		 * executed; isValid() is called for all changes *before* any change is actually executed.
		 * Therefore some datamodels will reject the change.
		 * 
		 * So, for now, we will not validate the datamodel at this stage.
		 */
		//return RefactoringStatus.create(datamodel.validate());
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	public Change perform(IProgressMonitor monitor) throws CoreException {

		IDataModelOperation operation = datamodel.getDefaultOperation();

		if (undo && operation.canUndo()) {
			try {
				operation.undo(monitor, null);
			} catch (ExecutionException e) {
				throw new CoreException(DeployCorePlugin.createErrorStatus(0, e.getMessage(), e));
			}
			String newName = name.startsWith(DeployCoreMessages.DatamodelDrivenChange_Red_) ? name
					: NLS.bind(DeployCoreMessages.DatamodelDrivenChange_Redo_0_, name);
			return new DatamodelDrivenChange(newName, element, datamodel, false);
		}

		try {
			operation.execute(monitor, null);
		} catch (ExecutionException e) {
			throw new CoreException(DeployCorePlugin.createErrorStatus(0, e.getMessage(), e));
		}

		if (operation.canUndo()) {
			String newName = name.startsWith(DeployCoreMessages.DatamodelDrivenChange_Und_) ? name
					: NLS.bind(DeployCoreMessages.DatamodelDrivenChange_Undo_0_, name);
			return new DatamodelDrivenChange(newName, element, datamodel, false);
		}
		return null;
	}

	protected final IDataModel getDatamodel() {
		return datamodel;
	}

}
