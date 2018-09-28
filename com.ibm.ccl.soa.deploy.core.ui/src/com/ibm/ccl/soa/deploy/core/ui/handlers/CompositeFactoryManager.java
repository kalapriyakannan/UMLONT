/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.infrastructure.assertion.Assert;
import com.ibm.ccl.soa.infrastructure.emf.RegistryReader;

/**
 * Composite Factory Manager wraps the <b>com.ibm.ccl.soa.deploy.core.ui.compositeFactories</b>.
 * 
 */
public class CompositeFactoryManager {
	/**
	 * Singleton instance of the CompositeFactoryManager
	 */
	public static final CompositeFactoryManager INSTANCE = new CompositeFactoryManager();
	private static final CompositeFactoryDescriptor[] NO_ELEMENTS_COMPOSITE_FACTORY_DESCRIPTOR = new CompositeFactoryDescriptor[0];

	private final Set<CompositeFactoryDescriptor> compositeFactoryDescriptors = new HashSet<CompositeFactoryDescriptor>();

	private CompositeFactoryManager() {
		new CompositeFactoryRegistry().readRegistry();
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public CompositeFactoryDescriptor[] findAllCompositeFactoryDescriptors() {
		if (compositeFactoryDescriptors.isEmpty()) {
			return NO_ELEMENTS_COMPOSITE_FACTORY_DESCRIPTOR;
		}

		return compositeFactoryDescriptors
				.toArray(new CompositeFactoryDescriptor[compositeFactoryDescriptors.size()]);
	}

	/**
	 * TODO
	 * 
	 * @param obj
	 * @return
	 */
	public CompositeFactoryDescriptor[] findCompositeFactoryDescriptorsForObject(Object obj) {
		List<CompositeFactoryDescriptor> list = new ArrayList<CompositeFactoryDescriptor>();
		if (compositeFactoryDescriptors.isEmpty()) {
			return NO_ELEMENTS_COMPOSITE_FACTORY_DESCRIPTOR;
		}

		CompositeFactoryDescriptor[] allDescriptors = findAllCompositeFactoryDescriptors();
		for (int i = 0; i < allDescriptors.length; i++) {
			if (allDescriptors[i].isEnabled(obj)) {
				list.add(allDescriptors[i]);
			}
		}

		if (list.isEmpty()) {
			return NO_ELEMENTS_COMPOSITE_FACTORY_DESCRIPTOR;
		}

		return list.toArray(new CompositeFactoryDescriptor[list.size()]);
	}

	private void addCompositeFactoryDescriptor(CompositeFactoryDescriptor descriptor) {
		Assert.isNotNull(descriptor);
		compositeFactoryDescriptors.add(descriptor);
	}

	/**
	 * Does the low level work of parsing the Eclipse registry.
	 * 
	 * @since 1.0
	 * 
	 */
	private class CompositeFactoryRegistry extends RegistryReader implements
			IDeployCoreUIExtensionConstants {

		private CompositeFactoryRegistry() {
			super(Platform.getExtensionRegistry(), DeployCoreUIPlugin.PLUGIN_ID,
					COMPOSITE_FACTORIES_EXT_POINT_ID);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_COMPOSITE_FACTORY.equals(element.getName())) {
				addCompositeFactoryDescriptor(new CompositeFactoryDescriptor(element));
				return true;
			}
			return false;
		}
	}
}
