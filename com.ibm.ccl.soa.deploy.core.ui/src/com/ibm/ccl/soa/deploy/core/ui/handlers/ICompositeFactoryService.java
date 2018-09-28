/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;

/**
 * Provides {@link AbstractCompositeFactory factories} provided by the
 * <b>com.ibm.ccl.soa.deploy.core.ui.compositeFactories</b> extension point that can create custom
 * UIs for the editing of {@link DeployModelObject custom model objects}.
 * 
 * @see AbstractCompositeFactory
 */
public interface ICompositeFactoryService {

	/**
	 * Returns an implementation of {@link AbstractCompositeFactory} provided by the
	 * <b>com.ibm.ccl.soa.deploy.core.ui.compositeFactories</b> extension point.
	 * 
	 * @param dmo
	 *           A model object that may be edited by a user
	 * @return An implementation of {@link AbstractCompositeFactory} provided by the
	 *         <b>com.ibm.ccl.soa.deploy.core.ui.compositeFactories</b> extension point.
	 */
	public AbstractCompositeFactory findDmoUIHandlerForDmo(DeployModelObject dmo);
}
