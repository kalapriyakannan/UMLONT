/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;
import com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;
import com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint;

/**
 * Defines the deploy status problem types for the Was domain.
 * 
 * @see WasPackage
 * @see IDeployStatus#getProblemType()
 * 
 * This interface declares constants only; it is not intended to be implemented.
 */
public interface IWASProblemType {

	/**
	 * member is invalid for group, in the context of WAS Model
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT = WasDeployPlugin.pluginID
			+ ".invalidMemberUnitInGroupUnit"; //$NON-NLS-1$	

	/**
	 * there are a list of invalid members for group, in the context of WAS Model
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_INVALID_MEMBERUNIT_LIST_IN_GROUPUNIT = WasDeployPlugin.pluginID
			+ ".invalidMemberUnitListInGroupUnit"; //$NON-NLS-1$	

	/**
	 * there are a list of invalid members for group, in the context of WAS Model
	 * <p>
	 * Value = {@value}
	 */
	public static final String INVALID_NUMBER_DEPLOYMENTMANAGERUNIT_ON_DMGR = WasDeployPlugin.pluginID
			+ ".invalidNumberOfDeploymentManagerUnitOnDmgr"; //$NON-NLS-1$

	/**
	 * member who requiring for only one grouper, been grouped more than once, in the context of WAS
	 * Model
	 * <p>
	 * Value = {@value}
	 */
	public static final String DUPLICATED_GROUPING_UNIT = WasDeployPlugin.pluginID
			+ ".memberUnitBeenDuplicatedGrouping"; //$NON-NLS-1$

	/**
	 * common problem for unSatisfied Grouping Request For a MemberUnit
	 * <p>
	 * Value = {@value}
	 */
	public static final String UNSATISFIED_GROUPING_REQUEST_FOR_MEMBERUNIT = WasDeployPlugin.pluginID
			+ ".unSatisfiedGroupingRequestForMemberUnit"; //$NON-NLS-1$	

	/**
	 * Managed wasNode has invalid wasVersion for the Grouping Distributed WasCell.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_CLUSTER_DEPENDING_ON_WAS_NODEGROUP_NOT_IN_SAME_WAS_CELL = WasDeployPlugin.pluginID
			+ ".wasClusterDependingOnWasNodeGroupNotInSameWasCell"; //$NON-NLS-1$	

	/**
	 * wasClusterUnit depeding on a wasNodeGroupUnit who is in different wasCellUnit
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_CLUSTER_UNIT_DEPENDINGLINK_UNSATISFIED = WasDeployPlugin.pluginID
			+ ".wasClusterUnitDepedingLinkToNGUnsatisfied";//$NON-NLS-1$

	/**
	 * wasClusterUnit's member's wasNodeUnit is not in the NodeGroupUnit on whom the wasClusterUnit
	 * is depending
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_CLUSTER_NODE_UNIT_NOT_IN_DEPENDING_NODEGROUP = WasDeployPlugin.pluginID
			+ ".wasClusterNodeNotInDependingNodeGroup";//$NON-NLS-1$

	/**
	 * the default was Node in the standalone was cell has no was servers in it
	 * <p>
	 * Value = {@value}
	 */
	public static final String EMPTY_DEFAULT_WAS_NODE_IN_A_STANDALONE_WAS_CELL = WasDeployPlugin.pluginID
			+ ".EmptyDefaultNodeInStandAloneCell"; //$NON-NLS-1$	

	/**
	 * There should be only one node inside a standalone Cell
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_WAS_DMGR_NODE_UNIT_IN_WAS_DISTIRBUTED_CELL = WasDeployPlugin.pluginID
			+ ".missingWasDmgrNodeInADistributedCell"; //$NON-NLS-1$

	/**
	 * There should be only one node inside a standalone Cell
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_DEFAULT_TYPE_WAS_NODE_UNIT_IN_WAS_STANDALONE_CELL = WasDeployPlugin.pluginID
			+ ".missingDefaultWasNodeUnitInAStandAloneCell"; //$NON-NLS-1$

	/**
	 * There should be only one node inside a standalone Cell
	 * <p>
	 * Value = {@value}
	 */
	public static final String MORE_THAN_ONE_WAS_NODE_UNIT_IN_WAS_STANDALONE_CELL = WasDeployPlugin.pluginID
			+ ".moreThanOneWasNodeInAStandAloneCell"; //$NON-NLS-1$

	/**
	 * There should be only one default nodeGroup inside a distributed 6 Cell
	 * <p>
	 * Value = {@value}
	 */
	public static final String MORE_THAN_ONE_DEFAULT_WAS_NODEGROUP_UNIT_IN_WAS_6_DISTIRUBTED_CELL = WasDeployPlugin.pluginID
			+ ".moreThanOneDefaultNodeGroupInAWas6DistributedCell"; //$NON-NLS-1$

	/**
	 * There should be only one default nodeGroup inside a distributed 6 Cell
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_DEFAULT_WAS_NODEGROUP_UNIT_IN_WAS_6_CELL_UNIT = WasDeployPlugin.pluginID
			+ ".missingDefaultNodeGroupUnitInAWas6CellUnit"; //$NON-NLS-1$

	/**
	 * There should be only one nodeGroup inside a Cell in a WAS Base System
	 * <p>
	 * Value = {@value}
	 */
	public static final String MORE_THAN_ONE_NODEGROUP_UNIT_IN_WAS_CELL_UNIT_ON_BASE_SYSTEM = WasDeployPlugin.pluginID
			+ ".moreThanOneNodeGroupUnitInAWasCellUnitOnBaseSystem"; //$NON-NLS-1$

	/**
	 * There should be mo Dmgr Node inside a Cell that is part of a Base System
	 * <p>
	 * Value = {@value}
	 */
	public static final String UNALLOWED_DMGR_UNIT_IN_WAS_CELL_UNIT_ON_BASE_SYSTEM = WasDeployPlugin.pluginID
			+ ".unallowedDmgrNodeUnitInWasCellUnitOnBaseSystem"; //$NON-NLS-1$

	/**
	 * A distributed Was Cell is not allowed to be hosted on a Base System
	 * <p>
	 * Value = {@value}
	 */
	public static final String DISTRIBUTED_WAS_CELL_UNIT_HOSTED_ON_BASE_SYSTEM = WasDeployPlugin.pluginID
			+ ".distributedWasCellUnitIsHostedOnBaseSystem"; //$NON-NLS-1$

	/**
	 * nodeCap.wasVersion should >= 5 and <6, cause WAS 4 do not have Node concept
	 * <p>
	 * Value = {@value}
	 */
	public static final String INVALID_WASPROFILETYPE_OF_WAS_NODE_UNIT_AS_A_GROUP_FOR_WAS_DMGR_UNIT = WasDeployPlugin.pluginID
			+ ".invalidWasNodeProfileTypeForGroupingWasDmgrUnit"; //$NON-NLS-1$

	/**
	 * WAS Standalone Cell Unit do not support ClusterUnit as member
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_CLUSTER_IN_STANDALONE_WAS_CELL_UNIT = WasDeployPlugin.pluginID
			+ ".wasClusterUnitInsideAStandaloneCellUnit"; //$NON-NLS-1$

	/**
	 * Application who had deployed onto WAS, missing its required DataSource
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_WAS_DATASOURCE_FOR_APPLICATION = WasDeployPlugin.pluginID
			+ ".missingDataSourceForApplicationDeployed"; //$NON-NLS-1$

	/**
	 * Application who had deployed onto WAS, missing its required J2CAuthen
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_WAS_J2CAUTHEN_FOR_APPLICATION = WasDeployPlugin.pluginID
			+ ".missingJ2CauthenForApplicationDeployed"; //$NON-NLS-1$

	/*
	 * Application who had deployed onto WAS Server which is a member of cluster <p> Value = {@value}
	 */
	public static final String APPLICATION_HOSTINGON_WASSERVER_WHO_IS_CLUSTER_MEMEBER = WasDeployPlugin.pluginID
			+ ".applicationHostingOnWasClusterMemberDirectly"; //$NON-NLS-1$

	/*
	 * db2 DatasourceUnit Missing Local DB2 Catalog <p> Value = {@value}
	 */
	public static final String DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG = WasDeployPlugin.pluginID
			+ ".db2DatasourceUnitMissingLocalCatalog"; //$NON-NLS-1$

	/**
	 * application Hosting Onto Cluster Without any Server
	 * <p>
	 * Value = {@value}
	 */
	public static final String APPLICATION_HOSTINGON_ON_CLUSTER_WITHOUT_MEMEBER = WasDeployPlugin.pluginID
			+ ".applicationHostingOntoClusterWithoutServer"; //$NON-NLS-1$

	/**
	 * in valid number(0 or more than one) wasNode(who is defaultProfile true) on same wasSystem
	 * <p>
	 * Value = {@value}
	 */
	public static final String INVALID_NUMBER_DEFAULTPROFILE_WASNODE_ON_WASSYSTEM = WasDeployPlugin.pluginID
			+ ".invalidNumberDefaultProfileWasNodeOnWasSystem"; //$NON-NLS-1$ 

	/**
	 * The WAS base product is missing the default profile (Node + Server).
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_BASE_MISSING_DEFAULT_PROFILE = WasDeployPlugin.pluginID
			+ ".wasBaseMissingDefaultProfile"; //$NON-NLS-1$ 

	/**
	 * The WAS base product may have at most one WebServer node.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_BASE_MAY_ONLY_HAVE_ONE_WEBSERVER_NODE = WasDeployPlugin.pluginID
			+ ".wasBaseMayOnlyHaveOneWebserverNode"; //$NON-NLS-1$ 

	/**
	 * an variable is not defined while being used
	 * <p>
	 * Value = {@value}
	 */
	public static final String UNDEFINED_VARIABLE = WasDeployPlugin.pluginID + ".VariableNotDefined"; //$NON-NLS-1$ 

	/**
	 * An application's reference to a utility JAR is not mediated via a shared library definition.
	 * <p>
	 * Value = {@value}
	 */
	public static final String MISSING_SHARED_LIBARY = WasDeployPlugin.pluginID
			+ ".MissingSharedLibrary"; //$NON-NLS-1$

	/**
	 * Shared library definitons at the application (or module) and the server scope have been
	 * defined.
	 * <p>
	 * Value = {@value}
	 */
	public static final String CONFLICTING_SHARED_LIBARIES = WasDeployPlugin.pluginID
			+ ".ConflictingSharedLibraries"; //$NON-NLS-1$

	/**
	 * A shared library referenced by an application (or module) is hosted on a server other than the
	 * one where the application is hosted.
	 * <p>
	 * Value = {@value}
	 */
	public static final String REFERENCED_SHARED_LIBARY_HOSTING_CONFLICT = WasDeployPlugin.pluginID
			+ ".ReferencedSharedLibraryHostingConflict"; //$NON-NLS-1$

	/**
	 * An application's reference to a utility JAR is mediated via a shared library definition.
	 * <p>
	 * Value = {@value}
	 */
	public static final String CREATE_SHARED_LIBRARY = WasDeployPlugin.pluginID
			+ ".CreateSharedLibrary"; //$NON-NLS-1$

	/**
	 * An application's reference to a utility JAR is mediated via a shared library definition.
	 * <p>
	 * Value = {@value}
	 */
	public static final String ADD_TO_SHARED_LIBRARY = WasDeployPlugin.pluginID
			+ ".AddToSharedLibrary"; //$NON-NLS-1$

	/**
	 * A distributed Was Cell is hosted on a Base System
	 * <p>
	 * Value = {@value}
	 */
	public static final String DISTRIBUTED_CELL_UNIT_IS_HOSTED_ON_BASE_SYSTEM = WasDeployPlugin.pluginID
			+ ".DistributedCellUnitIsHostedOnBaseSystem"; //$NON-NLS-1$

	/**
	 * A {@link WasSecuritySubjectConstraint} cannot be defined in this context.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_INVALID_CONTEXT = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintInvalidContext"; //$NON-NLS-1$

	/**
	 * {@link WasSecuritySubjectConstraint#getJ2eeSecurityRole()} cannot be null
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NULL = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintJ2eeSecurityRoleNull"; //$NON-NLS-1$

	/**
	 * {@link WasSecuritySubjectConstraint#getWasSecuritySubject()} cannot be null
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NULL = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintWasSecuritySubjectNull"; //$NON-NLS-1$

	/**
	 * {@link WasSecuritySubjectConstraint#getJ2eeSecurityRole()} cannot be found on hostee
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_J2EE_SECURITY_ROLL_NOT_FOUND = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintJ2eeSecurityRoleNotFound"; //$NON-NLS-1$

	/**
	 * {@link WasSecuritySubjectConstraint#getWasSecuritySubject()} cannot be found on host
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_SUBJECT_NOT_FOUND = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintWasSecuritySubjectNotFound"; //$NON-NLS-1$

	/**
	 * {@link WasSecurity} capability not defined on server
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_UNDEFINED = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintWasSecurityUndefined"; //$NON-NLS-1$

	/**
	 * {@link WasSecurity} capability defined on some (but not all) servers in cluster
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_SECURITY_SUBJECT_CONSTRAINT_WAS_SECURITY_INCONSISTENT = WasDeployPlugin.pluginID
			+ ".WasSecuritySubjectConstraintWasSecurityInconsistent"; //$NON-NLS-1$

	/**
	 * A {@link WasWarClassloaderPolicyConstraint} cannot be defined in this context.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT = WasDeployPlugin.pluginID
			+ ".WasWarClassloaderPolicyConstraintInvalidContext"; //$NON-NLS-1$

	/**
	 * A {@link WasEarClassloaderPolicyConstraint} cannot be defined in this context.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT_INVALID_CONTEXT = WasDeployPlugin.pluginID
			+ ".WasEarClassloaderPolicyConstraintInvalidContext"; //$NON-NLS-1$

	/**
	 * A {@link WasWarClassloaderPolicyConstraint} cannot be defined in this context.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_MODULE_START_WEIGHT_CONSTRAINT_INVALID_CONTEXT = WasDeployPlugin.pluginID
			+ ".WasModuleStartWeightConstraintInvalidContext"; //$NON-NLS-1$

	/**
	 * A {@link WasWarClassloaderPolicyConstraint} cannot be defined in this context.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT = WasDeployPlugin.pluginID
			+ ".WasJNDIBindingConstraintInvalidContext"; //$NON-NLS-1$

	/**
	 * A {@link WasWarClassloaderPolicyConstraint} cannot be defined in this context.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH = WasDeployPlugin.pluginID
			+ ".WasJNDIBindingConstraintJNDINameOfCapabilityDoesNotMatch"; //$NON-NLS-1$

	/**
	 * An optional {@link Constraint} is not found on the object.
	 * <p>
	 * Value = {@value}
	 */
	public static final String OPTIONAL_CONSTRAINT_NOT_PRESENT = WasDeployPlugin.pluginID
			+ ".OptionalConstraintNotPresent"; //$NON-NLS-1$

	/**
	 * Too many instances of a {@link Constraint} have been found on an object.
	 * <p>
	 * Value = {@value}
	 */
	public static final String TOO_MANY_CONSTRAINTS_PRESENT = WasDeployPlugin.pluginID
			+ ".OptionalConstraintNotPresent"; //$NON-NLS-1$

	/**
	 * More than one unit of a given type is hosted on a host.
	 * <p>
	 * Value = {@value}
	 */
	public static final String UNIT_NOT_UNIQUE_ON_HOST = WasDeployPlugin.pluginID
			+ ".UnitNotUniqueOnHost"; //$NON-NLS-1$

	/**
	 * Database matching datasource not clearly identified.
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_DATASOURCE_MATCHING_DB_NOT_IDENTIFIED = WasDeployPlugin.pluginID
			+ ".WasDatasourceMatchingDbNotIdentified"; //$NON-NLS-1$

	/**
	 * Database matching datasource identified (perhaps more than 1).
	 * <p>
	 * Value = {@value}
	 */
	public static final String WAS_DATASOURCE_MATCHING_DB_IDENTIFIED = WasDeployPlugin.pluginID
			+ ".WasDatasourceMatchingDbIdentified"; //$NON-NLS-1$
}
