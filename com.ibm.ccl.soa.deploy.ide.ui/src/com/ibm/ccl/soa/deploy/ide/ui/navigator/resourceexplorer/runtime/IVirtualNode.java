/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime;

public interface IVirtualNode {
	/**
	 * Name of the Virtual Node
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Display Name of the Virtual Node - Will be displayed in the Model Explorer if null, getName
	 * will be used
	 * 
	 * @return
	 */
	public String getDisplayName();

	/**
	 * @return the parent of this node in the tree
	 */
	public Object getParent();

}
