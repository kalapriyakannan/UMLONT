/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteStack;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypeRoot;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicTypes;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage
 * @generated
 */
public class DynamictypeSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static DynamictypePackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamictypeSwitch() {
		if (modelPackage == null) {
			modelPackage = DynamictypePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0),
					theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY: {
			DynamicPaletteEntry dynamicPaletteEntry = (DynamicPaletteEntry) theEObject;
			T result = caseDynamicPaletteEntry(dynamicPaletteEntry);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case DynamictypePackage.DYNAMIC_PALETTE_STACK: {
			DynamicPaletteStack dynamicPaletteStack = (DynamicPaletteStack) theEObject;
			T result = caseDynamicPaletteStack(dynamicPaletteStack);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case DynamictypePackage.DYNAMIC_TYPE_ROOT: {
			DynamicTypeRoot dynamicTypeRoot = (DynamicTypeRoot) theEObject;
			T result = caseDynamicTypeRoot(dynamicTypeRoot);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case DynamictypePackage.DYNAMIC_TYPES: {
			DynamicTypes dynamicTypes = (DynamicTypes) theEObject;
			T result = caseDynamicTypes(dynamicTypes);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Palette Entry</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Palette Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicPaletteEntry(DynamicPaletteEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Palette Stack</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Palette Stack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicPaletteStack(DynamicPaletteStack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Type Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Type Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicTypeRoot(DynamicTypeRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Types</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Types</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicTypes(DynamicTypes object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //DynamictypeSwitch
