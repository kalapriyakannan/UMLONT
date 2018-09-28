/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.wps.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.wps.WpsPackage;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.BPEContainerUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.BusinessRulesManagerUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.ESBUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.SIBUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.TaskContainerUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.WPSCommonEventInfrastructureUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.WpsBaseSystemUnitEditPart;
import com.ibm.ccl.soa.deploy.wps.ui.editparts.WpsSystemUnitEditPart;


/**
 * Deploy tool Edit Part provider for Wps domain.
 * 
 */
public class WpsEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(WpsPackage.eINSTANCE.getBPEContainerUnit(), BPEContainerUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getBusinessRulesManagerUnit(), BusinessRulesManagerUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getWPSESBUnit(), ESBUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getWPSSIBUnit(), SIBUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getTaskContainerUnit(), TaskContainerUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getWpsBaseSystemUnit(), WpsBaseSystemUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getWPSCommonEventInfrastructureUnit(), WPSCommonEventInfrastructureUnitEditPart.class);
		nodeMap.put(WpsPackage.eINSTANCE.getWpsSystemUnit(), WpsSystemUnitEditPart.class);
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
