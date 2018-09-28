/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.ui.IMemento;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;

/**
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public interface IStatusViewConfig {
	/**
	 * 
	 * @return extend fields that can be shown in detail dialog except severity,message,stack trace.
	 */
	public IStatusField[] getExtendFields();

	/**
	 * 
	 * @return filter fields
	 */
	public IStatusField[] getFilterFields();

	/**
	 * 
	 * @param index
	 *           the index of FilterConfig
	 * @return filter with index.
	 */
	public FilterConfig getFilter(int index);

	/**
	 * 
	 * @return all FilterConfig related this status view
	 */
	public FilterConfig[] getFilters();

	/**
	 * @return FilterDialog settings related this status view
	 * 
	 * 
	 */

	public IDialogSettings getFilterDialogSettings();

	/**
	 * @return group fields
	 */
	public IStatusField[] getGroupFields();

	/**
	 * 
	 * @return selected filter
	 */
	public FilterConfig getSelectedFilter();

	/**
	 * 
	 * @return selected group
	 */
	public IStatusField getSelectedGroup();

	/**
	 * 
	 * @return SorterDialog settings related this status view
	 */
	public IDialogSettings getSorterDialogSettings();

	/**
	 * @return TableViewerConfig instance related this.
	 */
	public TableViewerConfig getTableViewerConfig();

	/**
	 * 
	 * @param memento
	 *           used for saving the important state of an object in a form that can be persisted in
	 *           the file system. Restore state from assigned memento, if memento equals null, the
	 *           state will be restored to default state. If a StatusView is closed before you close
	 *           workspace, when you start workspace again, the StatusView will be restroed to
	 *           defautl state.
	 */
	public void restoreState(IMemento memento);

	/**
	 * @param memento
	 *           save state to memento, if memento equals null, do nothing.
	 */
	public void saveState(IMemento memento);

	/**
	 * 
	 * @param newFilter
	 */
	public void setFilters(FilterConfig[] newFilter);

	/**
	 * 
	 * @param index
	 */
	public void setSelectedFilter(int index);

	/**
	 * 
	 * @param index
	 * @param group
	 */
	public void setSelectedGroup(int index);

	/**
	 * @param tableViewerConfig
	 *           the viewerData to set
	 */
	public void setTableViewerConfigData(TableViewerConfig tableViewerConfig);

	/**
	 * 
	 * @return config Provider
	 * @see IConfigProvider
	 */
	public IConfigProvider getConfigProvider();

	/**
	 * 
	 * @param provider
	 * @see IConfigProvider
	 */
	public void setConfigProvider(IConfigProvider provider);

	/**
	 * 
	 * @return Sorter
	 */
	public ViewerSorter getSorter();
}
