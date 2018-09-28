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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A generic resolution for satisfying a realization requirement
 */
public class GenericConnectedSetRealizationSatisfactionResolution extends DeployResolution {

	private final Map<Unit, Unit> _csrMap;
	private final Unit _sourceUnit;
	final LinkType[] realizationLinkTypes = new LinkType[] { LinkType.REALIZATION };
	final LinkType[] dependencyLinkTypes = new LinkType[] { LinkType.DEPENDENCY };

	/**
	 * Construct a resolution create a realization link to a selected unit.
	 * 
	 * @param context
	 *           the context of the resolution.
	 * @param generator
	 *           the generator creating this status.
	 * @param sourceUnit
	 * @param targetUnit
	 * @param connectedSetRealizationMap
	 *           unit for the target of the link
	 */
	public GenericConnectedSetRealizationSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit sourceUnit, Unit targetUnit,
			Map<Unit, Unit> connectedSetRealizationMap) {
		this(context, generator, sourceUnit, targetUnit, connectedSetRealizationMap, null);
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
	 * @param csrMap
	 * @param description
	 *           the description of the resolution.
	 */
	public GenericConnectedSetRealizationSatisfactionResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit sourceUnit, Unit targetUnit,
			Map<Unit, Unit> csrMap, String description) {
		super(context, generator);
		_csrMap = csrMap;
		_sourceUnit = sourceUnit;
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
		realizeConnectedSet();

		//		System.out.println("After connected set realization"); //$NON-NLS-1$
		//		RealizationPatternUtil.dumpUnitSet(RealizationPatternUtil.getImmediateConceptualConnectedSet ( _sourceUnit ), "starting at (conceptual=" + _sourceUnit.isConceptual() + ")" + _sourceUnit.titleWithContext()); //$NON-NLS-1$ //$NON-NLS-2$

		return Status.OK_STATUS;
	}

	/**
	 * Realize the all the possible realizations given in the member map csrMap
	 * 
	 * @return OK_STATUS, always
	 */
	private IStatus realizeConnectedSet() {

		Set<Unit> sourceSet = filterOutAlreadyRealized(RealizationPatternCacheService.INSTANCE
				.getImmediateConceptualConnectedSet(_sourceUnit));
		Topology editTop = _sourceUnit.getEditTopology();

		for (Iterator<Unit> csrMapIter = _csrMap.keySet().iterator(); csrMapIter.hasNext();) {
			Unit source = csrMapIter.next();
			sourceSet.remove(source);
			Unit target = _csrMap.get(source);
			if (target.getTopology() == null) {
				// Perhaps target unit was discovered.
				UnitDescriptor targetUD = RealizationPatternCacheService.INSTANCE
						.rpGetUnitDescriptor(target);
				if (targetUD == null) {
					continue;
				}
				target = targetUD.getUnitValueAndAddToTopology(source.getEditTopology());
				if (target == null) {
					continue;
				}
			}
			LinkFactory.createRealizationLink(source, target);
		}
		for (Iterator<Unit> missingUnitsIter = sourceSet.iterator(); missingUnitsIter.hasNext();) {
			Unit missingUnit = missingUnitsIter.next();
			Unit missingUnitFR = (Unit) RealizationLinkUtil.getFinalRealization(missingUnit);
			if (!missingUnitFR.equals(missingUnit)) {
				continue;
			}
//			System.out
//					.println("Missing unit " + missingUnit.getCaptionProvider().titleWithContext(missingUnit)); //$NON-NLS-1$
			assert missingUnit.isConfigurationUnit();
			assert missingUnit.isConceptual();
			if (missingUnit.isConfigurationUnit() && missingUnit.isConceptual()) {
				List<Unit> l = new ArrayList<Unit>();
				l.add(missingUnit);
				Collection<Unit> dup = ResolutionUtils.partialIntelligentDeepCopy(l, editTop, true);
				if (dup.size() > 0) {
					Unit dupedMissingUnitRealized = (Unit) dup.toArray()[0];
					editTop.getUnits().add(dupedMissingUnitRealized);
					_csrMap.put(missingUnit, dupedMissingUnitRealized);
					if (missingUnit.isConceptual()) {
						// Is this correct? Mixed conceptual/concrete.
						LinkFactory.createRealizationLink(missingUnit, dupedMissingUnitRealized);
					}
				}
			}
		}
		boolean conceptualTargets = targetsAreConceptual();
		for (Iterator<Unit> missingUnitsIter = sourceSet.iterator(); missingUnitsIter.hasNext();) {
			Unit missingUnit = missingUnitsIter.next();
			Unit dupedMissingUnitRealized = _csrMap.get(missingUnit);
			setupLinksOnCopiedUnit(missingUnit, dupedMissingUnitRealized);
			dupedMissingUnitRealized.setConceptual(conceptualTargets);
		}

		return Status.OK_STATUS;
	}

	// If targets are mainly conceptual, return true, else return false;
	private boolean targetsAreConceptual() {
		int conceptualCount = 0;
		Collection<Unit> valuesColl = _csrMap.values();
		for (Iterator<Unit> valuesCollIter = valuesColl.iterator(); valuesCollIter.hasNext();) {
			Unit target = valuesCollIter.next();
			if (target.isConceptual()) {
				++conceptualCount;
			}
		}
		return conceptualCount > _csrMap.values().size() / 2;
	}

	private void setupLinksOnCopiedUnit(Unit missingUnit, Unit dupedMissingUnitRealized) {
		if (missingUnit == null || dupedMissingUnitRealized == null) {
			return;
		}
		Topology editTop = missingUnit.getEditTopology();

		// If missing unit has a host, make copy have isomorphic host.
		Unit host = ValidatorUtils.getImmediateHost(missingUnit);
		if (host != null) {
			Unit realizedHost = _csrMap.get(host);
			LinkFactory.createHostingLink(realizedHost, dupedMissingUnitRealized);
		}

		// If missing unit hosts units, make copy have isomorphic hosted units
		List<Unit> hosted = ValidatorUtils.getImmediateHosted(missingUnit);
		for (Iterator<Unit> hostedIter = hosted.iterator(); hostedIter.hasNext();) {
			Unit hostedU = hostedIter.next();
			Unit realizedHostedU = _csrMap.get(hostedU);
			if (realizedHostedU != null) {
				if (!RealizationPatternCacheService.INSTANCE.getMostRealizedHosted(
						dupedMissingUnitRealized, editTop).contains(realizedHostedU)) {
					LinkFactory.createHostingLink(dupedMissingUnitRealized, realizedHostedU);
				}
			}
		}

		// If missing unit is in groups, make copy member of isomorphic groups
		List<Unit> containingGroups = ValidatorUtils.getImmediateGroups(missingUnit);
		for (Iterator<Unit> containingGroupsIter = containingGroups.iterator(); containingGroupsIter
				.hasNext();) {
			Unit containingGroup = containingGroupsIter.next();
			Unit realizedContainingGroup = _csrMap.get(containingGroup);
			if (realizedContainingGroup != null) {
				if (!RealizationPatternCacheService.INSTANCE.getMostRealizedGroups(
						dupedMissingUnitRealized, editTop).contains(realizedContainingGroup)) {
					LinkFactory.createMemberLink(realizedContainingGroup, dupedMissingUnitRealized);
				}
			}
		}

		// If missing unit has members, make sure it has isomorphic members
		List<Unit> members = ValidatorUtils.getImmediateMembers(missingUnit);
		for (Iterator<Unit> membersIter = members.iterator(); membersIter.hasNext();) {
			Unit member = membersIter.next();
			Unit realizedMember = _csrMap.get(member);
			if (realizedMember != null) {
				if (!RealizationPatternCacheService.INSTANCE.getMostRealizedMembers(
						dupedMissingUnitRealized, editTop).contains(realizedMember)) {
					LinkFactory.createMemberLink(dupedMissingUnitRealized, realizedMember);
				}
			}
		}
		// How do we handle dependency links? 
		// The realization mapping algorithm might not correctly bridge the gap
		// TODO this is not quite correct - it won't handle ambiguity.
		for (Iterator<Requirement> reqIter = missingUnit.getRequirements().iterator(); reqIter
				.hasNext();) {
			Requirement r = reqIter.next();
			Capability targetCap = ValidatorUtils.getImmediateDependencyLinkTarget(r);
			if (targetCap != null) {
				Unit targetUnit = ValidatorUtils.getUnit(targetCap);
				if (targetUnit != null) {
					Unit realizedTargetUnit = _csrMap.get(targetUnit);
					// Find corresponding target capability
					if (realizedTargetUnit != null) {
						LinkDescriptor[] dlld = context.getDeployValidatorService().getPossibleLinks(
								dupedMissingUnitRealized, realizedTargetUnit, dependencyLinkTypes);
						for (int i = 0; i < dlld.length; ++i) {
							if (r.eClass().isSuperTypeOf(((Requirement) dlld[i].getSource()).eClass())) {
								dlld[i].create();
								break;
							}
						}
					}
				}
			}
		}

		for (Iterator<Capability> capIter = missingUnit.getCapabilities().iterator(); capIter
				.hasNext();) {
			Capability c = capIter.next();
			List<Requirement> sourceReqs = ValidatorUtils.getDependencyLinkSources(c);
			for (Iterator<Requirement> sourceReqIter = sourceReqs.iterator(); sourceReqIter.hasNext();) {
				Requirement sourceReq = sourceReqIter.next();
				Unit sourceUnit = ValidatorUtils.getUnit(sourceReq);
				if (sourceUnit != null) {
					Unit realizedSourceUnit = _csrMap.get(sourceUnit);
					// Find corresponding source requirement
					if (realizedSourceUnit != null) {
						LinkDescriptor[] dlld = context.getDeployValidatorService().getPossibleLinks(
								realizedSourceUnit, dupedMissingUnitRealized, dependencyLinkTypes);
						for (int i = 0; i < dlld.length; ++i) {
							if (c.eClass().isSuperTypeOf(((Requirement) dlld[i].getTarget()).eClass())) {
								dlld[i].create();
								break;
							}
						}
					}
				}
			}
		}

	}

	private static Set<Unit> filterOutAlreadyRealized(Set<Unit> s) {
		HashSet<Unit> result = new HashSet<Unit>();
		for (Iterator<Unit> setIter = s.iterator(); setIter.hasNext();) {
			Unit u = setIter.next();
			if (!alreadyRealized(u)) {
				result.add(u);
			}
		}

		return result;
	}

	private static boolean alreadyRealized(Unit u) {
		Unit uFR = (Unit) RealizationLinkUtil.getFinalRealization(u);
		return !uFR.equals(u);
	}

}
