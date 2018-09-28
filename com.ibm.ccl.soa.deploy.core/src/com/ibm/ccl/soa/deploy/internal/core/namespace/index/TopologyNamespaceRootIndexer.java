/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.namespace.index;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;

/**
 * Tracks the existance of topology root indexes within the current workspace. Indexes are keyed off
 * the project they are associated with.
 * 
 * @since 1.0
 * 
 */
public class TopologyNamespaceRootIndexer implements ITopologyNamespaceRootIndexer {

	private final Object lock = new Object();

	private HashMap projectRootIndexes = new HashMap();

	public ITopologyNamespaceRootIndex getTopologyNamespaceRootIndex(IProject project,
			IProgressMonitor monitor) {

		TopologyNamespaceRootIndex index = null;

		synchronized (lock) {
			if (!projectRootIndexes.containsKey(project.getName())) {
				index = new TopologyNamespaceRootIndex(project);
				index.init(monitor == null ? new NullProgressMonitor() : monitor);
				projectRootIndexes.put(project.getName(), index);
			}

			index = (TopologyNamespaceRootIndex) projectRootIndexes.get(project.getName());
		}

		return index;
	}

	public void dispose() {
		for (Iterator iter = projectRootIndexes.values().iterator(); iter.hasNext();) {
			ITopologyNamespaceRootIndex index = (ITopologyNamespaceRootIndex) iter.next();
			index.dispose();
		}
		projectRootIndexes = null;
	}

}
