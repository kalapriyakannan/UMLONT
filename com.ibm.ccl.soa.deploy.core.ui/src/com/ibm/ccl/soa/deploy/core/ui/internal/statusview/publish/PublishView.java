/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.publish;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISelectionListener;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusViewConfig;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusView;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusViewConfig;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class PublishView extends StatusView implements ISelectionListener {
	private StatusViewConfig config;
	private PublishConfigProvider provider;

	/**
	 * 
	 * 
	 */
	public PublishView() {
		provider = new PublishConfigProvider();
		config = new StatusViewConfig(provider);
		config.setName("publisher"); //$NON-NLS-1$
		// TODO Track changes and update view 
		//PublishAdapter adapter=new PublishAdapter(this);
		this.seperate = true;
	}

	protected IStatusViewConfig getSetting() {

		return config;
	}

	protected Action createClearAction() {
		return new ClearPublishStatusAction(this);
	}

}
