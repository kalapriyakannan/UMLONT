/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisPackage.java,v 1.12 2008/02/05 22:21:31 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 		    The Topology Definition Model (TDM) defines a core set of concepts to describe
 * 		    Enterprise Architectures from the Software Applications down to the hardware 
 * 		    requirements. The model is inherently extensible, allowing technology specific
 * 		    domains to define their own types. At a high level, the model is orgainzed into
 * 		    {@link Topology topologies}, which contain {@link Unit}s. A Unit contain 
 * 		    {@link Capability capabilities}, {@Requirement requirements}, and four types 
 * 		    of links ({@link DependencyLink  dependency links}, {@link HostingLink  hosting links},
 * 		    {@link ConstraintLink  constraint links}, {@link MemberLink  member links}. In 
 * 		    addition, the model defines the notion of {@link Constraint constraints} which 
 * 		    can be added to Units or Contraint Links in order to describe requirements on 
 * 		    target application or environment. 
 * 		
 * 
 * 				An object that can be part of a deployable module.  See {@link FileArtifact}.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface AnalysisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "analysis"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/analysis/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "analysisDeploy"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalysisPackage eINSTANCE = com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getAnalysisConstraint()
	 * @generated
	 */
	int ANALYSIS_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__ANNOTATIONS = CorePackage.CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA = CorePackage.CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES = CorePackage.CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__ARTIFACT_GROUP = CorePackage.CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__ARTIFACTS = CorePackage.CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP = CorePackage.CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__CONSTRAINTS = CorePackage.CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__DESCRIPTION = CorePackage.CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__DISPLAY_NAME = CorePackage.CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__MUTABLE = CorePackage.CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT__NAME = CorePackage.CONSTRAINT__NAME;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl <em>Deploy Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getAnalysisDeployRoot()
	 * @generated
	 */
	int ANALYSIS_DEPLOY_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Availability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY = 3;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Daily Load</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD = 4;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Data Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE = 5;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Execution Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE = 6;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Expected Lifespan</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN = 7;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Expected Volume</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME = 8;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Peak Load</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD = 9;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Response Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME = 10;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Size Per Submission</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION = 11;

	/**
	 * The feature id for the '<em><b>Analysis Constraint Usage Window Per Day</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY = 12;

	/**
	 * The feature id for the '<em><b>Capability Deployment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT = 13;

	/**
	 * The feature id for the '<em><b>Capability Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE = 14;

	/**
	 * The feature id for the '<em><b>Constraint Analysis Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT = 15;

	/**
	 * The feature id for the '<em><b>Unit Deployment Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT = 16;

	/**
	 * The feature id for the '<em><b>Unit Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION = 17;

	/**
	 * The feature id for the '<em><b>Unit Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT__UNIT_NODE = 18;

	/**
	 * The number of structural features of the '<em>Deploy Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_DEPLOY_ROOT_FEATURE_COUNT = 19;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.AvailabilityConstraintImpl <em>Availability Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AvailabilityConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getAvailabilityConstraint()
	 * @generated
	 */
	int AVAILABILITY_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT__PERCENTAGE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Availability Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DailyLoadConstraintImpl <em>Daily Load Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.DailyLoadConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDailyLoadConstraint()
	 * @generated
	 */
	int DAILY_LOAD_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Daily Load</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT__DAILY_LOAD = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Daily Load Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAILY_LOAD_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DataServiceConstraintImpl <em>Data Service Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.DataServiceConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDataServiceConstraint()
	 * @generated
	 */
	int DATA_SERVICE_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT__TYPE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Service Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SERVICE_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DeploymentImpl <em>Deployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.DeploymentImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeployment()
	 * @generated
	 */
	int DEPLOYMENT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__FACET = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DeploymentUnitImpl <em>Deployment Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.DeploymentUnitImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeploymentUnit()
	 * @generated
	 */
	int DEPLOYMENT_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Deployment Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ExecutionServiceConstraintImpl <em>Execution Service Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.ExecutionServiceConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExecutionServiceConstraint()
	 * @generated
	 */
	int EXECUTION_SERVICE_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT__TYPE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execution Service Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ExpectedLifespanConstraintImpl <em>Expected Lifespan Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.ExpectedLifespanConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExpectedLifespanConstraint()
	 * @generated
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__DURATION = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT__STATE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expected Lifespan Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_LIFESPAN_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ExpectedVolumeConstraintImpl <em>Expected Volume Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.ExpectedVolumeConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExpectedVolumeConstraint()
	 * @generated
	 */
	int EXPECTED_VOLUME_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Growth Rate Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expected Volume Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_VOLUME_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.LocationUnitImpl <em>Location Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.LocationUnitImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getLocationUnit()
	 * @generated
	 */
	int LOCATION_UNIT = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Location Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.NodeImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.NodeUnitImpl <em>Node Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.NodeUnitImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getNodeUnit()
	 * @generated
	 */
	int NODE_UNIT = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__ANNOTATIONS = CorePackage.CONCEPTUAL_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__ATTRIBUTE_META_DATA = CorePackage.CONCEPTUAL_NODE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.CONCEPTUAL_NODE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__ARTIFACT_GROUP = CorePackage.CONCEPTUAL_NODE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__ARTIFACTS = CorePackage.CONCEPTUAL_NODE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CONSTRAINT_GROUP = CorePackage.CONCEPTUAL_NODE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CONSTRAINTS = CorePackage.CONCEPTUAL_NODE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__DESCRIPTION = CorePackage.CONCEPTUAL_NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__DISPLAY_NAME = CorePackage.CONCEPTUAL_NODE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__MUTABLE = CorePackage.CONCEPTUAL_NODE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__NAME = CorePackage.CONCEPTUAL_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CAPABILITY_GROUP = CorePackage.CONCEPTUAL_NODE__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CAPABILITIES = CorePackage.CONCEPTUAL_NODE__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__REQUIREMENT_GROUP = CorePackage.CONCEPTUAL_NODE__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__REQUIREMENTS = CorePackage.CONCEPTUAL_NODE__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__UNIT_LINKS_GROUP = CorePackage.CONCEPTUAL_NODE__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__UNIT_LINKS = CorePackage.CONCEPTUAL_NODE__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CONSTRAINT_LINKS = CorePackage.CONCEPTUAL_NODE__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__REALIZATION_LINKS = CorePackage.CONCEPTUAL_NODE__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__STEREOTYPES = CorePackage.CONCEPTUAL_NODE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__BUILD_VERSION = CorePackage.CONCEPTUAL_NODE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CONCEPTUAL = CorePackage.CONCEPTUAL_NODE__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__CONFIGURATION_UNIT = CorePackage.CONCEPTUAL_NODE__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__GOAL_INSTALL_STATE = CorePackage.CONCEPTUAL_NODE__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__INIT_INSTALL_STATE = CorePackage.CONCEPTUAL_NODE__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__ORIGIN = CorePackage.CONCEPTUAL_NODE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT__PUBLISH_INTENT = CorePackage.CONCEPTUAL_NODE__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Node Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_UNIT_FEATURE_COUNT = CorePackage.CONCEPTUAL_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.PeakLoadConstraintImpl <em>Peak Load Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.PeakLoadConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getPeakLoadConstraint()
	 * @generated
	 */
	int PEAK_LOAD_CONSTRAINT = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Peak Load</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT__PEAK_LOAD = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Peak Load Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEAK_LOAD_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ResponseTimeConstraintImpl <em>Response Time Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.ResponseTimeConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getResponseTimeConstraint()
	 * @generated
	 */
	int RESPONSE_TIME_CONSTRAINT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__DURATION = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT__PERCENTAGE = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Response Time Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TIME_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.SizePerSubmissionConstraintImpl <em>Size Per Submission Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.SizePerSubmissionConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getSizePerSubmissionConstraint()
	 * @generated
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT__BYTES = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Size Per Submission Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZE_PER_SUBMISSION_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.UsageWindowPerDayConstraintImpl <em>Usage Window Per Day Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.UsageWindowPerDayConstraintImpl
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getUsageWindowPerDayConstraint()
	 * @generated
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__ANNOTATIONS = ANALYSIS_CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__ATTRIBUTE_META_DATA = ANALYSIS_CONSTRAINT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__EXTENDED_ATTRIBUTES = ANALYSIS_CONSTRAINT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__ARTIFACT_GROUP = ANALYSIS_CONSTRAINT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__ARTIFACTS = ANALYSIS_CONSTRAINT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__CONSTRAINT_GROUP = ANALYSIS_CONSTRAINT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__CONSTRAINTS = ANALYSIS_CONSTRAINT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__DESCRIPTION = ANALYSIS_CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__DISPLAY_NAME = ANALYSIS_CONSTRAINT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__MUTABLE = ANALYSIS_CONSTRAINT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__NAME = ANALYSIS_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT__DURATION = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Usage Window Per Day Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USAGE_WINDOW_PER_DAY_CONSTRAINT_FEATURE_COUNT = ANALYSIS_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceType <em>Data Service Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDataServiceType()
	 * @generated
	 */
	int DATA_SERVICE_TYPE = 17;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet <em>Deployment Unit Facet</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeploymentUnitFacet()
	 * @generated
	 */
	int DEPLOYMENT_UNIT_FACET = 18;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType <em>Execution Service Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExecutionServiceType()
	 * @generated
	 */
	int EXECUTION_SERVICE_TYPE = 19;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.analysis.LifespanState <em>Lifespan State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getLifespanState()
	 * @generated
	 */
	int LIFESPAN_STATE = 20;

	/**
	 * The meta object id for the '<em>Data Service Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDataServiceTypeObject()
	 * @generated
	 */
	int DATA_SERVICE_TYPE_OBJECT = 21;

	/**
	 * The meta object id for the '<em>Deployment Unit Facet Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeploymentUnitFacetObject()
	 * @generated
	 */
	int DEPLOYMENT_UNIT_FACET_OBJECT = 22;

	/**
	 * The meta object id for the '<em>Execution Service Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExecutionServiceTypeObject()
	 * @generated
	 */
	int EXECUTION_SERVICE_TYPE_OBJECT = 23;

	/**
	 * The meta object id for the '<em>Lifespan State Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
	 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getLifespanStateObject()
	 * @generated
	 */
	int LIFESPAN_STATE_OBJECT = 24;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint
	 * @generated
	 */
	EClass getAnalysisConstraint();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deploy Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot
	 * @generated
	 */
	EClass getAnalysisDeployRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getMixed()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EAttribute getAnalysisDeployRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getXMLNSPrefixMap()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getXSISchemaLocation()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintAvailability <em>Analysis Constraint Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Availability</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintAvailability()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintAvailability();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDailyLoad <em>Analysis Constraint Daily Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Daily Load</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDailyLoad()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintDailyLoad();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDataService <em>Analysis Constraint Data Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Data Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDataService()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintDataService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExecutionService <em>Analysis Constraint Execution Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Execution Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExecutionService()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintExecutionService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedLifespan <em>Analysis Constraint Expected Lifespan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Expected Lifespan</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedLifespan()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintExpectedLifespan();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedVolume <em>Analysis Constraint Expected Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Expected Volume</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedVolume()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintExpectedVolume();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintPeakLoad <em>Analysis Constraint Peak Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Peak Load</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintPeakLoad()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintPeakLoad();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintResponseTime <em>Analysis Constraint Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Response Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintResponseTime()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintResponseTime();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintSizePerSubmission <em>Analysis Constraint Size Per Submission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Size Per Submission</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintSizePerSubmission()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintSizePerSubmission();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintUsageWindowPerDay <em>Analysis Constraint Usage Window Per Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Analysis Constraint Usage Window Per Day</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintUsageWindowPerDay()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_AnalysisConstraintUsageWindowPerDay();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityDeployment <em>Capability Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Deployment</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityDeployment()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_CapabilityDeployment();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityNode <em>Capability Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityNode()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_CapabilityNode();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getConstraintAnalysisConstraint <em>Constraint Analysis Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Analysis Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getConstraintAnalysisConstraint()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_ConstraintAnalysisConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitDeploymentUnit <em>Unit Deployment Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Deployment Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitDeploymentUnit()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_UnitDeploymentUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitLocation <em>Unit Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitLocation()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_UnitLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitNode <em>Unit Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitNode()
	 * @see #getAnalysisDeployRoot()
	 * @generated
	 */
	EReference getAnalysisDeployRoot_UnitNode();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint <em>Availability Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Availability Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint
	 * @generated
	 */
	EClass getAvailabilityConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint#getPercentage()
	 * @see #getAvailabilityConstraint()
	 * @generated
	 */
	EAttribute getAvailabilityConstraint_Percentage();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint <em>Daily Load Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Daily Load Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint
	 * @generated
	 */
	EClass getDailyLoadConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint#getDailyLoad <em>Daily Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Daily Load</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint#getDailyLoad()
	 * @see #getDailyLoadConstraint()
	 * @generated
	 */
	EAttribute getDailyLoadConstraint_DailyLoad();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint <em>Data Service Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Service Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint
	 * @generated
	 */
	EClass getDataServiceConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint#getType()
	 * @see #getDataServiceConstraint()
	 * @generated
	 */
	EAttribute getDataServiceConstraint_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.Deployment
	 * @generated
	 */
	EClass getDeployment();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.Deployment#getFacet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facet</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.Deployment#getFacet()
	 * @see #getDeployment()
	 * @generated
	 */
	EAttribute getDeployment_Facet();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnit <em>Deployment Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnit
	 * @generated
	 */
	EClass getDeploymentUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint <em>Execution Service Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Service Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint
	 * @generated
	 */
	EClass getExecutionServiceConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint#getType()
	 * @see #getExecutionServiceConstraint()
	 * @generated
	 */
	EAttribute getExecutionServiceConstraint_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint <em>Expected Lifespan Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expected Lifespan Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint
	 * @generated
	 */
	EClass getExpectedLifespanConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getDuration()
	 * @see #getExpectedLifespanConstraint()
	 * @generated
	 */
	EAttribute getExpectedLifespanConstraint_Duration();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getState()
	 * @see #getExpectedLifespanConstraint()
	 * @generated
	 */
	EAttribute getExpectedLifespanConstraint_State();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint <em>Expected Volume Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expected Volume Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint
	 * @generated
	 */
	EClass getExpectedVolumeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getGrowthRatePercentage <em>Growth Rate Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Growth Rate Percentage</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getGrowthRatePercentage()
	 * @see #getExpectedVolumeConstraint()
	 * @generated
	 */
	EAttribute getExpectedVolumeConstraint_GrowthRatePercentage();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getInitialSize <em>Initial Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getInitialSize()
	 * @see #getExpectedVolumeConstraint()
	 * @generated
	 */
	EAttribute getExpectedVolumeConstraint_InitialSize();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.LocationUnit <em>Location Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.LocationUnit
	 * @generated
	 */
	EClass getLocationUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.NodeUnit <em>Node Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.NodeUnit
	 * @generated
	 */
	EClass getNodeUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint <em>Peak Load Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Peak Load Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint
	 * @generated
	 */
	EClass getPeakLoadConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint#getPeakLoad <em>Peak Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Peak Load</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint#getPeakLoad()
	 * @see #getPeakLoadConstraint()
	 * @generated
	 */
	EAttribute getPeakLoadConstraint_PeakLoad();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint <em>Response Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response Time Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint
	 * @generated
	 */
	EClass getResponseTimeConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getDuration()
	 * @see #getResponseTimeConstraint()
	 * @generated
	 */
	EAttribute getResponseTimeConstraint_Duration();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getPercentage()
	 * @see #getResponseTimeConstraint()
	 * @generated
	 */
	EAttribute getResponseTimeConstraint_Percentage();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint <em>Size Per Submission Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Size Per Submission Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint
	 * @generated
	 */
	EClass getSizePerSubmissionConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint#getBytes <em>Bytes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bytes</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint#getBytes()
	 * @see #getSizePerSubmissionConstraint()
	 * @generated
	 */
	EAttribute getSizePerSubmissionConstraint_Bytes();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint <em>Usage Window Per Day Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usage Window Per Day Constraint</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint
	 * @generated
	 */
	EClass getUsageWindowPerDayConstraint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint#getDuration()
	 * @see #getUsageWindowPerDayConstraint()
	 * @generated
	 */
	EAttribute getUsageWindowPerDayConstraint_Duration();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceType <em>Data Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Service Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
	 * @generated
	 */
	EEnum getDataServiceType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet <em>Deployment Unit Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Deployment Unit Facet</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
	 * @generated
	 */
	EEnum getDeploymentUnitFacet();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType <em>Execution Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Service Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
	 * @generated
	 */
	EEnum getExecutionServiceType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.analysis.LifespanState <em>Lifespan State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lifespan State</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
	 * @generated
	 */
	EEnum getLifespanState();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceType <em>Data Service Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Data Service Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.analysis.DataServiceType"
	 *        extendedMetaData="name='DataServiceType:Object' baseType='DataServiceType'"
	 * @generated
	 */
	EDataType getDataServiceTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet <em>Deployment Unit Facet Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Deployment Unit Facet Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
	 * @model instanceClass="com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet"
	 *        extendedMetaData="name='DeploymentUnitFacet:Object' baseType='DeploymentUnitFacet'"
	 * @generated
	 */
	EDataType getDeploymentUnitFacetObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType <em>Execution Service Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Execution Service Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType"
	 *        extendedMetaData="name='ExecutionServiceType:Object' baseType='ExecutionServiceType'"
	 * @generated
	 */
	EDataType getExecutionServiceTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.analysis.LifespanState <em>Lifespan State Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lifespan State Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
	 * @model instanceClass="com.ibm.ccl.soa.deploy.analysis.LifespanState"
	 *        extendedMetaData="name='LifespanState:Object' baseType='LifespanState'"
	 * @generated
	 */
	EDataType getLifespanStateObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnalysisFactory getAnalysisFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getAnalysisConstraint()
		 * @generated
		 */
		EClass ANALYSIS_CONSTRAINT = eINSTANCE.getAnalysisConstraint();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl <em>Deploy Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getAnalysisDeployRoot()
		 * @generated
		 */
		EClass ANALYSIS_DEPLOY_ROOT = eINSTANCE.getAnalysisDeployRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_DEPLOY_ROOT__MIXED = eINSTANCE.getAnalysisDeployRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getAnalysisDeployRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getAnalysisDeployRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Availability</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintAvailability();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Daily Load</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintDailyLoad();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Data Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintDataService();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Execution Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintExecutionService();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Expected Lifespan</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintExpectedLifespan();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Expected Volume</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintExpectedVolume();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Peak Load</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintPeakLoad();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Response Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintResponseTime();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Size Per Submission</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintSizePerSubmission();

		/**
		 * The meta object literal for the '<em><b>Analysis Constraint Usage Window Per Day</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY = eINSTANCE.getAnalysisDeployRoot_AnalysisConstraintUsageWindowPerDay();

		/**
		 * The meta object literal for the '<em><b>Capability Deployment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT = eINSTANCE.getAnalysisDeployRoot_CapabilityDeployment();

		/**
		 * The meta object literal for the '<em><b>Capability Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE = eINSTANCE.getAnalysisDeployRoot_CapabilityNode();

		/**
		 * The meta object literal for the '<em><b>Constraint Analysis Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT = eINSTANCE.getAnalysisDeployRoot_ConstraintAnalysisConstraint();

		/**
		 * The meta object literal for the '<em><b>Unit Deployment Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT = eINSTANCE.getAnalysisDeployRoot_UnitDeploymentUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION = eINSTANCE.getAnalysisDeployRoot_UnitLocation();

		/**
		 * The meta object literal for the '<em><b>Unit Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_DEPLOY_ROOT__UNIT_NODE = eINSTANCE.getAnalysisDeployRoot_UnitNode();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.AvailabilityConstraintImpl <em>Availability Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AvailabilityConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getAvailabilityConstraint()
		 * @generated
		 */
		EClass AVAILABILITY_CONSTRAINT = eINSTANCE.getAvailabilityConstraint();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVAILABILITY_CONSTRAINT__PERCENTAGE = eINSTANCE.getAvailabilityConstraint_Percentage();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DailyLoadConstraintImpl <em>Daily Load Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.DailyLoadConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDailyLoadConstraint()
		 * @generated
		 */
		EClass DAILY_LOAD_CONSTRAINT = eINSTANCE.getDailyLoadConstraint();

		/**
		 * The meta object literal for the '<em><b>Daily Load</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAILY_LOAD_CONSTRAINT__DAILY_LOAD = eINSTANCE.getDailyLoadConstraint_DailyLoad();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DataServiceConstraintImpl <em>Data Service Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.DataServiceConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDataServiceConstraint()
		 * @generated
		 */
		EClass DATA_SERVICE_CONSTRAINT = eINSTANCE.getDataServiceConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SERVICE_CONSTRAINT__TYPE = eINSTANCE.getDataServiceConstraint_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DeploymentImpl <em>Deployment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.DeploymentImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeployment()
		 * @generated
		 */
		EClass DEPLOYMENT = eINSTANCE.getDeployment();

		/**
		 * The meta object literal for the '<em><b>Facet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT__FACET = eINSTANCE.getDeployment_Facet();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.DeploymentUnitImpl <em>Deployment Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.DeploymentUnitImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeploymentUnit()
		 * @generated
		 */
		EClass DEPLOYMENT_UNIT = eINSTANCE.getDeploymentUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ExecutionServiceConstraintImpl <em>Execution Service Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.ExecutionServiceConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExecutionServiceConstraint()
		 * @generated
		 */
		EClass EXECUTION_SERVICE_CONSTRAINT = eINSTANCE.getExecutionServiceConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_SERVICE_CONSTRAINT__TYPE = eINSTANCE.getExecutionServiceConstraint_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ExpectedLifespanConstraintImpl <em>Expected Lifespan Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.ExpectedLifespanConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExpectedLifespanConstraint()
		 * @generated
		 */
		EClass EXPECTED_LIFESPAN_CONSTRAINT = eINSTANCE.getExpectedLifespanConstraint();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_LIFESPAN_CONSTRAINT__DURATION = eINSTANCE.getExpectedLifespanConstraint_Duration();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_LIFESPAN_CONSTRAINT__STATE = eINSTANCE.getExpectedLifespanConstraint_State();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ExpectedVolumeConstraintImpl <em>Expected Volume Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.ExpectedVolumeConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExpectedVolumeConstraint()
		 * @generated
		 */
		EClass EXPECTED_VOLUME_CONSTRAINT = eINSTANCE.getExpectedVolumeConstraint();

		/**
		 * The meta object literal for the '<em><b>Growth Rate Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE = eINSTANCE.getExpectedVolumeConstraint_GrowthRatePercentage();

		/**
		 * The meta object literal for the '<em><b>Initial Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE = eINSTANCE.getExpectedVolumeConstraint_InitialSize();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.LocationUnitImpl <em>Location Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.LocationUnitImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getLocationUnit()
		 * @generated
		 */
		EClass LOCATION_UNIT = eINSTANCE.getLocationUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.NodeImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.NodeUnitImpl <em>Node Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.NodeUnitImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getNodeUnit()
		 * @generated
		 */
		EClass NODE_UNIT = eINSTANCE.getNodeUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.PeakLoadConstraintImpl <em>Peak Load Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.PeakLoadConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getPeakLoadConstraint()
		 * @generated
		 */
		EClass PEAK_LOAD_CONSTRAINT = eINSTANCE.getPeakLoadConstraint();

		/**
		 * The meta object literal for the '<em><b>Peak Load</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PEAK_LOAD_CONSTRAINT__PEAK_LOAD = eINSTANCE.getPeakLoadConstraint_PeakLoad();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.ResponseTimeConstraintImpl <em>Response Time Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.ResponseTimeConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getResponseTimeConstraint()
		 * @generated
		 */
		EClass RESPONSE_TIME_CONSTRAINT = eINSTANCE.getResponseTimeConstraint();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TIME_CONSTRAINT__DURATION = eINSTANCE.getResponseTimeConstraint_Duration();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TIME_CONSTRAINT__PERCENTAGE = eINSTANCE.getResponseTimeConstraint_Percentage();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.SizePerSubmissionConstraintImpl <em>Size Per Submission Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.SizePerSubmissionConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getSizePerSubmissionConstraint()
		 * @generated
		 */
		EClass SIZE_PER_SUBMISSION_CONSTRAINT = eINSTANCE.getSizePerSubmissionConstraint();

		/**
		 * The meta object literal for the '<em><b>Bytes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIZE_PER_SUBMISSION_CONSTRAINT__BYTES = eINSTANCE.getSizePerSubmissionConstraint_Bytes();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.impl.UsageWindowPerDayConstraintImpl <em>Usage Window Per Day Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.UsageWindowPerDayConstraintImpl
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getUsageWindowPerDayConstraint()
		 * @generated
		 */
		EClass USAGE_WINDOW_PER_DAY_CONSTRAINT = eINSTANCE.getUsageWindowPerDayConstraint();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USAGE_WINDOW_PER_DAY_CONSTRAINT__DURATION = eINSTANCE.getUsageWindowPerDayConstraint_Duration();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceType <em>Data Service Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDataServiceType()
		 * @generated
		 */
		EEnum DATA_SERVICE_TYPE = eINSTANCE.getDataServiceType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet <em>Deployment Unit Facet</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeploymentUnitFacet()
		 * @generated
		 */
		EEnum DEPLOYMENT_UNIT_FACET = eINSTANCE.getDeploymentUnitFacet();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType <em>Execution Service Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExecutionServiceType()
		 * @generated
		 */
		EEnum EXECUTION_SERVICE_TYPE = eINSTANCE.getExecutionServiceType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.analysis.LifespanState <em>Lifespan State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getLifespanState()
		 * @generated
		 */
		EEnum LIFESPAN_STATE = eINSTANCE.getLifespanState();

		/**
		 * The meta object literal for the '<em>Data Service Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDataServiceTypeObject()
		 * @generated
		 */
		EDataType DATA_SERVICE_TYPE_OBJECT = eINSTANCE.getDataServiceTypeObject();

		/**
		 * The meta object literal for the '<em>Deployment Unit Facet Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getDeploymentUnitFacetObject()
		 * @generated
		 */
		EDataType DEPLOYMENT_UNIT_FACET_OBJECT = eINSTANCE.getDeploymentUnitFacetObject();

		/**
		 * The meta object literal for the '<em>Execution Service Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getExecutionServiceTypeObject()
		 * @generated
		 */
		EDataType EXECUTION_SERVICE_TYPE_OBJECT = eINSTANCE.getExecutionServiceTypeObject();

		/**
		 * The meta object literal for the '<em>Lifespan State Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
		 * @see com.ibm.ccl.soa.deploy.analysis.impl.AnalysisPackageImpl#getLifespanStateObject()
		 * @generated
		 */
		EDataType LIFESPAN_STATE_OBJECT = eINSTANCE.getLifespanStateObject();

	}

} //AnalysisPackage
