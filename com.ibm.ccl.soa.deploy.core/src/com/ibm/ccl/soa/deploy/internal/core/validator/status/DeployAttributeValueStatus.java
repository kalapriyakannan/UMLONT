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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Default {@link IDeployAttributeValueStatus} implementation.
 */
public class DeployAttributeValueStatus extends DeployAttributeStatus implements
		IDeployAttributeValueStatus {

	/**
	 * @see IDeployAttributeValueStatus#getAttributeExpectedValue()
	 */
	private Object value;

	/**
	 * Default constructor for deploy object attribute statuses with an expected value.
	 */
	public DeployAttributeValueStatus() {
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
	 * @param attribute
	 *           the attribute marked in the status.
	 */
	public DeployAttributeValueStatus(int severity, String validatorID, String problemType,
			String unboundMessage, String[] bindings, DeployModelObject object, EAttribute attribute) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object, attribute);
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus#getAttributeExpectedValue
	 * ()
	 */
	public Object getAttributeExpectedValue() {
		return value;
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus#getAttributeExpectedValue
	 * (org.eclipse.emf.ecore.EDataType, com.ibm.ccl.soa.deploy.core.Topology)
	 */
	public Object getAttributeExpectedValue(EDataType type, Topology topology) {
		return value;
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus#setAttributeExpectedValue
	 * (java.lang.Object)
	 */
	public void setAttributeExpectedValue(Object value) {
		this.value = value;
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployAttributeValueStatus)) {
			return false;
		}
		IDeployAttributeValueStatus as = (IDeployAttributeValueStatus) obj;

		return super.equals(obj) && equivalentValue(as);
	}

	protected boolean equivalentValue(IDeployAttributeValueStatus as) {
		return ValidatorUtils
				.equals(this.getAttributeExpectedValue(), as.getAttributeExpectedValue());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getAttributeExpectedValue());
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(IDeployStatus status) {
		int result;
		if ((result = super.compareTo(status)) != 0) {
			return result;
		}
		DeployAttributeValueStatus aStatus = (DeployAttributeValueStatus) status;
		if ((result = ValidatorUtils.compare(this.getAttributeExpectedValue(), aStatus
				.getAttributeExpectedValue())) != 0) {
			return result;
		}
		return 0;
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#serializeAttributes(java
	 * .util.Map)
	 */
	@Override
	protected void serializeAttributes(Map<String, Object> attributes) {
		super.serializeAttributes(attributes);
		if (value instanceof List) {
			attributes.put(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE, serializeCollectionScalarValues(
					(List) value, getAttributeDataType()));
		} else {
			attributes.put(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE, serializeScalarValue(value,
					getAttributeDataType()));
		}
	}

	/*
	 * @see
	 * com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus#deserializeAttributes
	 * (java.util.Map, com.ibm.ccl.soa.deploy.core.Topology, java.util.List)
	 */
	@Override
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		super.deserializeAttributes(attributes, topology, statusList);
		String strValue = (String) attributes.get(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE);
		EAttribute attr = getAttributeType();
		if (attr == null) {
			// this is strange, anyway ...
			setAttributeExpectedValue(deserializeScalarValue(strValue, getAttributeDataType(),
					topology));
		} else {
			Object attrValue = getDeployObject().eGet(attr);
			if (attrValue instanceof List) {
				List values = new LinkedList();
				deserializeCollectionScalarValues(strValue, getAttributeDataType(), values, topology,
						statusList);
				setAttributeExpectedValue(values);
			} else {
				setAttributeExpectedValue(deserializeScalarValue(strValue, getAttributeDataType(),
						topology));
			}
		}
	}
}
