/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImageUnit;

/**
 * Validates {@link XenVirtualImageUnit}
 */
public class XenVirtualImageUnitValidator extends VirtualImageUnitValidator {

	/**
	 * Create a validator for {@link XenVirtualImageUnit}.
	 */
	public XenVirtualImageUnitValidator() {
		this(VirtualizationPackage.eINSTANCE.getXenVirtualImageUnit());
	}

	/**
	 * Create a validator for a subtype of {@link XenVirtualImageUnit}.
	 * 
	 * @param type
	 *            a subtype of {@link XenVirtualImageUnit}
	 */
	protected XenVirtualImageUnitValidator(EClass type) {
		super(type);
		
		// XenVirtualImage.domainName must be set
		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				getClass().getName(), VirtualizationPackage.eINSTANCE
						.getXenVirtualImage_DomainName(), IStatus.ERROR));
		// XenVirtualImage.domainName must be unique in its host
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				getClass().getName(), VirtualizationPackage.eINSTANCE
						.getXenVirtualImage_DomainName()));

		assert VirtualizationPackage.eINSTANCE.getXenVirtualImageUnit()
				.isSuperTypeOf(type);
	}

}
