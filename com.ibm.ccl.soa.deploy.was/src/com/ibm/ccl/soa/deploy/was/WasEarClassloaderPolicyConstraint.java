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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ear Classloader Policy Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Was classloader policy constraint for ear modules.
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getPolicy <em>Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#isReloadClasses <em>Reload Classes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getReloadInterval <em>Reload Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEarClassloaderPolicyConstraint()
 * @model extendedMetaData="name='WasEarClassloaderPolicyConstraint' kind='elementOnly'"
 * @generated
 */
public interface WasEarClassloaderPolicyConstraint extends WasWarClassloaderPolicyConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Policy</b></em>' attribute.
	 * The default value is <code>"SINGLE"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType
	 * @see #isSetPolicy()
	 * @see #unsetPolicy()
	 * @see #setPolicy(ClassloaderPolicyType)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEarClassloaderPolicyConstraint_Policy()
	 * @model default="SINGLE" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='policy'"
	 * @generated
	 */
	ClassloaderPolicyType getPolicy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType
	 * @see #isSetPolicy()
	 * @see #unsetPolicy()
	 * @see #getPolicy()
	 * @generated
	 */
	void setPolicy(ClassloaderPolicyType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPolicy()
	 * @see #getPolicy()
	 * @see #setPolicy(ClassloaderPolicyType)
	 * @generated
	 */
	void unsetPolicy();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getPolicy <em>Policy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Policy</em>' attribute is set.
	 * @see #unsetPolicy()
	 * @see #getPolicy()
	 * @see #setPolicy(ClassloaderPolicyType)
	 * @generated
	 */
	boolean isSetPolicy();

	/**
	 * Returns the value of the '<em><b>Reload Classes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reload Classes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reload Classes</em>' attribute.
	 * @see #isSetReloadClasses()
	 * @see #unsetReloadClasses()
	 * @see #setReloadClasses(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEarClassloaderPolicyConstraint_ReloadClasses()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='reloadClasses'"
	 * @generated
	 */
	boolean isReloadClasses();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#isReloadClasses <em>Reload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reload Classes</em>' attribute.
	 * @see #isSetReloadClasses()
	 * @see #unsetReloadClasses()
	 * @see #isReloadClasses()
	 * @generated
	 */
	void setReloadClasses(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#isReloadClasses <em>Reload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReloadClasses()
	 * @see #isReloadClasses()
	 * @see #setReloadClasses(boolean)
	 * @generated
	 */
	void unsetReloadClasses();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#isReloadClasses <em>Reload Classes</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reload Classes</em>' attribute is set.
	 * @see #unsetReloadClasses()
	 * @see #isReloadClasses()
	 * @see #setReloadClasses(boolean)
	 * @generated
	 */
	boolean isSetReloadClasses();

	/**
	 * Returns the value of the '<em><b>Reload Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reload Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #setReloadInterval(int)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasEarClassloaderPolicyConstraint_ReloadInterval()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='reloadInterval'"
	 * @generated
	 */
	int getReloadInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @generated
	 */
	void setReloadInterval(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(int)
	 * @generated
	 */
	void unsetReloadInterval();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint#getReloadInterval <em>Reload Interval</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reload Interval</em>' attribute is set.
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(int)
	 * @generated
	 */
	boolean isSetReloadInterval();

} // WasEarClassloaderPolicyConstraint
