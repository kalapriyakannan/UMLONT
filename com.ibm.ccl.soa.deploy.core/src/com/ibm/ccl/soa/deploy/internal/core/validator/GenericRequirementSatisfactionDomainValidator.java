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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternCacheService;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.RealizationPatternUtil;

/**
 * Defines a {@link DomainValidator} that tests action preconditions
 */
public class GenericRequirementSatisfactionDomainValidator extends DomainValidator {

	/**
	 * Construct a domain validator.
	 */
	public GenericRequirementSatisfactionDomainValidator() {
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		// Enable realization caches, flush them
		cacheControlOnEntry();
		// For each unrealized conceptual unit, do single-unit realization precomputation.
		// TODO available hosting matches, dependency matches, any other O(N) matches
		for (Iterator<Unit> iter = context.getTopology().findAllUnits(); iter.hasNext();) {
			Unit unit = iter.next();
			if (context.getProgressMonitor().isCanceled()) {
				return;
			}
			if (unit.isConceptual() && ValidatorUtils.getSourceRealizationLinks(unit).size() == 0) {
				realizationPreComputations(unit, context, reporter);
			}
		}
		cacheControlOnExit();
	}

	private void realizationPreComputations(Unit srcUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		LinkType[] linkTypes = new LinkType[] { LinkType.REALIZATION };

		DeployValidatorService dvs = context.getDeployValidatorService();

		Topology top = srcUnit.getEditTopology();
		if (top == null) {
			return;
		}

		Map<Unit, LinkDescriptor> candidateToLD = new HashMap<Unit, LinkDescriptor>();

		// Per agreement, look only in local topology
		for (Iterator<Unit> it = top.findAllUnits(); it.hasNext();) {
			if (context.getProgressMonitor().isCanceled()) {
				return;
			}
			Unit candidate = it.next();

			if (candidate == null) {
				continue;
			}
			if (candidate != srcUnit) {
				LinkDescriptor[] linkDescriptorArray = RealizationPatternCacheService.INSTANCE
						.getPossibleLinks(srcUnit, candidate, linkTypes, dvs);
				if (linkDescriptorArray != null && linkDescriptorArray.length > 0) {
					if (validityFilter(top, srcUnit, candidate, context)) {
						LinkDescriptor ld = linkDescriptorArray[0];
						if (ld.getType().equals(LinkType.REALIZATION)) {
							candidateToLD.put(candidate, ld);
						}
					}
				}
			}
		}
		if (candidateToLD.keySet().size() > 0) {
			IDeployStatusWithDataObject status = new DeployStatusWithDataObject(IStatus.OK,
					IAutoRealizationValidators.CONCEPTUAL_UNIT_SINGLE_UNIT_REALIZATION_AVAILABLE,
					ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED,
					DeployCoreMessages.GenericRequirementSatisfactionDomainValidator, new Object[] {},
					srcUnit, candidateToLD);
			reporter.addStatus(status);
		}
	}

	// Do limited additional checking beyond that done by the RealizationLinkMatcher
	private boolean validityFilter(Topology top, Unit u, Unit candidate,
			IDeployValidationContext context) {
		if (top == null || u == null || candidate == null) {
			return false;
		}
		// TODO consider reworking this to use constraint evaluator in speculative mode
		List<Unit> dlhTargets = deferredHostingLinkTargets(top, u, candidate, context);
		// If any deferred hosting links to unit
		for (Unit dlhTarget : dlhTargets) {
			dlhTarget = (Unit) RealizationLinkUtil.getFinalRealization(dlhTarget);
			Unit hostInStack = ValidatorUtils.findHostInStack(candidate, dlhTarget.eClass());
			if (hostInStack != null) {
				// if deferred host is already realized to candidate, or deferred host is realizable by candidate
				if (dlhTarget == hostInStack
						|| RealizationPatternUtil.realizable(dlhTarget, hostInStack, false, false,
								RealizationPatternCacheService.INSTANCE, DeployValidatorService
										.getDefaultValidatorService())) {
					return true;
				} else {
					// Not realizable
					return false;
				}
			}
		}
		return true;
	}

	private List<Unit> deferredHostingLinkTargets(Topology top, Unit u, Unit candidateU,
			IDeployValidationContext context) {
		List<Unit> dhlSource = new ArrayList<Unit>();
		Collection<ConstraintLink> clColl = new LinkedHashSet<ConstraintLink>();
		clColl.addAll(top.getRelationships().getConstraintLinkTargetsLinks(u));
		for (ConstraintLink cl : clColl) {
			if (context.getProgressMonitor().isCanceled()) {
				return Collections.emptyList();
			}
//		for (Iterator<ConstraintLink> clIter = top.findAllConstraintLinks(); clIter.hasNext();) {
//			ConstraintLink cl = clIter.next();
			// We want only units, so it's OK if constraints to objects like
			// imports are added.
			Unit sourceUnit = ValidatorUtils.getUnit(cl.getSource());
			Unit targetUnit = ValidatorUtils.getUnit(cl.getTarget());
			if (sourceUnit != null && targetUnit != null && sourceUnit.equals(u)) {
				for (Iterator<Constraint> constraintsIter = cl.getConstraints().iterator(); constraintsIter
						.hasNext();) {
					Constraint c = constraintsIter.next();
					if (c instanceof DeferredHostingConstraint) {
						dhlSource.add(targetUnit);
					}
				}
			}
		}
		return dhlSource;
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
		RealizationPatternCacheService.INSTANCE.enterRealizationNavigationCache();
	}

	private void cacheControlOnExit() {
	}
}
