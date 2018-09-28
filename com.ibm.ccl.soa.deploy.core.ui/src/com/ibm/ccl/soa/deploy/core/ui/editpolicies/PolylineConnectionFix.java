/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FanRouter;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * keep drag wire from going haywire
 * 
 */
public class PolylineConnectionFix extends PolylineConnectionEx {
	public void setConnectionRouter(ConnectionRouter arg0) {
		super.setConnectionRouter(new FanRouter());
	}

}
