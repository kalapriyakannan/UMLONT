/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.http.HttpPackage;
import com.ibm.ccl.soa.deploy.http.validator.capability.HttpUserValidator;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;

/**
 * Validator for the {@link IhsSystemUnit} unit.
 */
public class IhsSystemUnitValidator extends UnitValidator {

	/**
	 * Construct a new {@link IhsSystemUnit} unit validator.
	 */
	public IhsSystemUnitValidator() {
		this(IhsPackage.eINSTANCE.getIhsSystemUnit());
	}

	/**
	 * Construct a new {@link IhsSystemUnit} subtype unit validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link IhsSystemUnit}
	 */
	protected IhsSystemUnitValidator(EClass unitType) {
		super(unitType);
		assert IhsPackage.eINSTANCE.getIhsSystemUnit().isSuperTypeOf(unitType);

		this.addCapabilityValidator(new HttpUserValidator());

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IIhsDomainValidators.IHS_USER_ID_UNIQUE, HttpPackage.eINSTANCE.getHttpUser_UserId()));
	}
}
