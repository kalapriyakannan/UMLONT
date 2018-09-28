package com.ibm.ccl.soa.deploy.ide.ui.refactoring.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.participants.MoveRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsProcessor;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards.MoveUnitsWizard;

public class MoveUnitsRefactoringHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		ArrayList<Unit> units = new ArrayList<Unit>();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			for (int i = 0; i < elements.length; i++) {
				Object adapted = Platform.getAdapterManager().getAdapter(elements[i], Unit.class);
				if (null == adapted) {
					// we found something other than a unit
					return null;
				}

				if (!(adapted instanceof EObject)) {
					// we found something other than a unit
					displayWarning(
							"Selection contains a non-emf based type that cannot be refactored", window.getShell()); //$NON-NLS-1$
					IDEPlugin
							.log(IStatus.WARNING, 0,
									"Selection contains a non-emf based type that cannot be refactored", //$NON-NLS-1$
									new ExecutionException(
											"Selection contained a non-emf based type: " + adapted)); //$NON-NLS-1$
					return null;
				}

				EObject eObject = (EObject) adapted;
				if (!CorePackage.eINSTANCE.getUnit().isSuperTypeOf(eObject.eClass())) {
					// we found something other than a unit
					displayWarning(
							"Selection contains a non-unit type that cannot be refactored", window.getShell()); //$NON-NLS-1$
					IDEPlugin
							.log(IStatus.WARNING, 0,
									"Selection contains a non-unit based type that cannot be refactored", //$NON-NLS-1$
									new ExecutionException(
											"Selection contained a non-unit based type: " + adapted)); //$NON-NLS-1$
					return null;
				}

				Unit unit = (Unit) eObject;
				if (!unit.getTopology().equals(unit.getEditTopology())) {
					// this is a proxyied reference to a unit in another topology
					displayWarning(
							"Cannot refactor the imported unit " + unit.getDisplayName(), window.getShell()); //$NON-NLS-1$
					IDEPlugin
					.log(IStatus.WARNING, 0,
							"Selection contains an imported unit that cannot be refactored", //$NON-NLS-1$
							new ExecutionException(
									"Selection contained an imported unit: " + adapted)); //$NON-NLS-1$
					return null;
				}

				units.add((Unit) eObject);
			}

			if (units.size() > 0 && window != null) {
				MoveUnitsProcessor processor = new MoveUnitsProcessor(units);
				MoveRefactoring refactoring = new MoveRefactoring(processor);
				run(new MoveUnitsWizard(refactoring, Messages.MoveTopologyRefactoringHandler_Mov_),
						window.getShell(), Messages.MoveTopologyRefactoringHandler_Mov_);
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

	private void displayWarning(String message, Shell shell) {
		MessageDialog.openWarning(shell, "Warning...", message); //$NON-NLS-1$
	}

}
