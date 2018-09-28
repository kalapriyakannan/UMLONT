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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Requirement Link Types</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The type of links supported by this {@link Requirement}.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirementLinkTypes()
 * @model
 * @generated
 */
public final class RequirementLinkTypes extends AbstractEnumerator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7486490198708045990L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Hosting</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hosting</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOSTING_LITERAL
	 * @model name="hosting"
	 * @generated
	 * @ordered
	 */
	public static final int HOSTING = 0;

	/**
	 * The '<em><b>Dependency</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Dependency</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEPENDENCY_LITERAL
	 * @model name="dependency"
	 * @generated
	 * @ordered
	 */
	public static final int DEPENDENCY = 1;

	/**
	 * The '<em><b>Member</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Member</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMBER_LITERAL
	 * @model name="member"
	 * @generated
	 * @ordered
	 */
	public static final int MEMBER = 2;

	/**
	 * The '<em><b>Any</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Any</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANY_LITERAL
	 * @model name="any"
	 * @generated
	 * @ordered
	 */
	public static final int ANY = 3;

	/**
	 * The '<em><b>Hosting</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #HOSTING
	 * @generated
	 * @ordered
	 */
	public static final RequirementLinkTypes HOSTING_LITERAL = new RequirementLinkTypes(HOSTING, "hosting", "hosting"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Dependency</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DEPENDENCY
	 * @generated
	 * @ordered
	 */
	public static final RequirementLinkTypes DEPENDENCY_LITERAL = new RequirementLinkTypes(DEPENDENCY, "dependency", "dependency"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Member</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MEMBER
	 * @generated
	 * @ordered
	 */
	public static final RequirementLinkTypes MEMBER_LITERAL = new RequirementLinkTypes(MEMBER, "member", "member"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Any</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #ANY
	 * @generated
	 * @ordered
	 */
	public static final RequirementLinkTypes ANY_LITERAL = new RequirementLinkTypes(ANY, "any", "any"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Requirement Link Types</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RequirementLinkTypes[] VALUES_ARRAY = new RequirementLinkTypes[] {
			HOSTING_LITERAL,
			DEPENDENCY_LITERAL,
			MEMBER_LITERAL,
			ANY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Requirement Link Types</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Requirement Link Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementLinkTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementLinkTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Link Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementLinkTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RequirementLinkTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Requirement Link Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementLinkTypes get(int value) {
		switch (value) {
			case HOSTING: return HOSTING_LITERAL;
			case DEPENDENCY: return DEPENDENCY_LITERAL;
			case MEMBER: return MEMBER_LITERAL;
			case ANY: return ANY_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private RequirementLinkTypes(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RequirementLinkTypes
