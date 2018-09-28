/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * 
 * Requirement Property Tester.
 * 
 */
public class RequirementPropertyTester extends PropertyTester {

	/**
	 * Constant to test whether the dmoType of the Requirement is compatible with the expected type.
	 * 'requirementDmoType' specifies expected dmoType (XML type) and its value should be in the form
	 * of 'namespace:typeName', where 'namespace' is the namespace of the EMF package where the (XML)
	 * type is defined, and 'typeName' is the type's (XML) name.
	 * 
	 * Example: 'http://www.ibm.com/ccl/soa/deploy/core/1.0.0/:Capability'
	 */
	public static final String REQUIREMENT_DMO_TYPE = "requirementDmoType"; //$NON-NLS-1$

	/**
	 * Constant to represent the linkType property.
	 */
	public static final String LINK_TYPE = "linkType"; //$NON-NLS-1$	

	/**
	 * Public constructor.
	 */
	public RequirementPropertyTester() {
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof Requirement)) {
			return false;
		}

		Requirement req = (Requirement) receiver;
		if (REQUIREMENT_DMO_TYPE.equals(property)) {
			EClass requirementType = req.getDmoEType();
			EClass expectedType = getEclassFromPropertyValue((String) expectedValue);
			if (expectedType != null && expectedType.isSuperTypeOf(requirementType)) {
				return true;
			}
		} else if (LINK_TYPE.equals(property)) {
			RequirementLinkTypes linkType = req.getLinkType();
			if (linkType != null && linkType.getLiteral() != null
					&& linkType.getLiteral().equals(expectedValue)) {
				return true;
			}
		}
		return false;
	}

	private EClass getEclassFromPropertyValue(String value) {
		if (value == null) {
			return null;
		}

		value = value.trim();
		int ind = value.lastIndexOf(':');
		if (ind < 0) {
			return null;
		}
		String namespace = value.substring(0, ind).trim();
		String type = value.substring(ind + 1).trim();
		if (type.length() == 0) {
			return null;
		}

		try {
			EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(namespace);
			if (pkg == null) {
				// we don't have this EMF Package
				String errMsg = NLS.bind(DeployCoreMessages.No_EMF_package_for_namespace_0,
						new Object[] { namespace });
				DeployCorePlugin.logError(0, errMsg, null);
				return null;
			}

			EClassifier classifier = pkg.getEClassifier(type);
			if (!(classifier instanceof EClass)) {
				// we don't have this EClass
				String errMsg = NLS.bind(DeployCoreMessages.No_EClass_for_type_name_0,
						new Object[] { type });
				DeployCorePlugin.logError(0, errMsg, null);
				return null;
			}

			return (EClass) classifier;

		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return null;
		}
	}
}
