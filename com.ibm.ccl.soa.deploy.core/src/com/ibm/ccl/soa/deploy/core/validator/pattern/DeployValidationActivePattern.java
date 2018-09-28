/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.pattern;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;

/**
 * Abstract implementation of {@link IDeployValidationActivePattern}.
 * <p>
 * It is recommended that implementations of {@link IDeployValidationActivePattern} extend this
 * type, instead of implementing the interface directly.
 */
public abstract class DeployValidationActivePattern implements IDeployValidationActivePattern {

	/**
	 * Finds the link between the requirement and the capability.
	 * 
	 * @param req
	 *           a requirement.
	 * @param cap
	 *           a capability.
	 * @param fix
	 *           true if the link should be created if missing.
	 * @return the OK if the link exists, or was created.
	 */
	protected IStatus findDependencyLink(Requirement req, Capability cap, boolean fix) {
		if (req == null || cap == null) {
			return FAIL_NO_FIX;
		}
		if (req.getLink() == null) {
			if (!fix) {
				return FAIL_HAS_FIX;
			}
			DependencyLink link = CoreFactory.eINSTANCE.createDependencyLink();
			req.setLink(link);
			UnitUtil.assignUniqueName(link);
		}

		if (req.getLink().getTarget() != cap) {
			if (!fix) {
				return FAIL_HAS_FIX;
			}
			req.getLink().setTarget(cap);
		}
		return Status.OK_STATUS;
	}

	/**
	 * Find a hosted unit and optionally create it from a template.
	 * 
	 * @param host
	 *           the unit host.
	 * @param type
	 *           the unit or capability type of the hosted unit.
	 * @param hostedUnitTemplate
	 *           the template from which to create the hosted unit if it is not found.
	 * @param fix
	 *           true if the hosted unit should be created if missing.
	 * @return the status of validation/fix.
	 */
	protected IStatus findHostedUnit(Unit host, EClass type, String hostedUnitTemplate, boolean fix) {
		if (host == null || type == null) {
			return FAIL_NO_FIX;
		}
		List hostedUnitList;
		if (CorePackage.eINSTANCE.getUnit().isSuperTypeOf(type)) {
			hostedUnitList = ValidatorUtils.discoverHosted(host, type, null);
		} else if (CorePackage.eINSTANCE.getCapability().isSuperTypeOf(type)) {
			hostedUnitList = ValidatorUtils.discoverHostedWithCapability(host, type, false, null);
		} else {
			return FAIL_NO_FIX;
		}

		if (hostedUnitList == null || hostedUnitList.size() > 1) {
			return FAIL_NO_FIX;
		}

		if (hostedUnitList.size() == 0) {
			if (!fix) {
				return FAIL_HAS_FIX;
			}
			if (hostedUnitTemplate == null) {
				return FAIL_NO_FIX;
			}
			// Create unit
			Unit hosted = (Unit) ResolutionUtils.addFromTemplate(hostedUnitTemplate, host
					.getTopology());
			if (hosted == null) {
				return FAIL_NO_FIX;
			}
			// Hosting link
			HostingLink hostLink = CoreFactory.eINSTANCE.createHostingLink();
			hostLink.setTarget(hosted);
			host.getHostingLinks().add(hostLink);
			UnitUtil.assignUniqueName(hostLink);
		}
		return Status.OK_STATUS;
	}
}
