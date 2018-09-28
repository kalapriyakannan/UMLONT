/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import java.util.ArrayList;
import java.util.Collections;
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
public class ConstraintDependencyLinkMatcher extends ConstraintLinkMatcher {

	private final List<ValidEndpointDefinition> _validEndpointDefinitions = new ArrayList<ValidEndpointDefinition>();

	protected boolean _singleton = true;

	protected AbstractLinkDescriptorFactory linkDescriptorFactory = new LinkDescriptorFactory();

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
	public ConstraintDependencyLinkMatcher(EClass[] sourceTypes, EClass sourceRequirementType,
			EClass[] targetTypes, EClass targetCapabilityType, boolean singleton) {

		_validEndpointDefinitions.add(new ValidEndpointDefinition(filterNull(sourceTypes),
				new EClass[] { sourceRequirementType }, filterNull(sourceTypes),
				new EClass[] { targetCapabilityType }));
		_singleton = singleton;
	}

	public ConstraintDependencyLinkMatcher(EClass[] sourceTypes, EClass[] sourceRequirementTypes,
			EClass[] targetTypes, EClass[] targetCapabilityTypes, boolean singleton) {

		_validEndpointDefinitions.add(new ValidEndpointDefinition(filterNull(sourceTypes),
				filterNull(sourceRequirementTypes), filterNull(targetTypes),
				filterNull(targetCapabilityTypes)));
		_singleton = singleton;
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

	public void addEndpointMatch(EClass[] sourceTypes, EClass[] sourceRequirementTypes,
			EClass[] targetTypes, EClass[] targetCapabilityTypes) {
		_validEndpointDefinitions.add(new ValidEndpointDefinition(filterNull(sourceTypes),
				filterNull(sourceRequirementTypes), filterNull(targetTypes),
				filterNull(targetCapabilityTypes)));
	}

	public IStatus canBeLinkSource(Unit sourceUnit, Requirement sourceRequirement) {
		// check types
		// check that no link already exists (if singleton)

		//
		// CHECK type of sourceUnit and sourceRequirement
		//
		List<ValidEndpointDefinition> definitions = getEndpointDefinitionsFromSource(sourceUnit,
				sourceRequirement);
		if (definitions.isEmpty()) {
//		if (!isSourceUnitTypeAcceptable(sourceUnit)) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		//
//		// CHECK type of sourceRequirement
		// CHECK that there isn't another link (if singleton required)
		//
		// if a specific sourceRequirement was input check it
		if (sourceRequirement != null) {
			if (_singleton && alreadyLinked(sourceUnit, sourceRequirement)) {
				return DeployMatcherStatus.MATCH_NOT_FOUND;
			}
//			if (!isSourceRequirementTypeAcceptable(sourceRequirement)) {
//				return DeployMatcherStatus.MATCH_NOT_FOUND;
//			}
			return DeployMatcherStatus.MATCH_FOUND;
		}

		// otherwise check for an "available" source requirement
		// ie, null == sourceRequirement

		// we may have several definitions that are acceptable
		// we need to find one that works
		for (ValidEndpointDefinition epDefn : definitions) {
			// first check if we expect a source requirement for this definition; 
			// it might be the link is to the unit
			if (0 == epDefn.getSourceRequirementType().length) {
				if (_singleton && alreadyLinked(sourceUnit, sourceRequirement)) {
					return DeployMatcherStatus.MATCH_NOT_FOUND;
				}
				return DeployMatcherStatus.MATCH_FOUND;
			}

			// for this definition, we expect a source requirement and didn't have any 
			// so must search for them
			// note that there can be more than one
			for (int i = 0; i < epDefn.getSourceRequirementType().length; i++) {
				List<Requirement> sourceRequirements = ValidatorUtils.getRequirements(sourceUnit,
						epDefn.getSourceRequirementType()[i]);
				for (Requirement req : sourceRequirements) {
					if (_singleton && alreadyLinked(sourceUnit, req)) {
						continue;
					}
					// we found a valid one; there may be others we haven't identified
					return DeployMatcherStatus.createMatchFoundWithRequirement(req);
					// return DeployMatcherStatus.MATCH_FOUND;
				}
			}
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
//		if (!isTargetUnitTypeAcceptable(targetUnit)) {
//			return DeployMatcherStatus.MATCH_NOT_FOUND;
//		}
		List<ValidEndpointDefinition> definitions = getEndpointDefinitionsFromSource(sourceUnit,
				sourceRequirement);
		definitions = getEndpointDefinitionsFromTarget(targetUnit, targetCapability, definitions);
		if (definitions.isEmpty()) {
			return DeployMatcherStatus.MATCH_NOT_FOUND;
		}

		// We now have several definitons that might apply.
		// We need to find one that does.

		for (ValidEndpointDefinition epDefn : definitions) {
//			//
//			// CHECK type of targetCapability
//			//
//			// if we expect a target capability look for one that is acceptable
//			if (null == targetCapability) {
//				targetCapability = getTargetCapability(targetUnit, epDefn);
//			}
//			
			if (0 == epDefn.getTargetCapabilityType().length) {
				// this definition does not expect a target capability
				// if we don't have one we have a match
				if (null == targetCapability) {
					return DeployMatcherStatus.MATCH_FOUND;
				}
			}
			// look through all valid target capability types and see if the unit has one
			for (int i = 0; i < epDefn.getTargetCapabilityType().length; i++) {
				// look for a target capability from among the list of acceptable ones
				if (!ValidatorUtils.getCapabilities(targetUnit, epDefn.getTargetCapabilityType()[i])
						.isEmpty()) {
					return DeployMatcherStatus.MATCH_FOUND;
				}
			}
		}

		// we didn't find any acceptable target capabilities
		return DeployMatcherStatus.MATCH_NOT_FOUND;

//		// if target capability still null and we don't expect one...
//		if (null == targetCapability && null == targetCapabilityType) {
//			return DeployMatcherStatus.MATCH_FOUND;
//		}
//
//		// otherwise if we expected a targetCapability and didn't find one...
//		if (null == targetCapability) {
//			return DeployMatcherStatus.MATCH_NOT_FOUND;
//		}
//
//		// we found a targetCapability
//		return isTargetCapabilityTypeAcceptable(targetCapability) ? DeployMatcherStatus.MATCH_FOUND
//				: DeployMatcherStatus.MATCH_NOT_FOUND;
	}

	public IStatus canCreateLink(Unit sourceUnit, Unit targetUnit) {
		return canCreateLink(sourceUnit, null, targetUnit, null);
	}

	public Set<LinkDescriptor> getPossibleLinks(Unit sourceUnit, Requirement sourceRequirement,
			Unit targetUnit, Capability targetCapability) {
		Set<LinkDescriptor> links = new HashSet<LinkDescriptor>();

		// we have a sourceRequirment and a targetCapability
		if (null != sourceRequirement && null != targetCapability) {
			if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability).isOK()) {
				links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit,
						sourceRequirement, targetUnit, targetCapability));
			}
			return links;
		}

		List<ValidEndpointDefinition> definitions = getEndpointDefinitionsFromSource(sourceUnit,
				sourceRequirement);
		definitions = getEndpointDefinitionsFromTarget(targetUnit, targetCapability, definitions);

		if (null == sourceRequirement) {
			// we might have several options for a valid sourceRequirement type (including none)
			for (ValidEndpointDefinition epDefn : definitions) {
				if (epDefn.isSourceRequirementNeeded()) {
					// source requirement is needed
					// look for all that match a type in the definiton
					for (int i = 0; i < epDefn.getSourceRequirementType().length; i++) {
						List<Requirement> reqs = ValidatorUtils.getRequirements(sourceUnit, epDefn
								.getSourceRequirementType()[i]);
						for (Requirement req : reqs) {
							if (null == targetCapability) {
								// no target capability has been specified; search for one
								if (epDefn.isTargetCapabilityNeeded()) {
									// source requirement and target capability are needed
									for (int j = 0; j < epDefn.getTargetCapabilityType().length; j++) {
										List<Capability> caps = ValidatorUtils.getCapabilities(targetUnit,
												epDefn.getTargetCapabilityType()[j]);
										for (Capability cap : caps) {
											if (canCreateLink(sourceUnit, sourceRequirement, targetUnit,
													targetCapability).isOK()) {
												links.add(linkDescriptorFactory.createLinkDescriptor(
														LinkType.CONSTRAINT, sourceUnit, req, targetUnit, cap));
											}
										}
									}
								} else {
									// source requirement is needed but target capability is not needed
									if (canCreateLink(sourceUnit, sourceRequirement, targetUnit,
											targetCapability).isOK()) {
										links.add(linkDescriptorFactory.createLinkDescriptor(
												LinkType.CONSTRAINT, sourceUnit, req, targetUnit,
												targetCapability));
									}
								}
							} else {
								// target capability was specified; we must use it
								if (canCreateLink(sourceUnit, sourceRequirement, targetUnit,
										targetCapability).isOK()) {
									links.add(linkDescriptorFactory
											.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit, req,
													targetUnit, targetCapability));
								}
							}
						}
					}
				} else {
					// source requirement not needed
					if (null == targetCapability) {
						// no target capability has been specified; search for one
						if (epDefn.isTargetCapabilityNeeded()) {
							// source requirement not needed by target capability is needed
							// look at all capabilities that match any in the definition
							for (int j = 0; j < epDefn.getTargetCapabilityType().length; j++) {
								List<Capability> caps = ValidatorUtils.getCapabilities(targetUnit, epDefn
										.getTargetCapabilityType()[j]);
								for (Capability cap : caps) {
									if (canCreateLink(sourceUnit, sourceRequirement, targetUnit,
											targetCapability).isOK()) {
										links.add(linkDescriptorFactory.createLinkDescriptor(
												LinkType.CONSTRAINT, sourceUnit, sourceRequirement, targetUnit,
												cap));
									}
								}
							}
						} else {
							// source requirement and target capability not needed
							if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability)
									.isOK()) {
								links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
										sourceUnit, targetUnit));
								break;
							}
						}
					} else {
						// target capability was specified; we must use it
						if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability)
								.isOK()) {
							links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
									sourceUnit, sourceRequirement, targetUnit, targetCapability));
						}
					}
				}
			}
		} else {
			// source requirement is not null; we must use it
			for (ValidEndpointDefinition epDefn : definitions) {
				if (null == targetCapability) {
					// no target capability specified; must search for it
					if (epDefn.isTargetCapabilityNeeded()) {
						// source requirement and target capability are needed
						for (int j = 0; j < epDefn.getTargetCapabilityType().length; j++) {
							List<Capability> caps = ValidatorUtils.getCapabilities(targetUnit, epDefn
									.getTargetCapabilityType()[j]);
							for (Capability cap : caps) {
								if (canCreateLink(sourceUnit, sourceRequirement, targetUnit,
										targetCapability).isOK()) {
									links.add(linkDescriptorFactory.createLinkDescriptor(
											LinkType.CONSTRAINT, sourceUnit, sourceRequirement, targetUnit,
											cap));
								}
							}
						}
					} else {
						// source requirement is needed but target capability is not needed
						if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability)
								.isOK()) {
							links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
									sourceUnit, sourceRequirement, targetUnit, targetCapability));
						}
					}
				} else {
					// target capability was specified; we must use it
					if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability)
							.isOK()) {
						links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
								sourceUnit, sourceRequirement, targetUnit, targetCapability));
					}
				}
			}
		}

//		// get target capability if not already defined
//		if (null == targetCapability) {
//			targetCapability = getTargetCapability(targetUnit);
//		}
//
//		// if we don't have the targetCapability we expect we better stop now
//		if (null == targetCapability && null != targetCapabilityType) {
//			return links;
//		}
//
//		// we have a single source requirement
//		if (null != sourceRequirement) {
//			if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability).isOK()) {
//				links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit,
//						sourceRequirement, targetUnit, targetCapability));
//			}
//			return links;
//		}
//
//		// we don't expect a source requirement
//		if (null == sourceRequirementType) {
//			if (canCreateLink(sourceUnit, sourceRequirement, targetUnit, targetCapability).isOK()) {
//				if (null == targetCapabilityType) {
//					links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
//							sourceUnit, targetUnit));
//				} else {
//					links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT,
//							sourceUnit, sourceRequirement, targetUnit, targetCapability));
//				}
//			}
//			return links;
//		}
//
//		// otherwise we expect a source requirment and we don't have it
//		List sourceRequirements = ValidatorUtils.getRequirements(sourceUnit, sourceRequirementType);
//		for (int i = 0; i < sourceRequirements.size(); i++) {
//			Requirement req = (Requirement) sourceRequirements.get(i);
//
//			if (canCreateLink(sourceUnit, req, targetUnit, targetCapability).isOK()) {
//				links.add(linkDescriptorFactory.createLinkDescriptor(LinkType.CONSTRAINT, sourceUnit,
//						req, targetUnit, targetCapability));
//			}
//		}

		return links;
	}

	public Set getPossibleLinks(Unit source, Unit target) {
		return getPossibleLinks(source, null, target, null);
	}

//	protected boolean isSourceUnitTypeAcceptable(Unit sourceUnit) {
//		if (null == sourceUnit) {
//			return false;
//		}
//
//		for (ValidEndpointDefinition epDefn:_validEndpointDefinitions) {
//			EClass[] sourceTypes = epDefn.getSourceUnitTypes();
//			for (int i = 0; i < sourceTypes.length; i++) {
//				if (sourceTypes[i].isSuperTypeOf(sourceUnit.getEObject().eClass())) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
	private List<ValidEndpointDefinition> getEndpointDefinitionsFromSource(Unit sourceUnit,
			Requirement sourceRequirement) {
		if (null == sourceUnit) {
			return Collections.emptyList();
		}

		List<ValidEndpointDefinition> definitions = new ArrayList<ValidEndpointDefinition>();

		EClass sourceUnitType = sourceUnit.getEObject().eClass();

		for (ValidEndpointDefinition epDefn : _validEndpointDefinitions) {
			EClass[] sourceTypes = epDefn.getSourceUnitTypes();
			for (int i = 0; i < sourceTypes.length; i++) {
				if (sourceTypes[i].isSuperTypeOf(sourceUnitType)) {
					EClass[] sourceRequirementTypes = epDefn.getSourceRequirementType();
					if (null == sourceRequirement) {
						definitions.add(epDefn);
						break;
					}
					// sourceRequirement is not null
					EClass sourceRequirementType = sourceRequirement.getDmoEType();
					boolean addedDefinition = false;
					for (int j = 0; j < sourceRequirementTypes.length; j++) {
						if (sourceRequirementTypes[j].isSuperTypeOf(sourceRequirementType)) {
							definitions.add(epDefn);
							addedDefinition = true;
							break;
						}
					}
					if (addedDefinition) {
						break;
					}
				}
			}
		}
		return definitions;
	}

	private List<ValidEndpointDefinition> getEndpointDefinitionsFromTarget(Unit targetUnit,
			Capability targetCapability, List<ValidEndpointDefinition> inputDefinitions) {
		if (null == targetUnit) {
			return Collections.emptyList();
		}

		List<ValidEndpointDefinition> definitions = new ArrayList<ValidEndpointDefinition>();

		EClass targetUnitType = targetUnit.getEObject().eClass();

		for (ValidEndpointDefinition epDefn : inputDefinitions) {
			EClass[] targetTypes = epDefn.getTargetUnitTypes();
			for (int i = 0; i < targetTypes.length; i++) {
				if (targetTypes[i].isSuperTypeOf(targetUnitType)) {
					EClass[] targetCapabilityTypes = epDefn.getTargetCapabilityType();
					if (null == targetCapability) {
						definitions.add(epDefn);
						break;
					}
					// targetCapability is not null
					EClass targetCapabilityType = targetCapability.getEObject().eClass();
					boolean addedDefinition = false;
					for (int j = 0; j < targetCapabilityTypes.length; j++) {
						if (targetCapabilityTypes[j].isSuperTypeOf(targetCapabilityType)) {
							definitions.add(epDefn);
							addedDefinition = true;
							break;
						}
					}
					if (addedDefinition) {
						break;
					}
				}
			}
		}
		return definitions;
	}

//	private boolean isTargetAcceptable (Unit targetUnit, Capability targetCapability, List<ValidEndpointDefinition> definitions) {
//		if (null == targetUnit) {
//			return false;
//		}
//		
//		EClass targetUnitType = targetUnit.getEObject().eClass();
//
//		for (ValidEndpointDefinition epDefn:definitions) {
//			EClass[] targetTypes = epDefn.getTargetUnitTypes();
//			for (int i = 0; i < targetTypes.length; i++) {
//				if (targetTypes[i].isSuperTypeOf(targetUnitType)) {
//					EClass[] targetCapabilityTypes = epDefn.getTargetCapabilityType();
//					if (null == targetCapability) {
//						return true;
//					}
//					// targetCapability is not null
//					EClass targetCapabilityType = targetCapability.getEObject().eClass();
//					for (int j = 0; j < targetCapabilityTypes.length; j++) {
//						if (targetCapabilityTypes[j].isSuperTypeOf(targetCapabilityType)) {
//							return true;
//						}
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	protected boolean isSourceRequirementTypeAcceptable(Requirement sourceRequirement) {
//		if (null == sourceRequirement) {
//			return false;
//		}
//
//		return sourceRequirementType.isSuperTypeOf(sourceRequirement.getDmoEType());
//	}
//
//	protected boolean isTargetUnitTypeAcceptable(Unit targetUnit) {
//		if (null == targetUnit) {
//			return false;
//		}
//
//		for (int i = 0; i < targetTypes.length; i++) {
//			if (targetTypes[i].isSuperTypeOf(targetUnit.getEObject().eClass())) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	protected boolean isTargetCapabilityTypeAcceptable(Capability targetCapability) {
//		if (null == targetCapability) {
//			return false;
//		}
//
//		return targetCapabilityType.isSuperTypeOf(targetCapability.getEObject().eClass());
//	}
//
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

//
//	protected Capability getTargetCapability(Unit targetUnit, ValidEndpointDefinition definition) {
//		if (0 == definition.getTargetCapabilityType().length) {
//			return null;
//		}
//
//		return ValidatorUtils.getFirstCapability(targetUnit, targetCapabilityType);
//	}
//
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

	/**
	 * Utility class to ensure that input to constructors is cleaned up.
	 * 
	 * @param types
	 *           list of {@link EClass} types
	 * @return list without any null entries
	 */
	private EClass[] filterNull(EClass[] types) {
		int filteredCount = 0;
		for (int i = 0; i < types.length; i++) {
			if (null != types[i]) {
				filteredCount++;
			}
		}
		// no filtering to do; the usual case
		if (types.length == filteredCount) {
			return types;
		}

		// otherwise copy non-null entries
		EClass[] filteredTypes = new EClass[filteredCount];
		int j = 0;
		for (int i = 0; i < types.length; i++) {
			if (null != types[i]) {
				filteredTypes[j++] = types[i];
			}
		}

		return filteredTypes;
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

			for (int i = 0; i < sourceRequirementTypes.length; i++) {
				assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(sourceRequirementTypes[i]);
			}

			assert targetTypes.length > 0;
			for (int i = 0; i < targetTypes.length; i++) {
				assert CorePackage.Literals.UNIT.isSuperTypeOf(targetTypes[i]);
			}

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

		/**
		 * Determine if a source requirement is expected by this definition
		 * 
		 * @return true if at least one source requirement type was specified
		 */
		public boolean isSourceRequirementNeeded() {
			return _sourceRequirementTypes.length > 0;
		}

		/**
		 * Determine if a target capability is expected by this definition
		 * 
		 * @return true if at least one target capability type was specified
		 */
		public boolean isTargetCapabilityNeeded() {
			return _targetCapabilityTypes.length > 0;
		}
	}
}
