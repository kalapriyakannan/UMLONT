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
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Default implementation of {@link IDeployAttributeValueSourceStatus}.
 */
public class DeployAttributeValueSourceStatus extends DeployAttributeValueStatus implements
		IDeployAttributeValueSourceStatus {

	/**
	 * @see IDeployAttributeValueSourceStatus#getAttributeExpectedValueSourceObject()
	 */
	private DeployModelObject sourceObject = null;

	/**
	 * @see IDeployAttributeValueSourceStatus#getAttributeExpectedValueSourceAttributeName()
	 */
	private String sourceAttributeFullName = null;

	/**
	 * @see IDeployAttributeValueSourceStatus#getAttributeExpectedValueSourceAttributeType()
	 */
	private EAttribute sourceAttributeEType = null;

	/**
	 * Construct a deploy attribute value source status.
	 */
	public DeployAttributeValueSourceStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus#getAttributeExpectedValueSourceObject()
	 */
	public DeployModelObject getAttributeExpectedValueSourceObject() {
		return sourceObject;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus#getAttributeExpectedValueSourceAttributeType()
	 */
	public EAttribute getAttributeExpectedValueSourceAttributeType() {
		if (sourceAttributeEType != null) {
			return sourceAttributeEType;
		}
		if (sourceAttributeFullName == null) {
			return null;
		}
		DeployModelObject object = getDeployObject();
		String attName = getAttributeExpectedValueSourceAttributeName();
		if (object == null || attName == null) {
			return null;
		}

		sourceAttributeEType = DeployCoreStatusUtil.resolveFullEAttributeName(attName, object);
		return sourceAttributeEType;
	}

	/**
	 * @return the {@link EDataType} of the attribute's value.
	 */
	public EDataType getAttributeExpectedValueSourceAttributeDataType() {
		EAttribute attribute = getAttributeExpectedValueSourceAttributeType();
		if (attribute == null) {
			return null;
		}
		return attribute.getEAttributeType();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus#getAttributeExpectedValueSourceAttributeName()
	 */
	public String getAttributeExpectedValueSourceAttributeName() {
		if (sourceAttributeEType != null) {
			DeployCoreStatusUtil.getFullEAttributeName(sourceAttributeEType);
		}
		return sourceAttributeFullName;
	}

	/**
	 * @return return the short name for the source attribute.
	 */
	public String getAttributeExpectedValueSourceAttributeShortName() {
		if (sourceAttributeEType != null) {
			return sourceAttributeEType.getName();
		}
		String attr = getAttributeExpectedValueSourceAttributeName();
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
	public void setAttributeExpectedValueSourceAttributeName(String name) {
		sourceAttributeFullName = name;
		sourceAttributeEType = null; // compute lazily
	}

	/**
	 * Sets the name of the attribute that is referenced.
	 * 
	 * @param attribute
	 *           the reference to the static {@link EAttribute} or the dynamic
	 *           {@link ExtendedAttribute}.
	 */
	public void setAttributeExpectedValueSourceAttributeName(EAttribute attribute) {
		if (attribute == null) {
			sourceAttributeEType = null;
			sourceAttributeFullName = null;
		} else {
			sourceAttributeEType = attribute;
			sourceAttributeFullName = DeployCoreStatusUtil.getFullEAttributeName(attribute);
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployAttributeValueSourceStatus)) {
			return false;
		}
		IDeployAttributeValueSourceStatus as = (IDeployAttributeValueSourceStatus) obj;

		return super.equals(obj)
				&& ValidatorUtils.equals(this.getAttributeExpectedValueSourceObject(), as
						.getAttributeExpectedValueSourceObject())
				&& ValidatorUtils.equals(this.getAttributeExpectedValueSourceAttributeName(), as
						.getAttributeExpectedValueSourceAttributeName());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ ValidatorUtils.hashCode(getAttributeExpectedValueSourceObject())
				^ ValidatorUtils.hashCode(getAttributeExpectedValueSourceAttributeName());
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
		DeployAttributeValueSourceStatus aStatus = (DeployAttributeValueSourceStatus) status;
		if ((result = ValidatorUtils.compareObjectPaths(this.getAttributeExpectedValueSourceObject(),
				aStatus.getAttributeExpectedValueSourceObject())) != 0) {
			return result;
		}
		if ((result = ValidatorUtils.compare(this.getAttributeExpectedValueSourceAttributeName(),
				aStatus.getAttributeExpectedValueSourceAttributeName())) != 0) {
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
		if (sourceObject != null) {
			attributes.put(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE_SOURCE_OBJECT_ID, sourceObject
					.getFullPath());
			attributes.put(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE_SOURCE_OBJECT_TYPE, sourceObject
					.getEObject().eClass().getInstanceClassName());
		}
		attributes.put(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE_SOURCE_ATTRIBUTE_NAME,
				getAttributeExpectedValueSourceAttributeName());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus#deserializeAttributes(java.util.Map,
	 *      com.ibm.ccl.soa.deploy.core.Topology, java.util.List)
	 */
	@Override
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		super.deserializeAttributes(attributes, topology, statusList);
		String id = (String) attributes.get(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE_SOURCE_OBJECT_ID);
		if (id != null && topology != null) {
			sourceObject = topology.resolve(id);
		}
		setAttributeExpectedValueSourceAttributeName((String) attributes
				.get(IDeployMarker.ATTRIBUTE_EXPECTED_VALUE_SOURCE_ATTRIBUTE_NAME));
	}

	public EAttribute getAttributeExpectedValueSourceAttributeType(Topology topology) {
		return getAttributeExpectedValueSourceAttributeType();
	}

	public DeployModelObject getAttributeExpectedValueSourceObject(Topology topology) {
		return getAttributeExpectedValueSourceObject();
	}

	public String getAttributeExpectedValueSourceObjectID() {
		if (sourceObject == null) {
			return null;
		}
		return sourceObject.getFullPath();
	}

	public String getAttributeExpectedValueSourceObjectType() {
		if (sourceObject == null) {
			return null;
		}
		return sourceObject.getEObject().eClass().getInstanceClassName();
	}

	public void setAttributeExpectedValueSourceObject(DeployModelObject object) {
		sourceObject = object;
	}
}
