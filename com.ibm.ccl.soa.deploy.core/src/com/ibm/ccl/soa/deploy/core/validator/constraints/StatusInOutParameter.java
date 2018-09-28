package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EDataType;

/**
 * A mutable (in/out) status parameter to return additional status information from the evaluation
 * of a constraint.
 */
public class StatusInOutParameter {
	/** The current status. */
	protected List<IStatus> statusList = null;

	/**
	 * Optional data type of an attribute
	 */
	protected EDataType attrDataType;

	/**
	 * Constructs a new mutable status parameter.
	 */
	public StatusInOutParameter() {
	}

	/**
	 * Constructs a new mutable status parameter.
	 * 
	 * @param status
	 *           initial value of the parameter (may be null).
	 */
	public StatusInOutParameter(IStatus status) {
		if (status != null) {
			statusList = new ArrayList<IStatus>();
			statusList.add(status);
		}
	}

	/**
	 * @return an immutable list of logged statuses.
	 */
	public List<IStatus> getStatuses() {
		if (statusList == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(statusList);
	}

	/**
	 * Sets the status value of the parameter.
	 * 
	 * @param status
	 *           a status object (may be null).
	 */
	public void addStatus(IStatus status) {
		if (status == null) {
			return;
		}
		if (statusList == null) {
			statusList = new ArrayList<IStatus>();
		}
		statusList.add(status);
	}

	/**
	 * Clears the status stored (sets it to null).
	 */
	public void clear() {
		if (statusList != null) {
			statusList.clear();
		}
		attrDataType = null;
	}

	/**
	 * @return true if it has any non-null status values.
	 */
	public boolean hasStatus() {
		return statusList != null && statusList.size() > 0;
	}

	/**
	 * @return Returns the attrDataType.
	 */
	public EDataType getAttrDataType() {
		return attrDataType;
	}

	/**
	 * @param attrDataType
	 *           The attrDataType to set.
	 */
	public void setAttrDataType(EDataType attrDataType) {
		this.attrDataType = attrDataType;
	}
}
