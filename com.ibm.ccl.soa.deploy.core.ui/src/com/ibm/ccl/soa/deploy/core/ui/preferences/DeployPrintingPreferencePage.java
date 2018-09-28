package com.ibm.ccl.soa.deploy.core.ui.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * The printing preference page used for the Modeling preferences.
 */
public class DeployPrintingPreferencePage extends PrintingPreferencePage {

	/**
	 * Creates a new instance and initializes the preference store.
	 */
	public DeployPrintingPreferencePage() {
		super(DeployCoreUIPlugin.getDefault().getPreferenceStore());
	}

	/**
	 * @param store
	 */
	public DeployPrintingPreferencePage(IPreferenceStore store) {
		super(store);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
//				IDeployHelpContextIds.TOPOLOGY_EDITOR_PRINTING_PREFERENCE_PAGE_HELPID);
		return super.createContents(parent);
	}

}
