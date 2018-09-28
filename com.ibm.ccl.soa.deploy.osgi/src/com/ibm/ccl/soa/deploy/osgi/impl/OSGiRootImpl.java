/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.impl;

import com.ibm.ccl.soa.deploy.osgi.BundleCapability;
import com.ibm.ccl.soa.deploy.osgi.BundleComponent;
import com.ibm.ccl.soa.deploy.osgi.ExportedPackage;
import com.ibm.ccl.soa.deploy.osgi.Library;
import com.ibm.ccl.soa.deploy.osgi.OSGiRoot;
import com.ibm.ccl.soa.deploy.osgi.OsgiPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OS Gi Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getCapabilityApiPackage <em>Capability Api Package</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getCapabilityOsgiBundle <em>Capability Osgi Bundle</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getComponentBundle <em>Component Bundle</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.OSGiRootImpl#getUnitOsgiLibrary <em>Unit Osgi Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OSGiRootImpl extends EObjectImpl implements OSGiRoot {
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
	protected OSGiRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.OS_GI_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, OsgiPackage.OS_GI_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, OsgiPackage.OS_GI_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, OsgiPackage.OS_GI_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedPackage getCapabilityApiPackage() {
		return (ExportedPackage)getMixed().get(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_API_PACKAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityApiPackage(ExportedPackage newCapabilityApiPackage, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_API_PACKAGE, newCapabilityApiPackage, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityApiPackage(ExportedPackage newCapabilityApiPackage) {
		((FeatureMap.Internal)getMixed()).set(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_API_PACKAGE, newCapabilityApiPackage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundleCapability getCapabilityOsgiBundle() {
		return (BundleCapability)getMixed().get(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityOsgiBundle(BundleCapability newCapabilityOsgiBundle, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE, newCapabilityOsgiBundle, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityOsgiBundle(BundleCapability newCapabilityOsgiBundle) {
		((FeatureMap.Internal)getMixed()).set(OsgiPackage.Literals.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE, newCapabilityOsgiBundle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundleComponent getComponentBundle() {
		return (BundleComponent)getMixed().get(OsgiPackage.Literals.OS_GI_ROOT__COMPONENT_BUNDLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentBundle(BundleComponent newComponentBundle, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(OsgiPackage.Literals.OS_GI_ROOT__COMPONENT_BUNDLE, newComponentBundle, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentBundle(BundleComponent newComponentBundle) {
		((FeatureMap.Internal)getMixed()).set(OsgiPackage.Literals.OS_GI_ROOT__COMPONENT_BUNDLE, newComponentBundle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library getUnitOsgiLibrary() {
		return (Library)getMixed().get(OsgiPackage.Literals.OS_GI_ROOT__UNIT_OSGI_LIBRARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitOsgiLibrary(Library newUnitOsgiLibrary, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(OsgiPackage.Literals.OS_GI_ROOT__UNIT_OSGI_LIBRARY, newUnitOsgiLibrary, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOsgiLibrary(Library newUnitOsgiLibrary) {
		((FeatureMap.Internal)getMixed()).set(OsgiPackage.Literals.OS_GI_ROOT__UNIT_OSGI_LIBRARY, newUnitOsgiLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OsgiPackage.OS_GI_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case OsgiPackage.OS_GI_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case OsgiPackage.OS_GI_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_API_PACKAGE:
				return basicSetCapabilityApiPackage(null, msgs);
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE:
				return basicSetCapabilityOsgiBundle(null, msgs);
			case OsgiPackage.OS_GI_ROOT__COMPONENT_BUNDLE:
				return basicSetComponentBundle(null, msgs);
			case OsgiPackage.OS_GI_ROOT__UNIT_OSGI_LIBRARY:
				return basicSetUnitOsgiLibrary(null, msgs);
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
			case OsgiPackage.OS_GI_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case OsgiPackage.OS_GI_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case OsgiPackage.OS_GI_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_API_PACKAGE:
				return getCapabilityApiPackage();
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE:
				return getCapabilityOsgiBundle();
			case OsgiPackage.OS_GI_ROOT__COMPONENT_BUNDLE:
				return getComponentBundle();
			case OsgiPackage.OS_GI_ROOT__UNIT_OSGI_LIBRARY:
				return getUnitOsgiLibrary();
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
			case OsgiPackage.OS_GI_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case OsgiPackage.OS_GI_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case OsgiPackage.OS_GI_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_API_PACKAGE:
				setCapabilityApiPackage((ExportedPackage)newValue);
				return;
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE:
				setCapabilityOsgiBundle((BundleCapability)newValue);
				return;
			case OsgiPackage.OS_GI_ROOT__COMPONENT_BUNDLE:
				setComponentBundle((BundleComponent)newValue);
				return;
			case OsgiPackage.OS_GI_ROOT__UNIT_OSGI_LIBRARY:
				setUnitOsgiLibrary((Library)newValue);
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
			case OsgiPackage.OS_GI_ROOT__MIXED:
				getMixed().clear();
				return;
			case OsgiPackage.OS_GI_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case OsgiPackage.OS_GI_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_API_PACKAGE:
				setCapabilityApiPackage((ExportedPackage)null);
				return;
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE:
				setCapabilityOsgiBundle((BundleCapability)null);
				return;
			case OsgiPackage.OS_GI_ROOT__COMPONENT_BUNDLE:
				setComponentBundle((BundleComponent)null);
				return;
			case OsgiPackage.OS_GI_ROOT__UNIT_OSGI_LIBRARY:
				setUnitOsgiLibrary((Library)null);
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
			case OsgiPackage.OS_GI_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case OsgiPackage.OS_GI_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case OsgiPackage.OS_GI_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_API_PACKAGE:
				return getCapabilityApiPackage() != null;
			case OsgiPackage.OS_GI_ROOT__CAPABILITY_OSGI_BUNDLE:
				return getCapabilityOsgiBundle() != null;
			case OsgiPackage.OS_GI_ROOT__COMPONENT_BUNDLE:
				return getComponentBundle() != null;
			case OsgiPackage.OS_GI_ROOT__UNIT_OSGI_LIBRARY:
				return getUnitOsgiLibrary() != null;
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

} //OSGiRootImpl
