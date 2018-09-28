/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.db2.internal.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;

/**
 * DB2InstanceUnitFilter suggests {@link Unit} types to be hosted by an {@link DB2InstanceUnit}.
 * 
 * @since 3.2
 * 
 * @author Ed Snible (based on earlier version)
 */
public class DB2InstanceUnitFilter extends UnitFilter {

	private static final List<String> conceptualHostees = Collections.unmodifiableList(Arrays
			.asList(new String[] { IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT_CONCEPTUAL,
					IDb2TemplateConstants.DB2_DATABASE_UNIT_CONCEPTUAL }));
	private static final List<String> hostees = Collections.unmodifiableList(Arrays
			.asList(new String[] { IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT,
					IDb2TemplateConstants.DB2_DATABASE_UNIT }));

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableHostingTemplates(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		return anInputUnit.isConceptual() ? conceptualHostees : hostees;
	}

	@Override
	public boolean isVolatile() {
		// Don't cache the types, because the user may toggle the conceptual bit and
		// expect the filter to generate different stuff.
		return true;
	}
}
