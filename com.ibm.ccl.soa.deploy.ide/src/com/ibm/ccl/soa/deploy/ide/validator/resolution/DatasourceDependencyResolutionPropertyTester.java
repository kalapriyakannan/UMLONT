/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.validator.resolution;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

public abstract class DatasourceDependencyResolutionPropertyTester extends PropertyTester {

	private final String property = "isUnsatisfiedDatasource"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.property.equals(property)) {
			if (receiver instanceof IDeployStatus) {
				// 
				IDeployStatus status = (IDeployStatus) receiver;
				if (status.getProblemType() != ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED) {
					return false;
				}

				DeployModelObject dmo = status.getDeployObject();
				if (dmo instanceof Requirement) {
					Requirement req = (Requirement) dmo;

					if (!IDEResolutionUtils.isUnsatisfiedDataSourceRequirement(req)) {
						return false;
					}
					return hasRuntimeSupport(req);
				}
			}
		}
		return false;
	}

	protected abstract boolean hasRuntimeSupport(Requirement req);

	protected abstract String[] getServerTypes();
}
