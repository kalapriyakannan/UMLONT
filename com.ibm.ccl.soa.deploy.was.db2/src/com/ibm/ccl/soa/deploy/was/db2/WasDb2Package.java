/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;

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
 * The Topology Definition Model (TDM) defines a core set of concepts to describe Enterprise
 * Architectures from the Software Applications down to the hardware requirements. The model is
 * inherently extensible, allowing technology specific domains to define their own types. At a high
 * level, the model is orgainzed into {@link Topology topologies}, which contain {@link Unit}s. A
 * Unit contain {@link Capability capabilities}, {@Requirement requirements}, and four types of
 * links ({@link DependencyLink  dependency links}, {@link HostingLink  hosting links},
 * {@link ConstraintLink  constraint links}, {@link MemberLink  member links}. In addition, the
 * model defines the notion of {@link Constraint constraints} which can be added to Units or
 * Contraint Links in order to describe requirements on target application or environment.
 * 
 * 
 * An object that can be part of a deployable module. See {@link FileArtifact}.
 * 
 * 
 * The constraint model for SOA Deploy.
 * 
 * 
 * Constraints the number of groups (incoming member links).
 * 
 * 
 * Constraints the number of members (outgoing member links).
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2Factory
 * @model kind="package"
 * @generated
 */
public interface WasDb2Package extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "db2"; //$NON-NLS-1$

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/wasdb2/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "wasdb2"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	WasDb2Package eINSTANCE = com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2PackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.was.db2.impl.DatasourceSatisfactionConstraintImpl <em>Datasource Satisfaction Constraint</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.was.db2.impl.DatasourceSatisfactionConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2PackageImpl#getDatasourceSatisfactionConstraint()
	 * @generated
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__ANNOTATIONS = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__ATTRIBUTE_META_DATA = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__EXTENDED_ATTRIBUTES = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__ARTIFACT_GROUP = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__ARTIFACTS = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__CONSTRAINT_GROUP = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__CONSTRAINTS = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__DESCRIPTION = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__DISPLAY_NAME = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__MUTABLE = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__NAME = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Respect Link Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT__RESPECT_LINK_DIRECTION = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT__RESPECT_LINK_DIRECTION;

	/**
	 * The number of structural features of the '<em>Datasource Satisfaction Constraint</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_SATISFACTION_CONSTRAINT_FEATURE_COUNT = ConstraintPackage.APPLICATION_COMMUNICATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2DeployRootImpl <em>Deploy Root</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2DeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2PackageImpl#getWasDb2DeployRoot()
	 * @generated
	 */
	int WAS_DB2_DEPLOY_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WAS_DB2_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WAS_DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WAS_DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Constraint Datasource Satisfaction</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WAS_DB2_DEPLOY_ROOT__CONSTRAINT_DATASOURCE_SATISFACTION = 3;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WAS_DB2_DEPLOY_ROOT_FEATURE_COUNT = 4;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint <em>Datasource Satisfaction Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Datasource Satisfaction Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint
	 * @generated
	 */
	EClass getDatasourceSatisfactionConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot
	 * @generated
	 */
	EClass getWasDb2DeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getMixed()
	 * @see #getWasDb2DeployRoot()
	 * @generated
	 */
	EAttribute getWasDb2DeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getXMLNSPrefixMap()
	 * @see #getWasDb2DeployRoot()
	 * @generated
	 */
	EReference getWasDb2DeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getXSISchemaLocation()
	 * @see #getWasDb2DeployRoot()
	 * @generated
	 */
	EReference getWasDb2DeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getConstraintDatasourceSatisfaction <em>Constraint Datasource Satisfaction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Constraint Datasource Satisfaction</em>'.
	 * @see com.ibm.ccl.soa.deploy.was.db2.WasDb2DeployRoot#getConstraintDatasourceSatisfaction()
	 * @see #getWasDb2DeployRoot()
	 * @generated
	 */
	EReference getWasDb2DeployRoot_ConstraintDatasourceSatisfaction();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WasDb2Factory getWasDb2Factory();

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
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.was.db2.impl.DatasourceSatisfactionConstraintImpl <em>Datasource Satisfaction Constraint</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.was.db2.impl.DatasourceSatisfactionConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2PackageImpl#getDatasourceSatisfactionConstraint()
		 * @generated
		 */
		EClass DATASOURCE_SATISFACTION_CONSTRAINT = eINSTANCE.getDatasourceSatisfactionConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2DeployRootImpl <em>Deploy Root</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2DeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.was.db2.impl.WasDb2PackageImpl#getWasDb2DeployRoot()
		 * @generated
		 */
		EClass WAS_DB2_DEPLOY_ROOT = eINSTANCE.getWasDb2DeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WAS_DB2_DEPLOY_ROOT__MIXED = eINSTANCE.getWasDb2DeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WAS_DB2_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE
				.getWasDb2DeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WAS_DB2_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE
				.getWasDb2DeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Constraint Datasource Satisfaction</b></em>'
		 * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WAS_DB2_DEPLOY_ROOT__CONSTRAINT_DATASOURCE_SATISFACTION = eINSTANCE
				.getWasDb2DeployRoot_ConstraintDatasourceSatisfaction();

	}

} //WasDb2Package
