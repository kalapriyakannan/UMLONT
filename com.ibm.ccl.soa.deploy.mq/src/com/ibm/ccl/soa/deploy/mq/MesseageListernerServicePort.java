/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.mq;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Messeage Listerner Service Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getCFJNDIName <em>CFJNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getDestinationJNDIName <em>Destination JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxRetries <em>Max Retries</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxSessions <em>Max Sessions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMesseageListernerServicePort()
 * @model extendedMetaData="name='MesseageListernerServicePort' kind='elementOnly'"
 * @generated
 */
public interface MesseageListernerServicePort extends Capability {
	/**
	 * Returns the value of the '<em><b>CFJNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CFJNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CFJNDI Name</em>' attribute.
	 * @see #setCFJNDIName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMesseageListernerServicePort_CFJNDIName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CFJNDIName'"
	 * @generated
	 */
	String getCFJNDIName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getCFJNDIName <em>CFJNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CFJNDI Name</em>' attribute.
	 * @see #getCFJNDIName()
	 * @generated
	 */
	void setCFJNDIName(String value);

	/**
	 * Returns the value of the '<em><b>Destination JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination JNDI Name</em>' attribute.
	 * @see #setDestinationJNDIName(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMesseageListernerServicePort_DestinationJNDIName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DestinationJNDIName'"
	 * @generated
	 */
	String getDestinationJNDIName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getDestinationJNDIName <em>Destination JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination JNDI Name</em>' attribute.
	 * @see #getDestinationJNDIName()
	 * @generated
	 */
	void setDestinationJNDIName(String value);

	/**
	 * Returns the value of the '<em><b>Max Retries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Retries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Retries</em>' attribute.
	 * @see #setMaxRetries(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMesseageListernerServicePort_MaxRetries()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxRetries'"
	 * @generated
	 */
	String getMaxRetries();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxRetries <em>Max Retries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Retries</em>' attribute.
	 * @see #getMaxRetries()
	 * @generated
	 */
	void setMaxRetries(String value);

	/**
	 * Returns the value of the '<em><b>Max Sessions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Sessions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Sessions</em>' attribute.
	 * @see #setMaxSessions(String)
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMesseageListernerServicePort_MaxSessions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxSessions'"
	 * @generated
	 */
	String getMaxSessions();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getMaxSessions <em>Max Sessions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Sessions</em>' attribute.
	 * @see #getMaxSessions()
	 * @generated
	 */
	void setMaxSessions(String value);

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
	 * @see com.ibm.ccl.soa.deploy.mq.MqPackage#getMesseageListernerServicePort_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.mq.MesseageListernerServicePort#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

} // MesseageListernerServicePort
