/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypesImpl#getPaletteEntries <em>Palette Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicTypesImpl extends EObjectImpl implements DynamicTypes {
	/**
	 * The cached value of the '{@link #getPaletteEntries() <em>Palette Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaletteEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<DynamicPaletteEntry> paletteEntries;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicTypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamictypePackage.Literals.DYNAMIC_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DynamicPaletteEntry> getPaletteEntries() {
		if (paletteEntries == null) {
			paletteEntries = new EObjectContainmentEList<DynamicPaletteEntry>(DynamicPaletteEntry.class, this, DynamictypePackage.DYNAMIC_TYPES__PALETTE_ENTRIES);
		}
		return paletteEntries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPES__PALETTE_ENTRIES:
				return ((InternalEList<?>)getPaletteEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPES__PALETTE_ENTRIES:
				return getPaletteEntries();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPES__PALETTE_ENTRIES:
				getPaletteEntries().clear();
				getPaletteEntries().addAll((Collection<? extends DynamicPaletteEntry>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPES__PALETTE_ENTRIES:
				getPaletteEntries().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPES__PALETTE_ENTRIES:
				return paletteEntries != null && !paletteEntries.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DynamicTypesImpl
