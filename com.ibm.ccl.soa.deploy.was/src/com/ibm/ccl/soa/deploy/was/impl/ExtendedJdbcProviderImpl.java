/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.java.impl.JdbcProviderImpl;
import com.ibm.ccl.soa.deploy.was.ExtendedJdbcProvider;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Extended Jdbc Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExtendedJdbcProviderImpl extends JdbcProviderImpl implements ExtendedJdbcProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedJdbcProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.EXTENDED_JDBC_PROVIDER;
	}

} //ExtendedJdbcProviderImpl
