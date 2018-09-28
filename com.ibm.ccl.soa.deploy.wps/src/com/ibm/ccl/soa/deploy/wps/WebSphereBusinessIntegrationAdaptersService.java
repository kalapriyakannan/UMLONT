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
 * A representation of the model object '<em><b>Web Sphere Business Integration Adapters Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getInputQueueJNDIName <em>Input Queue JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getJNDIName <em>JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getOutputQueueJNDIName <em>Output Queue JNDI Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWebSphereBusinessIntegrationAdaptersService()
 * @model extendedMetaData="name='WebSphereBusinessIntegrationAdaptersService' kind='elementOnly'"
 * @generated
 */
public interface WebSphereBusinessIntegrationAdaptersService extends Capability {
	/**
	 * Returns the value of the '<em><b>Input Queue JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Queue JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Queue JNDI Name</em>' attribute.
	 * @see #setInputQueueJNDIName(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWebSphereBusinessIntegrationAdaptersService_InputQueueJNDIName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='InputQueueJNDIName'"
	 * @generated
	 */
	String getInputQueueJNDIName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getInputQueueJNDIName <em>Input Queue JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Queue JNDI Name</em>' attribute.
	 * @see #getInputQueueJNDIName()
	 * @generated
	 */
	void setInputQueueJNDIName(String value);

	/**
	 * Returns the value of the '<em><b>JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>JNDI Name</em>' attribute.
	 * @see #setJNDIName(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWebSphereBusinessIntegrationAdaptersService_JNDIName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='JNDIName'"
	 * @generated
	 */
	String getJNDIName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getJNDIName <em>JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>JNDI Name</em>' attribute.
	 * @see #getJNDIName()
	 * @generated
	 */
	void setJNDIName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWebSphereBusinessIntegrationAdaptersService_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Output Queue JNDI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Queue JNDI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Queue JNDI Name</em>' attribute.
	 * @see #setOutputQueueJNDIName(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWebSphereBusinessIntegrationAdaptersService_OutputQueueJNDIName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='OutputQueueJNDIName'"
	 * @generated
	 */
	String getOutputQueueJNDIName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getOutputQueueJNDIName <em>Output Queue JNDI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Queue JNDI Name</em>' attribute.
	 * @see #getOutputQueueJNDIName()
	 * @generated
	 */
	void setOutputQueueJNDIName(String value);

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getWebSphereBusinessIntegrationAdaptersService_Timeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Timeout'"
	 * @generated
	 */
	String getTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.WebSphereBusinessIntegrationAdaptersService#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(String value);

} // WebSphereBusinessIntegrationAdaptersService
