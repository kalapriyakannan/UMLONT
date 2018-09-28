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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionGroup;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitAmplifierDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;

/**
 * @since 1.0
 * 
 */
public class UnitAmplifierActionGroup extends ActionGroup {
	private IStructuredSelection selection;
	private final IWorkbenchPage page;

	/**
	 * @param viewSite
	 */
	public UnitAmplifierActionGroup(IWorkbenchPage page) {
		this.page = page;
	}

	public void dispose() {
		super.dispose();

	}

	/**
	 * @param selection
	 */
	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public void fillContextMenu(IMenuManager menu) {

		Unit unit = null;
		UnitAmplifierDescriptor[] descriptors = getUnitAmplifierDescriptors(unit);
		addUnitAmplifierMenu(menu, unit, descriptors);

	}

	/**
	 * @param topology
	 * @return Returns TopologyAmplifiererDescriptors for the given Topology.
	 */
	private UnitAmplifierDescriptor[] getUnitAmplifierDescriptors(Unit unit) {
		return UnitLifeCycleManager.getInstance().findEnabledTopologyUnitAmplifiersByInputOnly(unit);
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
	 * Adds all the available TopologyAmplifiererDescriptor for the given Topology as a submenu under
	 * Amplifier
	 * 
	 */
	private void addUnitAmplifierMenu(IMenuManager aMenu, Unit unit,
			UnitAmplifierDescriptor[] descriptors) {

		/*
		 * aMenu.insertBefore(ICommonMenuConstants.GROUP_ADDITIONS, new Separator(
		 * ActionIds.GROUP_TOPOLOGY_ACTIONS));
		 */
		IMenuManager submenu = new MenuManager(Messages.UnitAmplifierActionGroup_Amplifie_,
				ActionIds.AMPLIFY_ACTION);

		for (int x = 0; x < descriptors.length; ++x) {
			/*
			 * submenu.add(new UnitAmplifierAction(Display.getDefault().getActiveShell(),
			 * descriptors[x], unit,null));
			 */
		}
		aMenu.appendToGroup(ActionIds.GROUP_TOPOLOGY_ACTIONS, submenu);
	}

}
