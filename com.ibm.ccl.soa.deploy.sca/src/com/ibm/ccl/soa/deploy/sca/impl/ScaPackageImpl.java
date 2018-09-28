/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaPackageImpl extends EPackageImpl implements ScaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericSCAImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericSCAImplementationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaBindingUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaComponentUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationBPELEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationBPELUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationCompositeUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationCplusplusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationCplusplusUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationJavaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaImplementationJavaUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaInterfaceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaOperationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPolicyIntentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPolicyIntentUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPolicySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPolicySetUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPropertyUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaPropertyValueUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaReferenceUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaServiceUnitEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScaPackageImpl() {
		super(eNS_URI, ScaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ScaPackage init() {
		if (isInited) return (ScaPackage)EPackage.Registry.INSTANCE.getEPackage(ScaPackage.eNS_URI);

		// Obtain or create and register package
		ScaPackageImpl theScaPackage = (ScaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ScaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ScaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theScaPackage.createPackageContents();

		// Initialize created meta-data
		theScaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScaPackage.freeze();

		return theScaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericSCAImplementation() {
		return genericSCAImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericSCAImplementation_Name1() {
		return (EAttribute)genericSCAImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericSCAImplementation_PolicySets() {
		return (EAttribute)genericSCAImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericSCAImplementation_Requires() {
		return (EAttribute)genericSCAImplementationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericSCAImplementation_Type() {
		return (EAttribute)genericSCAImplementationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericSCAImplementationUnit() {
		return genericSCAImplementationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCABinding() {
		return scaBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCABinding_Name1() {
		return (EAttribute)scaBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCABinding_URI() {
		return (EAttribute)scaBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCABindingUnit() {
		return scaBindingUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAComponent() {
		return scaComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAComponent_Autowire() {
		return (EAttribute)scaComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAComponent_Name1() {
		return (EAttribute)scaComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAComponentUnit() {
		return scaComponentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationBPEL() {
		return scaImplementationBPELEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationBPEL_Class() {
		return (EAttribute)scaImplementationBPELEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationBPEL_PolicySets() {
		return (EAttribute)scaImplementationBPELEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationBPEL_Requires() {
		return (EAttribute)scaImplementationBPELEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationBPELUnit() {
		return scaImplementationBPELUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationComposite() {
		return scaImplementationCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationComposite_Name1() {
		return (EAttribute)scaImplementationCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationComposite_PolicySets() {
		return (EAttribute)scaImplementationCompositeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationComposite_Requires() {
		return (EAttribute)scaImplementationCompositeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationComposite_Type() {
		return (EAttribute)scaImplementationCompositeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationCompositeUnit() {
		return scaImplementationCompositeUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationCplusplus() {
		return scaImplementationCplusplusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationCplusplus_Class() {
		return (EAttribute)scaImplementationCplusplusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationCplusplus_PolicySets() {
		return (EAttribute)scaImplementationCplusplusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationCplusplus_Requires() {
		return (EAttribute)scaImplementationCplusplusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationCplusplusUnit() {
		return scaImplementationCplusplusUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationJava() {
		return scaImplementationJavaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationJava_Class() {
		return (EAttribute)scaImplementationJavaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationJava_PolicySets() {
		return (EAttribute)scaImplementationJavaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAImplementationJava_Requires() {
		return (EAttribute)scaImplementationJavaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAImplementationJavaUnit() {
		return scaImplementationJavaUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAInterface() {
		return scaInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAInterface_CallBackInterface() {
		return (EAttribute)scaInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAInterface_Conversational() {
		return (EAttribute)scaInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAInterface_Interface() {
		return (EAttribute)scaInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAInterface_Name1() {
		return (EAttribute)scaInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAInterfaceUnit() {
		return scaInterfaceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAOperation() {
		return scaOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAOperation_Name1() {
		return (EAttribute)scaOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAOperation_PolicySets() {
		return (EAttribute)scaOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAOperation_Requires() {
		return (EAttribute)scaOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAOperationUnit() {
		return scaOperationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAPolicyIntent() {
		return scaPolicyIntentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAPolicyIntent_Name1() {
		return (EAttribute)scaPolicyIntentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAPolicyIntentUnit() {
		return scaPolicyIntentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAPolicySet() {
		return scaPolicySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAPolicySet_Name1() {
		return (EAttribute)scaPolicySetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAPolicySetUnit() {
		return scaPolicySetUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAProperty() {
		return scaPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAProperty_Element() {
		return (EAttribute)scaPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAProperty_Many() {
		return (EAttribute)scaPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAProperty_MustSupply() {
		return (EAttribute)scaPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAProperty_Name1() {
		return (EAttribute)scaPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAProperty_Value() {
		return (EAttribute)scaPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAPropertyUnit() {
		return scaPropertyUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScaPropertyValue() {
		return scaPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_Element() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_File() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_Many() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_MustSupply() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_Name1() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_Source() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScaPropertyValue_Type() {
		return (EAttribute)scaPropertyValueEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAPropertyValueUnit() {
		return scaPropertyValueUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAPropertyValueUnit_Name1() {
		return (EAttribute)scaPropertyValueUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAReference() {
		return scaReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAReference_Autowire() {
		return (EAttribute)scaReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAReference_Multiplicity() {
		return (EAttribute)scaReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAReference_Name1() {
		return (EAttribute)scaReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAReference_WiredByImpl() {
		return (EAttribute)scaReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAReferenceUnit() {
		return scaReferenceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCARoot() {
		return scaRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCARoot_Mixed() {
		return (EAttribute)scaRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_XMLNSPrefixMap() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_XSISchemaLocation() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilityGenericSCAImplementation() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCABinding() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilityScaComponent() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAImplementationBPEL() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAImplementationComposite() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAImplementationCplusplus() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAImplementationJava() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAInterface() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAOperation() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAPolicyIntent() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAPolicySet() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilityScaProperty() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilityScaPropertyValue() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilitySCAReference() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_CapabilityScaService() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitGenericscaImplementationUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCABindingUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitScaComponentUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAImplementationBPELUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAImplementationCompositeUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAImplementationCplusplusUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAImplementationJavaUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAInterfaceUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAOperationUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAPolicyIntentUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAPolicySetUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitScaPropertyUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitScaPropertyValueUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitSCAReferenceUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCARoot_UnitScaServiceUnit() {
		return (EReference)scaRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAService() {
		return scaServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSCAService_Name1() {
		return (EAttribute)scaServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCAServiceUnit() {
		return scaServiceUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaFactory getScaFactory() {
		return (ScaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		genericSCAImplementationEClass = createEClass(GENERIC_SCA_IMPLEMENTATION);
		createEAttribute(genericSCAImplementationEClass, GENERIC_SCA_IMPLEMENTATION__NAME1);
		createEAttribute(genericSCAImplementationEClass, GENERIC_SCA_IMPLEMENTATION__POLICY_SETS);
		createEAttribute(genericSCAImplementationEClass, GENERIC_SCA_IMPLEMENTATION__REQUIRES);
		createEAttribute(genericSCAImplementationEClass, GENERIC_SCA_IMPLEMENTATION__TYPE);

		genericSCAImplementationUnitEClass = createEClass(GENERIC_SCA_IMPLEMENTATION_UNIT);

		scaBindingEClass = createEClass(SCA_BINDING);
		createEAttribute(scaBindingEClass, SCA_BINDING__NAME1);
		createEAttribute(scaBindingEClass, SCA_BINDING__URI);

		scaBindingUnitEClass = createEClass(SCA_BINDING_UNIT);

		scaComponentEClass = createEClass(SCA_COMPONENT);
		createEAttribute(scaComponentEClass, SCA_COMPONENT__AUTOWIRE);
		createEAttribute(scaComponentEClass, SCA_COMPONENT__NAME1);

		scaComponentUnitEClass = createEClass(SCA_COMPONENT_UNIT);

		scaImplementationBPELEClass = createEClass(SCA_IMPLEMENTATION_BPEL);
		createEAttribute(scaImplementationBPELEClass, SCA_IMPLEMENTATION_BPEL__CLASS);
		createEAttribute(scaImplementationBPELEClass, SCA_IMPLEMENTATION_BPEL__POLICY_SETS);
		createEAttribute(scaImplementationBPELEClass, SCA_IMPLEMENTATION_BPEL__REQUIRES);

		scaImplementationBPELUnitEClass = createEClass(SCA_IMPLEMENTATION_BPEL_UNIT);

		scaImplementationCompositeEClass = createEClass(SCA_IMPLEMENTATION_COMPOSITE);
		createEAttribute(scaImplementationCompositeEClass, SCA_IMPLEMENTATION_COMPOSITE__NAME1);
		createEAttribute(scaImplementationCompositeEClass, SCA_IMPLEMENTATION_COMPOSITE__POLICY_SETS);
		createEAttribute(scaImplementationCompositeEClass, SCA_IMPLEMENTATION_COMPOSITE__REQUIRES);
		createEAttribute(scaImplementationCompositeEClass, SCA_IMPLEMENTATION_COMPOSITE__TYPE);

		scaImplementationCompositeUnitEClass = createEClass(SCA_IMPLEMENTATION_COMPOSITE_UNIT);

		scaImplementationCplusplusEClass = createEClass(SCA_IMPLEMENTATION_CPLUSPLUS);
		createEAttribute(scaImplementationCplusplusEClass, SCA_IMPLEMENTATION_CPLUSPLUS__CLASS);
		createEAttribute(scaImplementationCplusplusEClass, SCA_IMPLEMENTATION_CPLUSPLUS__POLICY_SETS);
		createEAttribute(scaImplementationCplusplusEClass, SCA_IMPLEMENTATION_CPLUSPLUS__REQUIRES);

		scaImplementationCplusplusUnitEClass = createEClass(SCA_IMPLEMENTATION_CPLUSPLUS_UNIT);

		scaImplementationJavaEClass = createEClass(SCA_IMPLEMENTATION_JAVA);
		createEAttribute(scaImplementationJavaEClass, SCA_IMPLEMENTATION_JAVA__CLASS);
		createEAttribute(scaImplementationJavaEClass, SCA_IMPLEMENTATION_JAVA__POLICY_SETS);
		createEAttribute(scaImplementationJavaEClass, SCA_IMPLEMENTATION_JAVA__REQUIRES);

		scaImplementationJavaUnitEClass = createEClass(SCA_IMPLEMENTATION_JAVA_UNIT);

		scaInterfaceEClass = createEClass(SCA_INTERFACE);
		createEAttribute(scaInterfaceEClass, SCA_INTERFACE__CALL_BACK_INTERFACE);
		createEAttribute(scaInterfaceEClass, SCA_INTERFACE__CONVERSATIONAL);
		createEAttribute(scaInterfaceEClass, SCA_INTERFACE__INTERFACE);
		createEAttribute(scaInterfaceEClass, SCA_INTERFACE__NAME1);

		scaInterfaceUnitEClass = createEClass(SCA_INTERFACE_UNIT);

		scaOperationEClass = createEClass(SCA_OPERATION);
		createEAttribute(scaOperationEClass, SCA_OPERATION__NAME1);
		createEAttribute(scaOperationEClass, SCA_OPERATION__POLICY_SETS);
		createEAttribute(scaOperationEClass, SCA_OPERATION__REQUIRES);

		scaOperationUnitEClass = createEClass(SCA_OPERATION_UNIT);

		scaPolicyIntentEClass = createEClass(SCA_POLICY_INTENT);
		createEAttribute(scaPolicyIntentEClass, SCA_POLICY_INTENT__NAME1);

		scaPolicyIntentUnitEClass = createEClass(SCA_POLICY_INTENT_UNIT);

		scaPolicySetEClass = createEClass(SCA_POLICY_SET);
		createEAttribute(scaPolicySetEClass, SCA_POLICY_SET__NAME1);

		scaPolicySetUnitEClass = createEClass(SCA_POLICY_SET_UNIT);

		scaPropertyEClass = createEClass(SCA_PROPERTY);
		createEAttribute(scaPropertyEClass, SCA_PROPERTY__ELEMENT);
		createEAttribute(scaPropertyEClass, SCA_PROPERTY__MANY);
		createEAttribute(scaPropertyEClass, SCA_PROPERTY__MUST_SUPPLY);
		createEAttribute(scaPropertyEClass, SCA_PROPERTY__NAME1);
		createEAttribute(scaPropertyEClass, SCA_PROPERTY__VALUE);

		scaPropertyUnitEClass = createEClass(SCA_PROPERTY_UNIT);

		scaPropertyValueEClass = createEClass(SCA_PROPERTY_VALUE);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__ELEMENT);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__FILE);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__MANY);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__MUST_SUPPLY);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__NAME1);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__SOURCE);
		createEAttribute(scaPropertyValueEClass, SCA_PROPERTY_VALUE__TYPE);

		scaPropertyValueUnitEClass = createEClass(SCA_PROPERTY_VALUE_UNIT);
		createEAttribute(scaPropertyValueUnitEClass, SCA_PROPERTY_VALUE_UNIT__NAME1);

		scaReferenceEClass = createEClass(SCA_REFERENCE);
		createEAttribute(scaReferenceEClass, SCA_REFERENCE__AUTOWIRE);
		createEAttribute(scaReferenceEClass, SCA_REFERENCE__MULTIPLICITY);
		createEAttribute(scaReferenceEClass, SCA_REFERENCE__NAME1);
		createEAttribute(scaReferenceEClass, SCA_REFERENCE__WIRED_BY_IMPL);

		scaReferenceUnitEClass = createEClass(SCA_REFERENCE_UNIT);

		scaRootEClass = createEClass(SCA_ROOT);
		createEAttribute(scaRootEClass, SCA_ROOT__MIXED);
		createEReference(scaRootEClass, SCA_ROOT__XMLNS_PREFIX_MAP);
		createEReference(scaRootEClass, SCA_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_BINDING);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_COMPONENT);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_INTERFACE);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_OPERATION);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_POLICY_SET);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_PROPERTY);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_REFERENCE);
		createEReference(scaRootEClass, SCA_ROOT__CAPABILITY_SCA_SERVICE);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_BINDING_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_COMPONENT_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_INTERFACE_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_OPERATION_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_PROPERTY_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_REFERENCE_UNIT);
		createEReference(scaRootEClass, SCA_ROOT__UNIT_SCA_SERVICE_UNIT);

		scaServiceEClass = createEClass(SCA_SERVICE);
		createEAttribute(scaServiceEClass, SCA_SERVICE__NAME1);

		scaServiceUnitEClass = createEClass(SCA_SERVICE_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		genericSCAImplementationEClass.getESuperTypes().add(theCorePackage.getCapability());
		genericSCAImplementationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaBindingEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaBindingUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaComponentEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaComponentUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaImplementationBPELEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaImplementationBPELUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaImplementationCompositeEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaImplementationCompositeUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaImplementationCplusplusEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaImplementationCplusplusUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaImplementationJavaEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaImplementationJavaUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaInterfaceEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaInterfaceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaOperationEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaOperationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaPolicyIntentEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaPolicyIntentUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaPolicySetEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaPolicySetUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaPropertyEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaPropertyUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaPropertyValueEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaPropertyValueUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaReferenceEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaReferenceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		scaServiceEClass.getESuperTypes().add(theCorePackage.getCapability());
		scaServiceUnitEClass.getESuperTypes().add(theCorePackage.getUnit());

		// Initialize classes and features; add operations and parameters
		initEClass(genericSCAImplementationEClass, GenericSCAImplementation.class, "GenericSCAImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getGenericSCAImplementation_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, GenericSCAImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGenericSCAImplementation_PolicySets(), theXMLTypePackage.getString(), "policySets", null, 0, 1, GenericSCAImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGenericSCAImplementation_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, GenericSCAImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getGenericSCAImplementation_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, GenericSCAImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(genericSCAImplementationUnitEClass, GenericSCAImplementationUnit.class, "GenericSCAImplementationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaBindingEClass, SCABinding.class, "SCABinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCABinding_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCABinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCABinding_URI(), theXMLTypePackage.getString(), "uRI", null, 0, 1, SCABinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaBindingUnitEClass, SCABindingUnit.class, "SCABindingUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaComponentEClass, SCAComponent.class, "SCAComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAComponent_Autowire(), theXMLTypePackage.getString(), "autowire", null, 0, 1, SCAComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAComponent_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaComponentUnitEClass, SCAComponentUnit.class, "SCAComponentUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaImplementationBPELEClass, SCAImplementationBPEL.class, "SCAImplementationBPEL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAImplementationBPEL_Class(), theXMLTypePackage.getString(), "class", null, 0, 1, SCAImplementationBPEL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationBPEL_PolicySets(), theXMLTypePackage.getString(), "policySets", null, 0, 1, SCAImplementationBPEL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationBPEL_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, SCAImplementationBPEL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaImplementationBPELUnitEClass, SCAImplementationBPELUnit.class, "SCAImplementationBPELUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaImplementationCompositeEClass, SCAImplementationComposite.class, "SCAImplementationComposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAImplementationComposite_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAImplementationComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationComposite_PolicySets(), theXMLTypePackage.getString(), "policySets", null, 0, 1, SCAImplementationComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationComposite_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, SCAImplementationComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationComposite_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, SCAImplementationComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaImplementationCompositeUnitEClass, SCAImplementationCompositeUnit.class, "SCAImplementationCompositeUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaImplementationCplusplusEClass, SCAImplementationCplusplus.class, "SCAImplementationCplusplus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAImplementationCplusplus_Class(), theXMLTypePackage.getString(), "class", null, 0, 1, SCAImplementationCplusplus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationCplusplus_PolicySets(), theXMLTypePackage.getString(), "policySets", null, 0, 1, SCAImplementationCplusplus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationCplusplus_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, SCAImplementationCplusplus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaImplementationCplusplusUnitEClass, SCAImplementationCplusplusUnit.class, "SCAImplementationCplusplusUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaImplementationJavaEClass, SCAImplementationJava.class, "SCAImplementationJava", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAImplementationJava_Class(), theXMLTypePackage.getString(), "class", null, 0, 1, SCAImplementationJava.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationJava_PolicySets(), theXMLTypePackage.getString(), "policySets", null, 0, 1, SCAImplementationJava.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAImplementationJava_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, SCAImplementationJava.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaImplementationJavaUnitEClass, SCAImplementationJavaUnit.class, "SCAImplementationJavaUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaInterfaceEClass, SCAInterface.class, "SCAInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAInterface_CallBackInterface(), theXMLTypePackage.getString(), "callBackInterface", null, 0, 1, SCAInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAInterface_Conversational(), theXMLTypePackage.getString(), "conversational", null, 0, 1, SCAInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAInterface_Interface(), theXMLTypePackage.getString(), "interface", null, 0, 1, SCAInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAInterface_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaInterfaceUnitEClass, SCAInterfaceUnit.class, "SCAInterfaceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaOperationEClass, SCAOperation.class, "SCAOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAOperation_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAOperation_PolicySets(), theXMLTypePackage.getString(), "policySets", null, 0, 1, SCAOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAOperation_Requires(), theXMLTypePackage.getString(), "requires", null, 0, 1, SCAOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaOperationUnitEClass, SCAOperationUnit.class, "SCAOperationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaPolicyIntentEClass, SCAPolicyIntent.class, "SCAPolicyIntent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAPolicyIntent_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAPolicyIntent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaPolicyIntentUnitEClass, SCAPolicyIntentUnit.class, "SCAPolicyIntentUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaPolicySetEClass, SCAPolicySet.class, "SCAPolicySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAPolicySet_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAPolicySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaPolicySetUnitEClass, SCAPolicySetUnit.class, "SCAPolicySetUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaPropertyEClass, SCAProperty.class, "SCAProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAProperty_Element(), theXMLTypePackage.getString(), "element", null, 0, 1, SCAProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAProperty_Many(), theXMLTypePackage.getString(), "many", null, 0, 1, SCAProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAProperty_MustSupply(), theXMLTypePackage.getString(), "mustSupply", null, 0, 1, SCAProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAProperty_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAProperty_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, SCAProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaPropertyUnitEClass, SCAPropertyUnit.class, "SCAPropertyUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaPropertyValueEClass, ScaPropertyValue.class, "ScaPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_Element(), theXMLTypePackage.getString(), "element", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_File(), theXMLTypePackage.getString(), "file", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_Many(), theXMLTypePackage.getString(), "many", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_MustSupply(), theXMLTypePackage.getString(), "mustSupply", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_Source(), theXMLTypePackage.getString(), "source", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScaPropertyValue_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, ScaPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaPropertyValueUnitEClass, SCAPropertyValueUnit.class, "SCAPropertyValueUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAPropertyValueUnit_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAPropertyValueUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaReferenceEClass, SCAReference.class, "SCAReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAReference_Autowire(), theXMLTypePackage.getString(), "autowire", null, 0, 1, SCAReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAReference_Multiplicity(), theXMLTypePackage.getString(), "multiplicity", null, 0, 1, SCAReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAReference_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSCAReference_WiredByImpl(), theXMLTypePackage.getString(), "wiredByImpl", null, 0, 1, SCAReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaReferenceUnitEClass, SCAReferenceUnit.class, "SCAReferenceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(scaRootEClass, SCARoot.class, "SCARoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCARoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilityGenericSCAImplementation(), this.getGenericSCAImplementation(), null, "capabilityGenericSCAImplementation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCABinding(), this.getSCABinding(), null, "capabilitySCABinding", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilityScaComponent(), this.getSCAComponent(), null, "capabilityScaComponent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAImplementationBPEL(), this.getSCAImplementationBPEL(), null, "capabilitySCAImplementationBPEL", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAImplementationComposite(), this.getSCAImplementationComposite(), null, "capabilitySCAImplementationComposite", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAImplementationCplusplus(), this.getSCAImplementationCplusplus(), null, "capabilitySCAImplementationCplusplus", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAImplementationJava(), this.getSCAImplementationJava(), null, "capabilitySCAImplementationJava", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAInterface(), this.getSCAInterface(), null, "capabilitySCAInterface", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAOperation(), this.getSCAOperation(), null, "capabilitySCAOperation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAPolicyIntent(), this.getSCAPolicyIntent(), null, "capabilitySCAPolicyIntent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAPolicySet(), this.getSCAPolicySet(), null, "capabilitySCAPolicySet", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilityScaProperty(), this.getSCAProperty(), null, "capabilityScaProperty", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilityScaPropertyValue(), this.getScaPropertyValue(), null, "capabilityScaPropertyValue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilitySCAReference(), this.getSCAReference(), null, "capabilitySCAReference", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_CapabilityScaService(), this.getSCAService(), null, "capabilityScaService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitGenericscaImplementationUnit(), this.getGenericSCAImplementationUnit(), null, "unitGenericscaImplementationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCABindingUnit(), this.getSCABindingUnit(), null, "unitSCABindingUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitScaComponentUnit(), this.getSCAComponentUnit(), null, "unitScaComponentUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAImplementationBPELUnit(), this.getSCAImplementationBPELUnit(), null, "unitSCAImplementationBPELUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAImplementationCompositeUnit(), this.getSCAImplementationCompositeUnit(), null, "unitSCAImplementationCompositeUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAImplementationCplusplusUnit(), this.getSCAImplementationCplusplusUnit(), null, "unitSCAImplementationCplusplusUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAImplementationJavaUnit(), this.getSCAImplementationJavaUnit(), null, "unitSCAImplementationJavaUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAInterfaceUnit(), this.getSCAInterfaceUnit(), null, "unitSCAInterfaceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAOperationUnit(), this.getSCAOperationUnit(), null, "unitSCAOperationUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAPolicyIntentUnit(), this.getSCAPolicyIntentUnit(), null, "unitSCAPolicyIntentUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAPolicySetUnit(), this.getSCAPolicySetUnit(), null, "unitSCAPolicySetUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitScaPropertyUnit(), this.getSCAPropertyUnit(), null, "unitScaPropertyUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitScaPropertyValueUnit(), this.getSCAPropertyValueUnit(), null, "unitScaPropertyValueUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitSCAReferenceUnit(), this.getSCAReferenceUnit(), null, "unitSCAReferenceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSCARoot_UnitScaServiceUnit(), this.getSCAServiceUnit(), null, "unitScaServiceUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaServiceEClass, SCAService.class, "SCAService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSCAService_Name1(), theXMLTypePackage.getString(), "name1", null, 0, 1, SCAService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scaServiceUnitEClass, SCAServiceUnit.class, "SCAServiceUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
		addAnnotation
		  (genericSCAImplementationEClass, 
		   source, 
		   new String[] {
			 "name", "GenericSCAImplementation", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericSCAImplementation_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericSCAImplementation_PolicySets(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policySets" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericSCAImplementation_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Requires" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getGenericSCAImplementation_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (genericSCAImplementationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "GenericSCAImplementationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaBindingEClass, 
		   source, 
		   new String[] {
			 "name", "SCABinding", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCABinding_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCABinding_URI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "URI" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaBindingUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCABindingUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaComponentEClass, 
		   source, 
		   new String[] {
			 "name", "SCAComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAComponent_Autowire(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Autowire" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAComponent_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (scaComponentUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAComponentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationBPELEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationBPEL", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationBPEL_Class(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "class" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationBPEL_PolicySets(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policySets" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationBPEL_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Requires" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationBPELUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationBPELUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationCompositeEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationComposite", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationComposite_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationComposite_PolicySets(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policySets" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationComposite_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Requires" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationComposite_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationCompositeUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationCompositeUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationCplusplusEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationCplusplus", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationCplusplus_Class(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "class" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationCplusplus_PolicySets(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policySets" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationCplusplus_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Requires" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationCplusplusUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationCplusplusUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationJavaEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationJava", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationJava_Class(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "class" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationJava_PolicySets(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "policySets" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAImplementationJava_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Requires" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaImplementationJavaUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAImplementationJavaUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "SCAInterface", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAInterface_CallBackInterface(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "CallBackInterface" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAInterface_Conversational(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "conversational" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAInterface_Interface(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Interface" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAInterface_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaInterfaceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAInterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaOperationEClass, 
		   source, 
		   new String[] {
			 "name", "SCAOperation", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAOperation_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAOperation_PolicySets(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "PolicySets" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAOperation_Requires(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Requires" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaOperationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAOperationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPolicyIntentEClass, 
		   source, 
		   new String[] {
			 "name", "SCAPolicyIntent", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAPolicyIntent_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPolicyIntentUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAPolicyIntentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPolicySetEClass, 
		   source, 
		   new String[] {
			 "name", "SCAPolicySet", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAPolicySet_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPolicySetUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAPolicySetUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPropertyEClass, 
		   source, 
		   new String[] {
			 "name", "SCAProperty", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAProperty_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Element" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAProperty_Many(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Many" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAProperty_MustSupply(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mustSupply" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAProperty_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAProperty_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Value" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPropertyUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAPropertyUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPropertyValueEClass, 
		   source, 
		   new String[] {
			 "name", "scaPropertyValue", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Element" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_File(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "File" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_Many(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Many" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_MustSupply(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "MustSupply" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_Source(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Source" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getScaPropertyValue_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Type" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaPropertyValueUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAPropertyValueUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAPropertyValueUnit_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaReferenceEClass, 
		   source, 
		   new String[] {
			 "name", "SCAReference", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAReference_Autowire(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Autowire" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAReference_Multiplicity(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Multiplicity" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAReference_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAReference_WiredByImpl(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "WiredByImpl" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaReferenceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAReferenceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilityGenericSCAImplementation(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.genericSCAImplementation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCABinding(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCABinding", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilityScaComponent(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.scaComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAImplementationBPEL(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAImplementationBPEL", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAImplementationComposite(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAImplementationComposite", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAImplementationCplusplus(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAImplementationCplusplus", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAImplementationJava(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAImplementationJava", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAInterface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAInterface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAOperation(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAOperation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAPolicyIntent(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAPolicyIntent", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAPolicySet(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAPolicySet", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilityScaProperty(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.scaProperty", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilityScaPropertyValue(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.scaPropertyValue", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilitySCAReference(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.SCAReference", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_CapabilityScaService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.scaService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitGenericscaImplementationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.genericscaImplementationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCABindingUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCABindingUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitScaComponentUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.scaComponentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAImplementationBPELUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAImplementationBPELUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAImplementationCompositeUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAImplementationCompositeUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAImplementationCplusplusUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAImplementationCplusplusUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAImplementationJavaUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAImplementationJavaUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAInterfaceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAInterfaceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAOperationUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAOperationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAPolicyIntentUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAPolicyIntentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAPolicySetUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAPolicySetUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitScaPropertyUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.scaPropertyUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitScaPropertyValueUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.scaPropertyValueUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitSCAReferenceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.SCAReferenceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCARoot_UnitScaServiceUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.scaServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaServiceEClass, 
		   source, 
		   new String[] {
			 "name", "SCAService", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSCAService_Name1(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "Name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (scaServiceUnitEClass, 
		   source, 
		   new String[] {
			 "name", "SCAServiceUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //ScaPackageImpl
