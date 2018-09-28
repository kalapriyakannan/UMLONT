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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
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
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.core.CorePackage
 * @generated
 */
public class CoreSwitch {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CorePackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				Object result = caseAnnotation(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ARTIFACT: {
				Artifact artifact = (Artifact)theEObject;
				Object result = caseArtifact(artifact);
				if (result == null) result = caseDeployModelObject(artifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ATTRIBUTE_META_DATA: {
				AttributeMetaData attributeMetaData = (AttributeMetaData)theEObject;
				Object result = caseAttributeMetaData(attributeMetaData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.AUGMENTATION: {
				Augmentation augmentation = (Augmentation)theEObject;
				Object result = caseAugmentation(augmentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BASE_COMPONENT_UNIT: {
				BaseComponentUnit baseComponentUnit = (BaseComponentUnit)theEObject;
				Object result = caseBaseComponentUnit(baseComponentUnit);
				if (result == null) result = caseUnit(baseComponentUnit);
				if (result == null) result = caseDeployModelObject(baseComponentUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BUNDLE_CAPABILITY: {
				BundleCapability bundleCapability = (BundleCapability)theEObject;
				Object result = caseBundleCapability(bundleCapability);
				if (result == null) result = caseCapability(bundleCapability);
				if (result == null) result = caseDeployModelObject(bundleCapability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CAPABILITY: {
				Capability capability = (Capability)theEObject;
				Object result = caseCapability(capability);
				if (result == null) result = caseDeployModelObject(capability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.COMMUNICATION_CAPABILITY: {
				CommunicationCapability communicationCapability = (CommunicationCapability)theEObject;
				Object result = caseCommunicationCapability(communicationCapability);
				if (result == null) result = caseCapability(communicationCapability);
				if (result == null) result = caseDeployModelObject(communicationCapability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONCEPTUAL_NODE: {
				ConceptualNode conceptualNode = (ConceptualNode)theEObject;
				Object result = caseConceptualNode(conceptualNode);
				if (result == null) result = caseUnit(conceptualNode);
				if (result == null) result = caseDeployModelObject(conceptualNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONFIGURATION_CONTRACT: {
				ConfigurationContract configurationContract = (ConfigurationContract)theEObject;
				Object result = caseConfigurationContract(configurationContract);
				if (result == null) result = caseDeployModelObject(configurationContract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				Object result = caseConstraint(constraint);
				if (result == null) result = caseDeployModelObject(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONSTRAINT_LINK: {
				ConstraintLink constraintLink = (ConstraintLink)theEObject;
				Object result = caseConstraintLink(constraintLink);
				if (result == null) result = caseDeployLink(constraintLink);
				if (result == null) result = caseDeployModelObject(constraintLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEPENDENCY_LINK: {
				DependencyLink dependencyLink = (DependencyLink)theEObject;
				Object result = caseDependencyLink(dependencyLink);
				if (result == null) result = caseDeployLink(dependencyLink);
				if (result == null) result = caseDeployModelObject(dependencyLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEPLOY_CORE_ROOT: {
				DeployCoreRoot deployCoreRoot = (DeployCoreRoot)theEObject;
				Object result = caseDeployCoreRoot(deployCoreRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEPLOY_LINK: {
				DeployLink deployLink = (DeployLink)theEObject;
				Object result = caseDeployLink(deployLink);
				if (result == null) result = caseDeployModelObject(deployLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEPLOY_MODEL_OBJECT: {
				DeployModelObject deployModelObject = (DeployModelObject)theEObject;
				Object result = caseDeployModelObject(deployModelObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DEPLOY_MODEL_OBJECT_SET: {
				DeployModelObjectSet deployModelObjectSet = (DeployModelObjectSet)theEObject;
				Object result = caseDeployModelObjectSet(deployModelObjectSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXPLICIT_CONTRACT: {
				ExplicitContract explicitContract = (ExplicitContract)theEObject;
				Object result = caseExplicitContract(explicitContract);
				if (result == null) result = caseConfigurationContract(explicitContract);
				if (result == null) result = caseDeployModelObject(explicitContract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXPORTED: {
				Exported exported = (Exported)theEObject;
				Object result = caseExported(exported);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXPORTED_UNIT: {
				ExportedUnit exportedUnit = (ExportedUnit)theEObject;
				Object result = caseExportedUnit(exportedUnit);
				if (result == null) result = caseExported(exportedUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXTENDED_ATTRIBUTE: {
				ExtendedAttribute extendedAttribute = (ExtendedAttribute)theEObject;
				Object result = caseExtendedAttribute(extendedAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.FILE_ARTIFACT: {
				FileArtifact fileArtifact = (FileArtifact)theEObject;
				Object result = caseFileArtifact(fileArtifact);
				if (result == null) result = caseArtifact(fileArtifact);
				if (result == null) result = caseDeployModelObject(fileArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.HOSTING_LINK: {
				HostingLink hostingLink = (HostingLink)theEObject;
				Object result = caseHostingLink(hostingLink);
				if (result == null) result = caseUnitLink(hostingLink);
				if (result == null) result = caseDeployLink(hostingLink);
				if (result == null) result = caseDeployModelObject(hostingLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.IMPORT: {
				Import import_ = (Import)theEObject;
				Object result = caseImport(import_);
				if (result == null) result = caseDeployModelObject(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INSTANCE_CONFIGURATION: {
				InstanceConfiguration instanceConfiguration = (InstanceConfiguration)theEObject;
				Object result = caseInstanceConfiguration(instanceConfiguration);
				if (result == null) result = caseDeployModelObject(instanceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INSTANTIATION: {
				Instantiation instantiation = (Instantiation)theEObject;
				Object result = caseInstantiation(instantiation);
				if (result == null) result = caseDeployModelObject(instantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.INTERFACE: {
				Interface interface_ = (Interface)theEObject;
				Object result = caseInterface(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.MEMBER_LINK: {
				MemberLink memberLink = (MemberLink)theEObject;
				Object result = caseMemberLink(memberLink);
				if (result == null) result = caseUnitLink(memberLink);
				if (result == null) result = caseDeployLink(memberLink);
				if (result == null) result = caseDeployModelObject(memberLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROPERTY: {
				Property property = (Property)theEObject;
				Object result = caseProperty(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REALIZATION_LINK: {
				RealizationLink realizationLink = (RealizationLink)theEObject;
				Object result = caseRealizationLink(realizationLink);
				if (result == null) result = caseDeployLink(realizationLink);
				if (result == null) result = caseDeployModelObject(realizationLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REFERENCE: {
				Reference reference = (Reference)theEObject;
				Object result = caseReference(reference);
				if (result == null) result = caseRequirement(reference);
				if (result == null) result = caseDeployModelObject(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REQUIREMENT: {
				Requirement requirement = (Requirement)theEObject;
				Object result = caseRequirement(requirement);
				if (result == null) result = caseDeployModelObject(requirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.REQUIREMENT_EXPRESSION: {
				RequirementExpression requirementExpression = (RequirementExpression)theEObject;
				Object result = caseRequirementExpression(requirementExpression);
				if (result == null) result = caseConstraint(requirementExpression);
				if (result == null) result = caseDeployModelObject(requirementExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SERVICE: {
				Service service = (Service)theEObject;
				Object result = caseService(service);
				if (result == null) result = caseCapability(service);
				if (result == null) result = caseDeployModelObject(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SOFTWARE_COMPONENT: {
				SoftwareComponent softwareComponent = (SoftwareComponent)theEObject;
				Object result = caseSoftwareComponent(softwareComponent);
				if (result == null) result = caseBaseComponentUnit(softwareComponent);
				if (result == null) result = caseUnit(softwareComponent);
				if (result == null) result = caseDeployModelObject(softwareComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.STEREOTYPE: {
				Stereotype stereotype = (Stereotype)theEObject;
				Object result = caseStereotype(stereotype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.STRING_TO_STRING_ENTRY: {
				Map.Entry stringToStringEntry = (Map.Entry)theEObject;
				Object result = caseStringToStringEntry(stringToStringEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.TOPOLOGY: {
				Topology topology = (Topology)theEObject;
				Object result = caseTopology(topology);
				if (result == null) result = caseDeployModelObject(topology);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.UNIT: {
				Unit unit = (Unit)theEObject;
				Object result = caseUnit(unit);
				if (result == null) result = caseDeployModelObject(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.UNIT_LINK: {
				UnitLink unitLink = (UnitLink)theEObject;
				Object result = caseUnitLink(unitLink);
				if (result == null) result = caseDeployLink(unitLink);
				if (result == null) result = caseDeployModelObject(unitLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Artifact</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseArtifact(Artifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Meta Data</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeMetaData(AttributeMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Augmentation</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Augmentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAugmentation(Augmentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Component Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBaseComponentUnit(BaseComponentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBundleCapability(BundleCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Capability</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationCapability(CommunicationCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conceptual Node</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conceptual Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConceptualNode(ConceptualNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Contract</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Contract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConfigurationContract(ConfigurationContract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraintLink(ConstraintLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDependencyLink(DependencyLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Core Root</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Core Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployCoreRoot(DeployCoreRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployLink(DeployLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object Set</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObjectSet(DeployModelObjectSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Explicit Contract</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Explicit Contract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExplicitContract(ExplicitContract object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Exported</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Exported</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExported(Exported object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exported Unit</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exported Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExportedUnit(ExportedUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Attribute</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExtendedAttribute(ExtendedAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Artifact</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFileArtifact(FileArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hosting Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hosting Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHostingLink(HostingLink object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Import</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Configuration</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInstanceConfiguration(InstanceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiation</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInstantiation(Instantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseInterface(Interface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMemberLink(MemberLink object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Property</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realization Link</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realization Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealizationLink(RealizationLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Expression</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRequirementExpression(RequirementExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Service</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSoftwareComponent(SoftwareComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStereotype(Stereotype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To String Entry</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To String Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringToStringEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Topology</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Topology</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTopology(Topology object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Unit</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Link</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnitLink(UnitLink object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //CoreSwitch
