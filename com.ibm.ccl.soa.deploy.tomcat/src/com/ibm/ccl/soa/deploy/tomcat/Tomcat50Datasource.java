/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat;

import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tomcat50 Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getClientJarLocation <em>Client Jar Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getDriverClassName <em>Driver Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getFactory <em>Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcat50Datasource()
 * @model extendedMetaData="name='Tomcat50Datasource' kind='elementOnly'"
 * @generated
 */
public interface Tomcat50Datasource extends J2EEDatasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Client Jar Location</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Jar Location</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Client Jar Location</em>' attribute.
	 * @see #setClientJarLocation(String)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcat50Datasource_ClientJarLocation()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='clientJarLocation'"
	 * @generated
	 */
	String getClientJarLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getClientJarLocation <em>Client Jar Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Jar Location</em>' attribute.
	 * @see #getClientJarLocation()
	 * @generated
	 */
	void setClientJarLocation(String value);

	/**
	 * Returns the value of the '<em><b>Driver Class Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver Class Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Driver Class Name</em>' attribute.
	 * @see #setDriverClassName(String)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcat50Datasource_DriverClassName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='driverClassName'"
	 * @generated
	 */
	String getDriverClassName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getDriverClassName <em>Driver Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Class Name</em>' attribute.
	 * @see #getDriverClassName()
	 * @generated
	 */
	void setDriverClassName(String value);

	/**
	 * Returns the value of the '<em><b>Factory</b></em>' attribute.
	 * The default value is <code>"org.apache.commons.dbcp.BasicDataSourceFactory"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory</em>' attribute.
	 * @see #isSetFactory()
	 * @see #unsetFactory()
	 * @see #setFactory(String)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcat50Datasource_Factory()
	 * @model default="org.apache.commons.dbcp.BasicDataSourceFactory" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='factory'"
	 * @generated
	 */
	String getFactory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getFactory <em>Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #isSetFactory()
	 * @see #unsetFactory()
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(String value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getFactory <em>Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetFactory()
	 * @see #getFactory()
	 * @see #setFactory(String)
	 * @generated
	 */
	void unsetFactory();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getFactory <em>Factory</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Factory</em>' attribute is set.
	 * @see #unsetFactory()
	 * @see #getFactory()
	 * @see #setFactory(String)
	 * @generated
	 */
	boolean isSetFactory();

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see com.ibm.ccl.soa.deploy.tomcat.TomcatPackage#getTomcat50Datasource_Url()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='url'"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

} // Tomcat50Datasource
