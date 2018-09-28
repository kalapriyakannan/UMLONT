/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Suggests {@link Unit} types to be hosted by an {@link WasCellUnit}.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see WasCellUnit
 */
public class WebsphereCellUnitFilter extends UnitFilter {

	public List<?> getAllowableHostingUnitTypes(Unit anInputUnit) {

		List<Object> list = new ArrayList<Object>();
		List<String> providerList = new ArrayList<String>();
		List<String> messagingFactoryList = new ArrayList<String>();
		List<String> messagingUnitList = new ArrayList<String>();

		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_UNIVERSAL_JDBC_PROVIDER_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_XA_UNIT);
		providerList.add(IWasTemplateConstants.WAS_DB2_LEGACY_TYPE2_JDBC_PROVIDER_UNIT);

		WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(anInputUnit, WasPackage.eINSTANCE
				.getWasCell());
		if (wasCellCap == null || wasCellCap.getWasVersion() == null) {
			// nothing extra added
		} else if (wasCellCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			if (wasCellCap.isIsDistributed()) {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_6_CLUSTER_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_6_CLUSTER_UNIT)) {
					;
				}
			}
		} else if (wasCellCap.getWasVersion().startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			if (wasCellCap.isIsDistributed()) {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_5_CLUSTER_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_5_CLUSTER_UNIT)) {
					;
				}
			}
		}

		list.add(providerList);
		if (anInputUnit.isConceptual()) {
			list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_J2C_AUTHENTICATION_UNIT);

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
			list.add(IWasTemplateConstants.WAS_SHARED_LIBRARY_ENTRY_UNIT);
			list.add(IWasTemplateConstants.WAS_J2C_AUTHENTICATION_UNIT);
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

	public List<String> getAllowableMemberUnitTypes(Unit anInputUnit) {

		List<String> list = new ArrayList<String>();
		WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(anInputUnit, WasPackage.eINSTANCE
				.getWasCell());

		if (wasCellCap == null || wasCellCap.getWasVersion() == null) {
			if (anInputUnit.isConceptual() ? list
					.add(IWasTemplateConstants.WAS_6_NODE_UNIT_CONCEPTUAL) : list
					.add(IWasTemplateConstants.WAS_6_NODE_UNIT)) {
				;
			}
		} else if (wasCellCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			if (wasCellCap.isIsDistributed() == true) {
				//offer Dmgr only if no one is contained yet and if underlying system is no Base System
				if (WasUtil.getDeploymentManager((WasCellUnit) anInputUnit) == null
						&& !WasUtil.isCellHostedOnBaseSystem((WasCellUnit) anInputUnit)) {
					if (anInputUnit.isConceptual() ? list
							.add(IWasTemplateConstants.WAS_6_DMGR_NODE_UNIT_CONCEPTUAL) : list
							.add(IWasTemplateConstants.WAS_6_DMGR_NODE_UNIT)) {
						;
					}
				}
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_6_NODE_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_6_NODE_UNIT)) {
					;
				}
				//offer node Group only if the cell is hosted on a ND System or if there is no node group already
				if (!WasUtil.isCellHostedOnBaseSystem((WasCellUnit) anInputUnit)
						|| WasUtil.getWasNodeGroupsFromCell((WasCellUnit) anInputUnit,
								anInputUnit.getTopology()).size() < 1) {
					if (anInputUnit.isConceptual() ? list
							.add(IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT_CONCEPTUAL) : list
							.add(IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT)) {
						;
					}
				}
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_SIBUS_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_SIBUS_UNIT)) {
					;
				}
			} else {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_6_NODE_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_6_NODE_UNIT)) {
					;
				}
				//offer node Group only there is no one contained yet
				if (WasUtil.getWasNodeGroupsFromCell((WasCellUnit) anInputUnit,
						anInputUnit.getTopology()).size() < 1) {
					if (anInputUnit.isConceptual() ? list
							.add(IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT_CONCEPTUAL) : list
							.add(IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT)) {
						;
					}
				}
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_SIBUS_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_SIBUS_UNIT)) {
					;
				}

			}

		} else {
			if (wasCellCap.isIsDistributed() == true) {
				//offer Dmgr only if no one is contained yet and if underlying system is no Base System
				if (WasUtil.getDeploymentManager((WasCellUnit) anInputUnit) == null
						&& !WasUtil.isCellHostedOnBaseSystem((WasCellUnit) anInputUnit)) {
					if (anInputUnit.isConceptual() ? list
							.add(IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT_CONCEPTUAL) : list
							.add(IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT)) {
						;
					}
				}
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_5_NODE_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_5_NODE_UNIT)) {
					;
				}
				/*
				 * if (anInputUnit.isConceptual() ? list
				 * .add(IWasTemplateConstants.WAS_5_CLUSTER_UNIT_CONCEPTUAL) : list
				 * .add(IWasTemplateConstants.WAS_5_CLUSTER_UNIT)) { ; }
				 */
			} else {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_5_NODE_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_5_NODE_UNIT)) {
					;
				}
			}
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
