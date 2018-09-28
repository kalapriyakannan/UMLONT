/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sib Mediation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibMediation#getHandlerListName <em>Handler List Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasSibMediation#getMediationName <em>Mediation Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibMediation()
 * @model extendedMetaData="name='WasSibMediation' kind='elementOnly'"
 * @generated
 */
public interface WasSibMediation extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Handler List Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler List Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Handler List Name</em>' attribute.
	 * @see #setHandlerListName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibMediation_HandlerListName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='handlerListName'"
	 * @generated
	 */
	String getHandlerListName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibMediation#getHandlerListName <em>Handler List Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handler List Name</em>' attribute.
	 * @see #getHandlerListName()
	 * @generated
	 */
	void setHandlerListName(String value);

	/**
	 * Returns the value of the '<em><b>Mediation Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Mediation Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediation Name</em>' attribute.
	 * @see #setMediationName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasSibMediation_MediationName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='mediationName'"
	 * @generated
	 */
	String getMediationName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasSibMediation#getMediationName <em>Mediation Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediation Name</em>' attribute.
	 * @see #getMediationName()
	 * @generated
	 */
	void setMediationName(String value);

} // WasSibMediation
