/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Publish State</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * An type for the publish state of a unit.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getPublishState()
 * @model
 * @generated
 */
public final class PublishState extends AbstractEnumerator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6932310602797571939L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Published</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Published</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PUBLISHED_LITERAL
	 * @model name="published"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLISHED = 0;

	/**
	 * The '<em><b>Not Published</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Published</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NOT_PUBLISHED_LITERAL
	 * @model name="notPublished" literal="not_published"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_PUBLISHED = 1;

	/**
	 * The '<em><b>Unknown</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #UNKNOWN_LITERAL
	 * @model name="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 2;

	/**
	 * The '<em><b>Published</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #PUBLISHED
	 * @generated
	 * @ordered
	 */
	public static final PublishState PUBLISHED_LITERAL = new PublishState(PUBLISHED,
			"published", "published"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Not Published</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #NOT_PUBLISHED
	 * @generated
	 * @ordered
	 */
	public static final PublishState NOT_PUBLISHED_LITERAL = new PublishState(NOT_PUBLISHED,
			"notPublished", "not_published"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Unknown</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final PublishState UNKNOWN_LITERAL = new PublishState(UNKNOWN,
			"unknown", "unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Publish State</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final PublishState[] VALUES_ARRAY = new PublishState[] { PUBLISHED_LITERAL,
			NOT_PUBLISHED_LITERAL, UNKNOWN_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Publish State</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Publish State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PublishState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PublishState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Publish State</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PublishState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PublishState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Publish State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PublishState get(int value) {
		switch (value)
		{
		case PUBLISHED:
			return PUBLISHED_LITERAL;
		case NOT_PUBLISHED:
			return NOT_PUBLISHED_LITERAL;
		case UNKNOWN:
			return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private PublishState(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PublishState
