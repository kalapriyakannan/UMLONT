package com.ibm.ccl.soa.deploy.ide.ui.refactoring.handlers;

import java.util.ArrayList;

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

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

public class MoveTopologyRefactoringHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		ArrayList<IFile> topologies = new ArrayList<IFile>();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			for (int i = 0; i < elements.length; i++) {
				Object object = elements[i];
				if (object instanceof IFile) {
					IFile file = (IFile) object;
					if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
						topologies.add(file);
					}
				} else {
					// we found something else
					return null;
				}
			}
		}

		if (topologies.size() > 0 && window != null) {
//			MoveTopologyParticipant processor = new MoveTopologyParticipant(topologies, null);
//			MoveRefactoring refactoring = new MoveRefactoring(processor);
//			run(new MoveTopologiesWizard(refactoring, Messages.MoveTopologyRefactoringHandler_Mov_),
//					window.getShell(), Messages.MoveTopologyRefactoringHandler_Mov_);
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
