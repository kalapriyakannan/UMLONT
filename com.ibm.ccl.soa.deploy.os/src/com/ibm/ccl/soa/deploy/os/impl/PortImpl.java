/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Port</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl#getApplicationLayerProtocol <em>Application Layer Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl#getIpAddressOrHostname <em>Ip Address Or Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl#getPortName <em>Port Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl#getTransportLayerProtocol <em>Transport Layer Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends CapabilityImpl implements Port {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getApplicationLayerProtocol() <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_LAYER_PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getApplicationLayerProtocol() <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 * @ordered
	 */
	protected String applicationLayerProtocol = APPLICATION_LAYER_PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getIpAddressOrHostname() <em>Ip Address Or Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIpAddressOrHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String IP_ADDRESS_OR_HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIpAddressOrHostname() <em>Ip Address Or Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIpAddressOrHostname()
	 * @generated
	 * @ordered
	 */
	protected String ipAddressOrHostname = IP_ADDRESS_OR_HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected BigInteger port = PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPortName() <em>Port Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPortName()
	 * @generated
	 * @ordered
	 */
	protected static final String PORT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPortName() <em>Port Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPortName()
	 * @generated
	 * @ordered
	 */
	protected String portName = PORT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransportLayerProtocol() <em>Transport Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTransportLayerProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final TransportLayerProtocolType TRANSPORT_LAYER_PROTOCOL_EDEFAULT = TransportLayerProtocolType.TCP_LITERAL;

	/**
	 * The cached value of the '{@link #getTransportLayerProtocol() <em>Transport Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTransportLayerProtocol()
	 * @generated
	 * @ordered
	 */
	protected TransportLayerProtocolType transportLayerProtocol = TRANSPORT_LAYER_PROTOCOL_EDEFAULT;

	/**
	 * This is true if the Transport Layer Protocol attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean transportLayerProtocolESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationLayerProtocol() {
		return applicationLayerProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationLayerProtocol(String newApplicationLayerProtocol) {
		String oldApplicationLayerProtocol = applicationLayerProtocol;
		applicationLayerProtocol = newApplicationLayerProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.PORT__APPLICATION_LAYER_PROTOCOL, oldApplicationLayerProtocol,
					applicationLayerProtocol));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIpAddressOrHostname() {
		return ipAddressOrHostname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpAddressOrHostname(String newIpAddressOrHostname) {
		String oldIpAddressOrHostname = ipAddressOrHostname;
		ipAddressOrHostname = newIpAddressOrHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.PORT__IP_ADDRESS_OR_HOSTNAME, oldIpAddressOrHostname, ipAddressOrHostname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(BigInteger newPort) {
		BigInteger oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.PORT__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPortName() {
		return portName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortName(String newPortName) {
		String oldPortName = portName;
		portName = newPortName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.PORT__PORT_NAME,
					oldPortName, portName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransportLayerProtocolType getTransportLayerProtocol() {
		return transportLayerProtocol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransportLayerProtocol(TransportLayerProtocolType newTransportLayerProtocol) {
		TransportLayerProtocolType oldTransportLayerProtocol = transportLayerProtocol;
		transportLayerProtocol = newTransportLayerProtocol == null ? TRANSPORT_LAYER_PROTOCOL_EDEFAULT
				: newTransportLayerProtocol;
		boolean oldTransportLayerProtocolESet = transportLayerProtocolESet;
		transportLayerProtocolESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.PORT__TRANSPORT_LAYER_PROTOCOL, oldTransportLayerProtocol,
					transportLayerProtocol, !oldTransportLayerProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTransportLayerProtocol() {
		TransportLayerProtocolType oldTransportLayerProtocol = transportLayerProtocol;
		boolean oldTransportLayerProtocolESet = transportLayerProtocolESet;
		transportLayerProtocol = TRANSPORT_LAYER_PROTOCOL_EDEFAULT;
		transportLayerProtocolESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.PORT__TRANSPORT_LAYER_PROTOCOL, oldTransportLayerProtocol,
					TRANSPORT_LAYER_PROTOCOL_EDEFAULT, oldTransportLayerProtocolESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTransportLayerProtocol() {
		return transportLayerProtocolESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.PORT__APPLICATION_LAYER_PROTOCOL:
			return getApplicationLayerProtocol();
		case OsPackage.PORT__IP_ADDRESS_OR_HOSTNAME:
			return getIpAddressOrHostname();
		case OsPackage.PORT__PORT:
			return getPort();
		case OsPackage.PORT__PORT_NAME:
			return getPortName();
		case OsPackage.PORT__TRANSPORT_LAYER_PROTOCOL:
			return getTransportLayerProtocol();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.PORT__APPLICATION_LAYER_PROTOCOL:
			setApplicationLayerProtocol((String) newValue);
			return;
		case OsPackage.PORT__IP_ADDRESS_OR_HOSTNAME:
			setIpAddressOrHostname((String) newValue);
			return;
		case OsPackage.PORT__PORT:
			setPort((BigInteger) newValue);
			return;
		case OsPackage.PORT__PORT_NAME:
			setPortName((String) newValue);
			return;
		case OsPackage.PORT__TRANSPORT_LAYER_PROTOCOL:
			setTransportLayerProtocol((TransportLayerProtocolType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.PORT__APPLICATION_LAYER_PROTOCOL:
			setApplicationLayerProtocol(APPLICATION_LAYER_PROTOCOL_EDEFAULT);
			return;
		case OsPackage.PORT__IP_ADDRESS_OR_HOSTNAME:
			setIpAddressOrHostname(IP_ADDRESS_OR_HOSTNAME_EDEFAULT);
			return;
		case OsPackage.PORT__PORT:
			setPort(PORT_EDEFAULT);
			return;
		case OsPackage.PORT__PORT_NAME:
			setPortName(PORT_NAME_EDEFAULT);
			return;
		case OsPackage.PORT__TRANSPORT_LAYER_PROTOCOL:
			unsetTransportLayerProtocol();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.PORT__APPLICATION_LAYER_PROTOCOL:
			return APPLICATION_LAYER_PROTOCOL_EDEFAULT == null ? applicationLayerProtocol != null
					: !APPLICATION_LAYER_PROTOCOL_EDEFAULT.equals(applicationLayerProtocol);
		case OsPackage.PORT__IP_ADDRESS_OR_HOSTNAME:
			return IP_ADDRESS_OR_HOSTNAME_EDEFAULT == null ? ipAddressOrHostname != null
					: !IP_ADDRESS_OR_HOSTNAME_EDEFAULT.equals(ipAddressOrHostname);
		case OsPackage.PORT__PORT:
			return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
		case OsPackage.PORT__PORT_NAME:
			return PORT_NAME_EDEFAULT == null ? portName != null : !PORT_NAME_EDEFAULT
					.equals(portName);
		case OsPackage.PORT__TRANSPORT_LAYER_PROTOCOL:
			return isSetTransportLayerProtocol();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (applicationLayerProtocol: "); //$NON-NLS-1$
		result.append(applicationLayerProtocol);
		result.append(", ipAddressOrHostname: "); //$NON-NLS-1$
		result.append(ipAddressOrHostname);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(", portName: "); //$NON-NLS-1$
		result.append(portName);
		result.append(", transportLayerProtocol: "); //$NON-NLS-1$
		if (transportLayerProtocolESet)
			result.append(transportLayerProtocol);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //PortImpl
