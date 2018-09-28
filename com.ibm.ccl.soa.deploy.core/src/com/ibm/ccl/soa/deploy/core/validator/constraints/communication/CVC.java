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

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Temporary constraint validator context to be removed/refactored when constraint framework
 * provides something similar. cf. Jazz Milestone item 4784 and concept document
 * https://radical.rtp.raleigh.ibm.com/rad/44206-ibm.html
 */
public class CVC {

	/** validation context object */
	private DeployModelObject _context;

	/** additional attributes for the validator to use stored in a name, value manner */
	private final Map<String, Object> _data = new HashMap<String, Object>();

	/**
	 * Retrieve the traditional constraint validation context.
	 * 
	 * @return the context object
	 */
	public DeployModelObject getContext() {
		return _context;
	}

	protected void setContext(DeployModelObject context) {
		_context = context;
	}

	/**
	 * Retrieve additional context data stored using a key.
	 * 
	 * @param key
	 *           the key
	 * @return the additonal context data
	 */
	public Object getAttribute(String key) {
		return _data.get(key);
	}

	protected boolean setAttribute(String key, Object value) {
		_data.put(key, value);
		return true;
	}
}
