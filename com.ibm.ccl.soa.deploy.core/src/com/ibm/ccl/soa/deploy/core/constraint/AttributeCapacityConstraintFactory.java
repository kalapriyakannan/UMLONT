package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

public class AttributeCapacityConstraintFactory extends CustomConstraintFactory {

	public AttributeCapacityConstraintFactory() {
	}

	@Override
	public Constraint createConstraint(DeployModelObject parentDMO) {

		AttributeCapacityConstraint restriction = ConstraintFactory.eINSTANCE
				.createAttributeCapacityConstraint();
		restriction.setName(UnitUtil.generateUniqueName(restriction, "c")); //$NON-NLS-1$
		restriction.setExclusive(false);
		return restriction;
	}

}
