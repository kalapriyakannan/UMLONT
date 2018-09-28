/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort;
import com.ibm.ccl.soa.deploy.mq.MqPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Messeage Listerner Service Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl#getCFJNDIName <em>CFJNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl#getDestinationJNDIName <em>Destination JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl#getMaxRetries <em>Max Retries</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl#getMaxSessions <em>Max Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.impl.MesseageListernerServicePortImpl#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MesseageListernerServicePortImpl extends CapabilityImpl implements MesseageListernerServicePort {
	/**
	 * The default value of the '{@link #getCFJNDIName() <em>CFJNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCFJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String CFJNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCFJNDIName() <em>CFJNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCFJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String cFJNDIName = CFJNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDestinationJNDIName() <em>Destination JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDestinationJNDIName() <em>Destination JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String destinationJNDIName = DESTINATION_JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxRetries() <em>Max Retries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxRetries()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_RETRIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxRetries() <em>Max Retries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxRetries()
	 * @generated
	 * @ordered
	 */
	protected String maxRetries = MAX_RETRIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxSessions() <em>Max Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSessions()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_SESSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxSessions() <em>Max Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSessions()
	 * @generated
	 * @ordered
	 */
	protected String maxSessions = MAX_SESSIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MesseageListernerServicePortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MqPackage.Literals.MESSEAGE_LISTERNER_SERVICE_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCFJNDIName() {
		return cFJNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCFJNDIName(String newCFJNDIName) {
		String oldCFJNDIName = cFJNDIName;
		cFJNDIName = newCFJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME, oldCFJNDIName, cFJNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestinationJNDIName() {
		return destinationJNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationJNDIName(String newDestinationJNDIName) {
		String oldDestinationJNDIName = destinationJNDIName;
		destinationJNDIName = newDestinationJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME, oldDestinationJNDIName, destinationJNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxRetries() {
		return maxRetries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRetries(String newMaxRetries) {
		String oldMaxRetries = maxRetries;
		maxRetries = newMaxRetries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES, oldMaxRetries, maxRetries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxSessions() {
		return maxSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSessions(String newMaxSessions) {
		String oldMaxSessions = maxSessions;
		maxSessions = newMaxSessions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS, oldMaxSessions, maxSessions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME:
				return getCFJNDIName();
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME:
				return getDestinationJNDIName();
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES:
				return getMaxRetries();
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS:
				return getMaxSessions();
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1:
				return getName1();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME:
				setCFJNDIName((String)newValue);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME:
				setDestinationJNDIName((String)newValue);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES:
				setMaxRetries((String)newValue);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS:
				setMaxSessions((String)newValue);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1:
				setName1((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME:
				setCFJNDIName(CFJNDI_NAME_EDEFAULT);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME:
				setDestinationJNDIName(DESTINATION_JNDI_NAME_EDEFAULT);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES:
				setMaxRetries(MAX_RETRIES_EDEFAULT);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS:
				setMaxSessions(MAX_SESSIONS_EDEFAULT);
				return;
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__CFJNDI_NAME:
				return CFJNDI_NAME_EDEFAULT == null ? cFJNDIName != null : !CFJNDI_NAME_EDEFAULT.equals(cFJNDIName);
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__DESTINATION_JNDI_NAME:
				return DESTINATION_JNDI_NAME_EDEFAULT == null ? destinationJNDIName != null : !DESTINATION_JNDI_NAME_EDEFAULT.equals(destinationJNDIName);
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_RETRIES:
				return MAX_RETRIES_EDEFAULT == null ? maxRetries != null : !MAX_RETRIES_EDEFAULT.equals(maxRetries);
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__MAX_SESSIONS:
				return MAX_SESSIONS_EDEFAULT == null ? maxSessions != null : !MAX_SESSIONS_EDEFAULT.equals(maxSessions);
			case MqPackage.MESSEAGE_LISTERNER_SERVICE_PORT__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cFJNDIName: "); //$NON-NLS-1$
		result.append(cFJNDIName);
		result.append(", destinationJNDIName: "); //$NON-NLS-1$
		result.append(destinationJNDIName);
		result.append(", maxRetries: "); //$NON-NLS-1$
		result.append(maxRetries);
		result.append(", maxSessions: "); //$NON-NLS-1$
		result.append(maxSessions);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(')');
		return result.toString();
	}

} //MesseageListernerServicePortImpl
