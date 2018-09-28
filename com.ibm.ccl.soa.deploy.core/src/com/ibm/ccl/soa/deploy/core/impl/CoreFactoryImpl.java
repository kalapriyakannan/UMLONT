/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployLink;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class CoreFactoryImpl extends EFactoryImpl implements CoreFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CoreFactory init() {
		try {
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/core/1.0.0/"); //$NON-NLS-1$ 
			if (theCoreFactory != null) {
				return theCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CorePackage.ANNOTATION: return createAnnotation();
			case CorePackage.ATTRIBUTE_META_DATA: return createAttributeMetaData();
			case CorePackage.AUGMENTATION: return createAugmentation();
			case CorePackage.BASE_COMPONENT_UNIT: return createBaseComponentUnit();
			case CorePackage.BUNDLE_CAPABILITY: return createBundleCapability();
			case CorePackage.CAPABILITY: return createCapability();
			case CorePackage.COMMUNICATION_CAPABILITY: return createCommunicationCapability();
			case CorePackage.CONCEPTUAL_NODE: return createConceptualNode();
			case CorePackage.CONSTRAINT_LINK: return createConstraintLink();
			case CorePackage.DEPENDENCY_LINK: return createDependencyLink();
			case CorePackage.DEPLOY_CORE_ROOT: return createDeployCoreRoot();
			case CorePackage.DEPLOY_LINK: return createDeployLink();
			case CorePackage.DEPLOY_MODEL_OBJECT_SET: return createDeployModelObjectSet();
			case CorePackage.EXPLICIT_CONTRACT: return createExplicitContract();
			case CorePackage.EXPORTED: return createExported();
			case CorePackage.EXPORTED_UNIT: return createExportedUnit();
			case CorePackage.EXTENDED_ATTRIBUTE: return createExtendedAttribute();
			case CorePackage.FILE_ARTIFACT: return createFileArtifact();
			case CorePackage.HOSTING_LINK: return createHostingLink();
			case CorePackage.IMPORT: return createImport();
			case CorePackage.INSTANCE_CONFIGURATION: return createInstanceConfiguration();
			case CorePackage.INSTANTIATION: return createInstantiation();
			case CorePackage.MEMBER_LINK: return createMemberLink();
			case CorePackage.PROPERTY: return createProperty();
			case CorePackage.REALIZATION_LINK: return createRealizationLink();
			case CorePackage.REFERENCE: return createReference();
			case CorePackage.REQUIREMENT: return createRequirement();
			case CorePackage.REQUIREMENT_EXPRESSION: return createRequirementExpression();
			case CorePackage.SERVICE: return createService();
			case CorePackage.SOFTWARE_COMPONENT: return createSoftwareComponent();
			case CorePackage.STEREOTYPE: return createStereotype();
			case CorePackage.STRING_TO_STRING_ENTRY: return (EObject)createStringToStringEntry();
			case CorePackage.TOPOLOGY: return createTopology();
			case CorePackage.UNIT: return createUnit();
			case CorePackage.UNIT_LINK: return createUnitLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CorePackage.CAPABILITY_LINK_TYPES:
				return createCapabilityLinkTypesFromString(eDataType, initialValue);
			case CorePackage.INSTALL_STATE:
				return createInstallStateFromString(eDataType, initialValue);
			case CorePackage.PUBLISH_INTENT:
				return createPublishIntentFromString(eDataType, initialValue);
			case CorePackage.REQUIREMENT_EXPRESSION_USAGE:
				return createRequirementExpressionUsageFromString(eDataType, initialValue);
			case CorePackage.REQUIREMENT_LINK_TYPES:
				return createRequirementLinkTypesFromString(eDataType, initialValue);
			case CorePackage.REQUIREMENT_USAGE:
				return createRequirementUsageFromString(eDataType, initialValue);
			case CorePackage.VISIBILITY:
				return createVisibilityFromString(eDataType, initialValue);
			case CorePackage.CAPABILITY_LINK_TYPES_OBJECT:
				return createCapabilityLinkTypesObjectFromString(eDataType, initialValue);
			case CorePackage.GENERIC_VERSION_STRING:
				return createGenericVersionStringFromString(eDataType, initialValue);
			case CorePackage.INSTALL_STATE_OBJECT:
				return createInstallStateObjectFromString(eDataType, initialValue);
			case CorePackage.ISTATUS:
				return createIStatusFromString(eDataType, initialValue);
			case CorePackage.PORT_TYPE:
				return createPortTypeFromString(eDataType, initialValue);
			case CorePackage.PUBLISH_INTENT_OBJECT:
				return createPublishIntentObjectFromString(eDataType, initialValue);
			case CorePackage.REQUIREMENT_EXPRESSION_USAGE_OBJECT:
				return createRequirementExpressionUsageObjectFromString(eDataType, initialValue);
			case CorePackage.REQUIREMENT_LINK_TYPES_OBJECT:
				return createRequirementLinkTypesObjectFromString(eDataType, initialValue);
			case CorePackage.REQUIREMENT_USAGE_OBJECT:
				return createRequirementUsageObjectFromString(eDataType, initialValue);
			case CorePackage.SERVICE_RANGE:
				return createServiceRangeFromString(eDataType, initialValue);
			case CorePackage.SERVICE_VERSION:
				return createServiceVersionFromString(eDataType, initialValue);
			case CorePackage.VERSION_RANGE:
				return createVersionRangeFromString(eDataType, initialValue);
			case CorePackage.VERSION_STRING:
				return createVersionStringFromString(eDataType, initialValue);
			case CorePackage.VISIBILITY_OBJECT:
				return createVisibilityObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CorePackage.CAPABILITY_LINK_TYPES:
				return convertCapabilityLinkTypesToString(eDataType, instanceValue);
			case CorePackage.INSTALL_STATE:
				return convertInstallStateToString(eDataType, instanceValue);
			case CorePackage.PUBLISH_INTENT:
				return convertPublishIntentToString(eDataType, instanceValue);
			case CorePackage.REQUIREMENT_EXPRESSION_USAGE:
				return convertRequirementExpressionUsageToString(eDataType, instanceValue);
			case CorePackage.REQUIREMENT_LINK_TYPES:
				return convertRequirementLinkTypesToString(eDataType, instanceValue);
			case CorePackage.REQUIREMENT_USAGE:
				return convertRequirementUsageToString(eDataType, instanceValue);
			case CorePackage.VISIBILITY:
				return convertVisibilityToString(eDataType, instanceValue);
			case CorePackage.CAPABILITY_LINK_TYPES_OBJECT:
				return convertCapabilityLinkTypesObjectToString(eDataType, instanceValue);
			case CorePackage.GENERIC_VERSION_STRING:
				return convertGenericVersionStringToString(eDataType, instanceValue);
			case CorePackage.INSTALL_STATE_OBJECT:
				return convertInstallStateObjectToString(eDataType, instanceValue);
			case CorePackage.ISTATUS:
				return convertIStatusToString(eDataType, instanceValue);
			case CorePackage.PORT_TYPE:
				return convertPortTypeToString(eDataType, instanceValue);
			case CorePackage.PUBLISH_INTENT_OBJECT:
				return convertPublishIntentObjectToString(eDataType, instanceValue);
			case CorePackage.REQUIREMENT_EXPRESSION_USAGE_OBJECT:
				return convertRequirementExpressionUsageObjectToString(eDataType, instanceValue);
			case CorePackage.REQUIREMENT_LINK_TYPES_OBJECT:
				return convertRequirementLinkTypesObjectToString(eDataType, instanceValue);
			case CorePackage.REQUIREMENT_USAGE_OBJECT:
				return convertRequirementUsageObjectToString(eDataType, instanceValue);
			case CorePackage.SERVICE_RANGE:
				return convertServiceRangeToString(eDataType, instanceValue);
			case CorePackage.SERVICE_VERSION:
				return convertServiceVersionToString(eDataType, instanceValue);
			case CorePackage.VERSION_RANGE:
				return convertVersionRangeToString(eDataType, instanceValue);
			case CorePackage.VERSION_STRING:
				return convertVersionStringToString(eDataType, instanceValue);
			case CorePackage.VISIBILITY_OBJECT:
				return convertVisibilityObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMetaData createAttributeMetaData() {
		AttributeMetaDataImpl attributeMetaData = new AttributeMetaDataImpl();
		return attributeMetaData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Augmentation createAugmentation() {
		AugmentationImpl augmentation = new AugmentationImpl();
		return augmentation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BaseComponentUnit createBaseComponentUnit() {
		BaseComponentUnitImpl baseComponentUnit = new BaseComponentUnitImpl();
		return baseComponentUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BundleCapability createBundleCapability() {
		BundleCapabilityImpl bundleCapability = new BundleCapabilityImpl();
		return bundleCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Capability createCapability() {
		CapabilityImpl capability = new CapabilityImpl();
		return capability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationCapability createCommunicationCapability() {
		CommunicationCapabilityImpl communicationCapability = new CommunicationCapabilityImpl();
		return communicationCapability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualNode createConceptualNode() {
		ConceptualNodeImpl conceptualNode = new ConceptualNodeImpl();
		return conceptualNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintLink createConstraintLink() {
		ConstraintLinkImpl constraintLink = new ConstraintLinkImpl();
		return constraintLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyLink createDependencyLink() {
		DependencyLinkImpl dependencyLink = new DependencyLinkImpl();
		return dependencyLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DeployCoreRoot createDeployCoreRoot() {
		DeployCoreRootImpl deployCoreRoot = new DeployCoreRootImpl();
		return deployCoreRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DeployLink createDeployLink() {
		DeployLinkImpl deployLink = new DeployLinkImpl();
		return deployLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DeployModelObjectSet createDeployModelObjectSet() {
		DeployModelObjectSetImpl deployModelObjectSet = new DeployModelObjectSetImpl();
		return deployModelObjectSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExplicitContract createExplicitContract() {
		ExplicitContractImpl explicitContract = new ExplicitContractImpl();
		return explicitContract;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Exported createExported() {
		ExportedImpl exported = new ExportedImpl();
		return exported;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExportedUnit createExportedUnit() {
		ExportedUnitImpl exportedUnit = new ExportedUnitImpl();
		return exportedUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedAttribute createExtendedAttribute() {
		ExtendedAttributeImpl extendedAttribute = new ExtendedAttributeImpl();
		return extendedAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FileArtifact createFileArtifact() {
		FileArtifactImpl fileArtifact = new FileArtifactImpl();
		return fileArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HostingLink createHostingLink() {
		HostingLinkImpl hostingLink = new HostingLinkImpl();
		return hostingLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceConfiguration createInstanceConfiguration() {
		InstanceConfigurationImpl instanceConfiguration = new InstanceConfigurationImpl();
		return instanceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Instantiation createInstantiation() {
		InstantiationImpl instantiation = new InstantiationImpl();
		return instantiation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MemberLink createMemberLink() {
		MemberLinkImpl memberLink = new MemberLinkImpl();
		return memberLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RealizationLink createRealizationLink() {
		RealizationLinkImpl realizationLink = new RealizationLinkImpl();
		return realizationLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementExpression createRequirementExpression() {
		RequirementExpressionImpl requirementExpression = new RequirementExpressionImpl();
		return requirementExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareComponent createSoftwareComponent() {
		SoftwareComponentImpl softwareComponent = new SoftwareComponentImpl();
		return softwareComponent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype createStereotype() {
		StereotypeImpl stereotype = new StereotypeImpl();
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createStringToStringEntry() {
		StringToStringEntryImpl stringToStringEntry = new StringToStringEntryImpl();
		return stringToStringEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Topology createTopology() {
		TopologyImpl topology = new TopologyImpl();
		return topology;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLink createUnitLink() {
		UnitLinkImpl unitLink = new UnitLinkImpl();
		return unitLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityLinkTypes createCapabilityLinkTypesFromString(EDataType eDataType,
			String initialValue) {
		CapabilityLinkTypes result = CapabilityLinkTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCapabilityLinkTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstallState createInstallStateFromString(EDataType eDataType, String initialValue) {
		InstallState result = InstallState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInstallStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PublishIntent createPublishIntentFromString(EDataType eDataType, String initialValue) {
		PublishIntent result = PublishIntent.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPublishIntentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementExpressionUsage createRequirementExpressionUsageFromString(
			EDataType eDataType, String initialValue) {
		RequirementExpressionUsage result = RequirementExpressionUsage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementExpressionUsageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementLinkTypes createRequirementLinkTypesFromString(EDataType eDataType,
			String initialValue) {
		RequirementLinkTypes result = RequirementLinkTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementLinkTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementUsage createRequirementUsageFromString(EDataType eDataType, String initialValue) {
		RequirementUsage result = RequirementUsage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementUsageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
		Visibility result = Visibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityLinkTypes createCapabilityLinkTypesObjectFromString(EDataType eDataType,
			String initialValue) {
		return createCapabilityLinkTypesFromString(CorePackage.Literals.CAPABILITY_LINK_TYPES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCapabilityLinkTypesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertCapabilityLinkTypesToString(CorePackage.Literals.CAPABILITY_LINK_TYPES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createGenericVersionStringFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenericVersionStringToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstallState createInstallStateObjectFromString(EDataType eDataType, String initialValue) {
		return createInstallStateFromString(CorePackage.Literals.INSTALL_STATE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInstallStateObjectToString(EDataType eDataType, Object instanceValue) {
		return convertInstallStateToString(CorePackage.Literals.INSTALL_STATE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IStatus createIStatusFromString(EDataType eDataType, String initialValue) {
		return (IStatus)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIStatusToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger createPortTypeFromString(EDataType eDataType, String initialValue) {
		return (BigInteger)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.INTEGER, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.INTEGER, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PublishIntent createPublishIntentObjectFromString(EDataType eDataType, String initialValue) {
		return createPublishIntentFromString(CorePackage.Literals.PUBLISH_INTENT, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPublishIntentObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPublishIntentToString(CorePackage.Literals.PUBLISH_INTENT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementExpressionUsage createRequirementExpressionUsageObjectFromString(
			EDataType eDataType, String initialValue) {
		return createRequirementExpressionUsageFromString(CorePackage.Literals.REQUIREMENT_EXPRESSION_USAGE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementExpressionUsageObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertRequirementExpressionUsageToString(CorePackage.Literals.REQUIREMENT_EXPRESSION_USAGE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementLinkTypes createRequirementLinkTypesObjectFromString(EDataType eDataType,
			String initialValue) {
		return createRequirementLinkTypesFromString(CorePackage.Literals.REQUIREMENT_LINK_TYPES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementLinkTypesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertRequirementLinkTypesToString(CorePackage.Literals.REQUIREMENT_LINK_TYPES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementUsage createRequirementUsageObjectFromString(EDataType eDataType,
			String initialValue) {
		return createRequirementUsageFromString(CorePackage.Literals.REQUIREMENT_USAGE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRequirementUsageObjectToString(EDataType eDataType, Object instanceValue) {
		return convertRequirementUsageToString(CorePackage.Literals.REQUIREMENT_USAGE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createServiceRangeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceRangeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createServiceVersionFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceVersionToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createVersionRangeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVersionRangeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createVersionStringFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVersionStringToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityObjectFromString(EDataType eDataType, String initialValue) {
		return createVisibilityFromString(CorePackage.Literals.VISIBILITY, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityObjectToString(EDataType eDataType, Object instanceValue) {
		return convertVisibilityToString(CorePackage.Literals.VISIBILITY, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CorePackage getCorePackage() {
		return (CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static CorePackage getPackage() {
		return CorePackage.eINSTANCE;
	}

} //CoreFactoryImpl
