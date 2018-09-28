package com.ibm.ccl.soa.deploy.ide.ui.refactoring.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.resource.RenameResourceWizard;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;

public class RenameTopologyDiagramNodeRefactoringHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			if (elements.length == 1 && elements[0] instanceof TopologyDiagramNode) {
				TopologyDiagramNode node = (TopologyDiagramNode) elements[0];
				IResource resource = node.getDiagramFile();
				if (resource != null) {
					RenameResourceWizard refactoringWizard = new RenameResourceWizard(resource);
					RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
							refactoringWizard);
					try {
						op.run(HandlerUtil.getActiveShell(event),
								RefactoringUIMessages.RenameResourceHandler_title);
					} catch (InterruptedException e) {
						// do nothing
					}
				}
			}
		}
		return null;
	}

}
