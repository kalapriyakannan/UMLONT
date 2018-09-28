/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.namespace;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;

/**
 * Represents the root of the tree structure for a topology namespace.
 * 
 * @since 1.0
 * 
 */
public class NamespaceFragmentRoot extends NamespaceFragment implements INamespaceFragmentRoot {

	private static int hashCode(Object[] array) {
		final int PRIME = 31;
		if (array == null) {
			return 0;
		}
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = PRIME * result + (array[index] == null ? 0 : array[index].hashCode());
		}
		return result;
	}

	protected IProject project;
	protected String[] rootPath;

	public NamespaceFragmentRoot(IContainer aContainer) {
		super(aContainer, aContainer);
		project = aContainer.getProject();
		rootPath = aContainer.getProjectRelativePath().segments();
	}

	public boolean isDefaultNamespace() {
		return true;
	}

	public String getName() {
		return container.getName();
	}

	public int getType() {
		return INamespaceElement.TOPOLOGY_NAMESPACE_ROOT;
	}

	public IContainer getCorrespondingResource(INamespaceFragment namespace) {

		String[] segments = TopologyNamespaceUtil.getSimpleNames(namespace.getQualifiedName());
		IContainer current = container;
		for (int i = 0; i < segments.length; i++) {
			current = current.getFolder(new Path(segments[i]));
		}

		return current;
	}

	public INamespaceFragment resolveNamespace(String qualifiedName) {

		String path = qualifiedName.replace('.', IPath.SEPARATOR);
		IContainer resolved = container.getFolder(new Path(path));
		return new NamespaceFragment(container, resolved);
	}

	public INamespaceFragment resolveNamespace(String[] qualifiedName) {

		IContainer current = container;
		StringBuffer path = new StringBuffer();
		for (int i = 0; i < qualifiedName.length; i++) {
			path.append(qualifiedName[i]);
			if (i < qualifiedName.length - 1) {
				path.append(IPath.SEPARATOR);
			}
		}
		current = container.getFolder(new Path(path.toString()));

		return new NamespaceFragment(container, current);
	}

	public INamespaceFragment[] namespaces() {

		// keep a list of namespaces that we find
		final HashSet namespaces = new HashSet();

		try {
			if (container.isAccessible()) {
				container.accept(new IResourceProxyVisitor() {

					public boolean visit(IResourceProxy proxy) throws CoreException {

						switch (proxy.getType())
						{

						case IResource.FOLDER:
							IFolder folder = (IFolder) proxy.requestResource();
							// Don't understand why we need to check this; nested roots?
//							INamespaceFragmentRoot aRoot = NamespaceCore.getRoot(folder);
//							if (aRoot.equals(NamespaceFragmentRoot.this)) {
							INamespaceFragment namespace = new NamespaceFragment(container, folder);
							if (!namespace.isDefaultNamespace()) {
								namespaces.add(namespace);
							}
//							} else if (aRoot != null && aRoot.getCorrespondingResource().equals(folder)) {
//								namespaces.add(aRoot);
//							}
						}

						return true;
					}
				}, IResource.NONE);

			}

		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		return (INamespaceFragment[]) namespaces.toArray(new INamespaceFragment[namespaces.size()]);

	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("TNR/"); //$NON-NLS-1$
		buf.append(getName());
		buf.append("/"); //$NON-NLS-1$

		return buf.toString();
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + (project == null ? 0 : project.hashCode());
		result = PRIME * result + NamespaceFragmentRoot.hashCode(rootPath);
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final NamespaceFragmentRoot other = (NamespaceFragmentRoot) obj;
		if (project == null) {
			if (other.project != null) {
				return false;
			}
		} else if (!project.equals(other.project)) {
			return false;
		}
		if (!Arrays.equals(rootPath, other.rootPath)) {
			return false;
		}
		return true;
	}

	public boolean exists() {
		ITopologyNamespaceRootIndex index = DeployCorePlugin.getDefault()
				.getTopologyNamespaceRootIndexer().getTopologyNamespaceRootIndex(
						container.getProject(), new NullProgressMonitor());
		return index.hasExistingRoot(container) && container.exists();
	}

	public INamespaceFragment getNamespaceFragment(String fragment) {
		String path = fragment.replace('.', IPath.SEPARATOR);
		IFolder folder = container.getFolder(new Path(path));
		return (INamespaceFragment) NamespaceCore.create(folder);
	}
}
