/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.core.runtime.IStatus;

/**
 * Exception field of Publish Problems View
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * @see FieldTopology
 */

public class FieldException extends StatusField {

	/**
	 * @param obj
	 * @return exception field's class name if obj instance of {@linkplain}IDeployPublishStatus or
	 *         <code>null</code>
	 * @throws NotSupportedTargetException
	 */
	public String getValue(Object obj) throws NotSupportedTargetException {
		Throwable exe = getObject(obj);
		if (exe != null) {
			return exe.getClass().getName();
		}
		return Messages.NULL_MESSAGE;
	}

	/**
	 * @param obj
	 * @return throwable field of obj
	 * @throws NotSupportedTargetException
	 *            if it can identify obj.
	 */
	public Throwable getObject(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IStatus status = ((StatusNode) obj).getStatus();
			assert (status != null);
			Throwable exe = status.getException();
			return exe;
		}
		throw new NotSupportedTargetException(obj);
	}

	/**
	 * @return
	 * <li>{@link PublishMessages#Column_Title_Exception}
	 */

	public String getColumnHeaderText() {
		return Messages.Field_Exception_Name;
	}

	/**
	 * 
	 */
	public final static FieldException INSTANCE = new FieldException();
}
