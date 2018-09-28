/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilterTest;

/**
 * Filter to be used on results from a discoverer to ensure that the datasources returned are will
 * not override other datasources already configured.
 */
/**
 * Filter to be used on results from a discoverer to ensure that the datasources returned are will
 * not override other datasources already configured.
 */
public class DatasourceNotUsed implements IDiscoveryResultFilterTest {

	/** Topology */
	private final Topology topology;

	/** Requirement trying to satisfy with a data source */
	private final Requirement requirement;

	/** An expected host for the data source */
	private final Unit expectedHost;

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
	 */
	public DatasourceNotUsed(Topology topology, Requirement req, Unit expectedHost) {
		this.topology = topology;
		requirement = req;
		this.expectedHost = expectedHost;
	}

	/**
	 * Filter out any data sources that have already been configured and are "in use"; that is, they
	 * are the target of existing DependencyLinks. In such cases, mutable attributes are, in
	 * practise, immutable.
	 * 
	 * @param units
	 *           list of unit descriptors to filter
	 * @return list of unit descriptors that have mutable attributes
	 */
	public boolean isUnitOK(Unit dsUnit) {
		boolean dsValid = true;

		// ensure that the identified unit is hosted in the right place
		// or it is not hosted
		if (!isHost(dsUnit, expectedHost)) {
			return true;
		}

		// is there already a capability satisfying a requirement for a
		// different datasource?
		// need to look at all EARs with dependency links to the is
		// datasource

		// identify all EARs already referencing this datasource
		Capability cap = ValidatorUtils
				.getFirstCapability(dsUnit, WasPackage.Literals.WAS_DATASOURCE);
		List earUD = TopologyDiscovererService.INSTANCE.findSources(dsUnit, cap, topology);

		for (Iterator mIt = earUD.iterator(); mIt.hasNext();) {
			UnitDescriptor mUD = (UnitDescriptor) mIt.next();
			Unit module = mUD.getUnitValue();
			for (Iterator rIt = module.getRequirements().iterator(); rIt.hasNext();) {
				Requirement req = (Requirement) rIt.next();

//						System.out.println ("   checking for use by module, requirement"); //$NON-NLS-1$
//						System.out.println ("      " + module); //$NON-NLS-1$
//						System.out.println ("      " + req); //$NON-NLS-1$
				//
				if (req == requirement) {
					// if there is a match in this case, we want to allow
					// it; no need to check further
//							System.out.println ("   matches requirement --> we can use this datasource"); //$NON-NLS-1$
					return true;
				}
				EClass reqType = req.getDmoEType();
				if (null == reqType) {
					continue;
				}
				if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(reqType)) {
//							System.out.println ("   req not for datasource; skipping"); //$NON-NLS-1$
					continue;
				}
				UnitDescriptor targetDsUd = TopologyDiscovererService.INSTANCE.findTarget(module, req,
						topology);
				if (targetDsUd == null) {
//							System.out.println ("   target datasource UD is null; skipping"); //$NON-NLS-1$
					return true; //continue;
				}
				Unit ds = targetDsUd.getUnitValue();
				if (ds == dsUnit) {
					// there is already a module depending on this
					// datasource we can only use it if the jndiName already
					// matches our requirement (ie, we cannot assume that we
					// can change the attribute on the datasource

//							System.out.println ("   found match to datasource, capability"); //$NON-NLS-1$
//							System.out.println ("      " + ds); //$NON-NLS-1$
//							System.out.println ("      " + cap); //$NON-NLS-1$
					//
					if (validateJndiConstraints(req, cap)) {
						// we have found a module with a requirement that
						// has a dependency on this datasource. This is only
						// acceptable if the module/requirement is the same
						// as the module/requirement of the requirement we
						// were trying to satisfy in the first place (ie, is
						// "requirement")

//								System.out.println ("   datasource in use.  test if we can also use it"); //$NON-NLS-1$
						if (!validateJndiConstraints(requirement, cap)) {
//									System.out.println ("   failed; cannot use it"); //$NON-NLS-1$
							dsValid = false;
							break;
						}
					}
				}
				if (!dsValid) {
					break;
				}
			}
			if (!dsValid) {
				break;
			}
		}
		return dsValid;
	}

	private boolean isHost(Unit candidate, Unit expectedHost) {
		if (null == expectedHost) {
			// we don't know what host to expect so allow it
			return true;
		}
		Unit host = TopologyDiscovererService.INSTANCE.findHost(candidate, topology);
		if (host == expectedHost) {
			return true;
		}
		// we expected a particular host but we didn't get a match
		return false;
	}

	private boolean validateJndiConstraints(Requirement req, Capability cap) {
		if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(cap.getEObject().eClass())) {
			return false;
		}
		J2EEDatasource ds = (J2EEDatasource) cap;
		String jndiName = ds.getJndiName();
		if (null == jndiName || 0 == jndiName.trim().length()) {
			return false;
		}
		jndiName = jndiName.trim();

		for (Constraint c : ConstraintUtil.getConstraints(req,
				WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT)) {
			WasJNDIBindingConstraint jndiConstraint = (WasJNDIBindingConstraint) c;
			if (jndiName.equals(jndiConstraint.getJndiName())) {
				return true;
			}
		}
		return false;
	}

}
