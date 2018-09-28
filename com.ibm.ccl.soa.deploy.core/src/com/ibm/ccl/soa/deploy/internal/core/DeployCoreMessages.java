/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.pattern.IDeployValidationActivePattern;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.param.IDeployResolutionParameter;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * The externalized strings for DeployCore.
 * 
 * @since 1.0
 * 
 */
public class DeployCoreMessages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.internal.core.messages"; //$NON-NLS-1$

	/**
	 */
	public static String DeployTopologyExportService_location_file_export_error;

	/** */
	public static String UnitFilterDescriptor_An_instance_of_UnitFilter_is_required;
	/**
	 * 
	 */
	public static String UnitDiscovererDescriptor_An_instance_of_UnitDiscoverer_is_required;

	/** */
	public static String UnitProviderDescriptor_An_instance_of_TopologyUnitProvider_is_required;

	/** */
	public static String CapabilityProviderDescriptor_An_instance_of_CapabilityProvider_is_required;

	/**
	 * Message used in {@link DeployModelObject#getStatus()}.
	 */
	public static String Model_consistency_status_message;

	/** */
	public static String DomainDescriptor_Invalid_number_of_validator_eleme_;

	/**
	 * Message used to indicate that a domain descriptor could not be parsed.
	 */
	public static String DomainDescriptor_Invalid_domain_descriptor_0;

	/**
	 * Message to indicate an invalid number of content elements in a decoratorSemanticPatternBinding
	 * extension
	 */
	public static String DecoratorSemanticPatternBindingDescriptor_Invalid_number_of_content_eleme_;

	/**
	 * Message to indicate explicit entry content was declared in a non-local plugin.
	 */
	public static String DecoratorSemanticBindingRuleDescriptor_Explicit_entry_not_local;

	/** */
	public static String TopologyPublisherDescriptor_An_instance_of_0_is_required_fo_;
	/** */
	public static String TopologyExporterDescriptor_An_instance_of_0_is_required_fo_;
	/** */
	public static String TopologyDiscovererDescriptor_An_instance_of_0_is_required_fo_;

	/**
	 * Message used to indicate that a resolution element contains more than one enablement elements.
	 */
	public static String ResolutionDescriptor_Invalid_number_of_enablement_elements_in_0;

	/**
	 * Message used to indicate that more than one resolutions with the same ID have been declared in
	 * the same contributor.
	 */
	public static String ResolutionManager_Duplicate_resolution_id_0_found_in_0_and_1;

	/**
	 * Message used to indicate that more than one decorator semantic have been declared for the same
	 * ID.
	 */
	public static String TopologyManager_Duplicate_decoratorSemantic_ids_0_found_1_and_2;

	/**
	 * Message used to indicate that a constraint precondition holds.
	 */
	public static String Constraint_Precondition_holds;

	/**
	 * Message used to indicate that a constraint precondition does not hold.
	 */
	public static String Constraint_Precondition_does_not_hold;

	/**
	 * Message used to indicate that a constraint precondition can not be evaluated.
	 */
	public static String Constraint_Precondition_can_not_be_evaluated;

	// /////////////////////////////////////////////////////////////////////////////////////
	//
	// Constraint messages
	//
	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Message used to indicate that ID for constraint definition is missing.
	 */
	public static String ConstraintDescriptor_missing_ID_attribute_in_0;

	/**
	 * Message used to indicate that 'type' attribute for constraint definition is missing.
	 */
	public static String ConstraintDescriptor_missing_type_attribute_in_0;

	/**
	 * Message used to indicate that 'class' attribute for the validator element in the constraint
	 * definition is missing.
	 */
	public static String ConstraintDescriptor_missing_class_attribute_on_element_0_in_1;

	/**
	 * Message used to indicate that there should be one validator defined in a constraint
	 * declaration.
	 */
	public static String ConstraintDescriptor_should_have_one_validator_in_0;

	/**
	 * Message used to indicate that there should be at most one factory defined in a constraint
	 * declaration.
	 */
	public static String ConstraintDescriptor_should_have_at_most_one_factory_in_0;

	/**
	 * Message used to indicate that there should be at most one matcher defined in a constraint
	 * declaration.
	 */
	public static String ConstraintDescriptor_should_have_at_most_one_matcher_in_0;

	/**
	 * Message used to indicate that there should be at most one 'parentEnablement' defined in a
	 * constraint declaration.
	 */
	public static String ConstraintDescriptor_should_have_at_most_one_parent_enablement_in_0;

	/**
	 * Message used to indicate that there should be at most one 'contextEnablement' defined in a
	 * constraint declaration.
	 */
	public static String ConstraintDescriptor_should_have_at_most_one_context_enablement_in_0;

	/**
	 * Message used to indicate that certaint class instance is required in constraint declaration.
	 */
	public static String ConstraintDescriptor_instance_0_is_required_in_element_1_in_2;

	/**
	 * Message used to indicate that certaint class instance is required in constraint declaration.
	 */
	public static String ConstraintDescriptor_instance_0_is_required_in_attribute_1_in_2;

	/**
	 * Message used to indicate that more than one constraint has been declared for the same ID.
	 */
	public static String ConstraintManager_Duplicate_IDs_found_0_and_1;

	// /////////////////////////////////////////////////////////////////////////////////////
	//
	// Validation messages
	//

	/** Message used to indicate that a validator has failed. */
	public static String Validator_0_failed;

	/**
	 * Message used to indicate that an attribute of an object is undefined.
	 */
	public static String Validator_deploy_model_object_0_attribute_1_undefined;

	/**
	 * Message used to indicate that the name of an object that is an instance of a type is not set.
	 */
	public static String Validator_deploy_model_object_0_type_1_name_undefined;

	/**
	 * Message used to indicate that an attribute of an object is invalid.
	 */
	public static String Validator_deploy_model_object_0_attribute_1_invalid;

	/**
	 * Message used to indicate that a {@link DeployModelObject} has not parent container ({@link DeployModelObject#getParent()}.
	 */
	public static String Validator_deploy_model_object_0_container_undefined;

	/**
	 * Message used to indicate that a {@link Unit} has no consumed or provided services.
	 * 
	 * @see Unit#getConsumedNonHostingCapabilities()
	 * @see Unit#getOnlyDependencyCapabilities()
	 */
	public static String Validator_unit_0_has_no_requirements_or_capabilities;

	/**
	 * Message used to indicate that a {@link Unit} provides a {@link Capability} whose type is not
	 * valid.
	 */
	public static String Validator_unit_0_capability_1_invalid;

	/**
	 * Message used to indicate that a {@link Unit} with {@link Unit#getPublishIntent()}
	 * {@link PublishIntent#DO_NOT_PUBLISH} is hosted on a unit whose publish state is
	 * {@link PublishIntent#PUBLISH}.
	 */
	public static String Validator_unit_0_host_1_not_published;

	/**
	 * Message used to indicate that a {@link Unit} with {@link Unit#getPublishIntent()}
	 * {@link PublishIntent#PUBLISH} hosts one or more units whose publish state is
	 * {@link PublishIntent#DO_NOT_PUBLISH}.
	 */
	public static String Validator_unit_0_do_not_publish_hosts_publish_units;

	/**
	 * Message used to indicate that a {@link Unit} has an ambiguous hosting stack and requires
	 * elaboration; e.g. realization to a concrete {@link Unit} which is then explicitly hosted.
	 */
	public static String Validator_unit_0_has_ambiguous_hosting_st_;

	/**
	 * Message used to indicate that a {@link Unit} is missing an required capability (by type).
	 */
	public static String Validator_unit_0_capability_type_1_missing;

	/**
	 * Message used to indicate that a {@link Unit} provides an invalid number of {@link Capability}
	 * instances of the same type.
	 */
	public static String Validator_unit_0_capability_type_1_cardinality_2_invalid;

	/**
	 * Message used to indicate that a {@link Requirement} depends on more than one
	 * {@link Capability}.
	 */
	public static String Validator_unit_0_requirement_1_has_multiple_dependencies;

	/**
	 * Message used to indicate that a {@link Unit} consumes a requirement whose
	 * {@link Requirement#getCapabilityType()} is invalid.
	 */
	public static String Validator_unit_0_requirement_1_type_invalid;

	/**
	 * Message used to indicate that a {@link Unit} does not consume a requirement of the specified
	 * {@link Requirement#getCapabilityType()}.
	 */
	public static String Validator_unit_0_requirement_type_1_missing;

	/**
	 * Message used to indicate that a {@link Unit} consumes an invalid number of requirements for a
	 * specific {@link Requirement#getCapabilityType()}.
	 */
	public static String Validator_unit_0_requirement_type_1_cardinality_2_invalid;

	/**
	 * Message used to indicate that a {@link Requirement} has a {@link Requirement#getDmoEType()}
	 * that is not a subtype of {@link Unit}.
	 */
	public static String Validator_unit_0_requirement_1_dmoType_should_be_unit_type;

	/**
	 * Message used to indicated that the source of a {@link DependencyLink} is a {@link Requirement}
	 * whose {@link Requirement#getLinkType()} is not {@link RequirementLinkTypes#DEPENDENCY} or
	 * {@link RequirementLinkTypes#ANY}.
	 */
	public static String Validator_unit_0_requirement_1_link_type_forbids_dependency_link_2;

	/**
	 * Message used to indicate that a {@link Unit} consumes hosting requirements but is not the
	 * target of a {@link HostingLink}, including a description of the unsatisfied hosting
	 * requirement(s).
	 */
	public static String Validator_unit_0_not_hosted_1;

	/**
	 * Message used to indicate that a {@link Unit} consumes <it>optional</it> hosting requirements
	 * but is not the target of a {@link HostingLink}, including a description of the unsatisfied
	 * hosting requirement(s).
	 */
	public static String Validator_unit_0_not_hosted_1_optional;

	/**
	 * Message used to indicate that the host of a unit will be uninstalled.
	 */
	public static String Validator_unit_0_host_to_be_uninstalled;

	/**
	 * @see ICoreProblemType#UNIT_HOST_NOT_INSTALLED
	 */
	public static String Validator_unit_0_installed_but_host_1_not;

	/**
	 * @see ICoreProblemType#UNIT_HOST_WILL_BE_UNINSTALLED
	 */
	public static String Validator_unit_0_installed_but_host_1_will_be_uninstalled;

	/**
	 * @see ICoreProblemType#UNIT_HOST_WILL_BE_UNINSTALLED
	 */
	public static String Validator_unit_0_host_1_will_be_uninstalled;

	/**
	 * Message used to indicate that a {@link Unit} is the target of multiple hosting links.
	 */
	public static String Validator_unit_0_has_multiple_hosts;

	/**
	 * Message used to indicate that a {@link FileArtifact} has an empty
	 * {@link FileArtifact#getFileURIs()} list.
	 */
	public static String Validator_unit_0_artifact_1_has_no_URIs;

	/**
	 * Message used to indicate that {@link FileArtifact#getFileURIs()} contains an invalid URI.
	 */
	public static String Validator_unit_0_artifact_1_invalid_uri_2;

	/**
	 * Message used to indicate that a consumed {@link Capability} is not the source of a
	 * {@link DependencyLink} (@link Capability#getLink()}).
	 */
	public static String Requirement_0_dependency_link_undefined;

	/**
	 * Message used to indicate that an optional consumer {@link Requirement} is not the source of a
	 * {@link DependencyLink} (@link Capability#getLink()}).
	 */
	public static String Optional_Requirement_0_dependency_link_undefined;

	/**
	 * Message used to indicate that a {@link HostingLink} does not point to a hosted unit ({@link HostingLink#getHosted()}).
	 */
	public static String Validator_hosting_link_0_target_undefined;

	/**
	 * Message used to indicate that a link (unit, logical, dependency) has a source object whose
	 * {@link DeployModelObject#getTopology()} is null.
	 */
	public static String Validator_link_0_source_uncontained;

	/**
	 * Message used to indicate that a link (unit, logical, dependency) has must be contained at its
	 * source object.
	 */
	public static String Validator_link_0_must_be_contained_at_source_1;

	/**
	 * Message used to indicate that a link (unit, logical, dependency) has a target object whose
	 * {@link DeployModelObject#getTopology()} is null.
	 */
	public static String Validator_link_0_target_uncontained;

	/**
	 * Message used to indicate that a {@link HostingLink} targets a hosted {@link Unit} which
	 * consumes no {@link HostingCapability}.
	 */
	public static String Validator_hosting_link_0_target_unit_1_consumes_no_hosting_requirements;

	/**
	 * Message used to indicate that the {@link HostingLink} host is not its container.
	 */
	public static String Validator_hosting_link_0_container_1_is_not_the_host_2;

	/**
	 * Message used to indicate that the {@link HostingLink} host consumes a requirement whose type
	 * does not match the ones in the provided hosting capability.
	 */
	public static String Validator_hosting_link_0_requirement_1_does_not_match;

	/**
	 * Message used to indicate that the target of a {@link DependencyLink} is not a provided
	 * {@link Capability}.
	 */
	public static String Validator_dependency_link_0_target_1_is_not_valid;

	/**
	 * Message used to indicate that the target of a link is not defined.
	 */
	public static String Validator_link_0_source_undefined;

	/**
	 * Message used to indicate that the source of a link cannot be resolved.
	 */
	public static String Validator_link_0_source_1_cannot_be_resolved;

	/**
	 * Message used to indicate that the target of a link is not defined.
	 */
	public static String Validator_link_0_target_undefined;

	/**
	 * Message used to indicate that the target of a link cannot be resolved.
	 */
	public static String Validator_link_0_target_1_cannot_be_resolved;

	/**
	 * Message used to indicate that the source and target endpoints of a {@link DependencyLink} do
	 * not match.
	 */
	public static String Validator_dependency_link_0_endpoints_do_not_match;

	/**
	 * Message used to indicate that the target of the link sould be hosted by an alternative unit.
	 */
	public static String Validator_dependency_link_0_target_1_should_be_hosted_by_2;

	/**
	 * Message used to indicate that the EMF resource of a deploy model object has not been saved.
	 * 
	 * @see org.eclipse.emf.ecore.resource.Resource#save(java.util.Map)
	 */
	public static String Validation_topology_resource_0_not_saved;

	/**
	 * Message used to indicate that an {@link IResource} could not be opened.
	 */
	public static String Validation_error_opening_resource_0;

	/**
	 * Message used to indicate that an error occurred when creating an {@link IMarker};
	 */
	public static String Validation_marker_creation_error;

	/**
	 * Message used to indicate that the name of a deploy model object is not unique in its
	 * container.
	 */
	public static String Validator_deploy_model_object_0_name_not_unique_in_container_1;

	/**
	 * Message used to indicate that the attribute of an object is not uniqu in the context of some
	 * other object.
	 */
	public static String Validator_deploy_model_object_0_attribute_1_not_unique_in_the_context_of_2;

	/**
	 * Message used to indicate that a requirement is mapped to a capability which have an unequal
	 * {@link Requirement#getCapabilityType()} and {@link Capability#eClass()}.
	 */
	public static String Validator_requirement_0_type_mismatch_with_capability_1;

	/**
	 * Message used to indicate that a requirement is mapped to a capability which have an unequal
	 * {@link Requirement#getLinkType()} and {@link Capability#getLinkType()}.
	 */
	public static String Validator_requirement_0_for_type_1_does_not_match_2;

	/**
	 * Message used to indicate that a requirement expression is using an unknown interpreter.
	 */
	public static String Validator_requirement_expression_0_unknown_interpreter_1;

	/**
	 * Message used to indicate that the interpreter of a {@link RequirementExpression} failed during
	 * evaluation.
	 */
	public static String Validator_requirement_expression_0_interpreter_1_evaluation_error_2;
	/**
	 * Message used to indicate that a requirement expression interpreter did not validate agaist a
	 * value.
	 */
	public static String Validator_requirement_expression_0_interpterer_1_value_2_not_satisfied_by_target_object_3;
	/**
	 * Message used to indicate that a requirement expression interpreter did not validate agaist an
	 * attribute value.
	 */
	public static String Validator_requirement_expression_0_interpterer_1_value_2_not_satisfied_by_target_attribute_3_value_4_of_object_5;

	/**
	 * Message used to indicate that the value of a requirement expression is not valid.
	 */
	public static String Validator_deploy_model_object_0_attribute_1_value_2_invalid;

	/**
	 * Message used to indicate that the attribute of an object could not be validated, because the
	 * propagation source value is not set.
	 */
	public static String Validator_deploy_model_object_0_propagated_attribute_1_cannot_validated_because_source_is_not_set;

	/**
	 * Message used to indicate that a unit has multiple member links with the same target unit.
	 */
	public static String Validator_unit_0_has_multiple_member_links_to_unit_1;

	/**
	 * Message used to indicate that a {@link UnitValidator} was passed a unit in
	 * {@link UnitValidator#validate(Unit, com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext, com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)}
	 * of a type that is not a subtype {@link UnitValidator#getUnitType()}
	 */
	public static String Validator_unit_validator_expected_0_type_passed_object_1_of_type_2;

	/**
	 * Message used to indicate that the cardinality value for {@link InCardinality} or
	 * {@link OutCardinality} expression ({@link RequirementExpression#getValue()}) has an invalid
	 * range.
	 */
	public static String Validator_cardinality_interpreter_invalid_range_0_to_1;

	/**
	 * Message used to indicate that a group contains an invalid number of members.
	 */
	public static String Validator_group_0_requires_1_members_of_type_2_has_3;

	/**
	 * Message used to indicate that a unit must be part of a group of a specific type with specific
	 * cardinality.
	 */
	public static String Validator_unit_0_must_be_member_of_group_1_with_cardinality_2;

	/**
	 * Message used to indicate that the target of a member link is invalid.
	 */
	public static String Validator_unit_0_member_link_target_1_invalid;

	/**
	 * Message used to indicate that a {@link Unit} whose {@link Unit#isConceptual()} is true, is not
	 * realized.
	 */
	public static String Validator_conceptual_unit_0_not_realized;

	/**
	 * Message used to indicate that a {@link Unit} whose {@link Unit#isConceptual()} is false, is
	 * realized.
	 */
	public static String Validator_non_conceptual_unit_0_realized_in_link_1;

	/**
	 * Message used to indicate that a bound {@link Unit} declares an originating provider that
	 * cannot be found
	 */
	public static String Validator_provider_0_specified_in_unit_1_not_found;

	/**
	 * Message used to indicate that a {@link Capability} on a {@link Unit} whose
	 * {@link Unit#isConceptual()} is false, is realized.
	 */
	public static String Validator_capability_0_on_non_conceptual_unit_realized_in_link_1;

	/**
	 * Message used to indicate that a {@link Requirement} on a {@link Unit} whose
	 * {@link Unit#isConceptual()} is false, is realized.
	 */
	public static String Validator_requirement_0_on_non_conceptual_unit_realized_in_link_1;

	/**
	 * Message used to indicate that a {@link Capability} on a {@link Unit} is realized but the
	 * containing unit is not realized.
	 */
	public static String Validator_realized_capability_0_on_non_realized_unit_realized_in_link_1;

	/**
	 * Message used to indicate that a {@link Requirement} on a {@link Unit} is realized but the
	 * containing unit is not realized.
	 */
	public static String Validator_realized_requirement_0_on_non_realized_unit_realized_in_link_1;

	/**
	 * Message used to indicate that a {@link Capability} on a {@link Unit} is realized to a
	 * different target than containing unit
	 */
	public static String Validator_capability_0_on_unit_1_realized_to_different_target_in_link_2;

	/**
	 * Message used to indicate that a {@link DeployModelObject} which is a {@link Unit} or contained
	 * by the {@link Unit} is realized to a different target than unit or containing unit
	 */
	public static String Validator_DMO_0_realized_to_inconsistent_target_in_link_1;

	/**
	 * Message used to indicate that a {@link DeployModelObject} which is a {@link Unit} or contained
	 * by the {@link Unit} is realized to a different target than unit or containing unit
	 */
	public static String Validator_realization_link_source_0_not_contained_by_unit_1;

	/**
	 * Message used to indicate that a {@link Requirement} on a {@link Unit} is realized to a
	 * different target than containing unit
	 */
	public static String Validator_requirement_0_on_unit_1_realized_to_different_target_in_link_2;

	/**
	 * Message used to indicate that a {@link Unit} whose {@link Unit#isConceptual()} is true, has
	 * multiple realization links.
	 */
	public static String Validator_conceptual_unit_0_has_multiple_realization_links;

	/**
	 * Message used to indicate that a {@link Capability} has multiple realization links.
	 */
	public static String Validator_capability_0_has_multiple_realization_links;

	/**
	 * Message used to indicate that a {@link Requirement} has multiple realization links.
	 */
	public static String Validator_requirement_0_has_multiple_realization_links;
	/**
	 * Message used to indicate that a {@link RealizationLink} source and target types do not match.
	 */
	public static String Validator_realization_link_source_0_target_1_type_mismatch;

	/**
	 * Message used to indicate that a {@link RealizationLink} source and target stereotypes do not
	 * match.
	 */
	public static String Validator_realization_link_target_missing_required_stereotypes_0;

	/**
	 * Message used to indicate that a {@link RealizationLink} source and target are the same.
	 */
	public static String Validator_realization_link_source_target_same;

	/**
	 * Message used to indicate that {@link Import#getPattern()} is null.
	 */
	public static String Validator_topology_import_0_has_empty_pattern;

	/**
	 * Message used to indicate that a {@link Import} could not be resolved to a {@link Topology}.
	 */
	public static String Validator_topology_import_0_not_found_in_1;

	/**
	 * Message used to indicate that a {@link Instantiation} on an {@link InstanceConfiguration} on
	 * an {@link Import} is references a unresolvable {@link DeployModelObject}
	 */
	public static String Validator_instantiation_reference_0_not_resolvable;

	/**
	 * Message used to indicate that a {@link Instantiation} references an object that is not public.
	 */
	public static String Validator_instantiation_object_0_not_public;

	/**
	 * Message used to indicate that a {@link Property} of an {@link Instantiation} is referencing a
	 * non-public attribute.
	 */
	public static String Validator_instantiation_object_0_attribute_1_not_editable;

	/**
	 * Message used to indicate that a cycle in the import dependencies was found.
	 */
	public static String Validator_topology_has_import_cycle;

	/**
	 * Message used to indicate that a deploy model object contains an extended attribute at a
	 * specified index which has a null or empty name.
	 */
	public static String Validator_deploy_model_object_0_extended_attribute_at_index_1_has_no_name;

	/**
	 * Message used to indicate that an extended attribute name is not unique.
	 */
	public static String Validator_deploy_model_object_0_extended_attribute_name_1_not_unique;

	/**
	 * Message used to indicate that the name of an extended attribute conflicts with used in a
	 * static object attribute.
	 */
	public static String Validator_deploy_model_object_0_extended_attribute_1_conflicts_with_static_attribute_name;
	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Message used to indicate that the matcher found a match.
	 */
	public static String DeployMatcherStatus_Match_found_;

	/**
	 * Message used to indicate that the matcher did not find a match.
	 */
	public static String DeployMatcherStatus_Match_not_found_;

	/**
	 * Message used to indicate that the matcher did not reject a match.
	 */
	public static String DeployMatcherStatus_Match_not_rejected_;

	/**
	 * Message used to indicate that the matcher counld not find a match because the source and
	 * target units were the same.
	 */
	public static String DeployMatcherStatus_Cannot_Create_Link_To_Self;

	/**
	 * Message used to indicate that the matcher counld not find a match because the source and
	 * target units were the same.
	 */
	public static String DeployMatcherStatus_Realization_Cycle;

	/**
	 * Message used to indicate that the matcher could not find a match because the source and target
	 * units are already linked.
	 */
	public static String DeployMatcherStatus_Link_Already_Present;

	/**
	 * Message used to indicate that the matcher can not identify a hosting link between units.
	 */
	public static String DeployMatcherStatus_Hosting_Link_Not_Possible;

	/**
	 * Message used to indicate that the matcher does not allow a private unit to be a host.
	 */
	public static String DeployMatcherStatus_Private_Unit_Cannot_Be_Host;

	/**
	 * Message used to indicate that the matcher does not allow hosting of an unhosted private unit.
	 */
	public static String DeployMatcherStatus_Private_Unit_Cannot_Be_Hosted;

	/**
	 * Message used to indicate that the matcher does not allow a new realization link from a private
	 * unit.
	 */
	public static String DeployMatcherStatus_Private_Unit_Cannot_Be_Realized;

	/**
	 * Message used to indicate that the matcher does not allow a new realization link to a private
	 * unit.
	 */
	public static String DeployMatcherStatus_Private_Unit_Cannot_Be_Realization_Target;

	/**
	 * Message used to indicate that the matcher does not allow a private requirement to be source of
	 * a dependency link
	 */
	public static String DeployMatcherStatus_Private_Requirement_Cannot_Be_Link_Source;
	/**
	 * Message used to indicate that the matcher does not allow a private capability to be target of
	 * a dependency link
	 */
	public static String DeployMatcherStatus_Private_Capability_Cannot_Be_Link_Target;

	/**
	 * Message used to indicate that the matcher can not identify a member link between units.
	 */
	public static String DeployMatcherStatus_Member_Link_Not_Possible;

	/**
	 * Message used to indicate that the matcher can not identify a realization link between units.
	 */
	public static String DeployMatcherStatus_Realization_Link_Not_Possible;

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * link type
	 */
	public static String DeployMatcherStatus_Realization_Link_Type_Mismatch;

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * link stereotype
	 */
	public static String DeployMatcherStatus_Realization_Link_Stereotype_Mismatch;

	/**
	 * Message used to indicate that the matcher can not identify a realization link between units
	 * because a matching capability LinkType was not found on the target
	 */
	public static String DeployMatcherStatus_Realization_Link_Capability_Link_Type_Mismatch;

	/**
	 * Message used to indicate that the matcher can not identify a realization link between units
	 * because a matching requirement LinkType was not found on the target
	 */
	public static String DeployMatcherStatus_Realization_Link_Requirement_Link_Type_Mismatch;

	/**
	 * Message used to indicate that the matcher can not identify a realization link between units
	 * because a matching requirement "use" was not found on the target
	 */
	public static String DeployMatcherStatus_Realization_Link_Requirement_Use_Mismatch;

	/**
	 * Message used to indicate that the matcher can not identify a realization link between units
	 * because a matching requirement dmoType was not found on the target
	 */
	public static String DeployMatcherStatus_Realization_Link_Requirement_Dmo_Type_Mismatch;

	/**
	 * Message used to indicate that the matcher can not identify a realization link between a
	 * conceptual node and a target unit because hosting requirements of conceptual node were not
	 * satisified by the target.
	 */
	public static String DeployMatcherStatus_Realization_Link_Conceptual_Node_Hosting_Requirement_0_Not_Satisfied;

	/**
	 * Message used to indicate that a unit with initial install state == installed cannot be hosted:
	 * it must already be hosted if it is installed.
	 */
	public static String DeployMatcherStatus_Installed_Unit_Cannot_Be_Hosted;

	/**
	 * Message used to indicate that a unit with initial install state == installed cannot be link
	 * source; must already be satisfied
	 */
	public static String DeployMatcherStatus_Installed_Unit_Cannot_Be_Source;

	/**
	 * Message used to indicate that a source unit of a realization link must be conceptual
	 */
	public static String DeployMatcherStatus_Source_Must_Be_Conceptual;

	/**
	 * Message used to indicate that hoster of conceptual unit is invalid
	 */
	public static String DeployMatcherStatus_Realization_Invalid_Hoster;

	/**
	 * Message used to indicate that hostees of conceptual unit are invalid
	 */
	public static String DeployMatcherStatus_Realization_Invalid_Hostees;

	/**
	 * Message used to indicate that a hostee of candidate realization would be invalid
	 */
	public static String DeployMatcherStatus_Realization_Hostee_0_on_1_Invalid;

	/**
	 * Message used to indicate that a dependency link to unit would be invalid after realization
	 */
	public static String DeployMatcherStatus_Realization_Dependency_Link_From_0_to_1_Invalid;

	/**
	 * Message used to indicate that dependency link target from conceptual unit is invalid
	 */
	public static String DeployMatcherStatus_Realization_Invalid_DL_Target;

	/**
	 * Message used to indicate that dependency link sources to conceptual unit are invalid
	 */
	public static String DeployMatcherStatus_Realization_Invalid_DL_Sources;

	/**
	 * Message used to indicate that conceptual unit is member of invalid groups
	 */
	public static String DeployMatcherStatus_Realization_Invalid_Groups;

	/**
	 * Message used to indicate that conceptual unit has invalid group members
	 */
	public static String DeployMatcherStatus_Realization_Invalid_Members;

	/**
	 * Message used to indicate that conceptual unit has a capability not matched on realization
	 * target unit.
	 */
	public static String DeployMatcherStatus_Realization_Capability_0_Unmatched;
	/**
	 * Message used to indicate that conceptual unit has a pair of capabilities not matched on
	 * realization target unit.
	 */
	public static String DeployMatcherStatus_Realization_Capability_Pair_0_1_Unmatched;

	/**
	 * Message used to indicate that conceptual unit has a capability not matched on realization
	 * target unit.
	 */
	public static String DeployMatcherStatus_Realization_Requirement_0_Unmatched;

	/**
	 * Message used to indicate that dmo has a constraint that is not satisfied on the final
	 * realization of a potential realization match.
	 */
	public static String DeployMatcherStatus_Realization_Constraint_Not_Satisfied_On_Final_Realization;

	/**
	 * Message used to indicate that DeployModelObject has a attribute value not matched on
	 * realization target DeployModelObject.
	 */
	public static String DeployMatcherStatus_Realization_Attribute_Unmatched;

	/**
	 * Message used to indicate that DeployModelObject has a attribute with metadata not matched on
	 * the corresponding attribute on realization target DeployModelObject.
	 */
	public static String DeployMatcherStatus_Realization_Attribute_MetaData_Unmatched;

	/**
	 * Message used to indicate that the matcher can not identify a dependency link between
	 * endpoints.
	 */
	public static String DeployMatcherStatus_Dependency_Link_Not_Possible;

	/**
	 * Message used to indicate that the matcher cannot identify a dependency link because the source
	 * has an initial install state of "installed".
	 */
	public static String DeployMatcherStatus_Cannot_Add_Dependencies_To_Installed_Unit;

	/**
	 * Message used to indicate that the matcher can not identify a logical link between endpoints.
	 */
	public static String DeployMatcherStatus_Logical_Link_Not_Possible;

	/**
	 * Message used to indicate that the matcher can not identify a logical hosting link between
	 * endpoints.
	 */
	public static String DeployMatcherStatus_Logical_Hosting_Link_Not_Possible;

	/**
	 * Message used to indicate that the matcher can not identify a unit link between units.
	 */
	public static String DeployMatcherStatus_Unit_Link_Not_Possible;

	/**
	 * Message used to indicate that the matcher can not identify a logical link between endpoints
	 * because one already exists.
	 */
	public static String DeployMatcherStatus_Logical_Link_Already_Present;

	public static String LinkDescriptor_UnknownLinkType;
	public static String LinkDescriptor_LinkDeletionFails;
	public static String LinkDescriptor_LinkDeletionSuccess;

	/**
	 * Message used to indicate that the target of a {@link IDeployStatus} is undefined.
	 * 
	 * @see IDeployStatus#getDeployObject()
	 */
	public static String Deploy_message_target_undefined;

	/**
	 * The name of a validation job.
	 */
	public static String Deploy_topology_0_validation_job;

	/**
	 * Status message for failed validations.
	 */
	public static String Deploy_validation_failed;

	/**
	 * Status message for cancelled validations.
	 */
	public static String Deploy_validation_cancelled;

	/**
	 * The name of the job of saving markers.
	 */
	public static String Saving_markers_job;

	public static String DEPENDENCY;

	public static String HOSTING;

	public static String CONSTRAINT;

	public static String MEMBER;

	public static String REALIZATION;

	static {
		NLS.initializeMessages(BUNDLE_NAME, DeployCoreMessages.class);
	}

	// deploy status resolution

	/** Message used to indicate that the generation of resolutions failed. */
	public static String Resolution_generator_failure;

	public static String Resolution_set_attribute_0_to_value_1;

	public static String Resolution_set_attribute_0_not_found_on_1;

	public static String Resolution_set_attribute_0_on_object_1_to_value_of_attribute_2_of_object_3;

	public static String Resolution_assign_unique_name;

	public static String Resolution_create_dependency_link_from_0_to_1;

	public static String Resolution_host_0_on_1;

	public static String Resolution_logically_host_0_on_1;

	public static String Resolution_create_logical_link_to_0;

	public static String Resolution_create_logical_link_from_0_to_1;

	public static String Resolution_realize_0_by_1;

	public static String Resolution_realize_stack_at_0_by_stack_at_1;

	public static String Resolution_realize_set_at_0_by_set_at_1;

	// set all attributes resolution

	public static String Resolution_set_all_attribute_values_in_topology;

	public static String Resolution_set_all_attribute_values_in_unit;

	public static String Resolution_realize_all_conceptual_units_in_topology;

	public static String Resolution_searching_conceptual_units;

	public static String Resolution_duplicating_topology;

	public static String Resolution_searching_attribute_values;

	public static String Resolution_setting_attribute_values;

	public static String Resolution_propagation_cycle_found_or_max_length_exceeded;

	/**
	 * Resolution to delete a hosting link.
	 */
	public static String Resolution_unhost_0_from_1;

	/**
	 * Resolution which sets {@link Unit#getInitInstallState()} to
	 * {@link InstallState#INSTALLED_LITERAL}.
	 */
	public static String Resolution_set_unit_0_init_install_state_to_installed;

	public static String Marker_resolution_failed;

	/**
	 * Default resolution description uses class name.
	 */
	public static String Resolution_resolve_using_0;

	/**
	 * Message used to indicate that a resolution generator class name cannot be resolved to a Java
	 * {@link Class}.
	 */
	public static String Resolution_generator_class_0_missing;

	/**
	 * Message used to indicate a resolution which is to uninstall a unit and all its hosted units
	 * recursively.
	 */
	public static String Resolution_uninstall_unit_and_all_hosted_units;

	/**
	 * Message used to indicate a resolution which is to uninstall a unit.
	 */
	public static String Resolution_uninstall_unit;

	/**
	 * Message used to indicate that an XML namespace cannot be resolved.
	 */
	public static String Cannot_resolve_namespace_0;

	/**
	 * {@link IDeployReporter#addStatus(IDeployStatus)} invoked with a status having a null message.
	 */
	public static String Validator_reported_status_with_null_message;

	/**
	 * {@link IDeployReporter#addStatus(IDeployStatus)} invoked with a status having a null deploy
	 * object.
	 */
	public static String Validator_reported_status_0_on_null_object;

	/* TOPOLOGY EXPORT */
	/**
	 * 
	 */
	public static String DEPLOYMENTTOPOLOGYEXPORT_EXPORTER_UNDEFINED;
	/**
	 * 
	 */
	public static String DEPLOYMENTTOPOLOGYEXPORT_TOPOLOGY_UNDEFINED;
	/**
	 * 
	 */
	public static String DEPLOYMENTTOPOLOGYEXPORT_DESTINATION_INVALID;
	/**
	 * 
	 */
	public static String EXPORT_DEPLOYMENT_TOPOLOGY_FAILED_ERROR;
	/**
	 * 
	 */
	public static String DeployTopologyExportService_file_open_error;
	/**
	 * 
	 */

	public static String DeployTopologyExportService_location_file_creation_error;

	/**
	 * Message used to indicate that the value passed to {@link ExtendedAttribute#setValue(Object)}
	 * is not an instance of {@link ExtendedAttribute#getInstanceType()}.
	 */
	public static String Extended_attribute_value_must_be_instance_of_0_not_1;

	/**
	 * Message used to indicate that an extended attribute has no
	 * {@link ExtendedAttribute#getInstanceType()}.
	 */
	public static String Extended_attribute_0_has_no_instance_type_on_object_1;

	/**
	 * @see IDeployValidationActivePattern
	 */
	public static String Active_pattern_fail_no_fix;

	/**
	 * @see IDeployValidationActivePattern
	 */
	public static String Active_pattern_fail_has_fix;

	/**
	 * Message used by resolution to change the publish intent of all hosted units of a unit to DO
	 * NOT PUBLISH.
	 */
	public static String Resolution_do_not_publish_all_hosted_units;

	/**
	 * Resolution to change the install state of a unit and all its hosted configuration units to
	 * installed (recursive).
	 */
	public static String Resolution_set_unit_0_and_all_configuration_units_to_installed;

	/**
	 * Resolution to change a unit's visibility to public (from private)
	 */
	public static String Resolution_Make_Unit_Public;

	/**
	 * Resolution to change a requirement's visibility to public (from private)
	 */
	public static String Resolution_Make_Requirement_Public;

	/**
	 * Resolution to change an attributes's visibility to public editable (from public or private)
	 */
	public static String Resolution_Make_Attribute_Public_Editable;

	/**
	 * Message used to indicate that the serialization of a value of the specified type failed.
	 */
	public static String Error_serializing_instance_of_type_0;

	/**
	 * Message used to indicate that the deserialization of a value failed.
	 */
	public static String Error_deserializing_value;

	/**
	 * Message used to indicate that the execution of a domain validator resulted in an error.
	 */
	public static String Domain_validator_0_execution_error_1_over_topology_2;

	/**
	 * Message used to indicate that a topology discoverer caused an error.
	 */
	public static String Topology_discoverer_0_error_1;

	/**
	 * Message used to indicate that an attribute type is not of the expected type.
	 */
	public static String Attribute_0_type_1_not_a_subtype_of_2;

	/**
	 * "null"
	 */
	public static String null_value;

	public static String CreateTopologyDataModelProvider_The_source_path_0_is_not_a_vali_;
	public static String CreateTopologyDataModelProvider_The_topology_source_path_0_does_;
	public static String CreateTopologyDataModelProvider_The_container_for_the_path_0_do_;
	public static String CreateTopologyDataModelProvider_The_topology_name_cannot_be_empty_;
	public static String CreateTopologyDataModelProvider_The_topology_name_contains_invalid_;
	public static String CreateTopologyDataModelOperation_Create_Topolog_;
	public static String CreateTopologyDataModelProvider_The_source_folder_is_required_;
	public static String CreateTopologyDataModelProvider_Created_on_0_;
	public static String CreateTopologyDataModelProvider_The_selected_souce_folder_project_;
	public static String CreateTopologyDataModelProvider_The_selected_souce_folder_project__2;
	public static String CreateTopologyDataModelProvider_A_topology_named_0_already_exis_;
	public static String CreateTopologyDataModelProvider_A_topology_type_that_will_not_const_;
	public static String CreateTopologyDataModelProvider_The_source_folder_is_limitted_to_a_;

	public static String DomainManager_DeployModelObject_is_not_contained_;

	public static String CreateTopologyDataModelOperation_Failed_to_create_0_source_folde_;

	public static String ImplementationRefactoring_Implementation_Refactorin_;
	public static String ImplementationRefactoringProcessor_Component_Implementation_Processo_;
	public static String SkeletonImplementationParticipant_A_implementation_participant_failed_;
	public static String SkeletonImplementationParticipant_Invalid_implementation_participan_;
	public static String ImplementationParticipantDescriptor_An_extension_defined_by_0_must_sp_;
	public static String ImplementationParticipantDescriptor_An_implementationParticipant_define_;
	public static String DatamodelDrivenChange_Red_;
	public static String DatamodelDrivenChange_Redo_0_;
	public static String DatamodelDrivenChange_Und_;
	public static String DatamodelDrivenChange_Undo_0_;
	public static String ImplementationRefactoringProcessor_Implement_the_0_component_;
	public static String ImplementationRefactoringProcessor_Verifying_the_implementation_refact_;
	public static String ImplementationRefactoringProcessor_Creating_the_implementation_refacto_;
	public static String ConceptualNodePatternValidator_Non_matching_communication_protocol_;
	public static String CreateTopologyDataModelProvider_The_decorator_semantic_name_0_i_;
	public static String CreateTopologyDataModelProvider_The_source_path_0_resolves_to_a_;
	public static String CreateTopologyDataModelProvider_The_namespace_must_not_start_or_end_;
	public static String CreateTopologyDataModelProvider_The_namespace_cannot_contain_consec_;
	public static String CreateTopologyDataModelProvider_By_convention_namespaces_typically_;
	public static String CreateTopologyDataModelProvider_0_is_an_invalid_character_in_the_;
	public static String CreateTopologyDataModelProvider_The_namespace_doesn_t_exist_and_wil_;
	public static String CreateTopologyDataModelProvider_Spaces_are_not_valid_characters_in_;

	/**
	 * Message used to indicate that there was an error loading a template.
	 * 
	 * @see ResolutionUtils#addFromTemplate(String, Topology)
	 */
	public static String Error_loading_template_0;

	/**
	 * Message used to resolve an error by creating a new unit of type 0 and host it on unit 1.
	 */
	public static String Resolution_host_new_0_on_1;

	/**
	 * Message used to denote a malformed URL for a resource type icon
	 */
	public static String Malformed_resource_type_icon_url_0;

	/**
	 * Message used to indicate that a {@link RequirementExpression#getAttributeName()} is not
	 * defined on the object on which it is evaluated.
	 */
	public static String Requirement_expression_0_attribute_1_not_found_on_object_2;
	public static String CoreDomainValidator_0_does_not_match_the_expected_na_;
	public static String CoreDomainValidator_The_topology_file_name_should_match_;
	public static String RealizedTopology_cant_be_realize_;
	public static String RealizedTopology_Cant_derive_unit_from_realization_;
	public static String RealizedTopology_missing_target_from_hosting_lin_;

	public static String REFERENCE_LINKED_INTERFACE_MISMATCH;
	public static String REFERENCE_LINK_TYPE_INVALID;
	public static String ChangeScope_Creating_Loc_Binding_0_;
	/**
	 * Message used to indicate that an imported topology collection is immutable.
	 */
	public static String Imported_topology_collection_immutable;
	public static String ChangeScope_Creating_Topology_0_;
	public static String ChangeScope_Save_Changes_Operatio_;
	public static String ChangeScope_Create_model_of_type_0_;
	public static String ChangeScope_Release_referencees_to_shared_resou_;
	public static String CreateTopologyDataModelOperation_Configuring_Decorator_Semanti_;
	public static String CreateTopologyDataModelOperation_Configuring_Configuration_Contrac_;
	public static String UnitProvider_Resolving_Units_for_0_;
	public static String TopologyImportProvider_The_source_file_0_does_not_co_;
	public static String TopologyImportProvider_Cannot_import_a_Topology_into_itsel_;
	public static String TopologyImportProvider_Cross_project_imports_are_not_yet_s_;
	public static String ImportRefactoringProcessor_Verifying_the_import_refactoring_wi_;
	public static String ImportRefactoringProcessor_Import_0_into_the_mode_;

	public static String ImportRefactoringProcessor_Calculating_changes_for_importing_;
	public static String ReflectionRefactoringProcessor_Component_Reflection_Processo_;

	public static String UpdateContractOperation_No_contract_defined_for_0_;
	public static String Action_Precondition_Test_0_failed;
	public static String TopologyImportProvider_Validating_import_;
	public static String TopologyImportProvider_Import_for_0_already_exists_in_;
	public static String LocationBindingService_Could_not_save_location_binding_res_;
	public static String CreateTopologyDataModelProvider_Projects_cannot_be_used_as_source_f_;
	public static String UnitProvider_Resolving_units_;
	public static String UnitProvider_Resolving_links_;

	public static String Constraint_type_0_has_no_validator;
	public static String Constraint_0_type_1_empty;
	public static String Constraint_0_no_child_constraint_satisfied;
	public static String Constraint_0_type_1_has_too_many_child_constraints;
	public static String Constraint_0_null_context;
	public static String Constraint_0_parent_1_is_invalid;
	public static String Constraint_0_invalid_context_1;
	public static String Constraint_false;
	public static String Constraint_0_attribute_1_malformed;
	public static String Constraints_not_satisfied;

	public static String Target_unit_0_is_missing_capability_1;

	public static String Constraint_0_malformed_on_object_1;
	public static String Attribute_constraint_0_has_empty_attribute_name;
	public static String Attribute_constraint_0_attribute_1_not_found_on_object_2;
	public static String Attribute_constraint_0_not_satisfied_by_target_attribute_1_value_2_of_object_3;
	public static String Range_constraint_0_on_object_1_attribute_not_comparable;
	public static String Structural_constraint_0_link_source_undefined;
	public static String Structural_constraint_0_link_target_undefined;
	public static String Collocation_constraint_0_is_violated;
	public static String Collocation_constraint_0_different_units;
	public static String Collocation_constraint_0_hosting_stack_incomplete;
	public static String Anti_collocation_constraint_0_is_violated;
	public static String Anti_collocation_constraint_0_different_units;
	public static String Anti_collocation_constraint_0_hosting_stack_incomplete;
	public static String Deferred_hosting_constraint_0_is_violated;
	public static String Deferred_hosting_constraint_0_different_units;
	public static String Deferred_hosting_constraint_0_hosting_stack_incomplete;
	public static String Hosting_constraint_0_stack_malformed;
	public static String Object_0_type_1_violates_type_constraint_2;

	public static String CapabilityCaptionProvider_0_in_1_;
	public static String CapabilityCaptionProvider_no_0_;
	public static String LinkDiscoveryDataModelProvider_Please_select_a_check_box_in_the_ta_;
	public static String LinkDiscoveryDataModelProvider_Requirements_may_only_link_to_singl_;
	public static String LinkDiscoveryDataModelProvider_A_Unit_may_only_be_hosted_by_one_Un_;
	public static String DiscoveryDescriptor_no_ID_;
	public static String UnitCaptionProvider_0_on_1_;
	public static String True_i_;
	public static String Version_versio_;
	public static String UnitCaptionProvider_in_;
	public static String ContractProviderManager_Make_Conceptual_Units_Public_By_Def_;
	public static String ContractProviderManager_Make_All_Units_Private_By_Defaul_;
	public static String ContractProviderManager_Make_All_Units_Public_By_Defaul_;
	public static String ResourceTypeDescriptor_Resource_type_eclass_0_not_found_;
	public static String ResourceTypeDescriptor_ePackage_not_found_for_namespace_0_;

	// deploy status resolution

	/**
	 * Message used to indicate that no parameterizers have been found for a resolution.
	 */
	public static String Resolution_0_no_parameterizers_found;

	/**
	 * Message used to indicate that a resolution failed with the specified error.
	 */
	public static String Resolution_0_failed_with_error_1;

	/**
	 * @see IDeployResolutionParameter#getValue()
	 * @see IDeployResolutionParameter#getType()
	 */
	public static String Resolution_0_parameter_1_value_2_not_an_instance_of_3;

	/**
	 * @see IDeployResolutionParameter#getValue()
	 * @see IDeployResolutionParameter#getValidValueDescriptors()
	 */
	public static String Resolution_0_parameter_1_can_only_be_null;

	/**
	 * @see IDeployResolutionParameter#getValue()
	 * @see IDeployResolutionParameter#getValidValueDescriptors()
	 */
	public static String Resolution_0_parameter_1_value_2_not_valid;

	/** Message used to indicate that the generation of resolutions failed. */

	public static String Resolution_set_attribute_0_on_1;

	public static String ResolutionManager_Duplicate_parameterizer_id_0_found_in_0_and_1;
	/**
	 * Message used to indicate that a resolution parameterizer class name cannot be resolved to a
	 * Java {@link Class}.
	 */
	public static String Resolution_parameterizer_class_0_missing;

	public static String ImportToTopologyDatamodelOperation_Importing_Resources_into_Topology_;

	public static String ImportToTopologyDatamodelOperation_Could_not_import_selected_resources_;

	public static String ImportToTopologyDatamodelOperation_Resolving_stubs_;

	public static String ImportToTopologyDatamodelOperation_Resolving_resources_;

	public static String TypeConstraintValidator_dmoType_0_;

	public static String Resolution_delete_link;

	public static String Resolution_unset_override_of_imported_object_0_attribute_1;

	public static String Resolution_unset_all_overrides_of_imported_object_0;

	public static String Resolution_add_missing_stereotype_to_unit_0;

	public static String Resolution_add_missing_stereotype_to_capability_0;

	/**
	 * Message used to identify the model validator group which performs the basic model validation
	 * work.
	 * 
	 * @see IDomainValidator#getGroupDescription()
	 */
	public static String Model_validation;

	/**
	 * Message used to identify the model validator group which computes the available model actions.
	 * 
	 * @see IDomainValidator#getGroupDescription()
	 */
	public static String Model_actions;

	/**
	 * Message used to identify the model validator group which computes the available conceptual
	 * units realization.
	 * 
	 * @see IDomainValidator#getGroupDescription()
	 */
	public static String Model_realization;

	/**
	 * Message used to indicate that a job is waiting for some task to finish.
	 */
	public static String Waiting_for_0;

	/**
	 * Message used to indicate that a data model attribute is not defined.
	 * 
	 * @see IDataModel#getProperty(String)
	 */
	public static String Attribute_0_not_defined;

	/**
	 * Message used to indicate that the type of a value of a data model attribute is invalid.
	 * 
	 * @see IDataModel#getProperty(String)
	 */
	public static String Attribute_0_value_type_1_invalid;

	/**
	 * Message used to indicate that the value of a datamodel attribute is invalid.
	 * 
	 * @see IDataModel#getProperty(String)
	 */
	public static String Attribute_0_value_1_invalid;

	/**
	 * Message used to indicate that a data model is not nested a data model.
	 * 
	 * @see IDataModel#getNestedModel(String)
	 */
	public static String Data_model_0_not_nested_in_1;

	public static String CommunicationConstraintDataModelProvider_Port_must_be_an_integer_;

	public static String SetInterfaceResolution_Set_interface_of_0_;

	public static String IDeployStatusGroupType_Realize_Concptual_Unit_;

	public static String IDeployStatusGroupType_Perform_Custom_Action_;

	public static String IDeployStatusGroupType_Host_Unit_;

	public static String IDeployStatusGroupType_Resolve_Missing_Dependencie_;

	public static String IDeployStatusGroupType_Fix_Mismatched_Attribute_;

	public static String IDeployStatusGroupType_Set_Missing_Attribute_;

	public static String IDeployStatusGroupType_OTHE_;

	public static String CapabilityCaptionProvider_PART_SUBPART;

	public static String DeployStatusGrouper_not_matche_;

	public static String COMMCONSTRAINT_001;
	public static String COMMCONSTRAINT_002;

	public static String TopologyNamespaceRootIndex_Writing_topology_namespace_root_ind_;

	public static String ContractProviderManager_Make_All_Units_Public_Editable_By_D_;

	public static String InstanceConfigurationImpl_Reloading_imported_resource_from_di_;

	/**
	 * Message used to indicate that we can not find EMF package for this namespace.
	 */
	public static String No_EMF_package_for_namespace_0;

	/**
	 * Message used to indicate that we can not find EClass for the given type name.
	 */
	public static String No_EClass_for_type_name_0;

	public static String UnitAmplifierDescriptor_Instance_of_TopologyUnitAmplifier_i_;

	public static String MethodHandler_Cannot_modify_a_non_editable_field_;

	/**
	 * Messages used for communication constraint validation/resolution
	 */
	public static String Validator_acc_cannot_be_matched_between_0;

	public static String Validator_acc_child_constraint_cannot_be_matched_0;

	public static String Validator_acpc_unknown_protocol_requires_port_specification;

	public static String Validator_acpc_unspecified_application_protocol_details;

	public static String Validator_cpc_Match_not_found;

	public static String Validator_cpc_expected_port_not_required;

	public static String Validator_tdc_expected_delay_insufficient;

	public static String Validator_cbc_expected_bandwidth_insufficient;

	public static String Validator_ccc_expected_cost_insufficient;

	public static String Validator_ctc_incompatible_types;

	public static String Resolution_DeleteApplicationCommunicationConstraint_0;

	public static String Resolution_AddCommunicationConstraint_0;

	public static String Resolution_ModifyCommunicationConstraint_0_1;

	public static String Resolution_AddNetworkCommunicationConstraint_Between_0;

	public static String Resolution_ModifyOsNetworkCommunicationConstraint;

	public static String RealizationConstraintValidator_Validating_realizations_of_0_;

	public static String RealizationConstraintValidator_Cannot_realize_0_to_1_Unsa_;

	public static String RealizationConstraintValidator_0_;

	public static String RealizationConstraintValidator_0_1_;

	public static String RealizationConstraintValidator_0_1__2;

	public static String RealizationConstraintFactory_Realization_Constrain_;

	public static String RealizationConstraintValidator_0_1__3;

	public static String RealizationConstraintValidator_0_1__4;

	public static String ProductIdentifierConstraintValidator_Unable_to_resolve_identifier_versio_;

	public static String ProductIdentifierConstraintValidator_Product_Version_Constraint_is_not_i_;

	public static String ProductIdentifierConstraintValidator_Unit_0_is_missing_a_valid_product_;

	public static String ApplicationCommunicationProtocolConstraintValidator_Application_Layer_Protoco_;

	public static String AutoRealizationDomainValidator;

	public static String GenericRequirementSatisfactionDomainValidator;

	public static String ExceptionSettingAttribute_0;

	public static String Query_Unable_to_construct_IndexContext_in_;
	public static String Query_The_workspace_root_was_null_;
	public static String Query_The_workspace_was_null_;
	public static String Query_Unable_to_construct_IndexContext_in__2;

	public static String ExplicitContractImpl_Cannot_export_0_because_it_is_not_;

	/** An error message indicating that a required object attribute is null. */
	public static String Required_attribute_0_of_object_1_is_null;

	/** An error message indicating that a required object attribute is an empty string. */
	public static String Required_attribute_0_of_object_1_is_empty;

	/** Describes a constraint that an attribute be defined. */
	public static String Attribute_0_defined;

	/**
	 * Empty 'sourceAttributeName' on AttributePropagationConstraint.
	 */
	public static String Attribute_propagation_constraint_0_empty_source_attribute_name;

	/**
	 * Empty 'targetAttributeName' on AttributePropagationConstraint.
	 */
	public static String Attribute_propagation_constraint_0_empty_target_attribute_name;

	/**
	 * The source propagation constraint is not in the topology.
	 */
	public static String Attribute_propagation_constraint_0_source_not_in_topology;

	/**
	 * The target propagation constraint is not in the topology.
	 */
	public static String Attribute_propagation_constraint_0_target_not_in_topology;

	/**
	 * Attribute propagation constraint: can not resolve source object.
	 */
	public static String Attribute_propagation_constraint_0_can_not_resolve_source_object;

	/**
	 * Attribute propagation constraint: can not resolve target object.
	 */
	public static String Attribute_propagation_constraint_0_can_not_resolve_target_object;

	/**
	 * Message used to indicate that a propagation constraint is contained in a requirement with an
	 * unsupported link type.
	 */
	public static String Attribute_propagation_constraint_0_unsupported_requirement_1_link_type_2;

	/**
	 * Attribute propagation constraint: can not resolve object URI on context object.
	 */
	public static String Attribute_propagation_constraint_0_can_not_resolve_object_1_on_2;

	/**
	 * Attribute propagation constraint: can not propagate because value can not be converted to
	 * target attribute type.
	 */
	public static String Attribute_propagation_constraint_0_can_not_convert_value;

	/** Message used to indicate a propagation to an attribute. */
	public static String Propagate_to_target_0_attribute_1;

	/** Message used to indicate a propagation from an attribute. */
	public static String Propagate_from_source_0_attribute_1;

	public static String AddToPaletteDataModelProvider_Please_enter_a_Palette_entry_name_;

	public static String AddToPaletteDataModelProvider_Please_enter_a_Stack_name_;

	public static String AddToPaletteDataModelProvider_Palette_entry_name_is_already_in_us_;

	public static String PaletteConstraintValidator_Imported_topologies_are_not_support_;

	public static String PaletteConstraintValidator_UnknownResourceTypeId_0;

	public static String PaletteConstraintValidator_Add_import_error_statu_;

	public static String AddToPaletteDataModelProvider_Template_created_on_0_;

	public static String AddToPaletteDataModelProvider_The_template_name_can_not_be_empty_;

	public static String AddToPaletteDataModelProvider_The_template_name_contains_an_inval_;

	public static String ResourceTypeService_Modify_templateUri_and_templateVuri_;

	public static String CreateNamespaceDataModelProvider_A_namspace_with_the_specified_name_;

	public static String CreateTopologyDataModelProvider_Select_the_next_button_to_customize_;

	public static String StereotypeConstraintValidator_Unit_0_;

	public static String StereotypeConstraintValidator_Capability_0_;

	public static String StereotypeConstraintValidator_0_constraint_on_1_failed_2_;

	public static String StereotypeConstraintValidator_0_includes_1_;

	public static String CapacityConstraintValidator_Removing_existing_Capacity_statu_;

	public static String CapacityConstraintValidator_Exclusive_capacity_restriction_leve_;

	public static String CapacityConstraintValidator_Shared_capacity_restriction_leverag_;

	public static String CapacityConstraintValidator_Capacity_restrictions_exceeded_for_;

	public static String AttributeCapacityConstraintValidator_0_1_;

	public static String DeployModelObjectRefresherFactory_Unit_provider_not_foun_;

	public static String DeployModelObjectRefresher_Could_not_find_underlying_objec_;

	public static String DeployModelObjectRefresher_Could_not_find_input_objec_;

	public static String DeployModelObjectRefresher_Could_not_create_stubs_from_input_o_;

	public static String UnitRefresherFactory_Error_occurred_refreshing_uni_;

	public static String UnitRefresherFactory_refrsh_unit_s_;

	public static String Delete_constraint_from_topology;

	public static String CoreDomainValidator_The_topology_file_0_does_not_exis_;

	public static String MemoryMultiplier_byt_;

	public static String MemoryMultiplier_byte_;

	public static String CapacityConstraintValidator_;

	public static String CapacityConstraintValidator_Capacity_constraints_for_0_;

	public static String IConstants_Non_;

}
