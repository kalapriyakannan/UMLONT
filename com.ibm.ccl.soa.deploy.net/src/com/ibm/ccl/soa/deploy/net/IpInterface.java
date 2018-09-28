/**
 * <copyright>
 * </copyright>
 *
 * $Id: IpInterface.java,v 1.4 2008/05/19 14:50:09 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ip Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getGateway <em>Gateway</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpV4Address <em>Ip V4 Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpV6Address <em>Ip V6 Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpv6NotationType <em>Ipv6 Notation Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getL2InterfaceName <em>L2 Interface Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getNetmask <em>Netmask</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.IpInterface#getSubnetAddress <em>Subnet Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface()
 * @model extendedMetaData="name='IpInterface' kind='elementOnly'"
 * @generated
 */
public interface IpInterface extends Capability {
	/**
	 * Returns the value of the '<em><b>Gateway</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway</em>' attribute.
	 * @see #setGateway(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_Gateway()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='gateway'"
	 * @generated
	 */
	String getGateway();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getGateway <em>Gateway</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway</em>' attribute.
	 * @see #getGateway()
	 * @generated
	 */
	void setGateway(String value);

	/**
	 * Returns the value of the '<em><b>Ip V4 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The IPv4 address string, in IPV4 Dot notation.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ip V4 Address</em>' attribute.
	 * @see #setIpV4Address(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_IpV4Address()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ipV4Address'"
	 * @generated
	 */
	String getIpV4Address();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpV4Address <em>Ip V4 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip V4 Address</em>' attribute.
	 * @see #getIpV4Address()
	 * @generated
	 */
	void setIpV4Address(String value);

	/**
	 * Returns the value of the '<em><b>Ip V6 Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The IPv6 address string, in IpV6 , in the format specified by the ipv6NotationType attribute, or IPv6 Colon Notation by default.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ip V6 Address</em>' attribute.
	 * @see #setIpV6Address(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_IpV6Address()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ipV6Address'"
	 * @generated
	 */
	String getIpV6Address();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpV6Address <em>Ip V6 Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip V6 Address</em>' attribute.
	 * @see #getIpV6Address()
	 * @generated
	 */
	void setIpV6Address(String value);

	/**
	 * Returns the value of the '<em><b>Ipv6 Notation Type</b></em>' attribute.
	 * The default value is <code>"IPv6ColonNotation"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Enumeration. "IPv6ColonNotation" or "IPv6ByteNotation"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ipv6 Notation Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
	 * @see #isSetIpv6NotationType()
	 * @see #unsetIpv6NotationType()
	 * @see #setIpv6NotationType(IPv6AddressNotationType)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_Ipv6NotationType()
	 * @model default="IPv6ColonNotation" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='ipv6NotationType'"
	 * @generated
	 */
	IPv6AddressNotationType getIpv6NotationType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpv6NotationType <em>Ipv6 Notation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ipv6 Notation Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.net.IPv6AddressNotationType
	 * @see #isSetIpv6NotationType()
	 * @see #unsetIpv6NotationType()
	 * @see #getIpv6NotationType()
	 * @generated
	 */
	void setIpv6NotationType(IPv6AddressNotationType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpv6NotationType <em>Ipv6 Notation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIpv6NotationType()
	 * @see #getIpv6NotationType()
	 * @see #setIpv6NotationType(IPv6AddressNotationType)
	 * @generated
	 */
	void unsetIpv6NotationType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getIpv6NotationType <em>Ipv6 Notation Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Ipv6 Notation Type</em>' attribute is set.
	 * @see #unsetIpv6NotationType()
	 * @see #getIpv6NotationType()
	 * @see #setIpv6NotationType(IPv6AddressNotationType)
	 * @generated
	 */
	boolean isSetIpv6NotationType();

	/**
	 * Returns the value of the '<em><b>L2 Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Name of the associated L2 interface. This can vary depending on the Operating System and how
	 * 							the data is collected. SNMP - This field corresponds to the ifName Windows - This attribute
	 * 							corresponds to the "Name" column on the Network Connections panel. The "Device Name" column
	 * 							should not be used since a Computer System may have more than one adapter with the same
	 * 							Device Name. The "Name" column is globally unique. For Unix based systems this atttribute
	 * 							corresponds to the ifConfig value. It should be something like en0.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2 Interface Name</em>' attribute.
	 * @see #setL2InterfaceName(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_L2InterfaceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='l2InterfaceName'"
	 * @generated
	 */
	String getL2InterfaceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getL2InterfaceName <em>L2 Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2 Interface Name</em>' attribute.
	 * @see #getL2InterfaceName()
	 * @generated
	 */
	void setL2InterfaceName(String value);

	/**
	 * Returns the value of the '<em><b>Netmask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The netmask, for example 255.255.255.0, or similar for IPv6
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Netmask</em>' attribute.
	 * @see #setNetmask(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_Netmask()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='netmask'"
	 * @generated
	 */
	String getNetmask();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getNetmask <em>Netmask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Netmask</em>' attribute.
	 * @see #getNetmask()
	 * @generated
	 */
	void setNetmask(String value);

	/**
	 * Returns the value of the '<em><b>Subnet Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The network part e.g. 10.2.3.0, or similar for IPv6
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subnet Address</em>' attribute.
	 * @see #setSubnetAddress(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterface_SubnetAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subnetAddress'"
	 * @generated
	 */
	String getSubnetAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.IpInterface#getSubnetAddress <em>Subnet Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subnet Address</em>' attribute.
	 * @see #getSubnetAddress()
	 * @generated
	 */
	void setSubnetAddress(String value);

} // IpInterface
