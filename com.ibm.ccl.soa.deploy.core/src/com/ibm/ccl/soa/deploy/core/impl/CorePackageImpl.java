/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.Agreement;
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
import com.ibm.ccl.soa.deploy.core.CoreFactory;
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
import com.ibm.ccl.soa.deploy.core.util.CoreValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass augmentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseComponentUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptualNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationContractEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployCoreRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployModelObjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deployModelObjectSetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass explicitContractEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportedEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportedUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedAttributeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileArtifactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hostingLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realizationLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass softwareComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToStringEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topologyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitLinkEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum capabilityLinkTypesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum installStateEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum publishIntentEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum requirementExpressionUsageEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum requirementLinkTypesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum requirementUsageEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType capabilityLinkTypesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType genericVersionStringEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType installStateObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iStatusEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType portTypeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType publishIntentObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType requirementExpressionUsageObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType requirementLinkTypesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType requirementUsageObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType serviceRangeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType serviceVersionEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType versionRangeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType versionStringEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType visibilityObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorePackageImpl() {
		super(eNS_URI, CoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CorePackage init() {
		if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Obtain or create and register package
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCorePackage.createPackageContents();

		// Initialize created meta-data
		theCorePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCorePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return CoreValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCorePackage.freeze();

		return theCorePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Any() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Details() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Context() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifact() {
		return artifactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMetaData() {
		return attributeMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_AttributeName() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_Description() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_Encrypted() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_EncryptionRequired() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_Label() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_Mutable() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_Optional() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMetaData_Parameter() {
		return (EAttribute)attributeMetaDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAugmentation() {
		return augmentationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAugmentation_Additions() {
		return (EAttribute)augmentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAugmentation_Feature() {
		return (EAttribute)augmentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAugmentation_Select() {
		return (EAttribute)augmentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseComponentUnit() {
		return baseComponentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundleCapability() {
		return bundleCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundleCapability_Id() {
		return (EAttribute)bundleCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBundleCapability_Version() {
		return (EAttribute)bundleCapabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapability() {
		return capabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapability_Stereotypes() {
		return (EReference)capabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCapability_BuildVersion() {
		return (EAttribute)capabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCapability_LinkType() {
		return (EAttribute)capabilityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCapability_Origin() {
		return (EAttribute)capabilityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationCapability() {
		return communicationCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicationCapability_ApplicationLayerProtocol() {
		return (EAttribute)communicationCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicationCapability_Port() {
		return (EAttribute)communicationCapabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptualNode() {
		return conceptualNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationContract() {
		return configurationContractEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintLink() {
		return constraintLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyLink() {
		return dependencyLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployCoreRoot() {
		return deployCoreRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployCoreRoot_Mixed() {
		return (EAttribute)deployCoreRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_XMLNSPrefixMap() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_XSISchemaLocation() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Annotation() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Artifact() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_ArtifactFile() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_BaseComponent() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Capability() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_CapabilityBundle() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_CapabilityCommunication() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_DeployModelObject() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Import() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Instantiation() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Interface() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkConstraint() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkDependency() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkDeploy() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkHosting() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkUnit() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkMember() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_LinkRealization() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Property() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Reference() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_ReqExpr() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Service() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_SoftwareComponent() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Stereotype() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Requirement() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Topology() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_UnitConceptualNode() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployCoreRoot_Visibility() {
		return (EAttribute)deployCoreRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployLink() {
		return deployLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployLink_SourceURI() {
		return (EAttribute)deployLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployLink_TargetURI() {
		return (EAttribute)deployLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Unit() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_ConfigTopology() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_Constraint() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_ContractExplicit() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployCoreRoot_ContractTopology() {
		return (EReference)deployCoreRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployModelObject() {
		return deployModelObjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EAttribute getDeployModelObject_Visibility() {
		return Literals.DEPLOY_MODEL_OBJECT__VISIBILITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EAttribute getDeployModelObject_ExportedProperties() {
		return Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployModelObject_Annotations() {
		return (EReference)deployModelObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployModelObject_AttributeMetaData() {
		return (EReference)deployModelObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployModelObject_ExtendedAttributes() {
		return (EReference)deployModelObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObject_ArtifactGroup() {
		return (EAttribute)deployModelObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployModelObject_Artifacts() {
		return (EReference)deployModelObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObject_ConstraintGroup() {
		return (EAttribute)deployModelObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployModelObject_Constraints() {
		return (EReference)deployModelObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObject_Description() {
		return (EAttribute)deployModelObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObject_DisplayName() {
		return (EAttribute)deployModelObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObject_Mutable() {
		return (EAttribute)deployModelObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObject_Name() {
		return (EAttribute)deployModelObjectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployModelObjectSet() {
		return deployModelObjectSetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployModelObjectSet_DeployModelObjectGroup() {
		return (EAttribute)deployModelObjectSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeployModelObjectSet_DeployModelObject() {
		return (EReference)deployModelObjectSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExplicitContract() {
		return explicitContractEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExplicitContract_ExportedUnits() {
		return (EReference)explicitContractEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExplicitContract_Properties() {
		return (EReference)explicitContractEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExplicitContract_DefaultConceptualPolicy() {
		return (EAttribute)explicitContractEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExplicitContract_DefaultPolicy() {
		return (EAttribute)explicitContractEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExported() {
		return exportedEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExported_Configurable() {
		return (EAttribute)exportedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExported_Linkable() {
		return (EAttribute)exportedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExported_Name() {
		return (EAttribute)exportedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExported_Path() {
		return (EAttribute)exportedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExportedUnit() {
		return exportedUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExportedUnit_ExportedCapabilities() {
		return (EReference)exportedUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExportedUnit_ExportedRequirements() {
		return (EReference)exportedUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExportedUnit_ExportedProperties() {
		return (EReference)exportedUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExportedUnit_ConstraintGroup() {
		return (EAttribute)exportedUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExportedUnit_AugmentedConstraints() {
		return (EReference)exportedUnitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedAttribute() {
		return extendedAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedAttribute_Data() {
		return (EReference)extendedAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedAttribute_Name() {
		return (EAttribute)extendedAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileArtifact() {
		return fileArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileArtifact_FileURIs() {
		return (EAttribute)fileArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHostingLink() {
		return hostingLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImport_InstanceConfiguration() {
		return (EReference)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Namespace() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Pattern() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Reexported() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceConfiguration() {
		return instanceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EAttribute getInstanceConfiguration_PublicUnits() {
		return Literals.INSTANCE_CONFIGURATION__PUBLIC_UNITS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EAttribute getInstanceConfiguration_PublicEditableUnits() {
		return Literals.INSTANCE_CONFIGURATION__PUBLIC_EDITABLE_UNITS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EAttribute getInstanceConfiguration_GlobalProperties() {
		return Literals.INSTANCE_CONFIGURATION__GLOBAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceConfiguration_Instantiations() {
		return (EReference)instanceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceConfiguration_Imported() {
		return (EReference)instanceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiation() {
		return instantiationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstantiation_ConfiguredCapabilityGroup() {
		return (EAttribute)instantiationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiation_ConfiguredCapabilities() {
		return (EReference)instantiationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstantiation_ConfiguredRequirementsGroup() {
		return (EAttribute)instantiationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiation_ConfiguredRequirements() {
		return (EReference)instantiationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiation_ConfiguredProperties() {
		return (EReference)instantiationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstantiation_AugmentationGroup() {
		return (EAttribute)instantiationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiation_Augmentations() {
		return (EReference)instantiationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstantiation_Referenced() {
		return (EAttribute)instantiationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemberLink() {
		return memberLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Value() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Select() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealizationLink() {
		return realizationLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_InterfaceGroup() {
		return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_Interface() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReference_Range() {
		return (EAttribute)referenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_DependencyLinkGroup() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_Link() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_DmoType() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Extends() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_LinkType() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirement_Use() {
		return (EAttribute)requirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirementExpression() {
		return requirementExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirementExpression_AttributeName() {
		return (EAttribute)requirementExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirementExpression_Interpreter() {
		return (EAttribute)requirementExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirementExpression_Use() {
		return (EAttribute)requirementExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequirementExpression_Value() {
		return (EAttribute)requirementExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_InterfaceGroup() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Interface() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Protocol() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Version() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftwareComponent() {
		return softwareComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotype() {
		return stereotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotype_Keyword() {
		return (EAttribute)stereotypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotype_Profile() {
		return (EAttribute)stereotypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotype_Required() {
		return (EAttribute)stereotypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToStringEntry() {
		return stringToStringEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToStringEntry_Key() {
		return (EAttribute)stringToStringEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToStringEntry_Value() {
		return (EAttribute)stringToStringEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopology() {
		return topologyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public EAttribute getTopology_GlobalProperties() {
		return Literals.TOPOLOGY__GLOBAL_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_UnitGroup() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_Units() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_UnitLinksGroup() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_UnitLinks() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_ConstraintLinks() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_DependencyLinkGroup() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_DependencyLinks() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_RealizationLinks() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_Imports() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_ConfigurationContractGroup() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopology_ConfigurationContract() {
		return (EReference)topologyEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_DecoratorSemantic() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_MutabilityConfigurable() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopology_Namespace() {
		return (EAttribute)topologyEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnit() {
		return unitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_CapabilityGroup() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Capabilities() {
		return (EReference)unitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_RequirementGroup() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Requirements() {
		return (EReference)unitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_UnitLinksGroup() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_UnitLinks() {
		return (EReference)unitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_ConstraintLinks() {
		return (EReference)unitEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_RealizationLinks() {
		return (EReference)unitEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Stereotypes() {
		return (EReference)unitEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_BuildVersion() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Conceptual() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_ConfigurationUnit() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_GoalInstallState() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_InitInstallState() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Origin() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_PublishIntent() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitLink() {
		return unitLinkEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCapabilityLinkTypes() {
		return capabilityLinkTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInstallState() {
		return installStateEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPublishIntent() {
		return publishIntentEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRequirementExpressionUsage() {
		return requirementExpressionUsageEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRequirementLinkTypes() {
		return requirementLinkTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRequirementUsage() {
		return requirementUsageEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCapabilityLinkTypesObject() {
		return capabilityLinkTypesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGenericVersionString() {
		return genericVersionStringEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInstallStateObject() {
		return installStateObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIStatus() {
		return iStatusEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPortType() {
		return portTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPublishIntentObject() {
		return publishIntentObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRequirementExpressionUsageObject() {
		return requirementExpressionUsageObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRequirementLinkTypesObject() {
		return requirementLinkTypesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRequirementUsageObject() {
		return requirementUsageObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getServiceRange() {
		return serviceRangeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getServiceVersion() {
		return serviceVersionEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVersionRange() {
		return versionRangeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVersionString() {
		return versionStringEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVisibilityObject() {
		return visibilityObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactory getCoreFactory() {
		return (CoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__ANY);
		createEReference(annotationEClass, ANNOTATION__DETAILS);
		createEAttribute(annotationEClass, ANNOTATION__CONTEXT);

		artifactEClass = createEClass(ARTIFACT);

		attributeMetaDataEClass = createEClass(ATTRIBUTE_META_DATA);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__ATTRIBUTE_NAME);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__DESCRIPTION);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__ENCRYPTED);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__LABEL);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__MUTABLE);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__OPTIONAL);
		createEAttribute(attributeMetaDataEClass, ATTRIBUTE_META_DATA__PARAMETER);

		augmentationEClass = createEClass(AUGMENTATION);
		createEAttribute(augmentationEClass, AUGMENTATION__ADDITIONS);
		createEAttribute(augmentationEClass, AUGMENTATION__FEATURE);
		createEAttribute(augmentationEClass, AUGMENTATION__SELECT);

		baseComponentUnitEClass = createEClass(BASE_COMPONENT_UNIT);

		bundleCapabilityEClass = createEClass(BUNDLE_CAPABILITY);
		createEAttribute(bundleCapabilityEClass, BUNDLE_CAPABILITY__ID);
		createEAttribute(bundleCapabilityEClass, BUNDLE_CAPABILITY__VERSION);

		capabilityEClass = createEClass(CAPABILITY);
		createEReference(capabilityEClass, CAPABILITY__STEREOTYPES);
		createEAttribute(capabilityEClass, CAPABILITY__BUILD_VERSION);
		createEAttribute(capabilityEClass, CAPABILITY__LINK_TYPE);
		createEAttribute(capabilityEClass, CAPABILITY__ORIGIN);

		communicationCapabilityEClass = createEClass(COMMUNICATION_CAPABILITY);
		createEAttribute(communicationCapabilityEClass, COMMUNICATION_CAPABILITY__APPLICATION_LAYER_PROTOCOL);
		createEAttribute(communicationCapabilityEClass, COMMUNICATION_CAPABILITY__PORT);

		conceptualNodeEClass = createEClass(CONCEPTUAL_NODE);

		configurationContractEClass = createEClass(CONFIGURATION_CONTRACT);

		constraintEClass = createEClass(CONSTRAINT);

		constraintLinkEClass = createEClass(CONSTRAINT_LINK);

		dependencyLinkEClass = createEClass(DEPENDENCY_LINK);

		deployCoreRootEClass = createEClass(DEPLOY_CORE_ROOT);
		createEAttribute(deployCoreRootEClass, DEPLOY_CORE_ROOT__MIXED);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__ANNOTATION);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__ARTIFACT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__ARTIFACT_FILE);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__BASE_COMPONENT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__UNIT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CAPABILITY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CONSTRAINT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__IMPORT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__INSTANTIATION);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__INTERFACE);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_CONSTRAINT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_DEPENDENCY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_DEPLOY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_HOSTING);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_UNIT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_MEMBER);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__LINK_REALIZATION);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__PROPERTY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__REFERENCE);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__REQUIREMENT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__REQ_EXPR);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__SERVICE);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__STEREOTYPE);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__TOPOLOGY);
		createEReference(deployCoreRootEClass, DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE);
		createEAttribute(deployCoreRootEClass, DEPLOY_CORE_ROOT__VISIBILITY);

		deployLinkEClass = createEClass(DEPLOY_LINK);
		createEAttribute(deployLinkEClass, DEPLOY_LINK__SOURCE_URI);
		createEAttribute(deployLinkEClass, DEPLOY_LINK__TARGET_URI);

		deployModelObjectEClass = createEClass(DEPLOY_MODEL_OBJECT);
		createEReference(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__ANNOTATIONS);
		createEReference(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA);
		createEReference(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES);
		createEAttribute(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__ARTIFACT_GROUP);
		createEReference(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__ARTIFACTS);
		createEAttribute(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP);
		createEReference(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__CONSTRAINTS);
		createEAttribute(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__DESCRIPTION);
		createEAttribute(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__DISPLAY_NAME);
		createEAttribute(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__MUTABLE);
		createEAttribute(deployModelObjectEClass, DEPLOY_MODEL_OBJECT__NAME);

		deployModelObjectSetEClass = createEClass(DEPLOY_MODEL_OBJECT_SET);
		createEAttribute(deployModelObjectSetEClass, DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP);
		createEReference(deployModelObjectSetEClass, DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT);

		explicitContractEClass = createEClass(EXPLICIT_CONTRACT);
		createEReference(explicitContractEClass, EXPLICIT_CONTRACT__EXPORTED_UNITS);
		createEReference(explicitContractEClass, EXPLICIT_CONTRACT__PROPERTIES);
		createEAttribute(explicitContractEClass, EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY);
		createEAttribute(explicitContractEClass, EXPLICIT_CONTRACT__DEFAULT_POLICY);

		exportedEClass = createEClass(EXPORTED);
		createEAttribute(exportedEClass, EXPORTED__CONFIGURABLE);
		createEAttribute(exportedEClass, EXPORTED__LINKABLE);
		createEAttribute(exportedEClass, EXPORTED__NAME);
		createEAttribute(exportedEClass, EXPORTED__PATH);

		exportedUnitEClass = createEClass(EXPORTED_UNIT);
		createEReference(exportedUnitEClass, EXPORTED_UNIT__EXPORTED_CAPABILITIES);
		createEReference(exportedUnitEClass, EXPORTED_UNIT__EXPORTED_REQUIREMENTS);
		createEReference(exportedUnitEClass, EXPORTED_UNIT__EXPORTED_PROPERTIES);
		createEAttribute(exportedUnitEClass, EXPORTED_UNIT__CONSTRAINT_GROUP);
		createEReference(exportedUnitEClass, EXPORTED_UNIT__AUGMENTED_CONSTRAINTS);

		extendedAttributeEClass = createEClass(EXTENDED_ATTRIBUTE);
		createEReference(extendedAttributeEClass, EXTENDED_ATTRIBUTE__DATA);
		createEAttribute(extendedAttributeEClass, EXTENDED_ATTRIBUTE__NAME);

		fileArtifactEClass = createEClass(FILE_ARTIFACT);
		createEAttribute(fileArtifactEClass, FILE_ARTIFACT__FILE_UR_IS);

		hostingLinkEClass = createEClass(HOSTING_LINK);

		importEClass = createEClass(IMPORT);
		createEReference(importEClass, IMPORT__INSTANCE_CONFIGURATION);
		createEAttribute(importEClass, IMPORT__NAMESPACE);
		createEAttribute(importEClass, IMPORT__PATTERN);
		createEAttribute(importEClass, IMPORT__REEXPORTED);

		instanceConfigurationEClass = createEClass(INSTANCE_CONFIGURATION);
		createEReference(instanceConfigurationEClass, INSTANCE_CONFIGURATION__INSTANTIATIONS);
		createEReference(instanceConfigurationEClass, INSTANCE_CONFIGURATION__IMPORTED);

		instantiationEClass = createEClass(INSTANTIATION);
		createEAttribute(instantiationEClass, INSTANTIATION__CONFIGURED_CAPABILITY_GROUP);
		createEReference(instantiationEClass, INSTANTIATION__CONFIGURED_CAPABILITIES);
		createEAttribute(instantiationEClass, INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP);
		createEReference(instantiationEClass, INSTANTIATION__CONFIGURED_REQUIREMENTS);
		createEReference(instantiationEClass, INSTANTIATION__CONFIGURED_PROPERTIES);
		createEAttribute(instantiationEClass, INSTANTIATION__AUGMENTATION_GROUP);
		createEReference(instantiationEClass, INSTANTIATION__AUGMENTATIONS);
		createEAttribute(instantiationEClass, INSTANTIATION__REFERENCED);

		interfaceEClass = createEClass(INTERFACE);

		memberLinkEClass = createEClass(MEMBER_LINK);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__VALUE);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__SELECT);

		realizationLinkEClass = createEClass(REALIZATION_LINK);

		referenceEClass = createEClass(REFERENCE);
		createEAttribute(referenceEClass, REFERENCE__INTERFACE_GROUP);
		createEReference(referenceEClass, REFERENCE__INTERFACE);
		createEAttribute(referenceEClass, REFERENCE__RANGE);

		requirementEClass = createEClass(REQUIREMENT);
		createEAttribute(requirementEClass, REQUIREMENT__DEPENDENCY_LINK_GROUP);
		createEReference(requirementEClass, REQUIREMENT__LINK);
		createEAttribute(requirementEClass, REQUIREMENT__DMO_TYPE);
		createEAttribute(requirementEClass, REQUIREMENT__EXTENDS);
		createEAttribute(requirementEClass, REQUIREMENT__LINK_TYPE);
		createEAttribute(requirementEClass, REQUIREMENT__USE);

		requirementExpressionEClass = createEClass(REQUIREMENT_EXPRESSION);
		createEAttribute(requirementExpressionEClass, REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME);
		createEAttribute(requirementExpressionEClass, REQUIREMENT_EXPRESSION__INTERPRETER);
		createEAttribute(requirementExpressionEClass, REQUIREMENT_EXPRESSION__USE);
		createEAttribute(requirementExpressionEClass, REQUIREMENT_EXPRESSION__VALUE);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__INTERFACE_GROUP);
		createEReference(serviceEClass, SERVICE__INTERFACE);
		createEAttribute(serviceEClass, SERVICE__PROTOCOL);
		createEAttribute(serviceEClass, SERVICE__VERSION);

		softwareComponentEClass = createEClass(SOFTWARE_COMPONENT);

		stereotypeEClass = createEClass(STEREOTYPE);
		createEAttribute(stereotypeEClass, STEREOTYPE__KEYWORD);
		createEAttribute(stereotypeEClass, STEREOTYPE__PROFILE);
		createEAttribute(stereotypeEClass, STEREOTYPE__REQUIRED);

		stringToStringEntryEClass = createEClass(STRING_TO_STRING_ENTRY);
		createEAttribute(stringToStringEntryEClass, STRING_TO_STRING_ENTRY__KEY);
		createEAttribute(stringToStringEntryEClass, STRING_TO_STRING_ENTRY__VALUE);

		topologyEClass = createEClass(TOPOLOGY);
		createEAttribute(topologyEClass, TOPOLOGY__UNIT_GROUP);
		createEReference(topologyEClass, TOPOLOGY__UNITS);
		createEAttribute(topologyEClass, TOPOLOGY__UNIT_LINKS_GROUP);
		createEReference(topologyEClass, TOPOLOGY__UNIT_LINKS);
		createEReference(topologyEClass, TOPOLOGY__CONSTRAINT_LINKS);
		createEAttribute(topologyEClass, TOPOLOGY__DEPENDENCY_LINK_GROUP);
		createEReference(topologyEClass, TOPOLOGY__DEPENDENCY_LINKS);
		createEReference(topologyEClass, TOPOLOGY__REALIZATION_LINKS);
		createEReference(topologyEClass, TOPOLOGY__IMPORTS);
		createEAttribute(topologyEClass, TOPOLOGY__CONFIGURATION_CONTRACT_GROUP);
		createEReference(topologyEClass, TOPOLOGY__CONFIGURATION_CONTRACT);
		createEAttribute(topologyEClass, TOPOLOGY__DECORATOR_SEMANTIC);
		createEAttribute(topologyEClass, TOPOLOGY__MUTABILITY_CONFIGURABLE);
		createEAttribute(topologyEClass, TOPOLOGY__NAMESPACE);

		unitEClass = createEClass(UNIT);
		createEAttribute(unitEClass, UNIT__CAPABILITY_GROUP);
		createEReference(unitEClass, UNIT__CAPABILITIES);
		createEAttribute(unitEClass, UNIT__REQUIREMENT_GROUP);
		createEReference(unitEClass, UNIT__REQUIREMENTS);
		createEAttribute(unitEClass, UNIT__UNIT_LINKS_GROUP);
		createEReference(unitEClass, UNIT__UNIT_LINKS);
		createEReference(unitEClass, UNIT__CONSTRAINT_LINKS);
		createEReference(unitEClass, UNIT__REALIZATION_LINKS);
		createEReference(unitEClass, UNIT__STEREOTYPES);
		createEAttribute(unitEClass, UNIT__BUILD_VERSION);
		createEAttribute(unitEClass, UNIT__CONCEPTUAL);
		createEAttribute(unitEClass, UNIT__CONFIGURATION_UNIT);
		createEAttribute(unitEClass, UNIT__GOAL_INSTALL_STATE);
		createEAttribute(unitEClass, UNIT__INIT_INSTALL_STATE);
		createEAttribute(unitEClass, UNIT__ORIGIN);
		createEAttribute(unitEClass, UNIT__PUBLISH_INTENT);

		unitLinkEClass = createEClass(UNIT_LINK);

		// Create enums
		capabilityLinkTypesEEnum = createEEnum(CAPABILITY_LINK_TYPES);
		installStateEEnum = createEEnum(INSTALL_STATE);
		publishIntentEEnum = createEEnum(PUBLISH_INTENT);
		requirementExpressionUsageEEnum = createEEnum(REQUIREMENT_EXPRESSION_USAGE);
		requirementLinkTypesEEnum = createEEnum(REQUIREMENT_LINK_TYPES);
		requirementUsageEEnum = createEEnum(REQUIREMENT_USAGE);
		visibilityEEnum = createEEnum(VISIBILITY);

		// Create data types
		capabilityLinkTypesObjectEDataType = createEDataType(CAPABILITY_LINK_TYPES_OBJECT);
		genericVersionStringEDataType = createEDataType(GENERIC_VERSION_STRING);
		installStateObjectEDataType = createEDataType(INSTALL_STATE_OBJECT);
		iStatusEDataType = createEDataType(ISTATUS);
		portTypeEDataType = createEDataType(PORT_TYPE);
		publishIntentObjectEDataType = createEDataType(PUBLISH_INTENT_OBJECT);
		requirementExpressionUsageObjectEDataType = createEDataType(REQUIREMENT_EXPRESSION_USAGE_OBJECT);
		requirementLinkTypesObjectEDataType = createEDataType(REQUIREMENT_LINK_TYPES_OBJECT);
		requirementUsageObjectEDataType = createEDataType(REQUIREMENT_USAGE_OBJECT);
		serviceRangeEDataType = createEDataType(SERVICE_RANGE);
		serviceVersionEDataType = createEDataType(SERVICE_VERSION);
		versionRangeEDataType = createEDataType(VERSION_RANGE);
		versionStringEDataType = createEDataType(VERSION_STRING);
		visibilityObjectEDataType = createEDataType(VISIBILITY_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add supertypes to classes
		artifactEClass.getESuperTypes().add(this.getDeployModelObject());
		baseComponentUnitEClass.getESuperTypes().add(this.getUnit());
		bundleCapabilityEClass.getESuperTypes().add(this.getCapability());
		capabilityEClass.getESuperTypes().add(this.getDeployModelObject());
		communicationCapabilityEClass.getESuperTypes().add(this.getCapability());
		conceptualNodeEClass.getESuperTypes().add(this.getUnit());
		configurationContractEClass.getESuperTypes().add(this.getDeployModelObject());
		constraintEClass.getESuperTypes().add(this.getDeployModelObject());
		constraintLinkEClass.getESuperTypes().add(this.getDeployLink());
		dependencyLinkEClass.getESuperTypes().add(this.getDeployLink());
		deployLinkEClass.getESuperTypes().add(this.getDeployModelObject());
		explicitContractEClass.getESuperTypes().add(this.getConfigurationContract());
		exportedUnitEClass.getESuperTypes().add(this.getExported());
		fileArtifactEClass.getESuperTypes().add(this.getArtifact());
		hostingLinkEClass.getESuperTypes().add(this.getUnitLink());
		importEClass.getESuperTypes().add(this.getDeployModelObject());
		instanceConfigurationEClass.getESuperTypes().add(this.getDeployModelObject());
		instantiationEClass.getESuperTypes().add(this.getDeployModelObject());
		memberLinkEClass.getESuperTypes().add(this.getUnitLink());
		realizationLinkEClass.getESuperTypes().add(this.getDeployLink());
		referenceEClass.getESuperTypes().add(this.getRequirement());
		requirementEClass.getESuperTypes().add(this.getDeployModelObject());
		requirementExpressionEClass.getESuperTypes().add(this.getConstraint());
		serviceEClass.getESuperTypes().add(this.getCapability());
		softwareComponentEClass.getESuperTypes().add(this.getBaseComponentUnit());
		topologyEClass.getESuperTypes().add(this.getDeployModelObject());
		unitEClass.getESuperTypes().add(this.getDeployModelObject());
		unitLinkEClass.getESuperTypes().add(this.getDeployLink());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAnnotation_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnnotation_Details(), this.getStringToStringEntry(), null, "details", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAnnotation_Context(), theXMLTypePackage.getString(), "context", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(artifactEClass, Artifact.class, "Artifact", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(attributeMetaDataEClass, AttributeMetaData.class, "AttributeMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAttributeMetaData_AttributeName(), theXMLTypePackage.getString(), "attributeName", null, 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAttributeMetaData_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAttributeMetaData_Encrypted(), theXMLTypePackage.getBoolean(), "encrypted", "false", 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAttributeMetaData_EncryptionRequired(), theXMLTypePackage.getBoolean(), "encryptionRequired", "false", 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAttributeMetaData_Label(), theXMLTypePackage.getString(), "label", null, 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAttributeMetaData_Mutable(), theXMLTypePackage.getBoolean(), "mutable", "true", 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAttributeMetaData_Optional(), theXMLTypePackage.getBoolean(), "optional", "false", 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getAttributeMetaData_Parameter(), theXMLTypePackage.getBoolean(), "parameter", "false", 0, 1, AttributeMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(augmentationEClass, Augmentation.class, "Augmentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAugmentation_Additions(), ecorePackage.getEFeatureMapEntry(), "additions", null, 0, -1, Augmentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAugmentation_Feature(), theXMLTypePackage.getString(), "feature", null, 0, 1, Augmentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAugmentation_Select(), theXMLTypePackage.getString(), "select", null, 0, 1, Augmentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(baseComponentUnitEClass, BaseComponentUnit.class, "BaseComponentUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(bundleCapabilityEClass, BundleCapability.class, "BundleCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBundleCapability_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, BundleCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBundleCapability_Version(), this.getVersionString(), "version", null, 1, 1, BundleCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(capabilityEClass, Capability.class, "Capability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCapability_Stereotypes(), this.getStereotype(), null, "stereotypes", null, 0, -1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCapability_BuildVersion(), this.getVersionString(), "buildVersion", null, 0, 1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCapability_LinkType(), this.getCapabilityLinkTypes(), "linkType", "dependency", 0, 1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getCapability_Origin(), theXMLTypePackage.getString(), "origin", null, 0, 1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(capabilityEClass, theXMLTypePackage.getBoolean(), "isVisible", 0, 1); //$NON-NLS-1$

		addEOperation(capabilityEClass, theXMLTypePackage.getBoolean(), "isPublic", 0, 1); //$NON-NLS-1$

		addEOperation(capabilityEClass, theXMLTypePackage.getBoolean(), "isPublicEditable", 0, 1); //$NON-NLS-1$

		initEClass(communicationCapabilityEClass, CommunicationCapability.class, "CommunicationCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getCommunicationCapability_ApplicationLayerProtocol(), theXMLTypePackage.getString(), "applicationLayerProtocol", null, 0, 1, CommunicationCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getCommunicationCapability_Port(), this.getPortType(), "port", null, 1, 1, CommunicationCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(conceptualNodeEClass, ConceptualNode.class, "ConceptualNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(configurationContractEClass, ConfigurationContract.class, "ConfigurationContract", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(constraintLinkEClass, ConstraintLink.class, "ConstraintLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(constraintLinkEClass, this.getDeployModelObject(), "getSource", 1, 1); //$NON-NLS-1$

		EOperation op = addEOperation(constraintLinkEClass, null, "setSource"); //$NON-NLS-1$
		addEParameter(op, this.getDeployModelObject(), "source", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(constraintLinkEClass, this.getDeployModelObject(), "getTarget", 1, 1); //$NON-NLS-1$

		op = addEOperation(constraintLinkEClass, null, "setTarget"); //$NON-NLS-1$
		addEParameter(op, this.getDeployModelObject(), "target", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(dependencyLinkEClass, DependencyLink.class, "DependencyLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(dependencyLinkEClass, this.getRequirement(), "getSource", 1, 1); //$NON-NLS-1$

		addEOperation(dependencyLinkEClass, this.getCapability(), "getTarget", 1, 1); //$NON-NLS-1$

		op = addEOperation(dependencyLinkEClass, null, "setTarget"); //$NON-NLS-1$
		addEParameter(op, this.getCapability(), "capability", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(deployCoreRootEClass, DeployCoreRoot.class, "DeployCoreRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDeployCoreRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Annotation(), this.getAnnotation(), null, "annotation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Artifact(), this.getArtifact(), null, "artifact", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_ArtifactFile(), this.getFileArtifact(), null, "artifactFile", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_BaseComponent(), this.getBaseComponentUnit(), null, "baseComponent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Unit(), this.getUnit(), null, "unit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Capability(), this.getCapability(), null, "capability", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_CapabilityBundle(), this.getBundleCapability(), null, "capabilityBundle", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_CapabilityCommunication(), this.getCommunicationCapability(), null, "capabilityCommunication", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_ConfigTopology(), this.getInstanceConfiguration(), null, "configTopology", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Constraint(), this.getConstraint(), null, "constraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_ContractExplicit(), this.getExplicitContract(), null, "contractExplicit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_ContractTopology(), this.getConfigurationContract(), null, "contractTopology", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_DeployModelObject(), this.getDeployModelObject(), null, "deployModelObject", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Import(), this.getImport(), null, "import", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Instantiation(), this.getInstantiation(), null, "instantiation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Interface(), this.getInterface(), null, "interface", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkConstraint(), this.getConstraintLink(), null, "linkConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkDependency(), this.getDependencyLink(), null, "linkDependency", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkDeploy(), this.getDeployLink(), null, "linkDeploy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkHosting(), this.getHostingLink(), null, "linkHosting", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkUnit(), this.getUnitLink(), null, "linkUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkMember(), this.getMemberLink(), null, "linkMember", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_LinkRealization(), this.getRealizationLink(), null, "linkRealization", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Property(), this.getProperty(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Reference(), this.getReference(), null, "reference", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Requirement(), this.getRequirement(), null, "requirement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_ReqExpr(), this.getRequirementExpression(), null, "reqExpr", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Service(), this.getService(), null, "service", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_SoftwareComponent(), this.getSoftwareComponent(), null, "softwareComponent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Stereotype(), this.getStereotype(), null, "stereotype", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_Topology(), this.getTopology(), null, "topology", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployCoreRoot_UnitConceptualNode(), this.getConceptualNode(), null, "unitConceptualNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployCoreRoot_Visibility(), this.getVisibility(), "visibility", "private", 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(deployLinkEClass, DeployLink.class, "DeployLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDeployLink_SourceURI(), theXMLTypePackage.getAnyURI(), "sourceURI", null, 0, 1, DeployLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployLink_TargetURI(), theXMLTypePackage.getAnyURI(), "targetURI", null, 1, 1, DeployLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(deployModelObjectEClass, DeployModelObject.class, "DeployModelObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDeployModelObject_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployModelObject_AttributeMetaData(), this.getAttributeMetaData(), null, "attributeMetaData", null, 0, -1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployModelObject_ExtendedAttributes(), this.getExtendedAttribute(), null, "extendedAttributes", null, 0, -1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployModelObject_ArtifactGroup(), ecorePackage.getEFeatureMapEntry(), "artifactGroup", null, 0, -1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployModelObject_Artifacts(), this.getArtifact(), null, "artifacts", null, 0, -1, DeployModelObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployModelObject_ConstraintGroup(), ecorePackage.getEFeatureMapEntry(), "constraintGroup", null, 0, -1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployModelObject_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1, DeployModelObject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployModelObject_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployModelObject_DisplayName(), theXMLTypePackage.getString(), "displayName", null, 0, 1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDeployModelObject_Mutable(), theXMLTypePackage.getBoolean(), "mutable", "true", 0, 1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getDeployModelObject_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, DeployModelObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, this.getConstraint(), "getConstraints", 0, -1); //$NON-NLS-1$

		op = addEOperation(deployModelObjectEClass, this.getExtendedAttribute(), "getExtendedAttribute", 1, 1); //$NON-NLS-1$
		addEParameter(op, theXMLTypePackage.getString(), "name", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(deployModelObjectEClass, this.getConstraint(), "getConstraint", 1, 1); //$NON-NLS-1$
		addEParameter(op, theXMLTypePackage.getString(), "name", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(deployModelObjectEClass, this.getAnnotation(), "findAnnotation", 1, 1); //$NON-NLS-1$
		addEParameter(op, theXMLTypePackage.getString(), "context", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, this.getDeployModelObject(), "getParent", 1, 1); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, this.getIStatus(), "getStatus", 1, 1); //$NON-NLS-1$

		op = addEOperation(deployModelObjectEClass, this.getIStatus(), "addStatus", 1, 1); //$NON-NLS-1$
		addEParameter(op, this.getIStatus(), "aNewStatus", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, null, "clearStatus"); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, this.getDeployModelObject(), "getContainedModelObjects", 0, -1); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, this.getTopology(), "getTopology", 1, 1); //$NON-NLS-1$

		addEOperation(deployModelObjectEClass, ecorePackage.getEObject(), "getFullPath", 1, 1); //$NON-NLS-1$

		op = addEOperation(deployModelObjectEClass, ecorePackage.getEObject(), "getRelativePath", 1, 1); //$NON-NLS-1$
		addEParameter(op, this.getDeployModelObject(), "relativeObject", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(deployModelObjectEClass, this.getDeployModelObject(), "resolve", 1, 1); //$NON-NLS-1$
		addEParameter(op, theXMLTypePackage.getString(), "path", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(deployModelObjectSetEClass, DeployModelObjectSet.class, "DeployModelObjectSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDeployModelObjectSet_DeployModelObjectGroup(), ecorePackage.getEFeatureMapEntry(), "deployModelObjectGroup", null, 0, -1, DeployModelObjectSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDeployModelObjectSet_DeployModelObject(), this.getDeployModelObject(), null, "deployModelObject", null, 0, -1, DeployModelObjectSet.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(explicitContractEClass, ExplicitContract.class, "ExplicitContract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExplicitContract_ExportedUnits(), this.getExportedUnit(), null, "exportedUnits", null, 0, -1, ExplicitContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExplicitContract_Properties(), this.getProperty(), null, "properties", null, 0, -1, ExplicitContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExplicitContract_DefaultConceptualPolicy(), this.getVisibility(), "defaultConceptualPolicy", "private", 0, 1, ExplicitContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getExplicitContract_DefaultPolicy(), this.getVisibility(), "defaultPolicy", "private", 0, 1, ExplicitContract.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(exportedEClass, Exported.class, "Exported", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExported_Configurable(), theXMLTypePackage.getBoolean(), "configurable", null, 0, 1, Exported.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExported_Linkable(), theXMLTypePackage.getBoolean(), "linkable", null, 0, 1, Exported.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExported_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Exported.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExported_Path(), theXMLTypePackage.getString(), "path", null, 0, 1, Exported.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(exportedUnitEClass, ExportedUnit.class, "ExportedUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExportedUnit_ExportedCapabilities(), this.getExported(), null, "exportedCapabilities", null, 0, -1, ExportedUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExportedUnit_ExportedRequirements(), this.getExported(), null, "exportedRequirements", null, 0, -1, ExportedUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExportedUnit_ExportedProperties(), this.getProperty(), null, "exportedProperties", null, 0, -1, ExportedUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExportedUnit_ConstraintGroup(), ecorePackage.getEFeatureMapEntry(), "constraintGroup", null, 0, -1, ExportedUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getExportedUnit_AugmentedConstraints(), this.getConstraint(), null, "augmentedConstraints", null, 0, -1, ExportedUnit.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(extendedAttributeEClass, ExtendedAttribute.class, "ExtendedAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExtendedAttribute_Data(), ecorePackage.getEObject(), null, "data", null, 1, 1, ExtendedAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getExtendedAttribute_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ExtendedAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(extendedAttributeEClass, theEcorePackage.getEJavaObject(), "getValue", 1, 1); //$NON-NLS-1$

		op = addEOperation(extendedAttributeEClass, null, "setValue"); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEJavaObject(), "value", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(extendedAttributeEClass, theEcorePackage.getEDataType(), "getInstanceType", 1, 1); //$NON-NLS-1$

		op = addEOperation(extendedAttributeEClass, null, "setInstanceType"); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEDataType(), "type", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(extendedAttributeEClass, this.getDeployModelObject(), "getContainer", 1, 1); //$NON-NLS-1$

		initEClass(fileArtifactEClass, FileArtifact.class, "FileArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFileArtifact_FileURIs(), theXMLTypePackage.getAnyURI(), "fileURIs", null, 1, -1, FileArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(hostingLinkEClass, HostingLink.class, "HostingLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImport_InstanceConfiguration(), this.getInstanceConfiguration(), this.getInstanceConfiguration_Imported(), "instanceConfiguration", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getImport_Namespace(), theXMLTypePackage.getString(), "namespace", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getImport_Pattern(), theXMLTypePackage.getString(), "pattern", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getImport_Reexported(), theXMLTypePackage.getBoolean(), "reexported", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(importEClass, this.getTopology(), "resolveImport", 1, 1); //$NON-NLS-1$

		initEClass(instanceConfigurationEClass, InstanceConfiguration.class, "InstanceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInstanceConfiguration_Instantiations(), this.getInstantiation(), null, "instantiations", null, 0, -1, InstanceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstanceConfiguration_Imported(), this.getImport(), this.getImport_InstanceConfiguration(), "imported", null, 0, 1, InstanceConfiguration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(instantiationEClass, Instantiation.class, "Instantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getInstantiation_ConfiguredCapabilityGroup(), ecorePackage.getEFeatureMapEntry(), "configuredCapabilityGroup", null, 0, -1, Instantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiation_ConfiguredCapabilities(), this.getCapability(), null, "configuredCapabilities", null, 0, -1, Instantiation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstantiation_ConfiguredRequirementsGroup(), ecorePackage.getEFeatureMapEntry(), "configuredRequirementsGroup", null, 0, -1, Instantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiation_ConfiguredRequirements(), this.getRequirement(), null, "configuredRequirements", null, 0, -1, Instantiation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiation_ConfiguredProperties(), this.getProperty(), null, "configuredProperties", null, 0, -1, Instantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstantiation_AugmentationGroup(), ecorePackage.getEFeatureMapEntry(), "augmentationGroup", null, 0, -1, Instantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiation_Augmentations(), this.getAugmentation(), null, "augmentations", null, 0, -1, Instantiation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getInstantiation_Referenced(), theXMLTypePackage.getString(), "referenced", null, 0, 1, Instantiation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(interfaceEClass, Interface.class, "Interface", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(memberLinkEClass, MemberLink.class, "MemberLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getProperty_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getProperty_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getProperty_Select(), theXMLTypePackage.getString(), "select", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(realizationLinkEClass, RealizationLink.class, "RealizationLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(realizationLinkEClass, this.getDeployModelObject(), "getSource", 1, 1); //$NON-NLS-1$

		op = addEOperation(realizationLinkEClass, null, "setSource"); //$NON-NLS-1$
		addEParameter(op, this.getDeployModelObject(), "capability", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(realizationLinkEClass, this.getDeployModelObject(), "getTarget", 1, 1); //$NON-NLS-1$

		op = addEOperation(realizationLinkEClass, null, "setTarget"); //$NON-NLS-1$
		addEParameter(op, this.getDeployModelObject(), "target", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getReference_InterfaceGroup(), ecorePackage.getEFeatureMapEntry(), "interfaceGroup", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getReference_Interface(), this.getInterface(), null, "interface", null, 1, 1, Reference.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getReference_Range(), this.getServiceRange(), "range", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getRequirement_DependencyLinkGroup(), ecorePackage.getEFeatureMapEntry(), "dependencyLinkGroup", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRequirement_Link(), this.getDependencyLink(), null, "link", null, 0, 1, Requirement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRequirement_DmoType(), theXMLTypePackage.getQName(), "dmoType", null, 1, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRequirement_Extends(), theXMLTypePackage.getString(), "extends", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRequirement_LinkType(), this.getRequirementLinkTypes(), "linkType", "dependency", 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getRequirement_Use(), this.getRequirementUsage(), "use", "required", 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		addEOperation(requirementEClass, theEcorePackage.getEClass(), "getDmoEType", 1, 1); //$NON-NLS-1$

		op = addEOperation(requirementEClass, null, "setDmoEType"); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEClass(), "type", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(requirementEClass, this.getDependencyLink(), "getLink", 1, 1); //$NON-NLS-1$

		op = addEOperation(requirementEClass, null, "setLink"); //$NON-NLS-1$
		addEParameter(op, this.getDependencyLink(), "link", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(requirementEClass, this.getRequirementExpression(), "getExpressions", 0, -1); //$NON-NLS-1$

		addEOperation(requirementEClass, theXMLTypePackage.getBoolean(), "isVisible", 0, 1); //$NON-NLS-1$

		addEOperation(requirementEClass, theXMLTypePackage.getBoolean(), "isPublic", 0, 1); //$NON-NLS-1$

		addEOperation(requirementEClass, theXMLTypePackage.getBoolean(), "isPublicEditable", 0, 1); //$NON-NLS-1$

		initEClass(requirementExpressionEClass, RequirementExpression.class, "RequirementExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getRequirementExpression_AttributeName(), theXMLTypePackage.getString(), "attributeName", null, 0, 1, RequirementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRequirementExpression_Interpreter(), theXMLTypePackage.getString(), "interpreter", null, 1, 1, RequirementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getRequirementExpression_Use(), this.getRequirementExpressionUsage(), "use", "required", 0, 1, RequirementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getRequirementExpression_Value(), theXMLTypePackage.getString(), "value", null, 1, 1, RequirementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getService_InterfaceGroup(), ecorePackage.getEFeatureMapEntry(), "interfaceGroup", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getService_Interface(), this.getInterface(), null, "interface", null, 1, 1, Service.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getService_Protocol(), theXMLTypePackage.getString(), "protocol", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getService_Version(), this.getServiceVersion(), "version", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(softwareComponentEClass, SoftwareComponent.class, "SoftwareComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stereotypeEClass, Stereotype.class, "Stereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStereotype_Keyword(), theXMLTypePackage.getString(), "keyword", null, 0, 1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStereotype_Profile(), theXMLTypePackage.getString(), "profile", null, 0, 1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStereotype_Required(), theXMLTypePackage.getBoolean(), "required", null, 0, 1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToStringEntryEClass, Map.Entry.class, "StringToStringEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringToStringEntry_Key(), theXMLTypePackage.getString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStringToStringEntry_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(topologyEClass, Topology.class, "Topology", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTopology_UnitGroup(), ecorePackage.getEFeatureMapEntry(), "unitGroup", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_Units(), this.getUnit(), null, "units", null, 0, -1, Topology.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTopology_UnitLinksGroup(), ecorePackage.getEFeatureMapEntry(), "unitLinksGroup", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_UnitLinks(), this.getUnitLink(), null, "unitLinks", null, 0, -1, Topology.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_ConstraintLinks(), this.getConstraintLink(), null, "constraintLinks", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTopology_DependencyLinkGroup(), ecorePackage.getEFeatureMapEntry(), "dependencyLinkGroup", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_DependencyLinks(), this.getDependencyLink(), null, "dependencyLinks", null, 0, -1, Topology.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_RealizationLinks(), this.getRealizationLink(), null, "realizationLinks", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_Imports(), this.getImport(), null, "imports", null, 0, -1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTopology_ConfigurationContractGroup(), ecorePackage.getEFeatureMapEntry(), "configurationContractGroup", null, 0, 1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTopology_ConfigurationContract(), this.getConfigurationContract(), null, "configurationContract", null, 0, 1, Topology.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTopology_DecoratorSemantic(), theXMLTypePackage.getString(), "decoratorSemantic", null, 0, 1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTopology_MutabilityConfigurable(), theXMLTypePackage.getBoolean(), "mutabilityConfigurable", "false", 0, 1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getTopology_Namespace(), theXMLTypePackage.getString(), "namespace", null, 0, 1, Topology.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getDeployModelObject(), "getUnits", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getDeployModelObject(), "getGroups", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getDeployModelObject(), "getConfigurations", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getDeployModelObject(), "getConceptualUnits", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getDependencyLink(), "getDependencyLinks", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getDependencyLink(), "findAllDependencyLinks", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getConstraintLink(), "findAllConstraintLinks", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getHostingLink(), "findAllHostingLinks", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getRealizationLink(), "findAllRealizationLinks", 0, -1); //$NON-NLS-1$

		addEOperation(topologyEClass, this.getMemberLink(), "findAllMemberLinks", 0, -1); //$NON-NLS-1$

		initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUnit_CapabilityGroup(), ecorePackage.getEFeatureMapEntry(), "capabilityGroup", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnit_Capabilities(), this.getCapability(), null, "capabilities", null, 0, -1, Unit.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnit_RequirementGroup(), ecorePackage.getEFeatureMapEntry(), "requirementGroup", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnit_Requirements(), this.getRequirement(), null, "requirements", null, 0, -1, Unit.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnit_UnitLinksGroup(), ecorePackage.getEFeatureMapEntry(), "unitLinksGroup", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnit_UnitLinks(), this.getUnitLink(), null, "unitLinks", null, 0, -1, Unit.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnit_ConstraintLinks(), this.getConstraintLink(), null, "constraintLinks", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnit_RealizationLinks(), this.getRealizationLink(), null, "realizationLinks", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnit_Stereotypes(), this.getStereotype(), null, "stereotypes", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnit_BuildVersion(), this.getVersionString(), "buildVersion", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnit_Conceptual(), theXMLTypePackage.getBoolean(), "conceptual", "false", 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnit_ConfigurationUnit(), theXMLTypePackage.getBoolean(), "configurationUnit", "false", 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnit_GoalInstallState(), this.getInstallState(), "goalInstallState", "unknown", 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnit_InitInstallState(), this.getInstallState(), "initInstallState", "unknown", 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getUnit_Origin(), theXMLTypePackage.getString(), "origin", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getUnit_PublishIntent(), this.getPublishIntent(), "publishIntent", "publish", 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		addEOperation(unitEClass, this.getRequirement(), "getRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getHostingOrAnyRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getDependencyOrAnyRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getOnlyAnyRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getOnlyHostingRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getOnlyDependencyRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getOnlyMemberRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRequirement(), "getMemberOrAnyRequirements", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getCapability(), "getCapabilities", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getCapability(), "getOnlyHostingCapabilities", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getCapability(), "getOnlyDependencyCapabilities", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getCapability(), "getHostingOrAnyCapabilities", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getCapability(), "getDependencyOrAnyCapabilities", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getCapability(), "getOnlyAnyCapabilities", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, theXMLTypePackage.getBoolean(), "isBound", 0, 1); //$NON-NLS-1$

		addEOperation(unitEClass, theXMLTypePackage.getBoolean(), "isGroup", 0, 1); //$NON-NLS-1$

		addEOperation(unitEClass, theXMLTypePackage.getBoolean(), "isVisible", 0, 1); //$NON-NLS-1$

		addEOperation(unitEClass, theXMLTypePackage.getBoolean(), "isPublic", 0, 1); //$NON-NLS-1$

		addEOperation(unitEClass, theXMLTypePackage.getBoolean(), "isPublicEditable", 0, 1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getUnitLink(), "getUnitLinks", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getHostingLink(), "getHostingLinks", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getMemberLink(), "getMemberLinks", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getConstraintLink(), "getConstraintLinks", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getRealizationLink(), "getRealizationLinks", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, ecorePackage.getEObject(), "getSpecializedTypeId", 1, 1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getArtifact(), "getArtifacts", 0, -1); //$NON-NLS-1$

		addEOperation(unitEClass, this.getDependencyLink(), "getDependencyLinks", 0, -1); //$NON-NLS-1$

		initEClass(unitLinkEClass, UnitLink.class, "UnitLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(unitLinkEClass, this.getUnit(), "getSource", 1, 1); //$NON-NLS-1$

		op = addEOperation(unitLinkEClass, null, "setSource"); //$NON-NLS-1$
		addEParameter(op, this.getUnit(), "capability", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(unitLinkEClass, this.getUnit(), "getTarget", 1, 1); //$NON-NLS-1$

		op = addEOperation(unitLinkEClass, null, "setTarget"); //$NON-NLS-1$
		addEParameter(op, this.getUnit(), "target", 1, 1, !IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(capabilityLinkTypesEEnum, CapabilityLinkTypes.class, "CapabilityLinkTypes"); //$NON-NLS-1$
		addEEnumLiteral(capabilityLinkTypesEEnum, CapabilityLinkTypes.HOSTING_LITERAL);
		addEEnumLiteral(capabilityLinkTypesEEnum, CapabilityLinkTypes.DEPENDENCY_LITERAL);
		addEEnumLiteral(capabilityLinkTypesEEnum, CapabilityLinkTypes.ANY_LITERAL);

		initEEnum(installStateEEnum, InstallState.class, "InstallState"); //$NON-NLS-1$
		addEEnumLiteral(installStateEEnum, InstallState.INSTALLED_LITERAL);
		addEEnumLiteral(installStateEEnum, InstallState.NOT_INSTALLED_LITERAL);
		addEEnumLiteral(installStateEEnum, InstallState.UNKNOWN_LITERAL);

		initEEnum(publishIntentEEnum, PublishIntent.class, "PublishIntent"); //$NON-NLS-1$
		addEEnumLiteral(publishIntentEEnum, PublishIntent.PUBLISH_LITERAL);
		addEEnumLiteral(publishIntentEEnum, PublishIntent.DO_NOT_PUBLISH_LITERAL);
		addEEnumLiteral(publishIntentEEnum, PublishIntent.UNKNOWN_LITERAL);

		initEEnum(requirementExpressionUsageEEnum, RequirementExpressionUsage.class, "RequirementExpressionUsage"); //$NON-NLS-1$
		addEEnumLiteral(requirementExpressionUsageEEnum, RequirementExpressionUsage.REQUIRED_LITERAL);
		addEEnumLiteral(requirementExpressionUsageEEnum, RequirementExpressionUsage.OPTIONAL_LITERAL);
		addEEnumLiteral(requirementExpressionUsageEEnum, RequirementExpressionUsage.PROHIBITED_LITERAL);

		initEEnum(requirementLinkTypesEEnum, RequirementLinkTypes.class, "RequirementLinkTypes"); //$NON-NLS-1$
		addEEnumLiteral(requirementLinkTypesEEnum, RequirementLinkTypes.HOSTING_LITERAL);
		addEEnumLiteral(requirementLinkTypesEEnum, RequirementLinkTypes.DEPENDENCY_LITERAL);
		addEEnumLiteral(requirementLinkTypesEEnum, RequirementLinkTypes.MEMBER_LITERAL);
		addEEnumLiteral(requirementLinkTypesEEnum, RequirementLinkTypes.ANY_LITERAL);

		initEEnum(requirementUsageEEnum, RequirementUsage.class, "RequirementUsage"); //$NON-NLS-1$
		addEEnumLiteral(requirementUsageEEnum, RequirementUsage.REQUIRED_LITERAL);
		addEEnumLiteral(requirementUsageEEnum, RequirementUsage.OPTIONAL_LITERAL);
		addEEnumLiteral(requirementUsageEEnum, RequirementUsage.PROHIBITED_LITERAL);

		initEEnum(visibilityEEnum, Visibility.class, "Visibility"); //$NON-NLS-1$
		addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE_LITERAL);
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC_LITERAL);
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC_EDITABLE_LITERAL);

		// Initialize data types
		initEDataType(capabilityLinkTypesObjectEDataType, CapabilityLinkTypes.class, "CapabilityLinkTypesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(genericVersionStringEDataType, String.class, "GenericVersionString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(installStateObjectEDataType, InstallState.class, "InstallStateObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iStatusEDataType, IStatus.class, "IStatus", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(portTypeEDataType, BigInteger.class, "PortType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(publishIntentObjectEDataType, PublishIntent.class, "PublishIntentObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(requirementExpressionUsageObjectEDataType, RequirementExpressionUsage.class, "RequirementExpressionUsageObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(requirementLinkTypesObjectEDataType, RequirementLinkTypes.class, "RequirementLinkTypesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(requirementUsageObjectEDataType, RequirementUsage.class, "RequirementUsageObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(serviceRangeEDataType, String.class, "ServiceRange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(serviceVersionEDataType, String.class, "ServiceVersion", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(versionRangeEDataType, String.class, "VersionRange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(versionStringEDataType, String.class, "VersionString", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(visibilityObjectEDataType, Visibility.class, "VisibilityObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// null
		createNullAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$				
		addAnnotation
		  (annotationEClass, 
		   source, 
		   new String[] {
			 "name", "Annotation", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnnotation_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "wildcards", "##other", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
			 "processing", "lax" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnnotation_Details(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "detail", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnnotation_Context(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "context" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (artifactEClass, 
		   source, 
		   new String[] {
			 "name", "Artifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (attributeMetaDataEClass, 
		   source, 
		   new String[] {
			 "name", "AttributeMetaData", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_AttributeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "attributeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "description" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_Encrypted(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "encrypted" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAttributeMetaData_EncryptionRequired(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "encryptionRequired" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_Label(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "label" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_Mutable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mutable" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_Optional(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "optional" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getAttributeMetaData_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "parameter" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (augmentationEClass, 
		   source, 
		   new String[] {
			 "name", "Augmentation", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAugmentation_Additions(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "wildcards", "##any", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
			 "processing", "lax" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAugmentation_Feature(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "feature" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAugmentation_Select(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "select" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (baseComponentUnitEClass, 
		   source, 
		   new String[] {
			 "name", "BaseComponentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (bundleCapabilityEClass, 
		   source, 
		   new String[] {
			 "name", "BundleCapability", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBundleCapability_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getBundleCapability_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "version" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (capabilityEClass, 
		   source, 
		   new String[] {
			 "name", "Capability", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getCapability_Stereotypes(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "stereotype", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getCapability_BuildVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "buildVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getCapability_LinkType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "linkType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getCapability_Origin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "origin" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (capabilityLinkTypesEEnum, 
		   source, 
		   new String[] {
			 "name", "CapabilityLinkTypes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (capabilityLinkTypesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "CapabilityLinkTypes:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "CapabilityLinkTypes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (communicationCapabilityEClass, 
		   source, 
		   new String[] {
			 "name", "CommunicationCapability", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getCommunicationCapability_ApplicationLayerProtocol(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "applicationLayerProtocol" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getCommunicationCapability_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (conceptualNodeEClass, 
		   source, 
		   new String[] {
			 "name", "ConceptualNode", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (configurationContractEClass, 
		   source, 
		   new String[] {
			 "name", "ConfigurationContract", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (constraintEClass, 
		   source, 
		   new String[] {
			 "name", "Constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (constraintLinkEClass, 
		   source, 
		   new String[] {
			 "name", "ConstraintLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (dependencyLinkEClass, 
		   source, 
		   new String[] {
			 "name", "DependencyLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (deployCoreRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Annotation(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "annotation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Artifact(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "artifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_ArtifactFile(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "artifact.file", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "artifact" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_BaseComponent(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "baseComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Unit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Capability(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_CapabilityBundle(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.bundle", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_CapabilityCommunication(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.communication", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_ConfigTopology(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "config.topology", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_ContractExplicit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "contract.explicit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "contract.topology" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_ContractTopology(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "contract.topology", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_DeployModelObject(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "deployModelObject", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Import(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "import", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Instantiation(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instantiation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkDependency(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.dependency", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkDeploy(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.deploy", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkHosting(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.hosting", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "link.unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkMember(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.member", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "link.unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_LinkRealization(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.realization", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Property(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "property", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Reference(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reference", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "requirement" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Requirement(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "requirement", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_ReqExpr(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "req_expr", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Service(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "service", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_SoftwareComponent(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "softwareComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "baseComponent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Stereotype(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "stereotype", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Topology(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "topology", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_UnitConceptualNode(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.ConceptualNode", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployCoreRoot_Visibility(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "visibility", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (deployLinkEClass, 
		   source, 
		   new String[] {
			 "name", "DeployLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployLink_SourceURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "source" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployLink_TargetURI(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "target" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (deployModelObjectEClass, 
		   source, 
		   new String[] {
			 "name", "DeployModelObject", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_Annotations(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "annotation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_AttributeMetaData(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "attributeMetaData", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_ExtendedAttributes(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "extendedAttribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_ArtifactGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "artifact:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_Artifacts(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "artifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "artifact:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_ConstraintGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_Constraints(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "constraint:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployModelObject_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "description" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_DisplayName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "displayName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_Mutable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mutable" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getDeployModelObject_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (deployModelObjectSetEClass, 
		   source, 
		   new String[] {
			 "name", "DeployModelObjectSet", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployModelObjectSet_DeployModelObjectGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "deployModelObject:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployModelObjectSet_DeployModelObject(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "deployModelObject", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "deployModelObject:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (explicitContractEClass, 
		   source, 
		   new String[] {
			 "name", "ExplicitContract", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExplicitContract_ExportedUnits(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "exported.unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExplicitContract_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "property", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExplicitContract_DefaultConceptualPolicy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "defaultConceptualPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExplicitContract_DefaultPolicy(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "defaultPolicy" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (exportedEClass, 
		   source, 
		   new String[] {
			 "name", "Exported", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExported_Configurable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configurable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExported_Linkable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "linkable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExported_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExported_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "path" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (exportedUnitEClass, 
		   source, 
		   new String[] {
			 "name", "ExportedUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExportedUnit_ExportedCapabilities(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "exported.capability", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExportedUnit_ExportedRequirements(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "exported.requirement", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExportedUnit_ExportedProperties(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "property", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExportedUnit_ConstraintGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExportedUnit_AugmentedConstraints(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "constraint:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (extendedAttributeEClass, 
		   source, 
		   new String[] {
			 "name", "ExtendedAttribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getExtendedAttribute_Data(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "data", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExtendedAttribute_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (fileArtifactEClass, 
		   source, 
		   new String[] {
			 "name", "FileArtifact", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getFileArtifact_FileURIs(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "fileURI", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (genericVersionStringEDataType, 
		   source, 
		   new String[] {
			 "name", "GenericVersionString", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
			 "maxLength", "200", //$NON-NLS-1$ //$NON-NLS-2$
			 "pattern", "([0-9a-zA-Z]+(([\\+_%20\\-]*)+[0-9a-zA-Z]+)*)+(\\.([0-9a-zA-Z]+(([\\+_%20\\-]*)+[0-9a-zA-Z]+)*)){0,99}" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (hostingLinkEClass, 
		   source, 
		   new String[] {
			 "name", "HostingLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (importEClass, 
		   source, 
		   new String[] {
			 "name", "Import", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getImport_InstanceConfiguration(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "config.topology", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getImport_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "namespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getImport_Pattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "pattern" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getImport_Reexported(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "reexport" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (installStateEEnum, 
		   source, 
		   new String[] {
			 "name", "InstallState" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (installStateObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "InstallState:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "InstallState" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (instanceConfigurationEClass, 
		   source, 
		   new String[] {
			 "name", "InstanceConfiguration", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInstanceConfiguration_Instantiations(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "instantiation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (instantiationEClass, 
		   source, 
		   new String[] {
			 "name", "Instantiation", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getInstantiation_ConfiguredCapabilityGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getInstantiation_ConfiguredCapabilities(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "capability:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getInstantiation_ConfiguredRequirementsGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "requirement:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getInstantiation_ConfiguredRequirements(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "requirement", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "requirement:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInstantiation_ConfiguredProperties(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "property", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInstantiation_AugmentationGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "augmentation:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInstantiation_Augmentations(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "augmentation", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "augmentation:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getInstantiation_Referenced(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "referenced" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (interfaceEClass, 
		   source, 
		   new String[] {
			 "name", "Interface", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (iStatusEDataType, 
		   source, 
		   new String[] {
			 "name", "IStatus" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (memberLinkEClass, 
		   source, 
		   new String[] {
			 "name", "MemberLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (portTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "PortType", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#integer", //$NON-NLS-1$ //$NON-NLS-2$
			 "minInclusive", "1", //$NON-NLS-1$ //$NON-NLS-2$
			 "maxInclusive", "65535" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (propertyEClass, 
		   source, 
		   new String[] {
			 "name", "Property", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getProperty_Value(), 
		   source, 
		   new String[] {
			 "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getProperty_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getProperty_Select(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "select" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (publishIntentEEnum, 
		   source, 
		   new String[] {
			 "name", "PublishIntent" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (publishIntentObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "PublishIntent:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "PublishIntent" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (realizationLinkEClass, 
		   source, 
		   new String[] {
			 "name", "RealizationLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "name", "Reference", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getReference_InterfaceGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interface:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getReference_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "interface:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getReference_Range(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "range" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (requirementEClass, 
		   source, 
		   new String[] {
			 "name", "Requirement", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (getRequirement_DependencyLinkGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.dependency:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirement_Link(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.dependency", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "link.dependency:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirement_DmoType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dmoType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirement_Extends(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "extends" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirement_LinkType(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "linkType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirement_Use(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "use" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (requirementExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "RequirementExpression", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirementExpression_AttributeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "attributeName" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirementExpression_Interpreter(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interpreter" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirementExpression_Use(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "use" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getRequirementExpression_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "value" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (requirementExpressionUsageEEnum, 
		   source, 
		   new String[] {
			 "name", "RequirementExpressionUsage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (requirementExpressionUsageObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "RequirementExpressionUsage:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "RequirementExpressionUsage" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (requirementLinkTypesEEnum, 
		   source, 
		   new String[] {
			 "name", "RequirementLinkTypes" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (requirementLinkTypesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "RequirementLinkTypes:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "RequirementLinkTypes" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (requirementUsageEEnum, 
		   source, 
		   new String[] {
			 "name", "RequirementUsage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (requirementUsageObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "RequirementUsage:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "RequirementUsage" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (serviceEClass, 
		   source, 
		   new String[] {
			 "name", "Service", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getService_InterfaceGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interface:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getService_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "interface", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "interface:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getService_Protocol(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "protocol" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getService_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "version" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (serviceRangeEDataType, 
		   source, 
		   new String[] {
			 "name", "ServiceRange", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
			 "pattern", "[\\[\\(][0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\,[0-9]{1,3}\\,[%20]+[0-9]{1,3}\\.[0-9]{1,3}[\\)\\]]" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (serviceVersionEDataType, 
		   source, 
		   new String[] {
			 "name", "ServiceVersion", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
			 "pattern", "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (softwareComponentEClass, 
		   source, 
		   new String[] {
			 "name", "SoftwareComponent", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (stereotypeEClass, 
		   source, 
		   new String[] {
			 "name", "Stereotype", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getStereotype_Keyword(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "keyword" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getStereotype_Profile(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "profile" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getStereotype_Required(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "required" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (stringToStringEntryEClass, 
		   source, 
		   new String[] {
			 "name", "StringToStringEntry", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getStringToStringEntry_Key(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "key" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getStringToStringEntry_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "value" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (topologyEClass, 
		   source, 
		   new String[] {
			 "name", "Topology", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_UnitGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_Units(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "unit:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_UnitLinksGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.unit:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_UnitLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "link.unit:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_ConstraintLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_DependencyLinkGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.dependency:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_DependencyLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.dependency", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "link.dependency:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getTopology_RealizationLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.realization", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTopology_Imports(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "import", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTopology_ConfigurationContractGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "contract.topology:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTopology_ConfigurationContract(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "contract.topology", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "contract.topology:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTopology_DecoratorSemantic(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "decoratorSemantic" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTopology_MutabilityConfigurable(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "mutabilityConfigurable" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getTopology_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "namespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (unitEClass, 
		   source, 
		   new String[] {
			 "name", "Unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (getUnit_CapabilityGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_Capabilities(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "capability:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_RequirementGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "requirement:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_Requirements(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "requirement", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "requirement:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_UnitLinksGroup(), 
		   source, 
		   new String[] {
			 "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.unit:group", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_UnitLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.unit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "group", "link.unit:group" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_ConstraintLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.constraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_RealizationLinks(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "link.realization", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnit_Stereotypes(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "stereotype", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_BuildVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "buildVersion" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnit_Conceptual(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "conceptual" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_ConfigurationUnit(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "configurationUnit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnit_GoalInstallState(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "goalInstallState" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_InitInstallState(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initInstallState" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (getUnit_Origin(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "origin" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUnit_PublishIntent(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "publishIntent" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (unitLinkEClass, 
		   source, 
		   new String[] {
			 "name", "UnitLink", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (versionRangeEDataType, 
		   source, 
		   new String[] {
			 "name", "VersionRange", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
			 "pattern", "[\\[\\(][0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\,[0-9]{1,3}\\,[%20]+[0-9]{1,3}\\.[0-9]{1,3}[\\)\\]]" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (versionStringEDataType, 
		   source, 
		   new String[] {
			 "name", "VersionString", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
			 "pattern", "([0-9]{1,9})(\\.[0-9]{1,9}){0,3}" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (visibilityEEnum, 
		   source, 
		   new String[] {
			 "name", "Visibility" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (visibilityObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Visibility:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "Visibility" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

	/**
	 * Initializes the annotations for <b>null</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNullAnnotations() {
		String source = null;																																																																																																																																																																																																															
		addAnnotation
		  ((EOperation)requirementEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
		   });																																																																														
		addAnnotation
		  ((EOperation)unitEClass.getEOperations().get(22), 
		   source, 
		   new String[] {
		   });																																			
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EParameter addEParameter(EOperation owner, EClassifier type, String name,
			int lowerBound, int upperBound, boolean isUnique, boolean isOrdered) {
		EParameter p = ecoreFactory.createEParameter();
		p.setEType(type);
		p.setName(name);
		p.setLowerBound(lowerBound);
		p.setUpperBound(upperBound);
		p.setUnique(isUnique);
		p.setOrdered(isOrdered);
		owner.getEParameters().add(p);
		return p;
	}

	/**
	 * This is the hand-coded EAttribute used when setting the status of a DeployModelObject.
	 * 
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the {@link DeployModelObject#getStatus()}
	 *         attribute.
	 */
	public EAttribute createDeployModelObject_Status() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("DeployModelObject_Status"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

	/**
	 * A faux feature to indicate a change in the <i>contract visibility</i>. When the event is
	 * generated, the old and new values of the event will be empty, so check
	 * {@link Agreement#isPublic(DeployModelObject) Contract.isPublic()} and/or
	 * {@link Agreement#isPublicEditable(DeployModelObject) Contract.isPublicEditable()}. to
	 * determine what the current value is. This event is only generated for adjustments to the
	 * actual DeployModelObject.
	 * 
	 * <p>
	 * If a specific feature is <b>exported</b> or <b>unexported</b>, look for events on the
	 * {@link #createDeployModelObject_ExportedProperties()} feature.
	 * </p>
	 * 
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the {@link DeployModelObject#isPublic()} /
	 *         {@link DeployModelObject#isPublicEditable()} attribute.
	 * 
	 * @see ConfigurationContract
	 */
	public EAttribute createDeployModelObject_Visibility() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("DeployModelObject_Visibility"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

	/**
	 * A faux feature to indicate a change in the set of exported properties for this
	 * DeployModelObject. When the event is generated, the old and new values of the event will
	 * contain the package features {@link CorePackage} for the adjusted feature.
	 * 
	 * <p>
	 * You may also check
	 * {@link Agreement#isPublicEditable(DeployModelObject, String) Contract.isPublicEditable(dmo, attr)}.
	 * to determine what the current value is.
	 * <p>
	 * <p>
	 * If the <i>contract visibility</i> of the containing DeployModelObject is adjusted, the event
	 * will be on the {@link #VISIBILITY} feature.
	 * </p>
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the Exported Properties attribute.
	 * 
	 * @see ConfigurationContract
	 */
	public EAttribute createDeployModelObject_ExportedProperties() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("DeployModelObject_ExportedProperties"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

	/**
	 * A faux feature to indicate a change in the set of exported properties for the imported
	 * Topology. When the event is generated, the old and new values of the event will contain
	 * {@link Unit units} that were affected by the event.
	 * 
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the {@link Agreement#getPublicUnits()}
	 *         attribute.
	 * 
	 * @see InstanceConfiguration
	 */
	public EAttribute createInstanceConfiguration_PublicUnits() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("InstanceConfiguration_PublicUnits"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

	/**
	 * A faux feature to indicate a change in the set of exported properties for the imported
	 * Topology. When the event is generated, the old and new values of the event will contain
	 * {@link Unit units} that were affected by the event.
	 * 
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the {@link Agreement#getPublicEditableUnits()}
	 *         attribute.
	 * 
	 * @see InstanceConfiguration
	 */
	public EAttribute createInstanceConfiguration_PublicEditableUnits() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("InstanceConfiguration_PublicEditableUnits"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

	/**
	 * A faux feature to indicate a change in the set of global properties for the imported Topology.
	 * When the event is generated, the old and new values of the event will contain
	 * {@link Property properties} that were affected by the event.
	 * 
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the {@link Agreement#getGlobalProperties()}
	 *         attribute.
	 * 
	 * @see InstanceConfiguration
	 */
	public EAttribute createInstanceConfiguration_GlobalProperties() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("InstanceConfiguration_GlobalProperties"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

	/**
	 * A faux feature to indicate a change in the set of exported properties for this Topology. When
	 * the event is generated, the old and new values of the event will contain
	 * {@link Property properties} that were affected by the event.
	 * 
	 * <p>
	 * This is <b>not</b> intended to be used by clients directly.
	 * </p>
	 * 
	 * @return the {@link EAttribute} that represents the {@link DeployModelObject#getStatus()}
	 *         attribute.
	 * 
	 * @see ConfigurationContract
	 */
	public EAttribute createTopology_GlobalProperties() {
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("Topology_GlobalProperties"); //$NON-NLS-1$
		attribute.setChangeable(false);
		attribute.setTransient(true);
		attribute.setVolatile(true);
		attribute.setDerived(true);
		return attribute;
	}

} //CorePackageImpl
