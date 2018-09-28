/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.IWasDeployStatusAttributeNames;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Factory for generating {@link IDeployStatus} that can be serialized as markers.
 */
public class DeployWasMessageFactory extends DeployCoreStatusUtil {

	/** Status attribute field type */
	public final static String DELETION_DMO_TYPE = "DELETION_DMO_TYPE"; //$NON-NLS-1$

	/**
	 * common WAS invalid memberUnit status
	 * 
	 * @param memberUnit
	 * @param groupUnit
	 * @param validatorID
	 * @param message
	 * @return the created status
	 */
	public static IDeployStatus createWasInvalidMemberUnitInGroupUnitStatus(Unit memberUnit,
			Unit groupUnit, String validatorID, String message) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
				validatorID, IWASProblemType.WAS_INVALID_MEMBERUNIT_IN_GROUPUNIT, message,
				new Object[] { groupUnit }, memberUnit);
		return status;
	}

	/**
	 * commen validation status, there are a list of member units who are invalid
	 * 
	 * @param memberCapList
	 * @param groupUnit
	 * @param validatorID
	 * @param message
	 * @return the created status
	 */
	public static IDeployStatus createWasListOFInvalidMemberUnitInGroupUnitStatus(
			List memberCapList, Unit groupUnit, String validatorID, String message) {
		WasDeployStatus status = new WasDeployStatus(IStatus.ERROR, validatorID,
				IWASProblemType.WAS_INVALID_MEMBERUNIT_LIST_IN_GROUPUNIT, message, new Object[] {},
				groupUnit);
		status.setAttribute(IWasDeployStatusAttributeNames.CAPABILITY_LIST, memberCapList);
		return status;

	}

	/**
	 * nodegroup could only been grouped by one and exactly one Cell
	 * 
	 * @param nodeGroupUnit
	 * @param cellUnitList
	 * @return the status created
	 */
	public static IDeployStatus createWasNodeGroupUnitInMoreThanOneWasCellUnitStatus(
			WasNodeGroupUnit nodeGroupUnit, List<Unit> cellUnitList) {
		WasDeployStatus status = new WasDeployStatus(
				IStatus.ERROR,
				IWasValidatorID.VALIDAT_WAS_NODEGROUP_UNIT_S_GROUPING_WASCELLUNITS,
				IWASProblemType.DUPLICATED_GROUPING_UNIT,
				WasDomainMessages.Validator_Was_Duplicated_Grouping_for_MemberUnit_0_Request_only_one_GroupingUnit_1,
				new Object[] { nodeGroupUnit, WasPackage.Literals.WAS_CELL_UNIT }, nodeGroupUnit);
		status.setAttribute(IWasDeployStatusAttributeNames.CELL_LIST, cellUnitList);
		return status;
	}

	/**
	 * wasClusterUnit is depending on an invalid wasNodeGroup
	 * 
	 * @param clusterUnit
	 * @param nodeGroupUnit
	 * @return the status created
	 */
	public static IDeployStatus createWasClusterDependingOnNodeGroupInOtherCellStatus(
			WasClusterUnit clusterUnit, WasNodeGroupUnit nodeGroupUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.ERROR,
						IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_DEPENDING_ON_WAS_NODEGROUP_UNIT_IN_DIFFERENT_CELL,
						IWASProblemType.WAS_CLUSTER_UNIT_DEPENDINGLINK_UNSATISFIED,
						WasDomainMessages.Validator_WasClusterUnit_0_WasNodeGroupUnit_1_Not_In_SameCell,
						new Object[] { clusterUnit, nodeGroupUnit }, clusterUnit);
		return status;

	}

	public static IDeployStatus createWasClusterNodeNotInNodeGroupStatus(WasNodeUnit nodeUnit,
			WasNodeGroupUnit nodeGroupUnit, Unit clusterUnit, Unit serverUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(nodeUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDAT_WAS_CLUSTER_NODEUNIT_IN_DEPENDING_NODEGROUP,
				IWASProblemType.WAS_CLUSTER_NODE_UNIT_NOT_IN_DEPENDING_NODEGROUP,
				WasDomainMessages.Validator_WasCluster_0_Member_1_NodeUnit_2_Not_In_WasNodeGroupUnit_3,
				new Object[] { clusterUnit, serverUnit, nodeUnit, nodeGroupUnit }, nodeUnit);
		return status;

	}

	/**
	 * the cell is a standalone cell, the Node in the Cell whose profileType is default, has no
	 * 'server1'
	 * 
	 * The Right Way: If the profileType == default and it is inside a standalone Cell, it should own
	 * one and only one application server named 'server1'
	 * 
	 * @param nodeUnit
	 * @return the created status
	 */
	public static IDeployStatus createEmptyStandAloneDefaultNodeStatus(WasNodeUnit nodeUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(nodeUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.WAS_DEFAULT_NODE_UNIT_IN_WAS_STANDALONE_CELL_WITHOUT_WAS_SERVER,
				IWASProblemType.EMPTY_DEFAULT_WAS_NODE_IN_A_STANDALONE_WAS_CELL,
				WasDomainMessages.Validator_Was_Node_Unit_0_Without_Server1, new Object[] { nodeUnit },
				nodeUnit);
		return status;
	}

	/**
	 * Node not in NodeGroup
	 * 
	 * @param nodeUnit
	 * @param cellUnit
	 * @return the created status
	 */
	public static IDeployStatus createMissingGroupingNodeGroupStatus(WasNodeUnit nodeUnit,
			WasCellUnit cellUnit) {
		int severity;
		if (nodeUnit.isConceptual()) {
			severity = IStatus.INFO;
		} else if (nodeUnit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			severity = IStatus.WARNING;
		} else {
			severity = IStatus.ERROR;
		}
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						severity,
						IWasValidatorID.VALIDAT_WAS_NODE_IN_NODEGROUP_MEMBER_LINK,
						IWASProblemType.UNSATISFIED_GROUPING_REQUEST_FOR_MEMBERUNIT,
						WasDomainMessages.Validator_Was_Unsatisfied_GroupUnit_0_Grouping_Request_for_memberUnit_1,
						new Object[] { WasPackage.Literals.WAS_NODE_GROUP_UNIT, nodeUnit }, nodeUnit);
		return status;
	}

	/**
	 * one Node is required in a standalone cell
	 * 
	 * @param wasCellUnit
	 * @return the created status
	 */
	public static IDeployStatus createMissingNodeInStandAloneCellStatus(WasCellUnit wasCellUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						wasCellUnit.isConceptual() ? IStatus.INFO : IStatus.ERROR,
						IWasValidatorID.VALIDAT_WAS_STANDALONE_CELL_NODE_MEMBER_CARDINALITY_001,
						IWASProblemType.MISSING_DEFAULT_TYPE_WAS_NODE_UNIT_IN_WAS_STANDALONE_CELL,
						WasDomainMessages.Validator_Was_StandAloneCellUnit_0_With_Invalid_Node_Member_Cardinality,
						new Object[] { wasCellUnit }, wasCellUnit);
		return status;
	}

	/**
	 * one dmgr Node is required in a distributed cell
	 * 
	 * @param wasCellUnit
	 * @return the created status
	 */
	public static IDeployStatus createMissingDmgrNodeInDistributedCellStatus(WasCellUnit wasCellUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(wasCellUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDAT_WAS_DISTRIBUTED_CELL_DMGR_NODE_MEMBER_CARDINALITY_001,
				IWASProblemType.MISSING_WAS_DMGR_NODE_UNIT_IN_WAS_DISTIRBUTED_CELL,
				WasDomainMessages.Validator_Was_DistributedCell_0_Missing_Dmgr_Node_Member,
				new Object[] { wasCellUnit }, wasCellUnit);
		return status;
	}

	/**
	 * only one default NodeGroup is required in a distributed 6 cell
	 * 
	 * @param wasCellUnit
	 * @return the created status
	 */
	public static IDeployStatus createMissingDefaultNodeGroupINVersion6CellUnitStatus(
			WasCellUnit wasCellUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(wasCellUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDATE_WAS_6_CELL_UNIT_NODEGROUPUNIT_MEMBER_CARDINALITY_002,
				IWASProblemType.MISSING_DEFAULT_WAS_NODEGROUP_UNIT_IN_WAS_6_CELL_UNIT,
				WasDomainMessages.Validator_Was_6_Cell_0_Default_Node_Group_Cardinality,
				new Object[] { wasCellUnit }, wasCellUnit);
		return status;
	}

	/**
	 * a distributed Cell is not allowed to be hosted on a WAS base system
	 * 
	 * @param wasCellUnit
	 * @return the created status
	 */
	public static IDeployStatus createDistributedCellUnitHostedOnBaseSystemStatus(
			WasCellUnit wasCellUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(wasCellUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDATE_DISTRIBUTED_WAS_CELL_UNIT_HOSTED_ON_BASE_SYSTEM,
				IWASProblemType.DISTRIBUTED_WAS_CELL_UNIT_HOSTED_ON_BASE_SYSTEM,
				WasDomainMessages.Validator_Distributed_Was_Cell_Hosted_On_Base_System,
				new Object[] { wasCellUnit }, wasCellUnit);
		return status;
	}

	/**
	 * only one Dmgr is allowed in a Cell
	 * 
	 * @param wasCellUnit
	 * @return the created status
	 */
	public static IDeployStatus createUnallowedDmgrInACellUnitOnBaseSystemStatus(
			WasCellUnit wasCellUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(wasCellUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDATE_WAS_CELL_UNIT_ON_BASE_SYSTEM_DMGRNODEUNIT_MEMBER_CARDINALITY,
				IWASProblemType.UNALLOWED_DMGR_UNIT_IN_WAS_CELL_UNIT_ON_BASE_SYSTEM,
				WasDomainMessages.Validator_Was_Cell_On_Base_System_Unallowed_Dmgr_Node_Cardinality,
				new Object[] { wasCellUnit }, wasCellUnit);
		return status;
	}

	/**
	 * application Unit missing required datasourceUnit
	 * 
	 * @param applicationUnit
	 * @param ds_jndiName
	 * @param jdbcProviderMap
	 * @return the created status
	 */
	public static IDeployStatus createApplicationRequiringDSMissingStatus(Unit applicationUnit,
			String ds_jndiName, Map jdbcProviderMap) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(applicationUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDAT_WAS_APP_S_MISSING_DATASOURCE_REQ,
				IWASProblemType.MISSING_WAS_DATASOURCE_FOR_APPLICATION,
				WasDomainMessages.Validator_Application_Unit_0_Requiring_Datasource_1_Unsatisfied,
				new Object[] { applicationUnit, ds_jndiName }, applicationUnit);
		return status;
	}

	/**
	 * application Unit missing required datasourceUnit
	 * 
	 * @param applicationUnit
	 * @param j2cAuth_alias
	 * @param cellUnit
	 * @param req
	 * @return the created status
	 */
	public static IDeployStatus createApplicationRequiringJ2CAuthMissingStatus(Unit applicationUnit,
			String j2cAuth_alias, Unit cellUnit, Requirement req) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(applicationUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDAT_WAS_APP_S_MISSING_J2CAUTHEN_REQ,
				IWASProblemType.MISSING_WAS_J2CAUTHEN_FOR_APPLICATION,
				WasDomainMessages.Validator_Application_Unit_0_Requiring_J2CAuthen_1_Unsatisfied,
				new Object[] { applicationUnit, j2cAuth_alias }, applicationUnit);
		return status;
	}

	/**
	 * Application who had deployed onto WAS Server which is a member of cluster
	 * 
	 * @param applicationUnit
	 * @param serverUnit
	 * @param clusterUnit
	 * @return the created status
	 */
	public static IDeployStatus createApplicationHostingOnClusterMemberStatus(Unit applicationUnit,
			Unit serverUnit, Unit clusterUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						IStatus.ERROR,
						IWasValidatorID.VALIDAT_APPLICATION_HOSTINGON_CLUSTER_MEMBER,
						IWASProblemType.APPLICATION_HOSTINGON_WASSERVER_WHO_IS_CLUSTER_MEMEBER,
						WasDomainMessages.Validator_Application_Unit_0_HostingOn_WasServer_1_As_Member_of_Cluster_2,
						new Object[] { applicationUnit, serverUnit, clusterUnit }, applicationUnit);
		return status;
	}

	/**
	 * local type datasourceUnit without local db2 catalog status
	 * 
	 * @param dsUnit
	 * @param nearestUnithave
	 * @param validatorID
	 * @return the created status
	 */
	public static IDeployStatus createLocalDB2DSUnitMissingLocalDB2CatalogStatus(Unit dsUnit,
			Unit nearestUnithave, String validatorID) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						dsUnit.isConceptual() ? IStatus.INFO : IStatus.ERROR,
						validatorID,
						IWASProblemType.DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG,
						WasDomainMessages.Validator_DB2JdbcProvider_type2_WasDatasource_0_Missing_Local_DB2_Catalog,
						new Object[] { dsUnit }, dsUnit);

		return status;
	}

	/**
	 * for distributed ds
	 * 
	 * @param dsUnit
	 * @param nearestUnitL
	 * @param validatorID
	 * @return the created status
	 */
	public static IDeployStatus createLocalDB2DSUnitMissingLocalDB2CatalogStatus(Unit dsUnit,
			List nearestUnitL, String validatorID) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						dsUnit.isConceptual() ? IStatus.INFO : IStatus.ERROR,
						validatorID,
						IWASProblemType.DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG,
						WasDomainMessages.Validator_DB2JdbcProvider_type2_WasDatasource_0_Missing_Local_DB2_Catalog,
						new Object[] { dsUnit }, dsUnit);

		return status;
	}

	/**
	 * add resolution to add server from template into the cluster, or add some node's server into
	 * this cluster
	 * 
	 * @param clusterUnit
	 * @param applicationUnit
	 * @return the created status
	 */
	public static IDeployStatus createApplicationHostingOnEmptyClusterStatus(Unit clusterUnit,
			Unit applicationUnit) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(clusterUnit
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.VALIDAT_APPLICATION_HOSTINGON_ON_EMPTY_CLUSTER,
				IWASProblemType.APPLICATION_HOSTINGON_ON_CLUSTER_WITHOUT_MEMEBER,
				WasDomainMessages.Validator_Application_Unit_0_HostingOn_Empty_WasCluster_1,
				new Object[] { applicationUnit, clusterUnit }, clusterUnit);
		return status;
	}

	/**
	 * in valid number(0) wasNode(who is defaultProfile true) on same wasSystem
	 * 
	 * @param wasSystemUnit
	 * @return the created status
	 */
	public static IDeployAttributeStatus createOmitDefaultProfileNodeStatus(Unit wasSystemUnit) {
		int level = IStatus.ERROR;
		if (wasSystemUnit.isConceptual()) {
			level = IStatus.INFO;
		} else if (wasSystemUnit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			level = IStatus.WARNING;
		}
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(level,
				IWasValidatorID.WAS_VALIDAT_EXACT_ONE_DEFAULTPROFILE_ON_WASSYSTEM_001,
				IWASProblemType.INVALID_NUMBER_DEFAULTPROFILE_WASNODE_ON_WASSYSTEM,
				WasDomainMessages.Validator_Omit_DefaultProfile, null, wasSystemUnit,
				WasPackage.Literals.WAS_NODE__IS_DEFAULT_PROFILE);
		return status;
	}

	/**
	 * in valid number(>1) wasNode(who is defaultProfile true) on same wasSystem
	 * 
	 * @param wasSystemUnit
	 * @param wasNodeList
	 * @return the created status
	 */
	public static IDeployAttributeStatus createMoreThanOneDefaultProfileNodeStatus(
			Unit wasSystemUnit, List<WasNode> wasNodeList) {
		int level = IStatus.ERROR;
		if (wasSystemUnit.isConceptual()) {
			level = IStatus.INFO;
		} else if (wasSystemUnit.getInitInstallState() == InstallState.INSTALLED_LITERAL) {
			level = IStatus.WARNING;
		}
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(level,
				IWasValidatorID.WAS_VALIDAT_EXACT_ONE_DEFAULTPROFILE_ON_WASSYSTEM_002,
				IWASProblemType.INVALID_NUMBER_DEFAULTPROFILE_WASNODE_ON_WASSYSTEM,
				WasDomainMessages.Validator_More_Than_One_DefaultProfile, new Object[] { wasNodeList },
				wasSystemUnit, WasPackage.Literals.WAS_NODE__IS_DEFAULT_PROFILE);
		return status;
	}

	/**
	 * Creates a status on a unit whose hostee source and targets do not match.
	 * 
	 * @param req
	 *           the hosted unit's requirement whose attribute does not match.
	 * 
	 * @return the created status.
	 */
	public static IDeployStatus createHostingTargetOSInvalidStatus(Unit unit, Requirement req) {

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
				IWasValidatorID.WAS_WINDOWSSERVICE_HOSTINGSTACK_001,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
				WasDomainMessages.Validator_WindowsServiceUnit_0_HostingReq_1_unsatisfied,
				new Object[] { unit, req }, unit);
		return status;
	}

	/**
	 * cell hosting on invalid node
	 * 
	 * @param link
	 * @return the created status
	 */
	public static IDeployStatus createHostingTargetWasNodeInvalidStatus(HostingLink link) {

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
				IWasValidatorID.WAS_CELL_UNIT_HOSTINGLINK_INVILID_001,
				ICoreProblemType.HOSTING_LINK_TARGET_INVALID,
				WasDomainMessages.Validator_HostingLink_Between_CellUnit_0_and_NodeUnit_1,
				new Object[] { link.getSource(), link.getTarget() }, link);
		return status;
	}

	/**
	 * cluster's depending NG in differed cell
	 * 
	 * @param link
	 * @return the created status
	 */
	public static IDeployStatus createDependencyTargetWasNodeGroupInvalidStatus(DependencyLink link) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
				IWasValidatorID.WAS_CLUSTER_DEPENDENCYLINK_INVALID_001,
				ICoreProblemType.DEPENDENCY_LINK_TARGET_INVALID,
				WasDomainMessages.Validator_Was_dependency_link_target_0_should_be_in_same_cell,
				new Object[] { link.getTarget() }, link);
		return status;
	}

	/**
	 * Was JMSActivationSpecification must depend on defaultMessaging Queue/Topic Destination.
	 * 
	 * @param unit
	 * @return the created status
	 */
	public static IDeployStatus createWasJMSActiSpecDependencyOnDefaultMessagingDestinationUndefined(
			Unit unit) {

		IDeployStatus status = DeployCoreStatusFactory.INSTANCE
				.createDeployStatus(
						unit.isConceptual() ? IStatus.INFO : IStatus.ERROR,
						IWasValidatorID.WAS_JMSACTIVATIONSPEC_MUST_DEPENDON_ONE_DEFAULTMESSAGINGDESTINATION_001,
						ICoreProblemType.DEPENDENCY_LINK_TARGET_UNDEFINED,
						WasDomainMessages.Validator_WasJMSAactivationSpec_0__Must_Depend_on_one_defaultMessagingDestination,
						new Object[] { unit }, unit);

		return status;
	}

	/**
	 * variable undefined
	 * 
	 * @param variableName
	 * @param attribute
	 * @param capability
	 * @return the created status
	 */
	public static IDeployStatus createVariableUndefinedStatus(String variableName,
			EAttribute attribute, Capability capability) {
		Unit unit = ValidatorUtils.getUnit(capability);
		int severity = unit != null && unit.isConceptual() ? IStatus.INFO : IStatus.ERROR;
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(severity,
				IWasValidatorID.WAS_INVALID_CLASSPATH_VALUE_002, IWASProblemType.UNDEFINED_VARIABLE,
				WasDomainMessages.Validator_WasVariable_0_undefined, new Object[] { variableName },
				capability, attribute);
		return status;
	}

	/**
	 * in valid number(>1) DeploymentManager Unit on DmgrNode
	 * 
	 * @param dmgr
	 * @return the created status
	 */
	public static IDeployStatus createMoreThanOneDeploymentManagerUnit(Unit dmgr) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(dmgr
				.isConceptual() ? IStatus.INFO : IStatus.ERROR,
				IWasValidatorID.WAS_VALIDAT_EXACT_ONE_DEPLOYMENTMANAGERUNIT_ON_DMGR,
				IWASProblemType.INVALID_NUMBER_DEPLOYMENTMANAGERUNIT_ON_DMGR,
				WasDomainMessages.Validator_Was_More_Than_One_DeploymentManagerUnit,
				new Object[] { dmgr }, dmgr);
		return status;
	}

	/**
	 * More than one unit of a given type is hosted on a unit
	 * 
	 * @param server
	 * @param validatorId
	 * @return the created status
	 */
	public static IDeployStatus createUnitNotUniqueOnHost(Unit server, String validatorId,
			EClass type) {
//		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(server
//				.isConceptual() ? IStatus.INFO : IStatus.ERROR, validatorId,
//				IWASProblemType.UNIT_NOT_UNIQUE_ON_HOST,
//				WasDomainMessages.Validator_Unit_Not_Unique_On_Host, new Object[] {}, server);
		int severity = server.isConceptual() ? IStatus.INFO : IStatus.ERROR;
		WasDeployStatus status = new WasDeployStatus(severity, validatorId,
				IWASProblemType.UNIT_NOT_UNIQUE_ON_HOST,
				WasDomainMessages.Validator_Unit_Not_Unique_On_Host, new Object[] {}, server);
		status.setAttribute(DELETION_DMO_TYPE, type);
		return status;
	}
}
