/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerDataModelProvider;

/**
 * @author jeswanke
 * 
 * properties to create the topology model
 * 
 */
public class CreateDeploymentTopologyProvider extends AbstractScribblerDataModelProvider implements
		IDataModelProvider, ICreateDeploymentTopologyProperties {

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(DEPLOYMENT_FOLDER);
		propertyNames.add(DEPLOYMENT_PLAN_NAME);
		propertyNames.add(DEPLOYMENT_PROJECT_NAME);
		propertyNames.add(DEPLOYMENT_DESCRIPTION);
		propertyNames.add(DEPLOYMENT_PLAN_RESULT);
		propertyNames.add(DEPLOYABLE_SELECTIONS);
		return propertyNames;
	}

	public IDataModelOperation getDefaultOperation() {
		return new CreateDeploymentTopologyOperation(getDataModel());
	}

	public IStatus validate(String name) {
		// check project name
		if (name.equals(DEPLOYMENT_PROJECT_NAME)) {
			String projectName = model.getStringProperty(DEPLOYMENT_PROJECT_NAME);
			if (!ResourceUtils.isValidName(projectName)) {
				return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
						Messages.DEPLOYMENTPROJECT_BADNAME, null);
			}
			if (!ResourceUtils.isProjectExist(projectName)) {
				return new Status(IStatus.WARNING, DeployCoreUIPlugin.PLUGIN_ID, 0,
						Messages.DEPLOYMENTPROJECT_NOEXIST, null);
			}
			IProject project = ProjectUtilities.getProject(projectName);
			if (!project.isOpen()) {
				return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
						Messages.DEPLOYMENTPROJECT_CLOSED, null);
			}

		}
		// check plan name
		else if (name.equals(DEPLOYMENT_PLAN_NAME)) {
			String deployPlanName = model.getStringProperty(DEPLOYMENT_PLAN_NAME);
			if (!ResourceUtils.isValidName(deployPlanName)) {
				return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
						Messages.DEPLOYMENTMODEL_BADNAME, null);
			}
			String projectName = model.getStringProperty(DEPLOYMENT_PROJECT_NAME);
			if (projectName != null && projectName.length() > 0) {
				IProject project = ProjectUtilities.getProject(projectName);
				if (project != null && project.findMember(deployPlanName) != null) {
					return new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, 0,
							Messages.DEPLOYMENTMODEL_DUPNAME, null);
				}
			}

		}
		return super.validate(name);
	}

	public Object getDefaultProperty(String propertyName) {
		if (propertyName.equals(DEPLOYMENT_DESCRIPTION)) {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");//$NON-NLS-1$
			return Messages.DEPLOYMENTMODEL_CREATED_DESCRIPTION
					+ " " + formatter.format(now.getTime());//$NON-NLS-1$
		}
		return super.getDefaultProperty(propertyName);
	}
}
