/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.publisher;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

public class TomcatPropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// TODO can this be genericized for all unit publishers?  via reflection or exposing EObject, perhaps
		if (getVersionProperty().equals(property)) {
			if (receiver instanceof TomcatWebServerUnit) {
				TomcatWebServerUnit server = (TomcatWebServerUnit) receiver;
				// Peruse the services since tomcatVersion is defined on the service, not the unit
				Iterator provServices = server.getHostingOrAnyCapabilities().iterator();
				while (provServices.hasNext()) {
					Capability service = (Capability) provServices.next();
					if (service instanceof TomcatServer) {
						TomcatServer tomcatService = (TomcatServer) service;
						if (tomcatService.getTomcatVersion().startsWith(
								((Float) expectedValue).toString()))
							return true;
					}
				}
			}
		}

		return false;
	}

	protected String getVersionProperty() {
		return "tomcatVersion"; //$NON-NLS-1$
	}
}
