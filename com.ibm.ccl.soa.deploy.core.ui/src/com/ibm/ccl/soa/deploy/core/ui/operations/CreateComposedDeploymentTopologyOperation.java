/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerOperation;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * @author jeswanke
 * 
 * operation combines the topology and visualization operations to create the topology model, then
 * create the GMF notational model
 */
public class CreateComposedDeploymentTopologyOperation extends AbstractScribblerOperation implements
		ICreateComposedDeploymentProperties {

	/**
	 * 
	 */
	public CreateComposedDeploymentTopologyOperation() {
		super();
	}

	/**
	 * @param dataModel
	 */
	public CreateComposedDeploymentTopologyOperation(IDataModel dataModel) {
		super(dataModel);
	}

	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {
		IStatus status = runCreateDeploymentPlanOperation(monitor);
		if (status.isOK()) {
			status = runCreateDeploymentVizualizationOperation(monitor);
		}
		if (!status.isOK()) {
			Throwable ex = status.getException();
			if (ex != null) {
				ex.printStackTrace();
			}
			System.out.println(status.getMessage());
		}
		return status;
	}

	private IStatus runCreateDeploymentPlanOperation(final IProgressMonitor monitor) {
		IDataModel dm = model.getNestedModel(CREATE_DEPLOYMENT_DATAMODEL_PROVIDER);
		dm.setStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME, getDataModel()
				.getStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME));
		dm.setStringProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL, getDataModel()
				.getStringProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL));
		dm.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS, getDataModel()
				.getProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS));
		// MDE This has to be due to a defect in IDataModel.isPropertySet();
		// setup scribbler for outer datamodel.
		getDataModel().setStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME,
				getDataModel().getStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME));
		getDataModel().setStringProperty(
				IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL,
				getDataModel()
						.getStringProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL));
		getDataModel().setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
				getDataModel().getProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS));
		IDataModelOperation op = dm.getDefaultOperation();
		return getEditModelScribbler().execute(op, monitor, getEditModelScribbler());
	}

	private IStatus runCreateDeploymentVizualizationOperation(final IProgressMonitor monitor) {
		// get values from previous operation's datamodel
		IDataModel dataModelSrc = model.getNestedModel(CREATE_DEPLOYMENT_DATAMODEL_PROVIDER);
		Object deploymentPlan = dataModelSrc
				.getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_RESULT);
		String planName = (String) dataModelSrc
				.getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_NAME);
		IFolder planFolder = (IFolder) dataModelSrc
				.getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_FOLDER);
		// and stuff those values in this operation's datamodel
		IDataModel dataModel = model.getNestedModel(CREATE_DEPLOYMENT_VIZUALIZATION_PROVIDER);

		dataModel.setStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME,
				getDataModel().getStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME));
		dataModel.setStringProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL,
				getDataModel()
						.getStringProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL));
		dataModel.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS, getDataModel()
				.getProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS));

		dataModel.setProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_PLAN_MODEL,
				deploymentPlan);
		dataModel
				.setProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_PLAN_NAME, planName);
		dataModel.setProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_FOLDER, planFolder);
		dataModel.setProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_TOPOLOGY_FILENAME,
				planName + "." + IConstants.TOPOLOGY_EXTENSION); //$NON-NLS-1$

		// then do the operation
		IDataModelOperation op = dataModel.getDefaultOperation();
		return getEditModelScribbler().execute(op, monitor, getEditModelScribbler());
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
