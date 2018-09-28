/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;

/**
 * problemType field of Publish Problem View
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 */
public class FieldProblemType extends StatusField {
	/**
	 * @return problemType field if obj instance of {@link IDeployPublishStatus} or <code>null</code>
	 * @throws NotSupportedTargetException
	 */
	public String getValue(Object obj) throws NotSupportedTargetException {
		if (obj instanceof StatusNode) {
			IDeployPublishStatus status = (IDeployPublishStatus) ((StatusNode) obj).getStatus();
			assert (status != null);
			return status.getProblemType();
		}

		throw new NotSupportedTargetException(obj);
	}

	/**
	 * @return
	 * <li>{@value PublishMessages#Column_Title_ProblemType}</li>
	 */
	public String getColumnHeaderText() {
		// TODO Auto-generated method stub
		return Messages.Field_ProblemType_Name;
	}

	/**
	 * 
	 */
	public final static FieldProblemType INSTANCE = new FieldProblemType();
}
