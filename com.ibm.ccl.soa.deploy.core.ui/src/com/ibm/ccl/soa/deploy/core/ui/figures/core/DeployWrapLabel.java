/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures.core;

import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;

/**
 * @since 1.0
 * 
 */
public class DeployWrapLabel extends WrapLabel {
	private boolean isFaded = false;

	/**
	 * 
	 */
	public DeployWrapLabel() {
		super();
	}

	/**
	 * @param i
	 */
	public DeployWrapLabel(Image i) {
		super(i);
	}

	/**
	 * @param s
	 * @param i
	 */
	public DeployWrapLabel(String s, Image i) {
		super(s, i);
	}

	/**
	 * @param s
	 */
	public DeployWrapLabel(String s) {
		super(s);
	}

	public void paint(Graphics g) {
		if (isFaded)
			g.setAlpha(DeployCoreConstants.SELECTION_FADE);
		super.paint(g);
	}

	/**
	 * @param isFaded
	 */
	public void setFaded(boolean isFaded) {
		this.isFaded = isFaded;
	}

}
