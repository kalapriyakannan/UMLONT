package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class RealizationConstraintFactory extends CustomConstraintFactory {

	public RealizationConstraintFactory() {
	}

	@Override
	public Constraint createConstraint(DeployModelObject parentDMO) {
		RealizationConstraint constraint = ConstraintFactory.eINSTANCE.createRealizationConstraint();
		constraint
				.setDisplayName(DeployCoreMessages.RealizationConstraintFactory_Realization_Constrain_);
		TypeConstraint typeConstraint = ConstraintFactory.eINSTANCE.createTypeConstraint();
		typeConstraint.setName(UnitUtil.generateUniqueName(constraint, "c")); //$NON-NLS-1$
		typeConstraint.setDmoEType(CorePackage.Literals.UNIT);
		constraint.getConstraints().add(typeConstraint);
		return constraint;
	}

}
