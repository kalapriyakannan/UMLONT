/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapClient <em>Capability Ldap Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapEntry <em>Capability Ldap Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapLdif <em>Capability Ldap Ldif</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSchema <em>Capability Ldap Schema</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapServer <em>Capability Ldap Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSuffix <em>Capability Ldap Suffix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEPerson <em>Ldap EPerson</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapInetOrgPerson <em>Ldap Inet Org Person</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganization <em>Ldap Organization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganizationalPerson <em>Ldap Organizational Person</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapPerson <em>Ldap Person</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEntryUnit <em>Ldap Entry Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapServerUnit <em>Ldap Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapSuffixUnit <em>Ldap Suffix Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapClientUnit <em>Unit Ldap Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapLdifUnit <em>Unit Ldap Ldif Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapRoleReference <em>Unit Ldap Role Reference</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapSchemaUnit <em>Unit Ldap Schema Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdifArtifact <em>Unit Ldif Artifact</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitSchemaArtifact <em>Unit Schema Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface LdapDeployRoot {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Ldap Client</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability LdapServer Client</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ldap Client</em>' containment reference.
	 * @see #setCapabilityLdapClient(LdapClient)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_CapabilityLdapClient()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ldapClient' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LdapClient getCapabilityLdapClient();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapClient <em>Capability Ldap Client</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ldap Client</em>' containment reference.
	 * @see #getCapabilityLdapClient()
	 * @generated
	 */
	void setCapabilityLdapClient(LdapClient value);

	/**
	 * Returns the value of the '<em><b>Capability Ldap Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ldap Entry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ldap Entry</em>' containment reference.
	 * @see #setCapabilityLdapEntry(LdapEntry)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_CapabilityLdapEntry()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ldapEntry' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LdapEntry getCapabilityLdapEntry();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapEntry <em>Capability Ldap Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ldap Entry</em>' containment reference.
	 * @see #getCapabilityLdapEntry()
	 * @generated
	 */
	void setCapabilityLdapEntry(LdapEntry value);

	/**
	 * Returns the value of the '<em><b>Capability Ldap Ldif</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability LdapServer Ldif</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ldap Ldif</em>' containment reference.
	 * @see #setCapabilityLdapLdif(LdapLdif)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_CapabilityLdapLdif()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ldapLdif' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LdapLdif getCapabilityLdapLdif();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapLdif <em>Capability Ldap Ldif</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ldap Ldif</em>' containment reference.
	 * @see #getCapabilityLdapLdif()
	 * @generated
	 */
	void setCapabilityLdapLdif(LdapLdif value);

	/**
	 * Returns the value of the '<em><b>Capability Ldap Schema</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability LdapServer Schema</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ldap Schema</em>' containment reference.
	 * @see #setCapabilityLdapSchema(LdapSchema)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_CapabilityLdapSchema()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ldapSchema' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LdapSchema getCapabilityLdapSchema();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSchema <em>Capability Ldap Schema</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ldap Schema</em>' containment reference.
	 * @see #getCapabilityLdapSchema()
	 * @generated
	 */
	void setCapabilityLdapSchema(LdapSchema value);

	/**
	 * Returns the value of the '<em><b>Capability Ldap Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ldap Server</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ldap Server</em>' containment reference.
	 * @see #setCapabilityLdapServer(LdapServer)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_CapabilityLdapServer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ldapServer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LdapServer getCapabilityLdapServer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapServer <em>Capability Ldap Server</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ldap Server</em>' containment reference.
	 * @see #getCapabilityLdapServer()
	 * @generated
	 */
	void setCapabilityLdapServer(LdapServer value);

	/**
	 * Returns the value of the '<em><b>Capability Ldap Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability LdapServer Suffix</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ldap Suffix</em>' containment reference.
	 * @see #setCapabilityLdapSuffix(LdapSuffix)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_CapabilityLdapSuffix()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ldapSuffix' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LdapSuffix getCapabilityLdapSuffix();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSuffix <em>Capability Ldap Suffix</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ldap Suffix</em>' containment reference.
	 * @see #getCapabilityLdapSuffix()
	 * @generated
	 */
	void setCapabilityLdapSuffix(LdapSuffix value);

	/**
	 * Returns the value of the '<em><b>Ldap EPerson</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap EPerson</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap EPerson</em>' containment reference.
	 * @see #setLdapEPerson(EPerson)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapEPerson()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldap.ePerson' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	EPerson getLdapEPerson();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEPerson <em>Ldap EPerson</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap EPerson</em>' containment reference.
	 * @see #getLdapEPerson()
	 * @generated
	 */
	void setLdapEPerson(EPerson value);

	/**
	 * Returns the value of the '<em><b>Ldap Inet Org Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Inet Org Person</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Inet Org Person</em>' containment reference.
	 * @see #setLdapInetOrgPerson(InetOrgPerson)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapInetOrgPerson()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldap.inetOrgPerson' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	InetOrgPerson getLdapInetOrgPerson();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapInetOrgPerson <em>Ldap Inet Org Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Inet Org Person</em>' containment reference.
	 * @see #getLdapInetOrgPerson()
	 * @generated
	 */
	void setLdapInetOrgPerson(InetOrgPerson value);

	/**
	 * Returns the value of the '<em><b>Ldap Organization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Organization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Organization</em>' containment reference.
	 * @see #setLdapOrganization(Organization)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapOrganization()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldap.organization' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Organization getLdapOrganization();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganization <em>Ldap Organization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Organization</em>' containment reference.
	 * @see #getLdapOrganization()
	 * @generated
	 */
	void setLdapOrganization(Organization value);

	/**
	 * Returns the value of the '<em><b>Ldap Organizational Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Organizational Person</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Organizational Person</em>' containment reference.
	 * @see #setLdapOrganizationalPerson(OrganizationalPerson)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapOrganizationalPerson()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldap.organizationalPerson' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	OrganizationalPerson getLdapOrganizationalPerson();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganizationalPerson <em>Ldap Organizational Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Organizational Person</em>' containment reference.
	 * @see #getLdapOrganizationalPerson()
	 * @generated
	 */
	void setLdapOrganizationalPerson(OrganizationalPerson value);

	/**
	 * Returns the value of the '<em><b>Ldap Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Person</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Person</em>' containment reference.
	 * @see #setLdapPerson(Person)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapPerson()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldap.person' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Person getLdapPerson();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapPerson <em>Ldap Person</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Person</em>' containment reference.
	 * @see #getLdapPerson()
	 * @generated
	 */
	void setLdapPerson(Person value);

	/**
	 * Returns the value of the '<em><b>Ldap Entry Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Entry Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Entry Unit</em>' containment reference.
	 * @see #setLdapEntryUnit(LdapEntryUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapEntryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldapEntryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LdapEntryUnit getLdapEntryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEntryUnit <em>Ldap Entry Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Entry Unit</em>' containment reference.
	 * @see #getLdapEntryUnit()
	 * @generated
	 */
	void setLdapEntryUnit(LdapEntryUnit value);

	/**
	 * Returns the value of the '<em><b>Ldap Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Server Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Server Unit</em>' containment reference.
	 * @see #setLdapServerUnit(LdapServerUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapServerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldapServerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LdapServerUnit getLdapServerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapServerUnit <em>Ldap Server Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Server Unit</em>' containment reference.
	 * @see #getLdapServerUnit()
	 * @generated
	 */
	void setLdapServerUnit(LdapServerUnit value);

	/**
	 * Returns the value of the '<em><b>Ldap Suffix Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ldap Suffix Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ldap Suffix Unit</em>' containment reference.
	 * @see #setLdapSuffixUnit(LdapSuffixUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_LdapSuffixUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ldapSuffixUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LdapSuffixUnit getLdapSuffixUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapSuffixUnit <em>Ldap Suffix Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ldap Suffix Unit</em>' containment reference.
	 * @see #getLdapSuffixUnit()
	 * @generated
	 */
	void setLdapSuffixUnit(LdapSuffixUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ldap Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit LdapServer Client Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ldap Client Unit</em>' containment reference.
	 * @see #setUnitLdapClientUnit(LdapClientUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_UnitLdapClientUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ldapClientUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LdapClientUnit getUnitLdapClientUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapClientUnit <em>Unit Ldap Client Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ldap Client Unit</em>' containment reference.
	 * @see #getUnitLdapClientUnit()
	 * @generated
	 */
	void setUnitLdapClientUnit(LdapClientUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ldap Ldif Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit LdapServer Ldif Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ldap Ldif Unit</em>' containment reference.
	 * @see #setUnitLdapLdifUnit(LdapLdifUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_UnitLdapLdifUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ldapLdifUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LdapLdifUnit getUnitLdapLdifUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapLdifUnit <em>Unit Ldap Ldif Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ldap Ldif Unit</em>' containment reference.
	 * @see #getUnitLdapLdifUnit()
	 * @generated
	 */
	void setUnitLdapLdifUnit(LdapLdifUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ldap Role Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit LdapServer Role Reference</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ldap Role Reference</em>' containment reference.
	 * @see #setUnitLdapRoleReference(SecurityRoleReferenceUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_UnitLdapRoleReference()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ldapRoleReference' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SecurityRoleReferenceUnit getUnitLdapRoleReference();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapRoleReference <em>Unit Ldap Role Reference</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ldap Role Reference</em>' containment reference.
	 * @see #getUnitLdapRoleReference()
	 * @generated
	 */
	void setUnitLdapRoleReference(SecurityRoleReferenceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ldap Schema Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit LdapServer Schema Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ldap Schema Unit</em>' containment reference.
	 * @see #setUnitLdapSchemaUnit(LdapSchemaUnit)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_UnitLdapSchemaUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ldapSchemaUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LdapSchemaUnit getUnitLdapSchemaUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapSchemaUnit <em>Unit Ldap Schema Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ldap Schema Unit</em>' containment reference.
	 * @see #getUnitLdapSchemaUnit()
	 * @generated
	 */
	void setUnitLdapSchemaUnit(LdapSchemaUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Ldif Artifact</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ldif Artifact</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit Ldif Artifact</em>' containment reference.
	 * @see #setUnitLdifArtifact(LdifArtifact)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_UnitLdifArtifact()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ldifArtifact' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	LdifArtifact getUnitLdifArtifact();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdifArtifact <em>Unit Ldif Artifact</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ldif Artifact</em>' containment reference.
	 * @see #getUnitLdifArtifact()
	 * @generated
	 */
	void setUnitLdifArtifact(LdifArtifact value);

	/**
	 * Returns the value of the '<em><b>Unit Schema Artifact</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Schema Artifact</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Schema Artifact</em>' containment reference.
	 * @see #setUnitSchemaArtifact(SchemaArtifact)
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#getLdapDeployRoot_UnitSchemaArtifact()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.schemaArtifact' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	SchemaArtifact getUnitSchemaArtifact();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitSchemaArtifact <em>Unit Schema Artifact</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Schema Artifact</em>' containment reference.
	 * @see #getUnitSchemaArtifact()
	 * @generated
	 */
	void setUnitSchemaArtifact(SchemaArtifact value);

} // LdapDeployRoot
