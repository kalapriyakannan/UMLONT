/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisXMLProcessor.java,v 1.1 2007/09/25 19:55:06 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.util;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		AnalysisPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the AnalysisResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new AnalysisResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new AnalysisResourceFactoryImpl());
		}
		return registrations;
	}

} //AnalysisXMLProcessor
