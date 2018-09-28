/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was;

import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * UnitProvider Contribution: WASJ2CAuthenticationUnitASCProvider it will generate
 * {@link ASCConstants#TASK_CREATE_J2CAUTHENTICATION} asc task for {@link WASJ2CAuthenticationUnit}
 * 
 * @see WASJ2CAuthenticationUnit
 * @see WASJ2CAuthenticationDataEntry
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 */
public class WASJ2CAuthenticationUnitASCProvider extends WASASCProvider {

	public boolean isConditionSatisfied() {

		return unit instanceof WASJ2CAuthenticationUnit;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.asc.was.WASASCProvider#initTasks_Base()
	 */
	protected void initTasks_Base() throws ASCException {
		ascTaskName = new String[] { ASCConstants.TASK_CREATE_J2CAUTHENTICATION };
		Properties createJ2CAuth = new Properties();
		ascProps = new Properties[] { createJ2CAuth };
		setEnvProp(createJ2CAuth);
		super.setASCAgentProp(createJ2CAuth);
		WASJ2CAuthenticationDataEntry j2cCap = (WASJ2CAuthenticationDataEntry) CapabilityUtil
				.findCapabilityOfType(unit, WasPackage.eINSTANCE.getWASJ2CAuthenticationDataEntry());

		super.setAscProperty(createJ2CAuth, ASCConstants.WAS_J2CA_ALIAS, j2cCap.getAlias());
		super.setAscProperty(createJ2CAuth, ASCConstants.WAS_J2CA_USERID, j2cCap.getUserId());
		super.setAscProperty(createJ2CAuth, ASCConstants.WAS_J2CA_PWD, j2cCap.getPassword());
		super.setAscProperty(createJ2CAuth, ASCConstants.DESCRIPTION, j2cCap.getDescription());

	}

}
