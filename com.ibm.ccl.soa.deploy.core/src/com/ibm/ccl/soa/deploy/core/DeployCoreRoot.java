/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Core Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifact <em>Artifact</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifactFile <em>Artifact File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getBaseComponent <em>Base Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnit <em>Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapability <em>Capability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityBundle <em>Capability Bundle</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityCommunication <em>Capability Communication</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConfigTopology <em>Config Topology</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractExplicit <em>Contract Explicit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractTopology <em>Contract Topology</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getDeployModelObject <em>Deploy Model Object</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getImport <em>Import</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInstantiation <em>Instantiation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInterface <em>Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkConstraint <em>Link Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDependency <em>Link Dependency</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDeploy <em>Link Deploy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkHosting <em>Link Hosting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkUnit <em>Link Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkMember <em>Link Member</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkRealization <em>Link Realization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getProperty <em>Property</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReference <em>Reference</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReqExpr <em>Req Expr</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getService <em>Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getSoftwareComponent <em>Software Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getTopology <em>Topology</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnitConceptualNode <em>Unit Conceptual Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DeployCoreRoot extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Annotation</em>' containment reference.
	 * @see #setAnnotation(Annotation)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Annotation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='annotation' namespace='##targetNamespace'"
	 * @generated
	 */
	Annotation getAnnotation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getAnnotation <em>Annotation</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' containment reference.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(Annotation value);

	/**
	 * Returns the value of the '<em><b>Artifact</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artifact</em>' containment reference.
	 * @see #setArtifact(Artifact)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Artifact()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='artifact' namespace='##targetNamespace'"
	 * @generated
	 */
	Artifact getArtifact();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifact <em>Artifact</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact</em>' containment reference.
	 * @see #getArtifact()
	 * @generated
	 */
	void setArtifact(Artifact value);

	/**
	 * Returns the value of the '<em><b>Artifact File</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact File</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artifact File</em>' containment reference.
	 * @see #setArtifactFile(FileArtifact)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_ArtifactFile()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='artifact.file' namespace='##targetNamespace'
	 *        affiliation='artifact'"
	 * @generated
	 */
	FileArtifact getArtifactFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getArtifactFile <em>Artifact File</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact File</em>' containment reference.
	 * @see #getArtifactFile()
	 * @generated
	 */
	void setArtifactFile(FileArtifact value);

	/**
	 * Returns the value of the '<em><b>Base Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Component</em>' containment reference.
	 * @see #setBaseComponent(BaseComponentUnit)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_BaseComponent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='baseComponent' namespace='##targetNamespace' affiliation='unit'"
	 * @generated
	 */
	BaseComponentUnit getBaseComponent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getBaseComponent <em>Base Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Component</em>' containment reference.
	 * @see #getBaseComponent()
	 * @generated
	 */
	void setBaseComponent(BaseComponentUnit value);

	/**
	 * Returns the value of the '<em><b>Capability</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability</em>' containment reference.
	 * @see #setCapability(Capability)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Capability()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability' namespace='##targetNamespace'"
	 * @generated
	 */
	Capability getCapability();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapability <em>Capability</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability</em>' containment reference.
	 * @see #getCapability()
	 * @generated
	 */
	void setCapability(Capability value);

	/**
	 * Returns the value of the '<em><b>Capability Bundle</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Bundle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Bundle</em>' containment reference.
	 * @see #setCapabilityBundle(BundleCapability)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_CapabilityBundle()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.bundle' namespace='##targetNamespace'
	 *        affiliation='capability'"
	 * @generated
	 */
	BundleCapability getCapabilityBundle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityBundle <em>Capability Bundle</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Bundle</em>' containment reference.
	 * @see #getCapabilityBundle()
	 * @generated
	 */
	void setCapabilityBundle(BundleCapability value);

	/**
	 * Returns the value of the '<em><b>Capability Communication</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Communication</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Communication</em>' containment reference.
	 * @see #setCapabilityCommunication(CommunicationCapability)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_CapabilityCommunication()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.communication' namespace='##targetNamespace' affiliation='capability'"
	 * @generated
	 */
	CommunicationCapability getCapabilityCommunication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getCapabilityCommunication <em>Capability Communication</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Communication</em>' containment reference.
	 * @see #getCapabilityCommunication()
	 * @generated
	 */
	void setCapabilityCommunication(CommunicationCapability value);

	/**
	 * Returns the value of the '<em><b>Deploy Model Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deploy Model Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deploy Model Object</em>' containment reference.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_DeployModelObject()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='deployModelObject' namespace='##targetNamespace'"
	 * @generated
	 */
	DeployModelObject getDeployModelObject();

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Import</em>' containment reference.
	 * @see #setImport(Import)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Import()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
	 * @generated
	 */
	Import getImport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getImport <em>Import</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' containment reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(Import value);

	/**
	 * Returns the value of the '<em><b>Instantiation</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiation</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Instantiation</em>' containment reference.
	 * @see #setInstantiation(Instantiation)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Instantiation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='instantiation' namespace='##targetNamespace'"
	 * @generated
	 */
	Instantiation getInstantiation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInstantiation <em>Instantiation</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiation</em>' containment reference.
	 * @see #getInstantiation()
	 * @generated
	 */
	void setInstantiation(Instantiation value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interface</em>' containment reference.
	 * @see #setInterface(Interface)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Interface()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='interface' namespace='##targetNamespace'"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getInterface <em>Interface</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' containment reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Link Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Constraint</em>' containment reference.
	 * @see #setLinkConstraint(ConstraintLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.constraint' namespace='##targetNamespace'"
	 * @generated
	 */
	ConstraintLink getLinkConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkConstraint <em>Link Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Constraint</em>' containment reference.
	 * @see #getLinkConstraint()
	 * @generated
	 */
	void setLinkConstraint(ConstraintLink value);

	/**
	 * Returns the value of the '<em><b>Link Dependency</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Dependency</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Dependency</em>' containment reference.
	 * @see #setLinkDependency(DependencyLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkDependency()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.dependency' namespace='##targetNamespace'"
	 * @generated
	 */
	DependencyLink getLinkDependency();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDependency <em>Link Dependency</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Dependency</em>' containment reference.
	 * @see #getLinkDependency()
	 * @generated
	 */
	void setLinkDependency(DependencyLink value);

	/**
	 * Returns the value of the '<em><b>Link Deploy</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Deploy</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Deploy</em>' containment reference.
	 * @see #setLinkDeploy(DeployLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkDeploy()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.deploy' namespace='##targetNamespace'"
	 * @generated
	 */
	DeployLink getLinkDeploy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkDeploy <em>Link Deploy</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Deploy</em>' containment reference.
	 * @see #getLinkDeploy()
	 * @generated
	 */
	void setLinkDeploy(DeployLink value);

	/**
	 * Returns the value of the '<em><b>Link Hosting</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Hosting</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Hosting</em>' containment reference.
	 * @see #setLinkHosting(HostingLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkHosting()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.hosting' namespace='##targetNamespace'
	 *        affiliation='link.unit'"
	 * @generated
	 */
	HostingLink getLinkHosting();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkHosting <em>Link Hosting</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Hosting</em>' containment reference.
	 * @see #getLinkHosting()
	 * @generated
	 */
	void setLinkHosting(HostingLink value);

	/**
	 * Returns the value of the '<em><b>Link Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Unit</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Unit</em>' containment reference.
	 * @see #setLinkUnit(UnitLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.unit' namespace='##targetNamespace'"
	 * @generated
	 */
	UnitLink getLinkUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkUnit <em>Link Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Unit</em>' containment reference.
	 * @see #getLinkUnit()
	 * @generated
	 */
	void setLinkUnit(UnitLink value);

	/**
	 * Returns the value of the '<em><b>Link Member</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Member</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Member</em>' containment reference.
	 * @see #setLinkMember(MemberLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkMember()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.member' namespace='##targetNamespace'
	 *        affiliation='link.unit'"
	 * @generated
	 */
	MemberLink getLinkMember();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkMember <em>Link Member</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Member</em>' containment reference.
	 * @see #getLinkMember()
	 * @generated
	 */
	void setLinkMember(MemberLink value);

	/**
	 * Returns the value of the '<em><b>Link Realization</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Realization</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Realization</em>' containment reference.
	 * @see #setLinkRealization(RealizationLink)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_LinkRealization()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='link.realization' namespace='##targetNamespace'"
	 * @generated
	 */
	RealizationLink getLinkRealization();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getLinkRealization <em>Link Realization</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Realization</em>' containment reference.
	 * @see #getLinkRealization()
	 * @generated
	 */
	void setLinkRealization(RealizationLink value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Property</em>' containment reference.
	 * @see #setProperty(Property)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Property()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getProperty <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' containment reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reference</em>' containment reference.
	 * @see #setReference(Reference)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Reference()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='reference' namespace='##targetNamespace'
	 *        affiliation='requirement'"
	 * @generated
	 */
	Reference getReference();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReference <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' containment reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Reference value);

	/**
	 * Returns the value of the '<em><b>Req Expr</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req Expr</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Req Expr</em>' containment reference.
	 * @see #setReqExpr(RequirementExpression)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_ReqExpr()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='req_expr' namespace='##targetNamespace'
	 *        affiliation='constraint'"
	 * @generated
	 */
	RequirementExpression getReqExpr();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getReqExpr <em>Req Expr</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req Expr</em>' containment reference.
	 * @see #getReqExpr()
	 * @generated
	 */
	void setReqExpr(RequirementExpression value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(Service)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Service()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service' namespace='##targetNamespace'
	 *        affiliation='capability'"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Software Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Software Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Software Component</em>' containment reference.
	 * @see #setSoftwareComponent(SoftwareComponent)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_SoftwareComponent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='softwareComponent' namespace='##targetNamespace' affiliation='baseComponent'"
	 * @generated
	 */
	SoftwareComponent getSoftwareComponent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getSoftwareComponent <em>Software Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Software Component</em>' containment reference.
	 * @see #getSoftwareComponent()
	 * @generated
	 */
	void setSoftwareComponent(SoftwareComponent value);

	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' containment reference.
	 * @see #setStereotype(Stereotype)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Stereotype()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='stereotype' namespace='##targetNamespace'"
	 * @generated
	 */
	Stereotype getStereotype();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getStereotype <em>Stereotype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' containment reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requirement</em>' containment reference.
	 * @see #setRequirement(Requirement)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Requirement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='requirement' namespace='##targetNamespace'"
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getRequirement <em>Requirement</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' containment reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Topology</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topology</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Topology</em>' containment reference.
	 * @see #setTopology(Topology)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Topology()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='topology' namespace='##targetNamespace'"
	 * @generated
	 */
	Topology getTopology();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getTopology <em>Topology</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topology</em>' containment reference.
	 * @see #getTopology()
	 * @generated
	 */
	void setTopology(Topology value);

	/**
	 * Returns the value of the '<em><b>Unit Conceptual Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Conceptual Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Conceptual Node</em>' containment reference.
	 * @see #setUnitConceptualNode(ConceptualNode)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_UnitConceptualNode()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.ConceptualNode' namespace='##targetNamespace' affiliation='unit'"
	 * @generated
	 */
	ConceptualNode getUnitConceptualNode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnitConceptualNode <em>Unit Conceptual Node</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Conceptual Node</em>' containment reference.
	 * @see #getUnitConceptualNode()
	 * @generated
	 */
	void setUnitConceptualNode(ConceptualNode value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"private"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.core.Visibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see #setVisibility(Visibility)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Visibility()
	 * @model default="private" unique="false" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='visibility' namespace='##targetNamespace'"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit</em>' containment reference.
	 * @see #setUnit(Unit)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Unit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit' namespace='##targetNamespace'"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getUnit <em>Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' containment reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

	/**
	 * Returns the value of the '<em><b>Config Topology</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config Topology</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Config Topology</em>' containment reference.
	 * @see #setConfigTopology(InstanceConfiguration)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_ConfigTopology()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='config.topology' namespace='##targetNamespace'"
	 * @generated
	 */
	InstanceConfiguration getConfigTopology();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getConfigTopology <em>Config Topology</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config Topology</em>' containment reference.
	 * @see #getConfigTopology()
	 * @generated
	 */
	void setConfigTopology(InstanceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint</em>' containment reference.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_Constraint()
	 * @model containment="true" upper="-2" transient="true" changeable="false" volatile="true"
	 *        derived="true" extendedMetaData="kind='element' name='constraint'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	Constraint getConstraint();

	/**
	 * Returns the value of the '<em><b>Contract Explicit</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract Explicit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contract Explicit</em>' containment reference.
	 * @see #setContractExplicit(ExplicitContract)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_ContractExplicit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='contract.explicit' namespace='##targetNamespace'
	 *        affiliation='contract.topology'"
	 * @generated
	 */
	ExplicitContract getContractExplicit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractExplicit <em>Contract Explicit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract Explicit</em>' containment reference.
	 * @see #getContractExplicit()
	 * @generated
	 */
	void setContractExplicit(ExplicitContract value);

	/**
	 * Returns the value of the '<em><b>Contract Topology</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract Topology</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contract Topology</em>' containment reference.
	 * @see #setContractTopology(ConfigurationContract)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDeployCoreRoot_ContractTopology()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='contract.topology'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	ConfigurationContract getContractTopology();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.DeployCoreRoot#getContractTopology <em>Contract Topology</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract Topology</em>' containment reference.
	 * @see #getContractTopology()
	 * @generated
	 */
	void setContractTopology(ConfigurationContract value);

} // DeployCoreRoot
