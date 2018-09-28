/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.operation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerOperation;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

public abstract class AbstractDeploymentResourceOperation extends AbstractScribblerOperation {

	public AbstractDeploymentResourceOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractDeploymentResourceOperation(IDataModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	protected Topology getTopology() {
		DeploymentTopologyDomain dplanDomain = getDeploymentPlanDomain();
		IEditModelScribbler scribbler = getEditModelScribbler();
		Topology topology = null;
		Resource resource;
		resource = scribbler.getResource(dplanDomain.getTopologyResource());
		if (resource != null && !resource.getContents().isEmpty()) {
			DeployCoreRoot root = (DeployCoreRoot) resource.getContents().get(0);
			topology = root.getTopology();
		}

		return topology;
	}

	protected DeploymentTopologyDomain getDeploymentPlanDomain() {
		IScribblerDomain[] domains = (IScribblerDomain[]) getDataModel().getProperty(
				IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS);
		if (domains != null && domains.length > 0) {
			return (DeploymentTopologyDomain) domains[0];
		}
		return null;
	}

}
