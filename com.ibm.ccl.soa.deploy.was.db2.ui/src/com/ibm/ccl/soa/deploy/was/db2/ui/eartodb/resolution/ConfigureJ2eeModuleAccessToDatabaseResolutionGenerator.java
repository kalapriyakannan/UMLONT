/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDb2Package;
import com.ibm.ccl.soa.deploy.was.db2.ui.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.constraint.EarToDbUtil;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Generator for resolution to configure access via a datasource reference to a database.
 */
public class ConfigureJ2eeModuleAccessToDatabaseResolutionGenerator extends
		DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		String description = Messages.Resolution_Configure_Database_Access;

		Constraint dsCommConstraint = (Constraint) context.getDeployStatus().getDeployObject();

		DatasourceSatisfactionStatus status = (DatasourceSatisfactionStatus) context
				.getDeployStatus();
		DeployModelObject constraintContext = status.getConstraintContext();

		Requirement source = EarToDbUtil.getDatasourceRequirementFromConstraint(dsCommConstraint,
				constraintContext, context.getProgressMonitor());
		Database target = EarToDbUtil.getDatabaseFromConstraint(dsCommConstraint, constraintContext,
				context.getProgressMonitor());

		return new IDeployResolution[] { new ConfigureJ2eeModuleAccessToDatatbaseResolution(context,
				this, description, source, target, (DatasourceSatisfactionConstraint) dsCommConstraint,
				status.getUser(), status.getUserPassword()) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status instanceof DatasourceSatisfactionStatus)) {
			return false;
		}

		if (!IWasDb2ProblemType.EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN.equals(status
				.getProblemType())) {
			return false;
		}

		// this resolution works on DatasourceSatisfactionConstraint
		DeployModelObject object = status.getDeployObject();
		EClass objectType = object.getEObject().eClass();
		if (!WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT.isSuperTypeOf(objectType)) {
			return false;
		}

		// source and target are not null
		DeployModelObject constraintContext = ((DatasourceSatisfactionStatus) status)
				.getConstraintContext();
		if (null == constraintContext) {
			return false;
		}
		if (null == EarToDbUtil.getDatabaseFromConstraint((DatasourceSatisfactionConstraint) object,
				constraintContext, context.getProgressMonitor())) {
			return false;
		}
		if (null == EarToDbUtil.getDatasourceRequirementFromConstraint(
				(DatasourceSatisfactionConstraint) object, constraintContext, context
						.getProgressMonitor())) {
			return false;
		}

		return true;
	}

}
