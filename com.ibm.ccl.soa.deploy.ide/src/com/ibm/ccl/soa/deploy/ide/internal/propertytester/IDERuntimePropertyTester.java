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
import org.eclipse.wst.server.core.IRuntime;

import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;

public class IDERuntimePropertyTester extends PropertyTester {

	private final String propertyName = "isSupportedType"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// Ensure type id exists in runtimeTypeId map
		if (property.equals(propertyName)) {
			IRuntime runtime = (IRuntime) receiver;
			String runtimeTypeId = runtime.getRuntimeType().getId();
			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			if (rts.getResourceTypeId("wtp", runtimeTypeId) != null) { //$NON-NLS-1$
				return true;
			}
		}

		// TODO any way to check the runtime id (unit name) does not already exist in the topology?

		return false;
	}

}
