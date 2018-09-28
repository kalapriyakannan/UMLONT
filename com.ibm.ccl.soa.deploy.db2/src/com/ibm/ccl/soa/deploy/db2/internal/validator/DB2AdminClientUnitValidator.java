/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.DeployAttributeInvalidPathnameValidator;

/**
 * Validates a {@link DB2AdminClientUnit}.
 * <p>
 * <ul>
 * <li> {@link DB2ClientValidator}
 * <li> {@link DB2JdbcDriverValidator}
 * </ul>
 */
public class DB2AdminClientUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link DB2AdminClientUnit} validator.
	 */
	public DB2AdminClientUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2AdminClientUnit());
	}

	/**
	 * Construct a {@link DB2AdminClientUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link DB2AdminClientUnit}.
	 */
	protected DB2AdminClientUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2AdminClientUnit().isSuperTypeOf(unitType);

		addCapabilityTypeConstraint(Db2Package.Literals.DB2_JDBC_DRIVER,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, Integer.MAX_VALUE);
		addCapabilityTypeConstraint(Db2Package.Literals.DB2_ADMIN_CLIENT,
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		addRequirementTypeConstraint(OsPackage.Literals.OPERATING_SYSTEM,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addCapabilityValidator(new DB2JdbcDriverValidator());
		addCapabilityValidator(new DB2ClientValidator());

		DeployAttributeInvalidPathnameValidator clientPathValidator = new DeployAttributeInvalidPathnameValidator(
				IDB2ValidatorID.DB2_CLIENT_UNIT_CLIENT_INSTALL_DIR_INVALID_001,
				Db2Package.Literals.DB2_CLIENT__INSTALL_DIR);
		clientPathValidator.setRequireDriveLetterWindows(true);
		clientPathValidator.setRequireRootedPathUnix(true);
		addAttributeValidator(clientPathValidator);
	}
}
