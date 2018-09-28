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
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Suggests {@link Unit} types to be hosted by an {@link WasClusterUnit}.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see WasClusterUnit
 */
public class WebsphereClusterUnitFilter extends UnitFilter {

	public List<?> getAllowableMemberUnitTypes(Unit anInputUnit) {
		List<Object> list = new ArrayList<Object>();
		List<String> messagingFactoryList = new ArrayList<String>();
		List<String> messagingUnitList = new ArrayList<String>();
		List<String> providerList = new ArrayList<String>();

		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_UNIT);

		WasCluster clusterCap = (WasCluster) ValidatorUtils.getCapability(anInputUnit,
				WasPackage.eINSTANCE.getWasCluster());
		if (null == clusterCap) {
			return Collections.emptyList();
		}
		if (anInputUnit.isConceptual()) {
			if (clusterCap.getWasVersion().startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				list.add(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT_CONCEPTUAL);
			} else {
				List<String> serverList = new ArrayList<String>();
				serverList.add(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT_CONCEPTUAL);
				serverList.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT_CONCEPTUAL);
				list.add(serverList);
				list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT_CONCEPTUAL);
			}
			list.add(providerList);
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
		} else {
			if (clusterCap.getWasVersion().startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				list.add(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT);
			} else {
				List<String> serverList = new ArrayList<String>();
				serverList.add(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT);
				serverList.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT);
				list.add(serverList);
			}
			list.add(providerList);
			list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT);
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
		}

		return list;
	}

	@Override
	public List getAllowableHostingUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();

		if (anInputUnit.isConceptual()) {
			list.add(IWasTemplateConstants.WAS_MESSAGING_ENGINE_CONCEPTUAL);
		} else {
			list.add(IWasTemplateConstants.WAS_MESSAGING_ENGINE);
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
