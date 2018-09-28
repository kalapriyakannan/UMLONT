/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.LineBorder;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployShapeCompartmentFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

/**
 * @since 1.0
 * 
 */
public class DeployCoreCompartmentFigure extends DeployShapeCompartmentFigure {

	/**
	 * @param compartmentTitle
	 * @param mm
	 */
	public DeployCoreCompartmentFigure(String compartmentTitle, IMapMode mm) {
		super(compartmentTitle, mm);
		setOpaque(true);
		setBackgroundColor(DeployColorConstants.white);
		setBorder(new LineBorder(DeployColorConstants.groupCompartmentGray));
	}

}
