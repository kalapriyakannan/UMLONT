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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>SI Bus</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getBusName <em>Bus Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isConfigurationReload <em>Configuration Reload</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isDiscardMessages <em>Discard Messages</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getHighMessageThreshold <em>High Message Threshold</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getInterEngineTransportChain <em>Inter Engine Transport Chain</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSIBus()
 * @model extendedMetaData="name='WasSIBus' kind='elementOnly'"
 * @generated
 */
public interface WasSIBus extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Bus Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bus Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus Name</em>' attribute.
	 * @see #setBusName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSIBus_BusName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='busName'"
	 * @generated
	 */
	String getBusName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getBusName <em>Bus Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Name</em>' attribute.
	 * @see #getBusName()
	 * @generated
	 */
	void setBusName(String value);

	/**
	 * Returns the value of the '<em><b>Configuration Reload</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Reload</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Configuration Reload</em>' attribute.
	 * @see #isSetConfigurationReload()
	 * @see #unsetConfigurationReload()
	 * @see #setConfigurationReload(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSIBus_ConfigurationReload()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='configurationReload'"
	 * @generated
	 */
	boolean isConfigurationReload();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isConfigurationReload <em>Configuration Reload</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Reload</em>' attribute.
	 * @see #isSetConfigurationReload()
	 * @see #unsetConfigurationReload()
	 * @see #isConfigurationReload()
	 * @generated
	 */
	void setConfigurationReload(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isConfigurationReload <em>Configuration Reload</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetConfigurationReload()
	 * @see #isConfigurationReload()
	 * @see #setConfigurationReload(boolean)
	 * @generated
	 */
	void unsetConfigurationReload();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isConfigurationReload <em>Configuration Reload</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Configuration Reload</em>' attribute is set.
	 * @see #unsetConfigurationReload()
	 * @see #isConfigurationReload()
	 * @see #setConfigurationReload(boolean)
	 * @generated
	 */
	boolean isSetConfigurationReload();

	/**
	 * Returns the value of the '<em><b>Discard Messages</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discard Messages</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Discard Messages</em>' attribute.
	 * @see #isSetDiscardMessages()
	 * @see #unsetDiscardMessages()
	 * @see #setDiscardMessages(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSIBus_DiscardMessages()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='DiscardMessages'"
	 * @generated
	 */
	boolean isDiscardMessages();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isDiscardMessages <em>Discard Messages</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discard Messages</em>' attribute.
	 * @see #isSetDiscardMessages()
	 * @see #unsetDiscardMessages()
	 * @see #isDiscardMessages()
	 * @generated
	 */
	void setDiscardMessages(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isDiscardMessages <em>Discard Messages</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDiscardMessages()
	 * @see #isDiscardMessages()
	 * @see #setDiscardMessages(boolean)
	 * @generated
	 */
	void unsetDiscardMessages();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#isDiscardMessages <em>Discard Messages</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Discard Messages</em>' attribute is set.
	 * @see #unsetDiscardMessages()
	 * @see #isDiscardMessages()
	 * @see #setDiscardMessages(boolean)
	 * @generated
	 */
	boolean isSetDiscardMessages();

	/**
	 * Returns the value of the '<em><b>High Message Threshold</b></em>' attribute.
	 * The default value is <code>"50000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>High Message Threshold</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>High Message Threshold</em>' attribute.
	 * @see #isSetHighMessageThreshold()
	 * @see #unsetHighMessageThreshold()
	 * @see #setHighMessageThreshold(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSIBus_HighMessageThreshold()
	 * @model default="50000" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='highMessageThreshold'"
	 * @generated
	 */
	int getHighMessageThreshold();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getHighMessageThreshold <em>High Message Threshold</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Message Threshold</em>' attribute.
	 * @see #isSetHighMessageThreshold()
	 * @see #unsetHighMessageThreshold()
	 * @see #getHighMessageThreshold()
	 * @generated
	 */
	void setHighMessageThreshold(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getHighMessageThreshold <em>High Message Threshold</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetHighMessageThreshold()
	 * @see #getHighMessageThreshold()
	 * @see #setHighMessageThreshold(int)
	 * @generated
	 */
	void unsetHighMessageThreshold();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getHighMessageThreshold <em>High Message Threshold</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>High Message Threshold</em>' attribute is set.
	 * @see #unsetHighMessageThreshold()
	 * @see #getHighMessageThreshold()
	 * @see #setHighMessageThreshold(int)
	 * @generated
	 */
	boolean isSetHighMessageThreshold();

	/**
	 * Returns the value of the '<em><b>Inter Engine Transport Chain</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Engine Transport Chain</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Inter Engine Transport Chain</em>' attribute.
	 * @see #setInterEngineTransportChain(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSIBus_InterEngineTransportChain()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InterEngineTransportChain'"
	 * @generated
	 */
	String getInterEngineTransportChain();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSIBus#getInterEngineTransportChain <em>Inter Engine Transport Chain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Engine Transport Chain</em>' attribute.
	 * @see #getInterEngineTransportChain()
	 * @generated
	 */
	void setInterEngineTransportChain(String value);

} // WasSIBus
