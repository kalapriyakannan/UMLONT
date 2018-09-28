/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.cmdb.ui.internal.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IMenuManager;

import com.ibm.ccl.soa.deploy.cmdb.ui.internal.actions.CmdbActionIds;
import com.ibm.ccl.soa.deploy.cmdb.ui.internal.actions.DiscoverMenuManager;

/**
 * Collects all the actions that are provided by the CMDB deploy diagram
 * plug-in.
 */
public class CmdbContributionItemProvider extends
		AbstractContributionItemProvider implements CmdbActionIds {

	/*
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createMenuManager(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IMenuManager createMenuManager(String menuId,
			IWorkbenchPartDescriptor partDescriptor) {

		if (menuId.equals(DEPLOY_DISCOVER)) {
			return new DiscoverMenuManager(partDescriptor.getPartPage());
		}
		return super.createMenuManager(menuId, partDescriptor);
	}
} // end class DeployContributionItemProvider
