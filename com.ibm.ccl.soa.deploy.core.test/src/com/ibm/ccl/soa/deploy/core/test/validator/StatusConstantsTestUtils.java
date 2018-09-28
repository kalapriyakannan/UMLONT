/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * Static marker testing methods.
 */
public class StatusConstantsTestUtils {

	private StatusConstantsTestUtils() {
	}

	/**
	 * Checks that the {@link IDeployStatus#getProblemType()} constant values
	 * are unique and consistent with the Java constant.
	 * 
	 * @param problemClass
	 *            the class with static problem type fields.
	 * @param pluginID
	 *            the id of the plugin.
	 * @param checkNames
	 *            true if the names should match the field names.
	 */
	public static void checkProblemTypes(Class problemClass, String pluginID,
			boolean checkNames) {
		StringBuffer error = new StringBuffer();
		Field[] fields = problemClass.getFields();
		Set typeSet = new HashSet();
		String pluginPrefix = pluginID + ".";
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getType().equals(String.class)) {
				try {
					String name = fields[i].getName();
					String fullName = fields[i].getDeclaringClass().getName()
							+ "#" + name;
					String value = (String) fields[i].get(null);
					if (value == null) {
						error.append(fullName + " is null\n");
					} else if (value.length() == 0) {
						error.append(fullName + " has empty string value\n");
					} else {
						if (pluginID != null) {
							if (!value.startsWith(pluginPrefix)) {
								error.append(fullName + " value " + value
										+ " does not have plugin prefix "
										+ pluginPrefix + "\n");
							}
						}
						if (checkNames) {
							int index = value.lastIndexOf('.');
							String shortValue = value;
							if (index != -1) {
								shortValue = value.substring(index + 1);
							}
							if (!(name.replaceAll("_", ""))
									.equalsIgnoreCase(shortValue)) {
								error.append(fullName + " value " + value
										+ " does not match\n");
							}
						}

						if (typeSet.contains(value)) {
							error.append(value
									+ " is not unique among problem types");
							error.append('\n');
						} else {
							typeSet.add(value);
						}
					}
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
		if (error.length() > 0) {
			throw new RuntimeException(error.toString());
		}

	}

	/**
	 * Checks that the problem markers are unique.
	 * 
	 * @param validatorIDClass
	 *            the class with static validator ID fields.
	 * @param pluginID
	 *            the id of the plugin.
	 * @param checkNames
	 *            true if the names should match the field names.
	 */
	public static void checkValidatorIDs(Class validatorIDClass,
			String pluginID, boolean checkNames) {
		StringBuffer error = new StringBuffer();
		Field[] fields = validatorIDClass.getFields();
		Set typeSet = new HashSet();
		String pluginPrefix = pluginID + ".";
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getType().equals(String.class)) {
				try {
					String name = fields[i].getName();
					String fullName = fields[i].getDeclaringClass().getName()
							+ "#" + name;
					String value = (String) fields[i].get(null);
					if (value == null) {
						error.append(fullName + " is null\n");
					} else if (value.length() == 0) {
						error.append(fullName + " has empty string value\n");
					} else {
						if (pluginID != null) {
							if (!value.startsWith(pluginPrefix)) {
								error.append(fullName + " value " + value
										+ " does not have plugin prefix "
										+ pluginPrefix + "\n");
							}
						}
						int index = value.lastIndexOf('.');
						String shortValue = value;
						if (index != -1) {
							shortValue = value.substring(index + 1);
						}
						if (checkNames) {
							if (!(name.equals(shortValue))) {
								error.append(fullName + " value " + value
										+ " does not match\n");
							}
						}

						if (typeSet.contains(value)) {
							error.append(value
									+ " is not unique among problem types\n");
							error.append('\n');
						} else {
							typeSet.add(value);
						}
					}
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
		if (error.length() > 0) {
			throw new RuntimeException(error.toString());
		}
	}
}
