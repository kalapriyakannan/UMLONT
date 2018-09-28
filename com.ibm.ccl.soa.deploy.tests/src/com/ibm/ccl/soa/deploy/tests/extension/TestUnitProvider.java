/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;

/**
 * Provides a default test implementation of UnitProvider
 * 
 * @since 1.0
 * 
 */
public class TestUnitProvider extends UnitProvider {

	private static final String TEST_ARTIFACT_NAME = "_test.properties";

	private static final String TYPE_PROPERTIES = "type.properties";

	private static final String NAME = "name";

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		if (anInputObject instanceof IFile) {
			IFile properties = (IFile) anInputObject;
			if (TEST_ARTIFACT_NAME.equals(properties.getName())) {

				Properties props = new Properties();
				try {
					props.load(properties.getContents());
				} catch (IOException e) {

					e.printStackTrace();
				} catch (CoreException e) {

					e.printStackTrace();
				}
				String artifactName = props.getProperty(NAME);
				if (artifactName == null)
					artifactName = "Unknown";
				return new TopologyUnitStub[] { new TopologyUnitStub(
						artifactName, TYPE_PROPERTIES, null, anInputObject) };
			}
		}
		return NO_STUBS;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub,
			boolean toResolveLazily, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean resolveLinks(List aDeployModelObjects,
			IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}

}
