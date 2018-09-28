/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.synchronization;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;

import com.ibm.ccl.soa.deploy.core.datamodels.SynchronizationDatamodel;

/**
 * Provides standard arguments for the Implementation action.
 * 
 * @since 1.0
 * 
 */
public class SynchronizationArguments extends RefactoringArguments {

	private SynchronizationDatamodel datamodel;

	/**
	 * Construct a set of Implementation Arguments from the given datamodel.
	 * 
	 * @param datamodel
	 *           The datamodel that collected information either from a client operation or wizard
	 *           dialog.
	 */
	public SynchronizationArguments(SynchronizationDatamodel datamodel) {
		Assert.isNotNull(datamodel);
		this.datamodel = datamodel;
	}

	/**
	 * Return the underlying datamodel.
	 * 
	 * @return The underlying datamodel.
	 */
	public SynchronizationDatamodel getImplementationDatamodel() {
		return datamodel;
	}

}
