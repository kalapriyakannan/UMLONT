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

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;

/**
 * Validates a {link DB2RuntimeClientUnit}.
 */
public class DB2RuntimeClientUnitValidator extends UnitValidator {

	/**
	 * 
	 */
	public DB2RuntimeClientUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2RuntimeClientUnit());
	}

	protected DB2RuntimeClientUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2RuntimeClientUnit().isSuperTypeOf(unitType);

		this.addCapabilityTypeConstraint(Db2Package.Literals.DB2_CLIENT,
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(Db2Package.Literals.DB2_JDBC_DRIVER,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(OsPackage.Literals.OPERATING_SYSTEM,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addCapabilityValidator(new DB2JdbcDriverValidator());

		DeployAttributeInvalidPathnameValidator clientPathValidator = new DeployAttributeInvalidPathnameValidator(
				IDB2ValidatorID.DB2_CLIENT_UNIT_CLIENT_INSTALL_DIR_INVALID_001,
				Db2Package.Literals.DB2_CLIENT__INSTALL_DIR);
		clientPathValidator.setRequireDriveLetterWindows(true);
		clientPathValidator.setRequireRootedPathUnix(true);
		addAttributeValidator(clientPathValidator);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);

		DB2Client db2ClientCap = (DB2Client) ValidatorUtils.getCapability(unit,
				Db2Package.Literals.DB2_CLIENT);
//		DB2ValidatorUtils.validateInstallDirValidForHostingOS(db2ClientCap, Db2Package.Literals.DB2_CLIENT__INSTALL_DIR, reporter);
		ValidatorUtils.validateStrictVersionNumberSyntax(db2ClientCap,
				Db2Package.Literals.DB2_CLIENT__DB2_CLIENT_VERSION, reporter);
	}
}
