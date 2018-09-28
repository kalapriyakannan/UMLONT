/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.ChangeScope;

public abstract class ModelChange {

	private String label;

	public ModelChange(String externalizedLabel) {
		label = externalizedLabel;
	}

	public String getLabel() {
		return label;
	}

	public abstract IStatus execute(IProgressMonitor monitor, ChangeScope scope)
			throws ExecutionException;
}
