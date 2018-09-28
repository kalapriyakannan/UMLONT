package com.ibm.ccl.soa.deploy.internal.core.validator;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Static unique identifiers for validations done during pre-computation jobs (auto-realization,
 * generic requirement satisfaction)
 */
public interface IAutoRealizationValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_UNIT_NOT_REALIZED}
	 * <li>Description = At least one single-unit realization for the conceptual unit is available
	 * </ul>
	 */
	public final static String CONCEPTUAL_UNIT_SINGLE_UNIT_REALIZATION_AVAILABLE = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_UNIT_SINGLE_UNIT_REALIZATION_AVAILABLE"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_UNIT_NOT_REALIZED}
	 * <li>Description = At least one multi-unit realization for the conceptual unit is available
	 * </ul>
	 */
	public final static String CONCEPTUAL_AUTO_REALIZATION_AVAILABLE = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_AUTO_REALIZATION_AVAILABLE"; //$NON-NLS-1$	

}
