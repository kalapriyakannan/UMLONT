/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import java.util.Set;

import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerDataModelProvider;

/**
 * properties to create the topology diagram
 * 
 */
public class CreateDeploymentVisualizationProvider extends AbstractScribblerDataModelProvider
		implements IDataModelProvider, ICreateDeploymentVisualizationProperties {

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(DEPLOYMENT_TOPOLOGY_FILENAME);
		propertyNames.add(DEPLOYMENT_FOLDER);
		propertyNames.add(DEPLOYMENT_PLAN_MODEL);
		propertyNames.add(DEPLOYMENT_PLAN_NAME);

		return propertyNames;
	}

	public IDataModelOperation getDefaultOperation() {
		return new CreateDeploymentVisualizationOperation(getDataModel());
	}

}
