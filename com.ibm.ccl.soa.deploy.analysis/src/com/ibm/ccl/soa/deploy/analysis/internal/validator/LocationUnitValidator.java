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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.analysis.internal.AnalysisMessages;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

/**
 * Validates a {@link LocationUnit}.
 * 
 * @see AnalysisDomainValidator
 */
public class LocationUnitValidator extends UnitValidator {

	/**
	 * Construct a new {@link LocationUnit} validator.
	 */
	public LocationUnitValidator() {
		this(AnalysisPackage.eINSTANCE.getLocationUnit());
	}

	/**
	 * Construct a validator for a subtype of {@link LocationUnit}.
	 * 
	 * @param unitType
	 *           an {@link LocationUnit} subtype.
	 */
	protected LocationUnitValidator(EClass unitType) {
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
		
		/*remove per defect 5568
		 * if (!hasNodeMemberUnit(unit)) {
			reporter.addStatus( DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
					IAnalysisDomainValidators.LOCATIONUNIT_SHOULD_HAVE_ONE_NODEUNIT, IAnalysisProblemType.ANALYSIS_INVALID_MEMBERUNIT_IN_GROUPUNIT,
					AnalysisMessages.LOCATIONUNIT_SHOULD_HAVE_ONE_NODEUNIT, new Object[] {
					unit.getName()}, unit));
		}*/
		
	}
	
	private boolean hasNodeMemberUnit(Unit unit) {
		List<Unit> memberUnits = ValidatorUtils.getMembers(unit);
		for (Iterator iterator = memberUnits.iterator(); iterator.hasNext();) {
			Unit member = (Unit) iterator.next();
			if(member instanceof NodeUnit){
				return true;
			}
			
		}
		return false;
	}
}
