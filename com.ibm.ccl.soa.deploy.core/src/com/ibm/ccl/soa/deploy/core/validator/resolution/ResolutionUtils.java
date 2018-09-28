/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jem.util.plugin.JEMUtilPlugin;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.pattern.IUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployStatusCollector;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidationContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.SetAllAttributesInUnitResolution;

/**
 * Utility methods to support resolution.
 */
public class ResolutionUtils {

	private static DeployValidatorService dvs = DeployValidatorService
			.getOrCreateValidatorService("com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils"); //$NON-NLS-1$

	/**
	 * Create a service link between the services of two units.
	 * 
	 * @param context
	 *           the resolution context
	 * @param source
	 *           the source unit
	 * @param sourceType
	 *           the type of the source service consumed by the source unit
	 * @param target
	 *           the target unit
	 * @param targetType
	 *           the type of the target service provided by the target unit
	 * @return the service link created or null if single source and target services cannot be
	 *         identified
	 */
	public static DependencyLink link(IDeployResolutionContext context, Unit source,
			EClass sourceType, Unit target, EClass targetType) {
		if (null == source || null == target) {
			return null;
		}

		// // TODO handle links across topologies (future)
		// if (source.getTopology() != target.getTopology())
		// return null;

		Requirement sourceRequirement = ValidatorUtils.getFirstRequirement(source, sourceType);
		if (null == sourceRequirement) {
			return null;
		}

		Capability targetCapability = ValidatorUtils.getFirstCapability(target, targetType);
		if (null == targetCapability) {
			return null;
		}

		// attempt to use a domain specific creation method if one exists
		LinkDescriptor[] descriptors = dvs.getPossibleLinks(source, sourceRequirement, target,
				targetCapability, LinkType.DEPENDENCY_SET);
		if (descriptors.length == 1) {
			return (DependencyLink) descriptors[0].create();
		}

		// otherwise use default creation
		return LinkFactory.createDependencyLink(source, sourceRequirement, target, targetCapability);
	}

	/**
	 * Create a dependency link between a requirement and a capability of two units.
	 * 
	 * @param context
	 *           the resolution context
	 * @param sourceRequirement
	 *           the source service
	 * @param target
	 *           the target unit
	 * @param targetType
	 *           the type of the target service provided by the target unit
	 * @return the service link created or null if single source and target services cannot be
	 *         identified
	 */
	public static DependencyLink link(IDeployResolutionContext context,
			Requirement sourceRequirement, Unit target, EClass targetType) {
		if (null == sourceRequirement || null == target) {
			return null;
		}

		Capability targetCapability = ValidatorUtils.getFirstCapability(target, targetType);
		if (null == targetCapability) {
			return null;
		}

		Unit sourceUnit = ValidatorUtils.getOwningUnit(sourceRequirement);
		// attempt to use a domain specific creation method if one exists
		LinkDescriptor[] descriptors = dvs.getPossibleLinks(sourceUnit, sourceRequirement, target,
				targetCapability, LinkType.DEPENDENCY_SET);
		if (descriptors.length == 1) {
			return (DependencyLink) descriptors[0].create();
		}

		// otherwise use default creation
		DependencyLink link = LinkFactory.createDependencyLink(sourceUnit, sourceRequirement, target,
				targetCapability);
		return link;
	}

	/**
	 * Create a dependency link between a requirement and a capability.
	 * 
	 * @param context
	 *           the resolution context
	 * @param sourceRequirement
	 *           the source service
	 * @param targetCapability
	 *           the target service
	 * @return the service link created or null if single source and target services cannot be
	 *         identified
	 */
	public static DependencyLink link(IDeployResolutionContext context,
			Requirement sourceRequirement, Capability targetCapability) {
		if (null == sourceRequirement || null == targetCapability) {
			return null;
		}

		// // TODO handle links across topologies (future)
		// if (sourceRequirement.getTopology() !=
		// targetCapability.getTopology())
		// return null;

		Unit sourceUnit = ValidatorUtils.getOwningUnit(sourceRequirement);
		Unit targetUnit = ValidatorUtils.getOwningUnit(targetCapability);
		// attempt to use a domain specific creation method if one exists
		LinkDescriptor[] descriptors = dvs.getPossibleLinks(sourceUnit, sourceRequirement,
				targetUnit, targetCapability, LinkType.DEPENDENCY_SET);
		if (descriptors.length == 1) {
			return (DependencyLink) descriptors[0].create();
		}

		// otherwise use default creation
		return LinkFactory.createDependencyLink(sourceUnit, sourceRequirement, targetUnit,
				targetCapability);
	}

	/**
	 * Delete a service link.
	 * 
	 * @param context
	 *           the resolution context
	 * @param link
	 *           the service link to remove
	 */
	public static void unlink(IDeployResolutionContext context, DependencyLink link) {
		if (null == link) {
			return;
		}
		EcoreUtil.remove(link);
	}

	/**
	 * Delete a service link.
	 * 
	 * @param context
	 *           the resolution context
	 * @param sourceCapability
	 *           the source service containing the link to be removed
	 */
	public static void unlink(IDeployResolutionContext context, Requirement sourceCapability) {
		if (null == sourceCapability) {
			return;
		}
		DependencyLink link = sourceCapability.getLink();
		if (null == link) {
			return;
		}
		unlink(context, link);
	}

	/**
	 * Host one unit on another.
	 * 
	 * @param context
	 *           the resolution context
	 * @param hoster
	 *           the hoster
	 * @param hostee
	 *           the hostee
	 * @return the hosting link created
	 */
	public static HostingLink hosts(IDeployResolutionContext context, Unit hoster, Unit hostee) {
		if (null == hoster || null == hostee) {
			return null;
		}
		if (hoster == hostee) {
			return null;
		}

		// // TODO handle links across topologies (future)
		// if (hoster.getTopology() != hostee.getTopology())
		// return null;

		// if already hosted will reshost
		// // test if hostee already hosted
		// if (null != ValidatorUtils.getHost(hostee))
		// return null;

		// attempt to use a domain specific creation method if one exists
		LinkDescriptor[] descriptors = dvs.getPossibleLinks(hoster, hostee, LinkType.HOSTING_SET);
		if (descriptors.length == 1) {
			return (HostingLink) descriptors[0].create();
		}

		// otherwise use default creation
		return LinkFactory.createHostingLink(hoster, hostee);
	}

	/**
	 * Remove a hosting link Note: currently only used to destroy a logical hosting link from db2
	 * database to db2 system
	 * 
	 * @param context
	 *           the resolution context
	 * @param hoster
	 *           the hoster unit
	 * @param hostee
	 *           the hosted unit
	 */
	public static void unhost(IDeployResolutionContext context, Unit hoster, Unit hostee) {
		if (null == hoster || null == hostee) {
			return;
		}

		ArrayList links = new ArrayList();
		// model allows for multiple; we expect 1 or 0
		List hLinks = hoster.getHostingLinks();
		for (Iterator iter = hLinks.iterator(); iter.hasNext();) {
			HostingLink link = (HostingLink) iter.next();
			if (link.getTarget() == hostee) {
				links.add(link);
			}
		}
		for (int i = 0; i < links.size(); i++) {
			unhost(context, (HostingLink) links.get(i));
		}
	}

	/**
	 * Remove a hosting link.
	 * 
	 * @param context
	 *           the resolution context
	 * @param link
	 *           the hosting link to remove
	 */
	public static void unhost(IDeployResolutionContext context, HostingLink link) {
		if (null == link) {
			return;
		}
		EcoreUtil.remove(link);
	}

	/**
	 * Add member unit to the group unit
	 * 
	 * @param context
	 *           the resolution context
	 * @param group
	 *           the group unit
	 * @param member
	 *           the member unit
	 * @return the member link created
	 */
	public static MemberLink addMember(IDeployResolutionContext context, Unit group, Unit member) {
		if (null == group || null == member) {
			return null;
		}
		if (group == member) {
			return null;
		}

		// TODO handle links across topologies (future)
		if (group.getTopology() != member.getTopology()) {
			return null;
		}

		// test if membership is allowed and
//		DeployValidatorService dvs = new DeployValidatorService();
//		if (!dvs.canCreateLink(group, member, LinkType.MEMBER_SET).isOK()) {
//			return null;
//		}
		// attempt to use a domain specific creation method if one exists
		LinkDescriptor[] descriptors = dvs.getPossibleLinks(group, member, LinkType.MEMBER_SET);
		if (descriptors.length == 0) {
			return null;
		}
		if (descriptors.length == 1) {
			return (MemberLink) descriptors[0].create();
		}

		// otherwise use default creation
		// create the link
		return LinkFactory.createMemberLink(group, member);
	}

	public static DeployModelObject addFromTemplateURI(String templateURIString, Topology topology) {
		DeployModelObject unit = doDefaultElementCreation(templateURIString, topology);
		if (null != unit) {
			if (unit instanceof Unit) {
				topology.getUnits().add(unit);
			} else if (unit instanceof Import) {
				topology.getImports().add(unit);
			}
		}
		return unit;
	}

	/**
	 * Copy the contents of a template into a topology.
	 * 
	 * @param context
	 *           the resolution context
	 * @param typeId
	 *           the id of the template to copy
	 * @param topology
	 *           the target topology
	 * @return the object created in the topology
	 */
	public static DeployModelObject addFromTemplate(String typeId, Topology topology) {
		// TODO search for usages of this if/when the resourceType id is changed

		String templateURIString = getTemplateURIString(typeId);
		return addFromTemplateURI(templateURIString, topology);
//		DeployModelObject unit = createFromTemplate(typeId, topology);
//		if (null != unit) {
//			if (unit instanceof Unit) {
//				topology.getUnits().add(unit);
//			} else if (unit instanceof Import) {
//				topology.getImports().add(unit);
//			}
//		}
//		return unit;
	}

	/**
	 * Create a unit using the template for an existing topology.
	 * 
	 * @param typeId
	 *           the id of the template to copy
	 * @param topology
	 *           the target topology
	 * @return the object created using the topology
	 */
	public static DeployModelObject createFromTemplate(String typeId, Topology topology) {

//		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
//
//		String templateURIString = rts.getTemplateURI(typeId);
//
//		// TODO remove this after all domains use ResourceType registry, 
//		// or RTService can parse GMF extension points for loading
//		if (templateURIString == null) {
//			// only if type not found in RTService, then look for element type		
//			IElementType elementType = ElementTypeRegistry.getInstance().getType(typeId);
//			if (elementType == null) {
//				throw new IllegalArgumentException(typeId);
//			}
//			templateURIString = getTemplateURI(elementType);
//		}

		String templateURIString = getTemplateURIString(typeId);
		return ResolutionUtils.doDefaultElementCreation(templateURIString, topology);
	}

	private static String getTemplateURIString(String typeId) {
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();

		return rts.getTemplateURI(typeId);
	}

	/**
	 * Create and the units in the template to the topology, and return the annotated Unit from the
	 * list of created units.
	 * 
	 * <p>
	 * One reason for the annotation is to allow resolutions to cast the results of the addition to a
	 * particular Unit type.
	 * 
	 * @param templateURIString
	 * @param container
	 * @return the EObject for the ui element or null
	 */
	public static DeployModelObject doDefaultElementCreation(String templateURIString,
			Topology container) {

		if (templateURIString != null) {
			// Load the template file using the scribbler.
			URI templateURI = URI.createURI(templateURIString);
			Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(templateURI, true);

			if (resource != null) {
				DeployCoreRoot root = null;
				if (resource.getContents() != null && !resource.getContents().isEmpty()) {
					root = (DeployCoreRoot) resource.getContents().get(0);
				}
				if (root != null) {
					Topology topology = root.getTopology();
					// The return value includes both Units and Imports
//					Collection<DeployModelObject> createdUnits = doElementCreation(topology, container,
//							true);
					Map<DeployModelObject, DeployModelObject> createdDMOs = doElementCreation(topology,
							container, true);
					if (createdDMOs != null) {
						DeployModelObject retVal = null;
						String rootUnitName = getFirstTopologyRoot(topology);
						for (Iterator<DeployModelObject> it = createdDMOs.keySet().iterator(); it
								.hasNext();) {
							DeployModelObject candidate = it.next();
							if (rootUnitName != null && rootUnitName.equals(candidate.getName())) {
//								retVal = candidate;
								retVal = createdDMOs.get(candidate);
							}
						}
						if (retVal == null) {
							if (rootUnitName == null && createdDMOs.size() > 1) {
								// TWarning, no annotation to indicate which
								// unit to return
								// only log error if not a user template?
								IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
								if (!rts.isDynamicPaletteEntry(topology)) {
									DeployCorePlugin.log(IStatus.WARNING, 0,
											"No <core:annotation> in " + templateURI, null); //$NON-NLS-1$
								}
							} else if (rootUnitName != null) {
								// Error, annotation name doesn't match any Unit
								// in template
								DeployCorePlugin
										.logError(0, "No <core:annotation> in " + templateURI, null); //$NON-NLS-1$
							}

							// Return first unit
							if (createdDMOs.size() == 0) {
								return null;
							}
							retVal = createdDMOs.values().iterator().next();
						} // endif no Unit matches a topology_root
						// core:annotation

						return retVal;

					} // endif units were created?
				} // endif template contains a DeployCoreRoot
			} // endif template exists
		} // endif elementType has a templateURI associated

		return null;
	}

	/**
	 * Used to create elements in diagram from palette.
	 * 
	 * @param templateURIString
	 * @param container
	 * @param isDynamic
	 * @return all of the created objects
	 */
	public static Collection<DeployModelObject> doRealElementCreation(String templateURIString,
			Topology container, boolean isDynamic) {

		if (templateURIString != null) {
			// Load the template file using the scribbler.
			URI templateURI = URI.createURI(templateURIString);
			Resource resource = JEMUtilPlugin.getPluginResourceSet().getResource(templateURI, true);
			// Adding this to support modified user templates
			// Post M6 - a better way to manage the resources

			//Need a better way to manage stale dynamic types.
			if (Platform.inDebugMode() || isDynamic) {
				if (resource.isLoaded()) {
					resource.unload();
				}
			}
			try {
				if (!resource.isLoaded()) {
					resource.load(Collections.emptyMap());
				}
			} catch (IOException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			} finally {
				resource.setModified(false);
			}
			// End resource load fix

			if (resource != null) {
				DeployCoreRoot root = null;
				if (resource.getContents() != null && !resource.getContents().isEmpty()) {
					root = (DeployCoreRoot) resource.getContents().get(0);
				}
				if (root != null) {
					Topology topology = root.getTopology();
					// create new units from template and make their names
					// unique
					Collection<DeployModelObject> createdUnits = doElementCreation(topology, container,
							true).values();
					return createdUnits;
				}
			} // endif template exists
		} // endif elementType has a templateURI associated
		return null;
	}

	/**
	 * Return the Unit name/anchor for the Unit specified by the &lt;core:annotation
	 * context=&quot;topology_root&quot;&gt; (the &lt;core:detail value=/&gt;).
	 * 
	 * <p>
	 * This name can be used to look up the 'root' or most important Unit in a .template.
	 * 
	 * @param topology
	 *           the topology input
	 * @return the topology root unit name
	 */
	public static String getFirstTopologyRoot(Topology topology) {
		Collection<?> roots = getTopologyRoots(topology);
		if (roots != null && roots.size() > 0) {
			return (String) roots.iterator().next();
		}
		return null;
	}

	/**
	 * Return the {@link Annotation} details values for the &lt;core:annotation
	 * context=&quot;topology_root&quot;&gt;. These contexts are used to indicate that one Unit is to
	 * be considered the 'root' or most important Unit in a Topology.
	 * 
	 * @param topology
	 *           the topology input
	 * @return the list of topology root unit names
	 */
	public static Collection<?> getTopologyRoots(Topology topology) {
		Annotation annotation = topology.findAnnotation(IAnnotationConstants.TOPOLOGY_ROOT);
		if (annotation != null) {
			return annotation.getDetails().values();
		}
		return null;
	}

	/**
	 * Duplicate the Units in the 'topFrom' Topology and add them to 'topTo'.
	 */
	private static Map<DeployModelObject, DeployModelObject> doElementCreation(Topology topFrom,
			Topology topTo, boolean makeNameUnique) {
//		Collection<DeployModelObject> retVal = new ArrayList<DeployModelObject>();
		Map<DeployModelObject, DeployModelObject> retVal = new HashMap<DeployModelObject, DeployModelObject>();
//		Collection<Unit> unitCopies = intelligentDeepCopy(topFrom.getUnits(), topTo, makeNameUnique);
		Map<Unit, Unit> unitCopies = intelligentDeepCopyMap(topFrom.getUnits(), topTo, makeNameUnique);

		// Since were casting getElementToEdit() to Topology we might as well
		// assume getContainmentFeature() is Topology.unit
		for (Iterator<Map.Entry<Unit, Unit>> it = unitCopies.entrySet().iterator(); it.hasNext();) {
//			Unit object = it.next();
			Map.Entry<Unit, Unit> entry = it.next();
			topTo.getUnits().add(entry.getValue());
//			retVal.add(entry);
		}

		retVal.putAll(unitCopies);

//		Collection<Import> importCopies = duplicateImports(topFrom.getImports(), topTo,
//				makeNameUnique);
		Map<Import, Import> importCopies = duplicateImports(topFrom.getImports(), topTo,
				makeNameUnique);
		for (Iterator<Map.Entry<Import, Import>> it = importCopies.entrySet().iterator(); it
				.hasNext();) {
//			Import object = it.next();
			Map.Entry<Import, Import> entry = it.next();
			topTo.getImports().add(entry.getValue());
//			retVal.add(object);
		}

		retVal.putAll(importCopies);

		return retVal;
	}

	private static Map<Import, Import> duplicateImports(List<Import> imports, Topology topTo,
			boolean makeNameUnique) {

//		List<Import> retVal = new LinkedList<Import>();
		Map<Import, Import> retVal = new HashMap<Import, Import>();

		for (Iterator<Import> it = imports.iterator(); it.hasNext();) {
			Import src = it.next();
			Import copy = (Import) EcoreUtil.copy(src);

			// It's illegal for any Import to have the same name as something in the destination
			// topology, or the results

			// It is possible that the template names are already not unique, so
			// track them.
			Set<String> copyNameSet = new HashSet<String>();
			if (makeNameUnique) {
				makeNameUnique(copy, topTo);
			}

			makeNameUnique(topTo, copyNameSet, src, copy);

			copyNameSet.add(copy.getName());
//			retVal.add(copy);
			retVal.put(src, copy);
		}

		return retVal;
	}

	/**
	 * Deeply copies the units and all their contained objects, fixing the core links.
	 * <p>
	 * Does not add units to the topology, but their names are set to be unique in relation to the
	 * topology.
	 * 
	 * @param templateUnits
	 *           a list of {@link Unit}s to be copied.
	 * @param topDest
	 *           used to assure creation of unique names in copies.
	 * @return Collection<Unit> a collection of copied units (order may be changed).
	 */
	public static Collection<Unit> intelligentDeepCopy(List<Unit> templateUnits, Topology topDest) {
		return intelligentDeepCopy(templateUnits, topDest, true);
	}

	/**
	 * Deeply copies the units and all their contained objects, fixing the core links.
	 * <p>
	 * Does not add units to the topology, but optionally sets their name to be unique when they are
	 * added.
	 * 
	 * @param templateUnits
	 *           a list of {@link Unit}s to be copied.
	 * @param topDest
	 *           used to create unique names to copies.
	 * @param makeNameUnique
	 *           true if unique names should be assigned to the copies based on the topology unit
	 *           names already in use.
	 * @return Collection<Unit> a collection of copied units (order may be changed).
	 */
	public static Collection<Unit> intelligentDeepCopy(List<Unit> templateUnits, Topology topDest,
			boolean makeNameUnique) {
		return intelligentDeepCopyMap(templateUnits, topDest, makeNameUnique).values();
	}

	/**
	 * Deeply copies the units and all their contained objects, fixing the core links.
	 * <p>
	 * Does not add units to the topology, but optionally sets their name to be unique when they are
	 * added.
	 * 
	 * @param templateUnits
	 *           a list of {@link Unit}s to be copied.
	 * @param topDest
	 *           used to create unique names to copies.
	 * @param makeNameUnique
	 *           true if unique names should be assigned to the copies based on the topology unit
	 *           names already in use.
	 * @return Map<Unit, Unit> a map of original units to copy units.
	 */
	public static Map<Unit, Unit> intelligentDeepCopyMap(List<Unit> templateUnits, Topology topDest,
			boolean makeNameUnique) {
		// if (DEBUG) {
		// for (Iterator it = templateUnits.iterator(); it.hasNext(); ) {
		// Unit template = (Unit) it.next();
		// dumpLinks(template);
		// }
		// }

		// Map of template Unit to copy Unit
		Map<Unit, Unit> duplicatedUnits = mapImportOrUnitToDuplicates(templateUnits);
		// Map of template Capability to copy Capability
		Map<Capability, Capability> duplicatedCaps = mapCapabilitiesToDuplicates(duplicatedUnits);
		// Map of template Requirement to copy Requirement
		Map<Requirement, Requirement> duplicatedReqs = mapRequirementsToDuplicates(duplicatedUnits);

		// It is possible that the template names are already not unique, so
		// track them.
		Set<String> copyNameSet = new HashSet<String>();
		for (Iterator<Unit> it = templateUnits.iterator(); it.hasNext();) {
			DeployModelObject template = it.next();
			DeployModelObject copy = /* (DeployModelObject) */duplicatedUnits.get(template);
			if (makeNameUnique) {
				makeNameUnique(copy, topDest);
			}
			makeNameUnique(topDest, copyNameSet, template, copy);
		}
		// Set names before setting links
		for (Iterator<Unit> it = templateUnits.iterator(); it.hasNext();) {
			DeployModelObject dmo = it.next();
			if (dmo instanceof Unit) {
				Unit template = (Unit) dmo;
				Unit copy = duplicatedUnits.get(template);
				fixupConstraintLinks(template, copy, duplicatedUnits, duplicatedCaps, duplicatedReqs);
				fixupUnitLinks(template, copy, duplicatedUnits);
				fixupRealizationLinks(template, copy, duplicatedUnits);
				fixupDependencyLinks(template, duplicatedCaps, duplicatedReqs);
				// Note: If Unit has an extension units they better be findable
				// using one of the above techniques, and not contained by some
				// new extension field.
			}
		}

		// if (DEBUG) {
		// for (Iterator it = duplicatedUnits.values().iterator(); it.hasNext();
		// ) {
		// Unit template = (Unit) it.next();
		// dumpLinks(template);
		// }
		// }

		return duplicatedUnits;
	}

	private static void makeNameUnique(Topology topDest, Set copyNameSet,
			DeployModelObject template, DeployModelObject copy) {
		// Check if the template list contained duplicate names
		if (copyNameSet.contains(copy.getName())) {
			String postfix;
			if (template.getTopology() != null && template.getTopology().getName() != null) {
				postfix = template.getTopology().getName();
			} else {
				postfix = ""; //$NON-NLS-1$
			}
			int i = 1;
			String newName = copy.getName() + '-' + postfix;
			while (topDest.resolve(newName) != null || copyNameSet.contains(newName)) {
				i++;
				newName = copy.getName() + '-' + postfix + '-' + i;
			}
		}
	}

	private static void fixupUnitLinks(Unit template, Unit copy, Map<Unit, Unit> duplicatedUnits) {
		// Blow away any unit links on the copy already
		copy.getUnitLinks().clear();

		List<UnitLink> unitLinks = new ArrayList();
//		for (Iterator it = template.getUnitLinks().iterator(); it.hasNext();) {
//		UnitLink templateUL = (UnitLink) it.next();
		// Unit links are currently (2007/08/09) hosting links or member links
		unitLinks.addAll(TopologyUtil.getImmediateHostingLinksOut(template));
		unitLinks.addAll(TopologyUtil.getImmediateMemberLinksOut(template));
		for (UnitLink templateUL : unitLinks) {
			UnitLink copyUL = (UnitLink) EcoreUtil.copy(templateUL);
			Unit copyTarget = /* (Unit) */duplicatedUnits.get(templateUL.getTarget());
			copyUL.setTarget(copyTarget);
			copyUL.setSource(copy);
			copy.getUnitLinks().add(copyUL);
		}
	}

	private static void fixupRealizationLinks(Unit template, Unit copy,
			Map<Unit, Unit> duplicatedUnits) {
		// Blow away and realization links on the copy already
		copy.getRealizationLinks().clear();

//		for (Iterator it = template.getRealizationLinks().iterator(); it.hasNext();) {
//			RealizationLink templateLL = (RealizationLink) it.next();
		for (RealizationLink templateRL : TopologyUtil.getImmediateRealizationLinksOut(template)) {
			RealizationLink copyLL = (RealizationLink) EcoreUtil.copy(templateRL);
			DeployModelObject copySource = /* (DeployModelObject) */duplicatedUnits.get(templateRL
					.getSource());
			copyLL.setSource(copySource);
			DeployModelObject copyTarget = /* (DeployModelObject) */duplicatedUnits.get(templateRL
					.getTarget());
			copyLL.setTarget(copyTarget);
			copy.getRealizationLinks().add(copyLL);
		}
	}

	private static void fixupConstraintLinks(Unit template, Unit copy,
			Map<Unit, Unit> duplicatedUnits, Map<Capability, Capability> duplicatedCaps,
			Map<Requirement, Requirement> duplicatedReqs) {

		// Blow away and logical links on the copy already
		copy.getConstraintLinks().clear();

		for (ConstraintLink templateCL : TopologyUtil.getImmediateConstraintLinksOut(template)) {
			ConstraintLink copyLL = (ConstraintLink) EcoreUtil.copy(templateCL);
			DeployModelObject copySource = /* (DeployModelObject) */duplicatedUnits.get(templateCL
					.getSource());
			copyLL.setSource(copySource);
			Unit copyTarget = /* (Unit) */duplicatedUnits.get(templateCL.getTarget());
			copyLL.setTarget(copyTarget);
			copy.getConstraintLinks().add(copyLL);
		}

		// Find ALL ConstraintLink sources, not just constraint links out of the Unit.
		// (This currently means checking Requirements, too.)
		for (Requirement req : (List<Requirement>) template.getRequirements()) {
			for (ConstraintLink templateCL : TopologyUtil.getImmediateConstraintLinksOut(req)) {
				ConstraintLink copyLL = (ConstraintLink) EcoreUtil.copy(templateCL);
				Requirement copySource = duplicatedReqs.get(templateCL.getSource());
				copyLL.setSource(copySource);
				Capability copyTarget = duplicatedCaps.get(templateCL.getTarget());
				copyLL.setTarget(copyTarget);
				copy.getConstraintLinks().add(copyLL);
			}
		}

	}

	private static void fixupDependencyLinks(Unit template,
			Map<Capability, Capability> duplicatedCaps, Map<Requirement, Requirement> duplicatedReqs) {
		for (Iterator it = template.getRequirements().iterator(); it.hasNext();) {
			Requirement req = (Requirement) it.next();
//		 	DependencyLink dl = req.getLink();
			for (DependencyLink dl : TopologyUtil.getImmediateDependencyLinksOut(req)) {
				// This Requirement has a dependency link
				Capability target = safeGetTarget(dl);
				if (target == null) {
					DeployCorePlugin.logError(0,
							"Dependency Link " + dl + " cannot resolve its target!", null); //$NON-NLS-1$ //$NON-NLS-2$
					continue;
				}

				Requirement copyReq = /* (Requirement) */duplicatedReqs.get(req);
				Capability copyTarget = /* (Capability) */duplicatedCaps.get(target);
				copyReq.getLink().setTarget(copyTarget);
				copyReq.getLink().setSource(copyReq); // PREVENT BAD SOURCEURI CACHED VALUE!
			}
		}
	}

	/**
	 * This is a special version of {@link UnitUtil#generateUniqueName(DeployModelObject, String)}
	 * specifically for dropping new units on the diagram.
	 * 
	 * make Init's name and display name unique for the topology
	 * 
	 * @param copy
	 *           the unit to be uniqued
	 * @param container
	 *           the topology to match the units in
	 * 
	 * @deprecated Use {@link UnitUtil#generateUniqueName(DeployModelObject, String)}
	 */
	public static void makeNameUnique(DeployModelObject copy, Topology container) {
		// NOTE: topDest could be null

		// Now set the container. One thing we will do here is to make the name
		// unique before we set the container
		String initialName = copy.getName();
		String name = initialName;
		int i = 0;
		// When we are called 'copy' may or may not already be in 'container'.
		// So we don't dare just check if name exists.
		if (container != null) {
			while (/* container.resolve(name) != null */duplicatedAnchor(container, copy, name)) {
				name = initialName + i;
				i++;
			}
		}

		if (!name.equals(initialName)) {
			copy.setName(name);
			// copy.setDisplayName(name);
		}

		makeDisplayNameUnique(copy, container);
	}

	private static void makeDisplayNameUnique(DeployModelObject unit, Topology topDest) {
		// Did template writer forget display name?
		if (unit.getDisplayName() == null) {
			if (unit instanceof Unit && ((Unit) unit).getCaptionProvider().title((Unit) unit) == null) {
				unit.setDisplayName(unit.getName());
			}
			return;
		}

		if (unit.getDisplayName().length() == 0) {
			if (unit instanceof Unit && ((Unit) unit).getCaptionProvider().title((Unit) unit) == null) {
				unit.setDisplayName(unit.getName());
			} else {
				unit.setDisplayName(null);
			}
			return;
		}

		String initialName = unit.getDisplayName();
		String name = initialName;
		int i = 2;
		if (topDest != null) {
			// When we are called 'copy' may or may not already be in 'container'.
			// So we don't dare just check if name exists.
			while (duplicatedDisplayName(topDest, unit, name)) {
				//name = initialName + nthExtension(i);
				name = initialName + i;
				i++;
			}
		}

		if (!name.equals(initialName)) {
			unit.setDisplayName(name);
		}
	}

	private static String nthExtension(int i) {
		if (i < 26) {
			char c = (char) ('a' + i);
			return "/" + c; //$NON-NLS-1$
		}

		return "/" + (i - 25); //$NON-NLS-1$
	}

	private static boolean duplicatedDisplayName(Topology top, DeployModelObject unit, String name) {
		if (unit instanceof Unit) {
			for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
				DeployModelObject candidate = (DeployModelObject) it.next();
				if (candidate != unit) {
					if (name.equals(candidate.getDisplayName())) {
						return true;
					}
				}
			}
		} else if (unit instanceof Import) {
			for (Iterator it = top.getImports().iterator(); it.hasNext();) {
				DeployModelObject candidate = (DeployModelObject) it.next();
				if (candidate != unit) {
					if (name.equals(candidate.getDisplayName())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	// Are there any units (other than 'unit') in 'top' with the same anchor?
	private static boolean duplicatedAnchor(Topology top, DeployModelObject unit, String name) {
		if (unit instanceof Unit) {
			for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
				DeployModelObject candidate = (DeployModelObject) it.next();
				if (candidate != unit) {
					if (candidate.getName().equals(name)) {
						return true;
					}
				}
			}
		} else if (unit instanceof Import) {
			for (Iterator it = top.getImports().iterator(); it.hasNext();) {
				DeployModelObject candidate = (DeployModelObject) it.next();
				if (candidate != unit) {
					if (candidate.getName().equals(name)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static Map<Requirement, Requirement> mapRequirementsToDuplicates(
			Map<Unit, Unit> duplicatedUnits) {
		Map<Requirement, Requirement> retVal = new HashMap<Requirement, Requirement>();

		for (Iterator<Map.Entry<Unit, Unit>> it = duplicatedUnits.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Unit, Unit> entry = /* (Map.Entry) */it.next();
			Unit src = /* (DeployModelObject) */entry.getKey();
			//			if (dmo instanceof Unit) {
			//				Unit src = (Unit) dmo;
			Unit dest = /* (Unit) */entry.getValue();
			for (Iterator<Requirement> it2 = src.getRequirements().iterator(); it2.hasNext();) {
				Requirement reqSrc = /* (Requirement) */it2.next();
				Requirement reqDest = lookupRequirement(dest, reqSrc.getName());
				reqDest.setDmoEType(reqSrc.getDmoEType());

				retVal.put(reqSrc, reqDest);
			}
			//			}
		}

		return retVal;
	}

	private static Map<Capability, Capability> mapCapabilitiesToDuplicates(
			Map<Unit, Unit> duplicatedUnits) {
		Map<Capability, Capability> retVal = new HashMap<Capability, Capability>();

		for (Iterator<Map.Entry<Unit, Unit>> it = duplicatedUnits.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Unit, Unit> entry = /* (Map.Entry) */it.next();
			Unit src = /* (DeployModelObject) */entry.getKey();
			//			if (dmo instanceof Unit) {
			//				Unit src = (Unit) dmo;
			Unit dest = /* (Unit) */entry.getValue();
			for (Iterator<Capability> it2 = src.getCapabilities().iterator(); it2.hasNext();) {
				Capability capSrc = /* (Capability) */it2.next();
				Capability capDest = lookupCapability(dest, capSrc.getName());
				retVal.put(capSrc, capDest);
			}
			//			}
		}

		return retVal;
	}

	private static Requirement lookupRequirement(Unit unit, String reqName) {
		for (Iterator it = unit.getRequirements().iterator(); it.hasNext();) {
			Requirement req = (Requirement) it.next();
			if (req.getName().equals(reqName)) {
				return req;
			}
		}

		return null;
	}

	private static Capability lookupCapability(Unit unit, String capName) {
		for (Iterator it = unit.getCapabilities().iterator(); it.hasNext();) {
			Capability cap = (Capability) it.next();
			if (cap.getName().equals(capName)) {
				return cap;
			}
		}

		return null;
	}

	private static Map<Unit, Unit> mapImportOrUnitToDuplicates(List<Unit> units) {
		Map<Unit, Unit> retVal = new HashMap<Unit, Unit>();

		for (Iterator<Unit> it = units.iterator(); it.hasNext();) {
			Unit src = /* (DeployModelObject) */it.next();
			Unit dest = (Unit) EcoreUtil.copy(src);
			retVal.put(src, dest);
		}

		return retVal;
	}

	private static Capability safeGetTarget(DependencyLink dl) {
		try {
			return dl.getTarget();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Checks if the attribute described by the status is mutable.
	 * 
	 * @param status
	 *           a deploy attribute status.
	 * @return true if the attribute is mutable.
	 * 
	 * @see DeployModelObjectUtil#isMutable(DeployModelObject, org.eclipse.emf.ecore.EAttribute)
	 */
	public static boolean isMutable(IDeployAttributeStatus status) {
		if (status == null || status.getDeployObject() == null) {
			return false;
		}
		if (status.getAttributeType() != null) {
			return DeployModelObjectUtil
					.isMutable(status.getDeployObject(), status.getAttributeType());
		}
		if (status.getAttributeName() != null) {
			return DeployModelObjectUtil
					.isMutable(status.getDeployObject(), status.getAttributeName());

		}
		return false;
	}

	/**
	 * Checks if the attribute described by the status is settable - mutable and public-editable.
	 * 
	 * @param status
	 *           a deploy attribute status.
	 * @return true if the attribute is mutable and public editable
	 * 
	 * @see DeployModelObjectUtil#isMutable(DeployModelObject, org.eclipse.emf.ecore.EAttribute)
	 */
	public static boolean isSettable(IDeployAttributeStatus status) {
		if (status == null || status.getDeployObject() == null) {
			return false;
		}
		if (status.getAttributeType() != null
				&& !status.getDeployObject().isPublicEditable(status.getAttributeType().getName())) {
			return false;
		}
		return isMutable(status);
	}

	/**
	 * Return true if the source attribute of the status is encrypted.
	 * 
	 * @param status
	 *           a deploy attribute value status.
	 * @return true if the source attribute of the status is encrypted.
	 */
	public static boolean isSourceEncrypted(IDeployAttributeValueStatus status) {
		if (status == null || status.getDeployObject() == null) {
			return false;
		}
		if (status.getAttributeType() != null) {
			return DeployModelObjectUtil.isEncrypted(status.getDeployObject(), status
					.getAttributeType());
		}
		if (status.getAttributeName() != null) {
			return DeployModelObjectUtil.isEncrypted(status.getDeployObject(), status
					.getAttributeName());

		}
		return false;
	}

	/**
	 * Sets the values of all {@link IDeployAttributeValueStatus} reported by the unit validator
	 * (one-pass).
	 * 
	 * @param unit
	 *           the deploy unit whose attributes will be set recursively.
	 * @param validatorService
	 *           the deploy validator service.
	 * @param monitor
	 *           optional progress monitor (may be null).
	 * @return the status of the update.
	 */
	public static IStatus setAllAttributesReported(Unit unit,
			DeployValidatorService validatorService, IProgressMonitor monitor) {
		if (unit == null || validatorService == null) {
			return Status.CANCEL_STATUS;
		}
		List<IUnitValidator> validators = validatorService.getUnitValidators(unit.eClass());
		if (validators.size() == 0) {
			return Status.OK_STATUS;
		}

		DeployStatusCollector reporter = new DeployStatusCollector();
		DeployValidationContext context = new DeployValidationContext(unit.getTopology(),
				validatorService, monitor);
		for (IUnitValidator validator : validators) {
			validator.validate(unit, context, reporter);
		}
		List valueStatusList = reporter.getStatusList();
		for (Iterator iter = valueStatusList.iterator(); iter.hasNext();) {
			Object cur = iter.next();
			if (!(cur instanceof IDeployAttributeValueStatus)) {
				iter.remove();
			}
		}
		if (valueStatusList.size() == 0) {
			return Status.CANCEL_STATUS;
		}
		SetAllAttributesInUnitResolution res = new SetAllAttributesInUnitResolution(
				new DeployResolutionContext((IDeployStatus) valueStatusList.get(0), validatorService,
						monitor), null);

		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		return res.resolve(valueStatusList, monitor);
	}

	/**
	 * Load a unit from a template and host it on a topology unit.
	 * 
	 * @param hostUnit
	 *           the unit to be hosted.
	 * @param template
	 *           the template ID.
	 * @return the operation status.
	 */
	public static IStatus hostTemplateUnit(Unit hostUnit, String template) {
		// Load template and add to topology
		DeployModelObject target = ResolutionUtils.addFromTemplate(template, hostUnit.getTopology());
		if (target == null) {
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, DeployNLS.bind(
					DeployCoreMessages.Error_loading_template_0, template), null);
		}
		Unit hostedUnit = ValidatorUtils.getUnit(target);
		if (hostedUnit == null) {
			return Status.CANCEL_STATUS;
		}
		// Hosting link
		HostingLink hostLink = CoreFactory.eINSTANCE.createHostingLink();
		hostLink.setTarget(hostedUnit);
		hostUnit.getHostingLinks().add(hostLink);
		UnitUtil.assignUniqueName(hostLink);
		return Status.OK_STATUS;
	}

	/**
	 * Set an attribute value using a sub-resolution.
	 * 
	 * @param capability
	 *           the capability containing the attribute to be set
	 * @param attribute
	 *           the attribute to be set
	 * @param value
	 *           the value to set
	 * @param context
	 *           the resolution context of the caller
	 * @return true if successfully completed
	 */
	public static boolean propogateAttributeValue(Capability capability, EAttribute attribute,
			Object value, IDeployResolutionContext context) {
		if (null == value) {
			return false;
		}

		// if target attribute is not editable (mutable and contract allows editing) then return false
		if (!DeployModelObjectUtil.isSettable(capability, attribute)) {
			return false;
		}

		IDeployResolution resolution = new DeploySetAttributeResolution(capability, attribute, value,
				null, context, null);
		IStatus status = resolution.resolve(new NullProgressMonitor());
		return status.isOK() ? true : false;
	}

	/**
	 * Proxy method to call DeployResolution.createResolutionContext which is not always visible.
	 * 
	 * @param status
	 *           the status
	 * @param context
	 *           the callers resolution context
	 * @return a new resolution context
	 */
	public static IDeployResolutionContext createResolutionContextProxy(IDeployStatus status,
			IDeployResolutionContext context) {

		IDeployResolutionContext newContext = DeployResolution.createResolutionContext(status,
				context);
		return newContext;
	}

	/**
	 * Creates a resolution context over a generic deploy status on the deploy object.
	 * 
	 * @param object
	 *           the deploy object on which a status will be created (but not added).
	 * @return a resolution context over the generated object status.
	 */
	public static IDeployResolutionContext createResolutionContext(DeployModelObject object) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
				ResolutionUtils.class.getName(), "", null, null, object);//$NON-NLS-1$
		return new DeployResolutionContext(status, null, null);
	}

	/**
	 * Remove the member from the group.
	 * <p>
	 * Deletes all member links with source=group and target=member.
	 * 
	 * @param member
	 *           the member link target.
	 * @param group
	 *           the member link source.
	 */
	public static void removeMemberFromGroup(Unit member, Unit group) {
		if (group == null || member == null) {
			return;
		}
		for (Iterator iter = group.getMemberLinks().iterator(); iter.hasNext();) {
			MemberLink mLink = (MemberLink) iter.next();
			if (mLink.getTarget() == member) {
				iter.remove();
			}
		}
	}

	/**
	 * Hosts the second unit on the first unit argument.
	 * 
	 * @param host
	 *           the host unit.
	 * @param hosted
	 *           the hosted unit.
	 * @return the new hosting link, if a new one was created.
	 */
	public static HostingLink host(Unit host, Unit hosted) {
		if (host == null || hosted == null) {
			return null;
		}
		if (ValidatorUtils.hosts(host, hosted)) {
			return null;
		}
		HostingLink link = CoreFactory.eINSTANCE.createHostingLink();
		link.setSource(host);
		link.setTarget(hosted);
		host.getHostingLinks().add(link);
		UnitUtil.assignUniqueName(link);
		return link;
	}

	/**
	 * Unhosts the second unit on the first unit argument.
	 * 
	 * @param host
	 *           the host unit.
	 * @param hosted
	 *           the hosted unit.
	 */
	public static void unhost(Unit host, Unit hosted) {
		if (host == null || hosted == null) {
			return;
		}
		for (Iterator iter = host.getHostingLinks().iterator(); iter.hasNext();) {
			HostingLink link = (HostingLink) iter.next();
			if (link.getTarget() == hosted) {
				iter.remove();
			}
		}
	}

	/**
	 * Removes a unit from a topology along with all the links it is the source or target of.
	 * 
	 * @param unit
	 *           the unit to be deleted.
	 */
	public static void removeFromTopology(Unit unit) {
		if (unit == null || unit.getTopology() == null) {
			return;
		}

		// Hosting links
		Unit[] hosts = unit.getTopology().findHosts(unit);
		for (int i = 0; i < hosts.length; i++) {
			unhost(hosts[i], unit);
		}

		// Member links
		Unit[] groups = unit.getTopology().findMemberOf(unit);
		for (int i = 0; i < groups.length; i++) {
			removeMemberFromGroup(unit, groups[i]);
		}

		// Dependency links
		for (Iterator iter = unit.getDependencyOrAnyCapabilities().iterator(); iter.hasNext();) {
			Capability cap = (Capability) iter.next();
			Requirement[] reqs = unit.getTopology().findDependentRequirements(cap);
			for (int i = 0; i < reqs.length; i++) {
				reqs[i].setLink(null);
			}
		}
		unit.getTopology().getUnits().remove(unit);
	}

	/**
	 * Groups the member unit.
	 * 
	 * @param group
	 *           the group unit.
	 * @param member
	 *           the member unit to be added.
	 * @return the member link if created, null if not.
	 */
	public static MemberLink group(Unit group, Unit member) {
		if (group == null || member == null) {
			return null;
		}
		if (ValidatorUtils.groups(group, member)) {
			return null;
		}
		MemberLink link = CoreFactory.eINSTANCE.createMemberLink();
		link.setSource(group);
		link.setTarget(member);
		group.getMemberLinks().add(link);
		UnitUtil.assignUniqueName(link);
		return link;
	}

	/**
	 * Deletes all hosting links in the topology for a unit.
	 * <p>
	 * Note: the method does not check the install state of the unit.
	 * 
	 * @param hosted
	 *           a hosted unit.
	 * @return true if one or more hosting links have been deleted, false otherwise.
	 */
	public static boolean unhost(Unit hosted) {
		if (hosted == null || hosted.getTopology() == null) {
			return false;
		}
		Unit[] hosts = hosted.getTopology().findHosts(hosted);
		boolean found = false;
		for (int i = 0; i < hosts.length; i++) {
			for (Iterator iter = hosts[i].getHostingLinks().iterator(); iter.hasNext();) {
				HostingLink link = (HostingLink) iter.next();
				if (link.getTarget() == hosted) {
					iter.remove();
					found = true;
				}
			}
		}
		return found;
	}

	/**
	 * Adds all the units hosted in the unit to the topology (recursive).
	 * <p>
	 * Note: performs discovery.
	 * 
	 * @param unit
	 *           a unit in a topology.
	 * @return a list of all hosted units (directly or indirectly).
	 */
	public static List<Unit> addAllHostedUnits(Unit unit) {
		Topology topology = unit.getTopology();
		List<Unit> visited = new ArrayList<Unit>();
		List<Unit> stack = new LinkedList<Unit>();
		stack.add(unit);
		visited.add(unit);
		while (stack.size() > 0) {
			Unit cur = stack.remove(0);
			List<UnitDescriptor> udList = TopologyDiscovererService.INSTANCE.findHosted(cur, topology);
			for (Iterator<UnitDescriptor> iter = udList.iterator(); iter.hasNext();) {
				UnitDescriptor ud = iter.next();
				Unit hosted = ud.getUnitValue();
				if (hosted.getTopology() == null) {
					hosted = ud.getUnitValueAndAddToTopology(topology);
				}
				if (!visited.contains(hosted)) {
					stack.add(hosted);
					visited.add(hosted);
				}
			}
		}
		return visited;
	}

	private static void partialFixupUnitLinks(Unit src, Unit copy, Map<Unit, Unit> duplicatedUnits) {
		// Blow away any unit links on the copy already
		copy.getUnitLinks().clear();

		List<UnitLink> links = new ArrayList<UnitLink>();
		links.addAll(TopologyUtil.getImmediateHostingLinksOut(src));
		links.addAll(TopologyUtil.getImmediateMemberLinksOut(src));

		for (Iterator<UnitLink> it = links.iterator(); it.hasNext();) {
			UnitLink templateUL = /* (UnitLink) */it.next();
			Unit copyTarget = /* (Unit) */duplicatedUnits.get(templateUL.getTarget());
			if (copyTarget != null) {
				UnitLink copyUL = (UnitLink) EcoreUtil.copy(templateUL);
				copyUL.setTarget(copyTarget);
				copyUL.setSource(copy);
				copy.getUnitLinks().add(copyUL);
			}
		}
	}

	private static void partialFixupRealizationLinks(Unit src, Unit copy,
			Map<Unit, Unit> duplicatedUnits) {
		// Blow away and realization links on the copy already
		copy.getRealizationLinks().clear();

		for (Iterator<RealizationLink> it = TopologyUtil.getImmediateRealizationLinksOut(src)
				.iterator(); it.hasNext();) {
			RealizationLink templateRL = it.next();
			DeployModelObject copyTarget = duplicatedUnits.get(templateRL.getTarget());
			if (copyTarget != null) {
				RealizationLink copyLL = (RealizationLink) EcoreUtil.copy(templateRL);
				DeployModelObject copySource = duplicatedUnits.get(templateRL.getSource());
				copyLL.setSource(copySource);
				copyLL.setTarget(copyTarget);
				copy.getRealizationLinks().add(copyLL);
			}
		}
	}

	private static void partialFixupConstraintLinks(Unit src, /* Unit copy, */
	Map<Unit, Unit> duplicatedUnits, Map<Capability, Capability> duplicatedCaps,
			Map<Requirement, Requirement> duplicatedReqs) {

		Unit copy = duplicatedUnits.get(src);

		// Blow away and logical links on the copy already
		copy.getConstraintLinks().clear();

		// Get a combined map from sources to duplicates
		Map<DeployModelObject, DeployModelObject> duplicates = new HashMap<DeployModelObject, DeployModelObject>();
		duplicates.putAll(duplicatedUnits);
		duplicates.putAll(duplicatedCaps);
		duplicates.putAll(duplicatedReqs);

		partialFixupConstraintLinksDmo(src, duplicates);

		for (DeployModelObject dmo : (List<Capability>) src.getCapabilities()) {
			partialFixupConstraintLinksDmo(dmo, duplicates);
		}

		for (DeployModelObject dmo : (List<Requirement>) src.getRequirements()) {
			partialFixupConstraintLinksDmo(dmo, duplicates);
		}

//		for (Iterator<ConstraintLink> it = TopologyUtil.getImmediateConstraintLinksOut(src)
//				.iterator(); it.hasNext();) {
//			ConstraintLink templateLL = it.next();
//			Unit copyTarget = duplicatedUnits.get(templateLL.getTarget());
//			if (copyTarget != null) {
//				ConstraintLink copyLL = (ConstraintLink) EcoreUtil.copy(templateLL);
//				DeployModelObject copySource = duplicatedUnits.get(templateLL
//						.getSource());
//				copyLL.setSource(copySource);
//				copyLL.setTarget(copyTarget);
//				copy.getConstraintLinks().add(copyLL);
//			}
//		}
	}

	private static void partialFixupConstraintLinksDmo(DeployModelObject src,
			Map<DeployModelObject, DeployModelObject> duplicates) {

		DeployModelObject copy = duplicates.get(src);
		Unit unitOwningCL = copy instanceof Unit ? (Unit) copy : (Unit) copy.getParent();

		for (ConstraintLink sourceCL : TopologyUtil.getImmediateConstraintLinksOut(src)) {

			DeployModelObject copyTarget = duplicates.get(sourceCL.getTarget());
			if (copyTarget != null) {
				ConstraintLink copyCL = (ConstraintLink) EcoreUtil.copy(sourceCL);
				DeployModelObject copySource = duplicates.get(sourceCL.getSource());
				copyCL.setSource(copySource);
				copyCL.setTarget(copyTarget);

				unitOwningCL.getConstraintLinks().add(copyCL);
			}
		}
	}

	private static void partialFixupDependencyLinks(Unit src,
			Map<Capability, Capability> duplicatedCaps, Map<Requirement, Requirement> duplicatedReqs) {
		for (Iterator<Requirement> it = src.getRequirements().iterator(); it.hasNext();) {
			Requirement req = /* (Requirement) */it.next();
			Requirement copyReq = /* (Requirement) */duplicatedReqs.get(req);
			//			DependencyLink dl = req.getLink();
			List<DependencyLink> dlist = TopologyUtil.getImmediateDependencyLinksOut(req);
			DependencyLink dl = dlist.size() > 0 ? dlist.get(0) : null;
			if (dl != null) {
				// This Source Requirement has a dependency link
				Capability target = safeGetTarget(dl);
				Capability copyTarget = target == null ? null : duplicatedCaps.get(target);
				if (copyTarget == null) {
					copyReq.setLink(null);
				} else {
					copyReq.getLink().setTarget(copyTarget);
				}
			} // end if source has link
		} // end for all requirements
	}

	/**
	 * Deeply copies the units and all their contained objects, fixing the core links.
	 * <p>
	 * Does not add units to the topology, but optionally sets their name to be unique when they are
	 * edded.
	 * 
	 * @param templateUnits
	 *           a list of {@link Unit}s to be copied.
	 * @param topDest
	 *           used to create unique names to copies.
	 * @param makeNameUnique
	 *           true if unique names should be assigned to the copies based on the topology unit
	 *           names already in use.
	 * @return Map<Unit, Unit> a map of original units to copy units.
	 */
	public static Map<Unit, Unit> partialIntelligentDeepCopyMap(List<Unit> templateUnits,
			Topology topDest, boolean makeNameUnique) {

		// NOTE: topDest could be null

		// Map of template Unit to copy Unit
		Map<Unit, Unit> duplicatedUnits = mapImportOrUnitToDuplicates(templateUnits);
		// Map of template Capability to copy Capability
		Map<Capability, Capability> duplicatedCaps = mapCapabilitiesToDuplicates(duplicatedUnits);
		// Map of template Requirement to copy Requirement
		Map<Requirement, Requirement> duplicatedReqs = mapRequirementsToDuplicates(duplicatedUnits);

		// It is possible that the template names are already not unique, so
		// track them.
		//		Set copyNameSet = new HashSet();
		for (Iterator<Unit> it = templateUnits.iterator(); it.hasNext();) {
			DeployModelObject template = /* (DeployModelObject) */it.next();
			DeployModelObject copy = /* (DeployModelObject) */duplicatedUnits.get(template);
			if (makeNameUnique) {
				makeNameUnique(copy, topDest);
			}
			//			// Check if the template list contained duplicate names
			//			if (copyNameSet.contains(copy.getName())) {
			//				String postfix;
			//				if ((template.getTopology() != null)
			//						&& (template.getTopology().getName() != null)) {
			//					postfix = template.getTopology().getName();
			//				} else {
			//					postfix = ""; //$NON-NLS-1$
			//				}
			//				int i = 1;
			//				String newName = copy.getName() + '-' + postfix;
			//				while ((topDest.resolve(newName) != null)
			//						|| (copyNameSet.contains(newName))) {
			//					i++;
			//					newName = copy.getName() + '-' + postfix + '-' + i;
			//				}
			//			}
		}
		// Set names before setting links
		for (Iterator<Unit> it = templateUnits.iterator(); it.hasNext();) {
			Unit template = it.next();
			Unit copy = /* (Unit) */duplicatedUnits.get(template);
			partialFixupConstraintLinks(template, /* copy, */duplicatedUnits, duplicatedCaps,
					duplicatedReqs);
			partialFixupUnitLinks(template, copy, duplicatedUnits);
			partialFixupRealizationLinks(template, copy, duplicatedUnits);
			partialFixupDependencyLinks(template, duplicatedCaps, duplicatedReqs);
			// Note: If Unit has an extension units they better be findable
			// using one of the above techniques, and not contained by some
			// new extension field.
			// Bug: doesn't handle LogicalLinks between anything other than Units 
		}

		// if (DEBUG) {
		// for (Iterator it = duplicatedUnits.values().iterator(); it.hasNext();
		// ) {
		// Unit template = (Unit) it.next();
		// dumpLinks(template);
		// }
		// }

		return duplicatedUnits;
	}

	/**
	 * Deeply copies the units and all their contained objects, fixing the core links.
	 * <p>
	 * Does not add units to the topology, but optionally sets their name to be unique when they are
	 * edded.
	 * 
	 * @param templateUnits
	 *           a list of {@link Unit}s to be copied.
	 * @param topDest
	 *           used to create unique names to copies.
	 * @param makeNameUnique
	 *           true if unique names should be assigned to the copies based on the topology unit
	 *           names already in use.
	 * @return Collection<Unit> a collection of copied units (order may be changed).
	 */
	public static Collection<Unit> partialIntelligentDeepCopy(List<Unit> templateUnits,
			Topology topDest, boolean makeNameUnique) {
		return partialIntelligentDeepCopyMap(templateUnits, topDest, makeNameUnique).values();
	}

	/**
	 * Deeply copies the units and all their contained objects, fixing the core links.
	 * <p>
	 * Does not add units to the topology, but optionally sets their name to be unique when they are
	 * edded.
	 * 
	 * @param templateUnits
	 *           a list of {@link Unit}s to be copied.
	 * @param topDest
	 *           used to create unique names to copies.
	 * @param makeNameUnique
	 *           true if unique names should be assigned to the copies based on the topology unit
	 *           names already in use.
	 * @return Collection<Unit> a collection of copied units (order may be changed).
	 */
	public static Collection<Unit> partialIntelligentDeepCopy(List<Unit> templateUnits,
			boolean makeNameUnique) {
		return partialIntelligentDeepCopyMap(templateUnits, null, makeNameUnique).values();
	}

	/**
	 * Removes the instantiation entry for the specified attribute on the imported object.
	 * 
	 * @param object
	 *           a deploy model object from an imported topology.
	 * @param attribute
	 *           the attribute of the object to be unset.
	 * @return true if the attribute had been set in the instantiation, false otherwise.
	 */
	public static boolean unsetImportedObjectAttribute(DeployModelObject object, EAttribute attribute) {
		if (attribute == null) {
			return false;
		}
		return removeInstantiationProperty(object, attribute.getName());
	}

	/**
	 * Removes the instantiation entry for the specified attribute on the imported object.
	 * 
	 * @param object
	 *           a deploy model object from an imported topology.
	 * @param attribute
	 *           the name of the attribute to be un-modified.
	 * @return true if the attribute had been set in the instantiation, false otherwise.
	 */
	public static boolean removeInstantiationProperty(DeployModelObject object, String attribute) {
		Instantiation inst = getInstantiation(object);
		if (inst == null) {
			return false;
		}
		if (attribute == null) {
			return false;
		}
		for (Iterator<Property> iter = inst.getConfiguredProperties().iterator(); iter.hasNext();) {
			Property prop = iter.next();
			if (attribute.equals(prop.getSelect())) {
				return inst.getConfiguredProperties().remove(prop);
			}
		}
		return false;
	}

	/**
	 * Removes the instantiation entry for the specified imported object.
	 * <p>
	 * Discards all modification performed on the imported object.
	 * 
	 * @param object
	 *           a deploy model object from an imported topology.
	 * @return true if the object had been instantiated in the import, false otherwise.
	 */
	public static boolean removeInstantiation(DeployModelObject object) {
		Instantiation inst = getInstantiation(object);
		if (inst == null) {
			return false;
		}
		InstanceConfiguration config = (InstanceConfiguration) inst.getParent();
		if (config == null) {
			return false;
		}
		return config.getInstantiations().remove(inst);
	}

	/**
	 * Returns the instantiation of the imported object or null if not found.
	 * 
	 * @param object
	 *           an imported topology object.
	 * @return the instantiation, or null if it does not exist or is applicable.
	 */
	public static Instantiation getInstantiation(DeployModelObject object) {
		if (object == null || object.getTopology() == null) {
			return null;
		}
		Topology top = object.getTopology();
		if (object.getEditTopology() == top) {
			return null;
		}

		Import imp = top.getEditTopology().getImport(top.getNamespace(), top.getName());
		if (imp == null) {
			return null;
		}
		InstanceConfiguration config = imp.getInstanceConfiguration();
		if (config == null) {
			return null;
		}
		String path = object.getFullPath();
		int index = path.indexOf(':');
		if (index != -1) {
			if (index + 1 < path.length()) {
				path = path.substring(index + 1);
			} else {
				return null;
			}
		}

		return config.getInstantiation(path);
	}

	private static boolean DEBUG = false;

	/**
	 * Get a list of status of a particular type and severity on a particular object
	 * 
	 * @param obj
	 *           object to search for status
	 * @param problemType
	 *           status problem type
	 * @param severity
	 *           status severity
	 * @return list of statuses
	 */
	public static List<IDeployStatus> getStatuses(DeployModelObject obj, String problemType,
			int severity) {
		if (null == obj || null == problemType) {
			return Collections.emptyList();
		}

		List<IDeployStatus> result = new ArrayList<IDeployStatus>();

		for (DeployStatusIterator sIt = new DeployStatusIterator(obj); sIt.hasNext();) {
			IDeployStatus status = sIt.next();

			if (DEBUG) {
				System.out.println("     message: " + status.getMessage()); //$NON-NLS-1$
				System.out.println(" problemType: " + status.getProblemType()); //$NON-NLS-1$
				System.out.println("   validator: " + status.getValidatorID()); //$NON-NLS-1$
			}

			if (problemType.equals(status.getProblemType()) && severity == status.getSeverity()) {
				result.add(status);
			}
		}

		return result;
	}

	/**
	 * Retrieve list of resolutions of a particular type
	 * 
	 * @param resolutions
	 *           list of resolutions to consider
	 * @param c
	 *           the class type of the resolutions to return
	 * @return list resolutions matching desired type
	 */
	public static List<IDeployResolution> getResolutions(List<IDeployResolution> resolutions, Class c) {
		if (null == resolutions || 0 == resolutions.size() || null == c) {
			return Collections.emptyList();
		}

		if (DEBUG) {
			System.out.println("Filtering resolutions for one of type: " //$NON-NLS-1$
					+ c.getName());
		}

		List<IDeployResolution> result = new ArrayList<IDeployResolution>();

		for (IDeployResolution res : resolutions) {
			if (DEBUG) {
				System.out.println("   considering: " + res.getDescription()); //$NON-NLS-1$
			}
			if (c.isInstance(res)) {
				result.add(res);
			}
		}

		return result;
	}

}
