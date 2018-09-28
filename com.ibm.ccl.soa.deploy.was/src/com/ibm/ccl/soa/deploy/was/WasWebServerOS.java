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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Web Server OS</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasWebServerOS()
 * @model
 * @generated
 */
public final class WasWebServerOS extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>WINDOWS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WINDOWS</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WINDOWS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WINDOWS = 0;

	/**
	 * The '<em><b>SOLARIS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLARIS</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLARIS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOLARIS = 1;

	/**
	 * The '<em><b>AIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIX</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIX = 2;

	/**
	 * The '<em><b>HPUX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HPUX</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HPUX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HPUX = 3;

	/**
	 * The '<em><b>LINUX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINUX</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINUX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINUX = 4;

	/**
	 * The '<em><b>OS400</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OS400</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OS400_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OS400 = 5;

	/**
	 * The '<em><b>OS390</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OS390</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OS390_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OS390 = 6;

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
	public static final int UNKNOWN = 7;

	/**
	 * The '<em><b>WINDOWS</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #WINDOWS
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS WINDOWS_LITERAL = new WasWebServerOS(WINDOWS, "WINDOWS", "WINDOWS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SOLARIS</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SOLARIS
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS SOLARIS_LITERAL = new WasWebServerOS(SOLARIS, "SOLARIS", "SOLARIS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>AIX</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #AIX
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS AIX_LITERAL = new WasWebServerOS(AIX, "AIX", "AIX"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>HPUX</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #HPUX
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS HPUX_LITERAL = new WasWebServerOS(HPUX, "HPUX", "HPUX"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>LINUX</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #LINUX
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS LINUX_LITERAL = new WasWebServerOS(LINUX, "LINUX", "LINUX"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>OS400</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OS400
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS OS400_LITERAL = new WasWebServerOS(OS400, "OS400", "OS400"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>OS390</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OS390
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS OS390_LITERAL = new WasWebServerOS(OS390, "OS390", "OS390"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Unknown</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final WasWebServerOS UNKNOWN_LITERAL = new WasWebServerOS(UNKNOWN, "Unknown", "Unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Web Server OS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final WasWebServerOS[] VALUES_ARRAY = new WasWebServerOS[] {
			WINDOWS_LITERAL,
			SOLARIS_LITERAL,
			AIX_LITERAL,
			HPUX_LITERAL,
			LINUX_LITERAL,
			OS400_LITERAL,
			OS390_LITERAL,
			UNKNOWN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Web Server OS</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Web Server OS</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasWebServerOS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasWebServerOS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Server OS</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WasWebServerOS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			WasWebServerOS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Web Server OS</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WasWebServerOS get(int value) {
		switch (value) {
			case WINDOWS: return WINDOWS_LITERAL;
			case SOLARIS: return SOLARIS_LITERAL;
			case AIX: return AIX_LITERAL;
			case HPUX: return HPUX_LITERAL;
			case LINUX: return LINUX_LITERAL;
			case OS400: return OS400_LITERAL;
			case OS390: return OS390_LITERAL;
			case UNKNOWN: return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private WasWebServerOS(int value, String name, String literal) {
		super(value, name, literal);
	}

} //WasWebServerOS
