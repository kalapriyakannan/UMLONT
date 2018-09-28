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

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Check that target unit is hosted on an OS.
 * <p>
 * The guard is not evaluatable if the input database is null.
 * <p>
 * An {@link IStatus#WARNING} is returned if the input database is public; ie, the hosting instance
 * can be set if the current topology were imported into another topology
 * <p>
 * Otherwise, a {@link IStatus#ERROR} is returned if the hosting database instance cannot be
 * identified.
 */
public class EAR2DB2GuardInstanceCheck implements IConstraintResolutionPrecondition {

	public IStatus evaluate(Constraint constraint, DeployModelObject constraintContext,
			IProgressMonitor monitor) {

		Unit targetUnit = EarToDbUtil.getDatabaseUnitFromConstraint(constraint, constraintContext,
				monitor);

		if (null == targetUnit) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		Topology topology = targetUnit.getEditTopology();

		Unit instanceUnit = TopologyDiscovererService.INSTANCE.findHost(targetUnit,
				Db2Package.Literals.DB2_INSTANCE_UNIT, topology, monitor);

		if (null == instanceUnit) {
			// if targetUnit is public then we can still achieve this later
			int severity = targetUnit.isPublic() ? IStatus.WARNING : IStatus.ERROR;

			return new DatasourceSatisfactionStatus(severity,
					IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
					IWasDb2ProblemType.EAR2DBLL_DB_INSTANCE_ABSENT,
					Messages.Validator_EAR2DbLL_DB_Instance_Absent, new Object[] {}, constraint,
					constraintContext);
		}

		DB2Instance instance = (DB2Instance) ValidatorUtils.getFirstCapability(instanceUnit,
				Db2Package.Literals.DB2_INSTANCE);
		if (null == instance) {
			// can't solve every problem
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		String name = instance.getHostname();
		if (null == name || 0 == name.length()) {
			int severity = isSettable(instance, Db2Package.Literals.DB2_INSTANCE__HOSTNAME.getName()) ? IStatus.WARNING
					: IStatus.ERROR;
			return new DatasourceSatisfactionStatus(severity,
					IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
					IWasDb2ProblemType.DS_CONSTRAINT_DB_INSTANCE_HOSTNAME_UNSPECIFIED,
					Messages.Validator_Ds_Constraint_Hostname_Unspecified, new Object[] {}, constraint,
					constraintContext);
		}

		return ConstraintUtil.PRECONDITION_HOLDS;
	}

	/**
	 * Checks if the attribute (or extended attribute) is present on the dmo and settable/editable -
	 * mutable and public-editable.
	 * 
	 * @param dmo
	 *           a deploy model object
	 * @param attributeName
	 *           the short name of the attribute
	 * @return true if the attribute (or extended attribute) is present on the dmo and is mutable and
	 *         public editable
	 * 
	 * @see DeployModelObjectUtil#isMutable(DeployModelObject, org.eclipse.emf.ecore.EAttribute)
	 */
	public static boolean isSettable(DeployModelObject dmo, String attributeName) {
		if (dmo == null || attributeName == null) {
			return false;
		}
		if (!dmo.getTopology().getConfigurationContract().isPublicEditable(dmo, attributeName)) {
			// if (!dmo.isPublicEditable(attributeName)) {
			return false;
		}
		return DeployModelObjectUtil.isMutable(dmo, attributeName);
	}

}
