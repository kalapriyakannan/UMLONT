/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * Create a filter for Units that match a given proxy.
 * 
 * @since 1.0
 * 
 */
public class LinkProxyFilter implements IObjectFilter {

	private String sourcePath;

	/**
	 * Create a filter that will only accept links that have the given proxy set as their source.
	 * 
	 * @param proxy
	 */
	public LinkProxyFilter(DeployModelObject proxy) {
		sourcePath = proxy.getFullPath();
	}

	public boolean accept(Object value) {
		if (sourcePath != null) {

			if (value != null && value instanceof DeployLink) {
				String valueSourcePath = ((DeployLink) value).getSourceURI();
				return sourcePath.equals(valueSourcePath);
			}
		}
		return false;
	}

}
