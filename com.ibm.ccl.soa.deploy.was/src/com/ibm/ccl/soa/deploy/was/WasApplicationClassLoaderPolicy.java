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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Application Class Loader Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#isReloadClasses <em>Reload Classes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#getReloadInterval <em>Reload Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationClassLoaderPolicy()
 * @model extendedMetaData="name='WasApplicationClassLoaderPolicy' kind='elementOnly'"
 * @generated
 */
public interface WasApplicationClassLoaderPolicy extends WasClassLoaderPolicy {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Reload Classes</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Reload Classes</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reload Classes</em>' attribute.
	 * @see #isSetReloadClasses()
	 * @see #unsetReloadClasses()
	 * @see #setReloadClasses(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationClassLoaderPolicy_ReloadClasses()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='reloadClasses'"
	 * @generated
	 */
	boolean isReloadClasses();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#isReloadClasses <em>Reload Classes</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reload Classes</em>' attribute.
	 * @see #isSetReloadClasses()
	 * @see #unsetReloadClasses()
	 * @see #isReloadClasses()
	 * @generated
	 */
	void setReloadClasses(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#isReloadClasses <em>Reload Classes</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReloadClasses()
	 * @see #isReloadClasses()
	 * @see #setReloadClasses(boolean)
	 * @generated
	 */
	void unsetReloadClasses();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#isReloadClasses <em>Reload Classes</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reload Classes</em>' attribute is set.
	 * @see #unsetReloadClasses()
	 * @see #isReloadClasses()
	 * @see #setReloadClasses(boolean)
	 * @generated
	 */
	boolean isSetReloadClasses();

	/**
	 * Returns the value of the '<em><b>Reload Interval</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Reload Interval</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #setReloadInterval(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationClassLoaderPolicy_ReloadInterval()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='reloadInterval'"
	 * @generated
	 */
	int getReloadInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @generated
	 */
	void setReloadInterval(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(int)
	 * @generated
	 */
	void unsetReloadInterval();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationClassLoaderPolicy#getReloadInterval <em>Reload Interval</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reload Interval</em>' attribute is set.
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(int)
	 * @generated
	 */
	boolean isSetReloadInterval();

} // WasApplicationClassLoaderPolicy
