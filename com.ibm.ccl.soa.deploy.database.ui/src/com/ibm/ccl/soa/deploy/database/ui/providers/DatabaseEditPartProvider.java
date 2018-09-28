/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.database.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.ui.editparts.DatabaseComponentEditPart;
import com.ibm.ccl.soa.deploy.database.ui.editparts.DatabaseConfigurationUnitEditPart;
import com.ibm.ccl.soa.deploy.database.ui.editparts.DatabaseModuleEditPart;
import com.ibm.ccl.soa.deploy.database.ui.editparts.SqlModuleEditPart;
import com.ibm.ccl.soa.deploy.database.ui.util.DatabaseConstants;

/**
 * Deploy tool Edit Part provider
 */
public class DatabaseEditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private Map nodeHintMap = new HashMap();
	{
		nodeHintMap.put(DatabaseConstants.MODULE_DATABASE_SEMANTICHINT, DatabaseModuleEditPart.class);
		nodeHintMap.put(DatabaseConstants.CONFIGURATION_DATABASE_SEMANTICHINT,
				DatabaseConfigurationUnitEditPart.class);
		nodeHintMap.put(DatabaseConstants.COMPONENT_DATABASE_SEMANTICHINT,
				DatabaseComponentEditPart.class);
		// TODO Add semantic hint for SQLModule
	}

	/** list of supported shape editparts. */
	private Map nodeMap = new HashMap();
	{
		nodeMap.put(DatabasePackage.eINSTANCE.getDatabaseUnit(), DatabaseModuleEditPart.class);
		nodeMap.put(DatabasePackage.eINSTANCE.getDatabaseInstanceUnit(),
				DatabaseConfigurationUnitEditPart.class);
		nodeMap.put(DatabasePackage.eINSTANCE.getSQLModule(), SqlModuleEditPart.class);
		nodeMap
				.put(DatabasePackage.eINSTANCE.getDatabaseComponent(), DatabaseComponentEditPart.class);
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
