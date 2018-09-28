/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.Platform;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * 
 * @author tpouyer
 * 
 */
public class EmptyNamespaceFragmentPropertyTester extends PropertyTester {

	private static final boolean DEBUG = DeployCoreUIPlugin.getDefault().isDebugging()
			&& "true".equalsIgnoreCase(Platform.getDebugOption("com.ibm.ccl.soa.deploy.core.ui/debug/namespace/filter/emptyNamespaceFragmentFilter")); //$NON-NLS-1$ //$NON-NLS-2$

	private static final String PROPERTY_MATCHES_PATTERN = "emptyNamespaceFragment"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (DEBUG)
			System.out
					.println("EmptyNamespaceFragmentPropertyTester.test receiver - " + receiver + " property - " + property + " expectedValue - " + expectedValue); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		if (PROPERTY_MATCHES_PATTERN.equalsIgnoreCase(property)) {
			if (receiver instanceof INamespaceFragment) {
				INamespaceFragment fragment = (INamespaceFragment) receiver;
				if (fragment != null && fragment.getType() == INamespaceElement.TOPOLOGY_NAMESPACE) {

					// case: hide empty namespaces
					if (false == fragment.containsTopologies()
							&& false == fragment.containsNonTopologyResources()
							&& Boolean.TRUE.equals(expectedValue)) {
						return true;
					}

					// case: hide non-empty namespaces
					if ((true == fragment.containsTopologies() || true == fragment
							.containsNonTopologyResources())
							&& Boolean.FALSE.equals(expectedValue)) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
