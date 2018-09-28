/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.impl;

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

import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Was Web Plugin Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl#getCapabilityIhsWasPlugin <em>Capability Ihs Was Plugin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl#getConstraintWasWebServerToIhsConstraint <em>Constraint Was Web Server To Ihs Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.waswebplugin.impl.WasWebPluginDeployRootImpl#getUnitIhsWasPluginUnit <em>Unit Ihs Was Plugin Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasWebPluginDeployRootImpl extends EObjectImpl implements WasWebPluginDeployRoot {
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
	protected WasWebPluginDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasPlugin getCapabilityIhsWasPlugin() {
		return (IhsWasPlugin)getMixed().get(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityIhsWasPlugin(IhsWasPlugin newCapabilityIhsWasPlugin,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN, newCapabilityIhsWasPlugin, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityIhsWasPlugin(IhsWasPlugin newCapabilityIhsWasPlugin) {
		((FeatureMap.Internal)getMixed()).set(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN, newCapabilityIhsWasPlugin);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerToIhsConstraint getConstraintWasWebServerToIhsConstraint() {
		return (WasWebServerToIhsConstraint)getMixed().get(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintWasWebServerToIhsConstraint(
			WasWebServerToIhsConstraint newConstraintWasWebServerToIhsConstraint,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT, newConstraintWasWebServerToIhsConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintWasWebServerToIhsConstraint(
			WasWebServerToIhsConstraint newConstraintWasWebServerToIhsConstraint) {
		((FeatureMap.Internal)getMixed()).set(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT, newConstraintWasWebServerToIhsConstraint);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasPluginUnit getUnitIhsWasPluginUnit() {
		return (IhsWasPluginUnit)getMixed().get(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIhsWasPluginUnit(IhsWasPluginUnit newUnitIhsWasPluginUnit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT, newUnitIhsWasPluginUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIhsWasPluginUnit(IhsWasPluginUnit newUnitIhsWasPluginUnit) {
		((FeatureMap.Internal)getMixed()).set(WaswebpluginPackage.Literals.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT, newUnitIhsWasPluginUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN:
				return basicSetCapabilityIhsWasPlugin(null, msgs);
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT:
				return basicSetConstraintWasWebServerToIhsConstraint(null, msgs);
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT:
				return basicSetUnitIhsWasPluginUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN:
				return getCapabilityIhsWasPlugin();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT:
				return getConstraintWasWebServerToIhsConstraint();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT:
				return getUnitIhsWasPluginUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN:
				setCapabilityIhsWasPlugin((IhsWasPlugin)newValue);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT:
				setConstraintWasWebServerToIhsConstraint((WasWebServerToIhsConstraint)newValue);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT:
				setUnitIhsWasPluginUnit((IhsWasPluginUnit)newValue);
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
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN:
				setCapabilityIhsWasPlugin((IhsWasPlugin)null);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT:
				setConstraintWasWebServerToIhsConstraint((WasWebServerToIhsConstraint)null);
				return;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT:
				setUnitIhsWasPluginUnit((IhsWasPluginUnit)null);
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
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CAPABILITY_IHS_WAS_PLUGIN:
				return getCapabilityIhsWasPlugin() != null;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__CONSTRAINT_WAS_WEB_SERVER_TO_IHS_CONSTRAINT:
				return getConstraintWasWebServerToIhsConstraint() != null;
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT__UNIT_IHS_WAS_PLUGIN_UNIT:
				return getUnitIhsWasPluginUnit() != null;
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

} //WasWebPluginDeployRootImpl
