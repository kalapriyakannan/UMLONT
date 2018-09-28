/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

/**
 * Filter Java objects of a specified type.
 * 
 * @see EObjectTypeFilter
 */
public final class ObjectTypeFilter<T> implements IObjectFilter<T> {

	/** Type accepted. */
	private final Class<?> type;

	/** True if subtypes are accepted. */
	private final boolean subtypeMatch;

	/**
	 * Construct a type-based object filter.
	 * 
	 * @param type
	 *           the Java class.
	 * @param subtypeMatch
	 *           true if subtypes of the type argument should be accepted.
	 */
	public ObjectTypeFilter(Class<?> type, boolean subtypeMatch) {
		assert type != null;
		this.type = type;
		this.subtypeMatch = subtypeMatch;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.ObjectFilter#checkFilterAccept(java.lang.Object)
	 */
	public boolean accept(T value) {
		if (value == null) {
			return false;
		}
		if (subtypeMatch) {
			return type.isAssignableFrom(value.getClass());
		}
		return type.equals(value.getClass());
	}
}
