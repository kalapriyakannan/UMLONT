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
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationLinkMatcher;

/**
 * 
 * Utility methods for identifying realization patterns
 */
public class RealizationPatternUtil {

	private static LinkType[] realizationLinkTypes = new LinkType[] { LinkType.REALIZATION };

	/**
	 * Compute a set of units that are all units in the same topology as the parameter unit. Imported
	 * topologies and the edit topology are distinct.
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @return Set of Units in pattern. (or their proxies if they are in imported topologies)
	 */
	public static Set<Unit> getUnitsInTopology(Unit u) {
		HashSet<Unit> s = new HashSet<Unit>();
		Topology top = u.getTopology();
		Topology editTop = u.getEditTopology();
		for (Iterator<Unit> editTopUnitsIter = editTop.getUnits().iterator(); editTopUnitsIter
				.hasNext();) {
			Unit tmpU = editTopUnitsIter.next();
			if (tmpU.getTopology().equals(top)) {
				s.add(tmpU);
			}
		}
		return s;
	}

	/**
	 * Compute a set of Units which are all units connected to parameter unit via any link type
	 * except realization links, recursively. The returned set contains the final realizations of the
	 * units.
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param followStructuralConstraintLinks
	 *           True if structural constraint links should be followed to build the connected set.
	 * @param rpcs
	 * @return Set of Units in connected pattern
	 */
	public static Set<Unit> getImmediateConnectedSet(Unit u,
			boolean followStructuralConstraintLinks, RealizationPatternCacheService rpcs) {
		HashSet<Unit> s = new HashSet<Unit>();
		HashSet<Unit> visited = new HashSet<Unit>();

		for (Iterator<Unit> setIter = getImmediateConnectedSet(u, visited, u.getEditTopology(),
				false, followStructuralConstraintLinks, rpcs).iterator(); setIter.hasNext();) {
			s.add((Unit) RealizationLinkUtil.getFinalRealization(setIter.next()));
		}

		return s;
	}

	/**
	 * Compute a set of Units which are all units connected to parameter unit via any link type
	 * except realization links, recursively. The returned set contains the final realizations of the
	 * units.
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param rpcs
	 * @return Set of Units in connected pattern
	 */
	public static Set<Unit> getImmediateConnectedSet(Unit u, RealizationPatternCacheService rpcs) {
		return getImmediateConnectedSet(u, true, rpcs);
	}

	/**
	 * Compute a set of Units which are all conceptual units connected to conceptual parameter unit
	 * via any link type except realization links, recursively. Strictly follows immediate
	 * realization links.
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param followStructuralConstraintLinks
	 *           True if structural constraint links should be followed to build the connected set.
	 * @return Set of Units in connected pattern
	 */
	public static Set<Unit> getImmediateConceptualConnectedSet(Unit u,
			boolean followStructuralConstraintLinks, RealizationPatternCacheService rpcs) {
		HashSet<Unit> s = new HashSet<Unit>();
		HashSet<Unit> visited = new HashSet<Unit>();

		for (Iterator<Unit> setIter = getImmediateConnectedSet(u, visited, u.getEditTopology(), true,
				followStructuralConstraintLinks, rpcs).iterator(); setIter.hasNext();) {
			s.add(setIter.next());
		}

		return s;
	}

	/**
	 * Compute a set of Units which are all units connected to parameter unit via any link type
	 * except realization links, recursively, using depth-first search. TODO version with discovery
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param visited
	 *           Set of units visited so far
	 * @return Set of Units in connected pattern
	 */
	private static Set<Unit> getImmediateConnectedSet(Unit u, Set<Unit> visited, Topology top,
			boolean conceptualOnly, boolean followStructuralConstraintLinks,
			RealizationPatternCacheService rpcs) {
		HashSet<Unit> s = new HashSet<Unit>();
		if (visited.contains(u)) {
			return s;
		}
		visited.add(u);
		if (conceptualOnly && !u.isConceptual()) {
			return s;
		}
		s.add(u);

		// Build working set to recurse on
		Set<Unit> connectedUnits = getDirectlyConnectedUnits(u, top, true,
				followStructuralConstraintLinks, rpcs);
		for (Iterator<Unit> connUnitIter = connectedUnits.iterator(); connUnitIter.hasNext();) {
			Unit connUnit = connUnitIter.next();
			s.addAll(getImmediateConnectedSet(connUnit, visited, top, conceptualOnly,
					followStructuralConstraintLinks, rpcs));
		}

		return s;
	}

	/*
	 * TODO This is duplicated (plus more) in ConnectedSetRealizationMapper
	 */
	private static Set<Unit> getDirectlyConnectedUnits(Unit u, Topology top, boolean immediate,
			boolean followStructuralConstraintLinks, RealizationPatternCacheService rpcs) {
		HashSet<Unit> s = new HashSet<Unit>();
		Unit host = rpcs.getHost(u, top, immediate);
		if (host != null) {
			s.add(host);
		}
		for (Iterator<Unit> hostedIter = rpcs.getHosted(u, top, immediate).iterator(); hostedIter
				.hasNext();) {
			Unit hosted = hostedIter.next();
			s.add(hosted);
		}
		for (Iterator<Unit> containingGroupsIter = rpcs.getGroups(u, top, immediate).iterator(); containingGroupsIter
				.hasNext();) {
			Unit containingGroup = containingGroupsIter.next();
			s.add(containingGroup);
		}
		for (Iterator<Unit> membersIter = rpcs.getMembers(u, top, immediate).iterator(); membersIter
				.hasNext();) {
			Unit member = membersIter.next();
			s.add(member);
		}
		for (Iterator<Requirement> reqIter = u.getRequirements().iterator(); reqIter.hasNext();) {
			Requirement r = reqIter.next();
			Capability targetCap = rpcs.getDependencyLinkTarget(r, top, immediate);
			if (targetCap != null) {
				Unit targetUnit = ValidatorUtils.getUnit(targetCap);
				if (targetUnit != null) {
					s.add(ValidatorUtils.getUnit(targetCap));
				}
			}
		}
		for (Iterator<Capability> capIter = u.getCapabilities().iterator(); capIter.hasNext();) {
			Capability c = capIter.next();
			List<Requirement> sources = rpcs.getDependencyLinkSources(c, top, immediate);
			for (Iterator<Requirement> sourcesIter = sources.iterator(); sourcesIter.hasNext();) {
				Requirement sourceReq = sourcesIter.next();
				if (sourceReq != null) {
					Unit sourceUnit = ValidatorUtils.getUnit(sourceReq);
					if (sourceUnit != null) {
						s.add(sourceUnit);
					}
				}
			}
		}

		if (followStructuralConstraintLinks) {
			// Deferred hosting & general constraint links outbound
			for (ConstraintLink cl : top.getRelationships().getConstraintLinkTargetsLinks(u)) {
				if (!RealizationPatternUtil.isStructuralConstraintLink(cl)) {
					continue;
				}
				if (rpcs.getArbk().getIntraPatternStructuralConstraintLinksNotFollowed().contains(cl)) {
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
						} else {
							// For constraint links only, do additional navigation. 
							targetUnit = (Unit) RealizationLinkUtil.getFinalRealization(targetUnit);
							s.add(targetUnit);
						}
					}
				}
			}

			// general constraint links inbound
			for (ConstraintLink cl : top.getRelationships().getConstraintLinkSourcesLinks(u)) {
				if (!RealizationPatternUtil.isStructuralConstraintLink(cl)) {
					continue;
				}
				if (rpcs.getArbk().getIntraPatternStructuralConstraintLinksNotFollowed().contains(cl)) {
					continue;
				}
				Unit sourceUnit = ValidatorUtils.getUnit(cl.getSource());
				Unit targetUnit = ValidatorUtils.getUnit(cl.getTarget());
				if (sourceUnit != null && targetUnit != null && targetUnit.equals(u)) {
					for (Constraint c : (List<Constraint>) cl.getConstraints()) {
						if (c instanceof DeferredHostingConstraint) {
							sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
							s.add(sourceUnit);
						} else {
							// For constraint links only, do additional navigation. 
							sourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(sourceUnit);
							s.add(sourceUnit);
						}
					}
				}
			}
		}
		return s;
	}

	/**
	 * Compute a set of Units which are the final realization of (a) The parameter unit and all units
	 * in its immediate hosting stack including the bottom of the hosting stack, plus (b) The units
	 * hosted, recursively, by the units in (a) (c) The containing groups (1 level only) of the units
	 * in (a) and (b) TODO version with discovery
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param top
	 *           Topology to find pattern in.
	 * @return Set of Units in pattern
	 */
	public static Set<Unit> getImmediateStackPlusGroupsSet(Unit u, Topology top) {
		HashSet<Unit> s = new HashSet<Unit>();
		s.addAll(getImmediateStrictStackSet(u));
		Set<Unit> hostedRecursiveSet = getImmediateSetHostedRecursive(s, top);
		s.addAll(hostedRecursiveSet);
		Set<Unit> containingGroupsSet = getImmediateSetContainingGroups(s, top);
		s.addAll(containingGroupsSet);

		HashSet<Unit> returnSet = new HashSet<Unit>();
		for (Iterator<Unit> setIter = s.iterator(); setIter.hasNext();) {
			returnSet.add((Unit) RealizationLinkUtil.getFinalRealization(setIter.next()));
		}
		return returnSet;
	}

	/**
	 * Compute a set of Units which are the final realization of (a) The parameter unit (b) The units
	 * hosted, recursively, by the parameter unit)
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param top
	 *           Topology to find pattern in.
	 * @return Set of Units in pattern
	 */
	public static Set<Unit> getImmediateStackUpSet(Unit u, Topology top) {
		Set<Unit> s = new HashSet<Unit>();
		s = getImmediateHostedRecursive(u, s, top);

		HashSet<Unit> returnSet = new HashSet<Unit>();
		for (Iterator<Unit> setIter = s.iterator(); setIter.hasNext();) {
			returnSet.add((Unit) RealizationLinkUtil.getFinalRealization(setIter.next()));
		}
		return returnSet;
	}

	/**
	 * Compute a set of Units which are (a) The parameter unit and all units down its immediate
	 * hosting stack including the bottom of the hosting stack, plus (b) The configuration units
	 * hosted, recursively, by the units in (a)
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @param top
	 *           working topology (edit topology typically)
	 * @return Set of Units in pattern
	 */
	public static Set<Unit> getImmediateStackDownPlusConfigAndGroupsSet(Unit u, Topology top,
			RealizationPatternCacheService rpcs) {
		HashSet<Unit> s = new HashSet<Unit>();
		s.addAll(rpcs.getImmediateStrictStackSet(u));
		Set<Unit> hostedRecursiveSet = getImmediateSetHostedConfigRecursive(s, top);
		s.addAll(hostedRecursiveSet);
		Set<Unit> containingGroupsSet = getImmediateSetContainingGroups(s, top);
		s.addAll(containingGroupsSet);

		HashSet<Unit> returnSet = new HashSet<Unit>();
		for (Iterator<Unit> setIter = s.iterator(); setIter.hasNext();) {
			returnSet.add((Unit) RealizationLinkUtil.getFinalRealization(setIter.next()));
		}
		return returnSet;
	}

	/**
	 * Compute a set of Units which are the parameter unit and all units in its immediate hosting
	 * stack including the bottom of the hosting stack.
	 * 
	 * @param u
	 *           Unit from which to start pattern detection
	 * @return Set of Units in hosting stack pattern
	 */
	public static Set<Unit> getImmediateStrictStackSet(Unit u) {
		HashSet<Unit> s = new HashSet<Unit>();
		while (u != null) {
			s.add(u);
			u = ValidatorUtils.getImmediateHost(u);
		}
		return s;
	}

	private static Set<Unit> getImmediateSetHostedRecursive(Set<Unit> s, Topology top) {
		HashSet<Unit> rs = new HashSet<Unit>();
		for (Iterator<Unit> unitsIter = s.iterator(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			rs.addAll(getImmediateHostedRecursive(u, s, top));
		}

		return rs;
	}

	// Visited check is for efficiency, not correctness
	private static Set<Unit> getImmediateHostedRecursive(Unit u, Set<Unit> alreadyVisited,
			Topology top) {
		HashSet<Unit> s = new HashSet<Unit>();
		for (Iterator<Unit> hostedByIter = ValidatorUtils.getImmediateHosted(u).iterator(); hostedByIter
				.hasNext();) {
			Unit hosted = hostedByIter.next();
			if (!alreadyVisited.contains(hosted)) {
				s.add(hosted);
				s.addAll(getImmediateHostedRecursive(hosted, alreadyVisited, top));
			}
		}
		return s;
	}

	private static Set<Unit> getImmediateSetHostedConfigRecursive(Set<Unit> s, Topology top) {
		HashSet<Unit> rs = new HashSet<Unit>();
		for (Iterator<Unit> unitsIter = s.iterator(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			rs.addAll(getImmediateHostedConfigRecursive(u, s, top));
		}

		return rs;
	}

	// Visited check is for efficiency, not correctness
	private static Set<Unit> getImmediateHostedConfigRecursive(Unit u, Set<Unit> alreadyVisited,
			Topology top) {
		HashSet<Unit> s = new HashSet<Unit>();
		for (Iterator<Unit> hostedByIter = ValidatorUtils.getImmediateHosted(u).iterator(); hostedByIter
				.hasNext();) {
			Unit hosted = hostedByIter.next();
			if (!hosted.isConfigurationUnit()) {
				continue;
			}
			if (!alreadyVisited.contains(hosted)) {
				s.add(hosted);
				s.addAll(getImmediateHostedRecursive(hosted, alreadyVisited, top));
			}
		}
		return s;
	}

	private static Set<Unit> getImmediateSetContainingGroups(Set<Unit> s, Topology top) {
		HashSet<Unit> rs = new HashSet<Unit>();
		for (Iterator<Unit> unitsIter = s.iterator(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			rs.addAll(getImmediateContainingGroups(u, top));
		}
		return rs;
	}

	private static Set<Unit> getImmediateContainingGroups(Unit u, Topology top) {
		HashSet<Unit> s = new HashSet<Unit>();
		for (Iterator<Unit> containedByIter = ValidatorUtils.getImmediateGroups(u).iterator(); containedByIter
				.hasNext();) {
			Unit containedBy = containedByIter.next();
			s.add(containedBy);
		}

		return s;
	}

	/**
	 * @param s
	 * @param setName
	 */
	public static void dumpUnitSet(Set<Unit> s, String setName) {
		dumpUnitCollection(s, setName);
	}

	/**
	 * @param c
	 * @param collectionName
	 */
	public static void dumpUnitCollection(Collection<Unit> c, String collectionName) {
		String type = "Collection"; //$NON-NLS-1$
		if (c instanceof Set) {
			type = "Set"; //$NON-NLS-1$
		}
		if (c instanceof List) {
			type = "List"; //$NON-NLS-1$
		}
		System.out.println(type + " " + collectionName + " ----------- "); //$NON-NLS-1$ //$NON-NLS-2$
		for (Iterator<Unit> unitIter = c.iterator(); unitIter.hasNext();) {
			Unit u = unitIter.next();
			System.out
					.println("(conceptual=" + u.isConceptual() + ")" + u.getCaptionProvider().titleWithContext(u) + //$NON-NLS-1$//$NON-NLS-2$
							"[hashcode " + u.hashCode() + "]"); //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	/**
	 * Return true if a realization link between conceptual source unit and candidate target unit
	 * would be valid.
	 * 
	 * @param conceptualSourceUnit
	 *           conceptual unit that would be source of realization
	 * @param candidateTargetUnit
	 *           unit that would be target of realization
	 * @param strictAttributeValueMatchMode
	 *           Default for realization link matching allows mismatched attribute values if the
	 *           target attribute is settable. If this parameter is true, then mismatched attribute
	 *           values will prevent a realization match.
	 * @param fullyValidateConstraints
	 *           Default for matching evaluates constraints for potential match. If this parameter is
	 *           true, constraints will be fully validated.
	 * @param dvs
	 * @return Return true if a realization link between conceptual source unit and candidate target
	 *         unit would be valid, false otherwise.
	 */
	public static boolean realizable(Unit conceptualSourceUnit, Unit candidateTargetUnit,
			boolean strictAttributeValueMatchMode, boolean fullyValidateConstraints,
			RealizationPatternCacheService rpcs, DeployValidatorService dvs) {
		//		System.out.println("realizable called: " + conceptualSourceUnit.titleWithContext() + " to " + candidateTargetUnit.titleWithContext() //$NON-NLS-1$ //$NON-NLS-2$
		//				+ " [" + conceptualSourceUnit.hashCode() + "," + candidateTargetUnit.hashCode() + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		//		long startTime = System.currentTimeMillis();

		//		LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(conceptualSourceUnit, candidateTargetUnit, realizationLinkTypes);
		if (alreadyRealized(conceptualSourceUnit)) {
			return false;
		}
		if (!strictAttributeValueMatchMode && !fullyValidateConstraints) {
			LinkDescriptor[] linkDescriptorArray = rpcs.getPossibleLinks(conceptualSourceUnit,
					candidateTargetUnit, realizationLinkTypes, dvs);

			//		long time = System.currentTimeMillis();
			//		System.out.println("Realizable : Elapsed milliseconds for realizable query = " + (time-startTime)); //$NON-NLS-1$						

//		return linkDescriptorArray.length == 1;
			return linkDescriptorArray.length >= 1;
		} else {
			RealizationLinkMatcher rlm = new RealizationLinkMatcher();
			IStatus s = rlm.canCreateLink(conceptualSourceUnit, candidateTargetUnit,
					strictAttributeValueMatchMode, fullyValidateConstraints);
			return s.isOK();
		}
	}

	/**
	 * @param u
	 * @return true if unit does not equal its final realization
	 */
	public static boolean alreadyRealized(Unit u) {
		Unit uFR = (Unit) RealizationLinkUtil.getFinalRealization(u);
		return !uFR.equals(u);
	}

	/**
	 * @param cl
	 * @return True if link is structural constraint link of known type
	 */
	public static boolean isStructuralConstraintLink(ConstraintLink cl) {
		// If top level constraint is a structural constraint, then there is code to evaluate it.
		for (Constraint c : (List<Constraint>) cl.getConstraints()) {
			if (isStructuralConstraint(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param c
	 * @return True if link is structural constraint of known type
	 */
	public static boolean isStructuralConstraint(Constraint c) {
		if (c instanceof CollocationConstraint || c instanceof DeferredHostingConstraint) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param cl
	 * @return Collocation constraints in top level list of constraints
	 */
	public static Collection<CollocationConstraint> getCollocationConstraints(ConstraintLink cl) {
		ArrayList<CollocationConstraint> retVal = new ArrayList<CollocationConstraint>();

		for (Constraint c : (List<CollocationConstraint>) cl.getConstraints()) {
			if (c instanceof CollocationConstraint) {
				retVal.add((CollocationConstraint) c);
			}
		}
		return retVal;
	}
	
	/**
	 * 
	 * @param cl
	 * @return Deferred hosting constraints in top level list of constraints
	 */
	public static Collection<DeferredHostingConstraint> getDeferredHostingConstraints(ConstraintLink cl) {
		ArrayList<DeferredHostingConstraint> retVal = new ArrayList<DeferredHostingConstraint>();

		for (Constraint c : (List<CollocationConstraint>) cl.getConstraints()) {
			if (c instanceof DeferredHostingConstraint) {
				retVal.add((DeferredHostingConstraint) c);
			}
		}
		return retVal;
	}

}
