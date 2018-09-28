/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.export;

import org.eclipse.jface.viewers.ITreeContentProvider;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusContentProvider;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusView;
import com.ibm.ccl.soa.deploy.core.ui.perspective.DeployCorePerspectiveFactory;

/**
 * Export view config provider
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class ExportConfigProvider extends AbstractConfigProvider {
	private StatusContentProvider contentProvider = new StatusContentProvider();

	public ITreeContentProvider getContentProvider(StatusView view) {
		return contentProvider;
	}

	public String getID() {
		return DeployCorePerspectiveFactory.ID_EXPORT_VIEW;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Export"; //$NON-NLS-1$
	}

}
