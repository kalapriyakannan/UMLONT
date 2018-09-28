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
import com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit;

/**
 * Validates {@link WindowsLocalGroupUnit}.
 * <p>
 */
public class WindowsLocalGroupUnitValidator extends UserGroupUnitValidator {

	/**
	 * Construct a {@link WindowsLocalGroupUnit} instance validator.
	 */
	public WindowsLocalGroupUnitValidator() {
		this(OsPackage.eINSTANCE.getWindowsLocalGroupUnit());

	}

	/**
	 * Construct a {@link WindowsLocalGroupUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link WindowsLocalGroupUnit}.
	 */
	protected WindowsLocalGroupUnitValidator(EClass unitType) {
		super(unitType);
	}
}
