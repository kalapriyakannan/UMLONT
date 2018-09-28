/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;

/**
 * Filters DB2 node catalog entries by rejecting any already configured to refer to a DB2 database
 * instance.
 */
public class NodeCatalogFilter implements IDiscoveryResultFilter {
	public List select(List units) {
		List filtered = new ArrayList();
		for (Iterator uIt = units.iterator(); uIt.hasNext();) {
			UnitDescriptor ud = (UnitDescriptor) uIt.next();
			Unit unit = ud.getUnitValue();
			Requirement dbInstance = ValidatorUtils.getFirstRequirement(unit,
					Db2Package.Literals.DB2_INSTANCE);
			if (null == dbInstance) {
				continue;
			}

			// if linked to the instance we want it should have been earlier
			// so any link implies this is the wrong instance
			if (null != ValidatorUtils.discoverDependencyLinkTarget(dbInstance, null)) {
				continue;
			}

			// instance is not mapped to another
			filtered.add(ud);
		}

		return filtered;
	}
}
