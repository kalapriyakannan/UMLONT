/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.BusinessComponentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.BusinessComponentFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

public class JarModuleEditPart extends BusinessComponentEditPart {

	/**
	 * @param view
	 */
	public JarModuleEditPart(View view) {
		super(view);
		setCategory("Utility Component"); //$NON-NLS-1$
	}

	protected NodeFigure createMainFigure() {
		BusinessComponentFigure f = new BusinessComponentFigure(
				DeployColorConstants.utilComponentFillc1, DeployColorConstants.utilComponentFillc2,
				DeployColorConstants.utilComponentFill1, DeployColorConstants.utilComponentFill2,
				DeployColorConstants.utilComponentBorder, DeployColorConstants.utilComponentConcept);
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
