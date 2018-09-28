/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.Arrays;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.ui.IMemento;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class StatusViewConfig implements IStatusViewConfig {

	protected static final String TAG_FILTER_SELECTED = "selectedindex";//$NON-NLS-1$
	protected static final String TAG_FILTER_NUM = "num"; //$NON-NLS-1$
	protected static final String TAG_GROUP_SELECTED = "group.selected"; //$NON-NLS-1$
	protected static final String TAG_STATUS_VIEW = "com.ibm.ccl.soa.deploy.core.ui.internal.statusview"; //$NON-NLS-1$
	private static final String TAG_FILTER = "filterSection"; //$NON-NLS-1$
	private static final String TAG_NAME = "name"; //$NON-NLS-1$
	//Table Viewer Setting
	protected int selectedFilterIndex;
	protected int selectedGroupIndex = 0;
	protected TableViewerConfig viewerData;
	protected FilterConfig[] filters;

	private String name;
	private IConfigProvider provider;

	/**
	 * 
	 * 
	 */
	public StatusViewConfig() {
		selectedFilterIndex = 0;
		selectedGroupIndex = 0;
		viewerData = new TableViewerConfig();
		filters = new FilterConfig[] { getDefaultFilter() };
		provider = null;
	}

	public StatusViewConfig(IConfigProvider provider) {
		this.provider = provider;
		selectedFilterIndex = 0;
		selectedGroupIndex = 0;
		IStatusField[] tableFields = new IStatusField[this.provider.getExtendFields().length + 2];
		tableFields[0] = FieldMessage.INSTANCE;
		tableFields[1] = FieldException.INSTANCE;
		System.arraycopy(this.provider.getExtendFields(), 0, tableFields, 2, this.provider
				.getExtendFields().length);
		viewerData = new TableViewerConfig(tableFields);
		filters = new FilterConfig[] { getDefaultFilter() };
	}

	/**
	 * 
	 * @return StatusSorter
	 */
	private StatusSorter createTableSorter() {
		final IStatusField[] sortingFields = viewerData.getTableFields();
		final int[] priorities = new int[sortingFields.length];
		final int[] directions = new int[sortingFields.length];
		for (int i = 0; i < sortingFields.length; i++) {
			priorities[i] = i;
		}
		Arrays.fill(directions, StatusSorter.ASCENDING);
		final StatusSorter sorter = new StatusSorter(sortingFields, priorities, directions);
		sorter.restoreState(getSorterDialogSettings());

		return sorter;
	}

	public IConfigProvider getConfigProvider() {
		return provider;
	}

	protected FilterConfig getDefaultFilter() {
		return FilterConfig.getDefault(getFilterFields());
	}

	public IStatusField[] getExtendFields() {
		if (provider != null)
			return provider.getExtendFields();
		return new IStatusField[0];
	}

	public FilterConfig getFilter(int index) {
		if (index >= 0 && index < filters.length) {
			return filters[index];
		}
		return null;
	}

	public IDialogSettings getFilterDialogSettings() {
		return Util.getDialogSettings(getFilterTag());
	}

	public IStatusField[] getFilterFields() {
		if (provider != null) {
			return provider.getFilterFields();
		}
		return new IStatusField[0];
	}

	public FilterConfig[] getFilters() {
		if (filters.length == 0) {
			return new FilterConfig[] { getDefaultFilter() };
		}
		return filters;
	}

	protected String getFilterTag() {
		return TAG_STATUS_VIEW + "." + name + ".filter"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public IStatusField[] getGroupFields() {
		if (provider != null)
			return this.provider.getGroupFields();
		return new IStatusField[] { FieldSeverity.INSTANCE, FieldException.INSTANCE };
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return provider.getName();
	}

	public FilterConfig getSelectedFilter() {
		if (filters.length == 0) {
			return getDefaultFilter();
		}
		return filters[selectedFilterIndex];
	}

	public IStatusField getSelectedGroup() {
		return getGroupFields()[selectedGroupIndex];

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusViewConfig#getSorter()
	 */
	public ViewerSorter getSorter() {
		return createTableSorter();
	}

	/**
	 * 
	 * @return sorter dialog setting
	 */
	public IDialogSettings getSorterDialogSettings() {
		return Util.getDialogSettings(getSorterTag());
	}

	protected String getSorterTag() {
		return TAG_STATUS_VIEW + "." + name + ".sort"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @return the viewerData
	 */
	public TableViewerConfig getTableViewerConfig() {
		return viewerData;
	}

	public void restoreState(IMemento memento) {
		restoreFilterConfigs();
		if (memento == null) {
			return;
		}
		selectedFilterIndex = Util.getSavedValue(memento, TAG_FILTER_SELECTED, 0);
		if (selectedFilterIndex >= filters.length) {
			selectedFilterIndex = 0;
		}
		selectedGroupIndex = Util.getSavedValue(memento, TAG_GROUP_SELECTED, 0);
		if (selectedGroupIndex >= getGroupFields().length) {
			selectedGroupIndex = 0;
		}
		viewerData.restoreState(memento);

	}

	public void restoreFilterConfigs() {
		IDialogSettings filterDialogSetting = getFilterDialogSettings();
		int filterNum = Util.getSavedInt(filterDialogSetting, TAG_FILTER_NUM, 0);
		if (filterNum > 0) {
			filters = new FilterConfig[filterNum];
			for (int i = 0; i < filters.length; i++) {
				IDialogSettings setting = Util.getDialogSettings(TAG_FILTER + i);
				String name = setting.get(TAG_NAME);
				FilterConfig newFilter = new FilterConfig(name, provider.getFilterFields());
				//setting.getBoolean()
				newFilter.restoreState(setting);
				filters[i] = newFilter;

			}
		}
	}

	private void saveFilterConfigs() {
		IDialogSettings filterDialogSetting = getFilterDialogSettings();
		filterDialogSetting.put(TAG_FILTER_NUM, filters.length);
		for (int i = 0; i < filters.length; i++) {
			IDialogSettings setting = Util.getDialogSettings(TAG_FILTER + i);
			setting.put(TAG_NAME, filters[i].getName());
			filters[i].saveState(setting);

		}
	}

	public void saveState(IMemento memento) {
		saveFilterConfigs();
		if (memento == null) {
			return;
		}
		memento.putInteger(TAG_FILTER_SELECTED, selectedFilterIndex);
		memento.putInteger(TAG_GROUP_SELECTED, selectedGroupIndex);
		viewerData.saveState(memento);

	}

	public void setConfigProvider(IConfigProvider provider) {
		this.provider = provider;
		if (provider != null) {
			IStatusField[] tableFields = new IStatusField[this.provider.getExtendFields().length + 2];
			tableFields[0] = FieldMessage.INSTANCE;
			tableFields[1] = FieldException.INSTANCE;
			System.arraycopy(this.provider.getExtendFields(), 0, tableFields, 2, this.provider
					.getExtendFields().length);
			viewerData = new TableViewerConfig(tableFields);
			restoreFilterConfigs();
		}

	}

	public void setFilters(FilterConfig[] newFilterSettings) {
		if (newFilterSettings != null)
			filters = newFilterSettings;

	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setSelectedFilter(int index) {
		if (index >= 0 && index < filters.length)
			selectedFilterIndex = index;

	}

	public void setSelectedGroup(int index) {
		if (index >= 0 && index < this.provider.getGroupFields().length) {
			selectedGroupIndex = index;
		}

	}

	/**
	 * @param viewerData
	 *           the viewerData to set
	 */
	public void setTableViewerConfigData(TableViewerConfig viewerData) {
		this.viewerData = viewerData;
	}

}
