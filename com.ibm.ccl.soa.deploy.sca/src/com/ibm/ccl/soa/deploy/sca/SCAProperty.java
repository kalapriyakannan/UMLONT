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
 * A representation of the model object '<em><b>SCA Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getElement <em>Element</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getMany <em>Many</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getMustSupply <em>Must Supply</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAProperty()
 * @model extendedMetaData="name='SCAProperty' kind='elementOnly'"
 * @generated
 */
public interface SCAProperty extends Capability {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' attribute.
	 * @see #setElement(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAProperty_Element()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Element'"
	 * @generated
	 */
	String getElement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getElement <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' attribute.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(String value);

	/**
	 * Returns the value of the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many</em>' attribute.
	 * @see #setMany(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAProperty_Many()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Many'"
	 * @generated
	 */
	String getMany();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getMany <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Many</em>' attribute.
	 * @see #getMany()
	 * @generated
	 */
	void setMany(String value);

	/**
	 * Returns the value of the '<em><b>Must Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Must Supply</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Must Supply</em>' attribute.
	 * @see #setMustSupply(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAProperty_MustSupply()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mustSupply'"
	 * @generated
	 */
	String getMustSupply();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getMustSupply <em>Must Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Must Supply</em>' attribute.
	 * @see #getMustSupply()
	 * @generated
	 */
	void setMustSupply(String value);

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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAProperty_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCAProperty_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // SCAProperty
