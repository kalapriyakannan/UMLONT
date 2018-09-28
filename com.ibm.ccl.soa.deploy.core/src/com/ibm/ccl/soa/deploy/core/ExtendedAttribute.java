/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Extended Attribute</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * 
 * Structure for dynamic addition of attributes to a {@link DeployModelObject}.
 * <p>
 * Extended attribute instances are created using {@link CoreFactory#createExtendedAttribute()}.
 * They are associated with a deploy object by being added to the list of
 * {@link DeployModelObject#getExtendedAttributes()}. An extended attribute must have a
 * <code>name</code> that is unique for the object.
 * </p>
 * 
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExtendedAttribute()
 * @model features="data" dataType="org.eclipse.emf.ecore.EObject" dataContainment="true"
 *        dataRequired="true" dataSuppressedGetVisibility="true" dataSuppressedSetVisibility="true"
 *        dataExtendedMetaData="kind='element' name='data' namespace='##targetNamespace'"
 *        extendedMetaData="name='ExtendedAttribute' kind='elementOnly'"
 * 
 * @extends EAttribute
 */
public interface ExtendedAttribute extends EObject, EAttribute {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getExtendedAttribute_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * @return the value of the extended attribute.
	 * @generated NOT
	 */
	Object getValue();

	/**
	 * Sets the value of the extended attribute.
	 * <p>
	 * The value is not checkd against the {@link #getInstanceType()}. It is the responsibility of
	 * the {@link DeployValidatorService} to do so.
	 * 
	 * @param value
	 *           the new attribute value.
	 * @generated NOT
	 */
	void setValue(Object value);

	/**
	 * @return the type of the attribute, null for any.
	 * @generated NOT
	 */
	EDataType getInstanceType();

	/**
	 * Sets the type of the attribute.
	 * <p>
	 * {@link EDataType} declarations for common types can be obtained from {@link XMLTypePackage}.
	 * 
	 * @param type
	 *           the attribute type.
	 * 
	 * @see XMLTypePackage
	 * @generated NOT
	 */
	void setInstanceType(EDataType type);

	/**
	 * @return the deploy model object which contains this attribute.
	 * 
	 * @see DeployModelObject#getExtendedAttributes()
	 * @generated NOT
	 */
	DeployModelObject getContainer();

} // ExtendedAttribute
