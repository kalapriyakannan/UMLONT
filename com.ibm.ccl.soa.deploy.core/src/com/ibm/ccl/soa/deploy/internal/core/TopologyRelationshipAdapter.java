/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.impl.TopologyImpl;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * This naive approach extends EContentAdapter, so we get everything. TODO be more restrictive.
 */
public class TopologyRelationshipAdapter extends EContentAdapter implements IRelationshipChecker {

	/**
	 * 
	 */
	private final TopologyImpl topologyImpl;

	/**
	 * @param topImpl
	 */
	public TopologyRelationshipAdapter(TopologyImpl topImpl) {
		topologyImpl = topImpl;
	}

	// Boolean indicating complete staleness.  TODO consider having a stale
	// flag per map type (Hosting, Dependency, etc)
	private boolean stale = true;

	private final Map<Unit, List<Unit>> hosts = new HashMap<Unit, List<Unit>>();
	private final Map<Unit, List<Unit>> hosted = new HashMap<Unit, List<Unit>>();

	private final Map<Unit, List<Unit>> containers = new HashMap<Unit, List<Unit>>();
	private final Map<Unit, List<Unit>> members = new HashMap<Unit, List<Unit>>();

	private final Map<Capability, List<Requirement>> dependsUpon = new HashMap<Capability, List<Requirement>>();
	private final Map<Requirement, List<Capability>> isDependedUpon = new HashMap<Requirement, List<Capability>>();

	private final Map<DeployModelObject, List<DeployModelObject>> realizedBy = new HashMap<DeployModelObject, List<DeployModelObject>>();
	private final Map<DeployModelObject, List<DeployModelObject>> realizes = new HashMap<DeployModelObject, List<DeployModelObject>>();

	//
	private final Map<Unit, List<HostingLink>> hostsLinks = new HashMap<Unit, List<HostingLink>>();
	private final Map<Unit, List<HostingLink>> hostedLinks = new HashMap<Unit, List<HostingLink>>();

	private final Map<Unit, List<MemberLink>> containersLinks = new HashMap<Unit, List<MemberLink>>();
	private final Map<Unit, List<MemberLink>> membersLinks = new HashMap<Unit, List<MemberLink>>();

	private final Map<Capability, List<DependencyLink>> dependsUponLinks = new HashMap<Capability, List<DependencyLink>>();
	private final Map<Requirement, List<DependencyLink>> isDependedUponLinks = new HashMap<Requirement, List<DependencyLink>>();

	private final Map<DeployModelObject, List<RealizationLink>> realizedByLinks = new HashMap<DeployModelObject, List<RealizationLink>>();
	private final Map<DeployModelObject, List<RealizationLink>> realizesLinks = new HashMap<DeployModelObject, List<RealizationLink>>();

	private final Map<DeployModelObject, List<DeployModelObject>> constraintLinkSources = new HashMap<DeployModelObject, List<DeployModelObject>>();
	private final Map<DeployModelObject, List<DeployModelObject>> constraintLinkTargets = new HashMap<DeployModelObject, List<DeployModelObject>>();

	private final Map<DeployModelObject, List<ConstraintLink>> constraintLinkSourcesLinks = new HashMap<DeployModelObject, List<ConstraintLink>>();
	private final Map<DeployModelObject, List<ConstraintLink>> constraintLinkTargetsLinks = new HashMap<DeployModelObject, List<ConstraintLink>>();

	private final Map<DeployModelObject, Set<DeployModelObject>> implicitRealizationLinkedObjects = new HashMap<DeployModelObject, Set<DeployModelObject>>();

	private final Map<Object, Unit> artifactUnitMap = new HashMap<Object, Unit>();

	private boolean multipleHostingFlag;

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		// There is a possible optimization; we could return immediately if stale==true
		// without checking the notification.

		if (changesRelationships(notification)) {
			stale = true;
			//			System.out
			//					.println("Something important changed! - " + getFeatureName(notification.getFeature())); //$NON-NLS-1$
			//		} else if (!changesNothing(notification)) {
			//
			//			System.out
			//					.println("changed in non-stale-making way; src=" + notification.getNotifier().getClass() + " feature=" + getFeatureName(notification.getFeature())); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/** @deprecated this just cuts down on screen clutter during development */
	@Deprecated
	private boolean changesNothing(Notification notification) {
		Object feature = notification.getFeature();

		// Attributes are never structural ?
		if (feature instanceof EAttribute) {
			return true;
		}

		return false;
	}

	/**
	 * Does the notification mean our relationship structures have gone stale?
	 * 
	 * Note that this is just a simple yes/no, we could return fields indicating which structures
	 * were stale, or set this.stale ourselves.
	 * 
	 * The current implementation is to compare the feature against a list of attributes known to
	 * invalidate, and to assume all references invalidate. The reference part isn't actually true.
	 * We do it because when adding a PortConfig to a DB2System we were getting notifications for
	 * feature OsPackage.Literals.OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT instead of the
	 * expected CorePackage.Literals.UNIT__UNIT_LINKS_GROUP. It isn't clear what the problem is.
	 * Rather than 'blacklisting' certain EReferences a safe implementation would be to 'whitelist'
	 * EReferences like Unit.getCapabilities() which never change our data strcuture.
	 */
	private boolean changesRelationships(Notification notification) {

		Object feature = notification.getFeature();

		if (feature == null) {
			return false;
		}

//		System.out
//				.println("Feature=" + getFeatureName(feature) + "(eref=" + (feature instanceof EReference) + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		if (feature instanceof EReference) {
			return true;
		}

//		For dependency links, setting Requirement.link (EReference) 
//		if (feature == CorePackage.Literals.REQUIREMENT__LINK) {
//			return true;
//		}

		// If a unit link is being added or deleted
		if (feature == CorePackage.Literals.UNIT__UNIT_LINKS_GROUP) {
			return true;
		}

		// A link being re-targeted/sourced
		if (feature == CorePackage.Literals.DEPLOY_LINK__TARGET_URI) {
			return true;
		} else if (feature == CorePackage.Literals.DEPLOY_LINK__SOURCE_URI) {
			return true;
		}

//		 A realization link being added or deleted (EReference) 
//		if (feature == CorePackage.Literals.TOPOLOGY__REALIZATION_LINKS) {
//			return true;
//		}

		// An import-crossing link being added or deleted (TODO Make sure this is correct;
		// it could be that we need CorePackage.Literals.TOPOLOGY__UNIT_LINKS instead).
		if (feature == CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP) {
			return true;
		}

		// Imports (EReference) 
//		if (feature == CorePackage.Literals.TOPOLOGY__IMPORTS) {
//			return true;
//		}

		// Contract changed
		if (feature == CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP
				|| feature == CorePackage.Literals.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY
				|| feature == CorePackage.Literals.EXPLICIT_CONTRACT__DEFAULT_POLICY
		/* || feature == CorePackage.Literals.EXPLICIT_CONTRACT__EXPORTED_UNITS */) {
			return true;
		}

		if (feature == CorePackage.Literals.INSTANCE_CONFIGURATION__PUBLIC_UNITS) {
			return true;
		}

		// We aren't sure.
		return false;
	}

	/** @deprecated just for debugging */
	@Deprecated
	private String getFeatureName(Object feature) {
		if (feature == null) {
			return "<null>"; //$NON-NLS-1$
		}

		if (feature instanceof EStructuralFeature) {
			return ((EStructuralFeature) feature).getName();
		}

		return feature.getClass().getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getFirstHost(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Unit getFirstHost(Unit unit) {
		// A possible optimization is a Map<Unit,Unit> for this relationship, to avoid
		// the expense of collection lookup.
		List<Unit> hostsOfUnit = (List<Unit>) getHost(unit);
		return hostsOfUnit == null ? null : hostsOfUnit.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getHost(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<Unit> getHost(Unit hosted) {
		check();

		Collection<Unit> rv = hosts.get(hosted);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getHosted(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<Unit> getHosted(Unit host) {
		check();

		Collection<Unit> rv = hosted.get(host);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getContainer(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<Unit> getContainer(Unit member) {
		check();

		Collection<Unit> rv = containers.get(member);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getDependentRequirements(com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public Collection<Requirement> getDependentRequirements(Capability cap) {
		check();

		Collection<Requirement> reqs = dependsUpon.get(cap);
		if (reqs == null) {
			reqs = Collections.emptyList();
		}
		return reqs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getDependencyTargets(com.ibm.ccl.soa.deploy.core.Requirement)
	 */
	public Collection<Capability> getDependencyTargets(Requirement req) {
		check();

		Collection<Capability> rv = isDependedUpon.get(req);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getRealizes(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<DeployModelObject> getRealizes(DeployModelObject dmo) {
		check();

		Collection<DeployModelObject> rv = realizes.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getRealizedBy(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<DeployModelObject> getRealizedBy(DeployModelObject dmo) {
		check();

		Collection<DeployModelObject> rv = realizedBy.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	private void check() {
		if (stale) {
			// Peformance.  Rather than synching on every access, sync on a private object when stale=true
			synchronized (hosts) {
				if (stale) {
					// TODO consider creating a upToDate() method that merely updates
					// the maps based on exactly what was changed, rather than
					// rebuilding everything.  (To do this we probably need to save
					// all notifications that made our structure stale.)

					createInitialMaps();
				}
			}
		}
	}

	private void createInitialMaps() {
		multipleHostingFlag = false;
		hosts.clear();
		hosted.clear();
		containers.clear();
		members.clear();
		dependsUpon.clear();
		isDependedUpon.clear();
		realizedBy.clear();
		realizes.clear();
		constraintLinkSources.clear();
		constraintLinkTargets.clear();
		//
		hostsLinks.clear();
		hostedLinks.clear();
		containersLinks.clear();
		membersLinks.clear();
		dependsUponLinks.clear();
		isDependedUponLinks.clear();
		realizedByLinks.clear();
		realizesLinks.clear();
		constraintLinkSourcesLinks.clear();
		constraintLinkTargetsLinks.clear();
		artifactUnitMap.clear();
		//

		implicitRealizationLinkedObjects.clear();

		//		System.out.println("Link map creation."); //$NON-NLS-1$

		// Handle cross-import links
		for (Iterator<UnitLink> unitLinkIter = topologyImpl.findAllUnitLinks(); unitLinkIter
				.hasNext();) {
			addUnitLink(unitLinkIter.next());
		}

		for (Iterator<DependencyLink> depLinkIter = topologyImpl.findAllDependencyLinks(); depLinkIter
				.hasNext();) {
			addDependencyLink(depLinkIter.next());
		}

		for (Iterator<RealizationLink> realLinkIter = topologyImpl.findAllRealizationLinks(); realLinkIter
				.hasNext();) {
			addRealizationLink(realLinkIter.next());
		}

		for (Iterator<ConstraintLink> constraintLinkIter = topologyImpl.findAllConstraintLinks(); constraintLinkIter
				.hasNext();) {
			addConstraintLink(constraintLinkIter.next());
		}

		for (Iterator<Artifact> artifactsIter = topologyImpl.findAllArtifacts(); artifactsIter
				.hasNext();) {
			addArtifactUnit(artifactsIter.next());
		}

		// At this point we have the maps, but they aren't 'unmodifiable'.  Adding the unmodifiablility
		// wrapper slightly hurts performance (an extra Java class wraps the list) but keeps us safe
		// from rogue plugins.
		makeListsUnmodifiable(hosts);
		makeListsUnmodifiable(hosted);
		makeListsUnmodifiable(containers);
		makeListsUnmodifiable(members);
		makeListsUnmodifiable(dependsUpon);
		makeListsUnmodifiable(isDependedUpon);
		makeListsUnmodifiable(realizedBy);
		makeListsUnmodifiable(realizes);
		makeListsUnmodifiable(constraintLinkSources);
		makeListsUnmodifiable(constraintLinkTargets);

		// TODO other maps
		makeListsUnmodifiable(hostsLinks);
		makeListsUnmodifiable(hostedLinks);
		makeListsUnmodifiable(containersLinks);
		makeListsUnmodifiable(membersLinks);
		makeListsUnmodifiable(dependsUponLinks);
		makeListsUnmodifiable(isDependedUponLinks);
		makeListsUnmodifiable(realizedByLinks);
		makeListsUnmodifiable(realizesLinks);
		makeListsUnmodifiable(constraintLinkSourcesLinks);
		makeListsUnmodifiable(constraintLinkTargetsLinks);

		stale = false;
	}

	private void addArtifactUnit(Artifact artifact) {
		Object obj = null;
		if (artifact instanceof FileArtifact) {
			FileArtifact fileArtifact = (FileArtifact) artifact;
			obj = fileArtifact.getKey();
		} else {
			obj = artifact;
		}
		if (artifactUnitMap.get(obj) != null) {
			return;
		}
		Unit unit = ValidatorUtils.getUnit(artifact);
		if (unit == null) {
			return;
		}
		artifactUnitMap.put(obj, unit);

	}

	private void makeListsUnmodifiable(Map map) {
		for (Iterator<Map.Entry> meIter = map.entrySet().iterator(); meIter.hasNext();) {
			Map.Entry me = meIter.next();
			me.setValue(Collections.unmodifiableList((List) me.getValue()));
		}
	}

	private void addUnitLink(UnitLink ul) {
		if (ul instanceof MemberLink) {
			addMemberLink(ul.getSource(), ul.getTarget(), (MemberLink) ul);
		} else if (ul instanceof HostingLink) {
			addHostingLink(ul.getSource(), ul.getTarget(), (HostingLink) ul);
		}
	}

	private void addHostingLink(Unit host, Unit hostee, HostingLink hl) {
		// We could just call add() but I want to detect the problem for a possible
		// future optimization.
		if (host != null && hostee != null) {
			List<Unit> mem = hosts.get(hostee);
			if (mem == null) {
				mem = new ArrayList<Unit>();
				hosts.put(hostee, mem);
			} else {
				multipleHostingFlag = true;
			}
			mem.add(host);

			add(hosted, host, hostee);
		}

		if (hostee != null) {
			add(hostsLinks, hostee, hl);
		}
		if (host != null) {
			add(hostedLinks, host, hl);
		}
	}

	private void addMemberLink(Unit container, Unit member, MemberLink ml) {
		if (member != null && container != null) {
			add(containers, member, container);
			add(members, container, member);
		}

		if (member != null) {
			add(containersLinks, member, ml);
		}
		if (container != null) {
			add(membersLinks, container, ml);
		}
	}

	private void addDependencyLink(DependencyLink depLink) {
		Requirement sourceReq = depLink.getSource();
		if (sourceReq == null) {
			if (depLink.getParent() instanceof Requirement) {
				sourceReq = (Requirement) depLink.getParent();
			}
		}
		Capability targetCap = depLink.getTarget();

		if (sourceReq != null && targetCap != null) {
			add(isDependedUpon, sourceReq, targetCap);
			add(dependsUpon, targetCap, sourceReq);
		}
		if (sourceReq != null) {
			add(isDependedUponLinks, sourceReq, depLink);
		}
		if (targetCap != null) {
			add(dependsUponLinks, targetCap, depLink);
		}
	}

	private void addRealizationLink(RealizationLink rl) {
		DeployModelObject realizationSource = rl.getSource();
		DeployModelObject realizationTarget = rl.getTarget();

		if (realizationSource != null && realizationTarget != null) {
			add(realizedBy, realizationSource, realizationTarget);
			add(realizes, realizationTarget, realizationSource);
		}

		if (realizationSource != null) {
			add(realizedByLinks, realizationSource, rl);
		}
		if (realizationTarget != null) {
			add(realizesLinks, realizationTarget, rl);
		}
	}

	private void addConstraintLink(ConstraintLink cl) {
		DeployModelObject constraintLinkSource = cl.getSource();
		DeployModelObject constraintLinkTarget = cl.getTarget();

		if (constraintLinkSource != null && constraintLinkTarget != null) {
			add(constraintLinkTargets, constraintLinkSource, constraintLinkTarget);
			add(constraintLinkSources, constraintLinkTarget, constraintLinkSource);
		}

		if (constraintLinkSource != null) {
			add(constraintLinkTargetsLinks, constraintLinkSource, cl);
		}
		if (constraintLinkTarget != null) {
			add(constraintLinkSourcesLinks, constraintLinkTarget, cl);
		}
	}

	private void add(Map<Unit, List<HostingLink>> map, Unit key, HostingLink valueToBeAddedToList) {
		assert key != null;
		List<HostingLink> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<HostingLink>(1);
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<Unit, List<MemberLink>> map, Unit key, MemberLink valueToBeAddedToList) {
		assert key != null;
		List<MemberLink> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<MemberLink>(1);
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<Unit, List<Unit>> map, Unit key, Unit valueToBeAddedToList) {
		assert key != null;
		List<Unit> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<Unit>(1);
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<Requirement, List<Capability>> map, Requirement key,
			Capability valueToBeAddedToList) {
		assert key != null;
		List<Capability> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<Capability>();
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<Requirement, List<DependencyLink>> map, Requirement key,
			DependencyLink valueToBeAddedToList) {
		assert key != null;
		List<DependencyLink> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<DependencyLink>();
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<Capability, List<Requirement>> map, Capability key,
			Requirement valueToBeAddedToList) {
		assert key != null;
		List<Requirement> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<Requirement>();
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<Capability, List<DependencyLink>> map, Capability key,
			DependencyLink valueToBeAddedToList) {
		assert key != null;
		List<DependencyLink> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<DependencyLink>();
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<DeployModelObject, List<DeployModelObject>> map, DeployModelObject key,
			DeployModelObject valueToBeAddedToList) {
		assert key != null;
		List<DeployModelObject> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<DeployModelObject>(1);
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<DeployModelObject, List<RealizationLink>> map, DeployModelObject key,
			RealizationLink valueToBeAddedToList) {
		assert key != null;
		List<RealizationLink> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<RealizationLink>(1);
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	private void add(Map<DeployModelObject, List<ConstraintLink>> map, DeployModelObject key,
			ConstraintLink valueToBeAddedToList) {
		assert key != null;
		List<ConstraintLink> cont = map.get(key);
		if (cont == null) {
			cont = new ArrayList<ConstraintLink>(1);
			map.put(key, cont);
		}
		cont.add(valueToBeAddedToList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getContainerLinks(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<MemberLink> getContainerLinks(Unit member) {
		check();

		Collection<MemberLink> rv = containersLinks.get(member);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getDependencyTargetsLinks(com.ibm.ccl.soa.deploy.core.Requirement)
	 */
	public Collection<DependencyLink> getDependencyTargetsLinks(Requirement req) {
		check();

		Collection<DependencyLink> rv = isDependedUponLinks.get(req);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getDependentRequirementsLinks(com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public Collection<DependencyLink> getDependentRequirementsLinks(Capability cap) {
		check();

		Collection<DependencyLink> rv = dependsUponLinks.get(cap);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getHostLinks(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<HostingLink> getHostLinks(Unit hostedUnit) {
		check();

		Collection<HostingLink> rv = hostsLinks.get(hostedUnit);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getHostedLinks(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<HostingLink> getHostedLinks(Unit host) {
		check();

		Collection<HostingLink> rv = hostedLinks.get(host);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getMembers(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<Unit> getMembers(Unit container) {
		check();

		Collection<Unit> rv = members.get(container);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getMembersLinks(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Collection<MemberLink> getMembersLinks(Unit container) {
		check();

		Collection<MemberLink> rv = membersLinks.get(container);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getRealizedByLinks(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<RealizationLink> getRealizedByLinks(DeployModelObject dmo) {
		check();

		Collection<RealizationLink> rv = realizedByLinks.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getRealizesLinks(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<RealizationLink> getRealizesLinks(DeployModelObject dmo) {
		check();

		Collection<RealizationLink> rv = realizesLinks.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getAllImplicitRealizationLinkedObjects(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<DeployModelObject> getAllImplicitRealizationLinkedObjects(DeployModelObject dmo) {
		check();

		synchronized (implicitRealizationLinkedObjects) {
			Set<DeployModelObject> rv = implicitRealizationLinkedObjects.get(dmo);
			if (rv == null) {
				rv = RealizationLinkUtil.computeAllImplicitRealizationLinkedObjects(dmo);
				Set<DeployModelObject> urv = Collections.unmodifiableSet(rv);
				for (DeployModelObject o : urv) {
					implicitRealizationLinkedObjects.put(o, urv);
				}
				return urv;
			}
			return rv;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getConstraintLinkSources(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<DeployModelObject> getConstraintLinkSources(DeployModelObject dmo) {
		check();

		Collection<DeployModelObject> rv = constraintLinkSources.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getConstraintLinkSourcesLinks(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<ConstraintLink> getConstraintLinkSourcesLinks(DeployModelObject dmo) {
		check();

		Collection<ConstraintLink> rv = constraintLinkSourcesLinks.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getConstraintLinkTargetLinks(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<ConstraintLink> getConstraintLinkTargetsLinks(DeployModelObject dmo) {
		check();

		Collection<ConstraintLink> rv = constraintLinkTargetsLinks.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getConstraintLinkTargets(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public Collection<DeployModelObject> getConstraintLinkTargets(DeployModelObject dmo) {
		check();

		Collection<DeployModelObject> rv = constraintLinkTargets.get(dmo);
		if (rv == null) {
			rv = Collections.emptyList();
		}
		return rv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.IRelationshipChecker#getUnit(com.ibm.ccl.soa.deploy.core.Artifact)
	 */
	public Unit getUnit(Artifact artifact) {
		check();
		Unit unit = artifactUnitMap.get(artifact);
		return unit;
	}
}