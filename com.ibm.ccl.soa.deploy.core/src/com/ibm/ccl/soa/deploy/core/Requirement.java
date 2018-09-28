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

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A Requirement expresses a configuration or runtime dependency of its containing {@link Unit}.
 * 				<p>
 * 				The requirement must be satisfied by a {@link Capability}.  Typically, the capability
 * 				will be on another unit.  The linking will depend on the {@link #getLinkType()} of
 * 				the requirement.</p>
 * 				
 * 				<ul>
 * 				<li> {@link RequirementLinkTypes#DEPENDENCY} : the linking is through {@link #getLink()}.</li>
 * 				<li> {@link RequirementLinkTypes#HOSTING}: the linking is through a {@link HostingLink}
 * 				     contained in the parent Unit.</li>
 * 				<li> {@link RequirementLinkTypes#MEMBER}: the linking is through a {@link MemberLink}
 * 				     contained in the parent Unit.</li>
 * 				<li> {@link RequirementLinkTypes#ANY}: rarely used for capabilities that can be simultaneously
 * 				     dependency, hosting, and member.</li>
 * 				     
 * 				</ul>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Requirement#getExtends <em>Extends</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Requirement#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Requirement#getUse <em>Use</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirement()
 * @model features="dependencyLinkGroup link dmoType" 
 *        dependencyLinkGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" dependencyLinkGroupMany="false" dependencyLinkGroupSuppressedGetVisibility="true" dependencyLinkGroupSuppressedSetVisibility="true"
 *        dependencyLinkGroupExtendedMetaData="kind='group' name='link.dependency:group' namespace='##targetNamespace'"
 *        linkType="com.ibm.ccl.soa.deploy.core.DependencyLink" linkContainment="true" linkTransient="true" linkVolatile="true" linkDerived="true" linkSuppressedGetVisibility="true" linkSuppressedSetVisibility="true"
 *        linkExtendedMetaData="kind='element' name='link.dependency' namespace='##targetNamespace' group='link.dependency:group'"
 *        dmoTypeDataType="org.eclipse.emf.ecore.xml.type.QName" dmoTypeRequired="true" dmoTypeSuppressedGetVisibility="true" dmoTypeSuppressedSetVisibility="true"
 *        dmoTypeExtendedMetaData="kind='attribute' name='dmoType'"
 *        extendedMetaData="name='Requirement' kind='elementOnly'"
 * @generated
 */
public interface Requirement extends DeployModelObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the list of Requirement Expression constraints, defined on this Requirement.
	 * 
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.RequirementExpression"
	 * @generated
	 */
	List getExpressions();

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
	 * Returns the value of the '<em><b>Extends</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Relative path to a requirement that this
	 * requirement extends <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Extends</em>' attribute.
	 * @see #setExtends(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirement_Extends()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='extends'"
	 * @generated
	 */
	String getExtends();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getExtends <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' attribute.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(String value);

	/**
	 * Returns the value of the '<em><b>Link Type</b></em>' attribute. The default value is
	 * <code>"dependency"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.RequirementLinkTypes}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Shall Requirement be met by a
	 * {@link DependencyLink} or {@link UnitLink}; matches against {@link Capability}.linkType <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Link Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
	 * @see #isSetLinkType()
	 * @see #unsetLinkType()
	 * @see #setLinkType(RequirementLinkTypes)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirement_LinkType()
	 * @model default="dependency" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='linkType'"
	 * @generated
	 */
	RequirementLinkTypes getLinkType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getLinkType <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementLinkTypes
	 * @see #isSetLinkType()
	 * @see #unsetLinkType()
	 * @see #getLinkType()
	 * @generated
	 */
	void setLinkType(RequirementLinkTypes value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getLinkType <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetLinkType()
	 * @see #getLinkType()
	 * @see #setLinkType(RequirementLinkTypes)
	 * @generated
	 */
	void unsetLinkType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getLinkType <em>Link Type</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Link Type</em>' attribute is set.
	 * @see #unsetLinkType()
	 * @see #getLinkType()
	 * @see #setLinkType(RequirementLinkTypes)
	 * @generated
	 */
	boolean isSetLinkType();

	/**
	 * Returns the value of the '<em><b>Use</b></em>' attribute. The default value is
	 * <code>"required"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.core.RequirementUsage}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Usually 'required' <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Use</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
	 * @see #isSetUse()
	 * @see #unsetUse()
	 * @see #setUse(RequirementUsage)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getRequirement_Use()
	 * @model default="required" unique="false" unsettable="true" extendedMetaData="kind='attribute'
	 *        name='use'"
	 * @generated
	 */
	RequirementUsage getUse();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getUse <em>Use</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.core.RequirementUsage
	 * @see #isSetUse()
	 * @see #unsetUse()
	 * @see #getUse()
	 * @generated
	 */
	void setUse(RequirementUsage value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getUse <em>Use</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUse()
	 * @see #getUse()
	 * @see #setUse(RequirementUsage)
	 * @generated
	 */
	void unsetUse();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Requirement#getUse <em>Use</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Use</em>' attribute is set.
	 * @see #unsetUse()
	 * @see #getUse()
	 * @see #setUse(RequirementUsage)
	 * @generated
	 */
	boolean isSetUse();

	/**
	 * Returns the <em>fist</em> expression whose name equals the argument, or null if none exists.
	 * 
	 * @param name
	 *           the name of a contained requirement expression.
	 * @return the <em>first</em> expression of the specified name, or null.
	 * 
	 * @generated NOT
	 * @deprecated use {@link DeployModelObject#getConstraint(String)} instead
	 */
	RequirementExpression getExpression(String name);

	/**
	 * Returns the {@link #getCapabilityType()} XMLNS {@link QualifiedName} converted to an EMF
	 * {@link EClass}.
	 * <p>
	 * The conversion requires that the {@link Requirement#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @return the EClass corresponding to the XMLNS {@link QualifiedName}.
	 * 
	 * @throws RuntimeException
	 *            if {@link Requirement#getTopology()}.eContainer() == null.
	 * @generated NOT
	 */
	EClass getDmoEType();

	/**
	 * Sets the value of the {@link #setCapabilityType(Object)} attribute by converting the
	 * {@link EClass} to an XMLNS {@link QualifiedName}.
	 * <p>
	 * The conversion requires that the {@link Requirement#getTopology()} be non-null, and contained
	 * in a {@link DeployCoreRoot}.
	 * 
	 * @param type
	 *           the ECore type to be converted to an XMLNS {@link QualifiedName}.
	 * 
	 * @throws RuntimeException
	 *            if {@link Requirement#getTopology()}.eContainer() == null.
	 * @generated NOT
	 */
	void setDmoEType(EClass type);

	/**
	 * @return DependencyLink with a target {@link Capability}.
	 * @generated NOT
	 */
	DependencyLink getLink();

	/**
	 * Set the dependency link of the requirement.
	 * 
	 * @param newLink
	 *           the new dependency link.
	 * @generated NOT
	 */
	void setLink(DependencyLink newLink);

} // Requirement
