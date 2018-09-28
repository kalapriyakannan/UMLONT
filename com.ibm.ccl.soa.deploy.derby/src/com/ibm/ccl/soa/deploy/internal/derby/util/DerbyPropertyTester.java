/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.util;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit;

public class DerbyPropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (getVersionProperty().equals(property)) {
			if (receiver instanceof DerbyDatabaseUnit) {
				DerbyDatabaseUnit server = (DerbyDatabaseUnit) receiver;
				Iterator provServices = server.getHostingOrAnyCapabilities().iterator();
				while (provServices.hasNext()) {
					Capability service = (Capability) provServices.next();
					if (service instanceof DerbyDatabase) {
						DerbyDatabase derbyService = (DerbyDatabase) service;
						if (derbyService.getDerbyVersion().startsWith(((Float) expectedValue).toString()))
							return true;
					}
				}
			}
		}

		return false;
	}

	protected String getVersionProperty() {
		return "derbyVersion"; //$NON-NLS-1$
	}

}
