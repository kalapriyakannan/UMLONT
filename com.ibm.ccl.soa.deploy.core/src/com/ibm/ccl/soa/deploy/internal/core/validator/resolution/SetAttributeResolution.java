/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionAttributeDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.datamodel.ResolutionDataModel;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.DeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Sets the value of a deploy object attribute that is undefined or invalid.
 * <p>
 * The value is provided by a parameterizer.
 */
public class SetAttributeResolution extends DeployParameterizedResolution {

	protected IDeployAttributeStatus aStatus;

	protected EAttribute attribute;

	protected String attributeName;

	protected Class<?> attributeType;

	protected IDataModel param;

	private final ResolutionAttributeDataModel attributeModel;

	/**
	 * Construct a resolution to set the attribute of a deploy model object.
	 * 
	 * @param context
	 *           the resolution context with a {@link IDeployAttributeStatus}.
	 * @param generator
	 *           the resolution generator.
	 */
	public SetAttributeResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		aStatus = (IDeployAttributeStatus) context.getDeployStatus();
		attribute = aStatus.getAttributeType();
		attributeName = aStatus.getAttributeShortName();
		String message = DeployNLS.bind(DeployCoreMessages.Resolution_set_attribute_0_on_1,
				(attribute != null ? attribute : attributeName), context.getDeployStatus()
						.getDeployObject());
		setDescription(message);
		setPriority(-100);

		attributeType = Object.class;
		if (aStatus.getAttributeType() != null) {
			attributeType = aStatus.getAttributeType().getEAttributeType().getInstanceClass();
		} else if (aStatus.getDeployObject().getExtendedAttribute(attributeName) != null) {
			ExtendedAttribute ext = aStatus.getDeployObject().getExtendedAttribute(attributeName);
			if (ext.getInstanceType() != null) {
				attributeType = ext.getInstanceType().getInstanceClass();
			}
		}

		attributeModel = ResolutionAttributeDataModel.createModel();
		attributeModel.setDeployModelObject(aStatus.getDeployObject());
		attributeModel.setAttribute(aStatus.getAttributeType());
		attributeModel.setAttributeName(attributeName);

		ResolutionDataModel resolutionDataModel = attributeModel.getResolutionDataModel();
		resolutionDataModel.setName(attributeName);
		resolutionDataModel.setType(attributeType);
		resolutionDataModel.setDescription(message);
		resolutionDataModel.setResolution(this);

		if (aStatus instanceof IDeployAttributeValueStatus) {
			resolutionDataModel.setValue(((IDeployAttributeValueStatus) aStatus)
					.getAttributeExpectedValue());
		}

		addParameter(attributeModel.getUnderlyingDataModel());
	}

	/*
	 * @seecom.ibm.ccl.soa.deploy.core.validator.resolution.param.DeployParameterizedResolution#
	 * resolveWithParameters(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolveWithParameters(IProgressMonitor monitor) {
		IDataModelOperation op = attributeModel.createConfiguredOperation();
		IStatus status;
		try {
			status = op.execute(monitor, null);
		} catch (ExecutionException e) {
			status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, DeployNLS.bind(
					DeployCoreMessages.Resolution_0_failed_with_error_1, new Object[] { this,
							e.getCause().getMessage() }), e.getCause());
		}
		return status;
	}

	/**
	 * Returns a safe wrapper over the data model for the attribute value.
	 * <p>
	 * The resolution has one parameter whose data model can be accessed through the
	 * {@link ResolutionAttributeDataModel} interface.
	 * <p>
	 * This is equivalent to:<code>
	 * return new ResolutionAttributeDataModel(getParameters().get(0));
	 * </code>
	 * 
	 * @return the type safe wrapper over the attribute data model.
	 */
	public ResolutionAttributeDataModel getAttributeDataModel() {
		return attributeModel;
	}

	/**
	 * @return the deploy attribute status associated with this resolution.
	 * @see #getDeployStatus()
	 */
	public IDeployAttributeStatus getDeployAttributeStatus() {
		return aStatus;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (aStatus == null) {
			return 0;
		}
		DeployModelObject dmo = aStatus.getDeployObject();
		String attrName = aStatus.getAttributeShortName();

		if (dmo == null && attrName == null) {
			return 0;
		}
		if (dmo == null) {
			return attrName.hashCode();
		}
		if (attrName == null) {
			return dmo.hashCode();
		}
		return dmo.hashCode() ^ attrName.hashCode();
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SetAttributeResolution)) {
			return false;
		}

		SetAttributeResolution res = (SetAttributeResolution) obj;
		IDeployAttributeStatus resStatus = res.getDeployAttributeStatus();
		if (resStatus == null) {
			return aStatus == null;
		}
		if (aStatus == null) {
			return false;
		}
		return ValidatorUtils.equals(aStatus.getDeployObject(), resStatus.getDeployObject())
				&& ValidatorUtils.equals(aStatus.getAttributeShortName(), resStatus
						.getAttributeShortName());
	}
}
