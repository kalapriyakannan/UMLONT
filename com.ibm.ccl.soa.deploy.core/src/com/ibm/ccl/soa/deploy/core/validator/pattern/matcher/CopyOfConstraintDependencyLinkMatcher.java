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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.ConstraintLinkUtils;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.AbstractLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.ConstraintLinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * Identifies whether or not a logical dependency link can be established between a source and and a
 * target.
 */
public class CopyOfConstraintDependencyLinkMatcher extends ConstraintLinkMatcher {

	protected EClass[] sourceTypes;

	protected EClass sourceRequirementType;

	protected EClass[] targetTypes;

	protected EClass targetCapabilityType;

	protected boolean singleton = true;

	protected static AbstractLinkDescriptorFactory linkDescriptorFactory = new LinkDescriptorFactory();

	/**
	 * Construct a logical dependency link matcher between the two units.
	 * 
	 * @param sourceTypes
	 *           array of types of the link source, a subtype of {@link Unit}.
	 * @param sourceRequirementType
	 *           the DeployModelObject of assigned to the source requirement
	 * @param targetTypes
	 *           array of types of the link target, a subtype of {@link Unit}
	 * @param targetCapabilityType
	 *           the type of the link target capability a subtype of {@link Capability}
	 * @param singleton
	 *           flag indicating whether or not there can be multiple logical links
	 */
	public CopyOfConstraintDependencyLinkMatcher(EClass[] sourceTypes, EClass sourceRequirementType,
			EClass[] targetTypes, EClass targetCapabilityType, boolean singleton) {
		assert sourceTypes.length > 0;
		for (int i = 0; i < sourceTypes.length; i++) {
			assert CorePackage.Literals.UNIT.isSuperTypeOf(sourceTypes[i]);
		}
		if (sourceRequirementType != null) {
			assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(sourceRequirementType);
		}
		assert targetTypes.length > 0;
		for (int i = 0; i < targetTypes.length; i++) {
			assert CorePackage.Literals.UNIT.isSuperTypeOf(targetTypes[i]);
		}
		if (targetCapabilityType != null) {
			assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(targetCapabilityType);
		}

		this.sourceTypes = sourceTypes;
		this.sourceRequirementType = sourceRequirementType;
		this.targetTypes = targetTypes;
		this.targetCapabilityType = targetCapabilityType;
		this.singleton = singleton;
	}

	/**
	 * Set the {@link AbstractLinkDescriptorFactory} that should be used to create
	 * {@link LinkDescriptor}s.
	 * 
	 * @param factory
	 *           the link descriptor factory
	 */
	public void setLinkDescritptorFactory(AbstractLinkDescriptorFactory factory) {
		linkDescriptorFactory = factory;
	}

	public IStatus canBeLinkSource(Unit sourceUnit, Requirement sourceRequirement) {
		// check types
		// check that no link already exists (if singleton)

		//
		// CHECK type of sourceUnit
		//
		if (!isSourceUnitTypeAcceptable(sourceUnit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		//
		// CHECK type of sourceRequirement
		// CHECK that there isn't another link (if singleton)
		//
		// if a specific sourceRequirement was input check it
		if (sourceRequirement != null) {
			if (singleton && alreadyLinked(sourceUnit, sourceRequirement)) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			if (!isSourceRequirementTypeAcceptable(sourceRequirement)) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// otherwise check for an "available" source requirement
		// ie, null == sourceRequirement

		// first check if we expect a source requirement; it might be the link
		// is to the unit
		if (null == sourceRequirementType) {
			if (singleton && alreadyLinked(sourceUnit, sourceRequirement)) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// we expect a source requirement and didn't have any so search for them
		// there can be more than one;
		List sourceRequirements = ValidatorUtils.getRequirements(sourceUnit, sourceRequirementType);
		for (int i = 0; i < sourceRequirements.size(); i++) {
			Requirement req = (Requirement) sourceRequirements.get(i);
			if (singleton && alreadyLinked(sourceUnit, req)) {
				continue;
			}
			// we found a valid one
			return DeployMatcherStatus.createMatchFoundWithRequirement(req);
			// return DeployMatcherStatus.MATCH_FOUND;
		}

		return DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canBeLinkSource(Unit unit) {
		// return this.canBeLinkSource(unit, null);
		return super.canBeLinkSource(unit);
	}

	public IStatus canCreateLink(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {

		IStatus sourceStatus = canBeLinkSource(sourceUnit, sourceRequirement);
		if (!sourceStatus.isOK()) {
			return sourceStatus;
		}

		//
		// CHECK type of targetUnit
		//
		if (!isTargetUnitTypeAcceptable(targetUnit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		//
		// CHECK type of targetCapability
		//
		// if we expect a target capability look for one
		if (null == targetCapability) {
			targetCapability = getTargetCapability(targetUnit);
		}

		// if target capability still null and we don't expect one...
		if (null == targetCapability && null == targetCapabilityType) {
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// otherwise if we expected a targetCapability and didn't find one...
		if (null == targetCapability) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// we found a targetCapability
		return isTargetCapabilityTypeAcceptable(targetCapability) ? DeployMatcherStatus.MATCH_FOUND
				: DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit sourceUnit, Unit targetUnit) {
		return canCreateLink(sourceUnit, null, targetUnit, null);
	}

	public Set getPossibleLinks(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {
		Set links = new HashSet();

		// get target capability if not already defined
		if (null == targetCapability) {
			targetCapability = getTargetCapability(targetUnit);
		}

		// if we don't have the targetCapability we expect we better stop now
		if (null == targetCapability && null != targetCapabilityType) {
			return links;
		}

		// we have a single source requirement
		if (null != sourceRequirement) {
			if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability).isOK()) {
				links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit,
						sourceRequirement, targetUnit, targetCapability));
			}
			return links;
		}

		// we don't expect a source requirement
		if (null == sourceRequirementType) {
			if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability).isOK()) {
				if (null == targetCapabilityType) {
					links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
							sourceUnit, targetUnit));
				} else {
					links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
							sourceUnit, sourceRequirement, targetUnit, targetCapability));
				}
			}
			return links;
		}

		// otherwise we expect a source requirment and we don't have it
		List sourceRequirements = ValidatorUtils.getRequirements(sourceUnit, sourceRequirementType);
		for (int i = 0; i < sourceRequirements.size(); i++) {
			Requirement req = (Requirement) sourceRequirements.get(i);

			if (canCreateLink(sourceUnit, req, targetUnit, targetCapability).isOK()) {
				links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit,
						req, targetUnit, targetCapability));
			}
		}

		return links;
	}

	public Set getPossibleLinks(Unit source, Unit target) {
		return getPossibleLinks(source, null, target, null);
	}

	protected boolean isSourceUnitTypeAcceptable(Unit sourceUnit) {
		if (null == sourceUnit) {
			return false;
		}

		for (int i = 0; i < sourceTypes.length; i++) {
			if (sourceTypes[i].isSuperTypeOf(sourceUnit.getEObject().eClass())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isSourceRequirementTypeAcceptable(Requirement sourceRequirement) {
		if (null == sourceRequirement) {
			return false;
		}

		return sourceRequirementType.isSuperTypeOf(sourceRequirement.getDmoEType());
	}

	protected boolean isTargetUnitTypeAcceptable(Unit targetUnit) {
		if (null == targetUnit) {
			return false;
		}

		for (int i = 0; i < targetTypes.length; i++) {
			if (targetTypes[i].isSuperTypeOf(targetUnit.getEObject().eClass())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isTargetCapabilityTypeAcceptable(Capability targetCapability) {
		if (null == targetCapability) {
			return false;
		}

		return targetCapabilityType.isSuperTypeOf(targetCapability.getEObject().eClass());
	}

	// assumes that if sourceRequirement is desired it is set; we do not search
	// for it
	protected boolean alreadyLinked(Unit sourceUnit, Requirement sourceRequirement) {

		// look for existing logical link
		List logicalLinks = sourceUnit.getConstraintLinks();
		for (Iterator<ConstraintLink> llIter = logicalLinks.iterator(); llIter.hasNext();) {
			ConstraintLink link = llIter.next();
			assert sourceUnit == ConstraintLinkUtils.getLogicalLinkSourceUnit(link);
			if (sourceRequirement == ConstraintLinkUtils.getLogicalLinkSourceRequirement(link)) {
				// link already exists
				return true;
			}
		}
		return false;
	}

	protected Capability getTargetCapability(Unit targetUnit) {
		if (null == targetCapabilityType) {
			return null;
		}

		return ValidatorUtils.getFirstCapability(targetUnit, targetCapabilityType);
	}

	// Currently not used
	// assumes that if sourceRequirement is desired it is set; we do not search
	// for it
	protected boolean alreadyLinked(Unit sourceUnit, Requirement sourceRequirement, Unit targetUnit,
			Capability targetCapability) {

		// look for existing logical link
		List logicalLinks = sourceUnit.getConstraintLinks();
		for (Iterator<ConstraintLink> llIter = logicalLinks.iterator(); llIter.hasNext();) {
			ConstraintLink link = llIter.next();
			assert sourceUnit == ConstraintLinkUtils.getLogicalLinkSourceUnit(link);
			if (sourceRequirement == ConstraintLinkUtils.getLogicalLinkSourceRequirement(link)
					&& targetUnit == ConstraintLinkUtils.getLogicalLinkTargetedUnit(link)
					&& targetCapability == ConstraintLinkUtils.getLogicalLinkTargetCapability(link)) {
				// link already exists
				return true;
			}
		}
		return false;
	}

	private class ValidEndpointDefinition {

		private final EClass[] _sourceTypes;
		private final EClass[] _sourceRequirementTypes;
		private final EClass[] _targetTypes;
		private final EClass[] _targetCapabilityTypes;

		/**
		 * Constructor.
		 * 
		 * @param sourceTypes
		 * @param sourceRequirementTypes
		 * @param targetTypes
		 * @param targetCapabilityTypes
		 */
		public ValidEndpointDefinition(EClass[] sourceTypes, EClass[] sourceRequirementTypes,
				EClass[] targetTypes, EClass[] targetCapabilityTypes) {
			assert sourceTypes.length > 0;
			for (int i = 0; i < sourceTypes.length; i++) {
				assert CorePackage.Literals.UNIT.isSuperTypeOf(sourceTypes[i]);
			}

			assert sourceRequirementTypes.length > 0;
			for (int i = 0; i < sourceRequirementTypes.length; i++) {
				assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(sourceRequirementTypes[i]);
			}

			assert targetTypes.length > 0;
			for (int i = 0; i < targetTypes.length; i++) {
				assert CorePackage.Literals.UNIT.isSuperTypeOf(targetTypes[i]);
			}

			assert targetCapabilityTypes.length > 0;
			for (int i = 0; i < targetCapabilityTypes.length; i++) {
				assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(targetCapabilityTypes[i]);
			}

			_sourceTypes = sourceTypes;
			_sourceRequirementTypes = sourceRequirementTypes;
			_targetTypes = targetTypes;
			_targetCapabilityTypes = targetCapabilityTypes;
		}

		/**
		 * Get list of acceptable source unit types.
		 * 
		 * @return array of unit types
		 */
		public EClass[] getSourceUnitTypes() {
			return _sourceTypes;
		}

		/**
		 * Get acceptable source requirement types.
		 * 
		 * @return array of requirement types
		 */
		public EClass[] getSourceRequirementType() {
			return _sourceRequirementTypes;
		}

		/**
		 * Get acceptable target unit types.
		 * 
		 * @return array of unit types
		 */
		public EClass[] getTargetUnitTypes() {
			return _targetTypes;
		}

		/**
		 * Get acceptable target capability types
		 * 
		 * @return array of capability types
		 */
		public EClass[] getTargetCapabilityType() {
			return _targetCapabilityTypes;
		}
	}
}
