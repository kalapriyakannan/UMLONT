/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.status;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Status used to identify problems with a datasource satisfaction constraint.
 */
public class DatasourceSatisfactionStatus extends DeployStatus {

	private DeployModelObject constraintContext;

	private String dbUser;

	private String dbPassword;

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
	 * @param context
	 *           the constraint context.
	 */
	public DatasourceSatisfactionStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object,
			DeployModelObject context) {
		// super (severity, validatorID, problemType, unboundMessage, bindings, object) is broken
		setMarkerType(IDeployMarker.MARKER_ID);
		setSeverity(severity);
		setValidatorID(validatorID);
		setProblemType(problemType);
		setUnboundMessage(unboundMessage);
		setBindings(bindings);
		setDeployObject(object);
		setConstraintContext(context);
	}

	public void setSeverity(int severity) {
		super.setSeverity(severity);
	}

	public void setProblemType(String problemType) {
		super.setProblemType(problemType);
	}

	public void setMessage(String unboundMessage, Object[] bindings) {
		setUnboundMessage(unboundMessage);
		setBindings(bindings);
	}

	/**
	 * Set the constraint context in the status.
	 * 
	 * @param context
	 *           the constraint context
	 */
	public void setConstraintContext(DeployModelObject context) {
		constraintContext = context;
	}

	/**
	 * Get the saved constraint context from the status.
	 * 
	 * @return constraint context
	 */
	public DeployModelObject getConstraintContext() {
		return constraintContext;
	}

	/**
	 * Save a user name associated with the status.
	 * 
	 * @param user
	 *           user name
	 */
	public void setUser(String user) {
		dbUser = user;
	}

	/**
	 * Get the saved user name from the status.
	 * 
	 * @return user name
	 */
	public String getUser() {
		return dbUser;
	}

	/**
	 * Save a user password associated with the status.
	 * 
	 * @param password
	 *           password
	 */
	public void setUserPassword(String password) {
		dbPassword = password;
	}

	/**
	 * Get the saved user password from the status.
	 * 
	 * @return password
	 */
	public String getUserPassword() {
		return dbPassword;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof DatasourceSatisfactionStatus)) {
			return false;
		}
		DatasourceSatisfactionStatus ds = (DatasourceSatisfactionStatus) obj;
		return super.equals(obj)
				&& ValidatorUtils.equals(this.getConstraintContext(), ds.getConstraintContext())
				&& ValidatorUtils.equals(this.getUser(), ds.getUser())
				&& ValidatorUtils.equals(this.getUserPassword(), ds.getUserPassword());
	}

	// TODO support serialization
}
