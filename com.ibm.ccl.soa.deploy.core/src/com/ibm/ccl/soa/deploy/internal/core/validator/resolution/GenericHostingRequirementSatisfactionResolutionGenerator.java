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

import com.ibm.ccl.soa.deploy.core.InstallState;
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
 * Generates hosting requirement satisfaction resolutions on a unit with an unsatisfied hosting
 * requirement
 * 
 * @author barnold
 */
public class GenericHostingRequirementSatisfactionResolutionGenerator extends
		DeployResolutionGenerator {

	private final Map<Unit, LinkDescriptor[]> candidateToLDs = new HashMap<Unit, LinkDescriptor[]>();

	//	private Map candidateToUD = new HashMap();		

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {

		IDeployStatus status = context.getDeployStatus();
		Unit unit = null;
		if (status.getDeployObject() instanceof Unit) {
			unit = (Unit) status.getDeployObject();
		}

		if (!ICoreProblemType.UNIT_NOT_HOSTED.equals(status.getProblemType())) {
			return false;
		}
		// Same rules as set-to-installed resolution.
		if (ICoreProblemType.UNIT_NOT_HOSTED.equals(status.getProblemType()) && unit != null
				&& unit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
			return false;
		}
		return true;
	}

	//	/*
	//	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	//	 */
	//	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
	//		if (!hasResolutions(context)) {
	//			return new IDeployResolution[0];
	//		}
	//		IDeployStatus status = context.getDeployStatus();
	//		Unit srcUnit = (Unit) status.getDeployObject();
	//		List matches = calculateMatches(srcUnit, context);
	//		ArrayList resolutionsList = new ArrayList();
	//		for (Iterator iter = matches.iterator(); iter.hasNext();) {
	//			Unit candidate = (Unit) iter.next();
	//			String description = NLS.bind(DeployCoreMessages.Resolution_host_0_on_1, 
	//					srcUnit.getDisplayName() == null ? srcUnit.getName() : srcUnit.getDisplayName(), 
	//					candidate.getDisplayName() == null ? candidate.getName() : candidate.getDisplayName());
	//
	//			LinkDescriptor[] linkDescriptors = (LinkDescriptor[]) candidateToLDs.get(candidate);
	//			UnitDescriptor candidateUnitUD = (UnitDescriptor) candidateToUD.get(candidate);
	//			// Only want to offer one hosting resolution to any particular target.
	//			if (linkDescriptors.length > 0) {
	//				resolutionsList.add(new GenericHostingRequirementSatisfactionResolution(context, this, 
	//					linkDescriptors[0], candidateUnitUD, description));
	//			}
	//		}
	//		
	//		IDeployResolution resolutions[] = new IDeployResolution[resolutionsList.size()];
	//		for (int i=0; i<resolutionsList.size(); i++) {
	//			resolutions[i] = (IDeployResolution)resolutionsList.get(i);
	//		}
	//		return resolutions;
	//	}
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
				if (ld.getType().equals(LinkType.HOSTING)) {
					description = NLS.bind(DeployCoreMessages.Resolution_host_0_on_1, srcUnit
							.getCaptionProvider().title(srcUnit), candidate.getCaptionProvider()
							.titleWithContext(candidate));
					//							srcUnit.getDisplayName() == null ? srcUnit.getName() : srcUnit.getDisplayName(), candidate
					//									.getDisplayName() == null ? candidate.getName() : candidate.getDisplayName());

				} else if (ld.getType().equals(LinkType.CONSTRAINT)) {
					if (!ld.getSourceUnit().equals(srcUnit)) {
						continue;
					}
					description = NLS.bind(DeployCoreMessages.Resolution_logically_host_0_on_1, srcUnit
							.getCaptionProvider().title(srcUnit), candidate.getCaptionProvider()
							.titleWithContext(candidate));
					//							srcUnit
					//							.getDisplayName() == null ? srcUnit.getName() : srcUnit.getDisplayName(), candidate
					//							.getDisplayName() == null ? candidate.getName() : candidate.getDisplayName());
				}
				resolutionsList.add(new GenericHostingRequirementSatisfactionResolution(context, this,
						linkDescriptors[0], candidate, description));
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
		LinkType[] linkTypes = new LinkType[] { LinkType.HOSTING, LinkType.CONSTRAINT };

		DeployValidatorService dvs = context.getDeployValidatorService();

		List<Unit> retVal = new ArrayList<Unit>();

		Topology top = srcUnit.getEditTopology();
		//		DiscoveryFilter filter = DiscoveryFilterFactory.createFindPossibleHostsFilter(srcUnit, top);
		//		List possibleHostsUnitDescriptors = TopologyDiscovererService.INSTANCE.findAll(filter);
		////		for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
		////			Unit candidate = (Unit) it.next();
		//		for (Iterator it = possibleHostsUnitDescriptors.iterator(); it.hasNext();) {
		//			UnitDescriptor candidateUnitUD = (UnitDescriptor)it.next();
		//			if (candidateUnitUD == null) {
		//				continue;
		//			}
		//			Unit candidate = candidateUnitUD.getUnitValue();
		//			if (candidate == null) {
		//				continue;
		//			}
		//			candidateToUD.put(candidate, candidateUnitUD);			
		//			if (candidate != srcUnit) {
		//				LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(candidate, srcUnit, linkTypes);
		//				if (linkDescriptorArray.length > 0) {
		//					retVal.add(candidate);
		//					candidateToLDs.put(candidate, linkDescriptorArray);
		//				}
		//			}
		//		}

		// Per agreement, look only in local topology
		for (Iterator<Unit> it = top.findAllUnits(); it.hasNext();) {
			Unit candidate = it.next();

			if (candidate == null) {
				continue;
			}
			if (candidate != srcUnit) {
				LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(candidate, srcUnit,
						linkTypes);
				if (linkDescriptorArray.length > 0) {
					retVal.add(candidate);
					candidateToLDs.put(candidate, linkDescriptorArray);
				}
			}
		}

		return retVal;
	}
}
