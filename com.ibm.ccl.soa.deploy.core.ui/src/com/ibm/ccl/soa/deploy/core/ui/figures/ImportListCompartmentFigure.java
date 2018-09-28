/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * @since 1.0
 * 
 */
public class ImportListCompartmentFigure extends DeployListCompartmentFigure {

	/**
	 * @param isInnerLst
	 * @param compartmentTitle
	 * @param mm
	 */
	public ImportListCompartmentFigure(boolean isInnerLst, String compartmentTitle, IMapMode mm) {
		super(isInnerLst, compartmentTitle, mm);
	}

}
