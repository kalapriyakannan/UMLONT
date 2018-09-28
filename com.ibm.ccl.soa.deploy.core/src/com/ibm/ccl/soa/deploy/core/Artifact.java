/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Artifact</b></em>'.
 * <!-- end-user-doc -->
 * 
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getArtifact()
 * @model abstract="true" extendedMetaData="name='Artifact' kind='elementOnly'"
 * @generated
 */
public interface Artifact extends DeployModelObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * getKey() returns an Object which overrides the hashcode and equals. This level of indirection
	 * prevents modification of the artifact.
	 */
	public Object getKey();

} // Artifact
