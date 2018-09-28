package com.ibm.ccl.soa.deploy.ide.ui.refactoring.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

public class RenameTopologyRefactoringHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			if (elements.length == 1 && elements[0] instanceof IFile) {
				IFile topology = (IFile) elements[0];
				if (topology != null && window != null) {
//					RenameTopologyParticipant processor = new RenameTopologyParticipant(topology);
//					RenameRefactoring refactoring = new RenameRefactoring(processor);
//					run(new RenameTopologyWizard(refactoring,
//							Messages.RenameTopologyAction_Rename_Topolog_), window.getShell(),
//							Messages.RenameTopologyAction_Rename_Topolog_);
				}
			}
		}

		return null;
	}

	public void run(RefactoringWizard wizard, Shell parent, String dialogTitle) {
		try {
			RefactoringWizardOpenOperation operation = new RefactoringWizardOpenOperation(wizard);
			operation.run(parent, dialogTitle);
		} catch (InterruptedException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
		}
	}
}
