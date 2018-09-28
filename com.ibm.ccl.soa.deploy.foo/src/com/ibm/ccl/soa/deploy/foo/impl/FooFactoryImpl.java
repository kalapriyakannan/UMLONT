/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.foo.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.foo.FooBaseSystem;
import com.ibm.ccl.soa.deploy.foo.FooBaseSystemUnit;
import com.ibm.ccl.soa.deploy.foo.FooFactory;
import com.ibm.ccl.soa.deploy.foo.FooPackage;
import com.ibm.ccl.soa.deploy.foo.FooRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FooFactoryImpl extends EFactoryImpl implements FooFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FooFactory init() {
		try {
			FooFactory theFooFactory = (FooFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/Zephyr/foo/1.0.0/"); 
			if (theFooFactory != null) {
				return theFooFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FooFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FooPackage.FOO_BASE_SYSTEM: return createFooBaseSystem();
			case FooPackage.FOO_BASE_SYSTEM_UNIT: return createFooBaseSystemUnit();
			case FooPackage.FOO_ROOT: return createFooRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooBaseSystem createFooBaseSystem() {
		FooBaseSystemImpl fooBaseSystem = new FooBaseSystemImpl();
		return fooBaseSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooBaseSystemUnit createFooBaseSystemUnit() {
		FooBaseSystemUnitImpl fooBaseSystemUnit = new FooBaseSystemUnitImpl();
		return fooBaseSystemUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooRoot createFooRoot() {
		FooRootImpl fooRoot = new FooRootImpl();
		return fooRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooPackage getFooPackage() {
		return (FooPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static FooPackage getPackage() {
		return FooPackage.eINSTANCE;
	}

} //FooFactoryImpl
