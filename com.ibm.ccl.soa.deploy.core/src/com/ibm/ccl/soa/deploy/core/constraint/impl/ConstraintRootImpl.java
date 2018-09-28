/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot;
import com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NotConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.RealizationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.XorConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Root</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getMixed <em>Mixed</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintAnd <em>Constraint And</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintApplicationcommunication <em>Constraint Applicationcommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintApplicationprotocol <em>Constraint Applicationprotocol</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintAttrdef <em>Constraint Attrdef</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintAttributePropagation <em>Constraint Attribute Propagation</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintBasecommunication <em>Constraint Basecommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCapacity <em>Constraint Capacity</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCapacityRestriction <em>Constraint Capacity Restriction</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCollocation <em>Constraint Collocation</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCommunicationbandwidth <em>Constraint Communicationbandwidth</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCommunicationcost <em>Constraint Communicationcost</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCommunicationport <em>Constraint Communicationport</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCommunicationredundancy <em>Constraint Communicationredundancy</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintCommunicationtype <em>Constraint Communicationtype</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintDeferredHosting <em>Constraint Deferred Hosting</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintEnumeration <em>Constraint Enumeration</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintEquals <em>Constraint Equals</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintExclusion <em>Constraint Exclusion</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintGroupCardinality <em>Constraint Group Cardinality</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintMemberCardinality <em>Constraint Member Cardinality</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintNetworkcommunication <em>Constraint Networkcommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintNot <em>Constraint Not</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintOr <em>Constraint Or</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintPalette <em>Constraint Palette</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintProductIdentifier <em>Constraint Product Identifier</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintRange <em>Constraint Range</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintRealization <em>Constraint Realization</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintStereotype <em>Constraint Stereotype</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintSynchronouscommunication <em>Constraint Synchronouscommunication</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintTransmissiondelay <em>Constraint Transmissiondelay</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintType <em>Constraint Type</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintUpdate <em>Constraint Update</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintVersion <em>Constraint Version</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getConstraintXor <em>Constraint Xor</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintRootImpl extends EObjectImpl implements ConstraintRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConstraintRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ConstraintPackage.Literals.CONSTRAINT_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, ConstraintPackage.CONSTRAINT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
					EStringToStringMapEntryImpl.class, this,
					ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AndConstraint getConstraintAnd() {
		return (AndConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_AND, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintAnd(AndConstraint newConstraintAnd,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_AND, newConstraintAnd, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintAnd(AndConstraint newConstraintAnd) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_AND, newConstraintAnd);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ApplicationCommunicationConstraint getConstraintApplicationcommunication() {
		return (ApplicationCommunicationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintApplicationcommunication(
			ApplicationCommunicationConstraint newConstraintApplicationcommunication,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION,
				newConstraintApplicationcommunication, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintApplicationcommunication(
			ApplicationCommunicationConstraint newConstraintApplicationcommunication) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION,
				newConstraintApplicationcommunication);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ApplicationCommunicationProtocolConstraint getConstraintApplicationprotocol() {
		return (ApplicationCommunicationProtocolConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintApplicationprotocol(
			ApplicationCommunicationProtocolConstraint newConstraintApplicationprotocol,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL,
				newConstraintApplicationprotocol, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintApplicationprotocol(
			ApplicationCommunicationProtocolConstraint newConstraintApplicationprotocol) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL,
				newConstraintApplicationprotocol);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeDefinedConstraint getConstraintAttrdef() {
		return (AttributeDefinedConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintAttrdef(
			AttributeDefinedConstraint newConstraintAttrdef, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF, newConstraintAttrdef,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintAttrdef(AttributeDefinedConstraint newConstraintAttrdef) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF, newConstraintAttrdef);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributePropagationConstraint getConstraintAttributePropagation() {
		return (AttributePropagationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintAttributePropagation(
			AttributePropagationConstraint newConstraintAttributePropagation, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION,
				newConstraintAttributePropagation, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintAttributePropagation(
			AttributePropagationConstraint newConstraintAttributePropagation) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION,
				newConstraintAttributePropagation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BaseCommunicationConstraint getConstraintBasecommunication() {
		return (BaseCommunicationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintBasecommunication(
			BaseCommunicationConstraint newConstraintBasecommunication, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
				newConstraintBasecommunication, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintBasecommunication(
			BaseCommunicationConstraint newConstraintBasecommunication) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION,
				newConstraintBasecommunication);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CapacityConstraint getConstraintCapacity() {
		return (CapacityConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCapacity(CapacityConstraint newConstraintCapacity,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY, newConstraintCapacity,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCapacity(CapacityConstraint newConstraintCapacity) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY, newConstraintCapacity);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeCapacityConstraint getConstraintCapacityRestriction() {
		return (AttributeCapacityConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCapacityRestriction(
			AttributeCapacityConstraint newConstraintCapacityRestriction, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION,
				newConstraintCapacityRestriction, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCapacityRestriction(
			AttributeCapacityConstraint newConstraintCapacityRestriction) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION,
				newConstraintCapacityRestriction);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollocationConstraint getConstraintCollocation() {
		return (CollocationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCollocation(
			CollocationConstraint newConstraintCollocation, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION,
				newConstraintCollocation, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCollocation(CollocationConstraint newConstraintCollocation) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION,
				newConstraintCollocation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationBandwidthConstraint getConstraintCommunicationbandwidth() {
		return (CommunicationBandwidthConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCommunicationbandwidth(
			CommunicationBandwidthConstraint newConstraintCommunicationbandwidth,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH,
				newConstraintCommunicationbandwidth, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCommunicationbandwidth(
			CommunicationBandwidthConstraint newConstraintCommunicationbandwidth) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH,
				newConstraintCommunicationbandwidth);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationCostConstraint getConstraintCommunicationcost() {
		return (CommunicationCostConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCommunicationcost(
			CommunicationCostConstraint newConstraintCommunicationcost, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST,
				newConstraintCommunicationcost, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCommunicationcost(
			CommunicationCostConstraint newConstraintCommunicationcost) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST,
				newConstraintCommunicationcost);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationPortConstraint getConstraintCommunicationport() {
		return (CommunicationPortConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCommunicationport(
			CommunicationPortConstraint newConstraintCommunicationport, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT,
				newConstraintCommunicationport, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCommunicationport(
			CommunicationPortConstraint newConstraintCommunicationport) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT,
				newConstraintCommunicationport);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationRedundancyConstraint getConstraintCommunicationredundancy() {
		return (CommunicationRedundancyConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCommunicationredundancy(
			CommunicationRedundancyConstraint newConstraintCommunicationredundancy,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY,
				newConstraintCommunicationredundancy, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCommunicationredundancy(
			CommunicationRedundancyConstraint newConstraintCommunicationredundancy) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY,
				newConstraintCommunicationredundancy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationTypeConstraint getConstraintCommunicationtype() {
		return (CommunicationTypeConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintCommunicationtype(
			CommunicationTypeConstraint newConstraintCommunicationtype, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE,
				newConstraintCommunicationtype, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintCommunicationtype(
			CommunicationTypeConstraint newConstraintCommunicationtype) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE,
				newConstraintCommunicationtype);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeferredHostingConstraint getConstraintDeferredHosting() {
		return (DeferredHostingConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintDeferredHosting(
			DeferredHostingConstraint newConstraintDeferredHosting, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING,
				newConstraintDeferredHosting, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintDeferredHosting(DeferredHostingConstraint newConstraintDeferredHosting) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING,
				newConstraintDeferredHosting);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumerationConstraint getConstraintEnumeration() {
		return (EnumerationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintEnumeration(
			EnumerationConstraint newConstraintEnumeration, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION,
				newConstraintEnumeration, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintEnumeration(EnumerationConstraint newConstraintEnumeration) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION,
				newConstraintEnumeration);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EqualsConstraint getConstraintEquals() {
		return (EqualsConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintEquals(EqualsConstraint newConstraintEquals,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS, newConstraintEquals,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintEquals(EqualsConstraint newConstraintEquals) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EQUALS, newConstraintEquals);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExclusionConstraint getConstraintExclusion() {
		return (ExclusionConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintExclusion(ExclusionConstraint newConstraintExclusion,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION,
				newConstraintExclusion, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintExclusion(ExclusionConstraint newConstraintExclusion) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION,
				newConstraintExclusion);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GroupCardinalityConstraint getConstraintGroupCardinality() {
		return (GroupCardinalityConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintGroupCardinality(
			GroupCardinalityConstraint newConstraintGroupCardinality, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY,
				newConstraintGroupCardinality, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintGroupCardinality(
			GroupCardinalityConstraint newConstraintGroupCardinality) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY,
				newConstraintGroupCardinality);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MemberCardinalityConstraint getConstraintMemberCardinality() {
		return (MemberCardinalityConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintMemberCardinality(
			MemberCardinalityConstraint newConstraintMemberCardinality, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY,
				newConstraintMemberCardinality, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintMemberCardinality(
			MemberCardinalityConstraint newConstraintMemberCardinality) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY,
				newConstraintMemberCardinality);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NetworkCommunicationConstraint getConstraintNetworkcommunication() {
		return (NetworkCommunicationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintNetworkcommunication(
			NetworkCommunicationConstraint newConstraintNetworkcommunication, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION,
				newConstraintNetworkcommunication, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintNetworkcommunication(
			NetworkCommunicationConstraint newConstraintNetworkcommunication) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION,
				newConstraintNetworkcommunication);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotConstraint getConstraintNot() {
		return (NotConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NOT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintNot(NotConstraint newConstraintNot,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NOT, newConstraintNot, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintNot(NotConstraint newConstraintNot) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_NOT, newConstraintNot);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OrConstraint getConstraintOr() {
		return (OrConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_OR, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintOr(OrConstraint newConstraintOr,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_OR, newConstraintOr, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintOr(OrConstraint newConstraintOr) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_OR, newConstraintOr);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PaletteConstraint getConstraintPalette() {
		return (PaletteConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintPalette(PaletteConstraint newConstraintPalette,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE, newConstraintPalette,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintPalette(PaletteConstraint newConstraintPalette) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PALETTE, newConstraintPalette);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProductIdentifierConstraint getConstraintProductIdentifier() {
		return (ProductIdentifierConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintProductIdentifier(
			ProductIdentifierConstraint newConstraintProductIdentifier, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER,
				newConstraintProductIdentifier, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintProductIdentifier(
			ProductIdentifierConstraint newConstraintProductIdentifier) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER,
				newConstraintProductIdentifier);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RangeConstraint getConstraintRange() {
		return (RangeConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_RANGE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintRange(RangeConstraint newConstraintRange,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_RANGE, newConstraintRange, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintRange(RangeConstraint newConstraintRange) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_RANGE, newConstraintRange);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealizationConstraint getConstraintRealization() {
		return (RealizationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintRealization(
			RealizationConstraint newConstraintRealization, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION,
				newConstraintRealization, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintRealization(RealizationConstraint newConstraintRealization) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION,
				newConstraintRealization);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypeConstraint getConstraintStereotype() {
		return (StereotypeConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintStereotype(
			StereotypeConstraint newConstraintStereotype, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE,
				newConstraintStereotype, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintStereotype(StereotypeConstraint newConstraintStereotype) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE,
				newConstraintStereotype);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SynchronousCommunicationConstraint getConstraintSynchronouscommunication() {
		return (SynchronousCommunicationConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintSynchronouscommunication(
			SynchronousCommunicationConstraint newConstraintSynchronouscommunication,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION,
				newConstraintSynchronouscommunication, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintSynchronouscommunication(
			SynchronousCommunicationConstraint newConstraintSynchronouscommunication) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION,
				newConstraintSynchronouscommunication);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransmissionDelayConstraint getConstraintTransmissiondelay() {
		return (TransmissionDelayConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintTransmissiondelay(
			TransmissionDelayConstraint newConstraintTransmissiondelay, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY,
				newConstraintTransmissiondelay, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintTransmissiondelay(
			TransmissionDelayConstraint newConstraintTransmissiondelay) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY,
				newConstraintTransmissiondelay);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeConstraint getConstraintType() {
		return (TypeConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintType(TypeConstraint newConstraintType,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE, newConstraintType, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintType(TypeConstraint newConstraintType) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_TYPE, newConstraintType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	public VersionConstraint getConstraintVersion() {
		return (VersionConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintVersion(VersionConstraint newConstraintVersion,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_VERSION, newConstraintVersion,
				msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintVersion(VersionConstraint newConstraintVersion) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_VERSION, newConstraintVersion);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public XorConstraint getConstraintXor() {
		return (XorConstraint) getMixed().get(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_XOR, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConstraintXor(XorConstraint newConstraintXor,
			NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_XOR, newConstraintXor, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConstraintXor(XorConstraint newConstraintXor) {
		((FeatureMap.Internal) getMixed()).set(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__CONSTRAINT_XOR, newConstraintXor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SingleValue getValue() {
		return (SingleValue) getMixed().get(ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetValue(SingleValue newValue, NotificationChain msgs) {
		return ((FeatureMap.Internal) getMixed()).basicAdd(
				ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE, newValue, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(SingleValue newValue) {
		((FeatureMap.Internal) getMixed()).set(ConstraintPackage.Literals.CONSTRAINT_ROOT__VALUE,
				newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case ConstraintPackage.CONSTRAINT_ROOT__MIXED:
			return ((InternalEList) getMixed()).basicRemove(otherEnd, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP:
			return ((InternalEList) getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION:
			return ((InternalEList) getXSISchemaLocation()).basicRemove(otherEnd, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_AND:
			return basicSetConstraintAnd(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION:
			return basicSetConstraintApplicationcommunication(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL:
			return basicSetConstraintApplicationprotocol(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF:
			return basicSetConstraintAttrdef(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION:
			return basicSetConstraintAttributePropagation(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION:
			return basicSetConstraintBasecommunication(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY:
			return basicSetConstraintCapacity(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION:
			return basicSetConstraintCapacityRestriction(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION:
			return basicSetConstraintCollocation(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH:
			return basicSetConstraintCommunicationbandwidth(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST:
			return basicSetConstraintCommunicationcost(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT:
			return basicSetConstraintCommunicationport(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY:
			return basicSetConstraintCommunicationredundancy(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE:
			return basicSetConstraintCommunicationtype(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING:
			return basicSetConstraintDeferredHosting(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION:
			return basicSetConstraintEnumeration(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EQUALS:
			return basicSetConstraintEquals(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION:
			return basicSetConstraintExclusion(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY:
			return basicSetConstraintGroupCardinality(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY:
			return basicSetConstraintMemberCardinality(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION:
			return basicSetConstraintNetworkcommunication(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NOT:
			return basicSetConstraintNot(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_OR:
			return basicSetConstraintOr(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PALETTE:
			return basicSetConstraintPalette(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER:
			return basicSetConstraintProductIdentifier(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_RANGE:
			return basicSetConstraintRange(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION:
			return basicSetConstraintRealization(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE:
			return basicSetConstraintStereotype(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION:
			return basicSetConstraintSynchronouscommunication(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY:
			return basicSetConstraintTransmissiondelay(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TYPE:
			return basicSetConstraintType(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_VERSION:
			return basicSetConstraintVersion(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_XOR:
			return basicSetConstraintXor(null, msgs);
		case ConstraintPackage.CONSTRAINT_ROOT__VALUE:
			return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case ConstraintPackage.CONSTRAINT_ROOT__MIXED:
			if (coreType) {
				return getMixed();
			}
			return ((FeatureMap.Internal) getMixed()).getWrapper();
		case ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP:
			if (coreType) {
				return getXMLNSPrefixMap();
			} else {
				return getXMLNSPrefixMap().map();
			}
		case ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION:
			if (coreType) {
				return getXSISchemaLocation();
			} else {
				return getXSISchemaLocation().map();
			}
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_AND:
			return getConstraintAnd();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION:
			return getConstraintApplicationcommunication();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL:
			return getConstraintApplicationprotocol();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF:
			return getConstraintAttrdef();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION:
			return getConstraintAttributePropagation();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION:
			return getConstraintBasecommunication();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY:
			return getConstraintCapacity();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION:
			return getConstraintCapacityRestriction();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION:
			return getConstraintCollocation();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH:
			return getConstraintCommunicationbandwidth();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST:
			return getConstraintCommunicationcost();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT:
			return getConstraintCommunicationport();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY:
			return getConstraintCommunicationredundancy();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE:
			return getConstraintCommunicationtype();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING:
			return getConstraintDeferredHosting();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION:
			return getConstraintEnumeration();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EQUALS:
			return getConstraintEquals();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION:
			return getConstraintExclusion();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY:
			return getConstraintGroupCardinality();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY:
			return getConstraintMemberCardinality();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION:
			return getConstraintNetworkcommunication();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NOT:
			return getConstraintNot();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_OR:
			return getConstraintOr();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PALETTE:
			return getConstraintPalette();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER:
			return getConstraintProductIdentifier();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_RANGE:
			return getConstraintRange();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION:
			return getConstraintRealization();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE:
			return getConstraintStereotype();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION:
			return getConstraintSynchronouscommunication();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY:
			return getConstraintTransmissiondelay();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TYPE:
			return getConstraintType();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_VERSION:
			return getConstraintVersion();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_XOR:
			return getConstraintXor();
		case ConstraintPackage.CONSTRAINT_ROOT__VALUE:
			return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case ConstraintPackage.CONSTRAINT_ROOT__MIXED:
			((FeatureMap.Internal) getMixed()).set(newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP:
			((EStructuralFeature.Setting) getXMLNSPrefixMap()).set(newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION:
			((EStructuralFeature.Setting) getXSISchemaLocation()).set(newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_AND:
			setConstraintAnd((AndConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION:
			setConstraintApplicationcommunication((ApplicationCommunicationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL:
			setConstraintApplicationprotocol((ApplicationCommunicationProtocolConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF:
			setConstraintAttrdef((AttributeDefinedConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION:
			setConstraintAttributePropagation((AttributePropagationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION:
			setConstraintBasecommunication((BaseCommunicationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY:
			setConstraintCapacity((CapacityConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION:
			setConstraintCapacityRestriction((AttributeCapacityConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION:
			setConstraintCollocation((CollocationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH:
			setConstraintCommunicationbandwidth((CommunicationBandwidthConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST:
			setConstraintCommunicationcost((CommunicationCostConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT:
			setConstraintCommunicationport((CommunicationPortConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY:
			setConstraintCommunicationredundancy((CommunicationRedundancyConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE:
			setConstraintCommunicationtype((CommunicationTypeConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING:
			setConstraintDeferredHosting((DeferredHostingConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION:
			setConstraintEnumeration((EnumerationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EQUALS:
			setConstraintEquals((EqualsConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION:
			setConstraintExclusion((ExclusionConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY:
			setConstraintGroupCardinality((GroupCardinalityConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY:
			setConstraintMemberCardinality((MemberCardinalityConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION:
			setConstraintNetworkcommunication((NetworkCommunicationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NOT:
			setConstraintNot((NotConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_OR:
			setConstraintOr((OrConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PALETTE:
			setConstraintPalette((PaletteConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER:
			setConstraintProductIdentifier((ProductIdentifierConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_RANGE:
			setConstraintRange((RangeConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION:
			setConstraintRealization((RealizationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE:
			setConstraintStereotype((StereotypeConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION:
			setConstraintSynchronouscommunication((SynchronousCommunicationConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY:
			setConstraintTransmissiondelay((TransmissionDelayConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TYPE:
			setConstraintType((TypeConstraint) newValue);
			return;

		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_VERSION:
			setConstraintVersion((VersionConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_XOR:
			setConstraintXor((XorConstraint) newValue);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__VALUE:
			setValue((SingleValue) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case ConstraintPackage.CONSTRAINT_ROOT__MIXED:
			getMixed().clear();
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP:
			getXMLNSPrefixMap().clear();
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION:
			getXSISchemaLocation().clear();
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_AND:
			setConstraintAnd((AndConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION:
			setConstraintApplicationcommunication((ApplicationCommunicationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL:
			setConstraintApplicationprotocol((ApplicationCommunicationProtocolConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF:
			setConstraintAttrdef((AttributeDefinedConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION:
			setConstraintAttributePropagation((AttributePropagationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION:
			setConstraintBasecommunication((BaseCommunicationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY:
			setConstraintCapacity((CapacityConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION:
			setConstraintCapacityRestriction((AttributeCapacityConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION:
			setConstraintCollocation((CollocationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH:
			setConstraintCommunicationbandwidth((CommunicationBandwidthConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST:
			setConstraintCommunicationcost((CommunicationCostConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT:
			setConstraintCommunicationport((CommunicationPortConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY:
			setConstraintCommunicationredundancy((CommunicationRedundancyConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE:
			setConstraintCommunicationtype((CommunicationTypeConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING:
			setConstraintDeferredHosting((DeferredHostingConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION:
			setConstraintEnumeration((EnumerationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EQUALS:
			setConstraintEquals((EqualsConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION:
			setConstraintExclusion((ExclusionConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY:
			setConstraintGroupCardinality((GroupCardinalityConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY:
			setConstraintMemberCardinality((MemberCardinalityConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION:
			setConstraintNetworkcommunication((NetworkCommunicationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NOT:
			setConstraintNot((NotConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_OR:
			setConstraintOr((OrConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PALETTE:
			setConstraintPalette((PaletteConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER:
			setConstraintProductIdentifier((ProductIdentifierConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_RANGE:
			setConstraintRange((RangeConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION:
			setConstraintRealization((RealizationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE:
			setConstraintStereotype((StereotypeConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION:
			setConstraintSynchronouscommunication((SynchronousCommunicationConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY:
			setConstraintTransmissiondelay((TransmissionDelayConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TYPE:
			setConstraintType((TypeConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_VERSION:
			setConstraintVersion((VersionConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_XOR:
			setConstraintXor((XorConstraint) null);
			return;
		case ConstraintPackage.CONSTRAINT_ROOT__VALUE:
			setValue((SingleValue) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case ConstraintPackage.CONSTRAINT_ROOT__MIXED:
			return mixed != null && !mixed.isEmpty();
		case ConstraintPackage.CONSTRAINT_ROOT__XMLNS_PREFIX_MAP:
			return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
		case ConstraintPackage.CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION:
			return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_AND:
			return getConstraintAnd() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION:
			return getConstraintApplicationcommunication() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL:
			return getConstraintApplicationprotocol() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF:
			return getConstraintAttrdef() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION:
			return getConstraintAttributePropagation() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION:
			return getConstraintBasecommunication() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY:
			return getConstraintCapacity() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION:
			return getConstraintCapacityRestriction() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION:
			return getConstraintCollocation() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH:
			return getConstraintCommunicationbandwidth() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST:
			return getConstraintCommunicationcost() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT:
			return getConstraintCommunicationport() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY:
			return getConstraintCommunicationredundancy() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE:
			return getConstraintCommunicationtype() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING:
			return getConstraintDeferredHosting() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION:
			return getConstraintEnumeration() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EQUALS:
			return getConstraintEquals() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION:
			return getConstraintExclusion() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY:
			return getConstraintGroupCardinality() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY:
			return getConstraintMemberCardinality() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION:
			return getConstraintNetworkcommunication() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_NOT:
			return getConstraintNot() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_OR:
			return getConstraintOr() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PALETTE:
			return getConstraintPalette() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER:
			return getConstraintProductIdentifier() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_RANGE:
			return getConstraintRange() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_REALIZATION:
			return getConstraintRealization() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE:
			return getConstraintStereotype() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION:
			return getConstraintSynchronouscommunication() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY:
			return getConstraintTransmissiondelay() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_TYPE:
			return getConstraintType() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_VERSION:
			return getConstraintVersion() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__CONSTRAINT_XOR:
			return getConstraintXor() != null;
		case ConstraintPackage.CONSTRAINT_ROOT__VALUE:
			return getValue() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //ConstraintRootImpl
