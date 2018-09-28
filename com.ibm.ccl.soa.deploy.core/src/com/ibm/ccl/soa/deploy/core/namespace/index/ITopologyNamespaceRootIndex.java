/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.namespace.index;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;

/**
 * Used to store the instances of topology roots found within a project.
 * 
 * @since 1.0
 * 
 */
public interface ITopologyNamespaceRootIndex {

	/**
	 * Returns the project that this index is storing roots for.
	 * 
	 * @return the project this index is tracking roots for.
	 */
	IProject getProject();

	/**
	 * Used to clean up any existing resources.
	 * 
	 */
	void dispose();

	/**
	 * Adds a new topology root to this index. The folder passed in must exist and be located under
	 * the project for this index.
	 * 
	 * @param container
	 *           the folder to use as the backing for a new topology root
	 * @return the instance of topology root for this folder
	 */
	INamespaceFragmentRoot addTopologyRootNamespace(IContainer container);

	/**
	 * Returns an array of all the topology roots for this index's project.
	 * 
	 * @return array of topology root objects found in this project.
	 */
	INamespaceFragmentRoot[] getRootNamespaces();

	/**
	 * Removes the topology root backed by the passed in folder if found.
	 * 
	 * @param folder
	 */
	void removeRootNamespace(IContainer folder);

	/**
	 * Creates a new instance of a topology root for the given folder. This operation will create a
	 * folder resource if one does not already exist.
	 * 
	 * @param container
	 * @param monitor
	 * @return
	 * @throws CoreException
	 */
	public INamespaceFragmentRoot createTopologyRootNamespace(IContainer container,
			IProgressMonitor monitor) throws CoreException;

	/**
	 * Returns the root for the passed in folder if it is a descendent of an existing root folder.
	 * Will return null if no root exists in the folder's path to the top level project.
	 * 
	 * @param container
	 * @return
	 */
	public INamespaceFragmentRoot getRoot(IContainer container);

	/**
	 * @param container -
	 *           An {@link IContainer} that is represented as a possible root.
	 * @return An {@link INamespaceFragmentRoot} that corresponds to the passed container if it is
	 *         defined. If the root is not defined for the container then null will be returned.
	 */
	public INamespaceFragmentRoot resolveExistingRoot(IContainer container);

	/**
	 * 
	 * @param container -
	 *           An {@link IContainer} that is represented as a possible root.
	 * @return true if the passed container exists as a root.
	 */
	boolean hasExistingRoot(IContainer container);
}
