/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.synchronization.ISynchronizationParticipantDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.RegistryReader;

/**
 * A singleton manager following the Eclipse Lifecycle Extension Pattern.
 * 
 * @since 1.0
 * 
 */
public class SynchronizationParticipantManager {

	private final Set<ISynchronizationParticipantDescriptor> descriptors = new HashSet<ISynchronizationParticipantDescriptor>();

	/**
	 * The singleton instance of the manager.
	 * 
	 * @deprecated Use the singleton {@link #INSTANCE}.
	 */
	public static final SynchronizationParticipantManager INSTANCE = new SynchronizationParticipantManager();

	/**
	 * Return the singleton instance of the ImplementationParticipantManager type.
	 * 
	 * @return The singleton instance of the ImplementationParticipantManager type.
	 * @deprecated Use the singleton {@link #INSTANCE}.
	 */
	public static SynchronizationParticipantManager getInstance() {
		return INSTANCE;
	}

	private SynchronizationParticipantManager() {
		new SynchronizationParticipantRegistry().readRegistry();
	}

	/**
	 * Return a set of descriptors enabled for the software components selected in the datamodel.
	 * 
	 * @param unit
	 *           A list of {@link SynchronizationParticipantDescriptor}s to evaluate against.
	 * @return a set of descriptors enabled for the software components selected in the datamodel.
	 */
	public Set<ISynchronizationParticipantDescriptor> findDescriptorsEnabledFor(Unit unit) {
		Set<ISynchronizationParticipantDescriptor> foundDescriptors = new HashSet<ISynchronizationParticipantDescriptor>();

		for (Iterator<ISynchronizationParticipantDescriptor> iter = descriptors.iterator(); iter
				.hasNext();) {
			ISynchronizationParticipantDescriptor descriptor = iter.next();
			if (descriptor.isEnabled(unit)) {
				foundDescriptors.add(descriptor);
			}
		}
		return foundDescriptors;
	}

	/**
	 * Return a set of descriptors enabled for the software components selected in the datamodel.
	 * 
	 * @param units
	 *           A list of {@link SynchronizationParticipantDescriptor}s to evaluate against.
	 * @return a set of descriptors enabled for the software components selected in the datamodel.
	 */
	public Set<ISynchronizationParticipantDescriptor> findDescriptorsEnabledFor(Unit[] units) {
		Set<ISynchronizationParticipantDescriptor> foundDescriptors = new HashSet<ISynchronizationParticipantDescriptor>();

		boolean enabled = false;
		for (Iterator<ISynchronizationParticipantDescriptor> iter = descriptors.iterator(); iter
				.hasNext();) {
			ISynchronizationParticipantDescriptor descriptor = iter.next();
			enabled = false;
			for (int indx = 0; indx < units.length && !enabled; indx++) {

				if (descriptor.isEnabled(units[indx])) {
					foundDescriptors.add(descriptor);
					enabled = true;
				}
			}

		}
		return foundDescriptors;
	}

	private void addDescriptor(ISynchronizationParticipantDescriptor descriptor) {
		descriptors.add(descriptor);

	}

	/**
	 * A registry to parse all implementationParticipant extensions.
	 * 
	 * @since 1.0
	 * 
	 */
	private class SynchronizationParticipantRegistry extends RegistryReader implements
			ICommonDeployExtensionConstants {

		/**
		 * Create the registry
		 * 
		 */
		public SynchronizationParticipantRegistry() {
			super(Platform.getExtensionRegistry(), DeployCorePlugin.PLUGIN_ID, TAG_DOMAINS);
		}

		protected boolean readElement(IConfigurationElement element) {
			if (TAG_DOMAIN.equals(element.getName())) {
				IConfigurationElement[] children = element.getChildren("implementationParticipant"); //$NON-NLS-1$
				if (children.length > 0) {
					DeployCorePlugin
							.logError(
									0,
									"The \"implementationParticipant\" was refactored as \"synchronizationParticipant\" under the com.ibm.ccl.soa.deploy.core.domains extension (no longer under ..domains/domain, anException)", null); //$NON-NLS-1$
				}
			} else if (TAG_SYNCHRONIZATION_PARTICIPANT.equals(element.getName())) {
				addDescriptor(new SynchronizationParticipantDescriptor(element));
			}
			return true;
		}

	}

}
