/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Constants for serializing {@link IDeployStatus} as a {@link IMarker}.
 * 
 * @see IDeployStatus#createMarker()
 */
public interface IDeployMarker {

	/**
	 * The list of parameters for the deploy action status.
	 */
	public static final String ACTION_PARAMETERS = "deployActionParameters"; //$NON-NLS-1$

	/**
	 * Name of field containing attributes to be set and their values
	 */
	public static final String APP_COMM_ATTRIBUTE_DATA = "deployApplicationCommunicationTargetAttributeData"; //$NON-NLS-1$

	/**
	 * Name of field containing constraint display name
	 */
	public static final String APP_COMM_DISPLAY_NAME = "deployApplicationCommunicationTargetDisplayName"; //$NON-NLS-1$

	/**
	 * Name of field containing a {@link NetworkCommunicationConstraint}
	 */
	public static final String APP_COMM_TARGET_NCC = "deployApplicationCommunicationTarget"; //$NON-NLS-1$

	/**
	 * Name of field containing constraint class type
	 */
	public static final String APP_COMM_TYPE = "deployApplicationCommunicationType"; //$NON-NLS-1$

	/**
	 * Identifies the expected value of the deploy model object attribute marked on the deploy
	 * resource.
	 * 
	 * @see DeployModelObject#getEObject()
	 * @see EAttribute#getName()
	 * @see EObject#eGet(EStructuralFeature)
	 */
	public static final String ATTRIBUTE_EXPECTED_VALUE = "deployAttributeExpectedValue"; //$NON-NLS-1$

	/**
	 * Identifies the name of the deploy model object whose attribute is propagated to the
	 * {@link #ATTRIBUTE_EXPECTED_VALUE_SOURCE_ATTRIBUTE_NAME}
	 */
	public static final String ATTRIBUTE_EXPECTED_VALUE_SOURCE_ATTRIBUTE_NAME = "deployAttributeExpectedValueSourceAttributeName"; //$NON-NLS-1$

	/**
	 * Identifies the ID of the deploy model object whose attribute is propagated to the
	 * {@link #OBJECT_ID}
	 */
	public static final String ATTRIBUTE_EXPECTED_VALUE_SOURCE_OBJECT_ID = "deployAttributeExpectedValueSourceObjectID"; //$NON-NLS-1$

	/**
	 * Identifies the type of the deploy model object whose attribute is propagated to the
	 * {@link #OBJECT_ID}
	 */
	public static final String ATTRIBUTE_EXPECTED_VALUE_SOURCE_OBJECT_TYPE = "deployAttributeExpectedValueSourceObjectType"; //$NON-NLS-1$

	/**
	 * The the name of a deploy attribute.
	 * 
	 * @see IDeployAttributeStatus#getAttributeName()
	 */
	public static final String ATTRIBUTE_NAME = "deployAttributeName"; //$NON-NLS-1$

	/**
	 * The constraints on the deploy attribute.
	 * 
	 * @see IDeployStatus#getConstraints()
	 */
	public static final String CONSTRAINTS = "deployConstraints"; //$NON-NLS-1$

	public static final String COMM_CANDIDATE_CONSTRAINTS = "deployCommunicationCandidateConstraints"; //$NON-NLS-1$

	public static final String COMM_CHILD_STATUSES = "deployCommunicationChildStatuses"; //$NON-NLS-1$

	public static final String COMM_SOURCE = "deployCommunicationSource"; //$NON-NLS-1$

	public static final String COMM_TARGET = "deployCommunicationTarget"; //$NON-NLS-1$

	/**
	 * Identifies the target deploy model object in a communication status.
	 */
	public static final String COMMUNICATION_TARGET_DMO = "deployCommunicationTargetDmo"; //$NON-NLS-1$

	/**
	 * The exception associated with the deploy status which was serialized as this marker.
	 * 
	 * @see IDeployStatus
	 */
	public static final String EXCEPTION = "deployException"; //$NON-NLS-1$

	/**
	 * SOA deploy model marker ID (value
	 * <code>com.ibm.ccl.soa.deploy.core.validator.marker.DeployMarker</code>).
	 * 
	 * @see IDeployStatus#getMarkerType()
	 */
	public static final String MARKER_ID = "com.ibm.ccl.soa.deploy.core.validator.marker.DeployMarker"; //$NON-NLS-1$

	/**
	 * Identifies the deploy model object marked in the topology stored in the resource.
	 * <p>
	 * Stores the full path of the object on which the status is defined.
	 * 
	 * @see IDeployStatus#getDeployObject()
	 * @see DeployModelObject#getFullPath()
	 * @see Topology#resolve(String)
	 */
	public static final String OBJECT_ID = "deployObjectID"; //$NON-NLS-1$

	/**
	 * Identifies the fully qualified type of the object on which the marker was set.
	 * 
	 * @see IDeployStatus#getDeployObject()
	 */
	public static final String OBJECT_TYPE = "deployObjectType"; //$NON-NLS-1$

	/**
	 * The bundle of the deploy status which was serialized as this marker.
	 */
	public static final String PLUGIN = "deployPlugin"; //$NON-NLS-1$

	/**
	 * Identifies the type of the deployment problem.
	 * <p>
	 * Problem types are defined by each SOA deploy domain. The core domain problem constants are
	 * defined in {@link ICoreProblemType}.
	 * 
	 * @see IDeployStatus#getProblemType()
	 */
	public static final String PROBLEM_TYPE = "deployProblemType"; //$NON-NLS-1$

	/**
	 * The Java plugin bundle in which the status class can be found for the status serialized in
	 * this marker.
	 */
	public static final String STATUS_BUNDLE = "deployStatusBundle"; //$NON-NLS-1$
	/**
	 * The Java class type of the deploy status which was serialized as this marker.
	 */
	public static final String STATUS_CLASS = "deployStatusClass"; //$NON-NLS-1$
	/**
	 * The ID of the validator group that created this marker.
	 * 
	 * @see IDeployStatus#getValidatorGroupID()
	 */
	public static final String VALIDATOR_GROUP_ID = "deployValidatorGroupID"; //$NON-NLS-1$
	/**
	 * The ID of the validator that created this marker.
	 * 
	 * @see IDeployStatus#getValidatorID()
	 */
	public static final String VALIDATOR_ID = "deployValidatorID"; //$NON-NLS-1$
}
