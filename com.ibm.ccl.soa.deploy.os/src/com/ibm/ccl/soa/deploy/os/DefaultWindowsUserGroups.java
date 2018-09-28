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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Default Windows User Groups</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getDefaultWindowsUserGroups()
 * @model extendedMetaData="name='DefaultWindowsUserGroups'"
 * @generated
 */
public final class DefaultWindowsUserGroups extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Administrators</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Administrators</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADMINISTRATORS_LITERAL
	 * @model name="Administrators"
	 * @generated
	 * @ordered
	 */
	public static final int ADMINISTRATORS = 0;

	/**
	 * The '<em><b>Backup Operators</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Backup Operators</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BACKUP_OPERATORS_LITERAL
	 * @model name="BackupOperators" literal="Backup Operators"
	 * @generated
	 * @ordered
	 */
	public static final int BACKUP_OPERATORS = 1;

	/**
	 * The '<em><b>Distributed COM Users</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Distributed COM Users</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISTRIBUTED_COM_USERS_LITERAL
	 * @model name="DistributedCOMUsers" literal="Distributed COM Users"
	 * @generated
	 * @ordered
	 */
	public static final int DISTRIBUTED_COM_USERS = 2;

	/**
	 * The '<em><b>Guests</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Guests</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUESTS_LITERAL
	 * @model name="Guests"
	 * @generated
	 * @ordered
	 */
	public static final int GUESTS = 3;

	/**
	 * The '<em><b>Network Configuration Operators</b></em>' literal value.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Network Configuration Operators</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORK_CONFIGURATION_OPERATORS_LITERAL
	 * @model name="NetworkConfigurationOperators" literal="Network Configuration Operators"
	 * @generated
	 * @ordered
	 */
	public static final int NETWORK_CONFIGURATION_OPERATORS = 4;

	/**
	 * The '<em><b>Power Users</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Power Users</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POWER_USERS_LITERAL
	 * @model name="PowerUsers" literal="Power Users"
	 * @generated
	 * @ordered
	 */
	public static final int POWER_USERS = 5;

	/**
	 * The '<em><b>Print Operators</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Print Operators</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRINT_OPERATORS_LITERAL
	 * @model name="PrintOperators" literal="Print Operators"
	 * @generated
	 * @ordered
	 */
	public static final int PRINT_OPERATORS = 6;

	/**
	 * The '<em><b>Remote Desktop Users</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Remote Desktop Users</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOTE_DESKTOP_USERS_LITERAL
	 * @model name="RemoteDesktopUsers" literal="Remote Desktop Users"
	 * @generated
	 * @ordered
	 */
	public static final int REMOTE_DESKTOP_USERS = 7;

	/**
	 * The '<em><b>Replicator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replicator</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLICATOR_LITERAL
	 * @model name="Replicator"
	 * @generated
	 * @ordered
	 */
	public static final int REPLICATOR = 8;

	/**
	 * The '<em><b>Users</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Users</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERS_LITERAL
	 * @model name="Users"
	 * @generated
	 * @ordered
	 */
	public static final int USERS = 9;

	/**
	 * The '<em><b>Administrators</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ADMINISTRATORS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups ADMINISTRATORS_LITERAL = new DefaultWindowsUserGroups(
			ADMINISTRATORS, "Administrators", "Administrators"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Backup Operators</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #BACKUP_OPERATORS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups BACKUP_OPERATORS_LITERAL = new DefaultWindowsUserGroups(
			BACKUP_OPERATORS, "BackupOperators", "Backup Operators"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Distributed COM Users</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DISTRIBUTED_COM_USERS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups DISTRIBUTED_COM_USERS_LITERAL = new DefaultWindowsUserGroups(
			DISTRIBUTED_COM_USERS, "DistributedCOMUsers", "Distributed COM Users"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Guests</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #GUESTS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups GUESTS_LITERAL = new DefaultWindowsUserGroups(
			GUESTS, "Guests", "Guests"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Network Configuration Operators</b></em>' literal object.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #NETWORK_CONFIGURATION_OPERATORS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups NETWORK_CONFIGURATION_OPERATORS_LITERAL = new DefaultWindowsUserGroups(
			NETWORK_CONFIGURATION_OPERATORS,
			"NetworkConfigurationOperators", "Network Configuration Operators"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Power Users</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #POWER_USERS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups POWER_USERS_LITERAL = new DefaultWindowsUserGroups(
			POWER_USERS, "PowerUsers", "Power Users"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Print Operators</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #PRINT_OPERATORS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups PRINT_OPERATORS_LITERAL = new DefaultWindowsUserGroups(
			PRINT_OPERATORS, "PrintOperators", "Print Operators"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Remote Desktop Users</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #REMOTE_DESKTOP_USERS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups REMOTE_DESKTOP_USERS_LITERAL = new DefaultWindowsUserGroups(
			REMOTE_DESKTOP_USERS, "RemoteDesktopUsers", "Remote Desktop Users"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Replicator</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #REPLICATOR
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups REPLICATOR_LITERAL = new DefaultWindowsUserGroups(
			REPLICATOR, "Replicator", "Replicator"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Users</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #USERS
	 * @generated
	 * @ordered
	 */
	public static final DefaultWindowsUserGroups USERS_LITERAL = new DefaultWindowsUserGroups(USERS,
			"Users", "Users"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Default Windows User Groups</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DefaultWindowsUserGroups[] VALUES_ARRAY = new DefaultWindowsUserGroups[] {
			ADMINISTRATORS_LITERAL, BACKUP_OPERATORS_LITERAL, DISTRIBUTED_COM_USERS_LITERAL,
			GUESTS_LITERAL, NETWORK_CONFIGURATION_OPERATORS_LITERAL, POWER_USERS_LITERAL,
			PRINT_OPERATORS_LITERAL, REMOTE_DESKTOP_USERS_LITERAL, REPLICATOR_LITERAL, USERS_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Default Windows User Groups</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Default Windows User Groups</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DefaultWindowsUserGroups get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DefaultWindowsUserGroups result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Default Windows User Groups</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DefaultWindowsUserGroups getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DefaultWindowsUserGroups result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Default Windows User Groups</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DefaultWindowsUserGroups get(int value) {
		switch (value)
		{
		case ADMINISTRATORS:
			return ADMINISTRATORS_LITERAL;
		case BACKUP_OPERATORS:
			return BACKUP_OPERATORS_LITERAL;
		case DISTRIBUTED_COM_USERS:
			return DISTRIBUTED_COM_USERS_LITERAL;
		case GUESTS:
			return GUESTS_LITERAL;
		case NETWORK_CONFIGURATION_OPERATORS:
			return NETWORK_CONFIGURATION_OPERATORS_LITERAL;
		case POWER_USERS:
			return POWER_USERS_LITERAL;
		case PRINT_OPERATORS:
			return PRINT_OPERATORS_LITERAL;
		case REMOTE_DESKTOP_USERS:
			return REMOTE_DESKTOP_USERS_LITERAL;
		case REPLICATOR:
			return REPLICATOR_LITERAL;
		case USERS:
			return USERS_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private DefaultWindowsUserGroups(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DefaultWindowsUserGroups
