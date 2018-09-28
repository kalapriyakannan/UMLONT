/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.ide.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;

public class ResourceNamePropertyTester extends PropertyTester {

	private String property = "isResourceName"; //$NON-NLS-1$

	//TODO expand this to accept regular expressions
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.property.equals(property)) {
			String resourceName = (String) expectedValue;
			IResource resource = (IResource) ((IAdaptable) receiver).getAdapter(IResource.class);
			return null != resource ? resource.getName().equals(resourceName) : false;
		}
		assert false;
		return false;
	}

}
