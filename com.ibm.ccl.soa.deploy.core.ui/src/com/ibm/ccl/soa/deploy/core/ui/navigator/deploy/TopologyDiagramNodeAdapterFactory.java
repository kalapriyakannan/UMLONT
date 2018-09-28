package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;

public class TopologyDiagramNodeAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof TopologyDiagramNode) {
			if (adapterType == IFile.class || adapterType == IResource.class) {
				return ((TopologyDiagramNode) adaptableObject).getAdapter(adapterType);
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IFile.class, IResource.class };
	}

}
