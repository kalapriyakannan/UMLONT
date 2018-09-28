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
 * A representation of the model object '<em><b>Generic SCA Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getPolicySets <em>Policy Sets</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getRequires <em>Requires</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getGenericSCAImplementation()
 * @model extendedMetaData="name='GenericSCAImplementation' kind='elementOnly'"
 * @generated
 */
public interface GenericSCAImplementation extends Capability {
	/**
	 * Returns the value of the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name1</em>' attribute.
	 * @see #setName1(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getGenericSCAImplementation_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getGenericSCAImplementation_PolicySets()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='policySets'"
	 * @generated
	 */
	String getPolicySets();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getPolicySets <em>Policy Sets</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getGenericSCAImplementation_Requires()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Requires'"
	 * @generated
	 */
	String getRequires();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getRequires <em>Requires</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requires</em>' attribute.
	 * @see #getRequires()
	 * @generated
	 */
	void setRequires(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getGenericSCAImplementation_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // GenericSCAImplementation
