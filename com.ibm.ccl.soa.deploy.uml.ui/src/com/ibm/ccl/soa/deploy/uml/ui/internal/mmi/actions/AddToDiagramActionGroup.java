/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.uml.ui.internal.UmlUIMessages;

/**
 * @since 1.0
 * 
 */
public class AddToDiagramActionGroup extends ActionGroup {
	private IStructuredSelection selection;
	private final IWorkbenchPartSite viewSite;
	private final String TOPOLOGY_FILE_EXTENSION = "topology"; //$NON-NLS-1$
	private final String TOPOLOGYV_FILE_EXTENSION = "topologyv"; //$NON-NLS-1$
	private final ROTopologyModelManager modelManager = ROTopologyModelManager.create();
	private final ROTopologyModelManager.Listener listener = new ROTopologyModelManager.Listener() {

		public void onUnload(IFile unloadedResource) {
			// We only assume the topology we fetched is valid for the lift of the fillContextMenu call.

		}

	};

	/**
	 * @param viewSite
	 */
	public AddToDiagramActionGroup(IWorkbenchPartSite viewSite) {
		this.viewSite = viewSite;
	}

	public void dispose() {
		super.dispose();
		modelManager.dispose();
	}

	/**
	 * @param selection
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void fillContextMenu(IMenuManager menu) {
		menu.insertAfter(ICommonMenuConstants.GROUP_NEW, new Separator("deploy.vizualize.seperator")); //$NON-NLS-1$
		IMenuManager submenu = new MenuManager(UmlUIMessages.AddToDiagramActionGroup_Add_Diagra_,
				"deploy.vizualize.submenu"); //$NON-NLS-1$
		menu.appendToGroup("deploy.vizualize.seperator", submenu); //$NON-NLS-1$

		submenu.add(new AddToNewTopologyDiagramWrapperAction(selection));

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

	/**
	 * @param aMenu
	 * @param descriptors
	 * @param selection
	 * 
	 * Adds all the available TopologyPublisherDescriptor for the given Topology as a submenu under
	 * Publish
	 * 
	 */
	private void addTopologyPublisherMenu(IMenuManager aMenu, Topology topology,
			ITopologyPublisherDescriptor[] descriptors) {

	}

}
