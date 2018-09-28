/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Type Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl#getDynamicPaletteEntry <em>Dynamic Palette Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl#getDynamicPaletteStack <em>Dynamic Palette Stack</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicTypeRootImpl#getDynamicTypes <em>Dynamic Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DynamicTypeRootImpl extends EObjectImpl implements DynamicTypeRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicTypeRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DynamictypePackage.DYNAMIC_TYPE_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DynamictypePackage.DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DynamictypePackage.DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicPaletteEntry getDynamicPaletteEntry() {
		return (DynamicPaletteEntry)getMixed().get(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicPaletteEntry(DynamicPaletteEntry newDynamicPaletteEntry, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY, newDynamicPaletteEntry, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicPaletteEntry(DynamicPaletteEntry newDynamicPaletteEntry) {
		((FeatureMap.Internal)getMixed()).set(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY, newDynamicPaletteEntry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicPaletteStack getDynamicPaletteStack() {
		return (DynamicPaletteStack)getMixed().get(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicPaletteStack(DynamicPaletteStack newDynamicPaletteStack, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK, newDynamicPaletteStack, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicPaletteStack(DynamicPaletteStack newDynamicPaletteStack) {
		((FeatureMap.Internal)getMixed()).set(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK, newDynamicPaletteStack);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicTypes getDynamicTypes() {
		return (DynamicTypes)getMixed().get(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicTypes(DynamicTypes newDynamicTypes, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES, newDynamicTypes, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicTypes(DynamicTypes newDynamicTypes) {
		((FeatureMap.Internal)getMixed()).set(DynamictypePackage.Literals.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES, newDynamicTypes);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY:
				return basicSetDynamicPaletteEntry(null, msgs);
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK:
				return basicSetDynamicPaletteStack(null, msgs);
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES:
				return basicSetDynamicTypes(null, msgs);
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
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY:
				return getDynamicPaletteEntry();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK:
				return getDynamicPaletteStack();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES:
				return getDynamicTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY:
				setDynamicPaletteEntry((DynamicPaletteEntry)newValue);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK:
				setDynamicPaletteStack((DynamicPaletteStack)newValue);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES:
				setDynamicTypes((DynamicTypes)newValue);
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
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__MIXED:
				getMixed().clear();
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY:
				setDynamicPaletteEntry((DynamicPaletteEntry)null);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK:
				setDynamicPaletteStack((DynamicPaletteStack)null);
				return;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES:
				setDynamicTypes((DynamicTypes)null);
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
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_ENTRY:
				return getDynamicPaletteEntry() != null;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_PALETTE_STACK:
				return getDynamicPaletteStack() != null;
			case DynamictypePackage.DYNAMIC_TYPE_ROOT__DYNAMIC_TYPES:
				return getDynamicTypes() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DynamicTypeRootImpl
