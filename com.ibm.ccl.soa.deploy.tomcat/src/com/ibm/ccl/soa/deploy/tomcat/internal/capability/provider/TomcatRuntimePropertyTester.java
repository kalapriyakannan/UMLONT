/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.internal.capability.provider;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.wst.common.project.facet.core.runtime.IRuntime;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.IAnnotationConstants;
import com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider.ServerRuntimeUtils;

public class TomcatRuntimePropertyTester extends PropertyTester {

	//TODO eventually move this class to a tomcat.ide plugin

	private String projectProperty = "isTomcatRuntime"; //$NON-NLS-1$
	private String serverProperty = "isTomcatServerRuntime"; //$NON-NLS-1$
	private String annotationProperty = "isTomcatRuntimeAnnotation"; //$NON-NLS-1$
	private final String TOMCAT_ID = "org.eclipse.jst.server.tomcat"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (projectProperty.equals(property)) {
			if (receiver instanceof IRuntime) {
				IRuntime runtime = (IRuntime) receiver;
				if (ServerRuntimeUtils.containsRuntimeMatchingType(runtime, TOMCAT_ID))
					return true;
			}
		} else if (serverProperty.equals(property)) {
			if (receiver instanceof org.eclipse.wst.server.core.IRuntime) {
				org.eclipse.wst.server.core.IRuntime runtime = (org.eclipse.wst.server.core.IRuntime) receiver;
				String runtimeTypeId = runtime.getRuntimeType().getId();
				if (runtimeTypeId.startsWith(TOMCAT_ID))
					return true;
			}
		} else if (annotationProperty.equals(property)) {
			if (receiver instanceof Annotation) {
				Annotation annotation = (Annotation) receiver;
				String runtimeTypeId = (String) annotation.getDetails().get(
						IAnnotationConstants.RUNTIME_TYPE);
				if (runtimeTypeId != null)
					if (runtimeTypeId.startsWith(TOMCAT_ID))
						return true;
			}
		}
		return false;
	}

}
