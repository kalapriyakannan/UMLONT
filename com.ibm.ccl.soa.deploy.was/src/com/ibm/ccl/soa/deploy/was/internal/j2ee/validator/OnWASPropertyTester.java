package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import org.eclipse.core.expressions.PropertyTester;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * Property tester for testing if a hosted {@link DeployModelObject} is hosted on Websphere...
 * either a {@link WebsphereAppServerUnit} or a {@link WasClusterUnit}.
 */
public class OnWASPropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (!(receiver instanceof DeployModelObject)) {
			return false;
		}

		if (receiver instanceof Requirement) {
			receiver = ((DeployModelObject) receiver).getParent();
		}
		if (null == receiver) {
			return false;
		}

		// assumes that any desired type is checked by another enablement expression		
		return WasJ2eeValidatorUtils.isJ2eeHostedOnWas((DeployModelObject) receiver);
	}
}
