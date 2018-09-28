/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.extension.PaletteExtensionListener;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;

/**
 * Service APIs to assist with accessing ResourceType information
 * 
 * @since 2.0
 */
public interface IResourceTypeService {

	/**
	 * Tool kind identifier
	 */
	public static final String TOOL_KIND = "tool"; //$NON-NLS-1$

	/**
	 * Stack kind identifier
	 */
	public static final String STACK_KIND = "stack"; //$NON-NLS-1$

	/**
	 * Get the resource type id for the specified context, bound id
	 * 
	 * @param context
	 * @param id
	 * @return the resource type id, null if not found
	 */
	public String getResourceTypeId(String context, String id);

	/**
	 * Get the template URI for the specified resource type id
	 * 
	 * @param resourceTypeId
	 * @return the templateURI string, null if not found
	 */
	public String getTemplateURI(String resourceTypeId);

	/**
	 * Get the template URI for the specified resource type id
	 * 
	 * @param resourceTypeId
	 * @return the templtaeURI string, null if not found
	 */
	public String getTemplateVURI(String resourceTypeId);

	/**
	 * Return the template URI from the id bound to the specified context
	 * 
	 * @param context
	 *           the context of the resource type binding id
	 * @param id
	 *           the binding id
	 * @return the template URI string, null if not found
	 */
	public String getTemplateURI(String context, String id);

	/**
	 * Create a unit using the template for an existing topology.
	 * 
	 * @param resourceTypeId
	 *           the id of the template to create
	 * @return the object created using the topology
	 */
	public DeployModelObject createFromTemplate(String resourceTypeId);

	/**
	 * Create a unit using the template for an existing topology.
	 * 
	 * @param resourceTypeId
	 *           the id of the template to create
	 * @param topology
	 *           the target topology
	 * @return the object created using the topology
	 */
	public DeployModelObject createFromTemplate(String resourceTypeId, Topology topology);

	/**
	 * Locate the resource id for the given binding id, and load its template and return the
	 * corresponding unit.
	 * 
	 * @param bindingId -
	 *           the binding id
	 * @param context -
	 *           the context to which the binding id applies
	 * @return the unit created from the template corresponding to the binding id, null if not found
	 */
	public DeployModelObject createUnitFromBindingId(String bindingId, String context);

	/**
	 * Locate the resource id for the given binding id, and load its template and return the
	 * corresponding unit.
	 * 
	 * @param bindingId -
	 *           the binding id
	 * @param context -
	 *           the context to which the binding id applies
	 * @param topology -
	 *           a topology
	 * @return the object created from the template corresponding to the binding id, null if not
	 *         found
	 */
	public DeployModelObject createUnitFromBindingId(String bindingId, String context,
			Topology topology);

	/**
	 * Get the reourceTypeDescriptor for the associated Id
	 * 
	 * @param id
	 *           the resourceTypeId
	 * @return the ResourceTypeDescriptor
	 */
	public ResourceTypeDescriptor getResourceTypeDescriptor(String id);

	/**
	 * Get the reourceTypeUIBindingDescriptor for the associated Id
	 * 
	 * @param id
	 *           the resourceTypeId
	 * @return the ResourceTypeUIBindingDescriptor
	 */
	public ResourceTypeUIBindingDescriptor getResourceTypeUIBindingDescriptor(String id);

	/**
	 * Returns all the palette entries - static + dynamic
	 * 
	 * @return all the palette entries that are available; both statically registered and dynamically
	 *         loaded.
	 */
	public DynamicPaletteEntry[] getAllPaletteEntries();

	/**
	 * Return all the statically defined palette entries
	 * 
	 * @return an array of DynamicPaletteEntry objects that comprise the set of entries registered as
	 *         ResourceTypePaletteBindings
	 */
	public DynamicPaletteEntry[] getRegisteredPaletteEntries();

	/**
	 * Return all the dynamically defined palette tool entries
	 * 
	 * @return an array of DynamicPaletteEntry objects
	 */
	public DynamicPaletteEntry[] getDynamicPaletteEntries();

	/**
	 * Return all the dynamically defined palette stack entries
	 * 
	 * @return an array of DeployPaletteEntry objects
	 */
	public DynamicPaletteEntry[] getDynamicStackEntries();

	/**
	 * Return the list of known dynamic resource type ids
	 * 
	 * @return the list of dynamic resource type ids
	 */
	public List<String> getDynamicResourceTypeIds();

	/**
	 * Create a new dynamic resource type
	 * 
	 * @param id
	 *           TODO the stem of the template filename?
	 * @param path
	 * @param label
	 * @param description
	 * @param smallIcon
	 * @param largeIcon
	 * @param units
	 *           are copied by value; they will not be removed from their current location
	 * @param projectName
	 */
	public void addDynamicResourceType(String id, String path, String label, String description,
			String smallIcon, String largeIcon, Unit[] units, String projectName);

	/**
	 * Create a new dynamic resource type
	 * 
	 * @param id
	 *           TODO the stem of the template filename?
	 * @param path
	 * @param label
	 * @param description
	 * @param smallIcon
	 * @param largeIcon
	 * @param units
	 *           are copied by value; they will not be removed from their current location
	 * @param projectName
	 */
	public void addDynamicResourceType(String id, String path, String label, String description,
			String smallIcon, String largeIcon, Unit[] units, String projectName, String templateUri);

	/**
	 * Create a new dynamic resource type
	 * 
	 * @param id
	 *           TODO the stem of the template filename?
	 * @param path
	 * @param label
	 * @param description
	 * @param smallIcon
	 * @param largeIcon
	 * @param units
	 *           are copied by value; they will not be removed from their current location
	 * @param projectName
	 */
	public void addDynamicResourceType(String id, String path, String label, String description,
			String smallIcon, String largeIcon, Unit[] units, String projectName, String templateUri,
			String templateVUri);

	/**
	 * Create a new dynamic stack entry in the palette
	 * 
	 * @param id
	 * @param path
	 * @param label
	 * @param icon
	 * @param projectName
	 */
	public void addDynamicPaletteStack(String id, String path, String label, String icon,
			String projectName);

	/**
	 * Remove a dynamic resource type
	 * 
	 * @param resourceId
	 */
	public void removeDynamicResourceType(String resourceId);

	/**
	 * @param listener
	 */
	public void addPaletteChangeListener(PaletteExtensionListener listener);

	/**
	 * @param listener
	 */
	public void removePaletteChangeListener(PaletteExtensionListener listener);

	/**
	 * Returns true if the specifed resourceTypeId is a dynamic palette entry
	 * 
	 * @param resourceTypeId
	 * @return true if the specified id is dynamic
	 */
	public boolean isDynamicPaletteEntry(String resourceTypeId);

	/**
	 * Return the descriptive name of the resource type with the specified id. May be either a static
	 * or dynamic resource
	 * 
	 * @param the
	 *           id
	 * @retrun the name
	 */
	public String getResourceTypeName(String id);

	/**
	 * Create a dynamic palette tool entry
	 * 
	 * @param id
	 * @param path
	 * @param label
	 * @param desc
	 * @param smallIcon
	 * @param largeIcon
	 * @param templateUri
	 * @return the DynamicPaletteEntry
	 */
	public DynamicPaletteEntry createDynamicPaletteEntry(String id, String path, String label,
			String desc, String smallIcon, String largeIcon, String templateUri);

	/**
	 * Create a dynamic palette stack entry
	 * 
	 * @param id
	 * @param path
	 * @param label
	 * @param icon
	 * @return the DynamicPaletteEntry
	 */
	public DynamicPaletteEntry createDynamicStackEntry(String id, String path, String label,
			String icon);

	/**
	 * Returns true if the specified topology is a dynamic user template
	 * 
	 * @param topology
	 * @return true if the specified topology is a dynamic user template
	 */
	public boolean isDynamicPaletteEntry(Topology topology);

	/**
	 * Rename the resource type from the specified id
	 * 
	 * @param id
	 *           The resource type id
	 * @param name
	 *           The new name
	 */
	public void renameResourceType(String id, String name);

	/**
	 * 
	 * @return current topology
	 */
	public Topology getCurrentTopology();

	/**
	 * Create a standalone dynamic types file
	 * 
	 * @param fileName
	 * @param fileFolder
	 * @param projectName
	 * @param resourceTypeId
	 * @param setTeamPrivate -
	 *           set to true to keep folder location team private
	 * @return The URI of the created file
	 */
	public URI createStandaloneDynamicTypesFile(String fileName, String fileFolder,
			String projectName, String resourceTypeId, boolean setTeamPrivate);

	/**
	 * add a dynamic stack entry
	 * 
	 * @param entry
	 * @param projectName
	 */
	public void addDynamicPaletteStack(DynamicPaletteEntry entry, String projectName);

	/**
	 * add a dynamic resource type
	 * 
	 * @param paletteEntry
	 * @param projectName
	 */
	public void addDynamicResourceType(DynamicPaletteEntry paletteEntry, String projectName);
}
