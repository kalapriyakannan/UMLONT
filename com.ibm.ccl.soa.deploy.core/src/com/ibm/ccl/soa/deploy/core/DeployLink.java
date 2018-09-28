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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Base link type for subsequent, specially-typed links to extend.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployLink#getSourceURI <em>Source URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployLink#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployLink()
 * @model extendedMetaData="name='DeployLink' kind='elementOnly'"
 * @generated
 */
public interface DeployLink extends DeployModelObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Source URI</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The source end of the link, which becomes a
	 * {@link DeployModelObject} during deserialization <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Source URI</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployLink_SourceURI()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        suppressedSetVisibility="true" extendedMetaData="kind='attribute' name='source'"
	 * @generated
	 */
	String getSourceURI();

	/**
	 * Returns the value of the '<em><b>Target URI</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The target end of the link, which becomes a
	 * {@link DeployModelObject} during deserialization <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Target URI</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployLink_TargetURI()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        suppressedSetVisibility="true" extendedMetaData="kind='attribute' name='target'"
	 * @generated
	 */
	String getTargetURI();

} // DeployLink
