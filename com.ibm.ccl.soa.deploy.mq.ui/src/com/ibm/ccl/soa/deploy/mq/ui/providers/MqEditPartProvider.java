/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.mq.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.mq.MqPackage;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQActivationSpecificationUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQBaseSystemUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQConnectionFactoriesUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQListenerUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQMessageListnerServicePortUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQMessagingProviderUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQQueueChannelUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQQueueConnectionFactoryUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQQueueDestinationUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQQueueManagerUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQQueueUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQTopicConnectionFactoryUnitEditPart;
import com.ibm.ccl.soa.deploy.mq.ui.editparts.MQTopicDestinationUnitEditPart;


/**
 * Deploy tool Edit Part provider for Mq domain.
 * 
 */
public class MqEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(MqPackage.eINSTANCE.getMQActivationSpecificationUnit(), MQActivationSpecificationUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQBaseSystemUnit(), MQBaseSystemUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQConnectionFactoriesUnit(), MQConnectionFactoriesUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQListenerUnit(), MQListenerUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQMessageListnerServicePortUnit(), MQMessageListnerServicePortUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQMessagingProviderUnit(), MQMessagingProviderUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQQueueChannelUnit(), MQQueueChannelUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQQueueConnectionFactoryUnit(), MQQueueConnectionFactoryUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQQueueDestinationUnit(), MQQueueDestinationUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQQueueManagerUnit(), MQQueueManagerUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQQueueUnit(), MQQueueUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQTopicConnectionFactoryUnit(), MQTopicConnectionFactoryUnitEditPart.class);
		nodeMap.put(MqPackage.eINSTANCE.getMQTopicDestinationUnit(), MQTopicDestinationUnitEditPart.class);
	}

	/**
	 * Gets a Node's editpart class.
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		Class<?> clazz = null;
		EClass eClass = getReferencedElementEClass(view);
		if (eClass != null) {
			clazz = ((Class<?>) nodeMap.get(eClass));
		}

		return clazz;
	}
}
