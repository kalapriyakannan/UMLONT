/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.handlers;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.WSDLInterface;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * 
 */
public class WSDLInterfaceHandler extends AbstractInterfaceHandler {

	/*
	 * create a computed interface property label
	 * 
	 * @see com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler#getInterfacePropertyLabel(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public String getInterfacePropertyLabel(Interface interfaze) {
		WSDLInterface wInterface = (WSDLInterface) interfaze;

		String type = wInterface.getTypeUri();
		if (type == null) {
			return "Type not set"; //$NON-NLS-1$
		}
		return "Type: " + type; //$NON-NLS-1$
	}

	public Interface createInterfaceFor(Object interfaceObj) {
		WSDLInterface wsdlInterface = J2eeFactory.eINSTANCE.createWSDLInterface();
		return wsdlInterface;
	}

	@Override
	public Interface createInterfaceForService(EClass serviceType) throws SAFException,
			InvalidOperationException {
		WSDLInterface wsdlInterface = J2eeFactory.eINSTANCE.createWSDLInterface();
		return wsdlInterface;
	}
}