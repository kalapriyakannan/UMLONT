/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: NetworkCommunicationConstraint.java,v 1.1 2007/12/21 15:46:14 kalantar Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network Communication Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Idenitifies requirement for network level communication between elements. In general this is between units. 
 * 				However, it may be expressed on dependency link between a requirement and a capability.
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getNetworkCommunicationConstraint()
 * @model extendedMetaData="name='NetworkCommunicationConstraint' kind='elementOnly'"
 * @generated
 */
public interface NetworkCommunicationConstraint extends BaseCommunicationConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

} // NetworkCommunicationConstraint
