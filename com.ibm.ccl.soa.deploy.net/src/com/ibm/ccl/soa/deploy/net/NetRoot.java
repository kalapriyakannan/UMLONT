/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetRoot.java,v 1.2 2008/02/01 20:40:01 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityIpInterface <em>Capability Ip Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityL2Interface <em>Capability L2 Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getUnitIpInterfaceUnit <em>Unit Ip Interface Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.NetRoot#getUnitL2InterfaceUnit <em>Unit L2 Interface Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface NetRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Ip Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Ip Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Ip Interface</em>' containment reference.
	 * @see #setCapabilityIpInterface(IpInterface)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_CapabilityIpInterface()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.ipInterface' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	IpInterface getCapabilityIpInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityIpInterface <em>Capability Ip Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Ip Interface</em>' containment reference.
	 * @see #getCapabilityIpInterface()
	 * @generated
	 */
	void setCapabilityIpInterface(IpInterface value);

	/**
	 * Returns the value of the '<em><b>Capability L2 Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability L2 Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability L2 Interface</em>' containment reference.
	 * @see #setCapabilityL2Interface(L2Interface)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_CapabilityL2Interface()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.l2Interface' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	L2Interface getCapabilityL2Interface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getCapabilityL2Interface <em>Capability L2 Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability L2 Interface</em>' containment reference.
	 * @see #getCapabilityL2Interface()
	 * @generated
	 */
	void setCapabilityL2Interface(L2Interface value);

	/**
	 * Returns the value of the '<em><b>Unit Ip Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Ip Interface Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Ip Interface Unit</em>' containment reference.
	 * @see #setUnitIpInterfaceUnit(IpInterfaceUnit)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_UnitIpInterfaceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ipInterfaceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	IpInterfaceUnit getUnitIpInterfaceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getUnitIpInterfaceUnit <em>Unit Ip Interface Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Ip Interface Unit</em>' containment reference.
	 * @see #getUnitIpInterfaceUnit()
	 * @generated
	 */
	void setUnitIpInterfaceUnit(IpInterfaceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit L2 Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit L2 Interface Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit L2 Interface Unit</em>' containment reference.
	 * @see #setUnitL2InterfaceUnit(L2InterfaceUnit)
	 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getNetRoot_UnitL2InterfaceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.l2InterfaceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	L2InterfaceUnit getUnitL2InterfaceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.net.NetRoot#getUnitL2InterfaceUnit <em>Unit L2 Interface Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit L2 Interface Unit</em>' containment reference.
	 * @see #getUnitL2InterfaceUnit()
	 * @generated
	 */
	void setUnitL2InterfaceUnit(L2InterfaceUnit value);

} // NetRoot
