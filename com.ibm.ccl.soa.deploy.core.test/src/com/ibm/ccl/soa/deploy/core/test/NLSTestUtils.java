/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test;

import java.lang.reflect.Field;

/**
 * Static utility methods for NLS testing.
 */
public class NLSTestUtils {

	private NLSTestUtils() {
	}

	/**
	 * Checks that the NLS static fields of the class match the bundle
	 * declarations.
	 * 
	 * @param nlsClass
	 *            the NLS class.
	 * @param bundleName
	 *            the message bundle.
	 */
	public static void checkNLS(Class nlsClass, String bundleName) {
		// TODO use bundle
		StringBuffer error = new StringBuffer();
		Field[] fields = nlsClass.getFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getType().equals(String.class)) {
				try {
					String value = (String) fields[i].get(null);
					if (value == null) {
						error.append(fields[i].getDeclaringClass().getName()
								+ "." + fields[i].getName() + " is null\n");
					} else if (value.length() == 0) {
						error.append(fields[i].getDeclaringClass().getName()
								+ "." + fields[i].getName() + " is empty\n");
					} else if (value.startsWith("NLS missing message:")) {
						error.append(value);
						error.append('\n');
					}
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
		if (error.length() > 0) {
			throw new RuntimeException("Errors were found in the NLS class "
					+ nlsClass + " and its associated bundle " + bundleName
					+ ":\n" + error.toString());
		}
	}

}
