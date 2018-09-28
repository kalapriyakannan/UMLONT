/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.publish;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.IModelFileIndex;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusContentProvider;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.StatusNode;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter.FilterConfig;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;

/**
 * 
 * @author lynn
 * 
 */
public class PublishContentProvider extends StatusContentProvider {
	private final IObjectFilter statusFilter = new IObjectFilter() {

		public boolean accept(Object value) {
			if (value instanceof IDeployPublishStatus) {
				return true;

			}
			return false;
		}

	};

	private ROTopologyModelManager modelManager = ROTopologyModelManager.create();
	private ROTopologyModelManager.Listener listener = new ROTopologyModelManager.Listener() {

		public void onUnload(IFile unloadedResource) {
			// usage is not long term; can be ignored.

		}

	};

	public void dispose() {
		super.dispose();
		modelManager.dispose();
	}

	public Object[] getElements(Object inputElement) {
		if (config == null)
			return new Object[0];
		return groupElements(getFilteredNodeList());
	}

	private List getFilteredNodeList() {
		List nodeList = new LinkedList();
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		FilterConfig filter = config.getSelectedFilter();
		final IProject[] projects = root.getProjects();
		// filter elements.
		for (int i = 0; i < projects.length; i++) {

			IModelFileIndex modelIndex = DeployCoreUIPlugin.getDefault().getIndex(projects[i]);

			IFile[] modelFiles = modelIndex.getModelFiles();

			for (int j = 0; j < modelFiles.length; j++) {

				if (config.getSelectedFilter().accept(modelFiles[j])) {

					Topology topology = modelManager.openModel(modelFiles[j], listener);

					for (final Iterator dmoIter = topology.findAllDeployModelObjects(); dmoIter
							.hasNext();) {
						final DeployModelObject obj = (DeployModelObject) dmoIter.next();
						for (final Iterator statusIter = new FilterIterator(new StatusIterator(obj
								.getStatus()), statusFilter); statusIter.hasNext();) {
							final IDeployPublishStatus status = (IDeployPublishStatus) statusIter.next();

							StatusNode node = new StatusNode(status);
							if (filter.accept(node))
								nodeList.add(node);

						}
					}
				}
			}

		}
		return nodeList;
	}
}
