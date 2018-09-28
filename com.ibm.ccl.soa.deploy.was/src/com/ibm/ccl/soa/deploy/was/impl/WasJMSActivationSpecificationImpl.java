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

import com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl;
import com.ibm.ccl.soa.deploy.was.ShareDurableSubscriptionsEnum;
import com.ibm.ccl.soa.deploy.was.WasJMSActivationSpecification;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMS Activation Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasJMSActivationSpecificationImpl#getDurableScriptionHome <em>Durable Scription Home</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasJMSActivationSpecificationImpl#getMaxBatchSize <em>Max Batch Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasJMSActivationSpecificationImpl#getMaxConcurrentEndpoints <em>Max Concurrent Endpoints</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasJMSActivationSpecificationImpl#getShareDurableSubscription <em>Share Durable Subscription</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasJMSActivationSpecificationImpl extends JMSActivationSpecificationImpl implements
		WasJMSActivationSpecification {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getDurableScriptionHome() <em>Durable Scription Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDurableScriptionHome()
	 * @generated
	 * @ordered
	 */
	protected static final String DURABLE_SCRIPTION_HOME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDurableScriptionHome() <em>Durable Scription Home</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDurableScriptionHome()
	 * @generated
	 * @ordered
	 */
	protected String durableScriptionHome = DURABLE_SCRIPTION_HOME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBatchSize() <em>Max Batch Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxBatchSize()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_BATCH_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxBatchSize() <em>Max Batch Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxBatchSize()
	 * @generated
	 * @ordered
	 */
	protected int maxBatchSize = MAX_BATCH_SIZE_EDEFAULT;

	/**
	 * This is true if the Max Batch Size attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxBatchSizeESet;

	/**
	 * The default value of the '{@link #getMaxConcurrentEndpoints() <em>Max Concurrent Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxConcurrentEndpoints()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_CONCURRENT_ENDPOINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxConcurrentEndpoints() <em>Max Concurrent Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxConcurrentEndpoints()
	 * @generated
	 * @ordered
	 */
	protected int maxConcurrentEndpoints = MAX_CONCURRENT_ENDPOINTS_EDEFAULT;

	/**
	 * This is true if the Max Concurrent Endpoints attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxConcurrentEndpointsESet;

	/**
	 * The default value of the '{@link #getShareDurableSubscription() <em>Share Durable Subscription</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getShareDurableSubscription()
	 * @generated
	 * @ordered
	 */
	protected static final ShareDurableSubscriptionsEnum SHARE_DURABLE_SUBSCRIPTION_EDEFAULT = ShareDurableSubscriptionsEnum.IN_CLUSTER_LITERAL;

	/**
	 * The cached value of the '{@link #getShareDurableSubscription() <em>Share Durable Subscription</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getShareDurableSubscription()
	 * @generated
	 * @ordered
	 */
	protected ShareDurableSubscriptionsEnum shareDurableSubscription = SHARE_DURABLE_SUBSCRIPTION_EDEFAULT;

	/**
	 * This is true if the Share Durable Subscription attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean shareDurableSubscriptionESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasJMSActivationSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_JMS_ACTIVATION_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDurableScriptionHome() {
		return durableScriptionHome;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDurableScriptionHome(String newDurableScriptionHome) {
		String oldDurableScriptionHome = durableScriptionHome;
		durableScriptionHome = newDurableScriptionHome;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__DURABLE_SCRIPTION_HOME, oldDurableScriptionHome, durableScriptionHome));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxBatchSize() {
		return maxBatchSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBatchSize(int newMaxBatchSize) {
		int oldMaxBatchSize = maxBatchSize;
		maxBatchSize = newMaxBatchSize;
		boolean oldMaxBatchSizeESet = maxBatchSizeESet;
		maxBatchSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE, oldMaxBatchSize, maxBatchSize, !oldMaxBatchSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxBatchSize() {
		int oldMaxBatchSize = maxBatchSize;
		boolean oldMaxBatchSizeESet = maxBatchSizeESet;
		maxBatchSize = MAX_BATCH_SIZE_EDEFAULT;
		maxBatchSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE, oldMaxBatchSize, MAX_BATCH_SIZE_EDEFAULT, oldMaxBatchSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxBatchSize() {
		return maxBatchSizeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxConcurrentEndpoints() {
		return maxConcurrentEndpoints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxConcurrentEndpoints(int newMaxConcurrentEndpoints) {
		int oldMaxConcurrentEndpoints = maxConcurrentEndpoints;
		maxConcurrentEndpoints = newMaxConcurrentEndpoints;
		boolean oldMaxConcurrentEndpointsESet = maxConcurrentEndpointsESet;
		maxConcurrentEndpointsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS, oldMaxConcurrentEndpoints, maxConcurrentEndpoints, !oldMaxConcurrentEndpointsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxConcurrentEndpoints() {
		int oldMaxConcurrentEndpoints = maxConcurrentEndpoints;
		boolean oldMaxConcurrentEndpointsESet = maxConcurrentEndpointsESet;
		maxConcurrentEndpoints = MAX_CONCURRENT_ENDPOINTS_EDEFAULT;
		maxConcurrentEndpointsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS, oldMaxConcurrentEndpoints, MAX_CONCURRENT_ENDPOINTS_EDEFAULT, oldMaxConcurrentEndpointsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxConcurrentEndpoints() {
		return maxConcurrentEndpointsESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShareDurableSubscriptionsEnum getShareDurableSubscription() {
		return shareDurableSubscription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShareDurableSubscription(ShareDurableSubscriptionsEnum newShareDurableSubscription) {
		ShareDurableSubscriptionsEnum oldShareDurableSubscription = shareDurableSubscription;
		shareDurableSubscription = newShareDurableSubscription == null ? SHARE_DURABLE_SUBSCRIPTION_EDEFAULT : newShareDurableSubscription;
		boolean oldShareDurableSubscriptionESet = shareDurableSubscriptionESet;
		shareDurableSubscriptionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION, oldShareDurableSubscription, shareDurableSubscription, !oldShareDurableSubscriptionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShareDurableSubscription() {
		ShareDurableSubscriptionsEnum oldShareDurableSubscription = shareDurableSubscription;
		boolean oldShareDurableSubscriptionESet = shareDurableSubscriptionESet;
		shareDurableSubscription = SHARE_DURABLE_SUBSCRIPTION_EDEFAULT;
		shareDurableSubscriptionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION, oldShareDurableSubscription, SHARE_DURABLE_SUBSCRIPTION_EDEFAULT, oldShareDurableSubscriptionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShareDurableSubscription() {
		return shareDurableSubscriptionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__DURABLE_SCRIPTION_HOME:
				return getDurableScriptionHome();
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE:
				return new Integer(getMaxBatchSize());
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS:
				return new Integer(getMaxConcurrentEndpoints());
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION:
				return getShareDurableSubscription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__DURABLE_SCRIPTION_HOME:
				setDurableScriptionHome((String)newValue);
				return;
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE:
				setMaxBatchSize(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS:
				setMaxConcurrentEndpoints(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION:
				setShareDurableSubscription((ShareDurableSubscriptionsEnum)newValue);
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
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__DURABLE_SCRIPTION_HOME:
				setDurableScriptionHome(DURABLE_SCRIPTION_HOME_EDEFAULT);
				return;
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE:
				unsetMaxBatchSize();
				return;
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS:
				unsetMaxConcurrentEndpoints();
				return;
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION:
				unsetShareDurableSubscription();
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
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__DURABLE_SCRIPTION_HOME:
				return DURABLE_SCRIPTION_HOME_EDEFAULT == null ? durableScriptionHome != null : !DURABLE_SCRIPTION_HOME_EDEFAULT.equals(durableScriptionHome);
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_BATCH_SIZE:
				return isSetMaxBatchSize();
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__MAX_CONCURRENT_ENDPOINTS:
				return isSetMaxConcurrentEndpoints();
			case WasPackage.WAS_JMS_ACTIVATION_SPECIFICATION__SHARE_DURABLE_SUBSCRIPTION:
				return isSetShareDurableSubscription();
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
		result.append(" (durableScriptionHome: "); //$NON-NLS-1$
		result.append(durableScriptionHome);
		result.append(", maxBatchSize: "); //$NON-NLS-1$
		if (maxBatchSizeESet) result.append(maxBatchSize); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", maxConcurrentEndpoints: "); //$NON-NLS-1$
		if (maxConcurrentEndpointsESet) result.append(maxConcurrentEndpoints); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", shareDurableSubscription: "); //$NON-NLS-1$
		if (shareDurableSubscriptionESet) result.append(shareDurableSubscription); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasJMSActivationSpecificationImpl
