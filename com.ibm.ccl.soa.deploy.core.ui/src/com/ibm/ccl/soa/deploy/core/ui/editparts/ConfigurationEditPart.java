/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editparts;

import org.eclipse.gmf.runtime.notation.View;

/**
 * Base class of a Configuration Unit (may go away).
 */
public abstract class ConfigurationEditPart extends TopologyEditPart {
	/**
	 * @param view
	 */
	public ConfigurationEditPart(View view) {
		super(view);
	}
}
