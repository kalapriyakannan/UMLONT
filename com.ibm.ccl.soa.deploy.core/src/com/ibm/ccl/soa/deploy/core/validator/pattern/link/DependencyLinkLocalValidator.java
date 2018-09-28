/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.link;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Validates that the source of the dependency link is hosted on the same unit as the target of the
 * link.
 * <p>
 * Validation can be performed by depth, or by the type of the expected host (unit or capability).
 */
public class DependencyLinkLocalValidator extends DependencyLinkValidator {

	protected EClass capabilityType;

	protected int depth;

	protected int severity;

	protected EClass hostType;

	/**
	 * Construct a validator for local linking.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param capabilityType
	 *           the type of the target
	 * @param depth
	 *           the hosting depth.
	 * @param severity
	 *           the severity of the error.
	 */

	public DependencyLinkLocalValidator(String validatorID, EClass capabilityType, int depth,
			int severity) {
		super(validatorID);
		assert capabilityType != null;
		assert depth > 0;
		this.capabilityType = capabilityType;
		this.depth = depth;
		this.severity = severity;
		hostType = null;
	}

	/**
	 * Construct a validator for local linking.
	 * 
	 * @param validatorID
	 *           the validator identifier.
	 * @param capabilityType
	 *           the type of the source {@link Requirement#getDmoEType()}.
	 * @param hostType
	 *           the unit or capability type of the host.
	 * @param severity
	 *           the severity of the error.
	 */

	public DependencyLinkLocalValidator(String validatorID, EClass capabilityType, EClass hostType,
			int severity) {
		super(validatorID);
		assert capabilityType != null;
		assert hostType != null;
		this.capabilityType = capabilityType;
		depth = -1;
		this.hostType = hostType;
		this.severity = severity;
	}

	/**
	 * Checks that the link source and target are not-null, and that the
	 * {@link Requirement#getDmoEType()} matches.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.link.IDependencyLinkValidator#appliesTo(Requirement,
	 *      Capability, DependencyLink, IDeployValidationContext)
	 */
	public boolean appliesTo(Requirement req, Capability cap, DependencyLink link,
			IDeployValidationContext context) {
		if (req == null || cap == null) {
			return false;
		}

		if (req.getDmoEType() == null) {
			return capabilityType.isInstance(link.getTarget());
		}
		return capabilityType.isSuperTypeOf(req.getDmoEType());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.link.IDependencyLinkValidator#validate(com.ibm.ccl.soa.deploy.core.Requirement,
	 *      com.ibm.ccl.soa.deploy.core.Capability, com.ibm.ccl.soa.deploy.core.DependencyLink,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(Requirement sourceReq, Capability targetCap, DependencyLink link,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (sourceReq == null || targetCap == null) {
			return;
		}

		Unit sourceHost = null;
		Unit targetHost = null;

		if (hostType != null) {
			sourceHost = searchHostByType((Unit) sourceReq.getParent(), context);
			targetHost = searchHostByType((Unit) targetCap.getParent(), context);
		} else {
			sourceHost = searchHostByDepth((Unit) sourceReq.getParent(), context);
			targetHost = searchHostByDepth((Unit) targetCap.getParent(), context);
		}

		if (sourceHost == null || targetHost == null) {
			return;
		}

		compareHosts(sourceReq, targetCap, link, sourceHost, targetHost, context, reporter);
	}

	/**
	 * Compares the found hosts of the link's source and target.
	 * <p>
	 * The hosts may not be the <em>immediate</em> hosts, but ones down the hosting stack.
	 * 
	 * @param sourceReq
	 *           the link source requirement.
	 * @param targetReq
	 *           the link target capability.
	 * @param link
	 *           the link validated (may be null).
	 * @param sourceUnit
	 *           the source unit.
	 * @param targetUnit
	 *           the target unit.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation status reporter.
	 */
	protected void compareHosts(Requirement sourceReq, Capability targetCap, DependencyLink link,
			Unit sourceUnit, Unit targetUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		if (!sourceUnit.equals(targetUnit)) {
			Object[] bindings = new Object[] { link, targetCap, sourceUnit };
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
					validatorID, ICoreProblemType.DEPENDENCY_LINK_TARGET_HOSTING_INVALID,
					DeployCoreMessages.Validator_dependency_link_0_target_1_should_be_hosted_by_2,
					bindings, link);
			reporter.addStatus(status);
		}
	}

	/**
	 * Traverses hostingDepth hosting links down the unit's hosting stack.
	 * 
	 * @param unit
	 *           a unit.
	 * @param context
	 *           the validation context.
	 * @return the host, or null if one does not exist at the specified depth.
	 */
	protected Unit searchHostByDepth(Unit unit, IDeployValidationContext context) {
		if (unit == null) {
			return null;
		}
		for (int i = 0; i < depth; i++) {
			unit = TopologyDiscovererService.INSTANCE.findHost(unit, context.getTopology());
			if (unit == null) {
				return null;
			}
		}
		return unit;
	}

	/**
	 * Returns the first unit down the hosting stack to satisfy {@link #isHostTypeMatch(Unit)}.
	 * 
	 * @param unit
	 *           the unit where the search begins (may be returned).
	 * @param context
	 *           the validation context.
	 * @return the matching unit, or null if not found.
	 */
	protected Unit searchHostByType(Unit unit, IDeployValidationContext context) {
		while (unit != null) {
			if (isHostTypeMatch(unit)) {
				return unit;
			}
			unit = TopologyDiscovererService.INSTANCE.findHost(unit, context.getTopology());
		}
		return null;
	}

	/**
	 * Checks if the unit matches the host type specified in the constructor.
	 * 
	 * @param unit
	 *           the unit to be checked.
	 * @param context
	 *           the validation context.
	 * @return true if the unit or one of its capabilities is of the host type.
	 */
	protected boolean isHostTypeMatch(Unit unit) {
		if (unit == null || hostType == null) {
			return false;
		}

		if (CorePackage.eINSTANCE.getUnit().isSuperTypeOf(hostType)) {
			return hostType.isInstance(unit);
		} else if (CorePackage.eINSTANCE.getCapability().isSuperTypeOf(hostType)) {
			return ValidatorUtils.getFirstCapability(unit, hostType) != null;
		}
		return false;
	}
}
