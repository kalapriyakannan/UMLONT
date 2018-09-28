/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit;

/**
 * Validates {@link WindowsLocalUserUnit}.
 * <p>
 */
public class WindowsLocalUserUnitValidator extends UserUnitValidator {

	/**
	 * Construct a {@link WindowsLocalUserUnit} instance validator.
	 */
	public WindowsLocalUserUnitValidator() {
		this(OsPackage.eINSTANCE.getWindowsLocalUserUnit());

	}

	/**
	 * Construct a {@link WindowsLocalUserUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link WindowsLocalUserUnit}.
	 */
	protected WindowsLocalUserUnitValidator(EClass unitType) {
		super(unitType);
	}
}
