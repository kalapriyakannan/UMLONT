/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetXMLProcessor.java,v 1.1 2008/02/01 18:53:30 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.ibm.ccl.soa.deploy.net.NetPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NetXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		NetPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the NetResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new NetResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new NetResourceFactoryImpl());
		}
		return registrations;
	}

} //NetXMLProcessor
