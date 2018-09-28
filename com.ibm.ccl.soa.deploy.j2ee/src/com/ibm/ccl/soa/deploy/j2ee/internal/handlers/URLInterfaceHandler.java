/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.handlers;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.URLInterface;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * 
 */
public class URLInterfaceHandler extends AbstractInterfaceHandler {

	/*
	 * create a computed interface property label
	 * 
	 * @see com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler#getInterfacePropertyLabel(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public String getInterfacePropertyLabel(Interface interfaze) {
		URLInterface uInterface = (URLInterface) interfaze;
		String s = "Parameters"; //$NON-NLS-1$

		EList list = uInterface.getParamName();
		if (list.size() == 0) {
			s += " not set"; //$NON-NLS-1$
		} else {
			s += ": "; //$NON-NLS-1$
			for (Iterator it = list.iterator(); it.hasNext();) {
				s += it.next();
				if (it.hasNext()) {
					s += ", ";//$NON-NLS-1$
				}
			}
		}
		return s;
	}

	public Interface createInterfaceFor(Object interfaceObj) {
		URLInterface urlInterface = J2eeFactory.eINSTANCE.createURLInterface();
		return urlInterface;
	}

	@Override
	public Interface createInterfaceForService(EClass serviceType) throws SAFException,
			InvalidOperationException {
		URLInterface urlInterface = J2eeFactory.eINSTANCE.createURLInterface();
		return urlInterface;
	}

}