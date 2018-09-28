/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;

/**
 * A Composite that is embeddable in a {@link DmoComposite}.
 */
public interface CompositeForDmoComposite {

	/**
	 * @param model
	 * @param esf
	 */
	public void setup(DmoSyncHelperModel model, EStructuralFeature esf);

	/**
	 * @param model
	 * @param esf
	 */
	public void showValue();
}
