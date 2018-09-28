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

import org.eclipse.core.runtime.IAdaptable;

import com.ibm.ccl.soa.deploy.core.IConstants;

/**
 * Base interface for all of the namespace types.
 * 
 * @since 1.0
 * 
 */
public interface INamespaceElement extends IAdaptable {

	/**
	 * <p>
	 * Constant representing a topology namespace root. A Topology element with this type can be
	 * safely cast to <code>ITopologyNamespaceRoot</code>.
	 * </p>
	 */
	int TOPOLOGY_NAMESPACE_ROOT = 1;

	/**
	 * <p>
	 * Constant representing a topology namespace. A Topology element with this type can be safely
	 * cast to <code>ITopologyNamespace</code>.
	 * </p>
	 */
	int TOPOLOGY_NAMESPACE = 2;

	/**
	 * <p>
	 * Constant representing a topology file. A Topology element with this type can be safely cast to
	 * <code>ITopologyFile</code>.
	 * </p>
	 */
	int TOPOLOGY_FILE = 3;

	/**
	 * <p>
	 * The default file extension for topology files. ( value: the <code>String</code> topology )
	 * </p>
	 */
	String DEFAULT_TOPOLOGYFILE_EXTENSION = IConstants.TOPOLOGY_EXTENSION;

	/**
	 * Representation of the default namespace.
	 */
	String DEFAULT_NAMESPACE = ""; //$NON-NLS-1$

	/**
	 * <p>
	 * Returns the name of this element. This is a handle-only method.
	 * </p>
	 * 
	 * @return the element name
	 */
	String getName();

	/**
	 * <p>
	 * Returns the fully qualified name of the element based off it's distance from the topology root
	 * that contains it. This is a handle-only method.
	 * </p>
	 * 
	 * @return a fully qualified name
	 */
	String getQualifiedName();

	/**
	 * <p>
	 * Returns this element's kind encoded as an integer. This is a handle-only method.
	 * </p>
	 * 
	 * @return the kind of element; one of the constants declared in <code>ITopologyElement</code>
	 * @see INamespaceElement#TOPOLOGY_FILE
	 * @link ITopologyElement#TOPOLOGY_NAMESPACE_ROOT
	 * @link ITopologyElement#TOPOLOGY_NAMESPACE
	 * @link
	 */
	int getType();

	/**
	 * <p>
	 * Returns the <code>ITopologyNamespaceRoot</code> that this element belongs to or
	 * <code>null</code> if this element does not belong to an <code>ITopologyNamespaceRoot</code>.
	 * This is a handle-only method.
	 * </p>
	 * 
	 * @return the parent element of this element or null if not one present.
	 */
	INamespaceFragmentRoot getRoot();

	/**
	 * <p>
	 * This API is used to test for the existence of the element in the model.
	 * </p>
	 * 
	 * @return true if this {@link INamespaceElement} exists in the namespace model.
	 */
	boolean exists();
}
