/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public interface ITreeNode {
	/**
	 * 
	 * @return parent, if no parent return null
	 */
	public ITreeNode getParent();

	/**
	 * 
	 * @return children, if no child return null or new Object[0]
	 */
	public Object[] getChildren();

	/**
	 * 
	 * @return true if has children
	 */
	public boolean hasChildren();
}
