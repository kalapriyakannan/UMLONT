/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import org.eclipse.emf.ecore.EAttribute;

public class AttributeValuePair {
	private final EAttribute _attribute;
	private final Object _value;

	public AttributeValuePair(EAttribute attribute, Object value) {
		_attribute = attribute;
		_value = value;
	}

	public EAttribute getAttribute() {
		return _attribute;
	}

	public Object getValue() {
		return _value;
	}
}
