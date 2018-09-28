package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.internal.navigator.resources.actions.ResourceMgmtActionProvider;

import com.ibm.ccl.soa.deploy.core.IConstants;

public class OverrideResourceEditActionsProvider extends ResourceMgmtActionProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager menu) {
		if (!selectionContainsTopologyArtifact()) {
			super.fillContextMenu(menu);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars actionBars) {
		if (!selectionContainsTopologyArtifact()) {
			super.fillActionBars(actionBars);
		}
	}

	private boolean selectionContainsTopologyArtifact() {
		ActionContext context = super.getContext();
		IStructuredSelection selection = (IStructuredSelection) context.getSelection();
		for (Iterator iter = selection.iterator(); iter.hasNext();) {
			if (isTopologyArtifact(iter.next())) {
				return true;
			}
		}

		return false;
	}

	private boolean isTopologyArtifact(Object object) {

		IFile file = (IFile) Platform.getAdapterManager().getAdapter(object, IFile.class);
		if (null != file) {
			if (IConstants.TOPOLOGY_EXTENSION.equalsIgnoreCase(file.getFileExtension())
					|| IConstants.TOPOLOGYV_EXTENSION.equalsIgnoreCase(file.getFileExtension())) {
				return true;
			}
		}

		return false;
	}

}
