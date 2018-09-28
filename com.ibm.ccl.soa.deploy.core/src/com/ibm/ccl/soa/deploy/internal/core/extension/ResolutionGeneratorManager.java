/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jem.util.RegistryReader;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Parse the <b>{@link DeployCorePlugin#PLUGIN_ID}.{@link ICommonDeployExtensionConstants#TAG_RESOLUTION_GENERATORS}</b>
 * extension point into structures that can be more easily manipulated.
 */
public class ResolutionGeneratorManager {

	/*
	 * We initialize the instance up front to force the read of the registry in the constructor and
	 * therefore avoid any potential concurrency issues.
	 */
	private static final ResolutionGeneratorManager instance = new ResolutionGeneratorManager();

	/**
	 * List of all valid resolution descriptors.
	 */
	private final List<ResolutionGeneratorDescriptor> resolutionDescriptorList = new ArrayList<ResolutionGeneratorDescriptor>();

	/**
	 * Maps the global ID to a the resolution descriptor.
	 * <p>
	 * 
	 * @see ResolutionGeneratorDescriptor#getGlobalId()
	 */
	private final Map<String, ResolutionGeneratorDescriptor> globalIdToResolutionDescriptorMap = new LinkedHashMap<String, ResolutionGeneratorDescriptor>();

	/**
	 * Cached conversion of resolution descriptor list to an array.
	 */
	private ResolutionGeneratorDescriptor[] resolutionDescriptors = null;

	/**
	 * @return The singleton instance of the DomainManager.
	 */
	public static ResolutionGeneratorManager getInstance() {
		return instance;
	}

	private ResolutionGeneratorManager() {
		ResolutionRegistry registry = new ResolutionRegistry();
		registry.readRegistry();
	}

	/**
	 * Returns the resolution generator descriptors declared in all plugin.xml files.
	 * 
	 * @return an array of resolution generator descriptors (never null).
	 */
	public ResolutionGeneratorDescriptor[] getResolutionGeneratorDescriptors() {
		if (resolutionDescriptors == null) {
			resolutionDescriptors = resolutionDescriptorList
					.toArray(new ResolutionGeneratorDescriptor[resolutionDescriptorList.size()]);
		}
		return resolutionDescriptors;
	}

	/** An empty array of resolution generator descriptors. */
	public static final ResolutionGeneratorDescriptor[] EMPTY_RESOLUTION_ARRAY = new ResolutionGeneratorDescriptor[0];

	/**
	 * Returns the resolution generator descriptors for the deploy status.
	 * 
	 * @param status
	 *           a status that may be a deploy status, or contain deploy status.
	 * @return an array of resolution generator descriptors (never null).
	 */
	public ResolutionGeneratorDescriptor[] getResolutionGeneratorDescriptors(IStatus status) {
		List<ResolutionGeneratorDescriptor> list = null;
		ResolutionGeneratorDescriptor[] allDescriptors = getResolutionGeneratorDescriptors();
		for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
			IDeployStatus deployStatus = iter.next();
			for (int i = 0; i < allDescriptors.length; i++) {
				if (allDescriptors[i].isEnabled(deployStatus)) {
					if (list == null) {
						list = new ArrayList<ResolutionGeneratorDescriptor>();
					}
					list.add(allDescriptors[i]);
				}
			}
		}

		if (list == null) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		return list.toArray(new ResolutionGeneratorDescriptor[list.size()]);
	}

	/**
	 * Returns true if the status has a resolution generator descriptor.
	 * 
	 * @param status
	 *           a status that may be a deploy status, or contains one.
	 * @return true if the status is or contains a deploy status, and there are resolution generator
	 *         descriptions that are enabled for it.
	 */
	public boolean hasResolutionGeneratorDescriptors(IStatus status) {
		ResolutionGeneratorDescriptor[] allDescriptors = getResolutionGeneratorDescriptors();
		for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
			IDeployStatus deployStatus = iter.next();
			for (int i = 0; i < allDescriptors.length; i++) {

				if (allDescriptors[i].isEnabled(deployStatus)) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Returns the resolution descriptor mapped to the global resolution ID.
	 * 
	 * @param globalId
	 *           a global resolution ID (plugin-ID + "." + resolutionID).
	 * 
	 * @return the resolution descriptor, or null if not found.
	 */
	public ResolutionGeneratorDescriptor getResolutionDescriptor(String globalId) {
		return globalIdToResolutionDescriptorMap.get(globalId);
	}

	/**
	 * Add a resolution descriptor to the list.
	 * 
	 * @param aDescriptor
	 */
	private boolean addResolutionDescriptor(ResolutionGeneratorDescriptor aDescriptor) {
		Assert.isNotNull(aDescriptor);
		if (!aDescriptor.getStatus().isOK()) {
			return false;
		}
		resolutionDescriptorList.add(aDescriptor);
		// invalidate cache
		resolutionDescriptors = null;
		String globalId = aDescriptor.getGlobalId();
		if (globalIdToResolutionDescriptorMap.containsKey(globalId)) {
			ResolutionGeneratorDescriptor existing = globalIdToResolutionDescriptorMap.get(globalId);
			String message = NLS.bind(
					DeployCoreMessages.ResolutionManager_Duplicate_resolution_id_0_found_in_0_and_1,
					new Object[] { globalId, existing.getName(), existing.getName() });
			DeployCorePlugin.logError(0, message, null);
			return false;
		}
		globalIdToResolutionDescriptorMap.put(globalId, aDescriptor);
		return true;
	}

	/** An empty array of resolution parameterizer descriptors. */
	public final ResolutionParameterizerDescriptor[] EMPTY_PARAMETERIZER_DESCRIPTOR_ARRAY = new ResolutionParameterizerDescriptor[0];

	/**
	 * List of all valid parameterizer descriptors.
	 */
	private final List<ResolutionParameterizerDescriptor> parameterizerDescriptorList = new ArrayList<ResolutionParameterizerDescriptor>();

	/**
	 * Maps the global ID to a the parameterizer descriptor.
	 * <p>
	 * 
	 * @see ResolutionParameterizerDescriptor#getGlobalId()
	 */
	private final Map<String, ResolutionParameterizerDescriptor> globalIdToParameterizerDescriptorMap = new LinkedHashMap<String, ResolutionParameterizerDescriptor>();

	/**
	 * Cached conversion of parameterizers descriptor list to an array.
	 */
	private ResolutionParameterizerDescriptor[] parameterizerDescriptors = null;

	/**
	 * Returns the resolution parameterizer descriptors declared in all plugin.xml files.
	 * 
	 * @return an array of resolution generator descriptors (never null).
	 */
	public ResolutionParameterizerDescriptor[] getParameterizerDescriptors() {
		if (parameterizerDescriptors == null) {
			parameterizerDescriptors = resolutionDescriptorList
					.toArray(new ResolutionParameterizerDescriptor[resolutionDescriptorList.size()]);
		}
		return parameterizerDescriptors;
	}

	/**
	 * Returns the resolution generator descriptors for the deploy status.
	 * 
	 * @param resolution
	 *           a parameterized deploy resolution.
	 * @return an array of resolution generator descriptors (never null).
	 */
	public ResolutionParameterizerDescriptor[] getParameterizerDescriptors(
			IDeployParameterizedResolution resolution) {
		List<ResolutionParameterizerDescriptor> list = null;
		for (Iterator<ResolutionParameterizerDescriptor> iter = parameterizerDescriptorList
				.iterator(); iter.hasNext();) {
			ResolutionParameterizerDescriptor d = iter.next();
			if (d.isEnabled(resolution)) {
				if (list == null) {
					list = new ArrayList<ResolutionParameterizerDescriptor>();
				}
				list.add(d);
			}
		}

		if (list == null) {
			return EMPTY_PARAMETERIZER_DESCRIPTOR_ARRAY;
		}
		return list.toArray(new ResolutionParameterizerDescriptor[list.size()]);
	}

	/**
	 * Returns true if the resolution has one or more parameterizer descriptors.
	 * 
	 * @param resolution
	 *           a deploy resolution.
	 * @return true if the resolution is associated with one or more parameterizers.
	 */
	public boolean hasParameterizerDescriptors(IDeployResolution resolution) {
		for (Iterator<ResolutionParameterizerDescriptor> iter = parameterizerDescriptorList
				.iterator(); iter.hasNext();) {
			ResolutionParameterizerDescriptor d = iter.next();
			if (d.isEnabled(resolution)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the parameterizer descriptor mapped to the global parameterizer ID.
	 * 
	 * @param globalId
	 *           a global parameterizer ID (plugin-ID + "." + parameterizerID).
	 * 
	 * @return the parameterizer descriptor, or null if not found.
	 */
	public ResolutionParameterizerDescriptor getParameterizerDescriptor(String globalId) {
		return globalIdToParameterizerDescriptorMap.get(globalId);
	}

	/**
	 * Add a resolution parameterizer descriptor to the list.
	 * 
	 * @param aDescriptor
	 */
	private boolean addParameterizerDescriptor(ResolutionParameterizerDescriptor aDescriptor) {
		Assert.isNotNull(aDescriptor);
		if (!aDescriptor.getStatus().isOK()) {
			return false;
		}
		parameterizerDescriptorList.add(aDescriptor);
		// invalidate cache
		parameterizerDescriptors = null;
		String globalId = aDescriptor.getGlobalId();
		if (globalIdToParameterizerDescriptorMap.containsKey(globalId)) {
			ResolutionParameterizerDescriptor existing = globalIdToParameterizerDescriptorMap
					.get(globalId);
			String message = NLS.bind(
					DeployCoreMessages.ResolutionManager_Duplicate_parameterizer_id_0_found_in_0_and_1,
					new Object[] { globalId, existing.getName(), existing.getName() });
			DeployCorePlugin.logError(0, message, null);
			return false;
		}
		globalIdToParameterizerDescriptorMap.put(globalId, aDescriptor);
		return true;
	}

	/**
	 * Registry reader filtering resolution extension declarations.
	 */
	private class ResolutionRegistry extends RegistryReader implements
			ICommonDeployExtensionConstants {

		private ResolutionRegistry() {
			super(DeployCorePlugin.PLUGIN_ID, TAG_RESOLUTION_GENERATORS);
		}

		/*
		 * @see org.eclipse.jem.util.RegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
		 */
		public boolean readElement(IConfigurationElement element) {
			if (TAG_RESOLUTION_GENERATOR.equals(element.getName())) {

				ResolutionGeneratorDescriptor descriptor = new ResolutionGeneratorDescriptor(element);
				return addResolutionDescriptor(descriptor);
			} else if (TAG_RESOLUTION_PARAMETERIZER.equals(element.getName())) {
				ResolutionParameterizerDescriptor descriptor = new ResolutionParameterizerDescriptor(
						element);
				return addParameterizerDescriptor(descriptor);
			}
			return false;
		}

	}
}
