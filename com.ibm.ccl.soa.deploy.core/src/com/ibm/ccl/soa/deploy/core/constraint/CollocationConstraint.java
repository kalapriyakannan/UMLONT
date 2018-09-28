/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import javax.xml.namespace.QName;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.impl.RequirementImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Collocation Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Structural constraint representing collocation and anti-collocation of two units.
 * 			    Indicates that two units should be collocated/anti-collocated at a certain level 
 * 			    of their hosting stacks.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getCapabilityType <em>Capability Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCollocationConstraint()
 * @model extendedMetaData="name='CollocationConstraint' kind='elementOnly'"
 * @generated
 */
public interface CollocationConstraint extends StructuralConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Capability Type</b></em>' attribute.
	 * 
	 * <!-- begin-model-doc -->
	 * 
	 * Indicates capability type, such that hosting stacks converge ('collocation') or do not
	 * converge (anti-collocation) at every occurrence of units with the given capability type on
	 * both sides of the hosting stack.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Capability Type</em>' attribute.
	 * @see #setCapabilityType(QName)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCollocationConstraint_CapabilityType()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='capabilityType'"
	 * @generated
	 */
	QName getCapabilityType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getCapabilityType <em>Capability Type</em>}'
	 * attribute.
	 * 
	 * @param value
	 *           the new value of the '<em>Capability Type</em>' attribute.
	 * @see #getCapabilityType()
	 * @generated
	 */
	void setCapabilityType(QName value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"collocation"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 	    			Type of the collocation: 'collocation' or 'anti-collocation'.
	 * 					
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(CollocationConstraintTypes)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCollocationConstraint_Type()
	 * @model default="collocation" unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	CollocationConstraintTypes getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(CollocationConstraintTypes value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(CollocationConstraintTypes)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(CollocationConstraintTypes)
	 * @generated
	 */
	boolean isSetType();

	/**
	 * Returns the {@link #getCapabilityType()} XMLNS {@link QualifiedName} converted to an EMF
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
	public EClass getCapabilityEType();

	/**
	 * Sets the value of the {@link #setCapabilityType(Object)} attribute by converting the
	 * {@link EClass} to an XMLNS {@link QualifiedName}.
	 * <p>
	 * The conversion requires that the {@link Constraint#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @param type
	 *           the ECore type to be converted to an XMLNS {@link QualifiedName}.
	 * 
	 * Copied from {@link RequirementImpl}
	 * 
	 * @generated NOT
	 */
	public void setCapabilityEType(EClass type);

} // CollocationConstraint
