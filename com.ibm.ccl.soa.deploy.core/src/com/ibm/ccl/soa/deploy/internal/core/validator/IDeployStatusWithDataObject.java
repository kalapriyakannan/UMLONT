package com.ibm.ccl.soa.deploy.internal.core.validator;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * @since 7.0
 * 
 */
public interface IDeployStatusWithDataObject extends IDeployStatus {
	/** Name of field containing attributes to be set and their values */
	public static final String DATA_OBJECT = "DATA_OBJECT"; //$NON-NLS-1$

	/**
	 * @return Returns the dataObject.
	 */
	public Object getDataObject();

	/**
	 * @param dataObject
	 *           The dataObject to set.
	 */
	public void setDataObject(Object dataObject);
}
