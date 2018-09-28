/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.database.internal.provider;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.SQLModule;

/**
 * @since 1.0
 * 
 */
public class SQLUnitProvider extends UnitProvider {

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = NO_STUBS;

		if (DatabaseProviderUtil.isDDLFile(anInputObject)) {
			IResource resource = (IResource) anInputObject;
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			annotation.getDetails().put(IAnnotationConstants.MODULE_TYPE, IConstants.MODULE_TYPE_DDL);
			stubs[0] = new TopologyUnitStub(resource.getName(), null, annotation, resource);
		}
		return stubs;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {

		SQLModule module = DatabaseFactory.eINSTANCE.createSQLModule();
		module.getAnnotations().add(aStub.getAnnotation());
		module.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		module.setGoalInstallState(InstallState.INSTALLED_LITERAL);
		module.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
		DDLArtifact fileArtifact = DatabaseFactory.eINSTANCE.createDDLArtifact();
		List fileArtifacts = module.getArtifacts();
		List fileURIs = fileArtifact.getFileURIs();
		if (aStub.getInput() == null) {
			return null;
		}
		IResource resource = (IResource) aStub.getInput();
		module.setDisplayName(resource.getName());
		module.setName(UnitUtil.fixNameForID(resource.getName()));
		fileArtifact.setName(resource.getName());
		fileURIs.add(resource.getLocation().toOSString());
		fileArtifacts.add(fileArtifact);

		// Add SQLUser capability - userId/userPassword attributes left null
		DatabaseProviderUtil.createSqlUserCapability(module);

		// Add requirement for database capability to module
		DatabaseProviderUtil.createDatabaseHostingRequirement(module);

		return new DeployModelObject[] { module };
	}

	/*
	 * private String convertToValidUnitName(String name) { int x = 0; x = name.indexOf('.'); if (x >
	 * 0) { name = name.substring(0, x); } return name; }
	 */

	/**
	 * @Override
	 */
	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}
}
