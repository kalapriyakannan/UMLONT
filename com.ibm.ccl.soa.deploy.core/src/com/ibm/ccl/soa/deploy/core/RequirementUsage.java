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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Requirement Usage</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The usage of this {@link Requirement}. 'required' means that the Requirement expresses a
 * requirement, rather than an anti-requirement.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementUsage()
 * @model
 * @generated
 */
public final class RequirementUsage extends AbstractEnumerator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2179108696176100902L;

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
	public static final RequirementUsage REQUIRED_LITERAL = new RequirementUsage(REQUIRED, "required", "required"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Optional</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #OPTIONAL
	 * @generated
	 * @ordered
	 */
	public static final RequirementUsage OPTIONAL_LITERAL = new RequirementUsage(OPTIONAL, "optional", "optional"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Prohibited</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PROHIBITED
	 * @generated
	 * @ordered
	 */
	public static final RequirementUsage PROHIBITED_LITERAL = new RequirementUsage(PROHIBITED, "prohibited", "prohibited"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Requirement Usage</b></em>' enumerators.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final RequirementUsage[] VALUES_ARRAY = new RequirementUsage[] {
			REQUIRED_LITERAL,
			OPTIONAL_LITERAL,
			PROHIBITED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Requirement Usage</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Requirement Usage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementUsage get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementUsage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Usage</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RequirementUsage getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementUsage result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Usage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementUsage get(int value) {
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
	private RequirementUsage(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RequirementUsage
