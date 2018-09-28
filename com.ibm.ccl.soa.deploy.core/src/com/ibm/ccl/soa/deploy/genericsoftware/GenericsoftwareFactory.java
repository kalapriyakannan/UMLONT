/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareFactory.java,v 1.1 2008/02/04 15:55:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage
 * @generated
 */
public interface GenericsoftwareFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenericsoftwareFactory eINSTANCE = com.ibm.ccl.soa.deploy.genericsoftware.impl.GenericsoftwareFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	GenericsoftwareRoot createGenericsoftwareRoot();

	/**
	 * Returns a new object of class '<em>Software Install</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Install</em>'.
	 * @generated
	 */
	SoftwareInstall createSoftwareInstall();

	/**
	 * Returns a new object of class '<em>Software Install Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Install Unit</em>'.
	 * @generated
	 */
	SoftwareInstallUnit createSoftwareInstallUnit();

	/**
	 * Returns a new object of class '<em>Software Patch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Patch</em>'.
	 * @generated
	 */
	SoftwarePatch createSoftwarePatch();

	/**
	 * Returns a new object of class '<em>Software Patch Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Patch Unit</em>'.
	 * @generated
	 */
	SoftwarePatchUnit createSoftwarePatchUnit();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Version createVersion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenericsoftwarePackage getGenericsoftwarePackage();

} //GenericsoftwareFactory
