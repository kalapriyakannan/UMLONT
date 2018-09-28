/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationMatcherUtils;

/**
 * Static utility methods for deploy {@link RealizationLink} instances.
 */
public class RealizationLinkUtil {

	public static final int WALK_UP = 2;
	public static final int WALK_DOWN = 4;
	public static final int WALK_BOTH = WALK_UP | WALK_DOWN;

	private static final DeployModelObject[] NO_REALIZATIONS = new DeployModelObject[0];
	private static final Unit[] NO_UNIT_REALIZATIONS = new Unit[0];
	private static final Capability[] NO_CAPABILITY_REALIZATIONS = new Capability[0];
	private static final Requirement[] NO_REQUIREMENT_REALIZATIONS = new Requirement[0];

	/**
	 * Retrieve the targets of the realization links found in the topology with the given source.
	 * 
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit}, {@link Capability}
	 * , or {@link Requirement}. This method does not check this condition.
	 * </p>
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * </p>
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target of a realization link whose source is the parameter (null if no link
	 *         exists, or its target is null).
	 * 
	 * @see #getImplicitRealizations(DeployModelObject)
	 */

	public static Capability[] getRealizations(Capability source) {
		if (source == null) {
			return NO_CAPABILITY_REALIZATIONS;
		}
		Topology editTopology = source.getEditTopology();
		if (editTopology == null) {
			return NO_CAPABILITY_REALIZATIONS;
		}
		Collection<DeployModelObject> realizedByColl = editTopology.getRelationships().getRealizedBy(
				source);
		if (realizedByColl.size() == 0) {
			return NO_CAPABILITY_REALIZATIONS;
		}
		Set<DeployModelObject> unique = new HashSet<DeployModelObject>(realizedByColl.size());
		unique.addAll(realizedByColl);
		return unique.toArray(NO_CAPABILITY_REALIZATIONS);
	}

	public static Requirement[] getRealizations(Requirement source) {
		if (source == null) {
			return NO_REQUIREMENT_REALIZATIONS;
		}
		Topology editTopology = source.getEditTopology();
		if (editTopology == null) {
			return NO_REQUIREMENT_REALIZATIONS;
		}

		Collection<DeployModelObject> realizedByColl = editTopology.getRelationships().getRealizedBy(
				source);
		if (realizedByColl.size() == 0) {
			return NO_REQUIREMENT_REALIZATIONS;
		}
		Set<DeployModelObject> unique = new HashSet<DeployModelObject>(realizedByColl.size());
		unique.addAll(realizedByColl);
		return unique.toArray(NO_REQUIREMENT_REALIZATIONS);
	}

	public static Unit[] getRealizations(Unit source) {
		if (source == null) {
			return NO_UNIT_REALIZATIONS;
		}
		Topology editTopology = source.getEditTopology();
		if (editTopology == null) {
			return NO_UNIT_REALIZATIONS;
		}

		Collection<DeployModelObject> realizedByColl = editTopology.getRelationships().getRealizedBy(
				source);
		if (realizedByColl.size() == 0) {
			return NO_UNIT_REALIZATIONS;
		}
		Set<DeployModelObject> unique = new HashSet<DeployModelObject>(realizedByColl.size());
		unique.addAll(realizedByColl);
		return unique.toArray(NO_UNIT_REALIZATIONS);
	}

	public static DeployModelObject[] getRealizations(DeployModelObject source) {
		if (source == null) {
			return NO_REALIZATIONS;
		}
		Topology editTopology = source.getEditTopology();
		if (editTopology == null) {
			return NO_REALIZATIONS;
		}

		Collection<DeployModelObject> realizedByColl = editTopology.getRelationships().getRealizedBy(
				source);
		if (realizedByColl.size() == 0) {
			return NO_REALIZATIONS;
		}
		Set<DeployModelObject> unique = new HashSet<DeployModelObject>(realizedByColl.size());
		unique.addAll(realizedByColl);
		return unique.toArray(NO_REALIZATIONS);
	}

	/**
	 * Retrieve the target of the first realization link found in the topology which the given
	 * source, or through a related source.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target or implicit target of a realization link whose source is the parameter
	 *         (null if no link exists, or its target is null).
	 * @see #getRealizations(DeployModelObject)
	 */
	public static DeployModelObject[] getImplicitRealizations(DeployModelObject source) {
		if (source == null) {
			return NO_REALIZATIONS;
		}
		Topology editTopology = source.getEditTopology();
		if (editTopology == null) {
			return NO_REALIZATIONS;
		}

		DeployModelObject[] realizedBy = getRealizations(source);
		if (realizedBy.length > 0) {
			return realizedBy;
		}
		Set<DeployModelObject> implicitRealizations = new HashSet<DeployModelObject>();
		for (Iterator<RealizationLink> links = editTopology.findAllRealizationLinks(); links
				.hasNext();) {
			RealizationLink link = links.next();
			DeployModelObject implicitTarget = getImplicitTarget(source, link);
			if (implicitTarget != null) {
				implicitRealizations.add(implicitTarget);
			}

		}
		return implicitRealizations.toArray(NO_REALIZATIONS);
	}

	/**
	 * Retrieve the sources of the realization link found in the topology with the given target.
	 * <p>
	 * The method makes no checks on the validity of the source objects (type, isConceptual(), etc.).
	 * 
	 * @param target
	 *           the target of the realization link
	 * @return Set<DeployModelObject> list of direct realization list sources (never null).
	 */
	public static Set<DeployModelObject> getRealizes(DeployModelObject target) {
		if (target == null) {
			return Collections.emptySet();
		}
		Topology editTopology = target.getEditTopology();
		if (editTopology == null) {
			return Collections.emptySet();
		}

		Collection<DeployModelObject> realizes = editTopology.getRelationships().getRealizes(target);
		return realizes == null ? new HashSet<DeployModelObject>() : new HashSet<DeployModelObject>(
				realizes);

//		return getRealizes(target, false);
	}

	/**
	 * Retrieve the sources of the realization link explicitely or implicitely found in the topology
	 * with the given target.
	 * <p>
	 * The method makes no checks on the validity of the source objects (type, isConceptual(), etc.).
	 * 
	 * @param target
	 *           the target of the realization link
	 * @return Set<DeployModelObject> list of direct realization list sources (never null).
	 */
	public static Set<DeployModelObject> getImplicitRealizes(DeployModelObject target) {
		return getRealizes(target, true);
	}

	private static Set<DeployModelObject> getRealizes(DeployModelObject target, boolean implicit) {
		if (target == null) {
			return Collections.emptySet();
		}
		Topology editTopology = target.getEditTopology();
		if (editTopology == null) {
			return Collections.emptySet();
		}

		DeployModelObject source = null;
		Set<DeployModelObject> sourceList = null;

		for (DeployModelObject realizedByTarget : editTopology.getRelationships().getRealizes(target)) {
			if (source == null) {
				source = realizedByTarget;
			} else {
				if (sourceList == null) {
					sourceList = new HashSet<DeployModelObject>();
					sourceList.add(source);
				}
				sourceList.add(realizedByTarget);
			}
		}
		if (implicit) {
			for (Iterator<RealizationLink> links = editTopology.findAllRealizationLinks(); links
					.hasNext();) {
				RealizationLink link = links.next();
				if (link.getTarget() == null || link.getSource() == null) {
					continue;
				}
				DeployModelObject implicitSource = getImplicitSource(target, link);
				if (implicitSource != null) {
					if (source == null) {
						source = implicitSource;
					} else {
						if (sourceList == null) {
							sourceList = new HashSet<DeployModelObject>();
							sourceList.add(source);
						}
						sourceList.add(implicitSource);
					}
				}
			}
		}
		if (sourceList != null) {
			return sourceList;
		}
		if (source != null) {
			return Collections.singleton(source);
		}
		return DeployCollections.EMPTY_DEPLOY_MODEL_OBJECT_SET;
	}

	/**
	 * Recursively collect the units that realized or are explicitly realized by the unit (including
	 * the unit).
	 * <p>
	 * The method makes no checks on the validity of the realization link endpoints(type,
	 * isConceptual(), etc.).
	 * 
	 * @param object
	 *           a source or target of one or more realization link.
	 * @return Set<DeployModelObject> list of the transitive closure of objects reachable in either
	 *         direction of realization links to and from the unit (including the object parameter;
	 *         hence the list is never empty).
	 */
	public static Set<DeployModelObject> getAllRealizationLinkedObjects(DeployModelObject object) {
		return getAllRealizationLinkedObjects(object, false);
	}

	/**
	 * Recursively collect the units that realized or are explicitly or implicitly realized by the
	 * unit (including the unit).
	 * <p>
	 * The method makes no checks on the validity of the realization link endpoints(type,
	 * isConceptual(), etc.).
	 * 
	 * @param object
	 *           a source or target of one or more realization link.
	 * @return Set<DeployModelObject> set of the transitive closure of objects reachable in either
	 *         direction of realization links to and from the unit (including the object parameter;
	 *         hence the list is never empty).
	 */
	public static Collection<DeployModelObject> getAllImplicitRealizationLinkedObjects(
			DeployModelObject object) {
		if (object == null) {
			return Collections.emptySet();
		}
		Topology editTopology = object.getEditTopology();
		if (editTopology == null) {
			return Collections.emptySet();
		}
		return new HashSet<DeployModelObject>(editTopology.getRelationships()
				.getAllImplicitRealizationLinkedObjects(object));
	}

	/**
	 * 
	 * @see #getAllImplicitRealizationLinkedObjects(DeployModelObject)
	 * @param object
	 * @return Return linked objects
	 */
	public static Set<DeployModelObject> computeAllImplicitRealizationLinkedObjects(
			DeployModelObject object) {
		return getAllRealizationLinkedObjects(object, true);
	}

	/**
	 * Transitive closure on realization in both directions.
	 * 
	 * @param object
	 *           an object in the realization transitive closure set.
	 * @param implicit
	 *           true if implicit realizations should be honored.
	 * @return set of realization transitive closure objects (always of size greater than one).
	 */
//	private static Set<DeployModelObject> getAllRealizationLinkedObjects(DeployModelObject object,
//			boolean implicit) {
//
//		if (object == null) {
//			return DeployCollections.EMPTY_DEPLOY_MODEL_OBJECT_SET;
//		}
//		Set<DeployModelObject> result = new HashSet<DeployModelObject>();
//		List<DeployModelObject> stack = new LinkedList<DeployModelObject>();
//		stack.add(object);
//		while (stack.size() > 0) {
//			DeployModelObject cur = stack.remove(0);
//			if (result.contains(cur)) {
//				continue;
//			}
//			result.add(cur);
//			// Discovery can return objects with no topology
//			if (object.getEditTopology() == null) {
//				continue;
//			}
//			for (Iterator<RealizationLink> links = object.getEditTopology().findAllRealizationLinks(); links
//					.hasNext();) {
//				RealizationLink link = links.next();
//				if (link.getSource() == null || link.getTarget() == null) {
//					continue;
//				}
//				if (cur.equals(link.getSource())) {
//					stack.add(link.getTarget());
//				} else if (cur.equals(link.getTarget())) {
//					stack.add(link.getSource());
//				}
//				if (implicit) {
//					DeployModelObject implicitTarget = getImplicitTarget(cur, link);
//					if (implicitTarget != null) {
//						stack.add(implicitTarget);
//					}
//					DeployModelObject implicitSource = getImplicitSource(cur, link);
//					if (implicitSource != null) {
//						stack.add(implicitSource);
//					}
//				}
//			}
//		}
//		return result;
//	
	// Version that uses indexed relationships where possible.
	private static Set<DeployModelObject> getAllRealizationLinkedObjects(DeployModelObject object,
			boolean implicit) {

		if (object == null) {
			return DeployCollections.EMPTY_DEPLOY_MODEL_OBJECT_SET;
		}
		Set<DeployModelObject> result = new LinkedHashSet<DeployModelObject>();
		List<DeployModelObject> stack = new LinkedList<DeployModelObject>();
		Topology editTop = object.getEditTopology();
		if (editTop == null) {
			result.add(object);
			return result;
		}
		stack.add(object);
		while (stack.size() > 0) {
			DeployModelObject cur = stack.remove(0);
			if (result.contains(cur)) {
				continue;
			}
			result.add(cur);
			for (DeployModelObject o : editTop.getRelationships().getRealizedBy(cur)) {
				stack.add(o);
			}
			for (DeployModelObject o : editTop.getRelationships().getRealizes(cur)) {
				stack.add(o);
			}
			if (implicit) {
				for (Iterator<RealizationLink> links = editTop.findAllRealizationLinks(); links
						.hasNext();) {
					RealizationLink link = links.next();
					if (link.getSource() == null || link.getTarget() == null) {
						continue;
					}
					DeployModelObject implicitTarget = getImplicitTarget(cur, link);
					if (implicitTarget != null) {
						stack.add(implicitTarget);
					}
					DeployModelObject implicitSource = getImplicitSource(cur, link);
					if (implicitSource != null) {
						stack.add(implicitSource);
					}
				}
			}
		}
		return result;
	}

	// Version that uses indexed relationships where possible.
	public static List<DeployModelObject> getRealizationLinkedPath(DeployModelObject startingPoint) {
		return getRealizationLinkedPath(startingPoint, false, WALK_BOTH);
	}

	public static List<DeployModelObject> getRealizationLinkedPath(DeployModelObject startingPoint,
			int options) {
		return getRealizationLinkedPath(startingPoint, false, options);
	}

	/**
	 * 
	 * Returns a path of realization objects using the starting point, and including the
	 * startingpoint at the beginning of the final list. Version that uses indexed relationships
	 * where possible.
	 * 
	 * @param startingPoint
	 * @param implicit
	 * @param options
	 * @return
	 */
	public static List<DeployModelObject> getRealizationLinkedPath(DeployModelObject startingPoint,
			boolean implicit, int options) {

		if (startingPoint == null) {
			return Collections.emptyList();
		}

		Topology editTop = startingPoint.getEditTopology();
		if (editTop == null) {
			return Collections.singletonList(startingPoint);
		}

		List<DeployModelObject> result = new ArrayList<DeployModelObject>();

		if ((options & WALK_DOWN) != 0) {
			List<DeployModelObject> upStack = new LinkedList<DeployModelObject>();
			upStack.add(startingPoint);
			// walk down the stack
			while (upStack.size() > 0) {
				DeployModelObject cur = upStack.remove(0);
				if (result.contains(cur)) {
					continue;
				}
				if (cur != startingPoint) {
					result.add(cur);
				}
				for (DeployModelObject o : editTop.getRelationships().getRealizedBy(cur)) {
					if (!result.contains(o) && o != startingPoint) {
						upStack.add(o);
					}
				}
				if (implicit) {
					for (Iterator<RealizationLink> links = editTop.findAllRealizationLinks(); links
							.hasNext();) {
						RealizationLink link = links.next();
						if (link.getSource() == null || link.getTarget() == null) {
							continue;
						}
						DeployModelObject implicitTarget = getImplicitTarget(cur, link);
						if (implicitTarget != null) {
							upStack.add(implicitTarget);
						}
					}
				}
			}
		}

		if ((options & WALK_UP) != 0) {
			List<DeployModelObject> downStack = new LinkedList<DeployModelObject>();
			downStack.add(startingPoint);
			while (downStack.size() > 0) {
				DeployModelObject cur = downStack.remove(0);
				if (result.contains(cur)) {
					continue;
				}
				if (cur != startingPoint) {
					result.add(cur);
				}
				for (DeployModelObject o : editTop.getRelationships().getRealizes(cur)) {
					downStack.add(o);
				}
				if (implicit) {
					for (Iterator<RealizationLink> links = editTop.findAllRealizationLinks(); links
							.hasNext();) {
						RealizationLink link = links.next();
						if (link.getSource() == null || link.getTarget() == null) {
							continue;
						}
						DeployModelObject implicitSource = getImplicitSource(cur, link);
						if (implicitSource != null) {
							downStack.add(implicitSource);
						}
					}
				}
			}
		}

		result.add(0, startingPoint);

		return result;
	}

	/**
	 * Retrieve the last realization in a chain of realization from a {@link DeployModelObject} in a
	 * given context.
	 * <p>
	 * This method searches for a single unambiguous
	 * <p>
	 * If a unit has no realizations, the unit itself is returned.
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit}, {@link Capability}
	 * , or {@link Requirement}. Again, this method does not check this condition.
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target of a realization chain (never null unless source is null).
	 */
	public static DeployModelObject getFinalRealization(DeployModelObject source) {
		return getFinalRealization(source, false);
	}

	/**
	 * Retrieve the set of realization in a chain of realization from a {@link DeployModelObject} in
	 * a given context.
	 * <p>
	 * There should be only once realization of the object. This method does not check this
	 * condition. Instead it returns the first realization found, if any at any step in the process.
	 * If a realization link cycle is found, then the last object in the cycle is returned.
	 * <p>
	 * If a unit has no realizations, the unit itself is returned.
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit}, {@link Capability}
	 * , or {@link Requirement}. Again, this method does not check this condition.
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target of a realization chain (never null unless source is null).
	 */
	public static DeployModelObject[] getFinalRealizations(DeployModelObject source) {
		if (null == source) {
			return NO_REALIZATIONS;
		}

		Set<DeployModelObject> realizationSet = getFinalRealizationSet(source,
				new HashSet<DeployModelObject>());
		return realizationSet.toArray(new DeployModelObject[realizationSet.size()]);

	}

	private static Set<DeployModelObject> getFinalRealizationSet(DeployModelObject source,
			Set<DeployModelObject> visitSet) {
		if (null == source) {
			return null;
		}

		Set<DeployModelObject> finalRealizations = new HashSet<DeployModelObject>();

		visitSet.add(source);

		DeployModelObject[] realizations = getRealizations(source);
		if (realizations.length > 0) {
			for (int i = 0; i < realizations.length; i++) {
				if (!visitSet.contains(realizations[i])) {
					Set<DeployModelObject> realizationSet = getFinalRealizationSet(realizations[i],
							visitSet);
					if (realizationSet.size() == 0) {
						finalRealizations.add(realizations[i]);
					} else {
						finalRealizations.addAll(realizationSet);
					}
				}
				visitSet.add(realizations[i]);
			}
		} else {
			finalRealizations.add(source);
		}
		// either we traced an unambiguous path or we hit a fork in the road
		return finalRealizations;

	}

	/**
	 * Retrieve the last realization in a chain of realization from a {@link DeployModelObject} in a
	 * given context.
	 * <p>
	 * Implicit realizations are followed.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target of a realization chain (never null unless source is null).
	 */
	public static DeployModelObject getImplicitFinalRealization(DeployModelObject source) {
		return getFinalRealization(source, true);
	}

	/**
	 * Returns the final realization.
	 * 
	 * @param source
	 *           the realization source.
	 * @param implicit
	 *           true if implicit realizations should be honored (see
	 *           {@link #getImplicitRealizations(DeployModelObject)}.
	 * @return the most realized source.
	 */
	private static DeployModelObject getFinalRealization(DeployModelObject source, boolean implicit) {
		if (null == source) {
			return null;
		}
		DeployModelObject[] realizations = implicit ? getImplicitRealizations(source)
				: getRealizations(source);

		if (realizations.length == 1 && realizations[0] != null) {
			Set<DeployModelObject> visitSet = new HashSet<DeployModelObject>();
			visitSet.add(source);
			visitSet.add(realizations[0]);
			DeployModelObject nextRealization = realizations[0];
			while (nextRealization != null && realizations.length == 1) {
				realizations = implicit ? getImplicitRealizations(nextRealization)
						: getRealizations(nextRealization);
				if (realizations.length == 1 && realizations[0] != null) {
					if (visitSet.contains(realizations[0])) {
						// cycle
						return nextRealization;
					}
					nextRealization = realizations[0];
					visitSet.add(nextRealization);
				}
			}
			// either we traced an unambiguous path or we hit a fork in the road
			return nextRealization;
		}
		return source;
	}

	/**
	 * Returns an implicit realization of the source implied by the link.
	 * 
	 * <p>
	 * Note: returns a single target even if the target is ambiguous.
	 * 
	 * @param source
	 *           an implicit source object.
	 * @param link
	 *           a realization link that may imply a realization on the source.
	 * @return the realization link target implied, or null if none.
	 */
	private static DeployModelObject getImplicitTarget(DeployModelObject source, RealizationLink link) {
		if (source == null || link == null) {
			return null;
		}
		if (link.getSource() == null || link.getTarget() == null) {
			return null;
		}
		Unit sourceUnit = ValidatorUtils.getUnit(link.getSource());
		if (sourceUnit == null) {
			return null;
		}
		Unit targetUnit = ValidatorUtils.getUnit(link.getTarget());
		if (targetUnit == null) {
			return null;
		}
		if (!sourceUnit.equals(ValidatorUtils.getUnit(source))) {
			return null;
		}
		if (source.equals(sourceUnit)) {
			return targetUnit;
		}
		if (sourceUnit.equals(targetUnit)) {
			// trivial cycle: prevent infinite looping with RealizationMatcherUtils which calls back this method.
			return source;
		}
		if (source instanceof Requirement) {
			Requirement sourceReq = (Requirement) source;
			for (Iterator<Requirement> iter = targetUnit.getRequirements().iterator(); iter.hasNext();) {
				Requirement targetReq = iter.next();
				if (RealizationMatcherUtils.reqMatches(sourceReq, targetReq).isOK()) {
					return targetReq;
				}
			}
		} else if (source instanceof Capability) {
			Capability sourceCap = (Capability) source;
			for (Iterator<Capability> iter = targetUnit.getCapabilities().iterator(); iter.hasNext();) {
				Capability targetCap = iter.next();
				if (RealizationMatcherUtils.capMatches(sourceCap, targetCap).isOK()) {
					return targetCap;
				}
			}
		}
		return null;
	}

	/**
	 * Returns a list of implicit realizers of the target implied by the link.
	 * 
	 * <p>
	 * Note: returns a single source even if the source is ambiguous.
	 * 
	 * @param target
	 *           a implicit target object.
	 * @param link
	 *           a realization link that may imply a realization on the target.
	 * @return the realization link target implied, or null if none.
	 */
	private static DeployModelObject getImplicitSource(DeployModelObject target, RealizationLink link) {
		if (target == null || link == null) {
			return null;
		}
		if (link.getSource() == null || link.getTarget() == null) {
			return null;
		}
		Unit targetUnit = ValidatorUtils.getUnit(link.getTarget());
		if (targetUnit == null) {
			return null;
		}
		Unit sourceUnit = ValidatorUtils.getUnit(link.getSource());
		if (sourceUnit == null) {
			return null;
		}
		if (!targetUnit.equals(ValidatorUtils.getUnit(target))) {
			return null;
		}
		if (target.equals(targetUnit)) {
			return sourceUnit;
		}
		if (targetUnit.equals(sourceUnit)) {
			// trivial cycle: prevent infinite looping with RealizationMatcherUtils which calls back this method.
			return target;
		}
		if (target instanceof Requirement) {
			Requirement targetReq = (Requirement) target;
			for (Iterator<Requirement> iter = sourceUnit.getRequirements().iterator(); iter.hasNext();) {
				Requirement sourceReq = iter.next();
				if (RealizationMatcherUtils.reqMatches(sourceReq, targetReq).isOK()) {
					return sourceReq;
				}
			}
		} else if (target instanceof Capability) {
			Capability targetCap = (Capability) target;
			for (Iterator<Capability> iter = sourceUnit.getCapabilities().iterator(); iter.hasNext();) {
				Capability sourceCap = iter.next();
				if (RealizationMatcherUtils.capMatches(sourceCap, targetCap).isOK()) {
					return sourceCap;
				}
			}
		}
		return null;
	}

}
