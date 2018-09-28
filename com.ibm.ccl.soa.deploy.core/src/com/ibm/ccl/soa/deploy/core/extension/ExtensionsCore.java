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

import com.ibm.ccl.soa.deploy.internal.core.extension.CapabilityProviderService;
import com.ibm.ccl.soa.deploy.internal.core.extension.DecoratorSemanticService;
import com.ibm.ccl.soa.deploy.internal.core.extension.DomainPackagerService;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeService;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyExporterService;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyPublisherService;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitAmplifierService;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitDiscovererService;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitFilterService;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitProviderService;

public class ExtensionsCore {

	/**
	 * 
	 * @return An implementation of {@link IUnitDiscovererService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUnitDiscovererService createDiscovererService() {
		return new UnitDiscovererService();
	}

	/**
	 * 
	 * @return An implementation of {@link IUnitAmplifierService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUnitAmplifierService createAmplifierService() {
		return new UnitAmplifierService();
	}

	/**
	 * 
	 * @return An implementation of {@link IUnitFilterService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUnitFilterService createFilterService() {
		return new UnitFilterService();
	}

	/**
	 * 
	 * @return An implementation of {@link IDecoratorSemanticService} that can provide information
	 *         and instantiated classes from the available extensions.
	 */
	public static IDecoratorSemanticService createDecoratorSemanticService() {
		return DecoratorSemanticService.getDecoratorSemantic();
	}

	/**
	 * 
	 * @return An implementation of {@link ITopologyExporterService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static ITopologyExporterService createTopologyExporterService() {
		return new TopologyExporterService();
	}

	/**
	 * 
	 * @return An implementation of {@link ITopologyPublisherService} that can provide information
	 *         and instantiated classes from the available extensions.
	 */
	public static ITopologyPublisherService createTopologyPublisherService() {
		return new TopologyPublisherService();
	}

	/**
	 * 
	 * @return An implementation of {@link IDomainPackagerService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IDomainPackagerService createDomainPackagerService() {
		return new DomainPackagerService();
	}

	/**
	 * 
	 * @return An implementation of {@link IUnitProviderService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUnitProviderService createProviderService() {
		return new UnitProviderService();
	}

	/**
	 * 
	 * @return An implementation of {@link ICapabilityProviderService} that can provide information
	 *         and instantiated classes from the available extensions.
	 */
	public static ICapabilityProviderService createCapabilityProviderService() {
		return new CapabilityProviderService();
	}

	/**
	 * 
	 * @return An implementation of {@link IResourceTypeService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IResourceTypeService createResourceTypeService() {
		return ResourceTypeService.getInstance();
	}

}
