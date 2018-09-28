/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter;

import java.net.URI;
import java.util.Vector;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogSettings;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldMessage;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldSeverity;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Util;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * store filter setting data
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class FilterConfig implements IObjectFilter {
	protected static final String TAG_FILTER_NAME = "name"; //$NON-NLS-1$
	protected static final String TAG_FILTER_STRING_SECTION = "value"; //$NON-NLS-1$
	protected static final String TAG_FILTER_ENTRY_SECTION = "entry"; //$NON-NLS-1$
	protected static final String TAG_FILTER_ENABLE = "enable"; //$NON-NLS-1$
	private static final String TAG_WORKINGSETNAME = "workingsetname"; //$NON-NLS-1$
	private static final String TAG_RESOURCE = "resource"; //$NON-NLS-1$
	/**
	 * any resource
	 */
	public static final int Focus_On_Any = 0x1;
	/**
	 * any selected resource
	 */
	public static final int Focus_On_Selected = 0x2;
	/**
	 * any in selected working set.
	 */
	public static final int Focus_On_WorkingSet = 0x4;

	private boolean enable = true;
	protected Vector stringFilters = new Vector();
	protected Vector entryFilters = new Vector();
	protected SeverityFilter severityFilter = new SeverityFilter();
	protected String name;
	protected boolean enableResource = false;
	private int focus_on = Focus_On_Any;
	private IResource selectedResource;
	private String selectedWorkingSetName;

	/**
	 * create new named FilterSetting instance
	 * 
	 * @param newName
	 */
	public FilterConfig(String newName) {
		this(newName, new IStatusField[0]);
	}

	/**
	 * 
	 * @param newName
	 * @param fields
	 */
	public FilterConfig(String newName, IStatusField[] fields) {
		this.name = newName;
		FieldValueFilter msgFilter = new FieldValueFilter(FieldMessage.INSTANCE);
		stringFilters.add(msgFilter);
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].hasEntry()) {
				FieldEntryFilter entryFilter = new FieldEntryFilter(fields[i]);
				entryFilters.add(entryFilter);

			} else {
				FieldValueFilter fieldValueFilter = new FieldValueFilter(fields[i]);
				stringFilters.add(fieldValueFilter);
			}
		}
	}

	/**
	 * return cloned object;
	 */
	public Object clone() {
		FilterConfig newFilter = new FilterConfig(name);
		newFilter.enable = this.enable;
		newFilter.focus_on = this.focus_on;
		newFilter.enableResource = this.enableResource;
		newFilter.selectedResource = this.selectedResource;
		newFilter.selectedWorkingSetName = this.selectedWorkingSetName;
		newFilter.severityFilter = (SeverityFilter) this.severityFilter.clone();
		newFilter.entryFilters = new Vector();
		for (int i = 0; i < this.entryFilters.size(); i++) {
			newFilter.entryFilters.add(((FieldEntryFilter) (this.entryFilters.get(i))).clone());
		}
		newFilter.stringFilters = new Vector();
		for (int i = 0; i < this.stringFilters.size(); i++) {
			newFilter.stringFilters.add(((FieldValueFilter) (this.stringFilters.get(i))).clone());
		}
		return newFilter;
	}

	/**
	 * 
	 * @return filter name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return true if filter is enabled.
	 */
	public boolean isEnabled() {
		return enable;
	}

	/**
	 * make filter enable or disable;
	 * 
	 * @param enable
	 */
	public void setEnabled(boolean enable) {
		this.enable = enable;
	}

	/**
	 * 
	 * @param field
	 * @return default filter, default name, default setting.
	 */
	public static FilterConfig getDefault(IStatusField[] field) {
		FilterConfig defaultFilter = new FilterConfig("Default", field); //$NON-NLS-1$
		return defaultFilter;

	}

	private boolean acceptResource(IResource resource) {

		if (focus_on == Focus_On_Any)
			return true;

		IResource parent = resource;
		URI uri = parent.getRawLocationURI();
		URI suri = selectedResource.getRawLocationURI();
		if (suri == null)
			return true;
		while (parent != null && uri != null) {
			if (selectedResource.equals(parent))
				return true;
			if (suri.equals(uri))
				return true;
			parent = parent.getParent();
			uri = parent.getRawLocationURI();

		}

		return false;
	}

	/**
	 * @see IObjectFilter#accept(Object)
	 */
	public boolean accept(Object value) {
		if (value == null)
			return false;
		boolean result = true;
		if (enable) {
			if (enableResource && value instanceof IResource) {
				return acceptResource((IResource) value);
			}
			result = severityFilter.accept(value);
			if (!result)
				return false;
			for (int i = 0; i < stringFilters.size(); i++) {
				if (!((FieldValueFilter) stringFilters.get(i)).accept(value)) {
					return false;
				}
			}
			for (int i = 0; i < entryFilters.size(); i++) {
				if (!((FieldEntryFilter) entryFilters.get(i)).accept(value)) {
					return false;
				}
			}
		}
		return true;

	}

	/**
	 * 
	 * @param setting
	 */
	public void restoreState(IDialogSettings setting) {
		if (setting == null) {
			return;
		}
		this.enable = Util.getSavedBool(setting, TAG_FILTER_ENABLE);
		if (this.enableResource) {
			this.focus_on = Util.getSavedInt(setting, TAG_RESOURCE, Focus_On_Any);
			if (this.focus_on == Focus_On_WorkingSet) {
				this.selectedWorkingSetName = Util.getSavedValue(setting, TAG_WORKINGSETNAME, null);
			}
		}
		IDialogSettings severitySection = Util.getSection(setting, FieldSeverity.INSTANCE
				.getColumnHeaderText());
		this.severityFilter.restoreState(severitySection);
		for (int i = 0; i < stringFilters.size(); i++) {
			FieldValueFilter filter = (FieldValueFilter) stringFilters.get(i);
			IDialogSettings subSection = Util.getSection(setting, filter.getField()
					.getColumnHeaderText());
			filter.restoreState(subSection);
		}
		for (int i = 0; i < entryFilters.size(); i++) {
			FieldEntryFilter filter = (FieldEntryFilter) entryFilters.get(i);
			IDialogSettings subSection = Util.getSection(setting, filter.getField()
					.getColumnHeaderText());
			filter.restoreState(subSection);
		}

	}

	/**
	 * 
	 * @param setting
	 */
	public void saveState(IDialogSettings setting) {
		if (setting == null)
			return;
		setting.put(TAG_FILTER_ENABLE, this.enable);

		if (this.enableResource) {
			setting.put(TAG_RESOURCE, this.focus_on);
			if (this.focus_on == Focus_On_WorkingSet) {
				setting.put(TAG_WORKINGSETNAME, this.selectedWorkingSetName);
			}
		}
		IDialogSettings severitySection = Util.getSection(setting, FieldSeverity.INSTANCE
				.getColumnHeaderText());
		severityFilter.saveState(severitySection);
		for (int i = 0; i < stringFilters.size(); i++) {
			FieldValueFilter filter = (FieldValueFilter) stringFilters.get(i);
			IDialogSettings subSection = Util.getSection(setting, filter.getField()
					.getColumnHeaderText());
			filter.saveState(subSection);
		}
		for (int i = 0; i < entryFilters.size(); i++) {
			FieldEntryFilter filter = (FieldEntryFilter) entryFilters.get(i);
			IDialogSettings subSection = Util.getSection(setting, filter.getField()
					.getColumnHeaderText());
			filter.saveState(subSection);
		}

	}

	/**
	 * 
	 * @param field
	 * @return entryFilter
	 */
	public FieldEntryFilter getEntryListFilter(IStatusField field) {
		for (int i = 0; i < entryFilters.size(); i++) {
			FieldEntryFilter filter = (FieldEntryFilter) entryFilters.get(i);
			if (filter.getField().equals(field)) {
				return filter;
			}
		}
		return null;
	}

	/**
	 * @return the severityFilter
	 */
	public SeverityFilter getSeverityFilter() {
		return severityFilter;
	}

	/**
	 * @param severityFilter
	 *           the severityFilter to set
	 */
	public void setSeverityFilter(SeverityFilter severityFilter) {
		this.severityFilter = severityFilter;
	}

	/**
	 * @return the stringFilters
	 */
	public Vector getStringFilters() {
		return stringFilters;
	}

	/**
	 * @param stringFilters
	 *           the stringFilters to set
	 */
	public void setStringFilters(Vector stringFilters) {
		this.stringFilters = stringFilters;
	}

	/**
	 * @return the entryFilters
	 */
	public Vector getEntryFilters() {
		return entryFilters;
	}

	/**
	 * @param entryFilters
	 *           the entryFilters to set
	 */
	public void setEntryFilters(Vector entryFilters) {
		this.entryFilters = entryFilters;
	}

	/**
	 * 
	 * @param field
	 * @return value filter
	 */
	public FieldValueFilter getValueFilters(IStatusField field) {
		for (int i = 0; i < stringFilters.size(); i++) {
			FieldValueFilter filter = (FieldValueFilter) stringFilters.get(i);
			if (filter.getField().equals(field)) {
				return filter;
			}
		}
		FieldValueFilter filter = new FieldValueFilter(field);
		stringFilters.add(filter);
		return filter;
	}

	/**
	 * @return the selectedResource
	 */
	public IResource getSelectedResource() {
		return selectedResource;
	}

	/**
	 * @return the selectedWorkingSetName
	 */
	public String getSelectedWorkingSetName() {
		return selectedWorkingSetName;
	}

	/**
	 * @param selectedResource
	 *           the selectedResource to set
	 */
	public void setSelectedResource(IResource selectedResource) {
		this.selectedResource = selectedResource;
	}

	/**
	 * @param selectedWorkingSetName
	 *           the selectedWorkingSetName to set
	 */
	public void setSelectedWorkingSetName(String selectedWorkingSetName) {
		this.selectedWorkingSetName = selectedWorkingSetName;
	}

	/**
	 * @return the focus_on
	 */
	public int getFocus() {
		return focus_on;
	}

	/**
	 * @param focus_on
	 *           the focus_on to set
	 */
	public void setFocus(int focus_on) {
		if (focus_on == Focus_On_Any || focus_on == Focus_On_Selected
				|| focus_on == Focus_On_WorkingSet)
			this.focus_on = focus_on;
	}

	/**
	 * @return the enableResource
	 */
	public boolean isEnableResource() {
		return enableResource;
	}

	/**
	 * @param enableResource
	 *           the enableResource to set
	 */
	public void setEnableResource(boolean enableResource) {
		this.enableResource = enableResource;
	}
}
