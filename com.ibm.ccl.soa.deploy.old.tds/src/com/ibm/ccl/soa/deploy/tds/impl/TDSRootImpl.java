/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds.impl;

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

import com.ibm.ccl.soa.deploy.tds.TDSRoot;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystem;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.tds.TdsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TDS Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.impl.TDSRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.impl.TDSRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.impl.TDSRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.impl.TDSRootImpl#getCapabilityTdsBaseSystem <em>Capability Tds Base System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tds.impl.TDSRootImpl#getUnitTdsBaseSystemUnit <em>Unit Tds Base System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TDSRootImpl extends EObjectImpl implements TDSRoot {
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
	protected TDSRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TdsPackage.Literals.TDS_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, TdsPackage.TDS_ROOT__MIXED);
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
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, TdsPackage.TDS_ROOT__XMLNS_PREFIX_MAP);
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
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, TdsPackage.TDS_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsBaseSystem getCapabilityTdsBaseSystem() {
		return (TdsBaseSystem)getMixed().get(TdsPackage.Literals.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityTdsBaseSystem(TdsBaseSystem newCapabilityTdsBaseSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TdsPackage.Literals.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM, newCapabilityTdsBaseSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityTdsBaseSystem(TdsBaseSystem newCapabilityTdsBaseSystem) {
		((FeatureMap.Internal)getMixed()).set(TdsPackage.Literals.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM, newCapabilityTdsBaseSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsBaseSystemUnit getUnitTdsBaseSystemUnit() {
		return (TdsBaseSystemUnit)getMixed().get(TdsPackage.Literals.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitTdsBaseSystemUnit(TdsBaseSystemUnit newUnitTdsBaseSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TdsPackage.Literals.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT, newUnitTdsBaseSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitTdsBaseSystemUnit(TdsBaseSystemUnit newUnitTdsBaseSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(TdsPackage.Literals.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT, newUnitTdsBaseSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TdsPackage.TDS_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case TdsPackage.TDS_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case TdsPackage.TDS_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case TdsPackage.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM:
				return basicSetCapabilityTdsBaseSystem(null, msgs);
			case TdsPackage.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT:
				return basicSetUnitTdsBaseSystemUnit(null, msgs);
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
			case TdsPackage.TDS_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case TdsPackage.TDS_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case TdsPackage.TDS_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case TdsPackage.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM:
				return getCapabilityTdsBaseSystem();
			case TdsPackage.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT:
				return getUnitTdsBaseSystemUnit();
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
			case TdsPackage.TDS_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case TdsPackage.TDS_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case TdsPackage.TDS_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case TdsPackage.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM:
				setCapabilityTdsBaseSystem((TdsBaseSystem)newValue);
				return;
			case TdsPackage.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT:
				setUnitTdsBaseSystemUnit((TdsBaseSystemUnit)newValue);
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
			case TdsPackage.TDS_ROOT__MIXED:
				getMixed().clear();
				return;
			case TdsPackage.TDS_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case TdsPackage.TDS_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case TdsPackage.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM:
				setCapabilityTdsBaseSystem((TdsBaseSystem)null);
				return;
			case TdsPackage.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT:
				setUnitTdsBaseSystemUnit((TdsBaseSystemUnit)null);
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
			case TdsPackage.TDS_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case TdsPackage.TDS_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case TdsPackage.TDS_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case TdsPackage.TDS_ROOT__CAPABILITY_TDS_BASE_SYSTEM:
				return getCapabilityTdsBaseSystem() != null;
			case TdsPackage.TDS_ROOT__UNIT_TDS_BASE_SYSTEM_UNIT:
				return getUnitTdsBaseSystemUnit() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //TDSRootImpl
