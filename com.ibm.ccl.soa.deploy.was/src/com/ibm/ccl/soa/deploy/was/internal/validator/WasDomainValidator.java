/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.matcher.WasDomainMatcher;

/**
 * Validates objects in the WAS domain.
 */
public class WasDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link OsPackage} domain validator.
	 */
	public WasDomainValidator() {
		super(WasPackage.eINSTANCE);

		addValidator(new WasDatasourceUnitValidator(WasPackage.Literals.WAS_DATASOURCE_UNIT));
		addValidator(new WebsphereAppServerUnitValidator());
		addValidator(new WasLdapConfigurationUnitValidator());
		addValidator(new WasJ2CAuthenticationUnitValidator());
		addValidator(new DB2JdbcProviderUnitValidator());
		addValidator(new WasSystemUnitValidator());
		addValidator(new WasDeploymentManagerUnitValidator());
		addValidator(new WasCellUnitValidator());
		addValidator(new WasNodeUnitValidator());
		addValidator(new WasNodeGroupUnitValidator());
		addValidator(new WasClusterUnitValidator());
		addValidator(new WasNodeWindowsServiceUnitValidator());
		//addValidator(new WasSubstitutionVariableUnitValidator());
		addValidator(new WasSharedLibraryEntryUnitValidator());
		addValidator(new WasWebServerUnitValidator());

		//SIBus part
		addValidator(new WasSIBusUnitValidator());
		addValidator(new WasDefaultMessagingConnetionFactoryValidator());
		addValidator(new WasDefaultMessagingQueueConnetionFactoryValidator());
		addValidator(new WasDefaultMessagingTopicConnetionFactoryValidator());
		addValidator(new WasDefaultMessagingQueueDestinationValidator());
		addValidator(new WasDefaultMessagingTopicDestinationValidator());
		addValidator(new WasSibInboundServiceUnitValidator());
		addValidator(new WasSibOutboundServiceUnitValidator());
		addValidator(new WasSibInboundPortUnitValidator());
		addValidator(new WasSibOutboundPortUnitValidator());
		addValidator(new WasSibDestinationUnitValidator());
		addValidator(new WasSibMediationValidator());
		addValidator(new WasEndPointListenerConfigurationUnitValidator());
		addValidator(new WasJMSActivationSpecificationUnitValidator());
		addValidator(new WasMessageEngineUnitValidator());

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		super.validate(context, reporter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new WasDomainMatcher();
	}
}
