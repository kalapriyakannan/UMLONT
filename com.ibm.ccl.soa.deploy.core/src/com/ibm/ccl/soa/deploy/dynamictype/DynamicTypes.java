/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Types</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			   A container for dynamic type definitions
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes#getPaletteEntries <em>Palette Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypes()
 * @model extendedMetaData="name='DynamicTypes' kind='elementOnly'"
 * @generated
 */
public interface DynamicTypes extends EObject {
	/**
	 * Returns the value of the '<em><b>Palette Entries</b></em>' containment reference list.
	 * The list contents are of type {@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Palette Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Palette Entries</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicTypes_PaletteEntries()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='dynamicPaletteEntry' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DynamicPaletteEntry> getPaletteEntries();

} // DynamicTypes
