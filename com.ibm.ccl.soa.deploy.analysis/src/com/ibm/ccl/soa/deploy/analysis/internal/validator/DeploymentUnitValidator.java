/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal.validator;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Validates a {@link DeploymentUnit}.
 * 
 * @see AnalysisDomainValidator
 */
public class DeploymentUnitValidator extends UnitValidator {

	/**
	 * Construct a new {@link DeploymentUnit} validator.
	 */
	public DeploymentUnitValidator() {
		this(AnalysisPackage.eINSTANCE.getDeploymentUnit());
	}

	/**
	 * Construct a validator for a subtype of {@link DeploymentUnit}.
	 * 
	 * @param unitType
	 *           an {@link DeploymentUnit} subtype.
	 */
	protected DeploymentUnitValidator(EClass unitType) {
		super(unitType);
	}
	/**
	 * Overriden by subtypes to perform general purpose unit validation.
	 * <p>
	 * This method will not be invoked if the unit is in install and do not publish state.
	 * 
	 * @param unit
	 *           the unit whose membership link cardinality is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		assert unit != null;
		assert context != null;
		assert reporter != null;
		
		/*if (!isMemberUnit(unit)) {
			reporter.addStatus( DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
					IAnalysisDomainValidators.DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT, IAnalysisProblemType.MEMBER_LINK_UNDEFINED,
					AnalysisMessages.DEPLOYMENTUNIT_SHOULD_BE_ASSOCIATED_WITH_COMPONENT, new Object[] {
					unit.getName()}, unit));
		}*/
		
	}
	
	private boolean isMemberUnit(Unit unit) {
		boolean result = false;
		for (Iterator it = unit.getTopology().getUnits().iterator(); it.hasNext();) {
			Unit candidateContainer = (Unit) it.next();
			for (Iterator it2 = candidateContainer.getMemberLinks().iterator(); it2.hasNext();) {
				MemberLink ml = (MemberLink) it2.next();
				if (ml.getTarget() == unit) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
