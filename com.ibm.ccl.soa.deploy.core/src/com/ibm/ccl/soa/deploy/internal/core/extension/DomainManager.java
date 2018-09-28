/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jem.util.RegistryReader;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Parse the <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point into structures that can be
 * more easily manipulated.
 * 
 * @since 1.0
 * 
 */
public class DomainManager {

	/**
	 * The singleton instance of the manager.
	 */
	public static final DomainManager INSTANCE = new DomainManager();

	private final Set domainDescriptors = new HashSet();

	/** List<String> of {@link EPackage#getNsURI()}. */
	private final List domainNsURIList = new ArrayList();

	/** A map of (targetNamespaces(String), {@link DomainDescriptor}) [] - pairs */
	private final Map domainDescriptorsByTargetNamespace = new HashMap();

	private final DomainDescriptor[] emptyDescriptors = new DomainDescriptor[0];

	private static final CapabilityProviderDescriptor[] NO_CPD_ELEMENTS = new CapabilityProviderDescriptor[0];

	/** Map of contributing plugin id to DecoratorSemanticBindingRuleDescriptor * */
	private Map decoratorSemanticBindingRulesByPluginId;

	/** Map of validator plugin ids by classname * */
	private Map validatorPluginIdsByClassname = null;

	/** Map of resource type descriptors by id * */
	private Map resourceTypesById = null;

	/** Map of resource type descriptors by context * */
	private Map resourceTypeBindingsByContext = null;

	/** Map of resource type UI binding descriptors by resourceTypeId * */
	private Map resourceTypeUIBindingsById = null;

	/**
	 * @return The singleton instance of the DomainManager.
	 * @deprecated Use the singleton {@link #INSTANCE}.
	 */
	public static DomainManager getInstance() {
		return INSTANCE;
	}

	private DomainManager() {
		/*
		 * We initialize the instance up front to force the read of the registry in the constructor
		 * and therefore avoid any potential concurrency issues.
		 * 
		 */
		new DomainRegistry().readRegistry();
	}

	/**
	 * @return List<String> with the declared domain namespace URIs.
	 * 
	 * @see EPackage#getNsURI()
	 */
	public List getDomainNsURIs() {
		return Collections.unmodifiableList(domainNsURIList);
	}

	private boolean addDomainDescriptor(DomainDescriptor aDescriptor) {
		boolean result = true;
		Assert.isNotNull(aDescriptor);
		domainDescriptors.add(aDescriptor);
		if (aDescriptor.getTargetNamespace() != null && aDescriptor.getTargetNamespace().length() > 0
				&& !domainNsURIList.contains(aDescriptor.getTargetNamespace())) {
			domainNsURIList.add(aDescriptor.getTargetNamespace());
		}
		String id = aDescriptor.getId();
		if (id != null) {
			/*
			 * if (domainDescriptorsByDomainId.containsKey(id)) DeployCorePlugin.logError(0,
			 * NLS.bind(DeployCoreMessages.DomainManager_Duplicate_unitTypeIds_found, new
			 * Object[]{findDomainDescriptorByDomainId(id).getElement().getDeclaringExtension().getNamespace(),
			 * aDescriptor.getElement().getDeclaringExtension().getNamespace()}), null); else {
			 * domainDescriptorsByDomainId.put(id, aDescriptor);
			 */
			String targetNamespace = aDescriptor.getTargetNamespace();
			// There will likely only be a few descriptors for a given domain,
			// so growing one at
			// a time should not be an issue
			DomainDescriptor[] oldDescriptors = findDomainDescriptorsByTargetNamespace(
					targetNamespace, null);
			DomainDescriptor[] descriptors = new DomainDescriptor[oldDescriptors.length + 1];
			System.arraycopy(oldDescriptors, 0, descriptors, 0, oldDescriptors.length);
			descriptors[oldDescriptors.length] = aDescriptor;
			domainDescriptorsByTargetNamespace.put(targetNamespace, descriptors);
			// }
		}
		return result;
	}

	/**
	 * Search for {@link DomainDescriptor}s specifying the targetNamespace specified by the give
	 * {@link DeployModelObject}.
	 * 
	 * @param deployModelObject
	 *           The DeployModelObject whose targetNamespace to query.
	 * @return A DomainDescriptor [] with all DomainDescriptors matching on the targetNamespace, or
	 *         an empty array if there are none. This method will not return <code>null</code>.
	 */
	public DomainDescriptor[] findDomainDescriptors(DeployModelObject deployModelObject) {
		if (deployModelObject == null) {
			DeployCorePlugin.logError(0,
					DeployCoreMessages.DomainManager_DeployModelObject_is_not_contained_, null);
			return null;
		}
		String targetNamespace = deployModelObject.eClass().getEPackage().getNsURI();
		Topology topology = deployModelObject.getTopology();
		if (topology == null) {
			DeployCorePlugin.logError(0,
					DeployCoreMessages.DomainManager_DeployModelObject_is_not_contained_, null);
			return null;
		}
		String decoratorSemanticID = topology.getDecoratorSemantic();
		return findDomainDescriptorsByTargetNamespace(targetNamespace, decoratorSemanticID);
	}

	/**
	 * Search for all {@link DomainDescriptor}s specifying the given targetNamespace.
	 * 
	 * @param targetNamespace
	 *           The targetNamespace to search for.
	 * @param decoratorSemantic
	 * @return A DomainDescriptor [] with all DomainDescriptors matching on the targetNamespace, or
	 *         an empty array if there are none. This method will not return <code>null</code>.
	 */
	public DomainDescriptor[] findDomainDescriptorsByTargetNamespace(String targetNamespace,
			String decoratorSemanticId) {
		DomainDescriptor[] descriptors = (DomainDescriptor[]) domainDescriptorsByTargetNamespace
				.get(targetNamespace);
		if (decoratorSemanticId != null && descriptors != null && descriptors.length > 0) {
			List filteredBySemanticDescriptors = new ArrayList(descriptors.length);
			for (int i = 0; i < descriptors.length; i++) {
				DomainDescriptor descriptor = descriptors[i];
				filteredBySemanticDescriptors.add(descriptor);
			}

			return (DomainDescriptor[]) filteredBySemanticDescriptors
					.toArray(new DomainDescriptor[filteredBySemanticDescriptors.size()]);

		}
		return null != descriptors ? descriptors : emptyDescriptors;
	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link CapabilityProviderDescriptor} allows clients to
	 * create instances of {@link CapabilityProvider}s that can provide information about
	 * requirements and capabilities. Clients are required to instantiate and manage the lifecyle of
	 * the instance of {@link CapabilityProvider}.
	 * 
	 * 
	 * @param aPotentialObject
	 *           An object that may be or may be adaptable to a requirement or capability.
	 * @return An array of enabled topology Capability Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public CapabilityProviderDescriptor[] findEnabledCapabilityProvidersByInputOnly(
			Object aPotentialObject) {
		List enabledProviders = new ArrayList();

		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			CapabilityProviderDescriptor[] cpds = dd.getCapabilityProviderDescriptors();
			for (int i = 0; i < cpds.length; i++) {
				CapabilityProviderDescriptor descriptor = cpds[i];
				if (descriptor.isEnabledForInputOnly(aPotentialObject)) {
					enabledProviders.add(descriptor);
				}
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_CPD_ELEMENTS;
		}
		return (CapabilityProviderDescriptor[]) enabledProviders
				.toArray(new CapabilityProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link CapabilityProviderDescriptor} allows clients to
	 * create instances of {@link CapabilityProvider}s that can provide information about
	 * requirements and capabilities. Clients are required to instantiate and manage the lifecyle of
	 * the instance of {@link CapabilityProvider}.
	 * 
	 * 
	 * @param aPotentialObject
	 *           An object that may be or may be adaptable to a requirement or capability.
	 * @return An array of enabled topology Capability Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public CapabilityProviderDescriptor[] findEnabledCapabilityProvidersByOutputOnly(
			Object aPotentialObject) {
		List enabledProviders = new ArrayList();

		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			CapabilityProviderDescriptor[] cpds = dd.getCapabilityProviderDescriptors();
			for (int i = 0; i < cpds.length; i++) {
				CapabilityProviderDescriptor descriptor = cpds[i];
				if (descriptor.isEnabledForOutputOnly(aPotentialObject)) {
					enabledProviders.add(descriptor);
				}
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_CPD_ELEMENTS;
		}
		return (CapabilityProviderDescriptor[]) enabledProviders
				.toArray(new CapabilityProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link CapabilityProviderDescriptor} allows clients to
	 * create instances of {@link CapabilityProvider}s that can provide information about
	 * requirements and capabilities. Clients are required to instantiate and manage the lifecyle of
	 * the instance of {@link CapabilityProvider}.
	 * 
	 * 
	 * @param aInputObject
	 *           An object that may be or may be adaptable to a requirement or capability.
	 * @param aOutputObject
	 *           an output object return type for the provider
	 * @return An array of enabled topology Capability Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public CapabilityProviderDescriptor[] findEnabledCapabilityProvidersByInputAndOutput(
			Object aInputObject, Object aOutputObject) {
		List enabledProviders = new ArrayList();

		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			CapabilityProviderDescriptor[] cpds = dd.getCapabilityProviderDescriptors();
			for (int i = 0; i < cpds.length; i++) {
				CapabilityProviderDescriptor descriptor = cpds[i];
				if (descriptor.isEnabledForInputAndOutput(aInputObject, aOutputObject)) {
					enabledProviders.add(descriptor);
				}
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_CPD_ELEMENTS;
		}
		return (CapabilityProviderDescriptor[]) enabledProviders
				.toArray(new CapabilityProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for a {@link DomainDescriptor} which specifies the given id.
	 * 
	 * @param aDomainId
	 *           The domainId to search for.
	 * @return A DomainDescriptor matching the given domainId or <b>null</b>.
	 */
	/*
	 * This causes issues when domain contributions happen from multiple plug-ins. public
	 * DomainDescriptor findDomainDescriptorByDomainId(String aDomainId) { return (DomainDescriptor)
	 * domainDescriptorsByDomainId.get(aDomainId); }
	 */

	private class DomainRegistry extends RegistryReader implements ICommonDeployExtensionConstants {

		private DomainRegistry() {
			super(DeployCorePlugin.PLUGIN_ID, TAG_DOMAINS);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_DOMAIN.equals(element.getName())) {
				return addDomainDescriptor(new DomainDescriptor(element));
			} else if (TAG_SYNCHRONIZATION_PARTICIPANT.equals(element.getName())) {
				// Carry on, sync participant manager will handle
				return true;
			}
			return false;
		}

	}

	/**
	 * @param pluginid
	 *           the id of the contributing plugin
	 * @param contentType
	 *           the type of explicit-entry content to retrieve
	 * @return The list of explict entry content
	 */
	public List getExplicitEntryContent(String pluginid, String contentType) {
		if (decoratorSemanticBindingRulesByPluginId == null) {
			loadDSBRByPluginIdMap();
		}
		DecoratorSemanticBindingRuleDescriptor desc = (DecoratorSemanticBindingRuleDescriptor) decoratorSemanticBindingRulesByPluginId
				.get(pluginid);
		if (desc != null) {
			return desc.getExplicitEntryContents(contentType);
		}
		return null;
	}

	private void loadDSBRByPluginIdMap() {
		decoratorSemanticBindingRulesByPluginId = new HashMap();
		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			DecoratorSemanticBindingRuleDescriptor dsbrDesc = dd.getDsBindingRuleDescriptor();
			if (dsbrDesc != null) {
				String pluginId = dsbrDesc.getContributingPluginId();
				decoratorSemanticBindingRulesByPluginId.put(pluginId, dsbrDesc);
			}
		}
	}

	/**
	 * Return the id of the plugin declaring the content for the specified content type. Return null
	 * if the content is not defined in any plugin.
	 * 
	 * @param contentId
	 * @param contentType
	 * @return The ID of the plugin declaring the content. Null if not found.
	 */
	public String findPluginIdForContent(String contentId, String contentType) {
		// Brute force way for now.....must look at all domain descriptors
		// TODO cache this more effectively
		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			DecoratorSemanticBindingRuleDescriptor dsbrDesc = dd.getDsBindingRuleDescriptor();
			if (dsbrDesc != null) {
				List contents = dsbrDesc.getExplicitEntryContents(contentType);
				if (contents != null) {
					Iterator it = contents.iterator();
					while (it.hasNext()) {
						String id = (String) it.next();
						if (id != null && id.equals(contentId)) {
							return dsbrDesc.getContributingPluginId();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Return the contributing plugin id for the specified validator class.
	 * 
	 * @return the contributing plugin ID of the validator class
	 */
	public String getValidatorContributingPluginId(String id) {
		if (validatorPluginIdsByClassname == null) {
			loadValidatorsByClassnameMap();
		}
		return (String) validatorPluginIdsByClassname.get(id);
	}

	private void loadValidatorsByClassnameMap() {
		if (domainDescriptors == null) {
			return;
		}
		validatorPluginIdsByClassname = new HashMap();
		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			if (dd == null) {
				continue;
			}
			String classname = dd.getDomainValidatorClassAttr();
			String pluginId = dd.getDomainValidatorPluginid();
			validatorPluginIdsByClassname.put(classname, pluginId);
		}
	}

	/**
	 * Return all the resource type descriptors
	 * 
	 * @return array of all the resource type descriptors
	 */
	public ResourceTypeDescriptor[] getAllResourceTypes() {
		if (resourceTypesById == null) {
			loadResourceTypeDescriptorMap();
		}
		return (ResourceTypeDescriptor[]) resourceTypesById.values().toArray(
				new ResourceTypeDescriptor[resourceTypesById.size()]);
	}

	/**
	 * Return all the resource type binding descriptors
	 * 
	 * @param context
	 *           the context of the resource type binding
	 * @return array of all the resource type binding descriptors for the specified context
	 */
	public ResourceTypeBindingDescriptor[] getAllResourceTypeBindings(String context) {
		if (resourceTypeBindingsByContext == null) {
			loadResourceTypeBindingDescriptorMap();
		}
		List bindings = (List) resourceTypeBindingsByContext.get(context);
		if (bindings == null) {
			return null;
		}
		return (ResourceTypeBindingDescriptor[]) bindings
				.toArray(new ResourceTypeBindingDescriptor[bindings.size()]);
	}

	/**
	 * Return all the resource type UI binding descriptors
	 * 
	 * @return the array or resource type UI binding descriptors
	 */
	public ResourceTypeUIBindingDescriptor[] getAllResourceTypeUIBindings() {
		if (resourceTypeUIBindingsById == null) {
			loadResourceTypeUIBindingDescriptorMap();
		}

		return (ResourceTypeUIBindingDescriptor[]) resourceTypeUIBindingsById.values().toArray(
				new ResourceTypeUIBindingDescriptor[resourceTypeUIBindingsById.size()]);
	}

	/**
	 * Return the resource type UI binding descriptor for the specified resource type id
	 * 
	 * @param id
	 *           the resource type id
	 * @return the associated resource type UI binding descriptor, null if not found
	 */
	public ResourceTypeUIBindingDescriptor getResourceTypeUIBinding(String id) {
		if (resourceTypeUIBindingsById == null) {
			loadResourceTypeUIBindingDescriptorMap();
		}
		ResourceTypeUIBindingDescriptor desc = (ResourceTypeUIBindingDescriptor) resourceTypeUIBindingsById
				.get(id);

		return desc;
	}

	/**
	 * Return the ResourceTypeDescriptor for the specified resource id
	 * 
	 * @param id
	 *           the id of the resource type descriptor to return
	 * @return the resource type descriptor
	 */
	public ResourceTypeDescriptor getResourceType(String id) {
		if (resourceTypesById == null) {
			loadResourceTypeDescriptorMap();
		}
		return (ResourceTypeDescriptor) resourceTypesById.get(id);
	}

	private void loadResourceTypeDescriptorMap() {
		if (domainDescriptors == null) {
			return;
		}
		resourceTypesById = new HashMap();
		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			if (dd == null) {
				continue;
			}
			ResourceTypeDescriptor[] rtDescs = dd.getResourceTypeDescriptors();
			for (int i = 0; i < rtDescs.length; i++) {
				// TODO check for dupes - report error
				resourceTypesById.put(rtDescs[i].getId(), rtDescs[i]);
			}
		}
	}

	private void loadResourceTypeBindingDescriptorMap() {
		if (domainDescriptors == null) {
			return;
		}
		resourceTypeBindingsByContext = new HashMap();
		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			if (dd == null) {
				continue;
			}
			ResourceTypeBindingDescriptor[] rtDescs = dd.getResourceTypeBindingDescriptors();
			for (int i = 0; i < rtDescs.length; i++) {
				ResourceTypeBindingDescriptor rtdesc = rtDescs[i];
				String context = rtdesc.getContext();
				List bindings = (List) resourceTypeBindingsByContext.get(context);
				if (bindings == null) {
					bindings = new ArrayList();
				}
				bindings.add(rtdesc);
				resourceTypeBindingsByContext.put(context, bindings);
			}
		}
	}

	private void loadResourceTypeUIBindingDescriptorMap() {
		if (domainDescriptors == null) {
			return;
		}
		resourceTypeUIBindingsById = new HashMap();
		Iterator ddi = domainDescriptors.iterator();
		while (ddi.hasNext()) {
			DomainDescriptor dd = (DomainDescriptor) ddi.next();
			if (dd == null) {
				continue;
			}
			ResourceTypeUIBindingDescriptor[] rtDescs = dd.getResourceTypeUIBindingDescriptors();
			for (int i = 0; i < rtDescs.length; i++) {
				ResourceTypeUIBindingDescriptor rtdesc = rtDescs[i];
				String resourceTypeId = rtdesc.getResourceTypeId();
				resourceTypeUIBindingsById.put(resourceTypeId, rtdesc);
			}
		}
	}
}
