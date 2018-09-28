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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.DeployDb2MessageFactory;
import com.ibm.ccl.soa.deploy.db2.internal.validator.matcher.AdditionalDB2HostingLinkMatcher;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;

/**
 * Validates a {link DB2SystemUnit}.
 */
public class DB2SystemUnitValidator extends UnitValidator {

	/**
	 * 
	 */
	public DB2SystemUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2SystemUnit());
	}

	protected DB2SystemUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2SystemUnit().isSuperTypeOf(unitType);

		this.addCapabilityTypeConstraint(Db2Package.eINSTANCE.getDB2System(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(Db2Package.eINSTANCE.getDB2JdbcDriver(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, Integer.MAX_VALUE);
		this.addCapabilityTypeConstraint(Db2Package.eINSTANCE.getDB2Client(),
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		this.addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addCapabilityValidator(new DB2JdbcDriverValidator());
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_SYSTEM_UNIT_INSTALL_DIR_001,
				Db2Package.Literals.DB2_SYSTEM__INSTALL_DIR));

		DeployAttributeInvalidPathnameValidator systemInstallPathValidator = new DeployAttributeInvalidPathnameValidator(
				IDB2ValidatorID.DB2_SYSTEM_UNIT_INSTALL_DIR_INVALID_001,
				Db2Package.Literals.DB2_SYSTEM__INSTALL_DIR);
		systemInstallPathValidator.setRequireDriveLetterWindows(true);
		systemInstallPathValidator.setRequireRootedPathUnix(true);
		addAttributeValidator(systemInstallPathValidator);

		DeployAttributeInvalidPathnameValidator clientPathValidator = new DeployAttributeInvalidPathnameValidator(
				IDB2ValidatorID.DB2_SYSTEM_UNIT_CLIENT_INSTALL_DIR_INVALID_001,
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

		DB2System db2SystemCap = (DB2System) ValidatorUtils.getCapability(unit,
				Db2Package.Literals.DB2_SYSTEM);

		// TODO Add DB2 version number checks here against known DB2 versions? 
		// The additional validation is only necessary to detect invalid version numers XML, 
		// which the xml parser apparently doesn't complain about. The properties page will not allow setting of 	
		// invalid version numbers.
		ValidatorUtils.validateStrictVersionNumberSyntax(db2SystemCap,
				Db2Package.Literals.DB2_SYSTEM__DB2_VERSION, reporter);
		DB2Client db2ClientCap = (DB2Client) ValidatorUtils.getCapability(unit,
				Db2Package.Literals.DB2_CLIENT);
		ValidatorUtils.validateStrictVersionNumberSyntax(db2ClientCap,
				Db2Package.Literals.DB2_CLIENT__DB2_CLIENT_VERSION, reporter);
		if (db2ClientCap != null && db2SystemCap != null
				&& db2ClientCap.getDb2ClientVersion() != db2SystemCap.getDb2Version()) {
			IDeployAttributeValueStatus status = DeployCoreStatusUtil
					.createObjectAttributeInvalidStatus(db2ClientCap,
							Db2Package.Literals.DB2_CLIENT__DB2_CLIENT_VERSION, db2SystemCap
									.getDb2Version());
			reporter.addStatus(status);
		}

		// TODO implement
		// DB2JdbcDriver.classpath valid
		// DB2JdbcDriver.driverPath valid
		// DB2JdbcDriver.driverPath implied OS matches operatingSystem.osType
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateHostingLinkMatch(com.ibm.ccl.soa.deploy.core.HostingLink,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateHostingLinkMatch(HostingLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		Unit host = link.getHost();
		Unit hosted = link.getHosted();
		IStatus specialStatus = AdditionalDB2HostingLinkMatcher.isDatabaseOnSystem(hosted, host);
		if (specialStatus.isOK()) {
			//
			// Overrides to UnitValidator methods to support the logical link
			// DB2SystemUnit HOSTS DB2DatabaseUnit.
			//
			// TODO remove this method when implemented by a LogicalLink
			//
			reporter.addStatus(DeployDb2MessageFactory.createUnitDatabaseInstanceMissing(hosted,
					(Requirement) hosted.getRequirements().get(0), host));
		} else {
			super.validateHostingLinkMatch(link, unit, context, reporter);
		}
	}
}
