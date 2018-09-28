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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage
 * @generated
 */
public class ConstraintSwitch {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ConstraintPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintSwitch() {
		if (modelPackage == null) {
			modelPackage = ConstraintPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes
					.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
		case ConstraintPackage.AND_CONSTRAINT: {
			AndConstraint andConstraint = (AndConstraint) theEObject;
			Object result = caseAndConstraint(andConstraint);
			if (result == null) {
				result = caseBooleanOperator(andConstraint);
			}
			if (result == null) {
				result = caseConstraint(andConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(andConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT: {
			ApplicationCommunicationConstraint applicationCommunicationConstraint = (ApplicationCommunicationConstraint) theEObject;
			Object result = caseApplicationCommunicationConstraint(applicationCommunicationConstraint);
			if (result == null) {
				result = caseBaseCommunicationConstraint(applicationCommunicationConstraint);
			}
			if (result == null) {
				result = caseConstraint(applicationCommunicationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(applicationCommunicationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT: {
			ApplicationCommunicationProtocolConstraint applicationCommunicationProtocolConstraint = (ApplicationCommunicationProtocolConstraint) theEObject;
			Object result = caseApplicationCommunicationProtocolConstraint(applicationCommunicationProtocolConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(applicationCommunicationProtocolConstraint);
			}
			if (result == null) {
				result = caseConstraint(applicationCommunicationProtocolConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(applicationCommunicationProtocolConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.ATTRIBUTE_CAPACITY_CONSTRAINT: {
			AttributeCapacityConstraint attributeCapacityConstraint = (AttributeCapacityConstraint) theEObject;
			Object result = caseAttributeCapacityConstraint(attributeCapacityConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(attributeCapacityConstraint);
			}
			if (result == null) {
				result = caseConstraint(attributeCapacityConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(attributeCapacityConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.ATTRIBUTE_DEFINED_CONSTRAINT: {
			AttributeDefinedConstraint attributeDefinedConstraint = (AttributeDefinedConstraint) theEObject;
			Object result = caseAttributeDefinedConstraint(attributeDefinedConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(attributeDefinedConstraint);
			}
			if (result == null) {
				result = caseConstraint(attributeDefinedConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(attributeDefinedConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.ATTRIBUTE_PROPAGATION_CONSTRAINT: {
			AttributePropagationConstraint attributePropagationConstraint = (AttributePropagationConstraint) theEObject;
			Object result = caseAttributePropagationConstraint(attributePropagationConstraint);
			if (result == null) {
				result = caseConstraint(attributePropagationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(attributePropagationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.ATTRIBUTE_VALUE_CONSTRAINT: {
			AttributeValueConstraint attributeValueConstraint = (AttributeValueConstraint) theEObject;
			Object result = caseAttributeValueConstraint(attributeValueConstraint);
			if (result == null) {
				result = caseConstraint(attributeValueConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(attributeValueConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.BASE_COMMUNICATION_CONSTRAINT: {
			BaseCommunicationConstraint baseCommunicationConstraint = (BaseCommunicationConstraint) theEObject;
			Object result = caseBaseCommunicationConstraint(baseCommunicationConstraint);
			if (result == null) {
				result = caseConstraint(baseCommunicationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(baseCommunicationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.BOOLEAN_OPERATOR: {
			BooleanOperator booleanOperator = (BooleanOperator) theEObject;
			Object result = caseBooleanOperator(booleanOperator);
			if (result == null) {
				result = caseConstraint(booleanOperator);
			}
			if (result == null) {
				result = caseDeployModelObject(booleanOperator);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.CAPACITY_CONSTRAINT: {
			CapacityConstraint capacityConstraint = (CapacityConstraint) theEObject;
			Object result = caseCapacityConstraint(capacityConstraint);
			if (result == null) {
				result = caseTypeConstraint(capacityConstraint);
			}
			if (result == null) {
				result = caseConstraint(capacityConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(capacityConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COLLOCATION_CONSTRAINT: {
			CollocationConstraint collocationConstraint = (CollocationConstraint) theEObject;
			Object result = caseCollocationConstraint(collocationConstraint);
			if (result == null) {
				result = caseStructuralConstraint(collocationConstraint);
			}
			if (result == null) {
				result = caseConstraint(collocationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(collocationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COMMUNICATION_BANDWIDTH_CONSTRAINT: {
			CommunicationBandwidthConstraint communicationBandwidthConstraint = (CommunicationBandwidthConstraint) theEObject;
			Object result = caseCommunicationBandwidthConstraint(communicationBandwidthConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(communicationBandwidthConstraint);
			}
			if (result == null) {
				result = caseConstraint(communicationBandwidthConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(communicationBandwidthConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COMMUNICATION_CHILD_CONSTRAINT: {
			CommunicationChildConstraint communicationChildConstraint = (CommunicationChildConstraint) theEObject;
			Object result = caseCommunicationChildConstraint(communicationChildConstraint);
			if (result == null) {
				result = caseConstraint(communicationChildConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(communicationChildConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COMMUNICATION_COST_CONSTRAINT: {
			CommunicationCostConstraint communicationCostConstraint = (CommunicationCostConstraint) theEObject;
			Object result = caseCommunicationCostConstraint(communicationCostConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(communicationCostConstraint);
			}
			if (result == null) {
				result = caseConstraint(communicationCostConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(communicationCostConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COMMUNICATION_PORT_CONSTRAINT: {
			CommunicationPortConstraint communicationPortConstraint = (CommunicationPortConstraint) theEObject;
			Object result = caseCommunicationPortConstraint(communicationPortConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(communicationPortConstraint);
			}
			if (result == null) {
				result = caseConstraint(communicationPortConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(communicationPortConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COMMUNICATION_REDUNDANCY_CONSTRAINT: {
			CommunicationRedundancyConstraint communicationRedundancyConstraint = (CommunicationRedundancyConstraint) theEObject;
			Object result = caseCommunicationRedundancyConstraint(communicationRedundancyConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(communicationRedundancyConstraint);
			}
			if (result == null) {
				result = caseConstraint(communicationRedundancyConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(communicationRedundancyConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.COMMUNICATION_TYPE_CONSTRAINT: {
			CommunicationTypeConstraint communicationTypeConstraint = (CommunicationTypeConstraint) theEObject;
			Object result = caseCommunicationTypeConstraint(communicationTypeConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(communicationTypeConstraint);
			}
			if (result == null) {
				result = caseConstraint(communicationTypeConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(communicationTypeConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.CONSTRAINT_ROOT: {
			ConstraintRoot constraintRoot = (ConstraintRoot) theEObject;
			Object result = caseConstraintRoot(constraintRoot);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.DEFERRED_HOSTING_CONSTRAINT: {
			DeferredHostingConstraint deferredHostingConstraint = (DeferredHostingConstraint) theEObject;
			Object result = caseDeferredHostingConstraint(deferredHostingConstraint);
			if (result == null) {
				result = caseStructuralConstraint(deferredHostingConstraint);
			}
			if (result == null) {
				result = caseConstraint(deferredHostingConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(deferredHostingConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.ENUMERATION_CONSTRAINT: {
			EnumerationConstraint enumerationConstraint = (EnumerationConstraint) theEObject;
			Object result = caseEnumerationConstraint(enumerationConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(enumerationConstraint);
			}
			if (result == null) {
				result = caseConstraint(enumerationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(enumerationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.EQUALS_CONSTRAINT: {
			EqualsConstraint equalsConstraint = (EqualsConstraint) theEObject;
			Object result = caseEqualsConstraint(equalsConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(equalsConstraint);
			}
			if (result == null) {
				result = caseConstraint(equalsConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(equalsConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.EXCLUSION_CONSTRAINT: {
			ExclusionConstraint exclusionConstraint = (ExclusionConstraint) theEObject;
			Object result = caseExclusionConstraint(exclusionConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(exclusionConstraint);
			}
			if (result == null) {
				result = caseConstraint(exclusionConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(exclusionConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.GROUP_CARDINALITY_CONSTRAINT: {
			GroupCardinalityConstraint groupCardinalityConstraint = (GroupCardinalityConstraint) theEObject;
			Object result = caseGroupCardinalityConstraint(groupCardinalityConstraint);
			if (result == null) {
				result = caseConstraint(groupCardinalityConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(groupCardinalityConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.MEMBER_CARDINALITY_CONSTRAINT: {
			MemberCardinalityConstraint memberCardinalityConstraint = (MemberCardinalityConstraint) theEObject;
			Object result = caseMemberCardinalityConstraint(memberCardinalityConstraint);
			if (result == null) {
				result = caseConstraint(memberCardinalityConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(memberCardinalityConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.NETWORK_COMMUNICATION_CONSTRAINT: {
			NetworkCommunicationConstraint networkCommunicationConstraint = (NetworkCommunicationConstraint) theEObject;
			Object result = caseNetworkCommunicationConstraint(networkCommunicationConstraint);
			if (result == null) {
				result = caseBaseCommunicationConstraint(networkCommunicationConstraint);
			}
			if (result == null) {
				result = caseConstraint(networkCommunicationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(networkCommunicationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.NOT_CONSTRAINT: {
			NotConstraint notConstraint = (NotConstraint) theEObject;
			Object result = caseNotConstraint(notConstraint);
			if (result == null) {
				result = caseBooleanOperator(notConstraint);
			}
			if (result == null) {
				result = caseConstraint(notConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(notConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.OR_CONSTRAINT: {
			OrConstraint orConstraint = (OrConstraint) theEObject;
			Object result = caseOrConstraint(orConstraint);
			if (result == null) {
				result = caseBooleanOperator(orConstraint);
			}
			if (result == null) {
				result = caseConstraint(orConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(orConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.PALETTE_CONSTRAINT: {
			PaletteConstraint paletteConstraint = (PaletteConstraint) theEObject;
			Object result = casePaletteConstraint(paletteConstraint);
			if (result == null) {
				result = caseConstraint(paletteConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(paletteConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.PRODUCT_IDENTIFIER_CONSTRAINT: {
			ProductIdentifierConstraint productIdentifierConstraint = (ProductIdentifierConstraint) theEObject;
			Object result = caseProductIdentifierConstraint(productIdentifierConstraint);
			if (result == null) {
				result = caseConstraint(productIdentifierConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(productIdentifierConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.RANGE_CONSTRAINT: {
			RangeConstraint rangeConstraint = (RangeConstraint) theEObject;
			Object result = caseRangeConstraint(rangeConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(rangeConstraint);
			}
			if (result == null) {
				result = caseConstraint(rangeConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(rangeConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.REALIZATION_CONSTRAINT: {
			RealizationConstraint realizationConstraint = (RealizationConstraint) theEObject;
			Object result = caseRealizationConstraint(realizationConstraint);
			if (result == null) {
				result = caseConstraint(realizationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(realizationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.SINGLE_VALUE: {
			SingleValue singleValue = (SingleValue) theEObject;
			Object result = caseSingleValue(singleValue);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.STEREOTYPE_CONSTRAINT: {
			StereotypeConstraint stereotypeConstraint = (StereotypeConstraint) theEObject;
			Object result = caseStereotypeConstraint(stereotypeConstraint);
			if (result == null) {
				result = caseConstraint(stereotypeConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(stereotypeConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.STRUCTURAL_CONSTRAINT: {
			StructuralConstraint structuralConstraint = (StructuralConstraint) theEObject;
			Object result = caseStructuralConstraint(structuralConstraint);
			if (result == null) {
				result = caseConstraint(structuralConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(structuralConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.SYNCHRONOUS_COMMUNICATION_CONSTRAINT: {
			SynchronousCommunicationConstraint synchronousCommunicationConstraint = (SynchronousCommunicationConstraint) theEObject;
			Object result = caseSynchronousCommunicationConstraint(synchronousCommunicationConstraint);
			if (result == null) {
				result = caseConstraint(synchronousCommunicationConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(synchronousCommunicationConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.TRANSMISSION_DELAY_CONSTRAINT: {
			TransmissionDelayConstraint transmissionDelayConstraint = (TransmissionDelayConstraint) theEObject;
			Object result = caseTransmissionDelayConstraint(transmissionDelayConstraint);
			if (result == null) {
				result = caseCommunicationChildConstraint(transmissionDelayConstraint);
			}
			if (result == null) {
				result = caseConstraint(transmissionDelayConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(transmissionDelayConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.TYPE_CONSTRAINT: {
			TypeConstraint typeConstraint = (TypeConstraint) theEObject;
			Object result = caseTypeConstraint(typeConstraint);
			if (result == null) {
				result = caseConstraint(typeConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(typeConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}

		case ConstraintPackage.VERSION_CONSTRAINT: {
			VersionConstraint versionConstraint = (VersionConstraint) theEObject;
			Object result = caseVersionConstraint(versionConstraint);
			if (result == null) {
				result = caseAttributeValueConstraint(versionConstraint);
			}
			if (result == null) {
				result = caseConstraint(versionConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(versionConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ConstraintPackage.XOR_CONSTRAINT: {
			XorConstraint xorConstraint = (XorConstraint) theEObject;
			Object result = caseXorConstraint(xorConstraint);
			if (result == null) {
				result = caseBooleanOperator(xorConstraint);
			}
			if (result == null) {
				result = caseConstraint(xorConstraint);
			}
			if (result == null) {
				result = caseDeployModelObject(xorConstraint);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAndConstraint(AndConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Communication Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Communication Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseApplicationCommunicationConstraint(ApplicationCommunicationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Communication Protocol Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Communication Protocol Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseApplicationCommunicationProtocolConstraint(
			ApplicationCommunicationProtocolConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Capacity Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Capacity Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeCapacityConstraint(AttributeCapacityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Defined Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Defined Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeDefinedConstraint(AttributeDefinedConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Propagation Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Propagation Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributePropagationConstraint(AttributePropagationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeValueConstraint(AttributeValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Communication Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Communication Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBaseCommunicationConstraint(BaseCommunicationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Operator</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanOperator(BooleanOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capacity Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capacity Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapacityConstraint(CapacityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collocation Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collocation Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCollocationConstraint(CollocationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Bandwidth Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Bandwidth Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationBandwidthConstraint(CommunicationBandwidthConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Child Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Child Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationChildConstraint(CommunicationChildConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Cost Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Cost Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationCostConstraint(CommunicationCostConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Port Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Port Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationPortConstraint(CommunicationPortConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Redundancy Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Redundancy Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationRedundancyConstraint(CommunicationRedundancyConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Type Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Type Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCommunicationTypeConstraint(CommunicationTypeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Root</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraintRoot(ConstraintRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferred Hosting Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferred Hosting Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeferredHostingConstraint(DeferredHostingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnumerationConstraint(EnumerationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equals Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equals Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEqualsConstraint(EqualsConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exclusion Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exclusion Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExclusionConstraint(ExclusionConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group Cardinality Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group Cardinality Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGroupCardinalityConstraint(GroupCardinalityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Cardinality Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Cardinality Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMemberCardinalityConstraint(MemberCardinalityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Network Communication Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Network Communication Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNetworkCommunicationConstraint(NetworkCommunicationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNotConstraint(NotConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrConstraint(OrConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Palette Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Palette Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePaletteConstraint(PaletteConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Identifier Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Identifier Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseProductIdentifierConstraint(ProductIdentifierConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRangeConstraint(RangeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realization Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realization Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRealizationConstraint(RealizationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Value</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSingleValue(SingleValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stereotype Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stereotype Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStereotypeConstraint(StereotypeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStructuralConstraint(StructuralConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synchronous Communication Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synchronous Communication Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSynchronousCommunicationConstraint(SynchronousCommunicationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transmission Delay Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transmission Delay Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransmissionDelayConstraint(TransmissionDelayConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTypeConstraint(TypeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVersionConstraint(VersionConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xor Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xor Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseXorConstraint(XorConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *           the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ConstraintSwitch
