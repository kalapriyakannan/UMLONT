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

import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.util.CapabilityCaptionProvider;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Capability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Capabilities carry configuration content for their containing {@link Unit}.
 * 				<p>
 * 				Capabilities satisify {@link Requirement}s on other Units.  The linking may
 * 				be direct, using a {@link DependencyLink}, or indirect using a {@link UnitLink}.
 * 				A unit will typically provide one or more capabilities.  Because the model
 * 				does not support multiple inheritance, the use of multiple capabilites provides
 * 				the modeler with a tool to capture different facets of the unit.</p>
 * 				<p>
 * 				Capability instances may restrict the types of links that can be bound to
 * 				them, directly or indirectly.  Typically, dependency capabilities have
 * 				link type {@link CapabilityLinkTypes#DEPENDENCY}, while hosting capabilities
 * 				have link type {@link CapabilityLinkTypes#ANY} to express the fact that even
 * 				though they are hosting, others may have indirect dependencies on their
 * 				configuration.</p>
 * 				<p>
 * 				Domain extensions are expected to extend the capability type, providing additional
 * 				attributes.</p>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Capability#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Capability#getBuildVersion <em>Build Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Capability#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Capability#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCapability()
 * @model extendedMetaData="name='Capability' kind='elementOnly'"
 * @generated
 */
public interface Capability extends DeployModelObject {
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
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCapability_Stereotypes()
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
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCapability_BuildVersion()
	 * @model unique="false" dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='buildVersion'"
	 * @generated
	 */
	String getBuildVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Capability#getBuildVersion <em>Build Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Version</em>' attribute.
	 * @see #getBuildVersion()
	 * @generated
	 */
	void setBuildVersion(String value);

	/**
	 * Returns the value of the '<em><b>Link Type</b></em>' attribute. The default value is
	 * <code>"dependency"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Satisfies a {@link DependencyLink} or
	 * {@link UnitLink}; Matches against {@link Requirement}.linkType <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Link Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
	 * @see #isSetLinkType()
	 * @see #unsetLinkType()
	 * @see #setLinkType(CapabilityLinkTypes)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCapability_LinkType()
	 * @model default="dependency" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='linkType'"
	 * @generated
	 */
	CapabilityLinkTypes getLinkType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Capability#getLinkType <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes
	 * @see #isSetLinkType()
	 * @see #unsetLinkType()
	 * @see #getLinkType()
	 * @generated
	 */
	void setLinkType(CapabilityLinkTypes value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Capability#getLinkType <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetLinkType()
	 * @see #getLinkType()
	 * @see #setLinkType(CapabilityLinkTypes)
	 * @generated
	 */
	void unsetLinkType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Capability#getLinkType <em>Link Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Link Type</em>' attribute is set.
	 * @see #unsetLinkType()
	 * @see #getLinkType()
	 * @see #setLinkType(CapabilityLinkTypes)
	 * @generated
	 */
	boolean isSetLinkType();

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
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getCapability_Origin()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='origin'"
	 * @generated
	 */
	String getOrigin();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Capability#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

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

	//	/**
	//	 * @param hypotheticals
	//	 *           Map of String->Object; overrides for current state of Capability
	//	 * @return if not-null, the Capability's contribution to the Unit's recommended title
	//	 * @deprecated use use getCaptionProvider().calculatedTitle()
	//	 */
	//	String calculatedTitle(Map<String, Object> hypotheticals);
	//
	//	/**
	//	 * @return A String that names the Capability
	//	 * @deprecated use getCaptionProvider().title()
	//	 */
	//	String title();
	//
	//	/**
	//	 * @return A String that names the Capability and supplies additional information
	//	 * @deprecated use getCaptionProvider().titleWithContext()
	//	 */
	//	String titleWithContext();

	/**
	 * @return a caption provider, which provides strings to the UI
	 */
	CapabilityCaptionProvider getCaptionProvider();

	/**
	 * @return A List of EStructuralFeature|String keys this Capability contributes to its title
	 */
	List<EAttribute> titleKeys();

} // Capability
