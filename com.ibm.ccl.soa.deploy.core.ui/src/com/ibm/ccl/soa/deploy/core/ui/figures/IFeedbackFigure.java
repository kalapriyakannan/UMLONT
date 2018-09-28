/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;

/**
 * @see CompositeShapeFigure
 */
public interface IFeedbackFigure extends IFigure {

	public static final String STATE_HOVER = "hover"; //$NON-NLS-1$

	public static final String STATE_SELECTED = "selected"; //$NON-NLS-1$

	public static final String STATE_TARGET = "target"; //$NON-NLS-1$

	public static final String STATE_TARGET_HOVER = "target_hover"; //$NON-NLS-1$

	public static final String STATE_NONE = "none"; //$NON-NLS-1$

	public static final String STATE_LINK_SELECTED = "link_selected"; //$NON-NLS-1$

	public static final String STATE_LINK_UNSELECTED = "link_unselected"; //$NON-NLS-1$

	public static final String STATE_DUP_SELECTED = "dup_selected"; //$NON-NLS-1$

	public static final String STATE_DUP_UNSELECTED = "dup_unselected"; //$NON-NLS-1$

	public void setFeedbackState(String state);

	public String getFeedbackState();

	public Rectangle getFeedbackFigureBounds();

	public void setFeedbackState(String state, Color c);

}
