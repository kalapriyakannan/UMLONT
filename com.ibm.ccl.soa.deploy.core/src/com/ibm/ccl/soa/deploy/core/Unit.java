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

import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeAdapter;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.IObjectAdapter;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeAdapter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.UnitCaptionProvider;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Unit</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 	      Represents an abstract unit of publishable deployment.
 * 	      <p>
 * 	      A unit is an contains provided {@link Capability} instances, and consumed {@link Requirement}
 * 	      instances.  In is contained in a {@link Topology}.  A unit can be published to the modeled
 * 	      infrastructure using a deployment publisher.  It has hosting and dependency requirements.</p>
 * 	      <p>
 * 	      Typically, unit subtypes are defined as tag types and do not add attributes.  The tag is
 * 	      used by publishers to identify the driver responsible for provisioning the unit in the
 * 	      infrastructure.  Unit properties are typically associated with subtypes of {@link Capability}.
 * 	      In the first release of the Topology Definition Model (TDM) the schema does not enforce
 * 	      the association between unit and capability types.  Modelers create templates which are
 * 	      instances of unit subtypes containing predefined sets of capabilities and requirements.</p>
 * 	    
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#getBuildVersion <em>Build Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#isConceptual <em>Conceptual</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#isConfigurationUnit <em>Configuration Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#getGoalInstallState <em>Goal Install State</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#getInitInstallState <em>Init Install State</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#getOrigin <em>Origin</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Unit#getPublishIntent <em>Publish Intent</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit()
 * @model features="capabilityGroup capabilities requirementGroup requirements unitLinksGroup unitLinks constraintLinks realizationLinks" 
 *        capabilityGroupUnique="false" capabilityGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" capabilityGroupMany="true" capabilityGroupSuppressedGetVisibility="true" capabilityGroupSuppressedSetVisibility="true"
 *        capabilityGroupExtendedMetaData="kind='group' name='capability:group' namespace='##targetNamespace'"
 *        capabilitiesType="com.ibm.ccl.soa.deploy.core.Capability" capabilitiesContainment="true" capabilitiesMany="true" capabilitiesTransient="true" capabilitiesVolatile="true" capabilitiesDerived="true" capabilitiesSuppressedGetVisibility="true" capabilitiesSuppressedSetVisibility="true"
 *        capabilitiesExtendedMetaData="kind='element' name='capability' namespace='##targetNamespace' group='capability:group'"
 *        requirementGroupUnique="false" requirementGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" requirementGroupMany="true" requirementGroupSuppressedGetVisibility="true" requirementGroupSuppressedSetVisibility="true"
 *        requirementGroupExtendedMetaData="kind='group' name='requirement:group' namespace='##targetNamespace'"
 *        requirementsType="com.ibm.ccl.soa.deploy.core.Requirement" requirementsContainment="true" requirementsMany="true" requirementsTransient="true" requirementsVolatile="true" requirementsDerived="true" requirementsSuppressedGetVisibility="true" requirementsSuppressedSetVisibility="true"
 *        requirementsExtendedMetaData="kind='element' name='requirement' namespace='##targetNamespace' group='requirement:group'"
 *        unitLinksGroupUnique="false" unitLinksGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" unitLinksGroupMany="true" unitLinksGroupSuppressedGetVisibility="true" unitLinksGroupSuppressedSetVisibility="true"
 *        unitLinksGroupExtendedMetaData="kind='group' name='link.unit:group' namespace='##targetNamespace'"
 *        unitLinksType="com.ibm.ccl.soa.deploy.core.UnitLink" unitLinksContainment="true" unitLinksMany="true" unitLinksTransient="true" unitLinksVolatile="true" unitLinksDerived="true" unitLinksSuppressedGetVisibility="true" unitLinksSuppressedSetVisibility="true"
 *        unitLinksExtendedMetaData="kind='element' name='link.unit' namespace='##targetNamespace' group='link.unit:group'"
 *        constraintLinksType="com.ibm.ccl.soa.deploy.core.ConstraintLink" constraintLinksContainment="true" constraintLinksMany="true" constraintLinksSuppressedGetVisibility="true" constraintLinksSuppressedSetVisibility="true"
 *        constraintLinksExtendedMetaData="kind='element' name='link.constraint' namespace='##targetNamespace'"
 *        realizationLinksType="com.ibm.ccl.soa.deploy.core.RealizationLink" realizationLinksContainment="true" realizationLinksMany="true" realizationLinksSuppressedGetVisibility="true" realizationLinksSuppressedSetVisibility="true"
 *        realizationLinksExtendedMetaData="kind='element' name='link.realization' namespace='##targetNamespace'"
 *        extendedMetaData="name='Unit' kind='elementOnly'"
 * @generated
 */
public interface Unit extends DeployModelObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' containment reference list.
	 * The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Stereotype}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_Stereotypes()
	 * @model type="com.ibm.ccl.soa.deploy.core.Stereotype" containment="true"
	 *        extendedMetaData="kind='element' name='stereotype' namespace='##targetNamespace'"
	 * @generated
	 */
	List getStereotypes();

	/**
	 * Returns the value of the '<em><b>Build Version</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Build Version</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> This attribute is used to specify the build
	 * version of the unit when having multiple version controlled units. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Build Version</em>' attribute.
	 * @see #setBuildVersion(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_BuildVersion()
	 * @model unique="false" dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='buildVersion'"
	 * @generated
	 */
	String getBuildVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getBuildVersion <em>Build Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Version</em>' attribute.
	 * @see #getBuildVersion()
	 * @generated
	 */
	void setBuildVersion(String value);

	/**
	 * Returns the value of the '<em><b>Conceptual</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptual</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptual</em>' attribute.
	 * @see #isSetConceptual()
	 * @see #unsetConceptual()
	 * @see #setConceptual(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_Conceptual()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='conceptual'"
	 * @generated
	 */
	boolean isConceptual();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#isConceptual <em>Conceptual</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptual</em>' attribute.
	 * @see #isSetConceptual()
	 * @see #unsetConceptual()
	 * @see #isConceptual()
	 * @generated
	 */
	void setConceptual(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#isConceptual <em>Conceptual</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetConceptual()
	 * @see #isConceptual()
	 * @see #setConceptual(boolean)
	 * @generated
	 */
	void unsetConceptual();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#isConceptual <em>Conceptual</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Conceptual</em>' attribute is set.
	 * @see #unsetConceptual()
	 * @see #isConceptual()
	 * @see #setConceptual(boolean)
	 * @generated
	 */
	boolean isSetConceptual();

	/**
	 * Returns the value of the '<em><b>Configuration Unit</b></em>' attribute. The default
	 * value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Unit</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Hint that this Unit configures another Unit
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Configuration Unit</em>' attribute.
	 * @see #isSetConfigurationUnit()
	 * @see #unsetConfigurationUnit()
	 * @see #setConfigurationUnit(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_ConfigurationUnit()
	 * @model default="false" unique="false" unsettable="true"
	 *        dataType="org.eclipse.emf.ecore.xml.type.Boolean" extendedMetaData="kind='attribute'
	 *        name='configurationUnit'"
	 * @generated
	 */
	boolean isConfigurationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#isConfigurationUnit <em>Configuration Unit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Unit</em>' attribute.
	 * @see #isSetConfigurationUnit()
	 * @see #unsetConfigurationUnit()
	 * @see #isConfigurationUnit()
	 * @generated
	 */
	void setConfigurationUnit(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#isConfigurationUnit <em>Configuration Unit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetConfigurationUnit()
	 * @see #isConfigurationUnit()
	 * @see #setConfigurationUnit(boolean)
	 * @generated
	 */
	void unsetConfigurationUnit();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#isConfigurationUnit <em>Configuration Unit</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Configuration Unit</em>' attribute is set.
	 * @see #unsetConfigurationUnit()
	 * @see #isConfigurationUnit()
	 * @see #setConfigurationUnit(boolean)
	 * @generated
	 */
	boolean isSetConfigurationUnit();

	/**
	 * Returns the value of the '<em><b>Goal Install State</b></em>' attribute.
	 * The default value is <code>"unknown"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.core.InstallState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goal Install State</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal Install State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @see #isSetGoalInstallState()
	 * @see #unsetGoalInstallState()
	 * @see #setGoalInstallState(InstallState)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_GoalInstallState()
	 * @model default="unknown" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='goalInstallState'"
	 * @generated
	 */
	InstallState getGoalInstallState();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getGoalInstallState <em>Goal Install State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal Install State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @see #isSetGoalInstallState()
	 * @see #unsetGoalInstallState()
	 * @see #getGoalInstallState()
	 * @generated
	 */
	void setGoalInstallState(InstallState value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getGoalInstallState <em>Goal Install State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetGoalInstallState()
	 * @see #getGoalInstallState()
	 * @see #setGoalInstallState(InstallState)
	 * @generated
	 */
	void unsetGoalInstallState();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getGoalInstallState <em>Goal Install State</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Goal Install State</em>' attribute is set.
	 * @see #unsetGoalInstallState()
	 * @see #getGoalInstallState()
	 * @see #setGoalInstallState(InstallState)
	 * @generated
	 */
	boolean isSetGoalInstallState();

	/**
	 * Returns the value of the '<em><b>Init Install State</b></em>' attribute. The default
	 * value is <code>"unknown"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.InstallState}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Install State</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> If 'installed', short-circuits some validation
	 * and publishing steps <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Init Install State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @see #isSetInitInstallState()
	 * @see #unsetInitInstallState()
	 * @see #setInitInstallState(InstallState)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_InitInstallState()
	 * @model default="unknown" unique="false" unsettable="true" extendedMetaData="kind='attribute'
	 *        name='initInstallState'"
	 * @generated
	 */
	InstallState getInitInstallState();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getInitInstallState <em>Init Install State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Install State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.InstallState
	 * @see #isSetInitInstallState()
	 * @see #unsetInitInstallState()
	 * @see #getInitInstallState()
	 * @generated
	 */
	void setInitInstallState(InstallState value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getInitInstallState <em>Init Install State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetInitInstallState()
	 * @see #getInitInstallState()
	 * @see #setInitInstallState(InstallState)
	 * @generated
	 */
	void unsetInitInstallState();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getInitInstallState <em>Init Install State</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Init Install State</em>' attribute is set.
	 * @see #unsetInitInstallState()
	 * @see #getInitInstallState()
	 * @see #setInitInstallState(InstallState)
	 * @generated
	 */
	boolean isSetInitInstallState();

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> This attribute is used to set the origin of the
	 * unit when having multiple version controlled units. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see #setOrigin(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_Origin()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='origin'"
	 * @generated
	 */
	String getOrigin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

	/**
	 * Returns the value of the '<em><b>Publish Intent</b></em>' attribute.
	 * The default value is <code>"publish"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.core.PublishIntent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publish Intent</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publish Intent</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
	 * @see #isSetPublishIntent()
	 * @see #unsetPublishIntent()
	 * @see #setPublishIntent(PublishIntent)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnit_PublishIntent()
	 * @model default="publish" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='publishIntent'"
	 * @generated
	 */
	PublishIntent getPublishIntent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getPublishIntent <em>Publish Intent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publish Intent</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.PublishIntent
	 * @see #isSetPublishIntent()
	 * @see #unsetPublishIntent()
	 * @see #getPublishIntent()
	 * @generated
	 */
	void setPublishIntent(PublishIntent value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getPublishIntent <em>Publish Intent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPublishIntent()
	 * @see #getPublishIntent()
	 * @see #setPublishIntent(PublishIntent)
	 * @generated
	 */
	void unsetPublishIntent();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Unit#getPublishIntent <em>Publish Intent</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Publish Intent</em>' attribute is set.
	 * @see #unsetPublishIntent()
	 * @see #getPublishIntent()
	 * @see #setPublishIntent(PublishIntent)
	 * @generated
	 */
	boolean isSetPublishIntent();

	/**
	 * Return a list of {@link Requirement} elements that are consumed by this Unit.
	 * 
	 * @return A List of {@link Requirement} elements.
	 * @generated NOT
	 */
	List getRequirements();

	/**
	 * Returns a list of {@link Requirement} elements provided by this Unit whose elements are
	 * filtered.
	 * 
	 * @param filter
	 *           filteres the capabilities returned (see {@link RequirementLinkTypeFilter})
	 * @param addObjectAdapter
	 *           optionally adapts values added to the list (see {@link RequirementLinkTypeAdapter}) --
	 *           may be null.
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getRequirements(IObjectFilter filter, IObjectAdapter addObjectAdapter);

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * either {@link RequirementLinkTypes#HOSTING} or {@link RequirementLinkTypes#ANY}.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getHostingOrAnyRequirements();

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * either {@link RequirementLinkTypes#DEPENDENCY} or {@link RequirementLinkTypes#ANY}.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getDependencyOrAnyRequirements();

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * {@link RequirementLinkTypes#ANY}.
	 * <p>
	 * Note: does <b>not</b> return {@link Requirement} elements whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#HOSTING} or
	 * {@link RequirementLinkTypes#DEPENDENCY}.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getOnlyAnyRequirements();

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * {@link RequirementLinkTypes#HOSTING}.
	 * <p>
	 * Note: does <b>not</b> return {@link Requirement} elements whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#ANY}.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getOnlyHostingRequirements();

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * {@link RequirementLinkTypes#DEPENDENCY}.
	 * <p>
	 * Note: does <b>not</b> return {@link Requirement} elements whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#ANY}.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getOnlyDependencyRequirements();

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * {@link RequirementLinkTypes#MEMBER}.
	 * <p>
	 * Note: does <b>not</b> return {@link Requirement} elements whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#ANY}.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getOnlyMemberRequirements();

	/**
	 * Returns true if the unit contains any {@link Requirement} whose
	 * {@link Requirement#getLinkType()} is {@link RequirementLinkTypes#MEMBER}.
	 * <p>
	 * Equivalent to {@link #getOnlyMemberRequirements()}.size() > 0
	 * 
	 * @return true if the unit has a requirement with link type {@link RequirementLinkTypes#MEMBER}.
	 * @generated NOT
	 */
	boolean isGroup();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated NOT
	 */
	boolean isVisible();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated NOT
	 */
	boolean isPublic();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated NOT
	 */
	boolean isPublicEditable();

	/**
	 * Returns true if the unit is bound to a backing object from the environment
	 * <p>
	 * 
	 * @return true if the unit is bound.
	 * @generated NOT
	 */
	boolean isBound();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.UnitLink"
	 * @generated
	 */
	List getUnitLinks();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.HostingLink"
	 * @generated
	 */
	List getHostingLinks();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.MemberLink"
	 * @generated
	 */
	List getMemberLinks();

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the list of Constraint Links contained in the Unit. Constraint Links contained in a
	 * Unit should be links that have as their source a DeployModelObject that is contained
	 * (directly, or indirectly) in the unit. The code that creates a new Constraint Link should make
	 * sure that the link is added to the list of Constraint Links of the appropriate unit.
	 * 
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.ConstraintLink"
	 * @generated
	 */
	List getConstraintLinks();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.RealizationLink"
	 * @generated
	 */
	List getRealizationLinks();

	/**
	 * Return a list of {@link Requirement} elements whose {@link Requirement#getLinkType()} is
	 * either {@link RequirementLinkTypes#MEMBER} or {@link RequirementLinkTypes#ANY}.
	 * <p>
	 * Use {@link #getOnlyMemberRequirements()} to filter out {@link RequirementLinkTypes#ANY}
	 * requirements.
	 * 
	 * @return List<Requirement>
	 * @generated NOT
	 */
	List getMemberOrAnyRequirements();

	/**
	 * Return a list of {@link Capability} elements that are provided by this Unit.
	 * <p>
	 * <strong>Compatibility note:</strong> does not return consumed capabilities.
	 * 
	 * @return A List of {@link Capability} elements.
	 * @generated NOT
	 */
	List getCapabilities();

	/**
	 * Returns a list of {@link Capability} elements provided by this Unit whose elements are
	 * filtered.
	 * 
	 * @param filter
	 *           filteres the capabilities returned (see {@link CapabilityLinkTypeFilter})
	 * @param addObjectAdapter
	 *           optionally adapts values added to the list (see {@link CapabilityLinkTypeAdapter}) --
	 *           may be null.
	 * @return List<Capability>
	 * @generated NOT
	 */
	List getCapabilities(IObjectFilter filter, IObjectAdapter addObjectAdapter);

	/**
	 * Return a list of {@link Capability} elements whose {@link Capability#getLinkType()} is
	 * {@link CapabilityLinkTypes#DEPENDENCY}.
	 * <p>
	 * Note: does <b>not</b> return {@link Capability} elements whose
	 * {@link Capability#getLinkType()} is {@link CapabilityLinkTypes#ANY}.
	 * 
	 * @return A List of {@link Capability} elements.
	 * @generated NOT
	 */
	List getOnlyHostingCapabilities();

	/**
	 * Return a list of {@link Capability} elements whose {@link Capability#getLinkType()} is
	 * {@link CapabilityLinkTypes#DEPENDENCY}.
	 * <p>
	 * Note: does <b>not</b> return {@link Capability} elements whose
	 * {@link Capability#getLinkType()} is {@link CapabilityLinkTypes#ANY}.
	 * 
	 * @return A List of {@link Capability} elements.
	 * @generated NOT
	 */
	List getOnlyDependencyCapabilities();

	/**
	 * Return a list of {@link Capability} elements whose {@link Capability#getLinkType()} is either
	 * {@link CapabilityLinkTypes#HOSTING} or {@link CapabilityLinkTypes#ANY}.
	 * 
	 * @return A List of {@link Capability} elements.
	 * @generated NOT
	 */
	List getHostingOrAnyCapabilities();

	/**
	 * Return a list of {@link Capability} elements whose {@link Capability#getLinkType()} is either
	 * {@link CapabilityLinkTypes#DEPENDENCY} or {@link CapabilityLinkTypes#ANY}.
	 * 
	 * @return A List of {@link Capability} elements.
	 * @generated NOT
	 */
	List getDependencyOrAnyCapabilities();

	/**
	 * Return a list of {@link Capability} elements whose {@link Capability#getLinkType()} is
	 * {@link CapabilityLinkTypes#ANY}.
	 * <p>
	 * Note: does <b>not</b> return {@link Capability} elements whose
	 * {@link Capability#getLinkType()} is {@link CapabilityLinkTypes#HOSTING} or
	 * {@link CapabilityLinkTypes#DEPENDENCY}.
	 * 
	 * @return A List of {@link Capability} elements.
	 * @generated NOT
	 */
	List getOnlyAnyCapabilities();

	/**
	 * Used to test if the passed <code>hostedUnit</code> is being hosted by this {@link Unit}.
	 * This method will look for {@link HostingLink}s with wth hosted type being equal to the passed
	 * hostedUnit.
	 * 
	 * <p>
	 * The checkedContained will be used to test contained Units as well.
	 * </p>
	 * 
	 * @param hostedUnit -
	 *           The {@link Unit} to test for hosted.
	 * @param checkContained -
	 *           A boolean used to test the contained Units as ell.
	 * @return A boolean indicating if the hostedUnit is being hosted by this Unit.
	 * @generated NOT
	 */
	boolean isHosting(Unit hostedUnit, boolean checkContained);

	/**
	 * Get the specialized type id for this unit type. Take into account any specialization logic
	 * that determines the type. As for example, a WebsphereAppServer unit can have specialized type
	 * id for version v6 and version 6.1. If you need to define UnitFilters for a unit
	 * specialization, then you must override this method.
	 * 
	 * @return String the specialized type id
	 * @generated NOT
	 */
	String getSpecializedTypeId();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.Artifact"
	 * @generated
	 */
	List getArtifacts();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.DependencyLink"
	 * @generated
	 */
	List getDependencyLinks();

	//	/**
	//	 * @param hypotheticals
	//	 *           Map of DeployModelObject->Map(of String->Object); overrides to value
	//	 * @return if not-null, the Unit contribution to the recommended title
	//	 * @deprecated use use getCaptionProvider().calculatedTitle()
	//	 */
	//	String calculatedTitle(Map<Capability, Map<EAttribute, String>> hypotheticals);
	//
	//	/**
	//	 * @return A String that names the Unit
	//	 * @deprecated use getCaptionProvider().title()
	//	 */
	//	String title();
	//
	//	/**
	//	 * @return A String that names the Unit and supplies additional information
	//	 * @deprecated use getCaptionProvider().titleWithContext()
	//	 */
	//	String titleWithContext();

	/**
	 * @return a caption provider, which provides strings to the UI
	 */
	UnitCaptionProvider getCaptionProvider();

} // Unit
