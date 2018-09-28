/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareRootImpl.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.impl;

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

import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstallUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatchUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getCapabilitySoftwareInstall <em>Capability Software Install</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getCapabilitySoftwarePatch <em>Capability Software Patch</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getCapabilityVersion <em>Capability Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getUnitSoftwareInstallUnit <em>Unit Software Install Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareRootImpl#getUnitSoftwarePatchUnit <em>Unit Software Patch Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericsoftwareRootImpl extends EObjectImpl implements GenericsoftwareRoot {
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
	protected GenericsoftwareRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, GenericsoftwarePackage.GENERICSOFTWARE_ROOT__MIXED);
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
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP);
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
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInstall getCapabilitySoftwareInstall() {
		return (SoftwareInstall)getMixed().get(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySoftwareInstall(SoftwareInstall newCapabilitySoftwareInstall, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL, newCapabilitySoftwareInstall, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySoftwareInstall(SoftwareInstall newCapabilitySoftwareInstall) {
		((FeatureMap.Internal)getMixed()).set(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL, newCapabilitySoftwareInstall);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwarePatch getCapabilitySoftwarePatch() {
		return (SoftwarePatch)getMixed().get(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySoftwarePatch(SoftwarePatch newCapabilitySoftwarePatch, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH, newCapabilitySoftwarePatch, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySoftwarePatch(SoftwarePatch newCapabilitySoftwarePatch) {
		((FeatureMap.Internal)getMixed()).set(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH, newCapabilitySoftwarePatch);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getCapabilityVersion() {
		return (Version)getMixed().get(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityVersion(Version newCapabilityVersion, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION, newCapabilityVersion, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityVersion(Version newCapabilityVersion) {
		((FeatureMap.Internal)getMixed()).set(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION, newCapabilityVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInstallUnit getUnitSoftwareInstallUnit() {
		return (SoftwareInstallUnit)getMixed().get(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSoftwareInstallUnit(SoftwareInstallUnit newUnitSoftwareInstallUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT, newUnitSoftwareInstallUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSoftwareInstallUnit(SoftwareInstallUnit newUnitSoftwareInstallUnit) {
		((FeatureMap.Internal)getMixed()).set(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT, newUnitSoftwareInstallUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwarePatchUnit getUnitSoftwarePatchUnit() {
		return (SoftwarePatchUnit)getMixed().get(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSoftwarePatchUnit(SoftwarePatchUnit newUnitSoftwarePatchUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT, newUnitSoftwarePatchUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSoftwarePatchUnit(SoftwarePatchUnit newUnitSoftwarePatchUnit) {
		((FeatureMap.Internal)getMixed()).set(GenericsoftwarePackage.Literals.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT, newUnitSoftwarePatchUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL:
				return basicSetCapabilitySoftwareInstall(null, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH:
				return basicSetCapabilitySoftwarePatch(null, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION:
				return basicSetCapabilityVersion(null, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT:
				return basicSetUnitSoftwareInstallUnit(null, msgs);
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT:
				return basicSetUnitSoftwarePatchUnit(null, msgs);
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
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL:
				return getCapabilitySoftwareInstall();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH:
				return getCapabilitySoftwarePatch();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION:
				return getCapabilityVersion();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT:
				return getUnitSoftwareInstallUnit();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT:
				return getUnitSoftwarePatchUnit();
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
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL:
				setCapabilitySoftwareInstall((SoftwareInstall)newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH:
				setCapabilitySoftwarePatch((SoftwarePatch)newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION:
				setCapabilityVersion((Version)newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT:
				setUnitSoftwareInstallUnit((SoftwareInstallUnit)newValue);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT:
				setUnitSoftwarePatchUnit((SoftwarePatchUnit)newValue);
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
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__MIXED:
				getMixed().clear();
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL:
				setCapabilitySoftwareInstall((SoftwareInstall)null);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH:
				setCapabilitySoftwarePatch((SoftwarePatch)null);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION:
				setCapabilityVersion((Version)null);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT:
				setUnitSoftwareInstallUnit((SoftwareInstallUnit)null);
				return;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT:
				setUnitSoftwarePatchUnit((SoftwarePatchUnit)null);
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
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_INSTALL:
				return getCapabilitySoftwareInstall() != null;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_SOFTWARE_PATCH:
				return getCapabilitySoftwarePatch() != null;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__CAPABILITY_VERSION:
				return getCapabilityVersion() != null;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_INSTALL_UNIT:
				return getUnitSoftwareInstallUnit() != null;
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT__UNIT_SOFTWARE_PATCH_UNIT:
				return getUnitSoftwarePatchUnit() != null;
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
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //GenericsoftwareRootImpl
