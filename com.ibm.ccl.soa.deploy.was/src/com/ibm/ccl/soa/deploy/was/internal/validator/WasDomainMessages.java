/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the SOA Was domain.
 */
public class WasDomainMessages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.was.internal.validator.messages"; //$NON-NLS-1$

	// /////////////////////////////////////////////////////////////////////////////////////

	public static String Validator_WASV5DB2Datasource_0_with_non_DB2_database_requirement_1;
	public static String Resolution_increment_port_values_of_0;
	public static String Resolution_increment_port_values_resolution_exception;

	public static String Validator_Was_Node_0_Invalid_with_Was_Cell_1_NodewasVersion_2;
	public static String Validator_Was_Node_Unit_0_Without_Server1;
	public static String Validator_Was_Node_Unit_0_With_More_Than_One_Server_In_standalone_Cell;
	public static String Validator_Was_Node_Unit_0_With_One_Server_Whose_Name_Is_Invalid;
	public static String Validator_Was_StandAloneCellUnit_0_With_Invalid_Node_Member_Cardinality;
	public static String Validator_Was_6_StandAloneCellUnit_0_With_Invalid_NodeGroup_Member_Cardinality;
	public static String Validator_WAS_DisCellUnit_0_With_Invalid_DmgrNode_Unit_Member_Cardinality;
	public static String Validator_Was_DistributedCell_0_Missing_Dmgr_Node_Member;
	public static String Validator_Was_6_Cell_0_Default_Node_Group_Cardinality;
	public static String Validator_Was_Cell_On_Base_System_Unallowed_Dmgr_Node_Cardinality;
	public static String Validator_Distributed_Was_Cell_Hosted_On_Base_System;
	public static String Validator_Was_ClusterUnit_0_Is_Invalid_MemberOF_StandAlone_Was_Cell_Unit_1;
	public static String Validator_Was_Cluster_0_WasVersion_1_Bigger_Than_Its_WasCell_2_WasVersion_3;
	public static String Validator_WasClusterUnit_0_WasNodeGroupUnit_1_Not_In_SameCell;
	public static String Validator_WasClusterUnit_0_WasClusterMemberUnit_wasNodeUnit_1_Not_In_SameCell;
	public static String Validator_WasCluster_0_Member_1_NodeUnit_2_Not_In_WasNodeGroupUnit_3;
	public static String Validator_Was_Unsatisfied_GroupUnit_0_Grouping_Request_for_memberUnit_1;
	public static String Validator_Was_dependency_link_target_0_should_be_in_same_cell;

	public static String Validator_Was_Duplicated_Grouping_for_MemberUnit_0_Request_only_one_GroupingUnit_1;
	public static String Validator_Application_Unit_0_Requiring_Datasource_1_Unsatisfied;
	public static String Validator_Application_Unit_0_Requiring_J2CAuthen_1_Unsatisfied;
	public static String Validator_Application_Unit_0_HostingOn_WasServer_1_As_Member_of_Cluster_2;
	public static String Validator_DB2JdbcProvider_type2_WasDatasource_0_Missing_Local_DB2_Catalog;
	public static String Validator_Application_Unit_0_HostingOn_Empty_WasCluster_1;
	public static String Validator_WasNodeUnit_0_WasNodeGroupUnit_1_Not_in_same_Cell;
	public static String Validator_Omit_DefaultProfile;
	public static String Validator_More_Than_One_DefaultProfile;
	public static String Validator_WindowsServiceUnit_0_HostingReq_1_unsatisfied;
	public static String Validator_HostingLink_Between_CellUnit_0_and_NodeUnit_1;
	public static String Validator_WasJMSAactivationSpec_0__Must_Depend_on_one_defaultMessagingDestination;
	public static String Validator_WasVariable_0_undefined;
	public static String Validator_WAS_base_system_0_can_only_host_one_webserver_unmanaged_node;
	public static String Validator_WAS_base_system_0_missing_default_profile;
	public static String Validator_Was_More_Than_One_DeploymentManagerUnit;

	public static String Validator_Invalid_Requirement_Expression_Value;
	public static String Validator_Missing_Shared_Library_Reference_0;
	public static String Validator_Inconsistent_Shared_Library_References;
	public static String Validator_Referenced_Shared_Library_Hosting_Inconsistency;
	public static String Validator_Create_Shared_Library_Reference_0;
	public static String Validator_Add_to_Existing_Shared_Library_Reference_0;

	public static String WasJ2eeValidator_WasSecuritySubjectConstraint_In_Invalid_Context;
	public static String WasJ2eeValidator_Constraint_Attribute_Undefined_0;
	public static String WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Registry_0;
	public static String WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_Os_0;
	public static String WasJ2eeValidator_Required_Security_Subject_Not_Found_Reason_NotFound_0;
	public static String WasJ2eeValidator_Server_Security_Properties_Not_Specified;
	public static String WasJ2eeValidator_Server_Security_Inconsistent;
	public static String Resolution_Configure_Was_Security_Disabled;
	public static String Resolution_Configure_Was_Security_Enabled_0;
	public static String Resolution_Remove_Constraint;

	public static String WasJ2eeValidator_WasWarClassloaderPolicyConstraint_In_Invalid_Context;
	public static String WasJ2eeValidator_WasModuleStartWeightConstraint_In_Invalid_Context;
	public static String WasJ2eeValidator_WasJNDIBindingConstraint_In_Invalid_Context;
	public static String WasJ2eeValidator_WasJNDIBindingConstraint_Jndi_Name_Of_Capability_Does_Not_Match;
	public static String WasJ2eeValidator_WasJNDIBindingConstraint_Jndi_Name_Does_Not_Match;
	public static String Validator_Optional_Constraint_Not_Present_0;
	public static String Validator_Too_Many_Constraints_Present_0;

	public static String Validator_Unit_Not_Unique_On_Host;

	public static String Validator_Cannot_identify_target_database_for_datasource;
	public static String Validator_Database_name_does_not_match_defined_databases;

	public static String Resolution_move_Was_Node_Unit_0_Out_of_Cell_1;
	public static String Resolution_create_Default_Was_Node_Unit_for_StandAlone_CellUnit_0;
	public static String Resolution_create_Dmgr_Was_Node_Unit_for_Distributed_CellUnit_0;
	public static String Resolution_create_Default_Was_NodeGroup_Unit_for_CellUnit_0;
	public static String Resolution_create_Default_Was_Server1_Unit_for_Empty_Default_NodeUnit_0;
	public static String Resolution_move_Redundant_Servers_Other_Than_ServerUnit_0_Out_of_DefaultNodeUnit_1;
	public static String Resolution_move_Invalid_MemberUnit_0_Outof_GroupUnit_1;
	public static String Resolution_add_MemberUnit_0_into_GroupUnit_1;
	public static String Resolution_departFrom_Redundant_GroupingUnit_Other_Than_GroupUnit_0_for_MemberUnit_1;
	public static String Resolution_create_datasourceUnit_0_on_jdbcProviderUnit_1;
	public static String Resolution_create_datasourceUnit_0_in_scope_1;
	public static String Resolution_move_ApplicationUnit_0_from_ServerUnit_1_to_ClusterUnit_2;
	public static String Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_OS_unit_1;
	public static String Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_DB2RuntimeClient_unit_1;
	public static String Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_DB2ClientInstance_1;
	public static String Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_DB2NodeCatalogUnit_1;
	public static String Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0;
	public static String Resolution_make_wasNode_0_defaultProfile_of_wasSystemUnit_1;
	public static String Resolution_create_server_in_WasNodeUnit_0_as_clusterUnit_1_member;
	public static String Resolution_add_server_0_as_clusterUnit_1_member;
	public static String Resolution_unlink_Unit_0_with_Unit_1;
	public static String Resolution_set_wasSystem_0_ND_Edition;
	public static String Resolution_undistribute_was_cell_0;
	public static String Resolution_Invalid_Number_Of_Dmgr_Unit;
	public static String Resolution_unhost_distributed_was_cell_from_base_system;
	public static String Resolution_refactor_NodeGroup_Into_Default_Was_NodeGroup_Unit_for_CellUnit;
	public static String Resolution_create_required_authentication_unit;
	public static String Resolution_create_required_authentication_unit_description;
	public static String Resolution_create_default_node_group_name;
	public static String Resolution_create_default_node_group_description;
	public static String Resolution_create_deployment_manager_node_description;
	public static String Resolution_create_deployment_manager_description;
	public static String Resolution_create_node_description;
	public static String Resolution_create_server_description;
	public static String Resolution_create_required_standalone_cell;
	public static String Resolution_create_required_distributed_cell;
	public static String Resolution_create_required_node_group;
	public static String Resolution_associate_node_with_profile;
	public static String Resolution_create_new_cluster_member;
	public static String Resolution_assign_to_profile;
	public static String Resolution_configure_global_security_display_name;
	public static String Resolution_create_runtime_client_description;
	public static String Resolution_create_database_catalog_description;
	public static String Resolution_create_node_catalog_description;
	public static String Resolution_create_client_instance_description;
	public static String Resolution_create_datasource_description;
	public static String Resolution_create_jdbc_provider_description;
	public static String Resolution_host_web_server_on_new_node;
	public static String Unhost_0_from_1;

	public static String Resolution_configure_new_shared_library_from_module_for_access_to_0;
	public static String Resolution_configure_new_shared_library_from_app_for_access_to_0;
	public static String Resolution_configure_new_shared_library_from_server_for_access_to_0;
	public static String Resolution_delete_shared_library_0;
	public static String Resolution_create_new_shared_library_from_app_for_access_to_0;
	public static String Resolution_add_to_existing_shared_library_0_from_app_for_access_to_1;
	public static String Resolution_add_WasModuleStartWeightConstraint;
	public static String Resolution_add_ClassloaderPolicyConstraint;
	public static String Resolution_add_WasSecuritySubjectConstraint;
	public static String Resolution_add_WasJNDIBindingConstraint_on_0;
	public static String Resolution_add__all_WAS_specific_constraints;
	public static String Resolution_unhost_other_units;
	public static String Resolution_unhost_other_units_failure;

	public static String Action_Federate_Node_To_Cell_0;
	public static String Action_Create_Shared_Library_For_Application_0;
	public static String Action_Promote_Server_To_Existing_Cluster_0;
	public static String Action_Promote_Server_To_New_Cluster_0;
	public static String Action_Host_Cluster_On_Cell_With_Node_Group_0;
	public static String Action_Refactor_Was_Base_System_To_ND_0;
	public static String Action_Create_New_Cluster_Member_On_Node_0;

	public static String WasProductVersionUnitAmplifier_Product_versio_;

	public static String WasJNDIBindingConstraintValidator_WebSphere_JNDI_Binding_;

	public static String WasHostingLinkMatcherFilter_WebSphere_Application_Server_cannot_;

	public static String WasHostingLinkMatcherFilter_WebSphere_Application_Server_cannot__2;

	// /////////////////////////////////////////////////////////////////////////////////////

	static {
		NLS.initializeMessages(BUNDLE_NAME, WasDomainMessages.class);
	}

}
