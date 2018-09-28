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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Software Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A SoftwareComponent is a application level
 * 				configuration of a particular Business Module. A
 * 				Business Module is any deployable unit of function that
 * 				provides Services and requires References. A Business
 * 				Module may be instantiated multiple times in the same
 * 				{@link Topology}.
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getSoftwareComponent()
 * @model extendedMetaData="name='SoftwareComponent' kind='elementOnly'"
 * @generated
 */
public interface SoftwareComponent extends BaseComponentUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

} // SoftwareComponent
