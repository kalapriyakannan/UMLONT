/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV4Datasource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>V4 Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV4DatasourceImpl#isDisableAutoConnectionCleanup <em>Disable Auto Connection Cleanup</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV4DatasourceImpl#getIdleTimeout <em>Idle Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV4DatasourceImpl#getOrphanTimeout <em>Orphan Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasV4DatasourceImpl extends WasDatasourceImpl implements WasV4Datasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isDisableAutoConnectionCleanup() <em>Disable Auto Connection Cleanup</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDisableAutoConnectionCleanup()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISABLE_AUTO_CONNECTION_CLEANUP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDisableAutoConnectionCleanup() <em>Disable Auto Connection Cleanup</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDisableAutoConnectionCleanup()
	 * @generated
	 * @ordered
	 */
	protected boolean disableAutoConnectionCleanup = DISABLE_AUTO_CONNECTION_CLEANUP_EDEFAULT;

	/**
	 * This is true if the Disable Auto Connection Cleanup attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean disableAutoConnectionCleanupESet;

	/**
	 * The default value of the '{@link #getIdleTimeout() <em>Idle Timeout</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIdleTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String IDLE_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdleTimeout() <em>Idle Timeout</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIdleTimeout()
	 * @generated
	 * @ordered
	 */
	protected String idleTimeout = IDLE_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrphanTimeout() <em>Orphan Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOrphanTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String ORPHAN_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrphanTimeout() <em>Orphan Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOrphanTimeout()
	 * @generated
	 * @ordered
	 */
	protected String orphanTimeout = ORPHAN_TIMEOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasV4DatasourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_V4_DATASOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisableAutoConnectionCleanup() {
		return disableAutoConnectionCleanup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisableAutoConnectionCleanup(boolean newDisableAutoConnectionCleanup) {
		boolean oldDisableAutoConnectionCleanup = disableAutoConnectionCleanup;
		disableAutoConnectionCleanup = newDisableAutoConnectionCleanup;
		boolean oldDisableAutoConnectionCleanupESet = disableAutoConnectionCleanupESet;
		disableAutoConnectionCleanupESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP, oldDisableAutoConnectionCleanup, disableAutoConnectionCleanup, !oldDisableAutoConnectionCleanupESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisableAutoConnectionCleanup() {
		boolean oldDisableAutoConnectionCleanup = disableAutoConnectionCleanup;
		boolean oldDisableAutoConnectionCleanupESet = disableAutoConnectionCleanupESet;
		disableAutoConnectionCleanup = DISABLE_AUTO_CONNECTION_CLEANUP_EDEFAULT;
		disableAutoConnectionCleanupESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP, oldDisableAutoConnectionCleanup, DISABLE_AUTO_CONNECTION_CLEANUP_EDEFAULT, oldDisableAutoConnectionCleanupESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisableAutoConnectionCleanup() {
		return disableAutoConnectionCleanupESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdleTimeout() {
		return idleTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdleTimeout(String newIdleTimeout) {
		String oldIdleTimeout = idleTimeout;
		idleTimeout = newIdleTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V4_DATASOURCE__IDLE_TIMEOUT, oldIdleTimeout, idleTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrphanTimeout() {
		return orphanTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrphanTimeout(String newOrphanTimeout) {
		String oldOrphanTimeout = orphanTimeout;
		orphanTimeout = newOrphanTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V4_DATASOURCE__ORPHAN_TIMEOUT, oldOrphanTimeout, orphanTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP:
				return isDisableAutoConnectionCleanup() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_V4_DATASOURCE__IDLE_TIMEOUT:
				return getIdleTimeout();
			case WasPackage.WAS_V4_DATASOURCE__ORPHAN_TIMEOUT:
				return getOrphanTimeout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP:
				setDisableAutoConnectionCleanup(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_V4_DATASOURCE__IDLE_TIMEOUT:
				setIdleTimeout((String)newValue);
				return;
			case WasPackage.WAS_V4_DATASOURCE__ORPHAN_TIMEOUT:
				setOrphanTimeout((String)newValue);
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
			case WasPackage.WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP:
				unsetDisableAutoConnectionCleanup();
				return;
			case WasPackage.WAS_V4_DATASOURCE__IDLE_TIMEOUT:
				setIdleTimeout(IDLE_TIMEOUT_EDEFAULT);
				return;
			case WasPackage.WAS_V4_DATASOURCE__ORPHAN_TIMEOUT:
				setOrphanTimeout(ORPHAN_TIMEOUT_EDEFAULT);
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
			case WasPackage.WAS_V4_DATASOURCE__DISABLE_AUTO_CONNECTION_CLEANUP:
				return isSetDisableAutoConnectionCleanup();
			case WasPackage.WAS_V4_DATASOURCE__IDLE_TIMEOUT:
				return IDLE_TIMEOUT_EDEFAULT == null ? idleTimeout != null : !IDLE_TIMEOUT_EDEFAULT.equals(idleTimeout);
			case WasPackage.WAS_V4_DATASOURCE__ORPHAN_TIMEOUT:
				return ORPHAN_TIMEOUT_EDEFAULT == null ? orphanTimeout != null : !ORPHAN_TIMEOUT_EDEFAULT.equals(orphanTimeout);
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
		result.append(" (disableAutoConnectionCleanup: "); //$NON-NLS-1$
		if (disableAutoConnectionCleanupESet) result.append(disableAutoConnectionCleanup); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", idleTimeout: "); //$NON-NLS-1$
		result.append(idleTimeout);
		result.append(", orphanTimeout: "); //$NON-NLS-1$
		result.append(orphanTimeout);
		result.append(')');
		return result.toString();
	}

} //WasV4DatasourceImpl
