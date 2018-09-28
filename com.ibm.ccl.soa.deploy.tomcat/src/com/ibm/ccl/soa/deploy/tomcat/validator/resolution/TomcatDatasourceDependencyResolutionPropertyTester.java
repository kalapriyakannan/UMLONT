/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.validator.resolution;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.ide.validator.resolution.DatasourceDependencyResolutionPropertyTester;
import com.ibm.ccl.soa.deploy.ide.validator.resolution.IDEResolutionUtils;

public class TomcatDatasourceDependencyResolutionPropertyTester extends
		DatasourceDependencyResolutionPropertyTester {

	private final String TOMCAT_ID = "org.eclipse.jst.server.tomcat"; //$NON-NLS-1$

	protected String[] getServerTypes() {
		return new String[] { TOMCAT_ID };
	}

	protected boolean hasRuntimeSupport(Requirement req) {
		Unit unit = (Unit) req.getParent();
		if (IDEResolutionUtils.isHostedOnServerTarget(unit, getServerTypes()))
			return true;
		return false;
	}

}
