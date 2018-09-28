/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.uml;

import org.eclipse.osgi.util.NLS;

/**
 * The externalized strings for the UML domain.
 */
public class UMLDomainMessages extends NLS {

	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.uml.messages"; //$NON-NLS-1$

	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	public static String Unit_0_missing_connection_to_unit_1;
	public static String Unit_0_missing_connection_to_unit_1_from_2;

	public static String Create_Communication_constraint_from_0_to_1;
	public static String Create_Communication_constraint;

	public static String UMLInteractionConstraintValidator_Could_not_resolve_0_;

	public static String UMLInteractionConstraintValidator_add_statu_;

	public static String UMLInteractionConstraintValidator_UML_resource_0_could_not_be_acces_;

	public static String UMLInteractionConstraintValidator_File_in_UMLInteraction_constraint_d_;

	public static String UMLElementUnitValidator_Could_not_resolve_UML_type_0;

	public static String UMLElementUnitValidator_Missing_UML_stereotype_keyword_0_profile_1;

	public static String UMLElementUnitValidator_Extra_UML_stereotype_keyword_0_profile_1;

	public static String Delete_element_from_topology;

	public static String Create_missing_stereotype;

	public static String Resolution_add_missing_uml_stereotype_to_0;

	public static String DeployModelSourceSynchronizationProvider_create_VizOperatio_;

	public static String DeployModelSourceSynchronizationProvider_empty_operatio_;

	public static String DeployModelSourceSynchronizationProvider_create_VizDependency_;

	public static String DeployModelSourceSynchronizationProvider_empty_dependency_;

	public static String COMPONENT_VALIDATE_NODE_COMMUNICATION;
	public static String ACTOR_VALIDATE_LOCATION_COMMUNICATION;

	public static String OperationStructuredReferenceHandler_create_Uml_Operatio_;

	static {
		NLS.initializeMessages(BUNDLE_NAME, UMLDomainMessages.class);
	}

}
