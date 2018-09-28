/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal.validator;

import com.ibm.ccl.soa.deploy.analysis.Activator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;

public class IAnalysisDomainValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2EEDatasource#getJndiName()} attribute of a requirement
	 * consumed by a {@link EjbModule} is undefined.
	 * </ul>
	 */
	public final static String DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT = Activator.PLUGIN_ID
			+ ".DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT"; //$NON-NLS-1$
	public static String LOCATIONUNIT_SHOULD_HAVE_ONE_NODEUNIT= Activator.PLUGIN_ID
	+ ".LOCATIONUNIT_SHOULD_HAVE_ONE_NODEUNIT"; //$NON-NLS-1$
	public static String NODE_VALIDATE_LOCATION_COMMUNICATION= Activator.PLUGIN_ID
	+ ".NODE_VALIDATE_LOCATION_COMMUNICATION"; //$NON-NLS-1$
}
