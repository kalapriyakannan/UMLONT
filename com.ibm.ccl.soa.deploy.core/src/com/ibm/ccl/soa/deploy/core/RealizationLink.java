/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Realization Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				TODO fill this in with some useful information
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRealizationLink()
 * @model extendedMetaData="name='RealizationLink' kind='elementOnly'"
 * @generated
 */
public interface RealizationLink extends DeployLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	DeployModelObject getSource();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model capabilityUnique="false" capabilityRequired="true" capabilityOrdered="false"
	 * @generated
	 */
	void setSource(DeployModelObject capability);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	DeployModelObject getTarget();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model targetUnique="false" targetRequired="true" targetOrdered="false"
	 * @generated
	 */
	void setTarget(DeployModelObject target);

} // RealizationLink
