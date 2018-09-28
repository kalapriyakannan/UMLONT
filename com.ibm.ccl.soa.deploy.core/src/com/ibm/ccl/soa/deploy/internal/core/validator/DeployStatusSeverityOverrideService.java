/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.HashSet;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Service that centralizes status severity overrides
 */
public class DeployStatusSeverityOverrideService {

	/** singleton instance of this service */
	public static final DeployStatusSeverityOverrideService INSTANCE = new DeployStatusSeverityOverrideService();
	private final HashSet<String> linkageRequirementUnsatisfiedProblemTypes;
	private final HashSet<String> attributeProblemTypes;

	/**
	 * Private constructor
	 */
	private DeployStatusSeverityOverrideService() {
		linkageRequirementUnsatisfiedProblemTypes = new HashSet<String>();
		linkageRequirementUnsatisfiedProblemTypes
				.add(ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED);
		linkageRequirementUnsatisfiedProblemTypes.add(ICoreProblemType.UNIT_NOT_HOSTED);
		linkageRequirementUnsatisfiedProblemTypes.add(ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED);
		linkageRequirementUnsatisfiedProblemTypes.add(ICoreProblemType.GROUP_IN_CARDINALITY_INVALID);
		linkageRequirementUnsatisfiedProblemTypes.add(ICoreProblemType.GROUP_OUT_CARDINALITY_INVALID);

		attributeProblemTypes = new HashSet<String>();
		attributeProblemTypes.add(ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED);
		attributeProblemTypes.add(ICoreProblemType.OBJECT_ATTRIBUTE_INVALID);
	}

	/**
	 * Modify status severity
	 * 
	 * @param status
	 */
	public void severityOverride(IDeployStatus status) {
		if (status == null) {
			return;
		}
		if (status.getDeployObject() == null || status.getProblemType() == null) {
			return;
		}

		String problemType = status.getProblemType();

		if (status.getDeployObject().getEditTopology() == null
				|| status.getDeployObject().getEditTopology().getConfigurationContract() == null) {
			return;
		}
		ConfigurationContract cc = status.getDeployObject().getEditTopology()
				.getConfigurationContract();

		if (linkageRequirementUnsatisfiedProblemTypes.contains(problemType)) {
			linkageRequirementUnsatisfiedSeverityOverride(status, cc);
		}
		if (attributeProblemTypes.contains(problemType)) {
			attributeSeverityOverride(status, cc);
		}
	}

	/**
	 * Modify status severity according to visibility rules implied by the contract. Does not modify
	 * statuses if unit is simply not visible.
	 * 
	 * If a - status refers to a unsatisified dependency that can be satisfied by a link (including a
	 * realization link), - and the contract for the dmo with the status indicates that item
	 * isLinkable --- reduce severity to warning
	 * 
	 * If a - status refers to an error other than an unsatisified dependency that can be satisfied
	 * by link (including a realization link), - and the contract for the dmo with the status
	 * indicates that item isConfigurable --- reduce severity to warning
	 * 
	 * @param status
	 *           status to possibly override the severity of
	 */
	private void linkageRequirementUnsatisfiedSeverityOverride(IDeployStatus status,
			ConfigurationContract cc) {

		// override errors only when object is public (or public editable)
		if (cc.isPublic(status.getDeployObject())) {
			// Override errors to warnings
			if (status.getSeverity() == IStatus.ERROR) {
				status.setSeverity(IStatus.WARNING);
			}
			// Align with other conceptual unit status severities
			// Defect #3070
			if (ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
				status.setSeverity(IStatus.INFO);
			}
		}
	}

	private void attributeSeverityOverride(IDeployStatus status, ConfigurationContract cc) {
		if (status instanceof IDeployAttributeStatus) {
			IDeployAttributeStatus s = (IDeployAttributeStatus) status;
			if (cc.isPublicEditable(s.getDeployObject(), s.getAttributeShortName())) {
				if (s.getSeverity() == IStatus.ERROR) {
					s.setSeverity(IStatus.WARNING);
				}
			}
		}
	}

}
