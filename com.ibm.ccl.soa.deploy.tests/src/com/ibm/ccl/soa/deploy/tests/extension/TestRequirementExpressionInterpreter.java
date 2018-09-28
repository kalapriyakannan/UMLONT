/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.extension;

import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.validator.expression.IRequirementExpressionInterpreter;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

public class TestRequirementExpressionInterpreter implements
		IRequirementExpressionInterpreter {

	public IDeployStatus validate(RequirementExpression expression,
			ReqEvaluationContext ctx) {
		// TODO Auto-generated method stub
		System.out
				.println("----TEST---IDeployStatus validate(RequirementExpression expression, Capability capability)---");
		return new DeployStatus();
	}

	public String computeTitle(RequirementExpression re) {
		return "-TEST-";
	}

}
