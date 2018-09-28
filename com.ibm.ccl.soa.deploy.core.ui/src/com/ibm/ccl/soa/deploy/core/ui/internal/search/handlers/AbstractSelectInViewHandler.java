package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;

public abstract class AbstractSelectInViewHandler extends AbstractHandler implements IHandler {

	protected Object getSelection(ExecutionEvent event) throws CoreException, ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		Object object = selection;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			if (elements.length == 0 && elements.length > 1) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
						Messages.AbstractSelectInViewHandler_Cannot_view_more_than_one_selection_, null));
			}
			object = elements[0];
		}

		if (!(object instanceof Match)) {
			throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
					Messages.SelectInViewHandler_Selection_was_not_an_instance_of_Ma_, null));
		}

		return object;
	}

}
