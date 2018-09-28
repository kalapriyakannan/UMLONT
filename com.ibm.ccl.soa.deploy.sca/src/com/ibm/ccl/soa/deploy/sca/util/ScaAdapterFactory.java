/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation;
import com.ibm.ccl.soa.deploy.sca.GenericSCAImplementationUnit;
import com.ibm.ccl.soa.deploy.sca.SCABinding;
import com.ibm.ccl.soa.deploy.sca.SCABindingUnit;
import com.ibm.ccl.soa.deploy.sca.SCAComponent;
import com.ibm.ccl.soa.deploy.sca.SCAComponentUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationBPELUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationCompositeUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplusUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationJava;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationJavaUnit;
import com.ibm.ccl.soa.deploy.sca.SCAInterface;
import com.ibm.ccl.soa.deploy.sca.SCAInterfaceUnit;
import com.ibm.ccl.soa.deploy.sca.SCAOperation;
import com.ibm.ccl.soa.deploy.sca.SCAOperationUnit;
import com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent;
import com.ibm.ccl.soa.deploy.sca.SCAPolicyIntentUnit;
import com.ibm.ccl.soa.deploy.sca.SCAPolicySet;
import com.ibm.ccl.soa.deploy.sca.SCAPolicySetUnit;
import com.ibm.ccl.soa.deploy.sca.SCAProperty;
import com.ibm.ccl.soa.deploy.sca.SCAPropertyUnit;
import com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit;
import com.ibm.ccl.soa.deploy.sca.SCAReference;
import com.ibm.ccl.soa.deploy.sca.SCAReferenceUnit;
import com.ibm.ccl.soa.deploy.sca.SCARoot;
import com.ibm.ccl.soa.deploy.sca.SCAService;
import com.ibm.ccl.soa.deploy.sca.SCAServiceUnit;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;
import com.ibm.ccl.soa.deploy.sca.ScaPropertyValue;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage
 * @generated
 */
public class ScaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ScaPackage.eINSTANCE;
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaSwitch modelSwitch =
		new ScaSwitch() {
			public Object caseGenericSCAImplementation(GenericSCAImplementation object) {
				return createGenericSCAImplementationAdapter();
			}
			public Object caseGenericSCAImplementationUnit(GenericSCAImplementationUnit object) {
				return createGenericSCAImplementationUnitAdapter();
			}
			public Object caseSCABinding(SCABinding object) {
				return createSCABindingAdapter();
			}
			public Object caseSCABindingUnit(SCABindingUnit object) {
				return createSCABindingUnitAdapter();
			}
			public Object caseSCAComponent(SCAComponent object) {
				return createSCAComponentAdapter();
			}
			public Object caseSCAComponentUnit(SCAComponentUnit object) {
				return createSCAComponentUnitAdapter();
			}
			public Object caseSCAImplementationBPEL(SCAImplementationBPEL object) {
				return createSCAImplementationBPELAdapter();
			}
			public Object caseSCAImplementationBPELUnit(SCAImplementationBPELUnit object) {
				return createSCAImplementationBPELUnitAdapter();
			}
			public Object caseSCAImplementationComposite(SCAImplementationComposite object) {
				return createSCAImplementationCompositeAdapter();
			}
			public Object caseSCAImplementationCompositeUnit(SCAImplementationCompositeUnit object) {
				return createSCAImplementationCompositeUnitAdapter();
			}
			public Object caseSCAImplementationCplusplus(SCAImplementationCplusplus object) {
				return createSCAImplementationCplusplusAdapter();
			}
			public Object caseSCAImplementationCplusplusUnit(SCAImplementationCplusplusUnit object) {
				return createSCAImplementationCplusplusUnitAdapter();
			}
			public Object caseSCAImplementationJava(SCAImplementationJava object) {
				return createSCAImplementationJavaAdapter();
			}
			public Object caseSCAImplementationJavaUnit(SCAImplementationJavaUnit object) {
				return createSCAImplementationJavaUnitAdapter();
			}
			public Object caseSCAInterface(SCAInterface object) {
				return createSCAInterfaceAdapter();
			}
			public Object caseSCAInterfaceUnit(SCAInterfaceUnit object) {
				return createSCAInterfaceUnitAdapter();
			}
			public Object caseSCAOperation(SCAOperation object) {
				return createSCAOperationAdapter();
			}
			public Object caseSCAOperationUnit(SCAOperationUnit object) {
				return createSCAOperationUnitAdapter();
			}
			public Object caseSCAPolicyIntent(SCAPolicyIntent object) {
				return createSCAPolicyIntentAdapter();
			}
			public Object caseSCAPolicyIntentUnit(SCAPolicyIntentUnit object) {
				return createSCAPolicyIntentUnitAdapter();
			}
			public Object caseSCAPolicySet(SCAPolicySet object) {
				return createSCAPolicySetAdapter();
			}
			public Object caseSCAPolicySetUnit(SCAPolicySetUnit object) {
				return createSCAPolicySetUnitAdapter();
			}
			public Object caseSCAProperty(SCAProperty object) {
				return createSCAPropertyAdapter();
			}
			public Object caseSCAPropertyUnit(SCAPropertyUnit object) {
				return createSCAPropertyUnitAdapter();
			}
			public Object caseScaPropertyValue(ScaPropertyValue object) {
				return createScaPropertyValueAdapter();
			}
			public Object caseSCAPropertyValueUnit(SCAPropertyValueUnit object) {
				return createSCAPropertyValueUnitAdapter();
			}
			public Object caseSCAReference(SCAReference object) {
				return createSCAReferenceAdapter();
			}
			public Object caseSCAReferenceUnit(SCAReferenceUnit object) {
				return createSCAReferenceUnitAdapter();
			}
			public Object caseSCARoot(SCARoot object) {
				return createSCARootAdapter();
			}
			public Object caseSCAService(SCAService object) {
				return createSCAServiceAdapter();
			}
			public Object caseSCAServiceUnit(SCAServiceUnit object) {
				return createSCAServiceUnitAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation <em>Generic SCA Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation
	 * @generated
	 */
	public Adapter createGenericSCAImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.GenericSCAImplementationUnit <em>Generic SCA Implementation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.GenericSCAImplementationUnit
	 * @generated
	 */
	public Adapter createGenericSCAImplementationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCABinding <em>SCA Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCABinding
	 * @generated
	 */
	public Adapter createSCABindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCABindingUnit <em>SCA Binding Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCABindingUnit
	 * @generated
	 */
	public Adapter createSCABindingUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAComponent <em>SCA Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAComponent
	 * @generated
	 */
	public Adapter createSCAComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAComponentUnit <em>SCA Component Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAComponentUnit
	 * @generated
	 */
	public Adapter createSCAComponentUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL <em>SCA Implementation BPEL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL
	 * @generated
	 */
	public Adapter createSCAImplementationBPELAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationBPELUnit <em>SCA Implementation BPEL Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationBPELUnit
	 * @generated
	 */
	public Adapter createSCAImplementationBPELUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite <em>SCA Implementation Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite
	 * @generated
	 */
	public Adapter createSCAImplementationCompositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCompositeUnit <em>SCA Implementation Composite Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCompositeUnit
	 * @generated
	 */
	public Adapter createSCAImplementationCompositeUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus <em>SCA Implementation Cplusplus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus
	 * @generated
	 */
	public Adapter createSCAImplementationCplusplusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplusUnit <em>SCA Implementation Cplusplus Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplusUnit
	 * @generated
	 */
	public Adapter createSCAImplementationCplusplusUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJava <em>SCA Implementation Java</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJava
	 * @generated
	 */
	public Adapter createSCAImplementationJavaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAImplementationJavaUnit <em>SCA Implementation Java Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAImplementationJavaUnit
	 * @generated
	 */
	public Adapter createSCAImplementationJavaUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAInterface <em>SCA Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterface
	 * @generated
	 */
	public Adapter createSCAInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAInterfaceUnit <em>SCA Interface Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAInterfaceUnit
	 * @generated
	 */
	public Adapter createSCAInterfaceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAOperation <em>SCA Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperation
	 * @generated
	 */
	public Adapter createSCAOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAOperationUnit <em>SCA Operation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAOperationUnit
	 * @generated
	 */
	public Adapter createSCAOperationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent <em>SCA Policy Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent
	 * @generated
	 */
	public Adapter createSCAPolicyIntentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicyIntentUnit <em>SCA Policy Intent Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicyIntentUnit
	 * @generated
	 */
	public Adapter createSCAPolicyIntentUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicySet <em>SCA Policy Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicySet
	 * @generated
	 */
	public Adapter createSCAPolicySetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAPolicySetUnit <em>SCA Policy Set Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPolicySetUnit
	 * @generated
	 */
	public Adapter createSCAPolicySetUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAProperty <em>SCA Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAProperty
	 * @generated
	 */
	public Adapter createSCAPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAPropertyUnit <em>SCA Property Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPropertyUnit
	 * @generated
	 */
	public Adapter createSCAPropertyUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.ScaPropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPropertyValue
	 * @generated
	 */
	public Adapter createScaPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit <em>SCA Property Value Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit
	 * @generated
	 */
	public Adapter createSCAPropertyValueUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAReference <em>SCA Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReference
	 * @generated
	 */
	public Adapter createSCAReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAReferenceUnit <em>SCA Reference Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAReferenceUnit
	 * @generated
	 */
	public Adapter createSCAReferenceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCARoot <em>SCA Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCARoot
	 * @generated
	 */
	public Adapter createSCARootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAService <em>SCA Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAService
	 * @generated
	 */
	public Adapter createSCAServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.sca.SCAServiceUnit <em>SCA Service Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.sca.SCAServiceUnit
	 * @generated
	 */
	public Adapter createSCAServiceUnitAdapter() {
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

} //ScaAdapterFactory
