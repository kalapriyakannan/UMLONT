/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.location.LocationFactory
 * @model kind="package"
 * @generated
 */
public interface LocationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "location"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/location/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "location"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	LocationPackage eINSTANCE = com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.location.impl.BindingEntryImpl <em>Binding Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.location.impl.BindingEntryImpl
	 * @see com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl#getBindingEntry()
	 * @generated
	 */
	int BINDING_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Dmo Path</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_ENTRY__DMO_PATH = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_ENTRY__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Binding Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl
	 * @see com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl#getLocationBinding()
	 * @generated
	 */
	int LOCATION_BINDING = 1;

	/**
	 * The feature id for the '<em><b>Binding Entry</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING__BINDING_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING__CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING__NAME = 2;

	/**
	 * The feature id for the '<em><b>Topology</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING__TOPOLOGY = 3;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl <em>Binding Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl
	 * @see com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl#getLocationBindingRoot()
	 * @generated
	 */
	int LOCATION_BINDING_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Binding Entry</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_ROOT__BINDING_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Location Binding</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_ROOT__LOCATION_BINDING = 4;

	/**
	 * The number of structural features of the '<em>Binding Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION_BINDING_ROOT_FEATURE_COUNT = 5;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.location.BindingEntry <em>Binding Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.BindingEntry
	 * @generated
	 */
	EClass getBindingEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.location.BindingEntry#getDmoPath <em>Dmo Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dmo Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.BindingEntry#getDmoPath()
	 * @see #getBindingEntry()
	 * @generated
	 */
	EAttribute getBindingEntry_DmoPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.location.BindingEntry#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.BindingEntry#getLocation()
	 * @see #getBindingEntry()
	 * @generated
	 */
	EAttribute getBindingEntry_Location();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.location.LocationBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBinding
	 * @generated
	 */
	EClass getLocationBinding();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getBindingEntry <em>Binding Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binding Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBinding#getBindingEntry()
	 * @see #getLocationBinding()
	 * @generated
	 */
	EReference getLocationBinding_BindingEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBinding#getContext()
	 * @see #getLocationBinding()
	 * @generated
	 */
	EAttribute getLocationBinding_Context();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBinding#getName()
	 * @see #getLocationBinding()
	 * @generated
	 */
	EAttribute getLocationBinding_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.location.LocationBinding#getTopology <em>Topology</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topology</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBinding#getTopology()
	 * @see #getLocationBinding()
	 * @generated
	 */
	EAttribute getLocationBinding_Topology();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.location.LocationBindingRoot <em>Binding Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBindingRoot
	 * @generated
	 */
	EClass getLocationBindingRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getMixed()
	 * @see #getLocationBindingRoot()
	 * @generated
	 */
	EAttribute getLocationBindingRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getXMLNSPrefixMap()
	 * @see #getLocationBindingRoot()
	 * @generated
	 */
	EReference getLocationBindingRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getXSISchemaLocation()
	 * @see #getLocationBindingRoot()
	 * @generated
	 */
	EReference getLocationBindingRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getBindingEntry <em>Binding Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getBindingEntry()
	 * @see #getLocationBindingRoot()
	 * @generated
	 */
	EReference getLocationBindingRoot_BindingEntry();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getLocationBinding <em>Location Binding</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location Binding</em>'.
	 * @see com.ibm.ccl.soa.deploy.location.LocationBindingRoot#getLocationBinding()
	 * @see #getLocationBindingRoot()
	 * @generated
	 */
	EReference getLocationBindingRoot_LocationBinding();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LocationFactory getLocationFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.location.impl.BindingEntryImpl <em>Binding Entry</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.location.impl.BindingEntryImpl
		 * @see com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl#getBindingEntry()
		 * @generated
		 */
		EClass BINDING_ENTRY = eINSTANCE.getBindingEntry();

		/**
		 * The meta object literal for the '<em><b>Dmo Path</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_ENTRY__DMO_PATH = eINSTANCE.getBindingEntry_DmoPath();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_ENTRY__LOCATION = eINSTANCE.getBindingEntry_Location();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.location.impl.LocationBindingImpl
		 * @see com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl#getLocationBinding()
		 * @generated
		 */
		EClass LOCATION_BINDING = eINSTANCE.getLocationBinding();

		/**
		 * The meta object literal for the '<em><b>Binding Entry</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION_BINDING__BINDING_ENTRY = eINSTANCE.getLocationBinding_BindingEntry();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOCATION_BINDING__CONTEXT = eINSTANCE.getLocationBinding_Context();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOCATION_BINDING__NAME = eINSTANCE.getLocationBinding_Name();

		/**
		 * The meta object literal for the '<em><b>Topology</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOCATION_BINDING__TOPOLOGY = eINSTANCE.getLocationBinding_Topology();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl <em>Binding Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl
		 * @see com.ibm.ccl.soa.deploy.location.impl.LocationPackageImpl#getLocationBindingRoot()
		 * @generated
		 */
		EClass LOCATION_BINDING_ROOT = eINSTANCE.getLocationBindingRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LOCATION_BINDING_ROOT__MIXED = eINSTANCE.getLocationBindingRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getLocationBindingRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getLocationBindingRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Binding Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION_BINDING_ROOT__BINDING_ENTRY = eINSTANCE.getLocationBindingRoot_BindingEntry();

		/**
		 * The meta object literal for the '<em><b>Location Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION_BINDING_ROOT__LOCATION_BINDING = eINSTANCE.getLocationBindingRoot_LocationBinding();

	}

} //LocationPackage
