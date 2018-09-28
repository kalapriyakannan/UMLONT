/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Check that target unit is hosted on an OS.
 */
public class EAR2DB2GuardDbUserCheck implements IConstraintResolutionPrecondition {

	public IStatus evaluate(Constraint constraint, DeployModelObject constraintContext,
			IProgressMonitor monitor) {
		DatabaseUnit targetUnit = EarToDbUtil.getDatabaseUnitFromConstraint(constraint,
				constraintContext, monitor);
		if (null == targetUnit) {
			return createFailingStatus(constraint, constraintContext);
		}

		Topology topology = targetUnit.getEditTopology();

		Unit instanceUnit = TopologyDiscovererService.INSTANCE.findHost(targetUnit,
				Db2Package.Literals.DB2_INSTANCE_UNIT, topology, monitor);

		if (null == instanceUnit) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}
		Unit osUnit = TopologyDiscovererService.INSTANCE.findHost(targetUnit,
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);
		if (null == osUnit) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		Unit userUnit = TopologyDiscovererService.INSTANCE.findTarget(instanceUnit,
				OsPackage.Literals.USER, OsPackage.Literals.USER_UNIT, topology, monitor);
		if (null == userUnit) {
//			return IConstraintResolutionPrecondition.PRECONDITION_FAILS;
			return createFailingStatus(constraint, constraintContext);
		}

		Unit userOsUnit1 = TopologyDiscovererService.INSTANCE.findHost(userUnit,
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);

		if (!TopologyDiscovererService.INSTANCE.isSameUnit(osUnit, userOsUnit1)) {
//			return IConstraintResolutionPrecondition.PRECONDITION_FAILS;
			return createFailingStatus(constraint, constraintContext);
		}

		return ConstraintUtil.PRECONDITION_HOLDS;

	}

	private IStatus createFailingStatus(Constraint constraint, DeployModelObject context) {
		return new DatasourceSatisfactionStatus(IStatus.ERROR,
				IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
				IWasDb2ProblemType.EAR2DBLL_DB_USERS_ABSENT,
				Messages.Validator_EAR2DbLL_DB_Users_Absent, new Object[] {}, constraint, context);

	}

}
