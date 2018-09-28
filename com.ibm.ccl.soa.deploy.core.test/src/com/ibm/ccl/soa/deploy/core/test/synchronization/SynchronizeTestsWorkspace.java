/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.synchronization;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.test.TestWorkspace;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestPlugin;

public class SynchronizeTestsWorkspace extends TestWorkspace {

	public static final String MINIBANK_EAR = "MinibankEAR";
	public static final String MINIBANK_EJB = "MinibankEJB";
	public static final String MINIBANK_WEB = "MinibankWEB";

	public static final IPath TESTDATA = new Path(
			"testdata/synchronizeWorkspace.zip");

	public static final String[] PROJECT_NAMES = new String[] { MINIBANK_EAR,
			MINIBANK_EJB, MINIBANK_WEB };

	public SynchronizeTestsWorkspace() {
		super(TopologyTestPlugin.getDefault().getBundle(), TESTDATA,
				PROJECT_NAMES);
	}

	public IProject getMinibankEAR() {
		return ROOT.getProject(MINIBANK_EAR);
	}

	public IProject getMinibankEJB() {
		return ROOT.getProject(MINIBANK_EJB);
	}

	public IProject getMinibankWEB() {
		return ROOT.getProject(MINIBANK_WEB);
	}
}
