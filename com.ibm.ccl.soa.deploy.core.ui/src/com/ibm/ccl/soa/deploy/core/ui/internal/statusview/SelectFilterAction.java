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

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class SelectFilterAction extends Action {
	private IStatusViewConfig setting;
	private StatusView view;
	private int index;

	/**
	 * 
	 * @param view
	 * @param setting
	 * @param index
	 */
	public SelectFilterAction(StatusView view, IStatusViewConfig setting, int index) {
		super(setting.getFilter(index).getName(), IAction.AS_RADIO_BUTTON);
		this.setting = setting;
		this.view = view;
		this.index = index;
		FilterConfig filter = setting.getFilters()[index];
		FilterConfig selectdFilter = setting.getSelectedFilter();
		boolean bol = selectdFilter == filter;
		setChecked(bol);
	}

	public void run() {
		if (isChecked()) {
			setting.setSelectedFilter(index);
			view.update();
		}
	}
}
