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

import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerDataModelProvider;

/**
 * @author jeswanke
 * 
 * properties to combines the topology and visualization operations
 */
public class CreateComposedDeploymentTopologyProvider extends AbstractScribblerDataModelProvider
		implements IDataModelProvider, ICreateComposedDeploymentProperties {

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(CREATE_DEPLOYMENT_DATAMODEL_PROVIDER);
		propertyNames.add(CREATE_DEPLOYMENT_VIZUALIZATION_PROVIDER);
		return propertyNames;
	}

	public void init() {
		super.init();
		// add two nested models
		IDataModel deploymentPlanDataModel = DataModelFactory
				.createDataModel(ICreateComposedDeploymentProperties.CREATE_DEPLOYMENT_DATAMODEL_PROVIDER);
		IDataModel deploymentPlanVizDataModel = DataModelFactory
				.createDataModel(ICreateComposedDeploymentProperties.CREATE_DEPLOYMENT_VIZUALIZATION_PROVIDER);
		model.addNestedModel(
				ICreateComposedDeploymentProperties.CREATE_DEPLOYMENT_DATAMODEL_PROVIDER,
				deploymentPlanDataModel);
		model.addNestedModel(
				ICreateComposedDeploymentProperties.CREATE_DEPLOYMENT_VIZUALIZATION_PROVIDER,
				deploymentPlanVizDataModel);
	}

	/*
	 * consolidate three models into one with two nested models
	 */
	public IDataModelOperation getDefaultOperation() {
		return new CreateComposedDeploymentTopologyOperation(getDataModel());
	}

	public Object getDefaultProperty(String propertyName) {
		//scribbler related		
		if (propertyName.equals(EDIT_MODEL_LABEL)) {
			DeploymentTopologyDomain domain = new DeploymentTopologyDomain(
					(IFolder) getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_FOLDER),
					getStringProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_NAME));
			return domain.getEditModelLabel();
		}
		if (propertyName.equals(SCRIBBLER_DOMAINS)) {
			return new IScribblerDomain[] { new DeploymentTopologyDomain(
					(IFolder) getProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_FOLDER),
					getStringProperty(ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_NAME)) };
		}
		//TODO should I be using ComonentScribblerDomain
		return super.getDefaultProperty(propertyName);
	}
}
