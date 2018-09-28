/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * Validates a {@link DB2Client} capability.
 */
public class DB2ClientValidator extends UnitCapabilityValidator {

	/**
	 * 
	 */
	public DB2ClientValidator() {
		this(Db2Package.eINSTANCE.getDB2Client());
	}

	public DB2ClientValidator(EClass capabilityType) {
		super(capabilityType);
		assert Db2Package.eINSTANCE.getDB2Client().isSuperTypeOf(capabilityType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);

		DB2Client db2ClientCap = (DB2Client) capability;

		ValidatorUtils.validateStrictVersionNumberSyntax(db2ClientCap,
				Db2Package.Literals.DB2_CLIENT__DB2_CLIENT_VERSION, reporter);
	}
}
