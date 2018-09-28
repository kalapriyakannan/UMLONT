/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

public class DeployCommunicationConstraintStatus extends DeployStatus implements
		IDeployCommunicationConstraintStatus {

	private List<Constraint> constraintCandidates;

	private Unit commSource;

	private Unit commTarget;

	private StatusMap statusMap;

	private String description;

	public DeployCommunicationConstraintStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	/**
	 * Constructor.
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
	 * @param source
	 *           the source unit of the {@link ApplicationCommunicationConstraint}
	 * @param target
	 *           the target unit of a {@link ApplicationCommunicationConstraint}
	 * @param candidates
	 *           list of {@link NetworkCommunicationConstraint} that might appropriately constrain
	 *           the network communication
	 */
	public DeployCommunicationConstraintStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object, Unit source,
			Unit target, List<Constraint> candidates) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object);
		setMarkerType(IDeployMarker.MARKER_ID);
		setSource(source);
		setTarget(target);
		setCandidateConstraints(candidates);
	}

	public DeployCommunicationConstraintStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object, Unit source,
			Unit target, List<Constraint> candidates, StatusMap statusMap, String description) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object);
		setMarkerType(IDeployMarker.MARKER_ID);
		setSource(source);
		setTarget(target);
		setCandidateConstraints(candidates);
		setStatusMap(statusMap);
		setTypeDescription(description);
	}

	protected void setCandidateConstraints(List<Constraint> candidates) {
		constraintCandidates = candidates;
	}

	public List<Constraint> getCandidateConstaints() {
		return constraintCandidates;
	}

	protected void setSource(Unit source) {
		commSource = source;
	}

	public Unit getSource() {
		return commSource;
	}

	protected void setTarget(Unit target) {
		commTarget = target;
	}

	public Unit getTarget() {
		return commTarget;
	}

	public void setStatusMap(StatusMap statusMap) {
		this.statusMap = statusMap;
	}

	public StatusMap getStatusMap() {
		return statusMap;
	}

	public void setTypeDescription(String description) {
		this.description = description;
	}

	public String getTypeDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (commSource == null ? 0 : commSource.hashCode());
		result = prime * result + (commTarget == null ? 0 : commTarget.hashCode());
		result = prime * result
				+ (constraintCandidates == null ? 0 : constraintCandidates.hashCode());
		result = prime * result + (statusMap == null ? 0 : statusMap.hashCode());
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
		final DeployCommunicationConstraintStatus other = (DeployCommunicationConstraintStatus) obj;
		if (commSource == null) {
			if (other.commSource != null) {
				return false;
			}
		} else if (!commSource.equals(other.commSource)) {
			return false;
		}
		if (commTarget == null) {
			if (other.commTarget != null) {
				return false;
			}
		} else if (!commTarget.equals(other.commTarget)) {
			return false;
		}
		if (constraintCandidates == null) {
			if (other.constraintCandidates != null) {
				return false;
			}
		} else if (!constraintCandidates.equals(other.constraintCandidates)) {
			return false;
		}
		if (statusMap == null) {
			if (other.statusMap != null) {
				return false;
			}
		} else if (!statusMap.equals(other.statusMap)) {
			return false;
		}
		return true;
	}
}
