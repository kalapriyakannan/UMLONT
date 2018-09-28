/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class EClassPropertyTester extends PropertyTester {

	private static final String ECLASS_NAME = "eclass"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver != null && receiver instanceof EObject) {
			EClass eclass = ((EObject) receiver).eClass();
			if (ECLASS_NAME.equals(property)) {
				return eclass.getName() != null ? eclass.getName().equals(expectedValue) : false;
			}
		}
		return false;
	}

}
