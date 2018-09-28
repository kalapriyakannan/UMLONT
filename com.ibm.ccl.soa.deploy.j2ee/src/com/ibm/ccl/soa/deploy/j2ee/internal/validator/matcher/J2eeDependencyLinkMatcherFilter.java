/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator.matcher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatchFilter;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * Disallow links - From EAR to datasource if the units are hosted on different operating systems
 */
public class J2eeDependencyLinkMatcherFilter extends LinkMatchFilter {

	@Override
	public IStatus canCreateLink(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {
		if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			if (ValidatorUtils.getCapability(targetUnit, J2eePackage.Literals.J2EE_DATASOURCE) != null) {
				if (ValidatorUtils.unitsAreNonLocal(sourceUnit, targetUnit,
						OsPackage.Literals.OPERATING_SYSTEM_UNIT)) {
//					return new Status(IStatus.ERROR, J2EEDeployPlugin.pluginID, 0, 
//							"TODO", /* e.g. Messages.DatasourceMustBeHostedOnSameOperatingSystem,*/  //$NON-NLS-1$
//							null);
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				}
			}
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
//			if (!DeployMatcherStatus.MATCH_FOUND.equals(canCreateLink(sourceUnit, null, targetUnit,
//					null))) {
//				iter.remove();
//				continue;
//			}
//		}
//
//		return retVal;
//	}
}
