/***************************************************************************************************
 * Copyright (c) 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.refactoring.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.MoveRefactoring;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IMoveUnitsModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsProcessor;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor;

/**
 * 
 * This data model is used to refactor units from one topology model to another. It allows for the
 * use of an existing topology file as the destination as well as the ability to create a new
 * topology model by nesting the CreatTopologyDataModel.
 * 
 * <p>
 * Clients should use {@link MoveUnitsRefactoringDescriptor#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class MoveUnitsOperation extends AbstractDataModelOperation implements
		IMoveUnitsModelProperties {

	private MoveUnitsRefactoringDescriptor typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveUnitsOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new MoveUnitsRefactoringDescriptor(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public MoveUnitsOperation(MoveUnitsRefactoringDescriptor tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.operations.IUndoableOperation#execute(IProgressMonitor,
	 *      IAdaptable)
	 */
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		monitor.beginTask(Messages.MoveUnitsProcessor_Move_Unit_, 1);
		MultiStatus status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new String(), null);

		MoveUnitsProcessor processor = new MoveUnitsProcessor(typesafeModel);
		MoveRefactoring refactoring = new MoveRefactoring(processor);
		CheckConditionsOperation conditional = new CheckConditionsOperation(refactoring,
				CheckConditionsOperation.FINAL_CONDITIONS);
		CreateChangeOperation change = new CreateChangeOperation(conditional, RefactoringStatus.FATAL);
		PerformChangeOperation operation = new PerformChangeOperation(change);

		try {

			operation.run(monitor);

		} catch (CoreException ex) {
			throw new ExecutionException(ex.toString(), ex);
		} finally {

			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}

			monitor.done();
		}

		if (operation.getConditionCheckingStatus() != null
				&& !operation.getConditionCheckingStatus().isOK()) {
			RefactoringStatusEntry entry = operation.getConditionCheckingStatus()
					.getEntryWithHighestSeverity();
			if (entry.getSeverity() == RefactoringStatus.FATAL) {
				status.add(new Status(entry.getSeverity(), entry.getPluginId() != null
						&& entry.getPluginId().trim().equals(new String()) ? entry.getPluginId()
						: IDEPlugin.PLUGIN_ID, entry.getMessage()));
			}
		}

		if (operation.getValidationStatus() != null && !operation.getValidationStatus().isOK()) {
			RefactoringStatusEntry entry = operation.getValidationStatus()
					.getEntryWithHighestSeverity();
			if (entry.getSeverity() == RefactoringStatus.FATAL) {
				status.add(new Status(entry.getSeverity(), entry.getPluginId() != null
						&& entry.getPluginId().trim().equals(new String()) ? entry.getPluginId()
						: IDEPlugin.PLUGIN_ID, entry.getMessage()));
			}
		}

		return status;
	}

	/**
	 * This operation can accept a typesafe model that provides a more usable interface to the
	 * {@link org.eclipse.wst.common.frameworks.datamodel.IDataModel}.
	 * 
	 * @param mdl
	 *           The typesafe model that will drive this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	private void setTypeSafeModel(MoveUnitsRefactoringDescriptor mdl) {
		typesafeModel = mdl;
	}
}
