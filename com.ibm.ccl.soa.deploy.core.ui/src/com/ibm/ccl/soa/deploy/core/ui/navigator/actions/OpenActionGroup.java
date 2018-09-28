/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;

/**
 * @since 1.0
 * 
 */
public class OpenActionGroup extends ActionGroup {
	private final IWorkbenchPartSite viewSite;
	private final OpenToplogyAction openTopologyActon;
	private IStructuredSelection selection;

	/**
	 * @param viewSite
	 */

	public OpenActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
		openTopologyActon = new OpenToplogyAction(viewSite.getPage());
	}

	/**
	 * @param selection
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	/**
	 * @return Returns true if only one object is selected in the navigator otherwise returns false
	 */
	private boolean isSingleSelected() {
		if (selection == null) {
			return false;
		}
		if (selection.size() > 1) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager menu) {
		if (isSingleSelected()) {
			openTopologyActon.selectionChanged(getSelection());
			//TODO Hack for TopologyDiagramNode-- to be removed when menus are fixed
			if (openTopologyActon.isEnabled()
					&& !(getSelection().getFirstElement() instanceof TopologyDiagramNode)) {
				menu.insertAfter(ICommonMenuConstants.GROUP_OPEN, openTopologyActon);
				addOpenWithMenu(menu);
			}
		}
	}

	private IStructuredSelection getSelection() {
		return selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ICommonActionProvider#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	public void fillActionBars(IActionBars theActionBars) {
		if (isSingleSelected()) {
			openTopologyActon.selectionChanged(selection);
			if (openTopologyActon.isEnabled()) {
				theActionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openTopologyActon);
			}
		}
	}

	private Object resolveObject(Object object) {
		if (object instanceof IWrapperItemProvider) {
			IWrapperItemProvider wrapperItemProvider = (IWrapperItemProvider) object;
			object = wrapperItemProvider.getValue();

		}
		if (object instanceof FeatureMap.Entry) {
			FeatureMap.Entry entry = (FeatureMap.Entry) object;
			object = entry.getValue();
		}
		return object;
	}

	private void addOpenWithMenu(IMenuManager aMenu) {

		/*
		 * if (!isSingleSelected()) return;
		 * 
		 * Object o = selection.getFirstElement(); o = resolveObject(o);
		 * 
		 * IResource resource = (IResource) AdaptabilityUtility.getAdapter(o, IResource.class); //
		 * Create a menu flyout. IMenuManager submenu = new MenuManager( Messages.OpenWithMenu_label,
		 * ICommonMenuConstants.GROUP_OPEN_WITH); submenu.add(new
		 * GroupMarker(ICommonMenuConstants.GROUP_TOP)); if (resource != null && !(resource instanceof
		 * IProject) && !(resource instanceof IFolder)) submenu.add(new
		 * OpenWithMenu(viewSite.getPage(), resource));
		 * 
		 * submenu.add(new GroupMarker(ICommonMenuConstants.GROUP_ADDITIONS)); // Add the submenu. if
		 * (submenu.getItems().length > 2 && submenu.isEnabled())
		 * aMenu.appendToGroup(ICommonMenuConstants.GROUP_OPEN_WITH, submenu);
		 */
	}

}
