/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.tds.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.tds.TDSRoot;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystem;
import com.ibm.ccl.soa.deploy.tds.TdsBaseSystemUnit;
import com.ibm.ccl.soa.deploy.tds.TdsFactory;
import com.ibm.ccl.soa.deploy.tds.TdsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TdsFactoryImpl extends EFactoryImpl implements TdsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TdsFactory init() {
		try {
			TdsFactory theTdsFactory = (TdsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/Zephyr/tds/1.0.0/"); //$NON-NLS-1$ 
			if (theTdsFactory != null) {
				return theTdsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TdsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsFactoryImpl() {
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
			case TdsPackage.TDS_BASE_SYSTEM: return createTdsBaseSystem();
			case TdsPackage.TDS_BASE_SYSTEM_UNIT: return createTdsBaseSystemUnit();
			case TdsPackage.TDS_ROOT: return createTDSRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsBaseSystem createTdsBaseSystem() {
		TdsBaseSystemImpl tdsBaseSystem = new TdsBaseSystemImpl();
		return tdsBaseSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsBaseSystemUnit createTdsBaseSystemUnit() {
		TdsBaseSystemUnitImpl tdsBaseSystemUnit = new TdsBaseSystemUnitImpl();
		return tdsBaseSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDSRoot createTDSRoot() {
		TDSRootImpl tdsRoot = new TDSRootImpl();
		return tdsRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TdsPackage getTdsPackage() {
		return (TdsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TdsPackage getPackage() {
		return TdsPackage.eINSTANCE;
	}

} //TdsFactoryImpl
