/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.internal.derby.DerbyDDLArtifact;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabase;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDatabaseUnit;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyFactory;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyInstance;
import com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class DerbyFactoryImpl extends EFactoryImpl implements DerbyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DerbyFactory init() {
		try {
			DerbyFactory theDerbyFactory = (DerbyFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/derby/1.0.0/"); //$NON-NLS-1$ 
			if (theDerbyFactory != null) {
				return theDerbyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DerbyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DerbyPackage.DERBY_DATABASE: return createDerbyDatabase();
			case DerbyPackage.DERBY_DATABASE_INSTANCE_UNIT: return createDerbyDatabaseInstanceUnit();
			case DerbyPackage.DERBY_DATABASE_UNIT: return createDerbyDatabaseUnit();
			case DerbyPackage.DERBY_DDL_ARTIFACT: return createDerbyDDLArtifact();
			case DerbyPackage.DERBY_DEPLOY_ROOT: return createDerbyDeployRoot();
			case DerbyPackage.DERBY_INSTANCE: return createDerbyInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDatabase createDerbyDatabase() {
		DerbyDatabaseImpl derbyDatabase = new DerbyDatabaseImpl();
		return derbyDatabase;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDatabaseInstanceUnit createDerbyDatabaseInstanceUnit() {
		DerbyDatabaseInstanceUnitImpl derbyDatabaseInstanceUnit = new DerbyDatabaseInstanceUnitImpl();
		return derbyDatabaseInstanceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDatabaseUnit createDerbyDatabaseUnit() {
		DerbyDatabaseUnitImpl derbyDatabaseUnit = new DerbyDatabaseUnitImpl();
		return derbyDatabaseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDDLArtifact createDerbyDDLArtifact() {
		DerbyDDLArtifactImpl derbyDDLArtifact = new DerbyDDLArtifactImpl();
		return derbyDDLArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyDeployRoot createDerbyDeployRoot() {
		DerbyDeployRootImpl derbyDeployRoot = new DerbyDeployRootImpl();
		return derbyDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyInstance createDerbyInstance() {
		DerbyInstanceImpl derbyInstance = new DerbyInstanceImpl();
		return derbyInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyPackage getDerbyPackage() {
		return (DerbyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static DerbyPackage getPackage() {
		return DerbyPackage.eINSTANCE;
	}

} //DerbyFactoryImpl
