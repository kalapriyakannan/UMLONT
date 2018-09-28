/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSIBus;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>SI Bus</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSIBusImpl#getBusName <em>Bus Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSIBusImpl#isConfigurationReload <em>Configuration Reload</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSIBusImpl#isDiscardMessages <em>Discard Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSIBusImpl#getHighMessageThreshold <em>High Message Threshold</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSIBusImpl#getInterEngineTransportChain <em>Inter Engine Transport Chain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSIBusImpl extends CapabilityImpl implements WasSIBus {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBusName() <em>Bus Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBusName()
	 * @generated
	 * @ordered
	 */
	protected static final String BUS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusName() <em>Bus Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBusName()
	 * @generated
	 * @ordered
	 */
	protected String busName = BUS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isConfigurationReload() <em>Configuration Reload</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isConfigurationReload()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONFIGURATION_RELOAD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConfigurationReload() <em>Configuration Reload</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isConfigurationReload()
	 * @generated
	 * @ordered
	 */
	protected boolean configurationReload = CONFIGURATION_RELOAD_EDEFAULT;

	/**
	 * This is true if the Configuration Reload attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean configurationReloadESet;

	/**
	 * The default value of the '{@link #isDiscardMessages() <em>Discard Messages</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDiscardMessages()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISCARD_MESSAGES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDiscardMessages() <em>Discard Messages</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDiscardMessages()
	 * @generated
	 * @ordered
	 */
	protected boolean discardMessages = DISCARD_MESSAGES_EDEFAULT;

	/**
	 * This is true if the Discard Messages attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean discardMessagesESet;

	/**
	 * The default value of the '{@link #getHighMessageThreshold() <em>High Message Threshold</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHighMessageThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final int HIGH_MESSAGE_THRESHOLD_EDEFAULT = 50000;

	/**
	 * The cached value of the '{@link #getHighMessageThreshold() <em>High Message Threshold</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHighMessageThreshold()
	 * @generated
	 * @ordered
	 */
	protected int highMessageThreshold = HIGH_MESSAGE_THRESHOLD_EDEFAULT;

	/**
	 * This is true if the High Message Threshold attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean highMessageThresholdESet;

	/**
	 * The default value of the '{@link #getInterEngineTransportChain() <em>Inter Engine Transport Chain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInterEngineTransportChain()
	 * @generated
	 * @ordered
	 */
	protected static final String INTER_ENGINE_TRANSPORT_CHAIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInterEngineTransportChain() <em>Inter Engine Transport Chain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInterEngineTransportChain()
	 * @generated
	 * @ordered
	 */
	protected String interEngineTransportChain = INTER_ENGINE_TRANSPORT_CHAIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSIBusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SI_BUS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBusName() {
		return busName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusName(String newBusName) {
		String oldBusName = busName;
		busName = newBusName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SI_BUS__BUS_NAME, oldBusName, busName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConfigurationReload() {
		return configurationReload;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationReload(boolean newConfigurationReload) {
		boolean oldConfigurationReload = configurationReload;
		configurationReload = newConfigurationReload;
		boolean oldConfigurationReloadESet = configurationReloadESet;
		configurationReloadESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SI_BUS__CONFIGURATION_RELOAD, oldConfigurationReload, configurationReload, !oldConfigurationReloadESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConfigurationReload() {
		boolean oldConfigurationReload = configurationReload;
		boolean oldConfigurationReloadESet = configurationReloadESet;
		configurationReload = CONFIGURATION_RELOAD_EDEFAULT;
		configurationReloadESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SI_BUS__CONFIGURATION_RELOAD, oldConfigurationReload, CONFIGURATION_RELOAD_EDEFAULT, oldConfigurationReloadESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConfigurationReload() {
		return configurationReloadESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDiscardMessages() {
		return discardMessages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscardMessages(boolean newDiscardMessages) {
		boolean oldDiscardMessages = discardMessages;
		discardMessages = newDiscardMessages;
		boolean oldDiscardMessagesESet = discardMessagesESet;
		discardMessagesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SI_BUS__DISCARD_MESSAGES, oldDiscardMessages, discardMessages, !oldDiscardMessagesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDiscardMessages() {
		boolean oldDiscardMessages = discardMessages;
		boolean oldDiscardMessagesESet = discardMessagesESet;
		discardMessages = DISCARD_MESSAGES_EDEFAULT;
		discardMessagesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SI_BUS__DISCARD_MESSAGES, oldDiscardMessages, DISCARD_MESSAGES_EDEFAULT, oldDiscardMessagesESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDiscardMessages() {
		return discardMessagesESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getHighMessageThreshold() {
		return highMessageThreshold;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighMessageThreshold(int newHighMessageThreshold) {
		int oldHighMessageThreshold = highMessageThreshold;
		highMessageThreshold = newHighMessageThreshold;
		boolean oldHighMessageThresholdESet = highMessageThresholdESet;
		highMessageThresholdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD, oldHighMessageThreshold, highMessageThreshold, !oldHighMessageThresholdESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHighMessageThreshold() {
		int oldHighMessageThreshold = highMessageThreshold;
		boolean oldHighMessageThresholdESet = highMessageThresholdESet;
		highMessageThreshold = HIGH_MESSAGE_THRESHOLD_EDEFAULT;
		highMessageThresholdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD, oldHighMessageThreshold, HIGH_MESSAGE_THRESHOLD_EDEFAULT, oldHighMessageThresholdESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHighMessageThreshold() {
		return highMessageThresholdESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterEngineTransportChain() {
		return interEngineTransportChain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterEngineTransportChain(String newInterEngineTransportChain) {
		String oldInterEngineTransportChain = interEngineTransportChain;
		interEngineTransportChain = newInterEngineTransportChain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SI_BUS__INTER_ENGINE_TRANSPORT_CHAIN, oldInterEngineTransportChain, interEngineTransportChain));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SI_BUS__BUS_NAME:
				return getBusName();
			case WasPackage.WAS_SI_BUS__CONFIGURATION_RELOAD:
				return isConfigurationReload() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SI_BUS__DISCARD_MESSAGES:
				return isDiscardMessages() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD:
				return new Integer(getHighMessageThreshold());
			case WasPackage.WAS_SI_BUS__INTER_ENGINE_TRANSPORT_CHAIN:
				return getInterEngineTransportChain();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SI_BUS__BUS_NAME:
				setBusName((String)newValue);
				return;
			case WasPackage.WAS_SI_BUS__CONFIGURATION_RELOAD:
				setConfigurationReload(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SI_BUS__DISCARD_MESSAGES:
				setDiscardMessages(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD:
				setHighMessageThreshold(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_SI_BUS__INTER_ENGINE_TRANSPORT_CHAIN:
				setInterEngineTransportChain((String)newValue);
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
			case WasPackage.WAS_SI_BUS__BUS_NAME:
				setBusName(BUS_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SI_BUS__CONFIGURATION_RELOAD:
				unsetConfigurationReload();
				return;
			case WasPackage.WAS_SI_BUS__DISCARD_MESSAGES:
				unsetDiscardMessages();
				return;
			case WasPackage.WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD:
				unsetHighMessageThreshold();
				return;
			case WasPackage.WAS_SI_BUS__INTER_ENGINE_TRANSPORT_CHAIN:
				setInterEngineTransportChain(INTER_ENGINE_TRANSPORT_CHAIN_EDEFAULT);
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
			case WasPackage.WAS_SI_BUS__BUS_NAME:
				return BUS_NAME_EDEFAULT == null ? busName != null : !BUS_NAME_EDEFAULT.equals(busName);
			case WasPackage.WAS_SI_BUS__CONFIGURATION_RELOAD:
				return isSetConfigurationReload();
			case WasPackage.WAS_SI_BUS__DISCARD_MESSAGES:
				return isSetDiscardMessages();
			case WasPackage.WAS_SI_BUS__HIGH_MESSAGE_THRESHOLD:
				return isSetHighMessageThreshold();
			case WasPackage.WAS_SI_BUS__INTER_ENGINE_TRANSPORT_CHAIN:
				return INTER_ENGINE_TRANSPORT_CHAIN_EDEFAULT == null ? interEngineTransportChain != null : !INTER_ENGINE_TRANSPORT_CHAIN_EDEFAULT.equals(interEngineTransportChain);
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
		result.append(" (busName: "); //$NON-NLS-1$
		result.append(busName);
		result.append(", configurationReload: "); //$NON-NLS-1$
		if (configurationReloadESet) result.append(configurationReload); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", discardMessages: "); //$NON-NLS-1$
		if (discardMessagesESet) result.append(discardMessages); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", highMessageThreshold: "); //$NON-NLS-1$
		if (highMessageThresholdESet) result.append(highMessageThreshold); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", interEngineTransportChain: "); //$NON-NLS-1$
		result.append(interEngineTransportChain);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections
			.singletonList(WasPackage.Literals.WAS_SI_BUS__BUS_NAME);

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //WasSIBusImpl
