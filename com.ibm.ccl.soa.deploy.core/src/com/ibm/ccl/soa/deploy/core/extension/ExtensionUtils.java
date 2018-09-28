/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.extension.ICommonDeployExtensionConstants;

/**
 * Set of utility methods to retrive information associated with various extension points defined by
 * the SOA Deploy platform.
 */
public class ExtensionUtils {

	/**
	 * @return the list of all namespaces defined by the SOA Deploy domains.
	 */
	public static List<String> getSoaDeployDomainNamespaces() {
		// The 'DomainManager' class can't be used here; because it doesn't expose
		// a method to list all the provided extensions!

		List<String> retVal = new LinkedList<String>();
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(
				DeployCorePlugin.PLUGIN_ID, ICommonDeployExtensionConstants.TAG_DOMAINS);
		if (point == null) {
			return Collections.emptyList();
		}

		IConfigurationElement[] elements = point.getConfigurationElements();
		for (int i = 0; i < elements.length; i++) {
			String ns = elements[i].getAttribute(ICommonDeployExtensionConstants.ATT_TARGET_NAMESPACE);
			if (ns != null && ns.length() > 0) {
				retVal.add(ns);
			}
		}
		return retVal;
	}
}
