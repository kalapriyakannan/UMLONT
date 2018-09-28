/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.status;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * The base implementation class for {@link IDeployStatus}.
 * <p>
 * This class may be extended to support statuses with additional attributes.
 * <p>
 * Subtypes <em>must</em> override the {@link #equals(Object)} method to provide compare their
 * additional attributes (super.equals must be invoked).
 * <p>
 * Subtypes may <em>optionally</em> support serialization and deserialization of their additional
 * attributes to Eclipse markers, by overriding {@link #serializeAttributes(Map)} and
 * {@link #deserializeAttributes(Map, Topology, List)}, invoking <code>super</code> and then
 * adding their own attributes.
 * 
 */
public class DeployStatus implements IDeployStatus {

	/**
	 * Optional list of constraints associated with this status (may be null)
	 * 
	 * @see IDeployStatus#getConstraints()
	 */
	private List<Constraint> constraints = null;

	/**
	 * @see IDeployStatus#getDeployObject()
	 */
	private DeployModelObject deployObject;

	/**
	 * @see IStatus#getException()
	 */
	private Throwable exception;

	/**
	 * @see IDeployStatus#getMarker()
	 */
	private IMarker marker;

	/**
	 * @see IDeployStatus#getMarkerType()
	 */
	private String markerType = IDeployMarker.MARKER_ID;

	/**
	 * @see IStatus#getMessage()
	 */
	private String messageBound;

	/**
	 * @see IDeployStatus#getBindings()
	 */
	private Object[] messageParams;

	/**
	 * @see IDeployStatus#getUnboundMessage()
	 */
	private String messageUnbound;

	/**
	 * @see IDeployStatus#isPersistent()
	 */
	private boolean persistent = true;

	/**
	 * @see IStatus#getPlugin()
	 */
	private String plugin;

	/**
	 * @see IDeployStatus#getPriority()
	 */
	private int priority = PRIORITY_LOW;

	/**
	 * @see IDeployStatus#getProblemType()
	 */
	private String problemType;

	/**
	 * @see IStatus#getSeverity()
	 */
	private int severity;

	/**
	 * @see IDeployStatus#getValidatorGroupID()
	 */
	private String validatorGroupID;

	/**
	 * @see IDeployStatus#getValidatorID()
	 */
	private String validatorID;

	/**
	 * Construct an empty localized message.
	 */
	public DeployStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	/**
	 * Creates a deploy status associated with a deploy model object..
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
	 */
	public DeployStatus(int severity, String validatorID, String problemType, String unboundMessage,
			Object[] bindings, DeployModelObject object) {
		setMarkerType(IDeployMarker.MARKER_ID);
		setSeverity(severity);
		setValidatorID(validatorID);
		setProblemType(problemType);
		setUnboundMessage(unboundMessage);
		setBindings(bindings);
		setDeployObject(object);
	}

	/**
	 * Construct a new message with the bound localized text.
	 * 
	 * @param message
	 *           the bound localized message text.
	 */
	public DeployStatus(String message) {
		messageUnbound = message;
	}

	/**
	 * Construct a new message with the unbound localized text and its parameters.
	 * <p>
	 * Supports lazy binding of messages to parameters.
	 * 
	 * @param message
	 *           the unbound localized message text.
	 * @param nlsBindings
	 *           the parameters for {@link DeployNLS#bind(String, Object[])}.
	 */
	public DeployStatus(String message, Object[] nlsBindings) {
		messageUnbound = message;
		messageParams = nlsBindings;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#createMarker()
	 */
	public IMarker createMarker() throws CoreException {
		if (getSeverity() == IStatus.OK || getSeverity() == IStatus.CANCEL) {
			return null;
		}

		//
		// Serialize the status attributes
		//
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		serializeAttributes(map);

		// Clean up any invalid values in the map: only String, Integer, Boolean and null values permitted
		for (Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, Object> entry = iter.next();
			Object v = entry.getValue();
			if (v != null && !(v instanceof String) && !(v instanceof Integer)
					&& !(v instanceof Boolean)) {
				entry.setValue(v.toString());
			}
		}

		//
		// Create the marker
		//
		IResource resource;
		Topology topology;
		if (deployObject instanceof Topology) {
			topology = (Topology) deployObject;
		} else if (deployObject != null) {
			topology = deployObject.getTopology();
		} else {
			throw new CoreException(new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
					DeployCoreMessages.Deploy_message_target_undefined, null));
		}
		resource = WorkbenchResourceHelper.getFile(topology.getEditTopology());

		marker = resource.createMarker(getMarkerType());
		marker.setAttributes(map);

		return marker;
	}

	/**
	 * Exports the status attributes.
	 * 
	 * @return a map of status attributes to their serialized values.
	 */
	public Map<String, Object> exportAttributes() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		serializeAttributes(map);
		return Collections.unmodifiableMap(map);
	}

	/**
	 * Overriden by subtypes to contribute additional attributes for {@link IMarker} serialization.
	 * <p>
	 * Only primary marker type values should be assigned to attribute names: String, Integer,
	 * Boolean, null.
	 * 
	 * @param attributes
	 *           a map of attribute names to primitive values.
	 * @see #createMarker()
	 */
	protected void serializeAttributes(Map<String, Object> attributes) {
		// constraints
		attributes.put(IDeployMarker.CONSTRAINTS, serializeCollectionScalarValues(constraints,
				CorePackage.eINSTANCE.getConstraint()));
		// deployObject
		DeployModelObject obj = getDeployObject();
		if (obj != null) {
			attributes
					.put(IDeployMarker.OBJECT_TYPE, obj.getEObject().eClass().getInstanceClassName());
			attributes.put(IDeployMarker.OBJECT_ID, obj.getFullPath());
			attributes.put(IMarker.LOCATION, getDeployObject().getFullPath());
		}
		// exception
		Throwable exc = getException();
		if (exc != null) {
			attributes.put(IDeployMarker.EXCEPTION, exc.toString());
		}
		// marker: implicit
		// markerType: implicit
		// messageBound
		attributes.put(IMarker.MESSAGE, getMessage());
		// persistent: implicit
		// plugin
		attributes.put(IDeployMarker.PLUGIN, getPlugin());
		// priority
		attributes.put(IMarker.PRIORITY, getPriority());
		// problemType
		attributes.put(IDeployMarker.PROBLEM_TYPE, getProblemType());
		// severity
		switch (getSeverity())
		{
		case IStatus.OK:
		case IStatus.CANCEL:
			break;
		case IStatus.WARNING:
			attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_WARNING));
			break;
		case IStatus.INFO:
			attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_INFO));
			break;
		default:
			attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
			break;
		}
		// Deserialization attributes: status class and bundle
		attributes.put(IDeployMarker.STATUS_BUNDLE, DeployCorePlugin.PLUGIN_ID);
		attributes.put(IDeployMarker.STATUS_CLASS, this.getClass().getName());

		// validatorID
		attributes.put(IDeployMarker.VALIDATOR_ID, getValidatorID());
		// validatorGroupID
		attributes.put(IDeployMarker.VALIDATOR_GROUP_ID, getValidatorGroupID());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#loadMarker(org.eclipse.core.resources.IMarker)
	 */
	public IStatus loadMarker(IMarker marker, Topology topology) throws CoreException {
		Map<String, Object> attributes;
		if (marker == null) {
			attributes = new HashMap<String, Object>();
		} else {
			attributes = marker.getAttributes();
		}
		// marker
		setMarker(marker);
		// markerType
		setMarkerType(marker.getType());

		List<IStatus> statusList = new LinkedList<IStatus>();

		deserializeAttributes(attributes, topology, statusList);

		if (statusList.size() == 0) {
			return Status.OK_STATUS;
		}
		return ConstraintUtil.createMultiStatus(statusList);
	}

	/**
	 * Overriden by subtypes to deserialize additional attributes from {@link IMarker}.
	 * 
	 * @param attributes
	 *           a map of attribute names to primitive values.
	 * @param topology
	 *           a reference to the topology of the status context.
	 * @param statusList
	 *           used to report statuses with deserialization.
	 * @see #createMarker()
	 */
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		// constraints
		if (constraints == null) {
			constraints = new ArrayList<Constraint>();
		} else {
			constraints.clear();
		}
		deserializeCollectionScalarValues((String) attributes.get(IDeployMarker.CONSTRAINTS),
				CorePackage.eINSTANCE.getConstraint(), constraints, topology, statusList);
		// deployObject
		DeployModelObject obj = null;
		String id = (String) attributes.get(IDeployMarker.OBJECT_ID);
		if (id != null && topology != null) {
			obj = topology.resolve(id);
		} else {
			// TODO add status
		}
		setDeployObject(obj);

		// exception: serialization unsupported
		// messageBound
		setUnboundMessage((String) attributes.get(IMarker.MESSAGE));
		setBindings(null);
		// persistent
		setPersistent(true);
		// plugin
		setPlugin((String) attributes.get(IDeployMarker.PLUGIN));
		// priority
		setPriority((Integer) attributes.get(IMarker.PRIORITY));
		// problemType
		setProblemType((String) attributes.get(IDeployMarker.PROBLEM_TYPE));
		// severity
		Integer markerSeverity = (Integer) attributes.get(IMarker.SEVERITY);
		if (markerSeverity == null) {
			markerSeverity = IMarker.SEVERITY_ERROR;
		}
		switch (markerSeverity)
		{
		case IMarker.SEVERITY_ERROR:
			setSeverity(IStatus.ERROR);
			break;
		case IMarker.SEVERITY_WARNING:
			setSeverity(IStatus.WARNING);
			break;
		case IMarker.SEVERITY_INFO:
			setSeverity(IStatus.INFO);
			break;
		default:
			// TODO add status
			setSeverity(IStatus.ERROR);
			break;
		}
		// Deserialization attributes: status class and bundle (already used to instantiate this)

		// validatorID
		setValidatorID((String) attributes.get(IDeployMarker.VALIDATOR_ID));

		// validatorGroupID
		setValidatorGroupID((String) attributes.get(IDeployMarker.VALIDATOR_GROUP_ID));
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof IDeployStatus)) {
			return false;
		}
		if (object == this) {
			return true;
		}
		IDeployStatus status = (IDeployStatus) object;
		return ValidatorUtils.equals(this.getDeployObject(), status.getDeployObject())
				&& ValidatorUtils.equals(this.getException(), status.getException())
				&& ValidatorUtils.equals(this.getMarkerType(), status.getMarkerType())
				&& ValidatorUtils.equals(this.getMessage(), status.getMessage())
				&& ValidatorUtils.equals(this.isPersistent(), status.isPersistent())
				&& ValidatorUtils.equals(this.getPriority(), status.getPriority())
				&& ValidatorUtils.equals(this.getProblemType(), status.getProblemType())
				&& ValidatorUtils.equals(this.getSeverity(), status.getSeverity())
				&& ValidatorUtils.equals(this.getValidatorID(), status.getValidatorID())
				&& ValidatorUtils.equals(this.getValidatorGroupID(), status.getValidatorGroupID());
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(IDeployStatus status) {
		if (status == null) {
			return 1;
		}
		int result;
		if ((result = ValidatorUtils.compareObjectPaths(this.getDeployObject(), status
				.getDeployObject())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getProblemType(), status.getProblemType())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getClass(), status.getClass())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getMarkerType(), status.getMarkerType())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getMessage(), status.getMessage())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getPriority(), status.getPriority())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getSeverity(), status.getSeverity())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getValidatorID(), status.getValidatorID())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils
				.compare(this.getValidatorGroupID(), status.getValidatorGroupID())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getException(), status.getException())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.isPersistent(), status.isPersistent())) != 0) {
			return result;
		}
		return 0;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#getBindings()
	 */
	public Object[] getBindings() {
		return messageParams;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getChildren()
	 */
	public IStatus[] getChildren() {
		return null;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getCode()
	 */
	public int getCode() {
		return 0;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#getConstraints()
	 */
	public List<Constraint> getConstraints() {
		if (constraints == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(constraints);
	}

	/**
	 * Returns an mutable list of constraints (may be null).
	 * 
	 * @return a mutable list of constraints (may be null).
	 */
	public List<Constraint> getConstraintsMutable() {
		return constraints;
	}

	/**
	 * Sets the constraints associated with the status.
	 * 
	 * @param constraints
	 *           the status constraints.
	 */
	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#getTargetObject()
	 */
	public DeployModelObject getDeployObject() {
		return deployObject;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getException()
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * Temporary method to assist in the transition to message-based resolutions.
	 * 
	 * @return the marker for the message.
	 */
	public IMarker getMarker() {
		return marker;
	}

	/**
	 * @return the type of the marker that will be created by this message.
	 * 
	 * @see IMarker#getType()
	 */
	public String getMarkerType() {
		return markerType;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getMessage()
	 */
	public String getMessage() {
		if (messageBound != null) {
			return messageBound;
		}
		if (messageUnbound == null || messageParams == null || messageParams.length == 0) {
			return messageUnbound;
		}

		messageBound = DeployNLS.bind(messageUnbound, messageParams);

		return messageBound;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 */
	public String getPlugin() {
		return plugin;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#getPriority()
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority of the status.
	 * 
	 * @param priority
	 *           a status priority.
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#getProblemType()
	 */
	public String getProblemType() {
		return problemType;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 */
	public int getSeverity() {
		return severity;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 */
	public String getUnboundMessage() {
		return messageUnbound;
	}

	/**
	 * Returns the ID of the validator group that created the message (may be null).
	 * 
	 * @return the validator group ID.
	 * 
	 * @see IDomainValidator#getGroupID()
	 */
	public final String getValidatorGroupID() {
		return validatorGroupID;
	}

	/**
	 * Returns the ID of the validator that created the message (may be null).
	 * 
	 * @return the validator ID.
	 */
	public String getValidatorID() {
		return validatorID;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int code = 0;
		if (deployObject != null) {
			code ^= deployObject.hashCode();
		}
		if (problemType != null) {
			return code ^= problemType.hashCode();
		}
		if (validatorID != null) {
			return code ^= validatorID.hashCode();
		}
		if (messageUnbound != null) {
			return code ^= messageUnbound.hashCode();
		}
		return code;
	}

	public boolean isMultiStatus() {
		return false;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#isOK()
	 */
	public boolean isOK() {
		return getSeverity() == IStatus.OK;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#isPersistent()
	 */
	public boolean isPersistent() {
		return persistent;
	}

	/*
	 * @see org.eclipse.core.runtime.IStatus#matches(int)
	 */
	public boolean matches(int severityMask) {
		return (severity & severityMask) != 0;
	}

	/**
	 * Resets the bound message.
	 */
	public void resetMessage() {
		messageBound = null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#setBindings(java.lang.Object[])
	 */
	public void setBindings(Object[] newParams) {
		messageParams = newParams;
		messageBound = null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#setTargetObject(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public void setDeployObject(DeployModelObject obj) {
		deployObject = obj;
	}

	/**
	 * Set the exception associated with this status message.
	 * 
	 * @param exception
	 *           the status exception.
	 */
	public void setException(Throwable exception) {
		this.exception = exception;
	}

	/**
	 * Sets the marker to which this object was serialized.
	 * 
	 * @param marker
	 *           the serialization marker.
	 */
	public void setMarker(IMarker marker) {
		this.marker = marker;
	}

	/**
	 * Sets the type of marker created by this message.
	 * 
	 * @param type
	 *           the marker type created.
	 * 
	 * @see IResource#createMarker(String)
	 */
	public void setMarkerType(String type) {
		markerType = type;
	}

	/**
	 * Set the persistence of the status as an Eclipse marker.
	 * 
	 * @param isPersistent
	 *           true if the status should be persisted as a marker, false if it is transient.
	 * 
	 * @see IMarker
	 * @see #createMarker()
	 */
	public void setPersistent(boolean isPersistent) {
		persistent = isPersistent;
	}

	/**
	 * Sets the unique identifier of the plug-in associated with this status.
	 * 
	 * @param pluginID
	 *           the unique identifier of the relevant plug-in
	 */
	public void setPlugin(String pluginID) {
		plugin = pluginID;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#setProblemType(java.lang.String)
	 */
	public void setProblemType(String type) {
		problemType = type;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#setSeverity(int)
	 */
	public void setSeverity(int newSeverity) {
		severity = newSeverity;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus#setUnboundMessage(java.lang.String)
	 */
	public void setUnboundMessage(String newId) {
		messageUnbound = newId;
		messageBound = null;
	}

	/**
	 * Sets ID of the validator group that created the message.
	 * <p>
	 * The validator group ID is set by the {@link IDeployStatusReporter} and should not be changed
	 * by validators. It is used to perform incremental status updates. If the group ID is changed by
	 * a validator then the status will either not be cleared (if the group ID is not associated with
	 * a validation group), or be cleared incorrectly when posting the results of validating the
	 * corresponding group ID.
	 * 
	 * @param id
	 *           the validator group ID (may be null).
	 * 
	 * @see IDomainValidator#getGroupID()
	 */
	public final void setValidatorGroupID(String id) {
		validatorGroupID = id;
	}

	/**
	 * Sets ID of the validator that created the message.
	 * 
	 * @param id
	 *           the validator ID (may be null).
	 */
	public void setValidatorID(String id) {
		validatorID = id;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getMessage();
	}

	/**
	 * Serializes a value as a string.
	 * 
	 * @param value
	 *           the expected value
	 * @param type
	 *           optional EMF data type used to serialize the value.
	 * @return the string representation of the expected value.
	 */
	protected String serializeScalarValue(Object value, EClassifier type) {
		if (value == null) {
			return null;
		}

		if (value instanceof DeployModelObject) {
			return ((DeployModelObject) value).getFullPath();
		}

		if (type instanceof EDataType) {
			EDataType eType = (EDataType) type;
			if (eType.isSerializable()) {
				try {
					return type.getEPackage().getEFactoryInstance().convertToString(eType, value);
				} catch (RuntimeException e) {
					DeployCorePlugin.log(IStatus.ERROR, 0, e.getLocalizedMessage(), e);
				}
			}
		}

		// Fall back for unknown type and/or non-serializable value.
		if (value instanceof Serializable) {
			try {
				ByteArrayOutputStream bstream = new ByteArrayOutputStream();
				ObjectOutputStream ostream = new ObjectOutputStream(bstream);
				ostream.writeObject(value);
				ostream.close();
				return bstream.toString();
			} catch (Exception e) {
				DeployCorePlugin.log(IStatus.ERROR, 0, e.getLocalizedMessage(), e);
			}
		}

		DeployCorePlugin.log(IStatus.ERROR, 0,
				DeployCoreMessages.Error_serializing_instance_of_type_0, null);
		return null;
	}

	/**
	 * Deserializes a value serialized using
	 * {@link DeployAttributeValueStatus#serializeValue(Object)}.
	 * 
	 * @param serializedValue
	 *           the serialized value.
	 * @param type
	 *           the type of the deserialized value.
	 * @param topology
	 *           the topology used to resolved object references.
	 * @return the deserialized value.
	 */
	protected Object deserializeScalarValue(String serializedValue, EClassifier type,
			Topology topology) {
		if (serializedValue == null) {
			return null;
		}

		if (type instanceof EClass
				&& CorePackage.eINSTANCE.getDeployModelObject().isSuperTypeOf((EClass) type)) {
			return topology.resolve(serializedValue);
		}

		if (type instanceof EDataType) {
			EDataType eType = (EDataType) type;
			if (eType.isSerializable()) {
				return type.getEPackage().getEFactoryInstance()
						.createFromString(eType, serializedValue);
			}
		}

		try {
			ByteArrayInputStream bstream = new ByteArrayInputStream(serializedValue.getBytes());
			ObjectInputStream istream = new ObjectInputStream(bstream);
			Object value = istream.readObject();
			istream.close();
			return value;
		} catch (Exception e) {
			DeployCorePlugin.log(IStatus.ERROR, 0, DeployCoreMessages.Error_deserializing_value, e);
			return null;
		}
	}

	/**
	 * Serializes the scalar values of a collection as a string
	 * 
	 * @param collection
	 *           the collection.
	 * @param elementType
	 *           optional EMF type of the collection's elements (may be null).
	 */
	protected String serializeCollectionScalarValues(Collection<?> collection,
			EClassifier elementType) {
		if (collection == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		for (Iterator<?> iter = collection.iterator(); iter.hasNext();) {
			Object value = iter.next();
			String strValue = serializeScalarValue(value, elementType);
			if (strValue != null) {
				for (int i = 0; i < strValue.length(); i++) {
					char c = strValue.charAt(i);
					if (c == ',') {
						result.append('\\');
					} else if (c == '\\') {
						result.append('\\');
					}
					result.append(c);
				}
			}
			if (iter.hasNext()) {
				result.append(',');
			}
		}
		return result.toString();
	}

	/**
	 * Deserializes a collection from a string into the collection argument.
	 * 
	 * @param strValue
	 *           a serialized collection.
	 * @param elementType
	 *           the types of the collection.
	 * @param collection
	 *           the collection to which the values will be deserialized (will be cleared first)
	 * @param topology
	 *           the topology used to resolve paths.
	 * @param statusList
	 *           a list of deserialization statuses.
	 */
	protected void deserializeCollectionScalarValues(String strValue, EClassifier elementType,
			Collection collection, Topology topology, List<IStatus> statusList) {
		if (strValue == null || strValue.length() == 0 || collection == null || topology == null) {
			return;
		}
		collection.clear();
		boolean escape = false;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < strValue.length(); i++) {
			char c = strValue.charAt(i);
			if (escape) {
				buffer.append(c);
				escape = false;
			} else {
				if (c == '\\') {
					escape = true;
				} else if (c == ',') {
					collection.add(deserializeScalarValue(buffer.toString(), elementType, topology));
					buffer.setLength(0);
				} else {
					buffer.append(c);
				}
			}
		}
		collection.add(deserializeScalarValue(buffer.toString(), elementType, topology));
		buffer.setLength(0);
	}
}
