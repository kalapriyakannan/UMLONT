package com.ibm.ccl.soa.deploy.uml.ui.internal.search.handlers;

import java.util.Arrays;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers.AbstractSelectInViewHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers.SelectInDiagramHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;
import com.ibm.ccl.soa.deploy.uml.ui.Activator;
import com.ibm.ccl.soa.deploy.uml.ui.internal.search.Messages;
import com.ibm.xtools.uml.navigator.util.UMLNavigatorUtil;

public class UMLSelectInModelExplorerHandler extends AbstractSelectInViewHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {

			Match match = (Match) getSelection(event);
			EObject eObject = match.getReferencerEObject(true, true, false);

			if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
				return new SelectInDiagramHandler().execute(event);
			}

			UMLNavigatorUtil.navigateToModelerNavigator(Arrays.asList(new Object[] { eObject }));

		} catch (CoreException ex) {
			Activator.logError(0, ex.getMessage(), ex);
			ErrorDialog.openError(window.getShell(),
					Messages.UMLSelectInModelExplorerHandler_Error_Occurre_, ex.getMessage(),
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex));
		}

		return null;
	}

}
