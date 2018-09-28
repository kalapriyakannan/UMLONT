/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareSwitch.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage
 * @generated
 */
public class GenericsoftwareSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenericsoftwarePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsoftwareSwitch() {
		if (modelPackage == null) {
			modelPackage = GenericsoftwarePackage.eINSTANCE;
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
			case GenericsoftwarePackage.GENERICSOFTWARE_ROOT: {
				GenericsoftwareRoot genericsoftwareRoot = (GenericsoftwareRoot)theEObject;
				Object result = caseGenericsoftwareRoot(genericsoftwareRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenericsoftwarePackage.SOFTWARE_INSTALL: {
				SoftwareInstall softwareInstall = (SoftwareInstall)theEObject;
				Object result = caseSoftwareInstall(softwareInstall);
				if (result == null) result = caseCapability(softwareInstall);
				if (result == null) result = caseDeployModelObject(softwareInstall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenericsoftwarePackage.SOFTWARE_INSTALL_UNIT: {
				SoftwareInstallUnit softwareInstallUnit = (SoftwareInstallUnit)theEObject;
				Object result = caseSoftwareInstallUnit(softwareInstallUnit);
				if (result == null) result = caseUnit(softwareInstallUnit);
				if (result == null) result = caseDeployModelObject(softwareInstallUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenericsoftwarePackage.SOFTWARE_PATCH: {
				SoftwarePatch softwarePatch = (SoftwarePatch)theEObject;
				Object result = caseSoftwarePatch(softwarePatch);
				if (result == null) result = caseCapability(softwarePatch);
				if (result == null) result = caseDeployModelObject(softwarePatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenericsoftwarePackage.SOFTWARE_PATCH_UNIT: {
				SoftwarePatchUnit softwarePatchUnit = (SoftwarePatchUnit)theEObject;
				Object result = caseSoftwarePatchUnit(softwarePatchUnit);
				if (result == null) result = caseUnit(softwarePatchUnit);
				if (result == null) result = caseDeployModelObject(softwarePatchUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenericsoftwarePackage.VERSION: {
				Version version = (Version)theEObject;
				Object result = caseVersion(version);
				if (result == null) result = caseCapability(version);
				if (result == null) result = caseDeployModelObject(version);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenericsoftwareRoot(GenericsoftwareRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Install</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Install</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwareInstall(SoftwareInstall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Install Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Install Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwareInstallUnit(SoftwareInstallUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Patch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Patch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwarePatch(SoftwarePatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Patch Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Patch Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwarePatchUnit(SoftwarePatchUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVersion(Version object) {
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

} //GenericsoftwareSwitch
