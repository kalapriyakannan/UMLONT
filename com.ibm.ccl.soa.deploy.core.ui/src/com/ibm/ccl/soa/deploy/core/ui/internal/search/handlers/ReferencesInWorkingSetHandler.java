package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import java.util.HashSet;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;

public class ReferencesInWorkingSetHandler extends AbstractReferencesHandler {

	@Override
	protected Scope getSearchScope(ExecutionEvent event) throws CoreException, ExecutionException {

		Shell shell = HandlerUtil.getActiveShellChecked(event);

		IWorkingSetSelectionDialog dialog = PlatformUI.getWorkbench().getWorkingSetManager()
				.createWorkingSetSelectionDialog(shell, true);
		if (dialog.open() == Window.OK) {
			IWorkingSet[] workingSets = dialog.getSelection();
			if (workingSets.length == 0) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
						Messages.ReferencesInWorkingSetHandler_No_working_sets_were_choosen_, null));
			}
			HashSet<IResource> list = new HashSet<IResource>(2);
			for (int i = 0; i < workingSets.length; i++) {
				IAdaptable[] elements = workingSets[i].getElements();
				for (int j = 0; j < elements.length; j++) {
					IResource resource = (IResource) elements[j].getAdapter(IResource.class);
					if (resource != null) {
						list.add(resource);
					}
				}
			}

			if (list.size() == 0) {
				throw new CoreException(
						new Status(
								IStatus.ERROR,
								DeployCoreUIPlugin.PLUGIN_ID,
								Messages.ReferencesInWorkingSetHandler_No_searchable_resources_were_contai_,
								null));
			}

			return Scope.getResourcesScope(list, true, false);
		}

		return null;
	}

}
