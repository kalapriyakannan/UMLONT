/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;

/**
 * Validates that the source of the dependency link is hosted on the same unit as the target of the
 * link.
 * <p>
 * Validation can be performed by depth, or by the type of the expected host (unit or capability).
 */
public class DependencyLinkCommonCellValidator extends DependencyLinkValidator {

	protected EClass capabilityType;

	protected int severity;

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

	public DependencyLinkCommonCellValidator(String validatorID, EClass capabilityType, int severity) {
		super(validatorID);
		assert capabilityType != null;
		this.capabilityType = capabilityType;
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
			return false;
		}
		if (!capabilityType.isSuperTypeOf(req.getDmoEType())) {
			return false;
		}

		return true;
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

		Unit sourceBaseCell = null;
		Unit targetBaseCell = null;

		sourceBaseCell = getWasCell((Unit) sourceReq.getParent());
		targetBaseCell = getWasCell((Unit) targetCap.getParent());

		if (sourceBaseCell == null || targetBaseCell == null) {
			return;
		}

		compareHosts(sourceReq, targetCap, link, sourceBaseCell, targetBaseCell, context, reporter);
	}

	/**
	 * Compares the found hosts of the link's source and target.
	 * <p>
	 * The hosts may not be the <em>immediate</em> hosts, but ones down the hosting stack.
	 * 
	 * @param link
	 *           the link validated.
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
		if (!sourceUnit.equals(targetUnit)) {
			Object[] bindings = new Object[] { targetCap };
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
					validatorID, ICoreProblemType.DEPENDENCY_LINK_TARGET_HOSTING_INVALID,
					WasDomainMessages.Validator_Was_dependency_link_target_0_should_be_in_same_cell,
					bindings, link);
			reporter.addStatus(status);
		}

	}

	/**
	 * Returns the first unit down the hosting stack to satisfy {@link #isHostTypeMatch(Unit)}.
	 * 
	 * @param unit
	 *           the unit where the search begins (may be returned).
	 * @param hostType
	 *           type of the host to be returned
	 * @return the matching unit, or null if not found.
	 */
	protected Unit searchHostByType(Unit unit, EClass hostType) {
		Topology topology = unit.getTopology();
		return TopologyDiscovererService.INSTANCE.findHost(unit, hostType, topology);
	}

	protected WasCellUnit getWasCell(Unit unit) {
		Topology topology = unit.getTopology();

		Unit wasUnit = getWasUnit(unit);
		if (null == wasUnit) {
			return null;
		}

		if (wasUnit instanceof WebsphereAppServerUnit) {
			WebsphereAppServerUnit wasServer = (WebsphereAppServerUnit) wasUnit;
			UnitDescriptor wasNodeUD = WebsphereContext.getWasNodeUD(wasServer, topology);
			if (null == wasNodeUD) {
				return null;
			}
			WasNodeUnit wasNode = (WasNodeUnit) wasNodeUD.getUnitValue();
			if (null == wasNode) {
				return null;
			}
			UnitDescriptor wasCellUD = WebsphereContext.getWasCellUD(wasNode, topology);
			if (null == wasCellUD) {
				return null;
			}
			return (WasCellUnit) wasCellUD.getUnitValue();
		}

		if (wasUnit instanceof WasNodeUnit) {
			WasNodeUnit wasNode = (WasNodeUnit) wasUnit;
			UnitDescriptor wasCellUD = WebsphereContext.getWasCellUD(wasNode, topology);
			if (null == wasCellUD) {
				return null;
			}
			return (WasCellUnit) wasCellUD.getUnitValue();
		}

		if (wasUnit instanceof WasCellUnit) {
			return (WasCellUnit) wasUnit;
		}

		if (wasUnit instanceof WasClusterUnit) {
			WasClusterUnit wasCluster = (WasClusterUnit) wasUnit;
			UnitDescriptor wasCellUD = WebsphereContext.getWasCellUD(wasCluster, topology);
			if (null == wasCellUD) {
				return null;
			}
			return (WasCellUnit) wasCellUD.getUnitValue();
		}

		return null;
	}

	protected Unit getWasUnit(Unit unit) {
		Unit wasUnit = searchHostByType(unit, WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT);
		if (null != wasUnit) {
			return wasUnit;
		}
		wasUnit = searchHostByType(unit, WasPackage.Literals.WAS_NODE_UNIT);
		if (null != wasUnit) {
			return wasUnit;
		}
		wasUnit = searchHostByType(unit, WasPackage.Literals.WAS_CELL_UNIT);
		if (null != wasUnit) {
			return wasUnit;
		}
		wasUnit = searchHostByType(unit, WasPackage.Literals.WAS_CLUSTER_UNIT);
		return wasUnit;
	}

}
