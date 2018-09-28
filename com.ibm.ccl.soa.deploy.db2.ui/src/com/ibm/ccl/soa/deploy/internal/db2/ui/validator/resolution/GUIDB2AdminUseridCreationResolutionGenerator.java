/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ProblemType;

/**
 * Dialog box resolution for individual attribute value-setting. Adapted from
 * GuiPropertSetResolution, esnible@us.ibm.com
 * 
 * @author barnold@us.ibm.com
 */
public class GUIDB2AdminUseridCreationResolutionGenerator implements IDeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {

		String label = null;
		label = Messages.CreateDB2InstanceAdminUser;
		GUICreateDB2InstanceAdminUserResolution resolution = new GUICreateDB2InstanceAdminUserResolution(
				context, this, label);
		resolution.setPriority(resolution.getPriority() + 3);
		return new IDeployResolution[] { resolution };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {

		if (!IDB2ProblemType.INSTANCE_MISSING_LINK_TO_MISSING_INSTANCE_ADMIN_USER.equals(context
				.getDeployStatus().getProblemType())) {
			return false;
		}
		return true;
	}

} // end class GUIDB2AdminUseridCreationResolutionGenerator
