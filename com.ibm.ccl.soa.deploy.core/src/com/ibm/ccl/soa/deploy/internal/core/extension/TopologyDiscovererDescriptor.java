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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.TopologyDiscoverer;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * Provides a layer around an IConfigurationElement from
 * <b>com.ibm.ccl.soa.deploy.core.topology/discoverer</b>
 * 
 * @since 1.0
 * 
 */
public class TopologyDiscovererDescriptor extends CommonDescriptor {
	/**
	 * Create a descriptor for elements with the name "discoverer" that are defined as part of a
	 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
	 * 
	 * @param anElement
	 *           An element with the name "discoverer" that conforms to the schema of
	 *           <b>com.ibm.ccl.soa.deploy.core.topology/exporter</b>.
	 */
	public TopologyDiscovererDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_DISCOVERER.equals(anElement.getName());
	}

	/**
	 * The discoverer created by this method will not be cached. Clients of this method are required
	 * to manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link TopologyDiscoverer} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public TopologyDiscoverer createTopologyDiscoverer() {
		final TopologyDiscoverer[] extension = new TopologyDiscoverer[1];
		SafeRunner.run(new DeployCoreSafeRunnable() {

			@Override
			public void run() throws Exception {
				Object discoverer = getElement().createExecutableExtension(ATT_CLASS);
				if (discoverer instanceof TopologyDiscoverer) {
					extension[0] = (TopologyDiscoverer) discoverer;
				} else {
					String errMsg = NLS
							.bind(
									DeployCoreMessages.TopologyDiscovererDescriptor_An_instance_of_0_is_required_fo_,
									new Object[] {
											TopologyDiscoverer.class.getName(),
											ATT_CLASS,
											getElement().getDeclaringExtension().getNamespaceIdentifier()
													+ IConstants.PATH_SEPARATOR
													+ getElement().getDeclaringExtension()
															.getExtensionPointUniqueIdentifier() });
					DeployCorePlugin.logError(0, errMsg, null);
				}
			}

		});

		return extension[0] != null ? extension[0] : SkeletonTopologyDiscoverer.INSTANCE;
	}

}
