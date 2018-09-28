/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal;

import org.eclipse.osgi.util.NLS;

public class AnalysisMessages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.analysis.internal.messages"; //$NON-NLS-1$
	public static String DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT;
	public static String LOCATIONUNIT_SHOULD_HAVE_ONE_NODEUNIT;
	public static String NODE_VALIDATE_LOCATION_COMMUNICATION;
	public static String REQUIRED_AVAILABILITY_TITLE;
	public static String EXPECTED_LIFESPAN_TITLE;
	public static String DAILY_LOAD_CONSTRAINT;
	public static String PEAK_LOAD_CONSTRAINT;
	public static String EXPECTED_VOLUME_CONSTRAINT;
	public static String DATA_SERVICE_CONSTRAINT;
	public static String EXECUTION_SERVICE_CONSTRAINT;
	public static String RESPONSE_TIME_CONSTRAINT;
	public static String SIZE_PER_SUBMISSION_CONSTRAINT;
	public static String USAGE_WINDOW_PER_DAY_CONSTRAINT;
	
	public static String LOCATION_APPLICATION_COMMUNICATION_CONTEXT;
	
	
	

	static {
		NLS.initializeMessages(BUNDLE_NAME, AnalysisMessages.class);
	}

}
