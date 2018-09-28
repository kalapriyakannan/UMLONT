/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.Unit;

public class TargetNamespacePropertyTester extends PropertyTester {

	private final String property = "targetNamespace"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.property.equals(property)) {
			String expectedNamespace = (String) expectedValue;
			return null != expectedNamespace ? expectedNamespace.equalsIgnoreCase(((Unit) receiver)
					.eClass().getEPackage().getNsURI()) : false;
		}
		assert false;
		return false;
	}

}
