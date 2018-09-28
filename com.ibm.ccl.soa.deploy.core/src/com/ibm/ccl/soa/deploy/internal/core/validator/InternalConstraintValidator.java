package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * An interface for internal early support for Structural Constraint Validators.
 * 
 * 
 */
public interface InternalConstraintValidator {

	/**
	 * Process the set of statuses proposed by all Domain and Constraint validators. Clients are
	 * recommended not to change the existing statuses in the list or remove statuses that are valid;
	 * rather this list can be used to calculate any operation over the completely validated
	 * Topology. There are no guarantees about the kinds of statuses in this list or duplicates that
	 * might have occurred in the course of validating the Units in the Topology.
	 * 
	 * @param proposedStatuses
	 *           The mutable list of all proposed status results.
	 * @return true if any changes were made to the list.
	 */
	public boolean postProcess(List<IDeployStatus> proposedStatuses);
}
