/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.bindings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.infrastructure.emf.RegistryReader;

public class BindingsHelperManager {

	public static String TAG_BINDINGS_BRIDGE = "bindings"; //$NON-NLS-1$
	public static String TAG_BINDINGS_HELPER = "helper"; //$NON-NLS-1$
	private IBindingsHelper defaultBindingsHelper;
	private static BindingsHelperManager instance = null;
	private static final IBindingsHelper[] NO_ELEMENTS = new IBindingsHelper[0];

	private final Set helpers = new HashSet();

	private BindingsHelperManager() {
		new BindingsHelperRegistry().readRegistry();
	}

	public static BindingsHelperManager getInstance() {
		if (instance == null) {
			instance = new BindingsHelperManager();
		}
		return instance;
	}

	public IBindingsHelper[] findEnabledBindingsHelpers(Unit aUnit) {
		if (aUnit == null) {
			return NO_ELEMENTS;
		}
		List enabledHelpers = new ArrayList();

		BindingsHelperDescriptor descriptor;
		for (Iterator elementsItr = helpers.iterator(); elementsItr.hasNext();) {
			descriptor = (BindingsHelperDescriptor) elementsItr.next();
			if (descriptor.isEnabled(aUnit)) {
				enabledHelpers.add(descriptor.createBindingsHelper());
			}
		}
		if (enabledHelpers.size() == 0) {
			return NO_ELEMENTS;
		}
		return (IBindingsHelper[]) enabledHelpers.toArray(new IBindingsHelper[enabledHelpers.size()]);

	}

	public IBindingsHelper getDefault() {
		return new AbstractBindingsHelper();
	}

	private void addBindingsHelperDescriptor(BindingsHelperDescriptor element) {
		helpers.add(element);
	}

	private class BindingsHelperRegistry extends RegistryReader {

		private BindingsHelperRegistry() {
			super(Platform.getExtensionRegistry(), J2EEDeployPlugin.pluginID, TAG_BINDINGS_BRIDGE);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_BINDINGS_HELPER.equals(element.getName())) {
				addBindingsHelperDescriptor(new BindingsHelperDescriptor(element));
				return true;
			}
			return false;
		}
	}

}
