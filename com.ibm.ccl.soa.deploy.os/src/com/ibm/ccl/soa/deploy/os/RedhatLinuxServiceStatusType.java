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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Redhat Linux Service Status Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxServiceStatusType()
 * @model extendedMetaData="name='RedhatLinuxServiceStatusType'"
 * @generated
 */
public final class RedhatLinuxServiceStatusType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Running</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Running</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNNING_LITERAL
	 * @model name="Running"
	 * @generated
	 * @ordered
	 */
	public static final int RUNNING = 0;

	/**
	 * The '<em><b>Stopped</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stopped</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOPPED_LITERAL
	 * @model name="Stopped"
	 * @generated
	 * @ordered
	 */
	public static final int STOPPED = 1;

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model name="Unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 2;

	/**
	 * The '<em><b>Running</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #RUNNING
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStatusType RUNNING_LITERAL = new RedhatLinuxServiceStatusType(
			RUNNING, "Running", "Running"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Stopped</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #STOPPED
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStatusType STOPPED_LITERAL = new RedhatLinuxServiceStatusType(
			STOPPED, "Stopped", "Stopped"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Unknown</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxServiceStatusType UNKNOWN_LITERAL = new RedhatLinuxServiceStatusType(
			UNKNOWN, "Unknown", "Unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Redhat Linux Service Status Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RedhatLinuxServiceStatusType[] VALUES_ARRAY = new RedhatLinuxServiceStatusType[] {
			RUNNING_LITERAL, STOPPED_LITERAL, UNKNOWN_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Redhat Linux Service Status Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redhat Linux Service Status Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxServiceStatusType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxServiceStatusType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Service Status Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxServiceStatusType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxServiceStatusType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Service Status Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxServiceStatusType get(int value) {
		switch (value)
		{
		case RUNNING:
			return RUNNING_LITERAL;
		case STOPPED:
			return STOPPED_LITERAL;
		case UNKNOWN:
			return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private RedhatLinuxServiceStatusType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RedhatLinuxServiceStatusType
