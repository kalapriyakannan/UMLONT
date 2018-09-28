/**
 * <copyright>
 * </copyright>
 *
 * $Id: DuplexType.java,v 1.1 2008/02/01 18:53:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Duplex Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getDuplexType()
 * @model extendedMetaData="name='DuplexType'"
 * @generated
 */
public final class DuplexType extends AbstractEnumerator {
	/**
	 * The '<em><b>Half Duplex</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Half Duplex</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HALF_DUPLEX_LITERAL
	 * @model name="HalfDuplex"
	 * @generated
	 * @ordered
	 */
	public static final int HALF_DUPLEX = 0;

	/**
	 * The '<em><b>Full Duplex</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Full Duplex</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FULL_DUPLEX_LITERAL
	 * @model name="FullDuplex"
	 * @generated
	 * @ordered
	 */
	public static final int FULL_DUPLEX = 1;

	/**
	 * The '<em><b>Half Duplex</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HALF_DUPLEX
	 * @generated
	 * @ordered
	 */
	public static final DuplexType HALF_DUPLEX_LITERAL = new DuplexType(HALF_DUPLEX, "HalfDuplex", "HalfDuplex"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Full Duplex</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULL_DUPLEX
	 * @generated
	 * @ordered
	 */
	public static final DuplexType FULL_DUPLEX_LITERAL = new DuplexType(FULL_DUPLEX, "FullDuplex", "FullDuplex"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Duplex Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DuplexType[] VALUES_ARRAY =
		new DuplexType[] {
			HALF_DUPLEX_LITERAL,
			FULL_DUPLEX_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Duplex Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Duplex Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DuplexType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DuplexType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Duplex Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DuplexType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DuplexType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Duplex Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DuplexType get(int value) {
		switch (value) {
			case HALF_DUPLEX: return HALF_DUPLEX_LITERAL;
			case FULL_DUPLEX: return FULL_DUPLEX_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DuplexType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DuplexType
