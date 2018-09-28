/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;

/**
 * Provides a default implementation of {@link UnitAmplifier} that can be returned when clients
 * provide unruly or errant extensions for <b>com.ibm.ccl.soa.core.deploy.unitLifecycle</b>.
 * 
 * @since 1.0
 * @see UnitAmplifier
 * 
 */

public class SkeletonUnitAmplifier extends UnitAmplifier {

	public static final TopologyUnitStub[] NO_STUBS = new TopologyUnitStub[0];

	/**
	 * An empty array of {@link DeployModelObject} to return instead of <b>null</b>.
	 */
	public static final DeployModelObject[] NO_MODEL_OBJS = new DeployModelObject[0];
	/**
	 * The singleton instance.
	 */
	public static final SkeletonUnitAmplifier INSTANCE = new SkeletonUnitAmplifier();

	private SkeletonUnitAmplifier() {
	}

	public TopologyUnitStub[] resolveStubs(Object anInputObject) {
		return NO_STUBS;
	}

	@Override
	public String[] getValues(Unit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStatus modify(Unit unit, Object input) {
		// TODO Auto-generated method stub
		return Status.OK_STATUS;
	}

	@Override
	public String getExistingProductConstraintValue(Unit unit) {
		// TODO Auto-generated method stub
		return "test"; //$NON-NLS-1$
	}

}
