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
import com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * Validates {@link DB2BufferPoolUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * </ul>
 */
public class DB2BufferPoolUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link DB2BufferPoolUnit} instance validator.
	 */
	public DB2BufferPoolUnitValidator() {
		this(Db2highPackage.eINSTANCE.getDB2BufferPoolUnit());

	}

	/**
	 * Construct a {@link DB2BufferPoolUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link DB2BufferPoolUnit}.
	 */
	protected DB2BufferPoolUnitValidator(EClass unitType) {
		super(unitType);
		assert Db2highPackage.eINSTANCE.getDB2BufferPoolUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types.
		//
		addCapabilityTypeConstraint(Db2highPackage.eINSTANCE.getDB2BufferPool(),
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
