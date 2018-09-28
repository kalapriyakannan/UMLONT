/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;

/**
 * @since 1.0
 * 
 */
public class DeployResizableCompartmentEditPolicy extends ResizableCompartmentEditPolicy {

	/**
	 * @param horizontal
	 */
	public DeployResizableCompartmentEditPolicy(boolean horizontal) {
		super(horizontal);
	}

	protected List createCollapseHandles() {
		return Collections.EMPTY_LIST;
	}

}
