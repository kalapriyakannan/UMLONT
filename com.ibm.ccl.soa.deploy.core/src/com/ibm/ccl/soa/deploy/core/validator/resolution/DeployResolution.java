/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.resolution;

import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;

/**
 * Abstract implementation of the {@link IDeployResolution} interface.
 */
public abstract class DeployResolution implements IDeployResolution {

	protected String resolutionID;

	protected String description;

	protected IDeployResolutionContext context;

	protected IDeployResolutionGenerator generator;

	protected int priority = 0;

	protected boolean requiresUserInput = false;

	/**
	 * Construct a deploy resolution for the specified status and generator.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 */
	public DeployResolution(IDeployResolutionContext context, IDeployResolutionGenerator generator) {
		this(context, generator, null);
	}

	/**
	 * Construct a deploy resolution for the specified status, generator and description.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 * @param description
	 *           the resolution description.
	 */
	public DeployResolution(IDeployResolutionContext context, IDeployResolutionGenerator generator,
			String description) {
		assert context != null;
		this.context = context;
		this.generator = generator;
		if (description == null) {
			this.description = NLS.bind(DeployCoreMessages.Resolution_resolve_using_0, getClass()
					.getName());
		} else {
			this.description = description;
		}
	}

	/**
	 * Creates a new resolution context using the status and the values of the context.
	 * 
	 * @param status
	 *           the status associated with the resolution context.
	 * @param context
	 *           the parent resolution context used to obtain the remaining context values.
	 * @return a deploy resolution context bound to the specified status.
	 */
	protected static IDeployResolutionContext createResolutionContext(IDeployStatus status,
			IDeployResolutionContext context) {
		return new DeployResolutionContext(status, context.getDeployValidatorService(), context
				.getProgressMonitor());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#getResolutionID()
	 */
	public String getResolutionID() {
		return resolutionID;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#getPriority()
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority of the resolution.
	 * 
	 * @param priority
	 *           the resolution priority.
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#requiresUserInput()
	 */
	public boolean requiresUserInput() {
		return requiresUserInput;
	}

	/**
	 * Set the requirement for user input during resolution.
	 * 
	 * @param userInput
	 *           true if the user must provide additional input for the resolution, false if the
	 *           status suffices.
	 */
	public void setRequiresUserInput(boolean userInput) {
		requiresUserInput = userInput;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#getDeployStatus()
	 */
	public IDeployStatus getDeployStatus() {
		if (context == null) {
			return null;
		}
		return context.getDeployStatus();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#getDeployResolutionContext()
	 */
	public IDeployResolutionContext getDeployResolutionContext() {
		return context;
	}

	/**
	 * Sets the resolution description.
	 * 
	 * @param description
	 *           the resolution description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#getResolutionGenerator()
	 */
	public IDeployResolutionGenerator getResolutionGenerator() {
		return generator;
	}

	/*
	 * @see java.lang.Comparable#compareTo(T)
	 */
	public int compareTo(Object o) {
		return getPriority() - ((IDeployResolution) o).getPriority();
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (description != null) {
			return description;
		}
		return super.toString();
	}
}
