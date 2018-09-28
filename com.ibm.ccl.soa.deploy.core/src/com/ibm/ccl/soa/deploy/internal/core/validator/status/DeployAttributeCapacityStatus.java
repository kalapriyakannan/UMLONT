package com.ibm.ccl.soa.deploy.internal.core.validator.status;

import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;

public class DeployAttributeCapacityStatus extends DeployAttributeValueStatus {

	private AttributeCapacityConstraint restriction;
	private boolean exclusive;
	private Unit[] hostRoute;

	public DeployAttributeCapacityStatus() {
	}

	/**
	 * Creates a deploy status associated with a deploy model object..
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @param attribute
	 *           the attribute marked in the status.
	 */
	public DeployAttributeCapacityStatus(int severity, String validatorID, String problemType,
			String unboundMessage, String[] bindings, DeployModelObject object, EAttribute attribute) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object, attribute);

	}

	/**
	 * Set the "exclusive" flag which indicates whether the restriction can overlap with other
	 * restrictions.
	 * 
	 * @param exclusive
	 *           True to indicate the value indicated must be allocated strictly to the source of the
	 *           restriction.
	 */
	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	/**
	 * Return True to indicate the value indicated must be allocated strictly to the source of the
	 * restriction.
	 * 
	 * @return True to indicate the value indicated must be allocated strictly to the source of the
	 *         restriction.
	 */
	public boolean isExclusive() {
		return exclusive;
	}

	/**
	 * Set the particular restriction associated with this Constraint.
	 * 
	 * @param restriction
	 *           The particular restriction associated with this Constraint.
	 */
	public void setRestriction(AttributeCapacityConstraint restriction) {
		this.restriction = restriction;
	}

	/**
	 * Return the particular restriction associated with this Constraint.
	 * 
	 * @return The particular restriction associated with this Constraint.
	 */
	public AttributeCapacityConstraint getRestriction() {
		return restriction;
	}

	public void setHostRoute(Unit[] hostRoute) {
		this.hostRoute = hostRoute;
	}

	public Unit[] getHostRoute() {
		return hostRoute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
//		result = prime * result + (exclusive ? 1231 : 1237);
		result = prime * result + Arrays.hashCode(hostRoute);
		result = prime * result + (restriction == null ? 0 : restriction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DeployAttributeCapacityStatus other = (DeployAttributeCapacityStatus) obj;
//		if (exclusive != other.exclusive) {
//			return false;
//		}
		if (!Arrays.equals(hostRoute, other.hostRoute)) {
			return false;
		}
		if (restriction == null) {
			if (other.restriction != null) {
				return false;
			}
		} else if (!restriction.equals(other.restriction)) {
			return false;
		}
		return true;
	}

}
