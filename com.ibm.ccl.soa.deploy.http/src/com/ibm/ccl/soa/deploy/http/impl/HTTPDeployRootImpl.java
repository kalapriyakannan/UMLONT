/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.http.impl;

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

import com.ibm.ccl.soa.deploy.http.HTTPDeployRoot;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.HttpServer;
import com.ibm.ccl.soa.deploy.http.HttpServerUnit;
import com.ibm.ccl.soa.deploy.http.HttpUser;
import com.ibm.ccl.soa.deploy.http.HttpUserUnit;
import com.ibm.ccl.soa.deploy.http.StaticWebComponent;
import com.ibm.ccl.soa.deploy.http.StaticWebComponentUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>HTTP Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getCapabilityHttpServer <em>Capability Http Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getCapabilityHttpUser <em>Capability Http User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getCapabilityStaticWebComponent <em>Capability Static Web Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getComponentStaticWeb <em>Component Static Web</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getUnitHttpServerUnit <em>Unit Http Server Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.http.impl.HTTPDeployRootImpl#getUnitHttpUserUnit <em>Unit Http User Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HTTPDeployRootImpl extends EObjectImpl implements HTTPDeployRoot {
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
	protected HTTPDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return HttpPackage.Literals.HTTP_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, HttpPackage.HTTP_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, HttpPackage.HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, HttpPackage.HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HttpServer getCapabilityHttpServer() {
		return (HttpServer)getMixed().get(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityHttpServer(HttpServer newCapabilityHttpServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER, newCapabilityHttpServer, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityHttpServer(HttpServer newCapabilityHttpServer) {
		((FeatureMap.Internal)getMixed()).set(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER, newCapabilityHttpServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HttpUser getCapabilityHttpUser() {
		return (HttpUser)getMixed().get(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityHttpUser(HttpUser newCapabilityHttpUser,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER, newCapabilityHttpUser, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityHttpUser(HttpUser newCapabilityHttpUser) {
		((FeatureMap.Internal)getMixed()).set(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER, newCapabilityHttpUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticWebComponent getCapabilityStaticWebComponent() {
		return (StaticWebComponent)getMixed().get(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityStaticWebComponent(StaticWebComponent newCapabilityStaticWebComponent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT, newCapabilityStaticWebComponent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityStaticWebComponent(StaticWebComponent newCapabilityStaticWebComponent) {
		((FeatureMap.Internal)getMixed()).set(HttpPackage.Literals.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT, newCapabilityStaticWebComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticWebComponentUnit getComponentStaticWeb() {
		return (StaticWebComponentUnit)getMixed().get(HttpPackage.Literals.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentStaticWeb(StaticWebComponentUnit newComponentStaticWeb, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HttpPackage.Literals.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB, newComponentStaticWeb, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentStaticWeb(StaticWebComponentUnit newComponentStaticWeb) {
		((FeatureMap.Internal)getMixed()).set(HttpPackage.Literals.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB, newComponentStaticWeb);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpServerUnit getUnitHttpServerUnit() {
		return (HttpServerUnit)getMixed().get(HttpPackage.Literals.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitHttpServerUnit(HttpServerUnit newUnitHttpServerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HttpPackage.Literals.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT, newUnitHttpServerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitHttpServerUnit(HttpServerUnit newUnitHttpServerUnit) {
		((FeatureMap.Internal)getMixed()).set(HttpPackage.Literals.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT, newUnitHttpServerUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HttpUserUnit getUnitHttpUserUnit() {
		return (HttpUserUnit)getMixed().get(HttpPackage.Literals.HTTP_DEPLOY_ROOT__UNIT_HTTP_USER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitHttpUserUnit(HttpUserUnit newUnitHttpUserUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(HttpPackage.Literals.HTTP_DEPLOY_ROOT__UNIT_HTTP_USER_UNIT, newUnitHttpUserUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case HttpPackage.HTTP_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER:
				return basicSetCapabilityHttpServer(null, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER:
				return basicSetCapabilityHttpUser(null, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT:
				return basicSetCapabilityStaticWebComponent(null, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB:
				return basicSetComponentStaticWeb(null, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT:
				return basicSetUnitHttpServerUnit(null, msgs);
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_USER_UNIT:
				return basicSetUnitHttpUserUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HttpPackage.HTTP_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case HttpPackage.HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case HttpPackage.HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER:
				return getCapabilityHttpServer();
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER:
				return getCapabilityHttpUser();
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT:
				return getCapabilityStaticWebComponent();
			case HttpPackage.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB:
				return getComponentStaticWeb();
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT:
				return getUnitHttpServerUnit();
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_USER_UNIT:
				return getUnitHttpUserUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HttpPackage.HTTP_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER:
				setCapabilityHttpServer((HttpServer)newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER:
				setCapabilityHttpUser((HttpUser)newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT:
				setCapabilityStaticWebComponent((StaticWebComponent)newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB:
				setComponentStaticWeb((StaticWebComponentUnit)newValue);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT:
				setUnitHttpServerUnit((HttpServerUnit)newValue);
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
			case HttpPackage.HTTP_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER:
				setCapabilityHttpServer((HttpServer)null);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER:
				setCapabilityHttpUser((HttpUser)null);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT:
				setCapabilityStaticWebComponent((StaticWebComponent)null);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB:
				setComponentStaticWeb((StaticWebComponentUnit)null);
				return;
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT:
				setUnitHttpServerUnit((HttpServerUnit)null);
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
			case HttpPackage.HTTP_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case HttpPackage.HTTP_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case HttpPackage.HTTP_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_SERVER:
				return getCapabilityHttpServer() != null;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_HTTP_USER:
				return getCapabilityHttpUser() != null;
			case HttpPackage.HTTP_DEPLOY_ROOT__CAPABILITY_STATIC_WEB_COMPONENT:
				return getCapabilityStaticWebComponent() != null;
			case HttpPackage.HTTP_DEPLOY_ROOT__COMPONENT_STATIC_WEB:
				return getComponentStaticWeb() != null;
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_SERVER_UNIT:
				return getUnitHttpServerUnit() != null;
			case HttpPackage.HTTP_DEPLOY_ROOT__UNIT_HTTP_USER_UNIT:
				return getUnitHttpUserUnit() != null;
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

} //HTTPDeployRootImpl
