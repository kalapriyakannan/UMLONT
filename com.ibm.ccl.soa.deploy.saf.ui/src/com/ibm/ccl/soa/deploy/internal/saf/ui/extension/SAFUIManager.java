/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.ibm.ccl.soa.deploy.internal.saf.ui.SAFUIPlugin;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;
import com.ibm.ccl.soa.infrastructure.emf.RegistryReader;

/**
 * Parse the <b>com.ibm.ccl.soa.core.saf.handlers</b> extension point into structures that can be
 * more easily manipulated.
 */
public class SAFUIManager {

	private static final SAFUIManager instance = new SAFUIManager();

	private static final UIHandlerDescriptor[] NO_ELEMENTS_INTERFACE_HANDLER_DESCRIPTOR = new UIHandlerDescriptor[0];

	private final Map<String, Map<String, UIHandlerDescriptor>> descriptors = new HashMap<String, Map<String, UIHandlerDescriptor>>();

	/**
	 * @return The singleton instance of the UnitDiscovererManager.
	 */
	public static SAFUIManager getInstance() {
		return instance;
	}

	private SAFUIManager() {
		new SAFUIRegistry().readRegistry();
	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * 
	 * @return An array of enabled topology Unit Filter extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UIHandlerDescriptor[] findAllUIHandlerDescriptors(String type) {
		synchronized (descriptors) {

			Map<String, UIHandlerDescriptor> typeDescriptors = descriptors.get(type);
			if (typeDescriptors == null || typeDescriptors.size() == 0) {
				return NO_ELEMENTS_INTERFACE_HANDLER_DESCRIPTOR;
			}

			return typeDescriptors.values().toArray(new UIHandlerDescriptor[typeDescriptors.size()]);

		}

	}

	public UIHandlerDescriptor findUIHandlerDescriptorFor(String type, String interfaceKind) {
		synchronized (descriptors) {

			Map<String, UIHandlerDescriptor> typeDescriptors = descriptors.get(type);
			if (typeDescriptors == null || typeDescriptors.size() == 0) {
				return null;
			}

			return typeDescriptors.get(interfaceKind);

		}
	}

	private void addUIHandlerDescriptor(String type, UIHandlerDescriptor descriptor) {
		Assert.isNotNull(descriptor);
		synchronized (descriptors) {
			Map<String, UIHandlerDescriptor> typeDescriptors = descriptors.get(type);
			if (typeDescriptors == null) {
				descriptors.put(type, typeDescriptors = new HashMap<String, UIHandlerDescriptor>());
			}
			typeDescriptors.put(descriptor.getKind(), descriptor);
		}
	}

	/**
	 * Does the low level work of parsing the Eclipse registry.
	 * 
	 * @since 1.0
	 * 
	 */
	private class SAFUIRegistry extends RegistryReader implements ISAFUIExtensionConstants {

		private SAFUIRegistry() {
			super(Platform.getExtensionRegistry(), SAFUIPlugin.PLUGIN_ID, UIHANDLERS_EXT_POINT_ID);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_INTERFACE_UIHANDLER.equals(element.getName())) {
				addUIHandlerDescriptor(TAG_INTERFACE_UIHANDLER, new UIHandlerDescriptor(element));
				return true;
			} else if (TAG_ARTIFACT_UIHANDLER.equals(element.getName())) {
				addUIHandlerDescriptor(TAG_ARTIFACT_UIHANDLER, new UIHandlerDescriptor(element));
				return true;
			}

			return false;
		}
	}
}
