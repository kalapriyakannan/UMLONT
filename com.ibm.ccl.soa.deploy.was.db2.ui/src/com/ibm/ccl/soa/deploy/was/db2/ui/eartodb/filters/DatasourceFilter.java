/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.UnifiedDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.UnitHasKnownAttributesTest;

/**
 * Filter to be used on results from a discoverer to ensure that the datasources returned are will
 * not override other datasources already configured.
 */
public class DatasourceFilter extends UnifiedDiscoveryResultFilter implements
		IDiscoveryResultFilter {

	/**
	 * Constructor that stores the topology and a module's requirement for a datasource
	 * 
	 * @param topology
	 *           the topology
	 * @param req
	 *           a modules requirement for a datasource
	 * @param expectedHost
	 *           the expected host of the data source
	 * @param mutableAttributes
	 *           array of attributes that we expect to be mutable
	 * @param values
	 *           array of attribute values (if the attribute is immutable)
	 */
	public DatasourceFilter(Topology topology, Requirement req, Unit expectedHost,
			EAttribute[] mutableAttributes, Object[] values) {
		super(new IDiscoveryResultFilterTest[] {
		// MK 12/14/2006 this seems too strong
				// we are trying too hard to reuse a datasource; let's not
				// try unless the attributes we want _all_ match
//						new UnitHasImmutableAttributesTest(
				new UnitHasKnownAttributesTest(J2eePackage.Literals.J2EE_DATASOURCE, mutableAttributes,
						values), new DatasourceNotUsed(topology, req, expectedHost) });
	}

}
