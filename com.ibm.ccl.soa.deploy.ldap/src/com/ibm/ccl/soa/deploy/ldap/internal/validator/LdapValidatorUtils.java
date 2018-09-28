/***************************************************************************************************
 * LdapValidatorUtils.java --
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

import java.util.List;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;

/**
 * Utility methods for validation.
 */
public class LdapValidatorUtils {

	private LdapValidatorUtils() {
		// prevent instantiation
	}

	protected static boolean validateDomainNames(String name1, String name2) {
		// TODO implement with compatibility check instead of equality
		return name1 == name2 || name1 != null && name1.equals(name2);
	}

//	 Some notes for ITDS 5.1:
//	 
//	The Distinguished Name (DN) syntax supported by this server is based on RFC
//	2253. The Backus Naur Form (BNF) syntax is defined as follows:
//	<name> ::= <name-component> ( <spaced-separator> ) | <name-component> <spaced-separator> <name> 
//	<spaced-separator> ::= <optional-space> <separator> <optional-space>
//	<separator> ::= "," | ";"
//	<optional-space> ::= ( <CR> ) *( " " )
//	<name-component> ::= <attribute> | <attribute> <optional-space> "+" <optional-space> <name-component>
//	<attribute> ::= <string> | <key> <optional-space> "=" <optional-space> <string>
//	<key> ::= 1*( <keychar> ) | "OID." <oid> | "oid." <oid>
//	<keychar> ::= letters, numbers, and space
//	<oid> ::= <digitstring> | <digitstring> "." <oid>
//	<digitstring> ::= 1*<digit>
//	<digit> ::= digits 0-9
//	<string> ::= *( <stringchar> | <pair> ) | '"' *( <stringchar> | <special> | <pair> ) '"' | "#" <hex>
//	<special> ::= "," | "=" | <CR> | "+" | "<" | ">" | "#" | ";"
//	<pair> ::= "\" ( <special> | "\" | ’"’)
//	<stringchar> ::= any character except <special> or '\' or '"'
//	<hex> ::= 2*<hexchar>
//	<hexchar> ::= 0-9, a-f, A-F
//	 	
	protected static boolean isValidDN(String dnString) {
		boolean retVal = true;

		try {
			new LdapName(dnString);

		} catch (InvalidNameException e) {
			retVal = false;
		}

		return retVal;

		// Java 1.4.2 version of above...
//		try {
//			new X500Principal(dnString);
//		} catch (IllegalArgumentException iae) {
//			retVal = false;
//		}
//		if (dnString.indexOf('=') < 1) {
//			retVal = false;
//		}
	}

	/**
	 * @param unit
	 * @param eClass
	 * @param eAttribute
	 * @param context
	 * @param reporter
	 */
	protected static void validateDNSyntax(Unit unit, EClass eClass, EAttribute eAttribute,
			IDeployValidationContext context, IDeployReporter reporter) {

		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(eClass);
		assert eClass.getEAllAttributes().contains(eAttribute);

		List<Capability> matchingCapsForUnit = ValidatorUtils.findCapabilities(unit, eClass);

		if (matchingCapsForUnit.size() == 0) {
			return;
		}

		Capability c = matchingCapsForUnit.get(0);
		if (c == null) {
			return;
		}

		String dn = (String) c.getEObject().eGet(eAttribute);
		if (dn == null || dn.length() == 0) {
			reporter.addStatus(DeployCoreStatusUtil
					.createObjectAttributeUndefinedStatus(c, eAttribute));
		} else if (!LdapValidatorUtils.isValidDN(dn)) {
			reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(c, eAttribute));
		}
	}
}
