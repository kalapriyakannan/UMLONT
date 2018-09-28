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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Represents the structure of the namespace types.
 * 
 * @since 1.0
 * 
 */
public interface INamespaceFragment extends INamespaceElement {

	/**
	 * <p>
	 * The name of topology namespace for the default namespace (value: the empty string,
	 * <code>""</code>).
	 * </p>
	 */
	public static final String DEFAULT_NAMESPACE_NAME = ""; //$NON-NLS-1$

	/**
	 * <p>
	 * Returns whether this topology namespace is a default namespace. This is a handle-only method.
	 * </p>
	 * 
	 * @return true if this topology namespace is a default namespace
	 */
	boolean isDefaultNamespace();

	/**
	 * <p>
	 * Returns <code>true</code> if this namespace contains a topology file within it. This method
	 * does not take into account subnamespaces or any topology files that may be located within any
	 * of this namespace's subnamespaces.
	 * </p>
	 * 
	 * @return <code>true</code> if directly contains a topology file or<code>false</code>
	 *         otherwise.
	 */
	boolean containsTopologies();

	/**
	 * <p>
	 * Returns the <code>IFile</code> for the <code>Topology</code> that is contained directly
	 * beneath this namespace or <code>null</code> if no topology can be found.
	 * </p>
	 * 
	 * @return the <code>Topology</code> located within this namespace or <code>null</code> if no
	 *         topology could be found.
	 */
	IFile[] topologies();

	/**
	 * <p>
	 * Returns the <code>IFile</code> for the <code>Topology</code> that is contained directly
	 * beneath this namespace. Note this is a handle operation the IFile may not exist.
	 * </p>
	 * 
	 * @return the <code>Topology</code> located within this namespace.
	 */
	IFile getTopology(String name);

	/**
	 * <p>
	 * Returns <code>true</code> if this namespace contains files other than those associated with
	 * topology resources. This method does not take into account subnamespaces or any files that may
	 * be located within any of this namespace's subnamespaces.
	 * 
	 * </p>
	 * 
	 * @return <code>true</code> if this namespace does contain non-topology resources and
	 *         <code>false</code> if it does not.
	 */
	boolean containsNonTopologyResources();

	/**
	 * <p>
	 * Returns <code>IResource</code> array of all the non-topology resources contained within this
	 * namespace fragment.
	 * </p>
	 * 
	 * @return an array of <code>IResource</code> objects.
	 */
	IResource[] nonTopologyResources();

	boolean containsSubNamespaces();

	INamespaceFragment[] subNamespaces();

	boolean create(IProgressMonitor monitor) throws CoreException;

	INamespaceFragment getParent();

	IContainer getCorrespondingResource();
}
