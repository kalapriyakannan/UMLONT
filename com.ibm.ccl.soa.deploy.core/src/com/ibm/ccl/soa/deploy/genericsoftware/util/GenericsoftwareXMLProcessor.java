/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareXMLProcessor.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericsoftwareXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwareXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		GenericsoftwarePackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the GenericsoftwareResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new GenericsoftwareResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new GenericsoftwareResourceFactoryImpl());
		}
		return registrations;
	}

} //GenericsoftwareXMLProcessor
