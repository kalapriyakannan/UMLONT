/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tds.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.tds.TdsPackage;
import com.ibm.ccl.soa.deploy.tds.ui.editparts.TdsBaseSystemUnitEditPart;


/**
 * Deploy tool Edit Part provider for Tds domain.
 * 
 */
public class TdsEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private Map<EClass, Class<?>> nodeMap = new HashMap<EClass, Class<?>>();
	{
		nodeMap.put(TdsPackage.eINSTANCE.getTdsBaseSystemUnit(), TdsBaseSystemUnitEditPart.class);
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
