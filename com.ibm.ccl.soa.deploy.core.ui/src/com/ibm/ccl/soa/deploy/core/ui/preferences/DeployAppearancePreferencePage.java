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

import org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * @since 7.0
 * 
 */
public class DeployAppearancePreferencePage extends AppearancePreferencePage {

	/**
	 * set preference store
	 */
	public DeployAppearancePreferencePage() {
		super();
		setPreferenceStore(DeployCoreUIPlugin.getDefault().getPreferenceStore());
	}

	public void createControl(Composite parent) {
		super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_EDITOR_WINDOW_PREFERENCES_COLOR_AND_FONT);

	}

}
