/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.conceptual.node.resolution;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class NodeProtocolMatchTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// 
		IDeployStatus status = (IDeployStatus) receiver;
		if (status.getMessage().equals(
				DeployCoreMessages.ConceptualNodePatternValidator_Non_matching_communication_protocol_))
			return true;
		return false;

	}

}
