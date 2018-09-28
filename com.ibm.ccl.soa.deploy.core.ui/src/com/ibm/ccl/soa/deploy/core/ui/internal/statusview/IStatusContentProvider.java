/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.jface.viewers.ITreeContentProvider;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterDialog;

/**
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a> IStatusContentProvider provide content
 *         information for status view.
 * 
 */
public interface IStatusContentProvider extends ITreeContentProvider {
	/**
	 * 
	 * @return extend fields return extend fields that can be show in Table except Statsu
	 *         Message,Status Severity,Status Exception.
	 */
	public IStatusField[] getExtendFields();

	/**
	 * 
	 * @return group fields The group fields refer what fields can be used to group Status.
	 */
	public IStatusField[] getGroupFields();

	/**
	 * 
	 * @return filter fields The filter fields refer to what fields can be filter.
	 * @see FilterDialog
	 */
	public IStatusField[] getFilterfields();
}
