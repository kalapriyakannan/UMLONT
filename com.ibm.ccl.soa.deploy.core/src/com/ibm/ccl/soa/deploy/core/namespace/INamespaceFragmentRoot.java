/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.namespace;

import org.eclipse.core.resources.IContainer;

/**
 * @TODO add javadoc comments
 * @since 1.0
 * 
 */
public interface INamespaceFragmentRoot extends INamespaceFragment {

	/**
	 * <p>
	 * Returns the IContainer that corresponds to this root.
	 * </p>
	 * 
	 * @return the <code>IContainer</code> that this root represents.
	 */
	IContainer getCorrespondingResource();

	/**
	 * <p>
	 * Returns the IContainer that corresponds to this namespace.
	 * </p>
	 * 
	 * @param namespace
	 *           the <code>ITopologyNamespace</code> to retrieve an <code>IContainer</code> for.
	 * @return the <code>IContainer</code> that the namespace passed in represents.
	 */
	IContainer getCorrespondingResource(INamespaceFragment namespace);

	/**
	 * <p>
	 * Returns the <code>ITopologyNamespace</code> that matches the qualified name passed in as a
	 * parameter.
	 * </p>
	 * 
	 * @param qualifiedName
	 *           dot-seperated string representation of the <code>ITopologyNamespace</code>'s
	 *           fully-qualified name.
	 * @return the <code>ITopologyNamespace</code> that matches the fully qualified name passed in
	 *         as a parameter.
	 */
	INamespaceFragment resolveNamespace(String qualifiedName);

	/**
	 * <p>
	 * Returns the <code>ITopologyNamespace</code> that matches the qualified name passed in as a
	 * parameter.
	 * </p>
	 * 
	 * @param qualifiedName
	 *           <code>String[]</code> array of namespace segments that make up the fully-qualified
	 *           name of the <code>ITopologyNamespace</code>.
	 * @return the <code>ITopologyNamespace</code> that matches the fully-qualified name passed in
	 *         as a parameter.
	 */
	INamespaceFragment resolveNamespace(String[] qualifiedName);

	/**
	 * <p>
	 * Returns an array of <code>ITopologyNamespace</code>s contained within this root.
	 * </p>
	 * 
	 * @return an array of <code>ITopologyNamespace</code>s contained within this root.
	 */
	INamespaceFragment[] namespaces();

	/**
	 * Return a handle to the given fragment.
	 * 
	 * @param fragment
	 *           An identifier for the fragment.
	 * @return The subfragment that matches the given name.
	 */
	INamespaceFragment getNamespaceFragment(String fragment);

}
