/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.db2.WasDB2Plugin;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Check that source unit is hosted on an OS.
 * <p>
 * The guard is not evaluatable if the input module is not defined or if the hosting unit is a
 * {@link WasClusterUnit} without any server members.
 * <p>
 * A {@link IStatus#WARNING} is returned if:
 * <ul>
 * <li>At some point an element of the hosting stack is defined as
 * {@link InstallState#INSTALLED_LITERAL} and no further information is available.</li>
 * <li>The unit at the bottom of the hosting stack is public; ie, it can be set if the current
 * topology were imported into another topology.</li>
 * </ul>
 * <p>
 * Otherwise, a {@link IStatus#ERROR} is returned if the hosting operating system cannot be
 * identified.
 */
public class EAR2DB2GuardEarHosted implements IConstraintResolutionPrecondition {

	// shorthand for types we will refer to in this class
	private static final EClass osType = OsPackage.Literals.OPERATING_SYSTEM_UNIT;
	private static final EClass serverType = WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT;
	private static final EClass clusterType = WasPackage.Literals.WAS_CLUSTER_UNIT;

	public IStatus evaluate(Constraint constraint, DeployModelObject constraintContext,
			IProgressMonitor monitor) {
		Unit sourceUnit = EarToDbUtil.getJ2eeModuleFromConstraint(constraint, constraintContext,
				monitor);

		if (null == sourceUnit) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		Topology topology = sourceUnit.getEditTopology();

		Unit wasUnit = DatasourceSatisfactionConstraintGuardUtils.getWasUnit(sourceUnit, topology,
				monitor);

		if (null != wasUnit) {
			EClass wasUnitType = wasUnit.getEObject().eClass();
			if (serverType.isSuperTypeOf(wasUnitType)) {
				// check that hosted on OS
				Unit osUnit = TopologyDiscovererService.INSTANCE.findHost(wasUnit, osType, topology,
						monitor);
				if (null == osUnit) {
					return DatasourceSatisfactionConstraintGuardUtils.createOsStatus(sourceUnit,
							IWasDb2ProblemType.EAR2DBLL_EAR_NOT_HOSTED,
							Messages.Validator_Ear2DbLL_EAR_Not_Hosted, constraint, constraintContext,
							monitor);
				}

				return ConstraintUtil.PRECONDITION_HOLDS;
			}

			if (clusterType.isSuperTypeOf(wasUnitType)) {
				// check that each server is hosted on OS
				IStatus rtnStatus = null;
				List<Unit> servers = ValidatorUtils.discoverMembers(wasUnit, serverType, monitor);
				if (0 == servers.size()) {
					return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
				}
				for (Unit server : servers) {
					Unit osUnit = TopologyDiscovererService.INSTANCE.findHost(server, osType, topology,
							monitor);
					if (null == osUnit) {
						addStatus(rtnStatus, DatasourceSatisfactionConstraintGuardUtils.createOsStatus(
								sourceUnit, IWasDb2ProblemType.EAR2DBLL_EAR_NOT_HOSTED,
								Messages.Validator_Ear2DbLL_EAR_Not_Hosted, constraint, constraintContext,
								monitor));
					}
				}
				// if we got here we didn't find a member requirement for WebsphereAppServerUnits
				rtnStatus = null == rtnStatus ? ConstraintUtil.PRECONDITION_HOLDS : rtnStatus;
				return rtnStatus;
			}
		}

		// EAR was hosted on neither wasServer nor wasCluster !!
		return createNoHostStatus(constraint, constraintContext);

	}

//	private IStatus createFailingStatus(Constraint constraint, DeployModelObject context) {
//		return new DatasourceSatisfactionStatus(IStatus.INFO,
//				IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
//				IWasDb2ProblemType.EAR2DBLL_EAR_NOT_HOSTED, Messages.Validator_Ear2DbLL_EAR_Not_Hosted,
//				new Object[] {}, constraint, context);
//
//	}
//

	private IStatus createNoHostStatus(Constraint constraint, DeployModelObject context) {
		return new DatasourceSatisfactionStatus(IStatus.WARNING,
				IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
				IWasDb2ProblemType.EAR2DBLL_EAR_NOT_HOSTED, Messages.Validator_Ear2DbLL_EAR_Not_Hosted,
				new Object[] {}, constraint, context);
	}

	private IStatus addStatus(IStatus status, IStatus aNewStatus) {
		if (aNewStatus != null) {
			if (status == null) {
				status = aNewStatus;
			} else {
				IStatus oldStatus = status;
				if (!status.isMultiStatus()) {
					status = new MultiStatus(WasDB2Plugin.PLUGIN_ID, 0, new IStatus[] { oldStatus,
							aNewStatus }, DeployCoreMessages.Model_consistency_status_message, null);
				} else {
					MultiStatus multiStatus = (MultiStatus) status;
					multiStatus.add(aNewStatus);
					return multiStatus;
				}
			}
		}
		return status;
	}
}
