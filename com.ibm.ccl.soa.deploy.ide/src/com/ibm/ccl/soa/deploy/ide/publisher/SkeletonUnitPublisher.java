/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.ide.extension.IUnitPublisherService;

/**
 * Provides a default implementation of {@link UnitProvider} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.unitLifecycle</b>.
 * 
 * @since 1.0
 * @see UnitProvider
 * 
 */
public class SkeletonUnitPublisher extends UnitPublisher {

	public static final SkeletonUnitPublisher INSTANCE = new SkeletonUnitPublisher();

	private SkeletonUnitPublisher() {
	}

	public boolean canPublish(Unit hostUnit) {
		// TODO Auto-generated method stub
		return false;
	}

	public IStatus publish(Topology topology, IUnitPublisherService unitService) {
		// TODO Auto-generated method stub
		return Status.OK_STATUS;
	}

	public String getRuntimeInstanceId(Unit hostUnit) {
		return null;
	}

	public String getRuntimeTypeId(Unit hostUnit) {
		return null;
	}

	public String getEnvironment() {
		return null;
	}

}
