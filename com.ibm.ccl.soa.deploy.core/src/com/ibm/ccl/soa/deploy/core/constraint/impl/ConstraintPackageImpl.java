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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.constraint.AndConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator;
import com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint;
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
import com.ibm.ccl.soa.deploy.core.constraint.StructuralConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.XorConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConstraintPackageImpl extends EPackageImpl implements ConstraintPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass andConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass applicationCommunicationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass applicationCommunicationProtocolConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributeCapacityConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributeDefinedConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributePropagationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributeValueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass baseCommunicationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass booleanOperatorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass capacityConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collocationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationBandwidthConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationChildConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationCostConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationPortConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationRedundancyConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationTypeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constraintRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deferredHostingConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumerationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass equalsConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass exclusionConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass groupCardinalityConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass memberCardinalityConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass networkCommunicationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass notConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass orConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass paletteConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass productIdentifierConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass rangeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass realizationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass singleValueEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass structuralConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass synchronousCommunicationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass transmissionDelayConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass typeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass updateConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass versionConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass xorConstraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum collocationConstraintTypesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum communicationTypeTypesEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType collocationConstraintTypesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType communicationTypeTypesObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method
	 * {@link #init init()}, which also performs initialization of the package, or returns the
	 * registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConstraintPackageImpl() {
		super(eNS_URI, ConstraintFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends. Simple dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else. This method drives initialization for
	 * interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by
	 * their URI values are first created and registered. The packages are then initialized in two
	 * steps: meta-model objects for all of the packages are created before any are initialized,
	 * since one package's meta-model objects may refer to those of another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConstraintPackage init() {
		if (isInited) {
			return (ConstraintPackage) EPackage.Registry.INSTANCE
					.getEPackage(ConstraintPackage.eNS_URI);
		}

		// Obtain or create and register package
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) : new ConstraintPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theConstraintPackage.createPackageContents();

		// Initialize created meta-data
		theConstraintPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConstraintPackage.freeze();

		return theConstraintPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAndConstraint() {
		return andConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getApplicationCommunicationConstraint() {
		return applicationCommunicationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getApplicationCommunicationProtocolConstraint() {
		return applicationCommunicationProtocolConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getApplicationCommunicationProtocolConstraint_ApplicationLayerProtocol() {
		return (EAttribute) applicationCommunicationProtocolConstraintEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttributeCapacityConstraint() {
		return attributeCapacityConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributeCapacityConstraint_Exclusive() {
		return (EAttribute) attributeCapacityConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributeCapacityConstraint_Value() {
		return (EAttribute) attributeCapacityConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttributeDefinedConstraint() {
		return attributeDefinedConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttributePropagationConstraint() {
		return attributePropagationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributePropagationConstraint_RespectLinkDirection() {
		return (EAttribute) attributePropagationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributePropagationConstraint_SourceAttributeName() {
		return (EAttribute) attributePropagationConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributePropagationConstraint_SourceObjectURI() {
		return (EAttribute) attributePropagationConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributePropagationConstraint_TargetAttributeName() {
		return (EAttribute) attributePropagationConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributePropagationConstraint_TargetObjectURI() {
		return (EAttribute) attributePropagationConstraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttributeValueConstraint() {
		return attributeValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAttributeValueConstraint_AttributeName() {
		return (EAttribute) attributeValueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBaseCommunicationConstraint() {
		return baseCommunicationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBaseCommunicationConstraint_RespectLinkDirection() {
		return (EAttribute) baseCommunicationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBooleanOperator() {
		return booleanOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCapacityConstraint() {
		return capacityConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollocationConstraint() {
		return collocationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCollocationConstraint_CapabilityType() {
		return (EAttribute) collocationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCollocationConstraint_Type() {
		return (EAttribute) collocationConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationBandwidthConstraint() {
		return communicationBandwidthConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommunicationBandwidthConstraint_Bandwidth() {
		return (EAttribute) communicationBandwidthConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationChildConstraint() {
		return communicationChildConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationCostConstraint() {
		return communicationCostConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommunicationCostConstraint_Cost() {
		return (EAttribute) communicationCostConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationPortConstraint() {
		return communicationPortConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommunicationPortConstraint_IsTarget() {
		return (EAttribute) communicationPortConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommunicationPortConstraint_Port() {
		return (EAttribute) communicationPortConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationRedundancyConstraint() {
		return communicationRedundancyConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommunicationRedundancyConstraint_Redundancy() {
		return (EAttribute) communicationRedundancyConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationTypeConstraint() {
		return communicationTypeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCommunicationTypeConstraint_Type() {
		return (EAttribute) communicationTypeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstraintRoot() {
		return constraintRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConstraintRoot_Mixed() {
		return (EAttribute) constraintRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_XMLNSPrefixMap() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_XSISchemaLocation() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintAnd() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintApplicationcommunication() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintApplicationprotocol() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintAttrdef() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintAttributePropagation() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintBasecommunication() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCapacity() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCapacityRestriction() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCollocation() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCommunicationbandwidth() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCommunicationcost() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCommunicationport() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCommunicationredundancy() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintCommunicationtype() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintDeferredHosting() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintEnumeration() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintEquals() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintExclusion() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintGroupCardinality() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintMemberCardinality() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintNetworkcommunication() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintNot() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintOr() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintPalette() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintProductIdentifier() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintRange() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintRealization() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintStereotype() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintSynchronouscommunication() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintTransmissiondelay() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintType() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintUpdate() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintVersion() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_ConstraintXor() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintRoot_Value() {
		return (EReference) constraintRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeferredHostingConstraint() {
		return deferredHostingConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnumerationConstraint() {
		return enumerationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnumerationConstraint_Values() {
		return (EReference) enumerationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEqualsConstraint() {
		return equalsConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEqualsConstraint_Value() {
		return (EAttribute) equalsConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExclusionConstraint() {
		return exclusionConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExclusionConstraint_Values() {
		return (EReference) exclusionConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGroupCardinalityConstraint() {
		return groupCardinalityConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGroupCardinalityConstraint_MaxValue() {
		return (EAttribute) groupCardinalityConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGroupCardinalityConstraint_MinValue() {
		return (EAttribute) groupCardinalityConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMemberCardinalityConstraint() {
		return memberCardinalityConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMemberCardinalityConstraint_MaxValue() {
		return (EAttribute) memberCardinalityConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMemberCardinalityConstraint_MinValue() {
		return (EAttribute) memberCardinalityConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNetworkCommunicationConstraint() {
		return networkCommunicationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNotConstraint() {
		return notConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOrConstraint() {
		return orConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPaletteConstraint() {
		return paletteConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPaletteConstraint_ResourceTypeId() {
		return (EAttribute) paletteConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProductIdentifierConstraint() {
		return productIdentifierConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProductIdentifierConstraint_ProductIdentifier() {
		return (EAttribute) productIdentifierConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRangeConstraint() {
		return rangeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRangeConstraint_MaxValue() {
		return (EAttribute) rangeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRangeConstraint_MaxValueInclusive() {
		return (EAttribute) rangeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRangeConstraint_MinValue() {
		return (EAttribute) rangeConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRangeConstraint_MinValueInclusive() {
		return (EAttribute) rangeConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRealizationConstraint() {
		return realizationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSingleValue() {
		return singleValueEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSingleValue_Description() {
		return (EAttribute) singleValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSingleValue_Value() {
		return (EAttribute) singleValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypeConstraint() {
		return stereotypeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypeConstraint_Includes() {
		return (EAttribute) stereotypeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStructuralConstraint() {
		return structuralConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSynchronousCommunicationConstraint() {
		return synchronousCommunicationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSynchronousCommunicationConstraint_Synchronous() {
		return (EAttribute) synchronousCommunicationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTransmissionDelayConstraint() {
		return transmissionDelayConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTransmissionDelayConstraint_Delay() {
		return (EAttribute) transmissionDelayConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTypeConstraint() {
		return typeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTypeConstraint_DmoType() {
		return (EAttribute) typeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUpdateConstraint() {
		return updateConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getVersionConstraint() {
		return versionConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVersionConstraint_Value() {
		return (EAttribute) versionConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getXorConstraint() {
		return xorConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCollocationConstraintTypes() {
		return collocationConstraintTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCommunicationTypeTypes() {
		return communicationTypeTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getCollocationConstraintTypesObject() {
		return collocationConstraintTypesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getCommunicationTypeTypesObject() {
		return communicationTypeTypesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintFactory getConstraintFactory() {
		return (ConstraintFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		andConstraintEClass = createEClass(AND_CONSTRAINT);

		applicationCommunicationConstraintEClass = createEClass(APPLICATION_COMMUNICATION_CONSTRAINT);

		applicationCommunicationProtocolConstraintEClass = createEClass(APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT);
		createEAttribute(applicationCommunicationProtocolConstraintEClass,
				APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL);

		attributeCapacityConstraintEClass = createEClass(ATTRIBUTE_CAPACITY_CONSTRAINT);
		createEAttribute(attributeCapacityConstraintEClass, ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE);
		createEAttribute(attributeCapacityConstraintEClass, ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE);

		attributeDefinedConstraintEClass = createEClass(ATTRIBUTE_DEFINED_CONSTRAINT);

		attributePropagationConstraintEClass = createEClass(ATTRIBUTE_PROPAGATION_CONSTRAINT);
		createEAttribute(attributePropagationConstraintEClass,
				ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION);
		createEAttribute(attributePropagationConstraintEClass,
				ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME);
		createEAttribute(attributePropagationConstraintEClass,
				ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI);
		createEAttribute(attributePropagationConstraintEClass,
				ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME);
		createEAttribute(attributePropagationConstraintEClass,
				ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI);

		attributeValueConstraintEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT);
		createEAttribute(attributeValueConstraintEClass, ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME);

		baseCommunicationConstraintEClass = createEClass(BASE_COMMUNICATION_CONSTRAINT);
		createEAttribute(baseCommunicationConstraintEClass,
				BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION);

		booleanOperatorEClass = createEClass(BOOLEAN_OPERATOR);

		capacityConstraintEClass = createEClass(CAPACITY_CONSTRAINT);

		collocationConstraintEClass = createEClass(COLLOCATION_CONSTRAINT);
		createEAttribute(collocationConstraintEClass, COLLOCATION_CONSTRAINT__CAPABILITY_TYPE);
		createEAttribute(collocationConstraintEClass, COLLOCATION_CONSTRAINT__TYPE);

		communicationBandwidthConstraintEClass = createEClass(COMMUNICATION_BANDWIDTH_CONSTRAINT);
		createEAttribute(communicationBandwidthConstraintEClass,
				COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH);

		communicationChildConstraintEClass = createEClass(COMMUNICATION_CHILD_CONSTRAINT);

		communicationCostConstraintEClass = createEClass(COMMUNICATION_COST_CONSTRAINT);
		createEAttribute(communicationCostConstraintEClass, COMMUNICATION_COST_CONSTRAINT__COST);

		communicationPortConstraintEClass = createEClass(COMMUNICATION_PORT_CONSTRAINT);
		createEAttribute(communicationPortConstraintEClass, COMMUNICATION_PORT_CONSTRAINT__IS_TARGET);
		createEAttribute(communicationPortConstraintEClass, COMMUNICATION_PORT_CONSTRAINT__PORT);

		communicationRedundancyConstraintEClass = createEClass(COMMUNICATION_REDUNDANCY_CONSTRAINT);
		createEAttribute(communicationRedundancyConstraintEClass,
				COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY);

		communicationTypeConstraintEClass = createEClass(COMMUNICATION_TYPE_CONSTRAINT);
		createEAttribute(communicationTypeConstraintEClass, COMMUNICATION_TYPE_CONSTRAINT__TYPE);

		constraintRootEClass = createEClass(CONSTRAINT_ROOT);
		createEAttribute(constraintRootEClass, CONSTRAINT_ROOT__MIXED);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_AND);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_CAPACITY);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_EQUALS);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_NOT);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_OR);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_PALETTE);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_RANGE);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_REALIZATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_TYPE);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_UPDATE);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_VERSION);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__CONSTRAINT_XOR);
		createEReference(constraintRootEClass, CONSTRAINT_ROOT__VALUE);

		deferredHostingConstraintEClass = createEClass(DEFERRED_HOSTING_CONSTRAINT);

		enumerationConstraintEClass = createEClass(ENUMERATION_CONSTRAINT);
		createEReference(enumerationConstraintEClass, ENUMERATION_CONSTRAINT__VALUES);

		equalsConstraintEClass = createEClass(EQUALS_CONSTRAINT);
		createEAttribute(equalsConstraintEClass, EQUALS_CONSTRAINT__VALUE);

		exclusionConstraintEClass = createEClass(EXCLUSION_CONSTRAINT);
		createEReference(exclusionConstraintEClass, EXCLUSION_CONSTRAINT__VALUES);

		groupCardinalityConstraintEClass = createEClass(GROUP_CARDINALITY_CONSTRAINT);
		createEAttribute(groupCardinalityConstraintEClass, GROUP_CARDINALITY_CONSTRAINT__MAX_VALUE);
		createEAttribute(groupCardinalityConstraintEClass, GROUP_CARDINALITY_CONSTRAINT__MIN_VALUE);

		memberCardinalityConstraintEClass = createEClass(MEMBER_CARDINALITY_CONSTRAINT);
		createEAttribute(memberCardinalityConstraintEClass, MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE);
		createEAttribute(memberCardinalityConstraintEClass, MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE);

		networkCommunicationConstraintEClass = createEClass(NETWORK_COMMUNICATION_CONSTRAINT);

		notConstraintEClass = createEClass(NOT_CONSTRAINT);

		orConstraintEClass = createEClass(OR_CONSTRAINT);

		paletteConstraintEClass = createEClass(PALETTE_CONSTRAINT);
		createEAttribute(paletteConstraintEClass, PALETTE_CONSTRAINT__RESOURCE_TYPE_ID);

		productIdentifierConstraintEClass = createEClass(PRODUCT_IDENTIFIER_CONSTRAINT);
		createEAttribute(productIdentifierConstraintEClass,
				PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER);

		rangeConstraintEClass = createEClass(RANGE_CONSTRAINT);
		createEAttribute(rangeConstraintEClass, RANGE_CONSTRAINT__MAX_VALUE);
		createEAttribute(rangeConstraintEClass, RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE);
		createEAttribute(rangeConstraintEClass, RANGE_CONSTRAINT__MIN_VALUE);
		createEAttribute(rangeConstraintEClass, RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE);

		realizationConstraintEClass = createEClass(REALIZATION_CONSTRAINT);

		singleValueEClass = createEClass(SINGLE_VALUE);
		createEAttribute(singleValueEClass, SINGLE_VALUE__DESCRIPTION);
		createEAttribute(singleValueEClass, SINGLE_VALUE__VALUE);

		stereotypeConstraintEClass = createEClass(STEREOTYPE_CONSTRAINT);
		createEAttribute(stereotypeConstraintEClass, STEREOTYPE_CONSTRAINT__INCLUDES);

		structuralConstraintEClass = createEClass(STRUCTURAL_CONSTRAINT);

		synchronousCommunicationConstraintEClass = createEClass(SYNCHRONOUS_COMMUNICATION_CONSTRAINT);
		createEAttribute(synchronousCommunicationConstraintEClass,
				SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS);

		transmissionDelayConstraintEClass = createEClass(TRANSMISSION_DELAY_CONSTRAINT);
		createEAttribute(transmissionDelayConstraintEClass, TRANSMISSION_DELAY_CONSTRAINT__DELAY);

		typeConstraintEClass = createEClass(TYPE_CONSTRAINT);
		createEAttribute(typeConstraintEClass, TYPE_CONSTRAINT__DMO_TYPE);

		updateConstraintEClass = createEClass(UPDATE_CONSTRAINT);

		versionConstraintEClass = createEClass(VERSION_CONSTRAINT);
		createEAttribute(versionConstraintEClass, VERSION_CONSTRAINT__VALUE);

		xorConstraintEClass = createEClass(XOR_CONSTRAINT);

		// Create enums
		collocationConstraintTypesEEnum = createEEnum(COLLOCATION_CONSTRAINT_TYPES);
		communicationTypeTypesEEnum = createEEnum(COMMUNICATION_TYPE_TYPES);

		// Create data types
		collocationConstraintTypesObjectEDataType = createEDataType(COLLOCATION_CONSTRAINT_TYPES_OBJECT);
		communicationTypeTypesObjectEDataType = createEDataType(COMMUNICATION_TYPE_TYPES_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI);

		// Add supertypes to classes
		andConstraintEClass.getESuperTypes().add(this.getBooleanOperator());
		applicationCommunicationConstraintEClass.getESuperTypes().add(
				this.getBaseCommunicationConstraint());
		applicationCommunicationProtocolConstraintEClass.getESuperTypes().add(
				this.getCommunicationChildConstraint());
		attributeCapacityConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		attributeDefinedConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		attributePropagationConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		attributeValueConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		baseCommunicationConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		booleanOperatorEClass.getESuperTypes().add(theCorePackage.getConstraint());
		capacityConstraintEClass.getESuperTypes().add(this.getTypeConstraint());
		collocationConstraintEClass.getESuperTypes().add(this.getStructuralConstraint());
		communicationBandwidthConstraintEClass.getESuperTypes().add(
				this.getCommunicationChildConstraint());
		communicationChildConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		communicationCostConstraintEClass.getESuperTypes()
				.add(this.getCommunicationChildConstraint());
		communicationPortConstraintEClass.getESuperTypes()
				.add(this.getCommunicationChildConstraint());
		communicationRedundancyConstraintEClass.getESuperTypes().add(
				this.getCommunicationChildConstraint());
		communicationTypeConstraintEClass.getESuperTypes()
				.add(this.getCommunicationChildConstraint());
		deferredHostingConstraintEClass.getESuperTypes().add(this.getStructuralConstraint());
		enumerationConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		equalsConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		exclusionConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		groupCardinalityConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		memberCardinalityConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		networkCommunicationConstraintEClass.getESuperTypes().add(
				this.getBaseCommunicationConstraint());
		notConstraintEClass.getESuperTypes().add(this.getBooleanOperator());
		orConstraintEClass.getESuperTypes().add(this.getBooleanOperator());
		paletteConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		productIdentifierConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		rangeConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		realizationConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		stereotypeConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		structuralConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		synchronousCommunicationConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		transmissionDelayConstraintEClass.getESuperTypes()
				.add(this.getCommunicationChildConstraint());
		typeConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		updateConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		versionConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		xorConstraintEClass.getESuperTypes().add(this.getBooleanOperator());

		// Initialize classes and features; add operations and parameters
		initEClass(andConstraintEClass, AndConstraint.class,
				"AndConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				applicationCommunicationConstraintEClass,
				ApplicationCommunicationConstraint.class,
				"ApplicationCommunicationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				applicationCommunicationProtocolConstraintEClass,
				ApplicationCommunicationProtocolConstraint.class,
				"ApplicationCommunicationProtocolConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getApplicationCommunicationProtocolConstraint_ApplicationLayerProtocol(),
				theXMLTypePackage.getString(),
				"applicationLayerProtocol", null, 0, 1, ApplicationCommunicationProtocolConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeCapacityConstraintEClass, AttributeCapacityConstraint.class,
				"AttributeCapacityConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAttributeCapacityConstraint_Exclusive(),
				theXMLTypePackage.getBoolean(),
				"exclusive", null, 0, 1, AttributeCapacityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAttributeCapacityConstraint_Value(),
				theXMLTypePackage.getString(),
				"value", null, 1, 1, AttributeCapacityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeDefinedConstraintEClass, AttributeDefinedConstraint.class,
				"AttributeDefinedConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				attributePropagationConstraintEClass,
				AttributePropagationConstraint.class,
				"AttributePropagationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAttributePropagationConstraint_RespectLinkDirection(),
				theXMLTypePackage.getBoolean(),
				"respectLinkDirection", "true", 0, 1, AttributePropagationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getAttributePropagationConstraint_SourceAttributeName(),
				theXMLTypePackage.getString(),
				"sourceAttributeName", null, 1, 1, AttributePropagationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAttributePropagationConstraint_SourceObjectURI(),
				theXMLTypePackage.getAnyURI(),
				"sourceObjectURI", null, 0, 1, AttributePropagationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAttributePropagationConstraint_TargetAttributeName(),
				theXMLTypePackage.getString(),
				"targetAttributeName", null, 1, 1, AttributePropagationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAttributePropagationConstraint_TargetObjectURI(),
				theXMLTypePackage.getAnyURI(),
				"targetObjectURI", null, 0, 1, AttributePropagationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeValueConstraintEClass, AttributeValueConstraint.class,
				"AttributeValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAttributeValueConstraint_AttributeName(),
				theXMLTypePackage.getString(),
				"attributeName", null, 1, 1, AttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(baseCommunicationConstraintEClass, BaseCommunicationConstraint.class,
				"BaseCommunicationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getBaseCommunicationConstraint_RespectLinkDirection(),
				theXMLTypePackage.getBoolean(),
				"respectLinkDirection", "true", 0, 1, BaseCommunicationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(booleanOperatorEClass, BooleanOperator.class,
				"BooleanOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(capacityConstraintEClass, CapacityConstraint.class,
				"CapacityConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(collocationConstraintEClass, CollocationConstraint.class,
				"CollocationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCollocationConstraint_CapabilityType(),
				theXMLTypePackage.getQName(),
				"capabilityType", null, 0, 1, CollocationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCollocationConstraint_Type(),
				this.getCollocationConstraintTypes(),
				"type", "collocation", 1, 1, CollocationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				communicationBandwidthConstraintEClass,
				CommunicationBandwidthConstraint.class,
				"CommunicationBandwidthConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCommunicationBandwidthConstraint_Bandwidth(),
				theXMLTypePackage.getInt(),
				"bandwidth", null, 1, 1, CommunicationBandwidthConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(communicationChildConstraintEClass, CommunicationChildConstraint.class,
				"CommunicationChildConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(communicationCostConstraintEClass, CommunicationCostConstraint.class,
				"CommunicationCostConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCommunicationCostConstraint_Cost(),
				theXMLTypePackage.getInt(),
				"cost", null, 1, 1, CommunicationCostConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(communicationPortConstraintEClass, CommunicationPortConstraint.class,
				"CommunicationPortConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCommunicationPortConstraint_IsTarget(),
				theXMLTypePackage.getBoolean(),
				"isTarget", "true", 0, 1, CommunicationPortConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getCommunicationPortConstraint_Port(),
				theXMLTypePackage.getInt(),
				"port", null, 1, 1, CommunicationPortConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				communicationRedundancyConstraintEClass,
				CommunicationRedundancyConstraint.class,
				"CommunicationRedundancyConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCommunicationRedundancyConstraint_Redundancy(),
				theXMLTypePackage.getInt(),
				"redundancy", "1", 0, 1, CommunicationRedundancyConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(communicationTypeConstraintEClass, CommunicationTypeConstraint.class,
				"CommunicationTypeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCommunicationTypeConstraint_Type(),
				this.getCommunicationTypeTypes(),
				"type", "LAN", 0, 1, CommunicationTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(constraintRootEClass, ConstraintRoot.class,
				"ConstraintRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getConstraintRoot_Mixed(),
				ecorePackage.getEFeatureMapEntry(),
				"mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_XMLNSPrefixMap(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_XSISchemaLocation(),
				ecorePackage.getEStringToStringMapEntry(),
				null,
				"xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintAnd(),
				this.getAndConstraint(),
				null,
				"constraintAnd", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintApplicationcommunication(),
				this.getApplicationCommunicationConstraint(),
				null,
				"constraintApplicationcommunication", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintApplicationprotocol(),
				this.getApplicationCommunicationProtocolConstraint(),
				null,
				"constraintApplicationprotocol", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintAttrdef(),
				this.getAttributeDefinedConstraint(),
				null,
				"constraintAttrdef", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintAttributePropagation(),
				this.getAttributePropagationConstraint(),
				null,
				"constraintAttributePropagation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintBasecommunication(),
				this.getBaseCommunicationConstraint(),
				null,
				"constraintBasecommunication", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCapacity(),
				this.getCapacityConstraint(),
				null,
				"constraintCapacity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCapacityRestriction(),
				this.getAttributeCapacityConstraint(),
				null,
				"constraintCapacityRestriction", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCollocation(),
				this.getCollocationConstraint(),
				null,
				"constraintCollocation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCommunicationbandwidth(),
				this.getCommunicationBandwidthConstraint(),
				null,
				"constraintCommunicationbandwidth", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCommunicationcost(),
				this.getCommunicationCostConstraint(),
				null,
				"constraintCommunicationcost", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCommunicationport(),
				this.getCommunicationPortConstraint(),
				null,
				"constraintCommunicationport", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCommunicationredundancy(),
				this.getCommunicationRedundancyConstraint(),
				null,
				"constraintCommunicationredundancy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintCommunicationtype(),
				this.getCommunicationTypeConstraint(),
				null,
				"constraintCommunicationtype", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintDeferredHosting(),
				this.getDeferredHostingConstraint(),
				null,
				"constraintDeferredHosting", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintEnumeration(),
				this.getEnumerationConstraint(),
				null,
				"constraintEnumeration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintEquals(),
				this.getEqualsConstraint(),
				null,
				"constraintEquals", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintExclusion(),
				this.getExclusionConstraint(),
				null,
				"constraintExclusion", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintGroupCardinality(),
				this.getGroupCardinalityConstraint(),
				null,
				"constraintGroupCardinality", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintMemberCardinality(),
				this.getMemberCardinalityConstraint(),
				null,
				"constraintMemberCardinality", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintNetworkcommunication(),
				this.getNetworkCommunicationConstraint(),
				null,
				"constraintNetworkcommunication", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintNot(),
				this.getNotConstraint(),
				null,
				"constraintNot", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintOr(),
				this.getOrConstraint(),
				null,
				"constraintOr", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintPalette(),
				this.getPaletteConstraint(),
				null,
				"constraintPalette", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintProductIdentifier(),
				this.getProductIdentifierConstraint(),
				null,
				"constraintProductIdentifier", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintRange(),
				this.getRangeConstraint(),
				null,
				"constraintRange", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintRealization(),
				this.getRealizationConstraint(),
				null,
				"constraintRealization", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintStereotype(),
				this.getStereotypeConstraint(),
				null,
				"constraintStereotype", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintSynchronouscommunication(),
				this.getSynchronousCommunicationConstraint(),
				null,
				"constraintSynchronouscommunication", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintTransmissiondelay(),
				this.getTransmissionDelayConstraint(),
				null,
				"constraintTransmissiondelay", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintType(),
				this.getTypeConstraint(),
				null,
				"constraintType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintUpdate(),
				this.getUpdateConstraint(),
				null,
				"constraintUpdate", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintVersion(),
				this.getVersionConstraint(),
				null,
				"constraintVersion", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_ConstraintXor(),
				this.getXorConstraint(),
				null,
				"constraintXor", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstraintRoot_Value(),
				this.getSingleValue(),
				null,
				"value", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(deferredHostingConstraintEClass, DeferredHostingConstraint.class,
				"DeferredHostingConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(enumerationConstraintEClass, EnumerationConstraint.class,
				"EnumerationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getEnumerationConstraint_Values(),
				this.getSingleValue(),
				null,
				"values", null, 1, -1, EnumerationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(equalsConstraintEClass, EqualsConstraint.class,
				"EqualsConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEqualsConstraint_Value(),
				theXMLTypePackage.getString(),
				"value", null, 1, 1, EqualsConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(exclusionConstraintEClass, ExclusionConstraint.class,
				"ExclusionConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getExclusionConstraint_Values(),
				this.getSingleValue(),
				null,
				"values", null, 1, -1, ExclusionConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(groupCardinalityConstraintEClass, GroupCardinalityConstraint.class,
				"GroupCardinalityConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getGroupCardinalityConstraint_MaxValue(),
				theXMLTypePackage.getString(),
				"maxValue", "unbounded", 0, 1, GroupCardinalityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getGroupCardinalityConstraint_MinValue(),
				theXMLTypePackage.getString(),
				"minValue", "0", 0, 1, GroupCardinalityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(memberCardinalityConstraintEClass, MemberCardinalityConstraint.class,
				"MemberCardinalityConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMemberCardinalityConstraint_MaxValue(),
				theXMLTypePackage.getString(),
				"maxValue", "unbounded", 0, 1, MemberCardinalityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getMemberCardinalityConstraint_MinValue(),
				theXMLTypePackage.getString(),
				"minValue", "0", 0, 1, MemberCardinalityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				networkCommunicationConstraintEClass,
				NetworkCommunicationConstraint.class,
				"NetworkCommunicationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(notConstraintEClass, NotConstraint.class,
				"NotConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(orConstraintEClass, OrConstraint.class,
				"OrConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(paletteConstraintEClass, PaletteConstraint.class,
				"PaletteConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPaletteConstraint_ResourceTypeId(),
				theXMLTypePackage.getString(),
				"resourceTypeId", null, 1, 1, PaletteConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(productIdentifierConstraintEClass, ProductIdentifierConstraint.class,
				"ProductIdentifierConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getProductIdentifierConstraint_ProductIdentifier(),
				theXMLTypePackage.getString(),
				"productIdentifier", null, 1, 1, ProductIdentifierConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(rangeConstraintEClass, RangeConstraint.class,
				"RangeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRangeConstraint_MaxValue(),
				theXMLTypePackage.getString(),
				"maxValue", null, 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRangeConstraint_MaxValueInclusive(),
				theXMLTypePackage.getBoolean(),
				"maxValueInclusive", "true", 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getRangeConstraint_MinValue(),
				theXMLTypePackage.getString(),
				"minValue", null, 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRangeConstraint_MinValueInclusive(),
				theXMLTypePackage.getBoolean(),
				"minValueInclusive", "true", 0, 1, RangeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(realizationConstraintEClass, RealizationConstraint.class,
				"RealizationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(singleValueEClass, SingleValue.class,
				"SingleValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getSingleValue_Description(),
				theXMLTypePackage.getString(),
				"description", null, 0, 1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getSingleValue_Value(),
				theXMLTypePackage.getString(),
				"value", null, 1, 1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stereotypeConstraintEClass, StereotypeConstraint.class,
				"StereotypeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStereotypeConstraint_Includes(),
				theXMLTypePackage.getString(),
				"includes", null, 1, 1, StereotypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(structuralConstraintEClass, StructuralConstraint.class,
				"StructuralConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				synchronousCommunicationConstraintEClass,
				SynchronousCommunicationConstraint.class,
				"SynchronousCommunicationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getSynchronousCommunicationConstraint_Synchronous(),
				theXMLTypePackage.getBoolean(),
				"synchronous", "true", 0, 1, SynchronousCommunicationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(transmissionDelayConstraintEClass, TransmissionDelayConstraint.class,
				"TransmissionDelayConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getTransmissionDelayConstraint_Delay(),
				theXMLTypePackage.getInt(),
				"delay", null, 1, 1, TransmissionDelayConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeConstraintEClass, TypeConstraint.class,
				"TypeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getTypeConstraint_DmoType(),
				theXMLTypePackage.getQName(),
				"dmoType", null, 1, 1, TypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(versionConstraintEClass, VersionConstraint.class,
				"VersionConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getVersionConstraint_Value(),
				theXMLTypePackage.getString(),
				"value", null, 1, 1, VersionConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(xorConstraintEClass, XorConstraint.class,
				"XorConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(collocationConstraintTypesEEnum, CollocationConstraintTypes.class,
				"CollocationConstraintTypes"); //$NON-NLS-1$
		addEEnumLiteral(collocationConstraintTypesEEnum,
				CollocationConstraintTypes.COLLOCATION_LITERAL);
		addEEnumLiteral(collocationConstraintTypesEEnum,
				CollocationConstraintTypes.ANTICOLLOCATION_LITERAL);

		initEEnum(communicationTypeTypesEEnum, CommunicationTypeTypes.class, "CommunicationTypeTypes"); //$NON-NLS-1$
		addEEnumLiteral(communicationTypeTypesEEnum, CommunicationTypeTypes.LAN_LITERAL);
		addEEnumLiteral(communicationTypeTypesEEnum, CommunicationTypeTypes.WAN_LITERAL);

		// Initialize data types
		initEDataType(collocationConstraintTypesObjectEDataType, CollocationConstraintTypes.class,
				"CollocationConstraintTypesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(communicationTypeTypesObjectEDataType, CommunicationTypeTypes.class,
				"CommunicationTypeTypesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$				
		addAnnotation(andConstraintEClass, source, new String[] { "name", "AndConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(applicationCommunicationConstraintEClass, source, new String[] {
				"name", "ApplicationCommunicationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(applicationCommunicationProtocolConstraintEClass, source, new String[] {
				"name", "ApplicationCommunicationProtocolConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getApplicationCommunicationProtocolConstraint_ApplicationLayerProtocol(),
				source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
						"name", "applicationLayerProtocol" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(attributeCapacityConstraintEClass, source, new String[] {
				"name", "AttributeCapacityConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributeCapacityConstraint_Exclusive(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "exclusive" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributeCapacityConstraint_Value(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(attributeDefinedConstraintEClass, source, new String[] {
				"name", "AttributeDefinedConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(attributePropagationConstraintEClass, source, new String[] {
				"name", "AttributePropagationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributePropagationConstraint_RespectLinkDirection(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "respectLinkDirection" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributePropagationConstraint_SourceAttributeName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "sourceAttributeName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributePropagationConstraint_SourceObjectURI(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "sourceObjectURI" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributePropagationConstraint_TargetAttributeName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "targetAttributeName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributePropagationConstraint_TargetObjectURI(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "targetObjectURI" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(attributeValueConstraintEClass, source, new String[] {
				"name", "AttributeValueConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getAttributeValueConstraint_AttributeName(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "attributeName" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(baseCommunicationConstraintEClass, source, new String[] {
				"name", "BaseCommunicationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getBaseCommunicationConstraint_RespectLinkDirection(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "respectLinkDirection" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(booleanOperatorEClass, source, new String[] { "name", "BooleanOperator", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(capacityConstraintEClass, source, new String[] { "name", "CapacityConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(collocationConstraintEClass, source, new String[] {
				"name", "CollocationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCollocationConstraint_CapabilityType(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "capabilityType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCollocationConstraint_Type(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(collocationConstraintTypesEEnum, source, new String[] {
				"name", "CollocationConstraintTypes" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(collocationConstraintTypesObjectEDataType, source, new String[] {
				"name", "CollocationConstraintTypes:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "CollocationConstraintTypes" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationBandwidthConstraintEClass, source, new String[] {
				"name", "CommunicationBandwidthConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCommunicationBandwidthConstraint_Bandwidth(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "bandwidth" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationChildConstraintEClass, source, new String[] {
				"name", "CommunicationChildConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationCostConstraintEClass, source, new String[] {
				"name", "CommunicationCostConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCommunicationCostConstraint_Cost(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "cost" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationPortConstraintEClass, source, new String[] {
				"name", "CommunicationPortConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCommunicationPortConstraint_IsTarget(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "isTarget" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCommunicationPortConstraint_Port(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "port" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationRedundancyConstraintEClass, source, new String[] {
				"name", "CommunicationRedundancyConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCommunicationRedundancyConstraint_Redundancy(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "redundancy" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationTypeConstraintEClass, source, new String[] {
				"name", "CommunicationTypeConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getCommunicationTypeConstraint_Type(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationTypeTypesEEnum, source, new String[] {
				"name", "CommunicationTypeTypes" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(communicationTypeTypesObjectEDataType, source, new String[] {
				"name", "CommunicationTypeTypes:Object", //$NON-NLS-1$ //$NON-NLS-2$
				"baseType", "CommunicationTypeTypes" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(constraintRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_Mixed(), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
				"name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_XMLNSPrefixMap(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_XSISchemaLocation(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintAnd(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.and", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintApplicationcommunication(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.applicationcommunication", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintApplicationprotocol(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.applicationprotocol", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintAttrdef(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.attrdef", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintAttributePropagation(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.attributePropagation", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintBasecommunication(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.basecommunication", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCapacity(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.capacity", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCapacityRestriction(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.capacityRestriction", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCollocation(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.collocation", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCommunicationbandwidth(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.communicationbandwidth", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCommunicationcost(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.communicationcost", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCommunicationport(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.communicationport", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCommunicationredundancy(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.communicationredundancy", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintCommunicationtype(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.communicationtype", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintDeferredHosting(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.deferredHosting", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintEnumeration(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.enumeration", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintEquals(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.equals", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintExclusion(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.exclusion", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintGroupCardinality(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.groupCardinality", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintMemberCardinality(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.memberCardinality", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintNetworkcommunication(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.networkcommunication", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintNot(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.not", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintOr(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.or", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintPalette(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.palette", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintProductIdentifier(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.productIdentifier", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintRange(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.range", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintRealization(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.realization", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintStereotype(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.stereotype", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintSynchronouscommunication(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.synchronouscommunication", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintTransmissiondelay(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.transmissiondelay", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintType(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.type", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintUpdate(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.update", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintVersion(), source, new String[] {
				"kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.version", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_ConstraintXor(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "constraint.xor", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
				"affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getConstraintRoot_Value(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(deferredHostingConstraintEClass, source, new String[] {
				"name", "DeferredHostingConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(enumerationConstraintEClass, source, new String[] {
				"name", "EnumerationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEnumerationConstraint_Values(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(equalsConstraintEClass, source, new String[] { "name", "EqualsConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getEqualsConstraint_Value(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(exclusionConstraintEClass, source, new String[] {
				"name", "ExclusionConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getExclusionConstraint_Values(), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value", //$NON-NLS-1$ //$NON-NLS-2$
				"namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(groupCardinalityConstraintEClass, source, new String[] {
				"name", "GroupCardinalityConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getGroupCardinalityConstraint_MaxValue(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "maxValue" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getGroupCardinalityConstraint_MinValue(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "minValue" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(memberCardinalityConstraintEClass, source, new String[] {
				"name", "MemberCardinalityConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMemberCardinalityConstraint_MaxValue(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "maxValue" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMemberCardinalityConstraint_MinValue(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "minValue" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(networkCommunicationConstraintEClass, source, new String[] {
				"name", "NetworkCommunicationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(notConstraintEClass, source, new String[] { "name", "NotConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(orConstraintEClass, source, new String[] { "name", "OrConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(paletteConstraintEClass, source, new String[] { "name", "PaletteConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getPaletteConstraint_ResourceTypeId(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "resourceTypeId" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(productIdentifierConstraintEClass, source, new String[] {
				"name", "ProductIdentifierConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getProductIdentifierConstraint_ProductIdentifier(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "productIdentifier" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(rangeConstraintEClass, source, new String[] { "name", "RangeConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRangeConstraint_MaxValue(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "maxValue" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRangeConstraint_MaxValueInclusive(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "maxValueInclusive" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRangeConstraint_MinValue(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "minValue" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getRangeConstraint_MinValueInclusive(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "minValueInclusive" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(realizationConstraintEClass, source, new String[] {
				"name", "RealizationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(singleValueEClass, source, new String[] { "name", "SingleValue", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSingleValue_Description(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "description" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSingleValue_Value(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(stereotypeConstraintEClass, source, new String[] {
				"name", "StereotypeConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getStereotypeConstraint_Includes(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "includes" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(structuralConstraintEClass, source, new String[] {
				"name", "StructuralConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(synchronousCommunicationConstraintEClass, source, new String[] {
				"name", "SynchronousCommunicationConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getSynchronousCommunicationConstraint_Synchronous(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "synchronous" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(transmissionDelayConstraintEClass, source, new String[] {
				"name", "TransmissionDelayConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getTransmissionDelayConstraint_Delay(), source, new String[] {
				"kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "delay" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(typeConstraintEClass, source, new String[] { "name", "TypeConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getTypeConstraint_DmoType(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "dmoType" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(updateConstraintEClass, source, new String[] { "name", "UpdateConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(versionConstraintEClass, source, new String[] { "name", "VersionConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getVersionConstraint_Value(), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
				"name", "value" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(xorConstraintEClass, source, new String[] { "name", "XorConstraint", //$NON-NLS-1$ //$NON-NLS-2$
				"kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //ConstraintPackageImpl
