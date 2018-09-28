/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.core.validator;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * A validator used to test the registration of global validators that are
 * invoked on a topology no matter the number and/or types of units it contains.
 */
public class SyntheticGlobalDomainValidator extends DomainValidator {

	/**
	 * Special description that triggers an error in
	 * {@link SyntheticGlobalDomainValidator}.
	 */
	public static final String SPECIAL_DESCRIPTION = SyntheticGlobalDomainValidator.class
			.getName();

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context,
			IDeployReporter reporter) {
		Topology top = context.getTopology();
		if (SPECIAL_DESCRIPTION.equals(top.getDescription())) {
			addTestStatus(top, reporter);
		}
		for (Iterator iter = top.getUnits().iterator(); iter.hasNext();) {
			Unit unit = (Unit) iter.next();
			if (SPECIAL_DESCRIPTION.equals(unit.getDescription())) {
				addTestStatus(unit, reporter);
			}
		}
	}

	/**
	 * Adds a test message to the object.
	 * 
	 * @param object
	 * @param reporter
	 */
	protected void addTestStatus(DeployModelObject object,
			IDeployReporter reporter) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(IStatus.ERROR,
						SyntheticGlobalDomainValidator.class.getName(),
						SyntheticGlobalDomainValidator.class.getName(),
						"Test status", null, object);//$NON-NLS-1$
		reporter.addStatus(status);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new CoreDomainMatcher();
	}
}
