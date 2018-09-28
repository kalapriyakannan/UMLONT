/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerOperation;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * @author jeswanke
 * 
 * operation to create the topology model, then passes the result to the visualization operation to
 * create the GMF diagram
 */
public class CreateDeploymentTopologyOperation extends AbstractScribblerOperation implements
		IUndoableOperation {

	/**
	 * 
	 */
	public CreateDeploymentTopologyOperation() {
		super();
	}

	/**
	 * @param dataModel
	 */
	public CreateDeploymentTopologyOperation(IDataModel dataModel) {
		super(dataModel);
	}

	private void create(IFolder deploymentFolder, IProgressMonitor monitor) throws CoreException {
		if (!deploymentFolder.getParent().exists()) {
			if (deploymentFolder.getParent().getType() == IResource.FOLDER) {
				create((IFolder) deploymentFolder.getParent(), monitor);
			} else if (deploymentFolder.getParent().getType() == IResource.PROJECT) {
				throw new CoreException(Status.CANCEL_STATUS);
				// TODO Replace with real status
			}

		}
		deploymentFolder.create(true, true, monitor);
	}

	protected IStatus doExecute(IProgressMonitor monitor) {
		IDataModel dataModel = getDataModel();
		final String deploymentDesciption = dataModel
				.getStringProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_DESCRIPTION);
		final IFolder deploymentFolder = (IFolder) dataModel
				.getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_FOLDER);

		createDeploymentProject();

		if (!deploymentFolder.exists()) {
			try {
				create(deploymentFolder, monitor);
			} catch (CoreException e) {
				e.printStackTrace();
				// TODO Replace with proper logging and return error status
				return Status.CANCEL_STATUS;
			}
		}
		DeploymentTopologyDomain dplanDomain = getDeploymentPlanDomain();
		IEditModelScribbler scribbler = getEditModelScribbler();

		String topologyName = dataModel
				.getStringProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_NAME);
		// create a new topology and set its name/description
		Topology topology = CoreFactory.eINSTANCE.createTopology();
		topology.setDisplayName(deploymentFolder.getName());
		topology.setName(topologyName);
		topology.setDescription(deploymentDesciption);

		// create a root for this topology to live in
		DeployCoreRoot rootObject = CoreFactory.eINSTANCE.createDeployCoreRoot();
		rootObject.setTopology(topology);

		// open a file resource for this emf data
		try {
			scribbler.deleteResource(dplanDomain.getTopologyFile(), new NullProgressMonitor());
		} catch (EditModelException e) {
		}
		Resource resource = scribbler.getResource(dplanDomain.getTopologyFile());
		resource.getContents().add(rootObject);

		// save the topology for creating the diagram view
		dataModel.setProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_RESULT, topology);

		return OK_STATUS;
	}

	protected boolean createDeploymentProject() {
		IProject project = getProject();
		if (project == null) {
			return false;
		}
		try {
			project.getDescription();
		} catch (CoreException e) {
			return false;
		}
		return false;
	}

	protected DeploymentTopologyDomain getDeploymentPlanDomain() {
		IScribblerDomain[] domains = (IScribblerDomain[]) getDataModel().getProperty(
				IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS);
		if (domains != null && domains.length > 0) {
			return (DeploymentTopologyDomain) domains[0];
		}
		return null;
	}

	protected IStatus doRedo(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	protected IStatus doUndo(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}
}
