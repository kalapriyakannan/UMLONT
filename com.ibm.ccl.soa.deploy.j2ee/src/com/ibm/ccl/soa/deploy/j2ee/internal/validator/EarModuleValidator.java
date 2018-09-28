/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployRequirementAttributeNotNullValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.validation.IJ2eeValidatorID;

/**
 * Validates instances of {@link EarModule}.
 */
public class EarModuleValidator extends J2eeModuleValidator {

	/**
	 * Construct a unit validator for the {@link EarModule} unit type.
	 */
	public EarModuleValidator() {
		this(J2eePackage.eINSTANCE.getEarModule());
	}

	/**
	 * Construct a unit validator for subtype of {@link EarModule}.
	 * 
	 * @param unitType
	 *           a subtype ol {@link EarModule}.
	 */
	protected EarModuleValidator(EClass unitType) {
		super(unitType);
		assert J2eePackage.eINSTANCE.getEarModule().isSuperTypeOf(unitType);

		addAttributeValidator(new DeployRequirementAttributeNotNullValidator(
				IJ2eeDomainValidators.J2EE_EAR_MODULE_001, J2eePackage.eINSTANCE
						.getJ2EEDatasource_JndiName(), IStatus.ERROR));
		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IJ2eeDomainValidators.J2EE_EAR_MODULE_002, J2eePackage.eINSTANCE.getJ2EEDatasource(),
				J2eePackage.eINSTANCE.getJ2EEServer(), IStatus.ERROR));

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 1, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JSP_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.SERVLET_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.EJB_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JCA_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_SERVER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_SECURITY_ROLE,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_DATASOURCE,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_RESOURCE_REQUIREMENT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);

		this.addRequirementTypeConstraint(CorePackage.Literals.BUNDLE_CAPABILITY,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);

		this.addRequirementTypeConstraint(J2eePackage.Literals.WEB_MODULE,
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.EJB_MODULE,
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JAR_MODULE,
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.APP_CLIENT,
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JCA_MODULE,
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	protected void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		//
		// Validate that all the EAR module members have the same install state as the EAR
		//
		List<Unit> members;
		if (unit.getInitInstallState() == InstallState.INSTALLED_LITERAL
				&& unit.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			// The EAR was installed and now will be uninstalled.  Some of its modules
			// may not be in the topology, and we need to make sure that they are also
			// marked as uninstalled.  Use discovery to find them.
			members = ValidatorUtils.discoverMembers(unit, context.getProgressMonitor());
		} else {
			if (unit.getTopology() == null) {
				members = Collections.emptyList();
			} else {
				members = (List<Unit>) unit.getTopology().getRelationships().getMembers(unit);
			}
		}
		for (Unit member : members) {
			// initInstallState
			if (member.getInitInstallState() != unit.getInitInstallState()) {
				String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid;
				Object[] bindings = new Object[] { member,
						CorePackage.eINSTANCE.getUnit_InitInstallState(), unit.getInitInstallState() };
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
						IStatus.ERROR, IJ2eeValidatorID.EAR_MODULE_INSTALL_STATE_001,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, unboundMessage, bindings, member,
						CorePackage.eINSTANCE.getUnit_InitInstallState(), unit.getInitInstallState());
				reporter.addStatus(status);
			}
			// goalInstallState
			if (member.getGoalInstallState() != unit.getGoalInstallState()) {
				String unboundMessage = DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid;
				Object[] bindings = new Object[] { member,
						CorePackage.eINSTANCE.getUnit_GoalInstallState(), unit.getGoalInstallState() };
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
						IStatus.ERROR, IJ2eeValidatorID.EAR_MODULE_INSTALL_STATE_001,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID, unboundMessage, bindings, member,
						CorePackage.eINSTANCE.getUnit_GoalInstallState(), unit.getGoalInstallState());
				reporter.addStatus(status);
			}
		}
	}
}
