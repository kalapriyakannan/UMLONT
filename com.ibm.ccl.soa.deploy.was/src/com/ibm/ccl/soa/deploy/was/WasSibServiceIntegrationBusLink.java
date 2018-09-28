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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sib Service Integration Bus Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getBootTrapEndpoints <em>Boot Trap Endpoints</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getForeignBusName <em>Foreign Bus Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getLinkName <em>Link Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getRemoteMessagingEngineName <em>Remote Messaging Engine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibServiceIntegrationBusLink()
 * @model extendedMetaData="name='WasSibServiceIntegrationBusLink' kind='elementOnly'"
 * @generated
 */
public interface WasSibServiceIntegrationBusLink extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Boot Trap Endpoints</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boot Trap Endpoints</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Boot Trap Endpoints</em>' attribute.
	 * @see #setBootTrapEndpoints(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibServiceIntegrationBusLink_BootTrapEndpoints()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='bootTrapEndpoints'"
	 * @generated
	 */
	String getBootTrapEndpoints();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getBootTrapEndpoints <em>Boot Trap Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boot Trap Endpoints</em>' attribute.
	 * @see #getBootTrapEndpoints()
	 * @generated
	 */
	void setBootTrapEndpoints(String value);

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
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibServiceIntegrationBusLink_ForeignBusName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='foreignBusName'"
	 * @generated
	 */
	String getForeignBusName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getForeignBusName <em>Foreign Bus Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreign Bus Name</em>' attribute.
	 * @see #getForeignBusName()
	 * @generated
	 */
	void setForeignBusName(String value);

	/**
	 * Returns the value of the '<em><b>Link Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Name</em>' attribute.
	 * @see #setLinkName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibServiceIntegrationBusLink_LinkName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='linkName'"
	 * @generated
	 */
	String getLinkName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getLinkName <em>Link Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Name</em>' attribute.
	 * @see #getLinkName()
	 * @generated
	 */
	void setLinkName(String value);

	/**
	 * Returns the value of the '<em><b>Remote Messaging Engine Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Messaging Engine Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Remote Messaging Engine Name</em>' attribute.
	 * @see #setRemoteMessagingEngineName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibServiceIntegrationBusLink_RemoteMessagingEngineName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='remoteMessagingEngineName'"
	 * @generated
	 */
	String getRemoteMessagingEngineName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink#getRemoteMessagingEngineName <em>Remote Messaging Engine Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Messaging Engine Name</em>' attribute.
	 * @see #getRemoteMessagingEngineName()
	 * @generated
	 */
	void setRemoteMessagingEngineName(String value);

} // WasSibServiceIntegrationBusLink
