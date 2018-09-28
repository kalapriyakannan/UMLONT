/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.virtualization.VMwareESXUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * Validates {@link VMwareESXUnit} Could also extend OperatingSystemUnitValidator, but VMwareESX is not a full operating system.
 */
public class VMwareESXUnitValidator extends UnitValidator {

	/**
	 * Create a validator for {@link VMwareESXUnit}.
	 */
	public VMwareESXUnitValidator() {
		this(VirtualizationPackage.eINSTANCE.getVMwareESXUnit());
	}

	/**
	 * Create a validator for a subtype of {@link VMwareESXUnit}.
	 * 
	 * @param type
	 *            a subtype of {@link VMwareESXUnit}
	 */
	protected VMwareESXUnitValidator(EClass type) {
		super(type);

		assert VirtualizationPackage.eINSTANCE.getVMwareESXUnit().isSuperTypeOf(type);
	}

}
