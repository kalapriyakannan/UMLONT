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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Interface to the context of a SOA deploy problem resolution.
 */
public interface IDeployResolutionContext {
	/**
	 * Returns the topology of the status.
	 * 
	 * @return the topology of the status.
	 */
	public Topology getTopology();

	/**
	 * Returns the deploy problem status.
	 * 
	 * @return the deploy problem status.
	 */
	public IDeployStatus getDeployStatus();

	/**
	 * Returns the validation and matching service.
	 * <p>
	 * Resolutions may use the matching service to find resources.
	 * 
	 * @return the validator service.
	 */
	public DeployValidatorService getDeployValidatorService();

	/**
	 * Creates an object in an MSL and UI update safe way.
	 * 
	 * @param eClass
	 *           the EMF class of the new object.
	 * @return the created object.
	 * 
	 * @deprecated
	 */
	public EObject create(EClass eClass);

	/**
	 * @return the progress monitor associated with this resolution context (never null).
	 */
	public IProgressMonitor getProgressMonitor();
}
