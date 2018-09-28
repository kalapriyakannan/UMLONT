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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerOperation;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * An operation to create the *.topologyv file that is used to visualize the deployment topology.
 * <p>
 * This class has not been published as API so long as this comment is present.
 * </p>
 */
public class CreateDeploymentVisualizationOperation extends AbstractScribblerOperation implements
		IDataModelOperation {

	/**
	 * 
	 */
	public CreateDeploymentVisualizationOperation() {
		super();
	}

	/**
	 * @param dataModel
	 */
	public CreateDeploymentVisualizationOperation(IDataModel dataModel) {
		super(dataModel);
	}

	protected IStatus doExecute(IProgressMonitor monitor) {
		final IDataModel dataModel = getDataModel();
		final String fileName = dataModel
				.getStringProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_TOPOLOGY_FILENAME);
		final Topology topology = (Topology) dataModel
				.getProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_PLAN_MODEL);
		DeploymentTopologyDomain dplanDomain = getDeploymentTopologyDomain();
		IEditModelScribbler scribbler = getEditModelScribbler();

		try {
			scribbler.deleteResource(dplanDomain.getDefaultDiagramFile(), new NullProgressMonitor());
		} catch (EditModelException e) {
		}
		Resource resource = scribbler.getResource(dplanDomain.getDefaultDiagramFile());
		if (resource != null) {
			Diagram view = ViewService.getInstance().createDiagram(new EObjectAdapter(topology),
					DeployCoreConstants.DEPLOY_CORE, new PreferencesHint(DeployCoreUIPlugin.PLUGIN_ID));
			if (view != null) {
				resource.getContents().clear();
				resource.getContents().add(view);
				view.getDiagram().setName(fileName);
				view.setElement(topology);
			}
		}
		return Status.OK_STATUS;
	}

	private DeploymentTopologyDomain getDeploymentTopologyDomain() {
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
