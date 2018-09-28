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
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * Validates a {link DB2ClientInstanceUnit}.
 */
/**
 * @author barnold
 * 
 */
public class DB2ClientInstanceUnitValidator extends UnitValidator {

	/**
	 * 
	 */
	public DB2ClientInstanceUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2ClientInstanceUnit());
	}

	protected DB2ClientInstanceUnitValidator(EClass unitType) {
		super(unitType);

		this.addCapabilityTypeConstraint(Db2Package.Literals.DB2_CLIENT_INSTANCE,
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(Db2Package.Literals.DB2_CLIENT,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_INSTANCE_UNIT_INSTANCE_NAME_001,
				Db2Package.Literals.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);
		if (capability instanceof DB2ClientInstance) {
			validateProvidedDB2ClientInstance(unit, (DB2ClientInstance) capability, reporter, context);
		}
	}

	/**
	 * Validations specific to the DB2 Instance capability
	 * 
	 * @param unit
	 * @param db2ClientInstance
	 * @param reporter
	 * @param context
	 */
	private void validateProvidedDB2ClientInstance(Unit unit, DB2ClientInstance db2ClientInstance,
			IDeployReporter reporter, IDeployValidationContext context) {

		ValidatorUtils.validateStrictVersionNumberSyntax(db2ClientInstance,
				Db2Package.Literals.DB2_BASE_INSTANCE__DB2_VERSION, reporter);
		// db2ClientInstanceName validity rules appear to be same as database name
		// rules.
		if (db2ClientInstance.getDb2InstanceName() == null
				|| db2ClientInstance.getDb2InstanceName().length() == 0) {
			reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(
					db2ClientInstance, Db2Package.Literals.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME));
		} else {
			DB2ValidatorUtils.validateDB2GenericName(db2ClientInstance.getDb2InstanceName(),
					db2ClientInstance, Db2Package.Literals.DB2_BASE_INSTANCE__DB2_INSTANCE_NAME,
					reporter);
		}
	}

}
