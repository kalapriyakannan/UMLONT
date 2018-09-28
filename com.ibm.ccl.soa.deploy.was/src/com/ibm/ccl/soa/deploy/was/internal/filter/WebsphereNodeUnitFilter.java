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
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Suggests {@link Unit} types to be contained by an {@link WasNodeUnit}.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see WasNodeUnit
 */
public class WebsphereNodeUnitFilter extends UnitFilter {

	public List getAllowableHostingUnitTypes(Unit anInputUnit) {
		WasNode wasNodeCap = (WasNode) ValidatorUtils.getCapability(anInputUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (wasNodeCap == null) {
			return Collections.EMPTY_LIST;
		}

		// Deployment manager nodes can only host the deployment manager unit
		if (wasNodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
			//return empty list if DMGR node already hosts a DMGR unit
			if (ValidatorUtils.getHosted(anInputUnit, WasPackage.Literals.WAS_DEPLOYMENT_MANAGER_UNIT)
					.size() >= 1) {
				return Collections.EMPTY_LIST;
			}
			if (wasNodeCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
				if (anInputUnit.isConceptual()) {
					return Collections.singletonList(IWasTemplateConstants.WAS_6_DMGR_UNIT_CONCEPTUAL);
				} else {
					return Collections.singletonList(IWasTemplateConstants.WAS_6_DMGR_UNIT);
				}
			} else {
				if (anInputUnit.isConceptual()) {
					return Collections.singletonList(IWasTemplateConstants.WAS_5_DMGR_UNIT_CONCEPTUAL);
				} else {
					return Collections.singletonList(IWasTemplateConstants.WAS_5_DMGR_UNIT);
				}
			}
		}

		// Unmanaged nodes can only host web servers.
		if (wasNodeCap.getProfileType().equals(WasProfileTypeEnum.NONE_LITERAL)) {
			if (anInputUnit.isConceptual()) {
				return Collections.singletonList(IWasTemplateConstants.WAS_WEB_SERVER_UNIT_CONCEPTUAL);
			} else {
				return Collections.singletonList(IWasTemplateConstants.WAS_WEB_SERVER_UNIT);
			}
		}

		List list = new ArrayList();
		if (wasNodeCap.getWasVersion() != null) {
			if (wasNodeCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT)) {
					;
				}
			} else {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT)) {
					;
				}
			}
		}

		List<String> messagingFactoryList = new ArrayList<String>();
		List<String> messagingUnitList = new ArrayList<String>();
		List<String> providerList = new ArrayList<String>();

		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_UNIT);
		list.add(providerList);

		if (anInputUnit.isConceptual()) {
			//list.add(IWasTemplateConstants.WAS_WEB_SERVER_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT_CONCEPTUAL);
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
			list.add(IWasTemplateConstants.WAS_NODE_WINDOWS_SERVICE_UNIT_CONCEPTUAL);
		} else {
			//list.add(IWasTemplateConstants.WAS_WEB_SERVER_UNIT);
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
			list.add(IWasTemplateConstants.WAS_NODE_WINDOWS_SERVICE_UNIT);
		}

		return list;
	}

	//	public List<String> getAllowableMemberUnitTypes(Unit anInputUnit) {
	//		return Collections.EMPTY_LIST;
	//	}

	/**
	 * *@Override
	 */
	public boolean isVolatile() {
		// Prevent caching in order to update the list based on model changes 
		return true;
	}
}
