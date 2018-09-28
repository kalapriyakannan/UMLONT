/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * @author jswanke
 * 
 */
public class DeployScrollPane extends ScrollPane {

	private boolean expanded = true;

	/**
	 * Should be called, after which the compoenents can be removed.
	 */
	public void collapse() {
		if (expanded == false)
			return;
		expanded = false;
	}

	/**
	 * Should get called after adding all the new components.
	 */
	public void expand() {
		if (expanded == true)
			return;
		expanded = true;
	}

	/**
	 * Sets the scroll pane state as being expanded or not.
	 * 
	 * @param value
	 *           the <code>boolean</code> to set the expanded value of. If <code>true</code> then
	 *           the state will be set as expanded, <code>false</code> if not.
	 */
	public void setExpanded(boolean value) {
		if (expanded == value)
			return;
		expanded = value;
		revalidate();
	}

	/**
	 * Accessor for the expanded property
	 * 
	 * @return boolean expanded
	 */
	public final boolean isExpanded() {
		return expanded;
	}

	/** @see org.eclipse.draw2d.IFigure#isOpaque() */
	public boolean isOpaque() {
		return false;
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		if (expanded)
			return super.getPreferredSize(wHint, hHint);
		return getMinimumSize(wHint, hHint);
	}

	/**
	 * @see IFigure#validate()
	 */
	public void validate() {
		if (isValid())
			return;
		setValid(true);
		layout();
	}
}
