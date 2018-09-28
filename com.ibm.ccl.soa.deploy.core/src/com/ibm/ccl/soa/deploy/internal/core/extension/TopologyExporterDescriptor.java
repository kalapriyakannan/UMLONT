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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.TopologyExporter;
import com.ibm.ccl.soa.deploy.core.extension.ITopologyExporterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a layer around an IConfigurationElement from
 * <b>com.ibm.ccl.soa.deploy.core.topology/exporter</b>
 * 
 * @since 1.0
 * 
 */
public class TopologyExporterDescriptor extends CommonDescriptor implements
		ITopologyExporterDescriptor {
	/**
	 * Create a descriptor for elements with the name "exporter" that are defined as part of a
	 * <b>com.ibm.ccl.soa.deploy.core.topology</b> extension point.
	 * 
	 * @param anElement
	 *           An element with the name "exporter" that conforms to the schema of
	 *           <b>com.ibm.ccl.soa.deploy.core.topology/exporter</b>.
	 */
	public TopologyExporterDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_EXPORTER.equals(anElement.getName());
	}

	/**
	 * The exporter created by this method will not be cached. Clients of this method are required to
	 * manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link TopologyExporter} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public TopologyExporter createTopologyExporter() {
		try {
			Object exporter = getElement().createExecutableExtension(ATT_CLASS);
			if (exporter instanceof TopologyExporter) {
				return (TopologyExporter) exporter;
			}

			String errMsg = NLS.bind(
					DeployCoreMessages.TopologyExporterDescriptor_An_instance_of_0_is_required_fo_,
					new Object[] { TopologyExporter.class.getName(), ATT_CLASS,
							getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return SkeletonTopologyExporter.INSTANCE;
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
