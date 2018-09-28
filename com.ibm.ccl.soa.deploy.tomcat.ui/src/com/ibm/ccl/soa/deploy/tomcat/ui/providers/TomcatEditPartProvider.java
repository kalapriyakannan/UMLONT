/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tomcat.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.ui.editparts.TomcatDatasourceUnitEditPart;
import com.ibm.ccl.soa.deploy.tomcat.ui.editparts.TomcatModuleEditPart;
import com.ibm.ccl.soa.deploy.tomcat.ui.util.TomcatConstants;

/**
 * @author jschofie
 * 
 * Deploy tool Edit Part provider
 */
public class TomcatEditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private Map nodeHintMap = new HashMap();
	{
		nodeHintMap.put(TomcatConstants.MODULE_TOMCAT_SEMANTICHINT, TomcatModuleEditPart.class);
		nodeHintMap.put(TomcatConstants.CONFIGURATION_TOMCAT_SEMANTICHINT,
				TomcatDatasourceUnitEditPart.class);
	}

	/** list of supported shape editparts. */
	private Map nodeMap = new HashMap();
	{
		nodeMap.put(TomcatPackage.eINSTANCE.getTomcatWebServerUnit(), TomcatModuleEditPart.class);
		nodeMap.put(TomcatPackage.eINSTANCE.getTomcatDatasourceUnit(),
				TomcatDatasourceUnitEditPart.class);
	}

	/**
	 * Gets a Node's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	protected Class getNodeEditPartClass(View view) {
		String semanticHint = view.getType();

		Class clazz = null;
		if (semanticHint != null && semanticHint.length() > 0)
			clazz = (Class) nodeHintMap.get(semanticHint);
		else {
			EClass eClass = getReferencedElementEClass(view);
			if (eClass != null) {
				clazz = ((Class) nodeMap.get(eClass));
			}
		}

		return clazz;
	}
}
