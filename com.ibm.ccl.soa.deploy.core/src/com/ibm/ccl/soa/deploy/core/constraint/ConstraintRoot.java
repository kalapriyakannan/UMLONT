/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Root</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getMixed <em>Mixed</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAnd <em>Constraint And</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationcommunication <em>Constraint Applicationcommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationprotocol <em>Constraint Applicationprotocol</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttrdef <em>Constraint Attrdef</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttributePropagation <em>Constraint Attribute Propagation</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintBasecommunication <em>Constraint Basecommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacity <em>Constraint Capacity</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacityRestriction <em>Constraint Capacity Restriction</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCollocation <em>Constraint Collocation</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationbandwidth <em>Constraint Communicationbandwidth</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationcost <em>Constraint Communicationcost</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationport <em>Constraint Communicationport</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationredundancy <em>Constraint Communicationredundancy</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationtype <em>Constraint Communicationtype</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintDeferredHosting <em>Constraint Deferred Hosting</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEnumeration <em>Constraint Enumeration</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEquals <em>Constraint Equals</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintExclusion <em>Constraint Exclusion</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintGroupCardinality <em>Constraint Group Cardinality</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintMemberCardinality <em>Constraint Member Cardinality</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNetworkcommunication <em>Constraint Networkcommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNot <em>Constraint Not</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintOr <em>Constraint Or</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintPalette <em>Constraint Palette</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintProductIdentifier <em>Constraint Product Identifier</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRange <em>Constraint Range</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRealization <em>Constraint Realization</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintStereotype <em>Constraint Stereotype</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintSynchronouscommunication <em>Constraint Synchronouscommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintTransmissiondelay <em>Constraint Transmissiondelay</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintType <em>Constraint Type</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintUpdate <em>Constraint Update</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintVersion <em>Constraint Version</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintXor <em>Constraint Xor</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface ConstraintRoot extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list. The list contents are of
	 * type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

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
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Constraint And</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint And</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint And</em>' containment reference.
	 * @see #setConstraintAnd(AndConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintAnd()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.and' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	AndConstraint getConstraintAnd();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAnd <em>Constraint And</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint And</em>' containment reference.
	 * @see #getConstraintAnd()
	 * @generated
	 */
	void setConstraintAnd(AndConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Applicationcommunication</b></em>'
	 * containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Applicationcommunication</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Applicationcommunication</em>' containment
	 *         reference.
	 * @see #setConstraintApplicationcommunication(ApplicationCommunicationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintApplicationcommunication()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.applicationcommunication'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ApplicationCommunicationConstraint getConstraintApplicationcommunication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationcommunication <em>Constraint Applicationcommunication</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Applicationcommunication</em>' containment
	 *           reference.
	 * @see #getConstraintApplicationcommunication()
	 * @generated
	 */
	void setConstraintApplicationcommunication(ApplicationCommunicationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Applicationprotocol</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Applicationprotocol</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Applicationprotocol</em>' containment reference.
	 * @see #setConstraintApplicationprotocol(ApplicationCommunicationProtocolConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintApplicationprotocol()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.applicationprotocol'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ApplicationCommunicationProtocolConstraint getConstraintApplicationprotocol();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationprotocol <em>Constraint Applicationprotocol</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Applicationprotocol</em>' containment
	 *           reference.
	 * @see #getConstraintApplicationprotocol()
	 * @generated
	 */
	void setConstraintApplicationprotocol(ApplicationCommunicationProtocolConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Attrdef</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Attrdef</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Attrdef</em>' containment reference.
	 * @see #setConstraintAttrdef(AttributeDefinedConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintAttrdef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.attrdef'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	AttributeDefinedConstraint getConstraintAttrdef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttrdef <em>Constraint Attrdef</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Attrdef</em>' containment reference.
	 * @see #getConstraintAttrdef()
	 * @generated
	 */
	void setConstraintAttrdef(AttributeDefinedConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Attribute Propagation</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Attribute Propagation</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Attribute Propagation</em>' containment
	 *         reference.
	 * @see #setConstraintAttributePropagation(AttributePropagationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintAttributePropagation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.attributePropagation'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	AttributePropagationConstraint getConstraintAttributePropagation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttributePropagation <em>Constraint Attribute Propagation</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Attribute Propagation</em>' containment
	 *           reference.
	 * @see #getConstraintAttributePropagation()
	 * @generated
	 */
	void setConstraintAttributePropagation(AttributePropagationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Basecommunication</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Basecommunication</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Basecommunication</em>' containment reference.
	 * @see #setConstraintBasecommunication(BaseCommunicationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintBasecommunication()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.basecommunication'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	BaseCommunicationConstraint getConstraintBasecommunication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintBasecommunication <em>Constraint Basecommunication</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Basecommunication</em>' containment
	 *           reference.
	 * @see #getConstraintBasecommunication()
	 * @generated
	 */
	void setConstraintBasecommunication(BaseCommunicationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Capacity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Capacity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Capacity</em>' containment reference.
	 * @see #setConstraintCapacity(CapacityConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCapacity()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.capacity'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CapacityConstraint getConstraintCapacity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacity <em>Constraint Capacity</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Capacity</em>' containment reference.
	 * @see #getConstraintCapacity()
	 * @generated
	 */
	void setConstraintCapacity(CapacityConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Capacity Restriction</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Capacity Restriction</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Capacity Restriction</em>' containment reference.
	 * @see #setConstraintCapacityRestriction(AttributeCapacityConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCapacityRestriction()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.capacityRestriction'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	AttributeCapacityConstraint getConstraintCapacityRestriction();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacityRestriction <em>Constraint Capacity Restriction</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Capacity Restriction</em>' containment
	 *           reference.
	 * @see #getConstraintCapacityRestriction()
	 * @generated
	 */
	void setConstraintCapacityRestriction(AttributeCapacityConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Collocation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Collocation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Collocation</em>' containment reference.
	 * @see #setConstraintCollocation(CollocationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCollocation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.collocation'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CollocationConstraint getConstraintCollocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCollocation <em>Constraint Collocation</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Collocation</em>' containment reference.
	 * @see #getConstraintCollocation()
	 * @generated
	 */
	void setConstraintCollocation(CollocationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Communicationbandwidth</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Communicationbandwidth</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Communicationbandwidth</em>' containment
	 *         reference.
	 * @see #setConstraintCommunicationbandwidth(CommunicationBandwidthConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCommunicationbandwidth()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.communicationbandwidth'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CommunicationBandwidthConstraint getConstraintCommunicationbandwidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationbandwidth <em>Constraint Communicationbandwidth</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Communicationbandwidth</em>' containment
	 *           reference.
	 * @see #getConstraintCommunicationbandwidth()
	 * @generated
	 */
	void setConstraintCommunicationbandwidth(CommunicationBandwidthConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Communicationcost</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Communicationcost</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Communicationcost</em>' containment reference.
	 * @see #setConstraintCommunicationcost(CommunicationCostConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCommunicationcost()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.communicationcost'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CommunicationCostConstraint getConstraintCommunicationcost();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationcost <em>Constraint Communicationcost</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Communicationcost</em>' containment
	 *           reference.
	 * @see #getConstraintCommunicationcost()
	 * @generated
	 */
	void setConstraintCommunicationcost(CommunicationCostConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Communicationport</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Communicationport</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Communicationport</em>' containment reference.
	 * @see #setConstraintCommunicationport(CommunicationPortConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCommunicationport()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.communicationport'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CommunicationPortConstraint getConstraintCommunicationport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationport <em>Constraint Communicationport</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Communicationport</em>' containment
	 *           reference.
	 * @see #getConstraintCommunicationport()
	 * @generated
	 */
	void setConstraintCommunicationport(CommunicationPortConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Communicationredundancy</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Communicationredundancy</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Communicationredundancy</em>' containment
	 *         reference.
	 * @see #setConstraintCommunicationredundancy(CommunicationRedundancyConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCommunicationredundancy()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.communicationredundancy'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CommunicationRedundancyConstraint getConstraintCommunicationredundancy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationredundancy <em>Constraint Communicationredundancy</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Communicationredundancy</em>' containment
	 *           reference.
	 * @see #getConstraintCommunicationredundancy()
	 * @generated
	 */
	void setConstraintCommunicationredundancy(CommunicationRedundancyConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Communicationtype</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Communicationtype</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Communicationtype</em>' containment reference.
	 * @see #setConstraintCommunicationtype(CommunicationTypeConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintCommunicationtype()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.communicationtype'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	CommunicationTypeConstraint getConstraintCommunicationtype();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationtype <em>Constraint Communicationtype</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Communicationtype</em>' containment
	 *           reference.
	 * @see #getConstraintCommunicationtype()
	 * @generated
	 */
	void setConstraintCommunicationtype(CommunicationTypeConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Deferred Hosting</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Deferred Hosting</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Deferred Hosting</em>' containment reference.
	 * @see #setConstraintDeferredHosting(DeferredHostingConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintDeferredHosting()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.deferredHosting'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	DeferredHostingConstraint getConstraintDeferredHosting();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintDeferredHosting <em>Constraint Deferred Hosting</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Deferred Hosting</em>' containment
	 *           reference.
	 * @see #getConstraintDeferredHosting()
	 * @generated
	 */
	void setConstraintDeferredHosting(DeferredHostingConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Enumeration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Enumeration</em>' containment reference.
	 * @see #setConstraintEnumeration(EnumerationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintEnumeration()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.enumeration'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	EnumerationConstraint getConstraintEnumeration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEnumeration <em>Constraint Enumeration</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Enumeration</em>' containment reference.
	 * @see #getConstraintEnumeration()
	 * @generated
	 */
	void setConstraintEnumeration(EnumerationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Equals</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Equals</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Equals</em>' containment reference.
	 * @see #setConstraintEquals(EqualsConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintEquals()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.equals' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	EqualsConstraint getConstraintEquals();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEquals <em>Constraint Equals</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Equals</em>' containment reference.
	 * @see #getConstraintEquals()
	 * @generated
	 */
	void setConstraintEquals(EqualsConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Exclusion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Exclusion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Exclusion</em>' containment reference.
	 * @see #setConstraintExclusion(ExclusionConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintExclusion()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.exclusion'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ExclusionConstraint getConstraintExclusion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintExclusion <em>Constraint Exclusion</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Exclusion</em>' containment reference.
	 * @see #getConstraintExclusion()
	 * @generated
	 */
	void setConstraintExclusion(ExclusionConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Group Cardinality</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Group Cardinality</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Group Cardinality</em>' containment reference.
	 * @see #setConstraintGroupCardinality(GroupCardinalityConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintGroupCardinality()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.groupCardinality'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	GroupCardinalityConstraint getConstraintGroupCardinality();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintGroupCardinality <em>Constraint Group Cardinality</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Group Cardinality</em>' containment
	 *           reference.
	 * @see #getConstraintGroupCardinality()
	 * @generated
	 */
	void setConstraintGroupCardinality(GroupCardinalityConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Member Cardinality</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Member Cardinality</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Member Cardinality</em>' containment reference.
	 * @see #setConstraintMemberCardinality(MemberCardinalityConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintMemberCardinality()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.memberCardinality'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	MemberCardinalityConstraint getConstraintMemberCardinality();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintMemberCardinality <em>Constraint Member Cardinality</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Member Cardinality</em>' containment
	 *           reference.
	 * @see #getConstraintMemberCardinality()
	 * @generated
	 */
	void setConstraintMemberCardinality(MemberCardinalityConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Networkcommunication</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Networkcommunication</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Networkcommunication</em>' containment reference.
	 * @see #setConstraintNetworkcommunication(NetworkCommunicationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintNetworkcommunication()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.networkcommunication'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	NetworkCommunicationConstraint getConstraintNetworkcommunication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNetworkcommunication <em>Constraint Networkcommunication</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Networkcommunication</em>' containment
	 *           reference.
	 * @see #getConstraintNetworkcommunication()
	 * @generated
	 */
	void setConstraintNetworkcommunication(NetworkCommunicationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Not</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Not</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Not</em>' containment reference.
	 * @see #setConstraintNot(NotConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintNot()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.not' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	NotConstraint getConstraintNot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNot <em>Constraint Not</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Not</em>' containment reference.
	 * @see #getConstraintNot()
	 * @generated
	 */
	void setConstraintNot(NotConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Or</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Or</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Or</em>' containment reference.
	 * @see #setConstraintOr(OrConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintOr()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.or' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	OrConstraint getConstraintOr();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintOr <em>Constraint Or</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Or</em>' containment reference.
	 * @see #getConstraintOr()
	 * @generated
	 */
	void setConstraintOr(OrConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Palette</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Palette</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Palette</em>' containment reference.
	 * @see #setConstraintPalette(PaletteConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintPalette()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.palette'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	PaletteConstraint getConstraintPalette();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintPalette <em>Constraint Palette</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Palette</em>' containment reference.
	 * @see #getConstraintPalette()
	 * @generated
	 */
	void setConstraintPalette(PaletteConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Product Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Product Identifier</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Product Identifier</em>' containment reference.
	 * @see #setConstraintProductIdentifier(ProductIdentifierConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintProductIdentifier()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.productIdentifier'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ProductIdentifierConstraint getConstraintProductIdentifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintProductIdentifier <em>Constraint Product Identifier</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Product Identifier</em>' containment
	 *           reference.
	 * @see #getConstraintProductIdentifier()
	 * @generated
	 */
	void setConstraintProductIdentifier(ProductIdentifierConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Range</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Range</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Range</em>' containment reference.
	 * @see #setConstraintRange(RangeConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintRange()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.range' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	RangeConstraint getConstraintRange();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRange <em>Constraint Range</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Range</em>' containment reference.
	 * @see #getConstraintRange()
	 * @generated
	 */
	void setConstraintRange(RangeConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Realization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Realization</em>' containment reference.
	 * @see #setConstraintRealization(RealizationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintRealization()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.realization'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	RealizationConstraint getConstraintRealization();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRealization <em>Constraint Realization</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Realization</em>' containment reference.
	 * @see #getConstraintRealization()
	 * @generated
	 */
	void setConstraintRealization(RealizationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Stereotype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Stereotype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Stereotype</em>' containment reference.
	 * @see #setConstraintStereotype(StereotypeConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintStereotype()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.stereotype'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	StereotypeConstraint getConstraintStereotype();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintStereotype <em>Constraint Stereotype</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Stereotype</em>' containment reference.
	 * @see #getConstraintStereotype()
	 * @generated
	 */
	void setConstraintStereotype(StereotypeConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Synchronouscommunication</b></em>'
	 * containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Synchronouscommunication</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Synchronouscommunication</em>' containment
	 *         reference.
	 * @see #setConstraintSynchronouscommunication(SynchronousCommunicationConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintSynchronouscommunication()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.synchronouscommunication'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	SynchronousCommunicationConstraint getConstraintSynchronouscommunication();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintSynchronouscommunication <em>Constraint Synchronouscommunication</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Synchronouscommunication</em>' containment
	 *           reference.
	 * @see #getConstraintSynchronouscommunication()
	 * @generated
	 */
	void setConstraintSynchronouscommunication(SynchronousCommunicationConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Transmissiondelay</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Transmissiondelay</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Transmissiondelay</em>' containment reference.
	 * @see #setConstraintTransmissiondelay(TransmissionDelayConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintTransmissiondelay()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.transmissiondelay'
	 *        namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	TransmissionDelayConstraint getConstraintTransmissiondelay();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintTransmissiondelay <em>Constraint Transmissiondelay</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Transmissiondelay</em>' containment
	 *           reference.
	 * @see #getConstraintTransmissiondelay()
	 * @generated
	 */
	void setConstraintTransmissiondelay(TransmissionDelayConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Type</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Type</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Type</em>' containment reference.
	 * @see #setConstraintType(TypeConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintType()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.type' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	TypeConstraint getConstraintType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintType <em>Constraint Type</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Type</em>' containment reference.
	 * @see #getConstraintType()
	 * @generated
	 */
	void setConstraintType(TypeConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Update</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Update</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Update</em>' containment reference.
	 * @see #setConstraintUpdate(UpdateConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintUpdate()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.update' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */

	VersionConstraint getConstraintVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintVersion <em>Constraint Version</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Version</em>' containment reference.
	 * @see #getConstraintVersion()
	 * @generated
	 */
	void setConstraintVersion(VersionConstraint value);

	/**
	 * Returns the value of the '<em><b>Constraint Xor</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Xor</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Xor</em>' containment reference.
	 * @see #setConstraintXor(XorConstraint)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_ConstraintXor()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.xor' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	XorConstraint getConstraintXor();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintXor <em>Constraint Xor</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Constraint Xor</em>' containment reference.
	 * @see #getConstraintXor()
	 * @generated
	 */
	void setConstraintXor(XorConstraint value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(SingleValue)
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getConstraintRoot_Value()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	SingleValue getValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getValue <em>Value</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *           the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(SingleValue value);

} // ConstraintRoot
