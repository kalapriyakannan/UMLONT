/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter;

import org.eclipse.core.resources.IResource;

import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class ResourceFilter implements IObjectFilter {
	/**
	 * any resource
	 */
	public static final int Focus_On_Any = 0x1;
	/**
	 * any selected resource
	 */
	public static final int Focus_On_Selected = 0x2;
	private int focus_on = Focus_On_Any;
	private IResource selectedResource;

	public boolean accept(Object value) {
		if (focus_on == Focus_On_Any)
			return true;

		if (value instanceof IResource) {
			IResource parent = ((IResource) value).getParent();
			while (parent != null && parent != selectedResource) {
				parent = parent.getParent();
			}
			if (parent == null)
				return false;
		}
		return true;
	}

	/**
	 * @return the focus_on
	 */
	public int getFocus_on() {
		return focus_on;
	}

	/**
	 * @return the selectedResource
	 */
	public IResource getSelectedResource() {
		return selectedResource;
	}

	/**
	 * @param focus_on
	 *           the focus_on to set
	 */
	public void setFocus_on(int focus_on) {
		this.focus_on = focus_on;
	}

	/**
	 * @param selectedResource
	 *           the selectedResource to set
	 */
	public void setSelectedResource(IResource selectedResource) {
		this.selectedResource = selectedResource;
	}

}
