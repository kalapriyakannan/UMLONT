package com.ibm.ccl.soa.deploy.ide.ui.refactoring.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.resource.RenameResourceWizard;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceProcessor;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceRefactoringDescriptor;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards.RenameNamespaceWizard;

public class RenameTopologyNamespaceRefactoringHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			if (elements.length == 1 && elements[0] instanceof INamespaceFragment) {
				INamespaceFragment fragment = (INamespaceFragment) elements[0];
				if (fragment.getType() == INamespaceElement.TOPOLOGY_NAMESPACE_ROOT) {
					IResource resource = fragment.getRoot().getCorrespondingResource(fragment);
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
				} else if (fragment.getType() == INamespaceElement.TOPOLOGY_NAMESPACE) {
					RenameNamespaceRefactoringDescriptor dataModel = RenameNamespaceRefactoringDescriptor
							.createModel();
					IResource rootContainer = fragment.getRoot().getCorrespondingResource();
					dataModel.setSourcePath(rootContainer.getFullPath().toString());
					dataModel.setPreviousNamespacePath(fragment.getQualifiedName());
					dataModel.setNewNamespacePath(fragment.getQualifiedName());

					RenameNamespaceProcessor processor = new RenameNamespaceProcessor(dataModel);
					RenameRefactoring refactoring = new RenameRefactoring(processor);

					RenameNamespaceWizard refactoringWizard = new RenameNamespaceWizard(refactoring,
							Messages.RenameNamespaceWizardPage1_Rename_Namespac_);
					RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
							refactoringWizard);

					try {
						op.run(HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell(),
								Messages.RenameNamespaceWizardPage1_Rename_Namespac_);
					} catch (InterruptedException ex) {
						// do nothing
					}
				}
			}
		}
		return null;
	}

}
