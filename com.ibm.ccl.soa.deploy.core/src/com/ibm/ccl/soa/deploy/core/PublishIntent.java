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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Publish Intent</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * If the publish intent of a {@link Unit} is 'do_not_publish' it will not be deployed when the
 * topology is published.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getPublishIntent()
 * @model
 * @generated
 * @deprecated
 */
public final class PublishIntent extends AbstractEnumerator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5800931520893710806L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>Publish</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Publish</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUBLISH_LITERAL
	 * @model name="publish"
	 * @generated
	 * @ordered
	 */
	public static final int PUBLISH = 0;

	/**
	 * The '<em><b>Do Not Publish</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Do Not Publish</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DO_NOT_PUBLISH_LITERAL
	 * @model name="doNotPublish" literal="do_not_publish"
	 * @generated
	 * @ordered
	 */
	public static final int DO_NOT_PUBLISH = 1;

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_LITERAL
	 * @model name="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN = 2;

	/**
	 * The '<em><b>Publish</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #PUBLISH
	 * @generated
	 * @ordered
	 */
	public static final PublishIntent PUBLISH_LITERAL = new PublishIntent(PUBLISH, "publish", "publish"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Do Not Publish</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #DO_NOT_PUBLISH
	 * @generated
	 * @ordered
	 */
	public static final PublishIntent DO_NOT_PUBLISH_LITERAL = new PublishIntent(DO_NOT_PUBLISH, "doNotPublish", "do_not_publish"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Unknown</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #UNKNOWN
	 * @generated
	 * @ordered
	 */
	public static final PublishIntent UNKNOWN_LITERAL = new PublishIntent(UNKNOWN, "unknown", "unknown"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Publish Intent</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PublishIntent[] VALUES_ARRAY = new PublishIntent[] {
			PUBLISH_LITERAL,
			DO_NOT_PUBLISH_LITERAL,
			UNKNOWN_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Publish Intent</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Publish Intent</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static PublishIntent get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PublishIntent result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Publish Intent</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PublishIntent getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PublishIntent result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Publish Intent</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static PublishIntent get(int value) {
		switch (value) {
			case PUBLISH: return PUBLISH_LITERAL;
			case DO_NOT_PUBLISH: return DO_NOT_PUBLISH_LITERAL;
			case UNKNOWN: return UNKNOWN_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private PublishIntent(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PublishIntent
