/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.uml.internal.validator;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;
import com.ibm.ccl.soa.deploy.uml.internal.validator.matcher.UMLDomainMatcher;

/**
 * Validates objects in the {@link UmlPackage} deploy domain.
 * <p>
 * Validation of {@link SoftwareComponent} units is performed in the
 * {@link UMLCoreTypeDomainValidator} which is registered for the {@link CorePackage}
 * domain.
 */
public class UMLDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link UmlPackage} domain validator.
	 */
	public UMLDomainValidator() {
		super(UmlPackage.eINSTANCE);

		// Note: SoftwareComponent validation performed by CoreSoftwareComponentDomainValidator
		addValidator(new UMLActorUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new UMLDomainMatcher();
	}
}
