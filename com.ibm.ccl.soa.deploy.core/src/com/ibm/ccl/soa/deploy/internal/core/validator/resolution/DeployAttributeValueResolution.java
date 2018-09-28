/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolves an attribute expected value by overwriting the attribute value.
 * 
 * @deprecated use {@link DeploySetAttributeResolution}
 */
public class DeployAttributeValueResolution extends DeploySetAttributeResolution {

	/**
	 * Construct a resolution over the status.
	 * 
	 * @param status
	 *           the status used to compute the description.
	 * @param context
	 *           the deploy resolution context.
	 * @param generator
	 *           the generator of the resolution.
	 */
	public DeployAttributeValueResolution(IDeployAttributeValueStatus status,
			IDeployResolutionContext context, IDeployResolutionGenerator generator) {
		super(status.getDeployObject(), status.getAttributeType(),
				status.getAttributeExpectedValue(), null, context, generator);
		String message = null;
		if (status instanceof IDeployAttributeValueSourceStatus) {
			IDeployAttributeValueSourceStatus sourceStatus = (IDeployAttributeValueSourceStatus) status;
			if (ResolutionUtils.isSourceEncrypted(sourceStatus)) {
				Object sourceAttributeBinding = sourceStatus.getAttributeType() == null ? sourceStatus
						.getAttributeShortName() : sourceStatus.getAttributeType();
				message = DeployNLS
						.bind(
								DeployCoreMessages.Resolution_set_attribute_0_on_object_1_to_value_of_attribute_2_of_object_3,
								new Object[] { attributeType, status.getDeployObject(),
										sourceAttributeBinding,
										sourceStatus.getAttributeExpectedValueSourceObject() });
			}
		}
		if (message == null) {
			message = DeployNLS.bind(DeployCoreMessages.Resolution_set_attribute_0_to_value_1,
					new Object[] { attributeType, value });
		}
		setDescription(message);
	}

	/**
	 * Static factory method to create a resolution. Such a resolution might be used as a
	 * sub-resolution called by a more general resolution.
	 * 
	 * @param validatorID
	 *           id of the "validator" (ie, the caller) that created the resolution
	 * @param object
	 *           the object of the resolution
	 * @param attribute
	 *           the attribute to be updated
	 * @param value
	 *           the value to be assigned to the attribute
	 * @param oldContext
	 *           the calling resolution context
	 * @return a resolution
	 */
	public static DeployAttributeValueResolution createResolution(DeployModelObject object,
			EAttribute attribute, Object value, IDeployResolutionContext oldContext) {
		IDeployAttributeValueStatus status = DeployCoreStatusUtil.createAttributeInvalidStatus(
				IStatus.ERROR,
				DeployAttributeValueResolution.class.getName() + ".createResolution", object, //$NON-NLS-1$
				attribute, value);
		IDeployResolutionContext newContext = createResolutionContext(status, oldContext);
		return new DeployAttributeValueResolution(status, newContext, null);
	}
}
