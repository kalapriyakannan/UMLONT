/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.discoverer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;

/**
 * {@link IDiscoveryResultFilter} that composes a filter out of a set of individual tests on a
 * {@link Unit}.
 */
public class UnifiedDiscoveryResultFilter implements IDiscoveryResultFilter {

	private final IDiscoveryResultFilterTest[] tests;

	/**
	 * Constructor for filter
	 * 
	 * @param tests
	 *           list of unit tests
	 */
	public UnifiedDiscoveryResultFilter(IDiscoveryResultFilterTest[] tests) {
		this.tests = tests;
	}

	public List select(List unitDescriptors) {
		List filtered = new ArrayList();
		for (Iterator uIt = unitDescriptors.iterator(); uIt.hasNext();) {
			UnitDescriptor ud = (UnitDescriptor) uIt.next();
			Unit unit = ud.getUnitValue();

			boolean unitOK = true;
			for (int i = 0; i < tests.length; i++) {
				// if fail the test then this unit is unacceptable
				if (!tests[i].isUnitOK(unit)) {
					unitOK = false;
					break;
				}
			}

			// if passed all the tests, this unit is acceptable
			if (unitOK)
				filtered.add(ud);
		}
		return filtered;
	}

}
