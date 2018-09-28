/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;

/**
 * An Eclipse core expression tester for SOA deploy properties.
 * <p>
 * Supported properties:
 * <ul>
 * <li> {@value #ATTRIBUTE_EQUALS_PROPERTY} : see
 * {@link #attributeEqualsTester(EObject, Object[], Object)}.
 * </ul>
 * 
 * @see IPropertyTest
 */
public class DeployObjectPropertyTester extends PropertyTester {

	/**
	 * A property whose test compares the value of the <em>expected-value</em> to the value of a
	 * {@link EObject} attribute ({@link EObject#eGet(EStructuralFeature)}).
	 */
	public static final String ATTRIBUTE_EQUALS_PROPERTY = "attributeEquals"; //$NON-NLS-1$

	/*
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String,
	 *      java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver == null) {
			return false;
		}

		if (ATTRIBUTE_EQUALS_PROPERTY.equals(property)) {
			if (receiver instanceof EObject) {
				return attributeEqualsTester((EObject) receiver, args, expectedValue);
			}
		}

		return false;
	}

	/**
	 * Evaluates the "{@value #ATTRIBUTE_EQUALS_PROPERTY}" property.
	 * 
	 * @param object
	 *           a deploy object whose attribute value is evaluated.
	 * @param args
	 *           the name of the attribute.
	 * @param expectedValue
	 *           the expected value of the attribute.
	 * @return true if the attribute value matches, false if not, or the parameters are invalid.
	 */
	public boolean attributeEqualsTester(EObject object, Object[] args, Object expectedValue) {
		if (object == null) {
			return false;
		}

		if ((args.length != 1) || (!(args[0] instanceof String))) {
			return false;
		}

		String name = (String) args[0];
		EStructuralFeature feature = object.eClass().getEStructuralFeature(name);
		Object value = null;
		EDataType valueType = null;
		if (feature instanceof EAttribute) {
			EAttribute attribute = (EAttribute) feature;
			if (!object.eIsSet(attribute)) {
				return expectedValue == null;
			}
			value = object.eGet(attribute);
			valueType = attribute.getEAttributeType();
		} else if (object instanceof DeployModelObject) {
			DeployModelObject deployObject = (DeployModelObject) object;
			ExtendedAttribute extAttr = deployObject.getExtendedAttribute(name);
			if (extAttr != null) {
				value = extAttr.getValue();
				valueType = extAttr.getInstanceType();
			} else {
				return false;
			}
		} else {
			return false;
		}

		if (value == null) {
			return expectedValue == null;
		}

		if (expectedValue == null) {
			return false;
		}

		if (value.equals(expectedValue)) {
			return true;
		}

		if (expectedValue instanceof String) {
			try {
				Object deserializedExpectedValue = EcoreUtil.createFromString(valueType,
						(String) expectedValue);
				return value.equals(deserializedExpectedValue);
			} catch (Throwable e) {
				// TODO log
			}
		}
		return false;
	}
}
