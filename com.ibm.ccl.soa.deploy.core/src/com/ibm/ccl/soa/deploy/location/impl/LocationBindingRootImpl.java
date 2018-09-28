/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.location.impl;

import java.util.Map;

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

import com.ibm.ccl.soa.deploy.location.BindingEntry;
import com.ibm.ccl.soa.deploy.location.LocationBinding;
import com.ibm.ccl.soa.deploy.location.LocationBindingRoot;
import com.ibm.ccl.soa.deploy.location.LocationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl#getBindingEntry <em>Binding Entry</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.location.impl.LocationBindingRootImpl#getLocationBinding <em>Location Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationBindingRootImpl extends EObjectImpl implements LocationBindingRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationBindingRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LocationPackage.Literals.LOCATION_BINDING_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, LocationPackage.LOCATION_BINDING_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, LocationPackage.LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, LocationPackage.LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BindingEntry getBindingEntry() {
		return (BindingEntry)getMixed().get(LocationPackage.Literals.LOCATION_BINDING_ROOT__BINDING_ENTRY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBindingEntry(BindingEntry newBindingEntry,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LocationPackage.Literals.LOCATION_BINDING_ROOT__BINDING_ENTRY, newBindingEntry, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingEntry(BindingEntry newBindingEntry) {
		((FeatureMap.Internal)getMixed()).set(LocationPackage.Literals.LOCATION_BINDING_ROOT__BINDING_ENTRY, newBindingEntry);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocationBinding getLocationBinding() {
		return (LocationBinding)getMixed().get(LocationPackage.Literals.LOCATION_BINDING_ROOT__LOCATION_BINDING, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocationBinding(LocationBinding newLocationBinding,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(LocationPackage.Literals.LOCATION_BINDING_ROOT__LOCATION_BINDING, newLocationBinding, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationBinding(LocationBinding newLocationBinding) {
		((FeatureMap.Internal)getMixed()).set(LocationPackage.Literals.LOCATION_BINDING_ROOT__LOCATION_BINDING, newLocationBinding);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case LocationPackage.LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case LocationPackage.LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case LocationPackage.LOCATION_BINDING_ROOT__BINDING_ENTRY:
				return basicSetBindingEntry(null, msgs);
			case LocationPackage.LOCATION_BINDING_ROOT__LOCATION_BINDING:
				return basicSetLocationBinding(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case LocationPackage.LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case LocationPackage.LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case LocationPackage.LOCATION_BINDING_ROOT__BINDING_ENTRY:
				return getBindingEntry();
			case LocationPackage.LOCATION_BINDING_ROOT__LOCATION_BINDING:
				return getLocationBinding();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__BINDING_ENTRY:
				setBindingEntry((BindingEntry)newValue);
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__LOCATION_BINDING:
				setLocationBinding((LocationBinding)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING_ROOT__MIXED:
				getMixed().clear();
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__BINDING_ENTRY:
				setBindingEntry((BindingEntry)null);
				return;
			case LocationPackage.LOCATION_BINDING_ROOT__LOCATION_BINDING:
				setLocationBinding((LocationBinding)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LocationPackage.LOCATION_BINDING_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case LocationPackage.LOCATION_BINDING_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case LocationPackage.LOCATION_BINDING_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case LocationPackage.LOCATION_BINDING_ROOT__BINDING_ENTRY:
				return getBindingEntry() != null;
			case LocationPackage.LOCATION_BINDING_ROOT__LOCATION_BINDING:
				return getLocationBinding() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //LocationBindingRootImpl
