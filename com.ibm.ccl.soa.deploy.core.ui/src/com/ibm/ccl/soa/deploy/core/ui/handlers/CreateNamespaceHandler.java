package com.ibm.ccl.soa.deploy.core.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.NewNamespaceDialog;

public class CreateNamespaceHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			if (extended.size() > 1 || extended.size() == 0) {
				return null;
			}

			Object selected = extended.getFirstElement();
			if (null != selected && selected instanceof INamespaceElement) {
				NewNamespaceDialog dialog = new NewNamespaceDialog(HandlerUtil
						.getActiveShellChecked(event), extended);
				dialog.create();
				dialog.open();
			}
		}
		return null;
	}

}
