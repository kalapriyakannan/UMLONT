/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;

public class TopologyProjectDecorator implements ILightweightLabelDecorator {

	public void decorate(Object element, IDecoration decoration) {
		if (element == null)
			return;

		if (!(element instanceof IProject))
			return;

		IProject project = (IProject) element;
		INamespaceFragmentRoot[] roots = NamespaceCore
				.locateRoots(project, new NullProgressMonitor());

		if (roots.length == 0)
			return;

		decoration.addOverlay(getImageDescriptor(ISharedImages.IMG_TOPOLOGY_PROJECT_OVRLY));
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	public ImageDescriptor getImageDescriptor(String name) {
		return DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(name);
	}

}
