/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator.matcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * Disallow links - From EAR to datasource if the units are hosted on different operating systems
 */
public class DatasourceDependencyMatcher extends LinkMatcher {

	private static DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

	@Override
	public IStatus canCreateLink(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {
		// MK 02-29-2008 - defect 5549:
		// We only want to check this if we don't have a specific source requirement
		if (null == sourceRequirement) {
			if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
				// get member modules
				// if they have datasource requirements that match the target then can return true
				List<Unit> modules = ValidatorUtils.getMembers(sourceUnit);
				for (Unit module : modules) {
					List<Requirement> dsReqs = ValidatorUtils.getRequirements(module,
							J2eePackage.Literals.J2EE_DATASOURCE);
					for (Requirement dsReq : dsReqs) {
						IStatus status = dvs.canCreateLink(module, dsReq, targetUnit, targetCapability,
								LinkType.DEPENDENCY_SET, DeployValidatorService.MATCHER_DEPTH_ALL);
						if (status.isOK()) {
							return status;
						}
					}
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public IStatus canCreateLink(Unit sourceUnit, Unit targetUnit) {
		if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			// get member modules
			// if they have datasource requirements that match the target then can return true
			List<Unit> modules = ValidatorUtils.getMembers(sourceUnit);
			for (Unit module : modules) {
				List<Requirement> dsReqs = ValidatorUtils.getRequirements(module,
						J2eePackage.Literals.J2EE_DATASOURCE);
				for (Requirement dsReq : dsReqs) {
					IStatus status = dvs.canCreateLink(module, dsReq, targetUnit, null,
							LinkType.DEPENDENCY_SET, DeployValidatorService.MATCHER_DEPTH_ALL);
					if (status.isOK()) {
						return status;
					}
				}
			}
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	@Override
	public Set<LinkDescriptor> getPossibleLinks(Unit sourceUnit, Requirement sourceRequirement,
			Unit targetUnit, Capability targetCapability) {

		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();
		if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			// get member modules
			// if they have datasource requirements that match the target then can return true
			List<Unit> modules = ValidatorUtils.getMembers(sourceUnit);
			for (Unit module : modules) {
				List<Requirement> dsReqs = ValidatorUtils.getRequirements(module,
						J2eePackage.Literals.J2EE_DATASOURCE);
				for (Requirement dsReq : dsReqs) {
					LinkDescriptor[] ld = dvs.getPossibleLinks(module, dsReq, targetUnit,
							targetCapability, LinkType.DEPENDENCY_SET,
							DeployValidatorService.MATCHER_DEPTH_ALL);
					for (int i = 0; i < ld.length; i++) {
						possibleLinks.add(ld[i]);
					}
				}
			}
		}
		return possibleLinks;
	}

	@Override
	public Set<LinkDescriptor> getPossibleLinks(Unit sourceUnit, Unit targetUnit) {

		Set<LinkDescriptor> possibleLinks = new HashSet<LinkDescriptor>();
		if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			// get member modules
			// if they have datasource requirements that match the target then can return true
			List<Unit> modules = ValidatorUtils.getMembers(sourceUnit);
			for (Unit module : modules) {
				List<Requirement> dsReqs = ValidatorUtils.getRequirements(module,
						J2eePackage.Literals.J2EE_DATASOURCE);
				for (Requirement dsReq : dsReqs) {
					LinkDescriptor[] ld = dvs.getPossibleLinks(module, dsReq, targetUnit, null,
							LinkType.DEPENDENCY_SET, DeployValidatorService.MATCHER_DEPTH_ALL);
					for (int i = 0; i < ld.length; i++) {
						possibleLinks.add(ld[i]);
					}
				}
			}
		}
		return possibleLinks;
	}

}
