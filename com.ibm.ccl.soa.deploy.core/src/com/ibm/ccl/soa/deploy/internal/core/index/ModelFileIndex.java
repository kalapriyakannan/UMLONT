/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.index;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndex;

/**
 * @since 1.0
 * 
 */
public class ModelFileIndex implements IModelFileIndex {
	/**
	 * The topology file extension ({@value #DEPLOYMENT_TOPOLOGY_EXT}).
	 */
	public static final String DEPLOYMENT_TOPOLOGY_EXT = "topology"; //$NON-NLS-1$

	private final Object lock = new Object();

	private static final String[] interestingExtensions = new String[] { DEPLOYMENT_TOPOLOGY_EXT };

	private final Set fileTopologies = new HashSet();

	private final IProject project;

	/**
	 * @param theProject
	 */
	/* package */ModelFileIndex(IProject theProject) {
		project = theProject;

	}

	/**
	 * Initialize the index for the given project
	 * 
	 * @param monitor
	 */
	/* package */void init(IProgressMonitor progress) {
		final IProgressMonitor monitor = progress != null ? progress : new NullProgressMonitor();

		try {

			synchronized (lock) {
				project.accept(new IResourceProxyVisitor() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
					 */
					public boolean visit(IResourceProxy proxy) {

						String name = proxy.getName();

						for (int i = 0; i < interestingExtensions.length; i++)
							if (name.endsWith(interestingExtensions[i])) {
								/*
								 * only track tasks within files that are indexed to avoid any extra penalty
								 * for uninteresting files
								 */
								monitor.beginTask(NLS.bind(IndexMessages.ModelFileIndex_Indexing_0_, name),
										1);
								IResource resource = proxy.requestResource();
								if (resource.getType() == IResource.FILE)
									addModelFile((IFile) proxy.requestResource());
								monitor.worked(1);
								return false;
							}
						return true;
					}
				}, IResource.NONE);

			}
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndex#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndex#dispose()
	 */
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndex#addModelFile(org.eclipse.core.resources.IFile)
	 */
	public void addModelFile(IFile file) {

		synchronized (lock) {
			if (fileTopologies.contains(file))
				return;
			if (ModelFileIndexer.DEPLOYMENT_TOPOLOGY_EXT.equals(file.getFileExtension()))
				fileTopologies.add(file);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndex#getModelFiles()
	 */
	public IFile[] getModelFiles() {
		IFile[] files = null;
		synchronized (lock) {
			files = (IFile[]) fileTopologies.toArray(new IFile[fileTopologies.size()]);
		}

		return files;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.index.IModelFileIndex#removeModelFile(org.eclipse.core.resources.IFile)
	 */
	public synchronized void removeModelFile(IFile file) {
		synchronized (lock) {
			fileTopologies.remove(file);
		}
	}

}
