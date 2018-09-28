/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.namespace;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;
import com.ibm.ccl.soa.deploy.internal.core.namespace.NamespaceFragmentRoot;

/**
 * 
 * @since 1.0
 * 
 */
public class NamespaceCore {

	private static final INamespaceFragmentRoot[] EMPTY_NAMSPACE_FRAGMENT_ROOTS = new INamespaceFragmentRoot[0];

	/**
	 * Returns an array of all the topology roots for this index's project. Will return an empty
	 * array if project is not accessible.
	 * 
	 * @param project
	 * @param monitor
	 * @return array of topology root objects found in this project.
	 */
	public static INamespaceFragmentRoot[] locateRoots(IProject project, IProgressMonitor monitor) {
		if (!project.isAccessible()) {
			return EMPTY_NAMSPACE_FRAGMENT_ROOTS;
		}

		DeployCorePlugin plugin = DeployCorePlugin.getDefault();
		if (null != plugin) {
			ITopologyNamespaceRootIndexer indexer = plugin.getTopologyNamespaceRootIndexer();
			ITopologyNamespaceRootIndex index = indexer
					.getTopologyNamespaceRootIndex(project, monitor);
			return index.getRootNamespaces();
		}

		return new INamespaceFragmentRoot[0];
	}

	/**
	 * Returns the root for the passed in folder if it is a descendent of an existing root folder.
	 * Will return null if no root exists in the folder's path to the top level project, or container
	 * is not accessible.
	 * 
	 * @param container
	 * @return an <code>INamespaceFragmentRoot</code> that represents the container that was pssed
	 *         in.
	 */
	public static INamespaceFragmentRoot getRoot(IContainer container) {
		if (!container.getProject().isAccessible()) {
			return null;
		}
		ITopologyNamespaceRootIndexer indexer = DeployCorePlugin.getDefault()
				.getTopologyNamespaceRootIndexer();
		ITopologyNamespaceRootIndex index = indexer.getTopologyNamespaceRootIndex(container
				.getProject(), new NullProgressMonitor());
		return index.getRoot(container);
	}

	/**
	 * Creates a new instance of a topology root for the given folder. This operation will create a
	 * folder resource if one does not already exist. Will return null if container is not
	 * accessible.
	 * 
	 * @param container
	 * @param monitor
	 * @return an <code>INamespaceFragmentRoot</code> that represents the container that was passed
	 *         in.
	 * @throws CoreException
	 */
	public static INamespaceFragmentRoot createRoot(IContainer container, IProgressMonitor monitor)
			throws CoreException {
		if (!container.getProject().isAccessible()) {
			return null;
		}
		ITopologyNamespaceRootIndexer indexer = DeployCorePlugin.getDefault()
				.getTopologyNamespaceRootIndexer();
		ITopologyNamespaceRootIndex index = indexer.getTopologyNamespaceRootIndex(container
				.getProject(), monitor);
		return index.createTopologyRootNamespace(container, monitor);
	}

	/**
	 * <p>
	 * Use this API to return an instance of an {@link INamespaceElement} which represents either a
	 * namespace root or a namespace.
	 * 
	 * This is a handle only method.
	 * </p>
	 * 
	 * @param container
	 *           an {@link IContainer} representing either a namespace root or a namespace.
	 * @return an instance of an {@link INamespaceElement} based on the passed container.
	 */
	public static INamespaceElement create(IContainer container) {
		Assert.isNotNull(container);
		if (!container.getProject().isAccessible()) {
			return null;
		}
		if (DeployCorePlugin.getDefault() == null) {
			return null;
		}
		if (DeployCorePlugin.getDefault().getTopologyNamespaceRootIndexer() == null) {
			return null;
		}
		ITopologyNamespaceRootIndex index = DeployCorePlugin.getDefault()
				.getTopologyNamespaceRootIndexer().getTopologyNamespaceRootIndex(
						container.getProject(), null);
		//Is this a root?
		INamespaceFragmentRoot root = index.resolveExistingRoot(container);
		if (root != null) {
			//Found a root so return it.
			return root;
		}
		//Find the first valid root.
		root = index.getRoot(container);
		if (root == null) {
			//Then we don't have anything so give a handle to a root.
			return new NamespaceFragmentRoot(container);
		}
		//Return a resolved namespace.
		IContainer underlyingContainer = root.getCorrespondingResource();
		//Remove root path segments.
		IPath namespacePath = container.getFullPath().removeFirstSegments(
				underlyingContainer.getFullPath().segmentCount());
		return root.resolveNamespace(namespacePath.segments());
	}

	public static INamespaceFragment findNamespace(IProject context, String namespace) {
		if (!context.isAccessible()) {
			return null;
		}
		INamespaceFragmentRoot[] roots = locateRoots(context, new NullProgressMonitor());
		for (int i = 0; i < roots.length; i++) {
			INamespaceFragment resolvedNamespace = roots[i].resolveNamespace(namespace);
			if (resolvedNamespace.exists()) {
				return resolvedNamespace;
			}
		}
		return roots[0].resolveNamespace(namespace);
	}

	public static INamespaceFragment findNamespace(IProject context, IContainer container) {
		if (!context.isAccessible()) {
			return null;
		}

		INamespaceFragmentRoot root = NamespaceCore.getRoot(container);
		if (root == null) {
			return null;
		}

		IContainer rootContainer = root.getCorrespondingResource();
		IPath path = container.getFullPath().removeFirstSegments(
				container.getFullPath().matchingFirstSegments(rootContainer.getFullPath()));
		return NamespaceCore.findNamespace(container.getProject(), TopologyNamespaceUtil.concatWith(
				path.segments(), TopologyNamespaceUtil.C_DOT));
	}

	/**
	 * Returns a topology file given a project, namespace and topology name. --Returns first file
	 * found -- i.e. if two different src folders exist with the same namespace and filename --
	 * whichever root is searched first is the file that will be returned
	 * 
	 * @param context
	 *           - The containing
	 * @param namespace
	 *           - the topology namespace
	 * @param name
	 *           - the name of the topology
	 * @return the Topology file matching the parameter or null if none can be found
	 */
	public static IFile resolveTopology(IProject context, String namespace, String name) {
		if (!context.isAccessible()) {
			return null;
		}
		IFile topologyFile = null;
		IFile expectedTopologyFile = null;
		INamespaceFragmentRoot[] roots = locateRoots(context, new NullProgressMonitor());
		for (int i = 0; i < roots.length; i++) {
			INamespaceFragment resolvedNamespace = null;
			if (namespace == null || namespace.equals("")) { //$NON-NLS-1$
				resolvedNamespace = roots[i];
			} else {
				resolvedNamespace = roots[i].resolveNamespace(namespace);
			}
			if (resolvedNamespace != null) {
				topologyFile = resolvedNamespace.getTopology(name);
				if (expectedTopologyFile == null) {
					expectedTopologyFile = topologyFile;
				}
				if (topologyFile != null && topologyFile.exists()) {
					return topologyFile;
				}
			}
		}
		// return the first file found
		return expectedTopologyFile;
	}

	/**
	 * Returns a topology file given a project, qualified topology name. --Returns first file found
	 * -- i.e. if two different src folders exist with the same namespace and filename -- whichever
	 * root is searched first is the file that will be returned
	 * 
	 * @param context
	 *           - The containing
	 * @param qName
	 *           - the qualified topology name
	 * @return the Topology file matching the parameter or null if none can be found
	 */
	public static IFile resolveTopology(IProject context, String qName) {
		String[] splitNames = TopologyNamespaceUtil.splitQualifiedName(qName);
		return resolveTopology(context, splitNames[0], splitNames[1]);
	}
}
