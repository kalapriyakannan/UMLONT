/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.operation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

/**
 * @since 7.0
 * 
 */
public abstract class DeployModelObjectOperation extends AbstractEMFOperation implements
		IDeployModelObjectOperation {
	protected final EObject context;

	/**
	 * @param eObj
	 * @param label
	 */
	public DeployModelObjectOperation(EObject eObj, String label) {
		super(TransactionUtil.getEditingDomain(eObj), label);
		context = eObj;
	}

	/**
	 * @param eObj
	 * @param label
	 * @param options
	 */
	public DeployModelObjectOperation(EObject eObj, String label, Map<?, ?> options) {
		super(TransactionUtil.getEditingDomain(eObj), label, options);
		context = eObj;
	}

	public List<IFile> getAffectedFiles() {
		if (context != null) {
			Resource resource = context.eResource();

			if (resource != null) {
				IFile file = WorkspaceSynchronizer.getFile(resource);
				if (file != null) {
					return Collections.singletonList(file);
				}
			}
		}
		return null;
	}

}
