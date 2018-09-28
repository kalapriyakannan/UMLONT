/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.internal;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Factory for generating {@link IDeployStatus} that can be serialized as markers.
 */
public class DeployLogicalLinkMessageFactory extends DeployCoreStatusUtil {

	public static IDeployStatus createEAR2DBStatus(ConstraintLink link, String problemType, String error) {
		IDeployStatus message = DeployCoreStatusFactory.INSTANCE
				.createObjectStatus(problemType, link);
		message.setUnboundMessage(error);
		return message;
	}

}
