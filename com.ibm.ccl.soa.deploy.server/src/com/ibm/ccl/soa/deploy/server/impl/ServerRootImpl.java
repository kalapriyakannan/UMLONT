/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server.impl;

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

import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerRoot;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Root</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl#getCapabilityServer <em>Capability Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerRootImpl#getUnitServerUnit <em>Unit Server Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerRootImpl extends EObjectImpl implements ServerRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	protected ServerRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ServerPackage.Literals.SERVER_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, ServerPackage.SERVER_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this, ServerPackage.SERVER_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					ServerPackage.SERVER_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Server getCapabilityServer() {
		return (Server) getMixed().get(ServerPackage.Literals.SERVER_ROOT__CAPABILITY_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityServer(Server newCapabilityServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ServerPackage.Literals.SERVER_ROOT__CAPABILITY_SERVER, newCapabilityServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityServer(Server newCapabilityServer) {
		((FeatureMap.Internal) getMixed()).set(ServerPackage.Literals.SERVER_ROOT__CAPABILITY_SERVER,
				newCapabilityServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerUnit getUnitServerUnit() {
		return (ServerUnit) getMixed()
				.get(ServerPackage.Literals.SERVER_ROOT__UNIT_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitServerUnit(ServerUnit newUnitServerUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ServerPackage.Literals.SERVER_ROOT__UNIT_SERVER_UNIT, newUnitServerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitServerUnit(ServerUnit newUnitServerUnit) {
		((FeatureMap.Internal) getMixed()).set(ServerPackage.Literals.SERVER_ROOT__UNIT_SERVER_UNIT,
				newUnitServerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case ServerPackage.SERVER_ROOT__MIXED:
			return ((InternalEList) getMixed()).basicRemove(otherEnd, msgs);
		case ServerPackage.SERVER_ROOT__XMLNS_PREFIX_MAP:
			return ((InternalEList) ((EMap.InternalMapView) getXMLNSPrefixMap()).eMap()).basicRemove(
					otherEnd, msgs);
		case ServerPackage.SERVER_ROOT__XSI_SCHEMA_LOCATION:
			return ((InternalEList) ((EMap.InternalMapView) getXSISchemaLocation()).eMap())
					.basicRemove(otherEnd, msgs);
		case ServerPackage.SERVER_ROOT__CAPABILITY_SERVER:
			return basicSetCapabilityServer(null, msgs);
		case ServerPackage.SERVER_ROOT__UNIT_SERVER_UNIT:
			return basicSetUnitServerUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case ServerPackage.SERVER_ROOT__MIXED:
			if (coreType)
				return getMixed();
			return ((FeatureMap.Internal) getMixed()).getWrapper();
		case ServerPackage.SERVER_ROOT__XMLNS_PREFIX_MAP:
			if (coreType)
				return ((EMap.InternalMapView) getXMLNSPrefixMap()).eMap();
			else
				return getXMLNSPrefixMap();
		case ServerPackage.SERVER_ROOT__XSI_SCHEMA_LOCATION:
			if (coreType)
				return ((EMap.InternalMapView) getXSISchemaLocation()).eMap();
			else
				return getXSISchemaLocation();
		case ServerPackage.SERVER_ROOT__CAPABILITY_SERVER:
			return getCapabilityServer();
		case ServerPackage.SERVER_ROOT__UNIT_SERVER_UNIT:
			return getUnitServerUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case ServerPackage.SERVER_ROOT__MIXED:
			((FeatureMap.Internal) getMixed()).set(newValue);
			return;
		case ServerPackage.SERVER_ROOT__XMLNS_PREFIX_MAP:
			((EStructuralFeature.Setting) ((EMap.InternalMapView) getXMLNSPrefixMap()).eMap())
					.set(newValue);
			return;
		case ServerPackage.SERVER_ROOT__XSI_SCHEMA_LOCATION:
			((EStructuralFeature.Setting) ((EMap.InternalMapView) getXSISchemaLocation()).eMap())
					.set(newValue);
			return;
		case ServerPackage.SERVER_ROOT__CAPABILITY_SERVER:
			setCapabilityServer((Server) newValue);
			return;
		case ServerPackage.SERVER_ROOT__UNIT_SERVER_UNIT:
			setUnitServerUnit((ServerUnit) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case ServerPackage.SERVER_ROOT__MIXED:
			getMixed().clear();
			return;
		case ServerPackage.SERVER_ROOT__XMLNS_PREFIX_MAP:
			getXMLNSPrefixMap().clear();
			return;
		case ServerPackage.SERVER_ROOT__XSI_SCHEMA_LOCATION:
			getXSISchemaLocation().clear();
			return;
		case ServerPackage.SERVER_ROOT__CAPABILITY_SERVER:
			setCapabilityServer((Server) null);
			return;
		case ServerPackage.SERVER_ROOT__UNIT_SERVER_UNIT:
			setUnitServerUnit((ServerUnit) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case ServerPackage.SERVER_ROOT__MIXED:
			return mixed != null && !mixed.isEmpty();
		case ServerPackage.SERVER_ROOT__XMLNS_PREFIX_MAP:
			return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
		case ServerPackage.SERVER_ROOT__XSI_SCHEMA_LOCATION:
			return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
		case ServerPackage.SERVER_ROOT__CAPABILITY_SERVER:
			return getCapabilityServer() != null;
		case ServerPackage.SERVER_ROOT__UNIT_SERVER_UNIT:
			return getUnitServerUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //ServerRootImpl
