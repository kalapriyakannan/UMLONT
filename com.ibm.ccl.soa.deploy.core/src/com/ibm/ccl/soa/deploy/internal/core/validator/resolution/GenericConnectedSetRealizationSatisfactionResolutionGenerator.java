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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.IAutoRealizationValidators;
import com.ibm.ccl.soa.deploy.internal.core.validator.IDeployStatusWithDataObject;

/**
 * Generates realization requirement satisfaction resolutions for realization of a hosting stack on
 * a conceptual unit that is not realized
 */
public class GenericConnectedSetRealizationSatisfactionResolutionGenerator extends
		DeployResolutionGenerator {

	private IDeployResolution resolutions[];

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status.getDeployObject() instanceof Unit)) {
			return false;
		}

		if (!ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
			return false;
		}

		if (!IDeployCoreValidators.CONCEPTUAL_UNIT_001.equals(status.getValidatorID())) {
			return false;
		}

		resolutions = getResolutions(context);
//		if (resolutions.length >= 1) {
		if (resolutions.length == 1) {
			return true;
		}

		return false;

	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (resolutions != null) {
			return resolutions;
		}
		IDeployStatus status = context.getDeployStatus();
		Unit srcUnit = (Unit) status.getDeployObject();

		IDeployStatusWithDataObject statusWithData = null;
		for (Iterator<IDeployStatus> deployStatusIterator = new DeployStatusIterator(srcUnit); deployStatusIterator
				.hasNext();) {
			IDeployStatus workingStatus = deployStatusIterator.next();
			if (correctStatusForResolution(workingStatus)) {
				statusWithData = (IDeployStatusWithDataObject) workingStatus;
				break;
			}
		}
		if (statusWithData == null) {
			// Resolutions may appear after long-running validation, so do not record failure
			return new IDeployResolution[] {};
		}

		List<Map<Unit, Unit>> csrMapsList = (List<Map<Unit, Unit>>) statusWithData.getDataObject();
		assert csrMapsList != null; // Should not be null
		if (csrMapsList == null) {
			return new IDeployResolution[0];
		}
		List<IDeployResolution> resolutionsList = new ArrayList<IDeployResolution>();
		for (Iterator<Map<Unit, Unit>> csrMapsIter = csrMapsList.iterator(); csrMapsIter.hasNext();) {
			Map<Unit, Unit> csrMap = csrMapsIter.next();
			Unit candidate = csrMap.get(srcUnit);
			if (candidate == null) {
				continue;
			}
			if (csrMap.size() > 1) {
				String description = NLS.bind(
						DeployCoreMessages.Resolution_realize_set_at_0_by_set_at_1, srcUnit
								.getCaptionProvider().titleWithContext(srcUnit), candidate
								.getCaptionProvider().titleWithContext(candidate));

				resolutionsList.add(new GenericConnectedSetRealizationSatisfactionResolution(context,
						this, srcUnit, candidate, csrMap, description));
			}
		}

		IDeployResolution resolutionsRet[] = new IDeployResolution[resolutionsList.size()];
		for (int i = 0; i < resolutionsList.size(); i++) {
			resolutionsRet[i] = resolutionsList.get(i);
		}
		resolutions = resolutionsRet;
		return resolutionsRet;
	}

	private boolean correctStatusForResolution(IDeployStatus status) {
		if (!ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
			return false;
		}

		if (!IAutoRealizationValidators.CONCEPTUAL_AUTO_REALIZATION_AVAILABLE.equals(status
				.getValidatorID())) {
			return false;
		}

		if (!(status instanceof IDeployStatusWithDataObject)) {
			return false;
		}

		if (!(((IDeployStatusWithDataObject) status).getDataObject() instanceof List)) {
			return false;
		}

		return true;
	}
}
