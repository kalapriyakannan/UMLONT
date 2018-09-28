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
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IRenameNamespaceModelProperties;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceProcessor;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceRefactoringDescriptor;

public class RenameNamespaceOperation extends AbstractDataModelOperation implements
		IRenameNamespaceModelProperties {

	private RenameNamespaceRefactoringDescriptor typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameNamespaceOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new RenameNamespaceRefactoringDescriptor(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameNamespaceOperation(RenameNamespaceRefactoringDescriptor tsMdl) {
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

		monitor.beginTask(Messages.RenameNamespaceProcessor_Rename_Namespac_, 1);
		MultiStatus status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new String(), null);

		RenameNamespaceProcessor processor = new RenameNamespaceProcessor(typesafeModel);
		RenameRefactoring refactoring = new RenameRefactoring(processor);
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
	private void setTypeSafeModel(RenameNamespaceRefactoringDescriptor mdl) {
		typesafeModel = mdl;
	}

}
