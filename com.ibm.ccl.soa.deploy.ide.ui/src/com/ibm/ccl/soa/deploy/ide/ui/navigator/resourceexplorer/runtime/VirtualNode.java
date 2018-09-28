/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime;

public class VirtualNode implements IVirtualNode {
	private String name;
	private String displayName;
	private Object parent;

	public VirtualNode(String name, String displayName, Object parent) {
		this.name = name;
		this.displayName = displayName;
		this.parent = parent;

	}

	/**
	 * @see org.eclipse.wst.rdb.core.internal.ui.explorer.virtual.IVirtualNode#getName()
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @see org.eclipse.wst.rdb.core.internal.ui.explorer.virtual.IVirtualNode#getDisplayName()
	 */
	public String getDisplayName() {
		return this.displayName != null ? this.displayName : this.name;
	}

	/**
	 * @see org.eclipse.wst.rdb.core.internal.ui.explorer.virtual.IVirtualNode#getParent()
	 */
	public Object getParent() {
		return parent;
	}
}
