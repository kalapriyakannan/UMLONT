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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * Filters {@link EObject} instances based on the value of their {@link EAttribute}.
 */
public class EObjectAttributeValueFilter<T extends EObject> implements IObjectFilter<T> {

	protected final EAttribute attribute;

	protected final Object attributeValue;

	/**
	 * Filter EObjects on the value of an attribute.
	 * <p>
	 * Filter {@link EObject} instances whose type is {@link EAttribute#getContainerEClass()}, and
	 * whose link {@link EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)} value is
	 * {@link Object#equals(Object)} equal to the filter value.
	 * 
	 * @param attribute
	 *           an EMF attribute (cannot be null).
	 * @param attributeValue
	 *           the expected value of the EMF attribute (may be null).
	 */
	public EObjectAttributeValueFilter(EAttribute attribute, Object attributeValue) {
		assert attribute != null;
		this.attribute = attribute;
		this.attributeValue = attributeValue;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.util.IObjectFilter#accept(java.lang.Object)
	 */
	public boolean accept(T value) {
		if (value == null || !(value instanceof EObject)) {
			return false;
		}

		EObject object = value;

		if (!attribute.getEContainingClass().isSuperTypeOf(object.eClass())) {
			return false;
		}
		Object aValue = object.eGet(attribute);
		if (aValue == null) {
			return attributeValue == null;
		}
		if (attributeValue == null) {
			return false;
		}
		return aValue.equals(attributeValue);
	}
}
