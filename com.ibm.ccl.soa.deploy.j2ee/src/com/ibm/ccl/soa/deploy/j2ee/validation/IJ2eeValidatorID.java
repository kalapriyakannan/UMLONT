/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.validation;

import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * Static validator IDs for the J2EE domain.
 * 
 * @see J2eePackage
 * @see IDeployStatus#getValidatorID()
 */
public interface IJ2eeValidatorID {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The modules grouped by an EAR must have the same install state as the EAR
	 * since they are not independent units of deployment.
	 * </ul>
	 */
	public final static String EAR_MODULE_INSTALL_STATE_001 = J2EEDeployPlugin.pluginID
			+ ".EAR_MODULE_INSTALL_STATE_001"; //$NON-NLS-1$
}
