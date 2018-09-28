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

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasApplicationExt;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Application Ext</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasApplicationExtImpl#getReloadInterval <em>Reload Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasApplicationExtImpl#isShareSessionContext <em>Share Session Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasApplicationExtImpl extends CapabilityImpl implements WasApplicationExt {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getReloadInterval() <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReloadInterval()
	 * @generated
	 * @ordered
	 */
	protected static final long RELOAD_INTERVAL_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getReloadInterval() <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReloadInterval()
	 * @generated
	 * @ordered
	 */
	protected long reloadInterval = RELOAD_INTERVAL_EDEFAULT;

	/**
	 * This is true if the Reload Interval attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reloadIntervalESet;

	/**
	 * The default value of the '{@link #isShareSessionContext() <em>Share Session Context</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isShareSessionContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHARE_SESSION_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShareSessionContext() <em>Share Session Context</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isShareSessionContext()
	 * @generated
	 * @ordered
	 */
	protected boolean shareSessionContext = SHARE_SESSION_CONTEXT_EDEFAULT;

	/**
	 * This is true if the Share Session Context attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean shareSessionContextESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasApplicationExtImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_APPLICATION_EXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getReloadInterval() {
		return reloadInterval;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReloadInterval(long newReloadInterval) {
		long oldReloadInterval = reloadInterval;
		reloadInterval = newReloadInterval;
		boolean oldReloadIntervalESet = reloadIntervalESet;
		reloadIntervalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_APPLICATION_EXT__RELOAD_INTERVAL, oldReloadInterval, reloadInterval, !oldReloadIntervalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReloadInterval() {
		long oldReloadInterval = reloadInterval;
		boolean oldReloadIntervalESet = reloadIntervalESet;
		reloadInterval = RELOAD_INTERVAL_EDEFAULT;
		reloadIntervalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_APPLICATION_EXT__RELOAD_INTERVAL, oldReloadInterval, RELOAD_INTERVAL_EDEFAULT, oldReloadIntervalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReloadInterval() {
		return reloadIntervalESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShareSessionContext() {
		return shareSessionContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShareSessionContext(boolean newShareSessionContext) {
		boolean oldShareSessionContext = shareSessionContext;
		shareSessionContext = newShareSessionContext;
		boolean oldShareSessionContextESet = shareSessionContextESet;
		shareSessionContextESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT, oldShareSessionContext, shareSessionContext, !oldShareSessionContextESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShareSessionContext() {
		boolean oldShareSessionContext = shareSessionContext;
		boolean oldShareSessionContextESet = shareSessionContextESet;
		shareSessionContext = SHARE_SESSION_CONTEXT_EDEFAULT;
		shareSessionContextESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT, oldShareSessionContext, SHARE_SESSION_CONTEXT_EDEFAULT, oldShareSessionContextESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShareSessionContext() {
		return shareSessionContextESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_APPLICATION_EXT__RELOAD_INTERVAL:
				return new Long(getReloadInterval());
			case WasPackage.WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT:
				return isShareSessionContext() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_APPLICATION_EXT__RELOAD_INTERVAL:
				setReloadInterval(((Long)newValue).longValue());
				return;
			case WasPackage.WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT:
				setShareSessionContext(((Boolean)newValue).booleanValue());
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
			case WasPackage.WAS_APPLICATION_EXT__RELOAD_INTERVAL:
				unsetReloadInterval();
				return;
			case WasPackage.WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT:
				unsetShareSessionContext();
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
			case WasPackage.WAS_APPLICATION_EXT__RELOAD_INTERVAL:
				return isSetReloadInterval();
			case WasPackage.WAS_APPLICATION_EXT__SHARE_SESSION_CONTEXT:
				return isSetShareSessionContext();
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
		result.append(" (reloadInterval: "); //$NON-NLS-1$
		if (reloadIntervalESet) result.append(reloadInterval); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", shareSessionContext: "); //$NON-NLS-1$
		if (shareSessionContextESet) result.append(shareSessionContext); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasApplicationExtImpl
