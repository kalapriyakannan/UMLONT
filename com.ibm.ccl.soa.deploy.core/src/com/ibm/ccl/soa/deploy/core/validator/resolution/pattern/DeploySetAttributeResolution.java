/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution.pattern;

import java.text.NumberFormat;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A generic resolution for setting the value of a {@link DeployModelObject} attribute.
 * <p>
 * Supports both {@link EStructuralFeature} as well as {@link ExtendedAttribute} attributes.
 */
public class DeploySetAttributeResolution extends DeployResolution {

	/**
	 * The object on which the attribute will be set.
	 */
	protected final DeployModelObject object;

	/**
	 * The attribute to be set (static or dynamic).
	 */
	protected final EAttribute attributeType;

	/**
	 * The value to which the attribute will be set.
	 */
	protected final Object value;

	/**
	 * Construct a resolution that will set the attribute of the {@link DeployModelObject} of the
	 * {@link IDeployStatus}.
	 * <p>
	 * The object is identified using {@link IDeployResolutionContext#getDeployStatus()} and then
	 * {@link IDeployStatus#getDeployObject()}.
	 * 
	 * @param context
	 *           the deploy resolution context.
	 * @param generator
	 *           the generator creating this status.
	 * @param attributeName
	 *           the name of the status deploy object attribute ({@link EAttribute} or
	 *           {@link ExtendedAttribute}).
	 * @param value
	 *           the value to which the attribute will be set.
	 * @param description
	 *           the description of the resolution.
	 */
	public DeploySetAttributeResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String attributeName, Object value,
			String description) {
		this(context, generator, attributeName, value, description, context.getDeployStatus()
				.getDeployObject());
	}

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
	public DeploySetAttributeResolution(IDeployAttributeValueStatus status,
			IDeployResolutionContext context, IDeployResolutionGenerator generator) {
		this(status.getDeployObject(), status.getAttributeType(), status.getAttributeExpectedValue(),
				null, context, generator);
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
			message = computeDescription();
		}
		setDescription(message);
	}

	/**
	 * Construct a resolution that will set the attribute of a {@link DeployModelObject}.
	 * 
	 * @param context
	 *           the deploy resolution context.
	 * @param generator
	 *           the generator creating this status.
	 * @param attributeName
	 *           the name of the status deploy object attribute ({@link EAttribute} or
	 *           {@link ExtendedAttribute}).
	 * @param value
	 *           the value to which the attribute will be set.
	 * @param description
	 *           the description of the resolution.
	 * @param object
	 *           the object whose attribute will be set.
	 */
	public DeploySetAttributeResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String attributeName, Object value,
			String description, DeployModelObject object) {
		this(object, DeployModelObjectUtil.getAttribute(object, attributeName), value, description,
				context, generator);
	}

	/**
	 * Construct a resolution that will set the attribute of a {@link DeployModelObject}.
	 * 
	 * @param object
	 *           the object whose attribute will be set.
	 * @param attributeType
	 *           the type of the attribute of the deploy object, static ({@link EAttribute}) or
	 *           dynamic ({@link ExtendedAttribute}).
	 * @param value
	 *           the value to which the attribute will be set.
	 * @param description
	 *           the description of the resolution.
	 * @param context
	 *           the deploy resolution context.
	 * @param generator
	 *           the generator creating this status.
	 */
	public DeploySetAttributeResolution(DeployModelObject object, EAttribute attributeType,
			Object value, String description, IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		assert attributeType != null;
		this.object = object;
		this.attributeType = attributeType;
		this.value = value;
		if (description == null) {
			this.description = computeDescription();
		} else {
			this.description = description;
		}
	}

	/**
	 * Computes the description based on the object and attribute values.
	 * 
	 * @return the recommended description for the resolution.
	 */
	protected String computeDescription() {
		Object valueDescr = value;
		if (object != null && attributeType != null
				&& DeployModelObjectUtil.isEncrypted(object, attributeType)) {
			valueDescr = "*****"; //$NON-NLS-1$
		}
		if (valueDescr instanceof Number) {
			valueDescr = NumberFormat.getNumberInstance().format(valueDescr);
		}
		return DeployNLS.bind(DeployCoreMessages.Resolution_set_attribute_0_to_value_1,
				attributeType, valueDescr);
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core
	 * .runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		boolean success = DeployModelObjectUtil.setAttributeValue(object, attributeType, value);
		if (!success) {
			String message = DeployNLS.bind(
					DeployCoreMessages.Resolution_set_attribute_0_not_found_on_1, attributeType, object);
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, message);
		}
		return Status.OK_STATUS;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int code = 0;
		if (object != null) {
			code ^= object.hashCode();
		}
		if (attributeType != null) {
			code ^= attributeType.hashCode();
		}
		return code;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof DeploySetAttributeResolution)) {
			return false;
		}
		DeploySetAttributeResolution r = (DeploySetAttributeResolution) obj;

		return ValidatorUtils.equals(object, r.object)
				&& ValidatorUtils.equals(attributeType, r.attributeType)
				&& ValidatorUtils.equals(value, r.value);

	}
}
