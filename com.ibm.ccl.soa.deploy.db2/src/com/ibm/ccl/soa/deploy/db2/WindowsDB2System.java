/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Windows DB2 System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getAdminGroupName <em>Admin Group Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#isExtendedSecurity <em>Extended Security</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getUserGroupName <em>User Group Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2System()
 * @model extendedMetaData="name='WindowsDB2System' kind='elementOnly'"
 * @generated
 */
public interface WindowsDB2System extends DB2System {
	/**
	 * Returns the value of the '<em><b>Admin Group Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Admin Group Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Admin Group Name</em>' attribute.
	 * @see #setAdminGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2System_AdminGroupName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='adminGroupName'"
	 * @generated
	 */
	String getAdminGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getAdminGroupName <em>Admin Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin Group Name</em>' attribute.
	 * @see #getAdminGroupName()
	 * @generated
	 */
	void setAdminGroupName(String value);

	/**
	 * Returns the value of the '<em><b>Extended Security</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Security</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Extended Security</em>' attribute.
	 * @see #isSetExtendedSecurity()
	 * @see #unsetExtendedSecurity()
	 * @see #setExtendedSecurity(boolean)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2System_ExtendedSecurity()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='extendedSecurity'"
	 * @generated
	 */
	boolean isExtendedSecurity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#isExtendedSecurity <em>Extended Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Security</em>' attribute.
	 * @see #isSetExtendedSecurity()
	 * @see #unsetExtendedSecurity()
	 * @see #isExtendedSecurity()
	 * @generated
	 */
	void setExtendedSecurity(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#isExtendedSecurity <em>Extended Security</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetExtendedSecurity()
	 * @see #isExtendedSecurity()
	 * @see #setExtendedSecurity(boolean)
	 * @generated
	 */
	void unsetExtendedSecurity();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#isExtendedSecurity <em>Extended Security</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Extended Security</em>' attribute is set.
	 * @see #unsetExtendedSecurity()
	 * @see #isExtendedSecurity()
	 * @see #setExtendedSecurity(boolean)
	 * @generated
	 */
	boolean isSetExtendedSecurity();

	/**
	 * Returns the value of the '<em><b>User Group Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>User Group Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The Windows user group for DB2 users. Members of this group will have read and execute
	 * 							access to all DB2 objects in the system.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User Group Name</em>' attribute.
	 * @see #setUserGroupName(String)
	 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getWindowsDB2System_UserGroupName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='userGroupName'"
	 * @generated
	 */
	String getUserGroupName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2.WindowsDB2System#getUserGroupName <em>User Group Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Group Name</em>' attribute.
	 * @see #getUserGroupName()
	 * @generated
	 */
	void setUserGroupName(String value);

} // WindowsDB2System
