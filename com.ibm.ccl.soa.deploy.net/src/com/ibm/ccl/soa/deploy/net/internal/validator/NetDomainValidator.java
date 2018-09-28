/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.net.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.net.internal.validator.matcher.NetDomainMatcher;

/**
 * Validates objects in the {@link NetPackage} deploy domain.
 */
public class NetDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link NetPackage} domain validator.
	 */
	public NetDomainValidator() {
		super(NetPackage.eINSTANCE);
		
		addValidator(new IpInterfaceUnitValidator());
		addValidator(new L2InterfaceUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	@Override
	protected DomainMatcher createDomainMatcher() {
		return new NetDomainMatcher();
	}
}
