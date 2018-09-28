/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.db2.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.ui.editparts.DB2AdminClientUnitEditPart;
import com.ibm.ccl.soa.deploy.db2.ui.editparts.DB2AdminServerUnitEditPart;
import com.ibm.ccl.soa.deploy.db2.ui.editparts.DB2AppDevelClientUnitEditPart;
import com.ibm.ccl.soa.deploy.db2.ui.editparts.DB2ConfigurationUnitEditPart;
import com.ibm.ccl.soa.deploy.db2.ui.editparts.DB2ModuleEditPart;
import com.ibm.ccl.soa.deploy.db2.ui.util.DB2Constants;

/**
 * 
 * Deploy tool Edit Part provider
 */
public class DB2EditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private final Map<String, Class<?>> nodeHintMap = new HashMap<String, Class<?>>();
	{
		nodeHintMap.put(DB2Constants.MODULE_DB2_SEMANTICHINT, DB2ModuleEditPart.class);
		nodeHintMap.put(DB2Constants.CONFIGURATION_DB2_SEMANTICHINT,
				DB2ConfigurationUnitEditPart.class);
	}

	/** list of supported shape editparts. */
	private final Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(Db2Package.eINSTANCE.getDB2InstanceUnit(), DB2ModuleEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2ClientInstanceUnit(), DB2ModuleEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2DatabaseUnit(), DB2ModuleEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2SystemUnit(), DB2ModuleEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2RuntimeClientUnit(), DB2ModuleEditPart.class);

		nodeMap.put(Db2Package.eINSTANCE.getDB2CatalogUnit(), DB2ConfigurationUnitEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2NodeCatalogUnit(), DB2ConfigurationUnitEditPart.class);

		// Added ECS 5/1/06
		nodeMap.put(Db2Package.eINSTANCE.getDB2AdminClientUnit(), DB2AdminClientUnitEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2AdminServerUnit(), DB2AdminServerUnitEditPart.class);
		nodeMap.put(Db2Package.eINSTANCE.getDB2AppDevelClientUnit(),
				DB2AppDevelClientUnitEditPart.class);
	}

	/**
	 * Gets a Node's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	protected Class<?> getNodeEditPartClass(View view) {
		String semanticHint = view.getType();

		Class<?> clazz = null;
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = nodeHintMap.get(semanticHint);
		} else {
			EClass eClass = getReferencedElementEClass(view);
			if (eClass != null) {
				clazz = nodeMap.get(eClass);
			}
		}

		return clazz;
	}
}
