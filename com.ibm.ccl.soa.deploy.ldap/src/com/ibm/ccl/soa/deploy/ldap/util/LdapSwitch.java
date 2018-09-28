/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ldap.*;
import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapClient;
import com.ibm.ccl.soa.deploy.ldap.LdapClientUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot;
import com.ibm.ccl.soa.deploy.ldap.LdapLdif;
import com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSchema;
import com.ibm.ccl.soa.deploy.ldap.LdapSchemaUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.ldap.LdifArtifact;
import com.ibm.ccl.soa.deploy.ldap.SchemaArtifact;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage
 * @generated
 */
public class LdapSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static LdapPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapSwitch() {
		if (modelPackage == null) {
			modelPackage = LdapPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LdapPackage.EPERSON: {
				EPerson ePerson = (EPerson)theEObject;
				Object result = caseEPerson(ePerson);
				if (result == null) result = caseLdapAuxiliaryClass(ePerson);
				if (result == null) result = caseLdapObject(ePerson);
				if (result == null) result = caseCapability(ePerson);
				if (result == null) result = caseDeployModelObject(ePerson);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.INET_ORG_PERSON: {
				InetOrgPerson inetOrgPerson = (InetOrgPerson)theEObject;
				Object result = caseInetOrgPerson(inetOrgPerson);
				if (result == null) result = caseOrganizationalPerson(inetOrgPerson);
				if (result == null) result = casePerson(inetOrgPerson);
				if (result == null) result = caseTop(inetOrgPerson);
				if (result == null) result = caseLdapObject(inetOrgPerson);
				if (result == null) result = caseCapability(inetOrgPerson);
				if (result == null) result = caseDeployModelObject(inetOrgPerson);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_AUXILIARY_CLASS: {
				LdapAuxiliaryClass ldapAuxiliaryClass = (LdapAuxiliaryClass)theEObject;
				Object result = caseLdapAuxiliaryClass(ldapAuxiliaryClass);
				if (result == null) result = caseLdapObject(ldapAuxiliaryClass);
				if (result == null) result = caseCapability(ldapAuxiliaryClass);
				if (result == null) result = caseDeployModelObject(ldapAuxiliaryClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_CLIENT: {
				LdapClient ldapClient = (LdapClient)theEObject;
				Object result = caseLdapClient(ldapClient);
				if (result == null) result = caseCapability(ldapClient);
				if (result == null) result = caseDeployModelObject(ldapClient);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_CLIENT_UNIT: {
				LdapClientUnit ldapClientUnit = (LdapClientUnit)theEObject;
				Object result = caseLdapClientUnit(ldapClientUnit);
				if (result == null) result = caseUnit(ldapClientUnit);
				if (result == null) result = caseDeployModelObject(ldapClientUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_DEPLOY_ROOT: {
				LdapDeployRoot ldapDeployRoot = (LdapDeployRoot)theEObject;
				Object result = caseLdapDeployRoot(ldapDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_ENTRY: {
				LdapEntry ldapEntry = (LdapEntry)theEObject;
				Object result = caseLdapEntry(ldapEntry);
				if (result == null) result = caseCapability(ldapEntry);
				if (result == null) result = caseDeployModelObject(ldapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_ENTRY_UNIT: {
				LdapEntryUnit ldapEntryUnit = (LdapEntryUnit)theEObject;
				Object result = caseLdapEntryUnit(ldapEntryUnit);
				if (result == null) result = caseUnit(ldapEntryUnit);
				if (result == null) result = caseDeployModelObject(ldapEntryUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_LDIF: {
				LdapLdif ldapLdif = (LdapLdif)theEObject;
				Object result = caseLdapLdif(ldapLdif);
				if (result == null) result = caseCapability(ldapLdif);
				if (result == null) result = caseDeployModelObject(ldapLdif);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_LDIF_UNIT: {
				LdapLdifUnit ldapLdifUnit = (LdapLdifUnit)theEObject;
				Object result = caseLdapLdifUnit(ldapLdifUnit);
				if (result == null) result = caseUnit(ldapLdifUnit);
				if (result == null) result = caseDeployModelObject(ldapLdifUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_OBJECT: {
				LdapObject ldapObject = (LdapObject)theEObject;
				Object result = caseLdapObject(ldapObject);
				if (result == null) result = caseCapability(ldapObject);
				if (result == null) result = caseDeployModelObject(ldapObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_SCHEMA: {
				LdapSchema ldapSchema = (LdapSchema)theEObject;
				Object result = caseLdapSchema(ldapSchema);
				if (result == null) result = caseCapability(ldapSchema);
				if (result == null) result = caseDeployModelObject(ldapSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_SCHEMA_UNIT: {
				LdapSchemaUnit ldapSchemaUnit = (LdapSchemaUnit)theEObject;
				Object result = caseLdapSchemaUnit(ldapSchemaUnit);
				if (result == null) result = caseUnit(ldapSchemaUnit);
				if (result == null) result = caseDeployModelObject(ldapSchemaUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_SERVER: {
				LdapServer ldapServer = (LdapServer)theEObject;
				Object result = caseLdapServer(ldapServer);
				if (result == null) result = caseCapability(ldapServer);
				if (result == null) result = caseDeployModelObject(ldapServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_SERVER_UNIT: {
				LdapServerUnit ldapServerUnit = (LdapServerUnit)theEObject;
				Object result = caseLdapServerUnit(ldapServerUnit);
				if (result == null) result = caseUnit(ldapServerUnit);
				if (result == null) result = caseDeployModelObject(ldapServerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_SUFFIX: {
				LdapSuffix ldapSuffix = (LdapSuffix)theEObject;
				Object result = caseLdapSuffix(ldapSuffix);
				if (result == null) result = caseCapability(ldapSuffix);
				if (result == null) result = caseDeployModelObject(ldapSuffix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDAP_SUFFIX_UNIT: {
				LdapSuffixUnit ldapSuffixUnit = (LdapSuffixUnit)theEObject;
				Object result = caseLdapSuffixUnit(ldapSuffixUnit);
				if (result == null) result = caseUnit(ldapSuffixUnit);
				if (result == null) result = caseDeployModelObject(ldapSuffixUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.LDIF_ARTIFACT: {
				LdifArtifact ldifArtifact = (LdifArtifact)theEObject;
				Object result = caseLdifArtifact(ldifArtifact);
				if (result == null) result = caseFileArtifact(ldifArtifact);
				if (result == null) result = caseArtifact(ldifArtifact);
				if (result == null) result = caseDeployModelObject(ldifArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.ORGANIZATION: {
				Organization organization = (Organization)theEObject;
				Object result = caseOrganization(organization);
				if (result == null) result = caseTop(organization);
				if (result == null) result = caseLdapObject(organization);
				if (result == null) result = caseCapability(organization);
				if (result == null) result = caseDeployModelObject(organization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.ORGANIZATIONAL_PERSON: {
				OrganizationalPerson organizationalPerson = (OrganizationalPerson)theEObject;
				Object result = caseOrganizationalPerson(organizationalPerson);
				if (result == null) result = casePerson(organizationalPerson);
				if (result == null) result = caseTop(organizationalPerson);
				if (result == null) result = caseLdapObject(organizationalPerson);
				if (result == null) result = caseCapability(organizationalPerson);
				if (result == null) result = caseDeployModelObject(organizationalPerson);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.PERSON: {
				Person person = (Person)theEObject;
				Object result = casePerson(person);
				if (result == null) result = caseTop(person);
				if (result == null) result = caseLdapObject(person);
				if (result == null) result = caseCapability(person);
				if (result == null) result = caseDeployModelObject(person);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.SCHEMA_ARTIFACT: {
				SchemaArtifact schemaArtifact = (SchemaArtifact)theEObject;
				Object result = caseSchemaArtifact(schemaArtifact);
				if (result == null) result = caseFileArtifact(schemaArtifact);
				if (result == null) result = caseArtifact(schemaArtifact);
				if (result == null) result = caseDeployModelObject(schemaArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.SECURITY_ROLE_REFERENCE_UNIT: {
				SecurityRoleReferenceUnit securityRoleReferenceUnit = (SecurityRoleReferenceUnit)theEObject;
				Object result = caseSecurityRoleReferenceUnit(securityRoleReferenceUnit);
				if (result == null) result = caseUnit(securityRoleReferenceUnit);
				if (result == null) result = caseDeployModelObject(securityRoleReferenceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LdapPackage.TOP: {
				Top top = (Top)theEObject;
				Object result = caseTop(top);
				if (result == null) result = caseLdapObject(top);
				if (result == null) result = caseCapability(top);
				if (result == null) result = caseDeployModelObject(top);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPerson</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPerson</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEPerson(EPerson object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inet Org Person</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inet Org Person</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInetOrgPerson(InetOrgPerson object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Auxiliary Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Auxiliary Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapAuxiliaryClass(LdapAuxiliaryClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Client</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Client</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapClient(LdapClient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapClientUnit(LdapClientUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapDeployRoot(LdapDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapEntry(LdapEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapEntryUnit(LdapEntryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Ldif</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Ldif</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapLdif(LdapLdif object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ldif Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ldif Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapLdifUnit(LdapLdifUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapObject(LdapObject object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Schema</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapSchema(LdapSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schema Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schema Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapSchemaUnit(LdapSchemaUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapServer(LdapServer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapServerUnit(LdapServerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Suffix</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Suffix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapSuffix(LdapSuffix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Suffix Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Suffix Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdapSuffixUnit(LdapSuffixUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ldif Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ldif Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLdifArtifact(LdifArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrganization(Organization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organizational Person</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organizational Person</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrganizationalPerson(OrganizationalPerson object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Person</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Person</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePerson(Person object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schema Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schema Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSchemaArtifact(SchemaArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Role Reference Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Role Reference Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSecurityRoleReferenceUnit(SecurityRoleReferenceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTop(Top object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Artifact</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArtifact(Artifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileArtifact(FileArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //LdapSwitch
