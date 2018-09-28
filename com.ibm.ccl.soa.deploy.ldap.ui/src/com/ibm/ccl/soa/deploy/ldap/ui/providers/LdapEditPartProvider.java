/***************************************************************************************************
 * LdapEditPartProvider.java --
 * 
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ldap.ui.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.ui.editparts.LdapModuleEditPart;

/**
 * Deploy tool Edit Part provider
 * 
 * @author Ed Snible
 */
public class LdapEditPartProvider extends AbstractEditPartProvider {

	/** list of supported shape editparts. */
	private final Map<EClass, Class> nodeMap = new HashMap<EClass, Class>();
	{
		nodeMap.put(LdapPackage.eINSTANCE.getLdapServerUnit(), LdapModuleEditPart.class);
		nodeMap.put(LdapPackage.eINSTANCE.getLdapSuffixUnit(), LdapModuleEditPart.class);
		nodeMap.put(LdapPackage.eINSTANCE.getLdapEntryUnit(), LdapModuleEditPart.class);
//		nodeMap.put(LdapPackage.eINSTANCE.getSecurityRoleReferenceUnit(), LdapModuleEditPart.class);
//		nodeMap.put(LdapPackage.eINSTANCE.getLdapLdifUnit(), LdapModuleEditPart.class);
//		nodeMap.put( LdapPackage.eINSTANCE.getSuffixArtifact(), LdapModuleEditPart.class);
//		nodeMap.put( LdapPackage.eINSTANCE.getLdifArtifact(), LdapModuleEditPart.class);
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
		EClass eClass = getReferencedElementEClass(view);
		if (eClass != null) {
			clazz = nodeMap.get(eClass);
		}
		return clazz;
	}
}
