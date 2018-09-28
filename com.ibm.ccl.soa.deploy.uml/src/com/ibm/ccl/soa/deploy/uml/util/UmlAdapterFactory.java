/**
 * <copyright> </copyright>
 * 
 * $Id: UmlAdapterFactory.java,v 1.12 2008/02/05 22:17:43 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.uml.UMLActor;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UMLComponent;
import com.ibm.ccl.soa.deploy.uml.UMLDeployRoot;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UMLElementCapability;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UMLInterface;
import com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit;
import com.ibm.ccl.soa.deploy.uml.UMLPackageCap;
import com.ibm.ccl.soa.deploy.uml.UMLPackageUnit;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage
 * @generated
 */
public class UmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or
	 * is an instance object of the model. <!-- end-user-doc -->
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected UmlSwitch modelSwitch = new UmlSwitch() {
			public Object caseUMLActor(UMLActor object) {
				return createUMLActorAdapter();
			}
			public Object caseUMLActorUnit(UMLActorUnit object) {
				return createUMLActorUnitAdapter();
			}
			public Object caseUMLComponent(UMLComponent object) {
				return createUMLComponentAdapter();
			}
			public Object caseUMLDeployRoot(UMLDeployRoot object) {
				return createUMLDeployRootAdapter();
			}
			public Object caseUMLElementArtifact(UMLElementArtifact object) {
				return createUMLElementArtifactAdapter();
			}
			public Object caseUMLElementCapability(UMLElementCapability object) {
				return createUMLElementCapabilityAdapter();
			}
			public Object caseUMLInteractionConstraint(UMLInteractionConstraint object) {
				return createUMLInteractionConstraintAdapter();
			}
			public Object caseUMLInterface(UMLInterface object) {
				return createUMLInterfaceAdapter();
			}
			public Object caseUMLInterfaceUnit(UMLInterfaceUnit object) {
				return createUMLInterfaceUnitAdapter();
			}
			public Object caseUMLPackageCap(UMLPackageCap object) {
				return createUMLPackageCapAdapter();
			}
			public Object caseUMLPackageUnit(UMLPackageUnit object) {
				return createUMLPackageUnitAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseBundleCapability(BundleCapability object) {
				return createBundleCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseBaseComponentUnit(BaseComponentUnit object) {
				return createBaseComponentUnitAdapter();
			}
			public Object caseArtifact(Artifact object) {
				return createArtifactAdapter();
			}
			public Object caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLActor <em>UML Actor</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLActor
	 * @generated
	 */
	public Adapter createUMLActorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLActorUnit <em>UML Actor Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLActorUnit
	 * @generated
	 */
	public Adapter createUMLActorUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLComponent <em>UML Component</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLComponent
	 * @generated
	 */
	public Adapter createUMLComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot <em>UML Deploy Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLDeployRoot
	 * @generated
	 */
	public Adapter createUMLDeployRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact <em>UML Element Artifact</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementArtifact
	 * @generated
	 */
	public Adapter createUMLElementArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability <em>UML Element Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLElementCapability
	 * @generated
	 */
	public Adapter createUMLElementCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint <em>UML Interaction Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint
	 * @generated
	 */
	public Adapter createUMLInteractionConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLInterface <em>UML Interface</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInterface
	 * @generated
	 */
	public Adapter createUMLInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit <em>UML Interface Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit
	 * @generated
	 */
	public Adapter createUMLInterfaceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap <em>UML Package Cap</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLPackageCap
	 * @generated
	 */
	public Adapter createUMLPackageCapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageUnit <em>UML Package Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLPackageUnit
	 * @generated
	 */
	public Adapter createUMLPackageUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.BundleCapability <em>Bundle Capability</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.BundleCapability
	 * @generated
	 */
	public Adapter createBundleCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.BaseComponentUnit <em>Base Component Unit</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.BaseComponentUnit
	 * @generated
	 */
	public Adapter createBaseComponentUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Artifact
	 * @generated
	 */
	public Adapter createArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UmlAdapterFactory
