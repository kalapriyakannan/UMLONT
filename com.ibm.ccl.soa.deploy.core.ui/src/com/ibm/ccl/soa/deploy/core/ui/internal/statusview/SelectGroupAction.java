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
import org.eclipse.jface.action.IAction;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a> select group option, it will make all
 *         elements are grouped in view.
 */

public class SelectGroupAction extends Action {
	private int index;
	private IStatusViewConfig setting;
	private StatusView view;

	/**
	 * 
	 * @param view
	 * @param setting
	 * @param index
	 */
	public SelectGroupAction(StatusView view, IStatusViewConfig setting, int index) {
		super(setting.getGroupFields()[index].getColumnHeaderText(), IAction.AS_RADIO_BUTTON);
		this.index = index;
		this.setting = setting;
		this.view = view;

		IStatusField field = setting.getGroupFields()[index];
		IStatusField selectedGroup = setting.getSelectedGroup();
		setChecked(field == selectedGroup);
	}

	public SelectGroupAction(StatusView view2, String string, int i) {
		super(string, IAction.AS_RADIO_BUTTON);
		this.index = i;
		this.view = view2;
		this.setting = view2.getSetting();
		IStatusField field = setting.getGroupFields()[index];
		IStatusField selectedGroup = setting.getSelectedGroup();
		setChecked(field == selectedGroup);
	}

	public void run() {
		if (isChecked()) {
			IStatusField field = setting.getSelectedGroup();
			IStatusField myField = setting.getGroupFields()[index];
			if (field == myField)
				return;
			if (field != null)
				field.setShowing(true);
			setting.setSelectedGroup(index);
			if (myField != null)
				myField.setShowing(false);
			view.update();

		}
	}
}
