/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.publish;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.SelectionListenerAction;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldException;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldSeverity;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldTopology;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldUnit;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusView;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterDialog;
import com.ibm.ccl.soa.deploy.core.ui.perspective.DeployCorePerspectiveFactory;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class PublishConfigProvider extends AbstractConfigProvider {

	private PublishContentProvider content = new PublishContentProvider();

	public ITreeContentProvider getContentProvider(StatusView view) {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider#getExtendFields()
	 */
	public IStatusField[] getExtendFields() {
		return new IStatusField[] { FieldTopology.INSTANCE, FieldUnit.INSTANCE,
				FieldPublisher.INSTANCE };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider#getFilterFields()
	 */
	public IStatusField[] getFilterFields() {
		return new IStatusField[] { FieldPublisher.INSTANCE };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider#getGroupFields()
	 */
	public IStatusField[] getGroupFields() {
		return new IStatusField[] { null, FieldSeverity.INSTANCE, FieldTopology.INSTANCE,
				FieldException.INSTANCE, FieldPublisher.INSTANCE };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider#getTreeSelectionAction()
	 */
	public SelectionListenerAction getTreeSelectionAction(IWorkbenchPage page) {
		return new SetSelectionOnEditorAction(page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.AbstractConfigProvider#listeningResource()
	 */
	public boolean listeningResource() {
		return true;
	}

	public FilterDialog createFilterDialog(Shell parentShell, FilterConfig[] filterlist) {
		return new PublishFilterDialog(parentShell, filterlist, this.getFilterFields());
	}

	public String getID() {
		// TODO Auto-generated method stub
		return DeployCorePerspectiveFactory.ID_PUBLISH_PROBLEM;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Publish View"; //$NON-NLS-1$
	}

}
