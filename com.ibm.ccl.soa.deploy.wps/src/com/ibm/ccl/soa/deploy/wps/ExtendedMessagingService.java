/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Messaging Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getInputPort <em>Input Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getOutputPort <em>Output Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getExtendedMessagingService()
 * @model extendedMetaData="name='ExtendedMessagingService' kind='elementOnly'"
 * @generated
 */
public interface ExtendedMessagingService extends Capability {
	/**
	 * Returns the value of the '<em><b>Input Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Port</em>' attribute.
	 * @see #setInputPort(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getExtendedMessagingService_InputPort()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InputPort'"
	 * @generated
	 */
	String getInputPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getInputPort <em>Input Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Port</em>' attribute.
	 * @see #getInputPort()
	 * @generated
	 */
	void setInputPort(String value);

	/**
	 * Returns the value of the '<em><b>Output Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Port</em>' attribute.
	 * @see #setOutputPort(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getExtendedMessagingService_OutputPort()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='OutputPort'"
	 * @generated
	 */
	String getOutputPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.ExtendedMessagingService#getOutputPort <em>Output Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Port</em>' attribute.
	 * @see #getOutputPort()
	 * @generated
	 */
	void setOutputPort(String value);

} // ExtendedMessagingService
