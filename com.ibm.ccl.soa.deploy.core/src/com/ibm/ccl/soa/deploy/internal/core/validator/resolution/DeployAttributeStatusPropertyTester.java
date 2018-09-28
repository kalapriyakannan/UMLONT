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

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;

/**
 * Eclipse core expression tests of the attributes of {@link IDeployAttributeStatus}.
 * <p>
 * Supports:
 * <ul>
 * <li> {@link #ATTRIBUTE_NAME}
 * </ul>
 */
public class DeployAttributeStatusPropertyTester extends PropertyTester {

	/**
	 * Constant for the equality tester of the {@link IDeployAttributeStatus#getAttributeName()}
	 * attribute.
	 * <p>
	 * String value = {@value}
	 */
	public static final String ATTRIBUTE_NAME = "attributeName"; //$NON-NLS-1$

	/*
	 * @see org.eclipse.core.expressions.PropertyTester#test(java.lang.Object, java.lang.String,
	 *      java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof IDeployAttributeStatus)) {
			return false;
		}

		IDeployAttributeStatus status = (IDeployAttributeStatus) receiver;
		if (property.equals(ATTRIBUTE_NAME)) {
			String name = status.getAttributeName();
			if (name == null) {
				return expectedValue == null;
			}
			if (expectedValue == null) {
				return false;
			}
			String expectedName = expectedValue instanceof String ? (String) expectedValue
					: expectedValue.toString();
			int expectedNameSeparatorIndex = expectedName
					.indexOf(IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR);
			int nameSeparatorIndex = name
					.indexOf(IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR);
			if (nameSeparatorIndex == -1) {
				if (expectedNameSeparatorIndex != -1) {
					expectedName = expectedName.substring(expectedNameSeparatorIndex + 1);
				}
				return status.getAttributeName().equals(expectedValue);
			}

			if (expectedNameSeparatorIndex == -1) {
				name = name.substring(nameSeparatorIndex + 1);
				return name.equals(expectedName);
			}
			return name.equals(expectedName);

		}
		return false;
	}
}
