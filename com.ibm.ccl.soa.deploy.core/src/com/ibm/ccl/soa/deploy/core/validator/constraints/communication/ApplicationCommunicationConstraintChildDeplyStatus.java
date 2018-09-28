/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.NetworkCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * Base implementation of status indicating a problem on a child of
 * {@link ApplicationCommunicationConstraint}; expected to be extended.
 */
public class ApplicationCommunicationConstraintChildDeplyStatus extends DeployStatus implements
		IApplicationCommunicationConstraintChildDeployStatus {

	private NetworkCommunicationConstraint targetNcc = null;

	private EClass constraintType;

	private String displayName;

	private List<AttributeValuePair> attributeData;

	public ApplicationCommunicationConstraintChildDeplyStatus() {
		setMarkerType(IDeployMarker.MARKER_ID);
	}

	/**
	 * Constructor.
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
	 * @param ncc
	 *           the {@link NetworkCommunicationConstraint} missing the port constraint
	 */
	public ApplicationCommunicationConstraintChildDeplyStatus(int severity, String validatorID,
			String problemType, String unboundMessage, Object[] bindings, DeployModelObject object,
			EClass type, String name, List<AttributeValuePair> aData,
			NetworkCommunicationConstraint ncc) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object);
		setMarkerType(IDeployMarker.MARKER_ID);
		setConstraintType(type);
		setDisplayName(name);
		setAttributeData(aData);
		setTargetNcc(ncc);
	}

	protected void setTargetNcc(NetworkCommunicationConstraint ncc) {
		targetNcc = ncc;
	}

	public NetworkCommunicationConstraint getTargetNcc() {
		return targetNcc;
	}

	protected void setConstraintType(EClass type) {
		constraintType = type;
	}

	public EClass getConstraintType() {
		return constraintType;
	}

	protected void setDisplayName(String name) {
		displayName = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	protected void setAttributeData(List<AttributeValuePair> aData) {
		attributeData = aData;
	}

	public List<AttributeValuePair> getAttributeData() {
		return attributeData;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IApplicationCommunicationConstraintChildDeployStatus)) {
			return false;
		}
		IApplicationCommunicationConstraintChildDeployStatus cs = (IApplicationCommunicationConstraintChildDeployStatus) obj;

		return super.equals(cs) && ValidatorUtils.equals(this.getTargetNcc(), cs.getTargetNcc())
				&& ValidatorUtils.equals(this.getConstraintType(), cs.getConstraintType())
				&& ValidatorUtils.equals(this.getDisplayName(), cs.getDisplayName())
				&& ValidatorUtils.equals(this.getAttributeData(), cs.getAttributeData());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#serializeAttributes(java.util.Map)
	 */
	@Override
	protected void serializeAttributes(Map<String, Object> attributes) {
		super.serializeAttributes(attributes);
		attributes.put(IDeployMarker.APP_COMM_ATTRIBUTE_DATA, super.serializeCollectionScalarValues(
				getAttributeData(), null));
		attributes.put(IDeployMarker.APP_COMM_DISPLAY_NAME, getDisplayName());
		attributes.put(IDeployMarker.APP_COMM_TARGET_NCC, serializeScalarValue(getTargetNcc(),
				ConstraintPackage.eINSTANCE.getNetworkCommunicationConstraint()));
		attributes.put(IDeployMarker.APP_COMM_TYPE, serializeScalarValue(getConstraintType(),
				EcorePackage.eINSTANCE.getEClass()));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployAttributeStatus#deserializeAttributes(java.util.Map,
	 *      com.ibm.ccl.soa.deploy.core.Topology, java.util.List)
	 */
	@Override
	protected void deserializeAttributes(Map<String, Object> attributes, Topology topology,
			List<IStatus> statusList) {
		super.deserializeAttributes(attributes, topology, statusList);

		List<AttributeValuePair> aData = new ArrayList<AttributeValuePair>();
		deserializeCollectionScalarValues((String) attributes
				.get(IDeployMarker.APP_COMM_ATTRIBUTE_DATA), null, attributeData, topology, statusList);
		setAttributeData(aData);
		setDisplayName((String) attributes.get(IDeployMarker.APP_COMM_DISPLAY_NAME));
		setTargetNcc((NetworkCommunicationConstraint) deserializeScalarValue((String) attributes
				.get(IDeployMarker.APP_COMM_TARGET_NCC), ConstraintPackage.eINSTANCE
				.getNetworkCommunicationConstraint(), topology));
		setConstraintType((EClass) deserializeScalarValue((String) attributes
				.get(IDeployMarker.APP_COMM_TYPE), EcorePackage.eINSTANCE.getEClass(), topology));
	}
}
