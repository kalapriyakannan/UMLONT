/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>AIX User Registering Method Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getAIXUserRegisteringMethodType()
 * @model extendedMetaData="name='AIXUserRegisteringMethodType'"
 * @generated
 */
public final class AIXUserRegisteringMethodType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Files</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Files</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILES_LITERAL
	 * @model name="files"
	 * @generated
	 * @ordered
	 */
	public static final int FILES = 0;

	/**
	 * The '<em><b>NIS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NIS</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NIS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NIS = 1;

	/**
	 * The '<em><b>DCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DCE</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DCE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DCE = 2;

	/**
	 * The '<em><b>Files</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #FILES
	 * @generated
	 * @ordered
	 */
	public static final AIXUserRegisteringMethodType FILES_LITERAL = new AIXUserRegisteringMethodType(
			FILES, "files", "files"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>NIS</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NIS
	 * @generated
	 * @ordered
	 */
	public static final AIXUserRegisteringMethodType NIS_LITERAL = new AIXUserRegisteringMethodType(
			NIS, "NIS", "NIS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DCE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #DCE
	 * @generated
	 * @ordered
	 */
	public static final AIXUserRegisteringMethodType DCE_LITERAL = new AIXUserRegisteringMethodType(
			DCE, "DCE", "DCE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>AIX User Registering Method Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final AIXUserRegisteringMethodType[] VALUES_ARRAY = new AIXUserRegisteringMethodType[] {
			FILES_LITERAL, NIS_LITERAL, DCE_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>AIX User Registering Method Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>AIX User Registering Method Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AIXUserRegisteringMethodType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AIXUserRegisteringMethodType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>AIX User Registering Method Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AIXUserRegisteringMethodType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AIXUserRegisteringMethodType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>AIX User Registering Method Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AIXUserRegisteringMethodType get(int value) {
		switch (value)
		{
		case FILES:
			return FILES_LITERAL;
		case NIS:
			return NIS_LITERAL;
		case DCE:
			return DCE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private AIXUserRegisteringMethodType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AIXUserRegisteringMethodType
