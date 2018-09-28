/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Augmentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Augmentations are not meant to be access directly, instead clients should see {@link ConfigurationContract} 
 * 				and {@link InstanceConfiguration} for the relevant API. An Augmentation can append to a list of items from
 * 				an importED {@link DeployModelObject} dynamically in memory. The original items, as well as the appended 
 * 				items will appear as one cohesive list in memory. 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Augmentation#getAdditions <em>Additions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Augmentation#getFeature <em>Feature</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Augmentation#getSelect <em>Select</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAugmentation()
 * @model annotation="http://www.eclipse.org/emf/2002/GenModel suppressedGetVisibility='true' suppressedSetVisibility='true'"
 *        extendedMetaData="name='Augmentation' kind='elementOnly'"
 * @generated
 */
public interface Augmentation extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Additions</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additions</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAugmentation_Additions()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##any' name=':0' processing='lax'"
	 * @generated
	 */
	FeatureMap getAdditions();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAugmentation_Feature()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='feature'"
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Augmentation#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

	/**
	 * Returns the value of the '<em><b>Select</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Select</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Select</em>' attribute.
	 * @see #setSelect(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getAugmentation_Select()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='select'"
	 * @generated
	 */
	String getSelect();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Augmentation#getSelect <em>Select</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Select</em>' attribute.
	 * @see #getSelect()
	 * @generated
	 */
	void setSelect(String value);

} // Augmentation
