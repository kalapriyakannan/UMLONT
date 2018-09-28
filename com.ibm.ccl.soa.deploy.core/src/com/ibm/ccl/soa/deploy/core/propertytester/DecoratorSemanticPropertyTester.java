/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.propertytester;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Test properties that may be useful for enabling decorator semantic content
 * 
 * @since 1.0
 * 
 */
public class DecoratorSemanticPropertyTester extends PropertyTester {

	private final String conceptualUnitPropertyName = "isConceptualUnit"; //$NON-NLS-1$
	private final String groupPropertyName = "isGroup"; //$NON-NLS-1$
	private final String installedPropertyName = "isInstalled"; //$NON-NLS-1$	

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (property.equals(conceptualUnitPropertyName)) {
			Unit unit = (Unit) receiver;
			return unit.isConceptual();
		}
		if (property.equals(groupPropertyName)) {
			Unit unit = (Unit) receiver;
			return unit.isGroup();
		}
		if (property.equals(installedPropertyName)) {
			Unit unit = (Unit) receiver;
			return unit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL);
		}
		return false;
	}

}
