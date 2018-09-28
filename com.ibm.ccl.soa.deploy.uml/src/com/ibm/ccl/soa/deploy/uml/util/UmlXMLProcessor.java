/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmlXMLProcessor.java,v 1.3 2008/02/05 22:17:43 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		UmlPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the UmlResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new UmlResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new UmlResourceFactoryImpl());
		}
		return registrations;
	}

} //UmlXMLProcessor
