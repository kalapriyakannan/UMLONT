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

import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
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
 * Generates realization requirement satisfaction resolutions for realization of a hosting stack on
 * a conceptual unit that is not realized
 */
public class GenericStackRealizationSatisfactionResolutionGenerator extends
		DeployResolutionGenerator {

	private final Map<Unit, LinkDescriptor[]> candidateToLDs = new HashMap<Unit, LinkDescriptor[]>();

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status.getDeployObject() instanceof Unit)) {
			return false;
		}

		// TODO this resolution isn't in use, but if it were, it would be 
		// falsely claiming resolutions available when they are not
		if (!ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
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
		Unit srcUnit = (Unit) status.getDeployObject();
		List<Unit> matches = calculateMatches(srcUnit, context);
		List<IDeployResolution> resolutionsList = new ArrayList<IDeployResolution>();
		for (Iterator<Unit> iter = matches.iterator(); iter.hasNext();) {
			Unit candidate = iter.next();

			LinkDescriptor[] linkDescriptors = candidateToLDs.get(candidate);
			// Only want to offer one hosting resolution to any particular
			// target.
			if (linkDescriptors.length > 0) {

				String description = null;
				LinkDescriptor ld = linkDescriptors[0];
				Map srMap = GenericStackRealizationSatisfactionResolution.stackRealizationMap(ld
						.getSourceUnit(), ld.getTargetUnit(), context);
				if (srMap.size() > 1) {
					if (ld.getType().equals(LinkType.REALIZATION)) {
						description = NLS.bind(// DeployCoreMessages.Resolution_realize_0_by_1,
								DeployCoreMessages.Resolution_realize_stack_at_0_by_stack_at_1, srcUnit
										.getCaptionProvider().titleWithContext(srcUnit), candidate
										.getCaptionProvider().titleWithContext(candidate));

						resolutionsList.add(new GenericStackRealizationSatisfactionResolution(context,
								this, srcUnit, candidate, srMap, /* candidate, */description));
					}
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
	private List<Unit> calculateMatches(Unit srcUnit, IDeployResolutionContext context) {
		LinkType[] linkTypes = new LinkType[] { LinkType.REALIZATION };

		DeployValidatorService dvs = context.getDeployValidatorService();

		List<Unit> retVal = new ArrayList<Unit>();

		Topology top = srcUnit.getEditTopology();

		// Per agreement, look only in local topology
		for (Iterator<Unit> it = top.findAllUnits(); it.hasNext();) {
			Unit candidate = it.next();

			if (candidate == null) {
				continue;
			}
			if (candidate != srcUnit) {
				LinkDescriptor[] linkDescriptorArray = RealizationPatternCacheService.INSTANCE
						.getPossibleLinks(srcUnit, candidate, linkTypes, dvs);
				if (linkDescriptorArray.length > 0) {
					retVal.add(candidate);
					candidateToLDs.put(candidate, linkDescriptorArray);
				}
			}
		}

		return retVal;
	}
}
