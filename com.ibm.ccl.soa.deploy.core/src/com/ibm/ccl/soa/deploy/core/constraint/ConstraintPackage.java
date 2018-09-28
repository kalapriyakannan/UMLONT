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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The constraint model for SOA Deploy.
 * 
 * 
 * Constraints the number of groups (incoming member links).
 * 
 * 
 * Constraints the number of members (outgoing member links).
 * 
 * 
 * The core model for SOA Deploy. A {@link Topology} contains {@link Unit}s. Units contain
 * {@Capability}s, {@Requirement}s, and {@UnitLink}s. Extension domains are encouraged to extend
 * Unit and Capability but not Topology, Requirement, or UnitLink.
 * 
 * 
 * An object that can be part of a deployable module. See {@link FileArtifact}.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "constraint"; //$NON-NLS-1$

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/core/constraint/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "constraint"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ConstraintPackage eINSTANCE = com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.BooleanOperatorImpl <em>Boolean Operator</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.BooleanOperatorImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getBooleanOperator()
	 * @generated
	 */
	int BOOLEAN_OPERATOR = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Boolean Operator</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OPERATOR_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AndConstraintImpl <em>And Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AndConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAndConstraint()
	 * @generated
	 */
	int AND_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__ANNOTATIONS = BOOLEAN_OPERATOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__ATTRIBUTE_META_DATA = BOOLEAN_OPERATOR__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__EXTENDED_ATTRIBUTES = BOOLEAN_OPERATOR__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__ARTIFACT_GROUP = BOOLEAN_OPERATOR__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__ARTIFACTS = BOOLEAN_OPERATOR__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__CONSTRAINT_GROUP = BOOLEAN_OPERATOR__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__CONSTRAINTS = BOOLEAN_OPERATOR__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__DESCRIPTION = BOOLEAN_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__DISPLAY_NAME = BOOLEAN_OPERATOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__MUTABLE = BOOLEAN_OPERATOR__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT__NAME = BOOLEAN_OPERATOR__NAME;

	/**
	 * The number of structural features of the '<em>And Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_CONSTRAINT_FEATURE_COUNT = BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.BaseCommunicationConstraintImpl <em>Base Communication Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.BaseCommunicationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getBaseCommunicationConstraint()
	 * @generated
	 */
	int BASE_COMMUNICATION_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Respect Link Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Base Communication Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_COMMUNICATION_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationConstraintImpl <em>Application Communication Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getApplicationCommunicationConstraint()
	 * @generated
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__ANNOTATIONS = BASE_COMMUNICATION_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA = BASE_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES = BASE_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP = BASE_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__ARTIFACTS = BASE_COMMUNICATION_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP = BASE_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__CONSTRAINTS = BASE_COMMUNICATION_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__DESCRIPTION = BASE_COMMUNICATION_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__DISPLAY_NAME = BASE_COMMUNICATION_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__MUTABLE = BASE_COMMUNICATION_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__NAME = BASE_COMMUNICATION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Respect Link Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION = BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION;

	/**
	 * The number of structural features of the '<em>Application Communication Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_CONSTRAINT_FEATURE_COUNT = BASE_COMMUNICATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationChildConstraintImpl <em>Communication Child Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationChildConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationChildConstraint()
	 * @generated
	 */
	int COMMUNICATION_CHILD_CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Communication Child Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationProtocolConstraintImpl <em>Application Communication Protocol Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationProtocolConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getApplicationCommunicationProtocolConstraint()
	 * @generated
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Application Layer Protocol</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Application Communication Protocol Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeValueConstraintImpl <em>Attribute Value Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeValueConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributeValueConstraint()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Value Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeCapacityConstraintImpl <em>Attribute Capacity Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeCapacityConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributeCapacityConstraint()
	 * @generated
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Exclusive</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Capacity Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CAPACITY_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeDefinedConstraintImpl <em>Attribute Defined Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeDefinedConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributeDefinedConstraint()
	 * @generated
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The number of structural features of the '<em>Attribute Defined Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINED_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl <em>Attribute Propagation Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributePropagationConstraint()
	 * @generated
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Respect Link Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Attribute Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Object URI</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI = CorePackage.CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Attribute Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME = CorePackage.CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Object URI</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI = CorePackage.CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Attribute Propagation Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPAGATION_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CapacityConstraintImpl <em>Capacity Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CapacityConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCapacityConstraint()
	 * @generated
	 */
	int CAPACITY_CONSTRAINT = 9;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.StructuralConstraintImpl <em>Structural Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.StructuralConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getStructuralConstraint()
	 * @generated
	 */
	int STRUCTURAL_CONSTRAINT = 33;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CollocationConstraintImpl <em>Collocation Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CollocationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCollocationConstraint()
	 * @generated
	 */
	int COLLOCATION_CONSTRAINT = 10;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationBandwidthConstraintImpl <em>Communication Bandwidth Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationBandwidthConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationBandwidthConstraint()
	 * @generated
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT = 11;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationCostConstraintImpl <em>Communication Cost Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationCostConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationCostConstraint()
	 * @generated
	 */
	int COMMUNICATION_COST_CONSTRAINT = 13;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationPortConstraintImpl <em>Communication Port Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationPortConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationPortConstraint()
	 * @generated
	 */
	int COMMUNICATION_PORT_CONSTRAINT = 14;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationRedundancyConstraintImpl <em>Communication Redundancy Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationRedundancyConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationRedundancyConstraint()
	 * @generated
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT = 15;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationTypeConstraintImpl <em>Communication Type Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationTypeConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationTypeConstraint()
	 * @generated
	 */
	int COMMUNICATION_TYPE_CONSTRAINT = 16;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl <em>Root</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getConstraintRoot()
	 * @generated
	 */
	int CONSTRAINT_ROOT = 17;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.DeferredHostingConstraintImpl <em>Deferred Hosting Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.DeferredHostingConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getDeferredHostingConstraint()
	 * @generated
	 */
	int DEFERRED_HOSTING_CONSTRAINT = 18;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.EnumerationConstraintImpl <em>Enumeration Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.EnumerationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getEnumerationConstraint()
	 * @generated
	 */
	int ENUMERATION_CONSTRAINT = 19;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.EqualsConstraintImpl <em>Equals Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.EqualsConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getEqualsConstraint()
	 * @generated
	 */
	int EQUALS_CONSTRAINT = 20;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ExclusionConstraintImpl <em>Exclusion Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ExclusionConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getExclusionConstraint()
	 * @generated
	 */
	int EXCLUSION_CONSTRAINT = 21;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.GroupCardinalityConstraintImpl <em>Group Cardinality Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.GroupCardinalityConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getGroupCardinalityConstraint()
	 * @generated
	 */
	int GROUP_CARDINALITY_CONSTRAINT = 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.MemberCardinalityConstraintImpl <em>Member Cardinality Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.MemberCardinalityConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getMemberCardinalityConstraint()
	 * @generated
	 */
	int MEMBER_CARDINALITY_CONSTRAINT = 23;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.NetworkCommunicationConstraintImpl <em>Network Communication Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.NetworkCommunicationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getNetworkCommunicationConstraint()
	 * @generated
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT = 24;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.NotConstraintImpl <em>Not Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.NotConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getNotConstraint()
	 * @generated
	 */
	int NOT_CONSTRAINT = 25;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.OrConstraintImpl <em>Or Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.OrConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getOrConstraint()
	 * @generated
	 */
	int OR_CONSTRAINT = 26;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.PaletteConstraintImpl <em>Palette Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.PaletteConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getPaletteConstraint()
	 * @generated
	 */
	int PALETTE_CONSTRAINT = 27;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ProductIdentifierConstraintImpl <em>Product Identifier Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ProductIdentifierConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getProductIdentifierConstraint()
	 * @generated
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT = 28;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl <em>Range Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getRangeConstraint()
	 * @generated
	 */
	int RANGE_CONSTRAINT = 29;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RealizationConstraintImpl <em>Realization Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.RealizationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getRealizationConstraint()
	 * @generated
	 */
	int REALIZATION_CONSTRAINT = 30;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SingleValueImpl <em>Single Value</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.SingleValueImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getSingleValue()
	 * @generated
	 */
	int SINGLE_VALUE = 31;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SynchronousCommunicationConstraintImpl <em>Synchronous Communication Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.SynchronousCommunicationConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getSynchronousCommunicationConstraint()
	 * @generated
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT = 34;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.TransmissionDelayConstraintImpl <em>Transmission Delay Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.TransmissionDelayConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getTransmissionDelayConstraint()
	 * @generated
	 */
	int TRANSMISSION_DELAY_CONSTRAINT = 35;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.TypeConstraintImpl <em>Type Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.TypeConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getTypeConstraint()
	 * @generated
	 */
	int TYPE_CONSTRAINT = 36;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Dmo Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT__DMO_TYPE = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__ANNOTATIONS = TYPE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__ATTRIBUTE_META_DATA = TYPE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__EXTENDED_ATTRIBUTES = TYPE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__ARTIFACT_GROUP = TYPE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__ARTIFACTS = TYPE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__CONSTRAINT_GROUP = TYPE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__CONSTRAINTS = TYPE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__DESCRIPTION = TYPE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__DISPLAY_NAME = TYPE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__MUTABLE = TYPE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__NAME = TYPE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Dmo Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT__DMO_TYPE = TYPE_CONSTRAINT__DMO_TYPE;

	/**
	 * The number of structural features of the '<em>Capacity Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAPACITY_CONSTRAINT_FEATURE_COUNT = TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Structural Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__ANNOTATIONS = STRUCTURAL_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__ATTRIBUTE_META_DATA = STRUCTURAL_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__EXTENDED_ATTRIBUTES = STRUCTURAL_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__ARTIFACT_GROUP = STRUCTURAL_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__ARTIFACTS = STRUCTURAL_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__CONSTRAINT_GROUP = STRUCTURAL_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__CONSTRAINTS = STRUCTURAL_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__DESCRIPTION = STRUCTURAL_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__DISPLAY_NAME = STRUCTURAL_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__MUTABLE = STRUCTURAL_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__NAME = STRUCTURAL_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Type</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__CAPABILITY_TYPE = STRUCTURAL_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT__TYPE = STRUCTURAL_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collocation Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLOCATION_CONSTRAINT_FEATURE_COUNT = STRUCTURAL_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Bandwidth</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Bandwidth Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_BANDWIDTH_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT__COST = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Cost Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_COST_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Is Target</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__IS_TARGET = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT__PORT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Communication Port Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_PORT_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Redundancy</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Redundancy Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_REDUNDANCY_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT__TYPE = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication Type Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_TYPE_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Constraint And</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_AND = 3;

	/**
	 * The feature id for the '<em><b>Constraint Applicationcommunication</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION = 4;

	/**
	 * The feature id for the '<em><b>Constraint Applicationprotocol</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL = 5;

	/**
	 * The feature id for the '<em><b>Constraint Attrdef</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF = 6;

	/**
	 * The feature id for the '<em><b>Constraint Attribute Propagation</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION = 7;

	/**
	 * The feature id for the '<em><b>Constraint Basecommunication</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION = 8;

	/**
	 * The feature id for the '<em><b>Constraint Capacity</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_CAPACITY = 9;

	/**
	 * The feature id for the '<em><b>Constraint Capacity Restriction</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION = 10;

	/**
	 * The feature id for the '<em><b>Constraint Collocation</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION = 11;

	/**
	 * The feature id for the '<em><b>Constraint Communicationbandwidth</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH = 12;

	/**
	 * The feature id for the '<em><b>Constraint Communicationcost</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST = 13;

	/**
	 * The feature id for the '<em><b>Constraint Communicationport</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT = 14;

	/**
	 * The feature id for the '<em><b>Constraint Communicationredundancy</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY = 15;

	/**
	 * The feature id for the '<em><b>Constraint Communicationtype</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE = 16;

	/**
	 * The feature id for the '<em><b>Constraint Deferred Hosting</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING = 17;

	/**
	 * The feature id for the '<em><b>Constraint Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION = 18;

	/**
	 * The feature id for the '<em><b>Constraint Equals</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_EQUALS = 19;

	/**
	 * The feature id for the '<em><b>Constraint Exclusion</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION = 20;

	/**
	 * The feature id for the '<em><b>Constraint Group Cardinality</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY = 21;

	/**
	 * The feature id for the '<em><b>Constraint Member Cardinality</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY = 22;

	/**
	 * The feature id for the '<em><b>Constraint Networkcommunication</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION = 23;

	/**
	 * The feature id for the '<em><b>Constraint Not</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_NOT = 24;

	/**
	 * The feature id for the '<em><b>Constraint Or</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_OR = 25;

	/**
	 * The feature id for the '<em><b>Constraint Palette</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_PALETTE = 26;

	/**
	 * The feature id for the '<em><b>Constraint Product Identifier</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER = 27;

	/**
	 * The feature id for the '<em><b>Constraint Range</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_RANGE = 28;

	/**
	 * The feature id for the '<em><b>Constraint Realization</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_REALIZATION = 29;

	/**
	 * The feature id for the '<em><b>Constraint Stereotype</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE = 30;

	/**
	 * The feature id for the '<em><b>Constraint Synchronouscommunication</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION = 31;

	/**
	 * The feature id for the '<em><b>Constraint Transmissiondelay</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY = 32;

	/**
	 * The feature id for the '<em><b>Constraint Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_TYPE = 33;

	/**
	 * The feature id for the '<em><b>Constraint Update</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_UPDATE = 34;

	/**
	 * The feature id for the '<em><b>Constraint Version</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_VERSION = 35;

	/**
	 * The feature id for the '<em><b>Constraint Xor</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__CONSTRAINT_XOR = 36;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT__VALUE = 37;

	/**
	 * The number of structural features of the '<em>Root</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ROOT_FEATURE_COUNT = 38;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__ANNOTATIONS = STRUCTURAL_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__ATTRIBUTE_META_DATA = STRUCTURAL_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__EXTENDED_ATTRIBUTES = STRUCTURAL_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__ARTIFACT_GROUP = STRUCTURAL_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__ARTIFACTS = STRUCTURAL_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__CONSTRAINT_GROUP = STRUCTURAL_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__CONSTRAINTS = STRUCTURAL_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__DESCRIPTION = STRUCTURAL_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__DISPLAY_NAME = STRUCTURAL_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__MUTABLE = STRUCTURAL_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT__NAME = STRUCTURAL_CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Deferred Hosting Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFERRED_HOSTING_CONSTRAINT_FEATURE_COUNT = STRUCTURAL_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT__VALUES = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT__VALUE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Equals Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EQUALS_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT__VALUES = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exclusion Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__MAX_VALUE = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT__MIN_VALUE = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group Cardinality Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Member Cardinality Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MEMBER_CARDINALITY_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__ANNOTATIONS = BASE_COMMUNICATION_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA = BASE_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES = BASE_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP = BASE_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__ARTIFACTS = BASE_COMMUNICATION_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP = BASE_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__CONSTRAINTS = BASE_COMMUNICATION_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__DESCRIPTION = BASE_COMMUNICATION_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__DISPLAY_NAME = BASE_COMMUNICATION_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__MUTABLE = BASE_COMMUNICATION_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__NAME = BASE_COMMUNICATION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Respect Link Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION = BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION;

	/**
	 * The number of structural features of the '<em>Network Communication Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NETWORK_COMMUNICATION_CONSTRAINT_FEATURE_COUNT = BASE_COMMUNICATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__ANNOTATIONS = BOOLEAN_OPERATOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__ATTRIBUTE_META_DATA = BOOLEAN_OPERATOR__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__EXTENDED_ATTRIBUTES = BOOLEAN_OPERATOR__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__ARTIFACT_GROUP = BOOLEAN_OPERATOR__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__ARTIFACTS = BOOLEAN_OPERATOR__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__CONSTRAINT_GROUP = BOOLEAN_OPERATOR__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__CONSTRAINTS = BOOLEAN_OPERATOR__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__DESCRIPTION = BOOLEAN_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__DISPLAY_NAME = BOOLEAN_OPERATOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__MUTABLE = BOOLEAN_OPERATOR__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT__NAME = BOOLEAN_OPERATOR__NAME;

	/**
	 * The number of structural features of the '<em>Not Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_CONSTRAINT_FEATURE_COUNT = BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__ANNOTATIONS = BOOLEAN_OPERATOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__ATTRIBUTE_META_DATA = BOOLEAN_OPERATOR__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__EXTENDED_ATTRIBUTES = BOOLEAN_OPERATOR__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__ARTIFACT_GROUP = BOOLEAN_OPERATOR__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__ARTIFACTS = BOOLEAN_OPERATOR__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__CONSTRAINT_GROUP = BOOLEAN_OPERATOR__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__CONSTRAINTS = BOOLEAN_OPERATOR__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__DESCRIPTION = BOOLEAN_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__DISPLAY_NAME = BOOLEAN_OPERATOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__MUTABLE = BOOLEAN_OPERATOR__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT__NAME = BOOLEAN_OPERATOR__NAME;

	/**
	 * The number of structural features of the '<em>Or Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_CONSTRAINT_FEATURE_COUNT = BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Resource Type Id</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT__RESOURCE_TYPE_ID = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Palette Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Product Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Product Identifier Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRODUCT_IDENTIFIER_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__MAX_VALUE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Value Inclusive</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__MIN_VALUE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min Value Inclusive</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Range Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGE_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Realization Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Single Value</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.StereotypeConstraintImpl <em>Stereotype Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.StereotypeConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getStereotypeConstraint()
	 * @generated
	 */
	int STEREOTYPE_CONSTRAINT = 32;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT__INCLUDES = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stereotype Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Synchronous</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Synchronous Communication Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNCHRONOUS_COMMUNICATION_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__ANNOTATIONS = COMMUNICATION_CHILD_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__ATTRIBUTE_META_DATA = COMMUNICATION_CHILD_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__EXTENDED_ATTRIBUTES = COMMUNICATION_CHILD_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__ARTIFACT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__ARTIFACTS = COMMUNICATION_CHILD_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__CONSTRAINT_GROUP = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__CONSTRAINTS = COMMUNICATION_CHILD_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__DESCRIPTION = COMMUNICATION_CHILD_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__DISPLAY_NAME = COMMUNICATION_CHILD_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__MUTABLE = COMMUNICATION_CHILD_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__NAME = COMMUNICATION_CHILD_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT__DELAY = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transmission Delay Constraint</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSMISSION_DELAY_CONSTRAINT_FEATURE_COUNT = COMMUNICATION_CHILD_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.UpdateConstraintImpl <em>Update Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.UpdateConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getUpdateConstraint()
	 * @generated
	 */
	int UPDATE_CONSTRAINT = 37;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Update Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UPDATE_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.VersionConstraintImpl <em>Version Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.VersionConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getVersionConstraint()
	 * @generated
	 */
	int VERSION_CONSTRAINT = 38;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__ANNOTATIONS = ATTRIBUTE_VALUE_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__ATTRIBUTE_META_DATA = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__EXTENDED_ATTRIBUTES = ATTRIBUTE_VALUE_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__ARTIFACT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__ARTIFACTS = ATTRIBUTE_VALUE_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__CONSTRAINT_GROUP = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__CONSTRAINTS = ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__DESCRIPTION = ATTRIBUTE_VALUE_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__DISPLAY_NAME = ATTRIBUTE_VALUE_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__MUTABLE = ATTRIBUTE_VALUE_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__NAME = ATTRIBUTE_VALUE_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__ATTRIBUTE_NAME = ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT__VALUE = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Version Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_CONSTRAINT_FEATURE_COUNT = ATTRIBUTE_VALUE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.XorConstraintImpl <em>Xor Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.XorConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getXorConstraint()
	 * @generated
	 */
	int XOR_CONSTRAINT = 39;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__ANNOTATIONS = BOOLEAN_OPERATOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__ATTRIBUTE_META_DATA = BOOLEAN_OPERATOR__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__EXTENDED_ATTRIBUTES = BOOLEAN_OPERATOR__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__ARTIFACT_GROUP = BOOLEAN_OPERATOR__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__ARTIFACTS = BOOLEAN_OPERATOR__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__CONSTRAINT_GROUP = BOOLEAN_OPERATOR__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__CONSTRAINTS = BOOLEAN_OPERATOR__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__DESCRIPTION = BOOLEAN_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__DISPLAY_NAME = BOOLEAN_OPERATOR__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__MUTABLE = BOOLEAN_OPERATOR__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT__NAME = BOOLEAN_OPERATOR__NAME;

	/**
	 * The number of structural features of the '<em>Xor Constraint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int XOR_CONSTRAINT_FEATURE_COUNT = BOOLEAN_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes <em>Collocation Constraint Types</em>}'
	 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCollocationConstraintTypes()
	 * @generated
	 */
	int COLLOCATION_CONSTRAINT_TYPES = 40;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes <em>Communication Type Types</em>}'
	 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationTypeTypes()
	 * @generated
	 */
	int COMMUNICATION_TYPE_TYPES = 41;

	/**
	 * The meta object id for the '<em>Collocation Constraint Types Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCollocationConstraintTypesObject()
	 * @generated
	 */
	int COLLOCATION_CONSTRAINT_TYPES_OBJECT = 42;

	/**
	 * The meta object id for the '<em>Communication Type Types Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
	 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationTypeTypesObject()
	 * @generated
	 */
	int COMMUNICATION_TYPE_TYPES_OBJECT = 43;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.AndConstraint <em>And Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>And Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AndConstraint
	 * @generated
	 */
	EClass getAndConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint <em>Application Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Application Communication Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint
	 * @generated
	 */
	EClass getApplicationCommunicationConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint <em>Application Communication Protocol Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Application Communication Protocol Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint
	 * @generated
	 */
	EClass getApplicationCommunicationProtocolConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint#getApplicationLayerProtocol <em>Application Layer Protocol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Application Layer Protocol</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint#getApplicationLayerProtocol()
	 * @see #getApplicationCommunicationProtocolConstraint()
	 * @generated
	 */
	EAttribute getApplicationCommunicationProtocolConstraint_ApplicationLayerProtocol();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint <em>Attribute Capacity Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Capacity Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint
	 * @generated
	 */
	EClass getAttributeCapacityConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#isExclusive <em>Exclusive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exclusive</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#isExclusive()
	 * @see #getAttributeCapacityConstraint()
	 * @generated
	 */
	EAttribute getAttributeCapacityConstraint_Exclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeCapacityConstraint#getValue()
	 * @see #getAttributeCapacityConstraint()
	 * @generated
	 */
	EAttribute getAttributeCapacityConstraint_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint <em>Attribute Defined Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Defined Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeDefinedConstraint
	 * @generated
	 */
	EClass getAttributeDefinedConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint <em>Attribute Propagation Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Propagation Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint
	 * @generated
	 */
	EClass getAttributePropagationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Respect Link Direction</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#isRespectLinkDirection()
	 * @see #getAttributePropagationConstraint()
	 * @generated
	 */
	EAttribute getAttributePropagationConstraint_RespectLinkDirection();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceAttributeName <em>Source Attribute Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source Attribute Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceAttributeName()
	 * @see #getAttributePropagationConstraint()
	 * @generated
	 */
	EAttribute getAttributePropagationConstraint_SourceAttributeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceObjectURI <em>Source Object URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source Object URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getSourceObjectURI()
	 * @see #getAttributePropagationConstraint()
	 * @generated
	 */
	EAttribute getAttributePropagationConstraint_SourceObjectURI();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetAttributeName <em>Target Attribute Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Target Attribute Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetAttributeName()
	 * @see #getAttributePropagationConstraint()
	 * @generated
	 */
	EAttribute getAttributePropagationConstraint_TargetAttributeName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetObjectURI <em>Target Object URI</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Target Object URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint#getTargetObjectURI()
	 * @see #getAttributePropagationConstraint()
	 * @generated
	 */
	EAttribute getAttributePropagationConstraint_TargetObjectURI();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint <em>Attribute Value Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Attribute Value Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint
	 * @generated
	 */
	EClass getAttributeValueConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint#getAttributeName()
	 * @see #getAttributeValueConstraint()
	 * @generated
	 */
	EAttribute getAttributeValueConstraint_AttributeName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint <em>Base Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Base Communication Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint
	 * @generated
	 */
	EClass getBaseCommunicationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint#isRespectLinkDirection <em>Respect Link Direction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Respect Link Direction</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint#isRespectLinkDirection()
	 * @see #getBaseCommunicationConstraint()
	 * @generated
	 */
	EAttribute getBaseCommunicationConstraint_RespectLinkDirection();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator <em>Boolean Operator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Boolean Operator</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator
	 * @generated
	 */
	EClass getBooleanOperator();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint <em>Capacity Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Capacity Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint
	 * @generated
	 */
	EClass getCapacityConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint <em>Collocation Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collocation Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint
	 * @generated
	 */
	EClass getCollocationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getCapabilityType <em>Capability Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Capability Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getCapabilityType()
	 * @see #getCollocationConstraint()
	 * @generated
	 */
	EAttribute getCollocationConstraint_CapabilityType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint#getType()
	 * @see #getCollocationConstraint()
	 * @generated
	 */
	EAttribute getCollocationConstraint_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint <em>Communication Bandwidth Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Bandwidth Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint
	 * @generated
	 */
	EClass getCommunicationBandwidthConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint#getBandwidth <em>Bandwidth</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bandwidth</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationBandwidthConstraint#getBandwidth()
	 * @see #getCommunicationBandwidthConstraint()
	 * @generated
	 */
	EAttribute getCommunicationBandwidthConstraint_Bandwidth();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint <em>Communication Child Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Child Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationChildConstraint
	 * @generated
	 */
	EClass getCommunicationChildConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint <em>Communication Cost Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Cost Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint
	 * @generated
	 */
	EClass getCommunicationCostConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationCostConstraint#getCost()
	 * @see #getCommunicationCostConstraint()
	 * @generated
	 */
	EAttribute getCommunicationCostConstraint_Cost();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint <em>Communication Port Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Port Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint
	 * @generated
	 */
	EClass getCommunicationPortConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#isIsTarget <em>Is Target</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Target</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#isIsTarget()
	 * @see #getCommunicationPortConstraint()
	 * @generated
	 */
	EAttribute getCommunicationPortConstraint_IsTarget();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationPortConstraint#getPort()
	 * @see #getCommunicationPortConstraint()
	 * @generated
	 */
	EAttribute getCommunicationPortConstraint_Port();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint <em>Communication Redundancy Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Redundancy Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint
	 * @generated
	 */
	EClass getCommunicationRedundancyConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint#getRedundancy <em>Redundancy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Redundancy</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationRedundancyConstraint#getRedundancy()
	 * @see #getCommunicationRedundancyConstraint()
	 * @generated
	 */
	EAttribute getCommunicationRedundancyConstraint_Redundancy();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint <em>Communication Type Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Communication Type Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint
	 * @generated
	 */
	EClass getCommunicationTypeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeConstraint#getType()
	 * @see #getCommunicationTypeConstraint()
	 * @generated
	 */
	EAttribute getCommunicationTypeConstraint_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot <em>Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot
	 * @generated
	 */
	EClass getConstraintRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getMixed()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EAttribute getConstraintRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getXMLNSPrefixMap()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getXSISchemaLocation()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAnd <em>Constraint And</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint And</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAnd()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintAnd();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationcommunication <em>Constraint Applicationcommunication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Applicationcommunication</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationcommunication()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintApplicationcommunication();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationprotocol <em>Constraint Applicationprotocol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Applicationprotocol</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintApplicationprotocol()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintApplicationprotocol();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttrdef <em>Constraint Attrdef</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Attrdef</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttrdef()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintAttrdef();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttributePropagation <em>Constraint Attribute Propagation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Attribute Propagation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintAttributePropagation()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintAttributePropagation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintBasecommunication <em>Constraint Basecommunication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Basecommunication</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintBasecommunication()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintBasecommunication();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacity <em>Constraint Capacity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Capacity</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacity()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCapacity();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacityRestriction <em>Constraint Capacity Restriction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Capacity Restriction</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCapacityRestriction()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCapacityRestriction();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCollocation <em>Constraint Collocation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Collocation</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCollocation()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCollocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationbandwidth <em>Constraint Communicationbandwidth</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Communicationbandwidth</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationbandwidth()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCommunicationbandwidth();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationcost <em>Constraint Communicationcost</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Communicationcost</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationcost()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCommunicationcost();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationport <em>Constraint Communicationport</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Communicationport</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationport()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCommunicationport();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationredundancy <em>Constraint Communicationredundancy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Communicationredundancy</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationredundancy()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCommunicationredundancy();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationtype <em>Constraint Communicationtype</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Communicationtype</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintCommunicationtype()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintCommunicationtype();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintDeferredHosting <em>Constraint Deferred Hosting</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Deferred Hosting</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintDeferredHosting()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintDeferredHosting();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEnumeration <em>Constraint Enumeration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Enumeration</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEnumeration()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintEnumeration();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEquals <em>Constraint Equals</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Equals</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintEquals()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintEquals();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintExclusion <em>Constraint Exclusion</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Exclusion</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintExclusion()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintExclusion();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintGroupCardinality <em>Constraint Group Cardinality</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Group Cardinality</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintGroupCardinality()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintGroupCardinality();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintMemberCardinality <em>Constraint Member Cardinality</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Member Cardinality</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintMemberCardinality()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintMemberCardinality();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNetworkcommunication <em>Constraint Networkcommunication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Networkcommunication</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNetworkcommunication()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintNetworkcommunication();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNot <em>Constraint Not</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Not</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintNot()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintNot();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintOr <em>Constraint Or</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Or</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintOr()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintOr();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintPalette <em>Constraint Palette</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Palette</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintPalette()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintPalette();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintProductIdentifier <em>Constraint Product Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Product Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintProductIdentifier()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintProductIdentifier();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRange <em>Constraint Range</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Range</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRange()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintRange();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRealization <em>Constraint Realization</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Realization</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintRealization()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintRealization();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintStereotype <em>Constraint Stereotype</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Stereotype</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintStereotype()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintStereotype();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintSynchronouscommunication <em>Constraint Synchronouscommunication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Synchronouscommunication</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintSynchronouscommunication()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintSynchronouscommunication();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintTransmissiondelay <em>Constraint Transmissiondelay</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Transmissiondelay</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintTransmissiondelay()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintTransmissiondelay();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintType()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintType();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintUpdate <em>Constraint Update</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Update</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintUpdate()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintUpdate();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintVersion <em>Constraint Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintVersion()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintVersion();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintXor <em>Constraint Xor</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Xor</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getConstraintXor()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_ConstraintXor();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintRoot#getValue()
	 * @see #getConstraintRoot()
	 * @generated
	 */
	EReference getConstraintRoot_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint <em>Deferred Hosting Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Deferred Hosting Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.DeferredHostingConstraint
	 * @generated
	 */
	EClass getDeferredHostingConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint <em>Enumeration Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enumeration Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint
	 * @generated
	 */
	EClass getEnumerationConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint#getValues()
	 * @see #getEnumerationConstraint()
	 * @generated
	 */
	EReference getEnumerationConstraint_Values();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint <em>Equals Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Equals Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint
	 * @generated
	 */
	EClass getEqualsConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint#getValue()
	 * @see #getEqualsConstraint()
	 * @generated
	 */
	EAttribute getEqualsConstraint_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint <em>Exclusion Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Exclusion Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint
	 * @generated
	 */
	EClass getExclusionConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ExclusionConstraint#getValues()
	 * @see #getExclusionConstraint()
	 * @generated
	 */
	EReference getExclusionConstraint_Values();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint <em>Group Cardinality Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Group Cardinality Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint
	 * @generated
	 */
	EClass getGroupCardinalityConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMaxValue()
	 * @see #getGroupCardinalityConstraint()
	 * @generated
	 */
	EAttribute getGroupCardinalityConstraint_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint#getMinValue()
	 * @see #getGroupCardinalityConstraint()
	 * @generated
	 */
	EAttribute getGroupCardinalityConstraint_MinValue();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint <em>Member Cardinality Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Member Cardinality Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint
	 * @generated
	 */
	EClass getMemberCardinalityConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint#getMaxValue()
	 * @see #getMemberCardinalityConstraint()
	 * @generated
	 */
	EAttribute getMemberCardinalityConstraint_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint#getMinValue()
	 * @see #getMemberCardinalityConstraint()
	 * @generated
	 */
	EAttribute getMemberCardinalityConstraint_MinValue();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint <em>Network Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Network Communication Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint
	 * @generated
	 */
	EClass getNetworkCommunicationConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.NotConstraint <em>Not Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Not Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.NotConstraint
	 * @generated
	 */
	EClass getNotConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.OrConstraint <em>Or Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Or Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.OrConstraint
	 * @generated
	 */
	EClass getOrConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint <em>Palette Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Palette Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint
	 * @generated
	 */
	EClass getPaletteConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint#getResourceTypeId <em>Resource Type Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Resource Type Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.PaletteConstraint#getResourceTypeId()
	 * @see #getPaletteConstraint()
	 * @generated
	 */
	EAttribute getPaletteConstraint_ResourceTypeId();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint <em>Product Identifier Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Product Identifier Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint
	 * @generated
	 */
	EClass getProductIdentifierConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint#getProductIdentifier <em>Product Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Product Identifier</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.ProductIdentifierConstraint#getProductIdentifier()
	 * @see #getProductIdentifierConstraint()
	 * @generated
	 */
	EAttribute getProductIdentifierConstraint_ProductIdentifier();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint <em>Range Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Range Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint
	 * @generated
	 */
	EClass getRangeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMaxValue()
	 * @see #getRangeConstraint()
	 * @generated
	 */
	EAttribute getRangeConstraint_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMaxValueInclusive <em>Max Value Inclusive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Value Inclusive</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMaxValueInclusive()
	 * @see #getRangeConstraint()
	 * @generated
	 */
	EAttribute getRangeConstraint_MaxValueInclusive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#getMinValue()
	 * @see #getRangeConstraint()
	 * @generated
	 */
	EAttribute getRangeConstraint_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMinValueInclusive <em>Min Value Inclusive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min Value Inclusive</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint#isMinValueInclusive()
	 * @see #getRangeConstraint()
	 * @generated
	 */
	EAttribute getRangeConstraint_MinValueInclusive();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.RealizationConstraint <em>Realization Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Realization Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.RealizationConstraint
	 * @generated
	 */
	EClass getRealizationConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue <em>Single Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Single Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SingleValue
	 * @generated
	 */
	EClass getSingleValue();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getDescription()
	 * @see #getSingleValue()
	 * @generated
	 */
	EAttribute getSingleValue_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SingleValue#getValue()
	 * @see #getSingleValue()
	 * @generated
	 */
	EAttribute getSingleValue_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint <em>Stereotype Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Stereotype Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint
	 * @generated
	 */
	EClass getStereotypeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Includes</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.StereotypeConstraint#getIncludes()
	 * @see #getStereotypeConstraint()
	 * @generated
	 */
	EAttribute getStereotypeConstraint_Includes();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.StructuralConstraint <em>Structural Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Structural Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.StructuralConstraint
	 * @generated
	 */
	EClass getStructuralConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint <em>Synchronous Communication Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Synchronous Communication Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint
	 * @generated
	 */
	EClass getSynchronousCommunicationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint#isSynchronous <em>Synchronous</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Synchronous</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.SynchronousCommunicationConstraint#isSynchronous()
	 * @see #getSynchronousCommunicationConstraint()
	 * @generated
	 */
	EAttribute getSynchronousCommunicationConstraint_Synchronous();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint <em>Transmission Delay Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Transmission Delay Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint
	 * @generated
	 */
	EClass getTransmissionDelayConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.TransmissionDelayConstraint#getDelay()
	 * @see #getTransmissionDelayConstraint()
	 * @generated
	 */
	EAttribute getTransmissionDelayConstraint_Delay();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint <em>Type Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint
	 * @generated
	 */
	EClass getTypeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint#getDmoType <em>Dmo Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Dmo Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint#getDmoType()
	 * @see #getTypeConstraint()
	 * @generated
	 */
	EAttribute getTypeConstraint_DmoType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.UpdateConstraint <em>Update Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Update Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.UpdateConstraint
	 * @generated
	 */
	EClass getUpdateConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint <em>Version Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Version Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint
	 * @generated
	 */
	EClass getVersionConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint#getValue()
	 * @see #getVersionConstraint()
	 * @generated
	 */
	EAttribute getVersionConstraint_Value();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.core.constraint.XorConstraint <em>Xor Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Xor Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.XorConstraint
	 * @generated
	 */
	EClass getXorConstraint();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes <em>Collocation Constraint Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Collocation Constraint Types</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
	 * @generated
	 */
	EEnum getCollocationConstraintTypes();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes <em>Communication Type Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Communication Type Types</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
	 * @generated
	 */
	EEnum getCommunicationTypeTypes();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes <em>Collocation Constraint Types Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Collocation Constraint Types Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes"
	 *        extendedMetaData="name='CollocationConstraintTypes:Object'
	 *        baseType='CollocationConstraintTypes'"
	 * @generated
	 */
	EDataType getCollocationConstraintTypesObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes <em>Communication Type Types Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Communication Type Types Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
	 * @model instanceClass="com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes"
	 *        extendedMetaData="name='CommunicationTypeTypes:Object'
	 *        baseType='CommunicationTypeTypes'"
	 * @generated
	 */
	EDataType getCommunicationTypeTypesObject();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintFactory getConstraintFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AndConstraintImpl <em>And Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AndConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAndConstraint()
		 * @generated
		 */
		EClass AND_CONSTRAINT = eINSTANCE.getAndConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationConstraintImpl <em>Application Communication Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getApplicationCommunicationConstraint()
		 * @generated
		 */
		EClass APPLICATION_COMMUNICATION_CONSTRAINT = eINSTANCE
				.getApplicationCommunicationConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationProtocolConstraintImpl <em>Application Communication Protocol Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ApplicationCommunicationProtocolConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getApplicationCommunicationProtocolConstraint()
		 * @generated
		 */
		EClass APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT = eINSTANCE
				.getApplicationCommunicationProtocolConstraint();

		/**
		 * The meta object literal for the '<em><b>Application Layer Protocol</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute APPLICATION_COMMUNICATION_PROTOCOL_CONSTRAINT__APPLICATION_LAYER_PROTOCOL = eINSTANCE
				.getApplicationCommunicationProtocolConstraint_ApplicationLayerProtocol();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeCapacityConstraintImpl <em>Attribute Capacity Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeCapacityConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributeCapacityConstraint()
		 * @generated
		 */
		EClass ATTRIBUTE_CAPACITY_CONSTRAINT = eINSTANCE.getAttributeCapacityConstraint();

		/**
		 * The meta object literal for the '<em><b>Exclusive</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_CAPACITY_CONSTRAINT__EXCLUSIVE = eINSTANCE
				.getAttributeCapacityConstraint_Exclusive();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_CAPACITY_CONSTRAINT__VALUE = eINSTANCE
				.getAttributeCapacityConstraint_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeDefinedConstraintImpl <em>Attribute Defined Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeDefinedConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributeDefinedConstraint()
		 * @generated
		 */
		EClass ATTRIBUTE_DEFINED_CONSTRAINT = eINSTANCE.getAttributeDefinedConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl <em>Attribute Propagation Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributePropagationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributePropagationConstraint()
		 * @generated
		 */
		EClass ATTRIBUTE_PROPAGATION_CONSTRAINT = eINSTANCE.getAttributePropagationConstraint();

		/**
		 * The meta object literal for the '<em><b>Respect Link Direction</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPAGATION_CONSTRAINT__RESPECT_LINK_DIRECTION = eINSTANCE
				.getAttributePropagationConstraint_RespectLinkDirection();

		/**
		 * The meta object literal for the '<em><b>Source Attribute Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_ATTRIBUTE_NAME = eINSTANCE
				.getAttributePropagationConstraint_SourceAttributeName();

		/**
		 * The meta object literal for the '<em><b>Source Object URI</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPAGATION_CONSTRAINT__SOURCE_OBJECT_URI = eINSTANCE
				.getAttributePropagationConstraint_SourceObjectURI();

		/**
		 * The meta object literal for the '<em><b>Target Attribute Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_ATTRIBUTE_NAME = eINSTANCE
				.getAttributePropagationConstraint_TargetAttributeName();

		/**
		 * The meta object literal for the '<em><b>Target Object URI</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPAGATION_CONSTRAINT__TARGET_OBJECT_URI = eINSTANCE
				.getAttributePropagationConstraint_TargetObjectURI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeValueConstraintImpl <em>Attribute Value Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.AttributeValueConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getAttributeValueConstraint()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_CONSTRAINT = eINSTANCE.getAttributeValueConstraint();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME = eINSTANCE
				.getAttributeValueConstraint_AttributeName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.BaseCommunicationConstraintImpl <em>Base Communication Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.BaseCommunicationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getBaseCommunicationConstraint()
		 * @generated
		 */
		EClass BASE_COMMUNICATION_CONSTRAINT = eINSTANCE.getBaseCommunicationConstraint();

		/**
		 * The meta object literal for the '<em><b>Respect Link Direction</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BASE_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION = eINSTANCE
				.getBaseCommunicationConstraint_RespectLinkDirection();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.BooleanOperatorImpl <em>Boolean Operator</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.BooleanOperatorImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getBooleanOperator()
		 * @generated
		 */
		EClass BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CapacityConstraintImpl <em>Capacity Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CapacityConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCapacityConstraint()
		 * @generated
		 */
		EClass CAPACITY_CONSTRAINT = eINSTANCE.getCapacityConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CollocationConstraintImpl <em>Collocation Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CollocationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCollocationConstraint()
		 * @generated
		 */
		EClass COLLOCATION_CONSTRAINT = eINSTANCE.getCollocationConstraint();

		/**
		 * The meta object literal for the '<em><b>Capability Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLLOCATION_CONSTRAINT__CAPABILITY_TYPE = eINSTANCE
				.getCollocationConstraint_CapabilityType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLLOCATION_CONSTRAINT__TYPE = eINSTANCE.getCollocationConstraint_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationBandwidthConstraintImpl <em>Communication Bandwidth Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationBandwidthConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationBandwidthConstraint()
		 * @generated
		 */
		EClass COMMUNICATION_BANDWIDTH_CONSTRAINT = eINSTANCE.getCommunicationBandwidthConstraint();

		/**
		 * The meta object literal for the '<em><b>Bandwidth</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_BANDWIDTH_CONSTRAINT__BANDWIDTH = eINSTANCE
				.getCommunicationBandwidthConstraint_Bandwidth();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationChildConstraintImpl <em>Communication Child Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationChildConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationChildConstraint()
		 * @generated
		 */
		EClass COMMUNICATION_CHILD_CONSTRAINT = eINSTANCE.getCommunicationChildConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationCostConstraintImpl <em>Communication Cost Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationCostConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationCostConstraint()
		 * @generated
		 */
		EClass COMMUNICATION_COST_CONSTRAINT = eINSTANCE.getCommunicationCostConstraint();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_COST_CONSTRAINT__COST = eINSTANCE
				.getCommunicationCostConstraint_Cost();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationPortConstraintImpl <em>Communication Port Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationPortConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationPortConstraint()
		 * @generated
		 */
		EClass COMMUNICATION_PORT_CONSTRAINT = eINSTANCE.getCommunicationPortConstraint();

		/**
		 * The meta object literal for the '<em><b>Is Target</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_PORT_CONSTRAINT__IS_TARGET = eINSTANCE
				.getCommunicationPortConstraint_IsTarget();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_PORT_CONSTRAINT__PORT = eINSTANCE
				.getCommunicationPortConstraint_Port();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationRedundancyConstraintImpl <em>Communication Redundancy Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationRedundancyConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationRedundancyConstraint()
		 * @generated
		 */
		EClass COMMUNICATION_REDUNDANCY_CONSTRAINT = eINSTANCE.getCommunicationRedundancyConstraint();

		/**
		 * The meta object literal for the '<em><b>Redundancy</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_REDUNDANCY_CONSTRAINT__REDUNDANCY = eINSTANCE
				.getCommunicationRedundancyConstraint_Redundancy();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationTypeConstraintImpl <em>Communication Type Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.CommunicationTypeConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationTypeConstraint()
		 * @generated
		 */
		EClass COMMUNICATION_TYPE_CONSTRAINT = eINSTANCE.getCommunicationTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMUNICATION_TYPE_CONSTRAINT__TYPE = eINSTANCE
				.getCommunicationTypeConstraint_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl <em>Root</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintRootImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getConstraintRoot()
		 * @generated
		 */
		EClass CONSTRAINT_ROOT = eINSTANCE.getConstraintRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONSTRAINT_ROOT__MIXED = eINSTANCE.getConstraintRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getConstraintRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE
				.getConstraintRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Constraint And</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_AND = eINSTANCE.getConstraintRoot_ConstraintAnd();

		/**
		 * The meta object literal for the '<em><b>Constraint Applicationcommunication</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONCOMMUNICATION = eINSTANCE
				.getConstraintRoot_ConstraintApplicationcommunication();

		/**
		 * The meta object literal for the '<em><b>Constraint Applicationprotocol</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_APPLICATIONPROTOCOL = eINSTANCE
				.getConstraintRoot_ConstraintApplicationprotocol();

		/**
		 * The meta object literal for the '<em><b>Constraint Attrdef</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_ATTRDEF = eINSTANCE
				.getConstraintRoot_ConstraintAttrdef();

		/**
		 * The meta object literal for the '<em><b>Constraint Attribute Propagation</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_ATTRIBUTE_PROPAGATION = eINSTANCE
				.getConstraintRoot_ConstraintAttributePropagation();

		/**
		 * The meta object literal for the '<em><b>Constraint Basecommunication</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_BASECOMMUNICATION = eINSTANCE
				.getConstraintRoot_ConstraintBasecommunication();

		/**
		 * The meta object literal for the '<em><b>Constraint Capacity</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_CAPACITY = eINSTANCE
				.getConstraintRoot_ConstraintCapacity();

		/**
		 * The meta object literal for the '<em><b>Constraint Capacity Restriction</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_CAPACITY_RESTRICTION = eINSTANCE
				.getConstraintRoot_ConstraintCapacityRestriction();

		/**
		 * The meta object literal for the '<em><b>Constraint Collocation</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_COLLOCATION = eINSTANCE
				.getConstraintRoot_ConstraintCollocation();

		/**
		 * The meta object literal for the '<em><b>Constraint Communicationbandwidth</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONBANDWIDTH = eINSTANCE
				.getConstraintRoot_ConstraintCommunicationbandwidth();

		/**
		 * The meta object literal for the '<em><b>Constraint Communicationcost</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONCOST = eINSTANCE
				.getConstraintRoot_ConstraintCommunicationcost();

		/**
		 * The meta object literal for the '<em><b>Constraint Communicationport</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONPORT = eINSTANCE
				.getConstraintRoot_ConstraintCommunicationport();

		/**
		 * The meta object literal for the '<em><b>Constraint Communicationredundancy</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONREDUNDANCY = eINSTANCE
				.getConstraintRoot_ConstraintCommunicationredundancy();

		/**
		 * The meta object literal for the '<em><b>Constraint Communicationtype</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_COMMUNICATIONTYPE = eINSTANCE
				.getConstraintRoot_ConstraintCommunicationtype();

		/**
		 * The meta object literal for the '<em><b>Constraint Deferred Hosting</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_DEFERRED_HOSTING = eINSTANCE
				.getConstraintRoot_ConstraintDeferredHosting();

		/**
		 * The meta object literal for the '<em><b>Constraint Enumeration</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_ENUMERATION = eINSTANCE
				.getConstraintRoot_ConstraintEnumeration();

		/**
		 * The meta object literal for the '<em><b>Constraint Equals</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_EQUALS = eINSTANCE
				.getConstraintRoot_ConstraintEquals();

		/**
		 * The meta object literal for the '<em><b>Constraint Exclusion</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_EXCLUSION = eINSTANCE
				.getConstraintRoot_ConstraintExclusion();

		/**
		 * The meta object literal for the '<em><b>Constraint Group Cardinality</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_GROUP_CARDINALITY = eINSTANCE
				.getConstraintRoot_ConstraintGroupCardinality();

		/**
		 * The meta object literal for the '<em><b>Constraint Member Cardinality</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_MEMBER_CARDINALITY = eINSTANCE
				.getConstraintRoot_ConstraintMemberCardinality();

		/**
		 * The meta object literal for the '<em><b>Constraint Networkcommunication</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_NETWORKCOMMUNICATION = eINSTANCE
				.getConstraintRoot_ConstraintNetworkcommunication();

		/**
		 * The meta object literal for the '<em><b>Constraint Not</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_NOT = eINSTANCE.getConstraintRoot_ConstraintNot();

		/**
		 * The meta object literal for the '<em><b>Constraint Or</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_OR = eINSTANCE.getConstraintRoot_ConstraintOr();

		/**
		 * The meta object literal for the '<em><b>Constraint Palette</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_PALETTE = eINSTANCE
				.getConstraintRoot_ConstraintPalette();

		/**
		 * The meta object literal for the '<em><b>Constraint Product Identifier</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_PRODUCT_IDENTIFIER = eINSTANCE
				.getConstraintRoot_ConstraintProductIdentifier();

		/**
		 * The meta object literal for the '<em><b>Constraint Range</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_RANGE = eINSTANCE.getConstraintRoot_ConstraintRange();

		/**
		 * The meta object literal for the '<em><b>Constraint Realization</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_REALIZATION = eINSTANCE
				.getConstraintRoot_ConstraintRealization();

		/**
		 * The meta object literal for the '<em><b>Constraint Stereotype</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_STEREOTYPE = eINSTANCE
				.getConstraintRoot_ConstraintStereotype();

		/**
		 * The meta object literal for the '<em><b>Constraint Synchronouscommunication</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_SYNCHRONOUSCOMMUNICATION = eINSTANCE
				.getConstraintRoot_ConstraintSynchronouscommunication();

		/**
		 * The meta object literal for the '<em><b>Constraint Transmissiondelay</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_TRANSMISSIONDELAY = eINSTANCE
				.getConstraintRoot_ConstraintTransmissiondelay();

		/**
		 * The meta object literal for the '<em><b>Constraint Type</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_TYPE = eINSTANCE.getConstraintRoot_ConstraintType();

		/**
		 * The meta object literal for the '<em><b>Constraint Update</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_UPDATE = eINSTANCE
				.getConstraintRoot_ConstraintUpdate();

		/**
		 * The meta object literal for the '<em><b>Constraint Version</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_VERSION = eINSTANCE
				.getConstraintRoot_ConstraintVersion();

		/**
		 * The meta object literal for the '<em><b>Constraint Xor</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__CONSTRAINT_XOR = eINSTANCE.getConstraintRoot_ConstraintXor();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_ROOT__VALUE = eINSTANCE.getConstraintRoot_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.DeferredHostingConstraintImpl <em>Deferred Hosting Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.DeferredHostingConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getDeferredHostingConstraint()
		 * @generated
		 */
		EClass DEFERRED_HOSTING_CONSTRAINT = eINSTANCE.getDeferredHostingConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.EnumerationConstraintImpl <em>Enumeration Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.EnumerationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getEnumerationConstraint()
		 * @generated
		 */
		EClass ENUMERATION_CONSTRAINT = eINSTANCE.getEnumerationConstraint();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUMERATION_CONSTRAINT__VALUES = eINSTANCE.getEnumerationConstraint_Values();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.EqualsConstraintImpl <em>Equals Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.EqualsConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getEqualsConstraint()
		 * @generated
		 */
		EClass EQUALS_CONSTRAINT = eINSTANCE.getEqualsConstraint();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EQUALS_CONSTRAINT__VALUE = eINSTANCE.getEqualsConstraint_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ExclusionConstraintImpl <em>Exclusion Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ExclusionConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getExclusionConstraint()
		 * @generated
		 */
		EClass EXCLUSION_CONSTRAINT = eINSTANCE.getExclusionConstraint();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXCLUSION_CONSTRAINT__VALUES = eINSTANCE.getExclusionConstraint_Values();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.GroupCardinalityConstraintImpl <em>Group Cardinality Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.GroupCardinalityConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getGroupCardinalityConstraint()
		 * @generated
		 */
		EClass GROUP_CARDINALITY_CONSTRAINT = eINSTANCE.getGroupCardinalityConstraint();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GROUP_CARDINALITY_CONSTRAINT__MAX_VALUE = eINSTANCE
				.getGroupCardinalityConstraint_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GROUP_CARDINALITY_CONSTRAINT__MIN_VALUE = eINSTANCE
				.getGroupCardinalityConstraint_MinValue();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.MemberCardinalityConstraintImpl <em>Member Cardinality Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.MemberCardinalityConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getMemberCardinalityConstraint()
		 * @generated
		 */
		EClass MEMBER_CARDINALITY_CONSTRAINT = eINSTANCE.getMemberCardinalityConstraint();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE = eINSTANCE
				.getMemberCardinalityConstraint_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE = eINSTANCE
				.getMemberCardinalityConstraint_MinValue();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.NetworkCommunicationConstraintImpl <em>Network Communication Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.NetworkCommunicationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getNetworkCommunicationConstraint()
		 * @generated
		 */
		EClass NETWORK_COMMUNICATION_CONSTRAINT = eINSTANCE.getNetworkCommunicationConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.NotConstraintImpl <em>Not Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.NotConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getNotConstraint()
		 * @generated
		 */
		EClass NOT_CONSTRAINT = eINSTANCE.getNotConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.OrConstraintImpl <em>Or Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.OrConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getOrConstraint()
		 * @generated
		 */
		EClass OR_CONSTRAINT = eINSTANCE.getOrConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.PaletteConstraintImpl <em>Palette Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.PaletteConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getPaletteConstraint()
		 * @generated
		 */
		EClass PALETTE_CONSTRAINT = eINSTANCE.getPaletteConstraint();

		/**
		 * The meta object literal for the '<em><b>Resource Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PALETTE_CONSTRAINT__RESOURCE_TYPE_ID = eINSTANCE
				.getPaletteConstraint_ResourceTypeId();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.ProductIdentifierConstraintImpl <em>Product Identifier Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ProductIdentifierConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getProductIdentifierConstraint()
		 * @generated
		 */
		EClass PRODUCT_IDENTIFIER_CONSTRAINT = eINSTANCE.getProductIdentifierConstraint();

		/**
		 * The meta object literal for the '<em><b>Product Identifier</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PRODUCT_IDENTIFIER_CONSTRAINT__PRODUCT_IDENTIFIER = eINSTANCE
				.getProductIdentifierConstraint_ProductIdentifier();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl <em>Range Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.RangeConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getRangeConstraint()
		 * @generated
		 */
		EClass RANGE_CONSTRAINT = eINSTANCE.getRangeConstraint();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGE_CONSTRAINT__MAX_VALUE = eINSTANCE.getRangeConstraint_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Max Value Inclusive</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE = eINSTANCE
				.getRangeConstraint_MaxValueInclusive();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGE_CONSTRAINT__MIN_VALUE = eINSTANCE.getRangeConstraint_MinValue();

		/**
		 * The meta object literal for the '<em><b>Min Value Inclusive</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE = eINSTANCE
				.getRangeConstraint_MinValueInclusive();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.RealizationConstraintImpl <em>Realization Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.RealizationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getRealizationConstraint()
		 * @generated
		 */
		EClass REALIZATION_CONSTRAINT = eINSTANCE.getRealizationConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SingleValueImpl <em>Single Value</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.SingleValueImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getSingleValue()
		 * @generated
		 */
		EClass SINGLE_VALUE = eINSTANCE.getSingleValue();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SINGLE_VALUE__DESCRIPTION = eINSTANCE.getSingleValue_Description();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SINGLE_VALUE__VALUE = eINSTANCE.getSingleValue_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.StereotypeConstraintImpl <em>Stereotype Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.StereotypeConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getStereotypeConstraint()
		 * @generated
		 */
		EClass STEREOTYPE_CONSTRAINT = eINSTANCE.getStereotypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Includes</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPE_CONSTRAINT__INCLUDES = eINSTANCE.getStereotypeConstraint_Includes();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.StructuralConstraintImpl <em>Structural Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.StructuralConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getStructuralConstraint()
		 * @generated
		 */
		EClass STRUCTURAL_CONSTRAINT = eINSTANCE.getStructuralConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.SynchronousCommunicationConstraintImpl <em>Synchronous Communication Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.SynchronousCommunicationConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getSynchronousCommunicationConstraint()
		 * @generated
		 */
		EClass SYNCHRONOUS_COMMUNICATION_CONSTRAINT = eINSTANCE
				.getSynchronousCommunicationConstraint();

		/**
		 * The meta object literal for the '<em><b>Synchronous</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYNCHRONOUS_COMMUNICATION_CONSTRAINT__SYNCHRONOUS = eINSTANCE
				.getSynchronousCommunicationConstraint_Synchronous();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.TransmissionDelayConstraintImpl <em>Transmission Delay Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.TransmissionDelayConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getTransmissionDelayConstraint()
		 * @generated
		 */
		EClass TRANSMISSION_DELAY_CONSTRAINT = eINSTANCE.getTransmissionDelayConstraint();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TRANSMISSION_DELAY_CONSTRAINT__DELAY = eINSTANCE
				.getTransmissionDelayConstraint_Delay();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.TypeConstraintImpl <em>Type Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.TypeConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getTypeConstraint()
		 * @generated
		 */
		EClass TYPE_CONSTRAINT = eINSTANCE.getTypeConstraint();

		/**
		 * The meta object literal for the '<em><b>Dmo Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TYPE_CONSTRAINT__DMO_TYPE = eINSTANCE.getTypeConstraint_DmoType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.VersionConstraintImpl <em>Version Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.VersionConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getVersionConstraint()
		 * @generated
		 */
		EClass VERSION_CONSTRAINT = eINSTANCE.getVersionConstraint();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VERSION_CONSTRAINT__VALUE = eINSTANCE.getVersionConstraint_Value();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.impl.XorConstraintImpl <em>Xor Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.XorConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getXorConstraint()
		 * @generated
		 */
		EClass XOR_CONSTRAINT = eINSTANCE.getXorConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes <em>Collocation Constraint Types</em>}'
		 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCollocationConstraintTypes()
		 * @generated
		 */
		EEnum COLLOCATION_CONSTRAINT_TYPES = eINSTANCE.getCollocationConstraintTypes();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes <em>Communication Type Types</em>}'
		 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationTypeTypes()
		 * @generated
		 */
		EEnum COMMUNICATION_TYPE_TYPES = eINSTANCE.getCommunicationTypeTypes();

		/**
		 * The meta object literal for the '<em>Collocation Constraint Types Object</em>' data
		 * type. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraintTypes
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCollocationConstraintTypesObject()
		 * @generated
		 */
		EDataType COLLOCATION_CONSTRAINT_TYPES_OBJECT = eINSTANCE
				.getCollocationConstraintTypesObject();

		/**
		 * The meta object literal for the '<em>Communication Type Types Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.constraint.CommunicationTypeTypes
		 * @see com.ibm.ccl.soa.deploy.core.constraint.impl.ConstraintPackageImpl#getCommunicationTypeTypesObject()
		 * @generated
		 */
		EDataType COMMUNICATION_TYPE_TYPES_OBJECT = eINSTANCE.getCommunicationTypeTypesObject();

	}

} //ConstraintPackage
