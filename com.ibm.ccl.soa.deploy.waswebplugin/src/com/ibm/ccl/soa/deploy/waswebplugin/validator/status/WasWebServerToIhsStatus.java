/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.validator.status;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;

/**
 * Status used to identify status of a {@link WasWebServerToWasIhsPluginConstraint}.
 */
public class WasWebServerToIhsStatus extends DeployStatus {

	private WasWebServerUnit wasWebServerUnit;

	private IhsWasPluginUnit ihsPluginUnit;

	public WasWebServerToIhsStatus() {
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
	 * @param context
	 *           the constraint context.
	 */
	public WasWebServerToIhsStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object,
			WasWebServerUnit server, IhsWasPluginUnit plugin) {
		// super (severity, validatorID, problemType, unboundMessage, bindings, object) is broken
		setMarkerType(IDeployMarker.MARKER_ID);
		setSeverity(severity);
		setValidatorID(validatorID);
		setProblemType(problemType);
		setUnboundMessage(unboundMessage);
		setBindings(bindings);
		setDeployObject(object);
		setWasWebServer(server);
		setIhsPlugin(plugin);
	}

	/**
	 * Save a {@link WasWebServerUnit} in the status.
	 * 
	 * @param server
	 *           the server
	 */
	public void setWasWebServer(WasWebServerUnit server) {
		wasWebServerUnit = server;
	}

	/**
	 * Get the saved {@link WasWebServerUnit} from the status.
	 * 
	 * @return server
	 */
	public WasWebServerUnit getWasWebServer() {
		return wasWebServerUnit;
	}

	/**
	 * Save a {@link IhsWasPluginUnit} associated with the status.
	 * 
	 * @param plugin
	 *           IHS plugin
	 */
	public void setIhsPlugin(IhsWasPluginUnit plugin) {
		ihsPluginUnit = plugin;
	}

	/**
	 * Get the saved {@link IhsWasPluginUnit} from the status.
	 * 
	 * @return the plugin
	 */
	public IhsWasPluginUnit getIhsPlugin() {
		return ihsPluginUnit;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof WasWebServerToIhsStatus)) {
			return false;
		}
		WasWebServerToIhsStatus ws = (WasWebServerToIhsStatus) obj;
		return super.equals(obj)
				&& ValidatorUtils.equals(this.getWasWebServer(), ws.getWasWebServer())
				&& ValidatorUtils.equals(this.getIhsPlugin(), ws.getIhsPlugin());

	}
}
