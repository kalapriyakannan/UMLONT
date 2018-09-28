/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.extension;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for DeployCore.
 * 
 * @since 1.0
 * 
 */
public class DeployIdeMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.ide.extension.messages"; //$NON-NLS-1$

	/** */
	public static String UnitPublisherDescriptor_Exactly_one_enablement_element_is;
	/** */
	public static String UnitPublisherDescriptor_An_instance_of_UnitPublisher_is_required;
	/** */
	public static String IDEUnitPublisher_No_unit_publisher_found_for_unit;
	/** */
	public static String IDEUnitPublisher_Duplicate_host_instance_identifier;
	/** */
	public static String DataToolUnitPublisher_DDL_Module_URI_not_set;
	/** */
	public static String DataToolUnitPublisher_Connection_Exception;
	/** */
	public static String DataToolUnitPublisher_SQL_Contents_Exception;
	/** */
	public static String ServerToolUnitPublisher_Module_URI_not_set;
	/** */
	public static String ServerToolUnitPublisher_Module_type_not_set;
	/** */
	public static String ServerToolUnitPublisher_Server_module_could_not_be_found;

	public static String AssetDiscoveryProvider_Please_select_a_Deployabl_;

	public static String DiscoveredAssetManager_Discovery_is_in_progres_;

	///////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, DeployIdeMessages.class);
	}

}
