/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.database.Database;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCatalogSp <em>Catalog Sp</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCodeSet <em>Code Set</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCreatePath <em>Create Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDb2Version <em>Db2 Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbAlias <em>Db Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbDrive <em>Db Drive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbName <em>Db Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDftExtentSize <em>Dft Extent Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getTempSp <em>Temp Sp</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getTerritory <em>Territory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getUserSp <em>User Sp</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database()
 * @model extendedMetaData="name='DB2Database' kind='elementOnly'"
 * @generated
 */
public interface DB2Database extends Database {
	/**
	 * Returns the value of the '<em><b>Catalog Sp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catalog Sp</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tablespace for catalog, e.g. "SYSCATSPACE"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Catalog Sp</em>' attribute.
	 * @see #setCatalogSp(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_CatalogSp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='catalogSp'"
	 * @generated
	 */
	String getCatalogSp();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCatalogSp <em>Catalog Sp</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catalog Sp</em>' attribute.
	 * @see #getCatalogSp()
	 * @generated
	 */
	void setCatalogSp(String value);

	/**
	 * Returns the value of the '<em><b>Code Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Set</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code Set</em>' attribute.
	 * @see #setCodeSet(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_CodeSet()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='codeSet'"
	 * @generated
	 */
	String getCodeSet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCodeSet <em>Code Set</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Set</em>' attribute.
	 * @see #getCodeSet()
	 * @generated
	 */
	void setCodeSet(String value);

	/**
	 * Returns the value of the '<em><b>Create Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Path</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Create Path</em>' attribute.
	 * @see #setCreatePath(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_CreatePath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='createPath'"
	 * @generated
	 */
	String getCreatePath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getCreatePath <em>Create Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Path</em>' attribute.
	 * @see #getCreatePath()
	 * @generated
	 */
	void setCreatePath(String value);

	/**
	 * Returns the value of the '<em><b>Db2 Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db2 Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The version of DB2. Must be a dotted numeric version string, up to 4 parts
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Db2 Version</em>' attribute.
	 * @see #setDb2Version(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_Db2Version()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='db2Version'"
	 * @generated
	 */
	String getDb2Version();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDb2Version <em>Db2 Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db2 Version</em>' attribute.
	 * @see #getDb2Version()
	 * @generated
	 */
	void setDb2Version(String value);

	/**
	 * Returns the value of the '<em><b>Db Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Alias</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Alias for the DB2 database if it has one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Db Alias</em>' attribute.
	 * @see #setDbAlias(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_DbAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbAlias'"
	 * @generated
	 */
	String getDbAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbAlias <em>Db Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Alias</em>' attribute.
	 * @see #getDbAlias()
	 * @generated
	 */
	void setDbAlias(String value);

	/**
	 * Returns the value of the '<em><b>Db Drive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Drive</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Db Drive</em>' attribute.
	 * @see #setDbDrive(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_DbDrive()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbDrive'"
	 * @generated
	 */
	String getDbDrive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbDrive <em>Db Drive</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Drive</em>' attribute.
	 * @see #getDbDrive()
	 * @generated
	 */
	void setDbDrive(String value);

	/**
	 * Returns the value of the '<em><b>Db Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The DB2 database name
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Db Name</em>' attribute.
	 * @see #setDbName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_DbName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbName'"
	 * @generated
	 */
	String getDbName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDbName <em>Db Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Name</em>' attribute.
	 * @see #getDbName()
	 * @generated
	 */
	void setDbName(String value);

	/**
	 * Returns the value of the '<em><b>Dft Extent Size</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Dft Extent Size</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dft Extent Size</em>' attribute.
	 * @see #setDftExtentSize(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_DftExtentSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='dftExtentSize'"
	 * @generated
	 */
	BigInteger getDftExtentSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getDftExtentSize <em>Dft Extent Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dft Extent Size</em>' attribute.
	 * @see #getDftExtentSize()
	 * @generated
	 */
	void setDftExtentSize(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Page Size</b></em>' attribute.
	 * The default value is <code>"4096"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.db2.PageSizeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Size</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Page size
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Page Size</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
	 * @see #isSetPageSize()
	 * @see #unsetPageSize()
	 * @see #setPageSize(PageSizeType)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_PageSize()
	 * @model default="4096" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='pageSize'"
	 * @generated
	 */
	PageSizeType getPageSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Size</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.db2.PageSizeType
	 * @see #isSetPageSize()
	 * @see #unsetPageSize()
	 * @see #getPageSize()
	 * @generated
	 */
	void setPageSize(PageSizeType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPageSize()
	 * @see #getPageSize()
	 * @see #setPageSize(PageSizeType)
	 * @generated
	 */
	void unsetPageSize();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getPageSize <em>Page Size</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Page Size</em>' attribute is set.
	 * @see #unsetPageSize()
	 * @see #getPageSize()
	 * @see #setPageSize(PageSizeType)
	 * @generated
	 */
	boolean isSetPageSize();

	/**
	 * Returns the value of the '<em><b>Temp Sp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Sp</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Temporary tablespace, e.g. "TEMPSPACE1"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Temp Sp</em>' attribute.
	 * @see #setTempSp(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_TempSp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='tempSp'"
	 * @generated
	 */
	String getTempSp();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getTempSp <em>Temp Sp</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Sp</em>' attribute.
	 * @see #getTempSp()
	 * @generated
	 */
	void setTempSp(String value);

	/**
	 * Returns the value of the '<em><b>Territory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Territory</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * One of "BLANK, BR CN DE DK FI FR EN ES IT JP KR NO PL RU SE TW"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Territory</em>' attribute.
	 * @see #setTerritory(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_Territory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='territory'"
	 * @generated
	 */
	String getTerritory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getTerritory <em>Territory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Territory</em>' attribute.
	 * @see #getTerritory()
	 * @generated
	 */
	void setTerritory(String value);

	/**
	 * Returns the value of the '<em><b>User Sp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Sp</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * User tablespace, e.g. "USERSPACE1"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User Sp</em>' attribute.
	 * @see #setUserSp(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2Database_UserSp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userSp'"
	 * @generated
	 */
	String getUserSp();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.DB2Database#getUserSp <em>User Sp</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Sp</em>' attribute.
	 * @see #getUserSp()
	 * @generated
	 */
	void setUserSp(String value);

} // DB2Database
