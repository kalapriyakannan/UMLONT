/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.index;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * Provides access to project specific indices and notifications for interested parties.
 * 
 * @see DeployCorePlugin#getIndexer()
 * 
 * @since 1.0
 * 
 */
public interface IModelFileIndexer {

	/**
	 * The initial invocation of this method must visit() the project in order to build the initial
	 * state of the index.
	 * 
	 * 
	 * @param project
	 *           The project to locate the index of
	 * @param monitor
	 *           A progress monitor to acknowledge the work done while indexing the project
	 * @return The model file index for the given project.
	 */
	public abstract IModelFileIndex getModelIndex(IProject project, IProgressMonitor monitor);

	/**
	 * Add the given model listener to be notified of events relating to model files.
	 * 
	 * @param listener
	 *           The listener who will respond to the events.
	 */
	public abstract void addModelListener(AbstractModelIndexListener listener);

	/**
	 * Remove the given model listener so as to no longer be notified of events.
	 * 
	 * @param listener
	 *           The listener who will no longer respond to the events.
	 */
	public abstract void removeModelListener(AbstractModelIndexListener listener);

}