/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameterizer;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;{@value ICommonDeployExtensionConstants#TAG_RESOLUTION}
 * /&gt;</b> configuration elements parsed from the <b>{@value DeployCorePlugin#PLUGIN_ID}.{@value ICommonDeployExtensionConstants#TAG_RESOLUTION}</b>
 * extension point.
 */
public class ResolutionParameterizerDescriptor extends CommonDescriptor {

	/**
	 * The variable name argument in
	 * {@link IEvaluationContext#addVariable(String, Object)} for the deploy
	 * object in {@link IDeployStatus#getDeployObject()}.
	 */
	public static final String DEPLOY_OBJECT_VARIABLE = "deployObject"; //$NON-NLS-1$

	private Expression enablementExpression = null;

	private final IContributor contributor;

	private final String id;

	private final String parameterizerClassName;

	private Class<?> resolutionClass = null;

	private boolean resolutionLookupError = false;

	private IStatus status = Status.OK_STATUS;

	/**
	 * @param anElement
	 *            The configuration element from the parsed extension point.
	 */
	public ResolutionParameterizerDescriptor(IConfigurationElement anElement) {
		super(anElement);
		Assert.isTrue(TAG_RESOLUTION_PARAMETERIZER.equals(anElement.getName()));

		id = getElement().getAttribute(ATT_ID);
		parameterizerClassName = getElement().getAttribute(ATT_CLASS);
		contributor = getElement().getContributor();

		Assert.isTrue(contributor != null);
		Assert.isTrue(contributor.getName() != null);

		IConfigurationElement[] enablementChild = getElement().getChildren(
				TAG_ENABLEMENT);
		if (enablementChild.length == 1) {
			try {
				enablementExpression = ExpressionConverter.getDefault()
						.perform(enablementChild[0]);
			} catch (CoreException e) {
				status = e.getStatus();
				DeployCorePlugin.log(status);
			}
		} else if (enablementChild.length > 1) {
			String message = NLS
					.bind(
							DeployCoreMessages.ResolutionDescriptor_Invalid_number_of_enablement_elements_in_0,
							getElement().getDeclaringExtension()
									.getExtensionPointUniqueIdentifier());
			status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
					message, null);
			DeployCorePlugin.log(status);
		}
	}

	/**
	 * Returns the status of processing the element.
	 * 
	 * @return the element processing status.
	 */
	public IStatus getStatus() {
		return status;
	}

	/**
	 * @return the contributor of this resolution extension.
	 * @see IConfigurationElement#getContributor()
	 */
	public IContributor getContributor() {
		return contributor;
	}

	/**
	 * Returns the global ID of the resolution (contributor name + ID).
	 * 
	 * @return the global ID of the resolution.
	 */
	public String getGlobalId() {
		return contributor.getName() + "." + getId(); //$NON-NLS-1$
	}

	/**
	 * @return The identifier provided by the extension ("id" attribute).
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return The expression provided by the extension "enablement" attribute).
	 */
	public Expression getEnablementExpression() {
		return enablementExpression;
	}

	/**
	 * Returns true if the parameterizer is enabled for the specified deploy
	 * resolution.
	 * 
	 * @param resolution
	 *            the deploy resolution.
	 * @return true if the parameterizer is enabled, false if the enablement
	 *         expression is false, or failed.
	 */
	public boolean isEnabled(IDeployResolution resolution) {
		if (!(resolution instanceof IDeployParameterizedResolution)) {
			return false;
		}
		if (enablementExpression == null) {
			return true;
		}
		EvaluationContext context = new EvaluationContext(null, resolution);
		try {
			if (resolution.getDeployStatus().getDeployObject() != null) {
				context.addVariable(DEPLOY_OBJECT_VARIABLE, resolution
						.getDeployStatus().getDeployObject());
			}
			EvaluationResult result = enablementExpression.evaluate(context);
			return EvaluationResult.TRUE.equals(result);
		} catch (CoreException e) {
			DeployCorePlugin.log(e.getStatus());
			return false;
		}
	}

	/**
	 * Returns the resolution parameterizer declared in the descriptor.
	 * 
	 * @return the resolution parameterizer, or null if it cannot be created.
	 */
	public IDeployResolutionParameterizer getResolutionParameterizer() {
		if (resolutionLookupError || (parameterizerClassName == null)
				|| (parameterizerClassName.trim().length() == 0)) {
			return null;
		}

		Bundle bundle = Platform.getBundle(contributor.getName());
		if (bundle == null) {
			return null;
		}
		try {
			if (resolutionClass == null) {
				resolutionClass = bundle.loadClass(parameterizerClassName);
			}
			IDeployResolutionParameterizer resolution = (IDeployResolutionParameterizer) resolutionClass
					.newInstance();
			return resolution;
		} catch (Throwable e) {
			DeployCorePlugin
					.log(
							IStatus.ERROR,
							0,
							NLS
									.bind(
											DeployCoreMessages.Resolution_parameterizer_class_0_missing,
											parameterizerClassName), e);
			// Prevent repeated logging of error.
			this.resolutionLookupError = true;
			return null;
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(id);
		buffer.append(" [name="); //$NON-NLS-1$
		buffer.append(getName());
		buffer.append(", enablement="); //$NON-NLS-1$
		buffer.append(enablementExpression);
		buffer.append("]"); //$NON-NLS-1$
		return buffer.toString();
	}
}
