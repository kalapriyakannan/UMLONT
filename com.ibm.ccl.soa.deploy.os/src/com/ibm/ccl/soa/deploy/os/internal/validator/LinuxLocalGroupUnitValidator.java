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

import com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Validates {@link LinuxLocalGroupUnit}.
 * <p>
 */
public class LinuxLocalGroupUnitValidator extends UserGroupUnitValidator {

	/**
	 * Construct a {@link LinuxLocalGroupUnit} instance validator.
	 */
	public LinuxLocalGroupUnitValidator() {
		this(OsPackage.eINSTANCE.getLinuxLocalGroupUnit());

	}

	/**
	 * Construct a {@link LinuxLocalGroupUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link LinuxLocalGroupUnit}.
	 */
	protected LinuxLocalGroupUnitValidator(EClass unitType) {
		super(unitType);
	}
}
