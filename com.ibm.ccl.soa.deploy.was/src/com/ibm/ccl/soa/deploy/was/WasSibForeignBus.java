/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sib Foreign Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getForeignBusName <em>Foreign Bus Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getInBoundUserID <em>In Bound User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getOutBoundUserID <em>Out Bound User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getRoutingDefinitionType <em>Routing Definition Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibForeignBus()
 * @model extendedMetaData="name='WasSibForeignBus' kind='elementOnly'"
 * @generated
 */
public interface WasSibForeignBus extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Foreign Bus Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Bus Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Foreign Bus Name</em>' attribute.
	 * @see #setForeignBusName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibForeignBus_ForeignBusName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='foreignBusName'"
	 * @generated
	 */
	String getForeignBusName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getForeignBusName <em>Foreign Bus Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreign Bus Name</em>' attribute.
	 * @see #getForeignBusName()
	 * @generated
	 */
	void setForeignBusName(String value);

	/**
	 * Returns the value of the '<em><b>In Bound User ID</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Bound User ID</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>In Bound User ID</em>' attribute.
	 * @see #setInBoundUserID(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibForeignBus_InBoundUserID()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='inBoundUserID'"
	 * @generated
	 */
	String getInBoundUserID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getInBoundUserID <em>In Bound User ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Bound User ID</em>' attribute.
	 * @see #getInBoundUserID()
	 * @generated
	 */
	void setInBoundUserID(String value);

	/**
	 * Returns the value of the '<em><b>Out Bound User ID</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Bound User ID</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Out Bound User ID</em>' attribute.
	 * @see #setOutBoundUserID(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibForeignBus_OutBoundUserID()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='outBoundUserID'"
	 * @generated
	 */
	String getOutBoundUserID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getOutBoundUserID <em>Out Bound User ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Bound User ID</em>' attribute.
	 * @see #getOutBoundUserID()
	 * @generated
	 */
	void setOutBoundUserID(String value);

	/**
	 * Returns the value of the '<em><b>Routing Definition Type</b></em>' attribute. The default
	 * value is <code>"Direct,Service Integration Bus link"</code>. The literals are from the
	 * enumeration {@link com.ibm.ccl.soa.deploy.was.WasRoutingDefinitionTypeEnum}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routing Definition Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Routing Definition Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasRoutingDefinitionTypeEnum
	 * @see #isSetRoutingDefinitionType()
	 * @see #unsetRoutingDefinitionType()
	 * @see #setRoutingDefinitionType(WasRoutingDefinitionTypeEnum)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibForeignBus_RoutingDefinitionType()
	 * @model default="Direct,Service Integration Bus link" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='routingDefinitionType'"
	 * @generated
	 */
	WasRoutingDefinitionTypeEnum getRoutingDefinitionType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getRoutingDefinitionType <em>Routing Definition Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Routing Definition Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WasRoutingDefinitionTypeEnum
	 * @see #isSetRoutingDefinitionType()
	 * @see #unsetRoutingDefinitionType()
	 * @see #getRoutingDefinitionType()
	 * @generated
	 */
	void setRoutingDefinitionType(WasRoutingDefinitionTypeEnum value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getRoutingDefinitionType <em>Routing Definition Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetRoutingDefinitionType()
	 * @see #getRoutingDefinitionType()
	 * @see #setRoutingDefinitionType(WasRoutingDefinitionTypeEnum)
	 * @generated
	 */
	void unsetRoutingDefinitionType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibForeignBus#getRoutingDefinitionType <em>Routing Definition Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Routing Definition Type</em>' attribute is set.
	 * @see #unsetRoutingDefinitionType()
	 * @see #getRoutingDefinitionType()
	 * @see #setRoutingDefinitionType(WasRoutingDefinitionTypeEnum)
	 * @generated
	 */
	boolean isSetRoutingDefinitionType();

} // WasSibForeignBus
