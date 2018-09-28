/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: ApplicationCommunicationProtocolConstraintImpl.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Application Communication Protocol Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationProtocolConstraintImpl#getApplicationLayerProtocol <em>Application Layer Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationCommunicationProtocolConstraintImpl extends
		CommunicationChildConstraintImpl implements ApplicationCommunicationProtocolConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getApplicationLayerProtocol() <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_LAYER_PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicationLayerProtocol() <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 * @ordered
	 */
	protected String applicationLayerProtocol = APPLICATION_LAYER_PROTOCOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationCommunicationProtocolConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationLayerProtocol() {
		return applicationLayerProtocol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationLayerProtocol(String newApplicationLayerProtocol) {
		String oldApplicationLayerProtocol = applicationLayerProtocol;
		applicationLayerProtocol = newApplicationLayerProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL, oldApplicationLayerProtocol, applicationLayerProtocol));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL:
				return getApplicationLayerProtocol();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL:
				setApplicationLayerProtocol((String)newValue);
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
			case ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL:
				setApplicationLayerProtocol(APPLICATION_LAYER_PROTOCOL_EDEFAULT);
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
			case ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL:
				return APPLICATION_LAYER_PROTOCOL_EDEFAULT == null ? applicationLayerProtocol != null : !APPLICATION_LAYER_PROTOCOL_EDEFAULT.equals(applicationLayerProtocol);
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
		result.append(" (applicationLayerProtocol: "); //$NON-NLS-1$
		result.append(applicationLayerProtocol);
		result.append(')');
		return result.toString();
	}

} //ApplicationCommunicationProtocolConstraintImpl
