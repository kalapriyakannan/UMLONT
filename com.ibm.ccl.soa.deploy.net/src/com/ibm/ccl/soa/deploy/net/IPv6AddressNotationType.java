/**
 * <copyright>
 * </copyright>
 *
 * $Id: IPv6AddressNotationType.java,v 1.1 2008/02/04 02:43:44 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>IPv6 Address Notation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIPv6AddressNotationType()
 * @model extendedMetaData="name='IPv6AddressNotationType'"
 * @generated
 */
public final class IPv6AddressNotationType extends AbstractEnumerator {
	/**
	 * The '<em><b>IPv6 Colon Notation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 						e.g. "2001:0db8:0000:0000:0000:0000:1428:57ab" or "2001:db8::1428:57ab"
	 * 					
	 * <!-- end-model-doc -->
	 * @see #IPV6_COLON_NOTATION_LITERAL
	 * @model name="IPv6ColonNotation"
	 * @generated
	 * @ordered
	 */
	public static final int IPV6_COLON_NOTATION = 0;

	/**
	 * The '<em><b>IPv6 Mixed Notation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "E3D7::51F4:9BC8:192.168.100.32"
	 * <!-- end-model-doc -->
	 * @see #IPV6_MIXED_NOTATION_LITERAL
	 * @model name="IPv6MixedNotation"
	 * @generated
	 * @ordered
	 */
	public static final int IPV6_MIXED_NOTATION = 1;

	/**
	 * The '<em><b>IPv6 Colon Notation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IPV6_COLON_NOTATION
	 * @generated
	 * @ordered
	 */
	public static final IPv6AddressNotationType IPV6_COLON_NOTATION_LITERAL = new IPv6AddressNotationType(IPV6_COLON_NOTATION, "IPv6ColonNotation", "IPv6ColonNotation"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>IPv6 Mixed Notation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IPV6_MIXED_NOTATION
	 * @generated
	 * @ordered
	 */
	public static final IPv6AddressNotationType IPV6_MIXED_NOTATION_LITERAL = new IPv6AddressNotationType(IPV6_MIXED_NOTATION, "IPv6MixedNotation", "IPv6MixedNotation"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>IPv6 Address Notation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IPv6AddressNotationType[] VALUES_ARRAY =
		new IPv6AddressNotationType[] {
			IPV6_COLON_NOTATION_LITERAL,
			IPV6_MIXED_NOTATION_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>IPv6 Address Notation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>IPv6 Address Notation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IPv6AddressNotationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IPv6AddressNotationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>IPv6 Address Notation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IPv6AddressNotationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IPv6AddressNotationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>IPv6 Address Notation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IPv6AddressNotationType get(int value) {
		switch (value) {
			case IPV6_COLON_NOTATION: return IPV6_COLON_NOTATION_LITERAL;
			case IPV6_MIXED_NOTATION: return IPV6_MIXED_NOTATION_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IPv6AddressNotationType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //IPv6AddressNotationType
