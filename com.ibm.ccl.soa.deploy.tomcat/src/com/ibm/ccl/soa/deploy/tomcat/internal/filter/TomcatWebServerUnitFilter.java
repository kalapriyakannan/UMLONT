/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tomcat.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.tomcat.ITomcatTemplateConstants;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * A filter that suggests {@link Unit} types to be hosted by an {@link TomcatWebServerUnit}.
 * 
 * @since 3.2
 * @see TomcatWebServerUnit
 */
public class TomcatWebServerUnitFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableHostingTemplates(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();
		list.add(ITomcatTemplateConstants.TOMCAT_DATASOURCE_50_UNIT);
		return list;
	}

}
