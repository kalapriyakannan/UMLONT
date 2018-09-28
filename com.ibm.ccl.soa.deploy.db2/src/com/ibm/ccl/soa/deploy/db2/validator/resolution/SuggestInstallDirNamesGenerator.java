/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsProblemType;

/**
 * Generates resolutions on an object attribute with an expected value.
 */
public class SuggestInstallDirNamesGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (context.getDeployStatus() instanceof IDeployAttributeStatus) {
			String problemType = context.getDeployStatus().getProblemType();
			if (problemType.equals(IOsProblemType.PATH_INVALID_ON_AIX_OR_SOLARIS_OPERATING_SYSTEM)
					|| problemType.equals(IOsProblemType.PATH_INVALID_ON_WINDOWS_OPERATING_SYSTEM)
					|| problemType.equals(IOsProblemType.PATH_INVALID_ON_LINUX_OPERATING_SYSTEM)) {
				String validatorID = context.getDeployStatus().getValidatorID();
				if (validatorID == null) {
					return false;
				}
				if (validatorID.equals(IDB2ValidatorID.DB2_SYSTEM_UNIT_INSTALL_DIR_INVALID_001)
						|| context.getDeployStatus().getValidatorID().equals(
								IDB2ValidatorID.DB2_SYSTEM_UNIT_CLIENT_INSTALL_DIR_INVALID_001)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		EAttribute attributeType = status.getAttributeType();
		String problemType = context.getDeployStatus().getProblemType();
		if (problemType.equals(IOsProblemType.PATH_INVALID_ON_WINDOWS_OPERATING_SYSTEM)) {
			return new IDeployResolution[] {
					new SuggestInstallDirName(context, this, attributeType, attributeType.getName(),
							"C:\\IBM\\SQLLIB"), //$NON-NLS-1$
					new SuggestInstallDirName(context, this, attributeType, attributeType.getName(),
							"C:\\PROGRAM FILES\\IBM\\SQLLIB") //$NON-NLS-1$
			};
		} else if (problemType.equals(IOsProblemType.PATH_INVALID_ON_AIX_OR_SOLARIS_OPERATING_SYSTEM)) {
			return new IDeployResolution[] { new SuggestInstallDirName(context, this, attributeType,
					attributeType.getName(), "/usr/opt/IBM/SQLLIB") //$NON-NLS-1$
			};
		} else if (problemType.equals(IOsProblemType.PATH_INVALID_ON_LINUX_OPERATING_SYSTEM)) {
			return new IDeployResolution[] { new SuggestInstallDirName(context, this, attributeType,
					attributeType.getName(), "/opt/IBM/SQLLIB") //$NON-NLS-1$
			};
		}
		// hasResolutions prevents other options
		return new IDeployResolution[0];
	}
}
