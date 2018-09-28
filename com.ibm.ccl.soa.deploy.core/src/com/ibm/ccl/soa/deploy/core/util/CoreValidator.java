/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeployModelObjectSet;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Exported;
import com.ibm.ccl.soa.deploy.core.ExportedUnit;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.Visibility;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage
 * @generated
 */
public class CoreValidator extends EObjectValidator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final CoreValidator INSTANCE = new CoreValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
	 * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.ibm.ccl.soa.deploy.core"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written
	 * constants. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written
	 * constants in a derived class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CoreValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EPackage getEPackage() {
		return CorePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresonding classifier of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map context) {
		switch (classifierID)
		{
		case CorePackage.ANNOTATION:
			return validateAnnotation((Annotation) value, diagnostics, context);
		case CorePackage.ARTIFACT:
			return validateArtifact((Artifact) value, diagnostics, context);
		case CorePackage.ATTRIBUTE_META_DATA:
			return validateAttributeMetaData((AttributeMetaData) value, diagnostics, context);
		case CorePackage.AUGMENTATION:
			return validateAugmentation((Augmentation) value, diagnostics, context);
		case CorePackage.BASE_COMPONENT_UNIT:
			return validateBaseComponentUnit((BaseComponentUnit) value, diagnostics, context);
		case CorePackage.BUNDLE_CAPABILITY:
			return validateBundleCapability((BundleCapability) value, diagnostics, context);
		case CorePackage.CAPABILITY:
			return validateCapability((Capability) value, diagnostics, context);
		case CorePackage.COMMUNICATION_CAPABILITY:
			return validateCommunicationCapability((CommunicationCapability) value, diagnostics,
					context);
		case CorePackage.CONCEPTUAL_NODE:
			return validateConceptualNode((ConceptualNode) value, diagnostics, context);
		case CorePackage.CONFIGURATION_CONTRACT:
			return validateConfigurationContract((ConfigurationContract) value, diagnostics, context);
		case CorePackage.CONSTRAINT:
			return validateConstraint((Constraint) value, diagnostics, context);
		case CorePackage.CONSTRAINT_LINK:
			return validateConstraintLink((ConstraintLink) value, diagnostics, context);
		case CorePackage.DEPENDENCY_LINK:
			return validateDependencyLink((DependencyLink) value, diagnostics, context);
		case CorePackage.DEPLOY_CORE_ROOT:
			return validateDeployCoreRoot((DeployCoreRoot) value, diagnostics, context);
		case CorePackage.DEPLOY_LINK:
			return validateDeployLink((DeployLink) value, diagnostics, context);
		case CorePackage.DEPLOY_MODEL_OBJECT:
			return validateDeployModelObject((DeployModelObject) value, diagnostics, context);
		case CorePackage.DEPLOY_MODEL_OBJECT_SET:
			return validateDeployModelObjectSet((DeployModelObjectSet) value, diagnostics, context);
		case CorePackage.EXPLICIT_CONTRACT:
			return validateExplicitContract((ExplicitContract) value, diagnostics, context);
		case CorePackage.EXPORTED:
			return validateExported((Exported) value, diagnostics, context);
		case CorePackage.EXPORTED_UNIT:
			return validateExportedUnit((ExportedUnit) value, diagnostics, context);
		case CorePackage.EXTENDED_ATTRIBUTE:
			return validateExtendedAttribute((ExtendedAttribute) value, diagnostics, context);
		case CorePackage.FILE_ARTIFACT:
			return validateFileArtifact((FileArtifact) value, diagnostics, context);
		case CorePackage.HOSTING_LINK:
			return validateHostingLink((HostingLink) value, diagnostics, context);
		case CorePackage.IMPORT:
			return validateImport((Import) value, diagnostics, context);
		case CorePackage.INSTANCE_CONFIGURATION:
			return validateInstanceConfiguration((InstanceConfiguration) value, diagnostics, context);
		case CorePackage.INSTANTIATION:
			return validateInstantiation((Instantiation) value, diagnostics, context);
		case CorePackage.INTERFACE:
			return validateInterface((Interface) value, diagnostics, context);
		case CorePackage.MEMBER_LINK:
			return validateMemberLink((MemberLink) value, diagnostics, context);
		case CorePackage.PROPERTY:
			return validateProperty((Property) value, diagnostics, context);
		case CorePackage.REALIZATION_LINK:
			return validateRealizationLink((RealizationLink) value, diagnostics, context);
		case CorePackage.REFERENCE:
			return validateReference((Reference) value, diagnostics, context);
		case CorePackage.REQUIREMENT:
			return validateRequirement((Requirement) value, diagnostics, context);
		case CorePackage.REQUIREMENT_EXPRESSION:
			return validateRequirementExpression((RequirementExpression) value, diagnostics, context);
		case CorePackage.SERVICE:
			return validateService((Service) value, diagnostics, context);
		case CorePackage.SOFTWARE_COMPONENT:
			return validateSoftwareComponent((SoftwareComponent) value, diagnostics, context);
		case CorePackage.STEREOTYPE:
			return validateStereotype((Stereotype) value, diagnostics, context);
		case CorePackage.STRING_TO_STRING_ENTRY:
			return validateStringToStringEntry((Map.Entry) value, diagnostics, context);
		case CorePackage.TOPOLOGY:
			return validateTopology((Topology) value, diagnostics, context);
		case CorePackage.UNIT:
			return validateUnit((Unit) value, diagnostics, context);
		case CorePackage.UNIT_LINK:
			return validateUnitLink((UnitLink) value, diagnostics, context);
		case CorePackage.CAPABILITY_LINK_TYPES:
			return validateCapabilityLinkTypes((CapabilityLinkTypes) value, diagnostics, context);
		case CorePackage.INSTALL_STATE:
			return validateInstallState((InstallState) value, diagnostics, context);
		case CorePackage.PUBLISH_INTENT:
			return validatePublishIntent((PublishIntent) value, diagnostics, context);
		case CorePackage.REQUIREMENT_EXPRESSION_USAGE:
			return validateRequirementExpressionUsage((RequirementExpressionUsage) value, diagnostics,
					context);
		case CorePackage.REQUIREMENT_LINK_TYPES:
			return validateRequirementLinkTypes((RequirementLinkTypes) value, diagnostics, context);
		case CorePackage.REQUIREMENT_USAGE:
			return validateRequirementUsage((RequirementUsage) value, diagnostics, context);
		case CorePackage.VISIBILITY:
			return validateVisibility((Visibility) value, diagnostics, context);
		case CorePackage.CAPABILITY_LINK_TYPES_OBJECT:
			return validateCapabilityLinkTypesObject((CapabilityLinkTypes) value, diagnostics, context);
		case CorePackage.GENERIC_VERSION_STRING:
			return validateGenericVersionString((String) value, diagnostics, context);
		case CorePackage.INSTALL_STATE_OBJECT:
			return validateInstallStateObject((InstallState) value, diagnostics, context);
		case CorePackage.ISTATUS:
			return validateIStatus((IStatus) value, diagnostics, context);
		case CorePackage.PORT_TYPE:
			return validatePortType((BigInteger) value, diagnostics, context);
		case CorePackage.PUBLISH_INTENT_OBJECT:
			return validatePublishIntentObject((PublishIntent) value, diagnostics, context);
		case CorePackage.REQUIREMENT_EXPRESSION_USAGE_OBJECT:
			return validateRequirementExpressionUsageObject((RequirementExpressionUsage) value,
					diagnostics, context);
		case CorePackage.REQUIREMENT_LINK_TYPES_OBJECT:
			return validateRequirementLinkTypesObject((RequirementLinkTypes) value, diagnostics,
					context);
		case CorePackage.REQUIREMENT_USAGE_OBJECT:
			return validateRequirementUsageObject((RequirementUsage) value, diagnostics, context);
		case CorePackage.SERVICE_RANGE:
			return validateServiceRange((String) value, diagnostics, context);
		case CorePackage.SERVICE_VERSION:
			return validateServiceVersion((String) value, diagnostics, context);
		case CorePackage.VERSION_RANGE:
			return validateVersionRange((String) value, diagnostics, context);
		case CorePackage.VERSION_STRING:
			return validateVersionString((String) value, diagnostics, context);
		case CorePackage.VISIBILITY_OBJECT:
			return validateVisibilityObject((Visibility) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAnnotation(Annotation annotation, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(annotation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateArtifact(Artifact artifact, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(artifact, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAttributeMetaData(AttributeMetaData attributeMetaData,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(attributeMetaData, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAugmentation(Augmentation augmentation, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(augmentation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateBaseComponentUnit(BaseComponentUnit baseComponentUnit,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(baseComponentUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateBundleCapability(BundleCapability bundleCapability,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(bundleCapability, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCapability(Capability capability, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(capability, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCommunicationCapability(CommunicationCapability communicationCapability,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(communicationCapability, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConceptualNode(ConceptualNode conceptualNode,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(conceptualNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConfigurationContract(ConfigurationContract configurationContract,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(configurationContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(constraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConstraintLink(ConstraintLink constraintLink,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(constraintLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDependencyLink(DependencyLink dependencyLink,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(dependencyLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeployCoreRoot(DeployCoreRoot deployCoreRoot,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(deployCoreRoot, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeployLink(DeployLink deployLink, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(deployLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeployModelObject(DeployModelObject deployModelObject,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(deployModelObject, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeployModelObjectSet(DeployModelObjectSet deployModelObjectSet,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(deployModelObjectSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExplicitContract(ExplicitContract explicitContract,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(explicitContract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExported(Exported exported, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(exported, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExportedUnit(ExportedUnit exportedUnit, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(exportedUnit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExtendedAttribute(ExtendedAttribute extendedAttribute,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(extendedAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateFileArtifact(FileArtifact fileArtifact, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(fileArtifact, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateHostingLink(HostingLink hostingLink, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(hostingLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateImport(Import import_, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(import_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInstanceConfiguration(InstanceConfiguration instanceConfiguration,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(instanceConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInstantiation(Instantiation instantiation, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(instantiation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInterface(Interface interface_, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(interface_, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMemberLink(MemberLink memberLink, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(memberLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(property, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRealizationLink(RealizationLink realizationLink,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(realizationLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateReference(Reference reference, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(reference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirement(Requirement requirement, DiagnosticChain diagnostics,
			Map context) {
		return validate_EveryDefaultConstraint(requirement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementExpression(RequirementExpression requirementExpression,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(requirementExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateService(Service service, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(service, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSoftwareComponent(SoftwareComponent softwareComponent,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(softwareComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStereotype(Stereotype stereotype, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(stereotype, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStringToStringEntry(Map.Entry stringToStringEntry,
			DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject) stringToStringEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTopology(Topology topology, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(topology, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUnit(Unit unit, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(unit, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUnitLink(UnitLink unitLink, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(unitLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCapabilityLinkTypes(CapabilityLinkTypes capabilityLinkTypes,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInstallState(InstallState installState, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePublishIntent(PublishIntent publishIntent, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementExpressionUsage(
			RequirementExpressionUsage requirementExpressionUsage, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementLinkTypes(RequirementLinkTypes requirementLinkTypes,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementUsage(RequirementUsage requirementUsage,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVisibility(Visibility visibility, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCapabilityLinkTypesObject(CapabilityLinkTypes capabilityLinkTypesObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGenericVersionString(String genericVersionString,
			DiagnosticChain diagnostics, Map context) {
		boolean result = validateGenericVersionString_Pattern(genericVersionString, diagnostics,
				context);
		if (result || diagnostics != null) {
			result &= validateGenericVersionString_MaxLength(genericVersionString, diagnostics,
					context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validateGenericVersionString_Pattern
	 */
	public static final PatternMatcher[][] GENERIC_VERSION_STRING__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
			.createPatternMatcher("([0-9a-zA-Z]+(([\\+_ \\-]*)+[0-9a-zA-Z]+)*)+(\\.([0-9a-zA-Z]+(([\\+_ \\-]*)+[0-9a-zA-Z]+)*)){0,99}") //$NON-NLS-1$
	} };

	/**
	 * Validates the Pattern constraint of '<em>Generic Version String</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGenericVersionString_Pattern(String genericVersionString,
			DiagnosticChain diagnostics, Map context) {
		return validatePattern(CorePackage.Literals.GENERIC_VERSION_STRING, genericVersionString,
				GENERIC_VERSION_STRING__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * Validates the MaxLength constraint of '<em>Generic Version String</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGenericVersionString_MaxLength(String genericVersionString,
			DiagnosticChain diagnostics, Map context) {
		int length = genericVersionString.length();
		boolean result = length <= 200;
		if (!result && diagnostics != null) {
			reportMaxLengthViolation(CorePackage.Literals.GENERIC_VERSION_STRING,
					genericVersionString, length, 200, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInstallStateObject(InstallState installStateObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIStatus(IStatus iStatus, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePortType(BigInteger portType, DiagnosticChain diagnostics, Map context) {
		boolean result = validatePortType_Min(portType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validatePortType_Max(portType, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validatePortType_Min
	 */
	public static final BigInteger PORT_TYPE__MIN__VALUE = new BigInteger("1"); //$NON-NLS-1$

	/**
	 * Validates the Min constraint of '<em>Port Type</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePortType_Min(BigInteger portType, DiagnosticChain diagnostics, Map context) {
		boolean result = portType.compareTo(PORT_TYPE__MIN__VALUE) >= 0;
		if (!result && diagnostics != null) {
			reportMinViolation(CorePackage.Literals.PORT_TYPE, portType, PORT_TYPE__MIN__VALUE, true,
					diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validatePortType_Max
	 */
	public static final BigInteger PORT_TYPE__MAX__VALUE = new BigInteger("65535"); //$NON-NLS-1$

	/**
	 * Validates the Max constraint of '<em>Port Type</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePortType_Max(BigInteger portType, DiagnosticChain diagnostics, Map context) {
		boolean result = portType.compareTo(PORT_TYPE__MAX__VALUE) <= 0;
		if (!result && diagnostics != null) {
			reportMaxViolation(CorePackage.Literals.PORT_TYPE, portType, PORT_TYPE__MAX__VALUE, true,
					diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePublishIntentObject(PublishIntent publishIntentObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementExpressionUsageObject(
			RequirementExpressionUsage requirementExpressionUsageObject, DiagnosticChain diagnostics,
			Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementLinkTypesObject(
			RequirementLinkTypes requirementLinkTypesObject, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRequirementUsageObject(RequirementUsage requirementUsageObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateServiceRange(String serviceRange, DiagnosticChain diagnostics, Map context) {
		boolean result = validateServiceRange_Pattern(serviceRange, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validateServiceRange_Pattern
	 */
	public static final PatternMatcher[][] SERVICE_RANGE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
			.createPatternMatcher("[\\[\\(][0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\,[0-9]{1,3}\\,[ ]+[0-9]{1,3}\\.[0-9]{1,3}[\\)\\]]") //$NON-NLS-1$
	} };

	/**
	 * Validates the Pattern constraint of '<em>Service Range</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateServiceRange_Pattern(String serviceRange, DiagnosticChain diagnostics,
			Map context) {
		return validatePattern(CorePackage.Literals.SERVICE_RANGE, serviceRange,
				SERVICE_RANGE__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateServiceVersion(String serviceVersion, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validateServiceVersion_Pattern(serviceVersion, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validateServiceVersion_Pattern
	 */
	public static final PatternMatcher[][] SERVICE_VERSION__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
			.createPatternMatcher("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}") //$NON-NLS-1$
	} };

	/**
	 * Validates the Pattern constraint of '<em>Service Version</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateServiceVersion_Pattern(String serviceVersion,
			DiagnosticChain diagnostics, Map context) {
		return validatePattern(CorePackage.Literals.SERVICE_VERSION, serviceVersion,
				SERVICE_VERSION__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVersionRange(String versionRange, DiagnosticChain diagnostics, Map context) {
		boolean result = validateVersionRange_Pattern(versionRange, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validateVersionRange_Pattern
	 */
	public static final PatternMatcher[][] VERSION_RANGE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
			.createPatternMatcher("[\\[\\(][0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\,[0-9]{1,3}\\,[ ]+[0-9]{1,3}\\.[0-9]{1,3}[\\)\\]]") //$NON-NLS-1$
	} };

	/**
	 * Validates the Pattern constraint of '<em>Version Range</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVersionRange_Pattern(String versionRange, DiagnosticChain diagnostics,
			Map context) {
		return validatePattern(CorePackage.Literals.VERSION_RANGE, versionRange,
				VERSION_RANGE__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVersionString(String versionString, DiagnosticChain diagnostics,
			Map context) {
		boolean result = validateVersionString_Pattern(versionString, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @see #validateVersionString_Pattern
	 */
	public static final PatternMatcher[][] VERSION_STRING__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil
			.createPatternMatcher("([0-9]{1,9})(\\.[0-9]{1,9}){0,3}") //$NON-NLS-1$
	} };

	/**
	 * Validates the Pattern constraint of '<em>Version String</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVersionString_Pattern(String versionString, DiagnosticChain diagnostics,
			Map context) {
		return validatePattern(CorePackage.Literals.VERSION_STRING, versionString,
				VERSION_STRING__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateVisibilityObject(Visibility visibilityObject,
			DiagnosticChain diagnostics, Map context) {
		return true;
	}

} //CoreValidator
