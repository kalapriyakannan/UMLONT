/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core;

import java.util.Collection;

/**
 * @since 7.0
 * 
 */
public interface IRelationshipChecker {
	/**
	 * This API will return a Collection of {@link Unit} instances which host the passed unit. The
	 * scope is the passed Unit's edit topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned collection there will be a {@link HostingLink} which has the
	 * passed unit as the hosted target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param hosted -
	 *           The {@link Unit} which is being hosted.
	 * @return Collection of {@link Unit} of the hosts for the passed unit.
	 */
	Collection<Unit> getHost(Unit hosted);

	/**
	 * This API will return a {@link Unit} instance which hosts the passed unit. The scope is the
	 * passed Unit's edit topology and its imported topologies.
	 * 
	 * <p>
	 * This method will return null if the unit has no host. If the unit has more than one host, one
	 * will be returned.
	 * </p>
	 * 
	 * @param hosted -
	 *           The {@link Unit} which is being hosted.
	 * @return A {@link Unit} which is a host for the passed unit, or null
	 */
	Unit getFirstHost(Unit hosted);

	/**
	 * This API will return a Collection of {@link HostingLink} instances from hosts of the passed
	 * unit. The scope is the passed Unit's edit topology and its imported topologies.
	 * 
	 * <p>
	 * Each {@link HostingLink} in the returned collection has the passed unit as the hosted target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param hosted -
	 *           The {@link Unit} which is being hosted.
	 * @return Collection of {@link HostingLink}s from hosts of the passed unit.
	 */
	Collection<HostingLink> getHostLinks(Unit hosted);

	/**
	 * This API will return a Collection of {@link Unit} instances which are hosted by the passed
	 * unit. The scope is the passed Unit's edit topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned collection there will be a {@link HostingLink} which has the
	 * passed unit as the hosting source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param host -
	 *           The {@link Unit} which is the host.
	 * @return Collection of {@link Unit} of the units hosted by the passed unit.
	 */
	Collection<Unit> getHosted(Unit host);

	/**
	 * This API will return a Collection of {@link HostingLink} instances from the host to hosted
	 * units. The scope is the passed Unit's edit topology and its imported topologies.
	 * 
	 * <p>
	 * Each {@link HostingLink} in the returned collection has the passed unit as the hosting source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param host -
	 *           The {@link Unit} which is the host.
	 * @return Collection of {@link HostingLink}s from the host to hosted units.
	 */
	Collection<HostingLink> getHostedLinks(Unit host);

	/**
	 * This API will return a Collection of {@link Unit} instances which consider the passed unit a
	 * member of their relationships. The scope is the passed Unit's edit topology and its imported
	 * topologies.
	 * 
	 * <p>
	 * For each element in the returned Collection there will be a {@link MemberLink} which has the
	 * passed unit as the member target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param member -
	 *           The {@link Unit} which might be a member of some other Unit.
	 * @return Collection of {@link Unit} of the member link owner for the passed unit.
	 */
	Collection<Unit> getContainer(Unit member);

	/**
	 * This API will return a Collection of {@link MemberLink} instances sourced by units which
	 * consider the passed unit a member of their relationships. The scope is the passed Unit's edit
	 * topology and its imported topologies.
	 * 
	 * <p>
	 * For each {@link MemberLink} in the returned Collection, the link will have the passed unit as
	 * the member target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param member -
	 *           The {@link Unit} which might be a member of some other Unit.
	 * @return Collection of {@link MemberLink} of the member links which target the passed unit.
	 */
	Collection<MemberLink> getContainerLinks(Unit member);

	/**
	 * This API will return a Collection of {@link Unit} instances which are members of the container
	 * unit The scope is the passed Unit's edit topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned Collection there will be a {@link MemberLink} which has the
	 * passed unit as the container source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param container -
	 *           The {@link Unit} which might be a container of other Units.
	 * @return Collection of {@link Unit} of the member links for the passed unit.
	 */
	Collection<Unit> getMembers(Unit container);

	/**
	 * This API will return a Collection of {@link MemberLink} instances targeted at units which the
	 * passed container unit contains. The scope is the passed Unit's edit topology and its imported
	 * topologies.
	 * 
	 * <p>
	 * For each {@link MemberLink} in the returned Collection, the link will have the passed unit as
	 * the container source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param container -
	 *           The {@link Unit} which might be a container of some other Units.
	 * @return Collection of {@link MemberLink} of the member links which are sourced by the passed
	 *         unit.
	 */
	Collection<MemberLink> getMembersLinks(Unit container);

	/**
	 * Finds all {@link Requirement} instances for which {@link Requirement#getLink()} has the
	 * capability argument as a target ({@link DependencyLink#getTarget()}). The scope is the
	 * passed Capability's edit topology and its imported topologies.
	 * 
	 * @param cap
	 *           a capability.
	 * @return a Collection of requirements, never null.
	 */
	Collection<Requirement> getDependentRequirements(Capability cap);

	/**
	 * Finds all {@link DependencyLink} instances which have the capability argument as the ({@link DependencyLink#getTarget()}).
	 * The scope is the passed Capability's topology and its imported topologies.
	 * 
	 * @param cap
	 *           a capability.
	 * @return a Collection of DependencyLink, never null.
	 */
	Collection<DependencyLink> getDependentRequirementsLinks(Capability cap);

	/**
	 * Finds all {@link Capability} instances which the requirement argument has as a target. The
	 * scope is the passed Requirement's edit topology and its imported topologies.
	 * 
	 * @param req
	 *           a requirement
	 * @return a Collection of capabilities, never null.
	 */
	Collection<Capability> getDependencyTargets(Requirement req);

	/**
	 * Finds all {@link DependencyLink} instances which the requirement argument has as a source. The
	 * scope is the passed Requirement's topology and its imported topologies.
	 * 
	 * @param req
	 *           a requirement
	 * @return a Collection of DependencyLinks, never null.
	 */
	Collection<DependencyLink> getDependencyTargetsLinks(Requirement req);

	/**
	 * This API will return a Collection of {@link DeployModelObject} instances which are directly
	 * realized by the passed deploy model object. The scope is the passed DeployModelObject's edit
	 * topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned Collection there will be a {@link RealizationLink} which has
	 * the passed {@link DeployModelObject} as the realization target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be a realization of some other
	 *           {@link DeployModelObject}.
	 * @return Collection of {@link DeployModelObject} of the realization link sources for the passed
	 *         {@link DeployModelObject}.
	 */
	Collection<DeployModelObject> getRealizes(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link RealizationLink} instances which target the passed
	 * deploy model object. The scope is the passed DeployModelObjects's edit topology and its
	 * imported topologies.
	 * 
	 * <p>
	 * Each {@link RealizationLink} in the returned Collection will have the the passed
	 * {@link DeployModelObject} as the realization target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be a realization of some other
	 *           {@link DeployModelObject}.
	 * @return Collection of {@link RealizationLink} from realized {@link DeployModelObject}s to the
	 *         passed {@link DeployModelObject}.
	 */
	Collection<RealizationLink> getRealizesLinks(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link DeployModelObject} instances which are the
	 * realizations of the passed deploy model object. The scope is the passed DeployModelObject's
	 * edit topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned Collection there will be a {@link RealizationLink} which has
	 * the passed {@link DeployModelObject} as the realization source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be realized by some other deploy model
	 *           objects.
	 * @return A Collection of {@link DeployModelObject} of the realization link targets for the
	 *         passed deploy model object.
	 */
	Collection<DeployModelObject> getRealizedBy(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link RealizationLink} which have the passed deploy
	 * model object as the source. The scope is the passed DeployModelObject's edit topology and its
	 * imported topologies.
	 * 
	 * <p>
	 * Each {@link RealizationLink} in the collection will have the passed deploy model object as the
	 * realization source, and may have a realization target dmo that realizes the passed dmo.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null;
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be realized by some other deploy model
	 *           object.
	 * @return A Collection of {@link RealizationLink} which target realizations of the passed deploy
	 *         model object.
	 */
	Collection<RealizationLink> getRealizedByLinks(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link DeployModelObject} instances which are the source
	 * of a {@link ConstraintLink} with parameter {@link DeployModelObject} as the link target. The
	 * scope is the parameter {@link DeployModelObject}'s edit topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned Collection there will be a {@link ConstraintLink} which has
	 * the passed {@DeployModelObject} as the link target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be the target of {@link ConstraintLink}s.
	 * @return Collection of {@link DeployModelObject} sources of the {@link ConstraintLink}s that
	 *         target the parameter {@link DeployModelObject}.
	 */
	Collection<DeployModelObject> getConstraintLinkSources(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link ConstraintLink} instances which target the
	 * parameter {@link DeployModelObject}. The scope is the parameter {@link DeployModelObject}'s
	 * edit topology and its imported topologies.
	 * 
	 * <p>
	 * Each {@link ConstraintLink} in the returned Collection will have the parameter
	 * {@link DeployModelObject} as its target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be the target of {@link ConstraintLink}s.
	 * @return Collection of {@link ConstraintLink} which target the parameter
	 *         {@link DeployModelObject}.
	 */
	Collection<ConstraintLink> getConstraintLinkSourcesLinks(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link DeployModelObject} instances which are the target
	 * of a {@link ConstraintLink} from the parameter {@link DeployModelObject}. The scope is the
	 * parameter {@link DeployModelObject}'s edit topology and its imported topologies.
	 * 
	 * <p>
	 * For each element in the returned Collection there will be a {@link ConstraintLink} which has
	 * the parameter {@link DeployModelObject} as the link source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which might be the source of {@link ConstraintLink}s
	 *           targeting some other {@link DeployModelObject}s.
	 * @return A Collection of {@link DeployModelObject} of the {@link ConstraintLink} targets for
	 *         the parameter {@link DeployModelObject}.
	 */
	Collection<DeployModelObject> getConstraintLinkTargets(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link ConstraintLink} which have the passed
	 * {@link DeployModelObject} as the source. The scope is the parameter {@link DeployModelObject}'s
	 * edit topology and its imported topologies.
	 * 
	 * <p>
	 * Each {@link ConstraintLink} in the collection will have the parameter
	 * {@link DeployModelObject} as the constraint link source.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null;
	 * </p>
	 * 
	 * @param dmo -
	 *           The {@link DeployModelObject} which be the source of {@link ConstraintLink}s
	 *           targeting some other {@link DeployModelObject}s.
	 * @return A Collection of {@link ConstraintLink} which have the parameter
	 *         {@link DeployModelObject} as the constraint link source.
	 */
	Collection<ConstraintLink> getConstraintLinkTargetsLinks(DeployModelObject dmo);

	/**
	 * This API will return a Collection of {@link DeployModelObject}s that explicitly or implicitly
	 * realized or are realized by (directly or indirectly) the parameter. The scope is the passed
	 * DeployModelObject's edit topology and its imported topologies.
	 * <p>
	 * No checks are made on the validity of the realization link endpoints(type, isConceptual(),
	 * etc.).
	 * </p>
	 * <p>
	 * This method will not return null;
	 * </p>
	 * 
	 * @param dmo -
	 *           A {@link DeployModelObject} source or target of one or more realization link.
	 * @return A Collection of {@link DeployModelObject} of the transitive closure of objects
	 *         reachable in either direction of realization links to and from the unit (including the
	 *         object parameter; hence the list is never empty).
	 */
	Collection<DeployModelObject> getAllImplicitRealizationLinkedObjects(DeployModelObject dmo);

	/**
	 * This API will return a Unit for a given Artifact.
	 * </p>
	 * <p>
	 * This method will not return null;
	 * </p>
	 * 
	 * @param artifact -
	 *           Artifact for a given unit.
	 * @return Matching unit that satisfies the Artifacts equal and hashcode requirements.
	 */
	public Unit getUnit(Artifact artifact);
}
