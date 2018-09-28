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

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageUnit;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * Validates {@link VMwareVirtualImageUnit}
 */
public class VMwareVirtualImageUnitValidator extends VirtualImageUnitValidator {

	/**
	 * Create a validator for {@link VMwareVirtualImageUnit}.
	 */
	public VMwareVirtualImageUnitValidator() {
		super(VirtualizationPackage.eINSTANCE.getVMwareVirtualImageUnit());
	}

	/**
	 * Create a validator for a subtype of {@link VMwareVirtualImageUnit}.
	 * 
	 * @param type
	 *            a subtype of {@link VMwareVirtualImageUnit}
	 */
	protected VMwareVirtualImageUnitValidator(EClass type) {
		super(type);
		assert VirtualizationPackage.eINSTANCE.getVMwareVirtualImageUnit()
				.isSuperTypeOf(type);
	}

}
