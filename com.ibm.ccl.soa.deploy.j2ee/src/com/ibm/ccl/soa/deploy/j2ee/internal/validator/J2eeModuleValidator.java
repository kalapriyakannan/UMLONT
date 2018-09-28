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

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

public class J2eeModuleValidator extends UnitValidator {

	J2eeModuleValidator(EClass unitType) {
		super(unitType);

	}

	/**
	 * Validates that the unit has <em>one</em> host if it has hosting requirements, or no host if
	 * it has no hosting requirement.
	 * <p>
	 * Outgoing hosting links are validated in
	 * {@link #validateHostingLink(HostingLink, Unit, IaDeployValidationContext, IDeployReporter)}.
	 * The purpose of this method is to validate that the <em>number</em> of incoming is correct.
	 * 
	 * @param unit
	 *           the unit whose hosting is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 * 
	 * BA - 2007/12/20 Removed because it appears to be functionally handled by current UnitValidator
	 * method
	 */
// Ported over the key difference -- !ValidatorUtils.isHosted() to the core.
//	protected void validateHostingCardinality(Unit unit, IDeployValidationContext context,
//			IDeployReporter reporter) {
//
//		if (unit.getTopology() == null) {
//			// Cannot find the hosts of a unit
//			return;
//		}
//
//		boolean mustBeHosted = false;
//		for (Iterator iter = unit.getOnlyHostingRequirements().iterator(); iter.hasNext();) {
//			Requirement req = (Requirement) iter.next();
//			if (req.getUse() != RequirementUsage.OPTIONAL_LITERAL) {
//				mustBeHosted = true;
//				break;
//			}
//		}
//
//		Unit[] hosts = unit.getEditTopology().findHosts(unit);
//		if (hosts == null || hosts.length == 0) {
//			if (mustBeHosted) {
//				if (unit.getInitInstallState() != InstallState.INSTALLED_LITERAL) {
//
//					if (!ValidatorUtils.isHosted(unit)) {
//						int severity = unit.isConceptual() ? IStatus.WARNING : IStatus.ERROR;
//						IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
//								severity, IDeployCoreValidators.HOSTING_001,
//								ICoreProblemType.UNIT_NOT_HOSTED,
////										DeployCoreMessages.Validator_unit_0_not_hosted,
////										new Object[] { unit }, unit);
//								DeployCoreMessages.Validator_unit_0_not_hosted_1, new Object[] {
//										unit.getCaptionProvider().title(unit),
//										RequirementUtil.requirementsSummaryDescription(unit
//												.getOnlyHostingRequirements()) }, unit);
//						reporter.addStatus(status);
//					}
//				}
//			}
//		} else if (hosts.length == 1) {
//			// Link is verified in validateHostingLink(...)
//			Unit host = hosts[0];
//			if (!host.getTopology().equals(unit.getTopology())) {
//				// exception: host is in another topology
//				for (Iterator iter = host.getHostingLinks().iterator(); iter.hasNext();) {
//					HostingLink link = (HostingLink) iter.next();
//					if (link.getHosted().equals(unit)) {
//						this.validateHostingLink(link, unit, context, reporter);
//					}
//				}
//			}
//		} else {
//			// Hosted in multiple hosts
//			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
//					IDeployCoreValidators.HOSTING_002, ICoreProblemType.UNIT_MULTIPLE_HOSTS,
//					DeployCoreMessages.Validator_unit_0_has_ambiguous_hosting_st_,
//					new Object[] { unit }, unit);
//			reporter.addStatus(status);
//		}
//	}
}
