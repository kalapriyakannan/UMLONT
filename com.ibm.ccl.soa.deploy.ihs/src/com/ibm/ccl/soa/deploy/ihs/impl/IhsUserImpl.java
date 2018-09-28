/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ihs.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.http.impl.HttpUserImpl;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.ihs.IhsUser;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>User</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IhsUserImpl extends HttpUserImpl implements IhsUser {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IhsUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return IhsPackage.Literals.IHS_USER;
	}

} //IhsUserImpl
