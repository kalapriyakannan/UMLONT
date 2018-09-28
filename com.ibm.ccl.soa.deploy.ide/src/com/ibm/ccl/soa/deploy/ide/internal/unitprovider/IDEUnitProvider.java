/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.unitprovider;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.IResourceTypeConstants;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

public abstract class IDEUnitProvider extends UnitProvider implements IAnnotationConstants {

	public abstract TopologyUnitStub[] resolveStubs(Object anInputObject);

	protected final static String RESOURCE_BINDING_CONTEXT = "wtp"; //$NON-NLS-1$

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {

		Annotation annotation = aStub.getAnnotation();
		String runtimeTypeId = (String) annotation.getDetails()
				.get(IAnnotationConstants.RUNTIME_TYPE);
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		Unit createdUnit = (Unit) rts.createUnitFromBindingId(runtimeTypeId,
				IResourceTypeConstants.CONTEXT_WTP);
		createdUnit.getAnnotations().add(annotation);
		createdUnit.setInitInstallState(InstallState.INSTALLED_LITERAL);
		createdUnit.setPublishIntent(PublishIntent.DO_NOT_PUBLISH_LITERAL);
		createdUnit.setName(UnitUtil.fixNameForID(aStub.getName()));
		makeNameUnique(createdUnit, aStub.getTopology());
		createdUnit.setDisplayName(aStub.getName());
		setAdditionalAttributes(createdUnit, aStub);

		return new DeployModelObject[] { createdUnit };
	}

	/*
	 * Subclasses should override to set additional attributes.
	 */
	protected void setAdditionalAttributes(Unit createdUnit, TopologyUnitStub stub) {

	}

	private void makeNameUnique(Unit addUnit, Topology topology) {
		String initialName = addUnit.getName();
		if (initialName == null) {
			initialName = "Unit"; //$NON-NLS-1$
		}
		String name = initialName;
		int i = 0;
		while (topology.resolve(name) != null) {
			name = initialName + i;
			i++;
		}
		if (!name.equals(initialName)) {
			addUnit.setName(name);
			if (addUnit.getCaptionProvider().title(addUnit) == null) {
				addUnit.setDisplayName(name);
			}
		}
	}
}
