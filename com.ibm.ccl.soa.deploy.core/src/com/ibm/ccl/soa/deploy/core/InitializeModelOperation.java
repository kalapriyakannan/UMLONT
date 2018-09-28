/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;

public abstract class InitializeModelOperation<ModelType extends EObject> extends
		AbstractEMFOperation {

	public InitializeModelOperation(TransactionalEditingDomain domain, String label) {
		super(domain, label);
	}

	@Override
	protected final IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		ChangeScope<ModelType, ?> scope = ChangeScope.findChangeScope(info);
		return initialize(scope);
	}

	protected abstract IStatus initialize(ChangeScope<ModelType, ?> scope);
}
