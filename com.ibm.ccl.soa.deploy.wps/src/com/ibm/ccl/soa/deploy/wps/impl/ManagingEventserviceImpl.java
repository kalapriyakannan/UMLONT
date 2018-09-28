/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.wps.ManagingEventservice;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Managing Eventservice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.ManagingEventserviceImpl#getEventsInfrastructureEmitterFactoryJNDIName <em>Events Infrastructure Emitter Factory JNDI Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagingEventserviceImpl extends CapabilityImpl implements ManagingEventservice {
	/**
	 * The default value of the '{@link #getEventsInfrastructureEmitterFactoryJNDIName() <em>Events Infrastructure Emitter Factory JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventsInfrastructureEmitterFactoryJNDIName()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventsInfrastructureEmitterFactoryJNDIName() <em>Events Infrastructure Emitter Factory JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventsInfrastructureEmitterFactoryJNDIName()
	 * @generated
	 * @ordered
	 */
	protected String eventsInfrastructureEmitterFactoryJNDIName = EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagingEventserviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.MANAGING_EVENTSERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventsInfrastructureEmitterFactoryJNDIName() {
		return eventsInfrastructureEmitterFactoryJNDIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventsInfrastructureEmitterFactoryJNDIName(String newEventsInfrastructureEmitterFactoryJNDIName) {
		String oldEventsInfrastructureEmitterFactoryJNDIName = eventsInfrastructureEmitterFactoryJNDIName;
		eventsInfrastructureEmitterFactoryJNDIName = newEventsInfrastructureEmitterFactoryJNDIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME, oldEventsInfrastructureEmitterFactoryJNDIName, eventsInfrastructureEmitterFactoryJNDIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME:
				return getEventsInfrastructureEmitterFactoryJNDIName();
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
			case WpsPackage.MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME:
				setEventsInfrastructureEmitterFactoryJNDIName((String)newValue);
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
			case WpsPackage.MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME:
				setEventsInfrastructureEmitterFactoryJNDIName(EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME_EDEFAULT);
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
			case WpsPackage.MANAGING_EVENTSERVICE__EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME:
				return EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME_EDEFAULT == null ? eventsInfrastructureEmitterFactoryJNDIName != null : !EVENTS_INFRASTRUCTURE_EMITTER_FACTORY_JNDI_NAME_EDEFAULT.equals(eventsInfrastructureEmitterFactoryJNDIName);
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
		result.append(" (eventsInfrastructureEmitterFactoryJNDIName: "); //$NON-NLS-1$
		result.append(eventsInfrastructureEmitterFactoryJNDIName);
		result.append(')');
		return result.toString();
	}

} //ManagingEventserviceImpl
