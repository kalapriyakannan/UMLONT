/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Requirement Expression Usage</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 'required' means normal {@link RequirementExpression} semantics.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementExpressionUsage()
 * @model
 * @generated
 */
public final class RequirementExpressionUsage extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Required</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Required</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUIRED_LITERAL
	 * @model name="required"
	 * @generated
	 * @ordered
	 */
	public static final int REQUIRED = 0;

	/**
	 * The '<em><b>Optional</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Optional</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPTIONAL_LITERAL
	 * @model name="optional"
	 * @generated
	 * @ordered
	 */
	public static final int OPTIONAL = 1;

	/**
	 * The '<em><b>Prohibited</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Prohibited</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROHIBITED_LITERAL
	 * @model name="prohibited"
	 * @generated
	 * @ordered
	 */
	public static final int PROHIBITED = 2;

	/**
	 * The '<em><b>Required</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #REQUIRED
	 * @generated
	 * @ordered
	 */
	public static final RequirementExpressionUsage REQUIRED_LITERAL = new RequirementExpressionUsage(REQUIRED, "required", "required"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Optional</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #OPTIONAL
	 * @generated
	 * @ordered
	 */
	public static final RequirementExpressionUsage OPTIONAL_LITERAL = new RequirementExpressionUsage(OPTIONAL, "optional", "optional"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Prohibited</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PROHIBITED
	 * @generated
	 * @ordered
	 */
	public static final RequirementExpressionUsage PROHIBITED_LITERAL = new RequirementExpressionUsage(PROHIBITED, "prohibited", "prohibited"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Requirement Expression Usage</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RequirementExpressionUsage[] VALUES_ARRAY = new RequirementExpressionUsage[] {
			REQUIRED_LITERAL,
			OPTIONAL_LITERAL,
			PROHIBITED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Requirement Expression Usage</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Requirement Expression Usage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementExpressionUsage get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementExpressionUsage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Expression Usage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementExpressionUsage getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementExpressionUsage result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Expression Usage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementExpressionUsage get(int value) {
		switch (value) {
			case REQUIRED: return REQUIRED_LITERAL;
			case OPTIONAL: return OPTIONAL_LITERAL;
			case PROHIBITED: return PROHIBITED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private RequirementExpressionUsage(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RequirementExpressionUsage
