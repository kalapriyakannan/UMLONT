/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.server.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ui.editparts.ServerUnitEditPart;
import com.ibm.ccl.soa.deploy.server.ui.util.ServerConstants;

/**
 * @author Ed Snible
 * 
 * Deploy tool Edit Part provider
 */
public class ServerEditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private final Map nodeHintMap = new HashMap();
	{
		nodeHintMap.put(ServerConstants.UNIT_SERVER_SEMANTICHINT, ServerUnitEditPart.class);
	}

	/** list of supported shape editparts. */
	private final Map nodeMap = new HashMap();
	{
		nodeMap.put(ServerPackage.eINSTANCE.getServerUnit(), ServerUnitEditPart.class);
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
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = (Class) nodeHintMap.get(semanticHint);
		} else {
			EClass eClass = getReferencedElementEClass(view);
			if (eClass != null) {
				clazz = (Class) nodeMap.get(eClass);
			}
		}

		return clazz;
	}
}
