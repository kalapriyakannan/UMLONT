/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * @author jswanke
 * 
 */
public class DeployShapeCompartmentFigure extends ShapeCompartmentFigure {

	boolean ignoreCompartmentSize = false;

	/**
	 * @param compartmentTitle
	 * @param mm
	 */
	public DeployShapeCompartmentFigure(String compartmentTitle, IMapMode mm) {
		super(compartmentTitle, mm);
	}

	public Dimension getPreferredSize(int wHint, int hHint) {
		if (ignoreCompartmentSize)
			return new Dimension(0, 0);
		return super.getPreferredSize(wHint, hHint);
	}

	/**
	 * @param ignoreCompartmentSize --
	 *           used when calculating collapsed size of parent figure no matter what the collpased
	 *           state of the compartment
	 */
	public void setDisablePreferredSize(boolean ignoreCompartmentSize) {
		this.ignoreCompartmentSize = ignoreCompartmentSize;
	}

}
