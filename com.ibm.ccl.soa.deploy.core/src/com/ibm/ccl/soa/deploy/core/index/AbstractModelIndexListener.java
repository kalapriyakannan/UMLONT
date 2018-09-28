/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.index;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import com.ibm.ccl.soa.deploy.internal.core.index.ModelFileIndexer;

/**
 * Listens for file changes that migth affect model file renderings in viewers.
 * 
 * @see DeployCoreUIPlugin#getIndexer()
 * @see ModelFileIndexer#addModelListener(IModelIndexListener)
 * @see AbstractModelIndexListener
 * 
 */
public class AbstractModelIndexListener {

	/**
	 * Announce that model files have appeared in the resource tree since the listener was
	 * configured.
	 * 
	 * @param modelFiles
	 */
	public void modelsAdded(IFile[] modelFiles) {
	}

	/**
	 * Announce that model files have disappeared in the resource tree since the listener was
	 * configured.
	 * 
	 * @param modelFiles
	 */
	public void modelsRemoved(IFile[] modelFiles) {
	}

	/**
	 * Announce that model files have been renamed in the resource tree since the listener was
	 * configured.
	 * 
	 * <p>
	 * The list of original files corresponds to the list of renamed files based on their indices.
	 * </p>
	 * 
	 * @param originalFiles
	 *           The set of files as they were before the event.
	 * @param renamedFiles
	 *           The set of files as they were after the rename.
	 */
	public void modelsRenamed(IFile[] originalFiles, IFile[] renamedFiles) {
	}

	/**
	 * Announce that projects that may contain model files have been opened.
	 * 
	 * @param projects
	 */
	public void projectsOpened(IProject[] projects) {
	}

	/**
	 * Announce that projects that may have contained model files have been closed.
	 * 
	 * @param projects
	 */
	public void projectsClosed(IProject[] projects) {
	}

	/**
	 * Announce that projects that may contain model files have been added.
	 * 
	 * @param projects
	 */
	public void projectsAdded(IProject[] projects) {
	}

	/**
	 * Announce that projects that may have contained model files have been removed.
	 * 
	 * @param projects
	 */
	public void projectsRemoved(IProject[] projects) {
	}

}
