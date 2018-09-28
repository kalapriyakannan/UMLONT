/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.osgi.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;


/**
 * Deploy tool Edit Part provider for OS domain.
 * 
 * @author jschofie
 * @author Ed Snible
 * @author Bill Arnold
 */
public class OSGIEditPartProvider extends AbstractEditPartProvider {

//	// Map to hold the Shape Views
//	private Map nodeHintMap = new HashMap();
//	{
//		nodeHintMap.put( OsConstants.MODULE_OS_SEMANTICHINT, OsModuleEditPart.class);
//		nodeHintMap.put( OsConstants.CONFIGURATION_USER_SEMANTICHINT, UserUnitEditPart.class);
//		nodeHintMap.put( OsConstants.UNIT_GROUP_USER_GROUP_SEMANTICHINT, UserGroupUnitEditPart.class);		
//		nodeHintMap.put( OsConstants.CONFIGURATION_PORT_SEMANTICHINT, PortConfigUnitEditPart.class);				
//	}

	private Map nodeMap = new HashMap();
	{
	}
	protected Class getNodeEditPartClass(View view)
	{
		Class clazz = null;
		EClass eClass = getReferencedElementEClass(view);
		if(eClass!=null)
		{
		clazz= ((Class)nodeMap.get(eClass));	
		}
		return clazz;
	}
}
