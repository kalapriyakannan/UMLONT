/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>JRE Edition</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJREEdition()
 * @model extendedMetaData="name='JREEdition'"
 * @generated
 */
public final class JREEdition extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Standard</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Standard</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STANDARD_LITERAL
	 * @model name="standard"
	 * @generated
	 * @ordered
	 */
	public static final int STANDARD = 0;

	/**
	 * The '<em><b>Enterprise</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enterprise</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENTERPRISE_LITERAL
	 * @model name="enterprise"
	 * @generated
	 * @ordered
	 */
	public static final int ENTERPRISE = 1;

	/**
	 * The '<em><b>Micro</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Micro</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICRO_LITERAL
	 * @model name="micro"
	 * @generated
	 * @ordered
	 */
	public static final int MICRO = 2;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER_LITERAL
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER = 3;

	/**
	 * The '<em><b>Standard</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #STANDARD
	 * @generated
	 * @ordered
	 */
	public static final JREEdition STANDARD_LITERAL = new JREEdition(STANDARD, "standard", "standard"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Enterprise</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ENTERPRISE
	 * @generated
	 * @ordered
	 */
	public static final JREEdition ENTERPRISE_LITERAL = new JREEdition(ENTERPRISE, "enterprise", "enterprise"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Micro</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #MICRO
	 * @generated
	 * @ordered
	 */
	public static final JREEdition MICRO_LITERAL = new JREEdition(MICRO, "micro", "micro"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OTHER
	 * @generated
	 * @ordered
	 */
	public static final JREEdition OTHER_LITERAL = new JREEdition(OTHER, "other", "other"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>JRE Edition</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JREEdition[] VALUES_ARRAY = new JREEdition[] {
			STANDARD_LITERAL,
			ENTERPRISE_LITERAL,
			MICRO_LITERAL,
			OTHER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>JRE Edition</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>JRE Edition</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JREEdition get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JREEdition result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JRE Edition</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JREEdition getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JREEdition result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JRE Edition</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JREEdition get(int value) {
		switch (value) {
			case STANDARD: return STANDARD_LITERAL;
			case ENTERPRISE: return ENTERPRISE_LITERAL;
			case MICRO: return MICRO_LITERAL;
			case OTHER: return OTHER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private JREEdition(int value, String name, String literal) {
		super(value, name, literal);
	}

} //JREEdition
