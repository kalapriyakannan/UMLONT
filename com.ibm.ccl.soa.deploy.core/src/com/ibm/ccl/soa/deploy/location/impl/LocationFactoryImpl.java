/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationBindingRoot;
import com.ibm.ccl.soa.deploy.location.LocationFactory;
import com.ibm.ccl.soa.deploy.location.LocationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class LocationFactoryImpl extends EFactoryImpl implements LocationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static LocationFactory init() {
		try {
			LocationFactory theLocationFactory = (LocationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/location/1.0.0/"); //$NON-NLS-1$ 
			if (theLocationFactory != null) {
				return theLocationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LocationPackage.BINDING_ENTRY: return createBindingEntry();
			case LocationPackage.LOCATION_BINDING: return createLocationBinding();
			case LocationPackage.LOCATION_BINDING_ROOT: return createLocationBindingRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BindingEntry createBindingEntry() {
		BindingEntryImpl bindingEntry = new BindingEntryImpl();
		return bindingEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocationBinding createLocationBinding() {
		LocationBindingImpl locationBinding = new LocationBindingImpl();
		return locationBinding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocationBindingRoot createLocationBindingRoot() {
		LocationBindingRootImpl locationBindingRoot = new LocationBindingRootImpl();
		return locationBindingRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocationPackage getLocationPackage() {
		return (LocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static LocationPackage getPackage() {
		return LocationPackage.eINSTANCE;
	}

} //LocationFactoryImpl
