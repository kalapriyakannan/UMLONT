/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cluster</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasClusterImpl#getClusterName <em>Cluster Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasClusterImpl#isCreateReplicationDomain <em>Create Replication Domain</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasClusterImpl#isPreferLocal <em>Prefer Local</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasClusterImpl#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasClusterImpl extends WasJ2EEServerImpl implements WasCluster {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getClusterName() <em>Cluster Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClusterName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClusterName() <em>Cluster Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClusterName()
	 * @generated
	 * @ordered
	 */
	protected String clusterName = CLUSTER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isCreateReplicationDomain() <em>Create Replication Domain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isCreateReplicationDomain()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CREATE_REPLICATION_DOMAIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCreateReplicationDomain() <em>Create Replication Domain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isCreateReplicationDomain()
	 * @generated
	 * @ordered
	 */
	protected boolean createReplicationDomain = CREATE_REPLICATION_DOMAIN_EDEFAULT;

	/**
	 * This is true if the Create Replication Domain attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createReplicationDomainESet;

	/**
	 * The default value of the '{@link #isPreferLocal() <em>Prefer Local</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isPreferLocal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PREFER_LOCAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPreferLocal() <em>Prefer Local</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isPreferLocal()
	 * @generated
	 * @ordered
	 */
	protected boolean preferLocal = PREFER_LOCAL_EDEFAULT;

	/**
	 * This is true if the Prefer Local attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean preferLocalESet;

	/**
	 * The default value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected String wasVersion = WAS_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasClusterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_CLUSTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterName() {
		return clusterName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterName(String newClusterName) {
		String oldClusterName = clusterName;
		clusterName = newClusterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CLUSTER__CLUSTER_NAME, oldClusterName, clusterName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreateReplicationDomain() {
		return createReplicationDomain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateReplicationDomain(boolean newCreateReplicationDomain) {
		boolean oldCreateReplicationDomain = createReplicationDomain;
		createReplicationDomain = newCreateReplicationDomain;
		boolean oldCreateReplicationDomainESet = createReplicationDomainESet;
		createReplicationDomainESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CLUSTER__CREATE_REPLICATION_DOMAIN, oldCreateReplicationDomain, createReplicationDomain, !oldCreateReplicationDomainESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreateReplicationDomain() {
		boolean oldCreateReplicationDomain = createReplicationDomain;
		boolean oldCreateReplicationDomainESet = createReplicationDomainESet;
		createReplicationDomain = CREATE_REPLICATION_DOMAIN_EDEFAULT;
		createReplicationDomainESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_CLUSTER__CREATE_REPLICATION_DOMAIN, oldCreateReplicationDomain, CREATE_REPLICATION_DOMAIN_EDEFAULT, oldCreateReplicationDomainESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateReplicationDomain() {
		return createReplicationDomainESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPreferLocal() {
		return preferLocal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreferLocal(boolean newPreferLocal) {
		boolean oldPreferLocal = preferLocal;
		preferLocal = newPreferLocal;
		boolean oldPreferLocalESet = preferLocalESet;
		preferLocalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CLUSTER__PREFER_LOCAL, oldPreferLocal, preferLocal, !oldPreferLocalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreferLocal() {
		boolean oldPreferLocal = preferLocal;
		boolean oldPreferLocalESet = preferLocalESet;
		preferLocal = PREFER_LOCAL_EDEFAULT;
		preferLocalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_CLUSTER__PREFER_LOCAL, oldPreferLocal, PREFER_LOCAL_EDEFAULT, oldPreferLocalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreferLocal() {
		return preferLocalESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasVersion() {
		return wasVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasVersion(String newWasVersion) {
		String oldWasVersion = wasVersion;
		wasVersion = newWasVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CLUSTER__WAS_VERSION, oldWasVersion, wasVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_CLUSTER__CLUSTER_NAME:
				return getClusterName();
			case WasPackage.WAS_CLUSTER__CREATE_REPLICATION_DOMAIN:
				return isCreateReplicationDomain() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_CLUSTER__PREFER_LOCAL:
				return isPreferLocal() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_CLUSTER__WAS_VERSION:
				return getWasVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_CLUSTER__CLUSTER_NAME:
				setClusterName((String)newValue);
				return;
			case WasPackage.WAS_CLUSTER__CREATE_REPLICATION_DOMAIN:
				setCreateReplicationDomain(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_CLUSTER__PREFER_LOCAL:
				setPreferLocal(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_CLUSTER__WAS_VERSION:
				setWasVersion((String)newValue);
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
			case WasPackage.WAS_CLUSTER__CLUSTER_NAME:
				setClusterName(CLUSTER_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_CLUSTER__CREATE_REPLICATION_DOMAIN:
				unsetCreateReplicationDomain();
				return;
			case WasPackage.WAS_CLUSTER__PREFER_LOCAL:
				unsetPreferLocal();
				return;
			case WasPackage.WAS_CLUSTER__WAS_VERSION:
				setWasVersion(WAS_VERSION_EDEFAULT);
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
			case WasPackage.WAS_CLUSTER__CLUSTER_NAME:
				return CLUSTER_NAME_EDEFAULT == null ? clusterName != null : !CLUSTER_NAME_EDEFAULT.equals(clusterName);
			case WasPackage.WAS_CLUSTER__CREATE_REPLICATION_DOMAIN:
				return isSetCreateReplicationDomain();
			case WasPackage.WAS_CLUSTER__PREFER_LOCAL:
				return isSetPreferLocal();
			case WasPackage.WAS_CLUSTER__WAS_VERSION:
				return WAS_VERSION_EDEFAULT == null ? wasVersion != null : !WAS_VERSION_EDEFAULT.equals(wasVersion);
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
		result.append(" (clusterName: "); //$NON-NLS-1$
		result.append(clusterName);
		result.append(", createReplicationDomain: "); //$NON-NLS-1$
		if (createReplicationDomainESet) result.append(createReplicationDomain); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", preferLocal: "); //$NON-NLS-1$
		if (preferLocalESet) result.append(preferLocal); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", wasVersion: "); //$NON-NLS-1$
		result.append(wasVersion);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(WasPackage.eINSTANCE
			.getWasCluster_ClusterName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //WasClusterImpl
