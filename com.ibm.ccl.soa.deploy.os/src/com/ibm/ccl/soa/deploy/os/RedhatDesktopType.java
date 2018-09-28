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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Redhat Desktop Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatDesktopType()
 * @model extendedMetaData="name='RedhatDesktopType'"
 * @generated
 */
public final class RedhatDesktopType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>GNOME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GNOME</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GNOME_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GNOME = 0;

	/**
	 * The '<em><b>KDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KDE</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KDE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KDE = 1;

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 2;

	/**
	 * The '<em><b>GNOME</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #GNOME
	 * @generated
	 * @ordered
	 */
	public static final RedhatDesktopType GNOME_LITERAL = new RedhatDesktopType(GNOME,
			"GNOME", "GNOME"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>KDE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #KDE
	 * @generated
	 * @ordered
	 */
	public static final RedhatDesktopType KDE_LITERAL = new RedhatDesktopType(KDE, "KDE", "KDE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final RedhatDesktopType NONE_LITERAL = new RedhatDesktopType(NONE, "NONE", "NONE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Redhat Desktop Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RedhatDesktopType[] VALUES_ARRAY = new RedhatDesktopType[] { GNOME_LITERAL,
			KDE_LITERAL, NONE_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Redhat Desktop Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redhat Desktop Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatDesktopType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatDesktopType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Desktop Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RedhatDesktopType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatDesktopType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Desktop Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatDesktopType get(int value) {
		switch (value)
		{
		case GNOME:
			return GNOME_LITERAL;
		case KDE:
			return KDE_LITERAL;
		case NONE:
			return NONE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private RedhatDesktopType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RedhatDesktopType
