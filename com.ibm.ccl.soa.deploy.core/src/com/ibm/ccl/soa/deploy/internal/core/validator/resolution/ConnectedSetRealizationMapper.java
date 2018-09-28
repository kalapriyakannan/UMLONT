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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.CollocationConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.constraints.DeferredHostingConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * 
 * Utility methods for identifying realization patterns
 */
public class ConnectedSetRealizationMapper {

	private static final String HOST_RELATIONSHIP = "HOST_RELATIONSHIP"; //$NON-NLS-1$
	private static final String HOSTED_RELATIONSHIP = "HOSTED_RELATIONSHIP"; //$NON-NLS-1$	
	private static final String DEP_SOURCE_RELATIONSHIP = "DEP_SOURCE_RELATIONSHIP"; //$NON-NLS-1$		
	private static final String DEP_TARGET_RELATIONSHIP = "DEP_TARGET_RELATIONSHIP"; //$NON-NLS-1$			
	private static final String MEMBER_RELATIONSHIP = "MEMBER_RELATIONSHIP"; //$NON-NLS-1$				
	private static final String GROUP_RELATIONSHIP = "GROUP_RELATIONSHIP"; //$NON-NLS-1$	
	private static final String DEFERRED_HOST_RELATIONSHIP = "DEFERRED_HOST_RELATIONSHIP"; //$NON-NLS-1$
	private static final String DEFERRED_HOSTED_RELATIONSHIP = "DEFERRED_HOSTED_RELATIONSHIP"; //$NON-NLS-1$
	private static final String CONSTRAINT_LINK_TARGET_RELATIONSHIP = "CONSTRAINT_LINK_TARGET_RELATIONSHIP"; //$NON-NLS-1$
	private static final String CONSTRAINT_LINK_SOURCE_RELATIONSHIP = "CONSTRAINT_LINK_SOURCE_RELATIONSHIP"; //$NON-NLS-1$
	private static boolean allCapSemantics = true;

	/**
	 * Compute a realization mapping of a connected set of conceptual units against a target
	 * topology, starting at parameter unit. Can return multiple maps, if a set of conceptual units
	 * can be realization-mapped to more than one target set.
	 * 
	 * @param startU
	 * @param top
	 * @param rpcs
	 * @param arbk
	 * @param arc
	 * @param dvs
	 * @param monitor
	 * 
	 * @return List of maps of Units to realize to their realizations
	 */
	public static List<Map<Unit, Unit>> realizationMapsConnectedSet(Unit startU, Topology top,
			RealizationPatternCacheService rpcs, AutoRealizationBookKeeping arbk,
			AutoRealizationControl arc, DeployValidatorService dvs, IProgressMonitor monitor) {
		List<Map<Unit, Unit>> maps = new LinkedList<Map<Unit, Unit>>();
		if (top == null) {
			return Collections.emptyList();
		}
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

//		System.out
//				.println("Starting set realization mapping for " + startU.getCaptionProvider().titleWithContext(startU)); //$NON-NLS-1$
//		long prevTime = System.currentTimeMillis();

		// Special case handling of dangling target of deferred hosting constraint, common in patterns.
		startU = navigateToSourceOfDeferredHostingConstraintIfAny(startU, top);

		// Heuristic - bottom of hosting stack is generally less connected and may be more
		// constrained due to resource selection.
		startU = getImmediateUnrealizedBottomOfHostingStack(startU);
//		System.out
//				.println("Effective start unit " + startU.getCaptionProvider().titleWithContext(startU)); //$NON-NLS-1$

		// Make copy of controls
//		boolean findAllSolutionsInitial = arc.isFindAllSolutions();
		arc = new AutoRealizationControl(arc);

		if (true) {
			if (arc.isFollowStructuralConstraintLinks()) {
				List<DeployLink> l = Collections.emptyList();
				arbk.setIntraPatternStructuralConstraintLinks(l);
				rpcs.getArbk().getIntraPatternStructuralConstraintLinks().clear();
				Set<Unit> icsFollowingSCLs = RealizationPatternUtil.getImmediateConceptualConnectedSet(
						startU, true, rpcs);
				List<DeployLink> intraPatternStructuralConstraintLinks = intraSetLinksWithStructuralConstraints(
						icsFollowingSCLs, top);
				if (intraPatternStructuralConstraintLinks.size() > 0) {
					Set<Unit> icsNotFollowingSCLs = RealizationPatternUtil
							.getImmediateConceptualConnectedSet(startU, false, rpcs);
					arbk.setIntraPatternStructuralConstraintLinks(intraPatternStructuralConstraintLinks);
					rpcs.getArbk().setIntraPatternStructuralConstraintLinks(
							intraPatternStructuralConstraintLinks);
					if (icsNotFollowingSCLs.containsAll(icsFollowingSCLs)) {
						arbk
								.setIntraPatternStructuralConstraintLinksNotFollowed(intraPatternStructuralConstraintLinks);
						rpcs.getArbk().setIntraPatternStructuralConstraintLinksNotFollowed(
								intraPatternStructuralConstraintLinks);
					}
				}
			}
		}

		Set<Unit> ics = rpcs.getImmediateConceptualConnectedSet(startU);

		// Check to see if hosted set contains links with collocation constraints or deferred hosting constraints that might not be evaluated in-line in the search.
		// If found, then must switch to find-all-solutions mode.
		if (!arc.isFindAllSolutions()) {
			Set<Unit> hostedSet = getHostedSet(ics);
			List<DeployLink> dlListWC = linksWithConstraintsToFromSet(hostedSet, top, false);
			for (DeployLink dl : dlListWC) {
				for (Constraint c : (List<Constraint>) dl.getConstraints()) {
					if (c instanceof CollocationConstraint) {
						Unit sourceUnit = ValidatorUtils.getUnit(dl.resolve(dl.getSourceURI()));
						sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
						Unit targetUnit = ValidatorUtils.getUnit(dl.resolve(dl.getTargetURI()));
						targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
						if (ics.contains(sourceUnit) && ics.contains(targetUnit)
								&& dl instanceof ConstraintLink) {
							continue;
						}
						// Uh oh. Case found where post-processing could invalidate find-first-solution result.
						arc.setFindAllSolutions(true);
						break;
					}
					if (c instanceof DeferredHostingConstraint) {
						Unit sourceUnit = ValidatorUtils.getUnit(dl.resolve(dl.getSourceURI()));
						sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
						if (ics.contains(sourceUnit) && dl instanceof ConstraintLink) {
							continue;
						}
						// Uh oh. Case found where post-processing could invalidate find-first-solution result.
						arc.setFindAllSolutions(true);
						break;
					}
				}
				if (arc.isFindAllSolutions()) {
					break;
				}
			}
		}

		arc.setAllowUnmatchedConfigUnits(false);
		while (true) {
			for (Iterator<Unit> topUnitIter = top.findAllUnits(); topUnitIter.hasNext();) {
				Unit candidateUnit = topUnitIter.next();
				if (cancelled(monitor)) {
					return Collections.emptyList();
				}
				if (RealizationPatternUtil.realizable(startU, candidateUnit, arc
						.isStrictAttributeValueMatchMode(), arc.isFullyValidateConstraintsInMatchMode(),
						rpcs, dvs)) {
					assert !startU.equals(candidateUnit);
					assert !RealizationLinkUtil.getFinalRealization(startU).equals(candidateUnit);
					//					System.out.println("Realization unit local match found: " + candidateUnit.titleWithContext()); //$NON-NLS-1$
					Map<Unit, Unit> rmcs = realizationMapConnectedSet(startU, candidateUnit, top, rpcs,
							arbk, arc, dvs, monitor);
					if (rmcs.size() > 0) {
						if (arc.isFindAllSolutions()) {
							if (rmcs != null) {
//								ConnectedSetRealizationMapper.dumpUnitRealizationMapList(arbk.resultMaps,
//										"All result maps"); //$NON-NLS-1$
								maps.addAll(arbk.resultMaps);
								arbk.resultMaps.clear();
							}
						} else {
							maps.add(rmcs);
						}
					}
				}
			}
			if (maps.size() > 0) {
				break;
			}
			if (arc.isAllowUnmatchedConfigUnits()) {
				break;
			} else {
				arc.setAllowUnmatchedConfigUnits(true);
			}
		}
//		long time = System.currentTimeMillis();
//		System.out.println("Elapsed milliseconds for set realization mapping = " + (time - prevTime)); //$NON-NLS-1$
		// Do final cleanup to show only maximal solututions
		maps = new LinkedList<Map<Unit, Unit>>(arbk.searchGC(maps));
		return maps;
	}

	/**
	 * Special case for commonly seen conceptual unit dangling from a constraint link from concrete
	 * unit. If unit is a single disconnected unit that is the target of a single deferred hosting
	 * link, navigate up the link. Otherwise, return parameter.
	 * 
	 * @param startU
	 * @param top
	 * @return
	 */
	private static Unit navigateToSourceOfDeferredHostingConstraintIfAny(Unit startU, Topology top) {
		IRelationshipChecker rels = top.getRelationships();
		Collection<ConstraintLink> ccl = rels.getConstraintLinkSourcesLinks(startU);
		if (ccl.size() == 1) {
			ConstraintLink cl = ccl.iterator().next();
			for (Constraint c : (List<Constraint>) cl.getConstraints()) {
				if (c instanceof DeferredHostingConstraint) {
					Unit sourceUnit = ValidatorUtils.getUnit(cl.resolve(cl.getSourceURI()));
					sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
					if (rels.getConstraintLinkTargets(startU).size() > 0
							|| rels.getContainerLinks(startU).size() > 0
							|| rels.getHostedLinks(startU).size() > 0
							|| rels.getHostLinks(startU).size() > 0
							|| rels.getMembersLinks(startU).size() > 0) {
						return startU;
					}
					for (Capability cap : (List<Capability>) startU.getCapabilities()) {
						if (rels.getDependentRequirementsLinks(cap).size() > 0) {
							return startU;
						}
					}
					for (Requirement req : (List<Requirement>) startU.getRequirements()) {
						if (rels.getDependencyTargetsLinks(req).size() > 0) {
							return startU;
						}
					}
					return sourceUnit;
				}
			}
		}
		return startU;

	}

	/**
	 * @param startU
	 * @param top
	 * @param dvs
	 * @param monitor
	 * @return List of realization maps (from unit to unit)
	 * 
	 * @see ConnectedSetRealizationMapper#realizationMapsConnectedSet(Unit, Topology,
	 *      AutoRealizationBookKeeping arbk, AutoRealizationControl arc, DeployValidatorService,
	 *      IProgressMonitor)
	 */
//	public static List<Map<Unit, Unit>> realizationMapsConnectedSet(Unit startU, Topology top,
//			DeployValidatorService dvs, IProgressMonitor monitor) {
//		// Use defaults
//		AutoRealizationBookKeeping arbk = new AutoRealizationBookKeeping();
//		AutoRealizationControl arc = new AutoRealizationControl();
//
//		return realizationMapsConnectedSet(startU, top, arbk, arc, dvs, monitor);
//	}
	private static boolean cancelled(IProgressMonitor monitor) {
		if (monitor == null) {
			return false;
		}
		return monitor.isCanceled();
	}

	private static Unit getImmediateUnrealizedBottomOfHostingStack(Unit startU) {
		Unit u;
		Unit tmpU = startU;
		do {
			u = tmpU;
			tmpU = ValidatorUtils.getImmediateHost(u);
		} while (tmpU != null && !RealizationPatternUtil.alreadyRealized(tmpU));
		return u;
	}

	private static Unit getBottomOfHostingStack(Unit startU) {
		Unit u;
		Unit tmpU = startU;
		do {
			u = tmpU;
			tmpU = ValidatorUtils.getHost(u);
		} while (tmpU != null);
		return u;
	}

	private static boolean candidateUnitIsTargetInMaps(Unit candidateUnit,
			Collection<Map<Unit, Unit>> maps) {
		for (Map<Unit, Unit> map : maps) {
			if (map.containsValue(candidateUnit)) {
				return true;
			}
		}
		return false;
	}

	private static Map<Unit, Unit> realizationMapConnectedSet(Unit cu, Unit tu, Topology top,
			RealizationPatternCacheService rpcs, AutoRealizationBookKeeping arbk,
			AutoRealizationControl arc, DeployValidatorService dvs, IProgressMonitor monitor) {
		Map<Unit, Unit> tempMap = new HashMap<Unit, Unit>();
		if (cancelled(monitor)) {
			return tempMap;
		}
		Set<Unit> ics = rpcs.getImmediateConceptualConnectedSet(cu);
		if (!arc.isFindAllSolutions()) {
			Set<Unit> hostedSet = getHostedSet(ics);
			hostedSet.removeAll(ics);
			List<DeployLink> dlListWC = linksWithConstraintsToFromSet(hostedSet, top, false);
			for (DeployLink dl : dlListWC) {
				for (Constraint c : (List<Constraint>) dl.getConstraints()) {
					if (c instanceof CollocationConstraint) {
						arc.setFindAllSolutions(true);
						break;
					}
				}
			}
		}

//		System.out
//				.println("Attempting mapping starting at " + cu.getCaptionProvider().titleWithContext(cu) + "," + tu.getCaptionProvider().titleWithContext(tu) + //$NON-NLS-1$ //$NON-NLS-2$
//						" (" + cu.hashCode() + "," + tu.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (ics.contains(tu)) {
			return Collections.emptyMap();
		}
		arbk.resultMaps.clear();
		Map<Unit, Unit> m = mapImmediateConnectedUnits(cu, tu, tempMap, rpcs, arbk, arc, dvs,
				monitor, 0);
		arbk.postSearchBookKeeping();
		if (!validCollocationLinks(m, top, dvs)) {
			m = new HashMap<Unit, Unit>();
		}
		m = filterOutAlreadyRealized(m);
		// If all-solutions mode, process all the maps. Record/return one valid map if any is available.
		if (arc.isFindAllSolutions()) {
			List<Map<Unit, Unit>> removals = new ArrayList<Map<Unit, Unit>>();
			for (Map<Unit, Unit> mFromResults : arbk.resultMaps) {
//				ConnectedSetRealizationMapper.dumpUnitRealizationMap(mFromResults, "map from results"); //$NON-NLS-1$
				Map<Unit, Unit> unitAdditionsMap = new HashMap<Unit, Unit>();
				if (!validCollocationLinks(mFromResults, top, dvs)) {
					removals.add(mFromResults);
					continue;
				}
				if (!validUnevaluatedDeferredHostingLinks(mFromResults, unitAdditionsMap, top, arc,
						rpcs, dvs)) {
					removals.add(mFromResults);
					continue;
				}
				if (!validStructuralConstraintLinks(mFromResults, arbk
						.getIntraPatternStructuralConstraintLinks())) {
					removals.add(mFromResults);
					continue;
				}
				// Add maps to implied deferred hosting targets
				mFromResults.putAll(unitAdditionsMap);
			}
			arbk.resultMaps.removeAll(removals);
			if (m == null && arbk.resultMaps.size() > 0) {
				m = arbk.resultMaps.iterator().next();
			}
		}

//		dumpUnitRealizationMap(m, "Resulting map"); //$NON-NLS-1$

		return m;
	}

	private static boolean validUnevaluatedDeferredHostingLinks(Map<Unit, Unit> unitMap,
			Map<Unit, Unit> additionsMap, Topology top, AutoRealizationControl arc,
			RealizationPatternCacheService rpcs, DeployValidatorService dvs) {
		Set<Unit> hostedSet = getHostedSet(unitMap.keySet());
		List<DeployLink> dlListWC = linksWithConstraintsToFromSet(hostedSet, top, false);
		for (DeployLink dl : dlListWC) {
			for (Constraint c : (List<Constraint>) dl.getConstraints()) {
				if (c instanceof DeferredHostingConstraint) {
					Unit sourceUnit = ValidatorUtils.getUnit(dl.resolve(dl.getSourceURI()));
					sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
					Unit targetUnit = ValidatorUtils.getUnit(dl.resolve(dl.getTargetURI()));
					targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
					// If this constraint wasn't evaluated during search
//					if (!(unitMap.keySet().contains(sourceUnit) && dl instanceof ConstraintLink)) {
					Unit huis = findFirstMappedHostUnitInStack(sourceUnit, unitMap, targetUnit.eClass());
					if (huis != null) {
						if (RealizationPatternUtil.realizable(targetUnit, huis, arc
								.isStrictAttributeValueMatchMode(), arc
								.isFullyValidateConstraintsInMatchMode(), rpcs, dvs)) {
							Unit mappedSourceUnit = unitMap.get(sourceUnit);
							if (mappedSourceUnit != null) {
								IStatus s = DeferredHostingConstraintValidator.INSTANCE.validate(c,
										mappedSourceUnit, huis, new NullProgressMonitor());
								if (statusIsConstraintViolation(s, false)) {
									return false;
								}
							}
							additionsMap.put(targetUnit, huis);
						} else {
							return false;
						}
					}
//					} else {
//
//					}
				}
			}
		}

		return true;
	}

	private static boolean validStructuralConstraintLinks(Map<Unit, Unit> unitMap,
			List<DeployLink> structuralConstraintLinks) {
		for (Unit u : unitMap.keySet()) {
			if (!validStructuralConstraintLinksForUnit(u, unitMap, structuralConstraintLinks, true,
					new NullProgressMonitor())) {
				return false;
			}
		}
		return true;
	}

	private static boolean statusIsConstraintViolation(IStatus s, boolean ignoreIfUnevaluatable) {
		if (s instanceof IDeployStatus
				&& ((IDeployStatus) s).getProblemType() != null
				&& ((IDeployStatus) s).getProblemType().equals(
						ICoreProblemType.CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE) && ignoreIfUnevaluatable) {
			return false;
		}
		if (!s.isOK()) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	private static Unit findFirstMappedHostUnitInStack(Unit unit, Map<Unit, Unit> unitMap,
			EClass unitType) {
		Unit hostInStack = null;
		while (unit != null) {
			if (unitMap.get(unit) != null) {
				break;
			}
			unit = ValidatorUtils.getHost(unit);
		}
		if (unit != null) {
			unit = unitMap.get(unit);
			hostInStack = ValidatorUtils.findHostInStack(unit, unitType);
		}
		return hostInStack;
	}

	/**
	 * @param uuMap
	 *           Map<Unit,Unit> for proposed set of realizations
	 * @param top
	 *           Edit topology
	 * @param dvs
	 *           a DeployValidatorService instance
	 * @return true if collocation constraints applicable to units in keyset of map are all valid.
	 */
	private static boolean validCollocationLinks(Map<Unit, Unit> uuMap, Topology top,
			DeployValidatorService dvs) {
		// Find all constraint links associated with units in connected set or hosting stack of connected set.
//		dumpUnitRealizationMap(uuMap, "to Check for Valid Collocation Links"); //$NON-NLS-1$
		Set<Unit> hostedSet = getHostedSet(uuMap.keySet());

		List<DeployLink> dlListWC = linksWithConstraintsToFromSet(hostedSet, top, false);

		for (DeployLink dl : dlListWC) {
			Unit sourceUnit = ValidatorUtils.getUnit(dl.resolve(dl.getSourceURI()));
			sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
			Unit targetUnit = ValidatorUtils.getUnit(dl.resolve(dl.getTargetURI()));
			targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
			if (sourceUnit == null || targetUnit == null) {
				continue;
			}
			// If link concerns at least one unit in keyset (conceptual units to be realized), 
			// or one of their possibly-indirect hostees or units in their realization chain
			if (hostedSet.contains(sourceUnit) || hostedSet.contains(targetUnit)) {
				for (Constraint c : (List<Constraint>) dl.getConstraints()) {
					if (c instanceof CollocationConstraint) {
						// Qualifying collocation constraint. Now determine whether or not realization would break constraint
						if (realizationWouldViolateCollocationConstraint(dl, (CollocationConstraint) c,
								uuMap, sourceUnit, targetUnit)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private static boolean validStructuralConstraintLinksForUnit(Unit cu, Map<Unit, Unit> m,
			List<DeployLink> structuralConstraintLinks, boolean assumeCompleteMap,
			IProgressMonitor monitor) {
		for (DeployLink dl : structuralConstraintLinks) {
			for (Constraint c : (List<Constraint>) dl.getConstraints()) {
				Unit sourceUnit = ValidatorUtils.getUnit(dl.resolve(dl.getSourceURI()));
				sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
				Unit targetUnit = ValidatorUtils.getUnit(dl.resolve(dl.getTargetURI()));
				targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
				if (sourceUnit == null || targetUnit == null) {
					continue;
				}
				if (!(sourceUnit.equals(cu) || targetUnit.equals(cu))) {
					continue;
				}
				Unit mappedSourceUnit = m.get(sourceUnit);
				Unit mappedTargetUnit = m.get(targetUnit);
				if (mappedSourceUnit == null || mappedTargetUnit == null) {
					continue;
				}
				if (c instanceof DeferredHostingConstraint) {
					IStatus s = DeferredHostingConstraintValidator.INSTANCE.validate(c,
							mappedSourceUnit, mappedTargetUnit, monitor);
					if (statusIsConstraintViolation(s, !assumeCompleteMap)) {
						return false;
					}
				} else if (c instanceof CollocationConstraint) {
					if (mappedSourceUnit.equals(mappedTargetUnit)) {
						if (((CollocationConstraint) c).getType().equals(
								CollocationConstraintTypes.ANTICOLLOCATION_LITERAL)) {
							return false;
						}
						if (((CollocationConstraint) c).getType().equals(
								CollocationConstraintTypes.COLLOCATION_LITERAL)) {
							continue;
						}
					} else {
						IStatus s = CollocationConstraintValidator.INSTANCE.validate(c, mappedSourceUnit,
								mappedTargetUnit, monitor);
						if (statusIsConstraintViolation(s, true)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private static List<DeployLink> intraSetLinksWithStructuralConstraints(Set<Unit> s, Topology top) {
		List<DeployLink> intraSetLinksWithConstraints = linksWithConstraintsToFromSet(s, top, true);
		List<DeployLink> retVal = new LinkedList<DeployLink>();
		for (DeployLink dl : intraSetLinksWithConstraints) {
			for (Constraint c : (List<Constraint>) dl.getConstraints()) {
				if (c instanceof DeferredHostingConstraint || c instanceof CollocationConstraint) {
					retVal.add(dl);
					continue;
				}
			}
		}
		return retVal;
	}

	private static List<DeployLink> linksWithConstraintsToFromSet(Set<Unit> s, Topology top,
			boolean intraSetLinksOnly) {
		List<DeployLink> retVal = new ArrayList<DeployLink>();
		for (Iterator<DeployLink> dlIter = top.findAllDeployLinks(); dlIter.hasNext();) {
			// Process collocation constraints on ANY type of deploylink
			DeployLink dl = dlIter.next();
			List<Constraint> constraints = dl.getConstraints();
			if (constraints.size() > 0) {
				Unit sourceUnit = ValidatorUtils.getUnit(dl.resolve(dl.getSourceURI()));
				sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
				Unit targetUnit = ValidatorUtils.getUnit(dl.resolve(dl.getTargetURI()));
				targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
				if (sourceUnit == null || targetUnit == null) {
					continue;
				}
				// If link concerns at least one unit in keyset (conceptual
				// units to be realized),
				// or one of their possibly-indirect hostees or units in their
				// realization chain
				if (intraSetLinksOnly) {
					if (s.contains(sourceUnit) && s.contains(targetUnit)) {
						retVal.add(dl);
					}
				} else {
					if (s.contains(sourceUnit) || s.contains(targetUnit)) {
						retVal.add(dl);
					}
				}
			}
		}
		return retVal;
	}

	private static Set<Unit> getHostedSet(Set<Unit> s) {
		if (s == null) {
			return Collections.EMPTY_SET;
		}
		Set<Unit> hostedSet = new HashSet<Unit>();
		for (Unit cuUnit : s) {
			// If unit is in set its hostees (recursively) are in set
			if (hostedSet.contains(cuUnit)) {
				continue;
			}
			hostedSet.addAll(getAllStackSetUpIncludingParameter(cuUnit));
		}
		return hostedSet;
	}

	/**
	 * Compute and return set of units hosted by unit or by other units in its realization chain,
	 * recursively. Note: Returns parameter unit and members of its realization chain!!!
	 * 
	 * @param u
	 *           Unit to find all hosted units from
	 * @return Set of all units hosted by unit or by other units in its realization chain
	 */
	private static Set<Unit> getAllStackSetUpIncludingParameter(Unit u) {
		Set<Unit> visited = new HashSet<Unit>();
		return getAllHostedRecursiveIncludingParameter(u, visited);
	}

	// Visited check is for efficiency and cycle breaking, not correctness
	// Note: Returns parameter unit and members of its realization chain!!!
	private static Set<Unit> getAllHostedRecursiveIncludingParameter(Unit u, Set<Unit> alreadyVisited) {
		Set<Unit> s = new HashSet<Unit>();

		// For each unit in realization chain for parameter unit
		for (DeployModelObject dmo : RealizationLinkUtil.getAllRealizationLinkedObjects(u)) {
			if (dmo instanceof Unit) {
				Unit relLinkedUnit = (Unit) dmo;
				if (alreadyVisited.contains(relLinkedUnit)) {
					continue;
				} else {
					s.add(relLinkedUnit);
					alreadyVisited.add(relLinkedUnit);
				}
				// For each unit hosted by unit in realization chain for parameter unit
				for (Unit hosted : ValidatorUtils.getHosted(relLinkedUnit)) {
					s.addAll(getAllHostedRecursiveIncludingParameter(hosted, alreadyVisited));
				}
			}
		}
		return s;
	}

	/**
	 * Passed collocation constraint, the Unit endpoints of the link, and the candidate multi-unit
	 * realization map. Computes whether the constraint link would be evaluate to violated if the
	 * realizations proposed in the map were performed.
	 * 
	 * @param cc
	 *           collocation constraint on deploy link
	 * @param uuMap
	 *           proposed set of unit to unit realizations as a Map<Unit,Unit>
	 * @param sourceUnit
	 *           source unit of the constraint link
	 * @param targetUnit
	 *           target unit of the constraint link
	 * @return False if the proposed realizations would violate the constraint, true if not or
	 *         unevaluatable.
	 */
	private static boolean realizationWouldViolateCollocationConstraint(DeployLink dl,
			CollocationConstraint cc, Map<Unit, Unit> uuMap, Unit sourceUnit, Unit targetUnit) {
		assert sourceUnit != null && targetUnit != null;
		Unit sUnit = sourceUnit;
		Unit tUnit = targetUnit;

		// Find the first elements down the hosting stacks of constraint link source/target 
		// that are in the keyset of the proposed mapping.
		// This is to cover collocation links on real units
		// Preferentially use immediate host
		// TODO determine whether a full-width search down unfolded hosting tree is 
		// required for filtering of results.
		while (sUnit != null && !uuMap.keySet().contains(sUnit)) {
			Unit tmpUnit = ValidatorUtils.getImmediateHost(sUnit);
			if (tmpUnit == null) {
				sUnit = ValidatorUtils.getHost(sUnit);
			} else {
				sUnit = tmpUnit;
			}

		}
		while (tUnit != null && !uuMap.keySet().contains(tUnit)) {
			Unit tmpUnit = ValidatorUtils.getImmediateHost(tUnit);
			if (tmpUnit == null) {
				tUnit = ValidatorUtils.getHost(tUnit);
			} else {
				tUnit = tmpUnit;
			}
		}

		// Get candidate realization targets
		sUnit = uuMap.get(sUnit);
		tUnit = uuMap.get(tUnit);

		// Link is not important to source units in proposed set of realizations
		if (sUnit == null && tUnit == null) {
			return false;
		}
		// Perhaps one unit is not in connected set map - revert to initial units 
		if (sUnit == null) {
			sUnit = sourceUnit;
		}
		if (tUnit == null) {
			tUnit = targetUnit;
		}
		// Make sure code is starting with final realizations
		sUnit = (Unit) RealizationLinkUtil.getFinalRealization(sUnit);
		tUnit = (Unit) RealizationLinkUtil.getFinalRealization(tUnit);

		// Realization targets identified. Now check whether the collocation constraint is violated
		return collocationConstraintViolated(cc, sUnit, tUnit);
	}

	private static boolean collocationConstraintViolated(CollocationConstraint cc, Unit sUnit,
			Unit tUnit) {
		IStatus s = CollocationConstraintValidator.INSTANCE.validate(cc, sUnit, tUnit,
				new NullProgressMonitor());
		return statusIsConstraintViolation(s, true);
	}

	private static boolean collocationConstraintViolated(ConstraintLink cl, Unit sUnit, Unit tUnit) {

		for (CollocationConstraint cc : RealizationPatternUtil.getCollocationConstraints(cl)) {
			if (collocationConstraintViolated(cc, sUnit, tUnit)) {
				return true;
			}
		}
		return false;
	}

	private static boolean deferredHostingConstraintViolated(DeferredHostingConstraint cc,
			Unit sUnit, Unit tUnit, RealizationPatternCacheService rpcs) {
		IStatus s = DeferredHostingConstraintValidator.INSTANCE.validate(cc, sUnit, tUnit,
				new NullProgressMonitor());
		return statusIsConstraintViolation(s, false);
	}

	private static boolean deferredHostingConstraintViolated(ConstraintLink cl, Unit sUnit,
			Unit tUnit, RealizationPatternCacheService rpcs) {

		for (DeferredHostingConstraint cc : RealizationPatternUtil.getDeferredHostingConstraints(cl)) {
			if (deferredHostingConstraintViolated(cc, sUnit, tUnit, rpcs)) {
				return true;
			}
		}
		return false;
	}

//	private static boolean missingConceptualNonConfigUnits(Unit cu, Map<Unit, Unit> csrMap,
//			AutoRealizationControl arc) {
//		Set<Unit> sourceSet = new HashSet<Unit>(rpcs
//				.getImmediateConceptualConnectedSet(cu, arc.followConstraintLinks));
//
//		for (Unit source : csrMap.keySet()) {
//			sourceSet.remove(source);
//		}
//		for (Unit u : sourceSet) {
//			if (!u.isConfigurationUnit() && u.isConceptual()) {
//				return true;
//			}
//		}
//		return false;
//	}

	/**
	 * @param m
	 * @return copy of input map, with units filtered out if they are already realized to the target
	 *         specified in the map
	 */
	public static Map<Unit, Unit> filterOutAlreadyRealized(Map<Unit, Unit> m) {
		Map<Unit, Unit> result = new HashMap<Unit, Unit>();
		for (Unit u : m.keySet()) {
			Unit uFR = (Unit) RealizationLinkUtil.getFinalRealization(u);
			Unit mappedU = m.get(u);
			if (!uFR.equals(mappedU)) {
				result.put(u, mappedU);
			} else {
//				System.out
//						.println("Filtering out already-realized unit from results: " + u.getCaptionProvider().titleWithContext(u)); //$NON-NLS-1$
			}
		}

		return result;
	}

	/*
	 * return
	 */
	private static Map<Unit, Unit> mapImmediateConnectedUnits(Unit cu, Unit tu,
			Map<Unit, Unit> mapped, RealizationPatternCacheService rpcs,
			AutoRealizationBookKeeping arbk, AutoRealizationControl arc, DeployValidatorService dvs,
			IProgressMonitor monitor, int depth) {
		assert !cu.equals(tu);
		if (cancelled(monitor)) {
			return Collections.emptyMap();
		}
		if (mapped.containsKey(cu)) {
			return Collections.emptyMap();
		}
		if (!arc.isAllowManyToOneRealizations() && mapped.containsValue(tu)) {
			return Collections.emptyMap();
		}

//		System.out
//				.println("mapImmediateConnectedUnits[" + depth + "]: " + cu.getCaptionProvider().titleWithContext(cu) + "-->" + tu.getCaptionProvider().titleWithContext(tu) + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//						"[hcs " + cu.hashCode() + "," + tu.hashCode() + "]"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
//		dumpUnitRealizationMap(mapped, "mapped so far"); //$NON-NLS-1$
		if (arbk.getIntraPatternStructuralConstraintLinks().size() > 0) {
			Map<Unit, Unit> whatIfMap = new LinkedHashMap<Unit, Unit>(mapped);
			whatIfMap.put(cu, tu);
			for (Unit tcu : whatIfMap.keySet()) {
				if (!validStructuralConstraintLinksForUnit(tcu, whatIfMap, arbk
						.getIntraPatternStructuralConstraintLinks(), false, monitor)) {
//							System.out.println("structural constraint violated");
					return Collections.emptyMap();
				}
			}
		}

		// This shouldn't be necessary but direct use of mapped.keySet() fails
		Set<Unit> mappedKeySet = new HashSet<Unit>(mapped.keySet());

		// Build working map to recurse on
		Map<Unit, Set<Object>> cuRelationshipTypeMap = new HashMap<Unit, Set<Object>>();
		Map<Unit, Set<Object>> tuRelationshipTypeMap = new HashMap<Unit, Set<Object>>();

		Set<Unit> cuConnectedUnitsSet = getDirectlyConnectedUnits(cu, cuRelationshipTypeMap, cu
				.getEditTopology(), true, arc, rpcs, arbk);
		// Filter out concrete units
		cuConnectedUnitsSet = removeNonConceptualUnits(cuConnectedUnitsSet);

		//		RealizationPatternUtil.dumpUnitSet(cuConnectedUnitsSet, "cuConnectedUnitsSet"); //$NON-NLS-1$

		Set<Unit> tuConnectedUnitsSet = getDirectlyConnectedUnits(tu, tuRelationshipTypeMap, cu
				.getEditTopology(), false, arc, rpcs, arbk);

		if (alreadyMappedLinkNotPresentOnTarget(cu, tu, cuConnectedUnitsSet, cuRelationshipTypeMap,
				tuConnectedUnitsSet, tuRelationshipTypeMap, mapped)) {
			return Collections.emptyMap();
		}

		Map<Unit, Unit> m = new HashMap<Unit, Unit>();
		m.put(cu, tu);

		if (arc.isFollowStructuralConstraintLinks()) {
			Set<Unit> cuConstraintLinkConnectedUnitsSet = getPossibleStructuralConstraintLinkSourcesAndTargets(
					cu, tu, tuRelationshipTypeMap, arc, rpcs, arbk, cu.getEditTopology());
			tuConnectedUnitsSet.addAll(cuConstraintLinkConnectedUnitsSet);
		}

		addDeferredHosts(cuConnectedUnitsSet, cuRelationshipTypeMap, tu, tuConnectedUnitsSet,
				tuRelationshipTypeMap, rpcs);

		cuConnectedUnitsSet.removeAll(mappedKeySet);
		//		RealizationPatternUtil.dumpUnitSet(tuConnectedUnitsSet, "tuConnectedUnitsSet"); //$NON-NLS-1$

		//		List<List> cuConnUnitsPermutations = buildPermutations(cuConnectedUnitsSet, cuRelationshipTypeMap);

		List<Iterator<List<Unit>>> cuConnUnitsPermutationIterators = getPermutationIterators(
				cuConnectedUnitsSet, cuRelationshipTypeMap);
		//		dumpPermutationLists(cuConnUnitsPermutationLists);

		// Incomming list of results. Subtracted in loop from current results for delta.
		Set<Map<Unit, Unit>> baselineResults = new LinkedHashSet<Map<Unit, Unit>>();
		if (arc.isFindAllSolutions()) {
			baselineResults.addAll(arbk.resultMaps);
		}
		int permGroupNum = -1;

		if (cuConnUnitsPermutationIterators.size() > 0) {
			for (Iterator<List<Unit>> cuConnUnitsPermIter : cuConnUnitsPermutationIterators) {
				++permGroupNum;
				// Compute delta from incomming list of results. 
				Set<Map<Unit, Unit>> resultsUntilThisPermutationGroup = new LinkedHashSet<Map<Unit, Unit>>();
				if (arc.isFindAllSolutions()) {
					if (permGroupNum > 0) {
						resultsUntilThisPermutationGroup.addAll(arbk.resultMaps);
						resultsUntilThisPermutationGroup.removeAll(baselineResults);
					} else {
						// use empty hashset
					}
				}
				boolean allUnitsInPermMapped = false;
//				int permNum = 0;
				Map<Unit, Unit> firstResultM = new HashMap<Unit, Unit>(m);
				for (; cuConnUnitsPermIter.hasNext();) {
					Collection<Map<Unit, Unit>> initArbkResultMapsForPerm = new HashSet<Map<Unit, Unit>>(
							arbk.resultMaps);
					Map<Unit, Unit> tmpM = new HashMap<Unit, Unit>(m); // This map accumulates results for permutation
					Set<Map<Unit, Unit>> tmpMSet = new LinkedHashSet<Map<Unit, Unit>>(); // This list accumulates results for permutation in find-all-solutions mode
					tmpMSet.add(new HashMap<Unit, Unit>(m)); // Prime the result accumulator list
					boolean permMappingFailure = false; // Set to true if there are no solutions for the permutation
					List<Unit> cuConnectedUnitsPermutation = cuConnUnitsPermIter.next();
//					if (cuConnectedUnitsPermutation.size() > 1) {
//						System.out
//								.println("Trying permutation number " + permNum++ + " size=" + cuConnectedUnitsPermutation.size()); //$NON-NLS-1$ //$NON-NLS-2$j
//						RealizationPatternUtil.dumpUnitCollection(cuConnectedUnitsPermutation,
//								"permutation"); //$NON-NLS-1$
//					}
					for (Unit cuConnUnit : cuConnectedUnitsPermutation) {
//						System.out
//								.println("Attempting to map conceptual unit : " + cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit)); //$NON-NLS-1$
						boolean cuConnUnitRealizable = false; // True if at least one realization for the conceptual unit in the permutation
						boolean permUnitFoundMapping = false; // True if a recursive mapping from the unit in the perm was found
						boolean permUnitAlreadyMapped = false; // True if the unit has already been mapped to a target unit
						List<Unit> tuConnectedUnitsList = moveAlreadyMapTargetsToBackOfList(
								tuConnectedUnitsSet, tmpM.values());

						// List of results for the single conceptual unit in the permutation
						List<Map<Unit, Unit>> rmList = new ArrayList<Map<Unit, Unit>>();
						for (Unit tuConnUnit : tuConnectedUnitsList) {
							if (!cuConnUnit.eClass().isSuperTypeOf(tuConnUnit.eClass())) {
//								System.out
//										.println("Superclass check mismatch : " + cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit) + "-->" + tuConnUnit.getCaptionProvider().titleWithContext(tuConnUnit)); //$NON-NLS-1$ //$NON-NLS-2$
								continue;
							}
							if (!tuRelationshipTypeMap.get(tuConnUnit).containsAll(
									cuRelationshipTypeMap.get(cuConnUnit))) {
//								System.out
//										.println("Relationship type mismatch : " + cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit) + "-->" + tuConnUnit.getCaptionProvider().titleWithContext(tuConnUnit)); //$NON-NLS-1$ //$NON-NLS-2$
//								dumpRelationshipSet(
//										cuRelationshipTypeMap.get(cuConnUnit),
//										"cuRelationshipType set for " + cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit)); //$NON-NLS-1$					
//								dumpRelationshipSet(
//										tuRelationshipTypeMap.get(tuConnUnit),
//										"tuRelationshipType set for " + tuConnUnit.getCaptionProvider().titleWithContext(tuConnUnit)); //$NON-NLS-1$
								continue;
							}
//							System.out
//									.println("mapImmediateConnectedUnits: testing " + cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit) + "-->" + tuConnUnit.getCaptionProvider().titleWithContext(tuConnUnit) + " (" + cuConnUnit.hashCode() + "," + tuConnUnit.hashCode() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
							Map<Unit, Unit> unionMap = new HashMap<Unit, Unit>(tmpM);
							unionMap.putAll(mapped);
							if (unionMap.get(cuConnUnit) != null
									&& unionMap.get(cuConnUnit).equals(tuConnUnit)) {
//								System.out
//										.println("value already mapped : " + cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit) + "-->" + tuConnUnit.getCaptionProvider().titleWithContext(tuConnUnit)); //$NON-NLS-1$ //$NON-NLS-2$
								permUnitAlreadyMapped = true;
								continue;
							}
							// Treat existing realization link to target as mapping. 
							// Maps are filtered of already-realized units in a later pass.
							if (RealizationPatternUtil.realizable(cuConnUnit, tuConnUnit, arc
									.isStrictAttributeValueMatchMode(), arc
									.isFullyValidateConstraintsInMatchMode(), rpcs, dvs)
									|| !cuConnUnit.equals(tuConnUnit)
									&& RealizationLinkUtil.getFinalRealization(cuConnUnit)
											.equals(tuConnUnit)) {
//								System.out.println("realizable"); //$NON-NLS-1$
								cuConnUnitRealizable = true;
								Set<Map<Unit, Unit>> tmpArbkResultMaps = new LinkedHashSet<Map<Unit, Unit>>(
										arbk.resultMaps);
								Map<Unit, Unit> rm = mapImmediateConnectedUnits(cuConnUnit, tuConnUnit,
										unionMap, rpcs, arbk, arc, dvs, monitor, depth + 1);
								if (cancelled(monitor)) {
									return Collections.emptyMap();
								}
								// For each case where subtree solution is found, create new tmpM, add rm, and add it to tmpMList
								// do not break if in find all solutions mode
								// When done
								if (rm.size() > 0) {
									if (arc.isFindAllSolutions()) {
										Set<Map<Unit, Unit>> deltaArbkResultMaps = new LinkedHashSet<Map<Unit, Unit>>(
												arbk.resultMaps);
										deltaArbkResultMaps.removeAll(tmpArbkResultMaps);
										Set<Map<Unit, Unit>> goodMaps = arbk.searchGC(deltaArbkResultMaps);
										deltaArbkResultMaps.removeAll(goodMaps);
										arbk.resultMaps.removeAll(deltaArbkResultMaps);
										// System.out.println("fmsz = " + goodMaps.size() + ", darmsz=" + darmzd);
										// InstrumentedConnectedSetRealizationMapper.dumpUnitRealizationMapList(deltaArbkResultMaps, "deltaArbkResultMaps");
										for (Map<Unit, Unit> rmTmp : goodMaps) {
											// for (Map<Unit, Unit> rmTmp : deltaArbkResultMaps) {
											rmTmp.put(cuConnUnit, tuConnUnit);
											rmList.add(rmTmp);
										}
									} else {
										rmList.add(rm);
									}
									permUnitFoundMapping = true;
									if (arc.isFindAllSolutions()) {
										continue;
									} else {
										break;
									}
								}
							} else {
//								System.out.println("Not realizable"); //$NON-NLS-1$
							}
						} // End possible target units for a conceptual unit in permutation
						// Have found all possible targets for conceptual unit in permutation. 
						// Update earlier results in permutation
						// Bug? should results for earlier size > 1 permutation sets be updated as well?
						if (arc.isFindAllSolutions()) {
							// For each current result in permutation, update
							Set<Map<Unit, Unit>> additions = new LinkedHashSet<Map<Unit, Unit>>();
							Set<Map<Unit, Unit>> removals = new HashSet<Map<Unit, Unit>>();
							for (Map<Unit, Unit> tm : tmpMSet) { // For each current result for the permutation
								for (Map<Unit, Unit> rm : rmList) { // For each result for this conceptual unit in permutation
									Map<Unit, Unit> tm2 = new HashMap<Unit, Unit>(tm);
									tm2.putAll(rm); // Create new updated map which includes result
									additions.add(tm2);
									removals.add(tm);
								}
							}
							tmpMSet.removeAll(removals);
							tmpMSet.addAll(additions);
//							System.out.println("new tmpMList.size()=" + tmpMList.size() + ", removals=" //$NON-NLS-1$ //$NON-NLS-2$
//									+ removals.size() + ", additions=" + additions.size() + ", depth=" //$NON-NLS-1$ //$NON-NLS-2$
//									+ depth);
						} else {
							// Add each result to results
							for (Map<Unit, Unit> rm : rmList) {
								Map<Unit, Unit> tmpM2 = new HashMap<Unit, Unit>(tmpM);
								tmpM2.putAll(rm);
								tmpMSet.add(tmpM2);
							}
						}
						// Handle case where there are multiple paths to a unit
						if (!permUnitAlreadyMapped && mapped.containsKey(cuConnUnit)) {
							permUnitAlreadyMapped = true;
						}
						if (!permUnitAlreadyMapped && tmpM.containsKey(cuConnUnit)) {
							permUnitAlreadyMapped = true;
						}
						if (rmList.size() > 0) { // For single-solution mode
							tmpM.putAll(rmList.get(0));
						}
						if (!permUnitFoundMapping && !permUnitAlreadyMapped) {
							// If configuration unit and not present, record mapping failure
							// also check setting that should control this
							if (!arc.isAllowUnmatchedConfigUnits()
									|| !(cuConnUnit.isConfigurationUnit() && !cuConnUnitRealizable)) {
//								System.out.println("mapImmediateConnectedUnits [" + depth //$NON-NLS-1$
//										+ "]: No mapping found for " //$NON-NLS-1$
//										+ cuConnUnit.getCaptionProvider().titleWithContext(cuConnUnit));
								permMappingFailure = true;
								break; // Failed to map a unit. This permutation is no good.
							}
						}
					} // Finished trying to map all conceptual units in permutation
					// WCA fail always
					if (!permMappingFailure) {
//						System.out.println("Mapping success: "); //$NON-NLS-1$
//						dumpUnitRealizationMap(tmpM, "Addition map ----"); //$NON-NLS-1$
						if (!allUnitsInPermMapped) {
							// record first success
							firstResultM.putAll(tmpM);
							allUnitsInPermMapped = true;
						}
						if (!arc.isFindAllSolutions()) {
							break;
						} else {
							tmpMSet = arbk.searchGC(tmpMSet);
							for (Map<Unit, Unit> tm : tmpMSet) {
//								System.out.println("adding map[" + depth + "] size=" + tm.size()); //$NON-NLS-1$//$NON-NLS-2$
//								ConnectedSetRealizationMapper.dumpUnitRealizationMap(tm, "Map"); //$NON-NLS-1$
								arbk.addResultMap(m, tm);
							}
							Set<Map<Unit, Unit>> deltaMaps = new LinkedHashSet<Map<Unit, Unit>>(
									arbk.resultMaps);
							deltaMaps.removeAll(initArbkResultMapsForPerm);
//							deltaMaps = arbk.searchGC(deltaMaps);
							for (Map<Unit, Unit> deltaMap : deltaMaps) {
								arbk.addResultMap(m, deltaMap);
								// Update previous results at this level with results from this permutation
								for (Map<Unit, Unit> prevResult : resultsUntilThisPermutationGroup) {
									arbk.addResultMap(prevResult, deltaMap);
								}
							}
						}
					}
				}
				if (!allUnitsInPermMapped) {
					if (arc.isFindAllSolutions()) {
						// Toss all results
						arbk.resultMaps = baselineResults;
					}
					return Collections.emptyMap();
				} else {
					m = firstResultM;
				}
			}
		}

		//		dumpUnitRealizationMap(m, "Addition map ----"); //$NON-NLS-1$
		mapped.putAll(m);
		if (arc.isFindAllSolutions()) {
			arbk.addResultMap(m, new HashMap<Unit, Unit>());
		}
		return m;
	}

	private static final String[] linkTypesNotNeededInTargetArray = { DEFERRED_HOST_RELATIONSHIP,
			DEFERRED_HOSTED_RELATIONSHIP, CONSTRAINT_LINK_TARGET_RELATIONSHIP,
			CONSTRAINT_LINK_SOURCE_RELATIONSHIP };

	private static final List<String> linkTypesNotNeededInTargetList = Arrays
			.asList(linkTypesNotNeededInTargetArray);

	private static boolean alreadyMappedLinkNotPresentOnTarget(Unit cu, Unit tu,
			Set<Unit> cuConnectedUnitsSet, Map<Unit, Set<Object>> cuRelationshipTypeMap,
			Set<Unit> tuConnectedUnitsSet, Map<Unit, Set<Object>> tuRelationshipTypeMap,
			Map<Unit, Unit> mapped) {
		for (Unit cuConnUnit : cuConnectedUnitsSet) {
			if (mapped.get(cuConnUnit) != null) {
				Unit mappedCuConnUnit = mapped.get(cuConnUnit);
				Set<Object> cuRels = new HashSet<Object>(cuRelationshipTypeMap.get(cuConnUnit));
				if (!tuConnectedUnitsSet.contains(mappedCuConnUnit)) {
					cuRels.removeAll(linkTypesNotNeededInTargetList);
					if (cuRels.size() > 0) {
						return true;
					}
					continue;
				}
				if (!cuRelationshipTypeMap.get(cuConnUnit).containsAll(
						tuRelationshipTypeMap.get(mappedCuConnUnit))) {
					// return true unless only constraint links missing
					cuRels.removeAll(linkTypesNotNeededInTargetList);
					if (cuRels.size() > 0) {
						return true;
					}
					continue;
				}
			}
		}

		return false;
	}

	private static List<Unit> moveAlreadyMapTargetsToBackOfList(Set<Unit> unitsSet,
			Collection<Unit> mappedTargets) {
		List<Unit> retVal = new ArrayList<Unit>();
		for (Unit u : unitsSet) {
			if (mappedTargets.contains(u)) {
				retVal.add(u);
			} else {
				retVal.add(0, u);
			}
		}

		return retVal;
	}

	/**
	 * If target stack has a host unit in stack that is subtype of deferred host type, add the unit
	 * to the target set of units being evaluated, with a deferred host relationship type.
	 * 
	 * @param cuConnectedUnitsSet
	 * @param cuRelationshipTypeMap
	 * @param tu
	 * @param tuConnectedUnitsSet
	 * @param tuRelationshipTypeMap
	 */
	private static void addDeferredHosts(Set<Unit> cuConnectedUnitsSet,
			Map<Unit, Set<Object>> cuRelationshipTypeMap, Unit tu, Set<Unit> tuConnectedUnitsSet,
			Map<Unit, Set<Object>> tuRelationshipTypeMap, RealizationPatternCacheService rpcs) {
		for (Unit connectedCu : cuConnectedUnitsSet) {
			if (cuRelationshipTypeMap.get(connectedCu) != null
					&& cuRelationshipTypeMap.get(connectedCu).contains(
							ConnectedSetRealizationMapper.DEFERRED_HOST_RELATIONSHIP)) {
				Unit targetDeferredHost = getMostRealizedHostInStack(tu, connectedCu.eClass(), rpcs);
				if (targetDeferredHost != null) {
					tuConnectedUnitsSet.add(targetDeferredHost);
					addRelationshipType(tuRelationshipTypeMap, targetDeferredHost,
							ConnectedSetRealizationMapper.DEFERRED_HOST_RELATIONSHIP);
				}
			}
		}
	}

	private static Unit getMostRealizedHostInStack(Unit unit, EClass type,
			RealizationPatternCacheService rpcs) {
		Unit hostingUnit = unit;
		while (hostingUnit != null && !type.isSuperTypeOf(hostingUnit.eClass())) {
			hostingUnit = rpcs.getMostRealizedHost(hostingUnit, unit.getEditTopology());
		}
		return hostingUnit;
	}

	/*
	 * 
	 */
	private static Set<Unit> getDirectlyConnectedUnits(Unit u,
			Map<Unit, Set<Object>> relationshipTypeMap, Topology top, boolean immediate,
			AutoRealizationControl arc, RealizationPatternCacheService rpcs,
			AutoRealizationBookKeeping arbk) {
		Set<Unit> s = new HashSet<Unit>();
		if (top == null) {
			return s;
		}
		// Deferred hosting & general constraint links outbound
		for (ConstraintLink cl : top.getRelationships().getConstraintLinkTargetsLinks(u)) {
			if (arbk.getIntraPatternStructuralConstraintLinksNotFollowed().contains(cl)) {
				continue;
			}
			Unit sourceUnit = ValidatorUtils.getUnit(cl.getSource());
			Unit targetUnit = ValidatorUtils.getUnit(cl.getTarget());
			if (sourceUnit != null && targetUnit != null && sourceUnit.equals(u)) {
				for (Constraint c : (List<Constraint>) cl.getConstraints()) {
					if (c instanceof DeferredHostingConstraint) {
						// For constraint links only, do additional navigation. 					
						targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
						s.add(targetUnit);
						addRelationshipType(relationshipTypeMap, targetUnit,
								ConnectedSetRealizationMapper.DEFERRED_HOST_RELATIONSHIP);
					} else {
						if (arc.isFollowStructuralConstraintLinks()
								&& RealizationPatternUtil.isStructuralConstraint(c)) {
							// For constraint links only, do additional navigation. 					
							targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
							s.add(targetUnit);
							addRelationshipType(relationshipTypeMap, targetUnit,
									ConnectedSetRealizationMapper.CONSTRAINT_LINK_TARGET_RELATIONSHIP);
						}
					}
				}
			}
		}

		// general constraint links inbound
		for (ConstraintLink cl : top.getRelationships().getConstraintLinkSourcesLinks(u)) {
			if (arbk.getIntraPatternStructuralConstraintLinksNotFollowed().contains(cl)) {
				continue;
			}
			Unit sourceUnit = ValidatorUtils.getUnit(cl.getSource());
			Unit targetUnit = ValidatorUtils.getUnit(cl.getTarget());
			if (sourceUnit != null && targetUnit != null && targetUnit.equals(u)) {
				for (Constraint c : (List<Constraint>) cl.getConstraints()) {
					if (c instanceof DeferredHostingConstraint) {
						sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
						s.add(sourceUnit);
						addRelationshipType(relationshipTypeMap, sourceUnit,
								ConnectedSetRealizationMapper.DEFERRED_HOSTED_RELATIONSHIP);
					} else {
						if (arc.isFollowStructuralConstraintLinks()
								&& RealizationPatternUtil.isStructuralConstraint(c)) {
							// For constraint links only, do additional navigation. 					
							sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
							s.add(sourceUnit);
							addRelationshipType(relationshipTypeMap, sourceUnit,
									ConnectedSetRealizationMapper.CONSTRAINT_LINK_SOURCE_RELATIONSHIP);
						}
					}
				}
			}
		}

		Unit host = rpcs.getHost(u, top, immediate);
		if (host != null) {
			addRelationshipType(relationshipTypeMap, host,
					ConnectedSetRealizationMapper.HOST_RELATIONSHIP);
			s.add(host);
		}
		for (Unit hosted : rpcs.getHosted(u, top, immediate)) {
			addRelationshipType(relationshipTypeMap, hosted,
					ConnectedSetRealizationMapper.HOSTED_RELATIONSHIP);
			s.add(hosted);
		}
		for (Unit containingGroup : rpcs.getGroups(u, top, immediate)) {
			addRelationshipType(relationshipTypeMap, containingGroup,
					ConnectedSetRealizationMapper.GROUP_RELATIONSHIP);
			s.add(containingGroup);
		}
		for (Unit member : rpcs.getMembers(u, top, immediate)) {
			addRelationshipType(relationshipTypeMap, member,
					ConnectedSetRealizationMapper.MEMBER_RELATIONSHIP);
			s.add(member);
		}
		for (Requirement r : (List<Requirement>) u.getRequirements()) {
			Capability targetCap = rpcs.getDependencyLinkTarget(r, top, immediate);
			if (targetCap != null) {
				Unit targetUnit = ValidatorUtils.getUnit(targetCap);
				if (targetUnit != null) {
					addRelationshipType(relationshipTypeMap, targetUnit,
							ConnectedSetRealizationMapper.DEP_TARGET_RELATIONSHIP);
					s.add(targetUnit);
				}
			}
		}
		for (Capability c : (List<Capability>) u.getCapabilities()) {
			List<Requirement> sources = rpcs.getDependencyLinkSources(c, top, immediate);
			for (Iterator<Requirement> sourcesIter = sources.iterator(); sourcesIter.hasNext();) {
				Requirement sourceReq = sourcesIter.next();
				if (sourceReq != null) {
					Unit sourceUnit = ValidatorUtils.getUnit(sourceReq);
					if (sourceUnit != null) {
						addRelationshipType(relationshipTypeMap, sourceUnit,
								ConnectedSetRealizationMapper.DEP_SOURCE_RELATIONSHIP);
						s.add(sourceUnit);
					}
				}
			}
		}
		return s;
	}

	/**
	 * For collocation/anticollocation/deferred hosting constraint links, find all possible link
	 * sources/targets. These constraint links types are evaluated as part of the connected set
	 * realization mapping.
	 */
	private static Set<Unit> getPossibleStructuralConstraintLinkSourcesAndTargets(Unit rsu,
			Unit rtu, Map<Unit, Set<Object>> relationshipTypeMap, AutoRealizationControl arc,
			RealizationPatternCacheService rpcs, AutoRealizationBookKeeping arbk, Topology top) {
		Set<Unit> s = new HashSet<Unit>();
		if (top == null) {
			return s;
		}
		for (ConstraintLink cl : top.getRelationships().getConstraintLinkTargetsLinks(rsu)) {
			if (!RealizationPatternUtil.isStructuralConstraintLink(cl)) {
				continue;
			}
			if (arbk.getIntraPatternStructuralConstraintLinksNotFollowed().contains(cl)) {
				continue;
			}
			Unit linkSourceUnit = ValidatorUtils.getUnit(cl.getSource());
			linkSourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(linkSourceUnit);
			Unit linkTargetUnit = ValidatorUtils.getUnit(cl.getTarget());
			linkTargetUnit = (Unit) RealizationLinkUtil.getFinalRealization(linkTargetUnit);
			if (linkSourceUnit != null && linkTargetUnit != null && linkSourceUnit.equals(rsu)) {
				if (rsu.isConceptual() && !RealizationPatternUtil.alreadyRealized(linkTargetUnit)) {
					for (Iterator<Unit> iterUnit = top.findAllUnits(); iterUnit.hasNext();) {
						Unit candidateRTU = iterUnit.next();
						if (RealizationPatternUtil.realizable(linkTargetUnit, candidateRTU, arc
								.isStrictAttributeValueMatchMode(), arc
								.isFullyValidateConstraintsInMatchMode(), rpcs, DeployValidatorService
								.getDefaultValidatorService())) {
							if (RealizationPatternUtil.getCollocationConstraints(cl).size() > 0
									&& !collocationConstraintViolated(cl, rtu, candidateRTU)) {
								s.add(candidateRTU);
								addRelationshipType(relationshipTypeMap, candidateRTU,
										ConnectedSetRealizationMapper.CONSTRAINT_LINK_TARGET_RELATIONSHIP);
							}
							if (RealizationPatternUtil.getDeferredHostingConstraints(cl).size() > 0
									&& !deferredHostingConstraintViolated(cl, rtu, candidateRTU, rpcs)) {
								Unit realHostInStack = ValidatorUtils.findHostInStack(rtu, linkTargetUnit
										.eClass());
								if (candidateRTU.equals(realHostInStack)) {
									s.add(candidateRTU);
									addRelationshipType(relationshipTypeMap, candidateRTU,
											ConnectedSetRealizationMapper.DEFERRED_HOST_RELATIONSHIP);
								}
							}
						}
					}
				}
			}
		}

		// general constraint links inbound
		for (ConstraintLink cl : top.getRelationships().getConstraintLinkSourcesLinks(rsu)) {
			if (!RealizationPatternUtil.isStructuralConstraintLink(cl)) {
				continue;
			}
			if (arbk.getIntraPatternStructuralConstraintLinksNotFollowed().contains(cl)) {
				continue;
			}
			Unit linkSourceUnit = ValidatorUtils.getUnit(cl.getSource());
			linkSourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(linkSourceUnit);
			Unit linkTargetUnit = ValidatorUtils.getUnit(cl.getTarget());
			linkTargetUnit = (Unit) RealizationLinkUtil.getFinalRealization(linkTargetUnit);
			if (linkSourceUnit != null && linkTargetUnit != null && linkTargetUnit.equals(rsu)) {
				if (rsu.isConceptual() && !RealizationPatternUtil.alreadyRealized(linkSourceUnit)) {
					for (Iterator<Unit> iterUnit = top.findAllUnits(); iterUnit.hasNext();) {
						Unit candidateRSU = iterUnit.next();
						if (RealizationPatternUtil.realizable(linkSourceUnit, candidateRSU, arc
								.isStrictAttributeValueMatchMode(), arc
								.isFullyValidateConstraintsInMatchMode(), rpcs, DeployValidatorService
								.getDefaultValidatorService())) {
							if (RealizationPatternUtil.getCollocationConstraints(cl).size() > 0
									&& !collocationConstraintViolated(cl, candidateRSU, rtu)) {
								s.add(candidateRSU);
								addRelationshipType(relationshipTypeMap, candidateRSU,
										ConnectedSetRealizationMapper.CONSTRAINT_LINK_SOURCE_RELATIONSHIP);
							}
							if (RealizationPatternUtil.getDeferredHostingConstraints(cl).size() > 0
									&& !deferredHostingConstraintViolated(cl, candidateRSU, rtu, rpcs)) {
								Unit realHostInStack = ValidatorUtils.findHostInStack(candidateRSU,
										linkTargetUnit.eClass());
								if (rtu.equals(realHostInStack)) {
									s.add(candidateRSU);
									addRelationshipType(relationshipTypeMap, candidateRSU,
											ConnectedSetRealizationMapper.DEFERRED_HOSTED_RELATIONSHIP);
								}
							}
						}
					}
				}
			}
		}
		return s;
	}

	private static void addRelationshipType(Map<Unit, Set<Object>> relationshipTypeMap, Unit u,
			Object relationshipType) {
		Set<Object> rtSet = relationshipTypeMap.get(u);
		if (rtSet == null) {
			rtSet = new HashSet<Object>();
			relationshipTypeMap.put(u, rtSet);
		}
		rtSet.add(relationshipType);
	}

	private static Set<Unit> removeNonConceptualUnits(Set<Unit> unitSet) {
		Set<Unit> tSet = new HashSet<Unit>(unitSet);
		for (Unit u : unitSet) {
			if (!u.isConceptual()) {
				tSet.remove(u);
			}
		}
		return tSet;
	}

	private static Iterator<List<Unit>> getPermutationsIterator(Collection<Unit> c,
			Map<Unit, Set<Object>> relationshipTypes) {
		List<List<Unit>> cuConnUnitsPermutations;

		if (c.size() > 1 && unitTypesOverlap(c)) {
			Object[] cuConnectedUnitsArray = c.toArray();
			int cap = 4;
			// TODO no-heuristics case - return iterator that provides all permutations
			if (cuConnectedUnitsArray.length <= cap) {
				cuConnUnitsPermutations = new ArrayList<List<Unit>>();
				permute(0, cuConnectedUnitsArray.length, cuConnectedUnitsArray, cuConnUnitsPermutations);
				heuristicReorderPermutations(cuConnUnitsPermutations);
			} else {
				cuConnUnitsPermutations = heuristicPermutations(cuConnectedUnitsArray, factorial(cap),
						relationshipTypes);
			}
		} else {
			if (c.size() == 1) {
				cuConnUnitsPermutations = Collections.singletonList(Collections.singletonList(c
						.iterator().next()));
			} else {
				cuConnUnitsPermutations = Collections
						.singletonList((List<Unit>) new ArrayList<Unit>(c));
			}
		}
		return cuConnUnitsPermutations.iterator();
	}

	private static List<Iterator<List<Unit>>> getPermutationIterators(Set<Unit> setU,
			Map<Unit, Set<Object>> relationshipTypes) {
		if (setU.size() == 0) {
			return Collections.emptyList();
		}
		List<Iterator<List<Unit>>> cuConnUnitsPermutationIterators = new ArrayList<Iterator<List<Unit>>>();
		// if there are types in hierarchy in set, just build one big permutation list
		if (setU.size() == 1 || unitTypesInHierarchy(setU)) {
			cuConnUnitsPermutationIterators.add(getPermutationsIterator(setU, relationshipTypes));
		} else {
			// partition into sets of units that are of same type
			Set<DeployModelObject> workingSet = new HashSet<DeployModelObject>(setU);
			List<Set<Unit>> typePeerList = new ArrayList<Set<Unit>>();
			while (workingSet.size() > 0) {
				Object[] workingSetArray = workingSet.toArray();
				Unit unit = (Unit) workingSetArray[0];
				Set<Unit> typePeers = new HashSet<Unit>();
				typePeers.add(unit);
				for (int i = 1; i < workingSetArray.length; ++i) {
					if (unit.eClass().equals(((DeployModelObject) workingSetArray[i]).eClass())) {
						typePeers.add((Unit) workingSetArray[i]);
					}
				}
				workingSet.removeAll(typePeers);
				typePeerList.add(typePeers);
			}
			final Comparator<Collection<Unit>> collectionSizeComparator = new Comparator<Collection<Unit>>() {
				public int compare(Collection<Unit> c1, Collection<Unit> c2) {
					if (c1 == null || c2 == null) {
						return 0;
					}
					if (c1.size() == c2.size()) {
						return 0;
					} else if (c1.size() > c2.size()) {
						return 1;
					} else {
						return -1;
					}
				}
			};
//			Heuristic!!! order typed subgroups by increasing size. 
			Collections.sort(typePeerList, collectionSizeComparator);
			for (Set<Unit> typePeers : typePeerList) {
				cuConnUnitsPermutationIterators.add(getPermutationsIterator(typePeers,
						relationshipTypes));
			}
		}

		return cuConnUnitsPermutationIterators;
	}

	// "University of Exeter algorithm"
	// Build list of lists which are permutations of input array.
	static void permute(int start, int n, Object[] array, List<List<Unit>> results) {
		if (start == n - 1) {
			results.add(new ArrayList(Arrays.asList(array)));
		} else {
			for (int i = start; i < n; i++) {
				Object tmpO = array[i];
				array[i] = array[start];
				array[start] = tmpO;
				permute(start + 1, n, array, results);
				array[start] = array[i];
				array[i] = tmpO;
			}
		}
	}

	// Heuristically do permutations
	// This method is used if there are too many permutations 
	//
	private static List<List<Unit>> heuristicPermutations(Object cuConnectedUnitsArray[],
			int maxPermutations, Map<Unit, Set<Object>> relationshipTypesMap) {
		List<List<Unit>> cuConnUnitsPermutations = new ArrayList<List<Unit>>();
		// Try host first, if hosted
		Object[] tmpArray = cuConnectedUnitsArray.clone();
		for (int i = 0; i < tmpArray.length; ++i) {
			//			dumpRelationshipSet(relationshipTypesMap.get(tmpArray[i]), "rs"); //$NON-NLS-1$
			if (relationshipTypesMap.get(tmpArray[i]).contains(
					ConnectedSetRealizationMapper.HOST_RELATIONSHIP)) {
				if (i != 0) {
					Object tmpO = tmpArray[0];
					tmpArray[0] = tmpArray[i];
					tmpArray[i] = tmpO;
					cuConnUnitsPermutations.add(new ArrayList(Arrays.asList(tmpArray)));
					break;
				}
			}
		}

		// Try incoming order
		cuConnUnitsPermutations.add(new ArrayList(Arrays.asList(cuConnectedUnitsArray)));

		// Try reverse
		tmpArray = new Object[cuConnectedUnitsArray.length];
		for (int i = 0; i < cuConnectedUnitsArray.length; ++i) {
			tmpArray[tmpArray.length - 1 - i] = cuConnectedUnitsArray[i];
		}
		cuConnUnitsPermutations.add(new ArrayList(Arrays.asList(tmpArray)));

		List<Unit> l;
		// Try a few shuffles. Should this attempt de-duping?
		for (int i = 0; i < maxPermutations - cuConnUnitsPermutations.size(); ++i) {
			l = new ArrayList(Arrays.asList(cuConnectedUnitsArray));
			Collections.shuffle(l);
			cuConnUnitsPermutations.add(l);
		}

		return cuConnUnitsPermutations;
	}

	// Reorder generator permutations. 
	// Simple shuffle seems to perform best.
	private static void heuristicReorderPermutations(List<List<Unit>> permutations) {
		Collections.shuffle(permutations);
	}

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static boolean unitTypesInHierarchy(Collection<Unit> unitSet) {
		Set<EClass> eClassSet = new HashSet<EClass>();
		for (Iterator<Unit> unitSetIter = unitSet.iterator(); unitSetIter.hasNext();) {
			Unit unit = unitSetIter.next();
			for (EClass ec : eClassSet) {
				if (unit.eClass().isSuperTypeOf(ec) || ec.isSuperTypeOf(unit.eClass())) {
					if (!unit.eClass().equals(ec)) {
						//    		   			System.out.println("Types overlap - " + unit.eClass().getInstanceClassName() +  //$NON-NLS-1$
						//    		   					" : " + ec.getInstanceClassName()); //$NON-NLS-1$ 
						return true;
					}
				}
			}
			eClassSet.add(unit.eClass());
		}

		return false;
	}

	private static boolean unitTypesOverlap(Collection<Unit> unitSet) {
		Set<EClass> eClassSet = new HashSet<EClass>();
		for (Unit unit : unitSet) {
			for (EClass ec : eClassSet) {
				if (unit.eClass().isSuperTypeOf(ec) || ec.isSuperTypeOf(unit.eClass())) {
					//    		   		System.out.println("Types overlap - " + unit.eClass().getInstanceClassName() +  //$NON-NLS-1$
					//    		   				" : " + ec.getInstanceClassName()); //$NON-NLS-1$ 
					return true;
				}
			}
			eClassSet.add(unit.eClass());
		}

		return false;
	}

	//	private static void dumpPermutationLists(List<List<List>> unitsPermutationLists) {
	//		if (unitsPermutationLists.size() > 0) {
	//			System.out.println("PermutationLists -------"); //$NON-NLS-1$
	//			int i=0;
	//			for (Iterator i0 = unitsPermutationLists.iterator(); i0.hasNext();) {
	//				List l0 = (List) i0.next();
	//				int j=0;
	//				for (Iterator i1 = l0.iterator(); i1.hasNext();) {
	//					List l1 = (List) i1.next();
	//					System.out.print(i+":"+j++ +":"); //$NON-NLS-1$ //$NON-NLS-2$
	//					for (Iterator i2 = l1.iterator(); i2.hasNext();) {
	//						DeployModelObject dmo = (DeployModelObject)i2.next();
	//						System.out.print("[" + ((Unit)dmo).titleWithContext() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
	//					}
	//					System.out.println(); 
	//				}
	//				++i;
	//			}
	//			System.out.println("-------"); //$NON-NLS-1$
	//		}	
	//		}

	/**
	 * @param m
	 * @param mapName
	 */
	public static void dumpUnitRealizationMap(Map<Unit, Unit> m, String mapName) {
		System.out.println("Map " + mapName + " -----------"); //$NON-NLS-1$ //$NON-NLS-2$
		for (Iterator<Unit> unitIter = m.keySet().iterator(); unitIter.hasNext();) {
			Unit u = unitIter.next();
			Unit mappedU = m.get(u);
			System.out.println("(conceptual=" + u.isConceptual() + " hc=" + u.hashCode() + ") " + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					u.getCaptionProvider().titleWithContext(u) + " mapped to " + //$NON-NLS-1$
					"(conceptual=" + mappedU.isConceptual() + " hc=" + //$NON-NLS-1$ //$NON-NLS-2$
					m.get(u).hashCode() + ") " + mappedU.getCaptionProvider().titleWithContext(mappedU)); //$NON-NLS-1$
		}
	}

	/**
	 * @param maps
	 * @param mapsName
	 */
	public static void dumpUnitRealizationMapList(Collection<Map<Unit, Unit>> maps, String mapsName) {
		int i = 0;
		for (Map<Unit, Unit> m : maps) {
			dumpUnitRealizationMap(m, mapsName + "[" + i++ + "]"); //$NON-NLS-1$//$NON-NLS-2$
		}
	}
//
//	private static void dumpRelationshipSet(Set<Object> s, String relationshipSetName) {
//		System.out.println("-------Relationship set - " + relationshipSetName); //$NON-NLS-1$
//		Object sa[] = s.toArray();
//		for (int i = 0; i < sa.length; ++i) {
//			System.out.println(sa[i].toString());
//		}
//	}
}
