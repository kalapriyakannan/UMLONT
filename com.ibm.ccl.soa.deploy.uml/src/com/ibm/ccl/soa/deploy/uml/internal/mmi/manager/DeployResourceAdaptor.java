package com.ibm.ccl.soa.deploy.uml.internal.mmi.manager;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class DeployResourceAdaptor extends AdapterImpl {
	public static String adapterType = "DEPLOY_RESOURCE_ADAPTER"; //$NON-NLS-1$

	public boolean isAdapterForType(Object type) {
		return type.equals(adapterType);
	}

}
