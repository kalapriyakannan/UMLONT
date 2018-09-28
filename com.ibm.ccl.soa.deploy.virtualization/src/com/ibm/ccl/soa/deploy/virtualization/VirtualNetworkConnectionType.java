/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualNetworkConnectionType.java,v 1.2 2008/04/04 02:57:18 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Virtual Network Connection Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualNetworkConnectionType()
 * @model extendedMetaData="name='VirtualNetworkConnectionType'"
 * @generated
 */
public final class VirtualNetworkConnectionType extends AbstractEnumerator {
	/**
	 * The '<em><b>Bridged</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bridged</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRIDGED_LITERAL
	 * @model name="bridged"
	 * @generated
	 * @ordered
	 */
	public static final int BRIDGED = 0;

	/**
	 * The '<em><b>Nat</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nat</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAT_LITERAL
	 * @model name="nat"
	 * @generated
	 * @ordered
	 */
	public static final int NAT = 1;

	/**
	 * The '<em><b>Host Only</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Host Only</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOST_ONLY_LITERAL
	 * @model name="hostOnly" literal="host-only"
	 * @generated
	 * @ordered
	 */
	public static final int HOST_ONLY = 2;

	/**
	 * The '<em><b>Custom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Custom</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_LITERAL
	 * @model name="custom"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM = 3;

	/**
	 * The '<em><b>Bridged</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRIDGED
	 * @generated
	 * @ordered
	 */
	public static final VirtualNetworkConnectionType BRIDGED_LITERAL = new VirtualNetworkConnectionType(BRIDGED, "bridged", "bridged"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Nat</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAT
	 * @generated
	 * @ordered
	 */
	public static final VirtualNetworkConnectionType NAT_LITERAL = new VirtualNetworkConnectionType(NAT, "nat", "nat"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Host Only</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOST_ONLY
	 * @generated
	 * @ordered
	 */
	public static final VirtualNetworkConnectionType HOST_ONLY_LITERAL = new VirtualNetworkConnectionType(HOST_ONLY, "hostOnly", "host-only"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Custom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM
	 * @generated
	 * @ordered
	 */
	public static final VirtualNetworkConnectionType CUSTOM_LITERAL = new VirtualNetworkConnectionType(CUSTOM, "custom", "custom"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Virtual Network Connection Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VirtualNetworkConnectionType[] VALUES_ARRAY =
		new VirtualNetworkConnectionType[] {
			BRIDGED_LITERAL,
			NAT_LITERAL,
			HOST_ONLY_LITERAL,
			CUSTOM_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Virtual Network Connection Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Virtual Network Connection Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VirtualNetworkConnectionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VirtualNetworkConnectionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Virtual Network Connection Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VirtualNetworkConnectionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VirtualNetworkConnectionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Virtual Network Connection Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VirtualNetworkConnectionType get(int value) {
		switch (value) {
			case BRIDGED: return BRIDGED_LITERAL;
			case NAT: return NAT_LITERAL;
			case HOST_ONLY: return HOST_ONLY_LITERAL;
			case CUSTOM: return CUSTOM_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VirtualNetworkConnectionType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //VirtualNetworkConnectionType
