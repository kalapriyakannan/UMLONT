/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.filter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Suggests {@link Unit} types to be hosted by an {@link WebsphereAppServerUnit}.
 * 
 * @since 3.2
 * @see WebsphereAppServerUnit
 */
public class WebsphereAppServerUnitFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableHostingTemplates(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<?> getAllowableConfigurationUnitTypes(Unit anInputUnit) {
		List<Object> list = new ArrayList<Object>();

		List<String> providerList = new ArrayList<String>();
		List<String> messagingFactoryList = new ArrayList<String>();
		List<String> messagingUnitList = new ArrayList<String>();

		List<Unit> ports = ValidatorUtils.getHosted(anInputUnit, OsPackage.Literals.PORT_CONFIG_UNIT);
		int numPorts = ports.size();
		Object value = CapabilityUtil.getAttributeFromUnitCapability(anInputUnit,
				WasPackage.Literals.WAS_SERVER__WAS_VERSION, WasPackage.Literals.WAS_SERVER);
		if (!(value instanceof String)) {
			value = null;
		}
		String version = (String) value;

		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_UNIT);
		list.add(providerList);

		if (anInputUnit.isConceptual()) {
			list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_CLASS_WAS_SERVER_CLASS_LOADER_POLICY);
			if (0 == numPorts) {
				if (null != version) {
					if (version.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
						list.add(IWasTemplateConstants.WAS_5_PORT_CONFIGURATION_UNIT_CONCEPTUAL);
					} else if (version.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
						list.add(IWasTemplateConstants.WAS_6_PORT_CONFIGURATION_UNIT_CONCEPTUAL);
					}
				}
			}

			list.add(IWasTemplateConstants.WAS_ENDPOINT_LISTENER_UNIT_CONCEPTUAL);
			messagingFactoryList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT_CONCEPTUAL);
			messagingFactoryList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT_CONCEPTUAL);
			messagingFactoryList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT_CONCEPTUAL);
			list.add(messagingFactoryList);
			messagingUnitList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT_CONCEPTUAL);
			messagingUnitList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT_CONCEPTUAL);
			list.add(messagingUnitList);
			list.add(IWasTemplateConstants.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT_CONCEPTUAL);
			if (null == ValidatorUtils.discoverGroupByUnitType(anInputUnit,
					WasPackage.Literals.WAS_CLUSTER_UNIT, new NullProgressMonitor())) {
				list.add(IWasTemplateConstants.WAS_MESSAGING_ENGINE_CONCEPTUAL);
			}

		} else {
			list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT);
			list.add(IWasTemplateConstants.WAS_CLASS_WAS_SERVER_CLASS_LOADER_POLICY);
			if (0 == numPorts) {
				if (null != version) {
					if (version.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
						list.add(IWasTemplateConstants.WAS_5_PORT_CONFIGURATION_UNIT);
					} else if (version.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
						list.add(IWasTemplateConstants.WAS_6_PORT_CONFIGURATION_UNIT);
					}
				}
			}

			list.add(IWasTemplateConstants.WAS_ENDPOINT_LISTENER_UNIT);
			messagingFactoryList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_UNIT);
			messagingFactoryList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_UNIT);
			messagingFactoryList
					.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_UNIT);
			list.add(messagingFactoryList);
			messagingUnitList.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT);
			messagingUnitList.add(IWasTemplateConstants.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT);
			list.add(messagingUnitList);
			list.add(IWasTemplateConstants.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT);
			if (null == ValidatorUtils.discoverGroupByUnitType(anInputUnit,
					WasPackage.Literals.WAS_CLUSTER_UNIT, new NullProgressMonitor())) {
				list.add(IWasTemplateConstants.WAS_MESSAGING_ENGINE);
			}
		}
		return list;
	}

	public List<EClass> getAllowableUnitHostingTypes(Unit anInputUnit) {
		List<EClass> list = new ArrayList<EClass>();

		list.add(J2eePackage.Literals.WEB_MODULE);
		list.add(J2eePackage.Literals.EAR_MODULE);

		list.add(JavaPackage.Literals.JDBC_PROVIDER_UNIT);

		list.add(WasPackage.Literals.WAS_DEFAULT_MESSAGING_CONNECTION_FACTORY_CONFIGURATION);
		list.add(WasPackage.Literals.WAS_DEFAULT_MESSAGING_QUEUE_CONNECTION_FACTORY_CONFIGURATION);
		list.add(WasPackage.Literals.WAS_DEFAULT_MESSAGING_TOPIC_CONNECTION_FACTORY_CONFIGURATION);
		list.add(WasPackage.Literals.WAS_DEFAULT_MESSAGING_QUEUE_DESTINATION_UNIT);
		list.add(WasPackage.Literals.WAS_DEFAULT_MESSAGING_TOPIC_DESTINATION_UNIT);
		list.add(WasPackage.Literals.WAS_JMS_ACTIVATION_SPECIFICATION_UNIT);

		list.add(WasPackage.Literals.WAS_SHARED_LIBRARY_ENTRY_UNIT);
		list.add(WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT);
		if (0 == ValidatorUtils.getHosted(anInputUnit, OsPackage.Literals.PORT_CONFIG_UNIT).size()) {
			list.add(OsPackage.Literals.PORT_CONFIG_UNIT);
		}

		list.add(WasPackage.Literals.WAS_ENDPOINT_LISTENER_UNIT);

		if (null == ValidatorUtils.discoverGroupByUnitType(anInputUnit,
				WasPackage.Literals.WAS_CLUSTER_UNIT, new NullProgressMonitor())) {
			list.add(WasPackage.Literals.WAS_MESSAGING_ENGINE_UNIT);
		}

		return list;
	}

	/**
	 * *@Override
	 */
	public boolean isVolatile() {
		// Prevent caching in order to update the list based on model changes 
		return true;
	}
}
