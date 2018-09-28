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

import java.util.Iterator;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;
import com.ibm.ccl.soa.deploy.uml.internal.validator.matcher.UMLDomainMatcher;

/**
 * Validates {@link SoftwareComponent} units from the {@link CorePackage} domain that are related to
 * the UML {@link UmlPackage}.
 * <p>
 * The {@link UmlPackage} validator is {@link UMLDomainValidator}.
 */
public class UMLCoreTypeDomainValidator extends DomainValidator {

	/** The {@link SoftwareComponent} which is invoked if the topology has an instance of the type. */
	protected UMLComponentUnitValidator umlElementUnitValidator = null;

	/**
	 * Construct a {@link CorePackage} domain validator specialized for
	 * {@link CorePackage#getSoftwareComponent()}.
	 */
	public UMLCoreTypeDomainValidator() {
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		for (Iterator iter = context.findAllUnits(CorePackage.eINSTANCE.getSoftwareComponent()); iter
				.hasNext();) {
			SoftwareComponent sc = (SoftwareComponent) iter.next();
			if (sc != null) {
				if (umlElementUnitValidator == null) {
					umlElementUnitValidator = new UMLComponentUnitValidator();
				}
				umlElementUnitValidator.validate(sc, context, reporter);
			}
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	@Override
	protected DomainMatcher createDomainMatcher() {
		// no matcher customizations needed
		return new UMLDomainMatcher();
	}
}
