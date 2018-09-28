/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>V5 Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getAgedTimeout <em>Aged Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getDataSourceHelperClassName <em>Data Source Helper Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getJ2cAuthAlias <em>J2c Auth Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getPurgePolicy <em>Purge Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getReapTime <em>Reap Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getUnusedTimeout <em>Unused Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource()
 * @model extendedMetaData="name='WasV5Datasource' kind='elementOnly'"
 * @generated
 */
public interface WasV5Datasource extends WasDatasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Aged Timeout</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Aged Timeout</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							    Interval in seconds after which an unused aged connection is discarded by the connection pool maintenance thread.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aged Timeout</em>' attribute.
	 * @see #setAgedTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource_AgedTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='agedTimeout'"
	 * @generated
	 */
	String getAgedTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getAgedTimeout <em>Aged Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aged Timeout</em>' attribute.
	 * @see #getAgedTimeout()
	 * @generated
	 */
	void setAgedTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Data Source Helper Class Name</b></em>' attribute.
	 * The default value is <code>"com.ibm.websphere.rsadapter.DB2UniversalDataStoreHelper"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source Helper Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Helper Class Name</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames
	 * @see #isSetDataSourceHelperClassName()
	 * @see #unsetDataSourceHelperClassName()
	 * @see #setDataSourceHelperClassName(DataSourceHelperClassNames)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource_DataSourceHelperClassName()
	 * @model default="com.ibm.websphere.rsadapter.DB2UniversalDataStoreHelper" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='dataSourceHelperClassName'"
	 * @generated
	 */
	DataSourceHelperClassNames getDataSourceHelperClassName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getDataSourceHelperClassName <em>Data Source Helper Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Helper Class Name</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames
	 * @see #isSetDataSourceHelperClassName()
	 * @see #unsetDataSourceHelperClassName()
	 * @see #getDataSourceHelperClassName()
	 * @generated
	 */
	void setDataSourceHelperClassName(DataSourceHelperClassNames value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getDataSourceHelperClassName <em>Data Source Helper Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDataSourceHelperClassName()
	 * @see #getDataSourceHelperClassName()
	 * @see #setDataSourceHelperClassName(DataSourceHelperClassNames)
	 * @generated
	 */
	void unsetDataSourceHelperClassName();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getDataSourceHelperClassName <em>Data Source Helper Class Name</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Source Helper Class Name</em>' attribute is set.
	 * @see #unsetDataSourceHelperClassName()
	 * @see #getDataSourceHelperClassName()
	 * @see #setDataSourceHelperClassName(DataSourceHelperClassNames)
	 * @generated
	 */
	boolean isSetDataSourceHelperClassName();

	/**
	 * Returns the value of the '<em><b>J2c Auth Alias</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>J2c Auth Alias</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>J2c Auth Alias</em>' attribute.
	 * @see #setJ2cAuthAlias(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource_J2cAuthAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='j2cAuthAlias'"
	 * @generated
	 */
	String getJ2cAuthAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getJ2cAuthAlias <em>J2c Auth Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>J2c Auth Alias</em>' attribute.
	 * @see #getJ2cAuthAlias()
	 * @generated
	 */
	void setJ2cAuthAlias(String value);

	/**
	 * Returns the value of the '<em><b>Purge Policy</b></em>' attribute.
	 * The default value is <code>"EntirePool"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.Policies}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purge Policy</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							    How to purge connections when a stale connection or fatal connection error is detected.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Purge Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.Policies
	 * @see #isSetPurgePolicy()
	 * @see #unsetPurgePolicy()
	 * @see #setPurgePolicy(Policies)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource_PurgePolicy()
	 * @model default="EntirePool" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='purgePolicy'"
	 * @generated
	 */
	Policies getPurgePolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getPurgePolicy <em>Purge Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purge Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.Policies
	 * @see #isSetPurgePolicy()
	 * @see #unsetPurgePolicy()
	 * @see #getPurgePolicy()
	 * @generated
	 */
	void setPurgePolicy(Policies value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getPurgePolicy <em>Purge Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPurgePolicy()
	 * @see #getPurgePolicy()
	 * @see #setPurgePolicy(Policies)
	 * @generated
	 */
	void unsetPurgePolicy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getPurgePolicy <em>Purge Policy</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Purge Policy</em>' attribute is set.
	 * @see #unsetPurgePolicy()
	 * @see #getPurgePolicy()
	 * @see #setPurgePolicy(Policies)
	 * @generated
	 */
	boolean isSetPurgePolicy();

	/**
	 * Returns the value of the '<em><b>Reap Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reap Time</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							    Interval in seconds between runs of the connection pool maintenance thread.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reap Time</em>' attribute.
	 * @see #setReapTime(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource_ReapTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='reapTime'"
	 * @generated
	 */
	String getReapTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getReapTime <em>Reap Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reap Time</em>' attribute.
	 * @see #getReapTime()
	 * @generated
	 */
	void setReapTime(String value);

	/**
	 * Returns the value of the '<em><b>Unused Timeout</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Unused Timeout</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							    Interval in seconds after which an unused connection is discarded by the connection pool maintenance thread.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unused Timeout</em>' attribute.
	 * @see #setUnusedTimeout(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5Datasource_UnusedTimeout()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='unusedTimeout'"
	 * @generated
	 */
	String getUnusedTimeout();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5Datasource#getUnusedTimeout <em>Unused Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unused Timeout</em>' attribute.
	 * @see #getUnusedTimeout()
	 * @generated
	 */
	void setUnusedTimeout(String value);

} // WasV5Datasource
