/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: ApplicationCommunicationProtocolConstraint.java,v 1.2 2007/12/21 22:53:19 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Application Communication Protocol Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Specifies the application protocol of required communication.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint#getApplicationLayerProtocol <em>Application Layer Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getApplicationCommunicationProtocolConstraint()
 * @model extendedMetaData="name='ApplicationCommunicationProtocolConstraint' kind='elementOnly'"
 * @generated
 */
public interface ApplicationCommunicationProtocolConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Application Layer Protocol</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The name of the application layer protocol.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Application Layer Protocol</em>' attribute.
	 * @see #setApplicationLayerProtocol(String)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getApplicationCommunicationProtocolConstraint_ApplicationLayerProtocol()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" extendedMetaData="kind='attribute'
	 *        name='applicationLayerProtocol'"
	 * @generated
	 */
	String getApplicationLayerProtocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint#getApplicationLayerProtocol <em>Application Layer Protocol</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Layer Protocol</em>' attribute.
	 * @see #getApplicationLayerProtocol()
	 * @generated
	 */
	void setApplicationLayerProtocol(String value);

} // ApplicationCommunicationProtocolConstraint
