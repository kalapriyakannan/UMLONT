/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Old core DeployStatus compatibility class for WAS domain.
 * <p>
 * The WAS domain validators were coded with casts to the internal DeployStatus. A change in
 * DeployStatus away from use of attribute maps broke many of the WAS domain validators. This class
 * was created to bridge the gap of the missing dynamic attribute methods. The domain must be
 * updated to define its own status types.
 * 
 * @deprecated define typed deploy status subtypes
 */
public class WasDeployStatus extends DeployStatus {

	private final Map<String, Object> dynamicAttributes = new HashMap<String, Object>();

	public WasDeployStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	public WasDeployStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object) {
		setMarkerType(IDeployMarker.MARKER_ID);
		setSeverity(severity);
		setValidatorID(validatorID);
		setProblemType(problemType);
		setUnboundMessage(unboundMessage);
		setBindings(bindings);
		setDeployObject(object);
	}

	public Map<String, Object> getAttributes() {
		return dynamicAttributes;
	}

	public void setAttribute(String key, Object value) {
		dynamicAttributes.put(key, value);
	}

	public Object getAttribute(String key) {
		return dynamicAttributes.get(key);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus ws = (WasDeployStatus) obj;
		return super.equals(obj) && ValidatorUtils.equals(this.getAttributes(), ws.getAttributes());
	}
}
