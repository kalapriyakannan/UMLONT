/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.impl.CorePackageImpl;

/**
 * Tests the EMF manually coded operations.
 */
public class DeployManualOperationsTest extends TestCase {

	/**
	 * Checks that the {@link EClass} has a matching {@link EOperation}.
	 * 
	 * @param eClass
	 *            the class containing the {@link EOperation}.
	 * @param name
	 *            the name of the operation.
	 * @param returnType
	 *            the return operation type (may be null).
	 */
	public static void operationCheck(EClass eClass, String name,
			EClassifier returnType) {
		operationCheck(eClass, name, returnType, (EClassifier[]) null);
	}

	/**
	 * Checks that the {@link EClass} has a matching {@link EOperation}.
	 * 
	 * @param eClass
	 *            the class containing the {@link EOperation}.
	 * @param name
	 *            the name of the operation.
	 * @param returnType
	 *            the return operation type (may be null).
	 * @param parameterType
	 *            the single operation parameters (may be null).
	 */
	public static void operationCheck(EClass eClass, String name,
			EClassifier returnType, EClassifier parameterType) {
		if (parameterType == null) {
			operationCheck(eClass, name, returnType, (EClassifier[]) null);
		} else {
			operationCheck(eClass, name, returnType,
					new EClassifier[] { parameterType });
		}
	}

	/**
	 * Checks that the {@link EClass} has a matching {@link EOperation}.
	 * 
	 * @param eClass
	 *            the class containing the {@link EOperation}.
	 * @param name
	 *            the name of the operation.
	 * @param returnType
	 *            the return operation type (may be null).
	 * @param parameterTypes
	 *            the operation parameters (may be null).
	 */
	public static void operationCheck(EClass eClass, String name,
			EClassifier returnType, EClassifier[] parameterTypes) {
		boolean found = false;
		for (Iterator iter = eClass.getEOperations().iterator(); iter.hasNext();) {
			EOperation op = (EOperation) iter.next();
			if (op.getName().equals(name)) {
				found = true;
				if (returnType == null) {
					assert op.getEType() == null : "No return type expected for "
							+ op;
				} else {
					assert returnType.equals(op.getEType()) : "Invalid return type for "
							+ op;
				}
				if (parameterTypes == null) {
					assert op.getEParameters().size() == 0 : "No operations expected for "
							+ op;
				} else {
					assert parameterTypes.length == op.getEParameters().size() : "Invalid number of parameters for "
							+ op;
				}
				int index = 0;
				for (Iterator iter2 = op.getEParameters().iterator(); iter2
						.hasNext();) {
					EParameter param = (EParameter) iter2.next();
					assert parameterTypes[index] != null : "Illegal argument: null parameter type value";
					assert parameterTypes[index].equals(param.getEType()) : "Invalid "
							+ (index + 1) + " parameter type in " + op;
				}
			}
		}
		if (!found) {
			throw new RuntimeException(
					"Missing method '"
							+ name
							+ "' in class "
							+ eClass.getName()
							+ "\n"
							+ "Make sure that the CorePackageImpl#initializePackageContents() has been patched:"
							+ "  // BEGIN manual patch\n"
							+ "  addEOperation(requirementEClass, ecorePackage.getEClass(), \"getDmoEType\", 1, 1); //$NON-NLS-1$\n"
							+ "  op = addEOperation(requirementEClass, null, \"setDmoEType\"); //$NON-NLS-1$\n"
							+ "  addEParameter(op, ecorePackage.getEClass(), \"type\", 1, 1); //$NON-NLS-1$\n"
							+ "  addEOperation(extendedAttributeEClass, ecorePackage.getEJavaObject(), \"getValue\", 1, 1); //$NON-NLS-1$\n"
							+ "  op = addEOperation(extendedAttributeEClass, null, \"setValue\"); //$NON-NLS-1$\n"
							+ "  addEParameter(op, ecorePackage.getEJavaObject(), \"value\", 1, 1); //$NON-NLS-1$/n"
							+ "  addEOperation(extendedAttributeEClass, ecorePackage.getEDataType(), \"getInstanceType\", 1, 1); //$NON-NLS-1$\n"
							+ "  op = addEOperation(extendedAttributeEClass, null, \"setInstanceType\"); //$NON-NLS-1$\n"
							+ "  addEParameter(op, ecorePackage.getEDataType(), \"type\", 1, 1); //$NON-NLS-1$\n"
							+ "  // END manual patch\n");

		}
	}

	/**
	 * Tests the manually insterted operations in {@link CorePackageImpl}.
	 */
	public void testECoreParameterOperations() throws Exception {
		EDataType javaObjectType = EcorePackage.eINSTANCE.getEJavaObject();
		EClass eClassType = EcorePackage.eINSTANCE.getEClass();
		EClass eDataType = EcorePackage.eINSTANCE.getEDataType();

		EClass extAttrType = CorePackage.eINSTANCE.getExtendedAttribute();
		EClass reqType = CorePackage.eINSTANCE.getRequirement();

		operationCheck(extAttrType, "getValue", javaObjectType);
		operationCheck(extAttrType, "setValue", null, javaObjectType);

		operationCheck(extAttrType, "getInstanceType", eDataType);
		operationCheck(extAttrType, "setInstanceType", null, eDataType);

		operationCheck(reqType, "getDmoEType", eClassType);
		operationCheck(reqType, "setDmoEType", null, eClassType);
	}
}
