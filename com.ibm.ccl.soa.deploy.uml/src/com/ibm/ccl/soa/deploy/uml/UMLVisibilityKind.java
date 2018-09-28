/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLVisibilityKind.java,v 1.2 2007/10/11 02:47:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>UML Visibility Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				This represents the visibility of Zephyr UML elements.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLVisibilityKind()
 * @model extendedMetaData="name='UMLVisibilityKind'"
 * @generated
 */
public final class UMLVisibilityKind extends AbstractEnumerator {
	/**
	 * The '<em><b>Public</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Public</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUBLIC_LITERAL
	 * @model name="public"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLIC = 0;

	/**
	 * The '<em><b>Protected</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Protected</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROTECTED_LITERAL
	 * @model name="protected"
	 * @generated
	 * @ordered
	 */
	public static final int PROTECTED = 1;

	/**
	 * The '<em><b>Private</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Private</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIVATE_LITERAL
	 * @model name="private"
	 * @generated
	 * @ordered
	 */
	public static final int PRIVATE = 2;

	/**
	 * The '<em><b>Package</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Package</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_LITERAL
	 * @model name="package"
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE = 3;

	/**
	 * The '<em><b>Undefined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undefined</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_LITERAL
	 * @model name="undefined"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED = 4;

	/**
	 * The '<em><b>Public</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUBLIC
	 * @generated
	 * @ordered
	 */
	public static final UMLVisibilityKind PUBLIC_LITERAL = new UMLVisibilityKind(PUBLIC, "public", "public"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Protected</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROTECTED
	 * @generated
	 * @ordered
	 */
	public static final UMLVisibilityKind PROTECTED_LITERAL = new UMLVisibilityKind(PROTECTED, "protected", "protected"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Private</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIVATE
	 * @generated
	 * @ordered
	 */
	public static final UMLVisibilityKind PRIVATE_LITERAL = new UMLVisibilityKind(PRIVATE, "private", "private"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Package</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKAGE
	 * @generated
	 * @ordered
	 */
	public static final UMLVisibilityKind PACKAGE_LITERAL = new UMLVisibilityKind(PACKAGE, "package", "package"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Undefined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @generated
	 * @ordered
	 */
	public static final UMLVisibilityKind UNDEFINED_LITERAL = new UMLVisibilityKind(UNDEFINED, "undefined", "undefined"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>UML Visibility Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UMLVisibilityKind[] VALUES_ARRAY =
		new UMLVisibilityKind[] {
			PUBLIC_LITERAL,
			PROTECTED_LITERAL,
			PRIVATE_LITERAL,
			PACKAGE_LITERAL,
			UNDEFINED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>UML Visibility Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>UML Visibility Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLVisibilityKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UMLVisibilityKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UML Visibility Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLVisibilityKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UMLVisibilityKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>UML Visibility Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLVisibilityKind get(int value) {
		switch (value) {
			case PUBLIC: return PUBLIC_LITERAL;
			case PROTECTED: return PROTECTED_LITERAL;
			case PRIVATE: return PRIVATE_LITERAL;
			case PACKAGE: return PACKAGE_LITERAL;
			case UNDEFINED: return UNDEFINED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private UMLVisibilityKind(int value, String name, String literal) {
		super(value, name, literal);
	}

} //UMLVisibilityKind
