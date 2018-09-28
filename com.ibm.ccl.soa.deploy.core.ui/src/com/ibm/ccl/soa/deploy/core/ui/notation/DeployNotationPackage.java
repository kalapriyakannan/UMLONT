/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.notation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationFactory
 * @model kind="package"
 * @generated
 */
public interface DeployNotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "notation"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/notation/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DeployNotation"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeployNotationPackage eINSTANCE = com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployNotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl <em>Deploy Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployNotationPackageImpl#getDeployStyle()
	 * @generated
	 */
	int DEPLOY_STYLE = 0;

	/**
	 * The feature id for the '<em><b>Is Duplicate Canvas View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW = NotationPackage.STYLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Proxy Hash Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__PROXY_HASH_CODE = NotationPackage.STYLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__ELEMENT_NAME = NotationPackage.STYLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__ELEMENT_CATEGORY = NotationPackage.STYLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__IMPORT = NotationPackage.STYLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Snap Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__SNAP_PARENT = NotationPackage.STYLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Snap Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__SNAP_CHILDREN = NotationPackage.STYLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Filtered Semantic Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS = NotationPackage.STYLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Filtered Decorations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__FILTERED_DECORATIONS = NotationPackage.STYLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Snap Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__SNAP_STYLE = NotationPackage.STYLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Collapse Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__COLLAPSE_WIDTH = NotationPackage.STYLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Collapse Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__COLLAPSE_HEIGHT = NotationPackage.STYLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Expand Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__EXPAND_WIDTH = NotationPackage.STYLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Expand Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__EXPAND_HEIGHT = NotationPackage.STYLE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Contained Objs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__CONTAINED_OBJS = NotationPackage.STYLE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Uncontained Objs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE__UNCONTAINED_OBJS = NotationPackage.STYLE_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Deploy Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOY_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 16;


	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle <em>Deploy Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Style</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle
	 * @generated
	 */
	EClass getDeployStyle();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#isIsDuplicateCanvasView <em>Is Duplicate Canvas View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Duplicate Canvas View</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#isIsDuplicateCanvasView()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_IsDuplicateCanvasView();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getProxyHashCode <em>Proxy Hash Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy Hash Code</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getProxyHashCode()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_ProxyHashCode();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementName <em>Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementName()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_ElementName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementCategory <em>Element Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Category</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementCategory()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_ElementCategory();

	/**
	 * Returns the meta object for the reference '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getImport()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EReference getDeployStyle_Import();

	/**
	 * Returns the meta object for the reference '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapParent <em>Snap Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Snap Parent</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapParent()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EReference getDeployStyle_SnapParent();

	/**
	 * Returns the meta object for the reference list '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapChildren <em>Snap Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Snap Children</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapChildren()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EReference getDeployStyle_SnapChildren();

	/**
	 * Returns the meta object for the reference list '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getFilteredSemanticElements <em>Filtered Semantic Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filtered Semantic Elements</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getFilteredSemanticElements()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EReference getDeployStyle_FilteredSemanticElements();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getFilteredDecorations <em>Filtered Decorations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Filtered Decorations</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getFilteredDecorations()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_FilteredDecorations();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapStyle <em>Snap Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snap Style</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapStyle()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_SnapStyle();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseWidth <em>Collapse Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collapse Width</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseWidth()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_CollapseWidth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseHeight <em>Collapse Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collapse Height</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseHeight()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_CollapseHeight();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandWidth <em>Expand Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expand Width</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandWidth()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_ExpandWidth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandHeight <em>Expand Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expand Height</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandHeight()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EAttribute getDeployStyle_ExpandHeight();

	/**
	 * Returns the meta object for the reference list '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getContainedObjs <em>Contained Objs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contained Objs</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getContainedObjs()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EReference getDeployStyle_ContainedObjs();

	/**
	 * Returns the meta object for the reference list '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getUncontainedObjs <em>Uncontained Objs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uncontained Objs</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getUncontainedObjs()
	 * @see #getDeployStyle()
	 * @generated
	 */
	EReference getDeployStyle_UncontainedObjs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeployNotationFactory getDeployNotationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl <em>Deploy Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl
		 * @see com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployNotationPackageImpl#getDeployStyle()
		 * @generated
		 */
		EClass DEPLOY_STYLE = eINSTANCE.getDeployStyle();

		/**
		 * The meta object literal for the '<em><b>Is Duplicate Canvas View</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW = eINSTANCE.getDeployStyle_IsDuplicateCanvasView();

		/**
		 * The meta object literal for the '<em><b>Proxy Hash Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__PROXY_HASH_CODE = eINSTANCE.getDeployStyle_ProxyHashCode();

		/**
		 * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__ELEMENT_NAME = eINSTANCE.getDeployStyle_ElementName();

		/**
		 * The meta object literal for the '<em><b>Element Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__ELEMENT_CATEGORY = eINSTANCE.getDeployStyle_ElementCategory();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_STYLE__IMPORT = eINSTANCE.getDeployStyle_Import();

		/**
		 * The meta object literal for the '<em><b>Snap Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_STYLE__SNAP_PARENT = eINSTANCE.getDeployStyle_SnapParent();

		/**
		 * The meta object literal for the '<em><b>Snap Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_STYLE__SNAP_CHILDREN = eINSTANCE.getDeployStyle_SnapChildren();

		/**
		 * The meta object literal for the '<em><b>Filtered Semantic Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS = eINSTANCE.getDeployStyle_FilteredSemanticElements();

		/**
		 * The meta object literal for the '<em><b>Filtered Decorations</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__FILTERED_DECORATIONS = eINSTANCE.getDeployStyle_FilteredDecorations();

		/**
		 * The meta object literal for the '<em><b>Snap Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__SNAP_STYLE = eINSTANCE.getDeployStyle_SnapStyle();

		/**
		 * The meta object literal for the '<em><b>Collapse Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__COLLAPSE_WIDTH = eINSTANCE.getDeployStyle_CollapseWidth();

		/**
		 * The meta object literal for the '<em><b>Collapse Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__COLLAPSE_HEIGHT = eINSTANCE.getDeployStyle_CollapseHeight();

		/**
		 * The meta object literal for the '<em><b>Expand Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__EXPAND_WIDTH = eINSTANCE.getDeployStyle_ExpandWidth();

		/**
		 * The meta object literal for the '<em><b>Expand Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOY_STYLE__EXPAND_HEIGHT = eINSTANCE.getDeployStyle_ExpandHeight();

		/**
		 * The meta object literal for the '<em><b>Contained Objs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_STYLE__CONTAINED_OBJS = eINSTANCE.getDeployStyle_ContainedObjs();

		/**
		 * The meta object literal for the '<em><b>Uncontained Objs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOY_STYLE__UNCONTAINED_OBJS = eINSTANCE.getDeployStyle_UncontainedObjs();

	}

} //DeployNotationPackage
