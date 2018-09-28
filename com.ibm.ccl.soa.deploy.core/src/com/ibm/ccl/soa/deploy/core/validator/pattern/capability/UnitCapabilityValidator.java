/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.capability;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.IDeployAttributeValidator;

/**
 * Abstract base implementation of the {@link IUnitCapabilityValidator} interface.
 * 
 * @see UnitValidator#addCapabilityValidator(IUnitCapabilityValidator)
 */
public class UnitCapabilityValidator implements IUnitCapabilityValidator {

	protected EClass capabilityType;

	protected List attributeValidatorList = null;

	/**
	 * Construct a unit capability validator for the specified {@link Capability} subtype.
	 * 
	 * @param capabilityType
	 *           a {@link Capability} subtype.
	 */
	public UnitCapabilityValidator(EClass capabilityType) {
		assert capabilityType != null;
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(capabilityType);
		this.capabilityType = capabilityType;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitCapabilityValidator#getCapabilityType()
	 */
	public EClass getCapabilityType() {
		return capabilityType;
	}

	/**
	 * Adds an attribute validator to the capability validator.
	 * 
	 * @param validator
	 *           an attribute validator for an attribute of {@link #getCapabilityType()}.
	 */
	protected void addAttributeValidator(IDeployAttributeValidator validator) {
		assert validator != null;
		if (attributeValidatorList == null) {
			attributeValidatorList = new LinkedList();
		}
		attributeValidatorList.add(validator);
	}

	/**
	 * Invokes all attribute validators that apply.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.capability.IUnitCapabilityValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (attributeValidatorList != null) {
			for (Iterator iter = attributeValidatorList.iterator(); iter.hasNext();) {
				IDeployAttributeValidator validator = (IDeployAttributeValidator) iter.next();
				if (validator.appliesTo(capability, context)) {
					validator.validate(capability, context, reporter);
				}
			}
		}
	}

	/**
	 * Returns true if the capability is a subtype of {@link #getCapabilityType()}.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.capability.IUnitCapabilityValidator#appliesTo(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit, IDeployValidationContext)
	 */
	public boolean appliesTo(Capability capability, Unit unit, IDeployValidationContext context) {
		return capabilityType.isSuperTypeOf(capability.getEObject().eClass());
	}
}
