/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ihs.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsServerUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsSystemUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsUserUnit;
import com.ibm.ccl.soa.deploy.ihs.IhsWasModuleUnit;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsServerEditPart;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsSystemEditPart;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsUserEditPart;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsWasAdminModuleEditPart;
import com.ibm.ccl.soa.deploy.ihs.ui.editparts.IhsWasModuleEditPart;

/**
 * Deploy tool Edit Part provider for IHS units.
 * 
 * @author Ed Snible
 * @see IhsUserUnit
 * @see IhsServerUnit
 * @see IhsSystemUnit
 * @see IhsWasPluginUnit
 * @see IhsWasModuleUnit
 * @see IhsUserEditPart
 * @see IhsServerEditPart
 * @see IhsSystemEditPart
 * @see IhsWasModuleEditPart
 */
public class IhsEditPartProvider extends AbstractEditPartProvider {

//	// Map to hold the Shape Views
//	private Map nodeHintMap = new HashMap();
//	{
//		nodeHintMap.put( IhsConstants.MODULE_IHSMODULE_SEMANTICHINT, IhsServerEditPart.class);
//		nodeHintMap.put( IhsConstants.CONFIGURATION_SEMANTICHINT, IhsWasModuleEditPart.class);
//	}

	/** list of supported shape editparts. */
	private final Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(IhsPackage.eINSTANCE.getIhsUserUnit(), IhsUserEditPart.class);
		nodeMap.put(IhsPackage.eINSTANCE.getIhsServerUnit(), IhsServerEditPart.class);
		nodeMap.put(IhsPackage.eINSTANCE.getIhsSystemUnit(), IhsSystemEditPart.class);
		nodeMap.put(IhsPackage.eINSTANCE.getIhsWasModuleUnit(), IhsWasModuleEditPart.class);
		nodeMap.put(IhsPackage.eINSTANCE.getIhsWasAdminModuleUnit(), IhsWasAdminModuleEditPart.class);
		// TODO Support IHS Admin Unit
	}

	/**
	 * Gets a Node's editpart class. This method should be overridden by a provider if it wants to
	 * provide this service.
	 * 
	 * @param view
	 *           the view to be <i>controlled</code> by the created editpart
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
//		String semanticHint = view.getType();

		Class<?> clazz = null;
//		if (semanticHint != null &&	semanticHint.length() > 0)
//			clazz = (Class)nodeHintMap.get(semanticHint);
//		else {
		EClass eClass = getReferencedElementEClass(view);

		if (eClass != null) {
			clazz = nodeMap.get(eClass);
		}
//		}

		return clazz;
	}
}
