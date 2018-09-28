package com.ibm.ccl.soa.deploy.core.ui.internal.search.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;

public class MatchAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof Match) {

			Match match = (Match) adaptableObject;
			URI uri = match.getReferencing();

			if (adapterType == IResource.class || adapterType == IFile.class) {
				return ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(uri.toPlatformString(true)));
			}

			if (adapterType == URI.class) {
				return uri;
			}
		}

		return null;
	}

	public Class[] getAdapterList() {
		return new Class[] { IResource.class, IFile.class, URI.class };
	}

}
