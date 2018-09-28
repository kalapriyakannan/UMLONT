package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.CreateChangeOperation;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.MoveRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.MoveResourcesProcessor;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.internal.navigator.resources.plugin.WorkbenchNavigatorMessages;
import org.eclipse.ui.internal.navigator.resources.plugin.WorkbenchNavigatorPlugin;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

public class TopologyDropAdapterAssistant extends CommonDropAdapterAssistant {

	private static final boolean DEBUG = false;
	private static final IResource[] NO_RESOURCES = new IResource[0];

	private MoveResourcesProcessor processor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.CommonDropAdapterAssistant#validateDrop(java.lang.Object, int,
	 *      org.eclipse.swt.dnd.TransferData)
	 */
	public IStatus validateDrop(Object target, int aDropOperation, TransferData transferType) {

		if (!(target instanceof INamespaceElement)) {
			return WorkbenchNavigatorPlugin.createStatus(IStatus.INFO, 0,
					"target must be a namespace", null); //$NON-NLS-1$
		}

		IResource resource = (IResource) Platform.getAdapterManager().getAdapter(target,
				IResource.class);
		IContainer destination = getActualTarget(resource);

		IStatus status = null;

		INamespaceFragmentRoot root = NamespaceCore.getRoot(destination);
		if (null == root) {
			openError(status = new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
					"Cannot move topology to a non-namespace folder.")); //$NON-NLS-1$
			return status;
		}

		IResource[] selections = getSelectedResources();
		for (int r = 0; r < selections.length; r++) {
			IResource selection = selections[r];
			if (selection.getType() != IResource.FILE) {
				openError(status = new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
						"Cannot move namespaces with drag and drop.")); //$NON-NLS-1$
				return status;
			}

			IFile aFile = (IFile) selection;
			if (!IConstants.TOPOLOGY_EXTENSION.equals(aFile.getFileExtension())) {
				openError(status = new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
						"Cannot move file types other than *.topology using drag and drop.")); //$NON-NLS-1$
				return status;
			}
		}

		MoveResourcesProcessor processor = new MoveResourcesProcessor(getSelectedResources());
		processor.setDestination(getActualTarget(resource));

		MoveRefactoring refactoring = new MoveRefactoring(processor);
		CheckConditionsOperation condition = new CheckConditionsOperation(refactoring,
				CheckConditionsOperation.FINAL_CONDITIONS);

		try {
			condition.run(new NullProgressMonitor());

			RefactoringStatus refactorStatus = condition.getStatus();
			if (!refactorStatus.isOK()) {
				RefactoringStatusEntry entry = refactorStatus.getEntryWithHighestSeverity();
				status = new Status(entry.isError() || entry.isFatalError() ? IStatus.ERROR : entry
						.isWarning() ? IStatus.WARNING : IStatus.INFO, entry.getPluginId(), entry
						.getMessage());
			}
		} catch (CoreException ex) {
			status = new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex);
		}

		openError(status);
		return status == null ? Status.OK_STATUS : status;
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter dropAdapter, DropTargetEvent dropTargetEvent,
			Object target) {

		IResource resource = (IResource) Platform.getAdapterManager().getAdapter(target,
				IResource.class);

		MoveResourcesProcessor processor = new MoveResourcesProcessor(getSelectedResources());
		processor.setDestination(getActualTarget(resource));

		MoveRefactoring refactoring = new MoveRefactoring(processor);
		CheckConditionsOperation condition = new CheckConditionsOperation(refactoring,
				CheckConditionsOperation.FINAL_CONDITIONS);
		CreateChangeOperation change = new CreateChangeOperation(condition, RefactoringStatus.FATAL);
		PerformChangeOperation operation = new PerformChangeOperation(change);

		IStatus status = null;

		try {
			condition.run(new NullProgressMonitor());
			RefactoringStatus refactorStatus = condition.getStatus();
			if (!refactorStatus.isOK()) {
				RefactoringStatusEntry entry = refactorStatus.getEntryWithHighestSeverity();
				status = new Status(entry.getSeverity() - 1, entry.getPluginId(), entry.getMessage());
			} else {
				operation.run(new NullProgressMonitor());

				if (operation.changeExecuted() && operation.getValidationStatus().isOK()) {
					status = Status.OK_STATUS;
				} else if (operation.changeExecutionFailed() && operation.getValidationStatus() != null) {
					RefactoringStatusEntry entry = operation.getValidationStatus()
							.getEntryWithHighestSeverity();
					status = new Status(entry.getSeverity(), entry.getPluginId(), entry.getMessage());
				} else {
					RefactoringStatusEntry entry = operation.getConditionCheckingStatus()
							.getEntryWithHighestSeverity();
					status = new Status(entry.getSeverity(), entry.getPluginId(), entry.getMessage());
				}
			}

		} catch (CoreException ex) {
			status = new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex);
		}

		openError(status);

		return status == null ? Status.OK_STATUS : status;
	}

	/**
	 * Returns the actual target of the drop, given the resource under the mouse. If the mouse target
	 * is a file, then the drop actually occurs in its parent. If the drop location is before or
	 * after the mouse target and feedback is enabled, the target is also the parent.
	 */
	private IContainer getActualTarget(IResource mouseTarget) {

		/* if cursor is on a file, return the parent */
		if (mouseTarget.getType() == IResource.FILE) {
			return mouseTarget.getParent();
		}
		/* otherwise the mouseTarget is the real target */
		return (IContainer) mouseTarget;
	}

	/**
	 * Returns the resource selection from the LocalSelectionTransfer.
	 * 
	 * @return the resource selection from the LocalSelectionTransfer
	 */
	private IResource[] getSelectedResources() {

		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection instanceof IStructuredSelection) {
			return getSelectedResources((IStructuredSelection) selection);
		}
		return NO_RESOURCES;
	}

	/**
	 * Returns the resource selection from the LocalSelectionTransfer.
	 * 
	 * @return the resource selection from the LocalSelectionTransfer
	 */
	private IResource[] getSelectedResources(IStructuredSelection selection) {
		ArrayList selectedResources = new ArrayList();

		for (Iterator i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof IResource) {
				selectedResources.add(o);
			} else if (o instanceof IAdaptable) {
				IAdaptable a = (IAdaptable) o;
				IResource r = (IResource) a.getAdapter(IResource.class);
				if (r != null) {
					selectedResources.add(r);
				}
			}
		}
		return (IResource[]) selectedResources.toArray(new IResource[selectedResources.size()]);
	}

	/**
	 * Opens an error dialog if necessary. Takes care of complex rules necessary for making the error
	 * dialog look nice.
	 */
	private void openError(IStatus status) {
		if (status == null) {
			return;
		}

		String genericTitle = WorkbenchNavigatorMessages.DropAdapter_title;
		int codes = IStatus.ERROR | IStatus.WARNING;

		// simple case: one error, not a multistatus
		if (!status.isMultiStatus()) {
			ErrorDialog.openError(getShell(), genericTitle, null, status, codes);
			return;
		}

		// one error, single child of multistatus
		IStatus[] children = status.getChildren();
		if (children.length == 1) {
			ErrorDialog.openError(getShell(), status.getMessage(), null, children[0], codes);
			return;
		}
		// several problems
		ErrorDialog.openError(getShell(), genericTitle, null, status, codes);
	}
}
