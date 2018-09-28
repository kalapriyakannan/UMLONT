/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.ui.editparts;

import org.eclipse.osgi.util.NLS;

public class WASEditPartMessages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.was.ui.editparts.messages"; //$NON-NLS-1$

	public static String Was_J2c_Authentication;
	public static String Was_Jdbc_Provider;
	public static String Was_Db2_Jdbc_Provider;
	public static String Was_Derby_Jdbc_Provider;
	public static String Was_V5_Datasource;
	public static String Was_V4_Datasource;
	public static String Was_Db2_V5_Datasource;
	public static String Was_Shared_Library_Entry;
	public static String Was_Class_Loader_Policy;
	public static String Was_Default_Messageing_Connection_Factory;
	public static String Was_Default_Messageing_Queue_Connection_Factory;
	public static String Was_Default_Messageing_Topic_Connection_Factory;
	public static String Was_Default_Messageing_Queue_Destination;
	public static String Was_Default_Messageing_Topic_Destination;
	public static String Was_Default_Messageing_Jms_ActivationSpecification;
	public static String Sib_Outbound_Service;
	public static String Sib_Inbound_Service;
	public static String Sib_Outbound_Port;
	public static String Sib_Inbound_Port;
	public static String Sib_Mediation;
	public static String Sib_Destination;
	public static String Was_Endpoint_Listener;
	public static String Was_Windows_Local_Service;
	public static String Was_Unrecognized_Configuration;
	public static String Was_0_AppServer;
	public static String Was_0_1_System;
	public static String Was_Deployment_Manager;
	public static String Node_Type;
	public static String Web_Type;
	public static String Was_0_1_Node;
	public static String Was_Web_Server;
	public static String Was_0_1_Cell;
	public static String Distributed;
	public static String Standalone;
	public static String Was_Node_Group;
	public static String Was_0_Cluster;
	public static String Was_SI_Bus;
	public static String Was_Unrecognized_Unit;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, WASEditPartMessages.class);
	}

	private WASEditPartMessages() {
	}
}
