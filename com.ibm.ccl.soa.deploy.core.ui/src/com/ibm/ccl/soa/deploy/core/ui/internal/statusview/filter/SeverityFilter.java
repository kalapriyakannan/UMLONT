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

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldSeverity;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.NotSupportedTargetException;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusGroup;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Util;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class SeverityFilter implements IObjectFilter {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	private static final String TAG_ENABLE = "enable"; //$NON-NLS-1$
	private static final String TAG_VALUE = "value"; //$NON-NLS-1$

	public Object clone() {
		SeverityFilter newFilter = new SeverityFilter();
		newFilter.enabled = this.enabled;
		newFilter.interestedSeverities = this.interestedSeverities;
		return newFilter;
	}

	private boolean enabled = false;
	private int interestedSeverities = 0x7;

	public boolean accept(Object obj) {
		if (obj instanceof IResource || obj instanceof StatusGroup)
			return true;
		if (!enabled)
			return true;
		try {
			int severity = FieldSeverity.INSTANCE.getSeverity(obj);
			return (interestedSeverities & severity) != 0;
		} catch (NotSupportedTargetException e) {
			return false;
		}

	}

	/**
	 * @return the interestedSeverities
	 */
	public int getInterestedSeverities() {
		return interestedSeverities;
	}

	/**
	 * @param interestedSeverities
	 *           the interestedSeverities to set
	 */
	public void setInterestedSeverities(int interestedSeverities) {
		this.interestedSeverities = interestedSeverities;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *           the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * resotre from setting
	 * 
	 * @param setting
	 */
	public void restoreState(IDialogSettings setting) {
		assert (setting != null);
		enabled = Util.getSavedBool(setting, TAG_ENABLE);
		interestedSeverities = Util.getSavedInt(setting, TAG_VALUE, 0x7);
	}

	/**
	 * save to setting
	 * 
	 * @param setting
	 */
	public void saveState(IDialogSettings setting) {
		assert (setting != null);
		setting.put(TAG_ENABLE, enabled);
		setting.put(TAG_VALUE, interestedSeverities);
	}
}
