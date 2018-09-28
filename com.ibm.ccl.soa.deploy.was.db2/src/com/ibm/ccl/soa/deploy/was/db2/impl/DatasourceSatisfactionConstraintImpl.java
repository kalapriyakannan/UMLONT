/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationConstraintImpl;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDb2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Datasource Satisfaction Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class DatasourceSatisfactionConstraintImpl extends ApplicationCommunicationConstraintImpl
		implements DatasourceSatisfactionConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DatasourceSatisfactionConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT;
	}

} //DatasourceSatisfactionConstraintImpl
