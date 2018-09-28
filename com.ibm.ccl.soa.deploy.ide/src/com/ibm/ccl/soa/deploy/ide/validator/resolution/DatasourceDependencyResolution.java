/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.validator.resolution;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.DeployParameterizedResolution;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.IdeMessages;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

public class DatasourceDependencyResolution extends DeployParameterizedResolution {

	private IDataModel dataModel;

	private final Unit inputUnit;

	/**
	 * 
	 * @param context
	 * @param generator
	 * @param dataSourceType
	 * @param unit
	 */
	public DatasourceDependencyResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit unit) {
		super(context, generator);
		setDescription(IdeMessages.Resolve_datasource_resolution_description);
		inputUnit = unit;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		try {
			// Set up data model
			createDataModel();
			addParameter(dataModel);
			return super.resolve(monitor);
		} catch (Throwable e) {
			return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0,
					IdeMessages.Resolve_datasource_resolution_exception, e);
		}
	}

	private void createDataModel() {
		dataModel = DataModelFactory.createDataModel("DatasourceResolution"); //$NON-NLS-1$;
		if (dataModel == null) {
			// TODO return some error status
		}

		// TODO is this code correct to load up the scribbler with an existing
		// topology?
		Topology top = inputUnit.getTopology();
		IFile file = WorkbenchResourceHelper.getFile(top);
		String projectName = file.getProject().getName();

		DeploymentTopologyDomain domain = new DeploymentTopologyDomain(file);
		dataModel.setStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME, projectName);
		dataModel.setStringProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL, domain
				.getEditModelLabel());
		dataModel.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
				new IScribblerDomain[] { domain });

		dataModel.setProperty(IDatasourceResolutionProperties.SOURCE_UNIT, inputUnit);

		Unit[] hosts = top.findHosts(inputUnit);
		if (hosts.length != 0) {
			dataModel.setProperty(IDatasourceResolutionProperties.HOST_UNIT, hosts[0]);
		}

	}

	/*
	 * private List getDataSourceRequirements() { List dsReqs = new ArrayList(); Iterator iter =
	 * inputUnit.getRequirements().iterator(); while (iter.hasNext()) { Requirement req =
	 * (Requirement)iter.next(); if ( IDEResolutionUtils.isUnsatisfiedDataSourceRequirement(req))
	 * dsReqs.add( req ); }
	 * 
	 * return dsReqs; }
	 */

	/**
	 * Returns true if there is already a DatasourceDependencyResolution on the unit that contains
	 * the requirement of this status
	 * 
	 * @param resolution
	 * @return
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof DatasourceDependencyResolution)) {
			return false;
		}

		DatasourceDependencyResolution resolution = (DatasourceDependencyResolution) obj;
		DeployModelObject thisdmo = context.getDeployStatus().getDeployObject();
		if (thisdmo instanceof Requirement) {
			Requirement thisreq = (Requirement) thisdmo;
			Unit thisunit = (Unit) thisreq.getParent();
			DeployModelObject dmo = resolution.getDeployResolutionContext().getDeployStatus()
					.getDeployObject();
			if (dmo instanceof Requirement) {
				Unit unit = (Unit) dmo.getParent();
				if (unit.equals(thisunit)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Override hash code
	 */
	public int hashCode() {
		if (context.getDeployStatus().getDeployObject().getParent() != null) {
			return context.getDeployStatus().getDeployObject().getParent().hashCode();
		}

		return super.hashCode();
	}

	@Override
	public IStatus resolveWithParameters(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		//Wizard will fire operation
		return Status.OK_STATUS;
	}

}
