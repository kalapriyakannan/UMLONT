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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * Static utility methods for {@link Topology} instances.
 */
public final class TopologyUtil {

	private TopologyUtil() {
		// prevent instantiation
	}

	/**
	 * check if topology has any validation error
	 * 
	 * @param topology
	 *           a topology object
	 * @return boolean true, if error found
	 */
	public static boolean hasError(Topology top) {
		if (top == null) {
			return false;
		}
		for (Iterator iter = top.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject obj = (DeployModelObject) iter.next();
			if (obj.getStatus().getSeverity() == IStatus.ERROR) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Find a copy of a unit in a different topology. This works only if the unit has been copied
	 * from one topology to the other.
	 * 
	 * @param input
	 *           the unit
	 * @param topToHuntIn
	 *           the topology to search in
	 * @return the unit in the topology if it exists, null otherwise
	 */
	// everything below was copied from UnitUnitProvider (the first was changed
	// slightly)
	// FIXME refactor UnitUnitProvider and this
	public static Unit getUnitInTopology(Unit input, Topology topToHuntIn) {

		// first check if unit is already in the topology:
		if (input.getTopology() == topToHuntIn || input.getEditTopology() == topToHuntIn) {
			return input;
		}

		// check if the unit has a unitunit annotation use it to find the unit
		String uriToHunt = getUnitUnitOrigin(input);
		if (null != uriToHunt) {
			for (Iterator it = topToHuntIn.getUnits().iterator(); it.hasNext();) {
				Unit candidate = (Unit) it.next();
				String uriOrigin = uriForUnit(candidate);
				if (uriToHunt.equals(uriOrigin)) {
					return candidate;
				}
			}
			return null;
		}

		// next, get the uri and look for a unit with a unitunit annoation that
		// matches
		uriToHunt = uriForUnit(input);
		if (null != uriToHunt) {
			for (Iterator it = topToHuntIn.getUnits().iterator(); it.hasNext();) {
				Unit candidate = (Unit) it.next();
				String uriOrigin = getUnitUnitOrigin(candidate);
				if (uriToHunt.equals(uriOrigin)) {
					return candidate;
				}
			}
			return null;
		}

		// we didn't find it
		return null;
	}

	private static String uriForUnit(Unit input) {
		Resource resInput = input.eResource();
		if (resInput != null) {
			String origin = resInput.getURI().toString() + '#' + input.getFullPath();
			return origin;
		}
		return null;

	}

	private static final String UNIT_UNIT_CONTEXT = "unitunit"; //$NON-NLS-1$

	/**
	 * Given a DeployModelObject, get the URI we annotated it with during resolveUnit()
	 * 
	 * @param dmo
	 * @return URI as String
	 */
	private static String getUnitUnitOrigin(DeployModelObject dmo) {
		for (Iterator it = dmo.getAnnotations().iterator(); it.hasNext();) {
			Annotation ann = (Annotation) it.next();
			if (ann.getContext().equals(UNIT_UNIT_CONTEXT)) {
				Object obj = ann.getDetails().get(IAnnotationConstants.ARCHIVE_URI);
				String uri = (String) obj;
				return uri;
			}
		}

		return null;
	}

	/**
	 * Sequence the units with-in the the topology based on the hosting stack. A map is created from
	 * a list of non hosted units to the hostee stack. This ordering can then be used by the
	 * exporters or publishers.
	 * 
	 * @param top
	 *           the topology to traverse
	 * @return the map of the installed host unit to the hostee list
	 */
	public static Map sequenceTopologyHostingStack(Topology top) {
		Map map = new LinkedHashMap();
		// find all the  units that are not hosted and are marked as installed
		// units that do not have any hosting requirement
		List nonHostedUnits = findAllNonHostedInstalledUnits(top);
		List visitorList = new ArrayList();
		for (Iterator uIt = nonHostedUnits.iterator(); uIt.hasNext();) {
			Unit unit = (Unit) uIt.next();
			sequenceTopologyHostingStack(unit, map, visitorList);
		}
		return map;
	}

	private static void sequenceTopologyHostingStack(Unit unit, Map map, List visitorList) {
		if (map.containsKey(unit)) {
			return;
		}
		visitorList.add(unit);
		List hLinks = unit.getHostingLinks();
		for (Iterator hIt = hLinks.iterator(); hIt.hasNext();) {
			HostingLink link = (HostingLink) hIt.next();
			Unit hostee = link.getTarget();
			if (!hostee.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
				// Not installed, add to the map:  map.put( unit, hostee )
				ArrayList list = (ArrayList) map.get(unit);
				if (list == null) {
					list = new ArrayList();
				}
				list.add(hostee);
				map.put(unit, list);
			}
			if (!visitorList.contains(hostee)) {
				sequenceTopologyHostingStack(hostee, map, visitorList);
			}
		}

		List mLinks = unit.getMemberLinks();
		for (Iterator mIt = mLinks.iterator(); mIt.hasNext();) {
			MemberLink link = (MemberLink) mIt.next();
			Unit member = link.getTarget();
			if (!member.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)
					&& !isGenericGroup(member)) {
				// Not installed, add to the map:  map.put( unit, hostee )
				ArrayList list = (ArrayList) map.get(unit);
				if (list == null) {
					list = new ArrayList();
				}
				list.add(member);
				map.put(unit, list);
			}
			if (!visitorList.contains(member)) {
				sequenceTopologyHostingStack(member, map, visitorList);
			}
		}
	}

	private static List findAllNonHostedInstalledUnits(Topology top) {
		List list = new ArrayList();

		List units = top.getUnits();
		for (Iterator uIt = units.iterator(); uIt.hasNext();) {
			Unit unit = (Unit) uIt.next();
			// is not installed
			if (unit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
				Unit[] hosts = top.findHosts(unit);
				if (hosts == null || hosts.length == 0) {
					list.add(unit);
				}
			} else if (!isGenericGroup(unit) && unit.getHostingOrAnyRequirements().size() == 0) {
				Unit[] hosts = top.findHosts(unit);
				if (hosts == null || hosts.length == 0) {
					list.add(unit);
				}
			}
		}

		return list;
	}

	private static boolean isGenericGroup(Unit unit) {
		return unit.isGroup()
				&& CapabilityUtil.findRequirementOfType(unit, CorePackage.eINSTANCE.getUnit()) != null;
	}

	/**
	 * Imports a topology into another topology.
	 * <p>
	 * Creates or reuses an {@link Import} on {@link Topology#getImports()}.
	 * 
	 * @param importTopology
	 *           the topology to be imported.
	 * @param targetTopology
	 *           the topology where the {@link Import} will be added.
	 * @return the existing or newly created {@link Import}.
	 */
	public static Import importTopology(Topology importTopology, Topology targetTopology) {
		assert importTopology != null;
		assert targetTopology != null;

		Import i = targetTopology.getImport(importTopology.getNamespace(), importTopology.getName());
		if (i != null) {
			return i;
		}

		// Create a new import
		i = CoreFactory.eINSTANCE.createImport();
		i.setPattern(importTopology.getName());
		i.setNamespace(importTopology.getNamespace() == null ? new String() : importTopology
				.getNamespace());
		i.setName(importTopology.getName());
		i.setDisplayName(importTopology.getName());
		i.setMutable(false);

		InstanceConfiguration instanceConfig = CoreFactory.eINSTANCE.createInstanceConfiguration();
		instanceConfig.setName("default");//$NON-NLS-1$
		i.setInstanceConfiguration(instanceConfig);

		targetTopology.getImports().add(i);
		UnitUtil.assignUniqueName(i);
		return i;
	}

	/**
	 * Resolve a topology import to its topology.
	 * 
	 * @param importDcl
	 *           a topology import.
	 * @return the topology object, or null if it cannot be resolved.
	 */
	public static Topology resolve(Import importDcl) {
		if (importDcl == null) {
			return null;
		}
		IScopeService scope = IScopeService.Locator.findScopeService(importDcl);
		if (scope instanceof InternalScopeService) {
			InternalScopeService iScope = (InternalScopeService) scope;
			Topology top = iScope.resolve(importDcl);
			if (top != null) {
				return (Topology) iScope.getCacheService().findProxy(top, importDcl);
			}
		}
		return null;
	}

	/**
	 * Returns all the topologies imported by a topology (recursive).
	 * <p>
	 * The returned list does not include the topology argument. The method will return even if there
	 * is a cycle in the import graph.
	 * 
	 * @param top
	 *           a deploy topology.
	 * @return List<Topology> of all topologies imported directly or indirectly by the topology.
	 */
	public static List getAllImportedTopologies(Topology top) {
		return getAllImportedTopologies(top, false);
	}

	/**
	 * Returns all the topologies imported by a topology (recursive).
	 * <p>
	 * The returned list does not include the topology argument. The method will return even if there
	 * is a cycle in the import graph.
	 * 
	 * @param top
	 *           a deploy topology.
	 * @param includeTopology
	 *           true if the topology should be included in the list.
	 * @return List<Topology> of all topologies imported directly or indirectly by the topology.
	 */
	public static List getAllImportedTopologies(Topology top, boolean includeTopology) {
		if (top == null || top.getImports().size() == 0) {
			if (includeTopology) {
				return Collections.singletonList(top);
			}
			return Collections.EMPTY_LIST;
		}
		Set visited = new LinkedHashSet<Topology>();
		List stack = new LinkedList();
		stack.add(top);
		while (stack.size() > 0) {
			Topology cur = (Topology) stack.remove(0);
			if (!visited.contains(cur)) {
				visited.add(cur);
				for (Iterator iter = cur.getImports().iterator(); iter.hasNext();) {
					Topology importTop = resolve((Import) iter.next());
					if (importTop != null) {
						stack.add(importTop);
					}
				}
			}
		}
		if (!includeTopology) {
			visited.remove(top);
		}
		return new ArrayList(visited);
	}

	/**
	 * Returns a list of hosting links whose target is the specified unit.
	 * <p>
	 * Queries hosting links contained in {@link Unit#getHostingLinks()} as well as
	 * {@link Topology#getHostingLinks()}.
	 * <p>
	 * In hosting links, the target is the hosted unit, and the source is the host.
	 * <p>
	 * Note: in a valid model, the list size will be 0 or 1. However, it is possible that lists of
	 * size greater than 1 will be returned for invalid models.
	 * 
	 * @param hosted
	 *           a topology unit that is the target of zero or more hosting links.
	 * @return an immutable list of hosting links whose {@link HostingLink#getTarget()} is the unit.
	 */
	public static List<HostingLink> getImmediateHostingLinksIn(Unit hosted) {
		if (hosted == null) {
			return Collections.emptyList();
		}
		Topology editTop = hosted.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		HostingLink link = null;
		List<HostingLink> list = null;
		for (HostingLink cur : editTop.getRelationships().getHostLinks(hosted)) {
//		for (Iterator<HostingLink> iter = topology.findAllHostingLinks(); iter.hasNext();) {
//			HostingLink cur = iter.next();
			if (hosted.equals(cur.getTarget())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<HostingLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of hosting links whose source is the specified unit.
	 * <p>
	 * Queries hosting links contained in {@link Unit#getHostingLinks()} as well as
	 * {@link Topology#getHostingLinks()}.
	 * <p>
	 * In hosting links, the target is the hosted unit, and the source is the host.
	 * 
	 * @param host
	 *           a topology unit that is the source of zero or more hosting links.
	 * @return an immutable list of hosting links whose {@link HostingLink#getSource()} is the unit.
	 */
	public static List<HostingLink> getImmediateHostingLinksOut(Unit host) {
		if (host == null) {
			return Collections.emptyList();
		}
		Topology editTop = host.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		HostingLink link = null;
		List<HostingLink> list = null;
		for (HostingLink cur : editTop.getRelationships().getHostedLinks(host)) {
//		for (Iterator<HostingLink> iter = topology.findAllHostingLinks(); iter.hasNext();) {
//			HostingLink cur = iter.next();
			if (host.equals(cur.getSource())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<HostingLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of member links whose target is the specified unit.
	 * <p>
	 * Queries member links contained in {@link Unit#getMemberLinks()} as well as
	 * {@link Topology#getMemberLinks()}.
	 * <p>
	 * In member links, the target is the member unit, and the source is the group.
	 * 
	 * @param member
	 *           a topology member unit.
	 * @return an immutable list of member links whose {@link MemberLink#getTarget()} is the unit.
	 */
	public static List<MemberLink> getImmediateMemberLinksIn(Unit member) {
		if (member == null) {
			return Collections.emptyList();
		}
		Topology editTop = member.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		MemberLink link = null;
		List<MemberLink> list = null;
		for (MemberLink cur : editTop.getRelationships().getContainerLinks(member)) {
//		for (Iterator<MemberLink> iter = topology.findAllMemberLinks(); iter.hasNext();) {
//			MemberLink cur = iter.next();
			if (member.equals(cur.getTarget())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<MemberLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of member links whose source is the specified unit.
	 * <p>
	 * Queries member links contained in {@link Unit#getMemberLinks()} as well as
	 * {@link Topology#getMemberLinks()}.
	 * <p>
	 * In member links, the target is the member unit, and the source is the group.
	 * 
	 * @param group
	 *           a topology group unit.
	 * @return an immutable list of member links whose {@link MemberLink#getSource()} is the unit.
	 */
	public static List<MemberLink> getImmediateMemberLinksOut(Unit group) {
		if (group == null) {
			return Collections.emptyList();
		}
		Topology editTop = group.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		MemberLink link = null;
		List<MemberLink> list = null;
		for (MemberLink cur : editTop.getRelationships().getMembersLinks(group)) {
//		for (Iterator<MemberLink> iter = topology.findAllMemberLinks(); iter.hasNext();) {
//			MemberLink cur = iter.next();
			if (group.equals(cur.getSource())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<MemberLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of dependency links whose target is the specified capability.
	 * <p>
	 * Queries dependency links contained in {@link Requirement#getLink()} as well as
	 * {@link Topology#getDependencyLinks()}.
	 * <p>
	 * In dependency links, the target is a capabiilty, and the source is a requirement.
	 * 
	 * @param cap
	 *           a topology unit capability.
	 * @return an immutable list of dependency links whose {@link DependencyLink#getTarget()} is the
	 *         capability.
	 */
	public static List<DependencyLink> getImmediateDependencyLinksIn(Capability cap) {
		if (cap == null) {
			return Collections.emptyList();
		}
		Topology editTop = cap.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		DependencyLink link = null;
		List<DependencyLink> list = null;
		for (DependencyLink cur : editTop.getRelationships().getDependentRequirementsLinks(cap)) {
//		for (Iterator<DependencyLink> iter = topology.findAllDependencyLinks(); iter.hasNext();) {
//			DependencyLink cur = iter.next();
			if (cap.equals(cur.getTarget())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<DependencyLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of dependency links whose source is the specified requirement.
	 * <p>
	 * Queries dependency links contained in {@link Requirement#getLink()} as well as
	 * {@link Topology#getDependencyLinks()}.
	 * <p>
	 * In dependency links, the target is a capability, and the source is a requirement.
	 * <p>
	 * Returns all links, including those whose source or target is going to be uninstalled.
	 * 
	 * @param req
	 *           a topology unit requirement.
	 * @return an immutable list of dependency links whose {@link DependencyLink#getTarget()} is the
	 *         unit.
	 */
	public static List<DependencyLink> getImmediateDependencyLinksOut(Requirement req) {
		return getImmediateDependencyLinksOut(req, true);
	}

	/**
	 * Returns a list of dependency links whose source is the specified requirement.
	 * <p>
	 * Queries dependency links contained in {@link Requirement#getLink()} as well as
	 * {@link Topology#getDependencyLinks()}.
	 * <p>
	 * In dependency links, the target is a capability, and the source is a requirement .
	 * 
	 * @param req
	 *           a topology unit requirement.
	 * @param includeNotInstalledLinks
	 *           true if links whose target or source are uninstalled should be returned.
	 * @return an immutable list of dependency links whose {@link DependencyLink#getSource()} is the
	 *         requirement
	 */
	public static List<DependencyLink> getImmediateDependencyLinksOut(Requirement req,
			boolean includeNotInstalledLinks) {
		if (req == null) {
			return Collections.emptyList();
		}
		Topology editTop = req.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		DependencyLink link = null;
		List<DependencyLink> list = null;
		for (DependencyLink cur : editTop.getRelationships().getDependencyTargetsLinks(req)) {
//		for (Iterator<DependencyLink> iter = topology.findAllDependencyLinks(); iter.hasNext();) {
//			DependencyLink cur = iter.next();
			if (includeNotInstalledLinks && ValidatorUtils.isGoalNotInstalled(cur.getSource())
					|| ValidatorUtils.isGoalNotInstalled(cur.getTarget())) {
				continue;
			}
			if (req.equals(cur.getSource())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<DependencyLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of constraint links whose source is the specified object.
	 * <p>
	 * Queries constraint links contained in {@link Unit#getConstraintLinks()} well as
	 * {@link Topology#getConstraintLinks()}.
	 * <p>
	 * Returns all links, including those whose source or target is going to be uninstalled.
	 * 
	 * @param source
	 *           a topology object.
	 * @return an immutable list of constraint links whose {@link ConstraintLink#getSource()} is the
	 *         object.
	 */
	public static List<ConstraintLink> getImmediateConstraintLinksOut(DeployModelObject source) {
		return getImmediateConstraintLinksOut(source, true);
	}

	/**
	 * Returns a list of constraint links whose source is the specified object.
	 * <p>
	 * Queries constraint links contained in {@link Unit#getConstraintLinks()} well as
	 * {@link Topology#getConstraintLinks()}.
	 * <p>
	 * 
	 * @param source
	 *           a topology object.
	 * @param includeNotInstalledLinks
	 *           true if links whose target or source are uninstalled should be returned.
	 * @return an immutable list of constraint links whose {@link ConstraintLink#getSource()} is the
	 *         object.
	 */
	public static List<ConstraintLink> getImmediateConstraintLinksOut(DeployModelObject source,
			boolean includeNotInstalledLinks) {
		if (source == null) {
			return Collections.emptyList();
		}
		Topology editTop = source.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		ConstraintLink link = null;
		List<ConstraintLink> list = null;
//		for (Iterator<ConstraintLink> iter = editTop.findAllConstraintLinks(); iter.hasNext();) {
		for (Iterator<ConstraintLink> iter = editTop.getRelationships()
				.getConstraintLinkTargetsLinks(source).iterator(); iter.hasNext();) {
			ConstraintLink cur = iter.next();
			if (includeNotInstalledLinks && ValidatorUtils.isGoalNotInstalled(cur.getSource())
					|| ValidatorUtils.isGoalNotInstalled(cur.getTarget())) {
				continue;
			}
//			if (source.equals(cur.getSource())) {
			if (link == null) {
				link = cur;
			} else {
				if (list == null) {
					list = new ArrayList<ConstraintLink>();
					list.add(link);
				}
				list.add(cur);
			}
//			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of constraint links whose target is the specified object.
	 * <p>
	 * Queries constraint links contained in {@link Unit#getConstraintLinks()} as well as
	 * {@link Topology#getConstraintLinks()}.
	 * <p>
	 * 
	 * @param target
	 *           a topology object.
	 * @return an immutable list of constraint links whose {@link ConstraintLink#getTarget()} is the
	 *         object.
	 */
	public static List<ConstraintLink> getImmediateConstraintLinksIn(DeployModelObject target) {
		return getImmediateConstraintLinksIn(target, true);
	}

	/**
	 * Returns a list of constraint links whose target is the specified object.
	 * <p>
	 * Queries constraint links contained in {@link Unit#getConstraintLinks()} as well as
	 * {@link Topology#getConstraintLinks()}.
	 * 
	 * @param target
	 *           a topology object.
	 * @param includeNotInstalledLinks
	 *           true if links whose target or source are uninstalled should be returned.
	 * @return an immutable list of constraint links whose {@link ConstraintLink#getTarget()} is the
	 *         capability.
	 */
	public static List<ConstraintLink> getImmediateConstraintLinksIn(DeployModelObject target,
			boolean includeNotInstalledLinks) {
		if (target == null) {
			return Collections.emptyList();
		}
		Topology editTop = target.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		ConstraintLink link = null;
		List<ConstraintLink> list = null;
//		for (Iterator<ConstraintLink> iter = editTop.findAllConstraintLinks(); iter.hasNext();) {
		for (Iterator<ConstraintLink> iter = editTop.getRelationships()
				.getConstraintLinkSourcesLinks(target).iterator(); iter.hasNext();) {

			ConstraintLink cur = iter.next();
			if (includeNotInstalledLinks && ValidatorUtils.isGoalNotInstalled(cur.getSource())
					|| ValidatorUtils.isGoalNotInstalled(cur.getTarget())) {
				continue;
			}
//			if (target.equals(cur.getTarget())) {			
			if (link == null) {
				link = cur;
			} else {
				if (list == null) {
					list = new ArrayList<ConstraintLink>();
					list.add(link);
				}
				list.add(cur);
			}
//			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of realization links whose source is the specified object.
	 * <p>
	 * Queries realization links contained in {@link Unit#getRealizationLinks()} well as
	 * {@link Topology#getRealizationLinks()}.
	 * <p>
	 * Returns all links, including those whose source or target is going to be uninstalled.
	 * 
	 * @param source
	 *           a topology object.
	 * @return an immutable list of realization links whose {@link RealizationLink#getSource()} is
	 *         the object.
	 */
	public static List<RealizationLink> getImmediateRealizationLinksOut(DeployModelObject source) {
		return getImmediateRealizationLinksOut(source, true);
	}

	/**
	 * Returns a list of realization links whose source is the specified object.
	 * <p>
	 * Queries realization links contained in {@link Unit#getRealizationLinks()} well as
	 * {@link Topology#getRealizationLinks()}.
	 * <p>
	 * 
	 * @param source
	 *           a topology object.
	 * @param includeNotInstalledLinks
	 *           true if links whose target or source are uninstalled should be returned.
	 * @return an immutable list of realization links whose {@link RealizationLink#getSource()} is
	 *         the object.
	 */
	public static List<RealizationLink> getImmediateRealizationLinksOut(DeployModelObject source,
			boolean includeNotInstalledLinks) {
		if (source == null) {
			return Collections.emptyList();
		}
		Topology editTop = source.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		RealizationLink link = null;
		List<RealizationLink> list = null;
		for (RealizationLink cur : editTop.getRelationships().getRealizedByLinks(source)) {
//		for (Iterator<RealizationLink> iter = topology.findAllRealizationLinks(); iter.hasNext();) {
//			RealizationLink cur = iter.next();
			if (includeNotInstalledLinks && ValidatorUtils.isGoalNotInstalled(cur.getSource())
					|| ValidatorUtils.isGoalNotInstalled(cur.getTarget())) {
				continue;
			}
			if (source.equals(cur.getSource())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<RealizationLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of realization links whose target is the specified object.
	 * <p>
	 * Queries realization links contained in {@link Unit#getRealizationLinks()} as well as
	 * {@link Topology#getRealizationLinks()}.
	 * <p>
	 * 
	 * @param target
	 *           a topology object.
	 * @return an immutable list of realization links whose {@link RealizationLink#getTarget()} is
	 *         the object.
	 */
	public static List<RealizationLink> getImmediateRealizationLinksIn(DeployModelObject target) {
		return getImmediateRealizationLinksIn(target, true);
	}

	/**
	 * Returns a list of realization links whose target is the specified object.
	 * <p>
	 * Queries realization links contained in {@link Unit#getRealizationLinks()} as well as
	 * {@link Topology#getRealizationLinks()}.
	 * 
	 * @param target
	 *           a topology object.
	 * @param includeNotInstalledLinks
	 *           true if links whose target or source are uninstalled should be returned.
	 * @return an immutable list of realization links whose {@link RealizationLink#getTarget()} is
	 *         the capability.
	 */
	public static List<RealizationLink> getImmediateRealizationLinksIn(DeployModelObject target,
			boolean includeNotInstalledLinks) {
		if (target == null) {
			return Collections.emptyList();
		}
		Topology editTop = target.getEditTopology();
		if (editTop == null) {
			// cannot determine hosts without topology
			return Collections.emptyList();
		}

		RealizationLink link = null;
		List<RealizationLink> list = null;
		for (RealizationLink cur : editTop.getRelationships().getRealizesLinks(target)) {
//		for (Iterator<RealizationLink> iter = topology.findAllRealizationLinks(); iter.hasNext();) {
//			RealizationLink cur = iter.next();
			if (includeNotInstalledLinks && ValidatorUtils.isGoalNotInstalled(cur.getSource())
					|| ValidatorUtils.isGoalNotInstalled(cur.getTarget())) {
				continue;
			}
			if (target.equals(cur.getTarget())) {
				if (link == null) {
					link = cur;
				} else {
					if (list == null) {
						list = new ArrayList<RealizationLink>();
						list.add(link);
					}
					list.add(cur);
				}
			}
		}
		if (list != null) {
			return Collections.unmodifiableList(list);
		}
		if (link != null) {
			return Collections.singletonList(link);
		}
		return Collections.emptyList();
	}
}
