/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.impl;

import com.ibm.ccl.soa.deploy.was.db2.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WasDb2FactoryImpl extends EFactoryImpl implements WasDb2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WasDb2Factory init() {
		try {
			WasDb2Factory theWasDb2Factory = (WasDb2Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/wasdb2/1.0.0/"); //$NON-NLS-1$ 
			if (theWasDb2Factory != null) {
				return theWasDb2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WasDb2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasDb2FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WasDb2Package.DATASOURCE_SATISFACTION_CONSTRAINT: return createDatasourceSatisfactionConstraint();
			case WasDb2Package.WAS_DB2_DEPLOY_ROOT: return createWasDb2DeployRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatasourceSatisfactionConstraint createDatasourceSatisfactionConstraint() {
		DatasourceSatisfactionConstraintImpl datasourceSatisfactionConstraint = new DatasourceSatisfactionConstraintImpl();
		return datasourceSatisfactionConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasDb2DeployRoot createWasDb2DeployRoot() {
		WasDb2DeployRootImpl wasDb2DeployRoot = new WasDb2DeployRootImpl();
		return wasDb2DeployRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasDb2Package getWasDb2Package() {
		return (WasDb2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WasDb2Package getPackage() {
		return WasDb2Package.eINSTANCE;
	}

} //WasDb2FactoryImpl
