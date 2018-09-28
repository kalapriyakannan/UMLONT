/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui.extension;

import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * @since 7.0
 * 
 */
public class SkeletonUIHandler extends AbstractUIHandler {
	/**
	 * The singleton instance.
	 */
	public static final SkeletonUIHandler INSTANCE = new SkeletonUIHandler();

	private SkeletonUIHandler() {
		// do nothing
	}

	protected AbstractDescriptionProvider geInterfaceDescriptionProvider() {
		return null;
	}

	public boolean isUIHandlerForObject(Object obj) {
		return false;
	}

	@Override
	public boolean editSubstitutable(Shell shell, DeployModelObject dmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUIHandlerForObject(Substitutable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void open(Substitutable substitutableObj) throws SAFException, InvalidOperationException {
		// TODO Auto-generated method stub

	}
}
