/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Representation of WebSphere's DataSource MBean
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getConnectionTimeout <em>Connection Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getMaxConnections <em>Max Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getMinConnections <em>Min Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getStatementCacheSize <em>Statement Cache Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDatasource()
 * @model extendedMetaData="name='WasDatasource' kind='elementOnly'"
 * @generated
 */
public interface WasDatasource extends J2EEDatasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							    Optional J2EEResourceFactory category, used as a grouping mechanism.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDatasource_Category()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='category'"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Connection Timeout</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Timeout</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Connection Timeout</em>' attribute.
	 * @see #setConnectionTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDatasource_ConnectionTimeout()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='connectionTimeout'"
	 * @generated
	 */
	String getConnectionTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getConnectionTimeout <em>Connection Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Timeout</em>' attribute.
	 * @see #getConnectionTimeout()
	 * @generated
	 */
	void setConnectionTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Max Connections</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Max Connections</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 								Maximum number of managed connections that can be created in this connection pool.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Connections</em>' attribute.
	 * @see #setMaxConnections(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDatasource_MaxConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='maxConnections'"
	 * @generated
	 */
	String getMaxConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getMaxConnections <em>Max Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Connections</em>' attribute.
	 * @see #getMaxConnections()
	 * @generated
	 */
	void setMaxConnections(String value);

	/**
	 * Returns the value of the '<em><b>Min Connections</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Min Connections</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							    Minimum number of managed connection that should be maintained for all cases except if agedTimeout is set.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Connections</em>' attribute.
	 * @see #setMinConnections(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDatasource_MinConnections()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='minConnections'"
	 * @generated
	 */
	String getMinConnections();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getMinConnections <em>Min Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Connections</em>' attribute.
	 * @see #getMinConnections()
	 * @generated
	 */
	void setMinConnections(String value);

	/**
	 * Returns the value of the '<em><b>Statement Cache Size</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement Cache Size</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Statement Cache Size</em>' attribute.
	 * @see #setStatementCacheSize(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasDatasource_StatementCacheSize()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='statementCacheSize'"
	 * @generated
	 */
	String getStatementCacheSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasDatasource#getStatementCacheSize <em>Statement Cache Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement Cache Size</em>' attribute.
	 * @see #getStatementCacheSize()
	 * @generated
	 */
	void setStatementCacheSize(String value);

} // WasDatasource
