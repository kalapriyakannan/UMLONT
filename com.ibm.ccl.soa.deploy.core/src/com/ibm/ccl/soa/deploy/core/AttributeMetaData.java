/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Properties that can be applied to any attribute in a {@link DeployModelObject} (including {@link ExtendedAttributes}).
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getDescription <em>Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncrypted <em>Encrypted</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncryptionRequired <em>Encryption Required</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getLabel <em>Label</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isMutable <em>Mutable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isOptional <em>Optional</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData()
 * @model extendedMetaData="name='AttributeMetaData' kind='empty'"
 * @generated
 */
public interface AttributeMetaData extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> identifies which attribute or
	 * {@link ExtendedAttribute} this metadata applies to <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_AttributeName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='attributeName'"
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * TODO <b>What is the meaning of this attribute?</b>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_Description()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Encrypted</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encrypted</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> if <code>true</code>, field is treated as a
	 * password and not displayed clear in GUI or serialized clear <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Encrypted</em>' attribute.
	 * @see #isSetEncrypted()
	 * @see #unsetEncrypted()
	 * @see #setEncrypted(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_Encrypted()
	 * @model default="false" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='encrypted'"
	 * @generated
	 */
	boolean isEncrypted();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncrypted <em>Encrypted</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encrypted</em>' attribute.
	 * @see #isSetEncrypted()
	 * @see #unsetEncrypted()
	 * @see #isEncrypted()
	 * @generated
	 */
	void setEncrypted(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncrypted <em>Encrypted</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEncrypted()
	 * @see #isEncrypted()
	 * @see #setEncrypted(boolean)
	 * @generated
	 */
	void unsetEncrypted();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncrypted <em>Encrypted</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Encrypted</em>' attribute is set.
	 * @see #unsetEncrypted()
	 * @see #isEncrypted()
	 * @see #setEncrypted(boolean)
	 * @generated
	 */
	boolean isSetEncrypted();

	/**
	 * Returns the value of the '<em><b>Encryption Required</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encryption Required</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encryption Required</em>' attribute.
	 * @see #isSetEncryptionRequired()
	 * @see #unsetEncryptionRequired()
	 * @see #setEncryptionRequired(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_EncryptionRequired()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='encryptionRequired'"
	 * @generated
	 */
	boolean isEncryptionRequired();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncryptionRequired <em>Encryption Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encryption Required</em>' attribute.
	 * @see #isSetEncryptionRequired()
	 * @see #unsetEncryptionRequired()
	 * @see #isEncryptionRequired()
	 * @generated
	 */
	void setEncryptionRequired(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncryptionRequired <em>Encryption Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetEncryptionRequired()
	 * @see #isEncryptionRequired()
	 * @see #setEncryptionRequired(boolean)
	 * @generated
	 */
	void unsetEncryptionRequired();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isEncryptionRequired <em>Encryption Required</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Encryption Required</em>' attribute is set.
	 * @see #unsetEncryptionRequired()
	 * @see #isEncryptionRequired()
	 * @see #setEncryptionRequired(boolean)
	 * @generated
	 */
	boolean isSetEncryptionRequired();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 	            A string label for the attribute.
	 * 	            <p>
	 * 	            The label is a user-friendly and internationalized name for an attribute.   Typically,
	 * 	            labels will be provided for extended attributes, but they can also be provided to
	 * 	            customize the name of static attributes.
	 * 	            </p>
	 * 	            @see #getDescription()
	 * 	         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_Label()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='label'"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Mutable</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> if false, attribute is considered to be
	 * read-only <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Mutable</em>' attribute.
	 * @see #isSetMutable()
	 * @see #unsetMutable()
	 * @see #setMutable(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_Mutable()
	 * @model default="true" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='mutable'"
	 * @generated
	 */
	boolean isMutable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isMutable <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutable</em>' attribute.
	 * @see #isSetMutable()
	 * @see #unsetMutable()
	 * @see #isMutable()
	 * @generated
	 */
	void setMutable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isMutable <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMutable()
	 * @see #isMutable()
	 * @see #setMutable(boolean)
	 * @generated
	 */
	void unsetMutable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isMutable <em>Mutable</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mutable</em>' attribute is set.
	 * @see #unsetMutable()
	 * @see #isMutable()
	 * @see #setMutable(boolean)
	 * @generated
	 */
	boolean isSetMutable();

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * TODO <b>What is the meaning of this attribute</b>
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #isSetOptional()
	 * @see #unsetOptional()
	 * @see #setOptional(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_Optional()
	 * @model default="false" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='optional'"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isSetOptional()
	 * @see #unsetOptional()
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetOptional()
	 * @see #isOptional()
	 * @see #setOptional(boolean)
	 * @generated
	 */
	void unsetOptional();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isOptional <em>Optional</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Optional</em>' attribute is set.
	 * @see #unsetOptional()
	 * @see #isOptional()
	 * @see #setOptional(boolean)
	 * @generated
	 */
	boolean isSetOptional();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc
	 * -->
	 * 
	 * <i>Template</i> validation MUST NOT complain about the value of any (extended) attribute
	 * tagged as a parameter (but <i>Publish</i> validation MUST complain if publishing would fail
	 * with the attribute at it's current value. 'Deploy' validation MAY complain.) 'Parameter' is a
	 * hint to validators indicating that an attribute's value isn't finalized. It's a hint to to
	 * 'topology factories' of good customization points on topology templates.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Parameter</em>' attribute.
	 * @see #isSetParameter()
	 * @see #unsetParameter()
	 * @see #setParameter(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAttributeMetaData_Parameter()
	 * @model default="false" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='parameter'"
	 * @generated
	 */
	boolean isParameter();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isParameter <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' attribute.
	 * @see #isSetParameter()
	 * @see #unsetParameter()
	 * @see #isParameter()
	 * @generated
	 */
	void setParameter(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isParameter <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetParameter()
	 * @see #isParameter()
	 * @see #setParameter(boolean)
	 * @generated
	 */
	void unsetParameter();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.AttributeMetaData#isParameter <em>Parameter</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter</em>' attribute is set.
	 * @see #unsetParameter()
	 * @see #isParameter()
	 * @see #setParameter(boolean)
	 * @generated
	 */
	boolean isSetParameter();

} // AttributeMetaData
