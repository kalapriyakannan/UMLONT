/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.uml.internal.validator;

import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.uml.Activator;
import com.ibm.ccl.soa.deploy.uml.UMLComponent;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * {@link IDeployStatus#getValidatorID()} declarations for the {@link UmlPackage} deploy domain.
 */
public interface IUMLDomainValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#UNIT_MISSING_CONNECTION_001}
	 * <li>Description = This component should have a connection to another component.
	 * </ul>
	 */
	public final static String UNIT_MISSING_CONNECTION_001 = Activator.PLUGIN_ID
			+ ".UNIT_MISSING_CONNECTION_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#UNRESOLVED_ELEMENT_001}
	 * <li>Description = This component's backing type cannot be resolved.
	 * </ul>
	 */
	public final static String UNRESOLVED_ELEMENT_001 = Activator.PLUGIN_ID
			+ ".UNRESOLVED_ELEMENT_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#MISSING_UML_STEREOTYPE_001}
	 * <li>Description = This uml element is missing a stereotype defined by its backing uml
	 * element.
	 * </ul>
	 */
	public final static String MISSING_UML_STEREOTYPE_001 = Activator.PLUGIN_ID
			+ ".MISSING_UML_STEREOTYPE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#EXTRA_UML_STEREOTYPE_001}
	 * <li>Description = This uml element has an extra stereotype that is not defined by its backing
	 * uml element.
	 * </ul>
	 */
	public final static String EXTRA_UML_STEREOTYPE_001 = Activator.PLUGIN_ID
			+ ".EXTRA_UML_STEREOTYPE_001"; //$NON-NLS-1$	
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#COMMUNICATION_LINK_UNDEFINED}
	 * <li>Description = If two Components communicate then the nodes they are hosted on should
	 * communicate as well.
	 * </ul>
	 */
	public static String COMPONENT_VALIDATE_NODE_COMMUNICATION = Activator.PLUGIN_ID
			+ ".COMPONENT_VALIDATE_NODE_COMMUNICATION"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#COMMUNICATION_LINK_UNDEFINED}
	 * <li>Description = If two actors communicate then the locations they are member of should
	 * communicate as well.
	 * </ul>
	 */
	public static String ACTOR_VALIDATE_LOCATION_COMMUNICATION = Activator.PLUGIN_ID
			+ ".ACTOR_VALIDATE_LOCATION_COMMUNICATION"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link IUMLProblemType#UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID}
	 * <li>Description = A UML {@link SoftwareComponent} should have a capability of type
	 * {@link UMLComponent}.
	 * </ul>
	 */
	public final static String UML_SOFTWARE_COMPONENT_001 = Activator.PLUGIN_ID
			+ ".UML_SOFTWARE_COMPONENT_001"; //$NON-NLS-1$	

}
