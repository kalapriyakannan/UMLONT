/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>LDAP Directory Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getLDAPDirectoryType()
 * @model extendedMetaData="name='LDAPDirectoryType'"
 * @generated
 */
public final class LDAPDirectoryType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>IBMDIRECTORYSERVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IBMDIRECTORYSERVER</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IBMDIRECTORYSERVER_LITERAL
	 * @model literal="IBM_DIRECTORY_SERVER"
	 * @generated
	 * @ordered
	 */
	public static final int IBMDIRECTORYSERVER = 0;

	/**
	 * The '<em><b>SECUREWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECUREWAY</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECUREWAY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECUREWAY = 1;

	/**
	 * The '<em><b>IPLANET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IPLANET</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IPLANET_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IPLANET = 2;

	/**
	 * The '<em><b>NETSCAPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NETSCAPE</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETSCAPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NETSCAPE = 3;

	/**
	 * The '<em><b>DOMINO502</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOMINO502</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOMINO502_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOMINO502 = 4;

	/**
	 * The '<em><b>NDS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NDS</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NDS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NDS = 5;

	/**
	 * The '<em><b>ACTIVEDIRECTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVEDIRECTORY</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVEDIRECTORY_LITERAL
	 * @model literal="ACTIVE_DIRECTORY"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVEDIRECTORY = 6;

	/**
	 * The '<em><b>CUSTOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CUSTOM</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM = 7;

	/**
	 * The '<em><b>IBMDIRECTORYSERVER</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #IBMDIRECTORYSERVER
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType IBMDIRECTORYSERVER_LITERAL = new LDAPDirectoryType(IBMDIRECTORYSERVER, "IBMDIRECTORYSERVER", "IBM_DIRECTORY_SERVER"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SECUREWAY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SECUREWAY
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType SECUREWAY_LITERAL = new LDAPDirectoryType(SECUREWAY, "SECUREWAY", "SECUREWAY"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>IPLANET</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #IPLANET
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType IPLANET_LITERAL = new LDAPDirectoryType(IPLANET, "IPLANET", "IPLANET"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>NETSCAPE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #NETSCAPE
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType NETSCAPE_LITERAL = new LDAPDirectoryType(NETSCAPE, "NETSCAPE", "NETSCAPE"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DOMINO502</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #DOMINO502
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType DOMINO502_LITERAL = new LDAPDirectoryType(DOMINO502, "DOMINO502", "DOMINO502"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>NDS</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #NDS
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType NDS_LITERAL = new LDAPDirectoryType(NDS, "NDS", "NDS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ACTIVEDIRECTORY</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #ACTIVEDIRECTORY
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType ACTIVEDIRECTORY_LITERAL = new LDAPDirectoryType(ACTIVEDIRECTORY, "ACTIVEDIRECTORY", "ACTIVE_DIRECTORY"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CUSTOM</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CUSTOM
	 * @generated
	 * @ordered
	 */
	public static final LDAPDirectoryType CUSTOM_LITERAL = new LDAPDirectoryType(CUSTOM, "CUSTOM", "CUSTOM"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>LDAP Directory Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final LDAPDirectoryType[] VALUES_ARRAY = new LDAPDirectoryType[] {
			IBMDIRECTORYSERVER_LITERAL,
			SECUREWAY_LITERAL,
			IPLANET_LITERAL,
			NETSCAPE_LITERAL,
			DOMINO502_LITERAL,
			NDS_LITERAL,
			ACTIVEDIRECTORY_LITERAL,
			CUSTOM_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>LDAP Directory Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>LDAP Directory Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static LDAPDirectoryType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LDAPDirectoryType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>LDAP Directory Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static LDAPDirectoryType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LDAPDirectoryType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>LDAP Directory Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static LDAPDirectoryType get(int value) {
		switch (value) {
			case IBMDIRECTORYSERVER: return IBMDIRECTORYSERVER_LITERAL;
			case SECUREWAY: return SECUREWAY_LITERAL;
			case IPLANET: return IPLANET_LITERAL;
			case NETSCAPE: return NETSCAPE_LITERAL;
			case DOMINO502: return DOMINO502_LITERAL;
			case NDS: return NDS_LITERAL;
			case ACTIVEDIRECTORY: return ACTIVEDIRECTORY_LITERAL;
			case CUSTOM: return CUSTOM_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private LDAPDirectoryType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //LDAPDirectoryType
