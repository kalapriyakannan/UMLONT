/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator.matcher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * Matcher for J2EE hosting on WAS. Meant to replace DefaultLinkMatcher.
 */
public class J2eeHostingLinkMatcher extends LinkMatcher {

	@Override
	public IStatus canCreateLink(Unit host, Unit hostee) {
		assert null != host;
		assert null != hostee;

		// a unit that has initial install state == installed is already hosted
		if (InstallState.INSTALLED_LITERAL.equals(hostee.getInitInstallState())) {
			return DeployMatcherStatus.INSTALLED_UNIT_CANNOT_BE_HOSTED;
		}

		// a unit cannot host itself
		if (host.equals(hostee)) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}

		List hostingRequirements = hostee.getHostingOrAnyRequirements();

		// if hostee already hosted somewhere then return false
		// we need only look in the current topology since we know that the
		// hostee's initial install state is not "installed".  This means that if
		// there is a hosting link it must be in the current topology.
		if (null != ValidatorUtils.getHost(hostee)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// if hostee has no hosting requirements then return false
		if (0 == hostingRequirements.size()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		// for each hosting requirement see that is matched by a provided
		// capability
		for (Iterator requirements = hostingRequirements.iterator(); requirements.hasNext();) {
			Requirement requirement = (Requirement) requirements.next();

			boolean foundMatch = false;
			for (Iterator capabilities = host.getHostingOrAnyCapabilities().iterator(); capabilities
					.hasNext();) {
				Capability capability = (Capability) capabilities.next();

				EClass reqEType = requirement.getDmoEType();
				if (null == reqEType) {
					reqEType = CorePackage.Literals.CAPABILITY;
				}
				if (reqEType.isSuperTypeOf(capability.getEObject().eClass())) {
					if (J2eePackage.Literals.J2EE_CONTAINER.isSuperTypeOf(reqEType)
							|| J2eePackage.Literals.SERVLET_CONTAINER.isSuperTypeOf(reqEType)
							|| J2eePackage.Literals.JSP_CONTAINER.isSuperTypeOf(reqEType)) {
						if (RequirementUtil.validate(requirement, new ReqEvaluationContext(capability))
								.isOK()) {
							foundMatch = true;
							break;
						}
					} else {
						foundMatch = true;
						break;
					}
				}
			}
			if (!foundMatch) {
				return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
			}
		}

		// found that all hostee hosting requirements were unlinked and
		// that each had a corresponding capability in the proposed host
		return DeployMatcherStatus.MATCH_FOUND;
	}

	public Set<LinkDescriptor> getPossibleLinks(Unit host, Unit hostee) {
		HashSet<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		if (canCreateLink(host, hostee).isOK()) {
			links.add(new LinkDescriptor(LinkType.HOSTING, host, hostee));
		}

		return links;
	}

	public IStatus canBeLinkSource(Unit unit) {
		if (null == unit) {
			return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
		}

		int hostingSize = unit.getOnlyHostingCapabilities().size();
		if (hostingSize == 0 && unit.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(unit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// we consume at least one capability that is not satisfied
		return booleanToStatus(0 < unit.getHostingOrAnyCapabilities().size());
	}

	public IStatus canBeLinkTarget(Unit unit) {

		if (InstallState.INSTALLED_LITERAL.equals(unit.getInitInstallState())) {
			return DeployMatcherStatus.INSTALLED_UNIT_CANNOT_BE_HOSTED;
		}

		// added for M3 to support hosting of software components (without a
		// source or hosting requirements) to conceptual nodes
		// re-evaluate post M3
		if (unit instanceof SoftwareComponent) {
			List requirements = unit.getOnlyHostingRequirements();
			int requirmentSize = 0;
			if (requirements != null) {
				requirmentSize = requirements.size();
				// BA 2007/03/01 getHost() to getImmediateHost()
				if (requirmentSize == 0 && null == ValidatorUtils.getImmediateHost(unit)) {
					return DeployMatcherStatus.MATCH_FOUND;
				}
			}

		}

		// we consume a hosting requirement AND we are not currently hosted

		// Commented out until M4
		// int hostingSize = getOnlyHostingRequirements(unit).size();
		if (unit.isConceptual()
				&& CorePackage.Literals.CONCEPTUAL_NODE.isSuperTypeOf(unit.getEObject().eClass())) {
			return booleanToStatus(false);
		}

		// a unit that has initial install state == installed is already hosted

		// BA 2007/03/01 getHost() to getImmediateHost()
		return booleanToStatus(unit.getHostingOrAnyRequirements().size() > 0
				&& null == ValidatorUtils.getImmediateHost(unit));
	}

	@Override
	public IStatus canBeLinkTarget(Unit target, Capability targetCapability) {
		// for hosting link we ignore the targetCapability
		return canBeLinkTarget(target);
	}

}
