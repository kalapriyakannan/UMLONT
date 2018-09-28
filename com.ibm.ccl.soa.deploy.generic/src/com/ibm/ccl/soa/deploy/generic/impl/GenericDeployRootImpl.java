/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.generic.impl;

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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.generic.GenericDeployRoot;
import com.ibm.ccl.soa.deploy.generic.GenericPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl#getCapabilityGeneric <em>Capability Generic</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.generic.impl.GenericDeployRootImpl#getUnitGenericUnit <em>Unit Generic Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericDeployRootImpl extends EObjectImpl implements GenericDeployRoot {
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
	protected GenericDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenericPackage.Literals.GENERIC_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, GenericPackage.GENERIC_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, GenericPackage.GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, GenericPackage.GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Capability getCapabilityGeneric() {
		return (Capability)getMixed().get(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityGeneric(Capability newCapabilityGeneric, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC, newCapabilityGeneric, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityGeneric(Capability newCapabilityGeneric) {
		((FeatureMap.Internal)getMixed()).set(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC, newCapabilityGeneric);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnitGenericUnit() {
		return (Unit)getMixed().get(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitGenericUnit(Unit newUnitGenericUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT, newUnitGenericUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitGenericUnit(Unit newUnitGenericUnit) {
		((FeatureMap.Internal)getMixed()).set(GenericPackage.Literals.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT, newUnitGenericUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case GenericPackage.GENERIC_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case GenericPackage.GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case GenericPackage.GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case GenericPackage.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC:
				return basicSetCapabilityGeneric(null, msgs);
			case GenericPackage.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT:
				return basicSetUnitGenericUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericPackage.GENERIC_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case GenericPackage.GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case GenericPackage.GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case GenericPackage.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC:
				return getCapabilityGeneric();
			case GenericPackage.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT:
				return getUnitGenericUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenericPackage.GENERIC_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC:
				setCapabilityGeneric((Capability)newValue);
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT:
				setUnitGenericUnit((Unit)newValue);
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
			case GenericPackage.GENERIC_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC:
				setCapabilityGeneric((Capability)null);
				return;
			case GenericPackage.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT:
				setUnitGenericUnit((Unit)null);
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
			case GenericPackage.GENERIC_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case GenericPackage.GENERIC_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case GenericPackage.GENERIC_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case GenericPackage.GENERIC_DEPLOY_ROOT__CAPABILITY_GENERIC:
				return getCapabilityGeneric() != null;
			case GenericPackage.GENERIC_DEPLOY_ROOT__UNIT_GENERIC_UNIT:
				return getUnitGenericUnit() != null;
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

} //GenericDeployRootImpl
