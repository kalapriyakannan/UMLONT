/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Class containing static status messages returned by Matcher Capability.
 */
public class DeployMatcherStatus {

	/**
	 * Status message indicating that a match was found.
	 */
	public static IStatus MATCH_FOUND = new Status(IStatus.OK, DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Match_found_, null);

	/**
	 * Status message indicating that a match was not found.
	 */
	public static IStatus MATCH_NOT_FOUND = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Match_not_found_, null);

	/**
	 * Status message indicating that a match was not rejected.
	 */
	public static IStatus MATCH_NOT_REJECTED = new Status(IStatus.OK, DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Match_not_rejected_, null);

	/**
	 * Status message indicating that a match was not found because source and target were the same
	 * unit.
	 */
	public static IStatus CANNOT_CREATE_LINK_TO_SELF = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Cannot_Create_Link_To_Self, null);

	/**
	 * Status message indicating that a match was not found because a realization cycle was detected
	 */
	public static IStatus REALIZATION_CYCLE = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID,
			0, DeployCoreMessages.DeployMatcherStatus_Realization_Cycle, null);

	/**
	 * Status message indicating that a match was not found because a link already exists between the
	 * source and the target
	 */
	public static IStatus LINK_ALREADY_PRESENT = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Link_Already_Present, null);

	/**
	 * Status message indicating that a match was not found for a hosting link.
	 */
	public static IStatus HOSTING_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Hosting_Link_Not_Possible, null);

	/**
	 * Status message indicating that a hosting link to a private unit may not be created.
	 */
	public static IStatus PRIVATE_UNIT_CANNOT_BE_HOSTED = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Private_Unit_Cannot_Be_Hosted, null);

	/**
	 * Status message indicating that a hosting link from a private unit may not be created.
	 */
	public static IStatus PRIVATE_UNIT_CANNOT_BE_HOST = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Private_Unit_Cannot_Be_Host, null);

	/**
	 * Status message indicating that a hosting link to a private unit may not be created.
	 */
	public static IStatus PRIVATE_UNIT_CANNOT_BE_REALIZED = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Private_Unit_Cannot_Be_Realized, null);

	/**
	 * Status message indicating that a hosting link from a private unit may not be created.
	 */
	public static IStatus PRIVATE_UNIT_CANNOT_BE_REALIZATION_TARGET = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Private_Unit_Cannot_Be_Realization_Target, null);

	/**
	 * Status message indicating that a hosting link to a private unit may not be created.
	 */
	public static IStatus PRIVATE_REQUIREMENT_CANNOT_BE_LINK_SOURCE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Private_Requirement_Cannot_Be_Link_Source, null);

	/**
	 * Status message indicating that a hosting link from a private unit may not be created.
	 */
	public static IStatus PRIVATE_CAPABILITY_CANNOT_BE_LINK_TARGET = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Private_Capability_Cannot_Be_Link_Target, null);

	/**
	 * Status message indicating that a match was not found for a member link.
	 */
	public static IStatus MEMBER_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Member_Link_Not_Possible, null);

	/**
	 * Status message indicating that a match was not found for a realization link.
	 */
	public static IStatus REALIZATION_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Not_Possible, null);

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * link type
	 */
	public static IStatus REALIZATION_LINK_TYPE_MISMATCH = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Type_Mismatch, null);

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * link stereotypes
	 */
	public static IStatus REALIZATION_LINK_STEREOTYPE_MISMATCH = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Stereotype_Mismatch, null);

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * link type
	 */
	public static IStatus REALIZATION_LINK_CAPABILITY_LINK_TYPE_MISMATCH = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Capability_Link_Type_Mismatch,
			null);

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * link type
	 */
	public static IStatus REALIZATION_LINK_REQUIREMENT_LINK_TYPE_MISMATCH = new Status(
			IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Requirement_Link_Type_Mismatch,
			null);

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * dmo type
	 */
	public static IStatus REALIZATION_LINK_REQUIREMENT_DMO_TYPE_MISMATCH = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Requirement_Dmo_Type_Mismatch,
			null);

	/**
	 * Status message indicating that a match was not found for a realization link due to mismatched
	 * "use"
	 */
	public static IStatus REALIZATION_LINK_REQUIREMENT_USE_MISMATCH = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Link_Requirement_Use_Mismatch, null);

	/**
	 * Status message indicating that a match was not found for a dependency link.
	 */
	public static IStatus DEPENDENCY_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Dependency_Link_Not_Possible, null);

	/**
	 * Status message indicating that a match was not found because the unit's initial install state
	 * is "installed".
	 */
	public static IStatus CANNOT_ADD_DEPENDENCIES_TO_INSTALLED_UNIT = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Cannot_Add_Dependencies_To_Installed_Unit, null);

	/**
	 * Status message indicating that a match was not found for a logical link.
	 */
	public static IStatus LOGICAL_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Logical_Link_Not_Possible, null);

	/**
	 * Status message indicating that a match was not found for a logical link.
	 */
	public static IStatus LOGICAL_HOSTING_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Logical_Hosting_Link_Not_Possible, null);

	/**
	 * Status message indicating that a match was not found for a unit link.
	 */
	public static IStatus UNIT_LINK_NOT_POSSIBLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Unit_Link_Not_Possible, null);

	/**
	 * Status message indicating that a match was not found for a logical link because one was
	 * already present.
	 */
	public static IStatus LOGICAL_LINK_ALREADY_PRESENT = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Logical_Link_Already_Present, null);

	/**
	 * Status message indicating that a match was not found because the hostee was found to have an
	 * initial install state of "installed".
	 */
	public static IStatus INSTALLED_UNIT_CANNOT_BE_HOSTED = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Installed_Unit_Cannot_Be_Hosted, null);

	/**
	 * Status message indicating that a match was not found because the source unit had an initial
	 * install state of "installed".
	 */
	public static IStatus INSTALLED_UNIT_CANNOT_BE_SOURCE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Installed_Unit_Cannot_Be_Source, null);

	/**
	 * Status message indicating that a match was not found because the source unit is not a
	 * conceptual unit
	 */
	public static IStatus SOURCE_NOT_CONCEPTUAL = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Source_Must_Be_Conceptual, null);

	/**
	 * Status message indicating that hoster of conceptual unit is invalid.
	 */
	public static IStatus CONCEPTUAL_INVALID_HOSTER = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Invalid_Hoster, null);

	/**
	 * Status message indicating that hostees of conceptual unit are invalid.
	 */
	public static IStatus CONCEPTUAL_INVALID_HOSTEES = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Invalid_Hostees, null);

	/**
	 * Status message indicating that a dependency link target of conceptual unit is invalid.
	 */
	public static IStatus CONCEPTUAL_INVALID_DL_TARGET = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Invalid_DL_Target, null);

	/**
	 * Status message indicating that dependency link sources of conceptual unit are invalid.
	 */
	public static IStatus CONCEPTUAL_INVALID_DL_SOURCES = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Invalid_DL_Sources, null);

	/**
	 * Status message indicating that groups of conceptual unit are invalid.
	 */
	public static IStatus CONCEPTUAL_INVALID_GROUPS = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Invalid_Groups, null);

	/**
	 * Status message indicating that memmbers of conceptual unit are invalid.
	 */
	public static IStatus CONCEPTUAL_INVALID_MEMBERS = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.DeployMatcherStatus_Realization_Invalid_Members, null);

	/**
	 * Use this code to indicate status message is custom
	 */
	public static int CUSTOM_MESSAGE_CODE = -1;

	public static int REALIZATION_LINK_UNMATCHED_CAPABILITY = -2;
	public static int REALIZATION_LINK_UNMATCHED_REQUIREMENT = -3;
	public static int REALIZATION_LINK_CAPABILITY_PAIR = -4;

	public static int LINK_SOURCE_PROPOSED = 1;

	/**
	 * Create a status indicating that a match was not found with a specialized error message.
	 * 
	 * @param message
	 *           the error message
	 * @return the status
	 */
	public static IStatus createMatchNotFound(String message) {
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, CUSTOM_MESSAGE_CODE, message,
				null);
	}

	/**
	 * Create a status indicating that a match was not found with a specialized error message.
	 * 
	 * @param message
	 *           the error message
	 * @param params
	 *           Parameters for the message string
	 * @return the status
	 */
	public static IStatus createMatchNotFound(String message, Object params[]) {
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, CUSTOM_MESSAGE_CODE, DeployNLS
				.bind(message, params), null);
	}

	/**
	 * Create a status indicating that a match was not found with a specialized error message.
	 * 
	 * @param code
	 *           the error code
	 * @param message
	 *           the error message
	 * @param params
	 *           Parameters for the message string
	 * @return the status
	 */
	public static IStatus createMatchNotFound(int code, String message, Object params[]) {
		return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, code, DeployNLS.bind(message,
				params), null);
	}

	public static IStatus createDependencyMatchFound(int code) {
		return new Status(IStatus.OK, DeployCorePlugin.PLUGIN_ID, code,
				DeployCoreMessages.DeployMatcherStatus_Match_found_, null);
	}

	/**
	 * Create a status message in which the proposed link source (ie, determined by the matching
	 * method) is identified by a path name in the body of the status message.
	 * 
	 * @param req
	 *           the proposed source
	 * @return the status
	 */
	public static IStatus createMatchFoundWithRequirement(Requirement req) {
		return new Status(IStatus.OK, DeployCorePlugin.PLUGIN_ID, LINK_SOURCE_PROPOSED, req
				.getFullPath(), null);
	}
}
