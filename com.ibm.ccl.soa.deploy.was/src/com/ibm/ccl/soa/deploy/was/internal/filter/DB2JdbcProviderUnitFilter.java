/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;

/**
 * @since 3.2
 * @see DB2JdbcProviderUnit
 */
public class DB2JdbcProviderUnitFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableHostingTemplates(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();

		list.add(IWasTemplateConstants.WAS_DB2_DATASOURCE_UNIT_5);

		return list;
	}
}
