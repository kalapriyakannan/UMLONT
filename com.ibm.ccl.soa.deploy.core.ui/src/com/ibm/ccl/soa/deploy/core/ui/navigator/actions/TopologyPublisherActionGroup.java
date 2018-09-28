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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * @since 1.0
 * 
 */
public class TopologyPublisherActionGroup extends ActionGroup {
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
	public TopologyPublisherActionGroup(IWorkbenchPartSite viewSite) {
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
		if (isSingleSelected()) {
			Object object = selection.getFirstElement();
			Topology topology = null;
			if (object instanceof IFile) {
				topology = getTopology((IFile) object);
			} else if (object instanceof Topology) {
				topology = (Topology) object;
			}
			if (topology != null) {
				IDecoratorSemanticService dsService = ExtensionsCore.createDecoratorSemanticService();
				//Filter by decorator semantic
				ITopologyPublisherDescriptor[] descriptors = getTopologyPublisherDescriptors(topology);
				if (dsService.isMenuMemberOf(topology.getDecoratorSemantic(),
						ActionIds.PUBLISH_TOPOLOGY_ACTION)) {
					addTopologyPublisherMenu(menu, topology, descriptors);
				}
			}
		}
	}

	/**
	 * @param topology
	 * @return Returns TopologyPublisherDescriptors for the given Topology.
	 */
	private ITopologyPublisherDescriptor[] getTopologyPublisherDescriptors(Topology topology) {
		return ExtensionsCore.createTopologyPublisherService().findAvailableTopologyPublishers();
	}

	/**
	 * @param file
	 * @return Returns the topology object for given topology file.
	 */
	private Topology getTopology(IFile file) {
		if (file.getFileExtension() != null
				&& (TOPOLOGY_FILE_EXTENSION.equalsIgnoreCase(file.getFileExtension()) || TOPOLOGYV_FILE_EXTENSION
						.equalsIgnoreCase(file.getFileExtension()))) {
			//Do not force load.
			return modelManager.openModel(file, listener, false);
		}
		return null;

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

		aMenu.insertBefore(ICommonMenuConstants.GROUP_ADDITIONS, new Separator(
				ActionIds.GROUP_TOPOLOGY_ACTIONS));

		IMenuManager submenu = new MenuManager(Messages.PUBLISH_TOPOLOGY_SUB_MENU,
				ActionIds.PUBLISH_TOPOLOGY_ACTION);

		for (int x = 0; x < descriptors.length; ++x) {
			submenu.add(new TopologyPublisherAction(viewSite.getShell(), descriptors[x], topology));
		}
		aMenu.appendToGroup(ActionIds.GROUP_TOPOLOGY_ACTIONS, submenu);
	}
}
