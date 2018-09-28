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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
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
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.database.SQLUser;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;

/**
 * Validates a {@link DB2DatabaseUnit}.
 * 
 * @see DB2DomainValidator
 */
public class DB2DatabaseUnitValidator extends UnitValidator {

	/**
	 * 
	 */
	public DB2DatabaseUnitValidator() {
		this(Db2Package.eINSTANCE.getDB2DatabaseUnit());
	}

	protected DB2DatabaseUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2Package.eINSTANCE.getDB2DatabaseUnit().isSuperTypeOf(unitType);

		this.addCapabilityTypeConstraint(Db2Package.eINSTANCE.getDB2Database(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(Db2Package.eINSTANCE.getDB2Instance(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addCapabilityValidator(new DB2DatabaseValidator());

		// Generic DB2Database validator does not required dbName to be set
		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IDB2ValidatorID.DB2_DATABASE_UNIT_DB_NAME_001, Db2Package.eINSTANCE
						.getDB2Database_DbName(), IStatus.ERROR));

		// dbName unique in instance host.
		//		
		// Note: If the database is to be hosted on the system directly, then we
		// need to switch to CapabilityAttributeUniqueInDependencyValidator
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IDB2ValidatorID.DB2_DATABASE_UNIT_DB_NAME_002, Db2Package.eINSTANCE
						.getDB2Database_DbName()));
	}

	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
		validateSQLUserMatchesUserOnHostingOS(unit, context, reporter);
	}

	private void validateSQLUserMatchesUserOnHostingOS(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {

		// discover hosted SQLModules
		// For each SQLUser on each hosted SQLModule, match against users on hosting operating system

		Map<String, Capability> usersMap = DB2ValidatorUtils.getUsersOnHostingOS(unit);

		if (usersMap.size() == 0) {
			return;
		}
		List<Unit> smList = ValidatorUtils.discoverHosted(unit, DatabasePackage.eINSTANCE
				.getSQLModule(), context.getProgressMonitor());
		for (Iterator<Unit> smIter = smList.iterator(); smIter.hasNext();) {
			SQLModule sm = (SQLModule) smIter.next();
			List<Capability> suList = ValidatorUtils.getCapabilities(sm, DatabasePackage.eINSTANCE
					.getSQLUser());
			for (Iterator<Capability> suIter = suList.iterator(); suIter.hasNext();) {
				SQLUser su = (SQLUser) suIter.next();
				boolean foundMatchingOSUser = false;
				if (su.getUserId() != null) {
					User u = (User) usersMap.get(su.getUserId());
					if (u != null) {
						foundMatchingOSUser = true;
						if (!(u.getUserPassword() != null && u.getUserPassword().equals(
								su.getUserPassword()))) {
							reporter.addStatus(DeployCoreStatusUtil
									.createAttributeInvalidSourceValueStatus(IStatus.ERROR,
											IDB2ValidatorID.SQL_MODULE_USER_PASSWORD_FROM_USER_001, su,
											DatabasePackage.eINSTANCE.getSQLUser_UserPassword(), u,
											OsPackage.eINSTANCE.getUser_UserPassword()));
						}
					}
					if (!foundMatchingOSUser && usersMap.size() > 0) {
						reporter.addStatus(DeployCoreStatusUtil.createAttributeInvalidStatus(
								IStatus.ERROR, IDB2ValidatorID.SQL_MODULE_USER_NOT_FOUND_ON_OS_001, su,
								DatabasePackage.eINSTANCE.getSQLUser_UserId()));
					}
				}
			}
		}

	}

}
