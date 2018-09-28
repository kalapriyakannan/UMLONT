/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>And Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AndConstraintImpl extends BooleanOperatorImpl implements AndConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AndConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.AND_CONSTRAINT;
	}

} //AndConstraintImpl
