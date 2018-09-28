/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal.validator;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.internal.validator.matcher.AnalysisDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitDomainValidator;

/**
 * Validates objects in the {@link AnalysisPackage} deploy domain.
 */
public class AnalysisDomainValidator extends UnitDomainValidator {

	/**
	 * Construct a {@link AnalysisPackage} domain validator.
	 */
	public AnalysisDomainValidator() {
		super(AnalysisPackage.eINSTANCE);
		addValidator(new DeploymentUnitValidator());
		addValidator(new LocationUnitValidator());
		addValidator(new NodeUnitValidator());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new AnalysisDomainMatcher();
	}
	
	
}
