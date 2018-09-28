/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.impl;

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

import com.ibm.ccl.soa.deploy.internal.derby.DerbyDDLArtifact;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getArtifactDerbyddl <em>Artifact Derbyddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getCapabilityDerbyDatabase <em>Capability Derby Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getCapabilityDerbyInstance <em>Capability Derby Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getUnitDerbyDatabaseInstanceUnit <em>Unit Derby Database Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.impl.DerbyDeployRootImpl#getUnitDerbyDatabaseUnit <em>Unit Derby Database Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerbyDeployRootImpl extends EObjectImpl implements DerbyDeployRoot {
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
	protected DerbyDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DerbyPackage.Literals.DERBY_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DerbyPackage.DERBY_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DerbyPackage.DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DerbyPackage.DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDDLArtifact getArtifactDerbyddl() {
		return (DerbyDDLArtifact)getMixed().get(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifactDerbyddl(DerbyDDLArtifact newArtifactDerbyddl,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL, newArtifactDerbyddl, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactDerbyddl(DerbyDDLArtifact newArtifactDerbyddl) {
		((FeatureMap.Internal)getMixed()).set(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL, newArtifactDerbyddl);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDatabase getCapabilityDerbyDatabase() {
		return (DerbyDatabase)getMixed().get(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDerbyDatabase(
			DerbyDatabase newCapabilityDerbyDatabase, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE, newCapabilityDerbyDatabase, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDerbyDatabase(DerbyDatabase newCapabilityDerbyDatabase) {
		((FeatureMap.Internal)getMixed()).set(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE, newCapabilityDerbyDatabase);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyInstance getCapabilityDerbyInstance() {
		return (DerbyInstance)getMixed().get(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDerbyInstance(
			DerbyInstance newCapabilityDerbyInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE, newCapabilityDerbyInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDerbyInstance(DerbyInstance newCapabilityDerbyInstance) {
		((FeatureMap.Internal)getMixed()).set(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE, newCapabilityDerbyInstance);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDatabaseInstanceUnit getUnitDerbyDatabaseInstanceUnit() {
		return (DerbyDatabaseInstanceUnit)getMixed().get(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDerbyDatabaseInstanceUnit(
			DerbyDatabaseInstanceUnit newUnitDerbyDatabaseInstanceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT, newUnitDerbyDatabaseInstanceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDerbyDatabaseInstanceUnit(
			DerbyDatabaseInstanceUnit newUnitDerbyDatabaseInstanceUnit) {
		((FeatureMap.Internal)getMixed()).set(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT, newUnitDerbyDatabaseInstanceUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDatabaseUnit getUnitDerbyDatabaseUnit() {
		return (DerbyDatabaseUnit)getMixed().get(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDerbyDatabaseUnit(
			DerbyDatabaseUnit newUnitDerbyDatabaseUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT, newUnitDerbyDatabaseUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDerbyDatabaseUnit(DerbyDatabaseUnit newUnitDerbyDatabaseUnit) {
		((FeatureMap.Internal)getMixed()).set(DerbyPackage.Literals.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT, newUnitDerbyDatabaseUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case DerbyPackage.DERBY_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL:
				return basicSetArtifactDerbyddl(null, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE:
				return basicSetCapabilityDerbyDatabase(null, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE:
				return basicSetCapabilityDerbyInstance(null, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT:
				return basicSetUnitDerbyDatabaseInstanceUnit(null, msgs);
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT:
				return basicSetUnitDerbyDatabaseUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DerbyPackage.DERBY_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DerbyPackage.DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case DerbyPackage.DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case DerbyPackage.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL:
				return getArtifactDerbyddl();
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE:
				return getCapabilityDerbyDatabase();
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE:
				return getCapabilityDerbyInstance();
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT:
				return getUnitDerbyDatabaseInstanceUnit();
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT:
				return getUnitDerbyDatabaseUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DerbyPackage.DERBY_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL:
				setArtifactDerbyddl((DerbyDDLArtifact)newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE:
				setCapabilityDerbyDatabase((DerbyDatabase)newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE:
				setCapabilityDerbyInstance((DerbyInstance)newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT:
				setUnitDerbyDatabaseInstanceUnit((DerbyDatabaseInstanceUnit)newValue);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT:
				setUnitDerbyDatabaseUnit((DerbyDatabaseUnit)newValue);
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
			case DerbyPackage.DERBY_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL:
				setArtifactDerbyddl((DerbyDDLArtifact)null);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE:
				setCapabilityDerbyDatabase((DerbyDatabase)null);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE:
				setCapabilityDerbyInstance((DerbyInstance)null);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT:
				setUnitDerbyDatabaseInstanceUnit((DerbyDatabaseInstanceUnit)null);
				return;
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT:
				setUnitDerbyDatabaseUnit((DerbyDatabaseUnit)null);
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
			case DerbyPackage.DERBY_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DerbyPackage.DERBY_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case DerbyPackage.DERBY_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case DerbyPackage.DERBY_DEPLOY_ROOT__ARTIFACT_DERBYDDL:
				return getArtifactDerbyddl() != null;
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_DATABASE:
				return getCapabilityDerbyDatabase() != null;
			case DerbyPackage.DERBY_DEPLOY_ROOT__CAPABILITY_DERBY_INSTANCE:
				return getCapabilityDerbyInstance() != null;
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_INSTANCE_UNIT:
				return getUnitDerbyDatabaseInstanceUnit() != null;
			case DerbyPackage.DERBY_DEPLOY_ROOT__UNIT_DERBY_DATABASE_UNIT:
				return getUnitDerbyDatabaseUnit() != null;
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

} //DerbyDeployRootImpl
