/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.HashSet;

/**
 * Status Tree Node Wrapper class which has children
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class StatusGroup implements ITreeNode {
	private HashSet children = new HashSet();
	private String name;

	/**
	 * 
	 * @param name
	 */
	public StatusGroup(String name) {
		super();
		this.name = name;
	}

	public Object[] getChildren() {

		return children.toArray();
	}

	public ITreeNode getParent() {

		return null;
	}

	public boolean hasChildren() {

		return true;
	}

	/**
	 * 
	 * @param node
	 */
	public void removeChild(StatusNode node) {
		children.remove(node);

	}

	/**
	 * 
	 * @param node
	 */
	public void addChild(StatusNode node) {
		children.add(node);
		assert (node.getParent() == this);

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the number of children
	 */
	public int getChildrenNum() {
		return children.size();
	}
}
