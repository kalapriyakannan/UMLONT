/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.operation;

import java.util.List;

import org.eclipse.core.resources.IFile;

import com.ibm.ccl.soa.deploy.internal.core.DeployFileModificationApprover;

/**
 * An interface to be implemented by operations of the IT Deployment Architecture platform. This
 * interface will be utilized for the validate edit support.
 * 
 * @see DeployModelObjectOperation
 * @see DeployFileModificationApprover
 */
public interface IDeployModelObjectOperation {

	/**
	 * 
	 * @return a List of {@link IFile}s that will be the files that will be changed by the
	 *         operation.
	 */
	List<IFile> getAffectedFiles();
}
