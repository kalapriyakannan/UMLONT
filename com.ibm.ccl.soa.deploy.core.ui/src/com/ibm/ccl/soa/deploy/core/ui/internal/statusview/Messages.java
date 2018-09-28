/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.osgi.util.NLS;

/**
 * Common messages used by publish problem view
 * 
 * @author <a mailto:fenglin@cn.ibm.com>Ella Feng</a>
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.core.ui.internal.statusview.messages";//$NON-NLS-1$

	public static String Field_Unit_Name;
	public static String Field_Exception_Name;
	public static String Field_Message_Name;
	public static String Field_ProblemType_Name;
	public static String Field_Publisher_Name;
	public static String Field_Severity_Name;
	public static String Field_Topology_Name;

	public static String NULL_MESSAGE;
	public static String PublisherProblems_UpdateStatusJob_Name;

	public static String Views_Action_ClearStatus_Text;
	public static String Views_Action_ClearStatus_Tip;
	public static String Views_Action_Sort_Text;
	public static String Views_Action_GroupBy_Text;
	public static String Views_Action_SelectFilter_Text;
	public static String Views_Action_ConfigFilter_Text;
	public static String Views_Action_SelectAll_Text;
	public static String Views_Action_GroupBy_Tip;
	public static String Views_Action_Filter_Tip;
	public static String Views_Action_StatusDetails_Text;
	public static String Views_Category_Title;

	public static String Filter_Dialog_Title;
	public static String Filter_Area_UserFilter_Label;

	public static String Dialog_Add_New_Filter_Title;
	public static String Dialog_Add_New_Filter_Message;
	public static String Dialog_Add_New_Filter_InitValue;
	public static String Dialog_Add_New_Filter_EmptyName;
	public static String Dialog_Add_New_Filter_InvalidName;
	public static String Status_Severity;
	public static String Dialog_Sort_Title;
	public static String Dialog_Sort_Label;
	public static String Dialog_Sort_Column_Label;
	public static String Dialog_Restore_Default;
	public static String Dialog_Sort_Direction_Ascending_Text;
	public static String Dialog_Sort_Direction_Ascending_Text2;
	public static String Dialog_Sort_Direction_Ascending_Text3;
	public static String Dialog_Sort_Direction_Ascending_Text4;
	public static String Dialog_Sort_Direction_Descending_Text;
	public static String Dialog_Sort_Direction_Descending_Text2;
	public static String Dialog_Sort_Direction_Descending_Text3;
	public static String Dialog_Sort_Direction_Descending_Text4;

	public static String Combo_Contains;
	public static String Combo_Does_Not_Contain;

	public static String Button_Reset;
	public static String Button_New;
	public static String Button_Remove;
	public static String Button_Select_All;
	public static String Button_Deselect_All;
	public static String Button_Select_More;
	public static String Button_Resource_Any;
	public static String Button_Resource_Selected;
	public static String Button_Resource_WorkingSet;
	public static String Button_Resource_NoWorkingSet;
	public static String Button_Severity;
	public static String Button_Entry_Enablement;
	public static String Button_Severity_Error;
	public static String Button_Severity_Warn;
	public static String Button_Severity_Info;

	public static String Views_Action_Copy;

	public static String ResourceUtils_The_active_workbench_window_could_n_;

	public static String DiscoveryOptionsPage_User_defines_link_relationship_used_;

	static {
		// load message values from bundle file
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

}
