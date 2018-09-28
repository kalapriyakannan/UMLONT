/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogSettings;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.NotSupportedTargetException;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusGroup;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class FieldValueFilter implements IObjectFilter {
	private boolean enable = false;
	private boolean operator = false;
	private String searchString = Messages.NULL_MESSAGE;
	private static final String TAG_ENABLE = "enable"; //$NON-NLS-1$
	private static final String TAG_VALUE = "value"; //$NON-NLS-1$
	private static final String TAG_OPERATOR = "operator"; //$NON-NLS-1$
	private IStatusField field;

	/**
	 * 
	 * @param field
	 */
	public FieldValueFilter(IStatusField field) {
		this.field = field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		FieldValueFilter newFilter = new FieldValueFilter(this.getField());
		newFilter.enable = this.enable;
		newFilter.operator = this.operator;
		newFilter.searchString = this.searchString;
		return newFilter;
	}

	public boolean accept(Object obj) {
		if ((obj instanceof IResource) || obj instanceof StatusGroup)
			return true;
		if (enable) {
			try {
				String value = field.getValue(obj);
				boolean contains = value.indexOf(searchString) >= 0;
				boolean result = (contains() && contains || (!contains() && !contains));
				return result;
			} catch (NotSupportedTargetException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return the enable
	 */
	public String getName() {
		return field.getColumnHeaderText();
	}

	/**
	 * 
	 * @return if it is enabled
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @return the field
	 */
	public IStatusField getField() {
		return field;
	}

	/**
	 * @return the operator
	 */
	public boolean contains() {
		return operator;
	}

	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @param enable
	 *           the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @param field
	 *           the field to set
	 */
	public void setField(IStatusField field) {
		this.field = field;
	}

	/**
	 * @param operator
	 *           the operator to set
	 */
	public void setContains(boolean operator) {
		this.operator = operator;
	}

	/**
	 * @param searchString
	 *           the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * restore from setting
	 * 
	 * @param setting
	 */
	public void restoreState(IDialogSettings setting) {
		assert (setting != null);
		this.enable = setting.getBoolean(TAG_ENABLE);
		this.operator = setting.getBoolean(TAG_OPERATOR);
		this.searchString = setting.get(TAG_VALUE);

	}

	/**
	 * save this filter to setting
	 * 
	 * @param setting
	 */
	public void saveState(IDialogSettings setting) {
		assert (setting != null);
		setting.put(TAG_ENABLE, this.enable);
		setting.put(TAG_OPERATOR, this.operator);
		setting.put(TAG_VALUE, this.searchString);
	}
}
