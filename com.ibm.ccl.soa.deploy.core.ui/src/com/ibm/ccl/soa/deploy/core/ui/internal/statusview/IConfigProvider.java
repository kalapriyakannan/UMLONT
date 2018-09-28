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
import org.eclipse.jface.viewers.ITreeContentProvider;
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
public interface IConfigProvider {
	/**
	 * 
	 * @return true if StatusView need listen Resource
	 */
	public boolean listeningResource();

	/**
	 * 
	 * @param view
	 * @return StatusTreeViewer's content Provider
	 */
	public ITreeContentProvider getContentProvider(StatusView view);

	/**
	 * 
	 * @param fields
	 * @return StatusTreeViewer's label provider
	 */
	public ILabelProvider getLabelProvider(IStatusField[] fields);

	/**
	 * 
	 * @param page
	 *           TODO
	 * @return listeners which listen StatuTreeViewer's selection changed.
	 */
	public SelectionListenerAction getTreeSelectionAction(IWorkbenchPage page);

	/**
	 * 
	 * @return exntend fields;
	 */
	public IStatusField[] getExtendFields();

	/**
	 * 
	 * @return group fields;
	 */
	public IStatusField[] getGroupFields();

	/**
	 * 
	 * @return filter fields;
	 */
	public IStatusField[] getFilterFields();

	/**
	 * 
	 * @param parentShell
	 * @param filterlist
	 *           TODO
	 * @param filterFields
	 *           TODO
	 * @return filter dialog
	 */
	public FilterDialog createFilterDialog(Shell parentShell, FilterConfig[] filterlist);

	/**
	 * 
	 * @param view
	 *           TODO
	 * @return clear action, if action equals null then ClearAction don't show in StatusView
	 */
	public Action getClearAction(StatusView view);

	/**
	 * 
	 * @return saved action, if action equals null then ClearAction don't show in StatusView
	 */
	public Action getSaveAction();

	/**
	 * 
	 * @return open action, if action equals null then ClearAction don't show in StatusView
	 */
	public Action getOpenAction();

	/**
	 * 
	 * @return view's id
	 */
	public String getID();

	/**
	 * 
	 * @return veiw's name
	 */
	public String getName();
}
