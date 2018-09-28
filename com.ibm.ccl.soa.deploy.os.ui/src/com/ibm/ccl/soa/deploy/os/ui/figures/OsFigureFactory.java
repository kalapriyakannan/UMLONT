/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.ui.figures;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

/**
 * This class is used to create figures
 */
public class OsFigureFactory {
	/**
	 * 
	 * @return NodeFigure
	 */
	public static NodeFigure createNewOsUnitFigure() {
		return new OsUnitFigure();
	}

	public static NodeFigure createNewConfigurationUserFigure() {
		return new ConfigurationUserFigure();
	}

	public static NodeFigure createNewConfigurationUserGroupFigure() {
		return new ConfigurationUserGroupFigure();
	}

	public static NodeFigure createNewConfigurationPortConfigFigure() {
		return new ConfigurationPortConfigFigure();
	}

}
