package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.DeleteResourceAction;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;

import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;

public class DeleteTopologyDiagramNodeActionGroup extends ActionGroup implements
		ISelectionChangedListener {
	private IStructuredSelection selection;
	private final IWorkbenchPartSite viewSite;
	private final DeleteResourceAction deleteAction;

	public DeleteTopologyDiagramNodeActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
		deleteAction = new DeleteResourceAction(viewSite.getShell());
		ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		deleteAction.setId(ActionFactory.DELETE.getId());
		deleteAction.setDisabledImageDescriptor(images
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		deleteAction.setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setActionDefinitionId(IWorkbenchActionDefinitionIds.DELETE);
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		if (isEnabled()) {
			deleteAction.selectionChanged(selection);
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
	}

	public void updateActionBars() {
		deleteAction.selectionChanged((IStructuredSelection) getContext().getSelection());
	}

	private boolean isEnabled() {
		if (selection == null) {
			return false;
		}
		Iterator i = selection.iterator();
		while (i.hasNext()) {
			if (!(i.next() instanceof TopologyDiagramNode)) {
				return false;
			}
		}
		return true; //All selections are an instance of topology diagram node
	}

	public void selectionChanged(SelectionChangedEvent event) {
		deleteAction.selectionChanged(event);
	}
}
