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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;

/**
 * Represents the structure of the namespace types.
 * 
 * @since 1.0
 * 
 */
public class NamespaceFragment extends NamespaceElement implements INamespaceFragment {

	protected IContainer root;
	protected IContainer container;
	protected boolean containsTopologies = false;
	protected boolean containsOthers = false;
	protected boolean containsSubNamespaces = false;
	protected List<IFile> topologyFiles = new ArrayList<IFile>();
	protected List<IFile> otherFiles = new ArrayList<IFile>();
	protected List<INamespaceFragment> subnamespaces = new ArrayList<INamespaceFragment>();

	/**
	 * Creates a new instance of topology namespace with the given name.
	 * 
	 * @param aName
	 */
	NamespaceFragment(IContainer theRoot, IContainer aContainer) {
		super(aContainer.getProjectRelativePath().removeFirstSegments(
				aContainer.getProjectRelativePath().matchingFirstSegments(
						theRoot.getProjectRelativePath())).segments());
		root = theRoot;
		container = aContainer;
	}

	public boolean isDefaultNamespace() {
		if (root.equals(container)) {
			return true;
		}
		return false;
	}

	public int getType() {
		return INamespaceElement.TOPOLOGY_NAMESPACE;
	}

	public String getName() {

		if (!isDefaultNamespace()) {
			return container.getName();
		}

		return ""; //$NON-NLS-1$
	}

	public boolean containsTopologies() {
		if (container.isAccessible()) {
			try {
				containsTopologies = false;
				final NamespaceFragment fragment = this;
				container.accept(new IResourceProxyVisitor() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
					 */
					public boolean visit(IResourceProxy proxy) {

						if (proxy.getType() == IResource.FOLDER
								&& proxy.getName().equals(fragment.container.getName())) {
							return true;
						}

						String name = proxy.getName();
						if (name.endsWith(INamespaceElement.DEFAULT_TOPOLOGYFILE_EXTENSION)) {
							if (proxy.getType() == IResource.FILE) {
								fragment.containsTopologies = true;
							}
						}

						return false;
					}
				}, IResource.NONE);
			} catch (CoreException e) {
				DeployCorePlugin.logError(0, e.toString(), e);
			}
		}
		return containsTopologies;
	}

	public IFile[] topologies() {
		if (!container.isAccessible()) {
			return new IFile[0];
		}

		try {
			topologyFiles.clear();
			final NamespaceFragment fragment = this;
			container.accept(new IResourceProxyVisitor() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
				 */
				public boolean visit(IResourceProxy proxy) {

					if (proxy.getType() == IResource.FOLDER
							&& proxy.getName().equals(fragment.container.getName())) {
						return true;
					}

					String name = proxy.getName();
					if (name.endsWith(INamespaceElement.DEFAULT_TOPOLOGYFILE_EXTENSION)) {
						if (proxy.getType() == IResource.FILE) {
							fragment.topologyFiles.add((IFile) proxy.requestResource());
						}
					}

					return false;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		// final ROTopologyModelManager manager = ROTopologyModelManager.create();
		// Topology topology = manager.openModel( topologyFile, new
		// ROTopologyModelManager.Listener() {
		// public void onUnload( IFile unloadedResource ) {
		// manager.dispose();
		// }
		// });

		return topologyFiles.toArray(new IFile[topologyFiles.size()]);
	}

	public boolean containsNonTopologyResources() {
		try {
			containsOthers = false;
			final NamespaceFragment fragment = this;
			container.accept(new IResourceProxyVisitor() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
				 */
				public boolean visit(IResourceProxy proxy) {

					if (proxy.getType() == IResource.FOLDER
							&& proxy.getName().equals(fragment.container.getName())) {
						return true;
					}

					String name = proxy.getName();
					if (!name.endsWith(INamespaceElement.DEFAULT_TOPOLOGYFILE_EXTENSION)) {
						if (proxy.getType() == IResource.FILE) {
							fragment.containsOthers = true;
						}
					}

					return false;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		return containsOthers;
	}

	public IResource[] nonTopologyResources() {
		if (!container.isAccessible()) {
			return new IResource[0];
		}

		try {
			otherFiles.clear();
			final NamespaceFragment fragment = this;
			container.accept(new IResourceProxyVisitor() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
				 */
				public boolean visit(IResourceProxy proxy) {

					if (proxy.getType() == IResource.FOLDER
							&& proxy.getName().equals(fragment.container.getName())) {
						return true;
					}

					String name = proxy.getName();
					if (!name.endsWith(INamespaceElement.DEFAULT_TOPOLOGYFILE_EXTENSION)) {
						if (proxy.getType() == IResource.FILE) {
							fragment.otherFiles.add((IFile) proxy.requestResource());
						}
					}

					return false;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		return otherFiles.toArray(new IResource[otherFiles.size()]);
	}

	public boolean containsSubNamespaces() {
		try {
			final NamespaceFragment fragment = this;
			containsSubNamespaces = false;
			container.accept(new IResourceProxyVisitor() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
				 */
				public boolean visit(IResourceProxy proxy) {

					if (proxy.getType() == IResource.FOLDER
							&& proxy.getName().equals(fragment.container.getName())) {
						return true;
					}

					if (proxy.getType() == IResource.FOLDER) {
						containsSubNamespaces = true;
					}

					return false;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		return containsSubNamespaces;
	}

	public INamespaceFragment[] subNamespaces() {
		if (!container.isAccessible()) {
			return new INamespaceFragment[0];
		}

		try {
			subnamespaces.clear();
			final NamespaceFragment fragment = this;
			container.accept(new IResourceProxyVisitor() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.core.resources.IResourceProxyVisitor#visit(org.eclipse.core.resources.IResourceProxy)
				 */
				public boolean visit(IResourceProxy proxy) {

					if (proxy.getType() == IResource.FOLDER
							&& proxy.getName().equals(fragment.container.getName())) {
						return true;
					}

					if (proxy.getType() == IResource.FOLDER) {
						IResource resource = proxy.requestResource();
						subnamespaces.add(NamespaceCore.findNamespace(resource.getProject(),
								(IContainer) resource));
					}

					return false;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.toString(), e);
		}

		return subnamespaces.toArray(new INamespaceFragment[subnamespaces.size()]);
	}

	public INamespaceFragmentRoot getRoot() {
		return new NamespaceFragmentRoot(root);
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("TN/"); //$NON-NLS-1$
		buf.append(getQualifiedName());
		buf.append("/"); //$NON-NLS-1$

		return buf.toString();
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + (container == null ? 0 : container.hashCode());
		result = PRIME * result + (root == null ? 0 : root.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final NamespaceFragment other = (NamespaceFragment) obj;
		if (container == null) {
			if (other.container != null) {
				return false;
			}
		} else if (!container.equals(other.container)) {
			return false;
		}
		if (root == null) {
			if (other.root != null) {
				return false;
			}
		} else if (!root.equals(other.root)) {
			return false;
		}
		return true;
	}

	/*
	 * Return true if our root model exists and our corresponding container exists.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment#exists()
	 */
	public boolean exists() {
		INamespaceFragmentRoot root = getRoot();
		if (root != null && root.exists()) {
			return container.exists();
		}
		return false;
	}

	public IFile getTopology(String name) {
		final String fileName = name + IConstants.DOT_SEPARATOR + IConstants.TOPOLOGY_EXTENSION;
		return container.getFile(new Path(fileName));
	}

	public boolean create(IProgressMonitor monitor) throws CoreException {

		if (!container.exists()) {
			switch (container.getType())
			{
			case IResource.FOLDER:
				createContainer(container, monitor);

				return true;
			}
		}
		return false;
	}

	private void createContainer(IContainer container, IProgressMonitor monitor)
			throws CoreException {

		if (!container.exists()) {

			if (container.getType() == IResource.PROJECT) {
				throw new IllegalStateException(
						"The container for the current fragment \"" + getQualifiedName() + "\" does not exist."); //$NON-NLS-1$//$NON-NLS-2$
			}

			if (!container.getParent().exists()) {
				createContainer(container.getParent(), monitor);
			}

			IFolder folder = (IFolder) container;
			folder.create(true, true, monitor);
		}
	}

	public INamespaceFragment getParent() {
		IContainer parent = container.getParent();
		if (null != parent) {
			return NamespaceCore.findNamespace(parent.getProject(), parent);
		}

		return null;
	}

	public IContainer getCorrespondingResource() {
		return container;
	}
}
