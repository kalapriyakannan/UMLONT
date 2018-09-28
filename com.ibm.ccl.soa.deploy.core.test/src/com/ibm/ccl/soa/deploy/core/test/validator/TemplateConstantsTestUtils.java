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

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Static template constants file loading utilities.
 */
public class TemplateConstantsTestUtils {

	private TemplateConstantsTestUtils() {
	}

	/**
	 * Checks that the {@link IDeployStatus#getProblemType()} constant values
	 * are unique and consistent with the Java constant.
	 * 
	 * @param idClass
	 *            the interface with static template ID fields.
	 * @param pluginID
	 *            the id of the plugin.
	 */
	public static void checkTemplateIDs(Class idClass, String pluginID) {
		StringBuffer error = new StringBuffer();
		Field[] fields = idClass.getFields();
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
						error.append(fullName + " has empty template value\n");
					} else {
						Topology top = CoreFactory.eINSTANCE.createTopology();
						top.setName("topology");
						DeployModelObject object = ResolutionUtils.addFromTemplate((String) value, top); //$NON-NLS-1$
						if (object == null) {
							error.append("Cannot load template defined in "
									+ fullName + " = " + value + "\n");
						} else if (top.getUnits().size() == 0) {
							error.append(fullName + " = " + value
									+ " template does not contain any units\n");
						}
					}
				} catch (IllegalAccessException e) {
					error.append(e.toString());
				}
			}
		}
		if (error.length() > 0) {
			throw new RuntimeException(error.toString());
		}
	}
}
