/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Abstract base implementation of the {@link IActionPreconditionTest} interface.
 * 
 * @see UnitValidator#addCapabilityValidator(IActionPreconditionTest)
 */
public abstract class ActionPreconditionTest implements IActionPreconditionTest {

	/** action precondition tester id */
	protected String id;

	/** action parameter types */
	protected ISignature signature;

	/**
	 * Construct an action precondition tester for a particular {@link Unit} type.
	 * 
	 * @param id
	 *           the action tester id (is a validator id)
	 * @param unitTypes
	 *           an array of {@link Unit} subtypes identifying action parameter types.
	 */
	public ActionPreconditionTest(String id, ISignature unitTypes) {
		assert id != null;
		assert id.trim().length() != 0;
		assert unitTypes != null;
//		for (int i = 0; i < unitTypes.length; i++) {
//			assert CorePackage.Literals.UNIT.isSuperTypeOf(unitTypes[i]);
//		}
		this.id = id;
		this.signature = unitTypes;
	}

	public String getId() {
		return id;
	}

	public ISignature getSignature() {
		return signature;
	}

	// do we need a capability like this for various things?
	// /**
	// * Adds an attribute validator to the capability validator.
	// *
	// * @param validator
	// * an attribute validator for an attribute of
	// * {@link #getCapabilityType()}.
	// */
	// protected void addAttributeValidator(IDeployAttributeValidator validator)
	// {
	// assert validator != null;
	// if (attributeValidatorList == null) {
	// attributeValidatorList = new LinkedList();
	// }
	// attributeValidatorList.add(validator);
	// }

	/**
	 * Should be overritten.
	 */
	public abstract void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter);

	/**
	 * @return returns true if the units are (in order) subtypes of {@link #getSignature()}.
	 */
	public boolean appliesTo(List<DeployModelObject> parameters) {
		return getSignature().isValidInstance(parameters);
	}

	/**
	 * @return returns true if the unit types are (in order) subtypes of {@link #getSignature()}.
	 */
	public abstract boolean appliesTo(ISignature signature);
}
