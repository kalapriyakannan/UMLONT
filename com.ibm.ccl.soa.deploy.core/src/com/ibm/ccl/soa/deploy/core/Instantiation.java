/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * 
 * An Instantiation represents a {@link Unit} from the importED topology. When a {@link Unit} is
 * exposed in the {@link ConfigurationContract} as <b>public-editable</b>, the user may additively
 * modify the {@link Unit} in order to configure it in the importING topology. Examples of these
 * modifications include adding custom/specialized {@link Capability capabilities},
 * {@link Requirement requirements}, setting values for exposed {@link Property properties}, as
 * well as persisting {@link Augmentation augmentations} to append to lists contained in the
 * imported {@link DeployModelObject model objects} dynamically in memory.
 * 
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.Instantiation#getConfiguredProperties <em>Configured Properties</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.Instantiation#getAugmentationGroup <em>Augmentation Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.Instantiation#getAugmentations <em>Augmentations</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.Instantiation#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstantiation()
 * @model features="configuredCapabilityGroup configuredCapabilities configuredRequirementsGroup
 *        configuredRequirements" configuredCapabilityGroupUnique="false"
 *        configuredCapabilityGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry"
 *        configuredCapabilityGroupMany="true"
 *        configuredCapabilityGroupSuppressedGetVisibility="true"
 *        configuredCapabilityGroupSuppressedSetVisibility="true"
 *        configuredCapabilityGroupExtendedMetaData="kind='group' name='capability:group'
 *        namespace='##targetNamespace'"
 *        configuredCapabilitiesType="com.ibm.ccl.soa.deploy.core.Capability"
 *        configuredCapabilitiesContainment="true" configuredCapabilitiesMany="true"
 *        configuredCapabilitiesTransient="true" configuredCapabilitiesVolatile="true"
 *        configuredCapabilitiesDerived="true" configuredCapabilitiesSuppressedGetVisibility="true"
 *        configuredCapabilitiesSuppressedSetVisibility="true"
 *        configuredCapabilitiesExtendedMetaData="kind='element' name='capability'
 *        namespace='##targetNamespace' group='capability:group'"
 *        configuredRequirementsGroupUnique="false"
 *        configuredRequirementsGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry"
 *        configuredRequirementsGroupMany="true"
 *        configuredRequirementsGroupSuppressedGetVisibility="true"
 *        configuredRequirementsGroupSuppressedSetVisibility="true"
 *        configuredRequirementsGroupExtendedMetaData="kind='group' name='requirement:group'
 *        namespace='##targetNamespace'"
 *        configuredRequirementsType="com.ibm.ccl.soa.deploy.core.Requirement"
 *        configuredRequirementsContainment="true" configuredRequirementsMany="true"
 *        configuredRequirementsTransient="true" configuredRequirementsVolatile="true"
 *        configuredRequirementsDerived="true" configuredRequirementsSuppressedGetVisibility="true"
 *        configuredRequirementsSuppressedSetVisibility="true"
 *        configuredRequirementsExtendedMetaData="kind='element' name='requirement'
 *        namespace='##targetNamespace' group='requirement:group'"
 *        extendedMetaData="name='Instantiation' kind='elementOnly'"
 * @generated @
 */
public interface Instantiation extends DeployModelObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Configured Properties</b></em>' containment reference
	 * list. The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Property}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configured Properties</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Configured Properties</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstantiation_ConfiguredProperties()
	 * @model type="com.ibm.ccl.soa.deploy.core.Property" containment="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	List getConfiguredProperties();

	/**
	 * Returns the value of the '<em><b>Augmentation Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Augmentation Group</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Augmentation Group</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstantiation_AugmentationGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='augmentation:group' namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getAugmentationGroup();

	/**
	 * Returns the value of the '<em><b>Augmentations</b></em>' containment reference list. The
	 * list contents are of type {@link com.ibm.ccl.soa.deploy.core.Augmentation}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Augmentations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Augmentations</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstantiation_Augmentations()
	 * @model type="com.ibm.ccl.soa.deploy.core.Augmentation" containment="true" transient="true"
	 *        volatile="true" derived="true" extendedMetaData="kind='element' name='augmentation'
	 *        namespace='##targetNamespace' group='augmentation:group'"
	 * @generated
	 */
	List getAugmentations();

	/**
	 * Returns the value of the '<em><b>Referenced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced</em>' attribute.
	 * @see #setReferenced(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInstantiation_Referenced()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='referenced'"
	 * @generated
	 */
	String getReferenced();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Instantiation#getReferenced <em>Referenced</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced</em>' attribute.
	 * @see #getReferenced()
	 * @generated
	 */
	void setReferenced(String value);

	/**
	 * Return the {@link Capability capabilities} that have been augmented onto the Proxified
	 * {@link Unit} represented by this Instantiation.
	 * 
	 * @return The {@link Capability capabilities} that have been augmented onto the Proxified
	 *         {@link Unit} represented by this Instantiation.
	 */
	public List getCapabilities();

	/**
	 * Return the {@link Requirement requirements} that have been augmented onto the Proxified
	 * {@link Unit} represented by this Instantiation.
	 * 
	 * @return The {@link Requirement requirements} that have been augmented onto the Proxified
	 *         {@link Unit} represented by this Instantiation.
	 */
	public List getRequirements();

	/**
	 * Return a property of the given name.
	 * 
	 * <p>
	 * This method may return null.
	 * </p>
	 * 
	 * @param property
	 *           The name of the property to look for.
	 * 
	 * @return The property of the given name.
	 */
	Property getProperty(String property);

	/**
	 * Return the default value of the property as configured by the contract. Unset properties will
	 * be returned as an empty string.
	 * 
	 * <p>
	 * This method may return null if the given property is unknown
	 * </p>
	 * 
	 * @param property
	 *           The name of the property to look for.
	 * 
	 * @return The property of the given name.
	 */
	String getDefaultValue(String property);

	/**
	 * Return the augmentation for the given field.
	 * 
	 * @param field
	 *           The name of a field from the source's EClass.
	 * @return The augmentation for the given field.
	 */
	Augmentation getAugmentation(String field);

	/**
	 * Return the augmentation for the given field, and create it if necessary.
	 * 
	 * @param field
	 *           The name of a field from the source's EClass.
	 * @return The augmentation for the given field or create it if necessary.
	 */
	Augmentation createAugmentation(String field);

	/**
	 * Return the referenced object from the imported Topology.
	 * 
	 * @return The referenced object from the imported Topology.
	 */
	DeployModelObject getReferencedObject();

	/**
	 * Resolve the augmented object (if available) of the given relative URI
	 * 
	 * @param referenced
	 *           The relative URI of the augmented {@link DeployModelObject}.
	 * @return The augmented object (if available) of the given relative URI
	 */
	DeployModelObject resolveReferenced(String referenced);

} // Instantiation
