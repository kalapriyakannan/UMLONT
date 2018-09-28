/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.ui.figures;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

/**
 * This class is used to create figures
 */
public class AnalysisFigureFactory {
	/**
	 * 
	 * @return NodeFigure
	 */
	public static NodeFigure createNewComponentUnitFigure() {
		return new ComponentUnitFigure();
	}

	public static NodeFigure createNewDeploymentUnitFigure() {
		return new DeploymentUnitFigure();
	}

	public static NodeFigure createNewLocationUnitFigure() {
		return new LocationUnitFigure();
	}

	public static NodeFigure createNewNodeUnitFigure() {
		return new NodeUnitFigure();
	}

}
