/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.operation;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.operations.ICreateDeploymentTopologyProperties;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.ITopologyCreationSchemeConstants;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationScheme;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationSchemeService;
import com.ibm.ccl.soa.deploy.ide.operation.AbstractDeploymentResourceOperation;

public class RCTGroupOperation extends AbstractDeploymentResourceOperation implements
		RCTCreateTopologyExtensionProperties {

	public RCTGroupOperation() {
		super();
	}

	public RCTGroupOperation(IDataModel dataModel) {
		super(dataModel);
	}

	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {
		executeGroup(monitor);
		return Status.OK_STATUS;
	}

	private void executeGroup(final IProgressMonitor monitor) {
		// get values from previous operation's datamodel
		IDataModel dataModelDeployable = model
				.getNestedModel(RCTCreateTopologyExtensionProperties.CREATE_RCT_CREATE_TOPOLOGY_EXTENSION_PROVIDER);
		List addedUnits = (List) dataModelDeployable.getProperty(CREATED_UNITS);
		if (addedUnits != null) {
			Topology topology = getTopology();
			TopologyCreationScheme topologyCreationScheme = TopologyCreationSchemeService.INSTANCE
					.findScheme((String) dataModelDeployable.getProperty(TOPOLOGY_CREATION_SCHEME));
			if (topologyCreationScheme != null
					&& !topologyCreationScheme.getName().equals(
							ITopologyCreationSchemeConstants.NO_TOPOLOGY_CREATION_SCHEME)) {
				//host and deployable units
				if (topologyCreationScheme.applyScheme(addedUnits)) {
					// Set topology back in the data model
					getDataModel().setProperty(
							ICreateDeploymentTopologyProperties.DEPLOYMENT_PLAN_RESULT, topology);
				}
				//TODO ?? on no scheme what happens
			}
		}
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
