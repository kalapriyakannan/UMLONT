/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareDiskMode.java,v 1.2 2008/04/04 02:57:18 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>VMware Disk Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareDiskMode()
 * @model extendedMetaData="name='VMwareDiskMode'"
 * @generated
 */
public final class VMwareDiskMode extends AbstractEnumerator {
	/**
	 * The '<em><b>Persistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Persistent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERSISTENT_LITERAL
	 * @model name="persistent"
	 * @generated
	 * @ordered
	 */
	public static final int PERSISTENT = 0;

	/**
	 * The '<em><b>Undoable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undoable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDOABLE_LITERAL
	 * @model name="undoable"
	 * @generated
	 * @ordered
	 */
	public static final int UNDOABLE = 1;

	/**
	 * The '<em><b>Nonpersistent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nonpersistent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONPERSISTENT_LITERAL
	 * @model name="nonpersistent"
	 * @generated
	 * @ordered
	 */
	public static final int NONPERSISTENT = 2;

	/**
	 * The '<em><b>Persistent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final VMwareDiskMode PERSISTENT_LITERAL = new VMwareDiskMode(PERSISTENT, "persistent", "persistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Undoable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDOABLE
	 * @generated
	 * @ordered
	 */
	public static final VMwareDiskMode UNDOABLE_LITERAL = new VMwareDiskMode(UNDOABLE, "undoable", "undoable"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Nonpersistent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONPERSISTENT
	 * @generated
	 * @ordered
	 */
	public static final VMwareDiskMode NONPERSISTENT_LITERAL = new VMwareDiskMode(NONPERSISTENT, "nonpersistent", "nonpersistent"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>VMware Disk Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VMwareDiskMode[] VALUES_ARRAY =
		new VMwareDiskMode[] {
			PERSISTENT_LITERAL,
			UNDOABLE_LITERAL,
			NONPERSISTENT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>VMware Disk Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>VMware Disk Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareDiskMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VMwareDiskMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>VMware Disk Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareDiskMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VMwareDiskMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>VMware Disk Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareDiskMode get(int value) {
		switch (value) {
			case PERSISTENT: return PERSISTENT_LITERAL;
			case UNDOABLE: return UNDOABLE_LITERAL;
			case NONPERSISTENT: return NONPERSISTENT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VMwareDiskMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //VMwareDiskMode
