/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.ibm.ccl.soa.deploy.generic.GenericFactory
 * @model kind="package"
 * @generated
 */
public interface GenericPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generic"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/generic/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generic"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	GenericPackage eINSTANCE = com.ibm.ccl.soa.deploy.generic.impl.GenericPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.generic.impl.GenericPackageImpl#getGenericDeployRoot()
	 * @generated
	 */
	int GENERIC_DEPLOY_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Generic</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC = 3;

	/**
	 * The feature id for the '<em><b>Unit Generic Unit</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT = 4;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DEPLOY_ROOT_FEATURE_COUNT = 5;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericDeployRoot
	 * @generated
	 */
	EClass getGenericDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getMixed()
	 * @see #getGenericDeployRoot()
	 * @generated
	 */
	EAttribute getGenericDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getXMLNSPrefixMap()
	 * @see #getGenericDeployRoot()
	 * @generated
	 */
	EReference getGenericDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getXSISchemaLocation()
	 * @see #getGenericDeployRoot()
	 * @generated
	 */
	EReference getGenericDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getCapabilityGeneric <em>Capability Generic</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Generic</em>'.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getCapabilityGeneric()
	 * @see #getGenericDeployRoot()
	 * @generated
	 */
	EReference getGenericDeployRoot_CapabilityGeneric();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getUnitGenericUnit <em>Unit Generic Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Generic Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.generic.GenericDeployRoot#getUnitGenericUnit()
	 * @see #getGenericDeployRoot()
	 * @generated
	 */
	EReference getGenericDeployRoot_UnitGenericUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenericFactory getGenericFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.generic.impl.GenericPackageImpl#getGenericDeployRoot()
		 * @generated
		 */
		EClass GENERIC_DEPLOY_ROOT = eINSTANCE.getGenericDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GENERIC_DEPLOY_ROOT__MIXED = eINSTANCE.getGenericDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getGenericDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getGenericDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Generic</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC = eINSTANCE.getGenericDeployRoot_CapabilityGeneric();

		/**
		 * The meta object literal for the '<em><b>Unit Generic Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT = eINSTANCE.getGenericDeployRoot_UnitGenericUnit();

	}

} //GenericPackage
