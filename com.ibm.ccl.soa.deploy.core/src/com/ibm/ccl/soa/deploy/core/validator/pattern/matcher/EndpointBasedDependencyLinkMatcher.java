/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.NegativeDependencyLinkMatcher;

public class EndpointBasedDependencyLinkMatcher extends NegativeDependencyLinkMatcher {

	protected EClass sourceType;
	protected EClass sourceReqType;
	protected EClass targetType;
	protected EClass targetCapType;
	protected LinkDescriptorFactory ldf;

	public EndpointBasedDependencyLinkMatcher(EClass sourceType, EClass sourceRequirementEDMOType,
			EClass targetType, EClass targetCapabilityType, LinkDescriptorFactory factory) {
		this.sourceType = sourceType;
		this.sourceReqType = sourceRequirementEDMOType;
		this.targetType = targetType;
		this.targetCapType = targetCapabilityType;
		this.ldf = factory;
	}

	@Override
	public IStatus canBeLinkSource(Unit unit, Requirement requirement) {
		if (!sourceType.isSuperTypeOf(unit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}
		if (null != sourceReqType) {
			if ((null == requirement) || !sourceReqType.isSuperTypeOf(requirement.getDmoEType())) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
		}

		if (null == sourceReqType) {
			// will need to create a requirement to be a valid dependency link
			// check that we can do so; if not return an error
			if (!unit.isPublic()) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	@Override
	public IStatus canCreateLink(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {

		if ((null == sourceRequirement) && (null == targetCapability)) {
			return canCreateLinkInternal(source, target);
		}

		if (null == sourceRequirement) {
			return canCreateLinkInternal(source, targetCapability);
		}

		if (null == targetCapability) {
			return canCreateLinkInternal(sourceRequirement, target);
		}

		return canCreateLinkInternal(sourceRequirement, targetCapability);
	}

	@Override
	public Set<LinkDescriptor> getPossibleLinks(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		assert null != source;
		assert null != target;

		if (null != sourceRequirement) {
			if (null != targetCapability) {
				return getPossibleLinksInternal(source, sourceRequirement, target, targetCapability);
			}
			return getPossibleLinksInternal(source, sourceRequirement, target);
		}

		// we know that sourceRequirement is null
		if (null != targetCapability) {
			if (!target.getDependencyOrAnyCapabilities().contains(targetCapability))
				return new HashSet<LinkDescriptor>();
			return getPossibleLinksInternal(source, target, targetCapability);
		}

		return getPossibleLinksInternal(source, target);
	}

	private IStatus canCreateLinkInternal(Requirement sourceRequirement, Capability targetCapability) {
		assert null != sourceRequirement;
		assert null != targetCapability;

		if (sourceReqType == null) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!sourceReqType.isSuperTypeOf(sourceRequirement.getDmoEType())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (targetCapType == null) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!targetCapType.isSuperTypeOf(targetCapability.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	private IStatus canCreateLinkInternal(Unit sourceUnit, Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetCapability;

		if (!sourceType.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (targetCapType == null) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!targetCapType.isSuperTypeOf(targetCapability.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (sourceReqType != null) {
			// we need to find at least one matching requirement
			List<Requirement> requirements = sourceUnit.getDependencyOrAnyRequirements();
			for (int i = 0; i < requirements.size(); i++) {
				Requirement sourceRequirement = requirements.get(i);
				IStatus status = canCreateLinkInternal(sourceRequirement, targetCapability);
				if (status.isOK()) {
					return status;
				}
			}
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	private IStatus canCreateLinkInternal(Requirement sourceRequirement, Unit targetUnit) {
		assert null != sourceRequirement;
		assert null != targetUnit;

		if (sourceReqType == null) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!sourceReqType.isSuperTypeOf(sourceRequirement.getDmoEType())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!targetType.isSuperTypeOf(targetUnit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (targetCapType != null) {
			// we need to find at least one matching requirement
			List<Capability> capabilities = targetUnit.getDependencyOrAnyCapabilities();
			for (int i = 0; i < capabilities.size(); i++) {
				Capability targetCapability = capabilities.get(i);
				IStatus status = canCreateLinkInternal(sourceRequirement, targetCapability);
				if (status.isOK()) {
					return status;
				}
			}
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		return DeployMatcherStatus.MATCH_FOUND;
	}

	private IStatus canCreateLinkInternal(Unit sourceUnit, Unit targetUnit) {
		assert null != sourceUnit;
		assert null != targetUnit;

		if (!sourceType.isSuperTypeOf(sourceUnit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (!targetType.isSuperTypeOf(targetUnit.getEObject().eClass())) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		if (sourceReqType != null) {
			// we need to find at least one matching requirement
			List<Requirement> requirements = sourceUnit.getDependencyOrAnyRequirements();
			for (int i = 0; i < requirements.size(); i++) {
				Requirement sourceRequirement = requirements.get(i);
				IStatus status = canCreateLinkInternal(sourceRequirement, targetUnit);
				if (status.isOK()) {
					return status;
				}
			}
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// else sourceReqType == null
		if (targetCapType != null) {
			// we need to find at least one matching requirement
			List<Capability> capabilities = targetUnit.getDependencyOrAnyCapabilities();
			for (int i = 0; i < capabilities.size(); i++) {
				Capability targetCapability = capabilities.get(i);
				IStatus status = canCreateLinkInternal(sourceUnit, targetCapability);
				if (status.isOK()) {
					return status;
				}
			}
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// got here so must have not needed either a capability or a requirement
		return DeployMatcherStatus.MATCH_FOUND;
	}

	/**
	 * Retrieve the possible link between a source requirement and a target capability if one exists.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceRequirment
	 *           source requirement
	 * @param targetCapability
	 *           source capability
	 * @return list (size at most 1) of possible links
	 */
	private Set<LinkDescriptor> getPossibleLinksInternal(Unit sourceUnit,
			Requirement sourceRequirment, Unit targetUnit, Capability targetCapability) {
		assert null != sourceRequirment;
		assert null != targetCapability;

		Set<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		// check that can create link
		IStatus canCreateStatus = canCreateLinkInternal(sourceRequirment, targetCapability);
		if (!canCreateStatus.isOK()) {
			return links;
		}

		// we can create a link descriptor
		int statusCode = canCreateStatus.getCode();
		if (0 == statusCode) {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, sourceRequirment,
					targetUnit, targetCapability));
		} else {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, sourceRequirment,
					targetUnit, targetCapability, statusCode));
		}

		return links;
	}

	/**
	 * Retrieve the possible dependency links that can be created between a source unit and a target
	 * capability; that is, between any of the source units requirements and the target capability.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceUnit
	 *           source unit
	 * @param targetCapability
	 *           target capability
	 * @return list of possible dependency links
	 */
	private Set<LinkDescriptor> getPossibleLinksInternal(Unit sourceUnit, Unit targetUnit,
			Capability targetCapability) {
		assert null != sourceUnit;
		assert null != targetUnit;
		assert null != targetCapability;

		Set<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		// check that can create link
		IStatus status = canCreateLinkInternal(sourceUnit, targetCapability);
		if (!status.isOK()) {
			return links;
		}

		if (null != sourceReqType) {
			List<Requirement> requirements = sourceUnit.getDependencyOrAnyRequirements();
			for (int i = 0; i < requirements.size(); i++) {
				Requirement sourceRequirement = requirements.get(i);
				links.addAll(getPossibleLinksInternal(sourceUnit, sourceRequirement, targetUnit,
						targetCapability));
			}
			return links;
		}

		// else null == sourceReqType
		int statusCode = status.getCode();
		if (0 == statusCode) {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, null, targetUnit,
					targetCapability));
		} else {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, null, targetUnit,
					targetCapability, statusCode));
		}
		return links;
	}

	/**
	 * Retrieve the possible dependency links that can be created between a source requirement and a
	 * target unit; that is, with any of the targetUnit's capabilities.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceRequirement
	 *           source requirement
	 * @param targetUnit
	 *           target unit
	 * @return list of possible dependency links
	 */
	private Set<LinkDescriptor> getPossibleLinksInternal(Unit sourceUnit,
			Requirement sourceRequirement, Unit targetUnit) {
		assert null != sourceRequirement;
		assert null != targetUnit;

		Set<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		// check that can create link
		IStatus status = canCreateLinkInternal(sourceRequirement, targetUnit);
		if (!status.isOK()) {
			return links;
		}

		if (null != targetCapType) {
			List<Capability> capabilities = targetUnit.getDependencyOrAnyCapabilities();
			for (int i = 0; i < capabilities.size(); i++) {
				Capability targetCapability = capabilities.get(i);
				links.addAll(getPossibleLinksInternal(sourceUnit, sourceRequirement, targetUnit,
						targetCapability));
			}
			return links;
		}

		// else null == targetCapType
		int statusCode = status.getCode();
		if (0 == statusCode) {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, sourceRequirement,
					targetUnit, null));
		} else {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, sourceRequirement,
					targetUnit, null, statusCode));
		}
		return links;
	}

	/**
	 * Retrieve the possible dependency links that can be created between a source unit and a target
	 * unit; that is, between any of the source units requirements and any of the targetUnit's
	 * capabilities.
	 * 
	 * @param context
	 *           Identifier of source/target units
	 * @param sourceUnit
	 *           source unit
	 * @param targetUnit
	 *           target unit
	 * @return list of possible dependency links
	 */
	private Set<LinkDescriptor> getPossibleLinksInternal(Unit sourceUnit, Unit targetUnit) {
		assert null != sourceUnit;
		assert null != targetUnit;

		Set<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		// check that can create link
		IStatus status = canCreateLinkInternal(sourceUnit, targetUnit);
		if (!status.isOK()) {
			return links;
		}

		if (sourceReqType != null) {
			// we need to find at least one matching requirement
			List<Requirement> requirements = sourceUnit.getDependencyOrAnyRequirements();
			for (int i = 0; i < requirements.size(); i++) {
				Requirement sourceRequirement = requirements.get(i);
				links.addAll(getPossibleLinksInternal(sourceUnit, sourceRequirement, targetUnit));
			}
			return links;
		}

		// else sourceReqType == null

		if (targetCapType != null) {
			// we need to find at least one matching requirement
			List<Capability> capabilities = targetUnit.getDependencyOrAnyCapabilities();
			for (int i = 0; i < capabilities.size(); i++) {
				Capability targetCapability = capabilities.get(i);
				links.addAll(getPossibleLinksInternal(sourceUnit, targetUnit, targetCapability));
			}
			return links;
		}

		// else sourceReqType == null  &&  targetCapType == null
		int statusCode = status.getCode();
		if (0 == statusCode) {
			links.add(ldf
					.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, null, targetUnit, null));
		} else {
			links.add(ldf.createLinkDescriptor(LinkType.DEPENDENCY, sourceUnit, null, targetUnit,
					null, statusCode));
		}
		return links;
	}

}
