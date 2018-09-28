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
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class NotSupportedTargetException extends Exception {
	private Object target;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1258957113166605759L;

	/**
	 * 
	 * @param target
	 */
	public NotSupportedTargetException(Object target) {
		super();
		this.target = target;
	}

	/**
	 * @return the target
	 */
	public Object getTarget() {
		return target;
	}

}
