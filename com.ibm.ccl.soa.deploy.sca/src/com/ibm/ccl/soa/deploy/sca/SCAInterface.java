/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCA Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getCallBackInterface <em>Call Back Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getConversational <em>Conversational</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getInterface <em>Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAInterface()
 * @model extendedMetaData="name='SCAInterface' kind='elementOnly'"
 * @generated
 */
public interface SCAInterface extends Capability {
	/**
	 * Returns the value of the '<em><b>Call Back Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Back Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Back Interface</em>' attribute.
	 * @see #setCallBackInterface(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAInterface_CallBackInterface()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CallBackInterface'"
	 * @generated
	 */
	String getCallBackInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getCallBackInterface <em>Call Back Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Back Interface</em>' attribute.
	 * @see #getCallBackInterface()
	 * @generated
	 */
	void setCallBackInterface(String value);

	/**
	 * Returns the value of the '<em><b>Conversational</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversational</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversational</em>' attribute.
	 * @see #setConversational(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAInterface_Conversational()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='conversational'"
	 * @generated
	 */
	String getConversational();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getConversational <em>Conversational</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conversational</em>' attribute.
	 * @see #getConversational()
	 * @generated
	 */
	void setConversational(String value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAInterface_Interface()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Interface'"
	 * @generated
	 */
	String getInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(String value);

	/**
	 * Returns the value of the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name1</em>' attribute.
	 * @see #setName1(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAInterface_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

} // SCAInterface
