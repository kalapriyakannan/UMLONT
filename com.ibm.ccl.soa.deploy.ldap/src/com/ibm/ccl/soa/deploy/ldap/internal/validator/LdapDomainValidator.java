/***************************************************************************************************
 * LdapDomainValidator.java -- Validator for Units in the LDAP Domain
 * 
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ldap.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.internal.validator.matcher.LdapDomainMatcher;

/**
 * Validates objects in the {@link LdapPackage LDAP} deploy domain.
 */
public class LdapDomainValidator extends UnitDomainValidator {

	/**
	 * Construct an {@link LdapPackage LDAP} domain validator.
	 * 
	 */
	public LdapDomainValidator() {
		super(LdapPackage.eINSTANCE);

		addValidator(new LdapEntryUnitValidator());
		addValidator(new LdapServerUnitValidator());
		addValidator(new LdapSuffixUnitValidator());

		// Following units are currently deprecated...

		// addValidator(new LdapClientUnitValidator());
		// addValidator(new LdapLdifUnitValidator());
		// addValidator(new LdapSchemaUnitValidator());
		// addValidator(new SecurityRoleReferenceUnitValidator());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new LdapDomainMatcher();
	}
}
