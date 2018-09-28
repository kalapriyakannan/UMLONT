/**
 * <copyright>
 * </copyright>
 *
 * $Id: DesiredSnapshotStateType.java,v 1.1 2008/04/24 02:17:02 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Desired Snapshot State Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getDesiredSnapshotStateType()
 * @model extendedMetaData="name='DesiredSnapshotStateType'"
 * @generated
 */
public final class DesiredSnapshotStateType extends AbstractEnumerator {
	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * No change to snapshot state necessary
	 * <!-- end-model-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model name="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 0;

	/**
	 * The '<em><b>Active</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Snapshot active
	 * <!-- end-model-doc -->
	 * @see #ACTIVE_LITERAL
	 * @model name="active"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE = 1;

	/**
	 * The '<em><b>Revert</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Virtual machine should be reverted to this snapshot
	 * <!-- end-model-doc -->
	 * @see #REVERT_LITERAL
	 * @model name="revert"
	 * @generated
	 * @ordered
	 */
	public static final int REVERT = 2;

	/**
	 * The '<em><b>Unknown</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final DesiredSnapshotStateType UNKNOWN_LITERAL = new DesiredSnapshotStateType(UNKNOWN, "unknown", "unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Active</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @generated
	 * @ordered
	 */
	public static final DesiredSnapshotStateType ACTIVE_LITERAL = new DesiredSnapshotStateType(ACTIVE, "active", "active"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Revert</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVERT
	 * @generated
	 * @ordered
	 */
	public static final DesiredSnapshotStateType REVERT_LITERAL = new DesiredSnapshotStateType(REVERT, "revert", "revert"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Desired Snapshot State Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DesiredSnapshotStateType[] VALUES_ARRAY =
		new DesiredSnapshotStateType[] {
			UNKNOWN_LITERAL,
			ACTIVE_LITERAL,
			REVERT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Desired Snapshot State Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Desired Snapshot State Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DesiredSnapshotStateType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DesiredSnapshotStateType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Desired Snapshot State Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DesiredSnapshotStateType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DesiredSnapshotStateType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Desired Snapshot State Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DesiredSnapshotStateType get(int value) {
		switch (value) {
			case UNKNOWN: return UNKNOWN_LITERAL;
			case ACTIVE: return ACTIVE_LITERAL;
			case REVERT: return REVERT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DesiredSnapshotStateType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DesiredSnapshotStateType
