package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;

/**
 * @since 7.0
 * 
 */
public class HighlightUnusedNodesActionGroup extends ActionGroup {
	private final IWorkbenchPartSite viewSite;
	private HighlightUnusedNodesAction highlightUnusedNodesAction;

	/**
	 * @param viewSite
	 */
	public HighlightUnusedNodesActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		if (highlightUnusedNodesAction == null) {
			highlightUnusedNodesAction = new HighlightUnusedNodesAction(viewSite.getPage());
			actionBars.getToolBarManager().add(highlightUnusedNodesAction);
		}
		super.fillActionBars(actionBars);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		// TODO Auto-generated method stub
		super.fillContextMenu(menu);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
