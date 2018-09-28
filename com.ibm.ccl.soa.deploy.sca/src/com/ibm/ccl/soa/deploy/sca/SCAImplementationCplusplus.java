/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCA Implementation Cplusplus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getClass_ <em>Class</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getPolicySets <em>Policy Sets</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getRequires <em>Requires</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAImplementationCplusplus()
 * @model extendedMetaData="name='SCAImplementationCplusplus' kind='elementOnly'"
 * @generated
 */
public interface SCAImplementationCplusplus extends Capability {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAImplementationCplusplus_Class()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='class'"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Policy Sets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Sets</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Sets</em>' attribute.
	 * @see #setPolicySets(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAImplementationCplusplus_PolicySets()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='policySets'"
	 * @generated
	 */
	String getPolicySets();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getPolicySets <em>Policy Sets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Sets</em>' attribute.
	 * @see #getPolicySets()
	 * @generated
	 */
	void setPolicySets(String value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' attribute.
	 * @see #setRequires(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAImplementationCplusplus_Requires()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Requires'"
	 * @generated
	 */
	String getRequires();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus#getRequires <em>Requires</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requires</em>' attribute.
	 * @see #getRequires()
	 * @generated
	 */
	void setRequires(String value);

} // SCAImplementationCplusplus
