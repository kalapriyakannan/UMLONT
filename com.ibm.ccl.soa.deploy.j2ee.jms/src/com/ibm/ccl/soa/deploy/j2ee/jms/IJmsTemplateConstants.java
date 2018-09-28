/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms;

/**
 * Constant file used to reference JMS resources.
 */
public interface IJmsTemplateConstants {

	/** JMS Activation Specification resource */
	public static final String JMS_ACTIVATION_SPECIFICATION = "jms.activationspecification.conceptual"; //$NON-NLS-1$;
	/** JMS Queue Connection Factory resource */
	public static final String JMS_QUEUE_CONNECTION_FACTORY = "jms.queueCF.conceptual"; //$NON-NLS-1$;
	/** JMS Queue Destination resource */
	public static final String JMS_QUEUE_DESTINATION = "jms.queueDestination.conceptual"; //$NON-NLS-1$;
	/** JMS Topic Connection Factory resource */
	public static final String JMS_TOPIC_CONNECTION_FACTORY = "jms.topicCF.conceptual"; //$NON-NLS-1$;
	/** JMS Topic Destinatioin resource */
	public static final String JMS_TOPIC_DESTINATION = "jms.topicDestination.conceptual"; //$NON-NLS-1$;
}
