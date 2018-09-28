package com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.participant.IRenameDiagramModelProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameDiagramDescriptor;

/**
 * 
 * 
 * 
 * <p>
 * Clients should use {@link RenameDiagramDescriptor#createConfiguredOperation()} to create an
 * instance of this operation, configured with the necessary model properties.
 * </p>
 * 
 * @see org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelOperation
 * @see com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameDiagramDescriptor
 * @generated (mde.utilities.datamodels)
 */
public class RenameDiagramOperation extends AbstractDataModelOperation implements
		IRenameDiagramModelProperties {

	private RenameDiagramDescriptor typesafeModel;

	/**
	 * Construct an operation pre-configured with the given data model.
	 * 
	 * @param dMdl
	 *           The datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameDiagramOperation(IDataModel dMdl) {
		super(dMdl);
		setTypeSafeModel(new RenameDiagramDescriptor(dMdl));
	}

	/**
	 * Construct an operation pre-configured with the given type-safe data model.
	 * 
	 * @param tsMdl
	 *           The type-safe datamodel to use when executing this operation.
	 * @generated (mde.utilities.datamodels)
	 */
	public RenameDiagramOperation(RenameDiagramDescriptor tsMdl) {
		super(tsMdl.getUnderlyingDataModel());
		setTypeSafeModel(tsMdl);
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		monitor.beginTask(Messages.RenameTopologyRefactoringDataModelOperation_Rename_Topolog_, 1);
		MultiStatus status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new String(), null);

		IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(typesafeModel.getDiagram()));
		RenameResourceProcessor processor = new RenameResourceProcessor(diagramFile);
		processor.setNewResourceName(new Path(typesafeModel.getName()).lastSegment());
//		RenameTopologyParticipant processor = new RenameTopologyParticipant(typesafeModel);
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
						: DeployCorePlugin.PLUGIN_ID, entry.getMessage()));
			}
		}

		if (operation.getValidationStatus() != null && !operation.getValidationStatus().isOK()) {
			RefactoringStatusEntry entry = operation.getValidationStatus()
					.getEntryWithHighestSeverity();
			if (entry.getSeverity() == RefactoringStatus.FATAL) {
				status.add(new Status(entry.getSeverity(), entry.getPluginId() != null
						&& entry.getPluginId().trim().equals(new String()) ? entry.getPluginId()
						: DeployCorePlugin.PLUGIN_ID, entry.getMessage()));
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
	private void setTypeSafeModel(RenameDiagramDescriptor mdl) {
		typesafeModel = mdl;
	}

}
