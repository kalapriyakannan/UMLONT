/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.FontData;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * Initializes the preferences pages for the Logic Diagram Editor.
 * 
 */
public class DeployCorePreferencesInitializer extends DiagramPreferenceInitializer {

	/**
	 * Initializes all the generic diagram preferences with their default values. Override to
	 * initialize new preferences added.
	 */
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();

		IPreferenceStore store = getPreferenceStore();
		DeployCoreMainPreferencePage.initDefaults(store);
		PrintingPreferencePage.initDefaults(store);

		// override initial default font point size to 8
		FontData fontDataArray[] = JFaceResources.getDefaultFont().getFontData();
		FontData fontData = fontDataArray[0];
		fontData.setHeight(8);
		PreferenceConverter.setDefault(store, IPreferenceConstants.PREF_DEFAULT_FONT, fontData);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.xtools.diagram.ui.internal.preferences.DiagramPreferenceInitializer#getPreferenceStore()
	 */
	protected IPreferenceStore getPreferenceStore() {
		return DeployCoreUIPlugin.getDefault().getPreferenceStore();
	}

}
