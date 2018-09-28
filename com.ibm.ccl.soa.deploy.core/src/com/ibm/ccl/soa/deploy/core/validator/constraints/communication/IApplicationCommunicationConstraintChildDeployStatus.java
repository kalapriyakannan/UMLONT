/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Status associated with an {@link ApplicationCommunicationConstraint} child constraint.
 */
public interface IApplicationCommunicationConstraintChildDeployStatus extends IDeployStatus {

	/**
	 * Get the {@link NetworkCommunicationConstraint} that can be modified to fix the identified
	 * problem.
	 * 
	 * @return a network communication constraint
	 */
	public NetworkCommunicationConstraint getTargetNcc();

	/**
	 * Get the {@EClass} of the cosntraint type that can be created to fix the identified problem.
	 * 
	 * @return the constraint type
	 */
	public EClass getConstraintType();

	/**
	 * Get the display name that should be set for the new constraint.
	 * 
	 * @return the display name
	 */
	public String getDisplayName();

	/**
	 * Get any attribute, value pairs that should be set when creating a new constraint.
	 * 
	 * @return a list of attribute, value pairs
	 */
	public List<AttributeValuePair> getAttributeData();
}
