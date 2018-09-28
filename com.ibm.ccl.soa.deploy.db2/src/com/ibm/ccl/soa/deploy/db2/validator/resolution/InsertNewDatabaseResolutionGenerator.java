/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.ConstraintOnLinkValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.Messages;

/**
 * Resolution generator to generate resolutions to add a new {@link DB2DatabaseUnit}.
 */
public class InsertNewDatabaseResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		String description = Messages.Resolution_create_database;

		Constraint dhConstraint = (Constraint) context.getDeployStatus().getDeployObject();

		DeployModelObject constraintContext = getConstraintContext(dhConstraint);

		return new IDeployResolution[] { new InsertNewDatabaseResolution(context, this, description,
				(Unit) ConstraintOnLinkValidator.getTarget(constraintContext),
				(Unit) ConstraintOnLinkValidator.getSource(constraintContext), null) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		// check status
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		// check problem type
		if (!ICoreProblemType.CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE.equals(status.getProblemType())) {
			return false;
		}

		// this resolution works on {@link DeferredHostingConstraint}
		DeployModelObject object = status.getDeployObject();
		if (object == null) {
			return false;
		}
		EClass objectType = object.getEObject().eClass();
		if (!ConstraintPackage.Literals.DEFERRED_HOSTING_CONSTRAINT.isSuperTypeOf(objectType)) {
			return false;
		}

		// check context is a link
		DeployModelObject link = getConstraintContext((Constraint) object);
		if (null == link) {
			return false;
		}

		// check that hostee is {@link DatabaseComponent}
		DeployModelObject hostee = ConstraintOnLinkValidator.getSource(link);
		if (null == hostee
				|| !DatabasePackage.Literals.DATABASE_COMPONENT.isSuperTypeOf(hostee.getEObject()
						.eClass())) {
			return false;
		}

		// check that host is {@link DB2InstanceUnit} 
		DeployModelObject host = ConstraintOnLinkValidator.getTarget(link);
		if (null == host
				|| !Db2Package.Literals.DB2_INSTANCE_UNIT.isSuperTypeOf(host.getEObject().eClass())) {
			return false;
		}

		// check that can execute desired changes
		// TODO is this the correct check?
		if (!hostee.isMutable() || !host.isPublic()) {
			return false;
		}

		return true;
	}

	private DeployModelObject getConstraintContext(Constraint constraint) {
		DeployModelObject context = constraint.getParent();
		if (null == context) {
			return null;
		}
		if (!CorePackage.Literals.DEPLOY_LINK.isSuperTypeOf(context.getEObject().eClass())) {
			return null;
		}
		return context;
	}
}
