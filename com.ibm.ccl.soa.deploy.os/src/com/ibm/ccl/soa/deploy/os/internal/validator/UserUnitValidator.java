/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;

/**
 * Validates {@link UserUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * <li> {@link IOsDomainValidators#USER_UNIT_USER_ID_001}
 * <li> {@link IOsDomainValidators#USER_UNIT_USER_ID_002}
 * <li> {@link IOsDomainValidators#USER_UNIT_USER_PASSWORD_001}
 * </ul>
 */
public class UserUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link UserUnit} instance validator.
	 */
	public UserUnitValidator() {
		this(OsPackage.eINSTANCE.getUserUnit());

	}

	/**
	 * Construct a {@link UserUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link UserUnit}.
	 */
	protected UserUnitValidator(EClass unitType) {
		super(unitType);
		assert OsPackage.eINSTANCE.getUserUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types
		//
		addCapabilityTypeConstraint(OsPackage.eINSTANCE.getUser(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		addRequirementTypeConstraint(OsPackage.eINSTANCE.getUserGroupUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

		//
		// {@link User} capability attribute constraints
		//
		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IOsDomainValidators.USER_UNIT_USER_ID_001, OsPackage.eINSTANCE.getUser_UserId(),
				IStatus.ERROR));
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IOsDomainValidators.USER_UNIT_USER_ID_002, OsPackage.eINSTANCE.getUser_UserId()));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IOsDomainValidators.USER_UNIT_USER_PASSWORD_001, OsPackage.eINSTANCE
						.getUser_UserPassword(), IStatus.ERROR));
	}
}
