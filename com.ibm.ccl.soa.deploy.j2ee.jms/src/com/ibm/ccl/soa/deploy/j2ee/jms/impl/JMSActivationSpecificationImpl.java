/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.jms.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.j2ee.jms.AcknowledgeModeEnum;
import com.ibm.ccl.soa.deploy.j2ee.jms.JMSActivationSpecification;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JMS Activation Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#getAcknowledgeMode <em>Acknowledge Mode</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#getClientIdentifier <em>Client Identifier</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#getJndiName <em>Jndi Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#getMesasageSelector <em>Mesasage Selector</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#getSpecificationName <em>Specification Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#isSubscriptionDurable <em>Subscription Durable</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.j2ee.jms.impl.JMSActivationSpecificationImpl#getSubscriptionName <em>Subscription Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JMSActivationSpecificationImpl extends CapabilityImpl implements
		JMSActivationSpecification {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAcknowledgeMode() <em>Acknowledge Mode</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAcknowledgeMode()
	 * @generated
	 * @ordered
	 */
	protected static final AcknowledgeModeEnum ACKNOWLEDGE_MODE_EDEFAULT = AcknowledgeModeEnum.AUTO_ACKNOWLEDGE_LITERAL;

	/**
	 * The cached value of the '{@link #getAcknowledgeMode() <em>Acknowledge Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAcknowledgeMode()
	 * @generated
	 * @ordered
	 */
	protected AcknowledgeModeEnum acknowledgeMode = ACKNOWLEDGE_MODE_EDEFAULT;

	/**
	 * This is true if the Acknowledge Mode attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean acknowledgeModeESet;

	/**
	 * The default value of the '{@link #getClientIdentifier() <em>Client Identifier</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClientIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientIdentifier() <em>Client Identifier</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClientIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String clientIdentifier = CLIENT_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMesasageSelector() <em>Mesasage Selector</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMesasageSelector()
	 * @generated
	 * @ordered
	 */
	protected static final String MESASAGE_SELECTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMesasageSelector() <em>Mesasage Selector</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMesasageSelector()
	 * @generated
	 * @ordered
	 */
	protected String mesasageSelector = MESASAGE_SELECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpecificationName() <em>Specification Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSpecificationName()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecificationName() <em>Specification Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSpecificationName()
	 * @generated
	 * @ordered
	 */
	protected String specificationName = SPECIFICATION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isSubscriptionDurable() <em>Subscription Durable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSubscriptionDurable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUBSCRIPTION_DURABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSubscriptionDurable() <em>Subscription Durable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSubscriptionDurable()
	 * @generated
	 * @ordered
	 */
	protected boolean subscriptionDurable = SUBSCRIPTION_DURABLE_EDEFAULT;

	/**
	 * This is true if the Subscription Durable attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean subscriptionDurableESet;

	/**
	 * The default value of the '{@link #getSubscriptionName() <em>Subscription Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubscriptionName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBSCRIPTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubscriptionName() <em>Subscription Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubscriptionName()
	 * @generated
	 * @ordered
	 */
	protected String subscriptionName = SUBSCRIPTION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JMSActivationSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JmsPackage.Literals.JMS_ACTIVATION_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AcknowledgeModeEnum getAcknowledgeMode() {
		return acknowledgeMode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAcknowledgeMode(AcknowledgeModeEnum newAcknowledgeMode) {
		AcknowledgeModeEnum oldAcknowledgeMode = acknowledgeMode;
		acknowledgeMode = newAcknowledgeMode == null ? ACKNOWLEDGE_MODE_EDEFAULT : newAcknowledgeMode;
		boolean oldAcknowledgeModeESet = acknowledgeModeESet;
		acknowledgeModeESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE, oldAcknowledgeMode,
					acknowledgeMode, !oldAcknowledgeModeESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetAcknowledgeMode() {
		AcknowledgeModeEnum oldAcknowledgeMode = acknowledgeMode;
		boolean oldAcknowledgeModeESet = acknowledgeModeESet;
		acknowledgeMode = ACKNOWLEDGE_MODE_EDEFAULT;
		acknowledgeModeESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE, oldAcknowledgeMode,
					ACKNOWLEDGE_MODE_EDEFAULT, oldAcknowledgeModeESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetAcknowledgeMode() {
		return acknowledgeModeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getClientIdentifier() {
		return clientIdentifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setClientIdentifier(String newClientIdentifier) {
		String oldClientIdentifier = clientIdentifier;
		clientIdentifier = newClientIdentifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER, oldClientIdentifier,
					clientIdentifier));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setJndiName(String newJndiName) {
		String oldJndiName = jndiName;
		jndiName = newJndiName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__JNDI_NAME, oldJndiName, jndiName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMesasageSelector() {
		return mesasageSelector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMesasageSelector(String newMesasageSelector) {
		String oldMesasageSelector = mesasageSelector;
		mesasageSelector = newMesasageSelector;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR, oldMesasageSelector,
					mesasageSelector));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSpecificationName() {
		return specificationName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSpecificationName(String newSpecificationName) {
		String oldSpecificationName = specificationName;
		specificationName = newSpecificationName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME, oldSpecificationName,
					specificationName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSubscriptionDurable() {
		return subscriptionDurable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSubscriptionDurable(boolean newSubscriptionDurable) {
		boolean oldSubscriptionDurable = subscriptionDurable;
		subscriptionDurable = newSubscriptionDurable;
		boolean oldSubscriptionDurableESet = subscriptionDurableESet;
		subscriptionDurableESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE,
					oldSubscriptionDurable, subscriptionDurable, !oldSubscriptionDurableESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetSubscriptionDurable() {
		boolean oldSubscriptionDurable = subscriptionDurable;
		boolean oldSubscriptionDurableESet = subscriptionDurableESet;
		subscriptionDurable = SUBSCRIPTION_DURABLE_EDEFAULT;
		subscriptionDurableESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE,
					oldSubscriptionDurable, SUBSCRIPTION_DURABLE_EDEFAULT, oldSubscriptionDurableESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetSubscriptionDurable() {
		return subscriptionDurableESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSubscriptionName() {
		return subscriptionName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSubscriptionName(String newSubscriptionName) {
		String oldSubscriptionName = subscriptionName;
		subscriptionName = newSubscriptionName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME, oldSubscriptionName,
					subscriptionName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE:
			return getAcknowledgeMode();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER:
			return getClientIdentifier();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__JNDI_NAME:
			return getJndiName();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR:
			return getMesasageSelector();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME:
			return getSpecificationName();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE:
			return isSubscriptionDurable() ? Boolean.TRUE : Boolean.FALSE;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME:
			return getSubscriptionName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE:
			setAcknowledgeMode((AcknowledgeModeEnum) newValue);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER:
			setClientIdentifier((String) newValue);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__JNDI_NAME:
			setJndiName((String) newValue);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR:
			setMesasageSelector((String) newValue);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME:
			setSpecificationName((String) newValue);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE:
			setSubscriptionDurable(((Boolean) newValue).booleanValue());
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME:
			setSubscriptionName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE:
			unsetAcknowledgeMode();
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER:
			setClientIdentifier(CLIENT_IDENTIFIER_EDEFAULT);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__JNDI_NAME:
			setJndiName(JNDI_NAME_EDEFAULT);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR:
			setMesasageSelector(MESASAGE_SELECTOR_EDEFAULT);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME:
			setSpecificationName(SPECIFICATION_NAME_EDEFAULT);
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE:
			unsetSubscriptionDurable();
			return;
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME:
			setSubscriptionName(SUBSCRIPTION_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__ACKNOWLEDGE_MODE:
			return isSetAcknowledgeMode();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__CLIENT_IDENTIFIER:
			return CLIENT_IDENTIFIER_EDEFAULT == null ? clientIdentifier != null
					: !CLIENT_IDENTIFIER_EDEFAULT.equals(clientIdentifier);
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__JNDI_NAME:
			return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT
					.equals(jndiName);
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__MESASAGE_SELECTOR:
			return MESASAGE_SELECTOR_EDEFAULT == null ? mesasageSelector != null
					: !MESASAGE_SELECTOR_EDEFAULT.equals(mesasageSelector);
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME:
			return SPECIFICATION_NAME_EDEFAULT == null ? specificationName != null
					: !SPECIFICATION_NAME_EDEFAULT.equals(specificationName);
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_DURABLE:
			return isSetSubscriptionDurable();
		case JmsPackage.JMS_ACTIVATION_SPECIFICATION__SUBSCRIPTION_NAME:
			return SUBSCRIPTION_NAME_EDEFAULT == null ? subscriptionName != null
					: !SUBSCRIPTION_NAME_EDEFAULT.equals(subscriptionName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (acknowledgeMode: "); //$NON-NLS-1$
		if (acknowledgeModeESet) {
			result.append(acknowledgeMode);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", clientIdentifier: "); //$NON-NLS-1$
		result.append(clientIdentifier);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", mesasageSelector: "); //$NON-NLS-1$
		result.append(mesasageSelector);
		result.append(", specificationName: "); //$NON-NLS-1$
		result.append(specificationName);
		result.append(", subscriptionDurable: "); //$NON-NLS-1$
		if (subscriptionDurableESet) {
			result.append(subscriptionDurable);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", subscriptionName: "); //$NON-NLS-1$
		result.append(subscriptionName);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections
			.singletonList(JmsPackage.Literals.JMS_ACTIVATION_SPECIFICATION__SPECIFICATION_NAME);

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //JMSActivationSpecificationImpl
