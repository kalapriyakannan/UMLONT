/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.uml.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;

/**
 * @since 7.0
 * 
 */
public class ComponentUnitUmlFilter extends UnitFilter {

	public List<String> getAllowableMemberUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();
		list.add(IAnalysisTemplateConstants.DEPLOYMENTUNIT_UNIT);
		list.add(IAnalysisTemplateConstants.PRESENTATION_DEPLOYMENTUNIT_UNIT);
		list.add(IAnalysisTemplateConstants.EXECUTION_DEPLOYMENTUNIT_UNIT);
		list.add(IAnalysisTemplateConstants.DATA_DEPLOYMENTUNIT_UNIT);
		return list;
	}

	@Override
	public boolean isVolatile() {
		// Don't cache the types, because the user may toggle the conceptual bit and
		// expect the filter to generate different stuff.
		return false;
	}
}
