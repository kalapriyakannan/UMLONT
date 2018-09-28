/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A generic resolution for satisfying a realization requirement
 * 
 * @deprecated
 */
public class GenericStackRealizationSatisfactionResolution extends DeployResolution {

	private final Map<Unit, Unit> srMap;
	private final Unit _sourceUnit;
	private final Unit _targetUnit;
	static LinkType[] linkTypes = new LinkType[] { LinkType.REALIZATION };

	/**
	 * Construct a resolution create a realization link to a selected unit.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param sourceUnit
	 * @param targetUnit
	 * @param stackRealizationMap
	 */
	public GenericStackRealizationSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit sourceUnit, Unit targetUnit,
			Map<Unit, Unit> stackRealizationMap) {
		this(context, generator, sourceUnit, targetUnit, stackRealizationMap, null);
	}

	/**
	 * Construct a resolution create a realization link to a selected unit.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param sourceUnit
	 * @param targetUnit
	 * @param srMap
	 * @param description
	 *           the description of the resoluton.
	 */
	public GenericStackRealizationSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit sourceUnit, Unit targetUnit,
			Map<Unit, Unit> srMap, String description) {
		super(context, generator);
		this.srMap = srMap;
		_sourceUnit = sourceUnit;
		_targetUnit = targetUnit;

		if (description == null) {
			this.description = NLS.bind(
					DeployCoreMessages.Resolution_realize_stack_at_0_by_stack_at_1, sourceUnit
							.getCaptionProvider().titleWithContext(sourceUnit), targetUnit
							.getCaptionProvider().titleWithContext(targetUnit));
		} else {
			this.description = description;
		}
		// Make this resolution more prominent
		setPriority(getPriority() + 1);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		realizeStack();

		//		System.out.println("After stack realization"); //$NON-NLS-1$
		//		RealizationPatternUtil.dumpUnitSet(RealizationPatternUtil.getImmediateConnectedSet ( _sourceUnit ), "starting at (conceptual=" + _sourceUnit.isConceptual() + ")" + _sourceUnit.titleWithContext()); //$NON-NLS-1$ //$NON-NLS-2$

		return Status.OK_STATUS;
	}

	/**
	 * Realize the all the possible realizations given in the member map srMap
	 * 
	 * @return OK_STATUS, always
	 */
	private IStatus realizeStack() {

		for (Iterator<Unit> srMapIter = srMap.keySet().iterator(); srMapIter.hasNext();) {
			Unit source = srMapIter.next();
			Unit target = srMap.get(source);
			LinkFactory.createRealizationLink(source, target);
		}

		return Status.OK_STATUS;
	}

	/**
	 * Build a map of realizations for the stack started at the source unit
	 * 
	 * @param source
	 *           start search at this unit
	 * @param target
	 *           local realization match already to this unit
	 * @param context
	 * @return map of desired unit->unit realization links
	 */
	protected static HashMap<Unit, Unit> stackRealizationMap(Unit source, Unit target,
			IDeployResolutionContext context) {

		Topology top = context.getTopology();
		Set<Unit> precomputedSourceSet = RealizationPatternUtil.getImmediateStackPlusGroupsSet(
				source, top);
		Set<Unit> precomputedTargetSet = RealizationPatternUtil.getImmediateStackPlusGroupsSet(
				target, top);

		HashMap<Unit, Unit> retVal = new HashMap<Unit, Unit>();

		Unit tmpSource = source;
		Unit tmpTarget = target;
		if (tmpSource == null || tmpTarget == null) {
			return new HashMap<Unit, Unit>();
		}

		DeployValidatorService dvs = context.getDeployValidatorService();

		HashMap<Unit, Unit> sourcesToTargetsMap = new HashMap<Unit, Unit>();
		// Match already done for source/target
		sourcesToTargetsMap.put(tmpSource, tmpTarget);

		do {
			// System.out.println("source=" + source.getName() + ", target=" + target.getName()); //$NON-NLS-1$ //$NON-NLS-2$
			boolean alreadyRealized = false;
			if (!sourcesToTargetsMap.containsKey(tmpSource)) {
				if (!RealizationLinkUtil.getFinalRealization(tmpSource).equals(tmpSource)) {
					// Realized with something else. Is it our candidate target or its realization? 
					if (RealizationLinkUtil.getFinalRealization(tmpSource).equals(
							RealizationLinkUtil.getFinalRealization(tmpTarget))) {
						alreadyRealized = true;
					} else {
						return new HashMap<Unit, Unit>();
					}
				} else {
					LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(tmpSource, tmpTarget,
							linkTypes);
					if (linkDescriptorArray.length != 1) {
						return new HashMap<Unit, Unit>();
					}
				}
			}
			if (!alreadyRealized) {
				sourcesToTargetsMap.put(tmpSource, tmpTarget);
			}
			tmpSource = ValidatorUtils.getImmediateHost(tmpSource);
			tmpTarget = ValidatorUtils.getImmediateHost(tmpTarget);

		} while (tmpSource != null && tmpTarget != null);

		//		Match up stack of units starting with each already-mapped unit
		HashSet<Unit> targetsUsed = new HashSet<Unit>(sourcesToTargetsMap.values());
		HashMap<Unit, Unit> secondPassUnitsMap = new HashMap<Unit, Unit>();
		HashSet<Unit> secondPassVisitedUnits = new HashSet<Unit>(retVal.keySet());
		for (Iterator<Unit> alreadyMappedIter = sourcesToTargetsMap.keySet().iterator(); alreadyMappedIter
				.hasNext();) {
			Unit keySource = alreadyMappedIter.next();
			Unit keyTarget = sourcesToTargetsMap.get(keySource);
			HashMap<Unit, Unit> hm = matchUnits(keySource, keyTarget, targetsUsed,
					secondPassVisitedUnits, dvs);
			if (hm == null) {
				return new HashMap<Unit, Unit>();
			}
			secondPassUnitsMap.putAll(hm);
		}
		retVal.putAll(sourcesToTargetsMap);
		retVal.putAll(secondPassUnitsMap);

		//		Match one level of groups starting with each already-mapped unit
		targetsUsed = new HashSet<Unit>();
		HashMap<Unit, Unit> groupsMap = new HashMap<Unit, Unit>();
		HashSet<Unit> visitedGroups = new HashSet<Unit>();
		for (Iterator<Unit> alreadyMappedIter = retVal.keySet().iterator(); alreadyMappedIter
				.hasNext();) {
			Unit keySource = alreadyMappedIter.next();
			Unit keyTarget = retVal.get(keySource);
			HashMap<Unit, Unit> hm = matchGroups(keySource, keyTarget, targetsUsed, visitedGroups,
					precomputedTargetSet, dvs);
			if (hm == null) {
				return new HashMap<Unit, Unit>();
			}
			groupsMap.putAll(hm);
		}
		retVal.putAll(groupsMap);
		// TODO remove asserts
		// Does not contain already-resolved units
		assert precomputedSourceSet.size() >= retVal.keySet().size();
		assert precomputedSourceSet.containsAll(retVal.keySet());
		// Target set may be a superset
		assert precomputedTargetSet.size() >= retVal.keySet().size();
		assert precomputedTargetSet.containsAll(retVal.values());
		return retVal;
	}

	/**
	 * Recurse up the hosting stack, mapping realization matches If realization is not found, fail,
	 * unless the host/hostee are in different topologies, indicating a template boundary
	 * 
	 * @param keySource
	 * @param keyTarget
	 * @param targetsUsed
	 * @param visitedUnits
	 * @param dvs
	 * @return map of realization matches, or null if match failure
	 */
	private static HashMap<Unit, Unit> matchUnits(Unit keySource, Unit keyTarget,
			Set<Unit> targetsUsed, Set<Unit> secondPassVisitedUnits, DeployValidatorService dvs) {

		HashMap<Unit, Unit> retVal = new HashMap<Unit, Unit>();

		for (Iterator<Unit> hostedBySourceIterator = ValidatorUtils.getImmediateHosted(keySource)
				.iterator(); hostedBySourceIterator.hasNext();) {
			Unit sourceHosted = hostedBySourceIterator.next();
			// Prevent re-check of units, and detect and break cycle
			if (secondPassVisitedUnits.contains(sourceHosted)) {
				continue;
			}
			secondPassVisitedUnits.add(sourceHosted);
			// If target is not in working target stack (need better primitive) 
			if (!ValidatorUtils.getImmediateHost(sourceHosted).equals(
					RealizationLinkUtil.getFinalRealization(keySource))) {
				// Already realized - to correct stack?
				if (!targetsUsed.contains(ValidatorUtils.getImmediateHost(sourceHosted))) {
					return null;
				}
				continue;
			}

			List<Unit> targetHostedList = ValidatorUtils.getImmediateHosted(keyTarget);
			Unit matchedUnit = null;
			boolean alreadyRealized = false;
			for (Iterator<Unit> targetHostedIter = targetHostedList.iterator(); targetHostedIter
					.hasNext();) {
				Unit targetHosted = targetHostedIter.next();
				if (ValidatorUtils.getUnit(RealizationLinkUtil.getFinalRealization(sourceHosted))
						.equals(RealizationLinkUtil.getFinalRealization(targetHosted))) {
					alreadyRealized = true;
					continue;
				}
				if (targetsUsed.contains(targetHosted)) {
					continue;
				}
				// TODO deal with ambiguity?
				LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(sourceHosted, targetHosted,
						linkTypes);
				if (linkDescriptorArray.length == 1) {
					matchedUnit = targetHosted;
					retVal.put(sourceHosted, targetHosted);
					break;
				}
			}
			if (!alreadyRealized) {
				if (matchedUnit == null) {
					// If host and hosted are in different topologies, allow
					// match failure
					if (!keySource.getTopology().equals(sourceHosted.getTopology())) {
						continue;
					}
					return null;
				}
				targetsUsed.add(matchedUnit);
				HashMap<Unit, Unit> hm = matchUnits(sourceHosted, matchedUnit, targetsUsed,
						secondPassVisitedUnits, dvs);
				if (hm == null) {
					return null;
				}
				retVal.putAll(hm);
			}
		}
		return retVal;
	}

	/**
	 * Check one level of group membership. If source is a member of a group, target shoulod be a
	 * member of a matching group If realization is not found, fail
	 * 
	 * @param keySource
	 * @param keyTarget
	 * @param targetsUsed
	 * @param visitedGroups
	 * @param dvs
	 * @return map of realization matches, or null if match failure
	 */
	private static HashMap<Unit, Unit> matchGroups(Unit keySource, Unit keyTarget,
			Set<Unit> targetsUsed, Set<Unit> visitedGroups, Set<Unit> targetSet,
			DeployValidatorService dvs) {

		HashMap<Unit, Unit> retVal = new HashMap<Unit, Unit>();

		for (Iterator<Unit> groupsContainingSourceIterator = ValidatorUtils.getImmediateGroups(
				keySource).iterator(); groupsContainingSourceIterator.hasNext();) {
			Unit containingGroup = groupsContainingSourceIterator.next();
			// Prevent re-check of groups
			if (visitedGroups.contains(containingGroup)) {
				continue;
			}
			visitedGroups.add(containingGroup);
			if (containingGroup.isGroup() == true) {
				// If target is not in working target collection
				if (!ValidatorUtils.getImmediateMembers(containingGroup).contains(
						RealizationLinkUtil.getFinalRealization(keySource))) {
					// Final realization of source is not a immediate member of the containing group
					// Check that realization of containing group is not in the precomputed target set
					if (!targetSet.contains(containingGroup)) {
						return null;
					}
					continue;
				}

				List<Unit> targetContainingGroupsList = ValidatorUtils.getImmediateGroups(keyTarget);
				Unit matchedUnit = null;
				boolean alreadyRealized = false;
				for (Iterator<Unit> targetContainingGroupsIter = targetContainingGroupsList.iterator(); targetContainingGroupsIter
						.hasNext();) {
					Unit targetContainingGroup = targetContainingGroupsIter.next();
					if (ValidatorUtils.getUnit(RealizationLinkUtil.getFinalRealization(containingGroup))
							.equals(RealizationLinkUtil.getFinalRealization(targetContainingGroup))) {
						alreadyRealized = true;
						continue;
					}
					if (targetsUsed.contains(targetContainingGroup)) {
						continue;
					}
					// TODO deal with ambiguity?
					LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(containingGroup,
							targetContainingGroup, linkTypes);
					if (linkDescriptorArray.length == 1) {
						matchedUnit = targetContainingGroup;
						retVal.put(containingGroup, targetContainingGroup);
						break;
					}
				}
				if (!alreadyRealized) {
					if (matchedUnit == null) {
						return null;
					}
					targetsUsed.add(matchedUnit);
				}
			}
		}
		return retVal;
	}

}
