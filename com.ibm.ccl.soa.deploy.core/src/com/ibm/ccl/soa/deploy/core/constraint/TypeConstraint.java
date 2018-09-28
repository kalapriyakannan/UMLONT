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

import javax.xml.namespace.QName;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Type Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * 
 * Constraint that restricts the type of the context DMO, which is being validated. The primary
 * intent to use TypeConstraint is as a child of another constraint, which would define the
 * semantics of the child TypeConstraint constraint and would supply the right validation context.
 * 
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint#getDmoType <em>Dmo Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getTypeConstraint()
 * @model extendedMetaData="name='TypeConstraint' kind='elementOnly'"
 * @generated NOT
 * @extends Parentable
 */
public interface TypeConstraint extends Constraint, Parentable {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Dmo Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * Specifies the type (e.g., 'namespace:TypeName') of a Deploy Model Object.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Dmo Type</em>' attribute.
	 * @see #setDmoType(QName)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getTypeConstraint_DmoType()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='dmoType'"
	 * @generated
	 */
	QName getDmoType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint#getDmoType <em>Dmo Type</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Dmo Type</em>' attribute.
	 * @see #getDmoType()
	 * @generated
	 */
	void setDmoType(QName value);

	/**
	 * Returns the {@link #getDmoType()} XMLNS {@link QualifiedName} converted to an EMF
	 * {@link EClass}.
	 * <p>
	 * The conversion requires that the {@link Constraint#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @return the EClass corresponding to the XMLNS {@link QualifiedName}; or null, if a problem
	 *         happens.
	 * 
	 * @generated NOT
	 */
	public EClass getDmoEType();

	/**
	 * Sets the value of the {@link #setDmoType(QName)} attribute by converting the {@link EClass} to
	 * an XMLNS {@link QualifiedName}.
	 * <p>
	 * The conversion requires that the {@link Constraint#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @param type
	 *           the ECore type to be converted to an XMLNS {@link QualifiedName}.
	 * 
	 * @generated NOT
	 */
	public void setDmoEType(EClass type);

} // TypeConstraint
