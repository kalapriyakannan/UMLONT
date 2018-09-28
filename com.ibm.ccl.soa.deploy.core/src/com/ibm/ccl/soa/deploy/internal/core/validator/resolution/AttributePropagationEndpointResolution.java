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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Resolution to set the value of a deploy status object attribute.
 */
public class AttributePropagationEndpointResolution extends DeployResolution {

	protected final String attributeName;

	protected final DeployModelObject object;

	protected final boolean isSource;

	/**
	 * Construct a resolution to set an attribute.
	 * 
	 * @param context
	 *           the resolution context identifying the status and the object on which it is defined.
	 * @param object
	 *           the capability which is being pointed.
	 * @param attributeName
	 *           the capability attribute name.
	 * @param isSource
	 *           true if {@link AttributePropagationConstraint#getSourceAttributeName()} should be
	 *           set, false for {@link AttributePropagationConstraint#getTargetAttributeName()}.
	 * @param generator
	 *           the generator which created this resolution.
	 */
	public AttributePropagationEndpointResolution(IDeployResolutionContext context,
			DeployModelObject object, String attributeName, boolean isSource,
			IDeployResolutionGenerator generator) {
		super(context, generator);
		String title;
		if (object instanceof Capability) {
			title = ((Capability) object).getCaptionProvider().titleWithContext((Capability) object);
		} else {
			title = DeployNLS.getName(object);
		}

		if (object instanceof Unit) {
			DeployNLS.getName(object);
		}
		if (isSource) {
			setDescription(DeployNLS.bind(DeployCoreMessages.Propagate_from_source_0_attribute_1,
					title, attributeName));
		} else {
			setDescription(DeployNLS.bind(DeployCoreMessages.Propagate_to_target_0_attribute_1, title,
					attributeName));
		}
		this.object = object;
		this.attributeName = attributeName;
		this.isSource = isSource;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		AttributePropagationConstraint c = (AttributePropagationConstraint) getDeployStatus()
				.getDeployObject();
		if (isSource) {
			c.setSourceObjectURI(object.getName());
			c.setSourceAttributeName(attributeName);
		} else {
			c.setTargetObjectURI(object.getName());
			c.setTargetAttributeName(attributeName);
		}
		return Status.OK_STATUS;
	}
}
