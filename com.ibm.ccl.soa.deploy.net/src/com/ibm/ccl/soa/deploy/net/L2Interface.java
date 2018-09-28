/**
 * <copyright>
 * </copyright>
 *
 * $Id: L2Interface.java,v 1.1 2008/02/01 18:53:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>L2 Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#isAutoNegotiation <em>Auto Negotiation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#isBroadcast <em>Broadcast</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getDuplex <em>Duplex</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getEncapsulation <em>Encapsulation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getHwAddress <em>Hw Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getIndex <em>Index</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getL2InterfaceName <em>L2 Interface Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#isLoopback <em>Loopback</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getMtu <em>Mtu</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPromiscuous <em>Promiscuous</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.L2Interface#getSpeed <em>Speed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface()
 * @model extendedMetaData="name='L2Interface' kind='elementOnly'"
 * @generated
 */
public interface L2Interface extends Capability {
	/**
	 * Returns the value of the '<em><b>Auto Negotiation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 802.3 autonegotation setting for ethernet interfaces.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Auto Negotiation</em>' attribute.
	 * @see #isSetAutoNegotiation()
	 * @see #unsetAutoNegotiation()
	 * @see #setAutoNegotiation(boolean)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_AutoNegotiation()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoNegotiation'"
	 * @generated
	 */
	boolean isAutoNegotiation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isAutoNegotiation <em>Auto Negotiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Negotiation</em>' attribute.
	 * @see #isSetAutoNegotiation()
	 * @see #unsetAutoNegotiation()
	 * @see #isAutoNegotiation()
	 * @generated
	 */
	void setAutoNegotiation(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isAutoNegotiation <em>Auto Negotiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAutoNegotiation()
	 * @see #isAutoNegotiation()
	 * @see #setAutoNegotiation(boolean)
	 * @generated
	 */
	void unsetAutoNegotiation();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isAutoNegotiation <em>Auto Negotiation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Negotiation</em>' attribute is set.
	 * @see #unsetAutoNegotiation()
	 * @see #isAutoNegotiation()
	 * @see #setAutoNegotiation(boolean)
	 * @generated
	 */
	boolean isSetAutoNegotiation();

	/**
	 * Returns the value of the '<em><b>Broadcast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Is the interface capable of broadcasting frames or not?
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Broadcast</em>' attribute.
	 * @see #isSetBroadcast()
	 * @see #unsetBroadcast()
	 * @see #setBroadcast(boolean)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Broadcast()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='broadcast'"
	 * @generated
	 */
	boolean isBroadcast();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isBroadcast <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Broadcast</em>' attribute.
	 * @see #isSetBroadcast()
	 * @see #unsetBroadcast()
	 * @see #isBroadcast()
	 * @generated
	 */
	void setBroadcast(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isBroadcast <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBroadcast()
	 * @see #isBroadcast()
	 * @see #setBroadcast(boolean)
	 * @generated
	 */
	void unsetBroadcast();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isBroadcast <em>Broadcast</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Broadcast</em>' attribute is set.
	 * @see #unsetBroadcast()
	 * @see #isBroadcast()
	 * @see #setBroadcast(boolean)
	 * @generated
	 */
	boolean isSetBroadcast();

	/**
	 * Returns the value of the '<em><b>Duplex</b></em>' attribute.
	 * The default value is <code>"HalfDuplex"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.net.DuplexType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enumeration - HalfDuplex, FullDuplex
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Duplex</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.net.DuplexType
	 * @see #isSetDuplex()
	 * @see #unsetDuplex()
	 * @see #setDuplex(DuplexType)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Duplex()
	 * @model default="HalfDuplex" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='duplex'"
	 * @generated
	 */
	DuplexType getDuplex();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getDuplex <em>Duplex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duplex</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.net.DuplexType
	 * @see #isSetDuplex()
	 * @see #unsetDuplex()
	 * @see #getDuplex()
	 * @generated
	 */
	void setDuplex(DuplexType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getDuplex <em>Duplex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuplex()
	 * @see #getDuplex()
	 * @see #setDuplex(DuplexType)
	 * @generated
	 */
	void unsetDuplex();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getDuplex <em>Duplex</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duplex</em>' attribute is set.
	 * @see #unsetDuplex()
	 * @see #getDuplex()
	 * @see #setDuplex(DuplexType)
	 * @generated
	 */
	boolean isSetDuplex();

	/**
	 * Returns the value of the '<em><b>Encapsulation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Interface encapsulation (e.g. ethernet, loopback etc...)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Encapsulation</em>' attribute.
	 * @see #setEncapsulation(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Encapsulation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='encapsulation'"
	 * @generated
	 */
	String getEncapsulation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getEncapsulation <em>Encapsulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encapsulation</em>' attribute.
	 * @see #getEncapsulation()
	 * @generated
	 */
	void setEncapsulation(String value);

	/**
	 * Returns the value of the '<em><b>Hw Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Hardware address e.g. MAC address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hw Address</em>' attribute.
	 * @see #setHwAddress(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_HwAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hwAddress'"
	 * @generated
	 */
	String getHwAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getHwAddress <em>Hw Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hw Address</em>' attribute.
	 * @see #getHwAddress()
	 * @generated
	 */
	void setHwAddress(String value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #setIndex(int)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Index()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='index'"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #isSetIndex()
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
	void unsetIndex();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getIndex <em>Index</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Index</em>' attribute is set.
	 * @see #unsetIndex()
	 * @see #getIndex()
	 * @see #setIndex(int)
	 * @generated
	 */
	boolean isSetIndex();

	/**
	 * Returns the value of the '<em><b>L2 Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Name of the interface. This can vary depending on the Operating System and how the data is
	 * 							collected. SNMP - This field corresponds to the ifName Windows - This attribute corresponds
	 * 							to the "Name" column on the Network Connections panel. The "Device Name" column should not
	 * 							be used since a Computer System may have more than one adapter with the same Device Name.
	 * 							The "Name" column is globally unique. For Unix based systems this atttribute corresponds to
	 * 							the ifConfig value. It should be something like en0.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2 Interface Name</em>' attribute.
	 * @see #setL2InterfaceName(String)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_L2InterfaceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='l2InterfaceName'"
	 * @generated
	 */
	String getL2InterfaceName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getL2InterfaceName <em>L2 Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2 Interface Name</em>' attribute.
	 * @see #getL2InterfaceName()
	 * @generated
	 */
	void setL2InterfaceName(String value);

	/**
	 * Returns the value of the '<em><b>Loopback</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Is this a loopback interface?
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Loopback</em>' attribute.
	 * @see #isSetLoopback()
	 * @see #unsetLoopback()
	 * @see #setLoopback(boolean)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Loopback()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='loopback'"
	 * @generated
	 */
	boolean isLoopback();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isLoopback <em>Loopback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loopback</em>' attribute.
	 * @see #isSetLoopback()
	 * @see #unsetLoopback()
	 * @see #isLoopback()
	 * @generated
	 */
	void setLoopback(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isLoopback <em>Loopback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLoopback()
	 * @see #isLoopback()
	 * @see #setLoopback(boolean)
	 * @generated
	 */
	void unsetLoopback();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isLoopback <em>Loopback</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Loopback</em>' attribute is set.
	 * @see #unsetLoopback()
	 * @see #isLoopback()
	 * @see #setLoopback(boolean)
	 * @generated
	 */
	boolean isSetLoopback();

	/**
	 * Returns the value of the '<em><b>Mtu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The Maximum Transmission Unit (aka) frame size that the interface supports
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mtu</em>' attribute.
	 * @see #isSetMtu()
	 * @see #unsetMtu()
	 * @see #setMtu(int)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Mtu()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='mtu'"
	 * @generated
	 */
	int getMtu();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getMtu <em>Mtu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mtu</em>' attribute.
	 * @see #isSetMtu()
	 * @see #unsetMtu()
	 * @see #getMtu()
	 * @generated
	 */
	void setMtu(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getMtu <em>Mtu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMtu()
	 * @see #getMtu()
	 * @see #setMtu(int)
	 * @generated
	 */
	void unsetMtu();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getMtu <em>Mtu</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mtu</em>' attribute is set.
	 * @see #unsetMtu()
	 * @see #getMtu()
	 * @see #setMtu(int)
	 * @generated
	 */
	boolean isSetMtu();

	/**
	 * Returns the value of the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Is this a private interface? Private interfaces can send data but are never exported into
	 * 							routing tables.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Private</em>' attribute.
	 * @see #isSetPrivate()
	 * @see #unsetPrivate()
	 * @see #setPrivate(boolean)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Private()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='private'"
	 * @generated
	 */
	boolean isPrivate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private</em>' attribute.
	 * @see #isSetPrivate()
	 * @see #unsetPrivate()
	 * @see #isPrivate()
	 * @generated
	 */
	void setPrivate(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPrivate()
	 * @see #isPrivate()
	 * @see #setPrivate(boolean)
	 * @generated
	 */
	void unsetPrivate();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPrivate <em>Private</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Private</em>' attribute is set.
	 * @see #unsetPrivate()
	 * @see #isPrivate()
	 * @see #setPrivate(boolean)
	 * @generated
	 */
	boolean isSetPrivate();

	/**
	 * Returns the value of the '<em><b>Promiscuous</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Is the interface in promiscuous mode?
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Promiscuous</em>' attribute.
	 * @see #isSetPromiscuous()
	 * @see #unsetPromiscuous()
	 * @see #setPromiscuous(boolean)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Promiscuous()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='promiscuous'"
	 * @generated
	 */
	boolean isPromiscuous();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPromiscuous <em>Promiscuous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Promiscuous</em>' attribute.
	 * @see #isSetPromiscuous()
	 * @see #unsetPromiscuous()
	 * @see #isPromiscuous()
	 * @generated
	 */
	void setPromiscuous(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPromiscuous <em>Promiscuous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPromiscuous()
	 * @see #isPromiscuous()
	 * @see #setPromiscuous(boolean)
	 * @generated
	 */
	void unsetPromiscuous();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#isPromiscuous <em>Promiscuous</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Promiscuous</em>' attribute is set.
	 * @see #unsetPromiscuous()
	 * @see #isPromiscuous()
	 * @see #setPromiscuous(boolean)
	 * @generated
	 */
	boolean isSetPromiscuous();

	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Speed the interface is running on in bits/s.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #isSetSpeed()
	 * @see #unsetSpeed()
	 * @see #setSpeed(long)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getL2Interface_Speed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='speed'"
	 * @generated
	 */
	long getSpeed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #isSetSpeed()
	 * @see #unsetSpeed()
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSpeed()
	 * @see #getSpeed()
	 * @see #setSpeed(long)
	 * @generated
	 */
	void unsetSpeed();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.net.L2Interface#getSpeed <em>Speed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Speed</em>' attribute is set.
	 * @see #unsetSpeed()
	 * @see #getSpeed()
	 * @see #setSpeed(long)
	 * @generated
	 */
	boolean isSetSpeed();

} // L2Interface
