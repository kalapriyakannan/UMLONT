/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Implemented by deploy domain validators.
 * <p>
 * This interface is not intended to be implemented or extended. Domain validators should extend the
 * {@link DomainValidator} abstract class.
 */
public interface IDomainValidator {

	/**
	 * Returns the namespace URI for the domain being validated.
	 * <p>
	 * Example: "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/"
	 * 
	 * @return a string representation of the domain namespace URI.
	 * 
	 * @see EPackage#getNsURI()
	 * @see EPackage.Registry#INSTANCE
	 * @see EPackage.Registry#getEPackage(String)
	 */
	public String getDomainNsURI();

	/**
	 * @return the ID of the Eclipse extension in which the domain validator was declared.
	 */
	public String getDomainID();

	/**
	 * @return the ID of the validation group with which this validator is associatede (not null).
	 * @see #getGroupDescription()
	 */
	public String getGroupID();

	/**
	 * @return a description of the group to which this validator belongs to.
	 * @see #getGroupID()
	 */
	public String getGroupDescription();

	/**
	 * Validates the topology for this domain creating appropriate deploy status.
	 * <p>
	 * Deploy status objects should <b>not</b> be directly added to the deploy objects using
	 * {@link DeployModelObject#addStatus(org.eclipse.core.runtime.IStatus)}. Instead, the
	 * {@link IDeployReporter#addStatus(IDeployStatus)} method should be used. This enables
	 * validation to rollback when cancelled, and to perform incremental status updates.
	 * 
	 * @param context
	 *           the domain validation context (used to extract the topology).
	 * @param reporter
	 *           used to report deploy status.
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter);
}
