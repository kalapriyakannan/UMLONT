/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.resolution.param;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionGeneratorManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.ResolutionParameterizerDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.param.IResolutionDataModelProperties;

/**
 * Abstract implementation of a parameterized deploy resolution.
 */
public abstract class DeployParameterizedResolution extends DeployResolution implements
		IDeployParameterizedResolution, IResolutionDataModelProperties {

	/** List of parameters (may be null). */
	protected List<IDataModel> parameters;

	/** Unmodifiable wrapper on {@link #parameters} (may be null). */
	protected List<IDataModel> immutableParameters;

	/**
	 * Construct a parameterized deploy resolution for the specified status and generator.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 */
	public DeployParameterizedResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		this(context, generator, null);
	}

	/**
	 * Construct a parameterized deploy resolution for the specified status, generator and
	 * description.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 * @param description
	 *           the resolution description.
	 */
	public DeployParameterizedResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description) {
		super(context, generator, description);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution#getParameters()
	 */
	public List<IDataModel> getParameters() {
		if (immutableParameters == null) {
			return Collections.emptyList();
		}
		return immutableParameters;
	}

	/**
	 * Adds a parameter to the resolution parameter list.
	 * 
	 * @param param
	 */
	protected void addParameter(IDataModel param) {
		if (param == null) {
			throw new IllegalArgumentException(DeployCoreMessages.null_value);
		}
		if (parameters == null) {
			parameters = new ArrayList<IDataModel>();
			immutableParameters = Collections.unmodifiableList(parameters);
		}
		parameters.add(param);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		//
		// Find parameterizers
		//
		ResolutionParameterizerDescriptor[] descriptors = ResolutionGeneratorManager.getInstance()
				.getParameterizerDescriptors(this);
		if (descriptors == null || descriptors.length == 0) {
			String message = DeployNLS.bind(DeployCoreMessages.Resolution_0_no_parameterizers_found,
					this);
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, message);
		}

		//
		// Try parameterizers in order
		//
		IStatus parameterizerStatus = null;
		for (ResolutionParameterizerDescriptor d : descriptors) {
			try {
				IDeployResolutionParameterizer p = d.getResolutionParameterizer();
				parameterizerStatus = p.setParameters(this);
			} catch (Exception e) {
				parameterizerStatus = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, e
						.getLocalizedMessage(), e);
				DeployCorePlugin.log(parameterizerStatus);
			}
			if (parameterizerStatus != null && parameterizerStatus.isOK()) {
				break;
			}
		}
		if (parameterizerStatus == null) {
			return Status.CANCEL_STATUS;
		}
		if (!parameterizerStatus.isOK()) {
			return parameterizerStatus;
		}

		//
		// Check up on parameters
		//
		for (IDataModel dataModel : getParameters()) {
			//if (!dataModel.getBooleanProperty(VALUE_SET)) {
			//	String message = DeployNLS.bind(DeployCoreMessages.Resolution_0_parameter_1_not_set,
			//			this, dataModel.getStringProperty(NAME));
			//	return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, message);
			//}
			IStatus paramStatus = dataModel.validate();
			if (!paramStatus.isOK()) {
				return paramStatus;
			}
		}

		//
		// Delegate resolution
		//
		return resolveWithParameters(monitor);
	}

	/**
	 * Resolve the deploy status associated with this resolution.
	 * <p>
	 * Invoked by {@link #resolve(IProgressMonitor)} after the parameters have been successfully set
	 * by a parameterizer.
	 * 
	 * @param monitor
	 *           resolution progress monitor.
	 * @return the status of the resolution execution.
	 */
	public abstract IStatus resolveWithParameters(IProgressMonitor monitor);
}
