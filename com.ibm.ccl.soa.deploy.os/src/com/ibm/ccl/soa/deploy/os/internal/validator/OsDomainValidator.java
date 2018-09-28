/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.internal.validator.matcher.OsDomainMatcher;

/**
 * Validates objects in the {@link OsPackage} deploy domain.
 */
public class OsDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link OsPackage} domain validator.
	 */
	public OsDomainValidator() {
		super(OsPackage.eINSTANCE);

		addValidator(new OperatingSystemUnitValidator());
		addValidator(new WindowsOperatingSystemUnitValidator());
		addValidator(new LinuxOperatingSystemUnitValidator());
		addValidator(new AIXOperatingSystemUnitValidator());

		addValidator(new UserUnitValidator());
		addValidator(new WindowsLocalUserUnitValidator());
		addValidator(new LinuxLocalUserUnitValidator());
		addValidator(new AIXLocalUserUnitValidator());

		addValidator(new UserGroupUnitValidator());
		addValidator(new WindowsLocalGroupUnitValidator());
		addValidator(new LinuxLocalGroupUnitValidator());
		addValidator(new AIXLocalGroupUnitValidator());

		addValidator(new WindowsLocalServiceUnitValidator());
		addValidator(new LinuxLocalServiceUnitValidator());
		addValidator(new AIXLocalServiceUnitValidator());

		addValidator(new PortConfigUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	@Override
	protected DomainMatcher createDomainMatcher() {
		return new OsDomainMatcher();
	}
}
