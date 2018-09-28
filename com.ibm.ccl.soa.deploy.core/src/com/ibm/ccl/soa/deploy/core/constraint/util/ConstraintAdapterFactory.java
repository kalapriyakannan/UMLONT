/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
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
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint;
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
import com.ibm.ccl.soa.deploy.core.constraint.StructuralConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.XorConstraint;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage
 * @generated
 */
public class ConstraintAdapterFactory extends AdapterFactoryImpl {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ConstraintPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConstraintPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or
	 * is an instance object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConstraintSwitch modelSwitch = new ConstraintSwitch() {
		public Object caseAndConstraint(AndConstraint object) {
			return createAndConstraintAdapter();
		}

		public Object caseApplicationCommunicationConstraint(ApplicationCommunicationConstraint object) {
			return createApplicationCommunicationConstraintAdapter();
		}

		public Object caseApplicationCommunicationProtocolConstraint(
				ApplicationCommunicationProtocolConstraint object) {
			return createApplicationCommunicationProtocolConstraintAdapter();
		}

		public Object caseAttributeCapacityConstraint(AttributeCapacityConstraint object) {
			return createAttributeCapacityConstraintAdapter();
		}

		public Object caseAttributeDefinedConstraint(AttributeDefinedConstraint object) {
			return createAttributeDefinedConstraintAdapter();
		}

		public Object caseAttributePropagationConstraint(AttributePropagationConstraint object) {
			return createAttributePropagationConstraintAdapter();
		}

		public Object caseAttributeValueConstraint(AttributeValueConstraint object) {
			return createAttributeValueConstraintAdapter();
		}

		public Object caseBaseCommunicationConstraint(BaseCommunicationConstraint object) {
			return createBaseCommunicationConstraintAdapter();
		}

		public Object caseBooleanOperator(BooleanOperator object) {
			return createBooleanOperatorAdapter();
		}

		public Object caseCapacityConstraint(CapacityConstraint object) {
			return createCapacityConstraintAdapter();
		}

		public Object caseCollocationConstraint(CollocationConstraint object) {
			return createCollocationConstraintAdapter();
		}

		public Object caseCommunicationBandwidthConstraint(CommunicationBandwidthConstraint object) {
			return createCommunicationBandwidthConstraintAdapter();
		}

		public Object caseCommunicationChildConstraint(CommunicationChildConstraint object) {
			return createCommunicationChildConstraintAdapter();
		}

		public Object caseCommunicationCostConstraint(CommunicationCostConstraint object) {
			return createCommunicationCostConstraintAdapter();
		}

		public Object caseCommunicationPortConstraint(CommunicationPortConstraint object) {
			return createCommunicationPortConstraintAdapter();
		}

		public Object caseCommunicationRedundancyConstraint(CommunicationRedundancyConstraint object) {
			return createCommunicationRedundancyConstraintAdapter();
		}

		public Object caseCommunicationTypeConstraint(CommunicationTypeConstraint object) {
			return createCommunicationTypeConstraintAdapter();
		}

		public Object caseConstraintRoot(ConstraintRoot object) {
			return createConstraintRootAdapter();
		}

		public Object caseDeferredHostingConstraint(DeferredHostingConstraint object) {
			return createDeferredHostingConstraintAdapter();
		}

		public Object caseEnumerationConstraint(EnumerationConstraint object) {
			return createEnumerationConstraintAdapter();
		}

		public Object caseEqualsConstraint(EqualsConstraint object) {
			return createEqualsConstraintAdapter();
		}

		public Object caseExclusionConstraint(ExclusionConstraint object) {
			return createExclusionConstraintAdapter();
		}

		public Object caseGroupCardinalityConstraint(GroupCardinalityConstraint object) {
			return createGroupCardinalityConstraintAdapter();
		}

		public Object caseMemberCardinalityConstraint(MemberCardinalityConstraint object) {
			return createMemberCardinalityConstraintAdapter();
		}

		public Object caseNetworkCommunicationConstraint(NetworkCommunicationConstraint object) {
			return createNetworkCommunicationConstraintAdapter();
		}

		public Object caseNotConstraint(NotConstraint object) {
			return createNotConstraintAdapter();
		}

		public Object caseOrConstraint(OrConstraint object) {
			return createOrConstraintAdapter();
		}

		public Object casePaletteConstraint(PaletteConstraint object) {
			return createPaletteConstraintAdapter();
		}

		public Object caseProductIdentifierConstraint(ProductIdentifierConstraint object) {
			return createProductIdentifierConstraintAdapter();
		}

		public Object caseRangeConstraint(RangeConstraint object) {
			return createRangeConstraintAdapter();
		}

		public Object caseRealizationConstraint(RealizationConstraint object) {
			return createRealizationConstraintAdapter();
		}

		public Object caseSingleValue(SingleValue object) {
			return createSingleValueAdapter();
		}

		public Object caseStereotypeConstraint(StereotypeConstraint object) {
			return createStereotypeConstraintAdapter();
		}

		public Object caseStructuralConstraint(StructuralConstraint object) {
			return createStructuralConstraintAdapter();
		}

		public Object caseSynchronousCommunicationConstraint(SynchronousCommunicationConstraint object) {
			return createSynchronousCommunicationConstraintAdapter();
		}

		public Object caseTransmissionDelayConstraint(TransmissionDelayConstraint object) {
			return createTransmissionDelayConstraintAdapter();
		}

		public Object caseTypeConstraint(TypeConstraint object) {
			return createTypeConstraintAdapter();
		}

		public Object caseVersionConstraint(VersionConstraint object) {
			return createVersionConstraintAdapter();
		}

		public Object caseXorConstraint(XorConstraint object) {
			return createXorConstraintAdapter();
		}

		public Object caseDeployModelObject(DeployModelObject object) {
			return createDeployModelObjectAdapter();
		}

		public Object caseConstraint(Constraint object) {
			return createConstraintAdapter();
		}

		public Object defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param target
	 *           the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter) modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.AndConstraint <em>And Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AndConstraint
	 * @generated
	 */
	public Adapter createAndConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint <em>Application Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint
	 * @generated
	 */
	public Adapter createApplicationCommunicationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint <em>Application Communication Protocol Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint
	 * @generated
	 */
	public Adapter createApplicationCommunicationProtocolConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint <em>Attribute Capacity Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint
	 * @generated
	 */
	public Adapter createAttributeCapacityConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint <em>Attribute Defined Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint
	 * @generated
	 */
	public Adapter createAttributeDefinedConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint <em>Attribute Propagation Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint
	 * @generated
	 */
	public Adapter createAttributePropagationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint <em>Attribute Value Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint
	 * @generated
	 */
	public Adapter createAttributeValueConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint <em>Base Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint
	 * @generated
	 */
	public Adapter createBaseCommunicationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator <em>Boolean Operator</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator
	 * @generated
	 */
	public Adapter createBooleanOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint <em>Capacity Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint
	 * @generated
	 */
	public Adapter createCapacityConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint <em>Collocation Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint
	 * @generated
	 */
	public Adapter createCollocationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint <em>Communication Bandwidth Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint
	 * @generated
	 */
	public Adapter createCommunicationBandwidthConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint <em>Communication Child Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint
	 * @generated
	 */
	public Adapter createCommunicationChildConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint <em>Communication Cost Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint
	 * @generated
	 */
	public Adapter createCommunicationCostConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint <em>Communication Port Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint
	 * @generated
	 */
	public Adapter createCommunicationPortConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint <em>Communication Redundancy Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint
	 * @generated
	 */
	public Adapter createCommunicationRedundancyConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint <em>Communication Type Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint
	 * @generated
	 */
	public Adapter createCommunicationTypeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot <em>Root</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot
	 * @generated
	 */
	public Adapter createConstraintRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint <em>Deferred Hosting Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint
	 * @generated
	 */
	public Adapter createDeferredHostingConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint <em>Enumeration Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint
	 * @generated
	 */
	public Adapter createEnumerationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint <em>Equals Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint
	 * @generated
	 */
	public Adapter createEqualsConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint <em>Exclusion Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint
	 * @generated
	 */
	public Adapter createExclusionConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint <em>Group Cardinality Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint
	 * @generated
	 */
	public Adapter createGroupCardinalityConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint <em>Member Cardinality Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint
	 * @generated
	 */
	public Adapter createMemberCardinalityConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint <em>Network Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint
	 * @generated
	 */
	public Adapter createNetworkCommunicationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.NotConstraint <em>Not Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.NotConstraint
	 * @generated
	 */
	public Adapter createNotConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.OrConstraint <em>Or Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.OrConstraint
	 * @generated
	 */
	public Adapter createOrConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint <em>Palette Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint
	 * @generated
	 */
	public Adapter createPaletteConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint <em>Product Identifier Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint
	 * @generated
	 */
	public Adapter createProductIdentifierConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint <em>Range Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint
	 * @generated
	 */
	public Adapter createRangeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.RealizationConstraint <em>Realization Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RealizationConstraint
	 * @generated
	 */
	public Adapter createRealizationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue <em>Single Value</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SingleValue
	 * @generated
	 */
	public Adapter createSingleValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint <em>Stereotype Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint
	 * @generated
	 */
	public Adapter createStereotypeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.StructuralConstraint <em>Structural Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.StructuralConstraint
	 * @generated
	 */
	public Adapter createStructuralConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint <em>Synchronous Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint
	 * @generated
	 */
	public Adapter createSynchronousCommunicationConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint <em>Transmission Delay Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint
	 * @generated
	 */
	public Adapter createTransmissionDelayConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint <em>Type Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint
	 * @generated
	 */
	public Adapter createTypeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.UpdateConstraint <em>Update Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.UpdateConstraint
	 * @generated
	 */
	public Adapter createUpdateConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint <em>Version Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint
	 * @generated
	 */
	public Adapter createVersionConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.constraint.XorConstraint <em>Xor Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.XorConstraint
	 * @generated
	 */
	public Adapter createXorConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConstraintAdapterFactory
