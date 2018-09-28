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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>JSP Container Version</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getJSPContainerVersion()
 * @model extendedMetaData="name='JSPContainerVersion'"
 * @generated
 */
public final class JSPContainerVersion extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>11</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>11</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.2 <!-- end-model-doc -->
	 * 
	 * @see #_11_LITERAL
	 * @model literal="1.1"
	 * @generated
	 * @ordered
	 */
	public static final int _11 = 0;

	/**
	 * The '<em><b>12</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>12</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.3 <!-- end-model-doc -->
	 * 
	 * @see #_12_LITERAL
	 * @model literal="1.2"
	 * @generated
	 * @ordered
	 */
	public static final int _12 = 1;

	/**
	 * The '<em><b>20</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>20</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> J2EE 1.4 <!-- end-model-doc -->
	 * 
	 * @see #_20_LITERAL
	 * @model literal="2.0"
	 * @generated
	 * @ordered
	 */
	public static final int _20 = 2;

	/**
	 * The '<em><b>21</b></em>' literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * J2EE 5.0
	 * <!-- end-model-doc -->
	 * @see #_21_LITERAL
	 * @model literal="2.1"
	 * @generated
	 * @ordered
	 */
	public static final int _21 = 3;

	/**
	 * The '<em><b>11</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_11
	 * @generated
	 * @ordered
	 */
	public static final JSPContainerVersion _11_LITERAL = new JSPContainerVersion(_11, "_11", "1.1"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>12</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_12
	 * @generated
	 * @ordered
	 */
	public static final JSPContainerVersion _12_LITERAL = new JSPContainerVersion(_12, "_12", "1.2"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>20</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_20
	 * @generated
	 * @ordered
	 */
	public static final JSPContainerVersion _20_LITERAL = new JSPContainerVersion(_20, "_20", "2.0"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>21</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_21
	 * @generated
	 * @ordered
	 */
	public static final JSPContainerVersion _21_LITERAL = new JSPContainerVersion(_21, "_21", "2.1"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>JSP Container Version</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final JSPContainerVersion[] VALUES_ARRAY = new JSPContainerVersion[] {
			_11_LITERAL, _12_LITERAL, _20_LITERAL, _21_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>JSP Container Version</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>JSP Container Version</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JSPContainerVersion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JSPContainerVersion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JSP Container Version</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static JSPContainerVersion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JSPContainerVersion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JSP Container Version</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static JSPContainerVersion get(int value) {
		switch (value)
		{
		case _11:
			return _11_LITERAL;
		case _12:
			return _12_LITERAL;
		case _20:
			return _20_LITERAL;
		case _21:
			return _21_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private JSPContainerVersion(int value, String name, String literal) {
		super(value, name, literal);
	}

} //JSPContainerVersion
