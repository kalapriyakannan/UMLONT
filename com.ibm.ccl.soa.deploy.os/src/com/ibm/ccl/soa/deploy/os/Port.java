/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Port</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.Port#getApplicationLayerProtocol <em>Application Layer Protocol</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.Port#getIpAddressOrHostname <em>Ip Address Or Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.Port#getPort <em>Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.Port#getPortName <em>Port Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.Port#getTransportLayerProtocol <em>Transport Layer Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getPort()
 * @model extendedMetaData="name='Port' kind='elementOnly'"
 * @generated
 */
public interface Port extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Application Layer Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Layer Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Layer Protocol</em>' attribute.
	 * @see #setApplicationLayerProtocol(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getPort_ApplicationLayerProtocol()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='applicationLayerProtocol'"
	 * @generated
	 */
	String getApplicationLayerProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getApplicationLayerProtocol <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Layer Protocol</em>' attribute.
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 */
	void setApplicationLayerProtocol(String value);

	/**
	 * Returns the value of the '<em><b>Ip Address Or Hostname</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip Address Or Hostname</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ip Address Or Hostname</em>' attribute.
	 * @see #setIpAddressOrHostname(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getPort_IpAddressOrHostname()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ipAddressOrHostname'"
	 * @generated
	 */
	String getIpAddressOrHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getIpAddressOrHostname <em>Ip Address Or Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip Address Or Hostname</em>' attribute.
	 * @see #getIpAddressOrHostname()
	 * @generated
	 */
	void setIpAddressOrHostname(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getPort_Port()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.PortType" required="true"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	BigInteger getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Name</em>' attribute.
	 * @see #setPortName(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getPort_PortName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='portName'"
	 * @generated
	 */
	String getPortName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getPortName <em>Port Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Name</em>' attribute.
	 * @see #getPortName()
	 * @generated
	 */
	void setPortName(String value);

	/**
	 * Returns the value of the '<em><b>Transport Layer Protocol</b></em>' attribute.
	 * The default value is <code>"TCP"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transport Layer Protocol</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transport Layer Protocol</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
	 * @see #isSetTransportLayerProtocol()
	 * @see #unsetTransportLayerProtocol()
	 * @see #setTransportLayerProtocol(TransportLayerProtocolType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getPort_TransportLayerProtocol()
	 * @model default="TCP" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='transportLayerProtocol'"
	 * @generated
	 */
	TransportLayerProtocolType getTransportLayerProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getTransportLayerProtocol <em>Transport Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transport Layer Protocol</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
	 * @see #isSetTransportLayerProtocol()
	 * @see #unsetTransportLayerProtocol()
	 * @see #getTransportLayerProtocol()
	 * @generated
	 */
	void setTransportLayerProtocol(TransportLayerProtocolType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getTransportLayerProtocol <em>Transport Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTransportLayerProtocol()
	 * @see #getTransportLayerProtocol()
	 * @see #setTransportLayerProtocol(TransportLayerProtocolType)
	 * @generated
	 */
	void unsetTransportLayerProtocol();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.Port#getTransportLayerProtocol <em>Transport Layer Protocol</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transport Layer Protocol</em>' attribute is set.
	 * @see #unsetTransportLayerProtocol()
	 * @see #getTransportLayerProtocol()
	 * @see #setTransportLayerProtocol(TransportLayerProtocolType)
	 * @generated
	 */
	boolean isSetTransportLayerProtocol();

} // Port
