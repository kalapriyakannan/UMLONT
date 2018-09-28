/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage
 * @generated
 */
public interface OsgiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OsgiFactory eINSTANCE = com.ibm.ccl.soa.deploy.osgi.impl.OsgiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bundle Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bundle Capability</em>'.
	 * @generated
	 */
	BundleCapability createBundleCapability();

	/**
	 * Returns a new object of class '<em>Bundle Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bundle Component</em>'.
	 * @generated
	 */
	BundleComponent createBundleComponent();

	/**
	 * Returns a new object of class '<em>Exported Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exported Package</em>'.
	 * @generated
	 */
	ExportedPackage createExportedPackage();

	/**
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	Library createLibrary();

	/**
	 * Returns a new object of class '<em>OS Gi Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OS Gi Root</em>'.
	 * @generated
	 */
	OSGiRoot createOSGiRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OsgiPackage getOsgiPackage();

} //OsgiFactory
