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
import com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService;
import com.ibm.ccl.soa.deploy.wps.WpsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Messaging Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.ExtendedMessagingServiceImpl#getInputPort <em>Input Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.impl.ExtendedMessagingServiceImpl#getOutputPort <em>Output Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendedMessagingServiceImpl extends CapabilityImpl implements ExtendedMessagingService {
	/**
	 * The default value of the '{@link #getInputPort() <em>Input Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPort()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputPort() <em>Input Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPort()
	 * @generated
	 * @ordered
	 */
	protected String inputPort = INPUT_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputPort() <em>Output Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPort()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputPort() <em>Output Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPort()
	 * @generated
	 * @ordered
	 */
	protected String outputPort = OUTPUT_PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedMessagingServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WpsPackage.Literals.EXTENDED_MESSAGING_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputPort() {
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPort(String newInputPort) {
		String oldInputPort = inputPort;
		inputPort = newInputPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.EXTENDED_MESSAGING_SERVICE__INPUT_PORT, oldInputPort, inputPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputPort() {
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputPort(String newOutputPort) {
		String oldOutputPort = outputPort;
		outputPort = newOutputPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpsPackage.EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT, oldOutputPort, outputPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__INPUT_PORT:
				return getInputPort();
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT:
				return getOutputPort();
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
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__INPUT_PORT:
				setInputPort((String)newValue);
				return;
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT:
				setOutputPort((String)newValue);
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
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__INPUT_PORT:
				setInputPort(INPUT_PORT_EDEFAULT);
				return;
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT:
				setOutputPort(OUTPUT_PORT_EDEFAULT);
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
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__INPUT_PORT:
				return INPUT_PORT_EDEFAULT == null ? inputPort != null : !INPUT_PORT_EDEFAULT.equals(inputPort);
			case WpsPackage.EXTENDED_MESSAGING_SERVICE__OUTPUT_PORT:
				return OUTPUT_PORT_EDEFAULT == null ? outputPort != null : !OUTPUT_PORT_EDEFAULT.equals(outputPort);
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
		result.append(" (inputPort: "); //$NON-NLS-1$
		result.append(inputPort);
		result.append(", outputPort: "); //$NON-NLS-1$
		result.append(outputPort);
		result.append(')');
		return result.toString();
	}

} //ExtendedMessagingServiceImpl
