/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: WasMessagingEngine.java,v 1.1 2008/04/22 20:31:52 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Messaging Engine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasMessagingEngine#getEngineName <em>Engine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasMessagingEngine()
 * @model extendedMetaData="name='WasMessagingEngine' kind='elementOnly'"
 * @generated
 */
public interface WasMessagingEngine extends Capability {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Engine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the messaging engine
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Engine Name</em>' attribute.
	 * @see #setEngineName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasMessagingEngine_EngineName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='engineName'"
	 * @generated
	 */
	String getEngineName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasMessagingEngine#getEngineName <em>Engine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Engine Name</em>' attribute.
	 * @see #getEngineName()
	 * @generated
	 */
	void setEngineName(String value);

} // WasMessagingEngine
