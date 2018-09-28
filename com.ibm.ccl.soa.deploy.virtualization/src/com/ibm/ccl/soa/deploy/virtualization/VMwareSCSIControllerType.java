/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareSCSIControllerType.java,v 1.2 2008/04/04 02:57:18 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>VMware SCSI Controller Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareSCSIControllerType()
 * @model extendedMetaData="name='VMwareSCSIControllerType'"
 * @generated
 */
public final class VMwareSCSIControllerType extends AbstractEnumerator {
	/**
	 * The '<em><b>Buslogic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Buslogic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUSLOGIC_LITERAL
	 * @model name="buslogic"
	 * @generated
	 * @ordered
	 */
	public static final int BUSLOGIC = 0;

	/**
	 * The '<em><b>Lsilogic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lsilogic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LSILOGIC_LITERAL
	 * @model name="lsilogic"
	 * @generated
	 * @ordered
	 */
	public static final int LSILOGIC = 1;

	/**
	 * The '<em><b>Buslogic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUSLOGIC
	 * @generated
	 * @ordered
	 */
	public static final VMwareSCSIControllerType BUSLOGIC_LITERAL = new VMwareSCSIControllerType(BUSLOGIC, "buslogic", "buslogic"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Lsilogic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LSILOGIC
	 * @generated
	 * @ordered
	 */
	public static final VMwareSCSIControllerType LSILOGIC_LITERAL = new VMwareSCSIControllerType(LSILOGIC, "lsilogic", "lsilogic"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>VMware SCSI Controller Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VMwareSCSIControllerType[] VALUES_ARRAY =
		new VMwareSCSIControllerType[] {
			BUSLOGIC_LITERAL,
			LSILOGIC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>VMware SCSI Controller Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>VMware SCSI Controller Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareSCSIControllerType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VMwareSCSIControllerType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>VMware SCSI Controller Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareSCSIControllerType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VMwareSCSIControllerType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>VMware SCSI Controller Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareSCSIControllerType get(int value) {
		switch (value) {
			case BUSLOGIC: return BUSLOGIC_LITERAL;
			case LSILOGIC: return LSILOGIC_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VMwareSCSIControllerType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //VMwareSCSIControllerType
