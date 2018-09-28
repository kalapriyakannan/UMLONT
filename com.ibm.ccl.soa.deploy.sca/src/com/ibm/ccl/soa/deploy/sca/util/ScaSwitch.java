/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage
 * @generated
 */
public class ScaSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaSwitch() {
		if (modelPackage == null) {
			modelPackage = ScaPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ScaPackage.GENERIC_SCA_IMPLEMENTATION: {
				GenericSCAImplementation genericSCAImplementation = (GenericSCAImplementation)theEObject;
				Object result = caseGenericSCAImplementation(genericSCAImplementation);
				if (result == null) result = caseCapability(genericSCAImplementation);
				if (result == null) result = caseDeployModelObject(genericSCAImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.GENERIC_SCA_IMPLEMENTATION_UNIT: {
				GenericSCAImplementationUnit genericSCAImplementationUnit = (GenericSCAImplementationUnit)theEObject;
				Object result = caseGenericSCAImplementationUnit(genericSCAImplementationUnit);
				if (result == null) result = caseUnit(genericSCAImplementationUnit);
				if (result == null) result = caseDeployModelObject(genericSCAImplementationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_BINDING: {
				SCABinding scaBinding = (SCABinding)theEObject;
				Object result = caseSCABinding(scaBinding);
				if (result == null) result = caseCapability(scaBinding);
				if (result == null) result = caseDeployModelObject(scaBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_BINDING_UNIT: {
				SCABindingUnit scaBindingUnit = (SCABindingUnit)theEObject;
				Object result = caseSCABindingUnit(scaBindingUnit);
				if (result == null) result = caseUnit(scaBindingUnit);
				if (result == null) result = caseDeployModelObject(scaBindingUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_COMPONENT: {
				SCAComponent scaComponent = (SCAComponent)theEObject;
				Object result = caseSCAComponent(scaComponent);
				if (result == null) result = caseCapability(scaComponent);
				if (result == null) result = caseDeployModelObject(scaComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_COMPONENT_UNIT: {
				SCAComponentUnit scaComponentUnit = (SCAComponentUnit)theEObject;
				Object result = caseSCAComponentUnit(scaComponentUnit);
				if (result == null) result = caseUnit(scaComponentUnit);
				if (result == null) result = caseDeployModelObject(scaComponentUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_BPEL: {
				SCAImplementationBPEL scaImplementationBPEL = (SCAImplementationBPEL)theEObject;
				Object result = caseSCAImplementationBPEL(scaImplementationBPEL);
				if (result == null) result = caseCapability(scaImplementationBPEL);
				if (result == null) result = caseDeployModelObject(scaImplementationBPEL);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_BPEL_UNIT: {
				SCAImplementationBPELUnit scaImplementationBPELUnit = (SCAImplementationBPELUnit)theEObject;
				Object result = caseSCAImplementationBPELUnit(scaImplementationBPELUnit);
				if (result == null) result = caseUnit(scaImplementationBPELUnit);
				if (result == null) result = caseDeployModelObject(scaImplementationBPELUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_COMPOSITE: {
				SCAImplementationComposite scaImplementationComposite = (SCAImplementationComposite)theEObject;
				Object result = caseSCAImplementationComposite(scaImplementationComposite);
				if (result == null) result = caseCapability(scaImplementationComposite);
				if (result == null) result = caseDeployModelObject(scaImplementationComposite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_COMPOSITE_UNIT: {
				SCAImplementationCompositeUnit scaImplementationCompositeUnit = (SCAImplementationCompositeUnit)theEObject;
				Object result = caseSCAImplementationCompositeUnit(scaImplementationCompositeUnit);
				if (result == null) result = caseUnit(scaImplementationCompositeUnit);
				if (result == null) result = caseDeployModelObject(scaImplementationCompositeUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_CPLUSPLUS: {
				SCAImplementationCplusplus scaImplementationCplusplus = (SCAImplementationCplusplus)theEObject;
				Object result = caseSCAImplementationCplusplus(scaImplementationCplusplus);
				if (result == null) result = caseCapability(scaImplementationCplusplus);
				if (result == null) result = caseDeployModelObject(scaImplementationCplusplus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_CPLUSPLUS_UNIT: {
				SCAImplementationCplusplusUnit scaImplementationCplusplusUnit = (SCAImplementationCplusplusUnit)theEObject;
				Object result = caseSCAImplementationCplusplusUnit(scaImplementationCplusplusUnit);
				if (result == null) result = caseUnit(scaImplementationCplusplusUnit);
				if (result == null) result = caseDeployModelObject(scaImplementationCplusplusUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_JAVA: {
				SCAImplementationJava scaImplementationJava = (SCAImplementationJava)theEObject;
				Object result = caseSCAImplementationJava(scaImplementationJava);
				if (result == null) result = caseCapability(scaImplementationJava);
				if (result == null) result = caseDeployModelObject(scaImplementationJava);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_IMPLEMENTATION_JAVA_UNIT: {
				SCAImplementationJavaUnit scaImplementationJavaUnit = (SCAImplementationJavaUnit)theEObject;
				Object result = caseSCAImplementationJavaUnit(scaImplementationJavaUnit);
				if (result == null) result = caseUnit(scaImplementationJavaUnit);
				if (result == null) result = caseDeployModelObject(scaImplementationJavaUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_INTERFACE: {
				SCAInterface scaInterface = (SCAInterface)theEObject;
				Object result = caseSCAInterface(scaInterface);
				if (result == null) result = caseCapability(scaInterface);
				if (result == null) result = caseDeployModelObject(scaInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_INTERFACE_UNIT: {
				SCAInterfaceUnit scaInterfaceUnit = (SCAInterfaceUnit)theEObject;
				Object result = caseSCAInterfaceUnit(scaInterfaceUnit);
				if (result == null) result = caseUnit(scaInterfaceUnit);
				if (result == null) result = caseDeployModelObject(scaInterfaceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_OPERATION: {
				SCAOperation scaOperation = (SCAOperation)theEObject;
				Object result = caseSCAOperation(scaOperation);
				if (result == null) result = caseCapability(scaOperation);
				if (result == null) result = caseDeployModelObject(scaOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_OPERATION_UNIT: {
				SCAOperationUnit scaOperationUnit = (SCAOperationUnit)theEObject;
				Object result = caseSCAOperationUnit(scaOperationUnit);
				if (result == null) result = caseUnit(scaOperationUnit);
				if (result == null) result = caseDeployModelObject(scaOperationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_POLICY_INTENT: {
				SCAPolicyIntent scaPolicyIntent = (SCAPolicyIntent)theEObject;
				Object result = caseSCAPolicyIntent(scaPolicyIntent);
				if (result == null) result = caseCapability(scaPolicyIntent);
				if (result == null) result = caseDeployModelObject(scaPolicyIntent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_POLICY_INTENT_UNIT: {
				SCAPolicyIntentUnit scaPolicyIntentUnit = (SCAPolicyIntentUnit)theEObject;
				Object result = caseSCAPolicyIntentUnit(scaPolicyIntentUnit);
				if (result == null) result = caseUnit(scaPolicyIntentUnit);
				if (result == null) result = caseDeployModelObject(scaPolicyIntentUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_POLICY_SET: {
				SCAPolicySet scaPolicySet = (SCAPolicySet)theEObject;
				Object result = caseSCAPolicySet(scaPolicySet);
				if (result == null) result = caseCapability(scaPolicySet);
				if (result == null) result = caseDeployModelObject(scaPolicySet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_POLICY_SET_UNIT: {
				SCAPolicySetUnit scaPolicySetUnit = (SCAPolicySetUnit)theEObject;
				Object result = caseSCAPolicySetUnit(scaPolicySetUnit);
				if (result == null) result = caseUnit(scaPolicySetUnit);
				if (result == null) result = caseDeployModelObject(scaPolicySetUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_PROPERTY: {
				SCAProperty scaProperty = (SCAProperty)theEObject;
				Object result = caseSCAProperty(scaProperty);
				if (result == null) result = caseCapability(scaProperty);
				if (result == null) result = caseDeployModelObject(scaProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_PROPERTY_UNIT: {
				SCAPropertyUnit scaPropertyUnit = (SCAPropertyUnit)theEObject;
				Object result = caseSCAPropertyUnit(scaPropertyUnit);
				if (result == null) result = caseUnit(scaPropertyUnit);
				if (result == null) result = caseDeployModelObject(scaPropertyUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_PROPERTY_VALUE: {
				ScaPropertyValue scaPropertyValue = (ScaPropertyValue)theEObject;
				Object result = caseScaPropertyValue(scaPropertyValue);
				if (result == null) result = caseCapability(scaPropertyValue);
				if (result == null) result = caseDeployModelObject(scaPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_PROPERTY_VALUE_UNIT: {
				SCAPropertyValueUnit scaPropertyValueUnit = (SCAPropertyValueUnit)theEObject;
				Object result = caseSCAPropertyValueUnit(scaPropertyValueUnit);
				if (result == null) result = caseUnit(scaPropertyValueUnit);
				if (result == null) result = caseDeployModelObject(scaPropertyValueUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_REFERENCE: {
				SCAReference scaReference = (SCAReference)theEObject;
				Object result = caseSCAReference(scaReference);
				if (result == null) result = caseCapability(scaReference);
				if (result == null) result = caseDeployModelObject(scaReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_REFERENCE_UNIT: {
				SCAReferenceUnit scaReferenceUnit = (SCAReferenceUnit)theEObject;
				Object result = caseSCAReferenceUnit(scaReferenceUnit);
				if (result == null) result = caseUnit(scaReferenceUnit);
				if (result == null) result = caseDeployModelObject(scaReferenceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_ROOT: {
				SCARoot scaRoot = (SCARoot)theEObject;
				Object result = caseSCARoot(scaRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_SERVICE: {
				SCAService scaService = (SCAService)theEObject;
				Object result = caseSCAService(scaService);
				if (result == null) result = caseCapability(scaService);
				if (result == null) result = caseDeployModelObject(scaService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScaPackage.SCA_SERVICE_UNIT: {
				SCAServiceUnit scaServiceUnit = (SCAServiceUnit)theEObject;
				Object result = caseSCAServiceUnit(scaServiceUnit);
				if (result == null) result = caseUnit(scaServiceUnit);
				if (result == null) result = caseDeployModelObject(scaServiceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic SCA Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic SCA Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenericSCAImplementation(GenericSCAImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic SCA Implementation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic SCA Implementation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenericSCAImplementationUnit(GenericSCAImplementationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCABinding(SCABinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Binding Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Binding Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCABindingUnit(SCABindingUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAComponent(SCAComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Component Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Component Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAComponentUnit(SCAComponentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation BPEL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation BPEL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationBPEL(SCAImplementationBPEL object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation BPEL Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation BPEL Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationBPELUnit(SCAImplementationBPELUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation Composite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationComposite(SCAImplementationComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation Composite Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation Composite Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationCompositeUnit(SCAImplementationCompositeUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation Cplusplus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation Cplusplus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationCplusplus(SCAImplementationCplusplus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation Cplusplus Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation Cplusplus Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationCplusplusUnit(SCAImplementationCplusplusUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation Java</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation Java</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationJava(SCAImplementationJava object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Implementation Java Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Implementation Java Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAImplementationJavaUnit(SCAImplementationJavaUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAInterface(SCAInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Interface Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Interface Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAInterfaceUnit(SCAInterfaceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAOperation(SCAOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Operation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Operation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAOperationUnit(SCAOperationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Policy Intent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Policy Intent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAPolicyIntent(SCAPolicyIntent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Policy Intent Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Policy Intent Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAPolicyIntentUnit(SCAPolicyIntentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Policy Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Policy Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAPolicySet(SCAPolicySet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Policy Set Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Policy Set Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAPolicySetUnit(SCAPolicySetUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAProperty(SCAProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Property Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Property Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAPropertyUnit(SCAPropertyUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseScaPropertyValue(ScaPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Property Value Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Property Value Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAPropertyValueUnit(SCAPropertyValueUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAReference(SCAReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Reference Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Reference Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAReferenceUnit(SCAReferenceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCARoot(SCARoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAService(SCAService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCA Service Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCA Service Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSCAServiceUnit(SCAServiceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ScaSwitch
