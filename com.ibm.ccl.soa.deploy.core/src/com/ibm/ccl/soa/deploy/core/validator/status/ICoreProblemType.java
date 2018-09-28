/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;

/**
 * Defines the deploy model marker problem types for the core domain.
 * 
 * @see CorePackage
 * @see IDeployStatus#getProblemType()
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface ICoreProblemType {

	/**
	 * The hosted target of the {@link HostingLink} is not the link's container.
	 */
	public static final String HOSTING_LINK_SOURCE_IS_NOT_CONTAINER = DeployCorePlugin.PLUGIN_ID
			+ ".hostingLinkSourceIsNotContainer"; //$NON-NLS-1$

	/**
	 * The unit is hosting even though it does not provide any hosting capabilities.
	 */
	public static final String HOSTING_LINK_SOURCE_PROVIDES_NO_HOSTING_CAPABILITIES = DeployCorePlugin.PLUGIN_ID
			+ ".hostingLinkSourceProvidesNoHostingCapabilities"; //$NON-NLS-1$

	/**
	 * A unit is hosted even though it does not consume any hosting capabilities.
	 */
	public static final String HOSTING_LINK_TARGET_HAS_NO_HOSTING_REQUIREMENTS = DeployCorePlugin.PLUGIN_ID
			+ ".hostingLinkTargetHasNoHostingRequirements"; //$NON-NLS-1$

	/**
	 * The hosted target of the {@link HostingLink} is not a providing all the required hosting
	 * capabilities.
	 */
	public static final String HOSTING_LINK_TARGET_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".hostingLinkTargetInvalid"; //$NON-NLS-1$

	/**
	 * The hosted target of the {@link HostingLink} is not set.
	 */
	public static final String HOSTING_LINK_TARGET_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".hostingLinkTargetUndefined"; //$NON-NLS-1$

	/**
	 * The the target of the {@link MemberLink} is not set.
	 */
	public static final String MEMBER_LINK_TARGET_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".memberLinkTargetUndefined"; //$NON-NLS-1$

	/**
	 * The target of a link cannot be resolved.
	 * 
	 * @see DependencyLink#getTargetURI()
	 * @see UnitLink#getTargetURI()
	 * @see ConstraintLink#getTargetURI()
	 */
	public static final String LINK_TARGET_UNRESOLVABLE = DeployCorePlugin.PLUGIN_ID
			+ ".linkTargetUnresolvable"; //$NON-NLS-1$

	/**
	 * The source of a link is not contained in a topology.
	 * 
	 * @see DependencyLink#getSource()
	 * @see UnitLink#getSource()
	 * @see ConstraintLink#getSource()
	 * @see DeployModelObject#getTopology()
	 */
	public static final String LINK_SOURCE_UNCONTAINED = DeployCorePlugin.PLUGIN_ID
			+ ".linkSourceUncontained"; //$NON-NLS-1$

	/**
	 * The target of a link is not contained in a topology.
	 * 
	 * @see DependencyLink#getTarget()
	 * @see UnitLink#getTarget()
	 * @see ConstraintLink#getTarget()
	 * @see DeployModelObject#getTopology()
	 */
	public static final String LINK_TARGET_UNCONTAINED = DeployCorePlugin.PLUGIN_ID
			+ ".linkTargetUncontained"; //$NON-NLS-1$

	/**
	 * The target of a link has not been set.
	 * 
	 * @see DependencyLink#getTarget()
	 * @see UnitLink#getTarget()
	 * @see ConstraintLink#getTarget()
	 */
	public static final String LINK_TARGET_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".linkTargetUndefined"; //$NON-NLS-1$

	/**
	 * The source of a link cannot be resolved.
	 * 
	 * @see DependencyLink#getSourceURI()
	 * @see UnitLink#getSourceURI()
	 * @see ConstraintLink#getSourceURI()
	 */
	public static final String LINK_SOURCE_UNRESOLVABLE = DeployCorePlugin.PLUGIN_ID
			+ ".linkSourceUnresolvable"; //$NON-NLS-1$

	/**
	 * The source of a link has not been set.
	 * 
	 * @see DependencyLink#getSource()
	 * @see UnitLink#getSource()
	 * @see ConstraintLink#getSource()
	 */
	public static final String LINK_SOURCE_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".linkSourceUndefined"; //$NON-NLS-1$

	/**
	 * The hosted target of the {@link MemberLink} is not a permitted by the member requirements of
	 * the unit.
	 */
	public static final String MEMBER_LINK_TARGET_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".memberLinkTargetInvalid"; //$NON-NLS-1$

	/**
	 * The a unit contains more than one member links to the same target unit.
	 */
	public static final String MULTIPLE_MEMBER_LINKS_BETWEEN_UNITS = DeployCorePlugin.PLUGIN_ID
			+ ".multipleMemberLinksBetweenUnits"; //$NON-NLS-1$

	/**
	 * The value of the object attribute identified by the {@link DeployObjectAttributeMarker} is not
	 * valid.
	 * <p>
	 * This is a generic problem type for invalid attributes. More domain specific ones can be
	 * declared, such as {@link #OBJECT_ATTRIBUTE_NOT_UNIQUE}, and
	 * {@link #OBJECT_ATTRIBUTE_UNDEFINED}.
	 */
	public static final String OBJECT_ATTRIBUTE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".objectAttributeInvalid"; //$NON-NLS-1$

	/**
	 * The {@link CorePackage#getDeployModelObject_Name()} attribute value is not unique.
	 */
	public static final String OBJECT_ATTRIBUTE_NOT_UNIQUE = DeployCorePlugin.PLUGIN_ID
			+ ".objectAttributeNotUnique"; //$NON-NLS-1$

	/**
	 * The required object attribute identified by the {@link DeployObjectAttributeMarker} is not
	 * set.
	 * <p>
	 * This is a generic problem type for attributes that are not set.
	 */
	public static final String OBJECT_ATTRIBUTE_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".objectAttributeUndefined"; //$NON-NLS-1$

	/**
	 * The {@link DeployModelObject} has no parent container.
	 * 
	 * @see DeployModelObject#getParent()
	 */
	public static final String OBJECT_CONTAINER_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".objectContainerUndefined"; //$NON-NLS-1$

	/**
	 * The {@link DeployModelObject} has an invalid parent container.
	 * 
	 * @see DeployModelObject#getParent()
	 */
	public static final String OBJECT_CONTAINER_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".objectContainerInvalid"; //$NON-NLS-1$

	/**
	 * One or more attributes of the source and targets of {@link DependencyLink} do not match.
	 * 
	 * @see #DEPENDENCY_LINK_ENDPOINT_TYPE_MISMATCH
	 */
	public static String DEPENDENCY_LINK_ENDPOINT_ATTRIBUTE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".dependencyLinkEndpointAttributeMismatch"; //$NON-NLS-1$ 

	/**
	 * The source and target types of {@link DependencyLink} do not match.
	 * 
	 * @see #DEPENDENCY_LINK_ENDPOINT_ATTRIBUTE_MISMATCH
	 */
	public static String DEPENDENCY_LINK_ENDPOINT_TYPE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".dependencyLinkEndpointTypeMismatch"; //$NON-NLS-1$ 

	/**
	 * The source of {@link DependencyLink} is invalid (e.g. a prohibited requirement).
	 */
	public static final String DEPENDENCY_LINK_SOURCE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".dependencyLinkSourceInvalid"; //$NON-NLS-1$

	/**
	 * The target of {@link DependencyLink} is not valid.
	 */
	public static final String DEPENDENCY_LINK_TARGET_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".dependencyLinkTargetInvalid"; //$NON-NLS-1$

	/**
	 * The target of {@link DependencyLink} is is not hosted as expected.
	 */
	public static final String DEPENDENCY_LINK_TARGET_HOSTING_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".dependencyLinkTargetHostingInvalid"; //$NON-NLS-1$

	/**
	 * The target of {@link DependencyLink} is is not set.
	 */
	public static final String DEPENDENCY_LINK_TARGET_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".dependencyLinkTargetUndefined"; //$NON-NLS-1$

	/**
	 * A unit provides a {@link Capability} of a type that is not valid.
	 */
	public static final String UNIT_CAPABILITY_TYPE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".unitCapabilityTypeInvalid"; //$NON-NLS-1$

	/**
	 * An invalid number of dependency links are targeting the capability.
	 */
	public static final String UNIT_CAPABILITY_LINK_CARDINALITY_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".unitCapabilityLinkCardinalityInvalid"; //$NON-NLS-1$

	/**
	 * A unit provides a {@link Requirement} whose {@link Requirement#getDmoEType()} is invalid.
	 */
	public static final String UNIT_REQUIREMENT_TYPE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".unitRequirementTypeInvalid"; //$NON-NLS-1$

	/**
	 * A unit provides a {@link Capability} of a type in a cardinality that is not valid.
	 */
	public static final String UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".unitCapabilityTypeCardinalityInvalid"; //$NON-NLS-1$

	/**
	 * A unit provides a {@link Requirement} of with {@link Requirement#getDmoEType()} with invalid
	 * cardinality.
	 */
	public static final String UNIT_REQUIREMENT_CARDINALITY_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".unitRequirementCardinalityInvalid"; //$NON-NLS-1$

	/**
	 * A unit consumes a hosting requirement that is not provided by its host.
	 */
	public static final String UNIT_HOSTING_REQUIREMENT_UNMATCHED = DeployCorePlugin.PLUGIN_ID
			+ ".unitHostingRequirementUnmatched"; //$NON-NLS-1$

	/**
	 * A unit whose {@link Unit#getInitInstallState()} is {@link InstallState#INSTALLED} is hosted on
	 * a unit whose install state is <em>not</em> {@link InstallState#INSTALLED}.
	 */
	public static final String UNIT_HOST_NOT_INSTALLED = DeployCorePlugin.PLUGIN_ID
			+ ".unitHostNotInstalled"; //$NON-NLS-1$ 

	/**
	 * A unit whole {@link Unit#getPublishIntent()} is {@link PublishIntent#PUBLISH} and is hosted on
	 * a unit whose publish state is {@link PublishIntent#DO_NOT_PUBLISH}.
	 */
	public static final String UNIT_HOST_DO_NOT_PUBLISH = DeployCorePlugin.PLUGIN_ID
			+ ".unitHostDoNotPublish"; //$NON-NLS-1$  

	/**
	 * A unit whole {@link Unit#getPublishIntent()} is {@link PublishIntent#DO_NOT_PUBLISH} hosts one
	 * or more units whose publish intent is {@link PublishIntent#PUBLISH}.
	 */
	public static final String UNIT_DO_NOT_PUBLISH_HOSTS_PUBLISH_UNITS = DeployCorePlugin.PLUGIN_ID
			+ ".unitDoNotPublishHostsPublishUnits"; //$NON-NLS-1$  

	/**
	 * The consumed {@link Capability} has no {@link DependencyLink}.
	 */
	public static final String UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED = DeployCorePlugin.PLUGIN_ID
			+ ".unitDependencyRequirementUnmatched"; //$NON-NLS-1$

	/**
	 * The {@link Unit} is missing a {@link Capability} of an expected type.
	 */
	public static final String UNIT_MISSING_CAPABILITY = DeployCorePlugin.PLUGIN_ID
			+ ".unitMissingCapability"; //$NON-NLS-1$

	/**
	 * The {@link Unit} is missing a {@link Requirement} of an expected type.
	 */
	public static final String UNIT_MISSING_REQUIREMENT = DeployCorePlugin.PLUGIN_ID
			+ ".unitMissingRequirement"; //$NON-NLS-1$

	/**
	 * The unit does is not the target of more than one {@link HostingLink}.
	 */
	public static final String UNIT_MULTIPLE_HOSTS = DeployCorePlugin.PLUGIN_ID
			+ ".unitMultipleHosts"; //$NON-NLS-1$

	/**
	 * The unit does is not the target of a {@link HostingLink}.
	 */
	public static final String UNIT_NOT_HOSTED = DeployCorePlugin.PLUGIN_ID + ".unitNotHosted"; //$NON-NLS-1$

	/**
	 * The unit's host will be uninstalled ({@link Unit#getGoalInstallState()} is
	 * {@link InstallState#NOT_INSTALLED}.
	 * <p>
	 * A unit whose {@link Unit#getInitInstallState()} is {@link InstallState#INSTALLED} and whose
	 * goal install state is not {@link InstallState#NOT_INSTALLED}. is hosted on a unit whose
	 * <em>goal</em> install state is. <em>not</em> {@link InstallState#NOT_INSTALLED}.
	 */
	public static final String UNIT_HOST_TO_BE_UNINSTALLED = DeployCorePlugin.PLUGIN_ID
			+ ".unitHostToBeUninstalled"; //$NON-NLS-1$

	/**
	 * The {@link Unit} is containing a {@link Capability} which violates the cardinality rule.
	 */
	public static final String UNIT_CAPABILITY_CARDINALITY_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".unitCapabilityCardinalityInvalid"; //$NON-NLS-1$

	/**
	 * The unit contains a {@link Capability} whose type is invalid.
	 */
	public static final String UNIT_CAPABILITY_INVALID_TYPE = DeployCorePlugin.PLUGIN_ID
			+ ".unitCapabilityInvalidType"; //$NON-NLS-1$

	/**
	 * The {@link Unit} has no capabilities or requirements.
	 */
	public static final String UNIT_HAS_NO_REQUIREMENTS_OR_CAPABILITIES = DeployCorePlugin.PLUGIN_ID
			+ ".unitHasNoRequirementsOrCapabilities"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link Requirement} is linked to more than one {@link Capability}.
	 */
	public static final String REQUIREMENT_HAS_MULTIPLE_DEPENDENCIES = DeployCorePlugin.PLUGIN_ID
			+ ".requirementHasMultipleDependencies"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link Requirement} was matched the type of the capability that it was
	 * compared to.
	 * <p>
	 * Non-hosting requirements are compared to the target of their dependency link. Hosting
	 * requirements are compared to a capability is the hosting unit.
	 */
	public static final String REQUIREMENT_TYPE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".requirementTypeMismatch"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link Requirement} was matched the capability that has different hosting.
	 */
	public static final String REQUIREMENT_LINK_TYPE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".requirementLinkTypeMismatch"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link RequirementExpression} refers to an attribute that has not been
	 * declared in the target capability type.
	 */
	public static final String REQUIREMENT_EXPRESSION_INVALID_ATTRIBUTE = DeployCorePlugin.PLUGIN_ID
			+ ".requirementExpressionInvalidAttribute"; //$NON-NLS-1$

	/**
	 * Indicates that the value {@link RequirementExpression} does not match the value of the
	 * capability it was compared to.
	 */
	public static final String REQUIREMENT_EXPRESSION_VALUE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".requirementExpressionValueMismatch"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link Requirement} is missing a required {@link RequirementExpression}.
	 */
	public static final String REQUIREMENT_EXPRESSION_MISSING = DeployCorePlugin.PLUGIN_ID
			+ ".requirementExpressionMissing"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link RequirementExpression#getValue()} is invalid.
	 */
	public static final String REQUIREMENT_EXPRESSION_VALUE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".requirementExpressionValueInvalid"; //$NON-NLS-1$

	/**
	 * Indicates that the interface for a {@link Reference} does match the interface on a
	 * {@link Service}.
	 */
	public static final String REFERENCE_LINKED_INTERFACE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".referenceLinkedInterfaceMismatch"; //$NON-NLS-1$

	/**
	 * Indicates that the a {@link Reference} has invalid 'link type'.
	 */
	public static final String REFERENCE_LINK_TYPE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".referenceLinkTypeInvalid"; //$NON-NLS-1$
	/**
	 * Indicates that a {@link Unit} has an empty {@link Unit#getArtifacts()} list.
	 */
	public static final String UNIT_ARTIFACT_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".unitArtifactUndefined"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link FileArtifact} contains an invalid URI.
	 */
	public static final String FILE_ARTIFACT_URI_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".fileArtifactUriInvalid"; //$NON-NLS-1$

	/**
	 * Indicates that a {@link Unit} with {@link Unit#isGroup()} true, has a
	 * {@link RequirementExpression} for member whose {@link OutCardinality} expression is invalid.
	 */
	public static final String GROUP_OUT_CARDINALITY_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".groupOutCardinalityInvalid"; //$NON-NLS-1$ 

	/**
	 * Indicates that a {@link Unit} which is a member of a group by being a target of a
	 * {@link MemberLink} has a {@link RequirementExpression} restricting its group membership whose
	 * {@link InCardinality} expression is invalid.
	 */
	public static final String GROUP_IN_CARDINALITY_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".groupInCardinalityInvalid"; //$NON-NLS-1$ 

	/**
	 * A {@link Module} with {@link Module#getInitInstallState()} {@link InstallState#NOT_INSTALLED}
	 * has an empty {@link Module#getArtifacts()} list.
	 * <p>
	 * Value = {@value}
	 */
	public static final String APPLICATION_MODULE_ARTIFACT_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".applicationModuleArtifactUndefined"; //$NON-NLS-1$

	/**
	 * A {@link Unit} whose {@link Unit#isConceptual()} is true, is not realized in the topology
	 * using a {@link RealizationLink}.
	 */
	public static final String CONCEPTUAL_UNIT_NOT_REALIZED = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualUnitNotRealized"; //$NON-NLS-1$ 

	/**
	 * A {@link Unit} whose {@link Unit#isConceptual()} is false, is realized in the topology using a
	 * {@link RealizationLink}.
	 */
	public static final String NON_CONCEPTUAL_UNIT_REALIZED = DeployCorePlugin.PLUGIN_ID
			+ ".nonConceptualUnitRealized"; //$NON-NLS-1$ 

	/**
	 * A {@link Capability} on a {@link Unit} whose {@link Unit#isConceptual()} is false, is realized
	 * in the topology using a {@link RealizationLink}.
	 */
	public static final String CAPABILITY_ON_NON_CONCEPTUAL_UNIT_REALIZED = DeployCorePlugin.PLUGIN_ID
			+ ".capabilityOnNonConceptualUnitRealized"; //$NON-NLS-1$ 

	/**
	 * A {@link Requirement} on a {@link Unit} whose {@link Unit#isConceptual()} is false, is
	 * realized in the topology using a {@link RealizationLink}.
	 */
	public static final String REQUIREMENT_ON_NON_CONCEPTUAL_UNIT_REALIZED = DeployCorePlugin.PLUGIN_ID
			+ ".requirementOnNonConceptualUnitRealized"; //$NON-NLS-1$ 	
	/**
	 * A {@link Capability} on a {@link Unit}, is realized in the topology using a
	 * {@link RealizationLink} but parent unit is not realized.
	 */
	public static final String REALIZED_CAPABILITY_ON_NON_REALIZED_UNIT = DeployCorePlugin.PLUGIN_ID
			+ ".realizedCapabilityOnNonRealizedUnit"; //$NON-NLS-1$ 

	/**
	 * A {@link Requirement} on a {@link Unit}, is realized in the topology using a
	 * {@link RealizationLink} but parent unit is not realized.
	 */
	public static final String REALIZED_REQUIREMENT_ON_NON_REALIZED_UNIT = DeployCorePlugin.PLUGIN_ID
			+ ".realizedRequirementOnNonRealizedUnit"; //$NON-NLS-1$

	/**
	 * A {@link Capability} on a {@link Unit}, is realized in the topology using a
	 * {@link RealizationLink} to location inconsistent with parent's realization link
	 */
	public static final String CAPABILITY_REALIZATION_TARGET_INCONSISTENT = DeployCorePlugin.PLUGIN_ID
			+ ".capabilityRealizationTargetInconsistent"; //$NON-NLS-1$

	/**
	 * A {@link DeployModelObject} on a {@link Unit}, is realized in the topology using a
	 * {@link RealizationLink} to location inconsistent with parent's realization link
	 */
	public static final String DMO_REALIZATION_TARGET_INCONSISTENT = DeployCorePlugin.PLUGIN_ID
			+ ".dmoRealizationTargetInconsistent"; //$NON-NLS-1$	

	/**
	 * A {@link Requirement} on a {@link Unit}, is realized in the topology using a
	 * {@link RealizationLink} to location inconsistent with parent's realization link
	 */
	public static final String REQUIREMENT_REALIZATION_TARGET_INCONSISTENT = DeployCorePlugin.PLUGIN_ID
			+ ".requirementRealizationTargetInconsistent"; //$NON-NLS-1$	

	/**
	 * A {@link RealizationLink} on a {@link Unit}, has source that is not the unit or contained by
	 * the unit
	 */
	public static final String REALIZATION_LINK_SOURCE_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkSourceInvalid"; //$NON-NLS-1$

	/**
	 * A {@link Unit} whose {@link Unit#isConceptual()} is true, is realized in the topology using
	 * multiple {@link RealizationLink}.
	 */
	public static final String CONCEPTUAL_UNIT_HAS_MULTIPLE_REALIZATION_LINKS = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualUnitHasMultipleRealizationLinks"; //$NON-NLS-1$

	/**
	 * A {@link Unit} who realizes a conceptual {@link Unit} but is not hosted to a realization of
	 * one of the hosts in the hosting stack of the conceptual {@link Unit}.
	 */
	public static final String REALIZATION_HAS_AMBIGUOUS_HOSTING_STACK = DeployCorePlugin.PLUGIN_ID
			+ ".realizationHasAmbiguousHostingStack"; //$NON-NLS-1$
	/**
	 * A {@link Capability} is realized in the topology using multiple {@link RealizationLink}.
	 */
	public static final String CAPABILITY_HAS_MULTIPLE_REALIZATION_LINKS = DeployCorePlugin.PLUGIN_ID
			+ ".capabilityHasMultipleRealizationLinks"; //$NON-NLS-1$	

	/**
	 * A {@link Requirement} is realized in the topology using multiple {@link RealizationLink}.
	 */
	public static final String REQUIREMENT_HAS_MULTIPLE_REALIZATION_LINKS = DeployCorePlugin.PLUGIN_ID
			+ ".requirementHasMultipleRealizationLinks"; //$NON-NLS-1$	

	/**
	 * A {@link RealizationLink} source and target types do not match.
	 */
	public static final String REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkSourceTargetTypeMismatch"; //$NON-NLS-1$

	/**
	 * A {@link RealizationLink} unit source and target stereotype do not match.
	 */
	public static final String REALIZATION_LINK_UNIT_SOURCE_TARGET_STEREOTYPE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkUnitSourceTargetStereotypeMismatch"; //$NON-NLS-1$

	/**
	 * A {@link RealizationLink} capability source and target stereotype do not match.
	 */
	public static final String REALIZATION_LINK_CAP_SOURCE_TARGET_STEREOTYPE_MISMATCH = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkCapSourceTargetStereotypeMismatch"; //$NON-NLS-1$

	/**
	 * A {@link RealizationLink} source and target cannot be the same unit
	 */
	public static final String REALIZATION_LINK_SOURCE_TARGET_SAME = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkSourceTargetSame"; //$NON-NLS-1$

	/**
	 * A {@link RealizationLink} is not valid, specific reason unknown
	 */
	public static final String REALIZATION_LINK_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkInvalid"; //$NON-NLS-1$	

	/**
	 * A {@link RealizationLink} source has a {@link Capability} that cannot be matched to a
	 * capability on the target unit
	 */
	public static final String REALIZATION_LINK_UNMATCHED_CAPABILITY = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkUnmatchedCapability"; //$NON-NLS-1$

	/**
	 * A {@link RealizationLink} source's capability has a attribute value that does not match the
	 * corresponding attribute on the corresponding capability on the target unit
	 */
	public static final String REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkUnmatchedAttributeValue"; //$NON-NLS-1$	

	/**
	 * A {@link RealizationLink} source's capability has an attribute that is not found corresponding
	 * capability on the target unit
	 */
	public static final String REALIZATION_LINK_UNMATCHED_ATTRIBUTE = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkUnmatchedAttribute"; //$NON-NLS-1$		

	/**
	 * A {@link RealizationLink} source's capability has a attribute with metadata that does not
	 * match the metadata for the corresponding attribute on the corresponding capability on the
	 * target dmo
	 */
	public static final String REALIZATION_LINK_UNMATCHED_ATTRIBUTE_METADATA = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkUnmatchedAttributeMetaData"; //$NON-NLS-1$		

	/**
	 * A {@link RealizationLink} source has a {@link Requirement} that cannot be matched to a
	 * requirement on the target unit
	 */
	public static final String REALIZATION_LINK_UNMATCHED_REQUIREMENT = DeployCorePlugin.PLUGIN_ID
			+ ".realizationLinkUnmatchedRequirement"; //$NON-NLS-1$

	/**
	 * A {@link RealizationLink} source is part of a realization cycle
	 */
	public static final String REALIZATION_CYCLE = DeployCorePlugin.PLUGIN_ID + ".realizationCycle"; //$NON-NLS-1$	

	/**
	 * A conceptual {@link Unit} has a invalid host
	 */
	public static final String CONCEPTUAL_INVALID_HOSTER = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualInvalidHoster"; //$NON-NLS-1$	

	/**
	 * A conceptual {@link Unit} has a invalid hostees
	 */
	public static final String CONCEPTUAL_INVALID_HOSTEES = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualInvalidHostees"; //$NON-NLS-1$	

	/**
	 * A conceptual {@link Unit} has a requirement with invalid target
	 */
	public static final String CONCEPTUAL_INVALID_DL_TARGET = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualInvalidDLTarget"; //$NON-NLS-1$	

	/**
	 * A conceptual {@link Unit} is target of dependency links from invalid sources
	 */
	public static final String CONCEPTUAL_INVALID_DL_SOURCES = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualInvalidDLSources"; //$NON-NLS-1$	

	/**
	 * A conceptual {@link Unit} is a member of invalid groups
	 */
	public static final String CONCEPTUAL_INVALID_GROUPS = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualInvalidGroups"; //$NON-NLS-1$		
	/**
	 * A conceptual {@link Unit} has invalid group members
	 */
	public static final String CONCEPTUAL_INVALID_MEMBERS = DeployCorePlugin.PLUGIN_ID
			+ ".conceptualInvalidMembers"; //$NON-NLS-1$		

	/**
	 * A {@link Import} could not be resolved to its {@link Topology}.
	 */
	public static final String TOPOLOGY_IMPORT_NOT_FOUND = DeployCorePlugin.PLUGIN_ID
			+ ".topologyImportNotFound"; //$NON-NLS-1$

	/**
	 * The topology {@link Import} create a dependency cycle.
	 */
	public static final String TOPOLOGY_IMPORT_CYCLE = DeployCorePlugin.PLUGIN_ID
			+ ".topologyImportCycle"; //$NON-NLS-1$

	/**
	 * A {@link Import} could not be resolved to its {@link Topology}.
	 */
	public static final String IMPORT_INSTANTIATION_NOT_RESOLVABLE = DeployCorePlugin.PLUGIN_ID
			+ ".importInstantiationNotResolvable"; //$NON-NLS-1$

	/**
	 * A {@link Instantiation} references an object that was not exported by its contract.
	 * 
	 * @see DeployModelObject#isPublic()
	 */
	public static final String IMPORT_INSTANTIATION_OBJECT_NOT_PUBLIC = DeployCorePlugin.PLUGIN_ID
			+ ".importInstantiationObjectNotPublic"; //$NON-NLS-1$

	/**
	 * A {@link com.ibm.ccl.soa.deploy.core.Property} of an {@link Instantiation} references an
	 * object attribute that was not made public by its topology.
	 * 
	 * @see DeployModelObject#isPublicEditable(String)
	 */
	public static final String IMPORT_INSTANTIATION_OBJECT_ATTRIBUTE_NOT_EDITABLE = DeployCorePlugin.PLUGIN_ID
			+ ".importInstantiationObjectAttributeNotEditable"; //$NON-NLS-1$

	/**
	 * The Constraint has no validator. {@link Constraint}
	 */
	public static final String CONSTRAINT_NO_VALIDATOR = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintNoValidator"; //$NON-NLS-1$ 

	/**
	 * The Constraint's placement is invalid. {@link Constraint}
	 */
	public static final String CONSTRAINT_PLACEMENT_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintPlacementInvalid"; //$NON-NLS-1$ 

	/**
	 * The Constraint is malformed. {@link Constraint}
	 */
	public static final String CONSTRAINT_MALFORMED = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintMalformed"; //$NON-NLS-1$ 

	/**
	 * The context of a {@link Constraint} is null.
	 */
	public static final String CONSTRAINT_CONTEXT_NULL = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintContextNull"; //$NON-NLS-1$ 

	/**
	 * The context of a {@link Constraint} is invalid.
	 */
	public static final String CONSTRAINT_CONTEXT_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintContextInvalid"; //$NON-NLS-1$ 

	/**
	 * {@link Constraint} returned a non-deploy status with severity non-OK.
	 */
	public static final String CONSTRAINT_UNSATISFIED = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintUnsatisfied"; //$NON-NLS-1$ 

	/**
	 * {@link Constraint} returned a status with severity INFO.
	 */
	public static final String CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE = DeployCorePlugin.PLUGIN_ID
			+ ".ConstraintNotEnoughInfoToValidate"; //$NON-NLS-1$ 

	/**
	 * {@link DeployModelObject#getConstraints()} is empty.
	 */
	public static final String OBJECT_CONSTRAINTS_EMPTY = DeployCorePlugin.PLUGIN_ID
			+ ".ObjectConstraintsEmpty"; //$NON-NLS-1$ 

	/**
	 * {@link DeployModelObject#getConstraints()} is missing one or more values.
	 */
	public static final String OBJECT_CONSTRAINTS_MISSING = DeployCorePlugin.PLUGIN_ID
			+ ".ObjectConstraintsMissing"; //$NON-NLS-1$ 

	/**
	 * {@link DeployModelObject#getConstraints()} has too many values.
	 */
	public static final String OBJECT_CONSTRAINTS_EXTRANEOUS = DeployCorePlugin.PLUGIN_ID
			+ ".ObjectConstraintsExtraneous"; //$NON-NLS-1$ 

	/**
	 * Attribute Value Constraint {@link AttributeValueConstraint} refers to an attribute that has
	 * not been declared in the context.
	 */
	public static final String ATTRIBUTE_CONSTRAINT_INVALID_ATTRIBUTE = DeployCorePlugin.PLUGIN_ID
			+ ".AttributeConstraintInvalidAttribute"; //$NON-NLS-1$ 

	/**
	 * Attribute Value Constraint {@link AttributeValueConstraint} refers to a extended attribute
	 * that has no type.
	 */
	public static final String ATTRIBUTE_CONSTRAINT_EXTENDED_ATTRIBUTE_HAS_NO_TYPE = DeployCorePlugin.PLUGIN_ID
			+ ".AttributeConstraintExtendedAttributeHasNoType"; //$NON-NLS-1$ 

	/**
	 * A problem type indicating that the {@link CommunicationConstraint} has been violated.
	 * 
	 * @see IDeployCoreValidators for valid ids.
	 * 
	 * @see IDeployCoreValidators#COMMCONSTRAINT_001
	 * @see IDeployCoreValidators#COMMCONSTRAINT_002
	 */
	public static final String COMM_CONSTRAINT = DeployCorePlugin.PLUGIN_ID + ".CommConstraint"; //$NON-NLS-1$ 

	/**
	 * The provider for a bound unit cannot be resolved.
	 */
	public static final String BOUND_UNIT_PROVIDER_NOT_FOUND = DeployCorePlugin.PLUGIN_ID
			+ ".BoundUnitProviderNotFound"; //$NON-NLS-1$ 

	/**
	 * An {@link ApplicationCommunicationConstraint} cannot be matched to a
	 * {@link NetworkCommunicationConstraint} that can be applied to the hosting operating systems.
	 * <p>
	 * Value = {@value}
	 */
	public static final String CANNOT_MATCH_ACC_TO_NCC = DeployCorePlugin.PLUGIN_ID
			+ ".CannotMatchAccToNcc"; //$NON-NLS-1$

	/**
	 * An {@link ApplicationCommunicationConstraint} cannot be matched to a
	 * {@link NetworkCommunicationConstraint} that can be applied to the hosting operating systems.
	 * <p>
	 * Value = {@value}
	 */
	public static final String CANNOT_MATCH_ACC_CHILD_TO_NCC_CHILD = DeployCorePlugin.PLUGIN_ID
			+ ".CannotMatchAccChildToNccChild"; //$NON-NLS-1$

	/**
	 * An {@link ApplicationCommunicationProtocolConstraint} contains an unrecognized application
	 * protocol; port information is needed.
	 * <p>
	 * Value = {@value}
	 */
	public static final String UNKNOWN_APPLICATION_PROTOCOL_WITHOUT_PORTS = DeployCorePlugin.PLUGIN_ID
			+ ".UnknownApplicationProtocolWithoutPorts"; //$NON-NLS-1$

	/**
	 * An {@link ApplicationCommunicationProtocolConstraint} contains neither a protocol nor port
	 * configurations.
	 * <p>
	 * Value = {@value}
	 */
	public static final String NO_APPLICATION_PROTOCOL_DETAILS = DeployCorePlugin.PLUGIN_ID
			+ ".NoApplicationProtocolDetails"; //$NON-NLS-1$

	/**
	 * A {@link NetworkCommunicationProtocolConstraint} does not contain an expected
	 * {@link CommunicationPortConstraint}.
	 * <p>
	 * Value = {@value}
	 */
	public static final String EXPECTED_PORT_NOT_REQUIRED = DeployCorePlugin.PLUGIN_ID
			+ ".ExpectedPortNotRequired"; //$NON-NLS-1$

	/**
	 * A {@link NetworkCommunicationConstraint} does not contain an expected
	 * {@link TransmissionDelayConstraint}.
	 * <p>
	 * Value = {@value}
	 */
	public static final String EXPECTED_DELAY_INSUFFICIENT = DeployCorePlugin.PLUGIN_ID
			+ ".ExpectedDelayInsufficient"; //$NON-NLS-1$

	/**
	 * A {@link NetworkCommunicationConstraint} does not contain an expected
	 * {@link CommunicationBandwidthConstraint}.
	 * <p>
	 * Value = {@value}
	 */
	public static final String EXPECTED_BANDWIDTH_INSUFFICIENT = DeployCorePlugin.PLUGIN_ID
			+ ".ExpectedBandwidthInsufficient"; //$NON-NLS-1$

	/**
	 * A {@link NetworkCommunicationConstraint} does not contain an expected
	 * {@link CommunicationBandwidthConstraint}.
	 * <p>
	 * Value = {@value}
	 */
	public static final String EXPECTED_COST_INSUFFICIENT = DeployCorePlugin.PLUGIN_ID
			+ ".ExpectedCostInsufficient"; //$NON-NLS-1$

	/**
	 * A {@link NetworkCommunicationConstraint} does not contain an expected
	 * {@link CommunicationBandwidthConstraint}.
	 * <p>
	 * Value = {@value}
	 */
	public static final String COMMUNICATION_TYPE_INCOMPATIBLE = DeployCorePlugin.PLUGIN_ID
			+ ".CommunicationTypeIncompatible"; //$NON-NLS-1$

	/**
	 * Indicates that an {@link ApplicationCommunicationConstraint} is missing between two
	 * {@link Unit}s.
	 */
	public static final String MISSING_APP_COMM = DeployCorePlugin.PLUGIN_ID + ".MissingAppComm"; //$NON-NLS-1$

	/**
	 * Indicates that an {@link NetworkCommunicationConstraint} is missing between two {@link Unit}s.
	 */
	public static final String MISSING_NET_COMM = DeployCorePlugin.PLUGIN_ID + ".MissingNetComm"; //$NON-NLS-1$

	/**
	 * A unit does not have an expected ProductIdentifierConstraint.
	 * <p>
	 * Value = {@value}
	 */
	public static final String EXPECTED_PRODUCT_IDENTIFIER = DeployCorePlugin.PLUGIN_ID
			+ ".ExpectedProductIdentifier"; //$NON-NLS-1$

	/**
	 * A deploy model object has an extended attribute with a null or empty name.
	 * <p>
	 * Value = {@value}
	 */
	public static final String OBJECT_EXTENDED_ATTRIBUTE_NAME_UNDEFINED = DeployCorePlugin.PLUGIN_ID
			+ ".ObjectExtendedAttributeNameUndefined"; //$NON-NLS-1$

	/**
	 * A deploy model object has an extended attribute with a null or empty name.
	 * <p>
	 * Value = {@value}
	 */
	public static final String OBJECT_EXTENDED_ATTRIBUTE_NAME_INVALID = DeployCorePlugin.PLUGIN_ID
			+ ".ObjectExtendedAttributeNameInvalid"; //$NON-NLS-1$

	/**
	 * A import object has added to a template topology.
	 * <p>
	 * Value = {@value}
	 */
	public static final String INVALID_IMPORT_IN_TOPOLOGY_TEMPLATE = DeployCorePlugin.PLUGIN_ID
			+ ".invalidImportInTopologyTemplate"; //$NON-NLS-1$

	/**
	 * A object within the hosting stack has a capacity restriction against it somewhere higher in
	 * the stack.
	 * <p>
	 * Value = {@value}
	 */
	public static final String CAPACITY_RESTRICTION = DeployCorePlugin.PLUGIN_ID
			+ ".capacityRestriction"; //$NON-NLS-1$

	/**
	 * A object within the hosting stack has a capacity restriction against it somewhere higher in
	 * the stack has not been met..
	 * <p>
	 * Value = {@value}
	 */
	public static final String CAPACITY_EXCEEDED = DeployCorePlugin.PLUGIN_ID + ".capacityExceeded"; //$NON-NLS-1$

	/**
	 * One or more stereotypes were not found in the list of stereotypes for the {@link Unit} or
	 * {@link Capability} context.
	 * 
	 */
	public static final String STEREOTYPE_INCLUSION_FAILURE = DeployCorePlugin.PLUGIN_ID
			+ ".stereotypeInclusionFailure"; //$NON-NLS-1$

	/**
	 * Resource type id could not be located for the {@link Constraint}
	 * 
	 */
	public static final String INVALID_RESOURCE_TYPE_ID = DeployCorePlugin.PLUGIN_ID
			+ ".invalidResourceTypeId"; //$NON-NLS-1$
}
