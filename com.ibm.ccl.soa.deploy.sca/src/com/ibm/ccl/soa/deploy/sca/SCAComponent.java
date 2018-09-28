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
 * A representation of the model object '<em><b>SCA Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAComponent#getAutowire <em>Autowire</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAComponent#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAComponent()
 * @model extendedMetaData="name='SCAComponent' kind='elementOnly'"
 * @generated
 */
public interface SCAComponent extends Capability {
	/**
	 * Returns the value of the '<em><b>Autowire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autowire</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autowire</em>' attribute.
	 * @see #setAutowire(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAComponent_Autowire()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Autowire'"
	 * @generated
	 */
	String getAutowire();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAComponent#getAutowire <em>Autowire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autowire</em>' attribute.
	 * @see #getAutowire()
	 * @generated
	 */
	void setAutowire(String value);

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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAComponent_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAComponent#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

} // SCAComponent
