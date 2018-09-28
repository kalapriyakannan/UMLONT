/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.validator.resolution;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

public class IDEResolutionUtils {

	/**
	 * Returns true if the requirement is an unlinked Datasource requirement
	 * 
	 * @param req
	 * @return
	 */
	public static boolean isUnsatisfiedDataSourceRequirement(Requirement req) {
		if (req == null || req.getDmoEType() == null)
			return false;
		if (!req.getDmoEType().equals(J2eePackage.eINSTANCE.getJ2EEDatasource()))
			return false;
		if (req.getLink() != null)
			return false;

		return true;
	}

	/**
	 * Returns true if the unit is hosted on a server with an the WTP runtime type annotation
	 * contained in the serverTypeIds array
	 * 
	 * @param unit
	 * @param serverTypeIds
	 * @return
	 */
	public static boolean isHostedOnServerTarget(Unit unit, String[] serverTypeIds) {
		Unit host = ValidatorUtils.getHost(unit);
		return hasRuntimeAnnotation(serverTypeIds, host);

	}

	public static boolean hasRuntimeAnnotation(String[] serverTypeIds, Unit host) {
		if (host == null)
			return false;
		Annotation annotation = host.findAnnotation(IAnnotationConstants.ENVIRONMENT_WTP);
		if (annotation != null) {
			String runtimeType = (String) annotation.getDetails().get(
					IAnnotationConstants.RUNTIME_TYPE);
			if (runtimeType != null) {
				for (int i = 0; i < serverTypeIds.length; i++) {
					if (runtimeType.startsWith(serverTypeIds[i]))
						return true;
				}
			}
		}
		return false;
	}

}
