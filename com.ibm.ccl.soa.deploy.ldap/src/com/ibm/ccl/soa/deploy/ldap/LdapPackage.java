/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The core model for SOA Deploy. A {@link Topology} contains {@link Unit}s. Units contain
 * {@Capability}s, {@Requirement}s, and {@UnitLink}s. Extension domains are encouraged to extend
 * Unit and Capability but not Topology, Requirement, or UnitLink.
 * 
 * 
 * An object that can be part of a deployable module. See {@link FileArtifact}.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.ldap.LdapFactory
 * @model kind="package"
 * @generated
 */
public interface LdapPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ldap"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/ldap/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ldapDeploy"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	LdapPackage eINSTANCE = com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapObjectImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapObject()
	 * @generated
	 */
	int LDAP_OBJECT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_OBJECT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapAuxiliaryClassImpl <em>Auxiliary Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapAuxiliaryClassImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapAuxiliaryClass()
	 * @generated
	 */
	int LDAP_AUXILIARY_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__ANNOTATIONS = LDAP_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__ATTRIBUTE_META_DATA = LDAP_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__EXTENDED_ATTRIBUTES = LDAP_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__ARTIFACT_GROUP = LDAP_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__ARTIFACTS = LDAP_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__CONSTRAINT_GROUP = LDAP_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__CONSTRAINTS = LDAP_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__DESCRIPTION = LDAP_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__DISPLAY_NAME = LDAP_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__MUTABLE = LDAP_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__NAME = LDAP_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__STEREOTYPES = LDAP_OBJECT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__BUILD_VERSION = LDAP_OBJECT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__LINK_TYPE = LDAP_OBJECT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS__ORIGIN = LDAP_OBJECT__ORIGIN;

	/**
	 * The number of structural features of the '<em>Auxiliary Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_AUXILIARY_CLASS_FEATURE_COUNT = LDAP_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.EPersonImpl <em>EPerson</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.EPersonImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getEPerson()
	 * @generated
	 */
	int EPERSON = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ANNOTATIONS = LDAP_AUXILIARY_CLASS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ATTRIBUTE_META_DATA = LDAP_AUXILIARY_CLASS__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__EXTENDED_ATTRIBUTES = LDAP_AUXILIARY_CLASS__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ARTIFACT_GROUP = LDAP_AUXILIARY_CLASS__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ARTIFACTS = LDAP_AUXILIARY_CLASS__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__CONSTRAINT_GROUP = LDAP_AUXILIARY_CLASS__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__CONSTRAINTS = LDAP_AUXILIARY_CLASS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__DESCRIPTION = LDAP_AUXILIARY_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__DISPLAY_NAME = LDAP_AUXILIARY_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__MUTABLE = LDAP_AUXILIARY_CLASS__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__NAME = LDAP_AUXILIARY_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__STEREOTYPES = LDAP_AUXILIARY_CLASS__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__BUILD_VERSION = LDAP_AUXILIARY_CLASS__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__LINK_TYPE = LDAP_AUXILIARY_CLASS__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ORIGIN = LDAP_AUXILIARY_CLASS__ORIGIN;

	/**
	 * The feature id for the '<em><b>Access Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ACCESS_HINT = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ACCOUNT_HINT = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Audio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__AUDIO = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Business Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__BUSINESS_CATEGORY = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__C = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Car License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__CAR_LICENSE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Cn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__CN = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Config Ptr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__CONFIG_PTR = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Department Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__DEPARTMENT_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Destination Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__DESTINATION_INDICATOR = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Employee Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__EMPLOYEE_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Employee Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__EMPLOYEE_TYPE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Facsimile Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__FACSIMILE_TELEPHONE_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Generation Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__GENERATION_QUALIFIER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__GIVEN_NAME = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Home Fax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__HOME_FAX = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Home Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__HOME_PHONE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Home Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__HOME_POSTAL_ADDRESS = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Initials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__INITIALS = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>International ISD Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__INTERNATIONAL_ISD_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Jpeg Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__JPEG_PHOTO = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>L</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__L = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Labeled URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__LABELED_URI = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Mail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__MAIL = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__MANAGER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__MIDDLE_NAME = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__MOBILE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>O</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__O = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Organizational Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ORGANIZATIONAL_STATUS = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Other Mailbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__OTHER_MAILBOX = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Ou</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__OU = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Pager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__PAGER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Personal Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__PERSONAL_TITLE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__PHOTO = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Physical Delivery Office Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__PHYSICAL_DELIVERY_OFFICE_NAME = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__POSTAL_ADDRESS = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__POSTAL_CODE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Post Officebox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__POST_OFFICEBOX = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Preferred Delivery Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__PREFERRED_DELIVERY_METHOD = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Preferred Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__PREFERRED_LANGUAGE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Registered Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__REGISTERED_ADDRESS = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Room Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ROOM_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>Secretary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__SECRETARY = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 42;

	/**
	 * The feature id for the '<em><b>See Also</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__SEE_ALSO = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 43;

	/**
	 * The feature id for the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__SN = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 44;

	/**
	 * The feature id for the '<em><b>St</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__ST = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 45;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__STREET = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 46;

	/**
	 * The feature id for the '<em><b>Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__TELEPHONE_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 47;

	/**
	 * The feature id for the '<em><b>Teletex Terminal Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__TELETEX_TERMINAL_IDENTIFIER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 48;

	/**
	 * The feature id for the '<em><b>Telex Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__TELEX_NUMBER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 49;

	/**
	 * The feature id for the '<em><b>Thumbnail Logo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__THUMBNAIL_LOGO = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 50;

	/**
	 * The feature id for the '<em><b>Thumbnail Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__THUMBNAIL_PHOTO = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 51;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__TITLE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 52;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__UID = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 53;

	/**
	 * The feature id for the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__UNIQUE_IDENTIFIER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 54;

	/**
	 * The feature id for the '<em><b>User Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__USER_CERTIFICATE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 55;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__USER_PASSWORD = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 56;

	/**
	 * The feature id for the '<em><b>User PKCS12</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__USER_PKCS12 = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 57;

	/**
	 * The feature id for the '<em><b>User SMIME Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__USER_SMIME_CERTIFICATE = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 58;

	/**
	 * The feature id for the '<em><b>X121 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__X121_ADDRESS = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 59;

	/**
	 * The feature id for the '<em><b>X500 Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON__X500_UNIQUE_IDENTIFIER = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 60;

	/**
	 * The number of structural features of the '<em>EPerson</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPERSON_FEATURE_COUNT = LDAP_AUXILIARY_CLASS_FEATURE_COUNT + 61;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.TopImpl <em>Top</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.TopImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getTop()
	 * @generated
	 */
	int TOP = 23;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__ANNOTATIONS = LDAP_OBJECT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__ATTRIBUTE_META_DATA = LDAP_OBJECT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__EXTENDED_ATTRIBUTES = LDAP_OBJECT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__ARTIFACT_GROUP = LDAP_OBJECT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__ARTIFACTS = LDAP_OBJECT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__CONSTRAINT_GROUP = LDAP_OBJECT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__CONSTRAINTS = LDAP_OBJECT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__DESCRIPTION = LDAP_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__DISPLAY_NAME = LDAP_OBJECT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__MUTABLE = LDAP_OBJECT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__NAME = LDAP_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__STEREOTYPES = LDAP_OBJECT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__BUILD_VERSION = LDAP_OBJECT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__LINK_TYPE = LDAP_OBJECT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP__ORIGIN = LDAP_OBJECT__ORIGIN;

	/**
	 * The number of structural features of the '<em>Top</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_FEATURE_COUNT = LDAP_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ANNOTATIONS = TOP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ATTRIBUTE_META_DATA = TOP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__EXTENDED_ATTRIBUTES = TOP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ARTIFACT_GROUP = TOP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ARTIFACTS = TOP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CONSTRAINT_GROUP = TOP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CONSTRAINTS = TOP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__DESCRIPTION = TOP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__DISPLAY_NAME = TOP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__MUTABLE = TOP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = TOP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__STEREOTYPES = TOP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__BUILD_VERSION = TOP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LINK_TYPE = TOP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ORIGIN = TOP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Cn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CN = TOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>See Also</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SEE_ALSO = TOP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SN = TOP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__TELEPHONE_NUMBER = TOP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__USER_PASSWORD = TOP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = TOP_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl <em>Organizational Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getOrganizationalPerson()
	 * @generated
	 */
	int ORGANIZATIONAL_PERSON = 19;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__ANNOTATIONS = PERSON__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__ATTRIBUTE_META_DATA = PERSON__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__EXTENDED_ATTRIBUTES = PERSON__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__ARTIFACT_GROUP = PERSON__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__ARTIFACTS = PERSON__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__CONSTRAINT_GROUP = PERSON__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__CONSTRAINTS = PERSON__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__DESCRIPTION = PERSON__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__DISPLAY_NAME = PERSON__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__MUTABLE = PERSON__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__NAME = PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__STEREOTYPES = PERSON__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__BUILD_VERSION = PERSON__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__LINK_TYPE = PERSON__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__ORIGIN = PERSON__ORIGIN;

	/**
	 * The feature id for the '<em><b>Cn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__CN = PERSON__CN;

	/**
	 * The feature id for the '<em><b>See Also</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__SEE_ALSO = PERSON__SEE_ALSO;

	/**
	 * The feature id for the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__SN = PERSON__SN;

	/**
	 * The feature id for the '<em><b>Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__TELEPHONE_NUMBER = PERSON__TELEPHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__USER_PASSWORD = PERSON__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Destination Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR = PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Facsimile Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER = PERSON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>International ISDN Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER = PERSON_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>L</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__L = PERSON_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ou</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__OU = PERSON_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Physical Delivery Office Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME = PERSON_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__POSTAL_ADDRESS = PERSON_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__POSTAL_CODE = PERSON_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Post Office Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__POST_OFFICE_BOX = PERSON_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Preferred Delivery Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD = PERSON_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Registered Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS = PERSON_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>St</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__ST = PERSON_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__STREET = PERSON_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Teletex Terminal Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER = PERSON_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Telex Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__TELEX_NUMBER = PERSON_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__TITLE = PERSON_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>X12 1address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON__X121ADDRESS = PERSON_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Organizational Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATIONAL_PERSON_FEATURE_COUNT = PERSON_FEATURE_COUNT + 17;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl <em>Inet Org Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getInetOrgPerson()
	 * @generated
	 */
	int INET_ORG_PERSON = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ANNOTATIONS = ORGANIZATIONAL_PERSON__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ATTRIBUTE_META_DATA = ORGANIZATIONAL_PERSON__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__EXTENDED_ATTRIBUTES = ORGANIZATIONAL_PERSON__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ARTIFACT_GROUP = ORGANIZATIONAL_PERSON__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ARTIFACTS = ORGANIZATIONAL_PERSON__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__CONSTRAINT_GROUP = ORGANIZATIONAL_PERSON__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__CONSTRAINTS = ORGANIZATIONAL_PERSON__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__DESCRIPTION = ORGANIZATIONAL_PERSON__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__DISPLAY_NAME = ORGANIZATIONAL_PERSON__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__MUTABLE = ORGANIZATIONAL_PERSON__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__NAME = ORGANIZATIONAL_PERSON__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__STEREOTYPES = ORGANIZATIONAL_PERSON__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__BUILD_VERSION = ORGANIZATIONAL_PERSON__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__LINK_TYPE = ORGANIZATIONAL_PERSON__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ORIGIN = ORGANIZATIONAL_PERSON__ORIGIN;

	/**
	 * The feature id for the '<em><b>Cn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__CN = ORGANIZATIONAL_PERSON__CN;

	/**
	 * The feature id for the '<em><b>See Also</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__SEE_ALSO = ORGANIZATIONAL_PERSON__SEE_ALSO;

	/**
	 * The feature id for the '<em><b>Sn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__SN = ORGANIZATIONAL_PERSON__SN;

	/**
	 * The feature id for the '<em><b>Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__TELEPHONE_NUMBER = ORGANIZATIONAL_PERSON__TELEPHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__USER_PASSWORD = ORGANIZATIONAL_PERSON__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Destination Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__DESTINATION_INDICATOR = ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR;

	/**
	 * The feature id for the '<em><b>Facsimile Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__FACSIMILE_TELEPHONE_NUMBER = ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER;

	/**
	 * The feature id for the '<em><b>International ISDN Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__INTERNATIONAL_ISDN_NUMBER = ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER;

	/**
	 * The feature id for the '<em><b>L</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__L = ORGANIZATIONAL_PERSON__L;

	/**
	 * The feature id for the '<em><b>Ou</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__OU = ORGANIZATIONAL_PERSON__OU;

	/**
	 * The feature id for the '<em><b>Physical Delivery Office Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME = ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME;

	/**
	 * The feature id for the '<em><b>Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__POSTAL_ADDRESS = ORGANIZATIONAL_PERSON__POSTAL_ADDRESS;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__POSTAL_CODE = ORGANIZATIONAL_PERSON__POSTAL_CODE;

	/**
	 * The feature id for the '<em><b>Post Office Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__POST_OFFICE_BOX = ORGANIZATIONAL_PERSON__POST_OFFICE_BOX;

	/**
	 * The feature id for the '<em><b>Preferred Delivery Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__PREFERRED_DELIVERY_METHOD = ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD;

	/**
	 * The feature id for the '<em><b>Registered Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__REGISTERED_ADDRESS = ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS;

	/**
	 * The feature id for the '<em><b>St</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ST = ORGANIZATIONAL_PERSON__ST;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__STREET = ORGANIZATIONAL_PERSON__STREET;

	/**
	 * The feature id for the '<em><b>Teletex Terminal Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__TELETEX_TERMINAL_IDENTIFIER = ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Telex Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__TELEX_NUMBER = ORGANIZATIONAL_PERSON__TELEX_NUMBER;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__TITLE = ORGANIZATIONAL_PERSON__TITLE;

	/**
	 * The feature id for the '<em><b>X12 1address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__X121ADDRESS = ORGANIZATIONAL_PERSON__X121ADDRESS;

	/**
	 * The feature id for the '<em><b>Access Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ACCESS_HINT = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ACCOUNT_HINT = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Audio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__AUDIO = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Business Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__BUSINESS_CATEGORY = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>C</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__C = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Car License</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__CAR_LICENSE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Config Ptr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__CONFIG_PTR = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Department Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__DEPARTMENT_NUMBER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Employee Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__EMPLOYEE_NUMBER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Employee Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__EMPLOYEE_TYPE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Generation Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__GENERATION_QUALIFIER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Given Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__GIVEN_NAME = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Home Fax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__HOME_FAX = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Home Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__HOME_PHONE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Home Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__HOME_POSTAL_ADDRESS = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Initials</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__INITIALS = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Jpeg Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__JPEG_PHOTO = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Labeled URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__LABELED_URI = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Mail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__MAIL = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__MANAGER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Middle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__MIDDLE_NAME = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Mobile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__MOBILE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>O</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__O = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Organizational Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ORGANIZATIONAL_STATUS = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Other Mailbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__OTHER_MAILBOX = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Pager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__PAGER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Personal Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__PERSONAL_TITLE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__PHOTO = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Preferred Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__PREFERRED_LANGUAGE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Room Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__ROOM_NUMBER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Secretary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__SECRETARY = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Thumbnail Logo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__THUMBNAIL_LOGO = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Thumbnail Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__THUMBNAIL_PHOTO = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__UID = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__UNIQUE_IDENTIFIER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>User Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__USER_CERTIFICATE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>User PKCS12</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__USER_PKCS12 = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>User SMIME Certificate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__USER_SMIME_CERTIFICATE = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>X500 Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 38;

	/**
	 * The number of structural features of the '<em>Inet Org Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INET_ORG_PERSON_FEATURE_COUNT = ORGANIZATIONAL_PERSON_FEATURE_COUNT + 39;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapClientImpl <em>Client</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapClientImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapClient()
	 * @generated
	 */
	int LDAP_CLIENT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Client</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapClientUnitImpl <em>Client Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapClientUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapClientUnit()
	 * @generated
	 */
	int LDAP_CLIENT_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Client Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_CLIENT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapDeployRoot()
	 * @generated
	 */
	int LDAP_DEPLOY_ROOT = 5;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Ldap Client</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT = 3;

	/**
	 * The feature id for the '<em><b>Capability Ldap Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Capability LdapServer Ldif</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF = 5;

	/**
	 * The feature id for the '<em><b>Capability Ldap Schema</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA = 6;

	/**
	 * The feature id for the '<em><b>Capability Ldap Server</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER = 7;

	/**
	 * The feature id for the '<em><b>Capability Ldap Suffix</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX = 8;

	/**
	 * The feature id for the '<em><b>Ldap EPerson</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_EPERSON = 9;

	/**
	 * The feature id for the '<em><b>Ldap Inet Org Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON = 10;

	/**
	 * The feature id for the '<em><b>Ldap Organization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION = 11;

	/**
	 * The feature id for the '<em><b>Ldap Organizational Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON = 12;

	/**
	 * The feature id for the '<em><b>Ldap Person</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_PERSON = 13;

	/**
	 * The feature id for the '<em><b>Ldap Entry Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Ldap Server Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Ldap Suffix Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT = 16;

	/**
	 * The feature id for the '<em><b>Unit Ldap Client Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT = 17;

	/**
	 * The feature id for the '<em><b>Unit LdapServer Ldif Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT = 18;

	/**
	 * The feature id for the '<em><b>Unit Ldap Role Reference</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE = 19;

	/**
	 * The feature id for the '<em><b>Unit Ldap Schema Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT = 20;

	/**
	 * The feature id for the '<em><b>Unit Ldif Artifact</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT = 21;

	/**
	 * The feature id for the '<em><b>Unit Schema Artifact</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT = 22;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_DEPLOY_ROOT_FEATURE_COUNT = 23;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapEntry()
	 * @generated
	 */
	int LDAP_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Relative DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY__RELATIVE_DN = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryUnitImpl <em>Entry Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapEntryUnit()
	 * @generated
	 */
	int LDAP_ENTRY_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Entry Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_ENTRY_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifImpl <em>Ldif</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapLdif()
	 * @generated
	 */
	int LDAP_LDIF = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__ACTION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subtree Dn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF__SUBTREE_DN = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ldif</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifUnitImpl <em>Ldif Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapLdifUnit()
	 * @generated
	 */
	int LDAP_LDIF_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Ldif Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_LDIF_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaImpl <em>Schema</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSchema()
	 * @generated
	 */
	int LDAP_SCHEMA = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA__ACTION = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaUnitImpl <em>Schema Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSchemaUnit()
	 * @generated
	 */
	int LDAP_SCHEMA_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Schema Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SCHEMA_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapServerImpl <em>Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapServerImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapServer()
	 * @generated
	 */
	int LDAP_SERVER = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Administrator DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ADMINISTRATOR_DN = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Administrator Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER__ADMINISTRATOR_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapServerUnitImpl <em>Server Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapServerUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapServerUnit()
	 * @generated
	 */
	int LDAP_SERVER_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Server Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SERVER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixImpl <em>Suffix</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSuffix()
	 * @generated
	 */
	int LDAP_SUFFIX = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Suffix DN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX__SUFFIX_DN = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Suffix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixUnitImpl <em>Suffix Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSuffixUnit()
	 * @generated
	 */
	int LDAP_SUFFIX_UNIT = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Suffix Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDAP_SUFFIX_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdifArtifactImpl <em>Ldif Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdifArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdifArtifact()
	 * @generated
	 */
	int LDIF_ARTIFACT = 17;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__ANNOTATIONS = CorePackage.FILE_ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__ATTRIBUTE_META_DATA = CorePackage.FILE_ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__EXTENDED_ATTRIBUTES = CorePackage.FILE_ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__ARTIFACT_GROUP = CorePackage.FILE_ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__ARTIFACTS = CorePackage.FILE_ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__CONSTRAINT_GROUP = CorePackage.FILE_ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__CONSTRAINTS = CorePackage.FILE_ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__DESCRIPTION = CorePackage.FILE_ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__DISPLAY_NAME = CorePackage.FILE_ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__MUTABLE = CorePackage.FILE_ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__NAME = CorePackage.FILE_ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT__FILE_UR_IS = CorePackage.FILE_ARTIFACT__FILE_UR_IS;

	/**
	 * The number of structural features of the '<em>Ldif Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LDIF_ARTIFACT_FEATURE_COUNT = CorePackage.FILE_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl <em>Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getOrganization()
	 * @generated
	 */
	int ORGANIZATION = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ANNOTATIONS = TOP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ATTRIBUTE_META_DATA = TOP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__EXTENDED_ATTRIBUTES = TOP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ARTIFACT_GROUP = TOP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ARTIFACTS = TOP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__CONSTRAINT_GROUP = TOP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__CONSTRAINTS = TOP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__DESCRIPTION = TOP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__DISPLAY_NAME = TOP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__MUTABLE = TOP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__NAME = TOP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__STEREOTYPES = TOP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__BUILD_VERSION = TOP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__LINK_TYPE = TOP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ORIGIN = TOP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Business Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__BUSINESS_CATEGORY = TOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__DESCRIPTION1 = TOP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination Indicator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__DESTINATION_INDICATOR = TOP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Facsimile Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER = TOP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>International ISDN Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__INTERNATIONAL_ISDN_NUMBER = TOP_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>L</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__L = TOP_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>O</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__O = TOP_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Physical Delivery Office Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME = TOP_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Postal Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__POSTAL_ADDRESS = TOP_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__POSTAL_CODE = TOP_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Post Office Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__POST_OFFICE_BOX = TOP_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Preferred Delivery Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__PREFERRED_DELIVERY_METHOD = TOP_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Registered Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__REGISTERED_ADDRESS = TOP_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Search Guide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__SEARCH_GUIDE = TOP_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>See Also</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__SEE_ALSO = TOP_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>St</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__ST = TOP_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Street</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__STREET = TOP_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Telephone Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__TELEPHONE_NUMBER = TOP_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Teletex Terminal Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER = TOP_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Telex Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__TELEX_NUMBER = TOP_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__USER_PASSWORD = TOP_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>X12 1address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__X121ADDRESS = TOP_FEATURE_COUNT + 21;

	/**
	 * The number of structural features of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FEATURE_COUNT = TOP_FEATURE_COUNT + 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.SchemaArtifactImpl <em>Schema Artifact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.SchemaArtifactImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSchemaArtifact()
	 * @generated
	 */
	int SCHEMA_ARTIFACT = 21;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__ANNOTATIONS = CorePackage.FILE_ARTIFACT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__ATTRIBUTE_META_DATA = CorePackage.FILE_ARTIFACT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__EXTENDED_ATTRIBUTES = CorePackage.FILE_ARTIFACT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__ARTIFACT_GROUP = CorePackage.FILE_ARTIFACT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__ARTIFACTS = CorePackage.FILE_ARTIFACT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__CONSTRAINT_GROUP = CorePackage.FILE_ARTIFACT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__CONSTRAINTS = CorePackage.FILE_ARTIFACT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__DESCRIPTION = CorePackage.FILE_ARTIFACT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__DISPLAY_NAME = CorePackage.FILE_ARTIFACT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__MUTABLE = CorePackage.FILE_ARTIFACT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__NAME = CorePackage.FILE_ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>File UR Is</b></em>' attribute list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT__FILE_UR_IS = CorePackage.FILE_ARTIFACT__FILE_UR_IS;

	/**
	 * The number of structural features of the '<em>Schema Artifact</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCHEMA_ARTIFACT_FEATURE_COUNT = CorePackage.FILE_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.SecurityRoleReferenceUnitImpl <em>Security Role Reference Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.SecurityRoleReferenceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSecurityRoleReferenceUnit()
	 * @generated
	 */
	int SECURITY_ROLE_REFERENCE_UNIT = 22;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Security Role Reference Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_ROLE_REFERENCE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.LdifAction <em>Ldif Action</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdifAction()
	 * @generated
	 */
	int LDIF_ACTION = 24;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.ldap.SchemaAction <em>Schema Action</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSchemaAction()
	 * @generated
	 */
	int SCHEMA_ACTION = 25;

	/**
	 * The meta object id for the '<em>Ldif Action Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdifActionObject()
	 * @generated
	 */
	int LDIF_ACTION_OBJECT = 26;

	/**
	 * The meta object id for the '<em>Schema Action Object</em>' data type.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
	 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSchemaActionObject()
	 * @generated
	 */
	int SCHEMA_ACTION_OBJECT = 27;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.EPerson <em>EPerson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EPerson</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson
	 * @generated
	 */
	EClass getEPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAccessHint <em>Access Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Hint</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getAccessHint()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_AccessHint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAccountHint <em>Account Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Hint</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getAccountHint()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_AccountHint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getAudio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audio</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getAudio()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Audio();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getBusinessCategory <em>Business Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Business Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getBusinessCategory()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_BusinessCategory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getC()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_C();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getCarLicense <em>Car License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Car License</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getCarLicense()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_CarLicense();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getCn <em>Cn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cn</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getCn()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Cn();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getConfigPtr <em>Config Ptr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config Ptr</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getConfigPtr()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_ConfigPtr();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getDepartmentNumber <em>Department Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Department Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getDepartmentNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_DepartmentNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getDestinationIndicator <em>Destination Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Indicator</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getDestinationIndicator()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_DestinationIndicator();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeNumber <em>Employee Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Employee Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_EmployeeNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeType <em>Employee Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Employee Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getEmployeeType()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_EmployeeType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facsimile Telephone Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getFacsimileTelephoneNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_FacsimileTelephoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getGenerationQualifier <em>Generation Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Qualifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getGenerationQualifier()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_GenerationQualifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getGivenName <em>Given Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Given Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getGivenName()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_GivenName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomeFax <em>Home Fax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Fax</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getHomeFax()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_HomeFax();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePhone <em>Home Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Phone</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePhone()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_HomePhone();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePostalAddress <em>Home Postal Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Postal Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getHomePostalAddress()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_HomePostalAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getInitials <em>Initials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initials</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getInitials()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Initials();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getInternationalISDNumber <em>International ISD Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>International ISD Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getInternationalISDNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_InternationalISDNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getJpegPhoto <em>Jpeg Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jpeg Photo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getJpegPhoto()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_JpegPhoto();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getL <em>L</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getL()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_L();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getLabeledURI <em>Labeled URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Labeled URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getLabeledURI()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_LabeledURI();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMail <em>Mail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getMail()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Mail();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getManager()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Manager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMiddleName <em>Middle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Middle Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getMiddleName()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_MiddleName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getMobile <em>Mobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mobile</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getMobile()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Mobile();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getO <em>O</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>O</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getO()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_O();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOrganizationalStatus <em>Organizational Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Organizational Status</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getOrganizationalStatus()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_OrganizationalStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOtherMailbox <em>Other Mailbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Mailbox</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getOtherMailbox()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_OtherMailbox();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getOu <em>Ou</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ou</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getOu()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Ou();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPager <em>Pager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pager</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPager()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Pager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPersonalTitle <em>Personal Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Personal Title</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPersonalTitle()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PersonalTitle();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPhoto <em>Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Photo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPhoto()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Photo();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physical Delivery Office Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPhysicalDeliveryOfficeName()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PhysicalDeliveryOfficeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalAddress <em>Postal Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalAddress()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PostalAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPostalCode()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PostalCode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPostOfficebox <em>Post Officebox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Officebox</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPostOfficebox()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PostOfficebox();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Delivery Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredDeliveryMethod()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PreferredDeliveryMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredLanguage <em>Preferred Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Language</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getPreferredLanguage()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_PreferredLanguage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getRegisteredAddress <em>Registered Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registered Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getRegisteredAddress()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_RegisteredAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getRoomNumber <em>Room Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Room Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getRoomNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_RoomNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSecretary <em>Secretary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secretary</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getSecretary()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Secretary();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSeeAlso <em>See Also</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>See Also</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getSeeAlso()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_SeeAlso();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSn <em>Sn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sn</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getSn()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Sn();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getSt <em>St</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>St</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getSt()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_St();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getStreet()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Street();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTelephoneNumber <em>Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telephone Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getTelephoneNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_TelephoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Teletex Terminal Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getTeletexTerminalIdentifier()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_TeletexTerminalIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTelexNumber <em>Telex Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telex Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getTelexNumber()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_TelexNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailLogo <em>Thumbnail Logo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thumbnail Logo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailLogo()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_ThumbnailLogo();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailPhoto <em>Thumbnail Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thumbnail Photo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getThumbnailPhoto()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_ThumbnailPhoto();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getTitle()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Title();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUid <em>Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getUid()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_Uid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getUniqueIdentifier()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_UniqueIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserCertificate <em>User Certificate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Certificate</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getUserCertificate()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_UserCertificate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPassword <em>User Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPassword()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_UserPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPKCS12 <em>User PKCS12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User PKCS12</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getUserPKCS12()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_UserPKCS12();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getUserSMIMECertificate <em>User SMIME Certificate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User SMIME Certificate</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getUserSMIMECertificate()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_UserSMIMECertificate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getX121Address <em>X121 Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X121 Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getX121Address()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_X121Address();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.EPerson#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X500 Unique Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.EPerson#getX500UniqueIdentifier()
	 * @see #getEPerson()
	 * @generated
	 */
	EAttribute getEPerson_X500UniqueIdentifier();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson <em>Inet Org Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inet Org Person</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson
	 * @generated
	 */
	EClass getInetOrgPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccessHint <em>Access Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Hint</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccessHint()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_AccessHint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccountHint <em>Account Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Hint</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAccountHint()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_AccountHint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAudio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audio</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getAudio()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Audio();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getBusinessCategory <em>Business Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Business Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getBusinessCategory()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_BusinessCategory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>C</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getC()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_C();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getCarLicense <em>Car License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Car License</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getCarLicense()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_CarLicense();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getConfigPtr <em>Config Ptr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config Ptr</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getConfigPtr()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_ConfigPtr();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getDepartmentNumber <em>Department Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Department Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getDepartmentNumber()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_DepartmentNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeNumber <em>Employee Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Employee Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeNumber()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_EmployeeNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeType <em>Employee Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Employee Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getEmployeeType()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_EmployeeType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGenerationQualifier <em>Generation Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generation Qualifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGenerationQualifier()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_GenerationQualifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGivenName <em>Given Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Given Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getGivenName()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_GivenName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomeFax <em>Home Fax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Fax</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomeFax()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_HomeFax();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePhone <em>Home Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Phone</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePhone()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_HomePhone();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePostalAddress <em>Home Postal Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Postal Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getHomePostalAddress()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_HomePostalAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getInitials <em>Initials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initials</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getInitials()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Initials();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getJpegPhoto <em>Jpeg Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jpeg Photo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getJpegPhoto()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_JpegPhoto();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getLabeledURI <em>Labeled URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Labeled URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getLabeledURI()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_LabeledURI();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMail <em>Mail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMail()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Mail();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manager</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getManager()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Manager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMiddleName <em>Middle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Middle Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMiddleName()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_MiddleName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMobile <em>Mobile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mobile</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getMobile()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Mobile();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getO <em>O</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>O</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getO()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_O();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOrganizationalStatus <em>Organizational Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Organizational Status</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOrganizationalStatus()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_OrganizationalStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOtherMailbox <em>Other Mailbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Mailbox</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getOtherMailbox()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_OtherMailbox();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPager <em>Pager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pager</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPager()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Pager();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPersonalTitle <em>Personal Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Personal Title</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPersonalTitle()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_PersonalTitle();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPhoto <em>Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Photo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPhoto()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Photo();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPreferredLanguage <em>Preferred Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Language</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getPreferredLanguage()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_PreferredLanguage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getRoomNumber <em>Room Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Room Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getRoomNumber()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_RoomNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getSecretary <em>Secretary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secretary</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getSecretary()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Secretary();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailLogo <em>Thumbnail Logo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thumbnail Logo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailLogo()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_ThumbnailLogo();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailPhoto <em>Thumbnail Photo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thumbnail Photo</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getThumbnailPhoto()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_ThumbnailPhoto();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUid <em>Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUid()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_Uid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUniqueIdentifier()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_UniqueIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserCertificate <em>User Certificate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Certificate</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserCertificate()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_UserCertificate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserPKCS12 <em>User PKCS12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User PKCS12</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserPKCS12()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_UserPKCS12();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserSMIMECertificate <em>User SMIME Certificate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User SMIME Certificate</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getUserSMIMECertificate()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_UserSMIMECertificate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getX500UniqueIdentifier <em>X500 Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X500 Unique Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.InetOrgPerson#getX500UniqueIdentifier()
	 * @see #getInetOrgPerson()
	 * @generated
	 */
	EAttribute getInetOrgPerson_X500UniqueIdentifier();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapAuxiliaryClass <em>Auxiliary Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auxiliary Class</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapAuxiliaryClass
	 * @generated
	 */
	EClass getLdapAuxiliaryClass();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapClient <em>Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapClient
	 * @generated
	 */
	EClass getLdapClient();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapClientUnit <em>Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapClientUnit
	 * @generated
	 */
	EClass getLdapClientUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot
	 * @generated
	 */
	EClass getLdapDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getMixed()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EAttribute getLdapDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getXMLNSPrefixMap()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getXSISchemaLocation()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapClient <em>Capability Ldap Client</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ldap Client</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapClient()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_CapabilityLdapClient();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapEntry <em>Capability Ldap Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ldap Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapEntry()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_CapabilityLdapEntry();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapLdif <em>Capability Ldap Ldif</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ldap Ldif</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapLdif()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_CapabilityLdapLdif();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSchema <em>Capability Ldap Schema</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ldap Schema</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSchema()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_CapabilityLdapSchema();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapServer <em>Capability Ldap Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ldap Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapServer()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_CapabilityLdapServer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSuffix <em>Capability Ldap Suffix</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Ldap Suffix</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getCapabilityLdapSuffix()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_CapabilityLdapSuffix();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEPerson <em>Ldap EPerson</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap EPerson</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEPerson()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapEPerson();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapInetOrgPerson <em>Ldap Inet Org Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Inet Org Person</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapInetOrgPerson()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapInetOrgPerson();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganization <em>Ldap Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Organization</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganization()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapOrganization();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganizationalPerson <em>Ldap Organizational Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Organizational Person</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapOrganizationalPerson()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapOrganizationalPerson();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapPerson <em>Ldap Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Person</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapPerson()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapPerson();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEntryUnit <em>Ldap Entry Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Entry Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapEntryUnit()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapEntryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapServerUnit <em>Ldap Server Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapServerUnit()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapServerUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapSuffixUnit <em>Ldap Suffix Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ldap Suffix Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getLdapSuffixUnit()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_LdapSuffixUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapClientUnit <em>Unit Ldap Client Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ldap Client Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapClientUnit()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_UnitLdapClientUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapLdifUnit <em>Unit Ldap Ldif Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ldap Ldif Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapLdifUnit()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_UnitLdapLdifUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapRoleReference <em>Unit Ldap Role Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ldap Role Reference</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapRoleReference()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_UnitLdapRoleReference();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapSchemaUnit <em>Unit Ldap Schema Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ldap Schema Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdapSchemaUnit()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_UnitLdapSchemaUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdifArtifact <em>Unit Ldif Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Ldif Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitLdifArtifact()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_UnitLdifArtifact();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitSchemaArtifact <em>Unit Schema Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Schema Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapDeployRoot#getUnitSchemaArtifact()
	 * @see #getLdapDeployRoot()
	 * @generated
	 */
	EReference getLdapDeployRoot_UnitSchemaArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapEntry
	 * @generated
	 */
	EClass getLdapEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapEntry#getRelativeDN <em>Relative DN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative DN</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapEntry#getRelativeDN()
	 * @see #getLdapEntry()
	 * @generated
	 */
	EAttribute getLdapEntry_RelativeDN();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapEntryUnit <em>Entry Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapEntryUnit
	 * @generated
	 */
	EClass getLdapEntryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif <em>Ldif</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ldif</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapLdif
	 * @generated
	 */
	EClass getLdapLdif();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapLdif#getAction()
	 * @see #getLdapLdif()
	 * @generated
	 */
	EAttribute getLdapLdif_Action();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdif#getSubtreeDn <em>Subtree Dn</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subtree Dn</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapLdif#getSubtreeDn()
	 * @see #getLdapLdif()
	 * @generated
	 */
	EAttribute getLdapLdif_SubtreeDn();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit <em>Ldif Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ldif Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit
	 * @generated
	 */
	EClass getLdapLdifUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapObject
	 * @generated
	 */
	EClass getLdapObject();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapSchema
	 * @generated
	 */
	EClass getLdapSchema();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapSchema#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapSchema#getAction()
	 * @see #getLdapSchema()
	 * @generated
	 */
	EAttribute getLdapSchema_Action();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapSchemaUnit <em>Schema Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapSchemaUnit
	 * @generated
	 */
	EClass getLdapSchemaUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer <em>Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapServer
	 * @generated
	 */
	EClass getLdapServer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorDN <em>Administrator DN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Administrator DN</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorDN()
	 * @see #getLdapServer()
	 * @generated
	 */
	EAttribute getLdapServer_AdministratorDN();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorPassword <em>Administrator Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Administrator Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapServer#getAdministratorPassword()
	 * @see #getLdapServer()
	 * @generated
	 */
	EAttribute getLdapServer_AdministratorPassword();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapServerUnit <em>Server Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapServerUnit
	 * @generated
	 */
	EClass getLdapServerUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Suffix</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapSuffix
	 * @generated
	 */
	EClass getLdapSuffix();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.LdapSuffix#getSuffixDN <em>Suffix DN</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix DN</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapSuffix#getSuffixDN()
	 * @see #getLdapSuffix()
	 * @generated
	 */
	EAttribute getLdapSuffix_SuffixDN();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit <em>Suffix Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Suffix Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit
	 * @generated
	 */
	EClass getLdapSuffixUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.LdifArtifact <em>Ldif Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ldif Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifArtifact
	 * @generated
	 */
	EClass getLdifArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization
	 * @generated
	 */
	EClass getOrganization();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getBusinessCategory <em>Business Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Business Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getBusinessCategory()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_BusinessCategory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getDescription1()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getDestinationIndicator <em>Destination Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Indicator</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getDestinationIndicator()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_DestinationIndicator();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facsimile Telephone Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getFacsimileTelephoneNumber()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_FacsimileTelephoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getInternationalISDNNumber <em>International ISDN Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>International ISDN Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getInternationalISDNNumber()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_InternationalISDNNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getL <em>L</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getL()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_L();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getO <em>O</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>O</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getO()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_O();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physical Delivery Office Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getPhysicalDeliveryOfficeName()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_PhysicalDeliveryOfficeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostalAddress <em>Postal Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getPostalAddress()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_PostalAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getPostalCode()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_PostalCode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPostOfficeBox <em>Post Office Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Office Box</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getPostOfficeBox()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_PostOfficeBox();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Delivery Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getPreferredDeliveryMethod()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_PreferredDeliveryMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getRegisteredAddress <em>Registered Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registered Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getRegisteredAddress()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_RegisteredAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSearchGuide <em>Search Guide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Search Guide</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getSearchGuide()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_SearchGuide();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSeeAlso <em>See Also</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>See Also</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getSeeAlso()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_SeeAlso();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getSt <em>St</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>St</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getSt()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_St();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getStreet()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Street();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTelephoneNumber <em>Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telephone Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getTelephoneNumber()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_TelephoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Teletex Terminal Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getTeletexTerminalIdentifier()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_TeletexTerminalIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getTelexNumber <em>Telex Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telex Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getTelexNumber()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_TelexNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getUserPassword <em>User Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getUserPassword()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_UserPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Organization#getX121address <em>X12 1address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X12 1address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Organization#getX121address()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_X121address();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson <em>Organizational Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organizational Person</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson
	 * @generated
	 */
	EClass getOrganizationalPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getDestinationIndicator <em>Destination Indicator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Indicator</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getDestinationIndicator()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_DestinationIndicator();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getFacsimileTelephoneNumber <em>Facsimile Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facsimile Telephone Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getFacsimileTelephoneNumber()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_FacsimileTelephoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getInternationalISDNNumber <em>International ISDN Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>International ISDN Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getInternationalISDNNumber()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_InternationalISDNNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getL <em>L</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>L</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getL()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_L();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getOu <em>Ou</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ou</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getOu()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_Ou();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPhysicalDeliveryOfficeName <em>Physical Delivery Office Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physical Delivery Office Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPhysicalDeliveryOfficeName()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_PhysicalDeliveryOfficeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalAddress <em>Postal Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalAddress()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_PostalAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostalCode()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_PostalCode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostOfficeBox <em>Post Office Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Office Box</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPostOfficeBox()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_PostOfficeBox();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPreferredDeliveryMethod <em>Preferred Delivery Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preferred Delivery Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getPreferredDeliveryMethod()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_PreferredDeliveryMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getRegisteredAddress <em>Registered Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registered Address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getRegisteredAddress()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_RegisteredAddress();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getSt <em>St</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>St</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getSt()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_St();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getStreet <em>Street</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getStreet()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_Street();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTeletexTerminalIdentifier <em>Teletex Terminal Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Teletex Terminal Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTeletexTerminalIdentifier()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_TeletexTerminalIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTelexNumber <em>Telex Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telex Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTelexNumber()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_TelexNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getTitle()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_Title();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getX121address <em>X12 1address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X12 1address</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.OrganizationalPerson#getX121address()
	 * @see #getOrganizationalPerson()
	 * @generated
	 */
	EAttribute getOrganizationalPerson_X121address();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Person#getCn <em>Cn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cn</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Person#getCn()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Cn();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Person#getSeeAlso <em>See Also</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>See Also</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Person#getSeeAlso()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_SeeAlso();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Person#getSn <em>Sn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sn</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Person#getSn()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Sn();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Person#getTelephoneNumber <em>Telephone Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Telephone Number</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Person#getTelephoneNumber()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_TelephoneNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.ldap.Person#getUserPassword <em>User Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Person#getUserPassword()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_UserPassword();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.SchemaArtifact <em>Schema Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schema Artifact</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaArtifact
	 * @generated
	 */
	EClass getSchemaArtifact();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit <em>Security Role Reference Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Role Reference Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.SecurityRoleReferenceUnit
	 * @generated
	 */
	EClass getSecurityRoleReferenceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.ldap.Top <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.Top
	 * @generated
	 */
	EClass getTop();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.ldap.LdifAction <em>Ldif Action</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ldif Action</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
	 * @generated
	 */
	EEnum getLdifAction();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.ldap.SchemaAction <em>Schema Action</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Schema Action</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
	 * @generated
	 */
	EEnum getSchemaAction();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.ldap.LdifAction <em>Ldif Action Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ldif Action Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
	 * @model instanceClass="com.ibm.ccl.soa.deploy.ldap.LdifAction"
	 *        extendedMetaData="name='LdifAction:Object' baseType='LdifAction'"
	 * @generated
	 */
	EDataType getLdifActionObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.ldap.SchemaAction <em>Schema Action Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Schema Action Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
	 * @model instanceClass="com.ibm.ccl.soa.deploy.ldap.SchemaAction"
	 *        extendedMetaData="name='SchemaAction:Object' baseType='SchemaAction'"
	 * @generated
	 */
	EDataType getSchemaActionObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LdapFactory getLdapFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.EPersonImpl <em>EPerson</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.EPersonImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getEPerson()
		 * @generated
		 */
		EClass EPERSON = eINSTANCE.getEPerson();

		/**
		 * The meta object literal for the '<em><b>Access Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__ACCESS_HINT = eINSTANCE.getEPerson_AccessHint();

		/**
		 * The meta object literal for the '<em><b>Account Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__ACCOUNT_HINT = eINSTANCE.getEPerson_AccountHint();

		/**
		 * The meta object literal for the '<em><b>Audio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__AUDIO = eINSTANCE.getEPerson_Audio();

		/**
		 * The meta object literal for the '<em><b>Business Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__BUSINESS_CATEGORY = eINSTANCE.getEPerson_BusinessCategory();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__C = eINSTANCE.getEPerson_C();

		/**
		 * The meta object literal for the '<em><b>Car License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__CAR_LICENSE = eINSTANCE.getEPerson_CarLicense();

		/**
		 * The meta object literal for the '<em><b>Cn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__CN = eINSTANCE.getEPerson_Cn();

		/**
		 * The meta object literal for the '<em><b>Config Ptr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__CONFIG_PTR = eINSTANCE.getEPerson_ConfigPtr();

		/**
		 * The meta object literal for the '<em><b>Department Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__DEPARTMENT_NUMBER = eINSTANCE.getEPerson_DepartmentNumber();

		/**
		 * The meta object literal for the '<em><b>Destination Indicator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__DESTINATION_INDICATOR = eINSTANCE.getEPerson_DestinationIndicator();

		/**
		 * The meta object literal for the '<em><b>Employee Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__EMPLOYEE_NUMBER = eINSTANCE.getEPerson_EmployeeNumber();

		/**
		 * The meta object literal for the '<em><b>Employee Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__EMPLOYEE_TYPE = eINSTANCE.getEPerson_EmployeeType();

		/**
		 * The meta object literal for the '<em><b>Facsimile Telephone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__FACSIMILE_TELEPHONE_NUMBER = eINSTANCE.getEPerson_FacsimileTelephoneNumber();

		/**
		 * The meta object literal for the '<em><b>Generation Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__GENERATION_QUALIFIER = eINSTANCE.getEPerson_GenerationQualifier();

		/**
		 * The meta object literal for the '<em><b>Given Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__GIVEN_NAME = eINSTANCE.getEPerson_GivenName();

		/**
		 * The meta object literal for the '<em><b>Home Fax</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__HOME_FAX = eINSTANCE.getEPerson_HomeFax();

		/**
		 * The meta object literal for the '<em><b>Home Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__HOME_PHONE = eINSTANCE.getEPerson_HomePhone();

		/**
		 * The meta object literal for the '<em><b>Home Postal Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__HOME_POSTAL_ADDRESS = eINSTANCE.getEPerson_HomePostalAddress();

		/**
		 * The meta object literal for the '<em><b>Initials</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__INITIALS = eINSTANCE.getEPerson_Initials();

		/**
		 * The meta object literal for the '<em><b>International ISD Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__INTERNATIONAL_ISD_NUMBER = eINSTANCE.getEPerson_InternationalISDNumber();

		/**
		 * The meta object literal for the '<em><b>Jpeg Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__JPEG_PHOTO = eINSTANCE.getEPerson_JpegPhoto();

		/**
		 * The meta object literal for the '<em><b>L</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__L = eINSTANCE.getEPerson_L();

		/**
		 * The meta object literal for the '<em><b>Labeled URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__LABELED_URI = eINSTANCE.getEPerson_LabeledURI();

		/**
		 * The meta object literal for the '<em><b>Mail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__MAIL = eINSTANCE.getEPerson_Mail();

		/**
		 * The meta object literal for the '<em><b>Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__MANAGER = eINSTANCE.getEPerson_Manager();

		/**
		 * The meta object literal for the '<em><b>Middle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__MIDDLE_NAME = eINSTANCE.getEPerson_MiddleName();

		/**
		 * The meta object literal for the '<em><b>Mobile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__MOBILE = eINSTANCE.getEPerson_Mobile();

		/**
		 * The meta object literal for the '<em><b>O</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__O = eINSTANCE.getEPerson_O();

		/**
		 * The meta object literal for the '<em><b>Organizational Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__ORGANIZATIONAL_STATUS = eINSTANCE.getEPerson_OrganizationalStatus();

		/**
		 * The meta object literal for the '<em><b>Other Mailbox</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__OTHER_MAILBOX = eINSTANCE.getEPerson_OtherMailbox();

		/**
		 * The meta object literal for the '<em><b>Ou</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__OU = eINSTANCE.getEPerson_Ou();

		/**
		 * The meta object literal for the '<em><b>Pager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__PAGER = eINSTANCE.getEPerson_Pager();

		/**
		 * The meta object literal for the '<em><b>Personal Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__PERSONAL_TITLE = eINSTANCE.getEPerson_PersonalTitle();

		/**
		 * The meta object literal for the '<em><b>Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__PHOTO = eINSTANCE.getEPerson_Photo();

		/**
		 * The meta object literal for the '<em><b>Physical Delivery Office Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__PHYSICAL_DELIVERY_OFFICE_NAME = eINSTANCE.getEPerson_PhysicalDeliveryOfficeName();

		/**
		 * The meta object literal for the '<em><b>Postal Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__POSTAL_ADDRESS = eINSTANCE.getEPerson_PostalAddress();

		/**
		 * The meta object literal for the '<em><b>Postal Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__POSTAL_CODE = eINSTANCE.getEPerson_PostalCode();

		/**
		 * The meta object literal for the '<em><b>Post Officebox</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__POST_OFFICEBOX = eINSTANCE.getEPerson_PostOfficebox();

		/**
		 * The meta object literal for the '<em><b>Preferred Delivery Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__PREFERRED_DELIVERY_METHOD = eINSTANCE.getEPerson_PreferredDeliveryMethod();

		/**
		 * The meta object literal for the '<em><b>Preferred Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__PREFERRED_LANGUAGE = eINSTANCE.getEPerson_PreferredLanguage();

		/**
		 * The meta object literal for the '<em><b>Registered Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__REGISTERED_ADDRESS = eINSTANCE.getEPerson_RegisteredAddress();

		/**
		 * The meta object literal for the '<em><b>Room Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__ROOM_NUMBER = eINSTANCE.getEPerson_RoomNumber();

		/**
		 * The meta object literal for the '<em><b>Secretary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__SECRETARY = eINSTANCE.getEPerson_Secretary();

		/**
		 * The meta object literal for the '<em><b>See Also</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__SEE_ALSO = eINSTANCE.getEPerson_SeeAlso();

		/**
		 * The meta object literal for the '<em><b>Sn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__SN = eINSTANCE.getEPerson_Sn();

		/**
		 * The meta object literal for the '<em><b>St</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__ST = eINSTANCE.getEPerson_St();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__STREET = eINSTANCE.getEPerson_Street();

		/**
		 * The meta object literal for the '<em><b>Telephone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__TELEPHONE_NUMBER = eINSTANCE.getEPerson_TelephoneNumber();

		/**
		 * The meta object literal for the '<em><b>Teletex Terminal Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__TELETEX_TERMINAL_IDENTIFIER = eINSTANCE.getEPerson_TeletexTerminalIdentifier();

		/**
		 * The meta object literal for the '<em><b>Telex Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__TELEX_NUMBER = eINSTANCE.getEPerson_TelexNumber();

		/**
		 * The meta object literal for the '<em><b>Thumbnail Logo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__THUMBNAIL_LOGO = eINSTANCE.getEPerson_ThumbnailLogo();

		/**
		 * The meta object literal for the '<em><b>Thumbnail Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__THUMBNAIL_PHOTO = eINSTANCE.getEPerson_ThumbnailPhoto();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__TITLE = eINSTANCE.getEPerson_Title();

		/**
		 * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__UID = eINSTANCE.getEPerson_Uid();

		/**
		 * The meta object literal for the '<em><b>Unique Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__UNIQUE_IDENTIFIER = eINSTANCE.getEPerson_UniqueIdentifier();

		/**
		 * The meta object literal for the '<em><b>User Certificate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__USER_CERTIFICATE = eINSTANCE.getEPerson_UserCertificate();

		/**
		 * The meta object literal for the '<em><b>User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__USER_PASSWORD = eINSTANCE.getEPerson_UserPassword();

		/**
		 * The meta object literal for the '<em><b>User PKCS12</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__USER_PKCS12 = eINSTANCE.getEPerson_UserPKCS12();

		/**
		 * The meta object literal for the '<em><b>User SMIME Certificate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__USER_SMIME_CERTIFICATE = eINSTANCE.getEPerson_UserSMIMECertificate();

		/**
		 * The meta object literal for the '<em><b>X121 Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__X121_ADDRESS = eINSTANCE.getEPerson_X121Address();

		/**
		 * The meta object literal for the '<em><b>X500 Unique Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EPERSON__X500_UNIQUE_IDENTIFIER = eINSTANCE.getEPerson_X500UniqueIdentifier();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl <em>Inet Org Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.InetOrgPersonImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getInetOrgPerson()
		 * @generated
		 */
		EClass INET_ORG_PERSON = eINSTANCE.getInetOrgPerson();

		/**
		 * The meta object literal for the '<em><b>Access Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__ACCESS_HINT = eINSTANCE.getInetOrgPerson_AccessHint();

		/**
		 * The meta object literal for the '<em><b>Account Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__ACCOUNT_HINT = eINSTANCE.getInetOrgPerson_AccountHint();

		/**
		 * The meta object literal for the '<em><b>Audio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__AUDIO = eINSTANCE.getInetOrgPerson_Audio();

		/**
		 * The meta object literal for the '<em><b>Business Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__BUSINESS_CATEGORY = eINSTANCE.getInetOrgPerson_BusinessCategory();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__C = eINSTANCE.getInetOrgPerson_C();

		/**
		 * The meta object literal for the '<em><b>Car License</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__CAR_LICENSE = eINSTANCE.getInetOrgPerson_CarLicense();

		/**
		 * The meta object literal for the '<em><b>Config Ptr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__CONFIG_PTR = eINSTANCE.getInetOrgPerson_ConfigPtr();

		/**
		 * The meta object literal for the '<em><b>Department Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__DEPARTMENT_NUMBER = eINSTANCE.getInetOrgPerson_DepartmentNumber();

		/**
		 * The meta object literal for the '<em><b>Employee Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__EMPLOYEE_NUMBER = eINSTANCE.getInetOrgPerson_EmployeeNumber();

		/**
		 * The meta object literal for the '<em><b>Employee Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__EMPLOYEE_TYPE = eINSTANCE.getInetOrgPerson_EmployeeType();

		/**
		 * The meta object literal for the '<em><b>Generation Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__GENERATION_QUALIFIER = eINSTANCE.getInetOrgPerson_GenerationQualifier();

		/**
		 * The meta object literal for the '<em><b>Given Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__GIVEN_NAME = eINSTANCE.getInetOrgPerson_GivenName();

		/**
		 * The meta object literal for the '<em><b>Home Fax</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__HOME_FAX = eINSTANCE.getInetOrgPerson_HomeFax();

		/**
		 * The meta object literal for the '<em><b>Home Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__HOME_PHONE = eINSTANCE.getInetOrgPerson_HomePhone();

		/**
		 * The meta object literal for the '<em><b>Home Postal Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__HOME_POSTAL_ADDRESS = eINSTANCE.getInetOrgPerson_HomePostalAddress();

		/**
		 * The meta object literal for the '<em><b>Initials</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__INITIALS = eINSTANCE.getInetOrgPerson_Initials();

		/**
		 * The meta object literal for the '<em><b>Jpeg Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__JPEG_PHOTO = eINSTANCE.getInetOrgPerson_JpegPhoto();

		/**
		 * The meta object literal for the '<em><b>Labeled URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__LABELED_URI = eINSTANCE.getInetOrgPerson_LabeledURI();

		/**
		 * The meta object literal for the '<em><b>Mail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__MAIL = eINSTANCE.getInetOrgPerson_Mail();

		/**
		 * The meta object literal for the '<em><b>Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__MANAGER = eINSTANCE.getInetOrgPerson_Manager();

		/**
		 * The meta object literal for the '<em><b>Middle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__MIDDLE_NAME = eINSTANCE.getInetOrgPerson_MiddleName();

		/**
		 * The meta object literal for the '<em><b>Mobile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__MOBILE = eINSTANCE.getInetOrgPerson_Mobile();

		/**
		 * The meta object literal for the '<em><b>O</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__O = eINSTANCE.getInetOrgPerson_O();

		/**
		 * The meta object literal for the '<em><b>Organizational Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__ORGANIZATIONAL_STATUS = eINSTANCE.getInetOrgPerson_OrganizationalStatus();

		/**
		 * The meta object literal for the '<em><b>Other Mailbox</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__OTHER_MAILBOX = eINSTANCE.getInetOrgPerson_OtherMailbox();

		/**
		 * The meta object literal for the '<em><b>Pager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__PAGER = eINSTANCE.getInetOrgPerson_Pager();

		/**
		 * The meta object literal for the '<em><b>Personal Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__PERSONAL_TITLE = eINSTANCE.getInetOrgPerson_PersonalTitle();

		/**
		 * The meta object literal for the '<em><b>Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__PHOTO = eINSTANCE.getInetOrgPerson_Photo();

		/**
		 * The meta object literal for the '<em><b>Preferred Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__PREFERRED_LANGUAGE = eINSTANCE.getInetOrgPerson_PreferredLanguage();

		/**
		 * The meta object literal for the '<em><b>Room Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__ROOM_NUMBER = eINSTANCE.getInetOrgPerson_RoomNumber();

		/**
		 * The meta object literal for the '<em><b>Secretary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__SECRETARY = eINSTANCE.getInetOrgPerson_Secretary();

		/**
		 * The meta object literal for the '<em><b>Thumbnail Logo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__THUMBNAIL_LOGO = eINSTANCE.getInetOrgPerson_ThumbnailLogo();

		/**
		 * The meta object literal for the '<em><b>Thumbnail Photo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__THUMBNAIL_PHOTO = eINSTANCE.getInetOrgPerson_ThumbnailPhoto();

		/**
		 * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__UID = eINSTANCE.getInetOrgPerson_Uid();

		/**
		 * The meta object literal for the '<em><b>Unique Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__UNIQUE_IDENTIFIER = eINSTANCE.getInetOrgPerson_UniqueIdentifier();

		/**
		 * The meta object literal for the '<em><b>User Certificate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__USER_CERTIFICATE = eINSTANCE.getInetOrgPerson_UserCertificate();

		/**
		 * The meta object literal for the '<em><b>User PKCS12</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__USER_PKCS12 = eINSTANCE.getInetOrgPerson_UserPKCS12();

		/**
		 * The meta object literal for the '<em><b>User SMIME Certificate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__USER_SMIME_CERTIFICATE = eINSTANCE.getInetOrgPerson_UserSMIMECertificate();

		/**
		 * The meta object literal for the '<em><b>X500 Unique Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INET_ORG_PERSON__X500_UNIQUE_IDENTIFIER = eINSTANCE.getInetOrgPerson_X500UniqueIdentifier();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapAuxiliaryClassImpl <em>Auxiliary Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapAuxiliaryClassImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapAuxiliaryClass()
		 * @generated
		 */
		EClass LDAP_AUXILIARY_CLASS = eINSTANCE.getLdapAuxiliaryClass();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapClientImpl <em>Client</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapClientImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapClient()
		 * @generated
		 */
		EClass LDAP_CLIENT = eINSTANCE.getLdapClient();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapClientUnitImpl <em>Client Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapClientUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapClientUnit()
		 * @generated
		 */
		EClass LDAP_CLIENT_UNIT = eINSTANCE.getLdapClientUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapDeployRoot()
		 * @generated
		 */
		EClass LDAP_DEPLOY_ROOT = eINSTANCE.getLdapDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LDAP_DEPLOY_ROOT__MIXED = eINSTANCE.getLdapDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getLdapDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getLdapDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Ldap Client</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_CLIENT = eINSTANCE.getLdapDeployRoot_CapabilityLdapClient();

		/**
		 * The meta object literal for the '<em><b>Capability Ldap Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_ENTRY = eINSTANCE.getLdapDeployRoot_CapabilityLdapEntry();

		/**
		 * The meta object literal for the '<em><b>Capability Ldap Ldif</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_LDIF = eINSTANCE.getLdapDeployRoot_CapabilityLdapLdif();

		/**
		 * The meta object literal for the '<em><b>Capability Ldap Schema</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SCHEMA = eINSTANCE.getLdapDeployRoot_CapabilityLdapSchema();

		/**
		 * The meta object literal for the '<em><b>Capability Ldap Server</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SERVER = eINSTANCE.getLdapDeployRoot_CapabilityLdapServer();

		/**
		 * The meta object literal for the '<em><b>Capability Ldap Suffix</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__CAPABILITY_LDAP_SUFFIX = eINSTANCE.getLdapDeployRoot_CapabilityLdapSuffix();

		/**
		 * The meta object literal for the '<em><b>Ldap EPerson</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_EPERSON = eINSTANCE.getLdapDeployRoot_LdapEPerson();

		/**
		 * The meta object literal for the '<em><b>Ldap Inet Org Person</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_INET_ORG_PERSON = eINSTANCE.getLdapDeployRoot_LdapInetOrgPerson();

		/**
		 * The meta object literal for the '<em><b>Ldap Organization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_ORGANIZATION = eINSTANCE.getLdapDeployRoot_LdapOrganization();

		/**
		 * The meta object literal for the '<em><b>Ldap Organizational Person</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_ORGANIZATIONAL_PERSON = eINSTANCE.getLdapDeployRoot_LdapOrganizationalPerson();

		/**
		 * The meta object literal for the '<em><b>Ldap Person</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_PERSON = eINSTANCE.getLdapDeployRoot_LdapPerson();

		/**
		 * The meta object literal for the '<em><b>Ldap Entry Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_ENTRY_UNIT = eINSTANCE.getLdapDeployRoot_LdapEntryUnit();

		/**
		 * The meta object literal for the '<em><b>Ldap Server Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_SERVER_UNIT = eINSTANCE.getLdapDeployRoot_LdapServerUnit();

		/**
		 * The meta object literal for the '<em><b>Ldap Suffix Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__LDAP_SUFFIX_UNIT = eINSTANCE.getLdapDeployRoot_LdapSuffixUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ldap Client Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__UNIT_LDAP_CLIENT_UNIT = eINSTANCE.getLdapDeployRoot_UnitLdapClientUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ldap Ldif Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__UNIT_LDAP_LDIF_UNIT = eINSTANCE.getLdapDeployRoot_UnitLdapLdifUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ldap Role Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__UNIT_LDAP_ROLE_REFERENCE = eINSTANCE.getLdapDeployRoot_UnitLdapRoleReference();

		/**
		 * The meta object literal for the '<em><b>Unit Ldap Schema Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__UNIT_LDAP_SCHEMA_UNIT = eINSTANCE.getLdapDeployRoot_UnitLdapSchemaUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Ldif Artifact</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__UNIT_LDIF_ARTIFACT = eINSTANCE.getLdapDeployRoot_UnitLdifArtifact();

		/**
		 * The meta object literal for the '<em><b>Unit Schema Artifact</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDAP_DEPLOY_ROOT__UNIT_SCHEMA_ARTIFACT = eINSTANCE.getLdapDeployRoot_UnitSchemaArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapEntry()
		 * @generated
		 */
		EClass LDAP_ENTRY = eINSTANCE.getLdapEntry();

		/**
		 * The meta object literal for the '<em><b>Relative DN</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LDAP_ENTRY__RELATIVE_DN = eINSTANCE.getLdapEntry_RelativeDN();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryUnitImpl <em>Entry Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapEntryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapEntryUnit()
		 * @generated
		 */
		EClass LDAP_ENTRY_UNIT = eINSTANCE.getLdapEntryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifImpl <em>Ldif</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapLdif()
		 * @generated
		 */
		EClass LDAP_LDIF = eINSTANCE.getLdapLdif();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LDAP_LDIF__ACTION = eINSTANCE.getLdapLdif_Action();

		/**
		 * The meta object literal for the '<em><b>Subtree Dn</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LDAP_LDIF__SUBTREE_DN = eINSTANCE.getLdapLdif_SubtreeDn();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifUnitImpl <em>Ldif Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapLdifUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapLdifUnit()
		 * @generated
		 */
		EClass LDAP_LDIF_UNIT = eINSTANCE.getLdapLdifUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapObjectImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapObject()
		 * @generated
		 */
		EClass LDAP_OBJECT = eINSTANCE.getLdapObject();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaImpl <em>Schema</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSchema()
		 * @generated
		 */
		EClass LDAP_SCHEMA = eINSTANCE.getLdapSchema();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LDAP_SCHEMA__ACTION = eINSTANCE.getLdapSchema_Action();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaUnitImpl <em>Schema Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSchemaUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSchemaUnit()
		 * @generated
		 */
		EClass LDAP_SCHEMA_UNIT = eINSTANCE.getLdapSchemaUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapServerImpl <em>Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapServerImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapServer()
		 * @generated
		 */
		EClass LDAP_SERVER = eINSTANCE.getLdapServer();

		/**
		 * The meta object literal for the '<em><b>Administrator DN</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LDAP_SERVER__ADMINISTRATOR_DN = eINSTANCE.getLdapServer_AdministratorDN();

		/**
		 * The meta object literal for the '<em><b>Administrator Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LDAP_SERVER__ADMINISTRATOR_PASSWORD = eINSTANCE.getLdapServer_AdministratorPassword();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapServerUnitImpl <em>Server Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapServerUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapServerUnit()
		 * @generated
		 */
		EClass LDAP_SERVER_UNIT = eINSTANCE.getLdapServerUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixImpl <em>Suffix</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSuffix()
		 * @generated
		 */
		EClass LDAP_SUFFIX = eINSTANCE.getLdapSuffix();

		/**
		 * The meta object literal for the '<em><b>Suffix DN</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LDAP_SUFFIX__SUFFIX_DN = eINSTANCE.getLdapSuffix_SuffixDN();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixUnitImpl <em>Suffix Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapSuffixUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdapSuffixUnit()
		 * @generated
		 */
		EClass LDAP_SUFFIX_UNIT = eINSTANCE.getLdapSuffixUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.LdifArtifactImpl <em>Ldif Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdifArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdifArtifact()
		 * @generated
		 */
		EClass LDIF_ARTIFACT = eINSTANCE.getLdifArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl <em>Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.OrganizationImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getOrganization()
		 * @generated
		 */
		EClass ORGANIZATION = eINSTANCE.getOrganization();

		/**
		 * The meta object literal for the '<em><b>Business Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__BUSINESS_CATEGORY = eINSTANCE.getOrganization_BusinessCategory();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__DESCRIPTION1 = eINSTANCE.getOrganization_Description1();

		/**
		 * The meta object literal for the '<em><b>Destination Indicator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__DESTINATION_INDICATOR = eINSTANCE.getOrganization_DestinationIndicator();

		/**
		 * The meta object literal for the '<em><b>Facsimile Telephone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__FACSIMILE_TELEPHONE_NUMBER = eINSTANCE.getOrganization_FacsimileTelephoneNumber();

		/**
		 * The meta object literal for the '<em><b>International ISDN Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__INTERNATIONAL_ISDN_NUMBER = eINSTANCE.getOrganization_InternationalISDNNumber();

		/**
		 * The meta object literal for the '<em><b>L</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__L = eINSTANCE.getOrganization_L();

		/**
		 * The meta object literal for the '<em><b>O</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__O = eINSTANCE.getOrganization_O();

		/**
		 * The meta object literal for the '<em><b>Physical Delivery Office Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__PHYSICAL_DELIVERY_OFFICE_NAME = eINSTANCE.getOrganization_PhysicalDeliveryOfficeName();

		/**
		 * The meta object literal for the '<em><b>Postal Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__POSTAL_ADDRESS = eINSTANCE.getOrganization_PostalAddress();

		/**
		 * The meta object literal for the '<em><b>Postal Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__POSTAL_CODE = eINSTANCE.getOrganization_PostalCode();

		/**
		 * The meta object literal for the '<em><b>Post Office Box</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__POST_OFFICE_BOX = eINSTANCE.getOrganization_PostOfficeBox();

		/**
		 * The meta object literal for the '<em><b>Preferred Delivery Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__PREFERRED_DELIVERY_METHOD = eINSTANCE.getOrganization_PreferredDeliveryMethod();

		/**
		 * The meta object literal for the '<em><b>Registered Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__REGISTERED_ADDRESS = eINSTANCE.getOrganization_RegisteredAddress();

		/**
		 * The meta object literal for the '<em><b>Search Guide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__SEARCH_GUIDE = eINSTANCE.getOrganization_SearchGuide();

		/**
		 * The meta object literal for the '<em><b>See Also</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__SEE_ALSO = eINSTANCE.getOrganization_SeeAlso();

		/**
		 * The meta object literal for the '<em><b>St</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__ST = eINSTANCE.getOrganization_St();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__STREET = eINSTANCE.getOrganization_Street();

		/**
		 * The meta object literal for the '<em><b>Telephone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__TELEPHONE_NUMBER = eINSTANCE.getOrganization_TelephoneNumber();

		/**
		 * The meta object literal for the '<em><b>Teletex Terminal Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__TELETEX_TERMINAL_IDENTIFIER = eINSTANCE.getOrganization_TeletexTerminalIdentifier();

		/**
		 * The meta object literal for the '<em><b>Telex Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__TELEX_NUMBER = eINSTANCE.getOrganization_TelexNumber();

		/**
		 * The meta object literal for the '<em><b>User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__USER_PASSWORD = eINSTANCE.getOrganization_UserPassword();

		/**
		 * The meta object literal for the '<em><b>X12 1address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__X121ADDRESS = eINSTANCE.getOrganization_X121address();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl <em>Organizational Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.OrganizationalPersonImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getOrganizationalPerson()
		 * @generated
		 */
		EClass ORGANIZATIONAL_PERSON = eINSTANCE.getOrganizationalPerson();

		/**
		 * The meta object literal for the '<em><b>Destination Indicator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__DESTINATION_INDICATOR = eINSTANCE.getOrganizationalPerson_DestinationIndicator();

		/**
		 * The meta object literal for the '<em><b>Facsimile Telephone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__FACSIMILE_TELEPHONE_NUMBER = eINSTANCE.getOrganizationalPerson_FacsimileTelephoneNumber();

		/**
		 * The meta object literal for the '<em><b>International ISDN Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__INTERNATIONAL_ISDN_NUMBER = eINSTANCE.getOrganizationalPerson_InternationalISDNNumber();

		/**
		 * The meta object literal for the '<em><b>L</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__L = eINSTANCE.getOrganizationalPerson_L();

		/**
		 * The meta object literal for the '<em><b>Ou</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__OU = eINSTANCE.getOrganizationalPerson_Ou();

		/**
		 * The meta object literal for the '<em><b>Physical Delivery Office Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__PHYSICAL_DELIVERY_OFFICE_NAME = eINSTANCE.getOrganizationalPerson_PhysicalDeliveryOfficeName();

		/**
		 * The meta object literal for the '<em><b>Postal Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__POSTAL_ADDRESS = eINSTANCE.getOrganizationalPerson_PostalAddress();

		/**
		 * The meta object literal for the '<em><b>Postal Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__POSTAL_CODE = eINSTANCE.getOrganizationalPerson_PostalCode();

		/**
		 * The meta object literal for the '<em><b>Post Office Box</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__POST_OFFICE_BOX = eINSTANCE.getOrganizationalPerson_PostOfficeBox();

		/**
		 * The meta object literal for the '<em><b>Preferred Delivery Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__PREFERRED_DELIVERY_METHOD = eINSTANCE.getOrganizationalPerson_PreferredDeliveryMethod();

		/**
		 * The meta object literal for the '<em><b>Registered Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__REGISTERED_ADDRESS = eINSTANCE.getOrganizationalPerson_RegisteredAddress();

		/**
		 * The meta object literal for the '<em><b>St</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__ST = eINSTANCE.getOrganizationalPerson_St();

		/**
		 * The meta object literal for the '<em><b>Street</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__STREET = eINSTANCE.getOrganizationalPerson_Street();

		/**
		 * The meta object literal for the '<em><b>Teletex Terminal Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__TELETEX_TERMINAL_IDENTIFIER = eINSTANCE.getOrganizationalPerson_TeletexTerminalIdentifier();

		/**
		 * The meta object literal for the '<em><b>Telex Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__TELEX_NUMBER = eINSTANCE.getOrganizationalPerson_TelexNumber();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__TITLE = eINSTANCE.getOrganizationalPerson_Title();

		/**
		 * The meta object literal for the '<em><b>X12 1address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATIONAL_PERSON__X121ADDRESS = eINSTANCE.getOrganizationalPerson_X121address();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.PersonImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Cn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__CN = eINSTANCE.getPerson_Cn();

		/**
		 * The meta object literal for the '<em><b>See Also</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SEE_ALSO = eINSTANCE.getPerson_SeeAlso();

		/**
		 * The meta object literal for the '<em><b>Sn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SN = eINSTANCE.getPerson_Sn();

		/**
		 * The meta object literal for the '<em><b>Telephone Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__TELEPHONE_NUMBER = eINSTANCE.getPerson_TelephoneNumber();

		/**
		 * The meta object literal for the '<em><b>User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__USER_PASSWORD = eINSTANCE.getPerson_UserPassword();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.SchemaArtifactImpl <em>Schema Artifact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.SchemaArtifactImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSchemaArtifact()
		 * @generated
		 */
		EClass SCHEMA_ARTIFACT = eINSTANCE.getSchemaArtifact();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.SecurityRoleReferenceUnitImpl <em>Security Role Reference Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.SecurityRoleReferenceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSecurityRoleReferenceUnit()
		 * @generated
		 */
		EClass SECURITY_ROLE_REFERENCE_UNIT = eINSTANCE.getSecurityRoleReferenceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.impl.TopImpl <em>Top</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.TopImpl
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getTop()
		 * @generated
		 */
		EClass TOP = eINSTANCE.getTop();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.LdifAction <em>Ldif Action</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdifAction()
		 * @generated
		 */
		EEnum LDIF_ACTION = eINSTANCE.getLdifAction();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.ldap.SchemaAction <em>Schema Action</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSchemaAction()
		 * @generated
		 */
		EEnum SCHEMA_ACTION = eINSTANCE.getSchemaAction();

		/**
		 * The meta object literal for the '<em>Ldif Action Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.ldap.LdifAction
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getLdifActionObject()
		 * @generated
		 */
		EDataType LDIF_ACTION_OBJECT = eINSTANCE.getLdifActionObject();

		/**
		 * The meta object literal for the '<em>Schema Action Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.ldap.SchemaAction
		 * @see com.ibm.ccl.soa.deploy.ldap.impl.LdapPackageImpl#getSchemaActionObject()
		 * @generated
		 */
		EDataType SCHEMA_ACTION_OBJECT = eINSTANCE.getSchemaActionObject();

	}

} //LdapPackage
