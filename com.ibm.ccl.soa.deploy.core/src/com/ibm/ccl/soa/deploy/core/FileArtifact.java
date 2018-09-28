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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>File Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				An artifact that represents a file resource.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.FileArtifact#getFileURIs <em>File UR Is</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getFileArtifact()
 * @model extendedMetaData="name='FileArtifact' kind='elementOnly'"
 * @generated
 */
public interface FileArtifact extends Artifact {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>File UR Is</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File UR Is</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File UR Is</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getFileArtifact_FileURIs()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        extendedMetaData="kind='element' name='fileURI' namespace='##targetNamespace'"
	 * @generated
	 */
	List getFileURIsGen();

	/**
	 * The list of file URI's for this file artifact. If there is a location binding usage, then the
	 * file URI location is resolved from the location binding resource, otherwise, the fileURI's are
	 * inlined.
	 * 
	 * @return the location binding aware list of file URI's
	 */
	List getFileURIs();

} // FileArtifact
