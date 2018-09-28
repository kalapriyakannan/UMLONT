/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.operation;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;
import com.ibm.ccl.soa.deploy.ide.internal.scheme.ITopologyCreationSchemeConstants;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerDataModelProvider;

public class RCTCreateTopologyExtensionProvider extends AbstractScribblerDataModelProvider
		implements IDataModelProvider, RCTCreateTopologyExtensionProperties {

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(DEPLOYABLE_SELECTED_ITEMS);
		propertyNames.add(CREATED_UNITS);
		propertyNames.add(TOPOLOGY_CREATION_SCHEME);
		propertyNames.add(DEPLOYABLE_SELECTED_SERVERS);
		propertyNames.add(ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER);
		propertyNames.add(ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER);
		propertyNames.add(DEPLOYABLE_SELECTED_SERVERS);
		return propertyNames;
	}

	public IDataModelOperation getDefaultOperation() {
		return null;
	}

	public IStatus validate(String name) {
		/*
		 * if (name.equals(DEPLOYABLE_SELECTED_ITEMS) && model.getProperty(DEPLOYABLE_SELECTED_ITEMS) !=
		 * null) {
		 * 
		 * Object[] selectedItems = (Object[]) model.getProperty(DEPLOYABLE_SELECTED_ITEMS); if
		 * (selectedItems.length < 1) { return new Status(IStatus.ERROR, IDEUIPlugin.PLUGIN_ID, 0,
		 * Messages.DEPLOYBALES_PAGE_NO_SELECTION, null);} }
		 */
		return super.validate(name);
	}

	public Object getDefaultProperty(String propertyName) {
		if (propertyName.equals(TOPOLOGY_CREATION_SCHEME)) {
			return ITopologyCreationSchemeConstants.SIMPLE_TOPOLOGY_CREATION_SCHEME;
		} else if (propertyName.equals(ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER)) {
			return new Boolean(true);
		} else if (propertyName
				.equals(ITopologyDiscoveryProperties.IS_CREATE_FIND_DEPENDENCIES_FILTER)) {
			return new Boolean(false);
		}
		return super.getDefaultProperty(propertyName);
	}
}
