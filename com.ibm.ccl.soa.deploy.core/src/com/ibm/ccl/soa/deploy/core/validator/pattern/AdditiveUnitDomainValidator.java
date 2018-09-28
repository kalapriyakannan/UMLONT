/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.NegativeDomainMatcher;

/**
 * Defines an "additive" {@link UnitDomainValidator}; that is, one which can be used to add
 * additional validations to the units in a domain without repeating existing validations.
 */
public class AdditiveUnitDomainValidator extends UnitDomainValidator {

	/**
	 * Construct an additive domain validator.
	 * 
	 * @param domain
	 *           the domain whose units will be validated (may be null for any).
	 */
	public AdditiveUnitDomainValidator(EPackage domain) {
		super(domain);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		super.validate(context, reporter);
	}

	@Override
	public Iterator getValidators(EClass eclass) {
		List list = (List) eclassValidatorMap.get(eclass);
		if ((list == null) || (list.size() == 0)) {
			list = Collections.EMPTY_LIST;
		}

		return list.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		// domain matcher should do nothing additional; if additional matching
		// is being added, it should extend this matcher
		return new NegativeDomainMatcher();
	}
}
