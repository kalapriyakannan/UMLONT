/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby;

import com.ibm.ccl.soa.deploy.database.Database;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbAlias <em>Db Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbDrive <em>Db Drive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbName <em>Db Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDerbyVersion <em>Derby Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDatabase()
 * @model extendedMetaData="name='DerbyDatabase' kind='elementOnly'"
 * @generated
 */
public interface DerbyDatabase extends Database {
	/**
	 * Returns the value of the '<em><b>Db Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Db Alias</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Db Alias</em>' attribute.
	 * @see #setDbAlias(String)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDatabase_DbAlias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbAlias'"
	 * @generated
	 */
	String getDbAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbAlias <em>Db Alias</em>}' attribute.
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
	 * @return the value of the '<em>Db Drive</em>' attribute.
	 * @see #setDbDrive(String)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDatabase_DbDrive()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbDrive'"
	 * @generated
	 */
	String getDbDrive();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbDrive <em>Db Drive</em>}' attribute.
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
	 * @return the value of the '<em>Db Name</em>' attribute.
	 * @see #setDbName(String)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDatabase_DbName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dbName'"
	 * @generated
	 */
	String getDbName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDbName <em>Db Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Db Name</em>' attribute.
	 * @see #getDbName()
	 * @generated
	 */
	void setDbName(String value);

	/**
	 * Returns the value of the '<em><b>Derby Version</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Derby Version</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derby Version</em>' attribute.
	 * @see #setDerbyVersion(String)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDatabase_DerbyVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='derbyVersion'"
	 * @generated
	 */
	String getDerbyVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase#getDerbyVersion <em>Derby Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derby Version</em>' attribute.
	 * @see #getDerbyVersion()
	 * @generated
	 */
	void setDerbyVersion(String value);

} // DerbyDatabase
