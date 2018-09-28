/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.figures;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

/**
 * This class is used to create figures
 */
public class J2EEFigureFactory {
	/**
	 * 
	 * @return NodeFigure
	 */
	public static NodeFigure createNewModuleFigure() {
		return new J2EEModuleFigure();
	}

	public static NodeFigure createNewServerFigure() {
		return new J2EEServerFigure();
	}
}
