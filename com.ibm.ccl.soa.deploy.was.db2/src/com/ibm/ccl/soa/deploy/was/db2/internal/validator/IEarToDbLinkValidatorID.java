/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.db2.WasDB2Plugin;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;

/**
 * Validator identifiers for the {@link WasPackage} deploy domain.
 */
public interface IEarToDbLinkValidatorID {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IWasDb2ProblemType#EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN}
	 * <li>Description = The logical link from an {@link J2EEDatasource} reqirement (on a
	 * {@link EarModule}, {@link EjbModule} or {@link WebModule}) to a {@link DB2Database} is not
	 * correctly implemented (or not at all implemented) but the preconditions for implementing it
	 * exist.
	 * </ul>
	 */
	public final static String DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION = WasDB2Plugin.PLUGIN_ID
			+ ".DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION"; //$NON-NLS-1$	

}
