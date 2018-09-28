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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Redhat Linux Product Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getRedhatLinuxProductTypeType()
 * @model extendedMetaData="name='RedhatLinuxProductTypeType'"
 * @generated
 */
public final class RedhatLinuxProductTypeType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Server</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Server</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVER_LITERAL
	 * @model name="Server"
	 * @generated
	 * @ordered
	 */
	public static final int SERVER = 0;

	/**
	 * The '<em><b>Personal Desktop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Personal Desktop</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERSONAL_DESKTOP_LITERAL
	 * @model name="PersonalDesktop" literal="Personal Desktop"
	 * @generated
	 * @ordered
	 */
	public static final int PERSONAL_DESKTOP = 1;

	/**
	 * The '<em><b>Work Station</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Work Station</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WORK_STATION_LITERAL
	 * @model name="WorkStation" literal="Work Station"
	 * @generated
	 * @ordered
	 */
	public static final int WORK_STATION = 2;

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
	public static final int OTHER = 3;

	/**
	 * The '<em><b>Server</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SERVER
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxProductTypeType SERVER_LITERAL = new RedhatLinuxProductTypeType(
			SERVER, "Server", "Server"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Personal Desktop</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PERSONAL_DESKTOP
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxProductTypeType PERSONAL_DESKTOP_LITERAL = new RedhatLinuxProductTypeType(
			PERSONAL_DESKTOP, "PersonalDesktop", "Personal Desktop"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Work Station</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WORK_STATION
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxProductTypeType WORK_STATION_LITERAL = new RedhatLinuxProductTypeType(
			WORK_STATION, "WorkStation", "Work Station"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OTHER
	 * @generated
	 * @ordered
	 */
	public static final RedhatLinuxProductTypeType OTHER_LITERAL = new RedhatLinuxProductTypeType(
			OTHER, "Other", "Other"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Redhat Linux Product Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final RedhatLinuxProductTypeType[] VALUES_ARRAY = new RedhatLinuxProductTypeType[] {
			SERVER_LITERAL, PERSONAL_DESKTOP_LITERAL, WORK_STATION_LITERAL, OTHER_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Redhat Linux Product Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Redhat Linux Product Type Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxProductTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxProductTypeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Product Type Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxProductTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RedhatLinuxProductTypeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Redhat Linux Product Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static RedhatLinuxProductTypeType get(int value) {
		switch (value)
		{
		case SERVER:
			return SERVER_LITERAL;
		case PERSONAL_DESKTOP:
			return PERSONAL_DESKTOP_LITERAL;
		case WORK_STATION:
			return WORK_STATION_LITERAL;
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
	private RedhatLinuxProductTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //RedhatLinuxProductTypeType
