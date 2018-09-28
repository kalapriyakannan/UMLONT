/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Resolution to add a {@link WasSecurity} capbility to a {@link WebsphereAppServerUnit}
 */
public class SetConstraintAttributeValueResolution extends DeployResolution {

	private final Constraint _constraint;
	private final String _attributeName;
	private final Object _value;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param constraint
	 *           constraint
	 * @param attribute
	 *           attribute (on constraint) to be set
	 * @param value
	 *           value
	 */
	public SetConstraintAttributeValueResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Constraint constraint,
			EAttribute attribute, Object value) {
		super(context, generator, message);
		_constraint = constraint;
		_attributeName = attribute.getName();
		_value = value;
	}

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 * @param constraint
	 *           constraint
	 * @param attributeName
	 *           attribute (on constraint) name
	 * @param value
	 *           value
	 */
	public SetConstraintAttributeValueResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, Constraint constraint,
			String attributeName, Object value) {
		super(context, generator, message);
		_constraint = constraint;
		_attributeName = attributeName;
		_value = value;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		boolean success = DeployModelObjectUtil
				.setAttributeValue(_constraint, _attributeName, _value);
		return success ? Status.OK_STATUS : Status.CANCEL_STATUS;
	}

}
