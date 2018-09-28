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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * Select group option, it will make all elements are grouped in view.
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 */

public class SelectSubViewAction extends Action {
	private final StatusView view;
	private final IStatusViewConfig config;

	/**
	 * @param view
	 * @param config
	 * 
	 * 
	 */
	public SelectSubViewAction(StatusView view, IStatusViewConfig config) {
		super(config.getConfigProvider().getName(), IAction.AS_RADIO_BUTTON);
		this.view = view;
		this.config = config;
		setChecked(config == view.getActivatedConfig());
	}

	public void run() {
		if (isChecked()) {
			view.setActivatedSubView(config);
			//WorkbenchPartActivator.showView()
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(view);
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
						view.getViewID());

			} catch (PartInitException e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			}
		}
	}
}
