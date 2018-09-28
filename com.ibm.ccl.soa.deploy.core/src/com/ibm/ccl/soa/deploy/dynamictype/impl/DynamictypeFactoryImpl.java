/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypeFactory;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DynamictypeFactoryImpl extends EFactoryImpl implements DynamictypeFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DynamictypeFactory init() {
		try {
			DynamictypeFactory theDynamictypeFactory = (DynamictypeFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.ibm.com/ccl/soa/deploy/dynamictype/1.0.0/"); //$NON-NLS-1$ 
			if (theDynamictypeFactory != null) {
				return theDynamictypeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DynamictypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamictypeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY:
			return createDynamicPaletteEntry();
		case DynamictypePackage.DYNAMIC_PALETTE_STACK:
			return createDynamicPaletteStack();
		case DynamictypePackage.DYNAMIC_TYPE_ROOT:
			return createDynamicTypeRoot();
		case DynamictypePackage.DYNAMIC_TYPES:
			return createDynamicTypes();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicPaletteEntry createDynamicPaletteEntry() {
		DynamicPaletteEntryImpl dynamicPaletteEntry = new DynamicPaletteEntryImpl();
		return dynamicPaletteEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicPaletteStack createDynamicPaletteStack() {
		DynamicPaletteStackImpl dynamicPaletteStack = new DynamicPaletteStackImpl();
		return dynamicPaletteStack;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicTypeRoot createDynamicTypeRoot() {
		DynamicTypeRootImpl dynamicTypeRoot = new DynamicTypeRootImpl();
		return dynamicTypeRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicTypes createDynamicTypes() {
		DynamicTypesImpl dynamicTypes = new DynamicTypesImpl();
		return dynamicTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamictypePackage getDynamictypePackage() {
		return (DynamictypePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DynamictypePackage getPackage() {
		return DynamictypePackage.eINSTANCE;
	}

} //DynamictypeFactoryImpl
