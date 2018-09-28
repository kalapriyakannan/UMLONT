package com.ibm.ccl.soa.deploy.internal.core.validator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * An implementation of the deploy status interface.
 * <p>
 * Supports the new Eclipse message mechanism (
 * {@link "http://dev.eclipse.org/viewcvs/index.cgi/%7Echeckout%7E/platform-core-home/documents/3.1/message_bundles.html"})
 */
public class DeployStatusWithDataObject extends DeployStatus implements IDeployStatusWithDataObject {

	/**
	 * @see IDeployStatusWithDataObject#getDataObject()
	 */
	private Object dataObject = null;

	/**
	 * Construct a deploy status with a data object.
	 */
	public DeployStatusWithDataObject() {
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
	 * @param dataObject
	 *           object to pass to resolution generator
	 */
	public DeployStatusWithDataObject(int severity, String validatorID, String problemType,
			String unboundMessage, Object[] bindings, DeployModelObject object, Object dataObject) {
		super(severity, validatorID, problemType, unboundMessage, bindings, object);
		setMarkerType(IDeployMarker.MARKER_ID);
		setDataObject(dataObject);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.IDeployStatusWithDataObject#getDataObject()
	 */
	public Object getDataObject() {
		return dataObject;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.IDeployStatusWithDataObject#setDataObject(java.lang.Object)
	 */
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IDeployStatusWithDataObject)) {
			return false;
		}
		IDeployStatusWithDataObject s = (IDeployStatusWithDataObject) obj;
		return super.equals(s) && ValidatorUtils.equals(this.getDataObject(), s.getDataObject());
	}
}
