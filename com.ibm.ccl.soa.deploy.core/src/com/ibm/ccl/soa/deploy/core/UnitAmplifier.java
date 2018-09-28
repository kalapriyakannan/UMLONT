package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.runtime.IStatus;

public abstract class UnitAmplifier {

	/**
	 * @param unit -
	 *           Input used to determine dynamic values for the meta-model.
	 * 
	 * @return String[] object to populate a client, such as a UI.
	 */
	public abstract String[] getValues(Unit unit);

	/**
	 * @param unit -
	 *           target of input modification.
	 * @param input -
	 *           selection from a client, such as a UI
	 * @return feedback indicating the operation completed successfully.
	 */
	public abstract IStatus modify(Unit unit, Object input);

	/**
	 * @param unit -
	 *           target of input with existing productIndentifier.
	 * 
	 * @return existing constraint
	 */

	public abstract String getExistingProductConstraintValue(Unit unit);

}
