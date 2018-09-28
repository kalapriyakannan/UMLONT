/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.navigator.CommonViewer;

public class DeployCommonViewer extends CommonViewer {

	/**
	 * @param aViewerId
	 * @param aParent
	 * @param aStyle
	 * 
	 * Constructor
	 */
	public DeployCommonViewer(String aViewerId, Composite aParent, int aStyle) {
		super(aViewerId, aParent, aStyle);

	}

	public void add(Object parentElement, Object[] childElements) {
		// dont want to add to the root as the root has
		// groupings
		if (parentElement instanceof IWorkspaceRoot)
			this.refresh();
		else
			super.add(parentElement, childElements);
	}

	public void add(Object parentElement, Object childElement) {
		// dont want to add to the root as the root has
		// groupings
		if (parentElement instanceof IWorkspaceRoot)
			this.refresh();
		else
			super.add(parentElement, childElement);
	}

}
