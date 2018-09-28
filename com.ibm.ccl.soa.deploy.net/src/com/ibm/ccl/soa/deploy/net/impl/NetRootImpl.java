/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetRootImpl.java,v 1.2 2008/02/01 20:40:01 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.impl;

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

import com.ibm.ccl.soa.deploy.net.IpInterface;
import com.ibm.ccl.soa.deploy.net.IpInterfaceUnit;
import com.ibm.ccl.soa.deploy.net.L2Interface;
import com.ibm.ccl.soa.deploy.net.L2InterfaceUnit;
import com.ibm.ccl.soa.deploy.net.NetPackage;
import com.ibm.ccl.soa.deploy.net.NetRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getCapabilityIpInterface <em>Capability Ip Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getCapabilityL2Interface <em>Capability L2 Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getUnitIpInterfaceUnit <em>Unit Ip Interface Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.NetRootImpl#getUnitL2InterfaceUnit <em>Unit L2 Interface Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetRootImpl extends EObjectImpl implements NetRoot {
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
	protected NetRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NetPackage.Literals.NET_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, NetPackage.NET_ROOT__MIXED);
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
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, NetPackage.NET_ROOT__XMLNS_PREFIX_MAP);
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
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, NetPackage.NET_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpInterface getCapabilityIpInterface() {
		return (IpInterface)getMixed().get(NetPackage.Literals.NET_ROOT__CAPABILITY_IP_INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIpInterface(IpInterface newCapabilityIpInterface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(NetPackage.Literals.NET_ROOT__CAPABILITY_IP_INTERFACE, newCapabilityIpInterface, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIpInterface(IpInterface newCapabilityIpInterface) {
		((FeatureMap.Internal)getMixed()).set(NetPackage.Literals.NET_ROOT__CAPABILITY_IP_INTERFACE, newCapabilityIpInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2Interface getCapabilityL2Interface() {
		return (L2Interface)getMixed().get(NetPackage.Literals.NET_ROOT__CAPABILITY_L2_INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityL2Interface(L2Interface newCapabilityL2Interface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(NetPackage.Literals.NET_ROOT__CAPABILITY_L2_INTERFACE, newCapabilityL2Interface, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityL2Interface(L2Interface newCapabilityL2Interface) {
		((FeatureMap.Internal)getMixed()).set(NetPackage.Literals.NET_ROOT__CAPABILITY_L2_INTERFACE, newCapabilityL2Interface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpInterfaceUnit getUnitIpInterfaceUnit() {
		return (IpInterfaceUnit)getMixed().get(NetPackage.Literals.NET_ROOT__UNIT_IP_INTERFACE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIpInterfaceUnit(IpInterfaceUnit newUnitIpInterfaceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(NetPackage.Literals.NET_ROOT__UNIT_IP_INTERFACE_UNIT, newUnitIpInterfaceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIpInterfaceUnit(IpInterfaceUnit newUnitIpInterfaceUnit) {
		((FeatureMap.Internal)getMixed()).set(NetPackage.Literals.NET_ROOT__UNIT_IP_INTERFACE_UNIT, newUnitIpInterfaceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2InterfaceUnit getUnitL2InterfaceUnit() {
		return (L2InterfaceUnit)getMixed().get(NetPackage.Literals.NET_ROOT__UNIT_L2_INTERFACE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitL2InterfaceUnit(L2InterfaceUnit newUnitL2InterfaceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(NetPackage.Literals.NET_ROOT__UNIT_L2_INTERFACE_UNIT, newUnitL2InterfaceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitL2InterfaceUnit(L2InterfaceUnit newUnitL2InterfaceUnit) {
		((FeatureMap.Internal)getMixed()).set(NetPackage.Literals.NET_ROOT__UNIT_L2_INTERFACE_UNIT, newUnitL2InterfaceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetPackage.NET_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case NetPackage.NET_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case NetPackage.NET_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case NetPackage.NET_ROOT__CAPABILITY_IP_INTERFACE:
				return basicSetCapabilityIpInterface(null, msgs);
			case NetPackage.NET_ROOT__CAPABILITY_L2_INTERFACE:
				return basicSetCapabilityL2Interface(null, msgs);
			case NetPackage.NET_ROOT__UNIT_IP_INTERFACE_UNIT:
				return basicSetUnitIpInterfaceUnit(null, msgs);
			case NetPackage.NET_ROOT__UNIT_L2_INTERFACE_UNIT:
				return basicSetUnitL2InterfaceUnit(null, msgs);
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
			case NetPackage.NET_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case NetPackage.NET_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case NetPackage.NET_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case NetPackage.NET_ROOT__CAPABILITY_IP_INTERFACE:
				return getCapabilityIpInterface();
			case NetPackage.NET_ROOT__CAPABILITY_L2_INTERFACE:
				return getCapabilityL2Interface();
			case NetPackage.NET_ROOT__UNIT_IP_INTERFACE_UNIT:
				return getUnitIpInterfaceUnit();
			case NetPackage.NET_ROOT__UNIT_L2_INTERFACE_UNIT:
				return getUnitL2InterfaceUnit();
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
			case NetPackage.NET_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case NetPackage.NET_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case NetPackage.NET_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case NetPackage.NET_ROOT__CAPABILITY_IP_INTERFACE:
				setCapabilityIpInterface((IpInterface)newValue);
				return;
			case NetPackage.NET_ROOT__CAPABILITY_L2_INTERFACE:
				setCapabilityL2Interface((L2Interface)newValue);
				return;
			case NetPackage.NET_ROOT__UNIT_IP_INTERFACE_UNIT:
				setUnitIpInterfaceUnit((IpInterfaceUnit)newValue);
				return;
			case NetPackage.NET_ROOT__UNIT_L2_INTERFACE_UNIT:
				setUnitL2InterfaceUnit((L2InterfaceUnit)newValue);
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
			case NetPackage.NET_ROOT__MIXED:
				getMixed().clear();
				return;
			case NetPackage.NET_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case NetPackage.NET_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case NetPackage.NET_ROOT__CAPABILITY_IP_INTERFACE:
				setCapabilityIpInterface((IpInterface)null);
				return;
			case NetPackage.NET_ROOT__CAPABILITY_L2_INTERFACE:
				setCapabilityL2Interface((L2Interface)null);
				return;
			case NetPackage.NET_ROOT__UNIT_IP_INTERFACE_UNIT:
				setUnitIpInterfaceUnit((IpInterfaceUnit)null);
				return;
			case NetPackage.NET_ROOT__UNIT_L2_INTERFACE_UNIT:
				setUnitL2InterfaceUnit((L2InterfaceUnit)null);
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
			case NetPackage.NET_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case NetPackage.NET_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case NetPackage.NET_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case NetPackage.NET_ROOT__CAPABILITY_IP_INTERFACE:
				return getCapabilityIpInterface() != null;
			case NetPackage.NET_ROOT__CAPABILITY_L2_INTERFACE:
				return getCapabilityL2Interface() != null;
			case NetPackage.NET_ROOT__UNIT_IP_INTERFACE_UNIT:
				return getUnitIpInterfaceUnit() != null;
			case NetPackage.NET_ROOT__UNIT_L2_INTERFACE_UNIT:
				return getUnitL2InterfaceUnit() != null;
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

} //NetRootImpl
