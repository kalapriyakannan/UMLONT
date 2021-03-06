/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validation;

import com.ibm.ccl.soa.deploy.was.CFTargetSignificanceEnum;
import com.ibm.ccl.soa.deploy.was.ConnectionFactoryTargetTypeEnum;
import com.ibm.ccl.soa.deploy.was.ConnectionProximityEnum;
import com.ibm.ccl.soa.deploy.was.MessageReliabilityEnum;
import com.ibm.ccl.soa.deploy.was.ReadAheadOptimizationEnum;

/**
 * A sample validator interface for
 * {@link com.ibm.ccl.soa.deploy.was.WasDefaultMessagingQueueConnectionFactoryConfiguration}. This
 * doesn't really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can
 * be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WasDefaultMessagingQueueConnectionFactoryConfigurationValidator {
	boolean validate();

	boolean validateCategory(String value);

	boolean validateClientIdentifier(String value);

	boolean validateConnectionProximity(ConnectionProximityEnum value);

	boolean validateNonpersistentMessageReliability(MessageReliabilityEnum value);

	boolean validatePersistentMessageReliability(MessageReliabilityEnum value);

	boolean validateProviderEndpoints(String value);

	boolean validateReadAhead(ReadAheadOptimizationEnum value);

	boolean validateTarget(String value);

	boolean validateTargetInboundTransportChain(String value);

	boolean validateTargetSignificance(CFTargetSignificanceEnum value);

	boolean validateTargetType(ConnectionFactoryTargetTypeEnum value);

	boolean validateTempQNamePrefix(String value);
}
