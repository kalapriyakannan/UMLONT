/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.handlers.util;

import java.util.StringTokenizer;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util.StringMatcher;
import com.ibm.ccl.soa.deploy.j2ee.ui.J2EEUIDeployPlugin;

/**
 * 
 */
public class TypeFilter implements IPropertyChangeListener {

	public static TypeFilter getDefault() {
		return J2EEUIDeployPlugin.getDefault().getTypeFilter();
	}

	public static boolean isFiltered(String fullTypeName) {
		return getDefault().filter(fullTypeName);
	}

	public static boolean isFiltered(char[] fullTypeName) {
		return getDefault().filter(new String(fullTypeName));
	}

	public static boolean isFiltered(char[] packageName, char[] typeName) {
		return getDefault().filter(concatenateName(packageName, typeName));
	}

	/**
	 * Concatenates two names. Uses a dot for separation. Both strings can be empty or
	 * <code>null</code>.
	 */
	private static String concatenateName(char[] name1, char[] name2) {
		StringBuffer buf = new StringBuffer();
		if (name1 != null && name1.length > 0) {
			buf.append(name1);
		}
		if (name2 != null && name2.length > 0) {
			if (buf.length() > 0) {
				buf.append('.');
			}
			buf.append(name2);
		}
		return buf.toString();
	}

	private StringMatcher[] fStringMatchers;

	/**
	 * 
	 */
	public TypeFilter() {
		fStringMatchers = null;
		PreferenceConstants.getPreferenceStore().addPropertyChangeListener(this);
	}

	private synchronized StringMatcher[] getStringMatchers() {
		if (fStringMatchers == null) {
			String str = PreferenceConstants.getPreferenceStore().getString(
					PreferenceConstants.TYPEFILTER_ENABLED);
			StringTokenizer tok = new StringTokenizer(str, ";"); //$NON-NLS-1$
			int nTokens = tok.countTokens();

			fStringMatchers = new StringMatcher[nTokens];
			for (int i = 0; i < nTokens; i++) {
				String curr = tok.nextToken();
				if (curr.length() > 0) {
					fStringMatchers[i] = new StringMatcher(curr, false, false);
				}
			}
		}
		return fStringMatchers;
	}

	public void dispose() {
		PreferenceConstants.getPreferenceStore().removePropertyChangeListener(this);
		fStringMatchers = null;
	}

	public boolean hasFilters() {
		return getStringMatchers().length > 0;
	}

	public boolean filter(String fullTypeName) {
		StringMatcher[] matchers = getStringMatchers();
		for (int i = 0; i < matchers.length; i++) {
			StringMatcher curr = matchers[i];
			if (curr.match(fullTypeName)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 */
	public synchronized void propertyChange(PropertyChangeEvent event) {
		if (PreferenceConstants.TYPEFILTER_ENABLED.equals(event.getProperty())) {
			fStringMatchers = null;
		}
	}
}
