/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * Enumeration of the type-conformance relationships between {@link org.eclipse.emf.ecore.EClass}es
 * in an EMF metamodel.
 * 
 * @author rafikj
 * 
 * @see EObjectContainmentUtil
 */
final class RelationKind extends AbstractEnumerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 71584598182514982L;

	private static int nextOrdinal = 0;

	/**
	 * classes are of same type.
	 */
	public static final RelationKind SAME_TYPE = new RelationKind("Same Type"); //$NON-NLS-1$

	/**
	 * one class is a base-class of the other but not equal.
	 */
	public static final RelationKind STRICT_BASETYPE = new RelationKind("Strict Basetype"); //$NON-NLS-1$

	/**
	 * one class is a sub-class of the other but not equal.
	 */
	public static final RelationKind STRICT_SUBTYPE = new RelationKind("Strict Subtype"); //$NON-NLS-1$

	/**
	 * classes are unrelated.
	 */
	public static final RelationKind UNRELATED_TYPE = new RelationKind("Unrelated Type"); //$NON-NLS-1$

	private static final RelationKind[] VALUES = { SAME_TYPE, STRICT_BASETYPE, STRICT_SUBTYPE,
			UNRELATED_TYPE };

	private RelationKind(String name, int ordinal) {
		super(ordinal, name);
	}

	private RelationKind(String name) {
		this(name, nextOrdinal++);
	}

	/**
	 * Gets the list of all possible values.
	 */
	public static List getValues() {
		return Collections.unmodifiableList(Arrays.asList(VALUES));
	}
}
