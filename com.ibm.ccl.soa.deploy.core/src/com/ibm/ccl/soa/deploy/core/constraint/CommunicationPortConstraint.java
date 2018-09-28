/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: CommunicationPortConstraint.java,v 1.3 2008/04/20 23:12:17 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Communication Port Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Specifies the (TCP/UDP) port of required communication.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#isIsTarget <em>Is Target</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationPortConstraint()
 * @model extendedMetaData="name='CommunicationPortConstraint' kind='elementOnly'"
 * @generated
 */
public interface CommunicationPortConstraint extends CommunicationChildConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Is Target</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Flag identifying to which communication endpoint port constraint applies. This flag
	 * 							is interpreted together with the respectLinkDirection flag on the parent BaseCommunicationConstraint.
	 * 							Their meaning is:<ul>
	 * 							<li>
	 *       <tt>respectLinkDirection = true</tt> and <tt>isTarget = true</tt>: target must be able to accept connections on <tt>port</tt>
	 *     </li>
	 * 							<li>
	 *       <tt>respectLinkDirection = true</tt> and <tt>isTarget = false</tt>: source must be able to send messages on <tt>port</tt>
	 *     </li>
	 * 							<li>
	 *       <tt>respectLinkDirection = false</tt> and <tt>isTarget = true</tt>: target must be able to send messages on <tt>port</tt>
	 *     </li>
	 * 							<li>
	 *       <tt>respectLinkDirection = false</tt> and <tt>isTarget = false</tt>: source must be able to receive messages on <tt>port</tt>
	 *     </li>
	 * 							</ul>
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Target</em>' attribute.
	 * @see #isSetIsTarget()
	 * @see #unsetIsTarget()
	 * @see #setIsTarget(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationPortConstraint_IsTarget()
	 * @model default="true" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isTarget'"
	 * @generated
	 */
	boolean isIsTarget();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#isIsTarget <em>Is Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Target</em>' attribute.
	 * @see #isSetIsTarget()
	 * @see #unsetIsTarget()
	 * @see #isIsTarget()
	 * @generated
	 */
	void setIsTarget(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#isIsTarget <em>Is Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsTarget()
	 * @see #isIsTarget()
	 * @see #setIsTarget(boolean)
	 * @generated
	 */
	void unsetIsTarget();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#isIsTarget <em>Is Target</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Target</em>' attribute is set.
	 * @see #unsetIsTarget()
	 * @see #isIsTarget()
	 * @see #setIsTarget(boolean)
	 * @generated
	 */
	boolean isSetIsTarget();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * The (TCP/UDP) port of required communication.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #isSetPort()
	 * @see #unsetPort()
	 * @see #setPort(int)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getCommunicationPortConstraint_Port()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute' name='port'"
	 * @generated
	 */
	int getPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #isSetPort()
	 * @see #unsetPort()
	 * @see #getPort()
	 * @generated
	 */
	void setPort(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPort()
	 * @see #getPort()
	 * @see #setPort(int)
	 * @generated
	 */
	void unsetPort();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#getPort <em>Port</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Port</em>' attribute is set.
	 * @see #unsetPort()
	 * @see #getPort()
	 * @see #setPort(int)
	 * @generated
	 */
	boolean isSetPort();

} // CommunicationPortConstraint
