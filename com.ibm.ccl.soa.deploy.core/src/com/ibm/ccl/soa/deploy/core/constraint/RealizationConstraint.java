/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * $Id: RealizationConstraint.java,v 1.2 2008/07/31 00:27:52 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Realization Constraint</b></em>'. <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * 
 * Defines restrictions to the realization logic which validates whether a given realization is
 * valid. In particular, expects the user of nested Boolean or Type Constraints.
 * 
 * <!-- end-model-doc -->
 * 
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getRealizationConstraint()
 * @model extendedMetaData="name='RealizationConstraint' kind='elementOnly'"
 * @generated
 * @extends Parentable
 */
public interface RealizationConstraint extends Constraint, Parentable {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

} // RealizationConstraint
