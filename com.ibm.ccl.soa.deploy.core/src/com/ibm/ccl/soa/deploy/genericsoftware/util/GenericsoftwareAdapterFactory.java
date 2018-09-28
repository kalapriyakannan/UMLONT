/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareAdapterFactory.java,v 1.3 2008/02/08 21:22:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstallUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatchUnit;
import com.ibm.ccl.soa.deploy.genericsoftware.Version;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage
 * @generated
 */
public class GenericsoftwareAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenericsoftwarePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwareAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GenericsoftwarePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericsoftwareSwitch modelSwitch =
		new GenericsoftwareSwitch() {
			public Object caseGenericsoftwareRoot(GenericsoftwareRoot object) {
				return createGenericsoftwareRootAdapter();
			}
			public Object caseSoftwareInstall(SoftwareInstall object) {
				return createSoftwareInstallAdapter();
			}
			public Object caseSoftwareInstallUnit(SoftwareInstallUnit object) {
				return createSoftwareInstallUnitAdapter();
			}
			public Object caseSoftwarePatch(SoftwarePatch object) {
				return createSoftwarePatchAdapter();
			}
			public Object caseSoftwarePatchUnit(SoftwarePatchUnit object) {
				return createSoftwarePatchUnitAdapter();
			}
			public Object caseVersion(Version object) {
				return createVersionAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot
	 * @generated
	 */
	public Adapter createGenericsoftwareRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall <em>Software Install</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall
	 * @generated
	 */
	public Adapter createSoftwareInstallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstallUnit <em>Software Install Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstallUnit
	 * @generated
	 */
	public Adapter createSoftwareInstallUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch <em>Software Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatch
	 * @generated
	 */
	public Adapter createSoftwarePatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatchUnit <em>Software Patch Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.SoftwarePatchUnit
	 * @generated
	 */
	public Adapter createSoftwarePatchUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.Version
	 * @generated
	 */
	public Adapter createVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GenericsoftwareAdapterFactory
