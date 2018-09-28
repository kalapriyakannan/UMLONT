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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>V5DB2 Datasource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getCliSchema <em>Cli Schema</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getCurrentPackageSet <em>Current Package Set</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getCurrentSchema <em>Current Schema</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isDeferPrepares <em>Defer Prepares</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isFullyMaterializeLobData <em>Fully Materialize Lob Data</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getResultSetHoldability <em>Result Set Holdability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getTraceFile <em>Trace File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getTraceLevel <em>Trace Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isUseTemplate <em>Use Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource()
 * @model extendedMetaData="name='WasV5DB2Datasource' kind='elementOnly'"
 * @generated
 */
public interface WasV5DB2Datasource extends WasV5Datasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Cli Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cli Schema</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						    AKA sysSchema, the schema of the DB2 shadow catalog tables or views that are searched when an application invokes a DatabaseMetaData method.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cli Schema</em>' attribute.
	 * @see #setCliSchema(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_CliSchema()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cliSchema'"
	 * @generated
	 */
	String getCliSchema();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getCliSchema <em>Cli Schema</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cli Schema</em>' attribute.
	 * @see #getCliSchema()
	 * @generated
	 */
	void setCliSchema(String value);

	/**
	 * Returns the value of the '<em><b>Current Package Set</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Package Set</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Current Package Set</em>' attribute.
	 * @see #setCurrentPackageSet(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_CurrentPackageSet()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='currentPackageSet'"
	 * @generated
	 */
	String getCurrentPackageSet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getCurrentPackageSet <em>Current Package Set</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Package Set</em>' attribute.
	 * @see #getCurrentPackageSet()
	 * @generated
	 */
	void setCurrentPackageSet(String value);

	/**
	 * Returns the value of the '<em><b>Current Schema</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Current Schema</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						    The default schema name that is used to qualify unqualified database objects in dynamically prepared SQL statements.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Current Schema</em>' attribute.
	 * @see #setCurrentSchema(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_CurrentSchema()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='currentSchema'"
	 * @generated
	 */
	String getCurrentSchema();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getCurrentSchema <em>Current Schema</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Schema</em>' attribute.
	 * @see #getCurrentSchema()
	 * @generated
	 */
	void setCurrentSchema(String value);

	/**
	 * Returns the value of the '<em><b>Defer Prepares</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Defer Prepares</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						    Specifies whether to defer prepare operations until statement execution.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Defer Prepares</em>' attribute.
	 * @see #isSetDeferPrepares()
	 * @see #unsetDeferPrepares()
	 * @see #setDeferPrepares(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_DeferPrepares()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='deferPrepares'"
	 * @generated
	 */
	boolean isDeferPrepares();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isDeferPrepares <em>Defer Prepares</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defer Prepares</em>' attribute.
	 * @see #isSetDeferPrepares()
	 * @see #unsetDeferPrepares()
	 * @see #isDeferPrepares()
	 * @generated
	 */
	void setDeferPrepares(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isDeferPrepares <em>Defer Prepares</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDeferPrepares()
	 * @see #isDeferPrepares()
	 * @see #setDeferPrepares(boolean)
	 * @generated
	 */
	void unsetDeferPrepares();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isDeferPrepares <em>Defer Prepares</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Defer Prepares</em>' attribute is set.
	 * @see #unsetDeferPrepares()
	 * @see #isDeferPrepares()
	 * @see #setDeferPrepares(boolean)
	 * @generated
	 */
	boolean isSetDeferPrepares();

	/**
	 * Returns the value of the '<em><b>Fully Materialize Lob Data</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fully Materialize Lob Data</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fully Materialize Lob Data</em>' attribute.
	 * @see #isSetFullyMaterializeLobData()
	 * @see #unsetFullyMaterializeLobData()
	 * @see #setFullyMaterializeLobData(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_FullyMaterializeLobData()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='fullyMaterializeLobData'"
	 * @generated
	 */
	boolean isFullyMaterializeLobData();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isFullyMaterializeLobData <em>Fully Materialize Lob Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fully Materialize Lob Data</em>' attribute.
	 * @see #isSetFullyMaterializeLobData()
	 * @see #unsetFullyMaterializeLobData()
	 * @see #isFullyMaterializeLobData()
	 * @generated
	 */
	void setFullyMaterializeLobData(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isFullyMaterializeLobData <em>Fully Materialize Lob Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetFullyMaterializeLobData()
	 * @see #isFullyMaterializeLobData()
	 * @see #setFullyMaterializeLobData(boolean)
	 * @generated
	 */
	void unsetFullyMaterializeLobData();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isFullyMaterializeLobData <em>Fully Materialize Lob Data</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fully Materialize Lob Data</em>' attribute is set.
	 * @see #unsetFullyMaterializeLobData()
	 * @see #isFullyMaterializeLobData()
	 * @see #setFullyMaterializeLobData(boolean)
	 * @generated
	 */
	boolean isSetFullyMaterializeLobData();

	/**
	 * Returns the value of the '<em><b>Result Set Holdability</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Set Holdability</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Result Set Holdability</em>' attribute.
	 * @see #isSetResultSetHoldability()
	 * @see #unsetResultSetHoldability()
	 * @see #setResultSetHoldability(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_ResultSetHoldability()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='resultSetHoldability'"
	 * @generated
	 */
	int getResultSetHoldability();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getResultSetHoldability <em>Result Set Holdability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set Holdability</em>' attribute.
	 * @see #isSetResultSetHoldability()
	 * @see #unsetResultSetHoldability()
	 * @see #getResultSetHoldability()
	 * @generated
	 */
	void setResultSetHoldability(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getResultSetHoldability <em>Result Set Holdability</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetResultSetHoldability()
	 * @see #getResultSetHoldability()
	 * @see #setResultSetHoldability(int)
	 * @generated
	 */
	void unsetResultSetHoldability();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getResultSetHoldability <em>Result Set Holdability</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Result Set Holdability</em>' attribute is set.
	 * @see #unsetResultSetHoldability()
	 * @see #getResultSetHoldability()
	 * @see #setResultSetHoldability(int)
	 * @generated
	 */
	boolean isSetResultSetHoldability();

	/**
	 * Returns the value of the '<em><b>Trace File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace File</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						    the name of a file into which the IBM DB2 Driver for JDBC and SQLJ writes trace information.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Trace File</em>' attribute.
	 * @see #setTraceFile(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_TraceFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='traceFile'"
	 * @generated
	 */
	String getTraceFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getTraceFile <em>Trace File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace File</em>' attribute.
	 * @see #getTraceFile()
	 * @generated
	 */
	void setTraceFile(String value);

	/**
	 * Returns the value of the '<em><b>Trace Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Level</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						    bit flags, for example com.ibm.db2.jcc.DB2BaseDataSource.TRACE_ALL.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Trace Level</em>' attribute.
	 * @see #isSetTraceLevel()
	 * @see #unsetTraceLevel()
	 * @see #setTraceLevel(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_TraceLevel()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='traceLevel'"
	 * @generated
	 */
	int getTraceLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getTraceLevel <em>Trace Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Level</em>' attribute.
	 * @see #isSetTraceLevel()
	 * @see #unsetTraceLevel()
	 * @see #getTraceLevel()
	 * @generated
	 */
	void setTraceLevel(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getTraceLevel <em>Trace Level</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetTraceLevel()
	 * @see #getTraceLevel()
	 * @see #setTraceLevel(int)
	 * @generated
	 */
	void unsetTraceLevel();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#getTraceLevel <em>Trace Level</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Trace Level</em>' attribute is set.
	 * @see #unsetTraceLevel()
	 * @see #getTraceLevel()
	 * @see #setTraceLevel(int)
	 * @generated
	 */
	boolean isSetTraceLevel();

	/**
	 * Returns the value of the '<em><b>Use Template</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Use Template</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Template</em>' attribute.
	 * @see #isSetUseTemplate()
	 * @see #unsetUseTemplate()
	 * @see #setUseTemplate(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasV5DB2Datasource_UseTemplate()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='useTemplate'"
	 * @generated
	 */
	boolean isUseTemplate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isUseTemplate <em>Use Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Template</em>' attribute.
	 * @see #isSetUseTemplate()
	 * @see #unsetUseTemplate()
	 * @see #isUseTemplate()
	 * @generated
	 */
	void setUseTemplate(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isUseTemplate <em>Use Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUseTemplate()
	 * @see #isUseTemplate()
	 * @see #setUseTemplate(boolean)
	 * @generated
	 */
	void unsetUseTemplate();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasV5DB2Datasource#isUseTemplate <em>Use Template</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use Template</em>' attribute is set.
	 * @see #unsetUseTemplate()
	 * @see #isUseTemplate()
	 * @see #setUseTemplate(boolean)
	 * @generated
	 */
	boolean isSetUseTemplate();

} // WasV5DB2Datasource
