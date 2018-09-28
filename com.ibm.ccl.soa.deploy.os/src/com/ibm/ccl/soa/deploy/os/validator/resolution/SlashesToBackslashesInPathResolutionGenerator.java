/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.resolution;

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsProblemType;

/**
 * Generates resolutions on an object attribute with an expected value.
 */
public class SlashesToBackslashesInPathResolutionGenerator extends DeployResolutionGenerator {

	private String stringFromValue;

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (context.getDeployStatus() instanceof IDeployAttributeStatus) {
			String problemType = context.getDeployStatus().getProblemType();
			if (problemType.equals(IOsProblemType.PATH_INVALID_ON_WINDOWS_OPERATING_SYSTEM)) {
				IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
				EAttribute attributeType = status.getAttributeType();
				DeployModelObject object = status.getDeployObject();
				Object attributeValue = object.getEObject().eGet(attributeType);
				if (attributeValue instanceof String) {
					stringFromValue = (String) attributeValue;
					if (stringFromValue.indexOf("/") >= 0) { //$NON-NLS-1$
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}
		IDeployAttributeStatus status = (IDeployAttributeStatus) context.getDeployStatus();
		EAttribute attributeType = status.getAttributeType();

		String suggestedPath = stringFromValue.replace('/', '\\');
		return new IDeployResolution[] { new SlashesToBackslashesInPathResolution(context, this,
				attributeType, attributeType.getName(), stringFromValue, suggestedPath) };
	}
}
