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

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;

/**
 * Status associated with an operation over a deploy model object.
 * <p>
 * The base eclipse {@link IStatus} class is used to capture the outcome of an operation. This class
 * extends it with information on the status of an operation over a {@link DeployModelObject}. The
 * deploy status adds information about:
 * <ul>
 * <li> {@link #getDeployObject()}: the deploy object which was effected,
 * <li> {@link #getProblemType()}: a unique semantic description of the error (see
 * {@link ICoreProblemType} for examples).
 * <li> {@link #getValidatorID()}: identifies the link validator which created this status.
 * <li> {@link #getValidatorGroupID()}: identifies the validation group under which the status was
 * created. This is used to maintain the statuses across validation jobs/threads.
 * <li> {@link #isPersistent()}: controls if this status will be serialized as an Eclipse
 * {@link IMarker} when the resource containing the object on which it has been added is saved.
 * <li> {@link #getUnboundMessage()} and {@link #getBindings()} to return the non-NLS bound message
 * associated with the status.
 * </ul>
 * <p>
 * The base deploy status type is extended to provide additional status contextual information, such
 * as the particular attribute of an object ((@link IDeployAttributeStatus}).
 * <p>
 * In the validation framework, statuses are created using a factory pattern such as
 * {@link DeployCoreStatusFactory}. They are then reported using
 * {@link IDeployReporter#addStatus(IDeployStatus)}.
 * 
 * @see DeployModelObject#getStatus()
 * @see DeployModelObject#addStatus(IStatus)
 */
public interface IDeployStatus extends IStatus, Comparable<IDeployStatus> {

	/**
	 * Low priority constant (value {@value}).
	 * 
	 * @see #getPriority()
	 * @see IMarker#PRIORITY_LOW
	 */
	static public int PRIORITY_LOW = IMarker.PRIORITY_LOW;

	/**
	 * Low priority constant (value {@value}).
	 * 
	 * @see #getPriority()
	 * @see IMarker#PRIORITY_NORMAL
	 */
	static public int PRIORITY_NORMAL = IMarker.PRIORITY_NORMAL;

	/**
	 * High priority constant (value {@value}).
	 * 
	 * @see #getPriority()
	 * @see IMarker#PRIORITY_HIGH
	 */
	static public int PRIORITY_HIGH = IMarker.PRIORITY_HIGH;

	/**
	 * Returns the deploy object with which the status is associated.
	 * <p>
	 * A status can refer to a deploy model object without being reported on it using
	 * {@link DeployModelObject#addStatus(IStatus)}.
	 * 
	 * @return the deploy model object of this status.
	 */
	public DeployModelObject getDeployObject();

	/**
	 * Sets the target object of the message.
	 * 
	 * @param object
	 *           the object on which the message was created.
	 * 
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setDeployObject(DeployModelObject object);

	/**
	 * Sets the severity of the message
	 * 
	 * @param severity
	 *           the message severity {@link IStatus#getSeverity()}
	 * 
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setSeverity(int severity);

	/**
	 * Sets the unbound localized text of the message.
	 * 
	 * @param id
	 *           the localized message text.
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setUnboundMessage(String id);

	/**
	 * Returns the unbound localized message.
	 * <p>
	 * The unbound message is the second parameter to {@link NLS#bind(String, Object[])}. The result
	 * of {@link IStatus#getMessage()} will be
	 * <code>NLS.bind(getUnboundMessage(), getBindings())</code>.
	 * <p>
	 * For more information on the new Eclipse localization mechanism, see
	 * {@link "http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/platform-core-home/documents/3.1/message_bundles.html"}.
	 * 
	 * @return the unbound localized message.
	 */
	public String getUnboundMessage();

	/**
	 * Sets the parameters of the localized string.
	 * 
	 * @param bindings
	 *           an array of parameters (may be null).
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setBindings(Object[] bindings);

	/**
	 * Returns the localization parameters of the message.
	 * <p>
	 * The unbound message is the second parameter to {@link NLS#bind(String, Object[])}. The result
	 * of {@link IStatus#getMessage()} will be
	 * <code>NLS.bind(getUnboundMessage(), getBindings())</code>.
	 * <p>
	 * For more information on the new Eclipse localization mechanism, see
	 * {@link "http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/platform-core-home/documents/3.1/message_bundles.html"}.
	 * 
	 * @return the localization parameters (may be null).
	 * 
	 * @see #getUnboundMessage()
	 */
	public Object[] getBindings();

	/**
	 * Returns a unique semantic description of the problem.
	 * <p>
	 * The problem type of a status is used as a key by resolutions ({@link IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)}).
	 * 
	 * @return the deployment problem type.
	 * 
	 * @see ICoreProblemType
	 */
	public String getProblemType();

	/**
	 * @param type
	 *           the type of the deployment problem.
	 * 
	 * @see ICodeProblemType
	 * @see DeployMarker#setProblemType(org.eclipse.core.resources.IMarker, String)
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setProblemType(String type);

	/**
	 * Returns the unique ID of the validator that created this message.
	 * <p>
	 * In order to support traceability of statuses to the validators which created them, it is
	 * expected that this value be set in a way which enables correlation to logic which created it.
	 * 
	 * @return the ID of the validator that created this message.
	 * 
	 * @see DeployMarker#getValidatorID(org.eclipse.core.resources.IMarker)
	 */
	public String getValidatorID();

	/**
	 * @param id
	 *           the validator ID.
	 * 
	 * @see DeployMarker#setValidatorID(org.eclipse.core.resources.IMarker, String)
	 * @deprecated deploy status objects will be made immutable.
	 */
	public void setValidatorID(String id);

	/**
	 * Sets the type of marker created.
	 * 
	 * @param type
	 *           the marker type.
	 * 
	 * @deprecated create the appropriate type of message.
	 */
	public void setMarkerType(String type);

	/**
	 * Returns the {@link IMarker#getType()} of the marker created when serializing this status.
	 * 
	 * @return the marker type.
	 */
	public String getMarkerType();

	/**
	 * @return the marker used to persist this status, or null if the status has not been persisted.
	 * 
	 * @see #createMarker()
	 */
	public IMarker getMarker();

	/**
	 * Persists the status as an Eclipse marker.
	 * <p>
	 * If the status has already been associated with a marker ({@link #getMarker()}), the marker
	 * will be reused, and its attributes will be reset.
	 * 
	 * @return the marker created or reused.
	 * 
	 * @exception CoreException
	 *               if the marker cannot be created.
	 */
	public IMarker createMarker() throws CoreException;

	/**
	 * Restores the state of the status from the Eclipse Marker.
	 * <p>
	 * The loading operation will clear all of the state of the status.
	 * 
	 * @param marker
	 *           an Eclipse marker created using {@link #createMarker()}.
	 * @param topology
	 *           the topology in whose context the deploy status serialized marker will be
	 *           deserialized.
	 * @return the status of deserialization.
	 * @throws CoreException
	 *            if an error occurs when accessing the marker.
	 */
	public IStatus loadMarker(IMarker marker, Topology topology) throws CoreException;

	/**
	 * Returns true if the deploy status will be serialized as an Eclipse marker.
	 * <p>
	 * Deploy statuses are serialized as an Eclipse marker when they have been added to a deploy
	 * model object, and the resource of that object is saved.
	 * <p>
	 * A status that is not persistent will be discarded when the resource is closed.
	 * 
	 * @return true if the status should be persisted, false if transient.
	 * 
	 * @see IMarker
	 * @see DeployModelObject#getStatus()
	 * @see DeployModelObject#eResource()
	 */
	public boolean isPersistent();

	/**
	 * Identifies the job which created this status.
	 * <p>
	 * Statuses can be created by different jobs and processes and added to deploy model objects. In
	 * order to maintain the clearing of stale statuses when such a job finishes, it is necessary to
	 * know what statuses it had previously created. Any status whose group ID is different will be
	 * left for its owning job to maintain.
	 * <p>
	 * For validation in particular, a link {@link IDomainValidator} can request to be associated
	 * with a particular validation group using {@link IDomainValidator#getGroupID()}. The
	 * validators for the same group will be evaluated on a separate job from other groups. They will
	 * be provided with a {@link IDeployReporter} that will set the status
	 * {@link #getValidatorGroupID()} accordingly.
	 * 
	 * @return the group ID of the validator which created this status.
	 * 
	 * @see IDomainValidator#getGroupID()
	 */
	public String getValidatorGroupID();

	/**
	 * Returns the priority for resolving the status.
	 * <p>
	 * The priority field can be optionally used to provide ordering information for statuses with
	 * the same severity.
	 * 
	 * @return the priority of the status.
	 * 
	 * @see IStatusPriority for a list of predefined priorities.
	 */
	public int getPriority();

	/**
	 * Returns an immutable list of constraints associated with the attribute value.
	 * <p>
	 * The constraints on the value can be used for constraint solvers to determine a valid value for
	 * the attribute.
	 * 
	 * @return a list of constraints on the attribute value (never null).
	 */
	public List<Constraint> getConstraints();
}
