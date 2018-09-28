/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.generic.ui.internal;

import org.eclipse.osgi.util.NLS;

public class GenericMessages extends NLS {

	public static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.generic.ui.internal.messages"; //$NON-NLS-1$
	public static String RelationshipBasisDialog_Relationship_Basis_;
	public static String RelationshipBasisDialog_Hoster_Capability_;
	public static String RelationshipBasisDialog_Hoster_attribute_;
	public static String GenericPropertySection_Custom_attributes_;
	public static String GenericPropertySection_Additional_Capabilities_;
	public static String GenericPropertySection_Type_;
	public static String GenericPropertySection_Name_;
	public static String GenericLinkDialog_New_Relationship_;
	public static String GenericLinkDialog_Depend_upon_another_Unit_;
	public static String GenericLinkDialog_Be_hosted_by_another_Unit_;
	public static String GenericLinkDialog_Be_required_by_another_Unit_;
	public static String GenericLinkDialog_Host_another_unit_;
	public static String GenericLinkDialog_Clear_Selection_;
	public static String GenericLinkDialog_Capability_or_attribute_to_bind_;
	public static String GenericLinkDialog_Relationship_;
	public static String GenericLinkDialog_Unit_to_be_hosted_by_;
	public static String GenericLinkDialog_Unit_to_host_;
	public static String GenericLinkDialog_Unit_to_require_;
	public static String GenericLinkDialog_Unit_to_be_required_by_;
	public static String GenericLinkDialog_Select_Attribute_or_Capability_;
	public static String GenericLinkDialog_Supply_comparison_value_;
	public static String GenericLinkDialog_Select_Unit_;
	public static String GenericLinkDialog_Set_Extended_Attribute_;
	public static String DepRelationshipBasisDialog_Target_isA_;
	public static String DepRelationshipBasisDialog_Target_Capability_;
	public static String GenericPropertySection_isA_;
	public static String GenericPropertySection_New_Unit_Hosting_;
	public static String GenericPropertySection_New_Unit_Dependency_;
	public static String DepRelationshipBasisDialog_Target_attribute_;

	// Note: script and archive messages moved to the operation UI domain OperationMessages

	static {
		NLS.initializeMessages(BUNDLE_NAME, GenericMessages.class);
	}

}
