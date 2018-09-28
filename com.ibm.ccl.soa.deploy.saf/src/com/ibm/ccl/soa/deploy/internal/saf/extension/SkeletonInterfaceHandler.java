/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * @since 7.0
 * 
 */
public class SkeletonInterfaceHandler extends AbstractInterfaceHandler {
	/**
	 * The singleton instance.
	 */
	public static final SkeletonInterfaceHandler INSTANCE = new SkeletonInterfaceHandler();

	private SkeletonInterfaceHandler() {
	}

	@Override
	public Interface createInterfaceFor(Object interfaceObj) throws SAFException,
			InvalidOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interface createInterfaceForService(EClass serviceType) throws SAFException,
			InvalidOperationException {
		// TODO Auto-generated method stub
		return null;
	}

}
