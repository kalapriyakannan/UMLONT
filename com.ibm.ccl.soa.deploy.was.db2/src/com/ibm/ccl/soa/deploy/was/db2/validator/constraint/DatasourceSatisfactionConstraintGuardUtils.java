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
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDB2Plugin;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Common methods used by precondition testers (guards) for {@link DatasourceSatisfactionConstraint}.
 */
public class DatasourceSatisfactionConstraintGuardUtils {

	// shorthand for types we will refer to in this class
	private static final EClass ejbType = J2eePackage.Literals.EJB_MODULE;
	private static final EClass webType = J2eePackage.Literals.WEB_MODULE;
	private static final EClass earType = J2eePackage.Literals.EAR_MODULE;
	private static final EClass serverType = WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT;
	private static final EClass clusterType = WasPackage.Literals.WAS_CLUSTER_UNIT;
	private static final EClass osType = OsPackage.Literals.OPERATING_SYSTEM_UNIT;

	/**
	 * Retrieve a host of a particular type from the hosting stack of a unit, using discovery
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param type
	 *           the type of the hoster in the hosting stack
	 * @param topology
	 *           the scope of the search; typically the current edit toplogy
	 * @param monitor
	 * @return the hoster or null if none of the specified type can be found
	 */
	public static Unit findHostByTypeOrLast(Unit unit, EClass type, Topology topology,
			IProgressMonitor monitor) {
		Unit lastU = unit;
		while (null != lastU && !type.isSuperTypeOf(lastU.getEObject().eClass())) {
			Unit u = TopologyDiscovererService.INSTANCE.findHost(lastU, topology, monitor);
			if (u == null) {
				if (isModuleType(lastU)) {
					u = ValidatorUtils.discoverGroupByUnitType(lastU, earType, monitor);
				}
				if (u == null) {
					return lastU;
				}
			}
			lastU = u;
		}
		return lastU;
	}

	private static boolean isModuleType(Unit u) {
		if (null == u) {
			return false;
		}

		EClass uType = u.getEObject().eClass();
		return ejbType.isSuperTypeOf(uType) || webType.isSuperTypeOf(uType);
	}

	/**
	 * Get the hosting Was server or cluster for a module
	 * 
	 * @param module
	 *           the module
	 * @param topology
	 *           the topology; typically the current edit topology
	 * @param monitor
	 *           progress monitor
	 * @return the hosting was server or cluster
	 */
	public static Unit getWasUnit(Unit module, Topology topology, IProgressMonitor monitor) {
		Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(module, topology, monitor);

		if (null == wasUnit) {
			// it may be that the module is contained in an EAR Module that is hosted on the server/cluster
			EarModule earModule = (EarModule) ValidatorUtils.findGroupByUnitType(module, earType);
			if (null == earModule) {
				return null;
			}
			wasUnit = TopologyDiscovererService.INSTANCE.findHost(earModule, topology, monitor);
		}

		if (null == wasUnit) {
			return null;
		}

		EClass wasUnitType = wasUnit.getEObject().eClass();
		if (serverType.isSuperTypeOf(wasUnitType) || clusterType.isSuperTypeOf(wasUnitType)) {
			return wasUnit;
		}

		return null;
	}

	/**
	 * Return a status about whether or not the hosting {@link OperatingSystemUnit} can be found or
	 * not.
	 * 
	 * @param hostee
	 *           the unit for which an OS is sought
	 * @param problemType
	 *           the problem type that should be reported if an OS cannot be found
	 * @param message
	 *           the message that accompanies the problem type
	 * @param constraint
	 *           the constraint for which it is sought
	 * @param context
	 *           the constraint context
	 * @param monitor
	 *           a progress monitor
	 * @return a status identifying the status of the operating system
	 */
	public static IStatus createOsStatus(Unit hostee, String problemType, String message,
			Constraint constraint, DeployModelObject context, IProgressMonitor monitor) {
		if (null == hostee || null == constraint || null == context) {
			return null;
		}

		Unit host = findHostByTypeOrLast(hostee, osType, hostee.getEditTopology(), monitor);

		if (osType.isSuperTypeOf(host.getEObject().eClass())) {
			// there is a hosting OS; success
			return ConstraintUtil.PRECONDITION_HOLDS;
		}

		if (InstallState.INSTALLED_LITERAL.equals(host.getInitInstallState())) {
			// the unit is "installed" somewhere but we don't know the operating system
			// in this case we will provide a warning only.  This state should not prevent
			// us from completing our database configuration.
			// However, we need to be sure that enough of the model is available to us
			return new DatasourceSatisfactionStatus(IStatus.WARNING,
					IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
					IWasDb2ProblemType.DS_SAT_CANNOT_DETERMINE_OPERATING_SYSTEM,
					Messages.Validator_Cannot_Determine_Hosting_Cardinality, new Object[] {},
					constraint, context);

		}

		if (host.isPublic()) {
			// the bottom of the stack as we found it is public
			// this means it can be hosted when imported into another topology
			// so we don't report an error; instead we make it a warning.
			return new DatasourceSatisfactionStatus(IStatus.WARNING,
					IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION, problemType,
					message, new Object[] {}, constraint, context);
		}

		// we couldn't come up with a reason to downgrade the error
		return new DatasourceSatisfactionStatus(IStatus.ERROR,
				IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION, problemType,
				message, new Object[] {}, constraint, context);
	}

	/**
	 * Adds a new status to an existing status (creating a {@link MultiStatus} if necessary.
	 * 
	 * @param status
	 *           the existing status
	 * @param aNewStatus
	 *           the new status to be added
	 * @return existing status with new status added
	 */
	public static IStatus addStatus(IStatus status, IStatus aNewStatus) {
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
