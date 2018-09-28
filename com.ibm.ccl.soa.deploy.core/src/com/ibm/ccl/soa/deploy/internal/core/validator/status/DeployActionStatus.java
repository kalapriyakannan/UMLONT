/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployActionStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Status indicating that an action can be executed against at a unit; its preconditions have been
 * satisified.
 */
public class DeployActionStatus extends DeployStatus implements IDeployActionStatus {

	/**
	 * @see IDeployActionStatus#getParameters()
	 */
	private List<DeployModelObject> parameters;

	/**
	 * Constructor.
	 */
	public DeployActionStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
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
	 * @param parameters
	 *           a list of deploy action parameters.
	 */
	public DeployActionStatus(int severity, String validatorID, String problemType,
			String unboundMessage, String[] bindings, DeployModelObject object,
			List<DeployModelObject> parameters) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object);
		setMarkerType(IDeployMarker.MARKER_ID);
		setParameters(parameters);
	}

	/**
	 * @return returns the parameters that satisfied the action precondition
	 */
	public List<DeployModelObject> getParameters() {
		return parameters;
	}

	/**
	 * Associate the parameters that satisfy the acton tester with the status.
	 * 
	 * @param parameters
	 *           the valid parameters
	 */
	public void setParameters(List<DeployModelObject> parameters) {
		this.parameters = parameters;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployActionStatus)) {
			return false;
		}
		IDeployActionStatus as = (IDeployActionStatus) obj;

		return super.equals(obj) && ValidatorUtils.equals(this.getParameters(), as.getParameters());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getParameters());
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(IDeployStatus status) {
		int result;
		if ((result = super.compareTo(status)) != 0) {
			return result;
		}
		IDeployActionStatus aStatus = (IDeployActionStatus) status;
		if ((result = ValidatorUtils.compare(this.getParameters(), aStatus.getParameters())) != 0) {
			return result;
		}
		return 0;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#serializeAttributes(java.util.Map)
	 */
	@Override
	protected void serializeAttributes(Map<String, Object> attributes) {
		super.serializeAttributes(attributes);
		attributes.put(IDeployMarker.ACTION_PARAMETERS, serializeCollectionScalarValues(
				getParameters(), CorePackage.eINSTANCE.getDeployModelObject()));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#deserializeAttributes(java.util.Map,
	 *      com.ibm.ccl.soa.deploy.core.Topology, java.util.List)
	 */
	@Override
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		super.deserializeAttributes(attributes, topology, statusList);
		parameters = new ArrayList<DeployModelObject>();
		deserializeCollectionScalarValues((String) attributes.get(IDeployMarker.ACTION_PARAMETERS),
				CorePackage.eINSTANCE.getDeployModelObject(), parameters, topology, statusList);
	}
}
