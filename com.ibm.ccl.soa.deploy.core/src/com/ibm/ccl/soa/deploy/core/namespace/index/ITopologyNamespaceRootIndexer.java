/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.namespace.index;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * An index of all the currently availble topology namespace root indexes. The root indexes are
 * stored on a per project basis and can be retrieved from this indexer in the same manner.
 * 
 * @since 1.0
 * 
 */
public interface ITopologyNamespaceRootIndexer {

	/**
	 * Returns the topology root index for the given project. Will instantiate an new one if one does
	 * not already exist.
	 * 
	 * @param project
	 *           the IProject that the index is for
	 * @param monitor
	 *           an instance of IProgressMonitor
	 * @return an instance of ITopologyNamespaceRootIndex for the given project.
	 */
	public abstract ITopologyNamespaceRootIndex getTopologyNamespaceRootIndex(IProject project,
			IProgressMonitor monitor);

	/**
	 * Used to clean up any existing resources.
	 * 
	 */
	public abstract void dispose();
}
