/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.foo.impl;

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

import com.ibm.ccl.soa.deploy.foo.FooBaseSystem;
import com.ibm.ccl.soa.deploy.foo.FooBaseSystemUnit;
import com.ibm.ccl.soa.deploy.foo.FooPackage;
import com.ibm.ccl.soa.deploy.foo.FooRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooRootImpl#getCapabilityFooBaseSystem <em>Capability Foo Base System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.foo.impl.FooRootImpl#getUnitFooBaseSystemUnit <em>Unit Foo Base System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FooRootImpl extends EObjectImpl implements FooRoot {
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
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FooRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return FooPackage.Literals.FOO_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FooPackage.FOO_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FooPackage.FOO_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FooPackage.FOO_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooBaseSystem getCapabilityFooBaseSystem() {
		return (FooBaseSystem)getMixed().get(FooPackage.Literals.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityFooBaseSystem(FooBaseSystem newCapabilityFooBaseSystem, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FooPackage.Literals.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM, newCapabilityFooBaseSystem, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityFooBaseSystem(FooBaseSystem newCapabilityFooBaseSystem) {
		((FeatureMap.Internal)getMixed()).set(FooPackage.Literals.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM, newCapabilityFooBaseSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooBaseSystemUnit getUnitFooBaseSystemUnit() {
		return (FooBaseSystemUnit)getMixed().get(FooPackage.Literals.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitFooBaseSystemUnit(FooBaseSystemUnit newUnitFooBaseSystemUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FooPackage.Literals.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT, newUnitFooBaseSystemUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitFooBaseSystemUnit(FooBaseSystemUnit newUnitFooBaseSystemUnit) {
		((FeatureMap.Internal)getMixed()).set(FooPackage.Literals.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT, newUnitFooBaseSystemUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FooPackage.FOO_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case FooPackage.FOO_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case FooPackage.FOO_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case FooPackage.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM:
				return basicSetCapabilityFooBaseSystem(null, msgs);
			case FooPackage.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT:
				return basicSetUnitFooBaseSystemUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FooPackage.FOO_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case FooPackage.FOO_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case FooPackage.FOO_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case FooPackage.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM:
				return getCapabilityFooBaseSystem();
			case FooPackage.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT:
				return getUnitFooBaseSystemUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FooPackage.FOO_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case FooPackage.FOO_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case FooPackage.FOO_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case FooPackage.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM:
				setCapabilityFooBaseSystem((FooBaseSystem)newValue);
				return;
			case FooPackage.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT:
				setUnitFooBaseSystemUnit((FooBaseSystemUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case FooPackage.FOO_ROOT__MIXED:
				getMixed().clear();
				return;
			case FooPackage.FOO_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case FooPackage.FOO_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case FooPackage.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM:
				setCapabilityFooBaseSystem((FooBaseSystem)null);
				return;
			case FooPackage.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT:
				setUnitFooBaseSystemUnit((FooBaseSystemUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FooPackage.FOO_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case FooPackage.FOO_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case FooPackage.FOO_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case FooPackage.FOO_ROOT__CAPABILITY_FOO_BASE_SYSTEM:
				return getCapabilityFooBaseSystem() != null;
			case FooPackage.FOO_ROOT__UNIT_FOO_BASE_SYSTEM_UNIT:
				return getUnitFooBaseSystemUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //FooRootImpl
