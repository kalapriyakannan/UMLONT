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

import com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link LinuxLocalUserUnit}.
 * <p>
 */
public class LinuxLocalUserUnitValidator extends UserUnitValidator {

	/**
	 * Construct a {@link LinuxLocalUserUnit} instance validator.
	 */
	public LinuxLocalUserUnitValidator() {
		this(OsPackage.eINSTANCE.getLinuxLocalUserUnit());

	}

	/**
	 * Construct a {@link LinuxLocalUserUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link LinuxLocalUserUnit}.
	 */
	protected LinuxLocalUserUnitValidator(EClass unitType) {
		super(unitType);
	}
}
