/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.sca.internal.validator;

import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;
import com.ibm.ccl.soa.deploy.sca.internal.validator.matcher.ScaDomainMatcher;

/**
 * Validates objects in the {@link ScaPackage} deploy domain.
 */
public class ScaDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link ScaPackage} domain validator.
	 */
	public ScaDomainValidator() {
		super(ScaPackage.eINSTANCE);
		
		addValidator(new GenericSCAImplementationUnitValidator());
		addValidator(new SCABindingUnitValidator());
		addValidator(new SCAComponentUnitValidator());
		addValidator(new SCAImplementationBPELUnitValidator());
		addValidator(new SCAImplementationCompositeUnitValidator());
		addValidator(new SCAImplementationCplusplusUnitValidator());
		addValidator(new SCAImplementationJavaUnitValidator());
		addValidator(new SCAInterfaceUnitValidator());
		addValidator(new SCAOperationUnitValidator());
		addValidator(new SCAPolicyIntentUnitValidator());
		addValidator(new SCAPolicySetUnitValidator());
		addValidator(new SCAPropertyUnitValidator());
		addValidator(new SCAPropertyValueUnitValidator());
		addValidator(new SCAReferenceUnitValidator());
		addValidator(new SCAServiceUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new ScaDomainMatcher();
	}
}
