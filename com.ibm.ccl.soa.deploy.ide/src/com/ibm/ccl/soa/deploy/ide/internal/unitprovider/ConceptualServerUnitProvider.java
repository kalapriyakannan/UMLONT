/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.unitprovider;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.wst.server.core.IRuntime;

import com.ibm.ccl.soa.deploy.analysis.IAnalysisTemplateConstants;
import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

public class ConceptualServerUnitProvider extends IDEUnitProvider implements IAnnotationConstants {

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {

		TopologyUnitStub[] stubs = null;
		if (anInputObject instanceof IRuntime) {
			IRuntime runtime = (IRuntime) anInputObject;
			stubs = new TopologyUnitStub[1];
			Annotation annotation = CoreFactory.eINSTANCE.createAnnotation();
			annotation.setContext(IAnnotationConstants.ENVIRONMENT_WTP);
			annotation.getDetails().put(IAnnotationConstants.RUNTIME_TYPE,
					runtime.getRuntimeType().getId());
			annotation.getDetails().put(IAnnotationConstants.RUNTIME_ID, runtime.getId());
			stubs[0] = new TopologyUnitStub(runtime.getName(), null, annotation, runtime);
		} else if (anInputObject instanceof Annotation) {
			stubs = new TopologyUnitStub[1];
			Annotation annotation = (Annotation) anInputObject;
			String runtimeId = (String) annotation.getDetails().get(IAnnotationConstants.RUNTIME_ID);
			stubs[0] = new TopologyUnitStub(runtimeId, null, annotation, null);
		}
		return stubs;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {

		Annotation annotation = aStub.getAnnotation();
		IRuntime runtime = (IRuntime) aStub.getInput();
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		Unit createdUnit = (Unit) rts.createFromTemplate(IAnalysisTemplateConstants.NODE_UNIT);
		createdUnit.getAnnotations().add(annotation);
		createdUnit.setName(UnitUtil.fixNameForID(runtime.getId()));
		createdUnit.setDisplayName(aStub.getName());
		return new DeployModelObject[] { createdUnit };
	}

	/**
	 * 
	 */
	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}
}
