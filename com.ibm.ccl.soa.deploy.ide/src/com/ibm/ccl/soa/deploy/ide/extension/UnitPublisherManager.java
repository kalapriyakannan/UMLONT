/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.extension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jem.util.RegistryReader;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.publisher.UnitPublisher;
import com.ibm.ccl.soa.deploy.internal.core.extension.ICommonDeployExtensionConstants;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderDescriptor;

/**
 * Parse the <b>com.ibm.ccl.soa.deploy.core.unitLifecycle</b> extension point into structures that
 * can be more easily manipulated.
 * 
 * @since 1.0
 * 
 */
public class UnitPublisherManager {

	private static final UnitPublisherManager instance = new UnitPublisherManager();

	private static final UnitPublisherDescriptor[] NO_ELEMENTS = new UnitPublisherDescriptor[0];

	private final Set unitPublishers = new HashSet();

	/**
	 * @return The singleton instance of the UnitPublisherManager.
	 */
	public static UnitPublisherManager getInstance() {
		return instance;
	}

	private UnitPublisherManager() {
		new UnitPublisherRegistry().readRegistry();
	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitPublisher}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitPublisher}.
	 * 
	 * 
	 * @param aUnit
	 *           A Unit
	 * @return An array of enabled topology Unit Publisher extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitPublisherDescriptor[] findEnabledUnitPublishers(Unit aUnit) {
		List enabledPublishers = new ArrayList();

		UnitPublisherDescriptor descriptor;
		for (Iterator elementsItr = unitPublishers.iterator(); elementsItr.hasNext();) {
			descriptor = (UnitPublisherDescriptor) elementsItr.next();
			if (descriptor.isEnabled(aUnit))
				enabledPublishers.add(descriptor);
		}
		if (enabledPublishers.size() == 0)
			return NO_ELEMENTS;
		return (UnitPublisherDescriptor[]) enabledPublishers
				.toArray(new UnitPublisherDescriptor[enabledPublishers.size()]);

	}

	private void addUnitPublisherDescriptor(UnitPublisherDescriptor element) {
		unitPublishers.add(element);
	}

	/**
	 * Does the low level work of parsing the Eclipse registry.
	 * 
	 * @since 1.0
	 * 
	 */
	private class UnitPublisherRegistry extends RegistryReader implements
			ICommonDeployExtensionConstants {

		private UnitPublisherRegistry() {
			super(IDEPlugin.PLUGIN_ID, TAG_UNIT_PUBLISHER);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_UNIT_PUBLISHER.equals(element.getName())) {
				addUnitPublisherDescriptor(new UnitPublisherDescriptor(element));
				return true;
			}
			return false;
		}

	}
}
