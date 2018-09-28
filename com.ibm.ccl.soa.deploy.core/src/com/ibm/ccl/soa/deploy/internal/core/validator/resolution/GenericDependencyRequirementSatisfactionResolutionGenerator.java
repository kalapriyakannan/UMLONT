/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Generates dependency requirement satisfaction resolutions on a unit with unsatisfied dependency
 * requirements
 * 
 * @author barnold
 */
public class GenericDependencyRequirementSatisfactionResolutionGenerator extends
		DeployResolutionGenerator {

	private final Map<Unit, LinkDescriptor[]> candidateToLDs = new HashMap<Unit, LinkDescriptor[]>();
	private final Map<Unit, UnitDescriptor> candidateToUD = new HashMap<Unit, UnitDescriptor>();

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED.equals(status.getProblemType())) {
			return false;
		}
		if (!(status.getDeployObject() instanceof Requirement)) {
			return false;
		}

		return true;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}
		IDeployStatus status = context.getDeployStatus();
		Requirement req = (Requirement) status.getDeployObject();
		assert req.getLinkType().equals(RequirementLinkTypes.DEPENDENCY_LITERAL);
		List<Unit> matches = calculateMatches(req, context);
		List<IDeployResolution> resolutionsList = new ArrayList<IDeployResolution>();
		for (Iterator<Unit> iter = matches.iterator(); iter.hasNext();) {
			Unit candidate = iter.next();

			LinkDescriptor[] linkDescriptor = candidateToLDs.get(candidate);
			UnitDescriptor candidateUnitUD = candidateToUD.get(candidate);
			if (linkDescriptor.length > 0) {
				for (int j = 0; j < linkDescriptor.length; j++) {
					LinkDescriptor ld = linkDescriptor[j];
					DeployModelObject sourceObj = ld.getSource();
					Unit targetUnit = ld.getTargetUnit();
					String description = DeployNLS.bind(
							DeployCoreMessages.Resolution_create_dependency_link_from_0_to_1,
							new Object[] {
									null == sourceObj.getDisplayName() ? sourceObj.getName() : sourceObj
											.getDisplayName(),
									targetUnit.getCaptionProvider().titleWithContext(targetUnit) });
					// (null == targetUnit.getDisplayName()) ? targetUnit.getName() :
					// targetUnit.getDisplayName(),
					// (null == targetObj.getDisplayName()) ? targetObj.getName() :
					// targetObj.getDisplayName() });
					resolutionsList.add(new GenericDependencyRequirementSatisfactionResolution(context,
							this, candidateUnitUD, linkDescriptor[j], description));
				}
			}
		}

		IDeployResolution resolutions[] = new IDeployResolution[resolutionsList.size()];
		for (int i = 0; i < resolutionsList.size(); i++) {
			resolutions[i] = resolutionsList.get(i);
		}
		return resolutions;
	}

	// Adapted from SelectTargetWizard
	private List<Unit> calculateMatches(Requirement req, IDeployResolutionContext context) {
		LinkType[] linkTypes = new LinkType[] { LinkType.DEPENDENCY };
		DeployValidatorService dvs = context.getDeployValidatorService();

		List<Unit> retVal = new ArrayList<Unit>();

		// MK 03-01-2008: defect 5549:
		// As part of fix noted that when select marker on EAR there are repeated (and incorrect)
		// resolutions presented.  This is because the filter is incorrect; it left out the requirement.
		// While correcting this, other code style changes added at the same time.
		Unit src = (Unit) req.getParent();
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(src, req,
				context.getTopology(), context.getProgressMonitor());
		List<UnitDescriptor> possibleTargetsUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findAll(filter);
		for (UnitDescriptor candidateUD : possibleTargetsUnitDescriptors) {
			if (candidateUD == null) {
				continue;
			}
			Unit candidate = candidateUD.getUnitValue();
			if (candidate == null) {
				continue;
			}
			candidateToUD.put(candidate, candidateUD);
			// MK 10/2/2006 removed to allow a unit to satisfy its own requirement
			// if (candidate != src) {
			LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(src, req, candidate, null,
					linkTypes);
			if (linkDescriptorArray.length > 0) {
				retVal.add(candidate);
				candidateToLDs.put(candidate, linkDescriptorArray);
			}
			// }
		}

		return retVal;
	}
}
