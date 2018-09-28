/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator.matcher;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatchFilter;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.OsDeployPlugin;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Filter to remove some matches.
 * 
 */
public class DB2DependencyLinkFilter extends LinkMatchFilter {

	@Override
	public IStatus canCreateLink(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetUnit;

		if (Db2Package.Literals.DB2_CATALOG_UNIT.isSuperTypeOf(sourceUnit.getEObject().eClass())
				&& Db2Package.Literals.DB2_CATALOG_UNIT.isSuperTypeOf(targetUnit.getEObject().eClass())) {
			// No need for a custom explanation here. DB2 catalog cannot be of a DB2 catalog
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (Db2Package.Literals.DB2_INSTANCE_UNIT.isSuperTypeOf(sourceUnit.getEObject().eClass())
				&& OsPackage.Literals.USER_UNIT.isSuperTypeOf(targetUnit.getEObject().eClass())) {
			if (!ValidatorUtils.unitsAreNonLocal(sourceUnit, targetUnit,
					OsPackage.Literals.OPERATING_SYSTEM_UNIT)) {
				if (!DB2ValidatorUtils.userIsInstanceAdminUser((UserUnit) targetUnit, sourceUnit
						.getTopology(), true, true)) {
					return new Status(IStatus.ERROR, OsDeployPlugin.PLUGIN_ID, 0,
							Messages.MustBeDB2InstanceAdminUser, null);
				}
				return DeployMatcherStatus.MATCH_FOUND;
			}
			return new Status(IStatus.ERROR, OsDeployPlugin.PLUGIN_ID, 0,
					Messages.DB2InstanceAdminUserMustBeOnLocalOperatingSystem, null);
		}

		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.ibm.ccl.soa.deploy.core.validator.matcher.DependencyLinkMatcher#getPossibleLinks(com.ibm.ccl.soa.deploy.core.Unit,
//	 *      com.ibm.ccl.soa.deploy.core.Requirement, com.ibm.ccl.soa.deploy.core.Unit,
//	 *      com.ibm.ccl.soa.deploy.core.Capability)
//	 */
//	public Set getPossibleLinks(Unit source, Requirement sourceRequirement, Unit target,
//			Capability targetCapability) {
//		Set retVal = super.getPossibleLinks(source, sourceRequirement, target, targetCapability);
//		for (Iterator iter = retVal.iterator(); iter.hasNext();) {
//			LinkDescriptor ld = (LinkDescriptor) iter.next();
//			Unit sourceUnit = ld.getSourceUnit();
//			Unit targetUnit = ld.getTargetUnit();
//			if (!canCreateLink(sourceUnit, null, targetUnit, null).isOK()) {
//				retVal.remove(ld);
//				continue;
//			}
//		}
//
//		return retVal;
//	}
//
}
