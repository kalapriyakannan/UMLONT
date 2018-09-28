/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.publish;

import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterDialog;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class PublishFilterDialog extends FilterDialog {
	/**
	 * 
	 * @param parentShell
	 * @param filtersList
	 * @param extendFilterFields
	 */
	public PublishFilterDialog(Shell parentShell, FilterConfig[] filtersList,
			IStatusField[] extendFilterFields) {
		super(parentShell, filtersList, extendFilterFields, true);
	}

}
