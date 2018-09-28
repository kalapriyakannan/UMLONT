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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Default implementation of {@link IDeployAttributeStatus}
 */
public class DeployAttributeStatus extends DeployStatus implements IDeployAttributeStatus {

	/**
	 * The full name of the attribute.
	 * 
	 * @see DeployCoreStatusUtil#getFullEAttributeName(EAttribute)
	 * @see IDeployAttributeStatus#getAttributeName()
	 */
	private String attributeFullName = null;

	/**
	 * The attribute EType on the deploy object.
	 * <p>
	 * Can represent an static or an extended attribute.
	 * 
	 * @see IDeployAttributeStatus#getAttributeType()
	 */
	private EAttribute attributeEType = null;

	/**
	 * Construct a deploy attribute status.
	 */
	public DeployAttributeStatus() {
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
	public DeployAttributeStatus(int severity, String validatorID, String problemType,
			String unboundMessage, String[] bindings, DeployModelObject object, EAttribute attribute) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object);
		setMarkerType(IDeployMarker.MARKER_ID);
		setAttributeName(attribute);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus#getAttributeType()
	 */
	public EAttribute getAttributeType() {
		if (attributeEType != null) {
			return attributeEType;
		}
		if (attributeFullName == null) {
			return null;
		}
		DeployModelObject object = getDeployObject();
		String attName = getAttributeName();
		if (object == null || attName == null) {
			return null;
		}

		attributeEType = DeployCoreStatusUtil.resolveFullEAttributeName(attName, object);
		return attributeEType;
	}

	/**
	 * @return the {@link EDataType} of the attribute's value.
	 */
	public EDataType getAttributeDataType() {
		EAttribute attribute = getAttributeType();
		if (attribute == null) {
			return null;
		}
		return attribute.getEAttributeType();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus#getAttributeName()
	 */
	public String getAttributeName() {
		if (attributeEType != null) {
			DeployCoreStatusUtil.getFullEAttributeName(attributeEType);
		}
		return attributeFullName;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus#getAttributeShortName()
	 */
	public String getAttributeShortName() {
		if (attributeEType != null) {
			return attributeEType.getName();
		}
		String attr = getAttributeName();
		if (attr == null) {
			return null;
		}
		int index = attr.indexOf(ATTRIBUTE_NAME_CLASS_SEPARATOR);
		if (index != -1) {
			if (index == attr.length() + 1) {
				return "";//$NON-NLS-1$
			}
			return attr.substring(index + 1);
		}
		return attr;
	}

	/**
	 * Sets the name of the attribute that is referenced.
	 * <p>
	 * If the {@link EAttribute} or {@link ExtendedAttribute} is known, it is preferred to invoke
	 * {@link #setAttributeName(EAttribute)}.
	 * 
	 * @param name
	 *           the name of the attribute associated with the status.
	 */
	public void setAttributeName(String name) {
		attributeFullName = name;
		attributeEType = null; // compute lazily
	}

	/**
	 * Sets the name of the attribute that is referenced.
	 * 
	 * @param attribute
	 *           the reference to the static {@link EAttribute} or the dynamic
	 *           {@link ExtendedAttribute}.
	 */
	public void setAttributeName(EAttribute attribute) {
		if (attribute == null) {
			attributeEType = null;
			attributeFullName = null;
		} else {
			attributeEType = attribute;
			attributeFullName = DeployCoreStatusUtil.getFullEAttributeName(attribute);
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployAttributeStatus)) {
			return false;
		}
		IDeployAttributeStatus as = (IDeployAttributeStatus) obj;

		return super.equals(obj)
				&& ValidatorUtils.equals(this.getAttributeName(), as.getAttributeName());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getAttributeName());
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
		IDeployAttributeStatus aStatus = (IDeployAttributeStatus) status;
		if ((result = ValidatorUtils.compare(this.getAttributeName(), aStatus.getAttributeName())) != 0) {
			return result;
		}
		return 0;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#serializeAttributes(java.util.Map)
	 */
	@Override
	protected void serializeAttributes(Map<String, Object> attributes) {
		super.serializeAttributes(attributes);
		attributes.put(IDeployMarker.ATTRIBUTE_NAME, getAttributeName());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#deserializeAttributes(java.util.Map,
	 *      com.ibm.ccl.soa.deploy.core.Topology, java.util.List)
	 */
	@Override
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		super.deserializeAttributes(attributes, topology, statusList);
		setAttributeName((String) attributes.get(IDeployMarker.ATTRIBUTE_NAME));
	}
}
