/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.impl;

import com.ibm.ccl.soa.deploy.ldap.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapClient;
import com.ibm.ccl.soa.deploy.ldap.LdapClientUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapLdif;
import com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSchema;
import com.ibm.ccl.soa.deploy.ldap.LdapSchemaUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.LdifAction;
import com.ibm.ccl.soa.deploy.ldap.LdifArtifact;
import com.ibm.ccl.soa.deploy.ldap.SchemaAction;
import com.ibm.ccl.soa.deploy.ldap.SchemaArtifact;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class LdapFactoryImpl extends EFactoryImpl implements LdapFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static LdapFactory init() {
		try {
			LdapFactory theLdapFactory = (LdapFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/ldap/1.0.0/"); //$NON-NLS-1$ 
			if (theLdapFactory != null) {
				return theLdapFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LdapFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LdapPackage.EPERSON: return createEPerson();
			case LdapPackage.INET_ORG_PERSON: return createInetOrgPerson();
			case LdapPackage.LDAP_CLIENT: return createLdapClient();
			case LdapPackage.LDAP_CLIENT_UNIT: return createLdapClientUnit();
			case LdapPackage.LDAP_DEPLOY_ROOT: return (EObject)createLdapDeployRoot();
			case LdapPackage.LDAP_ENTRY: return createLdapEntry();
			case LdapPackage.LDAP_ENTRY_UNIT: return createLdapEntryUnit();
			case LdapPackage.LDAP_LDIF: return createLdapLdif();
			case LdapPackage.LDAP_LDIF_UNIT: return createLdapLdifUnit();
			case LdapPackage.LDAP_SCHEMA: return createLdapSchema();
			case LdapPackage.LDAP_SCHEMA_UNIT: return createLdapSchemaUnit();
			case LdapPackage.LDAP_SERVER: return createLdapServer();
			case LdapPackage.LDAP_SERVER_UNIT: return createLdapServerUnit();
			case LdapPackage.LDAP_SUFFIX: return createLdapSuffix();
			case LdapPackage.LDAP_SUFFIX_UNIT: return createLdapSuffixUnit();
			case LdapPackage.LDIF_ARTIFACT: return createLdifArtifact();
			case LdapPackage.ORGANIZATION: return createOrganization();
			case LdapPackage.ORGANIZATIONAL_PERSON: return createOrganizationalPerson();
			case LdapPackage.PERSON: return createPerson();
			case LdapPackage.SCHEMA_ARTIFACT: return createSchemaArtifact();
			case LdapPackage.SECURITY_ROLE_REFERENCE_UNIT: return createSecurityRoleReferenceUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case LdapPackage.LDIF_ACTION:
				return createLdifActionFromString(eDataType, initialValue);
			case LdapPackage.SCHEMA_ACTION:
				return createSchemaActionFromString(eDataType, initialValue);
			case LdapPackage.LDIF_ACTION_OBJECT:
				return createLdifActionObjectFromString(eDataType, initialValue);
			case LdapPackage.SCHEMA_ACTION_OBJECT:
				return createSchemaActionObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case LdapPackage.LDIF_ACTION:
				return convertLdifActionToString(eDataType, instanceValue);
			case LdapPackage.SCHEMA_ACTION:
				return convertSchemaActionToString(eDataType, instanceValue);
			case LdapPackage.LDIF_ACTION_OBJECT:
				return convertLdifActionObjectToString(eDataType, instanceValue);
			case LdapPackage.SCHEMA_ACTION_OBJECT:
				return convertSchemaActionObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPerson createEPerson() {
		EPersonImpl ePerson = new EPersonImpl();
		return ePerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InetOrgPerson createInetOrgPerson() {
		InetOrgPersonImpl inetOrgPerson = new InetOrgPersonImpl();
		return inetOrgPerson;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapClient createLdapClient() {
		LdapClientImpl ldapClient = new LdapClientImpl();
		return ldapClient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapClientUnit createLdapClientUnit() {
		LdapClientUnitImpl ldapClientUnit = new LdapClientUnitImpl();
		return ldapClientUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapDeployRoot createLdapDeployRoot() {
		LdapDeployRootImpl ldapDeployRoot = new LdapDeployRootImpl();
		return ldapDeployRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapEntry createLdapEntry() {
		LdapEntryImpl ldapEntry = new LdapEntryImpl();
		return ldapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapEntryUnit createLdapEntryUnit() {
		LdapEntryUnitImpl ldapEntryUnit = new LdapEntryUnitImpl();
		return ldapEntryUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapLdif createLdapLdif() {
		LdapLdifImpl ldapLdif = new LdapLdifImpl();
		return ldapLdif;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapLdifUnit createLdapLdifUnit() {
		LdapLdifUnitImpl ldapLdifUnit = new LdapLdifUnitImpl();
		return ldapLdifUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSchema createLdapSchema() {
		LdapSchemaImpl ldapSchema = new LdapSchemaImpl();
		return ldapSchema;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSchemaUnit createLdapSchemaUnit() {
		LdapSchemaUnitImpl ldapSchemaUnit = new LdapSchemaUnitImpl();
		return ldapSchemaUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapServer createLdapServer() {
		LdapServerImpl ldapServer = new LdapServerImpl();
		return ldapServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdapServerUnit createLdapServerUnit() {
		LdapServerUnitImpl ldapServerUnit = new LdapServerUnitImpl();
		return ldapServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSuffix createLdapSuffix() {
		LdapSuffixImpl ldapSuffix = new LdapSuffixImpl();
		return ldapSuffix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSuffixUnit createLdapSuffixUnit() {
		LdapSuffixUnitImpl ldapSuffixUnit = new LdapSuffixUnitImpl();
		return ldapSuffixUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdifArtifact createLdifArtifact() {
		LdifArtifactImpl ldifArtifact = new LdifArtifactImpl();
		return ldifArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization createOrganization() {
		OrganizationImpl organization = new OrganizationImpl();
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationalPerson createOrganizationalPerson() {
		OrganizationalPersonImpl organizationalPerson = new OrganizationalPersonImpl();
		return organizationalPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaArtifact createSchemaArtifact() {
		SchemaArtifactImpl schemaArtifact = new SchemaArtifactImpl();
		return schemaArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityRoleReferenceUnit createSecurityRoleReferenceUnit() {
		SecurityRoleReferenceUnitImpl securityRoleReferenceUnit = new SecurityRoleReferenceUnitImpl();
		return securityRoleReferenceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdifAction createLdifActionFromString(EDataType eDataType, String initialValue) {
		LdifAction result = LdifAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLdifActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaAction createSchemaActionFromString(EDataType eDataType, String initialValue) {
		SchemaAction result = SchemaAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchemaActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdifAction createLdifActionObjectFromString(EDataType eDataType, String initialValue) {
		return createLdifActionFromString(LdapPackage.Literals.LDIF_ACTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLdifActionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLdifActionToString(LdapPackage.Literals.LDIF_ACTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaAction createSchemaActionObjectFromString(EDataType eDataType, String initialValue) {
		return createSchemaActionFromString(LdapPackage.Literals.SCHEMA_ACTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchemaActionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertSchemaActionToString(LdapPackage.Literals.SCHEMA_ACTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapPackage getLdapPackage() {
		return (LdapPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static LdapPackage getPackage() {
		return LdapPackage.eINSTANCE;
	}

} //LdapFactoryImpl
