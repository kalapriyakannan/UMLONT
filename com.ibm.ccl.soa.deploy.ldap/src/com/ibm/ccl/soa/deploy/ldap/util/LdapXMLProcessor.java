/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ldap.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.ibm.ccl.soa.deploy.ldap.LdapPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class LdapXMLProcessor extends XMLProcessor {
	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LdapXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		LdapPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the LdapResourceFactoryImpl factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new LdapResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new LdapResourceFactoryImpl());
		}
		return registrations;
	}

} //LdapXMLProcessor
