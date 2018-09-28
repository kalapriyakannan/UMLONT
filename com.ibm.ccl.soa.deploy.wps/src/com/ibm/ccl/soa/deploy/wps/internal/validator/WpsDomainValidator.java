/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.wps.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;
import com.ibm.ccl.soa.deploy.wps.internal.validator.matcher.WpsDomainMatcher;

/**
 * Validates objects in the {@link WpsPackage} deploy domain.
 */
public class WpsDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link WpsPackage} domain validator.
	 */
	public WpsDomainValidator() {
		super(WpsPackage.eINSTANCE);
		
		addValidator(new BPEContainerUnitValidator());
		addValidator(new BusinessRulesManagerUnitValidator());
		addValidator(new ESBUnitValidator());
		addValidator(new SIBUnitValidator());
		addValidator(new TaskContainerUnitValidator());
		addValidator(new WpsBaseSystemUnitValidator());
		addValidator(new WPSCommonEventInfrastructureUnitValidator());
		addValidator(new WpsSystemUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new WpsDomainMatcher();
	}
}
