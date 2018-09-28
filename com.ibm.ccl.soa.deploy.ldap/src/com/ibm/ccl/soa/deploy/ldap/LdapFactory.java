/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage
 * @generated
 */
public interface LdapFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	LdapFactory eINSTANCE = com.ibm.ccl.soa.deploy.ldap.impl.LdapFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EPerson</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EPerson</em>'.
	 * @generated
	 */
	EPerson createEPerson();

	/**
	 * Returns a new object of class '<em>Inet Org Person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inet Org Person</em>'.
	 * @generated
	 */
	InetOrgPerson createInetOrgPerson();

	/**
	 * Returns a new object of class '<em>Client</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Client</em>'.
	 * @generated
	 */
	LdapClient createLdapClient();

	/**
	 * Returns a new object of class '<em>Client Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Client Unit</em>'.
	 * @generated
	 */
	LdapClientUnit createLdapClientUnit();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	LdapDeployRoot createLdapDeployRoot();

	/**
	 * Returns a new object of class '<em>Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry</em>'.
	 * @generated
	 */
	LdapEntry createLdapEntry();

	/**
	 * Returns a new object of class '<em>Entry Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Unit</em>'.
	 * @generated
	 */
	LdapEntryUnit createLdapEntryUnit();

	/**
	 * Returns a new object of class '<em>Ldif</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Ldif</em>'.
	 * @generated
	 */
	LdapLdif createLdapLdif();

	/**
	 * Returns a new object of class '<em>Ldif Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ldif Unit</em>'.
	 * @generated
	 */
	LdapLdifUnit createLdapLdifUnit();

	/**
	 * Returns a new object of class '<em>Schema</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Schema</em>'.
	 * @generated
	 */
	LdapSchema createLdapSchema();

	/**
	 * Returns a new object of class '<em>Schema Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Schema Unit</em>'.
	 * @generated
	 */
	LdapSchemaUnit createLdapSchemaUnit();

	/**
	 * Returns a new object of class '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	LdapServer createLdapServer();

	/**
	 * Returns a new object of class '<em>Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Unit</em>'.
	 * @generated
	 */
	LdapServerUnit createLdapServerUnit();

	/**
	 * Returns a new object of class '<em>Suffix</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Suffix</em>'.
	 * @generated
	 */
	LdapSuffix createLdapSuffix();

	/**
	 * Returns a new object of class '<em>Suffix Unit</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Suffix Unit</em>'.
	 * @generated
	 */
	LdapSuffixUnit createLdapSuffixUnit();

	/**
	 * Returns a new object of class '<em>Ldif Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Ldif Artifact</em>'.
	 * @generated
	 */
	LdifArtifact createLdifArtifact();

	/**
	 * Returns a new object of class '<em>Organization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Organization</em>'.
	 * @generated
	 */
	Organization createOrganization();

	/**
	 * Returns a new object of class '<em>Organizational Person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Organizational Person</em>'.
	 * @generated
	 */
	OrganizationalPerson createOrganizationalPerson();

	/**
	 * Returns a new object of class '<em>Person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person</em>'.
	 * @generated
	 */
	Person createPerson();

	/**
	 * Returns a new object of class '<em>Schema Artifact</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Schema Artifact</em>'.
	 * @generated
	 */
	SchemaArtifact createSchemaArtifact();

	/**
	 * Returns a new object of class '<em>Security Role Reference Unit</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Role Reference Unit</em>'.
	 * @generated
	 */
	SecurityRoleReferenceUnit createSecurityRoleReferenceUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LdapPackage getLdapPackage();

} //LdapFactory
