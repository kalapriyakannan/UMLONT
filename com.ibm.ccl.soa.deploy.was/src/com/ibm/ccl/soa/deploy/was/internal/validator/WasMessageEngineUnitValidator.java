/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * Validator for units of type {@link WasPackage.Literals#WAS_MESSAGING_ENGINE_UNIT}.
 */
public class WasMessageEngineUnitValidator extends UnitValidator {

	public EClass getUnitType() {
		return WasPackage.Literals.WAS_MESSAGING_ENGINE_UNIT;
	}

	public String getUnitValidatorId() {
		return getClass().getName();
	}

	/**
	 * Constructor
	 */
	public WasMessageEngineUnitValidator() {

		super(WasPackage.Literals.WAS_MESSAGING_ENGINE_UNIT);

		/*
		 * test for messaging engine capability, for example: <was:capability.wasMessagingEngine
		 * name="WASMessagingEngine" engineName="me1" linkType="any" />
		 */
		addCapabilityTypeConstraint(WasPackage.Literals.WAS_MESSAGING_ENGINE,
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		/*
		 * test for requirement that ME is member of SI Bus, for example: <core:requirement
		 * displayName="Member of SI Bus" mutable="true" name="MemberOfSIBus"
		 * dmoType="was:WasSIBusUnit" linkType="member"> <constraint:constraint.groupCardinality
		 * name="c0" maxValue="1" minValue="1"/> </core:requirement> <core:requirement
		 * displayName="Requires Auth Alias" name="AuthAlias"
		 * dmoType="was:WASJ2CAuthenticationDataEntry" linkType="dependency" use="optional"/>
		 */
		addRequirementTypeConstraint(WasPackage.Literals.WAS_SI_BUS_UNIT,
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

		/*
		 * test for requirement that ME may depend on an authentication entry for authentication to
		 * the SI Bus, for example: <core:requirement displayName="Requires Auth Alias"
		 * name="AuthAlias" dmoType="was:WASJ2CAuthenticationDataEntry" linkType="dependency"
		 * use="optional"/>
		 */
		addRequirementTypeConstraint(WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		/*
		 * test for requirement that ME depends on a datasource (for message store), for example:
		 * <core:requirement displayName="Requires Datasource" name="Datasource"
		 * dmoType="was:WasDatasource" linkType="dependency" use="required"/>
		 */
		// TODO - extend to include file system for message store
		addRequirementTypeConstraint(WasPackage.Literals.WAS_DATASOURCE,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		/*
		 * test for requirement that ME can be hosted on capability; for example: <core:requirement
		 * displayName="Hosted on WAS Container" mutable="true" name="HostedOnWasContainer"
		 * dmoType="core:Capability" linkType="hosting"> <constraint:constraint.or name="c0">
		 * <constraint:constraint.type name="c0" dmoType="was:WasServer"/> <constraint:constraint.type
		 * name="c1" dmoType="was:WasCluster"/> </constraint:constraint.or> </core:requirement>
		 */
		// TODO - improve requirement test to include constraint checking
		// TODO - this test doesn't seem to work; not sure why
//		addRequirementTypeConstraint(CorePackage.Literals.CAPABILITY,
//				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		// test that attribute {@link WasPackage.Literals#WAS_MESSAGING_ENGINE__ENGINE_NAME} is not empty 
		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(getUnitValidatorId(),
				WasPackage.Literals.WAS_MESSAGING_ENGINE__ENGINE_NAME, IStatus.ERROR));

		// test that attribute {@link WasPackage.Literals#WAS_MESSAGING_ENGINE__ENGINE_NAME} is unique among commonly hosted ME
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(getUnitValidatorId(),
				WasPackage.Literals.WAS_MESSAGING_ENGINE__ENGINE_NAME));

	}

	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		super.validateUnit(unit, context, reporter);

		// The following additional checks are made:
		//   (a) If the host is a {@link WebsphereAppServerUnit}, there is only 1 ME

		//   (a) If the host is a {@link WebsphereAppServerUnit}, there is only 1 ME
		//@jazz 6790: WAS ND validation is not correct
//		Unit host = ValidatorUtils.discoverHost(unit, context.getProgressMonitor());
//		if (null != host) {
//			if (WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT
//					.isSuperTypeOf(host.getEObject().eClass())) {
//				List<Unit> messageEngines = ValidatorUtils.discoverHosted(host,
//						WasPackage.Literals.WAS_MESSAGING_ENGINE_UNIT, context.getProgressMonitor());
//				if (1 < messageEngines.size()) {
//					IDeployStatus status = DeployWasMessageFactory.createUnitNotUniqueOnHost(unit,
//							IWasValidatorID.MESSAGING_ENGINE_001,
//							WasPackage.Literals.WAS_MESSAGING_ENGINE_UNIT);
//					reporter.addStatus(status);
//				}
//			}
//		}
	}
}
