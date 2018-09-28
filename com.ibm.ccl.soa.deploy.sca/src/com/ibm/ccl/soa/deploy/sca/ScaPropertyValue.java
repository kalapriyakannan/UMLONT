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
 * A representation of the model object '<em><b>Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getElement <em>Element</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getFile <em>File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMany <em>Many</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMustSupply <em>Must Supply</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getSource <em>Source</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue()
 * @model extendedMetaData="name='scaPropertyValue' kind='elementOnly'"
 * @generated
 */
public interface ScaPropertyValue extends Capability {
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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_Element()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Element'"
	 * @generated
	 */
	String getElement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getElement <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' attribute.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(String value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_File()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='File'"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_Many()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Many'"
	 * @generated
	 */
	String getMany();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMany <em>Many</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_MustSupply()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MustSupply'"
	 * @generated
	 */
	String getMustSupply();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getMustSupply <em>Must Supply</em>}' attribute.
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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_Source()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Source'"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

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
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getScaPropertyValue_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // ScaPropertyValue
