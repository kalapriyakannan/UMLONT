/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>CF Target Significance Enum</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getCFTargetSignificanceEnum()
 * @model extendedMetaData="name='CFTargetSignificanceEnum'"
 * @generated
 */
public final class CFTargetSignificanceEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Preferred</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Preferred</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREFERRED_LITERAL
	 * @model name="Preferred"
	 * @generated
	 * @ordered
	 */
	public static final int PREFERRED = 0;

	/**
	 * The '<em><b>Required</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Required</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUIRED_LITERAL
	 * @model name="Required"
	 * @generated
	 * @ordered
	 */
	public static final int REQUIRED = 1;

	/**
	 * The '<em><b>Preferred</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #PREFERRED
	 * @generated
	 * @ordered
	 */
	public static final CFTargetSignificanceEnum PREFERRED_LITERAL = new CFTargetSignificanceEnum(PREFERRED, "Preferred", "Preferred"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Required</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #REQUIRED
	 * @generated
	 * @ordered
	 */
	public static final CFTargetSignificanceEnum REQUIRED_LITERAL = new CFTargetSignificanceEnum(REQUIRED, "Required", "Required"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>CF Target Significance Enum</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final CFTargetSignificanceEnum[] VALUES_ARRAY = new CFTargetSignificanceEnum[] {
			PREFERRED_LITERAL,
			REQUIRED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>CF Target Significance Enum</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>CF Target Significance Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CFTargetSignificanceEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CFTargetSignificanceEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CF Target Significance Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CFTargetSignificanceEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CFTargetSignificanceEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>CF Target Significance Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CFTargetSignificanceEnum get(int value) {
		switch (value) {
			case PREFERRED: return PREFERRED_LITERAL;
			case REQUIRED: return REQUIRED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private CFTargetSignificanceEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CFTargetSignificanceEnum
