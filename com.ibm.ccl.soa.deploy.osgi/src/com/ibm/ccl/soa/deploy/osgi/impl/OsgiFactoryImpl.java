/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.impl;

import com.ibm.ccl.soa.deploy.osgi.*;

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
public class OsgiFactoryImpl extends EFactoryImpl implements OsgiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OsgiFactory init() {
		try {
			OsgiFactory theOsgiFactory = (OsgiFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/zephyr/osgi/1.0.0"); //$NON-NLS-1$ 
			if (theOsgiFactory != null) {
				return theOsgiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OsgiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OsgiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OsgiPackage.BUNDLE_CAPABILITY: return createBundleCapability();
			case OsgiPackage.BUNDLE_COMPONENT: return createBundleComponent();
			case OsgiPackage.EXPORTED_PACKAGE: return createExportedPackage();
			case OsgiPackage.LIBRARY: return createLibrary();
			case OsgiPackage.OS_GI_ROOT: return createOSGiRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundleCapability createBundleCapability() {
		BundleCapabilityImpl bundleCapability = new BundleCapabilityImpl();
		return bundleCapability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundleComponent createBundleComponent() {
		BundleComponentImpl bundleComponent = new BundleComponentImpl();
		return bundleComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedPackage createExportedPackage() {
		ExportedPackageImpl exportedPackage = new ExportedPackageImpl();
		return exportedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSGiRoot createOSGiRoot() {
		OSGiRootImpl osGiRoot = new OSGiRootImpl();
		return osGiRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OsgiPackage getOsgiPackage() {
		return (OsgiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static OsgiPackage getPackage() {
		return OsgiPackage.eINSTANCE;
	}

} //OsgiFactoryImpl
