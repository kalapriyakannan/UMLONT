/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import com.ibm.ccl.soa.deploy.core.Service;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enterprise Bean Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getHomeInterface <em>Home Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getEjbName <em>Ejb Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getVicinity <em>Vicinity</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEnterpriseBeanService()
 * @model extendedMetaData="name='EnterpriseBeanService' kind='elementOnly'"
 * @generated
 */
public interface EnterpriseBeanService extends Service {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Home Interface</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Home Interface</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Home Interface</em>' containment reference.
	 * @see #setHomeInterface(JavaInterface)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEnterpriseBeanService_HomeInterface()
	 * @model containment="true" extendedMetaData="kind='element' name='homeInterface'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	JavaInterface getHomeInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getHomeInterface <em>Home Interface</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Home Interface</em>' containment reference.
	 * @see #getHomeInterface()
	 * @generated
	 */
	void setHomeInterface(JavaInterface value);

	/**
	 * Returns the value of the '<em><b>Ejb Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ejb Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ejb Name</em>' attribute.
	 * @see #setEjbName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEnterpriseBeanService_EjbName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ejbName'"
	 * @generated
	 */
	String getEjbName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getEjbName <em>Ejb Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ejb Name</em>' attribute.
	 * @see #getEjbName()
	 * @generated
	 */
	void setEjbName(String value);

	/**
	 * Returns the value of the '<em><b>Jndi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jndi Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jndi Name</em>' attribute.
	 * @see #setJndiName(String)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEnterpriseBeanService_JndiName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='jndiName'"
	 * @generated
	 */
	String getJndiName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getJndiName <em>Jndi Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jndi Name</em>' attribute.
	 * @see #getJndiName()
	 * @generated
	 */
	void setJndiName(String value);

	/**
	 * Returns the value of the '<em><b>Vicinity</b></em>' attribute.
	 * The default value is <code>"local"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.j2ee.Vicinity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vicinity</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vicinity</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
	 * @see #isSetVicinity()
	 * @see #unsetVicinity()
	 * @see #setVicinity(Vicinity)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEnterpriseBeanService_Vicinity()
	 * @model default="local" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='vicinity'"
	 * @generated
	 */
	Vicinity getVicinity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getVicinity <em>Vicinity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vicinity</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.j2ee.Vicinity
	 * @see #isSetVicinity()
	 * @see #unsetVicinity()
	 * @see #getVicinity()
	 * @generated
	 */
	void setVicinity(Vicinity value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getVicinity <em>Vicinity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetVicinity()
	 * @see #getVicinity()
	 * @see #setVicinity(Vicinity)
	 * @generated
	 */
	void unsetVicinity();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService#getVicinity <em>Vicinity</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Vicinity</em>' attribute is set.
	 * @see #unsetVicinity()
	 * @see #getVicinity()
	 * @see #setVicinity(Vicinity)
	 * @generated
	 */
	boolean isSetVicinity();

} // EnterpriseBeanService
