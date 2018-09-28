/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Requirement Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A further matching constraint upon a {@link Requirement}.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getInterpreter <em>Interpreter</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getUse <em>Use</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementExpression()
 * @model extendedMetaData="name='RequirementExpression' kind='elementOnly'"
 * @generated
 */
public interface RequirementExpression extends Constraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc --> <!-- begin-model-doc --> name of an attribute on the
	 * {@link Capability} or {@link Unit} that satisfies the containing {@link Requirement} <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementExpression_AttributeName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='attributeName'"
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Interpreter</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Refers to an &lt;interpreter name=&gt; in
	 * domain extension <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Interpreter</em>' attribute.
	 * @see #setInterpreter(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementExpression_Interpreter()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='interpreter'"
	 * @generated
	 */
	String getInterpreter();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getInterpreter <em>Interpreter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpreter</em>' attribute.
	 * @see #getInterpreter()
	 * @generated
	 */
	void setInterpreter(String value);

	/**
	 * Returns the value of the '<em><b>Use</b></em>' attribute. The default value is
	 * <code>"required"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> Usually 'required' <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Use</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
	 * @see #isSetUse()
	 * @see #unsetUse()
	 * @see #setUse(RequirementExpressionUsage)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementExpression_Use()
	 * @model default="required" unique="false" unsettable="true" extendedMetaData="kind='attribute'
	 *        name='use'"
	 * @generated
	 */
	RequirementExpressionUsage getUse();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getUse <em>Use</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage
	 * @see #isSetUse()
	 * @see #unsetUse()
	 * @see #getUse()
	 * @generated
	 */
	void setUse(RequirementExpressionUsage value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getUse <em>Use</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUse()
	 * @see #getUse()
	 * @see #setUse(RequirementExpressionUsage)
	 * @generated
	 */
	void unsetUse();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getUse <em>Use</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use</em>' attribute is set.
	 * @see #unsetUse()
	 * @see #getUse()
	 * @see #setUse(RequirementExpressionUsage)
	 * @generated
	 */
	boolean isSetUse();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> interpreter-specific; for the equals interpreter a
	 * constaint that will be compared to the value of the attribute on the matching Capability <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementExpression_Value()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.RequirementExpression#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // RequirementExpression
