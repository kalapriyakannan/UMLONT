/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * This class is to be extended by all {@link DeployModelObject} UI handler contributions.
 */
public abstract class AbstractCompositeFactory {

	/**
	 * @param obj
	 * @return <code>true</code> if this factory is appropriate for 'obj'
	 */
	public boolean isUIHandlerForObject(Object obj) {
		return obj instanceof DeployModelObject
				&& isUIHandlerForDeployModelObject((DeployModelObject) obj);
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this handler handles this DeployModelObject
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return true;
	}

	/**
	 * Subclasses must implement this method to create the UI within a Composite
	 * 
	 * @param parent
	 * @param editDmo
	 * @param factory
	 * @return the Composite the created within <code>parent</code> to hold the controls
	 */
	public abstract DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit factory) /* throws SAFException */;

} // end class AbstractCompositeFactory
