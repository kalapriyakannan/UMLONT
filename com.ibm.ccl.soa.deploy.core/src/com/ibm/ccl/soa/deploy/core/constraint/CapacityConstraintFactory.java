package com.ibm.ccl.soa.deploy.core.constraint;

import javax.xml.namespace.QName;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

public class CapacityConstraintFactory extends CustomConstraintFactory {

	private static final String DEFAULT_NAMESPACE = "http://www.ibm.com/ccl/soa/deploy/server/1.0.0/"; //$NON-NLS-1$
	private static final String DEFAULT_CLASS = "Server"; //$NON-NLS-1$
	private static final String DEFAULT_ATTRIBUTE = "memorySize"; //$NON-NLS-1$
	private static final String DEFAULT_VALUE = "256"; //$NON-NLS-1$

	public CapacityConstraintFactory() {
	}

	@Override
	public Constraint createConstraint(DeployModelObject parentDMO) {

		CapacityConstraint constraint = ConstraintFactory.eINSTANCE.createCapacityConstraint();

		constraint.setDisplayName("Capacity Constraint"); //$NON-NLS-1$
		constraint.setDmoType(new QName(DEFAULT_NAMESPACE, DEFAULT_CLASS));
		AttributeCapacityConstraint restriction = ConstraintFactory.eINSTANCE
				.createAttributeCapacityConstraint();
		restriction.setAttributeName(DEFAULT_ATTRIBUTE);
		restriction.setName(UnitUtil.generateUniqueName(restriction, "c")); //$NON-NLS-1$
		restriction.setExclusive(false);
		restriction.setValue(DEFAULT_VALUE);
		constraint.getConstraints().add(restriction);
		return constraint;
	}
}
