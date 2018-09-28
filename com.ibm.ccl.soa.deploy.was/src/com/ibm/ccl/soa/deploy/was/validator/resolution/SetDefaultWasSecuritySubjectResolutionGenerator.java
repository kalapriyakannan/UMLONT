/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.RemoveConstraintResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.was.WasDefaultSecuritySubjectEnum;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolution generator to create a {@link RemoveConstraintResolution}
 */
public class SetDefaultWasSecuritySubjectResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		DeployStatus status = (DeployStatus) context.getDeployStatus();

		Constraint constraint = (Constraint) status.getDeployObject();

		String setEverybody = DeployNLS.bind(
				DeployCoreMessages.Resolution_set_attribute_0_to_value_1, new Object[] {
						WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT,
						WasDefaultSecuritySubjectEnum.EVERYONE_LITERAL });
		String allAuthenticated = DeployNLS.bind(
				DeployCoreMessages.Resolution_set_attribute_0_to_value_1, new Object[] {
						WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT,
						WasDefaultSecuritySubjectEnum.ALL_AUTHENTICATED_LITERAL });

		return new IDeployResolution[] {
				new SetConstraintAttributeValueResolution(context, this, setEverybody, constraint,
						WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT
								.getName(), WasDefaultSecuritySubjectEnum.EVERYONE_LITERAL.toString()),
				new SetConstraintAttributeValueResolution(context, this, allAuthenticated, constraint,
						WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT__WAS_SECURITY_SUBJECT
								.getName(), WasDefaultSecuritySubjectEnum.ALL_AUTHENTICATED_LITERAL
								.toString()) };

	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (null == status) {
			return false;
		}

		if (!(status instanceof DeployAttributeStatus)) {
			return false;
		}

		DeployAttributeStatus aStatus = (DeployAttributeStatus) status;

		if (!CorePackage.Literals.CONSTRAINT.isSuperTypeOf(aStatus.getDeployObject().getEObject()
				.eClass())) {
			return false;
		}

		Constraint constraint = (Constraint) aStatus.getDeployObject();

		String attributeName = aStatus.getAttributeName();

		if (IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND
				.equals(status.getProblemType())
				|| IWASProblemType.WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL
						.equals(status.getProblemType())) {
			if (!DeployModelObjectUtil.isSettable(constraint, attributeName)) {
				return false;
			}

			return true;
		}

		return false;
	}
}
