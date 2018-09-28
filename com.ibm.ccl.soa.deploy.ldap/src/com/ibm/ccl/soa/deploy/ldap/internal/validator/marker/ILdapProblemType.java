/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.internal.validator.marker;

import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.ldap.LdapDeployPlugin;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;

/**
 * Defines the deploy model marker problem types for the LDAP domain.
 * 
 * @see LdapPackage
 * @see IDeployMarker#PROBLEM_TYPE
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface ILdapProblemType {

	 /** LDAP_ENTRY_HAS_NO_STRUCTURAL_CAPS = {@value} */
	public static final String LDAP_ENTRY_HAS_NO_STRUCTURAL_CAPS = LdapDeployPlugin.PLUGIN_ID
			+ ".ldapEntryNoStructuralCaps"; //$NON-NLS-1$

	 /** LDAP_ENTRY_HAS_MULTI_STRUCTURAL_CAPS = {@value} */
	public static final String LDAP_ENTRY_HAS_MULTI_STRUCTURAL_CAPS = LdapDeployPlugin.PLUGIN_ID
			+ ".ldapEntryMultiStructuralCaps"; //$NON-NLS-1$

	 /** LDAP_ENTRY_MISSING_REQD_ATTR = {@value} */
	public static final String LDAP_ENTRY_MISSING_REQD_ATTR = LdapDeployPlugin.PLUGIN_ID
			+ ".ldapEntryMissingReqdAttr"; //$NON-NLS-1$

	 /** LDAP_ENTRY_MISSING_OPT_ATTR = {@value} */
	public static final String LDAP_ENTRY_MISSING_OPT_ATTR = LdapDeployPlugin.PLUGIN_ID
			+ ".ldapEntryMissingOptAttr"; //$NON-NLS-1$

	 /** EA_PROHIBITED_BY_LDAP_SCHEMA = {@value} */
	public static final String EA_PROHIBITED_BY_LDAP_SCHEMA = LdapDeployPlugin.PLUGIN_ID
			+ ".eaProhibitedByLDAPSchema"; //$NON-NLS-1$

	 /** EA_MUST_HAVE_A_VALUE = {@value} */
	public static final String EA_MUST_HAVE_A_VALUE = LdapDeployPlugin.PLUGIN_ID
			+ ".eaMustHaveValue"; //$NON-NLS-1$

	 /** EA_NOT_PART_OF_SCHEMA = {@value} */
	public static final String EA_NOT_PART_OF_SCHEMA = LdapDeployPlugin.PLUGIN_ID
			+ ".eaNotPartOfSchema"; //$NON-NLS-1$

//	/**
//	 * The {@link DeployModelObject} attribute is not set.
//	 */
//	public static final String OBJECT_ATTRIBUTE_UNDEFINED = DeployCorePlugin.PLUGIN_ID
//			+ ".objectAttributeUndefined"; //$NON-NLS-1$

	/**
	 * The database unit has no provoded databases.
	 */
	public static final String LDAP_DATABASE_NOT_UNIQUELY_HOSTED = "com.ibm.ccl.soa.deploy.ldap" //$NON-NLS-1$
			// LdapDeployPlugin.PLUGIN_ID 
			+ ".databaseNotUniquelyHosted"; //$NON-NLS-1$

}
