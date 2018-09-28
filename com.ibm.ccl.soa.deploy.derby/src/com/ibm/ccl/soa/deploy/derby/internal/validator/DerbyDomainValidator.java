/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.derby.internal.validator;

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * Validates objects in the Derby domain.
 */
public class DerbyDomainValidator extends DomainValidator {

	protected UnitValidator derbyUnitValidator;

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		for (Iterator iter = context.findAllUnits(DerbyPackage.eINSTANCE); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (derbyUnitValidator == null) {
				// TODO support derby-specific unit validation
				derbyUnitValidator = new UnitValidator(CorePackage.Literals.UNIT);
			}
			derbyUnitValidator.validate(unit, context, reporter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new CoreDomainMatcher();
	}
}
