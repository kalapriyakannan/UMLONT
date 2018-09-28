/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.AppClientModuleEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.EARModuleEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.EjbModuleEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.GenericJ2EEServerEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.GenericWebServerEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.J2EEConfigurationUnitEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.JCAModuleEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.JarModuleEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.editparts.WebComponentEditPart;
import com.ibm.ccl.soa.deploy.j2ee.ui.util.J2EEConstants;

/**
 * J2EE tool Edit Part provider.
 * 
 * @see EARModuleEditPart
 * @see EjbModuleEditPart
 * @see JCAModuleEditPart
 * @see AppClientModuleEditPart
 * @see AppClientModuleEditPart
 * @see WebComponentEditPart
 * 
 * @see J2EEConfigurationUnitEditPart
 * 
 * @see GenericWebServerEditPart
 * @see GenericJ2EEServerEditPart
 */
public class J2EEEditPartProvider extends AbstractEditPartProvider {

//	 Map to hold the Shape Views
	private Map nodeHintMap = new HashMap();
	{
		nodeHintMap.put(J2EEConstants.CONFIGURATION_J2EE_SEMANTICHINT,
				J2EEConfigurationUnitEditPart.class);
		nodeHintMap.put(J2EEConstants.COMPONENT_WEB_SEMANTICHINT, WebComponentEditPart.class);
		nodeHintMap.put(J2EEConstants.COMPONENT_EAR_SEMANTICHINT, EARModuleEditPart.class);
		nodeHintMap.put(J2EEConstants.COMPONENT_EJB_SEMANTICHINT, EjbModuleEditPart.class);
		nodeHintMap.put(J2EEConstants.COMPONENT_JAR_SEMANTICHINT, JarModuleEditPart.class);
	}

	/** list of supported shape editparts. */
	private Map nodeMap = new HashMap();
	{
		nodeMap.put(J2eePackage.eINSTANCE.getEarModule(), EARModuleEditPart.class);
		nodeMap.put(J2eePackage.eINSTANCE.getEjbModule(), EjbModuleEditPart.class);
		nodeMap.put(J2eePackage.eINSTANCE.getJCAModule(), JCAModuleEditPart.class);
		nodeMap.put(J2eePackage.eINSTANCE.getAppClient(), AppClientModuleEditPart.class);
		nodeMap.put(J2eePackage.eINSTANCE.getWebModule(), WebComponentEditPart.class);
		nodeMap.put(J2eePackage.eINSTANCE.getJarModule(), JarModuleEditPart.class);

		nodeMap.put(J2eePackage.eINSTANCE.getGenericWebServer(), GenericWebServerEditPart.class);
		nodeMap.put(J2eePackage.eINSTANCE.getGenericJ2eeServer(), GenericJ2EEServerEditPart.class);
	}

	/**
	 * Gets a Node's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	protected Class getNodeEditPartClass(View view) {
		Class clazz = null;
		String semanticHint = view.getType();
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = (Class) nodeHintMap.get(semanticHint);
		} else {
			clazz = ((Class) nodeMap.get(getReferencedElementEClass(view)));
		}

		return clazz;
	}
} // end class J2EEEditPartProvider
