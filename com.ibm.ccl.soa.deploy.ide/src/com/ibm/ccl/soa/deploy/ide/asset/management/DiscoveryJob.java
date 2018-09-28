/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.asset.management;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

public class DiscoveryJob extends Job {

	Object configurations;

	public DiscoveryJob(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected IStatus run(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getConfigurations() {
		return configurations;
	}

	public void setConfigurations(Object configurations) {
		this.configurations = configurations;
	}

}
