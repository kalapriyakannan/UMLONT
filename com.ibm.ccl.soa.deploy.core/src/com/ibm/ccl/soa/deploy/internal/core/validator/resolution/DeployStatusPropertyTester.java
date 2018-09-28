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
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Eclipse core expression tests of the attributes of {@link IDeployStatus}.
 * <p>
 * Supports:
 * <ul>
 * <li> {@link #SEVERITY}
 * <li> {@link #PROBLEM_TYPE}
 * <li> {@link #VALIDATOR_ID}
 * </ul>
 */
public class DeployStatusPropertyTester extends PropertyTester {

	/**
	 * Constant for the equality tester of the {@link IDeployStatus#getProblemType()} attribute.
	 * <p>
	 * String value = {@value}
	 */
	public static final String PROBLEM_TYPE = "problemType"; //$NON-NLS-1$

	/**
	 * Constant for the equality tester of the {@link IDeployStatus#getValidatorID()} attribute.
	 * <p>
	 * String value = {@value}
	 */
	public static final String VALIDATOR_ID = "validatorID"; //$NON-NLS-1$

	/**
	 * Constant for the equality tester of the {@link IDeployStatus#getSeverity()} attribute.
	 * <p>
	 * String value = {@value}
	 */
	public static final String SEVERITY = "severity"; //$NON-NLS-1$

	/*
	 * @see org.eclipse.core.expressions.PropertyTester#test(java.lang.Object, java.lang.String,
	 *      java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof IDeployStatus)) {
			return false;
		}

		IDeployStatus status = (IDeployStatus) receiver;
		if (property.equals(PROBLEM_TYPE)) {
			if (status.getProblemType() == null) {
				return expectedValue == null;
			}
			return status.getProblemType().equals(expectedValue);
		} else if (property.equals(VALIDATOR_ID)) {
			if (status.getValidatorID() == null) {
				return expectedValue == null;
			}
			return status.getValidatorID().equals(expectedValue);
		} else if (property.equals(SEVERITY)) {
			if (expectedValue == null) {
				return false;
			}
			if (expectedValue instanceof Number) {
				return status.getSeverity() == ((Number) expectedValue).intValue();
			}

			String stringValue;
			if (expectedValue instanceof String) {
				stringValue = (String) expectedValue;
			} else {
				stringValue = expectedValue.toString();
			}

			try {
				int expectedSeverity = Integer.parseInt(stringValue.trim());
				return expectedSeverity == status.getSeverity();
			} catch (Throwable e) {
				// ignore
			}
			if (stringValue.equalsIgnoreCase("ERROR")) { //$NON-NLS-1$
				return status.getSeverity() == IStatus.ERROR;
			}
			if (stringValue.equalsIgnoreCase("WARNING")) { //$NON-NLS-1$
				return status.getSeverity() == IStatus.WARNING;
			}
			if (stringValue.equalsIgnoreCase("INFO")) { //$NON-NLS-1$
				return status.getSeverity() == IStatus.INFO;
			}
			if (stringValue.equals("CANCEL")) { //$NON-NLS-1$
				return status.getSeverity() == IStatus.CANCEL;
			}
			return false;
		}
		return false;
	}
}
