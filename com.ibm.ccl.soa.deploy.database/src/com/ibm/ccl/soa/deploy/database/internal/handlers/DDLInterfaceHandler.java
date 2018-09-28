/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.internal.handlers;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.database.DDLInterface;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.Messages;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * @since 3.2
 * 
 */
public class DDLInterfaceHandler extends AbstractInterfaceHandler {

	/*
	 * create a computed interface property label
	 * 
	 * @see com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler#getInterfacePropertyLabel(com.ibm.ccl.soa.deploy.core.Interface)
	 */
	public String getInterfacePropertyLabel(Interface interfaze) {
		DDLInterface ddInterface = (DDLInterface) interfaze;
		String s;
		String d = ddInterface.getSchemaUri();
		if (d == null || d.length() == 0) {
			s = Messages.DDLInterfaceHandler_Schema_Uri_not_set;
		} else {
			s = d;
		}
		return s;
	}

	public Interface createInterfaceFor(Object interfaceObj) {
		DDLInterface wsdlInterface = DatabaseFactory.eINSTANCE.createDDLInterface();
		return wsdlInterface;
	}

	@Override
	public Interface createInterfaceForService(EClass serviceType) throws SAFException,
			InvalidOperationException {
		DDLInterface wsdlInterface = DatabaseFactory.eINSTANCE.createDDLInterface();
		return wsdlInterface;
	}

}