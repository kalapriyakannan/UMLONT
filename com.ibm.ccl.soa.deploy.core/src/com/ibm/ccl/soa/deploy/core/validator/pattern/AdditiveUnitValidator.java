/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * An "additive" {@link UnitValidator}; that is, one which does not do much validation. If one
 * wants to add validations to a {@link Unit} without repeating existing validations, one can do so
 * by extending this class. The only validations from {@link UnitValiator} that are carried forward
 * are
 * {@link UnitValidator#validateCapabilityTypes(Unit, IDeployValidationContext, IDeployReporter)}
 * and
 * {@link UnitValidator#validateRequirementTypes(Unit, IDeployValidationContext, IDeployReporter)}.
 */
public class AdditiveUnitValidator extends UnitValidator {

	/**
	 * Constructor
	 * 
	 * @param unitType
	 *           the type of unit that is validated.
	 */
	public AdditiveUnitValidator(EClass unitType) {
		super(unitType);
	}

	@Override
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateArtifact(Artifact artifact, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateAttributes(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateDependencyLink(DependencyLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateDependencyLinkMatch(DependencyLink link, Unit sourceUnit,
			Unit targetUnit, IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateDependencyLinkTarget(Capability cap, Requirement req,
			DependencyLink link, Unit sourceUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateFileArtifactURI(String uri, FileArtifact artifact, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateHostingCardinality(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateHostingLink(HostingLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateHostingLinkMatch(HostingLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected boolean validateInstalledUnit(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
		return true;
	}

	@Override
	protected void validateConstraintLink(ConstraintLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateMemberLink(MemberLink link, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	public void validateMembershipCardinality(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateUnitRealization(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateCapabilityRealization(Capability cap, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateRequirementRealization(Requirement req, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateRealizationLink(RealizationLink link, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateRequirement(Requirement req, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateUnitPublishState(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateCapabilityTypes(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateConstraints(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateRealizationLinks(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

	@Override
	protected void validateRequirementTypes(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		// do nothing
	}

}
