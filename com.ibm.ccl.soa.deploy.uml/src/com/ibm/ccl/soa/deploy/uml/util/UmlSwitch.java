/**
 * <copyright> </copyright>
 * 
 * $Id: UmlSwitch.java,v 1.12 2008/02/05 22:17:43 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage
 * @generated
 */
public class UmlSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UmlSwitch() {
		if (modelPackage == null) {
			modelPackage = UmlPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UmlPackage.UML_ACTOR: {
				UMLActor umlActor = (UMLActor)theEObject;
				Object result = caseUMLActor(umlActor);
				if (result == null) result = caseUMLElementCapability(umlActor);
				if (result == null) result = caseBundleCapability(umlActor);
				if (result == null) result = caseCapability(umlActor);
				if (result == null) result = caseDeployModelObject(umlActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_ACTOR_UNIT: {
				UMLActorUnit umlActorUnit = (UMLActorUnit)theEObject;
				Object result = caseUMLActorUnit(umlActorUnit);
				if (result == null) result = caseBaseComponentUnit(umlActorUnit);
				if (result == null) result = caseUnit(umlActorUnit);
				if (result == null) result = caseDeployModelObject(umlActorUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_COMPONENT: {
				UMLComponent umlComponent = (UMLComponent)theEObject;
				Object result = caseUMLComponent(umlComponent);
				if (result == null) result = caseUMLElementCapability(umlComponent);
				if (result == null) result = caseBundleCapability(umlComponent);
				if (result == null) result = caseCapability(umlComponent);
				if (result == null) result = caseDeployModelObject(umlComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_DEPLOY_ROOT: {
				UMLDeployRoot umlDeployRoot = (UMLDeployRoot)theEObject;
				Object result = caseUMLDeployRoot(umlDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_ELEMENT_ARTIFACT: {
				UMLElementArtifact umlElementArtifact = (UMLElementArtifact)theEObject;
				Object result = caseUMLElementArtifact(umlElementArtifact);
				if (result == null) result = caseArtifact(umlElementArtifact);
				if (result == null) result = caseDeployModelObject(umlElementArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_ELEMENT_CAPABILITY: {
				UMLElementCapability umlElementCapability = (UMLElementCapability)theEObject;
				Object result = caseUMLElementCapability(umlElementCapability);
				if (result == null) result = caseBundleCapability(umlElementCapability);
				if (result == null) result = caseCapability(umlElementCapability);
				if (result == null) result = caseDeployModelObject(umlElementCapability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_INTERACTION_CONSTRAINT: {
				UMLInteractionConstraint umlInteractionConstraint = (UMLInteractionConstraint)theEObject;
				Object result = caseUMLInteractionConstraint(umlInteractionConstraint);
				if (result == null) result = caseConstraint(umlInteractionConstraint);
				if (result == null) result = caseDeployModelObject(umlInteractionConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_INTERFACE: {
				UMLInterface umlInterface = (UMLInterface)theEObject;
				Object result = caseUMLInterface(umlInterface);
				if (result == null) result = caseUMLElementCapability(umlInterface);
				if (result == null) result = caseBundleCapability(umlInterface);
				if (result == null) result = caseCapability(umlInterface);
				if (result == null) result = caseDeployModelObject(umlInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_INTERFACE_UNIT: {
				UMLInterfaceUnit umlInterfaceUnit = (UMLInterfaceUnit)theEObject;
				Object result = caseUMLInterfaceUnit(umlInterfaceUnit);
				if (result == null) result = caseUnit(umlInterfaceUnit);
				if (result == null) result = caseDeployModelObject(umlInterfaceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_PACKAGE_CAP: {
				UMLPackageCap umlPackageCap = (UMLPackageCap)theEObject;
				Object result = caseUMLPackageCap(umlPackageCap);
				if (result == null) result = caseUMLElementCapability(umlPackageCap);
				if (result == null) result = caseBundleCapability(umlPackageCap);
				if (result == null) result = caseCapability(umlPackageCap);
				if (result == null) result = caseDeployModelObject(umlPackageCap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlPackage.UML_PACKAGE_UNIT: {
				UMLPackageUnit umlPackageUnit = (UMLPackageUnit)theEObject;
				Object result = caseUMLPackageUnit(umlPackageUnit);
				if (result == null) result = caseUnit(umlPackageUnit);
				if (result == null) result = caseDeployModelObject(umlPackageUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Actor</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLActor(UMLActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Actor Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Actor Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLActorUnit(UMLActorUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Component</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLComponent(UMLComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Deploy Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLDeployRoot(UMLDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Element Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Element Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLElementArtifact(UMLElementArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Element Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Element Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLElementCapability(UMLElementCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interaction Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interaction Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLInteractionConstraint(UMLInteractionConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interface</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLInterface(UMLInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Interface Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Interface Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLInterfaceUnit(UMLInterfaceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Package Cap</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Package Cap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLPackageCap(UMLPackageCap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Package Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Package Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUMLPackageUnit(UMLPackageUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBundleCapability(BundleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBaseComponentUnit(BaseComponentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArtifact(Artifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //UmlSwitch
