/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.publisher;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;

/**
 * Utility methods for publish validation
 */
public class PublisherValidationUtils {

	/**
	 * Create a publish status
	 * 
	 * @param publisherName
	 * @param msg
	 * @param ex
	 * @param obj
	 * @return
	 */
	public static IDeployPublishStatus createPublisherStatus(String publisherName, String msg,
			Exception ex, DeployModelObject obj) {
		return DeployCoreStatusFactory.INSTANCE.createPublisherStatus(IStatus.ERROR, publisherName,
				"", //TODO  //$NON-NLS-1$
				msg, new String[] { obj.getName() }, ex, obj);
	}

}
