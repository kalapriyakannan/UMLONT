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

import com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSTopicDestinationImpl;
import com.ibm.ccl.soa.deploy.was.ConnectionDeliveryModeEnum;
import com.ibm.ccl.soa.deploy.was.WasDefaultMessagingTopicDestination;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Default Messaging Topic Destination</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingTopicDestinationImpl#getConnectionDeliveryMode <em>Connection Delivery Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingTopicDestinationImpl#getMessageLiveTime <em>Message Live Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingTopicDestinationImpl#getMessagePriority <em>Message Priority</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDefaultMessagingTopicDestinationImpl#getTopicName <em>Topic Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasDefaultMessagingTopicDestinationImpl extends JMSTopicDestinationImpl implements
		WasDefaultMessagingTopicDestination {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getConnectionDeliveryMode() <em>Connection Delivery Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConnectionDeliveryMode()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionDeliveryModeEnum CONNECTION_DELIVERY_MODE_EDEFAULT = ConnectionDeliveryModeEnum.APPLICATION_LITERAL;

	/**
	 * The cached value of the '{@link #getConnectionDeliveryMode() <em>Connection Delivery Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConnectionDeliveryMode()
	 * @generated
	 * @ordered
	 */
	protected ConnectionDeliveryModeEnum connectionDeliveryMode = CONNECTION_DELIVERY_MODE_EDEFAULT;

	/**
	 * This is true if the Connection Delivery Mode attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean connectionDeliveryModeESet;

	/**
	 * The default value of the '{@link #getMessageLiveTime() <em>Message Live Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessageLiveTime()
	 * @generated
	 * @ordered
	 */
	protected static final long MESSAGE_LIVE_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMessageLiveTime() <em>Message Live Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessageLiveTime()
	 * @generated
	 * @ordered
	 */
	protected long messageLiveTime = MESSAGE_LIVE_TIME_EDEFAULT;

	/**
	 * This is true if the Message Live Time attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean messageLiveTimeESet;

	/**
	 * The default value of the '{@link #getMessagePriority() <em>Message Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessagePriority()
	 * @generated
	 * @ordered
	 */
	protected static final int MESSAGE_PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMessagePriority() <em>Message Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessagePriority()
	 * @generated
	 * @ordered
	 */
	protected int messagePriority = MESSAGE_PRIORITY_EDEFAULT;

	/**
	 * This is true if the Message Priority attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean messagePriorityESet;

	/**
	 * The default value of the '{@link #getTopicName() <em>Topic Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTopicName()
	 * @generated
	 * @ordered
	 */
	protected static final String TOPIC_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTopicName() <em>Topic Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTopicName()
	 * @generated
	 * @ordered
	 */
	protected String topicName = TOPIC_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasDefaultMessagingTopicDestinationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionDeliveryModeEnum getConnectionDeliveryMode() {
		return connectionDeliveryMode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionDeliveryMode(ConnectionDeliveryModeEnum newConnectionDeliveryMode) {
		ConnectionDeliveryModeEnum oldConnectionDeliveryMode = connectionDeliveryMode;
		connectionDeliveryMode = newConnectionDeliveryMode == null ? CONNECTION_DELIVERY_MODE_EDEFAULT : newConnectionDeliveryMode;
		boolean oldConnectionDeliveryModeESet = connectionDeliveryModeESet;
		connectionDeliveryModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE, oldConnectionDeliveryMode, connectionDeliveryMode, !oldConnectionDeliveryModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionDeliveryMode() {
		ConnectionDeliveryModeEnum oldConnectionDeliveryMode = connectionDeliveryMode;
		boolean oldConnectionDeliveryModeESet = connectionDeliveryModeESet;
		connectionDeliveryMode = CONNECTION_DELIVERY_MODE_EDEFAULT;
		connectionDeliveryModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE, oldConnectionDeliveryMode, CONNECTION_DELIVERY_MODE_EDEFAULT, oldConnectionDeliveryModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionDeliveryMode() {
		return connectionDeliveryModeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getMessageLiveTime() {
		return messageLiveTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageLiveTime(long newMessageLiveTime) {
		long oldMessageLiveTime = messageLiveTime;
		messageLiveTime = newMessageLiveTime;
		boolean oldMessageLiveTimeESet = messageLiveTimeESet;
		messageLiveTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME, oldMessageLiveTime, messageLiveTime, !oldMessageLiveTimeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMessageLiveTime() {
		long oldMessageLiveTime = messageLiveTime;
		boolean oldMessageLiveTimeESet = messageLiveTimeESet;
		messageLiveTime = MESSAGE_LIVE_TIME_EDEFAULT;
		messageLiveTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME, oldMessageLiveTime, MESSAGE_LIVE_TIME_EDEFAULT, oldMessageLiveTimeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMessageLiveTime() {
		return messageLiveTimeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMessagePriority() {
		return messagePriority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessagePriority(int newMessagePriority) {
		int oldMessagePriority = messagePriority;
		messagePriority = newMessagePriority;
		boolean oldMessagePriorityESet = messagePriorityESet;
		messagePriorityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY, oldMessagePriority, messagePriority, !oldMessagePriorityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMessagePriority() {
		int oldMessagePriority = messagePriority;
		boolean oldMessagePriorityESet = messagePriorityESet;
		messagePriority = MESSAGE_PRIORITY_EDEFAULT;
		messagePriorityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY, oldMessagePriority, MESSAGE_PRIORITY_EDEFAULT, oldMessagePriorityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMessagePriority() {
		return messagePriorityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopicName(String newTopicName) {
		String oldTopicName = topicName;
		topicName = newTopicName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__TOPIC_NAME, oldTopicName, topicName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE:
				return getConnectionDeliveryMode();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME:
				return new Long(getMessageLiveTime());
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY:
				return new Integer(getMessagePriority());
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__TOPIC_NAME:
				return getTopicName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE:
				setConnectionDeliveryMode((ConnectionDeliveryModeEnum)newValue);
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME:
				setMessageLiveTime(((Long)newValue).longValue());
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY:
				setMessagePriority(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__TOPIC_NAME:
				setTopicName((String)newValue);
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
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE:
				unsetConnectionDeliveryMode();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME:
				unsetMessageLiveTime();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY:
				unsetMessagePriority();
				return;
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__TOPIC_NAME:
				setTopicName(TOPIC_NAME_EDEFAULT);
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
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__CONNECTION_DELIVERY_MODE:
				return isSetConnectionDeliveryMode();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_LIVE_TIME:
				return isSetMessageLiveTime();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__MESSAGE_PRIORITY:
				return isSetMessagePriority();
			case WasPackage.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION__TOPIC_NAME:
				return TOPIC_NAME_EDEFAULT == null ? topicName != null : !TOPIC_NAME_EDEFAULT.equals(topicName);
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
		result.append(" (connectionDeliveryMode: "); //$NON-NLS-1$
		if (connectionDeliveryModeESet) result.append(connectionDeliveryMode); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", messageLiveTime: "); //$NON-NLS-1$
		if (messageLiveTimeESet) result.append(messageLiveTime); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", messagePriority: "); //$NON-NLS-1$
		if (messagePriorityESet) result.append(messagePriority); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", topicName: "); //$NON-NLS-1$
		result.append(topicName);
		result.append(')');
		return result.toString();
	}

} //WasDefaultMessagingTopicDestinationImpl
