/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.ldap.EPerson;
import com.ibm.ccl.soa.deploy.ldap.InetOrgPerson;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapClient;
import com.ibm.ccl.soa.deploy.ldap.LdapClientUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot;
import com.ibm.ccl.soa.deploy.ldap.LdapEntry;
import com.ibm.ccl.soa.deploy.ldap.LdapEntryUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapLdif;
import com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSchema;
import com.ibm.ccl.soa.deploy.ldap.LdapSchemaUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.LdifArtifact;
import com.ibm.ccl.soa.deploy.ldap.Organization;
import com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson;
import com.ibm.ccl.soa.deploy.ldap.Person;
import com.ibm.ccl.soa.deploy.ldap.SchemaArtifact;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getCapabilityLdapClient <em>Capability Ldap Client</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getCapabilityLdapEntry <em>Capability Ldap Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getCapabilityLdapLdif <em>Capability Ldap Ldif</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getCapabilityLdapSchema <em>Capability Ldap Schema</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getCapabilityLdapServer <em>Capability Ldap Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getCapabilityLdapSuffix <em>Capability Ldap Suffix</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapEPerson <em>Ldap EPerson</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapInetOrgPerson <em>Ldap Inet Org Person</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapOrganization <em>Ldap Organization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapOrganizationalPerson <em>Ldap Organizational Person</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapPerson <em>Ldap Person</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapEntryUnit <em>Ldap Entry Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapServerUnit <em>Ldap Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getLdapSuffixUnit <em>Ldap Suffix Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getUnitLdapClientUnit <em>Unit Ldap Client Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getUnitLdapLdifUnit <em>Unit Ldap Ldif Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getUnitLdapRoleReference <em>Unit Ldap Role Reference</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getUnitLdapSchemaUnit <em>Unit Ldap Schema Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getUnitLdifArtifact <em>Unit Ldif Artifact</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl#getUnitSchemaArtifact <em>Unit Schema Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LdapDeployRootImpl extends EObjectImpl implements LdapDeployRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LdapDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LdapPackage.Literals.LDAP_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, LdapPackage.LDAP_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, LdapPackage.LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, LdapPackage.LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapClient getCapabilityLdapClient() {
		return (LdapClient)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLdapClient(LdapClient newCapabilityLdapClient,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT, newCapabilityLdapClient, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLdapClient(LdapClient newCapabilityLdapClient) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT, newCapabilityLdapClient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapEntry getCapabilityLdapEntry() {
		return (LdapEntry)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLdapEntry(LdapEntry newCapabilityLdapEntry, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY, newCapabilityLdapEntry, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLdapEntry(LdapEntry newCapabilityLdapEntry) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY, newCapabilityLdapEntry);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapLdif getCapabilityLdapLdif() {
		return (LdapLdif)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLdapLdif(LdapLdif newCapabilityLdapLdif,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF, newCapabilityLdapLdif, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLdapLdif(LdapLdif newCapabilityLdapLdif) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF, newCapabilityLdapLdif);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSchema getCapabilityLdapSchema() {
		return (LdapSchema)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLdapSchema(LdapSchema newCapabilityLdapSchema,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA, newCapabilityLdapSchema, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLdapSchema(LdapSchema newCapabilityLdapSchema) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA, newCapabilityLdapSchema);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapServer getCapabilityLdapServer() {
		return (LdapServer)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLdapServer(LdapServer newCapabilityLdapServer, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER, newCapabilityLdapServer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLdapServer(LdapServer newCapabilityLdapServer) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER, newCapabilityLdapServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSuffix getCapabilityLdapSuffix() {
		return (LdapSuffix)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityLdapSuffix(LdapSuffix newCapabilityLdapSuffix,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX, newCapabilityLdapSuffix, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityLdapSuffix(LdapSuffix newCapabilityLdapSuffix) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX, newCapabilityLdapSuffix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPerson getLdapEPerson() {
		return (EPerson)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapEPerson(EPerson newLdapEPerson, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON, newLdapEPerson, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapEPerson(EPerson newLdapEPerson) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_EPERSON, newLdapEPerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InetOrgPerson getLdapInetOrgPerson() {
		return (InetOrgPerson)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapInetOrgPerson(InetOrgPerson newLdapInetOrgPerson, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON, newLdapInetOrgPerson, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapInetOrgPerson(InetOrgPerson newLdapInetOrgPerson) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON, newLdapInetOrgPerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization getLdapOrganization() {
		return (Organization)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapOrganization(Organization newLdapOrganization, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION, newLdapOrganization, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapOrganization(Organization newLdapOrganization) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION, newLdapOrganization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationalPerson getLdapOrganizationalPerson() {
		return (OrganizationalPerson)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapOrganizationalPerson(OrganizationalPerson newLdapOrganizationalPerson, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON, newLdapOrganizationalPerson, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapOrganizationalPerson(OrganizationalPerson newLdapOrganizationalPerson) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON, newLdapOrganizationalPerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person getLdapPerson() {
		return (Person)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapPerson(Person newLdapPerson, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON, newLdapPerson, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapPerson(Person newLdapPerson) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_PERSON, newLdapPerson);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapEntryUnit getLdapEntryUnit() {
		return (LdapEntryUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapEntryUnit(LdapEntryUnit newLdapEntryUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT, newLdapEntryUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapEntryUnit(LdapEntryUnit newLdapEntryUnit) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT, newLdapEntryUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapServerUnit getLdapServerUnit() {
		return (LdapServerUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapServerUnit(LdapServerUnit newLdapServerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT, newLdapServerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapServerUnit(LdapServerUnit newLdapServerUnit) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT, newLdapServerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSuffixUnit getLdapSuffixUnit() {
		return (LdapSuffixUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLdapSuffixUnit(LdapSuffixUnit newLdapSuffixUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT, newLdapSuffixUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLdapSuffixUnit(LdapSuffixUnit newLdapSuffixUnit) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT, newLdapSuffixUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapClientUnit getUnitLdapClientUnit() {
		return (LdapClientUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLdapClientUnit(LdapClientUnit newUnitLdapClientUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT, newUnitLdapClientUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLdapClientUnit(LdapClientUnit newUnitLdapClientUnit) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT, newUnitLdapClientUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapLdifUnit getUnitLdapLdifUnit() {
		return (LdapLdifUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLdapLdifUnit(LdapLdifUnit newUnitLdapLdifUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT, newUnitLdapLdifUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLdapLdifUnit(LdapLdifUnit newUnitLdapLdifUnit) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT, newUnitLdapLdifUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityRoleReferenceUnit getUnitLdapRoleReference() {
		return (SecurityRoleReferenceUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLdapRoleReference(
			SecurityRoleReferenceUnit newUnitLdapRoleReference, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE, newUnitLdapRoleReference, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLdapRoleReference(SecurityRoleReferenceUnit newUnitLdapRoleReference) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE, newUnitLdapRoleReference);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSchemaUnit getUnitLdapSchemaUnit() {
		return (LdapSchemaUnit)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLdapSchemaUnit(LdapSchemaUnit newUnitLdapSchemaUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT, newUnitLdapSchemaUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLdapSchemaUnit(LdapSchemaUnit newUnitLdapSchemaUnit) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT, newUnitLdapSchemaUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdifArtifact getUnitLdifArtifact() {
		return (LdifArtifact)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLdifArtifact(LdifArtifact newUnitLdifArtifact,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT, newUnitLdifArtifact, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLdifArtifact(LdifArtifact newUnitLdifArtifact) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT, newUnitLdifArtifact);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaArtifact getUnitSchemaArtifact() {
		return (SchemaArtifact)getMixed().get(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSchemaArtifact(SchemaArtifact newUnitSchemaArtifact,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT, newUnitSchemaArtifact, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSchemaArtifact(SchemaArtifact newUnitSchemaArtifact) {
		((FeatureMap.Internal)getMixed()).set(LdapPackage.Literals.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT, newUnitSchemaArtifact);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case LdapPackage.LDAP_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT:
				return basicSetCapabilityLdapClient(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY:
				return basicSetCapabilityLdapEntry(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF:
				return basicSetCapabilityLdapLdif(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA:
				return basicSetCapabilityLdapSchema(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER:
				return basicSetCapabilityLdapServer(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX:
				return basicSetCapabilityLdapSuffix(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_EPERSON:
				return basicSetLdapEPerson(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON:
				return basicSetLdapInetOrgPerson(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION:
				return basicSetLdapOrganization(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON:
				return basicSetLdapOrganizationalPerson(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_PERSON:
				return basicSetLdapPerson(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT:
				return basicSetLdapEntryUnit(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT:
				return basicSetLdapServerUnit(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT:
				return basicSetLdapSuffixUnit(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT:
				return basicSetUnitLdapClientUnit(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT:
				return basicSetUnitLdapLdifUnit(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE:
				return basicSetUnitLdapRoleReference(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT:
				return basicSetUnitLdapSchemaUnit(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT:
				return basicSetUnitLdifArtifact(null, msgs);
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT:
				return basicSetUnitSchemaArtifact(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LdapPackage.LDAP_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case LdapPackage.LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case LdapPackage.LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT:
				return getCapabilityLdapClient();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY:
				return getCapabilityLdapEntry();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF:
				return getCapabilityLdapLdif();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA:
				return getCapabilityLdapSchema();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER:
				return getCapabilityLdapServer();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX:
				return getCapabilityLdapSuffix();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_EPERSON:
				return getLdapEPerson();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON:
				return getLdapInetOrgPerson();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION:
				return getLdapOrganization();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON:
				return getLdapOrganizationalPerson();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_PERSON:
				return getLdapPerson();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT:
				return getLdapEntryUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT:
				return getLdapServerUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT:
				return getLdapSuffixUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT:
				return getUnitLdapClientUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT:
				return getUnitLdapLdifUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE:
				return getUnitLdapRoleReference();
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT:
				return getUnitLdapSchemaUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT:
				return getUnitLdifArtifact();
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT:
				return getUnitSchemaArtifact();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LdapPackage.LDAP_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT:
				setCapabilityLdapClient((LdapClient)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY:
				setCapabilityLdapEntry((LdapEntry)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF:
				setCapabilityLdapLdif((LdapLdif)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA:
				setCapabilityLdapSchema((LdapSchema)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER:
				setCapabilityLdapServer((LdapServer)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX:
				setCapabilityLdapSuffix((LdapSuffix)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_EPERSON:
				setLdapEPerson((EPerson)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON:
				setLdapInetOrgPerson((InetOrgPerson)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION:
				setLdapOrganization((Organization)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON:
				setLdapOrganizationalPerson((OrganizationalPerson)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_PERSON:
				setLdapPerson((Person)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT:
				setLdapEntryUnit((LdapEntryUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT:
				setLdapServerUnit((LdapServerUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT:
				setLdapSuffixUnit((LdapSuffixUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT:
				setUnitLdapClientUnit((LdapClientUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT:
				setUnitLdapLdifUnit((LdapLdifUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE:
				setUnitLdapRoleReference((SecurityRoleReferenceUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT:
				setUnitLdapSchemaUnit((LdapSchemaUnit)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT:
				setUnitLdifArtifact((LdifArtifact)newValue);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT:
				setUnitSchemaArtifact((SchemaArtifact)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case LdapPackage.LDAP_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT:
				setCapabilityLdapClient((LdapClient)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY:
				setCapabilityLdapEntry((LdapEntry)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF:
				setCapabilityLdapLdif((LdapLdif)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA:
				setCapabilityLdapSchema((LdapSchema)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER:
				setCapabilityLdapServer((LdapServer)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX:
				setCapabilityLdapSuffix((LdapSuffix)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_EPERSON:
				setLdapEPerson((EPerson)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON:
				setLdapInetOrgPerson((InetOrgPerson)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION:
				setLdapOrganization((Organization)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON:
				setLdapOrganizationalPerson((OrganizationalPerson)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_PERSON:
				setLdapPerson((Person)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT:
				setLdapEntryUnit((LdapEntryUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT:
				setLdapServerUnit((LdapServerUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT:
				setLdapSuffixUnit((LdapSuffixUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT:
				setUnitLdapClientUnit((LdapClientUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT:
				setUnitLdapLdifUnit((LdapLdifUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE:
				setUnitLdapRoleReference((SecurityRoleReferenceUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT:
				setUnitLdapSchemaUnit((LdapSchemaUnit)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT:
				setUnitLdifArtifact((LdifArtifact)null);
				return;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT:
				setUnitSchemaArtifact((SchemaArtifact)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LdapPackage.LDAP_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case LdapPackage.LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case LdapPackage.LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT:
				return getCapabilityLdapClient() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY:
				return getCapabilityLdapEntry() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF:
				return getCapabilityLdapLdif() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA:
				return getCapabilityLdapSchema() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER:
				return getCapabilityLdapServer() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX:
				return getCapabilityLdapSuffix() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_EPERSON:
				return getLdapEPerson() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON:
				return getLdapInetOrgPerson() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION:
				return getLdapOrganization() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON:
				return getLdapOrganizationalPerson() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_PERSON:
				return getLdapPerson() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT:
				return getLdapEntryUnit() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT:
				return getLdapServerUnit() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT:
				return getLdapSuffixUnit() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT:
				return getUnitLdapClientUnit() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT:
				return getUnitLdapLdifUnit() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE:
				return getUnitLdapRoleReference() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT:
				return getUnitLdapSchemaUnit() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT:
				return getUnitLdifArtifact() != null;
			case LdapPackage.LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT:
				return getUnitSchemaArtifact() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //LdapDeployRootImpl
