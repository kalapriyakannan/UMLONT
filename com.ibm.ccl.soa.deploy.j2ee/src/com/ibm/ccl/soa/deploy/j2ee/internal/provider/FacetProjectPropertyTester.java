/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.provider;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;

public class FacetProjectPropertyTester extends PropertyTester {

	private final String property = "memberOfFacetProject"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.property.equals(property)) {
			String facetID = (String) expectedValue;
			IProject project = J2EEDeployUtils.getProject((IAdaptable) receiver);
			if (J2EEDeployUtils.hasFacet(project, facetID)) {
				IProjectFacetVersion version = J2EEDeployUtils.getFacet(project, facetID);
				String j2eeVersion = version.getVersionString();
				return !(j2eeVersion.equals(J2EEVersionConstants.VERSION_1_5_TEXT) || j2eeVersion
						.equals("5.0")); //$NON-NLS-1$
			} else {
				return false;
			}
		}
		assert false;
		return false;
	}

}
