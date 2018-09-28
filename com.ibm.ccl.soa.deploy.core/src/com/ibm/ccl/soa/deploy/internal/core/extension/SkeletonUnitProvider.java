/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;

/**
 * Provides a default implementation of {@link UnitProvider} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.unitLifecycle</b>.
 * 
 * @since 1.0
 * @see UnitProvider
 * 
 */
public class SkeletonUnitProvider extends UnitProvider {

	/**
	 * The singleton instance.
	 */
	public static final SkeletonUnitProvider INSTANCE = new SkeletonUnitProvider();

	private SkeletonUnitProvider() {
	}

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		return NO_STUBS;
	}

	public Object[] resolveUnit(TopologyUnitStub aStub, boolean toResolveLazily,
			IProgressMonitor aMonitor) {
		return NO_MODEL_OBJS;
	}

	public boolean resolveLinks(List aDeployModelObjects, IProgressMonitor aMonitor) {
		// TODO Auto-generated method stub
		return false;
	}

}
