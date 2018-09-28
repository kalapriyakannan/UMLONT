/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogSettings;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.NotSupportedTargetException;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusGroup;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Util;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * 
 * @author lynn
 * 
 */
public class FieldEntryFilter implements IObjectFilter {
	private static final String TAG_ENABLE = "enable"; //$NON-NLS-1$
	private static final String TAG_ENTRY = "entry"; //$NON-NLS-1$
	private boolean enable = false;
	private Set entryList;
	private IStatusField field;

	/**
	 * @param field
	 * 
	 */
	public FieldEntryFilter(IStatusField field) {
		super();
		this.field = field;
		this.entryList = new TreeSet();

	}

	public Object clone() {
		FieldEntryFilter newFilter = new FieldEntryFilter(this.field);
		newFilter.enable = this.enable;
		newFilter.entryList = new TreeSet();
		newFilter.entryList.addAll(this.entryList);
		return newFilter;

	}

	/**
	 * 
	 * @return field name
	 */
	public String getName() {
		return field.getColumnHeaderText();
	}

	public boolean accept(Object obj) {
		if (obj instanceof IResource || obj instanceof StatusGroup)
			return true;
		if (enable && entryList != null) {
			try {
				String value = field.getValue(obj);
				if (entryList.contains(value)) {
					return true;
				}
			} catch (NotSupportedTargetException e) {
				return false;
			}

			return false;

		}
		return true;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *           the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the validList
	 */
	public Set getEntryList() {
		return entryList;
	}

	/**
	 * @param validList
	 *           the validList to set
	 */
	public void setEntryList(Set validList) {
		this.entryList = validList;
	}

	/**
	 * 
	 * @return field
	 */
	public IStatusField getField() {
		return field;
	}

	/**
	 * save this filter to setting.
	 * 
	 * @param setting
	 */
	public void saveState(IDialogSettings setting) {
		setting.put(TAG_ENABLE, enable);
		for (Iterator it = entryList.iterator(); it.hasNext();) {
			setting.put(TAG_ENTRY, (String) it.next());
		}
	}

	/**
	 * restore from setting
	 * 
	 * @param setting
	 */
	public void restoreState(IDialogSettings setting) {
		enable = Util.getSavedBool(setting, TAG_ENABLE);
		String[] list = setting.getArray(TAG_ENTRY);
		Set allEntries = field.getEntries();
		if (list == null)
			return;
		for (int i = 0; i < list.length; i++) {
			if (allEntries.contains(list[i])) {
				this.entryList.add(list[i]);
			}
		}
	}
}
