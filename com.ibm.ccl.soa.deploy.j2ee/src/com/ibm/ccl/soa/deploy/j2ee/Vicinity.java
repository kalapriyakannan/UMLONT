/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Vicinity</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getVicinity()
 * @model extendedMetaData="name='Vicinity'"
 * @generated
 */
public final class Vicinity extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Local</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL_LITERAL
	 * @model name="local"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL = 0;

	/**
	 * The '<em><b>Remote</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Remote</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOTE_LITERAL
	 * @model name="remote"
	 * @generated
	 * @ordered
	 */
	public static final int REMOTE = 1;

	/**
	 * The '<em><b>Local</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #LOCAL
	 * @generated
	 * @ordered
	 */
	public static final Vicinity LOCAL_LITERAL = new Vicinity(LOCAL, "local", "local"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Remote</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #REMOTE
	 * @generated
	 * @ordered
	 */
	public static final Vicinity REMOTE_LITERAL = new Vicinity(REMOTE, "remote", "remote"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Vicinity</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final Vicinity[] VALUES_ARRAY = new Vicinity[] { LOCAL_LITERAL, REMOTE_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Vicinity</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Vicinity</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Vicinity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Vicinity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Vicinity</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Vicinity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Vicinity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Vicinity</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Vicinity get(int value) {
		switch (value)
		{
		case LOCAL:
			return LOCAL_LITERAL;
		case REMOTE:
			return REMOTE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private Vicinity(int value, String name, String literal) {
		super(value, name, literal);
	}

} //Vicinity
