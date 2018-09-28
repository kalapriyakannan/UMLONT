/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Authentication Type Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines the authentication types for a unix db2 install.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getAuthenticationTypeType()
 * @model
 * @generated
 */
public final class AuthenticationTypeType extends AbstractEnumerator {
	/**
	 * The '<em><b>SERVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVER</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVER = 0;

	/**
	 * The '<em><b>CLIENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLIENT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLIENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLIENT = 1;

	/**
	 * The '<em><b>SERVERENCRYPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVERENCRYPT</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVERENCRYPT_LITERAL
	 * @model literal="SERVER_ENCRYPT"
	 * @generated
	 * @ordered
	 */
	public static final int SERVERENCRYPT = 2;

	/**
	 * The '<em><b>DATAENCRYPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATAENCRYPT</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATAENCRYPT_LITERAL
	 * @model literal="DATA_ENCRYPT"
	 * @generated
	 * @ordered
	 */
	public static final int DATAENCRYPT = 3;

	/**
	 * The '<em><b>DATAENCRYPTCMP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATAENCRYPTCMP</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATAENCRYPTCMP_LITERAL
	 * @model literal="DATA_ENCRYPT_CMP"
	 * @generated
	 * @ordered
	 */
	public static final int DATAENCRYPTCMP = 4;

	/**
	 * The '<em><b>KERBEROS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KERBEROS</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KERBEROS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KERBEROS = 5;

	/**
	 * The '<em><b>KRBSERVERENCRYPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KRBSERVERENCRYPT</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KRBSERVERENCRYPT_LITERAL
	 * @model literal="KRB_SERVER_ENCRYPT"
	 * @generated
	 * @ordered
	 */
	public static final int KRBSERVERENCRYPT = 6;

	/**
	 * The '<em><b>GSSPLUGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GSSPLUGIN</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GSSPLUGIN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GSSPLUGIN = 7;

	/**
	 * The '<em><b>GSSSERVERENCRYPT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GSSSERVERENCRYPT</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GSSSERVERENCRYPT_LITERAL
	 * @model literal="GSS_SERVER_ENCRYPT"
	 * @generated
	 * @ordered
	 */
	public static final int GSSSERVERENCRYPT = 8;

	/**
	 * The '<em><b>SERVER</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SERVER
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType SERVER_LITERAL = new AuthenticationTypeType(SERVER, "SERVER", "SERVER"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CLIENT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #CLIENT
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType CLIENT_LITERAL = new AuthenticationTypeType(CLIENT, "CLIENT", "CLIENT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>SERVERENCRYPT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #SERVERENCRYPT
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType SERVERENCRYPT_LITERAL = new AuthenticationTypeType(SERVERENCRYPT, "SERVERENCRYPT", "SERVER_ENCRYPT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DATAENCRYPT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DATAENCRYPT
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType DATAENCRYPT_LITERAL = new AuthenticationTypeType(DATAENCRYPT, "DATAENCRYPT", "DATA_ENCRYPT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>DATAENCRYPTCMP</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DATAENCRYPTCMP
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType DATAENCRYPTCMP_LITERAL = new AuthenticationTypeType(DATAENCRYPTCMP, "DATAENCRYPTCMP", "DATA_ENCRYPT_CMP"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>KERBEROS</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #KERBEROS
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType KERBEROS_LITERAL = new AuthenticationTypeType(KERBEROS, "KERBEROS", "KERBEROS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>KRBSERVERENCRYPT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #KRBSERVERENCRYPT
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType KRBSERVERENCRYPT_LITERAL = new AuthenticationTypeType(KRBSERVERENCRYPT, "KRBSERVERENCRYPT", "KRB_SERVER_ENCRYPT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>GSSPLUGIN</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #GSSPLUGIN
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType GSSPLUGIN_LITERAL = new AuthenticationTypeType(GSSPLUGIN, "GSSPLUGIN", "GSSPLUGIN"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>GSSSERVERENCRYPT</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #GSSSERVERENCRYPT
	 * @generated
	 * @ordered
	 */
	public static final AuthenticationTypeType GSSSERVERENCRYPT_LITERAL = new AuthenticationTypeType(GSSSERVERENCRYPT, "GSSSERVERENCRYPT", "GSS_SERVER_ENCRYPT"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Authentication Type Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final AuthenticationTypeType[] VALUES_ARRAY = new AuthenticationTypeType[] {
			SERVER_LITERAL,
			CLIENT_LITERAL,
			SERVERENCRYPT_LITERAL,
			DATAENCRYPT_LITERAL,
			DATAENCRYPTCMP_LITERAL,
			KERBEROS_LITERAL,
			KRBSERVERENCRYPT_LITERAL,
			GSSPLUGIN_LITERAL,
			GSSSERVERENCRYPT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Authentication Type Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Authentication Type Type</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static AuthenticationTypeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AuthenticationTypeType result = VALUES_ARRAY[i];
			if (result.toString().equalsIgnoreCase(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Authentication Type Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public static AuthenticationTypeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AuthenticationTypeType result = VALUES_ARRAY[i];
			if (result.getName().equalsIgnoreCase(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Authentication Type Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AuthenticationTypeType get(int value) {
		switch (value) {
			case SERVER: return SERVER_LITERAL;
			case CLIENT: return CLIENT_LITERAL;
			case SERVERENCRYPT: return SERVERENCRYPT_LITERAL;
			case DATAENCRYPT: return DATAENCRYPT_LITERAL;
			case DATAENCRYPTCMP: return DATAENCRYPTCMP_LITERAL;
			case KERBEROS: return KERBEROS_LITERAL;
			case KRBSERVERENCRYPT: return KRBSERVERENCRYPT_LITERAL;
			case GSSPLUGIN: return GSSPLUGIN_LITERAL;
			case GSSSERVERENCRYPT: return GSSSERVERENCRYPT_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private AuthenticationTypeType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AuthenticationTypeType
