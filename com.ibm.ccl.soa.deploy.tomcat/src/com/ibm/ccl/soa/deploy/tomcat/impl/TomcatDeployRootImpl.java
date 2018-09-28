/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.impl;

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

import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getCapabilityTomcat50datasource <em>Capability Tomcat50datasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getCapabilityTomcatServer <em>Capability Tomcat Server</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getUnitTomcatdatasource <em>Unit Tomcatdatasource</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.TomcatDeployRootImpl#getUnitTomcatWebServer <em>Unit Tomcat Web Server</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TomcatDeployRootImpl extends EObjectImpl implements TomcatDeployRoot {
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
	protected TomcatDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, TomcatPackage.TOMCAT_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, TomcatPackage.TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, TomcatPackage.TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Tomcat50Datasource getCapabilityTomcat50datasource() {
		return (Tomcat50Datasource)getMixed().get(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityTomcat50datasource(
			Tomcat50Datasource newCapabilityTomcat50datasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE, newCapabilityTomcat50datasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityTomcat50datasource(Tomcat50Datasource newCapabilityTomcat50datasource) {
		((FeatureMap.Internal)getMixed()).set(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE, newCapabilityTomcat50datasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatServer getCapabilityTomcatServer() {
		return (TomcatServer)getMixed().get(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityTomcatServer(TomcatServer newCapabilityTomcatServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER, newCapabilityTomcatServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityTomcatServer(TomcatServer newCapabilityTomcatServer) {
		((FeatureMap.Internal)getMixed()).set(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER, newCapabilityTomcatServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatDatasourceUnit getUnitTomcatdatasource() {
		return (TomcatDatasourceUnit)getMixed().get(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitTomcatdatasource(
			TomcatDatasourceUnit newUnitTomcatdatasource, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE, newUnitTomcatdatasource, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitTomcatdatasource(TomcatDatasourceUnit newUnitTomcatdatasource) {
		((FeatureMap.Internal)getMixed()).set(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE, newUnitTomcatdatasource);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatWebServerUnit getUnitTomcatWebServer() {
		return (TomcatWebServerUnit)getMixed().get(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitTomcatWebServer(TomcatWebServerUnit newUnitTomcatWebServer,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER, newUnitTomcatWebServer, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitTomcatWebServer(TomcatWebServerUnit newUnitTomcatWebServer) {
		((FeatureMap.Internal)getMixed()).set(TomcatPackage.Literals.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER, newUnitTomcatWebServer);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE:
				return basicSetCapabilityTomcat50datasource(null, msgs);
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER:
				return basicSetCapabilityTomcatServer(null, msgs);
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE:
				return basicSetUnitTomcatdatasource(null, msgs);
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER:
				return basicSetUnitTomcatWebServer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE:
				return getCapabilityTomcat50datasource();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER:
				return getCapabilityTomcatServer();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE:
				return getUnitTomcatdatasource();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER:
				return getUnitTomcatWebServer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE:
				setCapabilityTomcat50datasource((Tomcat50Datasource)newValue);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER:
				setCapabilityTomcatServer((TomcatServer)newValue);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE:
				setUnitTomcatdatasource((TomcatDatasourceUnit)newValue);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER:
				setUnitTomcatWebServer((TomcatWebServerUnit)newValue);
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
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE:
				setCapabilityTomcat50datasource((Tomcat50Datasource)null);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER:
				setCapabilityTomcatServer((TomcatServer)null);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE:
				setUnitTomcatdatasource((TomcatDatasourceUnit)null);
				return;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER:
				setUnitTomcatWebServer((TomcatWebServerUnit)null);
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
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT50DATASOURCE:
				return getCapabilityTomcat50datasource() != null;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__CAPABILITY_TOMCAT_SERVER:
				return getCapabilityTomcatServer() != null;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCATDATASOURCE:
				return getUnitTomcatdatasource() != null;
			case TomcatPackage.TOMCAT_DEPLOY_ROOT__UNIT_TOMCAT_WEB_SERVER:
				return getUnitTomcatWebServer() != null;
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

} //TomcatDeployRootImpl
