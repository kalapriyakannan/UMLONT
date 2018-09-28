/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;

/**
 * Defines a {@link DomainValidator} that tests action preconditions
 */
public class AutoRealizationDomainValidator extends DomainValidator {

	/**
	 * Construct a domain validator.
	 */
	public AutoRealizationDomainValidator() {
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		// Enable realization caches, flush them
		cacheControlOnEntry();
		// For each unrealized conceptual unit, do realization precomputation.
		// Note: realization precomputation short-circuited if it has already been done for the unit as part 
		// of a previous connected-set computation. 
		for (Iterator<Unit> iter = context.getTopology().findAllUnits(); iter.hasNext();) {
			Unit unit = iter.next();
			if (unit.isConceptual() && ValidatorUtils.getSourceRealizationLinks(unit).size() == 0) {
				realizationPreComputations(unit, context, reporter);
			}
			// cancel check to try to prevent concurrent modification exceptions 
			if (context.getProgressMonitor().isCanceled()) {
				cacheControlOnExit();
				return;
			}
		}
		cacheControlOnExit();
	}

	private void realizationPreComputations(Unit u, IDeployValidationContext context,
			IDeployReporter reporter) {
		List<Map<Unit, Unit>> realizationMaps = RealizationPatternCacheService.INSTANCE
				.realizationMapsConnectedSet(u, u.getEditTopology(), context
						.getDeployValidatorService(), context.getProgressMonitor());
		if (realizationMaps != null && realizationMaps.size() > 0) {
			IDeployStatusWithDataObject status = new DeployStatusWithDataObject(IStatus.OK,
					IAutoRealizationValidators.CONCEPTUAL_AUTO_REALIZATION_AVAILABLE,
					ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED,
					DeployCoreMessages.AutoRealizationDomainValidator, new Object[] {}, u,
					realizationMaps);
			reporter.addStatus(status);
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#getGroupID()
	 */
	@Override
	public String getGroupID() {
		return getClass().getName();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#getGroupDescription()
	 */
	@Override
	public String getGroupDescription() {
		return DeployCoreMessages.Model_realization;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	@Override
	protected DomainMatcher createDomainMatcher() {
		// domain matcher should not be supported by this validator
		return null;
	}

	private void cacheControlOnEntry() {
		RealizationPatternCacheService.INSTANCE.leaveRealizationNavigationCache();
		RealizationPatternCacheService.INSTANCE.leaveRealizationPatternCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationNavigationCache();
		RealizationPatternCacheService.INSTANCE.enterRealizationPatternCache();
	}

	private void cacheControlOnExit() {
	}
}
