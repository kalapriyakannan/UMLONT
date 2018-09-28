/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.bindings;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

public class AbstractBindingsHelper implements IBindingsHelper {

	public List<String> getBindings(J2EESecurityRole securityRole) {
		List<String> subjects = new ArrayList<String>();
		subjects.add(securityRole.getRole());
		return subjects;
	}

	public String getJNDIName(EnterpriseBeanService ejbService) {
		return "ejb/" + ejbService.getEjbName(); //$NON-NLS-1$
	}

	public String getJNDINameForDefaultDataSource(EntityService entityService) {
		return "jdbc/" + entityService.getParent().getName(); //$NON-NLS-1$
	}

	public String getJNDINameForRequirement(Requirement requirement) {
		if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(requirement.getDmoEType())) {
			DependencyLink link = requirement.getLink();
			if (link != null) {
				Capability capability = link.getTarget();
				if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(capability.getEObject()
						.eClass())) {
					// we know the target of the dependency link is an EnterpriseBeanService
					EnterpriseBeanService service = (EnterpriseBeanService) capability;
					return getJNDIName(service);
				}
			}
		} else if (J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(requirement.getDmoEType())) {
			DependencyLink link = requirement.getLink();
			if (link != null) {
				Capability capability = link.getTarget();
				if (J2eePackage.Literals.J2EE_DATASOURCE
						.isSuperTypeOf(capability.getEObject().eClass())) {
					// we know the target of the dependency link is a J2EEDatasource
					J2EEDatasource datasource = (J2EEDatasource) capability;
					return datasource.getJndiName();
				}
			}
		}

		return null;
	}

}
