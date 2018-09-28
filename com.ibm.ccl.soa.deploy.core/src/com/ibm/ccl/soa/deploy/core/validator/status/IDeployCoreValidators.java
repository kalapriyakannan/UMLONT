/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationProtocolConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;

/**
 * Static unique identifiers for SOA deploy core validators ({@link CorePackage}).
 */
public interface IDeployCoreValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = An artifact contains no URIs.
	 * </ul>
	 */
	public final static String ARTIFACT_001 = DeployCorePlugin.PLUGIN_ID + ".ARTIFACT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#FILE_ARTIFACT_URI_INVALID}
	 * <li>Description = an artifact URI is null or empty.
	 * </ul>
	 */
	public final static String ARTIFACT_002 = DeployCorePlugin.PLUGIN_ID + ".ARTIFACT_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID}
	 * <li>Description = capability has an invalid number of instances based on the type constraints
	 * added to the unit validator ({@link UnitValidator#addCapabilityTypeConstraint(org.eclipse.emf.ecore.EClass, com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes, int, int)}).
	 * </ul>
	 */
	public final static String CAPABILITY_001 = DeployCorePlugin.PLUGIN_ID + ".CAPABILITY_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_CAPABILITY_TYPE_INVALID}
	 * <li>Description = unit contains an unexpected capability based on ({@link UnitValidator#addCapabilityTypeConstraint(org.eclipse.emf.ecore.EClass, com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes, int, int)})
	 * and when {@link UnitValidator#setAllowUnexpectedCapabilityTypes(boolean)} is set to false.
	 * </ul>
	 */
	public final static String CAPABILITY_002 = DeployCorePlugin.PLUGIN_ID + ".CAPABILITY_002"; //$NON-NLS-1$

	/**
	 * Generic placeholder for unassigned validator IDs.
	 * 
	 * @deprecated create unique validator identifier
	 */
	public static final String CORE_UNASSIGNED = DeployCorePlugin.PLUGIN_ID + ".CORE_UNASSIGNED"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_SOURCE_INVALID}
	 * <li>Description = a dependency link has been created for a requirement whose link type is not
	 * {@link RequirementLinkTypes#DEPENDENCY} or {@link RequirementLinkTypes#ANY}.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_001 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_ENDPOINT_TYPE_MISMATCH}
	 * <li>Description = a dependency link failed to validate against one or more requirement
	 * expressions.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_002 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_DEPENDENCY_REQUIREMENT_UNMATCHED}
	 * <li>Description = a unit contains a required dependency with to dependency link.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_003 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_CONTAINER_UNDEFINED}
	 * <li>Description = the parent container of a dependency link is null.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_004 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_UNDEFINED}
	 * <li>Description = the target of a dependency link is null.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_005 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_CONTAINER_UNDEFINED}
	 * <li>Description = the parent container of the capability target of a dependency link is null.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_006 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_006"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DEPENDENCY_LINK_TARGET_INVALID}
	 * <li>Description = the target of a dependency link is not a capability with link type
	 * DEPENDENCY or ANY.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_007 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_007"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNRESOLVABLE}
	 * <li>Description = a dependency link has a target URI that cannot be resolved.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_008 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_008"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNCONTAINED}
	 * <li>Description = a dependency link has a target that is not contained in a topology.
	 * resolved.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_009 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_009"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REQUIREMENT_HAS_MULTIPLE_DEPENDENCIES}
	 * <li>Description = a requirement depends on more than one capabilities.
	 * </ul>
	 */
	public final static String DEPENDENCY_LINK_010 = DeployCorePlugin.PLUGIN_ID
			+ ".DEPENDENCY_LINK_010"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_NOT_HOSTED}
	 * <li>Description = uninstalled unit with hosting requirements is not hosted.
	 * </ul>
	 */
	public final static String HOSTING_001 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_MULTIPLE_HOSTS}
	 * <li>Description = unit has multiple hosts.
	 * </ul>
	 */
	public final static String HOSTING_002 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HOSTING_REQUIREMENT_UNMATCHED}
	 * <li>Description = a hosting requirement of a unit is not satisfied by a capability of its
	 * hoster.
	 * </ul>
	 */
	public final static String HOSTING_003 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_TARGET_INVALID}
	 * <li>Description =a hosting requirement of a unit is not satisfied by a capability of its
	 * hoster.
	 * </ul>
	 */
	public final static String HOSTING_004 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HOST_TO_BE_UNINSTALLED}
	 * <li>Description = the host of an installed unit will be uninstalled.
	 * </ul>
	 */
	public final static String HOSTING_005 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_SOURCE_IS_NOT_CONTAINER}
	 * <li>Description = a hosting link is contained in a different unit from its source (violates
	 * current validator assumptions).
	 * </ul>
	 */
	public final static String HOSTING_LINK_001 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HOST_NOT_INSTALLED}
	 * <li>Description = an installed unit is hosted on an non-installed host.
	 * </ul>
	 */
	public final static String HOSTING_LINK_002 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_TARGET_UNDEFINED}
	 * <li>Description = a hosting link has a null target.
	 * </ul>
	 */
	public final static String HOSTING_LINK_003 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_CONTAINER_UNDEFINED}
	 * <li>Description = a hosting link does not have a parent container.
	 * </ul>
	 */
	public final static String HOSTING_LINK_004 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_CONTAINER_UNDEFINED}
	 * <li>Description = a hosting link is not indirectly contained in a topology.
	 * </ul>
	 */
	public final static String HOSTING_LINK_005 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#HOSTING_LINK_TARGET_HAS_NO_HOSTING_REQUIREMENTS}
	 * <li>Description = the target of a hosting link (hosted unit) does not have any hosting
	 * requirements.
	 * </ul>
	 */
	public final static String HOSTING_LINK_006 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_006"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNRESOLVABLE}
	 * <li>Description = the target of a hosting link (hosted unit) is a URI that cannot be
	 * resolved.
	 * </ul>
	 */
	public final static String HOSTING_LINK_007 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_007"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNCONTAINED}
	 * <li>Description = the target of a hosting link (hosted unit) is not contained in a topology.
	 * </ul>
	 */
	public final static String HOSTING_LINK_008 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_008"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HOST_WILL_BE_UNINSTALLED}
	 * <li>Description = the host of an installed unit will be uninstalled.
	 * </ul>
	 */
	public final static String HOSTING_LINK_009 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_009"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HOST_WILL_BE_UNINSTALLED}
	 * <li>Description = the host of a unit will be uninstalled.
	 * </ul>
	 */
	public final static String HOSTING_LINK_010 = DeployCorePlugin.PLUGIN_ID + ".HOSTING_LINK_010"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#MEMBER_LINK_TARGET_UNDEFINED}
	 * <li>Description = a member link has a null target.
	 * </ul>
	 */
	public final static String MEMBER_LINK_001 = DeployCorePlugin.PLUGIN_ID + ".MEMBER_LINK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#MEMBER_LINK_TARGET_INVALID}
	 * <li>Description = a group contains a member whose type does not match the any of the MEMBER
	 * requirement dmoTypes.
	 * </ul>
	 */
	public final static String MEMBER_LINK_002 = DeployCorePlugin.PLUGIN_ID + ".MEMBER_LINK_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#MULTIPLE_MEMBER_LINKS_BETWEEN_UNITS}
	 * <li>Description = Group contains a member whose unit type is not one of those permitted by
	 * its member requirements.
	 * </ul>
	 */
	public final static String MEMBER_LINK_003 = DeployCorePlugin.PLUGIN_ID + ".MEMBER_LINK_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNRESOLVABLE}
	 * <li>Description = a target URI of a member link cannot be resolved.
	 * </ul>
	 */
	public final static String MEMBER_LINK_004 = DeployCorePlugin.PLUGIN_ID + ".MEMBER_LINK_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_NOT_CONTAINED}
	 * <li>Description = a membership link targets a unit that is not contained in a topology.
	 * </ul>
	 */
	public final static String MEMBER_LINK_005 = DeployCorePlugin.PLUGIN_ID + ".MEMBER_LINK_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = a member link requirement has a dmoType value that is not a subtype of
	 * {@link Unit}.
	 * </ul>
	 */
	public final static String MEMBER_REQUIREMENT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".MEMBER_REQUIREMENT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = the name of a {@link DeployModelObject} is null or empty.
	 * </ul>
	 */
	public final static String OBJECT_NAME_001 = DeployCorePlugin.PLUGIN_ID + ".OBJECT_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = the name of a {@link DeployModelObject} contains invalid characters.
	 * </ul>
	 */
	public final static String OBJECT_NAME_002 = DeployCorePlugin.PLUGIN_ID + ".OBJECT_NAME_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
	 * <li>Description = the name attribute of a {@link DeployModelObject} is not unique in its
	 * container.
	 * </ul>
	 */
	public final static String OBJECT_NAME_003 = DeployCorePlugin.PLUGIN_ID + ".OBJECT_NAME_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HOST_DO_NOT_PUBLISH}
	 * <li>Description = unit is host is not installed and has will not be published.
	 * </ul>
	 */
	public final static String PUBLISH_STATE_001 = DeployCorePlugin.PLUGIN_ID + ".PUBLISH_STATE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = A validator where both the {@link Service} and {@link Reference} interfaces
	 * are set but they don't match.
	 * </ul>
	 */
	public final static String REFERENCE_INTERFACE_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REFERENCE_INTERFACE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = A validator where the {@link Service} interface is set but the
	 * {@link Reference} interface is not set.
	 * </ul>
	 */
	public final static String REFERENCE_INTERFACE_002 = DeployCorePlugin.PLUGIN_ID
			+ ".REFERENCE_INTERFACE_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = A validator where the {@link Reference} interface is set but the
	 * {@link Service} interface is not set.
	 * </ul>
	 */
	public final static String REFERENCE_INTERFACE_003 = DeployCorePlugin.PLUGIN_ID
			+ ".REFERENCE_INTERFACE_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_REQUIREMENT_TYPE_CARDINALITY_INVALID}
	 * <li>Description = requirement has an invalid number of instances based on the type
	 * constraints added to the unit validator ({@link UnitValidator#addRequirementTypeConstraint(org.eclipse.emf.ecore.EClass, com.ibm.ccl.soa.deploy.core.RequirementLinkTypes, int, int)}).
	 * </ul>
	 */
	public final static String REQUIREMENT_001 = DeployCorePlugin.PLUGIN_ID + ".REQUIREMENT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_REQUIREMENT_TYPE_INVALID}
	 * <li>Description = unit contains an unexpected requirement based on ({@link UnitValidator#addRequirementTypeConstraint(org.eclipse.emf.ecore.EClass, com.ibm.ccl.soa.deploy.core.RequirementLinkTypes, int, int)})
	 * and when {@link UnitValidator#setAllowUnexpectedRequirementTypes(boolean)} is set to false.
	 * </ul>
	 */
	public final static String REQUIREMENT_002 = DeployCorePlugin.PLUGIN_ID + ".REQUIREMENT_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = The logical requirement is missing a physical requirement.
	 * </ul>
	 */
	public final static String REQUIREMENT_003 = DeployCorePlugin.PLUGIN_ID + ".REQUIREMENT_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = The logical requirement physical requirement set but it fails to resolve to
	 * another requirement on the parent unit.
	 * </ul>
	 */
	public final static String REQUIREMENT_004 = DeployCorePlugin.PLUGIN_ID + ".REQUIREMENT_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = The physical requirement is defined on a parent that is different from the
	 * logical requirement.
	 * </ul>
	 */
	public final static String REQUIREMENT_005 = DeployCorePlugin.PLUGIN_ID + ".REQUIREMENT_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = {@link Requirement#getDmoEType()} was not set because the
	 * {@link Requirement#getDmoType()} could not be deserialized.
	 * </ul>
	 */
	public final static String REQUIREMENT_DMO_ETYPE_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_DMO_ETYPE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNIT_HAS_NO_REQUIREMENTS_OR_CAPABILITIES}
	 * <li>Description = unit without requirements and capabilities.
	 * </ul>
	 */
	public final static String UNIT_001 = DeployCorePlugin.PLUGIN_ID + ".UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = {@link Unit#getGoalInstallState()} was set to NOT_INSTALLED when
	 * {@link Unit#getInitInstallState()} is not INSTALLED.
	 * </ul>
	 */
	public final static String UNIT_GOAL_INSTALL_STATE_001 = DeployCorePlugin.PLUGIN_ID
			+ ".UNIT_GOAL_INSTALL_STATE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_UNIT_NOT_REALIZED}
	 * <li>Description = conceptual unit is not realized.
	 * </ul>
	 */
	public final static String CONCEPTUAL_UNIT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#NON_CONCEPTUAL_UNIT_REALIZED}
	 * <li>Description = a concrete unit is realized (source of realization link)
	 * </ul>
	 */
	public final static String CONCEPTUAL_UNIT_002 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_UNIT_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_HAS_AMBIGUOUS_HOSTING_STACK}
	 * <li>Description = a concrete Unit realizes a Unit but is itself unhosted.
	 * </ul>
	 */
	public final static String CONCEPTUAL_UNIT_003 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_UNIT_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_UNIT_HAS_MULTIPLE_REALIZATION_LINKS}
	 * <li>Description = a conceptual unit is realized by more than one units.
	 * </ul>
	 */
	public final static String CONCEPTUAL_UNIT_004 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_UNIT_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CAPABILITY_ON_NON_CONCEPTUAL_UNIT_REALIZED}
	 * <li>Description = a capability on concrete unit is realized (source of realization link)
	 * </ul>
	 */
	public final static String CAP_ON_CONCEPTUAL_UNIT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CAP_ON_CONCEPTUAL_UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REQUIREMENT_ON_NON_CONCEPTUAL_UNIT_REALIZED}
	 * <li>Description = a requirement on concrete unit is realized (source of realization link)
	 * </ul>
	 */
	public final static String REQ_ON_CONCEPTUAL_UNIT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REQ_ON_CONCEPTUAL_UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZED_CAPABILITY_ON_NON_REALIZED_UNIT}
	 * <li>Description = a realized capability found on non-realized unit
	 * </ul>
	 */
	public final static String REALIZED_CAP_ON_NON_REALIZED_UNIT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZED_CAP_ON_NON_REALIZED_UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZED_REQUIREMENT_ON_NON_REALIZED_UNIT}
	 * <li>Description = a realized requirement found on non-realized unit
	 * </ul>
	 */
	public final static String REALIZED_REQ_ON_NON_REALIZED_UNIT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZED_REQ_ON_NON_REALIZED_UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CAPABILITY_HAS_MULTIPLE_REALIZATION_LINKS}
	 * <li>Description = a capability is realized by more than one capability.
	 * </ul>
	 */
	public final static String CAPABILITY_REALIZATION_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CAPABILITY_REALIZATION_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REQUIREMENT_HAS_MULTIPLE_REALIZATION_LINKS}
	 * <li>Description = a requirement is realized by more than one requirement.
	 * </ul>
	 */
	public final static String REQUIREMENT_REALIZATION_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_REALIZATION_001"; //$NON-NLS-1$	
	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CAPABILITY_REALIZATION_TARGET_INCONSISTENT}
	 * <li>Description = a capability is realized to a location inconsistent with parent's
	 * realization
	 * </ul>
	 */
	public final static String CAPABILITY_REALIZATION_002 = DeployCorePlugin.PLUGIN_ID
			+ ".CAPABILITY_REALIZATION_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#DMO_REALIZATION_TARGET_INCONSISTENT}
	 * <li>Description = a deploy model object is realized to a location inconsistent with parent's
	 * realization
	 * </ul>
	 */
	public final static String DMO_REALIZATION_002 = DeployCorePlugin.PLUGIN_ID
			+ ".DMO_REALIZATION_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REQUIREMENT_REALIZATION_TARGET_INCONSISTENT}
	 * <li>Description = a requirement is realized to a location inconsistent with parent's
	 * realization
	 * </ul>
	 */
	public final static String REQUIREMENT_REALIZATION_002 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_REALIZATION_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_SOURCE_INVALID}
	 * <li>Description = the realization link has source that is not either the unit containing the
	 * link or the a deploy model object contained directly or indirectly by the unit.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_INVALID_SOURCE_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_INVALID_SOURCE_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNRESOLVABLE}
	 * <li>Description = a realization link target URI cannot be resolved.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNDEFINED}
	 * <li>Description = a realization link has a null target.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_002 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_SOURCE_TARGET_TYPE_MISMATCH}
	 * <li>Description = a realization link is between incompatible types.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_003 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_SOURCE_TARGET_SAME}
	 * <li>Description = a realization link from a unit to itself.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_004 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_UNMATCHED_CAPABILITY}
	 * <li>Description = There is no matching capability on the target for at least one capability.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_005 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_UNMATCHED_REQUIREMENT}
	 * <li>Description = There is no matching requirement on the target for at least one
	 * requirement.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_006 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_006"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_UNMATCHED_ATTRIBUTE_VALUE}
	 * <li>Description = Attribute value mismatch between conceptual unit and its reaalization
	 * </ul>
	 */
	public final static String REALIZATION_LINK_007 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_007"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_CYCLE}
	 * <li>Description = Realization link is part of a realization cycle.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_008 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_008"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_UNMATCHED_ATTRIBUTE_METADATA}
	 * <li>Description = Attribute metadata mismatch between conceptual dmo and its reaalization
	 * </ul>
	 */
	public final static String REALIZATION_LINK_009 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_009"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_UNMATCHED_ATTRIBUTE}
	 * <li>Description = Attribute on conceptual (or capability) not found on its realization target
	 * </ul>
	 */
	public final static String REALIZATION_LINK_010 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_010"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_INVALID}
	 * <li>Description = Realization link is invalid, reason not known.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_011 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_011"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_INVALID}
	 * <li>Description = Realization link from conceptual nodes is to unit that does not satisfy
	 * hosting requirement of conceptual node
	 * </ul>
	 */
	public final static String REALIZATION_LINK_012 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_012"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REALIZATION_LINK_SOURCE_TARGET_STEREOTYPE_MISMATCH}
	 * <li>Description = a realization link is between mismatched stereotypes.
	 * </ul>
	 */
	public final static String REALIZATION_LINK_013 = DeployCorePlugin.PLUGIN_ID
			+ ".REALIZATION_LINK_013"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_INVALID_HOSTER}
	 * <li>Description = Conceptual unit has an invalid host
	 * </ul>
	 */
	public final static String CONCEPTUAL_INVALID_HOSTER_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_INVALID_HOSTER_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_INVALID_HOSTEES}
	 * <li>Description = Conceptual unit has invalid hostees
	 * </ul>
	 */
	public final static String CONCEPTUAL_INVALID_HOSTEES_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_INVALID_HOSTEES_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_INVALID_DL_TARGET}
	 * <li>Description = Conceptual unit has requirement with dependency link with invalid target
	 * </ul>
	 */
	public final static String CONCEPTUAL_INVALID_DL_TARGET_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_INVALID_DL_TARGET_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_INVALID_DL_SOURCES}
	 * <li>Description = Conceptual unit is target of dependency link from invalid sources
	 * </ul>
	 */
	public final static String CONCEPTUAL_INVALID_DL_SOURCES_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_INVALID_DL_SOURCES_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_INVALID_GROUPS}
	 * <li>Description = Conceptual unit is member of invalid groups
	 * </ul>
	 */
	public final static String CONCEPTUAL_INVALID_GROUPS_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_INVALID_GROUPS_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONCEPTUAL_INVALID_MEMBERS}
	 * <li>Description = Conceptual unit has invalid group members
	 * </ul>
	 */
	public final static String CONCEPTUAL_INVALID_MEMBERS_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONCEPTUAL_INVALID_MEMBERS_001"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNRESOLVABLE}
	 * <li>Description = the target URI of a logical link cannot be resolved.
	 * </ul>
	 */
	public final static String CONSTRAINT_LINK_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CONSTRAINT_LINK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNDEFINED}
	 * <li>Description = a logical link has no target.
	 * </ul>
	 */
	public final static String CONSTRAINT_LINK_002 = DeployCorePlugin.PLUGIN_ID
			+ ".CONSTRAINT_LINK_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_SOURCE_UNRESOLVABLE}
	 * <li>Description = the source URI of a logical link cannot be resolved.
	 * </ul>
	 */
	public final static String CONSTRAINT_LINK_003 = DeployCorePlugin.PLUGIN_ID
			+ ".CONSTRAINT_LINK_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_SOURCE_UNDEFINED}
	 * <li>Description = a logical link has no source.
	 * </ul>
	 */
	public final static String CONSTRAINT_LINK_004 = DeployCorePlugin.PLUGIN_ID
			+ ".CONSTRAINT_LINK_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNCONTAINED}
	 * <li>Description = a logical link has a source that is not contained in a topology.
	 * </ul>
	 */
	public final static String CONSTRAINT_LINK_005 = DeployCorePlugin.PLUGIN_ID
			+ ".CONSTRAINT_LINK_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#LINK_TARGET_UNCONTAINED}
	 * <li>Description = a logical link has a target that is not contained in a topology.
	 * </ul>
	 */
	public final static String CONSTRAINT_LINK_006 = DeployCorePlugin.PLUGIN_ID
			+ ".CONSTRAINT_LINK_006"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_CONTAINER_INVALID}
	 * <li>Description = The link source container is a topology when it should have been its
	 * source.
	 * </ul>
	 */
	public final static String TOPOLOGY_LINK_001 = DeployCorePlugin.PLUGIN_ID + ".TOPOLOGY_LINK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Topology#getNamespace()} is inconsistent with the source folder
	 * package location.
	 * </ul>
	 */
	public final static String TOPOLOGY_NAMESPACE_001 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_NAMESPACE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Topology#getNamespace()} should be null/empty.
	 * </ul>
	 */
	public final static String TOPOLOGY_NAMESPACE_002 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_NAMESPACE_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Topology} does not exist in a topology namespace folder.
	 * </ul>
	 */
	public final static String TOPOLOGY_NAMESPACE_003 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_NAMESPACE_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Topology#getName()} is not consistent with the name of the file
	 * containing it.
	 * </ul>
	 */
	public final static String TOPOLOGY_NAME_001 = DeployCorePlugin.PLUGIN_ID + ".TOPOLOGY_NAME_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = {@link Import#getPattern()} is not null.
	 * </ul>
	 */
	public final static String TOPOLOGY_IMPORT_PATTERN_001 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_IMPORT_PATTERN_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#TOPOLOGY_IMPORT_NOT_FOUND}
	 * <li>Description = a {@link Topology#getImports()} {@link Import} could not be resolved.
	 * </ul>
	 */
	public final static String TOPOLOGY_IMPORT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_IMPORT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#TOPOLOGY_IMPORT_CYCLE}
	 * <li>Description = a {@link Topology#getImports()} imports topologies in a cycle.
	 * </ul>
	 */
	public final static String TOPOLOGY_IMPORT_002 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_IMPORT_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#IMPORT_INSTANTIATION_NOT_RESOLVABLE}
	 * <li>Description = a {@link Instantiation} on an {@link InstanceConfiguration} on an
	 * {@link Import} is references a unresolvable {@link DeployModelObject}
	 * </ul>
	 */
	public final static String TOPOLOGY_IMPORT_003 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_IMPORT_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#IMPORT_INSTANTIATION_OBJECT_NOT_PUBLIC}
	 * <li>Description = a {@link Instantiation} on an {@link InstanceConfiguration} on an
	 * {@link Import} is references a {@link DeployModelObject} that was not exported by its
	 * topology's contract.
	 * </ul>
	 */
	public final static String TOPOLOGY_IMPORT_004 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_IMPORT_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#IMPORT_INSTANTIATION_OBJECT_ATTRIBUTE_NOT_EDITABLE}
	 * <li>Description = a {@link Property} of an {@link Instantiation} modifies an attribute that
	 * is not public.
	 * </ul>
	 */
	public final static String TOPOLOGY_IMPORT_005 = DeployCorePlugin.PLUGIN_ID
			+ ".TOPOLOGY_IMPORT_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = The {@link InCardinality} interpreter detected a membership cardinality
	 * violation.
	 * </ul>
	 */
	public final static String CARDINALITY_IN_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CARDINALITY_IN_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Description = The {@link OutCardinality} interpreter detected a membership cardinality
	 * violation.
	 * </ul>
	 */
	public final static String CARDINALITY_OUT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CARDINALITY_OUT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeValueStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link Equals} interpreter did not match.
	 * </ul>
	 */
	public final static String EQUALS_001 = DeployCorePlugin.PLUGIN_ID + ".EQUALS_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REQUIREMENT_TYPE_MISMATCH}
	 * <li>Description = The {@link Requirement#getDmoEType()} did not match the target of the
	 * dependency link.
	 * </ul>
	 */
	public final static String REQUIREMENT_UTIL_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_UTIL_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link RequirementExpression#getInterpeter()} has not been set.
	 * </ul>
	 */
	public final static String REQUIREMENT_UTIL_002 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_UTIL_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link RequirementExpression#getInterpeter()} has not been declared in
	 * an extension point.
	 * </ul>
	 */
	public final static String REQUIREMENT_UTIL_003 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_UTIL_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link RequirementExpression#getValue()} was failed to be evaluated by
	 * the {@link RequirementExpression#getInterpeter()}.
	 * </ul>
	 */
	public final static String REQUIREMENT_UTIL_004 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_UTIL_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#REQUIREMENT_LINK_TYPE_MISMATCH}
	 * <li>Description = The {@link Requirement#getLinkType()} matches the context of the link.
	 * </ul>
	 */
	public final static String REQUIREMENT_UTIL_005 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_UTIL_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = The {@link RequirementExpression#getInterpreter()} was not declared in an
	 * extension point.
	 * </ul>
	 */
	public final static String REQUIREMENT_EXPRESSION_INTERPRETER_001 = DeployCorePlugin.PLUGIN_ID
			+ ".REQUIREMENT_EXPRESSION_INTERPRETER_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = A required {@link VersionString} attribute is not set.
	 * </ul>
	 */
	public final static String VERSION_STRING_001 = DeployCorePlugin.PLUGIN_ID
			+ ".VERSION_STRING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}.
	 * <li>Description = A required {@link VersionString} attribute is not set.
	 * </ul>
	 */
	public final static String VERSION_STRING_002 = DeployCorePlugin.PLUGIN_ID
			+ ".VERSION_STRING_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONSTRAINT_UNSATISFIED}
	 * <li>Description =
	 * {@link Constraint#validate(DeployModelObject, org.eclipse.core.runtime.IProgressMonitor)}
	 * returned a non-deploy status with severity that is not OK.
	 * </ul>
	 */
	public final static String CONSTRAINT_001 = DeployCorePlugin.PLUGIN_ID + ".CONSTRAINT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONSTRAINT_UNSATISFIED}
	 * <li>Description = CommunicationConstraint is violated such that a hosted linked
	 * {@link Service#getProtocol()} does not match the
	 * {@link CommunicationConstraint#getApplicationLayerProtocol()}.
	 * </ul>
	 */
	public static final String COMMCONSTRAINT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".COMMCONSTRAINT_001"; //$NON-NLS-1$;

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CONSTRAINT_UNSATISFIED}
	 * <li>Description = CommunicationConstraint is violated on a dependency link between two units
	 * such that a targeted {@link Service#getProtocol()} does not match the
	 * {@link CommunicationConstraint#getApplicationLayerProtocol()}.
	 * </ul>
	 */
	public static final String COMMCONSTRAINT_002 = DeployCorePlugin.PLUGIN_ID
			+ ".COMMCONSTRAINT_002"; //$NON-NLS-1$;

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#BOUND_UNIT_001}
	 * <li>Description = unit provider for bound unit not found
	 * </ul>
	 */
	public final static String BOUND_UNIT_001 = DeployCorePlugin.PLUGIN_ID + ".BOUND_UNIT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#CANNOT_MATCH_ACC_TO_NCC}
	 * <li>Description = Unable to match an {@link ApplicationCommunicationConstraint} with a
	 * corresponding {@link NetworkCommunicationConstraint} applicable to the hosting operating
	 * systems.
	 * </ul>
	 */
	public final static String ACC_MATCHING_001 = DeployCorePlugin.PLUGIN_ID + ".ACC_MATCHING_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#UNKNOWN_APPLICATION_PROTOCOL_WITHOUT_PORTS}
	 * <li>Description = An unrecognized application protocol needs supporting port configuration
	 * information.
	 * </ul>
	 */
	public final static String ACPC_PORT_CHECK_001 = DeployCorePlugin.PLUGIN_ID
			+ ".ACPC_PORT_CHECK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#NO_APPLICATION_PROTOCOL_DETAILS}
	 * <li>Description = An {@link ApplicationCommunicationProtocolConstraint} has neither
	 * application protocol nor port configurations specified.
	 * </ul>
	 */
	public static final String ACPC_PROTOCOL_CHECK_001 = DeployCorePlugin.PLUGIN_ID
			+ ".ACPC_PROTOCOL_CHECK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#NO_APPLICATION_PROTOCOL_DETAILS}
	 * <li>Description = An {@link ApplicationCommunicationProtocolConstraint} has neither
	 * application protocol nor port configurations specified.
	 * </ul>
	 */
	public static final String ACPC_PORT_SEARCH_001 = DeployCorePlugin.PLUGIN_ID
			+ ".ACPC_PORT_SEARCH_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#EXPECTED_PORT_NOT_REQUIRED}
	 * <li>Description = An {@link NetworkCommunicationProtocolConstraint} does not have the
	 * expected port requirements.
	 * </ul>
	 */
	public static final String CPC_PORT_CHECK_001 = DeployCorePlugin.PLUGIN_ID
			+ ".CPC_PORT_CHECK_001"; //$NON-NLS-1$
	/**
	 * 
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#EXPECTED_DELAY_INSUFFICIENT}
	 * <li>Description = An {@link NetworkCommunicationProtocolConstraint} does not have the
	 * expected port requirements.
	 * </ul>
	 */
	public static final String TDC_CHECK_001 = DeployCorePlugin.PLUGIN_ID + ".TDC_CHECK_001"; //$NON-NLS-1$

	/**
	 * 
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#EXPECTED_BANDWIDTH_INSUFFICIENT}
	 * <li>Description = An {@link NetworkCommunicationConstraint} does not have the expected port
	 * requirements.
	 * </ul>
	 */
	public static final String CBC_CHECK_001 = DeployCorePlugin.PLUGIN_ID + ".CBC_CHECK_001"; //$NON-NLS-1$

	/**
	 * 
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#EXPECTED_COST_INSUFFICIENT}
	 * <li>Description = An {@link NetworkCommunicationConstraint} does not have the expected port
	 * requirements.
	 * </ul>
	 */
	public static final String CCC_CHECK_001 = DeployCorePlugin.PLUGIN_ID + ".CCC_CHECK_001"; //$NON-NLS-1$

	/**
	 * 
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#COMMUNICATION_TYPE_INCOMPATIBLE}
	 * <li>Description = An {@link NetworkCommunicationConstraint} does not have the expected port
	 * requirements.
	 * </ul>
	 */
	public static final String CTC_CHECK_001 = DeployCorePlugin.PLUGIN_ID + ".CTC_CHECK_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_EXTENDED_ATTRIBUTE_NAME_UNDEFINED}
	 * <li>Description = An {@link ExtendedAttribute#getName()} is null or empty.
	 * </ul>
	 */
	public static final String EXTENDED_ATTRIBUTE_001 = DeployCorePlugin.PLUGIN_ID
			+ ".EXTENDED_ATTRIBUTE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = An {@link ExtendedAttribute#getInstanceType()} is null or empty.
	 * </ul>
	 */
	public static final String EXTENDED_ATTRIBUTE_002 = DeployCorePlugin.PLUGIN_ID
			+ ".EXTENDED_ATTRIBUTE_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
	 * <li>Description = An {@link ExtendedAttribute#getValue()} is not an instance of
	 * {@link ExtendedAttribute#getInstanceType()}.
	 * </ul>
	 */
	public static final String EXTENDED_ATTRIBUTE_003 = DeployCorePlugin.PLUGIN_ID
			+ ".EXTENDED_ATTRIBUTE_003"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_EXTENDED_ATTRIBUTE_NAME_INVALID}
	 * <li>Description = An {@link ExtendedAttribute#getName()} conflicts with the a structural
	 * feature (static attribute) of the object.
	 * </ul>
	 */
	public static final String EXTENDED_ATTRIBUTE_004 = DeployCorePlugin.PLUGIN_ID
			+ ".EXTENDED_ATTRIBUTE_004"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_EXTENDED_ATTRIBUTE_NAME_INVALID}
	 * <li>Description = An {@link ExtendedAttribute#getName()} is a duplicate with another extended
	 * attribute.
	 * </ul>
	 */
	public static final String EXTENDED_ATTRIBUTE_005 = DeployCorePlugin.PLUGIN_ID
			+ ".EXTENDED_ATTRIBUTE_005"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_IMPORT_TEMPLATE_INVALID}
	 * <li>Description = Imports are not valid in template topologies.
	 * </ul>
	 */
	public static final String INVALID_IMPORT_001 = DeployCorePlugin.PLUGIN_ID
			+ ".INVALID_IMPORT_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#INVALID_RESOURCE_TYPE_ID}
	 * <li>Description = Specified resoure type id is not found in registry
	 * </ul>
	 */
	public static final String INVALID_RESOURCE_TYPE_ID_001 = DeployCorePlugin.PLUGIN_ID
			+ ".INVALID_RESOURCE_TYPE_ID_001"; //$NON-NLS-1$
}
