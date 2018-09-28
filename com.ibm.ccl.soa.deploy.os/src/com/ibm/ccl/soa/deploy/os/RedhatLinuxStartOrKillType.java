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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Redhat Linux Start Or Kill Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxStartOrKillType()
 * @model
 * @generated
 */
public final class RedhatLinuxStartOrKillType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Start</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Start</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #START_LITERAL
	 * @model name="Start"
	 * @generated
	 * @ordered
	 */
	public static final int START = 0;

	/**
	 * The '<em><b>Kill</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kill</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #KILL_LITERAL
	 * @model name="Kill"
	 * @generated
	 * @ordered
	 */
	public static final int KILL = 1;

	/**
	 * The '<em><b>Start</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #START
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxStartOrKillType START_LITERAL = new RedhatLinuxStartOrKillType(
			START, "Start", "Start"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Kill</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #KILL
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxStartOrKillType KILL_LITERAL = new RedhatLinuxStartOrKillType(
			KILL, "Kill", "Kill"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Redhat Linux Start Or Kill Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RedhatLinuxStartOrKillType[] VALUES_ARRAY = new RedhatLinuxStartOrKillType[] {
			START_LITERAL, KILL_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Redhat Linux Start Or Kill Type</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redhat Linux Start Or Kill Type</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RedhatLinuxStartOrKillType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxStartOrKillType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Start Or Kill Type</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RedhatLinuxStartOrKillType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxStartOrKillType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Start Or Kill Type</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RedhatLinuxStartOrKillType get(int value) {
		switch (value)
		{
		case START:
			return START_LITERAL;
		case KILL:
			return KILL_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private RedhatLinuxStartOrKillType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RedhatLinuxStartOrKillType
