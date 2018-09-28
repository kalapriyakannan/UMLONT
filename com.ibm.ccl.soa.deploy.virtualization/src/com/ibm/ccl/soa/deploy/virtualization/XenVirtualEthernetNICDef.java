/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualEthernetNICDef.java,v 1.2 2008/04/04 17:59:42 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xen Virtual Ethernet NIC Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link EthernetNICDefUnits}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef#getNetworkBridge <em>Network Bridge</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualEthernetNICDef()
 * @model extendedMetaData="name='XenVirtualEthernetNICDef' kind='elementOnly'"
 * @generated
 */
public interface XenVirtualEthernetNICDef extends VirtualEthernetNICDef {

	/**
	 * Returns the value of the '<em><b>Network Bridge</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The network bridge to be used for this device.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Network Bridge</em>' attribute.
	 * @see #setNetworkBridge(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualEthernetNICDef_NetworkBridge()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='networkBridge'"
	 * @generated
	 */
	String getNetworkBridge();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualEthernetNICDef#getNetworkBridge <em>Network Bridge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network Bridge</em>' attribute.
	 * @see #getNetworkBridge()
	 * @generated
	 */
	void setNetworkBridge(String value);
} // XenVirtualEthernetNICDef
