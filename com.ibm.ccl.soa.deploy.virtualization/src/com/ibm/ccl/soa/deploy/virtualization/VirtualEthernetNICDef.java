/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualEthernetNICDef.java,v 1.1 2008/04/04 02:57:18 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Ethernet NIC Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link EthernetNICDefUnits}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getMacAddress <em>Mac Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getVirtualConnectionType <em>Virtual Connection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualEthernetNICDef()
 * @model extendedMetaData="name='VirtualEthernetNICDef' kind='elementOnly'"
 * @generated
 */
public interface VirtualEthernetNICDef extends Capability {
	/**
	 * Returns the value of the '<em><b>Mac Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MAC address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mac Address</em>' attribute.
	 * @see #setMacAddress(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualEthernetNICDef_MacAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='macAddress'"
	 * @generated
	 */
	String getMacAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getMacAddress <em>Mac Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mac Address</em>' attribute.
	 * @see #getMacAddress()
	 * @generated
	 */
	void setMacAddress(String value);

	/**
	 * Returns the value of the '<em><b>Virtual Connection Type</b></em>' attribute.
	 * The default value is <code>"bridged"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enumeration: bridged (default), nat, host-only, custom
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Virtual Connection Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
	 * @see #isSetVirtualConnectionType()
	 * @see #unsetVirtualConnectionType()
	 * @see #setVirtualConnectionType(VirtualNetworkConnectionType)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualEthernetNICDef_VirtualConnectionType()
	 * @model default="bridged" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='virtualConnectionType'"
	 * @generated
	 */
	VirtualNetworkConnectionType getVirtualConnectionType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getVirtualConnectionType <em>Virtual Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual Connection Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualNetworkConnectionType
	 * @see #isSetVirtualConnectionType()
	 * @see #unsetVirtualConnectionType()
	 * @see #getVirtualConnectionType()
	 * @generated
	 */
	void setVirtualConnectionType(VirtualNetworkConnectionType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getVirtualConnectionType <em>Virtual Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVirtualConnectionType()
	 * @see #getVirtualConnectionType()
	 * @see #setVirtualConnectionType(VirtualNetworkConnectionType)
	 * @generated
	 */
	void unsetVirtualConnectionType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualEthernetNICDef#getVirtualConnectionType <em>Virtual Connection Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Virtual Connection Type</em>' attribute is set.
	 * @see #unsetVirtualConnectionType()
	 * @see #getVirtualConnectionType()
	 * @see #setVirtualConnectionType(VirtualNetworkConnectionType)
	 * @generated
	 */
	boolean isSetVirtualConnectionType();

} // VirtualEthernetNICDef
