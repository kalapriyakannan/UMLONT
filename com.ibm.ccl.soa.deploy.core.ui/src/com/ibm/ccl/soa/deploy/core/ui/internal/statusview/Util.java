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
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

public final class Util {
	/**
	 * 
	 * @param setting
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getSavedInt(IDialogSettings setting, String key, int defaultValue) {

		try {
			return setting.getInt(key);
		} catch (NumberFormatException e) {
			return defaultValue;
		}

	}

	/**
	 * 
	 * @param setting
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static boolean getSavedBool(IDialogSettings setting, String key) {
		return setting.getBoolean(key);

	}

	/**
	 * 
	 * @param setting
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getSavedValue(IDialogSettings setting, String key, String defaultValue) {

		String value = setting.get(key);
		if (value == null)
			return defaultValue;
		return value;

	}

	public static int getSavedValue(IMemento memento, String key, int defaultValue) {
		Integer value = memento.getInteger(key);
		return value == null ? defaultValue : value.intValue();
	}

	public static String getSavedValue(IMemento memento, String key, String defaultValue) {
		String value = memento.getString(key);
		return value == null ? defaultValue : value;
	}

	public static IDialogSettings getSection(IDialogSettings setting, String name) {
		IDialogSettings mySetting = setting.getSection(name);
		if (mySetting == null) {
			mySetting = setting.addNewSection(name);
		}
		return mySetting;
	}

	protected static IDialogSettings getDialogSettings(String section) {
		final IDialogSettings workbenchSettings = DeployCoreUIPlugin.getDefault().getDialogSettings();
		IDialogSettings settings = workbenchSettings.getSection(section);

		if (settings == null) {
			settings = workbenchSettings.addNewSection(section);
		}
		return settings;
	}

	/**
	 * 
	 * @return selected working set;
	 */
	public static IWorkingSet getWorkingSet(String workingSetName) {
		return PlatformUI.getWorkbench().getWorkingSetManager().getWorkingSet(workingSetName);
	}

}
