/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.PublishState;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.expression.ReqEvaluationContext;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.IDeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.IUnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.IConstraintLinkValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.IDependencyLinkValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.IUnitLinkValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.UnitLifeCycleManager;
import com.ibm.ccl.soa.deploy.internal.core.validator.UnitCapabilityTypeConstraint;
import com.ibm.ccl.soa.deploy.internal.core.validator.UnitRequirementTypeConstraint;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RealizationMatcherUtils;

/**
 * Implements the {@link CorePackage} domain validations for a {@link Unit}.
 * <p>
 * Domain validators ({@link DomainValidator}) can delegate validations to individual unit
 * validators based on type. This pattern is implemented by {@link UnitDomainValidator}.
 * <p>
 * The main unit validator method
 * {@link IUnitValidator#validate(Unit, IDeployValidationContext, IDeployReporter)} delegates
 * validation of the unit-contained entities: requirements, capabilities, links (hosting,
 * requirement, dependency, logical), artifacts.
 * <p>
 * Unit subtype validators will extend this class to provide domain-specific validations. Two
 * extension mechanisms are provided:
 * <ul>
 * <li> "Declarative"-style validators added using
 * <ul>
 * <li> {@link #addCapabilityTypeConstraint(EClass, CapabilityLinkTypes, int, int)}: restrict the
 * set of capability types that can be contained by the unit.
 * <li> {@link #addRequirementTypeConstraint(EClass, RequirementLinkTypes, int, int)} : validate the
 * {@link Requirement#getDmoEType()} types that may be required by the unit.
 * <li> {@link #addAttributeValidator(IDeployAttributeValidator)} : validate an attribute on
 * <em>any</em> contained unit object.
 * <li> {@link #addCapabilityValidator(IUnitCapabilityValidator)}: validate a capability of a
 * specific type.
 * <li> {@link #addDependencyLinkValidator(IDependencyLinkValidator)}: validate a dependency link.
 * <li> {@link #addUnitLinkValidator(IUnitLinkValidator)}: validate a unit link.
 * <li> {@link #addConstraintLinkValidator(IConstraintLinkValidator)}: validate a logical link.
 * </ul>
 * <li> Imperative validators added by overriding one of the delegation methods. The core
 * validations may still be applied by invoking <code>super</code>.
 * </ul>
 */
public class UnitValidator implements IUnitValidator {

	/** The type of unit that is validated. */
	protected EClass unitType;

	/** The UnitValidator Id */
	protected String unitValidatorId = getClass().getName();

	/**
	 * @see #getAllowUnexpectedCapabilityTypes()
	 */
	protected boolean allowUnexpectedCapabilityTypes = true;

	/**
	 * @see #getAllowUnexpectedRequirementTypes()
	 */
	protected boolean allowUnexpectedRequirementTypes = true;

	/**
	 * Optional list of {@link UnitRequirementTypeConstraint} on unit capabilities.
	 */
	protected List<UnitCapabilityTypeConstraint> capabilityTypeConstraintList;

	/**
	 * Optional list of {@link UnitRequirementTypeConstraint} on unit requirements.
	 */
	protected List<UnitRequirementTypeConstraint> requirementTypeConstraintList;

	/** List<IDeloyAttributeValidator> */
	protected List<IDeployAttributeValidator> attributeValidatorList;

	/** List<IDependencyLinkValidator> */
	protected List<IDependencyLinkValidator> dependencyLinkValidatorList;

	/** List<IUnitLinkValidator> */
	protected List<IUnitLinkValidator> unitLinkValidatorList;

	/** List<ILogicalLinkValidator> */
	protected List<IConstraintLinkValidator> constraintLinkValidatorList;

	/** List<IUnitCapabilityValidator> */
	protected List<IUnitCapabilityValidator> capabilityValidatorList;

	/** Controls the application of core validation logic by the unit validator. */
	protected boolean coreValidationEnabled = true;

	/**
	 * Construct a unit validator for the {@link Unit} unit type.
	 * <p>
	 * By default, the requirement and capability type constraints are not enforced on undeclared
	 * types (@link {@link #setAllowUnexpectedCapabilityTypes(boolean)}).
	 * 
	 * @param unitType
	 *           the type of unit that is validated.
	 */
	public UnitValidator(EClass unitType) {
		if (unitType == null) {
			throw new IllegalArgumentException();
		}
		if (!CorePackage.eINSTANCE.getUnit().isSuperTypeOf(unitType)) {
			throw new IllegalArgumentException(unitType.getName());
		}
		this.unitType = unitType;
	}

	/**
	 * @return true if the unit validator will perform core unit validation.
	 */
	protected boolean isCoreValidationEnabled() {
		return coreValidationEnabled;
	}

	/**
	 * Enables or disables the core validation logic of the unit validator.
	 * 
	 * @param enabled
	 *           true if core validation should be invoked.
	 */
	protected void setCoreValidationEnabled(boolean enabled) {
		coreValidationEnabled = enabled;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return unitType;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitValidatorId()
	 */
	public String getUnitValidatorId() {
		return unitValidatorId;
	}

	/**
	 * Adds a constraint on the types of capabilities that can be provided by the unit.
	 * 
	 * @param type
	 *           the type that is permitted.
	 * @param linkType
	 *           the link type of the capability (may be null for don't care).
	 * @param min
	 *           the minimum number of type occurances.
	 * @param max
	 *           the maximum number of type occurances.
	 */
	public void addCapabilityTypeConstraint(EClass type, CapabilityLinkTypes linkType, int min,
			int max) {
		assert type != null;
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(type);
		UnitCapabilityTypeConstraint c = new UnitCapabilityTypeConstraint(type, min, max, linkType);
		if (capabilityTypeConstraintList == null) {
			capabilityTypeConstraintList = new ArrayList<UnitCapabilityTypeConstraint>();
		}
		capabilityTypeConstraintList.add(c);
	}

	/**
	 * Adds a constraint on the {@link Requirement#getDmoEType()} that can be consumed by the unit.
	 * 
	 * @param type
	 *           the deploy model object type that is permitted.
	 * @param linkType
	 *           the link type that is supported (may be null).
	 * @param min
	 *           the minimum number of type occurances.
	 * @param max
	 *           the maximum number of type occurances.
	 */
	public void addRequirementTypeConstraint(EClass type, RequirementLinkTypes linkType, int min,
			int max) {
		assert type != null;
		if (!CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf(type)) {
			throw new IllegalArgumentException(type.getName());
		}
		UnitRequirementTypeConstraint c = new UnitRequirementTypeConstraint(type, min, max, linkType);
		if (requirementTypeConstraintList == null) {
			requirementTypeConstraintList = new ArrayList<UnitRequirementTypeConstraint>();
		}
		requirementTypeConstraintList.add(c);
	}

	/**
	 * Adds a validator for a deploy model object attribute.
	 * <p>
	 * The unit validator checks
	 * {@link IDeployAttributeValidator#appliesTo(DeployModelObject, IDeployValidationContext)} for
	 * each unit contained object that is validated against the attribute validator, and invokes
	 * {@link IDeployAttributeValidator#validate(DeployModelObject, IDeployValidationContext, IDeployReporter)}
	 * when a match is found.
	 * 
	 * @param validator
	 *           an attribute validator.
	 */
	public void addAttributeValidator(IDeployAttributeValidator validator) {
		assert validator != null;
		if (attributeValidatorList == null) {
			attributeValidatorList = new LinkedList<IDeployAttributeValidator>();
		}
		attributeValidatorList.add(validator);
	}

	/**
	 * Adds a validator for a deploy {@link Capability}.
	 * <p>
	 * For each capability provided by a unit, the unit validator identifies the capability
	 * validators of a matching t{@link IUnitCapabilityValidator#getCapabilityType()}
	 * {@link IDeployAttributeValidator#appliesTo(DeployModelObject, IDeployValidationContext)} for
	 * each unit contained object that is validated against the attribute validator, and invokes
	 * {@link IDeployAttributeValidator#validate(DeployModelObject, IDeployValidationContext, IDeployReporter)}
	 * when a match is found.
	 * 
	 * @param validator
	 *           an attribute validator.
	 */
	public void addCapabilityValidator(IUnitCapabilityValidator validator) {
		assert validator != null;
		if (capabilityValidatorList == null) {
			capabilityValidatorList = new LinkedList<IUnitCapabilityValidator>();
		}
		capabilityValidatorList.add(validator);
	}

	/**
	 * Adds a validator for {@link UnitLink} contained in {@link Unit} being validated.
	 * 
	 * @param validator
	 *           a unit link validator.
	 */
	public void addUnitLinkValidator(IUnitLinkValidator validator) {
		assert validator != null;
		if (unitLinkValidatorList == null) {
			unitLinkValidatorList = new LinkedList<IUnitLinkValidator>();
		}
		unitLinkValidatorList.add(validator);
	}

	/**
	 * Adds a validator for {@link ConstraintLink} contained in the {@link Unit} being validated.
	 * 
	 * @param validator
	 *           a logical link validator.
	 */
	public void addConstraintLinkValidator(IConstraintLinkValidator validator) {
		assert validator != null;
		if (constraintLinkValidatorList == null) {
			constraintLinkValidatorList = new LinkedList<IConstraintLinkValidator>();
		}
		constraintLinkValidatorList.add(validator);
	}

	/**
	 * Adds a validator for {@link DependencyLink} contained in {@link Requirement} instances
	 * consumed by the {@link Unit} being validated.
	 * 
	 * @param validator
	 *           a dependency link validator.
	 */
	public void addDependencyLinkValidator(IDependencyLinkValidator validator) {
		assert validator != null;
		if (dependencyLinkValidatorList == null) {
			dependencyLinkValidatorList = new LinkedList<IDependencyLinkValidator>();
		}
		dependencyLinkValidatorList.add(validator);
	}

	/**
	 * Validates the unit by delegating to the different protected methods.
	 * <p>
	 * Subtypes should never override this method. Generic unit validation should be performed by
	 * overriding {@link #validateUnit(Unit, IDeployValidationContext, IDeployReporter)}.
	 * <p>
	 * For units in INSTALLED and DO_NOT_PUBLISH state, only the
	 * {@link #validateInstalledUnit(Unit, IDeployValidationContext, IDeployReporter)} protected
	 * method will be invoke.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#validate(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public final void validate(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		IProgressMonitor monitor = context.getProgressMonitor();
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Installed and not publishable units are validated differently
		//	
		if (unit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			if (!validateInstalledUnit(unit, context, reporter)) {
				return;
			}
		}

		validateUnit(unit, context, reporter);

		if (getUnitType() != null && !getUnitType().isSuperTypeOf(unit.getEObject().eClass())) {
			String message = NLS
					.bind(
							DeployCoreMessages.Validator_unit_validator_expected_0_type_passed_object_1_of_type_2,
							new Object[] { getUnitType().getName(), unit.getName(),
									unit.getEObject().eClass().getName() });
			throw new IllegalArgumentException(message);
		}

		if (monitor.isCanceled()) {
			return;
		}

		validateAttributes(unit, context, reporter);
		validateConstraints(unit, context, reporter);
		validateUnitPublishState(unit, context, reporter);

		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate capabilities & requirement <em>types</em>.
		//
		if (unit.getCapabilities().size() == 0 && !unit.isConceptual()
				&& unit.getConstraints().size() == 0 && unit.getRequirements().size() == 0) {
			if (!(unit instanceof SoftwareComponent)) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.WARNING, IDeployCoreValidators.UNIT_001,
						ICoreProblemType.UNIT_HAS_NO_REQUIREMENTS_OR_CAPABILITIES,
						DeployCoreMessages.Validator_unit_0_has_no_requirements_or_capabilities,
						new Object[] { unit }, unit);
				reporter.addStatus(status);
			}
		}

		validateCapabilityTypes(unit, context, reporter);
		validateRequirementTypes(unit, context, reporter);

		//
		// Perform core validation
		//
		if (monitor.isCanceled() || !isCoreValidationEnabled()) {
			return;
		}

		//
		// Capabilities
		//
		for (Iterator<Capability> iter = unit.getCapabilities().iterator(); iter.hasNext();) {
			Capability cap = iter.next();
			validateCapability(cap, unit, context, reporter);
		}

		//
		// Requirements
		//
		for (Iterator<Requirement> iter = unit.getRequirements().iterator(); iter.hasNext();) {
			Requirement req = iter.next();
			validateRequirement(req, unit, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Unit links
		//
		for (Iterator<UnitLink> iter = unit.getUnitLinks().iterator(); iter.hasNext();) {
			UnitLink link = iter.next();
			if (unitLinkValidatorList != null) {
				for (Iterator<IUnitLinkValidator> iter2 = unitLinkValidatorList.iterator(); iter2
						.hasNext();) {
					IUnitLinkValidator validator = iter2.next();
					try {
						validator.validate(link, context, reporter);
					} catch (RuntimeException e) {
						if (!context.getProgressMonitor().isCanceled()) {
							DeployCorePlugin.logError(0, DeployNLS.bind(
									DeployCoreMessages.Validator_0_failed, validator.getValidatorID()), e);
						}
					}
				}
			}
		}
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate unit hosting and hosting units (subtype of unit-link)
		//
		validateHostingCardinality(unit, context, reporter);
		for (Iterator<HostingLink> iter = unit.getHostingLinks().iterator(); iter.hasNext();) {
			HostingLink link = iter.next();
			validateHostingLink(link, unit, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate group membership and member links (subtype of unit-link)
		//
		validateMembershipCardinality(unit, context, reporter);
		for (Iterator<MemberLink> iter = unit.getMemberLinks().iterator(); iter.hasNext();) {
			MemberLink link = iter.next();
			validateMemberLink(link, unit, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate logical links.
		//
		for (Iterator<ConstraintLink> iter = unit.getConstraintLinks().iterator(); iter.hasNext();) {
			ConstraintLink link = iter.next();
			validateConstraintLink(link, unit, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate artifacts
		//
		for (Iterator<Artifact> iter = unit.getArtifacts().iterator(); iter.hasNext();) {
			Artifact artifact = iter.next();
			validateArtifact(artifact, unit, context, reporter);
		}
		if (monitor.isCanceled()) {
			return;
		}

		//
		// Validate realization
		//
		validateUnitRealization(unit, context, reporter);
		validateRealizationLinks(unit, context, reporter);

		// Validate unit binding
		validateUnitBinding(unit, context, reporter);
	}

	/**
	 * Overriden by subtypes to perform general purpose unit validation.
	 * <p>
	 * This method will not be invoked if the unit is in install and do not publish state.
	 * 
	 * @param unit
	 *           the unit whose membership link cardinality is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		assert unit != null;
		assert context != null;
		assert reporter != null;
	}

	/**
	 * Validation for units with {@link Unit#getInitInstallState()} = {@link InstallState#INSTALLED}.
	 * <p>
	 * The method is invoked by {@link #validate(Unit, IDeployValidationContext, IDeployReporter)}
	 * and no other validation methods are directly invoked. It validates:
	 * <ul>
	 * <li> Hosting links whose target is not an installed unit ({@link #validateHostingLink(HostingLink, Unit, IDeployValidationContext, IDeployReporter)}.
	 * <li> All constraint links.
	 * </ul>
	 * <p>
	 * Returns true if {@link Unit#getPublishIntent()} != {@link PublishIntent#PUBLISH}.
	 * 
	 * @param unit
	 *           the unit whose membership link cardinality is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 * @return true if further validation should be performed, false otherwise.
	 */
	protected boolean validateInstalledUnit(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert unit.getInitInstallState() == InstallState.INSTALLED_LITERAL;
		if (!isCoreValidationEnabled()) {
			return false;
		}
		//
		// Validate unit hosting and hosting units (subtype of unit-link)
		//
		for (Iterator<HostingLink> iter = unit.getHostingLinks().iterator(); iter.hasNext();) {
			HostingLink link = iter.next();
			if (link.getTarget() != null
					&& link.getTarget().getInitInstallState() != InstallState.INSTALLED_LITERAL) {
				validateHostingLink(link, unit, context, reporter);
			}
		}

		//
		// Validate logical links.
		//
		for (Iterator<ConstraintLink> iter = unit.getConstraintLinks().iterator(); iter.hasNext();) {
			ConstraintLink link = iter.next();
			validateConstraintLink(link, unit, context, reporter);
		}

		boolean continueUnitValidation = true;

		if (unit.getPublishIntent() == PublishIntent.DO_NOT_PUBLISH_LITERAL) {
			// no more validations needed
			continueUnitValidation = false;
		}

		if (unit.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			continueUnitValidation = false;
		}

		if (!continueUnitValidation) {
			//
			// Validate realization links.
			//
			validateUnitRealization(unit, context, reporter);
			validateRealizationLinks(unit, context, reporter);
		}

		// incremental changes made, so publish
		return continueUnitValidation;
	}

	/**
	 * Validates that the group has <em>one</em> member link to each unit.
	 * 
	 * @param unit
	 *           the unit whose membership link cardinality is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	public void validateMembershipCardinality(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		Set<Unit> memberSet = null;
		// TODO FIXME deal with topology links
		for (Iterator<MemberLink> iter = unit.getMemberLinks().iterator(); iter.hasNext();) {
			MemberLink link = iter.next();
			if (memberSet == null) {
				memberSet = new HashSet<Unit>();
			}
			if (link.getTarget() != null) {
				if (memberSet.contains(link.getTarget())) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.ERROR, IDeployCoreValidators.MEMBER_LINK_003,
							ICoreProblemType.MULTIPLE_MEMBER_LINKS_BETWEEN_UNITS,
							DeployCoreMessages.Validator_unit_0_has_multiple_member_links_to_unit_1,
							new Object[] { unit, link.getTarget() }, link);
					reporter.addStatus(status);
				} else {
					memberSet.add(link.getTarget());
				}
			}
		}
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
	 */
	protected void validateHostingCardinality(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {

		if (unit.getTopology() == null) {
			// Cannot find the hosts of a unit
			return;
		}

		boolean mustBeHosted = false;
		boolean mayBeHosted = false;
		for (Iterator iter = unit.getOnlyHostingRequirements().iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if (req.getUse() != RequirementUsage.OPTIONAL_LITERAL) {
				mustBeHosted = true;
			} else {
				mayBeHosted = true;
			}
		}

		List<UnitDescriptor> hostUDs = TopologyDiscovererService.INSTANCE.findAllHosts(unit, unit
				.getEditTopology(), context.getProgressMonitor());
		if (hostUDs.size() == 0) {
			// defect 2635: an INFO should appear for optionally hosted requirements
			if (mustBeHosted || mayBeHosted) {
				// No hosts discovered: either they don't exist or they are planned for uninstall.
				// init=INSTALLED, goal=INSTALLED/UNKNOWN, hasHostInTopology : ERROR
				// init=INSTALLED, goal=INSTALLED/UNKNOWN, !hasHostInTopology : OK
				// init=INSTALLED, goal=NOT_INSTALLED, hasHostInTopology: OK
				// init=INSTALLED, goal=NOT_INSTALLED, !hasHostInTopology: OK TODO WARNING?
				// init=NOT_INSTALLED/UNKNOWN, goal=INSTALLED/UNKNOWN, hasHostInTopology : ERROR
				// init=NOT_INSTALLED/UNKNOWN, goal=INSTALLED/UNKNOWN, !hasHostInTopology : ERROR
				// init=NOT_INSTALLED/UNKNOWN, goal=NOT_INSTALLED, hasHostInTopology: OK
				// init=NOT_INSTALLED/UNKNOWN, goal=NOT_INSTALLED, !hasHostInTopology: OK TODO WARNING?
				boolean isInitInstalled = unit.getInitInstallState() == InstallState.INSTALLED_LITERAL;
				if (unit.isConceptual()) {
					DeployModelObject finalUnit = RealizationLinkUtil.getFinalRealization(unit);
					if (finalUnit instanceof Unit) {
						isInitInstalled = ((Unit) finalUnit).getInitInstallState() == InstallState.INSTALLED_LITERAL;
					}
				}

				if (isInitInstalled) {
					List<HostingLink> linksIn = TopologyUtil.getImmediateHostingLinksIn(unit);
					if (linksIn.size() > 0
							&& unit.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
						// Host unit will be uninstalled: create error
						IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
								IStatus.ERROR, IDeployCoreValidators.HOSTING_005,
								ICoreProblemType.UNIT_HOST_TO_BE_UNINSTALLED,
								DeployCoreMessages.Validator_unit_0_host_to_be_uninstalled,
								new Object[] { unit }, unit);
						reporter.addStatus(status);
					}
				} else {
					// init=UNKNOWN or NOT_INSTALLED
					if (unit.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
						// defect 2635: an INFO should appear for optionally hosted requirements
						// we explicitly check ValidatorUtils.isHosted() because 
						// it will consider membership relationships in the hosting stack.
						if (mustBeHosted && !ValidatorUtils.isHosted(unit)) {
							int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
							IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
									severity, IDeployCoreValidators.HOSTING_001,
									ICoreProblemType.UNIT_NOT_HOSTED,
//								DeployCoreMessages.Validator_unit_0_not_hosted,
//										new Object[] { unit }, unit);
									DeployCoreMessages.Validator_unit_0_not_hosted_1, new Object[] {
											unit.getCaptionProvider().title(unit),
											RequirementUtil.requirementsSummaryDescription(unit
													.getOnlyHostingRequirements()) }, unit);
							reporter.addStatus(status);
						} else if (mayBeHosted) {
							int severity = IStatus.INFO;
							IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
									severity, IDeployCoreValidators.HOSTING_001,
									ICoreProblemType.UNIT_NOT_HOSTED,
									DeployCoreMessages.Validator_unit_0_not_hosted_1_optional, new Object[] {
											unit.getCaptionProvider().title(unit),
											RequirementUtil.requirementsSummaryDescription(unit
													.getOnlyHostingRequirements()) }, unit);
							reporter.addStatus(status);
						}
					}
				}
			}
		} else if (hostUDs.size() != 1) {
			// As of V8M5 we assign an ambiguous hosting status to the Unit.
			// Hosted in multiple hosts.  Lets check if any are local conceptual (efficiently).
//			List<Unit> localHosts = ValidatorUtils.getAllHosts(unit);
//			int localConceptualHostsCount = 0;
//			for (Unit localHost : localHosts) {
//				if (localHost.isConceptual()) {
//					localConceptualHostsCount++;
//				}
//			}
//			// Ignore counting of conceptual hosts that are not realized yet.
//			if (hostUDs.size() - localConceptualHostsCount > 1) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
					IDeployCoreValidators.HOSTING_002, ICoreProblemType.UNIT_MULTIPLE_HOSTS,
					DeployCoreMessages.Validator_unit_0_has_ambiguous_hosting_st_,
					new Object[] { unit }, unit);
			reporter.addStatus(status);
//			}
		}
	}

	/**
	 * Validate a member link contained in the unit.
	 * 
	 * @param link
	 *           the member link to be validated.
	 * @param unit
	 *           the unit that contains the member link.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateMemberLink(MemberLink link, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert link != null;
		assert unit != null;
		assert context != null;
		assert reporter != null;

		if (link.getTarget() == null) {
			IDeployStatus status;
			if (link.getTargetURI() != null) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.MEMBER_LINK_004, ICoreProblemType.LINK_TARGET_UNRESOLVABLE,
						DeployCoreMessages.Validator_link_0_target_1_cannot_be_resolved, new Object[] {
								link, link.getTargetURI() }, link);
			} else {
				int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
				status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(severity, IDeployCoreValidators.MEMBER_LINK_001,
								ICoreProblemType.MEMBER_LINK_TARGET_UNDEFINED,
								DeployCoreMessages.Validator_link_0_target_undefined,
								new Object[] { link }, link);
			}
			reporter.addStatus(status);
		} else {
			// Check for a zombie target (removed from topology).
			if (link.getTarget().getTopology() == null) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.MEMBER_LINK_005,
						ICoreProblemType.LINK_TARGET_UNCONTAINED,
						DeployCoreMessages.Validator_link_0_target_uncontained, new Object[] { link },
						link);
				reporter.addStatus(status);
			}

			//
			// Verify that the member link target type is one of the MEMBER
			// requirement dmoTypes
			//
			boolean reqMatch = false;
			boolean reqFound = false;
			for (Iterator iter2 = unit.getOnlyMemberRequirements().iterator(); iter2.hasNext();) {
				Requirement req = (Requirement) iter2.next();
				if (req.getDmoEType() != null) {
					reqFound = true;
					if (req.getDmoEType().isInstance(link.getTarget())) {
						reqMatch = true;
						break;
					}
				}
			}
			if (reqFound && !reqMatch) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.MEMBER_LINK_002,
						ICoreProblemType.MEMBER_LINK_TARGET_INVALID,
						DeployCoreMessages.Validator_unit_0_member_link_target_1_invalid, new Object[] {
								unit, link.getTarget() }, link);
				reporter.addStatus(status);
			}
		}
	}

	/**
	 * Validates the types of capabilities provided by the unit.
	 * <p>
	 * The default implementation uses the type constraints created through
	 * {@link #addCapabilityTypeConstraint(EClass, CapabilityLinkTypes, int, int)}.
	 * 
	 * @param unit
	 *           the unit whose capability types will be validated (see
	 *           {@link Unit#getCapabilities()})
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateCapabilityTypes(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		int[] coverage = new int[unit.getCapabilities().size()];
		if (capabilityTypeConstraintList != null) {
			for (Iterator iter = capabilityTypeConstraintList.iterator(); iter.hasNext();) {
				UnitCapabilityTypeConstraint c = (UnitCapabilityTypeConstraint) iter.next();
				int count = 0;
				int index = 0;
				for (Iterator iter2 = unit.getCapabilities().iterator(); iter2.hasNext();) {
					Capability cap = (Capability) iter2.next();
					if (c.matches(cap)) {
						coverage[index]++;
						count++;
					}
					index++;
				}
				if (count < c.getMin() || count > c.getMax()) {
					int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
					IDeployStatus status = DeployCoreStatusUtil
							.createUnitCapabilityTypeCardinalityInvalidStatus(severity,
									IDeployCoreValidators.CAPABILITY_001, unit, c.getType(), count);
					reporter.addStatus(status);
				}
			}
		}
		if (!getAllowUnexpectedCapabilityTypes()) {
			int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
			for (int i = 0; i < coverage.length; i++) {
				if (coverage[i] == 0) {
					Capability cap = (Capability) unit.getCapabilities().get(i);
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
							IDeployCoreValidators.CAPABILITY_002,
							ICoreProblemType.UNIT_CAPABILITY_TYPE_INVALID,
							DeployCoreMessages.Validator_unit_0_capability_1_invalid, new Object[] { unit,
									cap }, cap);
					reporter.addStatus(status);
				}
			}
		}
	}

	/**
	 * Validates the {@link Requirement#getDmoEType()} types of capability type attributes of
	 * {@link Unit#getRequirements()}.
	 * <p>
	 * The default implementation uses the type constraints created through
	 * {@link #addRequirementTypeConstraint(EClass, RequirementLinkTypes, int, int)}
	 * 
	 * @param unit
	 *           the unit whose requirement capability types will be validated (see
	 *           {@link Unit#getRequirements()})
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateRequirementTypes(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		int[] coverage = new int[unit.getRequirements().size()];
		if (requirementTypeConstraintList != null) {
			for (Iterator iter = requirementTypeConstraintList.iterator(); iter.hasNext();) {
				UnitRequirementTypeConstraint c = (UnitRequirementTypeConstraint) iter.next();
				int count = 0;
				int index = 0;
				for (Iterator iter2 = unit.getRequirements().iterator(); iter2.hasNext();) {
					Requirement req = (Requirement) iter2.next();
					if (c.matches(req)) {
						coverage[index]++;
						count++;
					}
					index++;
				}
				if (count < c.getMin() || count > c.getMax()) {
					int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
					IDeployStatus status = DeployCoreStatusUtil
							.createUnitRequirementTypeCardinalityInvalidStatus(severity,
									IDeployCoreValidators.REQUIREMENT_001, unit, c.getType(), count);
					reporter.addStatus(status);
				}
			}
		}

		if (!getAllowUnexpectedRequirementTypes()) {
			int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
			for (int i = 0; i < coverage.length; i++) {
				if (coverage[i] == 0) {
					Requirement req = (Requirement) unit.getRequirements().get(i);
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
							IDeployCoreValidators.REQUIREMENT_002,
							ICoreProblemType.UNIT_REQUIREMENT_TYPE_INVALID,
							DeployCoreMessages.Validator_unit_0_requirement_1_type_invalid, new Object[] {
									unit, req }, req);
					reporter.addStatus(status);
				}
			}
		}
	}

	/**
	 * Returns true if the consumed hosting requirement of hosted is matched to the provided hosting
	 * capability of the host.
	 * <p>
	 * Core implementation returns true if all requirement expressions hold.
	 * 
	 * @param requirement
	 *           the consumed hosting requirement of the hosted unit.
	 * @param hosted
	 *           the hosted unit.
	 * @param capability
	 *           the provided hosting capability of the host unit.
	 * @param host
	 *           the host unit.
	 * 
	 * @return the status of the match.
	 */
	protected IStatus checkHostingMatch(Requirement requirement, Unit hosted, Capability capability,
			Unit host) {
		assert hosted != null;
		assert host != null;
		assert requirement.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL
				|| requirement.getLinkType() == RequirementLinkTypes.ANY_LITERAL;
		assert capability.getLinkType() == CapabilityLinkTypes.HOSTING_LITERAL
				|| capability.getLinkType() == CapabilityLinkTypes.ANY_LITERAL;
		return RequirementUtil.validate(requirement, new ReqEvaluationContext(capability));
	}

	/**
	 * Checks if a requirement matches a capability.
	 * <p>
	 * The core implementation checks that the consumed is a supertype of the provided capability.
	 * Subtypes may override to support richer matching semantics.
	 * 
	 * @param link
	 *           the link between the capabilities.
	 * @param sourceUnit
	 *           the source unit of the dependency link.
	 * @param targetUnit
	 *           the target unit of the dependency link.
	 * @param context
	 *           the validation context.a
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateDependencyLinkMatch(DependencyLink link, Unit sourceUnit,
			Unit targetUnit, IDeployValidationContext context, IDeployReporter reporter) {
		assert sourceUnit != null;
		assert targetUnit != null;
		assert context != null;
		Requirement req = link.getSource();
		Capability cap = link.getTarget();

		if (req != null && cap != null) {
			IStatus status = RequirementUtil.validate(req, new ReqEvaluationContext(cap));
			if (status.isOK()) {
				return;
			}
			reportStatus(reporter, status);
		} else {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.DEPENDENCY_LINK_002,
					ICoreProblemType.DEPENDENCY_LINK_ENDPOINT_TYPE_MISMATCH,
					DeployCoreMessages.Validator_dependency_link_0_endpoints_do_not_match,
					new Object[] { link }, link);
			reporter.addStatus(status);
		}
	}

	/**
	 * Validates all the attributes of a {@link DeployModelObject}.
	 * 
	 * @param object
	 *           the deploy model object whose attributes should be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateAttributes(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		if (attributeValidatorList != null) {
			for (Iterator iter = attributeValidatorList.iterator(); iter.hasNext();) {
				IDeployAttributeValidator validator = (IDeployAttributeValidator) iter.next();
				try {
					if (validator.appliesTo(object, context)) {
						validator.validate(object, context, reporter);
					}
				} catch (Throwable e) {
					DeployCorePlugin.logError(0, DeployNLS.bind(DeployCoreMessages.Validator_0_failed,
							validator.getValidatorID()), e);
				}
			}
		}
	}

	/**
	 * Validates all the constraints of the Unit and all its contained model objects (recursive),
	 * excepting Type Constraints, AttributeValue Constraint, Cardinality Constraints and
	 * RequirementExpressions on Requirements, which are validated during link validation. Validation
	 * of child constraints of a constraint is done by the parent constraint (no recursing into
	 * constraints.)
	 * 
	 * @param unit
	 *           the unit whose constraints should be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateConstraints(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		List<DeployModelObject> stack = new LinkedList<DeployModelObject>();
		stack.add(unit);
		while (stack.size() > 0) {
			DeployModelObject object = stack.remove(0);
			for (DeployModelObject dmo : (List<DeployModelObject>) object.getContainedModelObjects()) {
				// Don't validate child constraints on constraints, they will be validated by parent constraints
				if (!(dmo instanceof Constraint)) {
					stack.add(dmo);
				}
			}
			ConstraintUtil.validateChildConstraintsInParentContext(object, context, reporter);
		}
	}

	/**
	 * Validates the {@link Unit#getPublishState()} value.
	 * <p>
	 * Units in publish state {@link PublishState#NOT_PUBLISHED} that are not
	 * {@link InstallState#INSTALLED} cannot host units whose state is {@link PublishState#PUBLISH}.
	 * 
	 * @param unit
	 *           the unit whose {@link Unit#getPublishState()} will be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateUnitPublishState(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		int failCount = 0;
		if (unit.getPublishIntent() == PublishIntent.DO_NOT_PUBLISH_LITERAL
				&& unit.getInitInstallState() != InstallState.INSTALLED_LITERAL) {
			for (Iterator iter = unit.getHostingLinks().iterator(); iter.hasNext();) {
				HostingLink link = (HostingLink) iter.next();
				Unit hostedUnit = link.getTarget();
				if (hostedUnit != null
						&& hostedUnit.getPublishIntent() == PublishIntent.PUBLISH_LITERAL) {
					failCount++;
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
							IStatus.ERROR, IDeployCoreValidators.PUBLISH_STATE_001,
							ICoreProblemType.UNIT_HOST_DO_NOT_PUBLISH,
							DeployCoreMessages.Validator_unit_0_host_1_not_published, new Object[] { unit,
									hostedUnit }, hostedUnit, CorePackage.eINSTANCE.getUnit_PublishIntent(),
							PublishIntent.DO_NOT_PUBLISH_LITERAL);
					reporter.addStatus(status);

				}
			}
		}

		if (failCount > 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.WARNING, IDeployCoreValidators.PUBLISH_STATE_001,
					ICoreProblemType.UNIT_DO_NOT_PUBLISH_HOSTS_PUBLISH_UNITS,
					DeployCoreMessages.Validator_unit_0_do_not_publish_hosts_publish_units,
					new Object[] { unit }, unit, CorePackage.eINSTANCE.getUnit_PublishIntent());
			reporter.addStatus(status);
		}
	}

	/**
	 * Validates a requirement consumed by the unit.
	 * 
	 * @param req
	 *           the provided capability to be validated.
	 * @param unit
	 *           the unit providing the capability.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateRequirement(Requirement req, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		validateAttributes(req, context, reporter);

		//
		// Validate DMO type deserialization
		//
		if (req.getDmoEType() != null) {
			boolean error = false;
			try {
				EClass dmoType = req.getDmoEType();
				if (dmoType == null) {
					error = true;
				}
			} catch (Throwable e) {
				error = true;
			}
			if (error) {
				IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						IStatus.ERROR, IDeployCoreValidators.REQUIREMENT_DMO_ETYPE_001,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_value_2_invalid,
						new Object[] { req, CorePackage.eINSTANCE.getRequirement_DmoType(),
								req.getDmoEType() }, req, CorePackage.eINSTANCE.getRequirement_DmoType());
				reporter.addStatus(status);
			}
		}

		//
		// Dependency requirement validation
		//
		List<DependencyLink> linkList = TopologyUtil.getImmediateDependencyLinksOut(req, false);
		if (req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL
				|| req.getLinkType() == RequirementLinkTypes.ANY_LITERAL) {

			// may be null
			Capability target = ValidatorUtils.discoverDependencyLinkTarget(req, req.getTopology(),
					true, context.getProgressMonitor());

			int linkCount = linkList.size();
			if (linkCount == 0) {
				if (target == null) {
					if (req.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL) {
						if (req.getUse() == RequirementUsage.REQUIRED_LITERAL) {
							int severity = unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
							IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
									severity, IDeployCoreValidators.DEPENDENCY_LINK_003,
									ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED,
									DeployCoreMessages.Requirement_0_dependency_link_undefined,
									new Object[] { req }, req);
							reporter.addStatus(status);
						} else if (req.getUse() == RequirementUsage.OPTIONAL_LITERAL) {
							IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
									IStatus.INFO, IDeployCoreValidators.DEPENDENCY_LINK_003,
									ICoreProblemType.UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED,
									DeployCoreMessages.Optional_Requirement_0_dependency_link_undefined,
									new Object[] { req }, req);
							reporter.addStatus(status);
						}
					}
				} else {
					validateDependencyLinkTarget(target, req, null, unit, context, reporter);
				}
			} else if (linkCount == 1) {// && ((target == null) || (target.equals(linkList.get(0).getTarget())))) {
				validateDependencyLink(linkList.get(0), unit, context, reporter);
			} else {
				// Too many dependency links
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.DEPENDENCY_LINK_010,
						ICoreProblemType.REQUIREMENT_HAS_MULTIPLE_DEPENDENCIES,
						DeployCoreMessages.Validator_unit_0_requirement_1_has_multiple_dependencies,
						new Object[] { unit, req }, req);
				reporter.addStatus(status);
			}
		} else if (linkList.size() > 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE
					.createDeployStatus(
							IStatus.ERROR,
							IDeployCoreValidators.DEPENDENCY_LINK_001,
							ICoreProblemType.DEPENDENCY_LINK_SOURCE_INVALID,
							DeployCoreMessages.Validator_unit_0_requirement_1_link_type_forbids_dependency_link_2,
							new Object[] { unit, req, req.getLink() }, req);
			reporter.addStatus(status);
		}

		//
		// Member requirement validation
		//
		if (req.getLinkType() == RequirementLinkTypes.MEMBER_LITERAL) {
			if (req.getDmoEType() != null
					&& !CorePackage.eINSTANCE.getUnit().isSuperTypeOf(req.getDmoEType())) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
						IStatus.ERROR, IDeployCoreValidators.MEMBER_REQUIREMENT_001,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Validator_unit_0_requirement_1_dmoType_should_be_unit_type,
						new Object[] { unit, req }, req, CorePackage.eINSTANCE.getRequirement_DmoType());
				reporter.addStatus(status);
			}

			IStatus reqStatus = RequirementUtil.validate(req, new ReqEvaluationContext(unit));
			if (!reqStatus.isOK()) {
				reportStatus(reporter, reqStatus);
			}
		}
	}

	/**
	 * Reports all {@link IDeployStatus} contained in the status using the reporter, and logs the
	 * rest.
	 * 
	 * @param reporter
	 *           used to report deploy status.
	 * @param status
	 *           the status to be reported, along all its children.
	 */
	protected void reportStatus(IDeployReporter reporter, IStatus status) {
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus reqStatus = (IStatus) iter.next();
			if (reqStatus instanceof IDeployStatus) {
				reporter.addStatus((IDeployStatus) reqStatus);
			} else if (reqStatus instanceof MultiStatus) {
				// ignore
			} else {
				DeployCorePlugin.log(reqStatus);
			}
		}
	}

	/**
	 * Validates a capability provided by the unit.
	 * 
	 * @param capability
	 *           the provided capability to be validated.
	 * @param unit
	 *           the unit providing the capability.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		validateAttributes(capability, context, reporter);

		if (capabilityValidatorList != null) {
			for (Iterator iter = capabilityValidatorList.iterator(); iter.hasNext();) {
				IUnitCapabilityValidator validator = (IUnitCapabilityValidator) iter.next();
				if (validator.appliesTo(capability, unit, context)) {
					validator.validateCapability(capability, unit, context, reporter);
				}
			}
		}
	}

	/**
	 * Validates a hosting link contained in a unit (to a unit that is hosted by this unit).
	 * 
	 * @param link
	 *           the link to be validated.
	 * @param unit
	 *           the hosting unit.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateHostingLink(HostingLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert link != null;
		assert unit != null;
		validateAttributes(link, context, reporter);

		Unit host = link.getHost();
		Unit hosted = link.getHosted();

		if (hosted == null) {
			IDeployStatus status;

			if (link.getTargetURI() != null) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.HOSTING_LINK_007,
						ICoreProblemType.LINK_TARGET_UNRESOLVABLE,
						DeployCoreMessages.Validator_link_0_target_1_cannot_be_resolved, new Object[] {
								link, link.getTargetURI() }, link);
			} else {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
						IDeployCoreValidators.HOSTING_LINK_003,
						ICoreProblemType.HOSTING_LINK_TARGET_UNDEFINED,
						DeployCoreMessages.Validator_hosting_link_0_target_undefined,
						new Object[] { link }, link);
			}
			reporter.addStatus(status);
		}

		if (host == null) {
			IDeployStatus status = DeployCoreStatusUtil.createContainerUndefinedStatus(IStatus.ERROR,
					IDeployCoreValidators.HOSTING_LINK_004, link);
			reporter.addStatus(status);
		} else if (!host.equals(link.getParent()) && link.getParent() instanceof Unit) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.WARNING, IDeployCoreValidators.HOSTING_LINK_001,
					ICoreProblemType.HOSTING_LINK_SOURCE_IS_NOT_CONTAINER,
					DeployCoreMessages.Validator_hosting_link_0_container_1_is_not_the_host_2,
					new Object[] { link, unit, host }, link);
			reporter.addStatus(status);
		}

		// Check for a zombie target hosted (removed from topology).
		if (hosted != null && hosted.getTopology() == null) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.HOSTING_LINK_008, ICoreProblemType.LINK_TARGET_UNCONTAINED,
					DeployCoreMessages.Validator_link_0_target_uncontained, new Object[] { link }, link);
			reporter.addStatus(status);
		}

		if (host == null || hosted == null) {
			return;
		}

		if (hosted.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			if (host.getInitInstallState() != InstallState.INSTALLED_LITERAL) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.HOSTING_LINK_002,
						ICoreProblemType.UNIT_HOST_NOT_INSTALLED,
						DeployCoreMessages.Validator_unit_0_installed_but_host_1_not, new Object[] {
								hosted, host }, hosted);
				reporter.addStatus(status);
			} else {
				// Check if installed host will be uninstalled
				if (hosted.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL
						&& host.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.ERROR, IDeployCoreValidators.HOSTING_LINK_009,
							ICoreProblemType.UNIT_HOST_TO_BE_UNINSTALLED,
							DeployCoreMessages.Validator_unit_0_installed_but_host_1_will_be_uninstalled,
							new Object[] { hosted, host }, hosted);
					reporter.addStatus(status);
				}
			}
			// No further validation for hosted units that are already
			// installed.
			return;
		}

		if (hosted.getGoalInstallState() == InstallState.INSTALLED_LITERAL
				&& host.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.HOSTING_LINK_010,
					ICoreProblemType.UNIT_HOST_TO_BE_UNINSTALLED,
					DeployCoreMessages.Validator_unit_0_host_1_will_be_uninstalled, new Object[] {
							hosted, host }, hosted);
			reporter.addStatus(status);
		}

		validateHostingLinkMatch(link, unit, context, reporter);

		// added for M3 to support hosting of software components (without a
		// source or hosting requirements) to conceptual nodes
		// re-evaluate post M3
		if (hosted instanceof SoftwareComponent) {
			List requirements = unit.getOnlyHostingRequirements();
			int requirmentSize = 0;
			if (requirements != null) {
				requirmentSize = requirements.size();
				if (requirmentSize == 0) {
					return;
				}
			}
		}

		if (hosted.getHostingOrAnyRequirements().size() == 0) {
			String linkName = link.getDisplayName();
			linkName = linkName == null || linkName.length() == 0 ? link.getName() : linkName;
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE
					.createDeployStatus(
							IStatus.ERROR,
							IDeployCoreValidators.HOSTING_LINK_006,
							ICoreProblemType.HOSTING_LINK_TARGET_HAS_NO_HOSTING_REQUIREMENTS,
							DeployCoreMessages.Validator_hosting_link_0_target_unit_1_consumes_no_hosting_requirements,
							new Object[] { linkName, hosted.getCaptionProvider().title(hosted) }, link);
			reporter.addStatus(status);
		}
	}

	/**
	 * Validates that the hosting requirements and capabilities of the hosting link source and target
	 * match.
	 * 
	 * @param link
	 *           the link to be validated.
	 * @param unit
	 *           the hosting unit.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateHostingLinkMatch(HostingLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert unit != null;
		assert context != null;

		// AT 4/1/07:  Evaluate final realizations
		Unit host = (Unit) RealizationLinkUtil.getFinalRealization(link.getHost());
		Unit hosted = (Unit) RealizationLinkUtil.getFinalRealization(link.getHosted());
		// Unit host = link.getHost();
		// Unit hosted = link.getHosted();

		if (CorePackage.Literals.CONCEPTUAL_NODE.isInstance(host)) {
			int size = host.getHostingOrAnyCapabilities().size();
			if (0 == size) {
				return;
			}
		}
		for (Iterator iter = hosted.getHostingOrAnyRequirements().iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			// MK 4/18/2007 Defect 
			if (req.getUse().equals(RequirementUsage.OPTIONAL_LITERAL)) {
				// ignore if optional
				continue;
			}

			// Constraint validation context is host
			// ConstraintUtil.validateChildConstraintsOnNonConstraintDmo(req, host, link, context,
			//	reporter);

			boolean requirementMatched = false;

			IStatus lastMatchStatus = null;
			for (Iterator iter2 = host.getHostingOrAnyCapabilities().iterator(); iter2.hasNext();) {

				Capability providedCapability = (Capability) iter2.next();
				EClass requiredCapabilityType = req.getDmoEType();
				if (requiredCapabilityType == null) {
					// if no dmoType is provided in Requirement, treat it as a requirement for core.Capability
					requiredCapabilityType = CorePackage.eINSTANCE.getCapability();
				}
				// AT 4/11/07 relaxed hosting rules
				if (requiredCapabilityType.isInstance(providedCapability)
						|| ValidatorUtils.getUnit(providedCapability).isConceptual()
						&& providedCapability.eClass().isSuperTypeOf(requiredCapabilityType)) {
					lastMatchStatus = checkHostingMatch(req, hosted, providedCapability, host);
					if (lastMatchStatus != null && lastMatchStatus.isOK()) {
						requirementMatched = true;
						break;
					}
				}
			}

			if (!requirementMatched) {
				IDeployStatus status = null;
				if (lastMatchStatus == null) {
					status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
							IDeployCoreValidators.HOSTING_004,
							ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
							DeployCoreMessages.Validator_hosting_link_0_requirement_1_does_not_match,
							new Object[] { link, req }, link);
					reporter.addStatus(status);
				} else {
					if (lastMatchStatus instanceof IDeployStatus) {
						status = DeployCoreStatusFactory.INSTANCE.createDeployWrapperStatus(
								IStatus.ERROR, IDeployCoreValidators.HOSTING_004,
								ICoreProblemType.HOSTING_LINK_TARGET_INVALID, lastMatchStatus.getMessage(),
								null, link, (IDeployStatus) lastMatchStatus);
						reporter.addStatus(status);
					} else if (lastMatchStatus.isMultiStatus()) {
						for (Iterator<IDeployStatus> dsIter = new DeployStatusIterator(lastMatchStatus); dsIter
								.hasNext();) {
							IDeployStatus curStatus = dsIter.next();
							reporter.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployWrapperStatus(
									IStatus.ERROR, IDeployCoreValidators.HOSTING_004,
									ICoreProblemType.HOSTING_LINK_TARGET_INVALID, curStatus.getMessage(),
									null, link, curStatus));
						}
					} else {
						status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
								IDeployCoreValidators.HOSTING_004,
								ICoreProblemType.HOSTING_LINK_TARGET_INVALID, lastMatchStatus.getMessage(),
								null, link);
						reporter.addStatus(status);
					}
				}
				/*----
				 IDeployStatus status = null;
				 if (lastMatchStatus == null) {
				 status = DeployCoreStatusFactory.INSTANCE
				 .createDeployStatus(
				 IStatus.ERROR,
				 IDeployCoreValidators.HOSTING_004,
				 ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
				 DeployCoreMessages.Validator_hosting_link_0_requirement_1_does_not_match,
				 new Object[] { link, req }, link);
				 } else {
				 if (lastMatchStatus instanceof IDeployStatus) {
				 status = DeployCoreStatusFactory.INSTANCE
				 .createDeployWrapperStatus(
				 IStatus.ERROR,
				 IDeployCoreValidators.HOSTING_004,
				 ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
				 lastMatchStatus.getMessage(), null,
				 link, (IDeployStatus) lastMatchStatus);
				 } else {
				 status = DeployCoreStatusFactory.INSTANCE
				 .createDeployStatus(
				 IStatus.ERROR,
				 IDeployCoreValidators.HOSTING_004,
				 ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
				 lastMatchStatus.getMessage(), null,
				 link);
				 }
				 }
				 1.34.2.5
				 */
			}
		}
	}

	/**
	 * Validates a logical link contained in a unit.
	 * 
	 * @param link
	 *           the link to be validated.
	 * @param unit
	 *           the hosting unit.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateConstraintLink(ConstraintLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert unit != null;
		validateAttributes(link, context, reporter);

		DeployModelObject source = link.getSource();
		DeployModelObject target = link.getTarget();

		if (source == null) {
			IDeployStatus status;
			if (link.getTargetURI() != null) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONSTRAINT_LINK_003,
						ICoreProblemType.LINK_SOURCE_UNRESOLVABLE,
						DeployCoreMessages.Validator_link_0_source_1_cannot_be_resolved, new Object[] {
								link, link.getTargetURI() }, link);
			} else {
				status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(IStatus.ERROR, IDeployCoreValidators.CONSTRAINT_LINK_004,
								ICoreProblemType.LINK_SOURCE_UNDEFINED,
								DeployCoreMessages.Validator_link_0_source_undefined,
								new Object[] { link }, link);
			}
			reporter.addStatus(status);
		}

		// Check for a zombie source (removed from topology).
		if (source != null && source.getTopology() == null) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.CONSTRAINT_LINK_005, ICoreProblemType.LINK_SOURCE_UNCONTAINED,
					DeployCoreMessages.Validator_link_0_source_uncontained, new Object[] { link }, link);
			reporter.addStatus(status);
		}

		if (target == null) {
			IDeployStatus status;
			if (link.getTargetURI() != null) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.CONSTRAINT_LINK_001,
						ICoreProblemType.LINK_TARGET_UNRESOLVABLE,
						DeployCoreMessages.Validator_link_0_target_1_cannot_be_resolved, new Object[] {
								link, link.getTargetURI() }, link);
			} else {
				status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(IStatus.ERROR, IDeployCoreValidators.CONSTRAINT_LINK_002,
								ICoreProblemType.LINK_TARGET_UNDEFINED,
								DeployCoreMessages.Validator_link_0_target_undefined,
								new Object[] { link }, link);
			}
			reporter.addStatus(status);
		}

		// Check for a zombie target (removed from topology).
		if (target != null && target.getTopology() == null) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.CONSTRAINT_LINK_006, ICoreProblemType.LINK_TARGET_UNCONTAINED,
					DeployCoreMessages.Validator_link_0_target_uncontained, new Object[] { link }, link);
			reporter.addStatus(status);
		}

		if (constraintLinkValidatorList != null) {
			for (Iterator iter2 = constraintLinkValidatorList.iterator(); iter2.hasNext();) {
				IConstraintLinkValidator validator = (IConstraintLinkValidator) iter2.next();
				try {
					validator.validate(link, context, reporter);
				} catch (Throwable e) {
					DeployCorePlugin.logError(0, DeployNLS.bind(DeployCoreMessages.Validator_0_failed,
							validator.getValidatorID()), e);
				}
			}
		}
	}

	/**
	 * Validates the dependency link.
	 * 
	 * @param link
	 *           the link to be validated.
	 * @param unit
	 *           the unit in which the link is indirectly contained.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateDependencyLink(DependencyLink link, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		validateAttributes(link, context, reporter);

		//
		// Validate that link source and targets are defined
		//
		Requirement req = link.getSource();
		if (req == null) {
			IDeployStatus status = DeployCoreStatusUtil.createContainerUndefinedStatus(IStatus.ERROR,
					IDeployCoreValidators.DEPENDENCY_LINK_004, link);
			reporter.addStatus(status);
		}
		Capability cap = link.getTarget();
		if (cap == null) {
			IDeployStatus status;
			if (link.getTargetURI() != null) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.DEPENDENCY_LINK_008,
						ICoreProblemType.LINK_TARGET_UNRESOLVABLE,
						DeployCoreMessages.Validator_link_0_target_1_cannot_be_resolved, new Object[] {
								link, link.getTargetURI() }, link);
			} else {
				status = DeployCoreStatusFactory.INSTANCE
						.createDeployStatus(IStatus.ERROR, IDeployCoreValidators.DEPENDENCY_LINK_005,
								ICoreProblemType.DEPENDENCY_LINK_TARGET_UNDEFINED,
								DeployCoreMessages.Validator_link_0_target_undefined,
								new Object[] { link }, link);
			}
			reporter.addStatus(status);
			return;
		}

		// Check for a zombie target (removed from topology).
		if (cap.getTopology() == null) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.DEPENDENCY_LINK_009, ICoreProblemType.LINK_TARGET_UNCONTAINED,
					DeployCoreMessages.Validator_link_0_target_uncontained, new Object[] { link }, link);
			reporter.addStatus(status);
			return;
		}

		Unit targetUnit = ValidatorUtils.getUnit(cap);
		if (targetUnit == null) {
			IDeployStatus status = DeployCoreStatusUtil.createContainerUndefinedStatus(IStatus.ERROR,
					IDeployCoreValidators.DEPENDENCY_LINK_006, link);
			reporter.addStatus(status);
		}

		if (cap.getLinkType() != CapabilityLinkTypes.DEPENDENCY_LITERAL
				&& cap.getLinkType() != CapabilityLinkTypes.ANY_LITERAL) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.DEPENDENCY_LINK_007,
					ICoreProblemType.DEPENDENCY_LINK_TARGET_INVALID,
					DeployCoreMessages.Validator_dependency_link_0_target_1_is_not_valid, new Object[] {
							link, link.getTarget() }, link);
			reporter.addStatus(status);
		}

		// Validate target
		// AT 4/11/07 use the final realization of the target capability.
		Capability finalCap = (Capability) RealizationLinkUtil.getImplicitFinalRealization(cap);
		validateDependencyLinkTarget(finalCap, req, link, unit, context, reporter);
	}

	/**
	 * Validates the target capability of a dependency link.
	 * <p>
	 * The dependency link is not passed as an argument, because the capability may have been
	 * discovered, and thus no link may exist.
	 * 
	 * @param cap
	 *           the dependency link target capability.
	 * @param req
	 *           the dependency link source requirement.
	 * @param link
	 *           the dependency link (may be null if discovered).
	 * @param sourceUnit
	 *           the unit that contains the source requirement.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateDependencyLinkTarget(Capability cap, Requirement req,
			DependencyLink link, Unit sourceUnit, IDeployValidationContext context,
			IDeployReporter reporter) {
		DeployModelObject statusContext = link != null ? link : req != null ? req : sourceUnit;

		if (cap == null) {
			return;
		}

		if (req == null) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.DEPENDENCY_LINK_002,
					ICoreProblemType.DEPENDENCY_LINK_ENDPOINT_TYPE_MISMATCH,
					DeployCoreMessages.Validator_dependency_link_0_endpoints_do_not_match,
					new Object[] { statusContext }, statusContext);
			reporter.addStatus(status);
			return;
		}

		//
		// Validate that source and targets match
		//
		IStatus status = RequirementUtil.validate(req, new ReqEvaluationContext(cap));
		if (!status.isOK()) {
			reportStatus(reporter, status);
		}

		//
		// Invoke constraint validator
		// Constraint validation context is dependency link target capability.
		// 
		ConstraintUtil.validateChildConstraintsOnRequirement(req, cap, link, context, reporter);

		//
		// Invoke dependency link validators
		//
		if (dependencyLinkValidatorList != null) {
			for (Iterator iter = dependencyLinkValidatorList.iterator(); iter.hasNext();) {
				IDependencyLinkValidator validator = (IDependencyLinkValidator) iter.next();
				if (!validator.appliesTo(req, cap, link, context)) {
					continue;
				}
				try {
					validator.validate(req, cap, link, context, reporter);
				} catch (Throwable e) {
					DeployCorePlugin.logError(0, DeployNLS.bind(DeployCoreMessages.Validator_0_failed,
							validator.getValidatorID()), e);
				}
			}
		}
	}

	/**
	 * Returns the first capability of the specified type, null if none exists.
	 * 
	 * @param list
	 *           a list of capabilities (List<Capability>)
	 * @param type
	 *           the type of a capability.
	 * @return the first capability that is a subtype of the type.
	 */
	protected Capability getFirstCapability(List list, EClass type) {
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Capability capability = (Capability) iter.next();
			if (type.isSuperTypeOf(capability.getEObject().eClass())) {
				return capability;
			}
		}

		return null;
	}

	/**
	 * Returns the number of instances of capabilities in the list that are subtypes of the type.
	 * 
	 * @param list
	 *           a list of capabilities (List<Capability>)
	 * @param type
	 *           the type of a capability.
	 * @return the capability count.
	 */
	protected int getCapabilityCount(List list, EClass type) {
		int count = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Capability capability = (Capability) iter.next();
			if (type.isSuperTypeOf(capability.getEObject().eClass())) {
				count++;
			}
		}

		return count;
	}

	/**
	 * @return true if capability types that are not covered by
	 *         {@link #addCapabilityTypeConstraint(EClass, CapabilityLinkTypes, int, int)} should be
	 *         allowed, false if they should trigger an error status.
	 * @deprecated
	 */
	public boolean getAllowUnexpectedCapabilityTypes() {
		return allowUnexpectedCapabilityTypes;
	}

	/**
	 * Configure whether requirement types that are not covered by
	 * {@link #addRequirementTypeConstraint(EClass, RequirementLinkTypes, int, int)} should be
	 * allowed, false if they should trigger an error status.
	 * 
	 * @param allowUnexpectedCapabilityTypes
	 * @deprecated
	 */
	public void setAllowUnexpectedCapabilityTypes(boolean allowUnexpectedCapabilityTypes) {
		this.allowUnexpectedCapabilityTypes = allowUnexpectedCapabilityTypes;
	}

	/**
	 * @return true if requirement types that are not covered by
	 *         {@link #addRequirementTypeConstraint(EClass, RequirementLinkTypes, int, int)} should
	 *         be allowed, false if they should trigger an error status.
	 * @deprecated
	 */
	public boolean getAllowUnexpectedRequirementTypes() {
		return allowUnexpectedRequirementTypes;
	}

	/**
	 * Configure whether requirement types that are not covered by
	 * {@link #addRequirementTypeConstraint(EClass, RequirementLinkTypes, int, int)} be allowed,
	 * false if they should trigger an error status.
	 * 
	 * @param allowUnexpectedRequirementTypes
	 *           true if unexpected types should be allowed.
	 * @deprecated
	 */
	public void setAllowUnexpectedRequirementTypes(boolean allowUnexpectedRequirementTypes) {
		this.allowUnexpectedRequirementTypes = allowUnexpectedRequirementTypes;
	}

	/**
	 * Validate the artifact of a unit.
	 * 
	 * @param unit
	 *           the unit containing the artifact.
	 * @param artifact
	 *           the artifact to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report error status.
	 */
	protected void validateArtifact(Artifact artifact, Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		validateAttributes(artifact, context, reporter);

		if (artifact instanceof FileArtifact) {
			FileArtifact fileArtifact = (FileArtifact) artifact;
			if (fileArtifact.getFileURIs().size() == 0) {
				if (unit.getInitInstallState() != InstallState.INSTALLED_LITERAL) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
							IStatus.ERROR, IDeployCoreValidators.ARTIFACT_001,
							ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
							DeployCoreMessages.Validator_unit_0_artifact_1_has_no_URIs, new Object[] {
									unit, artifact }, artifact, CorePackage.eINSTANCE
									.getFileArtifact_FileURIs());
					reporter.addStatus(status);
				}
			} else {
				for (Iterator iter = fileArtifact.getFileURIs().iterator(); iter.hasNext();) {
					String uri = (String) iter.next();
					validateFileArtifactURI(uri, fileArtifact, unit, context, reporter);
				}
			}
		}
	}

	/**
	 * Validate the URI of a {@link FileArtifact} contained in the {@link Module#getArtifacts()}.
	 * 
	 * @param uri
	 *           the URI to be validated.
	 * @param artifact
	 *           the file artifact whose URI is to be validated.
	 * @param unit
	 *           the unit containing the artifact.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report error status.
	 */
	protected void validateFileArtifactURI(String uri, FileArtifact artifact, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert context != null;
		if (uri == null || uri.length() == 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, IDeployCoreValidators.ARTIFACT_002,
					ICoreProblemType.FILE_ARTIFACT_URI_INVALID,
					DeployCoreMessages.Validator_unit_0_artifact_1_invalid_uri_2, new Object[] { unit,
							artifact, uri }, artifact, CorePackage.eINSTANCE.getFileArtifact_FileURIs());
			reporter.addStatus(status);
		}
		// Syntax checking of the URI is delegated to the subtypes.
	}

	/**
	 * Validates the realization of a conceptual unit.
	 * 
	 * @param unit
	 *           the conceptual unit to be validated.
	 * @param context
	 *           the topology-level validation context (used or indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	protected void validateUnitRealization(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		List sourceLinks = ValidatorUtils.getSourceRealizationLinks(unit);
		List targetLinks = ValidatorUtils.getTargetRealizationLinks(unit);

		if (unit.isConceptual()) {
			if (sourceLinks.size() == 0) {
//				String ds = null;
//				if (unit.getEditTopology() != null) {
//					ds = unit.getEditTopology().getDecoratorSemantic();
//				}
//				// TODO FIXME remove explicit reasoning over decorator
//				// semantic
//				// by enabling/disabling ValidatorID in plugin.xml
//				if (IDecoratorSemanticConstants.DeploymentDS_ID.equals(ds)
//						|| IDecoratorSemanticConstants.InfrastructureDS_ID.equals(ds)) {
				// severity overide by contract instead - defect #3070
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.CONCEPTUAL_UNIT_001,
						ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED,
						DeployCoreMessages.Validator_conceptual_unit_0_not_realized,
						new Object[] { unit }, unit);
				reporter.addStatus(status);
//				}
			}
// Disabled as of V8M5
//			else if (sourceLinks.size() == 1) {
//			} else {
//				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
//						IStatus.ERROR, IDeployCoreValidators.CONCEPTUAL_UNIT_003,
//						ICoreProblemType.CONCEPTUAL_UNIT_HAS_MULTIPLE_REALIZATION_LINKS,
//						DeployCoreMessages.Validator_conceptual_unit_0_has_multiple_realization_links,
//						new Object[] { unit }, unit);
//				reporter.addStatus(status);
//			} 

		} else {
			// concrete unit should not be the source of any realization links.
			for (int i = 0; i < sourceLinks.size(); i++) {
				RealizationLink link = (RealizationLink) sourceLinks.get(i);
				if (!unit.isConceptual()) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.ERROR, IDeployCoreValidators.CONCEPTUAL_UNIT_002,
							ICoreProblemType.NON_CONCEPTUAL_UNIT_REALIZED,
							DeployCoreMessages.Validator_non_conceptual_unit_0_realized_in_link_1,
							new Object[] { unit, link }, link);
					reporter.addStatus(status);
				}
			}

			if (targetLinks.size() > 0) {
				if (ValidatorUtils.getImmediateHosts(unit).size() > 1) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.INFO, IDeployCoreValidators.CONCEPTUAL_UNIT_004,
							ICoreProblemType.REALIZATION_HAS_AMBIGUOUS_HOSTING_STACK,
							DeployCoreMessages.Validator_unit_0_has_ambiguous_hosting_st_,
							new Object[] { unit }, unit);
					reporter.addStatus(status);
				}
			}
		}
	}

	/**
	 * Validates the binding information of a unit
	 * 
	 * @param unit
	 *           the unit to be validated.
	 * @param context
	 *           the topology-level validation context (used or indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	protected void validateUnitBinding(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {

		// TODO
		if (unit.isBound()) {
			String origin = unit.getOrigin();
			UnitProvider prov = UnitLifeCycleManager.INSTANCE.getUnitProviderByName(origin);
			if (prov == null) {
				// TODO unknown provider error
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.WARNING, IDeployCoreValidators.BOUND_UNIT_001,
						ICoreProblemType.BOUND_UNIT_PROVIDER_NOT_FOUND,
						DeployCoreMessages.Validator_provider_0_specified_in_unit_1_not_found,
						new Object[] { origin, unit }, unit);
				reporter.addStatus(status);
			}
		}
	}

	/**
	 * Validates the realization (if any) of a capability.
	 * 
	 * @param cap
	 *           the capability to be validated.
	 * @param context
	 *           the topology-level validation context (used for indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	protected void validateCapabilityRealization(Capability cap, IDeployValidationContext context,
			IDeployReporter reporter) {

		List sourceLinks = ValidatorUtils.getSourceRealizationLinks(cap);
		if (sourceLinks.size() == 0) {
			return;
		} else if (sourceLinks.size() == 1) {
			RealizationLink link = (RealizationLink) sourceLinks.get(0);
			Unit unit = ValidatorUtils.getUnit(cap);
			if (unit != null) {
				if (!unit.isConceptual()) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.CAP_ON_CONCEPTUAL_UNIT_001,
									ICoreProblemType.CAPABILITY_ON_NON_CONCEPTUAL_UNIT_REALIZED,
									DeployCoreMessages.Validator_capability_0_on_non_conceptual_unit_realized_in_link_1,
									new Object[] { cap, link }, cap);
					reporter.addStatus(status);
				}
				List unitSourceLinks = ValidatorUtils.getSourceRealizationLinks(unit);
				if (unitSourceLinks.size() == 0) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.REALIZED_CAP_ON_NON_REALIZED_UNIT_001,
									ICoreProblemType.REALIZED_CAPABILITY_ON_NON_REALIZED_UNIT,
									DeployCoreMessages.Validator_realized_capability_0_on_non_realized_unit_realized_in_link_1,
									new Object[] { cap, link }, cap);
					reporter.addStatus(status);
				} else if (unitSourceLinks.size() > 0) {
					RealizationLink unitLink = (RealizationLink) unitSourceLinks.get(0);
					// Compare target of link and unitlink					
					if (unitLink.getTarget() != null
							&& !unitLink.getTarget().equals(ValidatorUtils.getUnit(link.getTarget()))) {
						// Report parent's realization target not same as capability's realization target
						IDeployStatus status = DeployCoreStatusFactory.INSTANCE
								.createDeployStatus(
										IStatus.ERROR,
										IDeployCoreValidators.CAPABILITY_REALIZATION_002,
										ICoreProblemType.CAPABILITY_REALIZATION_TARGET_INCONSISTENT,
										DeployCoreMessages.Validator_capability_0_on_unit_1_realized_to_different_target_in_link_2,
										new Object[] { cap, unit, link }, cap);
						reporter.addStatus(status);
					}
				} else {
					// > 1 case checked elsewhere
				}
			}
		} else {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.CAPABILITY_REALIZATION_001,
					ICoreProblemType.CAPABILITY_HAS_MULTIPLE_REALIZATION_LINKS,
					DeployCoreMessages.Validator_capability_0_has_multiple_realization_links,
					new Object[] { cap }, cap);
			reporter.addStatus(status);
		}
	}

	/**
	 * Validates the realization (if any) of a requirement.
	 * 
	 * @param req
	 *           the requirement to be validated.
	 * @param context
	 *           the topology-level validation context (used for indexing).
	 * @param reporter
	 *           used to report errors.
	 */
	protected void validateRequirementRealization(Requirement req, IDeployValidationContext context,
			IDeployReporter reporter) {

		List sourceLinks = ValidatorUtils.getSourceRealizationLinks(req);
		if (sourceLinks.size() == 0) {
			return;
		} else if (sourceLinks.size() == 1) {
			RealizationLink link = (RealizationLink) sourceLinks.get(0);
			Unit unit = ValidatorUtils.getUnit(req);
			if (unit != null) {
				if (!unit.isConceptual()) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.REQ_ON_CONCEPTUAL_UNIT_001,
									ICoreProblemType.REQUIREMENT_ON_NON_CONCEPTUAL_UNIT_REALIZED,
									DeployCoreMessages.Validator_requirement_0_on_non_conceptual_unit_realized_in_link_1,
									new Object[] { req, link }, req);
					reporter.addStatus(status);
				}
				List unitSourceLinks = ValidatorUtils.getSourceRealizationLinks(unit);
				if (unitSourceLinks.size() == 0) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.REALIZED_REQ_ON_NON_REALIZED_UNIT_001,
									ICoreProblemType.REALIZED_REQUIREMENT_ON_NON_REALIZED_UNIT,
									DeployCoreMessages.Validator_realized_requirement_0_on_non_realized_unit_realized_in_link_1,
									new Object[] { req, link }, req);
					reporter.addStatus(status);
				} else if (unitSourceLinks.size() > 0) {
					RealizationLink unitLink = (RealizationLink) sourceLinks.get(0);
					// Compare target of link and unitlink
					if (unitLink.getTarget() != null
							&& !unitLink.getTarget().equals(ValidatorUtils.getUnit(link.getTarget()))) {
						// Report parent's realization target not same as capability's realization target
						IDeployStatus status = DeployCoreStatusFactory.INSTANCE
								.createDeployStatus(
										IStatus.ERROR,
										IDeployCoreValidators.REQUIREMENT_REALIZATION_002,
										ICoreProblemType.REQUIREMENT_REALIZATION_TARGET_INCONSISTENT,
										DeployCoreMessages.Validator_requirement_0_on_unit_1_realized_to_different_target_in_link_2,
										new Object[] { req, unit, link }, req);
						reporter.addStatus(status);
					}
				} else {
					// > 1 case checked elsewhere
				}
			}
		} else {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IDeployCoreValidators.REQUIREMENT_REALIZATION_001,
					ICoreProblemType.REQUIREMENT_HAS_MULTIPLE_REALIZATION_LINKS,
					DeployCoreMessages.Validator_requirement_0_has_multiple_realization_links,
					new Object[] { req }, req);
			reporter.addStatus(status);
		}
	}

	/**
	 * Validate the implementation of the realization link.
	 * 
	 * @param link
	 *           the link whose source dmo is validated.
	 * @param dmoLinkSource
	 *           the deploymodelobject which is the source of the link. Should be Unit, Capability,
	 *           or Requirement
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateRealizationLink(RealizationLink rLink, IDeployValidationContext context,
			IDeployReporter reporter) {
		IDeployStatus status;
		if (rLink.getTarget() == null) {
			if (rLink.getTargetURI() != null) {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.REALIZATION_LINK_001,
						ICoreProblemType.LINK_TARGET_UNRESOLVABLE,
						DeployCoreMessages.Validator_link_0_target_1_cannot_be_resolved, new Object[] {
								rLink, rLink.getTargetURI() }, rLink);
			} else {
				status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
						IDeployCoreValidators.REALIZATION_LINK_002,
						ICoreProblemType.LINK_TARGET_UNDEFINED,
						DeployCoreMessages.Validator_link_0_target_undefined, new Object[] { rLink },
						rLink);
			}
			reporter.addStatus(status);
			// MK 2/22/2007 addition
		} else {
			DeployModelObject rLinkSource = rLink.getSource();
			if (rLinkSource instanceof Unit) {
				// validateUnitRealization called from UnitValidator
			} else if (rLinkSource instanceof Capability) {
				validateCapabilityRealization((Capability) rLinkSource, context, reporter);
			} else if (rLinkSource instanceof Requirement) {
				validateRequirementRealization((Requirement) rLinkSource, context, reporter);
			} else {
				// report?
			}
			// Exclude Units from check
			// Unit validation does full type compatibility checking and handles conceptual nodes.
			if (!(rLinkSource instanceof Unit)) {
				DeployModelObject rLinkTarget = rLink.getTarget();
				if (!rLinkSource.eClass().isSuperTypeOf(rLinkTarget.eClass())) {
					status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IDeployCoreValidators.REALIZATION_LINK_003,
									ICoreProblemType.REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH,
									DeployCoreMessages.Validator_realization_link_source_0_target_1_type_mismatch,
									new Object[] { rLinkSource.eClass().getName(),
											rLinkTarget.eClass().getName() }, rLink);

					reporter.addStatus(status);
				}
			}
			RealizationMatcherUtils.validateRealizationLink(rLink, rLinkSource, rLink.getTarget(),
					context, reporter);
		}
	}

	/**
	 * Validations include -- all realization links with unit or unit-contained DMOs as source have
	 * same target -- basic checks for malformed links -- full realization link validation -- checks
	 * specific to links with capability or requirement as a source
	 * 
	 * @param Unit
	 *           unit the unit which is the direct or indirect source of the realization links
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateRealizationLinks(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
		if (unit.getEditTopology() == null) {
			return;
		}
		HashMap<DeployModelObject, DeployModelObject> sourceToTargetMap = new HashMap();
		HashMap<DeployModelObject, RealizationLink> sourceToRLinkMap = new HashMap();
		for (Iterator<RealizationLink> rLinkIter = unit.getEditTopology().findAllRealizationLinks(); rLinkIter
				.hasNext();) {
			RealizationLink rLink = rLinkIter.next();
			if (unit.equals(ValidatorUtils.getUnit(rLink.getSource()))) {
				// It is a link with source of unit or child of unit
				validateRealizationLink(rLink, context, reporter);
				if (rLink.getTarget() != null) {
					sourceToTargetMap.put(rLink.getSource(), rLink.getTarget());
					sourceToRLinkMap.put(rLink.getSource(), rLink);
				} else {
					// Malformed realization links reported elsewhere
				}
			}
		}

		// If inconsistent realization target detected, report
		if (sourceToTargetMap.entrySet().size() > 1) {
			// Report inconsistent target error on each source
			for (Iterator<DeployModelObject> sourceDmoIter = sourceToTargetMap.keySet().iterator(); sourceDmoIter
					.hasNext();) {
				DeployModelObject srcDmo = sourceDmoIter.next();
				// Do not report with generic status if capability or requirement 
				// should have already reported inconsistency with a more specific status.
				if (!(sourceToTargetMap.containsKey(unit) && (srcDmo.equals(unit)
						|| srcDmo instanceof Capability || srcDmo instanceof Requirement))) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
							IStatus.ERROR, IDeployCoreValidators.DMO_REALIZATION_002,
							ICoreProblemType.DMO_REALIZATION_TARGET_INCONSISTENT,
							DeployCoreMessages.Validator_DMO_0_realized_to_inconsistent_target_in_link_1,
							new Object[] { srcDmo, sourceToRLinkMap.get(srcDmo) }, srcDmo);
					reporter.addStatus(status);
				}
			}
		}

		// All realization links owned by unit must have source that is unit or contained by unit
		// Report on unit if realization link source is null
		for (Iterator<RealizationLink> rLinkIter = unit.getRealizationLinks().iterator(); rLinkIter
				.hasNext();) {
			RealizationLink rLink = rLinkIter.next();
			DeployModelObject rLinkSource = rLink.getSource();
			if (unit.equals(rLink.getParent()) && !unit.equals(ValidatorUtils.getUnit(rLinkSource))) {
				IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
						IStatus.ERROR, IDeployCoreValidators.REALIZATION_LINK_INVALID_SOURCE_001,
						ICoreProblemType.REALIZATION_LINK_SOURCE_INVALID,
						DeployCoreMessages.Validator_realization_link_source_0_not_contained_by_unit_1,
						new Object[] { rLinkSource != null ? rLinkSource : unit, unit },
						rLinkSource != null ? rLinkSource : unit);
				reporter.addStatus(status);
			}
		}
	}
}
