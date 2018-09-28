/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.notation.impl;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationFactory;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeployNotationPackageImpl extends EPackageImpl implements DeployNotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployStyleEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DeployNotationPackageImpl() {
		super(eNS_URI, DeployNotationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DeployNotationPackage init() {
		if (isInited) return (DeployNotationPackage)EPackage.Registry.INSTANCE.getEPackage(DeployNotationPackage.eNS_URI);

		// Obtain or create and register package
		DeployNotationPackageImpl theDeployNotationPackage = (DeployNotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DeployNotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DeployNotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDeployNotationPackage.createPackageContents();

		// Initialize created meta-data
		theDeployNotationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDeployNotationPackage.freeze();

		return theDeployNotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployStyle() {
		return deployStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_IsDuplicateCanvasView() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_ProxyHashCode() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_ElementName() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_ElementCategory() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployStyle_Import() {
		return (EReference)deployStyleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployStyle_SnapParent() {
		return (EReference)deployStyleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployStyle_SnapChildren() {
		return (EReference)deployStyleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployStyle_FilteredSemanticElements() {
		return (EReference)deployStyleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_FilteredDecorations() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_SnapStyle() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_CollapseWidth() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_CollapseHeight() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_ExpandWidth() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployStyle_ExpandHeight() {
		return (EAttribute)deployStyleEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployStyle_ContainedObjs() {
		return (EReference)deployStyleEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployStyle_UncontainedObjs() {
		return (EReference)deployStyleEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeployNotationFactory getDeployNotationFactory() {
		return (DeployNotationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		deployStyleEClass = createEClass(DEPLOY_STYLE);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__PROXY_HASH_CODE);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__ELEMENT_NAME);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__ELEMENT_CATEGORY);
		createEReference(deployStyleEClass, DEPLOY_STYLE__IMPORT);
		createEReference(deployStyleEClass, DEPLOY_STYLE__SNAP_PARENT);
		createEReference(deployStyleEClass, DEPLOY_STYLE__SNAP_CHILDREN);
		createEReference(deployStyleEClass, DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__FILTERED_DECORATIONS);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__SNAP_STYLE);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__COLLAPSE_WIDTH);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__COLLAPSE_HEIGHT);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__EXPAND_WIDTH);
		createEAttribute(deployStyleEClass, DEPLOY_STYLE__EXPAND_HEIGHT);
		createEReference(deployStyleEClass, DEPLOY_STYLE__CONTAINED_OBJS);
		createEReference(deployStyleEClass, DEPLOY_STYLE__UNCONTAINED_OBJS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		deployStyleEClass.getESuperTypes().add(theNotationPackage.getStyle());

		// Initialize classes and features; add operations and parameters
		initEClass(deployStyleEClass, DeployStyle.class, "DeployStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDeployStyle_IsDuplicateCanvasView(), ecorePackage.getEBoolean(), "isDuplicateCanvasView", "false", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_ProxyHashCode(), theEcorePackage.getEInt(), "proxyHashCode", "0", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_ElementName(), theEcorePackage.getEString(), "elementName", "", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_ElementCategory(), theEcorePackage.getEString(), "elementCategory", null, 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployStyle_Import(), theEcorePackage.getEObject(), null, "import", null, 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployStyle_SnapParent(), theNotationPackage.getView(), null, "snapParent", null, 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployStyle_SnapChildren(), theNotationPackage.getView(), null, "snapChildren", null, 0, -1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployStyle_FilteredSemanticElements(), theEcorePackage.getEObject(), null, "filteredSemanticElements", null, 0, -1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployStyle_FilteredDecorations(), ecorePackage.getEString(), "filteredDecorations", null, 0, -1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployStyle_SnapStyle(), theEcorePackage.getEInt(), "snapStyle", "0", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_CollapseWidth(), theEcorePackage.getEInt(), "collapseWidth", "-1", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_CollapseHeight(), theEcorePackage.getEInt(), "collapseHeight", "-1", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_ExpandWidth(), theEcorePackage.getEInt(), "expandWidth", "-1", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployStyle_ExpandHeight(), theEcorePackage.getEInt(), "expandHeight", "-1", 0, 1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getDeployStyle_ContainedObjs(), theEcorePackage.getEObject(), null, "containedObjs", null, 0, -1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployStyle_UncontainedObjs(), theEcorePackage.getEObject(), null, "uncontainedObjs", null, 0, -1, DeployStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //DeployNotationPackageImpl
