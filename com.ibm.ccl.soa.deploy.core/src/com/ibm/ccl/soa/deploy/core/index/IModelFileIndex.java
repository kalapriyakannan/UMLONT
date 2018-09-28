/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.index;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import com.ibm.ccl.soa.deploy.internal.core.index.ModelFileIndexer;

/**
 * Represents an idnex of mdoel files for a specific project.
 * 
 * @since 1.0
 * 
 */
public interface IModelFileIndex {

	/**
	 * @return The project that this object indexes.
	 */
	IProject getProject();

	/**
	 * 
	 */
	void dispose();

	/**
	 * Track the given file in the in memory index
	 * 
	 * @param file
	 *           A file with the extension {@value ModelFileIndexer#DEPLOYMENT_TOPOLOGY_EXT}.
	 */
	void addModelFile(IFile file);

	/**
	 * 
	 * @return Return an array of IFiles that contain EMF models.
	 */
	IFile[] getModelFiles();

	/**
	 * @param file
	 */
	void removeModelFile(IFile file);

}