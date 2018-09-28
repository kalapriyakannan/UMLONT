/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Common methods used by matching and validation.
 */
public class EARModuleToDBDatabaseUtils {

	/**
	 * Check if the topology contains the right things to allow us to correctly implement the link.
	 * 
	 * @param link
	 *           the link
	 * @return true if can do it
	 * @deprecated
	 */
	public static boolean canImplementLogicalServiceLink(DependencyLink link) {
		if (null == link || null == link.getSource() || null == link.getTarget()) {
			return false;
		}
		Unit sourceUnit = ValidatorUtils.getOwningUnit(link.getSource());
		Unit targetUnit = ValidatorUtils.getOwningUnit(link.getTarget());

		IStatus status = canImplementLogicalServiceLink(sourceUnit, link.getSource(), targetUnit,
				link.getTarget());
		return status.isOK();
	}

	/**
	 * Verify the preconditions for the implementation of a logical service link between an EAR and a
	 * DB.
	 * 
	 * @param sourceUnit
	 *           the EAR unit
	 * @param sourceRequirement
	 *           the consumed J2eeDatasource service
	 * @param targetUnit
	 *           the DB unit
	 * @param targetCapability
	 *           the provided DB service
	 * @return OK status when the link can be implemented
	 */
	public static IStatus canImplementLogicalServiceLink(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit, Capability targetCapability) {

		// test if we this is a an EarModule.J2eeDatasource ->
		// DB2DatabaseUnit.DB2Database
		// That is,
		// EarModule is super type of unit1, and
		// J2eeDatasource is super type of service1, and
		// DB2Database is super type of service2, and
		// OperatingSystemUnit -> WebsphereAppServerUnit -> unit1, and
		// EITHER
		// Db2DatabaseUnit is super type of unit2, and
		// OperatingSystemUnit -> DB2SystemUnit -> DB2InstanceUnit -> unit2 and
		// DB2InstanceUnit consumed user is satisfied
		// OR
		// DB2CatalogUnit is super type of unit2, and
		// DB2CatalogUnit linked to DB2NodeCatalogUnit linked to DB2ClientUnit

		IStatus endpointsStatus = checkEndpoints(sourceUnit, sourceRequirement, targetUnit,
				targetCapability);
		if (!endpointsStatus.isOK()) {
			return endpointsStatus;
		}

		// identify type of target unit
		EClass unit2Class = targetUnit.getEObject().eClass();
		boolean isDbUnit = Db2Package.Literals.DB2_DATABASE_UNIT.equals(unit2Class);
		boolean isCatalogUnit = false;
		if (!isDbUnit) {
			isCatalogUnit = Db2Package.Literals.DB2_CATALOG_UNIT.equals(unit2Class);
		}

		// verify source unit is hosted to OS
		OperatingSystemUnit unit1Os = (OperatingSystemUnit) ValidatorUtils.discoverHostInStack(
				sourceUnit, OsPackage.Literals.OPERATING_SYSTEM_UNIT, null);
		if (null == unit1Os) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (isDbUnit) {
			// verify db unit is hosted to OS
			OperatingSystemUnit unit2Os = (OperatingSystemUnit) ValidatorUtils.discoverHostInStack(
					targetUnit, OsPackage.Literals.OPERATING_SYSTEM_UNIT, null);
			if (null == unit2Os) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}

			// ensure the user is linked to instance
			Unit dbHost = ValidatorUtils.getHost(targetUnit);
			if (!Db2Package.Literals.DB2_INSTANCE_UNIT.isSuperTypeOf(dbHost.getEObject().eClass())) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			DB2InstanceUnit instanceUnit = (DB2InstanceUnit) dbHost;
			if (null == instanceUnit) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			Requirement user = ValidatorUtils.getFirstRequirement(instanceUnit,
					OsPackage.Literals.USER);
			if (null == user) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			UnitDescriptor userUnitUD = TopologyDiscovererService.INSTANCE.findTarget(instanceUnit,
					user, instanceUnit.getTopology());
			if (userUnitUD == null) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			UserUnit administratorUserUnit = (UserUnit) userUnitUD.getUnitValue();
			if (administratorUserUnit == null) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			Capability providedUser = ValidatorUtils.getCapability(administratorUserUnit,
					OsPackage.eINSTANCE.getUser());
			if (providedUser == null) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}

//			DependencyLink userLink = user.getLink();
//			if (null == userLink) {
//				return DeployMatcherStatus.MATCH_NOT_FOUND;
//			}
//			Capability providedUser = userLink.getTarget();
//			if (null == providedUser) {
//				return DeployMatcherStatus.MATCH_NOT_FOUND;
//			}
//			UserUnit administrator = (UserUnit) ValidatorUtils
//					.getOwningUnit(providedUser);
//			if (null == administrator) {
//				return DeployMatcherStatus.MATCH_NOT_FOUND;
//			}
		}

		if (isCatalogUnit) {
			// verify catalog unit is hosted to OS
			OperatingSystemUnit unit2Os = (OperatingSystemUnit) ValidatorUtils.discoverHostInStack(
					targetUnit, OsPackage.Literals.OPERATING_SYSTEM_UNIT, null);
			if (null == unit2Os) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			// In this case, the hosting OS must be the same as that for the
			// module
			if (!unit2Os.equals(unit1Os)) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
		}

		// we've tried hard to find a reason to reject... but we can't!
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Verify that the endpoints are valid for this kind of link.
	 * 
	 * @param sourceUnit
	 *           the source unit (one of EarModule, EjbModule or WebModule expected)
	 * @param sourceRequirement
	 *           the source service (J2eeDataSource expected)
	 * @param targetUnit
	 *           the target unit (one of DB2DatabaseUnit or DB2CatalogUnit expected)
	 * @param targetCapability
	 *           the target service (DB2Database expected)
	 * @return OK status if endpoints are as expected
	 */
	public static IStatus checkEndpoints(Unit sourceUnit, Requirement sourceRequirement,
			Unit targetUnit, Capability targetCapability) {
		// check the type of the source unit
		if (!J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())
				&& !J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())
				&& !J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// make sure we have a source requirement
		if (null == sourceRequirement) {
			sourceRequirement = ValidatorUtils.getFirstRequirement(sourceUnit,
					J2eePackage.Literals.J2EE_DATASOURCE);
			if (null == sourceRequirement) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
		}

		// check the type of the source requirement
		if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(sourceRequirement.getDmoEType())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// identify the target unit type; verify that it is a DatabaseUnit or a
		// CatalogUnit
		EClass unit2Class = targetUnit.getEObject().eClass();
		boolean isDbUnit = Db2Package.Literals.DB2_DATABASE_UNIT.equals(unit2Class);
		boolean isCatalogUnit = false;
		if (!isDbUnit) {
			isCatalogUnit = Db2Package.Literals.DB2_CATALOG_UNIT.equals(unit2Class);
		}
		if (!isDbUnit && !isCatalogUnit) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// make sure we have a target capability
		if (null == targetCapability) {
			targetCapability = ValidatorUtils.getFirstCapability(targetUnit,
					Db2Package.Literals.DB2_DATABASE);
		}
		if (null == targetCapability) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// check that the target capability is the right type
		if (!Db2Package.Literals.DB2_DATABASE.isSuperTypeOf(targetCapability.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// if we got this far, we have the right endpoint types !!
		return DeployMatcherStatus.MATCH_FOUND;
	}

}
