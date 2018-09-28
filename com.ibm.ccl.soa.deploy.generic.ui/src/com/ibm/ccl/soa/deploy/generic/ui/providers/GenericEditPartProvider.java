/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.generic.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.generic.ui.editparts.GenericGroupEditPart;
import com.ibm.ccl.soa.deploy.generic.ui.editparts.GenericModuleEditPart;
import com.ibm.ccl.soa.deploy.generic.ui.util.ApplicationConstants;

/**
 * Deploy tool Edit Part provider for Generic units.
 * 
 * @author Ed Snible
 * @see GenericModuleEditPart
 */
public class GenericEditPartProvider extends AbstractEditPartProvider {

	// Map to hold the Shape Views
	private final Map nodeHintMap = new HashMap();
	{
		nodeHintMap.put(ApplicationConstants.MODULE_GENERICMODULE_SEMANTICHINT,
				GenericModuleEditPart.class);
	}

	/** list of supported shape editparts. */
	private final Map nodeMap = new HashMap();
	{
		//nodeMap.put(GenericPackage.eINSTANCE.getGenericUnit(), GenericModuleEditPart.class);
		nodeMap.put(CorePackage.eINSTANCE.getUnit(), GenericModuleEditPart.class);
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
			// We have two kinds of Generic Unit edit part.  If this Generic is a group, use the group version

			if (view.getElement() instanceof Unit) {
				Unit unit = (Unit) view.getElement();

				if (unit.isGroup()) {
					return GenericGroupEditPart.class;
				}
			}

			EClass eClass = getReferencedElementEClass(view);

			if (eClass != null) {
				clazz = (Class) nodeMap.get(eClass);
			}
		}

		return clazz;
	}
}
