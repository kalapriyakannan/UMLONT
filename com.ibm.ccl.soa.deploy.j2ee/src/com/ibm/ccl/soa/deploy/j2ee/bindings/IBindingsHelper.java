/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.bindings;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;

public interface IBindingsHelper {

	public String getJNDIName(EnterpriseBeanService ejbService);

	public String getJNDINameForDefaultDataSource(EntityService entityService);

	public String getJNDINameForRequirement(Requirement requirement);

	public List<String> getBindings(J2EESecurityRole securityRole);
}
