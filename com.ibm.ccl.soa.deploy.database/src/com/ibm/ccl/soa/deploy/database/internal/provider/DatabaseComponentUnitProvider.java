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
import com.ibm.ccl.soa.deploy.core.IResourceTypeConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.database.DatabaseComponent;
import com.ibm.ccl.soa.deploy.database.DatabaseDefinition;

public class DatabaseComponentUnitProvider extends UnitProvider implements IAnnotationConstants {

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		TopologyUnitStub[] stubs = null;
		IResource resource = (IResource) anInputObject;
		String runtimeId = resource.getFullPath().toPortableString();
		stubs = new TopologyUnitStub[1];
		Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
		annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
		annotation.getDetails().put(IAnnotationConstants.MODULE_TYPE, IConstants.MODULE_TYPE_DDL);
		annotation.getDetails().put(IAnnotationConstants.RUNTIME_ID, runtimeId);
		stubs[0] = new TopologyUnitStub(getSimpleDDLName(resource.getName()), null, annotation,
				resource);
		return stubs;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {
		Object targetUnit = aStub.getDropTarget();
		DatabaseComponent component = null;
		Object anInputObject = aStub.getInput();

		if (targetUnit != null && targetUnit instanceof DatabaseComponent) {
			component = (DatabaseComponent) targetUnit;
			IResource ddlResource = (IResource) anInputObject;
			DatabaseDefinition databaseDefinition = DatabaseProviderUtil.createDatabaseDefinition(
					component, ddlResource);
			DatabaseProviderUtil.createOrUpdateDDLArtifact(component, databaseDefinition);
		} else {
			Annotation annotation = aStub.getAnnotation();

			IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
			Unit createdUnit = (Unit) rts
					.createFromTemplate(IResourceTypeConstants.DATABASE_COMPONENT_RESOURCE_ID);
			createdUnit.getAnnotations().add(annotation);
			createdUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
			createdUnit.setGoalInstallState(InstallState.INSTALLED_LITERAL);
			createdUnit.setPublishIntent(PublishIntent.PUBLISH_LITERAL);
			createdUnit.setName(UnitUtil.fixNameForID(aStub.getName()));
			createdUnit.setDisplayName(aStub.getName());
			DatabaseProviderUtil.makeUnitNameUnique(createdUnit, aStub.getTopology());
			component = (DatabaseComponent) createdUnit;
			component.setConceptual(false);
			IResource ddlResource = (IResource) anInputObject;
			DatabaseDefinition databaseDefinition = DatabaseProviderUtil.createDatabaseDefinition(
					component, ddlResource);
			DatabaseProviderUtil.createOrUpdateDDLArtifact(component, databaseDefinition);
			return new DeployModelObject[] { createdUnit };
		}
		return new DeployModelObject[0];
	}

	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}

	private String getSimpleDDLName(String name) {
		int index = name.indexOf('.');
		return index != 0 ? name.substring(0, index) : name;
	}

}
