/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.propertytester;

import org.eclipse.core.expressions.PropertyTester;

/**
 * @since 1.0
 * 
 */
public class TopologyPropertyTester extends PropertyTester {

	private String isTopologyImport = "isTopologyImport"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.isTopologyImport.equals(property)) {
			Boolean topologyImport = (Boolean) expectedValue;
			return null != topologyImport ? topologyImport.booleanValue() : false;
		}
		assert false;
		return false;
	}

}
