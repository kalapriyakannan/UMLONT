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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Redhat Linux Boot Loader Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxBootLoaderType()
 * @model extendedMetaData="name='RedhatLinuxBootLoaderType'"
 * @generated
 */
public final class RedhatLinuxBootLoaderType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>GRUB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRUB</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRUB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRUB = 0;

	/**
	 * The '<em><b>LILO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LILO</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LILO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LILO = 1;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER_LITERAL
	 * @model name="Other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER = 2;

	/**
	 * The '<em><b>GRUB</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #GRUB
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxBootLoaderType GRUB_LITERAL = new RedhatLinuxBootLoaderType(GRUB,
			"GRUB", "GRUB"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>LILO</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #LILO
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxBootLoaderType LILO_LITERAL = new RedhatLinuxBootLoaderType(LILO,
			"LILO", "LILO"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OTHER
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxBootLoaderType OTHER_LITERAL = new RedhatLinuxBootLoaderType(
			OTHER, "Other", "Other"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Redhat Linux Boot Loader Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RedhatLinuxBootLoaderType[] VALUES_ARRAY = new RedhatLinuxBootLoaderType[] {
			GRUB_LITERAL, LILO_LITERAL, OTHER_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Redhat Linux Boot Loader Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redhat Linux Boot Loader Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxBootLoaderType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxBootLoaderType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Boot Loader Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxBootLoaderType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxBootLoaderType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Boot Loader Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxBootLoaderType get(int value) {
		switch (value)
		{
		case GRUB:
			return GRUB_LITERAL;
		case LILO:
			return LILO_LITERAL;
		case OTHER:
			return OTHER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private RedhatLinuxBootLoaderType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RedhatLinuxBootLoaderType
