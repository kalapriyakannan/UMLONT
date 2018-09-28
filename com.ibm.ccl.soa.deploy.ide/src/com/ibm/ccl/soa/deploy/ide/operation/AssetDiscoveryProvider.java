/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.operation;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.AbstractDataModelProvider;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;
import org.eclipse.wst.server.core.IRuntime;

import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.extension.DeployIdeMessages;

public class AssetDiscoveryProvider extends AbstractDataModelProvider implements
		IAssetDiscoveryDataModelProperties {

	public Set getPropertyNames() {
		Set propertyNames = super.getPropertyNames();
		propertyNames.add(ASSET_DISCOVERY_SELECTED_ITEM);
		propertyNames.add(ASSET_DISCOVERY_RUNTIME);
		propertyNames.add(ASSET_DISCOVERY_RUNTIME_LOCATION);
		propertyNames.add(ALLOW_EXTENSIONS);
		return propertyNames;
	}

	public IStatus validate(String name) {
		if (name.equals(ASSET_DISCOVERY_SELECTED_ITEM)) {
			Object selectedItem = model.getProperty(ASSET_DISCOVERY_SELECTED_ITEM);
			if (selectedItem == null) {
				return new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, 0,
						DeployIdeMessages.AssetDiscoveryProvider_Please_select_a_Deployabl_, null);
			}
		}
		return super.validate(name);
	}

	public Object getDefaultProperty(String propertyName) {
		if (propertyName.equals(ASSET_DISCOVERY_RUNTIME)) {
			Object element = getProperty(ASSET_DISCOVERY_SELECTED_ITEM);
			if (element instanceof IRuntime) {
				return element;
			}
		} else if (propertyName.equals(ASSET_DISCOVERY_RUNTIME_LOCATION)) {
			Object element = getProperty(ASSET_DISCOVERY_RUNTIME);
			if (element instanceof IRuntime) {
				IRuntime runtime = (IRuntime) element;
				return runtime.getLocation().toOSString();
			}

		} else if (propertyName.equals(ALLOW_EXTENSIONS)) {
//			Object element = getProperty(ASSET_DISCOVERY_RUNTIME);
			return new Boolean(true);

		}
		return super.getDefaultProperty(propertyName);
	}

	public IDataModelOperation getDefaultOperation() {
		return new AssetDataModelOperation(model);
	}

}
