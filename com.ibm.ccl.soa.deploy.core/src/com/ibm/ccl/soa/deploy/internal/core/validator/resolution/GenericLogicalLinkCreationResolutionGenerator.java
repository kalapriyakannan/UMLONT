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

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
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
 * Generates logical link creation resolutions on a unit with available logical links
 * 
 * @author barnold
 */
public class GenericLogicalLinkCreationResolutionGenerator extends DeployResolutionGenerator {

	private final Map<Unit, LinkDescriptor[]> candidateToLDs = new HashMap<Unit, LinkDescriptor[]>();

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		Unit unit = null;
		if (status.getDeployObject() instanceof Unit) {
			unit = (Unit) status.getDeployObject();
		}

		if (!(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED.equals(status.getProblemType()) || ICoreProblemType.UNIT_NOT_HOSTED
				.equals(status.getProblemType()))) {
			return false;
		}
		// Same rules as set-to-installed resolution.
		if ((ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED.equals(status.getProblemType()) || ICoreProblemType.UNIT_NOT_HOSTED
				.equals(status.getProblemType()))
				&& unit != null && !unit.getInitInstallState().equals(InstallState.UNKNOWN_LITERAL)) {
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
		DeployModelObject dmo = status.getDeployObject();
		Requirement sourceReq = null;
		if (dmo == null) {
			return new IDeployResolution[0];
		}
		if (dmo instanceof Requirement) {
			sourceReq = (Requirement) dmo;
			dmo = dmo.getParent();
		}
		if (!(dmo instanceof Unit)) {
			return new IDeployResolution[0];
		}
		Unit sourceUnit = (Unit) dmo;
		List<Unit> matches = calculateMatches(sourceUnit, sourceReq, context);
		List<IDeployResolution> resolutionsList = new ArrayList<IDeployResolution>();
		for (Iterator<Unit> iter = matches.iterator(); iter.hasNext();) {
			Unit candidate = iter.next();

			String description = null;
			if (null != sourceReq) {
				description = NLS.bind(DeployCoreMessages.Resolution_create_logical_link_from_0_to_1,
						new Object[] {
								null == sourceReq.getDisplayName() ? sourceReq.getName() : sourceReq
										.getDisplayName(), candidate.getCaptionProvider().title(candidate) });
			} else {
				description = NLS.bind(DeployCoreMessages.Resolution_create_logical_link_to_0,
						candidate.getCaptionProvider().title(candidate));
			}

			LinkDescriptor[] linkDescriptor = candidateToLDs.get(candidate);
			for (int j = 0; j < linkDescriptor.length; j++) {
				resolutionsList.add(new GenericLogicalLinkCreationResolution(context, this,
						linkDescriptor[j], candidate, description));
			}
		}

		IDeployResolution resolutions[] = new IDeployResolution[resolutionsList.size()];
		for (int i = 0; i < resolutionsList.size(); i++) {
			resolutions[i] = resolutionsList.get(i);
		}
		return resolutions;
	}

	// Adapted from SelectTargetWizard
	private List<Unit> calculateMatches(Unit sourceUnit, Requirement sourceReq,
			IDeployResolutionContext context) {
		LinkType[] linkTypes = new LinkType[] { LinkType.CONSTRAINT };
		DeployValidatorService dvs = context.getDeployValidatorService();

		List<Unit> retVal = new ArrayList<Unit>();

		Topology top = sourceUnit.getEditTopology();
		for (Iterator<Unit> it = top.findAllUnits(); it.hasNext();) {
			Unit candidate = it.next();
			if (candidate != sourceUnit) {
				LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(sourceUnit, sourceReq,
						candidate, null, linkTypes);
				if (linkDescriptorArray.length > 0) {
					retVal.add(candidate);
					candidateToLDs.put(candidate, linkDescriptorArray);
				}
			}
		}

		return retVal;
	}
}
