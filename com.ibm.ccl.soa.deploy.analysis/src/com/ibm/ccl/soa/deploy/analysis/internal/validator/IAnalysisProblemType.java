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
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Defines the deploy status problem types for the Was domain.
 * 
 * @see WasPackage
 * @see IDeployStatus#getProblemType()
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IAnalysisProblemType {

	/**
	 * member is invalid for group, in the context of WAS Model
	 * <p>
	 * Value = {@value}
	 */
	public static final String ANALYSIS_INVALID_MEMBERUNIT_IN_GROUPUNIT = Activator.PLUGIN_ID
			+ ".invalidMemberUnitInGroupUnit"; //$NON-NLS-1$	
	public static final String MEMBER_LINK_UNDEFINED = Activator.PLUGIN_ID
			+ ".memberLinkUnDefined"; //$NON-NLS-1$	
	public static final String COMMUNICATION_LINK_UNDEFINED = Activator.PLUGIN_ID
	+ ".communicationLinkUnDefined"; //$NON-NLS-1$	

}
