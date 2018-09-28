/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.core.runtime.IStatus;

/**
 * tree node Wrapper for status
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class StatusNode implements ITreeNode {
	private IStatus status;
	private StatusGroup category;

	/**
	 * 
	 * @param status
	 */
	public StatusNode(IStatus status) {
		super();
		this.status = status;
	}

	/**
	 * 
	 * @param status
	 * @param category
	 */
	public StatusNode(IStatus status, StatusGroup category) {
		super();
		this.status = status;
		this.category = category;
	}

	public Object[] getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public ITreeNode getParent() {

		return category;
	}

	/**
	 * 
	 * @param parent
	 */
	public void setParent(StatusGroup parent) {
		if (this.category == parent)
			return;
		if (this.category != null) {
			this.category.removeChild(this);
		}
		this.category = parent;
		if (this.category != null) {
			this.category.addChild(this);
		}

	}

	public boolean hasChildren() {
		return false;
	}

	/**
	 * @return the status
	 */
	public IStatus getStatus() {
		return status;
	}

}
