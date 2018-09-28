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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Servlet Container Version</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getServletContainerVersion()
 * @model extendedMetaData="name='ServletContainerVersion'"
 * @generated
 */
public final class ServletContainerVersion extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>22</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>22</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.2 <!-- end-model-doc -->
	 * 
	 * @see #_22_LITERAL
	 * @model literal="2.2"
	 * @generated
	 * @ordered
	 */
	public static final int _22 = 0;

	/**
	 * The '<em><b>23</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>23</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.3 <!-- end-model-doc -->
	 * 
	 * @see #_23_LITERAL
	 * @model literal="2.3"
	 * @generated
	 * @ordered
	 */
	public static final int _23 = 1;

	/**
	 * The '<em><b>24</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>24</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.4 <!-- end-model-doc -->
	 * 
	 * @see #_24_LITERAL
	 * @model literal="2.4"
	 * @generated
	 * @ordered
	 */
	public static final int _24 = 2;

	/**
	 * The '<em><b>25</b></em>' literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * J2EE 5.0
	 * <!-- end-model-doc -->
	 * @see #_25_LITERAL
	 * @model literal="2.5"
	 * @generated
	 * @ordered
	 */
	public static final int _25 = 3;

	/**
	 * The '<em><b>22</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_22
	 * @generated
	 * @ordered
	 */
	public static final ServletContainerVersion _22_LITERAL = new ServletContainerVersion(_22,
			"_22", "2.2"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>23</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_23
	 * @generated
	 * @ordered
	 */
	public static final ServletContainerVersion _23_LITERAL = new ServletContainerVersion(_23,
			"_23", "2.3"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>24</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_24
	 * @generated
	 * @ordered
	 */
	public static final ServletContainerVersion _24_LITERAL = new ServletContainerVersion(_24,
			"_24", "2.4"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>25</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_25
	 * @generated
	 * @ordered
	 */
	public static final ServletContainerVersion _25_LITERAL = new ServletContainerVersion(_25,
			"_25", "2.5"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Servlet Container Version</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ServletContainerVersion[] VALUES_ARRAY = new ServletContainerVersion[] {
			_22_LITERAL, _23_LITERAL, _24_LITERAL, _25_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Servlet Container Version</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Servlet Container Version</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ServletContainerVersion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServletContainerVersion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Servlet Container Version</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ServletContainerVersion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServletContainerVersion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Servlet Container Version</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ServletContainerVersion get(int value) {
		switch (value)
		{
		case _22:
			return _22_LITERAL;
		case _23:
			return _23_LITERAL;
		case _24:
			return _24_LITERAL;
		case _25:
			return _25_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private ServletContainerVersion(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ServletContainerVersion
