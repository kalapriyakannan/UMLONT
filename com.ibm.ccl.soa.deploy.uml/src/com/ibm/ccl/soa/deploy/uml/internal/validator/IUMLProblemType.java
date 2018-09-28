/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.uml.internal.validator;

import com.ibm.ccl.soa.deploy.uml.Activator;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * Defines the deploy model marker problem types for the uml domain.
 * 
 * @see UmlPackage
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IUMLProblemType {
	/**
	 * Backing UML Element (type) cannot be resolved
	 * <p>
	 * Value = {@value}
	 */
	public static final String UML_ELEMENT_TYPE_NOT_RESOLVED = Activator.PLUGIN_ID
			+ ".umlElementNotResolved"; //$NON-NLS-1$	

	/**
	 * Unit is missing a stereotype defined in UML
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_UML_STEREOTYPE = Activator.PLUGIN_ID
			+ ".umlStereotypeMissing"; //$NON-NLS-1$	

	/**
	 * Unit an extra stereotype defined in UML
	 * <p>
	 * Value = {@value}
	 */
	public static final String EXTRA_UML_STEREOTYPE = Activator.PLUGIN_ID + ".umlStereotypeExtra"; //$NON-NLS-1$	
	/**
	 * Communication constraint is not defined.
	 * <p>
	 * Value = {@value}
	 */
	public static final String COMMUNICATION_LINK_UNDEFINED = Activator.PLUGIN_ID
			+ ".communicationLinkUnDefined"; //$NON-NLS-1$	
}
