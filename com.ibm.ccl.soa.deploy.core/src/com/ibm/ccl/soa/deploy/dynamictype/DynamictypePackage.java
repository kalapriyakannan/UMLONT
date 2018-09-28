/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype;

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
 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypeFactory
 * @model kind="package"
 * @generated
 */
public interface DynamictypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dynamictype"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/dynamictype/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dynamictype"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DynamictypePackage eINSTANCE = com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl <em>Dynamic Palette Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicPaletteEntry()
	 * @generated
	 */
	int DYNAMIC_PALETTE_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Diagram Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__ID = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__KIND = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__LABEL = 4;

	/**
	 * The feature id for the '<em><b>Large Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__LARGE_ICON = 5;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__PATH = 6;

	/**
	 * The feature id for the '<em><b>Small Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__SMALL_ICON = 7;

	/**
	 * The feature id for the '<em><b>Template URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI = 8;

	/**
	 * The number of structural features of the '<em>Dynamic Palette Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_ENTRY_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteStackImpl <em>Dynamic Palette Stack</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteStackImpl
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicPaletteStack()
	 * @generated
	 */
	int DYNAMIC_PALETTE_STACK = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_STACK__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_STACK__ICON = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_STACK__ID = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_STACK__LABEL = 3;

	/**
	 * The number of structural features of the '<em>Dynamic Palette Stack</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_PALETTE_STACK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl <em>Dynamic Type Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicTypeRoot()
	 * @generated
	 */
	int DYNAMIC_TYPE_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Dynamic Palette Entry</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Dynamic Palette Stack</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK = 4;

	/**
	 * The feature id for the '<em><b>Dynamic Types</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES = 5;

	/**
	 * The number of structural features of the '<em>Dynamic Type Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPE_ROOT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypesImpl <em>Dynamic Types</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypesImpl
	 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicTypes()
	 * @generated
	 */
	int DYNAMIC_TYPES = 3;

	/**
	 * The feature id for the '<em><b>Palette Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPES__PALETTE_ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>Dynamic Types</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_TYPES_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry <em>Dynamic Palette Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Palette Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry
	 * @generated
	 */
	EClass getDynamicPaletteEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDescription()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDiagramPath <em>Diagram Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDiagramPath()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_DiagramPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getId()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getKind()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_Kind();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLabel()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_Label();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLargeIcon <em>Large Icon</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Large Icon</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLargeIcon()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_LargeIcon();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getPath()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_Path();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getSmallIcon <em>Small Icon</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Small Icon</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getSmallIcon()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_SmallIcon();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getTemplateURI <em>Template URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getTemplateURI()
	 * @see #getDynamicPaletteEntry()
	 * @generated
	 */
	EAttribute getDynamicPaletteEntry_TemplateURI();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack <em>Dynamic Palette Stack</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Palette Stack</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack
	 * @generated
	 */
	EClass getDynamicPaletteStack();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getDescription()
	 * @see #getDynamicPaletteStack()
	 * @generated
	 */
	EAttribute getDynamicPaletteStack_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getIcon()
	 * @see #getDynamicPaletteStack()
	 * @generated
	 */
	EAttribute getDynamicPaletteStack_Icon();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getId()
	 * @see #getDynamicPaletteStack()
	 * @generated
	 */
	EAttribute getDynamicPaletteStack_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack#getLabel()
	 * @see #getDynamicPaletteStack()
	 * @generated
	 */
	EAttribute getDynamicPaletteStack_Label();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot <em>Dynamic Type Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Type Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot
	 * @generated
	 */
	EClass getDynamicTypeRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getMixed()
	 * @see #getDynamicTypeRoot()
	 * @generated
	 */
	EAttribute getDynamicTypeRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getXMLNSPrefixMap()
	 * @see #getDynamicTypeRoot()
	 * @generated
	 */
	EReference getDynamicTypeRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getXSISchemaLocation()
	 * @see #getDynamicTypeRoot()
	 * @generated
	 */
	EReference getDynamicTypeRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteEntry <em>Dynamic Palette Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic Palette Entry</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteEntry()
	 * @see #getDynamicTypeRoot()
	 * @generated
	 */
	EReference getDynamicTypeRoot_DynamicPaletteEntry();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteStack <em>Dynamic Palette Stack</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic Palette Stack</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicPaletteStack()
	 * @see #getDynamicTypeRoot()
	 * @generated
	 */
	EReference getDynamicTypeRoot_DynamicPaletteStack();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicTypes <em>Dynamic Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic Types</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot#getDynamicTypes()
	 * @see #getDynamicTypeRoot()
	 * @generated
	 */
	EReference getDynamicTypeRoot_DynamicTypes();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes <em>Dynamic Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Types</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes
	 * @generated
	 */
	EClass getDynamicTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes#getPaletteEntries <em>Palette Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Palette Entries</em>'.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes#getPaletteEntries()
	 * @see #getDynamicTypes()
	 * @generated
	 */
	EReference getDynamicTypes_PaletteEntries();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DynamictypeFactory getDynamictypeFactory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl <em>Dynamic Palette Entry</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicPaletteEntry()
		 * @generated
		 */
		EClass DYNAMIC_PALETTE_ENTRY = eINSTANCE.getDynamicPaletteEntry();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__DESCRIPTION = eINSTANCE.getDynamicPaletteEntry_Description();

		/**
		 * The meta object literal for the '<em><b>Diagram Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH = eINSTANCE.getDynamicPaletteEntry_DiagramPath();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__ID = eINSTANCE.getDynamicPaletteEntry_Id();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__KIND = eINSTANCE.getDynamicPaletteEntry_Kind();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__LABEL = eINSTANCE.getDynamicPaletteEntry_Label();

		/**
		 * The meta object literal for the '<em><b>Large Icon</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__LARGE_ICON = eINSTANCE.getDynamicPaletteEntry_LargeIcon();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__PATH = eINSTANCE.getDynamicPaletteEntry_Path();

		/**
		 * The meta object literal for the '<em><b>Small Icon</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__SMALL_ICON = eINSTANCE.getDynamicPaletteEntry_SmallIcon();

		/**
		 * The meta object literal for the '<em><b>Template URI</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI = eINSTANCE.getDynamicPaletteEntry_TemplateURI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteStackImpl <em>Dynamic Palette Stack</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteStackImpl
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicPaletteStack()
		 * @generated
		 */
		EClass DYNAMIC_PALETTE_STACK = eINSTANCE.getDynamicPaletteStack();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_STACK__DESCRIPTION = eINSTANCE.getDynamicPaletteStack_Description();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_STACK__ICON = eINSTANCE.getDynamicPaletteStack_Icon();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_STACK__ID = eINSTANCE.getDynamicPaletteStack_Id();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_PALETTE_STACK__LABEL = eINSTANCE.getDynamicPaletteStack_Label();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl <em>Dynamic Type Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicTypeRoot()
		 * @generated
		 */
		EClass DYNAMIC_TYPE_ROOT = eINSTANCE.getDynamicTypeRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DYNAMIC_TYPE_ROOT__MIXED = eINSTANCE.getDynamicTypeRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDynamicTypeRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDynamicTypeRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Dynamic Palette Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY = eINSTANCE.getDynamicTypeRoot_DynamicPaletteEntry();

		/**
		 * The meta object literal for the '<em><b>Dynamic Palette Stack</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK = eINSTANCE.getDynamicTypeRoot_DynamicPaletteStack();

		/**
		 * The meta object literal for the '<em><b>Dynamic Types</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES = eINSTANCE.getDynamicTypeRoot_DynamicTypes();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypesImpl <em>Dynamic Types</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypesImpl
		 * @see com.ibm.ccl.soa.deploy.dynamictype.impl.DynamictypePackageImpl#getDynamicTypes()
		 * @generated
		 */
		EClass DYNAMIC_TYPES = eINSTANCE.getDynamicTypes();

		/**
		 * The meta object literal for the '<em><b>Palette Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_TYPES__PALETTE_ENTRIES = eINSTANCE.getDynamicTypes_PaletteEntries();

	}

} //DynamictypePackage
