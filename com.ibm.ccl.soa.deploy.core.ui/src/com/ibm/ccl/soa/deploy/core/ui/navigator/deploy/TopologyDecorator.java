/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;

public class TopologyDecorator implements ILightweightLabelDecorator {

	private ROTopologyModelManager refreshManager;

	private final ROTopologyModelManager.Listener modelListener = new ROTopologyModelManager.Listener() {
		public void onUnload(IFile unloadedResource) {
			// Do something here?
		}
	};

	public void decorate(Object element, IDecoration decoration) {
		if (element == null) {
			return;
		}

		if (element instanceof IFile) {
			IFile topFile = (IFile) element;
			if (topFile.getProject().isAccessible() && topFile.isAccessible()
					&& IConstants.TOPOLOGY_EXTENSION.equals(topFile.getFileExtension())) {
				if (refreshManager == null) {
					refreshManager = ROTopologyModelManager.create();
				}
				Topology top = refreshManager.openModel(topFile, modelListener, false);
				// if the topology can't be opened it has no icon
				if (top != null) {
					IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
					if (rts.isDynamicPaletteEntry(top)) {
						decoration
								.addOverlay(getImageDescriptor(ISharedImages.IMG_REUSABLE_TOPOLOGY_OVRLY));
					}
				}
			}
		}
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		if (null != refreshManager) {
			SafeRunner.run(new ISafeRunnable() {
				public void run() throws Exception {
					refreshManager.dispose();
				}

				public void handleException(Throwable ex) {
					DeployCoreUIPlugin.logError(0, ex.toString(), ex);
				}
			});
		}
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
