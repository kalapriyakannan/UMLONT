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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConstraintFactoryImpl extends EFactoryImpl implements ConstraintFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintFactory init() {
		try {
			ConstraintFactory theConstraintFactory = (ConstraintFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.ibm.com/ccl/soa/deploy/core/constraint/1.0.0/"); //$NON-NLS-1$ 
			if (theConstraintFactory != null) {
				return theConstraintFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConstraintFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
		case ConstraintPackage.AND_CONSTRAINT:
			return createAndConstraint();
		case ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT:
			return createApplicationCommunicationConstraint();
		case ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT:
			return createApplicationCommunicationProtocolConstraint();
		case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT:
			return createAttributeCapacityConstraint();
		case ConstraintPackage.ATTRIBUTE_DEFINED_CONSTRAINT:
			return createAttributeDefinedConstraint();
		case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT:
			return createAttributePropagationConstraint();
		case ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT:
			return createBaseCommunicationConstraint();
		case ConstraintPackage.CAPACITY_CONSTRAINT:
			return createCapacityConstraint();
		case ConstraintPackage.COLLOCATION_CONSTRAINT:
			return createCollocationConstraint();
		case ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT:
			return createCommunicationBandwidthConstraint();
		case ConstraintPackage.COMMUNICATION_COST_CONSTRAINT:
			return createCommunicationCostConstraint();
		case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT:
			return createCommunicationPortConstraint();
		case ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT:
			return createCommunicationRedundancyConstraint();
		case ConstraintPackage.COMMUNICATION_TYPE_CONSTRAINT:
			return createCommunicationTypeConstraint();
		case ConstraintPackage.CONSTRAINT_ROOT:
			return createConstraintRoot();
		case ConstraintPackage.DEFERRED_HOSTING_CONSTRAINT:
			return createDeferredHostingConstraint();
		case ConstraintPackage.ENUMERATION_CONSTRAINT:
			return createEnumerationConstraint();
		case ConstraintPackage.EQUALS_CONSTRAINT:
			return createEqualsConstraint();
		case ConstraintPackage.EXCLUSION_CONSTRAINT:
			return createExclusionConstraint();
		case ConstraintPackage.GROUP_CARDINALITY_CONSTRAINT:
			return createGroupCardinalityConstraint();
		case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT:
			return createMemberCardinalityConstraint();
		case ConstraintPackage.NETWORK_COMMUNICATION_CONSTRAINT:
			return createNetworkCommunicationConstraint();
		case ConstraintPackage.NOT_CONSTRAINT:
			return createNotConstraint();
		case ConstraintPackage.OR_CONSTRAINT:
			return createOrConstraint();
		case ConstraintPackage.PALETTE_CONSTRAINT:
			return createPaletteConstraint();
		case ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT:
			return createProductIdentifierConstraint();
		case ConstraintPackage.RANGE_CONSTRAINT:
			return createRangeConstraint();
		case ConstraintPackage.REALIZATION_CONSTRAINT:
			return createRealizationConstraint();
		case ConstraintPackage.SINGLE_VALUE:
			return createSingleValue();
		case ConstraintPackage.STEREOTYPE_CONSTRAINT:
			return createStereotypeConstraint();
		case ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT:
			return createSynchronousCommunicationConstraint();
		case ConstraintPackage.TRANSMISSION_DELAY_CONSTRAINT:
			return createTransmissionDelayConstraint();
		case ConstraintPackage.TYPE_CONSTRAINT:
			return createTypeConstraint();
		case ConstraintPackage.VERSION_CONSTRAINT:
			return createVersionConstraint();
		case ConstraintPackage.XOR_CONSTRAINT:
			return createXorConstraint();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
		case ConstraintPackage.COLLOCATION_CONSTRAINT_TYPES:
			return createCollocationConstraintTypesFromString(eDataType, initialValue);
		case ConstraintPackage.COMMUNICATION_TYPE_TYPES:
			return createCommunicationTypeTypesFromString(eDataType, initialValue);
		case ConstraintPackage.COLLOCATION_CONSTRAINT_TYPES_OBJECT:
			return createCollocationConstraintTypesObjectFromString(eDataType, initialValue);
		case ConstraintPackage.COMMUNICATION_TYPE_TYPES_OBJECT:
			return createCommunicationTypeTypesObjectFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
		case ConstraintPackage.COLLOCATION_CONSTRAINT_TYPES:
			return convertCollocationConstraintTypesToString(eDataType, instanceValue);
		case ConstraintPackage.COMMUNICATION_TYPE_TYPES:
			return convertCommunicationTypeTypesToString(eDataType, instanceValue);
		case ConstraintPackage.COLLOCATION_CONSTRAINT_TYPES_OBJECT:
			return convertCollocationConstraintTypesObjectToString(eDataType, instanceValue);
		case ConstraintPackage.COMMUNICATION_TYPE_TYPES_OBJECT:
			return convertCommunicationTypeTypesObjectToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AndConstraint createAndConstraint() {
		AndConstraintImpl andConstraint = new AndConstraintImpl();
		return andConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ApplicationCommunicationConstraint createApplicationCommunicationConstraint() {
		ApplicationCommunicationConstraintImpl applicationCommunicationConstraint = new ApplicationCommunicationConstraintImpl();
		return applicationCommunicationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ApplicationCommunicationProtocolConstraint createApplicationCommunicationProtocolConstraint() {
		ApplicationCommunicationProtocolConstraintImpl applicationCommunicationProtocolConstraint = new ApplicationCommunicationProtocolConstraintImpl();
		return applicationCommunicationProtocolConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeCapacityConstraint createAttributeCapacityConstraint() {
		AttributeCapacityConstraintImpl attributeCapacityConstraint = new AttributeCapacityConstraintImpl();
		return attributeCapacityConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeDefinedConstraint createAttributeDefinedConstraint() {
		AttributeDefinedConstraintImpl attributeDefinedConstraint = new AttributeDefinedConstraintImpl();
		return attributeDefinedConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributePropagationConstraint createAttributePropagationConstraint() {
		AttributePropagationConstraintImpl attributePropagationConstraint = new AttributePropagationConstraintImpl();
		return attributePropagationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BaseCommunicationConstraint createBaseCommunicationConstraint() {
		BaseCommunicationConstraintImpl baseCommunicationConstraint = new BaseCommunicationConstraintImpl();
		return baseCommunicationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CapacityConstraint createCapacityConstraint() {
		CapacityConstraintImpl capacityConstraint = new CapacityConstraintImpl();
		return capacityConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollocationConstraint createCollocationConstraint() {
		CollocationConstraintImpl collocationConstraint = new CollocationConstraintImpl();
		return collocationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationBandwidthConstraint createCommunicationBandwidthConstraint() {
		CommunicationBandwidthConstraintImpl communicationBandwidthConstraint = new CommunicationBandwidthConstraintImpl();
		return communicationBandwidthConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationCostConstraint createCommunicationCostConstraint() {
		CommunicationCostConstraintImpl communicationCostConstraint = new CommunicationCostConstraintImpl();
		return communicationCostConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationPortConstraint createCommunicationPortConstraint() {
		CommunicationPortConstraintImpl communicationPortConstraint = new CommunicationPortConstraintImpl();
		return communicationPortConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationRedundancyConstraint createCommunicationRedundancyConstraint() {
		CommunicationRedundancyConstraintImpl communicationRedundancyConstraint = new CommunicationRedundancyConstraintImpl();
		return communicationRedundancyConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationTypeConstraint createCommunicationTypeConstraint() {
		CommunicationTypeConstraintImpl communicationTypeConstraint = new CommunicationTypeConstraintImpl();
		return communicationTypeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintRoot createConstraintRoot() {
		ConstraintRootImpl constraintRoot = new ConstraintRootImpl();
		return constraintRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeferredHostingConstraint createDeferredHostingConstraint() {
		DeferredHostingConstraintImpl deferredHostingConstraint = new DeferredHostingConstraintImpl();
		return deferredHostingConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumerationConstraint createEnumerationConstraint() {
		EnumerationConstraintImpl enumerationConstraint = new EnumerationConstraintImpl();
		return enumerationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EqualsConstraint createEqualsConstraint() {
		EqualsConstraintImpl equalsConstraint = new EqualsConstraintImpl();
		return equalsConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExclusionConstraint createExclusionConstraint() {
		ExclusionConstraintImpl exclusionConstraint = new ExclusionConstraintImpl();
		return exclusionConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GroupCardinalityConstraint createGroupCardinalityConstraint() {
		GroupCardinalityConstraintImpl groupCardinalityConstraint = new GroupCardinalityConstraintImpl();
		return groupCardinalityConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MemberCardinalityConstraint createMemberCardinalityConstraint() {
		MemberCardinalityConstraintImpl memberCardinalityConstraint = new MemberCardinalityConstraintImpl();
		return memberCardinalityConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NetworkCommunicationConstraint createNetworkCommunicationConstraint() {
		NetworkCommunicationConstraintImpl networkCommunicationConstraint = new NetworkCommunicationConstraintImpl();
		return networkCommunicationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotConstraint createNotConstraint() {
		NotConstraintImpl notConstraint = new NotConstraintImpl();
		return notConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OrConstraint createOrConstraint() {
		OrConstraintImpl orConstraint = new OrConstraintImpl();
		return orConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PaletteConstraint createPaletteConstraint() {
		PaletteConstraintImpl paletteConstraint = new PaletteConstraintImpl();
		return paletteConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProductIdentifierConstraint createProductIdentifierConstraint() {
		ProductIdentifierConstraintImpl productIdentifierConstraint = new ProductIdentifierConstraintImpl();
		return productIdentifierConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RangeConstraint createRangeConstraint() {
		RangeConstraintImpl rangeConstraint = new RangeConstraintImpl();
		return rangeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealizationConstraint createRealizationConstraint() {
		RealizationConstraintImpl realizationConstraint = new RealizationConstraintImpl();
		return realizationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SingleValue createSingleValue() {
		SingleValueImpl singleValue = new SingleValueImpl();
		return singleValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypeConstraint createStereotypeConstraint() {
		StereotypeConstraintImpl stereotypeConstraint = new StereotypeConstraintImpl();
		return stereotypeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SynchronousCommunicationConstraint createSynchronousCommunicationConstraint() {
		SynchronousCommunicationConstraintImpl synchronousCommunicationConstraint = new SynchronousCommunicationConstraintImpl();
		return synchronousCommunicationConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransmissionDelayConstraint createTransmissionDelayConstraint() {
		TransmissionDelayConstraintImpl transmissionDelayConstraint = new TransmissionDelayConstraintImpl();
		return transmissionDelayConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeConstraint createTypeConstraint() {
		TypeConstraintImpl typeConstraint = new TypeConstraintImpl();
		return typeConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VersionConstraint createVersionConstraint() {
		VersionConstraintImpl versionConstraint = new VersionConstraintImpl();
		return versionConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public XorConstraint createXorConstraint() {
		XorConstraintImpl xorConstraint = new XorConstraintImpl();
		return xorConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollocationConstraintTypes createCollocationConstraintTypesFromString(
			EDataType eDataType, String initialValue) {
		CollocationConstraintTypes result = CollocationConstraintTypes.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCollocationConstraintTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationTypeTypes createCommunicationTypeTypesFromString(EDataType eDataType,
			String initialValue) {
		CommunicationTypeTypes result = CommunicationTypeTypes.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCommunicationTypeTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollocationConstraintTypes createCollocationConstraintTypesObjectFromString(
			EDataType eDataType, String initialValue) {
		return createCollocationConstraintTypesFromString(
				ConstraintPackage.Literals.COLLOCATION_CONSTRAINT_TYPES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCollocationConstraintTypesObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertCollocationConstraintTypesToString(
				ConstraintPackage.Literals.COLLOCATION_CONSTRAINT_TYPES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationTypeTypes createCommunicationTypeTypesObjectFromString(EDataType eDataType,
			String initialValue) {
		return createCommunicationTypeTypesFromString(
				ConstraintPackage.Literals.COMMUNICATION_TYPE_TYPES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCommunicationTypeTypesObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertCommunicationTypeTypesToString(
				ConstraintPackage.Literals.COMMUNICATION_TYPE_TYPES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintPackage getConstraintPackage() {
		return (ConstraintPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	public static ConstraintPackage getPackage() {
		return ConstraintPackage.eINSTANCE;
	}

} //ConstraintFactoryImpl
