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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Context of resolution evaluation.
 */
public class DeployResolutionContext implements IDeployResolutionContext {

	protected Topology topology;

	protected IDeployStatus status;

	protected DeployValidatorService validator;

	protected List createdObjectList;

	protected List destroyedObjectList;

	protected IProgressMonitor monitor;

	/**
	 * Construct a resolution contex.
	 * 
	 * @param marker
	 *           the marker on the problem.
	 * @param topology
	 *           the topology over which the resolution will execute.
	 * @throws CoreException
	 *            if the marker cannot be accessed.
	 * 
	 * @deprecated switch to status based resolutions
	 */
	public DeployResolutionContext(IMarker marker, Topology topology) throws CoreException {
		assert marker != null;
		assert topology != null;
		this.topology = topology;
		status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(marker, topology);
	}

	/**
	 * Construct a deploy resolution context.
	 * 
	 * @param status
	 *           the deploy message.
	 * @param validator
	 *           the service used to perform validation and matching.
	 * @param monitor
	 *           the resolution progress and cancellation monitor.
	 */
	public DeployResolutionContext(IDeployStatus status, DeployValidatorService validator,
			IProgressMonitor monitor) {
		assert status != null;
		this.validator = validator;
		this.monitor = monitor;
		if (status.getDeployObject() != null) {
			topology = status.getDeployObject().getEditTopology();
		}
		this.status = status;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext#getTopology()
	 */
	public Topology getTopology() {
		return topology;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext#getDeployMessage()
	 */
	public IDeployStatus getDeployStatus() {
		return status;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext#getDeployValidatorService()
	 */
	public DeployValidatorService getDeployValidatorService() {
		return validator;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext#create(org.eclipse.emf.ecore.EClass)
	 * @deprecated
	 */
	public EObject create(EClass eClass) {
		if (createdObjectList == null) {
			createdObjectList = new ArrayList();
		}
		EObject object = eClass.getEPackage().getEFactoryInstance().create(eClass);
		createdObjectList.add(object);
		return object;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext#destroy(org.eclipse.emf.ecore.EObject)
	 * @deprecated
	 */

	/**
	 * Returns a list of objects created during resolution.
	 * <p>
	 * If an object was created and then subsequently deleted within the same resolution, then it is
	 * not returned.
	 * 
	 * @return List<DeployModelObject>
	 * @deprecated
	 */
	public List getCreatedObjects() {
		if (createdObjectList == null) {
			return Collections.EMPTY_LIST;
		}
		return createdObjectList;
	}

	/**
	 * Returns a list of objects destroyed during the resolution.
	 * 
	 * @return List<DeployModelObject>
	 * @deprecated
	 */
	public List getDestroyedObjects() {
		if (destroyedObjectList == null) {
			return Collections.EMPTY_LIST;
		}
		return destroyedObjectList;
	}

	/**
	 * Set the resolution context progress monitor.
	 * <p>
	 * If the monitor argument is null, the accessor method will create a new
	 * {@link NullProgressMonitor} next time it is invoked.
	 * 
	 * @param monitor
	 *           a progress monitor (may be null).
	 */
	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext#getProgressMonitor()
	 */
	public IProgressMonitor getProgressMonitor() {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		return monitor;
	}
}
