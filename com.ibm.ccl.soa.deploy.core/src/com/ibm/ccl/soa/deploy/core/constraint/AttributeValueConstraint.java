/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Abstract parent type of all constraint types representing attribute value constraints.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributeValueConstraint()
 * @model abstract="true"
 *        extendedMetaData="name='AttributeValueConstraint' kind='elementOnly'"
 * @generated
 */
public interface AttributeValueConstraint extends Constraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * 
	 * <!-- begin-model-doc -->
	 * 
	 * Name of the attribute on the {@link Capability} or {@link Unit}
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getAttributeValueConstraint_AttributeName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='attributeName'"
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

} // AttributeValueConstraint
