/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import com.ibm.ccl.soa.deploy.sca.ScaFactory;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;
import com.ibm.ccl.soa.deploy.sca.ScaPropertyValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaFactoryImpl extends EFactoryImpl implements ScaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaFactory init() {
		try {
			ScaFactory theScaFactory = (ScaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/Zephyr/sca/1.0.0/"); //$NON-NLS-1$ 
			if (theScaFactory != null) {
				return theScaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ScaPackage.GENERIC_SCA_IMPLEMENTATION: return createGenericSCAImplementation();
			case ScaPackage.GENERIC_SCA_IMPLEMENTATION_UNIT: return createGenericSCAImplementationUnit();
			case ScaPackage.SCA_BINDING: return createSCABinding();
			case ScaPackage.SCA_BINDING_UNIT: return createSCABindingUnit();
			case ScaPackage.SCA_COMPONENT: return createSCAComponent();
			case ScaPackage.SCA_COMPONENT_UNIT: return createSCAComponentUnit();
			case ScaPackage.SCA_IMPLEMENTATION_BPEL: return createSCAImplementationBPEL();
			case ScaPackage.SCA_IMPLEMENTATION_BPEL_UNIT: return createSCAImplementationBPELUnit();
			case ScaPackage.SCA_IMPLEMENTATION_COMPOSITE: return createSCAImplementationComposite();
			case ScaPackage.SCA_IMPLEMENTATION_COMPOSITE_UNIT: return createSCAImplementationCompositeUnit();
			case ScaPackage.SCA_IMPLEMENTATION_CPLUSPLUS: return createSCAImplementationCplusplus();
			case ScaPackage.SCA_IMPLEMENTATION_CPLUSPLUS_UNIT: return createSCAImplementationCplusplusUnit();
			case ScaPackage.SCA_IMPLEMENTATION_JAVA: return createSCAImplementationJava();
			case ScaPackage.SCA_IMPLEMENTATION_JAVA_UNIT: return createSCAImplementationJavaUnit();
			case ScaPackage.SCA_INTERFACE: return createSCAInterface();
			case ScaPackage.SCA_INTERFACE_UNIT: return createSCAInterfaceUnit();
			case ScaPackage.SCA_OPERATION: return createSCAOperation();
			case ScaPackage.SCA_OPERATION_UNIT: return createSCAOperationUnit();
			case ScaPackage.SCA_POLICY_INTENT: return createSCAPolicyIntent();
			case ScaPackage.SCA_POLICY_INTENT_UNIT: return createSCAPolicyIntentUnit();
			case ScaPackage.SCA_POLICY_SET: return createSCAPolicySet();
			case ScaPackage.SCA_POLICY_SET_UNIT: return createSCAPolicySetUnit();
			case ScaPackage.SCA_PROPERTY: return createSCAProperty();
			case ScaPackage.SCA_PROPERTY_UNIT: return createSCAPropertyUnit();
			case ScaPackage.SCA_PROPERTY_VALUE: return createScaPropertyValue();
			case ScaPackage.SCA_PROPERTY_VALUE_UNIT: return createSCAPropertyValueUnit();
			case ScaPackage.SCA_REFERENCE: return createSCAReference();
			case ScaPackage.SCA_REFERENCE_UNIT: return createSCAReferenceUnit();
			case ScaPackage.SCA_ROOT: return createSCARoot();
			case ScaPackage.SCA_SERVICE: return createSCAService();
			case ScaPackage.SCA_SERVICE_UNIT: return createSCAServiceUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericSCAImplementation createGenericSCAImplementation() {
		GenericSCAImplementationImpl genericSCAImplementation = new GenericSCAImplementationImpl();
		return genericSCAImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericSCAImplementationUnit createGenericSCAImplementationUnit() {
		GenericSCAImplementationUnitImpl genericSCAImplementationUnit = new GenericSCAImplementationUnitImpl();
		return genericSCAImplementationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCABinding createSCABinding() {
		SCABindingImpl scaBinding = new SCABindingImpl();
		return scaBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCABindingUnit createSCABindingUnit() {
		SCABindingUnitImpl scaBindingUnit = new SCABindingUnitImpl();
		return scaBindingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAComponent createSCAComponent() {
		SCAComponentImpl scaComponent = new SCAComponentImpl();
		return scaComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAComponentUnit createSCAComponentUnit() {
		SCAComponentUnitImpl scaComponentUnit = new SCAComponentUnitImpl();
		return scaComponentUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationBPEL createSCAImplementationBPEL() {
		SCAImplementationBPELImpl scaImplementationBPEL = new SCAImplementationBPELImpl();
		return scaImplementationBPEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationBPELUnit createSCAImplementationBPELUnit() {
		SCAImplementationBPELUnitImpl scaImplementationBPELUnit = new SCAImplementationBPELUnitImpl();
		return scaImplementationBPELUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationComposite createSCAImplementationComposite() {
		SCAImplementationCompositeImpl scaImplementationComposite = new SCAImplementationCompositeImpl();
		return scaImplementationComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationCompositeUnit createSCAImplementationCompositeUnit() {
		SCAImplementationCompositeUnitImpl scaImplementationCompositeUnit = new SCAImplementationCompositeUnitImpl();
		return scaImplementationCompositeUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationCplusplus createSCAImplementationCplusplus() {
		SCAImplementationCplusplusImpl scaImplementationCplusplus = new SCAImplementationCplusplusImpl();
		return scaImplementationCplusplus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationCplusplusUnit createSCAImplementationCplusplusUnit() {
		SCAImplementationCplusplusUnitImpl scaImplementationCplusplusUnit = new SCAImplementationCplusplusUnitImpl();
		return scaImplementationCplusplusUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationJava createSCAImplementationJava() {
		SCAImplementationJavaImpl scaImplementationJava = new SCAImplementationJavaImpl();
		return scaImplementationJava;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationJavaUnit createSCAImplementationJavaUnit() {
		SCAImplementationJavaUnitImpl scaImplementationJavaUnit = new SCAImplementationJavaUnitImpl();
		return scaImplementationJavaUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAInterface createSCAInterface() {
		SCAInterfaceImpl scaInterface = new SCAInterfaceImpl();
		return scaInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAInterfaceUnit createSCAInterfaceUnit() {
		SCAInterfaceUnitImpl scaInterfaceUnit = new SCAInterfaceUnitImpl();
		return scaInterfaceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAOperation createSCAOperation() {
		SCAOperationImpl scaOperation = new SCAOperationImpl();
		return scaOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAOperationUnit createSCAOperationUnit() {
		SCAOperationUnitImpl scaOperationUnit = new SCAOperationUnitImpl();
		return scaOperationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicyIntent createSCAPolicyIntent() {
		SCAPolicyIntentImpl scaPolicyIntent = new SCAPolicyIntentImpl();
		return scaPolicyIntent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicyIntentUnit createSCAPolicyIntentUnit() {
		SCAPolicyIntentUnitImpl scaPolicyIntentUnit = new SCAPolicyIntentUnitImpl();
		return scaPolicyIntentUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicySet createSCAPolicySet() {
		SCAPolicySetImpl scaPolicySet = new SCAPolicySetImpl();
		return scaPolicySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicySetUnit createSCAPolicySetUnit() {
		SCAPolicySetUnitImpl scaPolicySetUnit = new SCAPolicySetUnitImpl();
		return scaPolicySetUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAProperty createSCAProperty() {
		SCAPropertyImpl scaProperty = new SCAPropertyImpl();
		return scaProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPropertyUnit createSCAPropertyUnit() {
		SCAPropertyUnitImpl scaPropertyUnit = new SCAPropertyUnitImpl();
		return scaPropertyUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaPropertyValue createScaPropertyValue() {
		ScaPropertyValueImpl scaPropertyValue = new ScaPropertyValueImpl();
		return scaPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPropertyValueUnit createSCAPropertyValueUnit() {
		SCAPropertyValueUnitImpl scaPropertyValueUnit = new SCAPropertyValueUnitImpl();
		return scaPropertyValueUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAReference createSCAReference() {
		SCAReferenceImpl scaReference = new SCAReferenceImpl();
		return scaReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAReferenceUnit createSCAReferenceUnit() {
		SCAReferenceUnitImpl scaReferenceUnit = new SCAReferenceUnitImpl();
		return scaReferenceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCARoot createSCARoot() {
		SCARootImpl scaRoot = new SCARootImpl();
		return scaRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAService createSCAService() {
		SCAServiceImpl scaService = new SCAServiceImpl();
		return scaService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAServiceUnit createSCAServiceUnit() {
		SCAServiceUnitImpl scaServiceUnit = new SCAServiceUnitImpl();
		return scaServiceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaPackage getScaPackage() {
		return (ScaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ScaPackage getPackage() {
		return ScaPackage.eINSTANCE;
	}

} //ScaFactoryImpl
