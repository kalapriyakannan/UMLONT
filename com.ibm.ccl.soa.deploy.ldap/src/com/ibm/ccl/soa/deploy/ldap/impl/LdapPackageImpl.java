/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.ldap.EPerson;
import com.ibm.ccl.soa.deploy.ldap.InetOrgPerson;
import com.ibm.ccl.soa.deploy.ldap.LdapAuxiliaryClass;
import com.ibm.ccl.soa.deploy.ldap.LdapObject;
import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapClient;
import com.ibm.ccl.soa.deploy.ldap.LdapClientUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot;
import com.ibm.ccl.soa.deploy.ldap.LdapEntry;
import com.ibm.ccl.soa.deploy.ldap.LdapEntryUnit;
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
import com.ibm.ccl.soa.deploy.ldap.Organization;
import com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson;
import com.ibm.ccl.soa.deploy.ldap.Person;
import com.ibm.ccl.soa.deploy.ldap.SchemaAction;
import com.ibm.ccl.soa.deploy.ldap.SchemaArtifact;
import com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit;
import com.ibm.ccl.soa.deploy.ldap.Top;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class LdapPackageImpl extends EPackageImpl implements LdapPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ePersonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inetOrgPersonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapAuxiliaryClassEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapClientEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapClientUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapEntryUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapLdifEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapLdifUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapObjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapSchemaEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapSchemaUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapServerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapServerUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapSuffixEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldapSuffixUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldifArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationalPersonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schemaArtifactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityRoleReferenceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ldifActionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum schemaActionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ldifActionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType schemaActionObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LdapPackageImpl() {
		super(eNS_URI, LdapFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LdapPackage init() {
		if (isInited) return (LdapPackage)EPackage.Registry.INSTANCE.getEPackage(LdapPackage.eNS_URI);

		// Obtain or create and register package
		LdapPackageImpl theLdapPackage = (LdapPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof LdapPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new LdapPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLdapPackage.createPackageContents();

		// Initialize created meta-data
		theLdapPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLdapPackage.freeze();

		return theLdapPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPerson() {
		return ePersonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_AccessHint() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_AccountHint() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Audio() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_BusinessCategory() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_C() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_CarLicense() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Cn() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_ConfigPtr() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_DepartmentNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_DestinationIndicator() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_EmployeeNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_EmployeeType() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_FacsimileTelephoneNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_GenerationQualifier() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_GivenName() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_HomeFax() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_HomePhone() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_HomePostalAddress() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Initials() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_InternationalISDNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_JpegPhoto() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_L() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_LabeledURI() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Mail() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Manager() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_MiddleName() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Mobile() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_O() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_OrganizationalStatus() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_OtherMailbox() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Ou() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Pager() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PersonalTitle() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Photo() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PhysicalDeliveryOfficeName() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PostalAddress() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PostalCode() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PostOfficebox() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PreferredDeliveryMethod() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_PreferredLanguage() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_RegisteredAddress() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_RoomNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Secretary() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_SeeAlso() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Sn() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_St() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Street() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_TelephoneNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_TeletexTerminalIdentifier() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_TelexNumber() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_ThumbnailLogo() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_ThumbnailPhoto() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Title() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_Uid() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_UniqueIdentifier() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_UserCertificate() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_UserPassword() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_UserPKCS12() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_UserSMIMECertificate() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_X121Address() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPerson_X500UniqueIdentifier() {
		return (EAttribute)ePersonEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInetOrgPerson() {
		return inetOrgPersonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_AccessHint() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_AccountHint() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Audio() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_BusinessCategory() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_C() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_CarLicense() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_ConfigPtr() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_DepartmentNumber() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_EmployeeNumber() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_EmployeeType() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_GenerationQualifier() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_GivenName() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_HomeFax() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_HomePhone() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_HomePostalAddress() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Initials() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_JpegPhoto() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_LabeledURI() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Mail() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Manager() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_MiddleName() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Mobile() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_O() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_OrganizationalStatus() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_OtherMailbox() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Pager() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_PersonalTitle() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Photo() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_PreferredLanguage() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_RoomNumber() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Secretary() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_ThumbnailLogo() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_ThumbnailPhoto() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_Uid() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_UniqueIdentifier() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_UserCertificate() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_UserPKCS12() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_UserSMIMECertificate() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInetOrgPerson_X500UniqueIdentifier() {
		return (EAttribute)inetOrgPersonEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapAuxiliaryClass() {
		return ldapAuxiliaryClassEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapClient() {
		return ldapClientEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapClientUnit() {
		return ldapClientUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapDeployRoot() {
		return ldapDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapDeployRoot_Mixed() {
		return (EAttribute)ldapDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_XMLNSPrefixMap() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_XSISchemaLocation() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_CapabilityLdapClient() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_CapabilityLdapEntry() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_CapabilityLdapLdif() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_CapabilityLdapSchema() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_CapabilityLdapServer() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_CapabilityLdapSuffix() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapEPerson() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapInetOrgPerson() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapOrganization() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapOrganizationalPerson() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapPerson() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapEntryUnit() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapServerUnit() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_LdapSuffixUnit() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_UnitLdapClientUnit() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_UnitLdapLdifUnit() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_UnitLdapRoleReference() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_UnitLdapSchemaUnit() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_UnitLdifArtifact() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdapDeployRoot_UnitSchemaArtifact() {
		return (EReference)ldapDeployRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapEntry() {
		return ldapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapEntry_RelativeDN() {
		return (EAttribute)ldapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapEntryUnit() {
		return ldapEntryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapLdif() {
		return ldapLdifEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapLdif_Action() {
		return (EAttribute)ldapLdifEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapLdif_SubtreeDn() {
		return (EAttribute)ldapLdifEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapLdifUnit() {
		return ldapLdifUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapObject() {
		return ldapObjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapSchema() {
		return ldapSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapSchema_Action() {
		return (EAttribute)ldapSchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapSchemaUnit() {
		return ldapSchemaUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapServer() {
		return ldapServerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapServer_AdministratorDN() {
		return (EAttribute)ldapServerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapServer_AdministratorPassword() {
		return (EAttribute)ldapServerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapServerUnit() {
		return ldapServerUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapSuffix() {
		return ldapSuffixEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdapSuffix_SuffixDN() {
		return (EAttribute)ldapSuffixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdapSuffixUnit() {
		return ldapSuffixUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdifArtifact() {
		return ldifArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganization() {
		return organizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_BusinessCategory() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_Description1() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_DestinationIndicator() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_FacsimileTelephoneNumber() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_InternationalISDNNumber() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_L() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_O() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_PhysicalDeliveryOfficeName() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_PostalAddress() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_PostalCode() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_PostOfficeBox() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_PreferredDeliveryMethod() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_RegisteredAddress() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_SearchGuide() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_SeeAlso() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_St() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_Street() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TelephoneNumber() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TeletexTerminalIdentifier() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_TelexNumber() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_UserPassword() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganization_X121address() {
		return (EAttribute)organizationEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationalPerson() {
		return organizationalPersonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_DestinationIndicator() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_FacsimileTelephoneNumber() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_InternationalISDNNumber() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_L() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_Ou() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_PhysicalDeliveryOfficeName() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_PostalAddress() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_PostalCode() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_PostOfficeBox() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_PreferredDeliveryMethod() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_RegisteredAddress() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_St() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_Street() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_TeletexTerminalIdentifier() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_TelexNumber() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_Title() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrganizationalPerson_X121address() {
		return (EAttribute)organizationalPersonEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Cn() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SeeAlso() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Sn() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_TelephoneNumber() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_UserPassword() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchemaArtifact() {
		return schemaArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityRoleReferenceUnit() {
		return securityRoleReferenceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTop() {
		return topEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLdifAction() {
		return ldifActionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSchemaAction() {
		return schemaActionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLdifActionObject() {
		return ldifActionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSchemaActionObject() {
		return schemaActionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapFactory getLdapFactory() {
		return (LdapFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ePersonEClass = createEClass(EPERSON);
		createEAttribute(ePersonEClass, EPERSON__ACCESS_HINT);
		createEAttribute(ePersonEClass, EPERSON__ACCOUNT_HINT);
		createEAttribute(ePersonEClass, EPERSON__AUDIO);
		createEAttribute(ePersonEClass, EPERSON__BUSINESS_CATEGORY);
		createEAttribute(ePersonEClass, EPERSON__C);
		createEAttribute(ePersonEClass, EPERSON__CAR_LICENSE);
		createEAttribute(ePersonEClass, EPERSON__CN);
		createEAttribute(ePersonEClass, EPERSON__CONFIG_PTR);
		createEAttribute(ePersonEClass, EPERSON__DEPARTMENT_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__DESTINATION_INDICATOR);
		createEAttribute(ePersonEClass, EPERSON__EMPLOYEE_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__EMPLOYEE_TYPE);
		createEAttribute(ePersonEClass, EPERSON__FACSIMILE_TELEPHONE_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__GENERATION_QUALIFIER);
		createEAttribute(ePersonEClass, EPERSON__GIVEN_NAME);
		createEAttribute(ePersonEClass, EPERSON__HOME_FAX);
		createEAttribute(ePersonEClass, EPERSON__HOME_PHONE);
		createEAttribute(ePersonEClass, EPERSON__HOME_POSTAL_ADDRESS);
		createEAttribute(ePersonEClass, EPERSON__INITIALS);
		createEAttribute(ePersonEClass, EPERSON__INTERNATIONAL_ISD_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__JPEG_PHOTO);
		createEAttribute(ePersonEClass, EPERSON__L);
		createEAttribute(ePersonEClass, EPERSON__LABELED_URI);
		createEAttribute(ePersonEClass, EPERSON__MAIL);
		createEAttribute(ePersonEClass, EPERSON__MANAGER);
		createEAttribute(ePersonEClass, EPERSON__MIDDLE_NAME);
		createEAttribute(ePersonEClass, EPERSON__MOBILE);
		createEAttribute(ePersonEClass, EPERSON__O);
		createEAttribute(ePersonEClass, EPERSON__ORGANIZATIONAL_STATUS);
		createEAttribute(ePersonEClass, EPERSON__OTHER_MAILBOX);
		createEAttribute(ePersonEClass, EPERSON__OU);
		createEAttribute(ePersonEClass, EPERSON__PAGER);
		createEAttribute(ePersonEClass, EPERSON__PERSONAL_TITLE);
		createEAttribute(ePersonEClass, EPERSON__PHOTO);
		createEAttribute(ePersonEClass, EPERSON__PHYSICAL_DELIVERY_OFFICE_NAME);
		createEAttribute(ePersonEClass, EPERSON__POSTAL_ADDRESS);
		createEAttribute(ePersonEClass, EPERSON__POSTAL_CODE);
		createEAttribute(ePersonEClass, EPERSON__POST_OFFICEBOX);
		createEAttribute(ePersonEClass, EPERSON__PREFERRED_DELIVERY_METHOD);
		createEAttribute(ePersonEClass, EPERSON__PREFERRED_LANGUAGE);
		createEAttribute(ePersonEClass, EPERSON__REGISTERED_ADDRESS);
		createEAttribute(ePersonEClass, EPERSON__ROOM_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__SECRETARY);
		createEAttribute(ePersonEClass, EPERSON__SEE_ALSO);
		createEAttribute(ePersonEClass, EPERSON__SN);
		createEAttribute(ePersonEClass, EPERSON__ST);
		createEAttribute(ePersonEClass, EPERSON__STREET);
		createEAttribute(ePersonEClass, EPERSON__TELEPHONE_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__TELETEX_TERMINAL_IDENTIFIER);
		createEAttribute(ePersonEClass, EPERSON__TELEX_NUMBER);
		createEAttribute(ePersonEClass, EPERSON__THUMBNAIL_LOGO);
		createEAttribute(ePersonEClass, EPERSON__THUMBNAIL_PHOTO);
		createEAttribute(ePersonEClass, EPERSON__TITLE);
		createEAttribute(ePersonEClass, EPERSON__UID);
		createEAttribute(ePersonEClass, EPERSON__UNIQUE_IDENTIFIER);
		createEAttribute(ePersonEClass, EPERSON__USER_CERTIFICATE);
		createEAttribute(ePersonEClass, EPERSON__USER_PASSWORD);
		createEAttribute(ePersonEClass, EPERSON__USER_PKCS12);
		createEAttribute(ePersonEClass, EPERSON__USER_SMIME_CERTIFICATE);
		createEAttribute(ePersonEClass, EPERSON__X121_ADDRESS);
		createEAttribute(ePersonEClass, EPERSON__X500_UNIQUE_IDENTIFIER);

		inetOrgPersonEClass = createEClass(INET_ORG_PERSON);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__ACCESS_HINT);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__ACCOUNT_HINT);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__AUDIO);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__BUSINESS_CATEGORY);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__C);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__CAR_LICENSE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__CONFIG_PTR);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__DEPARTMENT_NUMBER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__EMPLOYEE_NUMBER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__EMPLOYEE_TYPE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__GENERATION_QUALIFIER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__GIVEN_NAME);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__HOME_FAX);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__HOME_PHONE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__HOME_POSTAL_ADDRESS);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__INITIALS);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__JPEG_PHOTO);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__LABELED_URI);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__MAIL);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__MANAGER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__MIDDLE_NAME);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__MOBILE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__O);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__ORGANIZATIONAL_STATUS);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__OTHER_MAILBOX);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__PAGER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__PERSONAL_TITLE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__PHOTO);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__PREFERRED_LANGUAGE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__ROOM_NUMBER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__SECRETARY);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__THUMBNAIL_LOGO);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__THUMBNAIL_PHOTO);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__UID);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__UNIQUE_IDENTIFIER);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__USER_CERTIFICATE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__USER_PKCS12);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__USER_SMIME_CERTIFICATE);
		createEAttribute(inetOrgPersonEClass, INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER);

		ldapAuxiliaryClassEClass = createEClass(LDAP_AUXILIARY_CLASS);

		ldapClientEClass = createEClass(LDAP_CLIENT);

		ldapClientUnitEClass = createEClass(LDAP_CLIENT_UNIT);

		ldapDeployRootEClass = createEClass(LDAP_DEPLOY_ROOT);
		createEAttribute(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__MIXED);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_EPERSON);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_PERSON);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT);
		createEReference(ldapDeployRootEClass, LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT);

		ldapEntryEClass = createEClass(LDAP_ENTRY);
		createEAttribute(ldapEntryEClass, LDAP_ENTRY__RELATIVE_DN);

		ldapEntryUnitEClass = createEClass(LDAP_ENTRY_UNIT);

		ldapLdifEClass = createEClass(LDAP_LDIF);
		createEAttribute(ldapLdifEClass, LDAP_LDIF__ACTION);
		createEAttribute(ldapLdifEClass, LDAP_LDIF__SUBTREE_DN);

		ldapLdifUnitEClass = createEClass(LDAP_LDIF_UNIT);

		ldapObjectEClass = createEClass(LDAP_OBJECT);

		ldapSchemaEClass = createEClass(LDAP_SCHEMA);
		createEAttribute(ldapSchemaEClass, LDAP_SCHEMA__ACTION);

		ldapSchemaUnitEClass = createEClass(LDAP_SCHEMA_UNIT);

		ldapServerEClass = createEClass(LDAP_SERVER);
		createEAttribute(ldapServerEClass, LDAP_SERVER__ADMINISTRATOR_DN);
		createEAttribute(ldapServerEClass, LDAP_SERVER__ADMINISTRATOR_PASSWORD);

		ldapServerUnitEClass = createEClass(LDAP_SERVER_UNIT);

		ldapSuffixEClass = createEClass(LDAP_SUFFIX);
		createEAttribute(ldapSuffixEClass, LDAP_SUFFIX__SUFFIX_DN);

		ldapSuffixUnitEClass = createEClass(LDAP_SUFFIX_UNIT);

		ldifArtifactEClass = createEClass(LDIF_ARTIFACT);

		organizationEClass = createEClass(ORGANIZATION);
		createEAttribute(organizationEClass, ORGANIZATION__BUSINESS_CATEGORY);
		createEAttribute(organizationEClass, ORGANIZATION__DESCRIPTION1);
		createEAttribute(organizationEClass, ORGANIZATION__DESTINATION_INDICATOR);
		createEAttribute(organizationEClass, ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER);
		createEAttribute(organizationEClass, ORGANIZATION__INTERNATIONAL_ISDN_NUMBER);
		createEAttribute(organizationEClass, ORGANIZATION__L);
		createEAttribute(organizationEClass, ORGANIZATION__O);
		createEAttribute(organizationEClass, ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME);
		createEAttribute(organizationEClass, ORGANIZATION__POSTAL_ADDRESS);
		createEAttribute(organizationEClass, ORGANIZATION__POSTAL_CODE);
		createEAttribute(organizationEClass, ORGANIZATION__POST_OFFICE_BOX);
		createEAttribute(organizationEClass, ORGANIZATION__PREFERRED_DELIVERY_METHOD);
		createEAttribute(organizationEClass, ORGANIZATION__REGISTERED_ADDRESS);
		createEAttribute(organizationEClass, ORGANIZATION__SEARCH_GUIDE);
		createEAttribute(organizationEClass, ORGANIZATION__SEE_ALSO);
		createEAttribute(organizationEClass, ORGANIZATION__ST);
		createEAttribute(organizationEClass, ORGANIZATION__STREET);
		createEAttribute(organizationEClass, ORGANIZATION__TELEPHONE_NUMBER);
		createEAttribute(organizationEClass, ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER);
		createEAttribute(organizationEClass, ORGANIZATION__TELEX_NUMBER);
		createEAttribute(organizationEClass, ORGANIZATION__USER_PASSWORD);
		createEAttribute(organizationEClass, ORGANIZATION__X121ADDRESS);

		organizationalPersonEClass = createEClass(ORGANIZATIONAL_PERSON);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__L);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__OU);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__POSTAL_ADDRESS);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__POSTAL_CODE);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__POST_OFFICE_BOX);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__ST);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__STREET);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__TELEX_NUMBER);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__TITLE);
		createEAttribute(organizationalPersonEClass, ORGANIZATIONAL_PERSON__X121ADDRESS);

		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__CN);
		createEAttribute(personEClass, PERSON__SEE_ALSO);
		createEAttribute(personEClass, PERSON__SN);
		createEAttribute(personEClass, PERSON__TELEPHONE_NUMBER);
		createEAttribute(personEClass, PERSON__USER_PASSWORD);

		schemaArtifactEClass = createEClass(SCHEMA_ARTIFACT);

		securityRoleReferenceUnitEClass = createEClass(SECURITY_ROLE_REFERENCE_UNIT);

		topEClass = createEClass(TOP);

		// Create enums
		ldifActionEEnum = createEEnum(LDIF_ACTION);
		schemaActionEEnum = createEEnum(SCHEMA_ACTION);

		// Create data types
		ldifActionObjectEDataType = createEDataType(LDIF_ACTION_OBJECT);
		schemaActionObjectEDataType = createEDataType(SCHEMA_ACTION_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Add supertypes to classes
		ePersonEClass.getESuperTypes().add(this.getLdapAuxiliaryClass());
		inetOrgPersonEClass.getESuperTypes().add(this.getOrganizationalPerson());
		ldapAuxiliaryClassEClass.getESuperTypes().add(this.getLdapObject());
		ldapClientEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapClientUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ldapEntryEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapEntryUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ldapLdifEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapLdifUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ldapObjectEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapSchemaEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapSchemaUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ldapServerEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapServerUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ldapSuffixEClass.getESuperTypes().add(theCorePackage.getCapability());
		ldapSuffixUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		ldifArtifactEClass.getESuperTypes().add(theCorePackage.getFileArtifact());
		organizationEClass.getESuperTypes().add(this.getTop());
		organizationalPersonEClass.getESuperTypes().add(this.getPerson());
		personEClass.getESuperTypes().add(this.getTop());
		schemaArtifactEClass.getESuperTypes().add(theCorePackage.getFileArtifact());
		securityRoleReferenceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		topEClass.getESuperTypes().add(this.getLdapObject());

		// Initialize classes and features; add operations and parameters
		initEClass(ePersonEClass, EPerson.class, "EPerson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEPerson_AccessHint(), theXMLTypePackage.getString(), "accessHint", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_AccountHint(), theXMLTypePackage.getString(), "accountHint", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Audio(), theXMLTypePackage.getString(), "audio", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_BusinessCategory(), theXMLTypePackage.getString(), "businessCategory", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_C(), theXMLTypePackage.getString(), "c", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_CarLicense(), theXMLTypePackage.getString(), "carLicense", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Cn(), theXMLTypePackage.getString(), "cn", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_ConfigPtr(), theXMLTypePackage.getString(), "configPtr", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_DepartmentNumber(), theXMLTypePackage.getString(), "departmentNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_DestinationIndicator(), theXMLTypePackage.getString(), "destinationIndicator", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_EmployeeNumber(), theXMLTypePackage.getString(), "employeeNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_EmployeeType(), theXMLTypePackage.getString(), "employeeType", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_FacsimileTelephoneNumber(), theXMLTypePackage.getString(), "facsimileTelephoneNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_GenerationQualifier(), theXMLTypePackage.getString(), "generationQualifier", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_GivenName(), theXMLTypePackage.getString(), "givenName", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_HomeFax(), theXMLTypePackage.getString(), "homeFax", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_HomePhone(), theXMLTypePackage.getString(), "homePhone", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_HomePostalAddress(), theXMLTypePackage.getString(), "homePostalAddress", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Initials(), theXMLTypePackage.getString(), "initials", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_InternationalISDNumber(), theXMLTypePackage.getString(), "internationalISDNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_JpegPhoto(), theXMLTypePackage.getString(), "jpegPhoto", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_L(), theXMLTypePackage.getString(), "l", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_LabeledURI(), theXMLTypePackage.getString(), "labeledURI", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Mail(), theXMLTypePackage.getString(), "mail", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Manager(), theXMLTypePackage.getString(), "manager", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_MiddleName(), theXMLTypePackage.getString(), "middleName", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Mobile(), theXMLTypePackage.getString(), "mobile", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_O(), theXMLTypePackage.getString(), "o", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_OrganizationalStatus(), theXMLTypePackage.getString(), "organizationalStatus", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_OtherMailbox(), theXMLTypePackage.getString(), "otherMailbox", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Ou(), theXMLTypePackage.getString(), "ou", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Pager(), theXMLTypePackage.getString(), "pager", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PersonalTitle(), theXMLTypePackage.getString(), "personalTitle", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Photo(), theXMLTypePackage.getString(), "photo", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PhysicalDeliveryOfficeName(), theXMLTypePackage.getString(), "physicalDeliveryOfficeName", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PostalAddress(), theXMLTypePackage.getString(), "postalAddress", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PostalCode(), theXMLTypePackage.getString(), "postalCode", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PostOfficebox(), theXMLTypePackage.getString(), "postOfficebox", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PreferredDeliveryMethod(), theXMLTypePackage.getString(), "preferredDeliveryMethod", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_PreferredLanguage(), theXMLTypePackage.getString(), "preferredLanguage", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_RegisteredAddress(), theXMLTypePackage.getString(), "registeredAddress", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_RoomNumber(), theXMLTypePackage.getString(), "roomNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Secretary(), theXMLTypePackage.getString(), "secretary", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_SeeAlso(), theXMLTypePackage.getString(), "seeAlso", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Sn(), theXMLTypePackage.getString(), "sn", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_St(), theXMLTypePackage.getString(), "st", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Street(), theXMLTypePackage.getString(), "street", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_TelephoneNumber(), theXMLTypePackage.getString(), "telephoneNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_TeletexTerminalIdentifier(), theXMLTypePackage.getString(), "teletexTerminalIdentifier", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_TelexNumber(), theXMLTypePackage.getString(), "telexNumber", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_ThumbnailLogo(), theXMLTypePackage.getString(), "thumbnailLogo", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_ThumbnailPhoto(), theXMLTypePackage.getString(), "thumbnailPhoto", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Title(), theXMLTypePackage.getString(), "title", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_Uid(), theXMLTypePackage.getString(), "uid", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_UniqueIdentifier(), theXMLTypePackage.getString(), "uniqueIdentifier", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_UserCertificate(), theXMLTypePackage.getString(), "userCertificate", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_UserPassword(), theXMLTypePackage.getString(), "userPassword", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_UserPKCS12(), theXMLTypePackage.getString(), "userPKCS12", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_UserSMIMECertificate(), theXMLTypePackage.getString(), "userSMIMECertificate", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_X121Address(), theXMLTypePackage.getString(), "x121Address", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getEPerson_X500UniqueIdentifier(), theXMLTypePackage.getString(), "x500UniqueIdentifier", null, 0, 1, EPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(inetOrgPersonEClass, InetOrgPerson.class, "InetOrgPerson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_AccessHint(), theXMLTypePackage.getString(), "accessHint", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_AccountHint(), theXMLTypePackage.getString(), "accountHint", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Audio(), theXMLTypePackage.getString(), "audio", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_BusinessCategory(), theXMLTypePackage.getString(), "businessCategory", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_C(), theXMLTypePackage.getString(), "c", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_CarLicense(), theXMLTypePackage.getString(), "carLicense", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_ConfigPtr(), theXMLTypePackage.getString(), "configPtr", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_DepartmentNumber(), theXMLTypePackage.getString(), "departmentNumber", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_EmployeeNumber(), theXMLTypePackage.getString(), "employeeNumber", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_EmployeeType(), theXMLTypePackage.getString(), "employeeType", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_GenerationQualifier(), theXMLTypePackage.getString(), "generationQualifier", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_GivenName(), theXMLTypePackage.getString(), "givenName", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_HomeFax(), theXMLTypePackage.getString(), "homeFax", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_HomePhone(), theXMLTypePackage.getString(), "homePhone", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_HomePostalAddress(), theXMLTypePackage.getString(), "homePostalAddress", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Initials(), theXMLTypePackage.getString(), "initials", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_JpegPhoto(), theXMLTypePackage.getString(), "jpegPhoto", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_LabeledURI(), theXMLTypePackage.getString(), "labeledURI", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Mail(), theXMLTypePackage.getString(), "mail", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Manager(), theXMLTypePackage.getString(), "manager", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_MiddleName(), theXMLTypePackage.getString(), "middleName", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Mobile(), theXMLTypePackage.getString(), "mobile", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_O(), theXMLTypePackage.getString(), "o", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_OrganizationalStatus(), theXMLTypePackage.getString(), "organizationalStatus", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_OtherMailbox(), theXMLTypePackage.getString(), "otherMailbox", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Pager(), theXMLTypePackage.getString(), "pager", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_PersonalTitle(), theXMLTypePackage.getString(), "personalTitle", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Photo(), theXMLTypePackage.getString(), "photo", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_PreferredLanguage(), theXMLTypePackage.getString(), "preferredLanguage", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_RoomNumber(), theXMLTypePackage.getString(), "roomNumber", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Secretary(), theXMLTypePackage.getString(), "secretary", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_ThumbnailLogo(), theXMLTypePackage.getString(), "thumbnailLogo", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_ThumbnailPhoto(), theXMLTypePackage.getString(), "thumbnailPhoto", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_Uid(), theXMLTypePackage.getString(), "uid", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_UniqueIdentifier(), theXMLTypePackage.getString(), "uniqueIdentifier", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_UserCertificate(), theXMLTypePackage.getString(), "userCertificate", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_UserPKCS12(), theXMLTypePackage.getString(), "userPKCS12", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_UserSMIMECertificate(), theXMLTypePackage.getString(), "userSMIMECertificate", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInetOrgPerson_X500UniqueIdentifier(), theXMLTypePackage.getString(), "x500UniqueIdentifier", null, 0, 1, InetOrgPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ldapAuxiliaryClassEClass, LdapAuxiliaryClass.class, "LdapAuxiliaryClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapClientEClass, LdapClient.class, "LdapClient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapClientUnitEClass, LdapClientUnit.class, "LdapClientUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapDeployRootEClass, LdapDeployRoot.class, "LdapDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLdapDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_CapabilityLdapClient(), this.getLdapClient(), null, "capabilityLdapClient", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_CapabilityLdapEntry(), this.getLdapEntry(), null, "capabilityLdapEntry", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_CapabilityLdapLdif(), this.getLdapLdif(), null, "capabilityLdapLdif", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_CapabilityLdapSchema(), this.getLdapSchema(), null, "capabilityLdapSchema", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_CapabilityLdapServer(), this.getLdapServer(), null, "capabilityLdapServer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_CapabilityLdapSuffix(), this.getLdapSuffix(), null, "capabilityLdapSuffix", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapEPerson(), this.getEPerson(), null, "ldapEPerson", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapInetOrgPerson(), this.getInetOrgPerson(), null, "ldapInetOrgPerson", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapOrganization(), this.getOrganization(), null, "ldapOrganization", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapOrganizationalPerson(), this.getOrganizationalPerson(), null, "ldapOrganizationalPerson", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapPerson(), this.getPerson(), null, "ldapPerson", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapEntryUnit(), this.getLdapEntryUnit(), null, "ldapEntryUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapServerUnit(), this.getLdapServerUnit(), null, "ldapServerUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_LdapSuffixUnit(), this.getLdapSuffixUnit(), null, "ldapSuffixUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_UnitLdapClientUnit(), this.getLdapClientUnit(), null, "unitLdapClientUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_UnitLdapLdifUnit(), this.getLdapLdifUnit(), null, "unitLdapLdifUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_UnitLdapRoleReference(), this.getSecurityRoleReferenceUnit(), null, "unitLdapRoleReference", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_UnitLdapSchemaUnit(), this.getLdapSchemaUnit(), null, "unitLdapSchemaUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_UnitLdifArtifact(), this.getLdifArtifact(), null, "unitLdifArtifact", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLdapDeployRoot_UnitSchemaArtifact(), this.getSchemaArtifact(), null, "unitSchemaArtifact", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ldapEntryEClass, LdapEntry.class, "LdapEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLdapEntry_RelativeDN(), theXMLTypePackage.getString(), "relativeDN", null, 0, 1, LdapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ldapEntryUnitEClass, LdapEntryUnit.class, "LdapEntryUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapLdifEClass, LdapLdif.class, "LdapLdif", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLdapLdif_Action(), this.getLdifAction(), "action", "import", 0, 1, LdapLdif.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLdapLdif_SubtreeDn(), theXMLTypePackage.getString(), "subtreeDn", null, 0, 1, LdapLdif.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ldapLdifUnitEClass, LdapLdifUnit.class, "LdapLdifUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapObjectEClass, LdapObject.class, "LdapObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapSchemaEClass, LdapSchema.class, "LdapSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLdapSchema_Action(), this.getSchemaAction(), "action", "add", 0, 1, LdapSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(ldapSchemaUnitEClass, LdapSchemaUnit.class, "LdapSchemaUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapServerEClass, LdapServer.class, "LdapServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLdapServer_AdministratorDN(), theXMLTypePackage.getString(), "administratorDN", "cn=root", 0, 1, LdapServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getLdapServer_AdministratorPassword(), theXMLTypePackage.getString(), "administratorPassword", null, 0, 1, LdapServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ldapServerUnitEClass, LdapServerUnit.class, "LdapServerUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldapSuffixEClass, LdapSuffix.class, "LdapSuffix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getLdapSuffix_SuffixDN(), theXMLTypePackage.getString(), "suffixDN", null, 0, 1, LdapSuffix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ldapSuffixUnitEClass, LdapSuffixUnit.class, "LdapSuffixUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ldifArtifactEClass, LdifArtifact.class, "LdifArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(organizationEClass, Organization.class, "Organization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getOrganization_BusinessCategory(), theXMLTypePackage.getString(), "businessCategory", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_Description1(), theXMLTypePackage.getString(), "description1", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_DestinationIndicator(), theXMLTypePackage.getString(), "destinationIndicator", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_FacsimileTelephoneNumber(), theXMLTypePackage.getString(), "facsimileTelephoneNumber", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_InternationalISDNNumber(), theXMLTypePackage.getString(), "internationalISDNNumber", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_L(), theXMLTypePackage.getString(), "l", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_O(), theXMLTypePackage.getString(), "o", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_PhysicalDeliveryOfficeName(), theXMLTypePackage.getString(), "physicalDeliveryOfficeName", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_PostalAddress(), theXMLTypePackage.getString(), "postalAddress", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_PostalCode(), theXMLTypePackage.getString(), "postalCode", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_PostOfficeBox(), theXMLTypePackage.getString(), "postOfficeBox", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_PreferredDeliveryMethod(), theXMLTypePackage.getString(), "preferredDeliveryMethod", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_RegisteredAddress(), theXMLTypePackage.getString(), "registeredAddress", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_SearchGuide(), theXMLTypePackage.getString(), "searchGuide", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_SeeAlso(), theXMLTypePackage.getString(), "seeAlso", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_St(), theXMLTypePackage.getString(), "st", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_Street(), theXMLTypePackage.getString(), "street", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_TelephoneNumber(), theXMLTypePackage.getString(), "telephoneNumber", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_TeletexTerminalIdentifier(), theXMLTypePackage.getString(), "teletexTerminalIdentifier", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_TelexNumber(), theXMLTypePackage.getString(), "telexNumber", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_UserPassword(), theXMLTypePackage.getString(), "userPassword", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganization_X121address(), theXMLTypePackage.getString(), "x121address", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(organizationalPersonEClass, OrganizationalPerson.class, "OrganizationalPerson", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_DestinationIndicator(), theXMLTypePackage.getString(), "destinationIndicator", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_FacsimileTelephoneNumber(), theXMLTypePackage.getString(), "facsimileTelephoneNumber", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_InternationalISDNNumber(), theXMLTypePackage.getString(), "internationalISDNNumber", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_L(), theXMLTypePackage.getString(), "l", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_Ou(), theXMLTypePackage.getString(), "ou", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_PhysicalDeliveryOfficeName(), theXMLTypePackage.getString(), "physicalDeliveryOfficeName", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_PostalAddress(), theXMLTypePackage.getString(), "postalAddress", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_PostalCode(), theXMLTypePackage.getString(), "postalCode", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_PostOfficeBox(), theXMLTypePackage.getString(), "postOfficeBox", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_PreferredDeliveryMethod(), theXMLTypePackage.getString(), "preferredDeliveryMethod", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_RegisteredAddress(), theXMLTypePackage.getString(), "registeredAddress", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_St(), theXMLTypePackage.getString(), "st", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_Street(), theXMLTypePackage.getString(), "street", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_TeletexTerminalIdentifier(), theXMLTypePackage.getString(), "teletexTerminalIdentifier", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_TelexNumber(), theXMLTypePackage.getString(), "telexNumber", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_Title(), theXMLTypePackage.getString(), "title", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getOrganizationalPerson_X121address(), theXMLTypePackage.getString(), "x121address", null, 0, 1, OrganizationalPerson.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPerson_Cn(), theXMLTypePackage.getString(), "cn", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPerson_SeeAlso(), theXMLTypePackage.getString(), "seeAlso", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPerson_Sn(), theXMLTypePackage.getString(), "sn", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPerson_TelephoneNumber(), theXMLTypePackage.getString(), "telephoneNumber", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPerson_UserPassword(), theXMLTypePackage.getString(), "userPassword", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(schemaArtifactEClass, SchemaArtifact.class, "SchemaArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(securityRoleReferenceUnitEClass, SecurityRoleReferenceUnit.class, "SecurityRoleReferenceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(topEClass, Top.class, "Top", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(ldifActionEEnum, LdifAction.class, "LdifAction"); //$NON-NLS-1$
		addEEnumLiteral(ldifActionEEnum, LdifAction.IMPORT_LITERAL);
		addEEnumLiteral(ldifActionEEnum, LdifAction.EXPORT_LITERAL);

		initEEnum(schemaActionEEnum, SchemaAction.class, "SchemaAction"); //$NON-NLS-1$
		addEEnumLiteral(schemaActionEEnum, SchemaAction.ADD_LITERAL);
		addEEnumLiteral(schemaActionEEnum, SchemaAction.REMOVE_LITERAL);

		// Initialize data types
		initEDataType(ldifActionObjectEDataType, LdifAction.class, "LdifActionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(schemaActionObjectEDataType, SchemaAction.class, "SchemaActionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$				
		addAnnotation
		  (ePersonEClass, 
		   source, 
		   new String[] {
			 "name", "EPerson", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_AccessHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "accessHint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_AccountHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "accountHint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Audio(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "audio" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_BusinessCategory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "businessCategory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_C(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "c" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_CarLicense(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "carLicense" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Cn(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "cn" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_ConfigPtr(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configPtr" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_DepartmentNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "departmentNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_DestinationIndicator(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationIndicator" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_EmployeeNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "employeeNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_EmployeeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "employeeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_FacsimileTelephoneNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "facsimileTelephoneNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_GenerationQualifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "generationQualifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_GivenName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "givenName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_HomeFax(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "homeFax" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_HomePhone(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "homePhone" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_HomePostalAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "homePostalAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Initials(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initials" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_InternationalISDNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "internationalISDNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_JpegPhoto(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jpegPhoto" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_L(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "l" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_LabeledURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "labeledURI" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Mail(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mail" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Manager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "manager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_MiddleName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "middleName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Mobile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mobile" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_O(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "o" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_OrganizationalStatus(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "organizationalStatus" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_OtherMailbox(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "otherMailbox" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Ou(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ou" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Pager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "pager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PersonalTitle(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "personalTitle" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Photo(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "photo" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PhysicalDeliveryOfficeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "physicalDeliveryOfficeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PostalAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postalAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PostalCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postalCode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PostOfficebox(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postOfficebox" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PreferredDeliveryMethod(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preferredDeliveryMethod" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_PreferredLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preferredLanguage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_RegisteredAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "registeredAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_RoomNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "roomNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Secretary(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "secretary" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_SeeAlso(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "seeAlso" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Sn(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "sn" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_St(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "st" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Street(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "street" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_TelephoneNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "telephoneNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_TeletexTerminalIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "teletexTerminalIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_TelexNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "telexNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_ThumbnailLogo(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "thumbnailLogo" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_ThumbnailPhoto(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "thumbnailPhoto" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Title(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "title" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_Uid(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "uid" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_UniqueIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "uniqueIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_UserCertificate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userCertificate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_UserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_UserPKCS12(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userPKCS12" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_UserSMIMECertificate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userSMIMECertificate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_X121Address(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "x121Address" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getEPerson_X500UniqueIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "x500UniqueIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (inetOrgPersonEClass, 
		   source, 
		   new String[] {
			 "name", "InetOrgPerson", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_AccessHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "accessHint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_AccountHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "accountHint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Audio(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "audio" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_BusinessCategory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "businessCategory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_C(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "c" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_CarLicense(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "carLicense" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_ConfigPtr(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configPtr" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_DepartmentNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "departmentNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_EmployeeNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "employeeNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_EmployeeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "employeeType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_GenerationQualifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "generationQualifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_GivenName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "givenName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_HomeFax(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "homeFax" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_HomePhone(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "homePhone" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_HomePostalAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "homePostalAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Initials(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initials" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_JpegPhoto(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "jpegPhoto" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_LabeledURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "labeledURI" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Mail(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mail" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Manager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "manager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_MiddleName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "middleName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Mobile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mobile" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_O(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "o" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_OrganizationalStatus(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "organizationalStatus" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_OtherMailbox(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "otherMailbox" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Pager(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "pager" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_PersonalTitle(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "personalTitle" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Photo(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "photo" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_PreferredLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preferredLanguage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_RoomNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "roomNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Secretary(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "secretary" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_ThumbnailLogo(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "thumbnailLogo" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_ThumbnailPhoto(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "thumbnailPhoto" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_Uid(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "uid" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_UniqueIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "uniqueIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_UserCertificate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userCertificate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_UserPKCS12(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userPKCS12" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_UserSMIMECertificate(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userSMIMECertificate" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInetOrgPerson_X500UniqueIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "x500UniqueIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapAuxiliaryClassEClass, 
		   source, 
		   new String[] {
			 "name", "LdapAuxiliaryClass", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapClientEClass, 
		   source, 
		   new String[] {
			 "name", "LdapClient", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapClientUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LdapClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ldapDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_CapabilityLdapClient(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ldapClient", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_CapabilityLdapEntry(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ldapEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_CapabilityLdapLdif(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ldapLdif", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_CapabilityLdapSchema(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ldapSchema", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_CapabilityLdapServer(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ldapServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_CapabilityLdapSuffix(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.ldapSuffix", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapEPerson(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldap.ePerson", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapInetOrgPerson(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldap.inetOrgPerson", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapOrganization(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldap.organization", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapOrganizationalPerson(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldap.organizationalPerson", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapPerson(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldap.person", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapEntryUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldapEntryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapServerUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldapServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_LdapSuffixUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ldapSuffixUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_UnitLdapClientUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ldapClientUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_UnitLdapLdifUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ldapLdifUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_UnitLdapRoleReference(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ldapRoleReference", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_UnitLdapSchemaUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ldapSchemaUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_UnitLdifArtifact(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ldifArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapDeployRoot_UnitSchemaArtifact(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.schemaArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ldapEntryEClass, 
		   source, 
		   new String[] {
			 "name", "LdapEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getLdapEntry_RelativeDN(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "relativeDN" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapEntryUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LdapEntryUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapLdifEClass, 
		   source, 
		   new String[] {
			 "name", "LdapLdif", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapLdif_Action(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "action" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapLdif_SubtreeDn(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "subtree_dn" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapLdifUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LdapLdifUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ldapObjectEClass, 
		   source, 
		   new String[] {
			 "name", "LdapObject", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapSchemaEClass, 
		   source, 
		   new String[] {
			 "name", "LdapSchema", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getLdapSchema_Action(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "action" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapSchemaUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LdapSchemaUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapServerEClass, 
		   source, 
		   new String[] {
			 "name", "LdapServer", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getLdapServer_AdministratorDN(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "administratorDN" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getLdapServer_AdministratorPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "administratorPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapServerUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LdapServerUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapSuffixEClass, 
		   source, 
		   new String[] {
			 "name", "LdapSuffix", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getLdapSuffix_SuffixDN(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "suffixDN" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldapSuffixUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LdapSuffixUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldifActionEEnum, 
		   source, 
		   new String[] {
			 "name", "LdifAction" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (ldifActionObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "LdifAction:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "LdifAction" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (ldifArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "LdifArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (organizationEClass, 
		   source, 
		   new String[] {
			 "name", "Organization", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_BusinessCategory(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "businessCategory" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_Description1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Description" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_DestinationIndicator(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationIndicator" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_FacsimileTelephoneNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "facsimileTelephoneNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_InternationalISDNNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "internationalISDNNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_L(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "l" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_O(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "o" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_PhysicalDeliveryOfficeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "physicalDeliveryOfficeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_PostalAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postalAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_PostalCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postalCode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_PostOfficeBox(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postOfficeBox" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_PreferredDeliveryMethod(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preferredDeliveryMethod" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_RegisteredAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "registeredAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_SearchGuide(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "searchGuide" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_SeeAlso(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "seeAlso" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_St(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "st" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_Street(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "street" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_TelephoneNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "telephoneNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_TeletexTerminalIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "teletexTerminalIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_TelexNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "telexNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_UserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganization_X121address(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "x121address" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (organizationalPersonEClass, 
		   source, 
		   new String[] {
			 "name", "OrganizationalPerson", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_DestinationIndicator(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "destinationIndicator" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_FacsimileTelephoneNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "facsimileTelephoneNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_InternationalISDNNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "internationalISDNNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_L(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "l" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_Ou(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "ou" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_PhysicalDeliveryOfficeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "physicalDeliveryOfficeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_PostalAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postalAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_PostalCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postalCode" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_PostOfficeBox(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "postOfficeBox" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_PreferredDeliveryMethod(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "preferredDeliveryMethod" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_RegisteredAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "registeredAddress" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_St(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "st" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_Street(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "street" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_TeletexTerminalIdentifier(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "teletexTerminalIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_TelexNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "telexNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_Title(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "title" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getOrganizationalPerson_X121address(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "x121address" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "name", "Person", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getPerson_Cn(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "cn" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getPerson_SeeAlso(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "seeAlso" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getPerson_Sn(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "sn" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getPerson_TelephoneNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "telephoneNumber" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getPerson_UserPassword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "userPassword" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (schemaActionEEnum, 
		   source, 
		   new String[] {
			 "name", "SchemaAction" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (schemaActionObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "SchemaAction:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "SchemaAction" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (schemaArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "SchemaArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (securityRoleReferenceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SecurityRoleReferenceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (topEClass, 
		   source, 
		   new String[] {
			 "name", "Top", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //LdapPackageImpl
