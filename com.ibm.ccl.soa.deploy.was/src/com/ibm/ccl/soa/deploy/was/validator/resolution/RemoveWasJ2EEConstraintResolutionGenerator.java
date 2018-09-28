/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.RemoveConstraintResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolution generator to create a {@link RemoveConstraintResolution}
 */
public class RemoveWasJ2EEConstraintResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		DeployStatus status = (DeployStatus) context.getDeployStatus();

		Constraint constraint = (Constraint) status.getDeployObject();

		IDeployResolution resolution = new RemoveConstraintResolution(context, this, DeployNLS.bind(
				WasDomainMessages.Resolution_Remove_Constraint, constraint), constraint);

		return new IDeployResolution[] { resolution };

	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (null == status) {
			return false;
		}

		DeployModelObject obj = status.getDeployObject();
		if (null == obj) {
			return false;
		}

		if (!CorePackage.Literals.CONSTRAINT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		if (IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT.equals(status
				.getProblemType())
				|| IWASProblemType.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT.equals(status
						.getProblemType())
				|| IWASProblemType.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT.equals(status
						.getProblemType())
				|| IWASProblemType.WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT.equals(status
						.getProblemType())
				|| IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT.equals(status
						.getProblemType())) {

			// check that resolution will be able to do what it needs to do:
			// (a) remove constraint from a unit; must be in edit topology
			if (obj.getTopology() != obj.getEditTopology()) {
				return false;
			}
			return true;
		}

		return false;
	}

}
