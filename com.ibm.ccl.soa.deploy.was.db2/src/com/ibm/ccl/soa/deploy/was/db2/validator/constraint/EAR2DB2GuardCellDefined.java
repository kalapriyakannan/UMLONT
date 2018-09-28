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
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;

/**
 * Check that the Was cell unit can be identified
 */
public class EAR2DB2GuardCellDefined implements IConstraintResolutionPrecondition {

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
		if (null == wasUnit) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		WebsphereContext wasContext = new WebsphereContext(wasUnit);
		WasCellUnit cellUnit = wasContext.getCellUnit();
		if (null != cellUnit) {
			return ConstraintUtil.PRECONDITION_HOLDS;
		}
		//The utility method should have returned a target realized was unit
		//if one was available.  If the was unit is conceptual then we cannot
		//determine the validity of this constraint.
		if (wasUnit.isConceptual()) {
			return ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
		}

		return new DatasourceSatisfactionStatus(IStatus.ERROR,
				IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
				IWasDb2ProblemType.DS_SAT_CANNOT_DETERMINE_WAS_CELL,
				Messages.Validator_Cannot_Determine_WAS_Cell, new Object[] {}, constraint,
				constraintContext);

	}

}
