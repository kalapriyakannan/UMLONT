/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2high.internal.validator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * Validates {@link DB2IndexUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class DB2IndexUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link DB2IndexUnit} instance validator.
	 */
	public DB2IndexUnitValidator() {
		this(Db2highPackage.eINSTANCE.getDB2IndexUnit());

	}

	/**
	 * Construct a {@link DB2IndexUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link DB2IndexUnit}.
	 */
	protected DB2IndexUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2highPackage.eINSTANCE.getDB2IndexUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(Db2highPackage.eINSTANCE.getDB2Index(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);
	}
}
