package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.util.ZephyrUmlUtil;

public class UMLArtifactPropertyTester extends PropertyTester {

	private static final String CONTAINS_UML_ARTIFACT_NAME = "containsUMLArtifact"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver != null && receiver instanceof DeployModelObject) {
			if (CONTAINS_UML_ARTIFACT_NAME.equalsIgnoreCase(property)) {
				UMLElementArtifact artifact = ZephyrUmlUtil
						.getUMLElementArtifact((DeployModelObject) receiver);
				if (null != artifact) {
					return true;
				}
			}
		}

		return false;
	}
}
