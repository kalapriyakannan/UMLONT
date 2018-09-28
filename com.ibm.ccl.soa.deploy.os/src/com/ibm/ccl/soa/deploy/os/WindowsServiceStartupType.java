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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Windows Service Startup Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getWindowsServiceStartupType()
 * @model extendedMetaData="name='WindowsServiceStartupType'"
 * @generated
 */
public final class WindowsServiceStartupType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Boot</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boot</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOT_LITERAL
	 * @model name="Boot"
	 * @generated
	 * @ordered
	 */
	public static final int BOOT = 0;

	/**
	 * The '<em><b>System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>System</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_LITERAL
	 * @model name="System"
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM = 1;

	/**
	 * The '<em><b>Automatic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Automatic</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTOMATIC_LITERAL
	 * @model name="Automatic"
	 * @generated
	 * @ordered
	 */
	public static final int AUTOMATIC = 2;

	/**
	 * The '<em><b>Manual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Manual</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANUAL_LITERAL
	 * @model name="Manual"
	 * @generated
	 * @ordered
	 */
	public static final int MANUAL = 3;

	/**
	 * The '<em><b>Disabled</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disabled</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISABLED_LITERAL
	 * @model name="Disabled"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLED = 4;

	/**
	 * The '<em><b>Boot</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BOOT
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceStartupType BOOT_LITERAL = new WindowsServiceStartupType(BOOT,
			"Boot", "Boot"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>System</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SYSTEM
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceStartupType SYSTEM_LITERAL = new WindowsServiceStartupType(
			SYSTEM, "System", "System"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Automatic</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #AUTOMATIC
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceStartupType AUTOMATIC_LITERAL = new WindowsServiceStartupType(
			AUTOMATIC, "Automatic", "Automatic"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Manual</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #MANUAL
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceStartupType MANUAL_LITERAL = new WindowsServiceStartupType(
			MANUAL, "Manual", "Manual"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Disabled</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DISABLED
	 * @generated
	 * @ordered
	 */
	public static final WindowsServiceStartupType DISABLED_LITERAL = new WindowsServiceStartupType(
			DISABLED, "Disabled", "Disabled"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Windows Service Startup Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final WindowsServiceStartupType[] VALUES_ARRAY = new WindowsServiceStartupType[] {
			BOOT_LITERAL, SYSTEM_LITERAL, AUTOMATIC_LITERAL, MANUAL_LITERAL, DISABLED_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Windows Service Startup Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Windows Service Startup Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WindowsServiceStartupType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindowsServiceStartupType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Windows Service Startup Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WindowsServiceStartupType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WindowsServiceStartupType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Windows Service Startup Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WindowsServiceStartupType get(int value) {
		switch (value)
		{
		case BOOT:
			return BOOT_LITERAL;
		case SYSTEM:
			return SYSTEM_LITERAL;
		case AUTOMATIC:
			return AUTOMATIC_LITERAL;
		case MANUAL:
			return MANUAL_LITERAL;
		case DISABLED:
			return DISABLED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WindowsServiceStartupType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WindowsServiceStartupType
