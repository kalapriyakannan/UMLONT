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
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployActionStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployCommunicationStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployPublishStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployWrapperStatus;

/**
 * Factory for deploy core {@link IDeployStatus} types.
 */
public class DeployCoreStatusFactory {

	/** Singleton instance. */
	public static final DeployCoreStatusFactory INSTANCE = new DeployCoreStatusFactory();

	protected final DeployStatus okStatus;

	protected DeployCoreStatusFactory() {
		okStatus = new DeployStatus();
		okStatus.setSeverity(IStatus.OK);
	}

	/**
	 * Returns the shared OK status instance with severity NORMAL.
	 * <p>
	 * Users should not set the severity of this status.
	 * 
	 * @return a deploy status with {@link IStatus#OK} status.
	 */
	public IDeployStatus getOKStatus() {
		return okStatus;
	}

	/**
	 * Creates a deploy status of the type identified by the deploy marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @param topology
	 *           used to resolve the marker target.
	 * @return a new status, of the type identified by the marker.
	 * @throws CoreException
	 *            if the marker does not exist.
	 * 
	 * @see IDeployStatus#createMarker()
	 */
	public IDeployStatus createDeployStatus(IMarker marker, Topology topology) throws CoreException {
		assert DeployMarker.isInstance(marker);
		String bundle = DeployMarker.getMessageBundle(marker);
		String className = DeployMarker.getMessageClass(marker);
		DeployStatus status;

		if (className == null) {
			new Exception("NULL CLASS NAME").printStackTrace();//$NON-NLS-1$
			status = (DeployStatus) createObjectStatus();
		} else {
			try {
				if (bundle != null) {
					status = (DeployStatus) Platform.getBundle(bundle).loadClass(className)
							.newInstance();
				} else {
					status = (DeployStatus) getClass().getClassLoader().loadClass(className)
							.newInstance();
				}
			} catch (Throwable e) {
				// TODO log
				e.printStackTrace();
				status = new DeployStatus();
			}
		}
		status.loadMarker(marker, topology);
		return status;
	}

	/**
	 * Creates a deploy status associated with a deploy model object.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @return the deploy status created.
	 */
	public IDeployStatus createDeployStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object) {
		assert problemType != null;
		assert object != null;
		DeployStatus status = new DeployStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		return status;
	}

	/**
	 * Creates a deploy status associated with a deploy model object.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @return the deploy status created.
	 */
	public IDeployStatus createDeployStatus(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object,
			List<Constraint> constraints) {
		assert problemType != null;
		assert object != null;
		DeployStatus status = new DeployStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		if (constraints != null) {
			status.setConstraints(constraints);
		}
		return status;
	}

	/**
	 * Creates a new deploy status.
	 * 
	 * @param problemType
	 *           the status problem type.
	 * @param topology
	 *           the topology over which the message is defined (not null).
	 * @return the created message.
	 * @deprecated use
	 *             {@link #createDeployStatus(int, String, String, String, Object[], DeployModelObject)}
	 */
	public IDeployStatus createDeployStatus(String problemType, Topology topology) {
		assert topology != null;
		DeployStatus status = new DeployStatus();
		status.setSeverity(IStatus.ERROR);
		status.setProblemType(problemType);
		status.setDeployObject(topology);
		return status;
	}

	/**
	 * Creates a new deploy object message.
	 * 
	 * @return the created message.
	 * @deprecated use
	 *             {@link #createDeployStatus(int, String, String, String, Object[], DeployModelObject)}
	 */
	public IDeployStatus createObjectStatus() {
		return new DeployStatus();
	}

	/**
	 * Creates a deploy object message.
	 * 
	 * @param problemType
	 *           the status problem type.
	 * @param object
	 *           the target of the message (not null).
	 * 
	 * @return the created message.
	 * @deprecated use
	 *             {@link #createDeployStatus(int, String, String, String, Object[], DeployModelObject)}
	 */
	public IDeployStatus createObjectStatus(String problemType, DeployModelObject object) {
		assert object != null;
		DeployStatus status = new DeployStatus();
		status.setSeverity(IStatus.ERROR);
		status.setProblemType(problemType);
		status.setDeployObject(object);
		return status;
	}

	/**
	 * Creates a deploy status associated with a deploy model object attribute.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @param attribute
	 *           the ({@link EAttribute} or {@link ExtendedAttribute} marked.
	 * @return the attribute status created.
	 */
	public IDeployAttributeStatus createAttributeStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			EAttribute attribute) {
		return createAttributeStatus(severity, validatorID, problemType, unboundMessage, bindings,
				object, attribute, null);
	}

	/**
	 * Creates a deploy status associated with a deploy model object attribute.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @param attribute
	 *           the ({@link EAttribute} or {@link ExtendedAttribute} marked.
	 * @param constraints
	 *           optional constraints to associate with the attribute constraint.
	 * @return the attribute status created.
	 */
	public IDeployAttributeStatus createAttributeStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			EAttribute attribute, List<Constraint> constraints) {
		assert problemType != null;
		assert object != null;
		DeployAttributeStatus status = new DeployAttributeStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setAttributeName(attribute);
		status.setConstraints(constraints);
		return status;
	}

	/**
	 * Creates a deploy status associated with a deploy model object attribute.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @param attribute
	 *           the name of the object attribute ({@link EAttribute} or {@link ExtendedAttribute}).
	 * @return the attribute status created.
	 */
	public IDeployAttributeStatus createAttributeStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			String attribute) {
		return createAttributeStatus(severity, validatorID, problemType, unboundMessage, bindings,
				object, attribute, null);
	}

	/**
	 * Creates a deploy status associated with a deploy model object attribute.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @param attribute
	 *           the name of the object attribute ({@link EAttribute} or {@link ExtendedAttribute}).
	 * @param constraints
	 *           optional constraints to associate with the attribute constraint.
	 * @return the attribute status created.
	 */
	public IDeployAttributeStatus createAttributeStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			String attribute, List<Constraint> constraints) {
		assert problemType != null;
		assert object != null;
		DeployAttributeStatus status = new DeployAttributeStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setAttributeName(attribute);
		status.setConstraints(constraints);
		return status;
	}

	/**
	 * Creates a deploy attribute message.
	 * 
	 * @param problemType
	 *           the status problem type.
	 * @param object
	 *           the target of the message (not null).
	 * @param attribute
	 *           the marked attribute (not null).
	 * 
	 * @return the created message.
	 * @deprecated use
	 *             {@link #createAttributeStatus(int, String, String, String, Object[], DeployModelObject, String)}.
	 */
	public IDeployAttributeStatus createAttributeStatus(String problemType,
			DeployModelObject object, EAttribute attribute) {
		assert problemType != null;
		assert object != null;
		DeployAttributeStatus message = new DeployAttributeStatus();
		message.setSeverity(IStatus.ERROR);
		message.setProblemType(problemType);
		message.setDeployObject(object);
		message.setAttributeName(attribute);
		return message;
	}

	/**
	 * Creates a deploy attribute expected value message.
	 * 
	 * @param problemType
	 *           the status problem type.
	 * @param object
	 *           the target of the message (not null).
	 * @param attribute
	 *           the marked attribute (not null).
	 * @param value
	 *           the expected value of the atttribute.
	 * 
	 * @return the created message.
	 * @deprecated use
	 *             {@link #createAttributeValueStatus(int, String, String, String, Object[], DeployModelObject, EAttribute, Object)}
	 */
	public IDeployAttributeValueStatus createAttributeValueStatus(String problemType,
			DeployModelObject object, EAttribute attribute, Object value) {
		assert problemType != null;
		assert object != null;
		DeployAttributeValueStatus status = new DeployAttributeValueStatus();
		status.setSeverity(IStatus.ERROR);
		status.setProblemType(problemType);
		status.setDeployObject(object);
		status.setAttributeName(attribute);
		status.setAttributeExpectedValue(value);
		return status;
	}

	/**
	 * Creates a deploy attribute expected value message.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the status problem type.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the target of the message (not null).
	 * @param attribute
	 *           the marked attribute (not null).
	 * @param expectedValue
	 *           the expected value of the atttribute.
	 * 
	 * @return the created message.
	 */
	public IDeployAttributeValueStatus createAttributeValueStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			EAttribute attribute, Object expectedValue) {
		assert problemType != null;
		assert object != null;
		DeployAttributeValueStatus status = new DeployAttributeValueStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setAttributeName(attribute);
		status.setAttributeExpectedValue(expectedValue);
		return status;
	}

	/**
	 * Creates a deploy attribute expected value message.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the status problem type.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the target of the message (not null).
	 * @param attributeName
	 *           the name of the marked attribute (not null).
	 * @param expectedValue
	 *           the expected value of the atttribute.
	 * 
	 * @return the created message.
	 */
	public IDeployAttributeValueStatus createAttributeValueStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			String attributeName, Object expectedValue) {
		assert problemType != null;
		assert object != null;
		DeployAttributeValueStatus status = new DeployAttributeValueStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setAttributeName(attributeName);
		status.setAttributeExpectedValue(expectedValue);
		return status;
	}

	/**
	 * Creates a deploy attribute expected value message.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the status problem type.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the target of the message (not null).
	 * @param attributeName
	 *           the name of the marked attribute (not null).
	 * @param expectedValue
	 *           the expected value of the atttribute.
	 * @param constraints
	 *           a list of constraints to associate with the deploy status (may be null).
	 * 
	 * @return the created message.
	 */
	public IDeployAttributeValueStatus createAttributeValueStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			String attributeName, Object expectedValue, List<Constraint> constraints) {
		assert problemType != null;
		assert object != null;
		DeployAttributeValueStatus status = new DeployAttributeValueStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setAttributeName(attributeName);
		status.setAttributeExpectedValue(expectedValue);
		if (constraints != null) {
			status.setConstraints(constraints);
		}
		return status;
	}

	/**
	 * Creates a deploy attribute expected value message.
	 * <p>
	 * The expected value is retrieved from the source object's attribute.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the status problem type.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the target of the message (not null).
	 * @param attribute
	 *           the marked attribute (not null).
	 * @param sourceObject
	 *           the source object of the expected value.
	 * @param sourceAttribute
	 *           the source object attribute containing the expected value.
	 * 
	 * @return the created message.
	 */
	public IDeployAttributeValueSourceStatus createAttributeValueSourceStatus(int severity,
			String validatorID, String problemType, String unboundMessage, Object[] bindings,
			DeployModelObject object, EAttribute attribute, DeployModelObject sourceObject,
			EAttribute sourceAttribute) {
		assert problemType != null;
		assert object != null;
		assert sourceObject != null;
		assert sourceAttribute != null;
		DeployAttributeValueSourceStatus status = new DeployAttributeValueSourceStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setDeployObject(object);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setAttributeName(attribute);
		status.setAttributeExpectedValueSourceAttributeName(sourceAttribute);
		status.setAttributeExpectedValueSourceObject(sourceObject);
		status.setAttributeExpectedValue(sourceObject.eGet(sourceAttribute));
		return status;
	}

	/**
	 * Creates a deploy action preconditions satisfied message.
	 * <p>
	 * The satisfying parameters are stored as part of the message.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the status problem type.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the target of the message (not null).
	 * @param parameters
	 *           array of satisfying parameters
	 * 
	 * @return the created message.
	 */
	public IDeployActionStatus createActionStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			List<DeployModelObject> parameters) {
		assert problemType != null;
		assert object != null;
		DeployActionStatus status = new DeployActionStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setDeployObject(object);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
//		Unit[] copy = new Unit[parameters.length];
//		for (int i = 0; i < parameters.length; i++) {
//			copy[i] = parameters[i];
//		}
		status.setParameters(parameters);
		status.setPersistent(false);
		return status;
	}

	/**
	 * Create a publisher status object.
	 * 
	 * @param severity
	 *           the error severity ({@link IStatus#getSeverity()}).
	 * @param publisher
	 *           the publisher source of the status message.
	 * @param problemType
	 *           the problem type ({@link IDeployProblemType}).
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param exception
	 *           the exception associated with the status (may be null).
	 * @param object
	 *           the object over which the exception is defined.
	 * @return the created status object.
	 */
	public IDeployPublishStatus createPublisherStatus(int severity, String publisher,
			String problemType, String unboundMessage, Object[] bindings, Throwable exception,
			DeployModelObject object) {
		DeployPublishStatus status = new DeployPublishStatus();
		status.setSeverity(severity);
		status.setPublisher(publisher);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setException(exception);
		status.setDeployObject(object);
		return status;
	}

	/**
	 * Creates a deploy status wrapper associated with a deploy model object and a deploy status.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @param wrappedStatus
	 *           the status that will be wrapped.
	 * @return the deploy wapper status created.
	 */
	public IDeployWrapperStatus createDeployWrapperStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			IDeployStatus wrappedStatus) {
		assert problemType != null;
		assert object != null;
		assert wrappedStatus != null;
		DeployWrapperStatus status = new DeployWrapperStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setWrappedStatus(wrappedStatus);
		return status;
	}

	/**
	 * Creates a communication deploy status associated with a deploy model object.
	 * 
	 * @param severity
	 *           the status severity ({@link IStatus#getSeverity()}).
	 * @param validatorID
	 *           the identifier of the validator.
	 * @param problemType
	 *           the semantic problem identifier ({@link ICoreProblemType}.
	 * @param unboundMessage
	 *           the NLS unbound message.
	 * @param bindings
	 *           the NLS bindings to the message (may be null).
	 * @param object
	 *           the object over which the status is defined.
	 * @return the deploy status created.
	 */
	public IDeployCommunicationStatus createDeployCommunicationStatus(int severity,
			String validatorID, String problemType, String unboundMessage, Object[] bindings,
			DeployModelObject object, DeployModelObject targetDmo) {
		assert problemType != null;
		assert object != null;
		DeployCommunicationStatus status = new DeployCommunicationStatus();
		status.setSeverity(severity);
		status.setValidatorID(validatorID);
		status.setProblemType(problemType);
		status.setUnboundMessage(unboundMessage);
		status.setBindings(bindings);
		status.setDeployObject(object);
		status.setTargetDmo(targetDmo);
		return status;
	}
}
