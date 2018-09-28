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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Classloader</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.Classloader#getMode <em>Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.Classloader#getStartWeight <em>Start Weight</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.Classloader#getWarClassLoaderPolicy <em>War Class Loader Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getClassloader()
 * @model extendedMetaData="name='Classloader' kind='empty'"
 * @generated
 */
public interface Classloader {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The default value is <code>"PARENT_FIRST"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ClassloaderMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderMode
	 * @see #isSetMode()
	 * @see #unsetMode()
	 * @see #setMode(ClassloaderMode)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getClassloader_Mode()
	 * @model default="PARENT_FIRST" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='mode'"
	 * @generated
	 */
	ClassloaderMode getMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderMode
	 * @see #isSetMode()
	 * @see #unsetMode()
	 * @see #getMode()
	 * @generated
	 */
	void setMode(ClassloaderMode value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMode()
	 * @see #getMode()
	 * @see #setMode(ClassloaderMode)
	 * @generated
	 */
	void unsetMode();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getMode <em>Mode</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mode</em>' attribute is set.
	 * @see #unsetMode()
	 * @see #getMode()
	 * @see #setMode(ClassloaderMode)
	 * @generated
	 */
	boolean isSetMode();

	/**
	 * Returns the value of the '<em><b>Start Weight</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Start Weight</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Weight</em>' attribute.
	 * @see #isSetStartWeight()
	 * @see #unsetStartWeight()
	 * @see #setStartWeight(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getClassloader_StartWeight()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='startWeight'"
	 * @generated
	 */
	int getStartWeight();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getStartWeight <em>Start Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Weight</em>' attribute.
	 * @see #isSetStartWeight()
	 * @see #unsetStartWeight()
	 * @see #getStartWeight()
	 * @generated
	 */
	void setStartWeight(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getStartWeight <em>Start Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetStartWeight()
	 * @see #getStartWeight()
	 * @see #setStartWeight(int)
	 * @generated
	 */
	void unsetStartWeight();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getStartWeight <em>Start Weight</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Weight</em>' attribute is set.
	 * @see #unsetStartWeight()
	 * @see #getStartWeight()
	 * @see #setStartWeight(int)
	 * @generated
	 */
	boolean isSetStartWeight();

	/**
	 * Returns the value of the '<em><b>War Class Loader Policy</b></em>' attribute.
	 * The default value is <code>"MODULE"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.WARClassloaderPolicy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>War Class Loader Policy</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>War Class Loader Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WARClassloaderPolicy
	 * @see #isSetWarClassLoaderPolicy()
	 * @see #unsetWarClassLoaderPolicy()
	 * @see #setWarClassLoaderPolicy(WARClassloaderPolicy)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getClassloader_WarClassLoaderPolicy()
	 * @model default="MODULE" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='warClassLoaderPolicy'"
	 * @generated
	 */
	WARClassloaderPolicy getWarClassLoaderPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getWarClassLoaderPolicy <em>War Class Loader Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>War Class Loader Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.WARClassloaderPolicy
	 * @see #isSetWarClassLoaderPolicy()
	 * @see #unsetWarClassLoaderPolicy()
	 * @see #getWarClassLoaderPolicy()
	 * @generated
	 */
	void setWarClassLoaderPolicy(WARClassloaderPolicy value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getWarClassLoaderPolicy <em>War Class Loader Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetWarClassLoaderPolicy()
	 * @see #getWarClassLoaderPolicy()
	 * @see #setWarClassLoaderPolicy(WARClassloaderPolicy)
	 * @generated
	 */
	void unsetWarClassLoaderPolicy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.Classloader#getWarClassLoaderPolicy <em>War Class Loader Policy</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>War Class Loader Policy</em>' attribute is set.
	 * @see #unsetWarClassLoaderPolicy()
	 * @see #getWarClassLoaderPolicy()
	 * @see #setWarClassLoaderPolicy(WARClassloaderPolicy)
	 * @generated
	 */
	boolean isSetWarClassLoaderPolicy();

} // Classloader
