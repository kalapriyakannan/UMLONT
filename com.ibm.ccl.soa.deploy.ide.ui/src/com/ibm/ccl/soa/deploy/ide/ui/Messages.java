/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ide.ui.messages";//$NON-NLS-1$
	public static String WIZ_EDIT_RUNTIME_WIZARD_TITLE;
	public static String WIZ_NEW_RUNTIME_WIZARD_TITLE;
	public static String APPLICATION_SERVERS;
	public static String APPLICATION_SERVER_LABEL;
	public static String DIALOG_RUNTIME_TITLE;
	public static String DIALOG_RUNTIME_IN_USE;
	public static String DELETE_RUNTIME_MENU_TITLE;
	public static String NEW_RUNTIME_MENU_TITLE;
	public static String EDIT_RUNTIME_MENU_TITLE;
	public static String REFRESH_RUNTIMES_MENU_TITLE;
	public static String DELETE_RUNTIME_MENU_TOOLTIP;
	public static String EDIT_RUNTIME_MENU_TOOLTIP;
	public static String REFRESH_RUNTIMES_MENU_TOOLTIP;
	public static String NEW_RUNTIME_MENU_TOOLTIP;


	public static String TOPOLOGY_CREATION_WIZARD_DEPLOYABLE_PAGE_DESC;
	public static String TOPOLOGY_CREATION_WIZARD_DEPLOYABLE_PAGE_TITLE;
	public static String TOPOLOGY_CREATION_WIZARD_OPTIONS_PAGE_DESC;
	public static String TOPOLOGY_CREATION_WIZARD_OPTIONS_PAGE_TITLE;
	public static String DISCOVER_HOST_LABEL;
	public static String DISCOVER_DEPENDENCIES_LABEL;

	public static String AssetDiscoveryWizard_AssetDiscover_;
	public static String DatasourceResolutionWizard_DatasourceResolution_;

	public static String DatasourceResolutionWizard_Wizard_Page0_Title;
	public static String DatasourceResolutionWizard_Wizard_Page0_Description;
	public static String DatasourceResolutionWizard_Wizard_Page0_DatSourceReq_Label;
	public static String DatasourceResolutionWizard_Wizard_Page1_Title;
	public static String DatasourceResolutionWizard_Wizard_Page1_Description;
	public static String DatasourceResolutionWizard_Wizard_Page1_Connection_Label;
	public static String DatasourceResolutionWizard_Wizard_Page1_New_Connection_Button_Label;
	public static String DatasourceResolutionOperation_Connection_Not_Found;

	public static String DatasourceResolutionWizardPage1_reConnec_;

	public static String DatasourceResolutionProvider_Please_press_the_Reconnect_button_f_;

	public static String PublishReportView_Unit_Publisher_Processes_;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
