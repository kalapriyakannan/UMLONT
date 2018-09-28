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

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.TopologyPublisher;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a layer around an IConfigurationElement from
 * <b>com.ibm.ccl.soa.deploy.core.topology/publisher</b>
 * 
 * @since 1.0
 * 
 */
public class TopologyPublisherDescriptor extends CommonDescriptor implements
		ITopologyPublisherDescriptor {

	/**
	 * Compares two topology publisher descriptors by their {@link #getName()}.
	 */
	public static final Comparator<ITopologyPublisherDescriptor> NAME_COMPARATOR = new Comparator<ITopologyPublisherDescriptor>() {
		public int compare(ITopologyPublisherDescriptor o1, ITopologyPublisherDescriptor o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
	};

	/**
	 * Create a descriptor for elements with the name "publisher" that are defined as part of a
	 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
	 * 
	 * @param anElement
	 *           An element with the name "publisher" that conforms to the schema of
	 *           <b>com.ibm.ccl.soa.deploy.core.topology/publisher</b>.
	 */
	public TopologyPublisherDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_PUBLISHER.equals(anElement.getName());
	}

	/**
	 * The publisher created by this method will not be cached. Clients of this method are required
	 * to manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link TopologyPublisher} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public TopologyPublisher createTopologyPublisher() {
		try {
			Object publisher = getElement().createExecutableExtension(ATT_CLASS);
			if (publisher instanceof TopologyPublisher) {
				return (TopologyPublisher) publisher;
			}

			String errMsg = NLS.bind(
					DeployCoreMessages.TopologyPublisherDescriptor_An_instance_of_0_is_required_fo_,
					new Object[] { TopologyPublisher.class.getName(), ATT_CLASS,
							getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return SkeletonTopologyPublisher.INSTANCE;
	}

	/**
	 * The name of the exporter as defined in the extension
	 * 
	 * @return the name of the exporter
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * The description of the exporter as defined in the extension
	 * 
	 * @return the description of the exporter
	 */
	public String getDescription() {
		return super.getDescription();
	}
}
