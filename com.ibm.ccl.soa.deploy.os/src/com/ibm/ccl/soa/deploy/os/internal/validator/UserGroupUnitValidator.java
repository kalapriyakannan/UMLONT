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
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;

/**
 * Validates {@link UserGroupUnit}.
 * <p>
 * Validator IDs:
 * <ul>
 * <li> {@link IOsDomainValidators#USER_GROUP_UNIT_GROUP_NAME_001}
 * </ul>
 */
public class UserGroupUnitValidator extends UnitValidator {

	/**
	 * Construct a {@link UserGroupUnit} instance validator.
	 */
	public UserGroupUnitValidator() {
		this(OsPackage.eINSTANCE.getUserGroupUnit());

	}

	/**
	 * Construct a {@link UserGroupUnit} subtype validator.
	 * 
	 * @param unitType
	 *           a subtype of {@link UserGroupUnit}.
	 */
	protected UserGroupUnitValidator(EClass unitType) {
		super(unitType);
		assert OsPackage.eINSTANCE.getUserGroupUnit().isSuperTypeOf(unitType);

		//
		// Constraints on capabilities and requirement types
		//
		addCapabilityTypeConstraint(OsPackage.eINSTANCE.getUserGroup(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		addRequirementTypeConstraint(OsPackage.eINSTANCE.getUserUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

		//
		// {@link User} capability attribute constraints
		//
		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IOsDomainValidators.USER_GROUP_UNIT_GROUP_NAME_001, OsPackage.eINSTANCE
						.getUserGroup_GroupName(), IStatus.ERROR));
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IOsDomainValidators.USER_GROUP_UNIT_GROUP_NAME_ID_001, OsPackage.eINSTANCE
						.getUserGroup_GroupName()));
	}
}
