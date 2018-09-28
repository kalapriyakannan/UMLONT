/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public abstract class DropDownAction extends Action implements IMenuCreator {
	private Menu fMenu = null;

	/**
	 * @param ei
	 *           enable ImageDescriptor
	 * @param di
	 *           disable ImageDescriptor
	 */
	public DropDownAction(ImageDescriptor ei, ImageDescriptor di) {
		setMenuCreator(this);
		setImageDescriptor(ei);
		setDisabledImageDescriptor(di);
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public Menu getMenu(Control parent) {
		if (fMenu != null) {
			fMenu.dispose();
		}
		fMenu = new Menu(parent);

		createMenu();

		return fMenu;
	}

	public Menu getMenu(Menu parent) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void addActionToMenu(Action action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(fMenu, -1);
	}

	private void createMenu() {

		Action[] actions = getSubActions();
		for (int i = 0; i < actions.length; i++) {
			addActionToMenu(actions[i]);
		}
		IContributionItem[] items = getSubItems();
		if (items.length > 0) {
			new MenuItem(fMenu, SWT.SEPARATOR);
			for (int i = 0; i < items.length; i++) {
				items[i].fill(fMenu, -1);

			}
		}

	}

	/**
	 * 
	 * @return the action shown in drop down menu
	 */
	public abstract Action[] getSubActions();

	/**
	 * 
	 * @return the contibution items shown in the drop down menu.
	 */
	public abstract IContributionItem[] getSubItems();
}
