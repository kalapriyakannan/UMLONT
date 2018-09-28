/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.wps;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Rules Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManager#getBusinessRulesManager <em>Business Rules Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBusinessRulesManager()
 * @model extendedMetaData="name='BusinessRulesManager' kind='elementOnly'"
 * @generated
 */
public interface BusinessRulesManager extends Capability {
	/**
	 * Returns the value of the '<em><b>Business Rules Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Rules Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Rules Manager</em>' attribute.
	 * @see #setBusinessRulesManager(String)
	 * @see com.ibm.ccl.soa.deploy.wps.WpsPackage#getBusinessRulesManager_BusinessRulesManager()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='BusinessRulesManager'"
	 * @generated
	 */
	String getBusinessRulesManager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.wps.BusinessRulesManager#getBusinessRulesManager <em>Business Rules Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Business Rules Manager</em>' attribute.
	 * @see #getBusinessRulesManager()
	 * @generated
	 */
	void setBusinessRulesManager(String value);

} // BusinessRulesManager
