/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.validator.resolution;

import org.eclipse.osgi.util.NLS;

/**
 * @author barnold
 * 
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.core.ui.validator.resolution.messages"; //$NON-NLS-1$

	/**
	 * 
	 */
	public static String GenericDiscoverPossibleHosts;

	public static String MultiRealizationPopupDialog_Find_and_map_groups_of_Unit_;

	public static String MultiRealizationPopupDialog_Realization_Assistan_;

	public static String MultiRealizationPopupDialog_Realiz_;

	public static String MultiRealizationWizardResolutionGenerator_Open_Realization_Assistant_;

	public static String RealizationsCreatedComposite_Sourc_;

	public static String RealizationsCreatedComposite_Targe_;

	public static String RealizationsCreatedComposite_Propose_;

	public static String RealizationsCreatedComposite_Compute_;

	public static String RealizationsCreatedComposite_Manua_;

	public static String TwoStacksComposite_Conceptual_Unit_;

	public static String TwoStacksComposite_Target_;

	public static String TwoStacksComposite_All_mappings_have_been_performe_;

	public static String TwoStacksComposite_No_solutions_0_unmappable_Unit_s_;

	public static String TwoStacksComposite_0_suitable_infrastructure_Unit_s_;

	public static String TwoStacksComposite_Include_invalid_realization_;

	public static String MultiRealizationPopupDialog_No_legal_realization_;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
