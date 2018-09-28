/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Model Object Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObjectSet#getDeployModelObjectGroup <em>Deploy Model Object Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployModelObjectSet#getDeployModelObject <em>Deploy Model Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObjectSet()
 * @model extendedMetaData="name='DeployModelObjectSet' kind='elementOnly'"
 * @generated
 */
public interface DeployModelObjectSet extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Deploy Model Object Group</b></em>' attribute list. The
	 * list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deploy Model Object Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Deploy Model Object Group</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObjectSet_DeployModelObjectGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='deployModelObject:group'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getDeployModelObjectGroup();

	/**
	 * Returns the value of the '<em><b>Deploy Model Object</b></em>' containment reference list.
	 * The list contents are of type {@link com.ibm.ccl.soa.deploy.core.DeployModelObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deploy Model Object</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deploy Model Object</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployModelObjectSet_DeployModelObject()
	 * @model type="com.ibm.ccl.soa.deploy.core.DeployModelObject" containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='deployModelObject' namespace='##targetNamespace' group='deployModelObject:group'"
	 * @generated
	 */
	List getDeployModelObject();

} // DeployModelObjectSet
