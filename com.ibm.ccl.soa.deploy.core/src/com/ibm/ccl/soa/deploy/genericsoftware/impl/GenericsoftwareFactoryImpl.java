/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareFactoryImpl.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareFactory;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstallUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatchUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericsoftwareFactoryImpl extends EFactoryImpl implements GenericsoftwareFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GenericsoftwareFactory init() {
		try {
			GenericsoftwareFactory theGenericsoftwareFactory = (GenericsoftwareFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/genericsoftware/1.0.0/"); //$NON-NLS-1$ 
			if (theGenericsoftwareFactory != null) {
				return theGenericsoftwareFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GenericsoftwareFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwareFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT: return createGenericsoftwareRoot();
			case GenericsoftwarePackage.SOFTWARE_INSTALL: return createSoftwareInstall();
			case GenericsoftwarePackage.SOFTWARE_INSTALL_UNIT: return createSoftwareInstallUnit();
			case GenericsoftwarePackage.SOFTWARE_PATCH: return createSoftwarePatch();
			case GenericsoftwarePackage.SOFTWARE_PATCH_UNIT: return createSoftwarePatchUnit();
			case GenericsoftwarePackage.VERSION: return createVersion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwareRoot createGenericsoftwareRoot() {
		GenericsoftwareRootImpl genericsoftwareRoot = new GenericsoftwareRootImpl();
		return genericsoftwareRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInstall createSoftwareInstall() {
		SoftwareInstallImpl softwareInstall = new SoftwareInstallImpl();
		return softwareInstall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareInstallUnit createSoftwareInstallUnit() {
		SoftwareInstallUnitImpl softwareInstallUnit = new SoftwareInstallUnitImpl();
		return softwareInstallUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwarePatch createSoftwarePatch() {
		SoftwarePatchImpl softwarePatch = new SoftwarePatchImpl();
		return softwarePatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwarePatchUnit createSoftwarePatchUnit() {
		SoftwarePatchUnitImpl softwarePatchUnit = new SoftwarePatchUnitImpl();
		return softwarePatchUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwarePackage getGenericsoftwarePackage() {
		return (GenericsoftwarePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static GenericsoftwarePackage getPackage() {
		return GenericsoftwarePackage.eINSTANCE;
	}

} //GenericsoftwareFactoryImpl
