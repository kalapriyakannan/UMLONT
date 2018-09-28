/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.CorePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Communication Capability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.CommunicationCapabilityImpl#getApplicationLayerProtocol <em>Application Layer Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.CommunicationCapabilityImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationCapabilityImpl extends CapabilityImpl implements CommunicationCapability {
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
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected BigInteger port = PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationCapabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.COMMUNICATION_CAPABILITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL, oldApplicationLayerProtocol, applicationLayerProtocol));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(BigInteger newPort) {
		BigInteger oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.COMMUNICATION_CAPABILITY__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL:
				return getApplicationLayerProtocol();
			case CorePackage.COMMUNICATION_CAPABILITY__PORT:
				return getPort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL:
				setApplicationLayerProtocol((String)newValue);
				return;
			case CorePackage.COMMUNICATION_CAPABILITY__PORT:
				setPort((BigInteger)newValue);
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
			case CorePackage.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL:
				setApplicationLayerProtocol(APPLICATION_LAYER_PROTOCOL_EDEFAULT);
				return;
			case CorePackage.COMMUNICATION_CAPABILITY__PORT:
				setPort(PORT_EDEFAULT);
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
			case CorePackage.COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL:
				return APPLICATION_LAYER_PROTOCOL_EDEFAULT == null ? applicationLayerProtocol != null : !APPLICATION_LAYER_PROTOCOL_EDEFAULT.equals(applicationLayerProtocol);
			case CorePackage.COMMUNICATION_CAPABILITY__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
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
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(')');
		return result.toString();
	}

} //CommunicationCapabilityImpl
