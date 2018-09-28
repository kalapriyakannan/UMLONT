/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.properties;

import com.ibm.ccl.soa.deploy.core.Artifact;

/**
 * Static util methods for properties
 */
public class ModulePropertyUtils extends PropertyUtils {

	/**
	 * @param artifact
	 * @return display name for an Artifact
	 */
	public static String getName(Artifact artifact) {
		String name = PropertyUtils.getName2(artifact /* , Messages.ModulePropertyUtils_ARTIFACT */);
		if (name != null) {
			return name;
		}

		// Unlike other DMOs, Artifacts are legally allowed to not have a name?
		return Messages.ModulePropertyUtils_ARTIFACT;
	}
}
