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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.SelectionListenerAction;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterDialog;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public abstract class AbstractConfigProvider implements IConfigProvider {

	public FilterDialog createFilterDialog(Shell parentShell, FilterConfig[] filterlist) {
		return new FilterDialog(parentShell, filterlist, getFilterFields(), listeningResource());
	}

	public IStatusField[] getExtendFields() {
		return new IStatusField[0];
	}

	public IStatusField[] getFilterFields() {
		return new IStatusField[] { FieldException.INSTANCE };
	}

	public IStatusField[] getGroupFields() {
		return new IStatusField[] { null, FieldSeverity.INSTANCE, FieldException.INSTANCE };
	}

	public ILabelProvider getLabelProvider(IStatusField[] fields) {

		return new TreeLabelProvider(fields);
	}

	public SelectionListenerAction getTreeSelectionAction(IWorkbenchPage page) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean listeningResource() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IConfigProvider#getClearAction()
	 */
	public Action getClearAction(StatusView view) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IConfigProvider#getOpenAction()
	 */
	public Action getOpenAction() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IConfigProvider#getSaveAction()
	 */
	public Action getSaveAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
