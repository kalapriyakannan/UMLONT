/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Popup Deploy editor Preferences dialog
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 */
public class ShowPreferencesAction extends Action {

	private final static String DEPLOY_CORE_MAIN_PREFERENCE_PAGE_ID = "com.ibm.ccl.soa.deploy.core.ui.preferences.DeployCoreMainPreferencePage"; //$NON-NLS-1$
	private final static String PREFERENCES_VALIDATION = "com.ibm.ccl.soa.deploy.core.ui.preferences.ValidationPreferencePage"; //$NON-NLS-1$

	/**
	 * Constructor
	 */
	public ShowPreferencesAction() {
		super(Messages.SHOW_PREFERENCES_ACTION_LABEL);
	}

	public void run() {
		String[] preferenceIDs = { DEPLOY_CORE_MAIN_PREFERENCE_PAGE_ID, PREFERENCES_VALIDATION };
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(null,
				DEPLOY_CORE_MAIN_PREFERENCE_PAGE_ID, preferenceIDs, null);
		dialog.open();
	}
}
