/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.impl;

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

import com.ibm.ccl.soa.deploy.java.JDK;
import com.ibm.ccl.soa.deploy.java.JDKUnit;
import com.ibm.ccl.soa.deploy.java.JRE;
import com.ibm.ccl.soa.deploy.java.JREUnit;
import com.ibm.ccl.soa.deploy.java.JVMConfig;
import com.ibm.ccl.soa.deploy.java.JavaDeployRoot;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getCapabilityJdbcProvider <em>Capability Jdbc Provider</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getCapabilityJdk <em>Capability Jdk</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getCapabilityJre <em>Capability Jre</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getCapabilityJvmConfig <em>Capability Jvm Config</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getUnitJdbcProviderUnit <em>Unit Jdbc Provider Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getUnitJdk <em>Unit Jdk</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JavaDeployRootImpl#getUnitJre <em>Unit Jre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaDeployRootImpl extends EObjectImpl implements JavaDeployRoot {
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
	protected JavaDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JAVA_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, JavaPackage.JAVA_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, JavaPackage.JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, JavaPackage.JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcProvider getCapabilityJdbcProvider() {
		return (JdbcProvider)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJdbcProvider(JdbcProvider newCapabilityJdbcProvider,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER, newCapabilityJdbcProvider, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJdbcProvider(JdbcProvider newCapabilityJdbcProvider) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER, newCapabilityJdbcProvider);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JDK getCapabilityJdk() {
		return (JDK)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JDK, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJdk(JDK newCapabilityJdk, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JDK, newCapabilityJdk, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJdk(JDK newCapabilityJdk) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JDK, newCapabilityJdk);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JRE getCapabilityJre() {
		return (JRE)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JRE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJre(JRE newCapabilityJre, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JRE, newCapabilityJre, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJre(JRE newCapabilityJre) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JRE, newCapabilityJre);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JVMConfig getCapabilityJvmConfig() {
		return (JVMConfig)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityJvmConfig(JVMConfig newCapabilityJvmConfig,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG, newCapabilityJvmConfig, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityJvmConfig(JVMConfig newCapabilityJvmConfig) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG, newCapabilityJvmConfig);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcProviderUnit getUnitJdbcProviderUnit() {
		return (JdbcProviderUnit)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJdbcProviderUnit(JdbcProviderUnit newUnitJdbcProviderUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT, newUnitJdbcProviderUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJdbcProviderUnit(JdbcProviderUnit newUnitJdbcProviderUnit) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT, newUnitJdbcProviderUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JDKUnit getUnitJdk() {
		return (JDKUnit)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JDK, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJdk(JDKUnit newUnitJdk, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JDK, newUnitJdk, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJdk(JDKUnit newUnitJdk) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JDK, newUnitJdk);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREUnit getUnitJre() {
		return (JREUnit)getMixed().get(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JRE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitJre(JREUnit newUnitJre, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JRE, newUnitJre, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitJre(JREUnit newUnitJre) {
		((FeatureMap.Internal)getMixed()).set(JavaPackage.Literals.JAVA_DEPLOY_ROOT__UNIT_JRE, newUnitJre);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case JavaPackage.JAVA_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER:
				return basicSetCapabilityJdbcProvider(null, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDK:
				return basicSetCapabilityJdk(null, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JRE:
				return basicSetCapabilityJre(null, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG:
				return basicSetCapabilityJvmConfig(null, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT:
				return basicSetUnitJdbcProviderUnit(null, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDK:
				return basicSetUnitJdk(null, msgs);
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JRE:
				return basicSetUnitJre(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JAVA_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case JavaPackage.JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case JavaPackage.JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER:
				return getCapabilityJdbcProvider();
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDK:
				return getCapabilityJdk();
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JRE:
				return getCapabilityJre();
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG:
				return getCapabilityJvmConfig();
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT:
				return getUnitJdbcProviderUnit();
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDK:
				return getUnitJdk();
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JRE:
				return getUnitJre();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaPackage.JAVA_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER:
				setCapabilityJdbcProvider((JdbcProvider)newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDK:
				setCapabilityJdk((JDK)newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JRE:
				setCapabilityJre((JRE)newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG:
				setCapabilityJvmConfig((JVMConfig)newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT:
				setUnitJdbcProviderUnit((JdbcProviderUnit)newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDK:
				setUnitJdk((JDKUnit)newValue);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JRE:
				setUnitJre((JREUnit)newValue);
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
			case JavaPackage.JAVA_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER:
				setCapabilityJdbcProvider((JdbcProvider)null);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDK:
				setCapabilityJdk((JDK)null);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JRE:
				setCapabilityJre((JRE)null);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG:
				setCapabilityJvmConfig((JVMConfig)null);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT:
				setUnitJdbcProviderUnit((JdbcProviderUnit)null);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDK:
				setUnitJdk((JDKUnit)null);
				return;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JRE:
				setUnitJre((JREUnit)null);
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
			case JavaPackage.JAVA_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case JavaPackage.JAVA_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case JavaPackage.JAVA_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDBC_PROVIDER:
				return getCapabilityJdbcProvider() != null;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JDK:
				return getCapabilityJdk() != null;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JRE:
				return getCapabilityJre() != null;
			case JavaPackage.JAVA_DEPLOY_ROOT__CAPABILITY_JVM_CONFIG:
				return getCapabilityJvmConfig() != null;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDBC_PROVIDER_UNIT:
				return getUnitJdbcProviderUnit() != null;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JDK:
				return getUnitJdk() != null;
			case JavaPackage.JAVA_DEPLOY_ROOT__UNIT_JRE:
				return getUnitJre() != null;
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

} //JavaDeployRootImpl
