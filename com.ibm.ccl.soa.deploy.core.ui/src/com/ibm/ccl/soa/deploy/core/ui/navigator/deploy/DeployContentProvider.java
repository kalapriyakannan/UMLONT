/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.index.AbstractModelIndexListener;
import com.ibm.ccl.soa.deploy.core.ui.RefreshJob;

/**
 * @since 1.0 DeployContentProvider provides the contents for the Deployment Navigator. Fulfills the
 *        <code>org.eclipse.ui.navigator.navigatorContent</code> extension point in *.core.ui.
 * 
 * <p>
 * Formerly this provider provided a third catagory, 'Deployable Projects', that category now comes
 * from the *.ide.ui project.
 * 
 * @see DeployLabelProvider
 */
public class DeployContentProvider implements ICommonContentProvider {

	private static final Object[] NO_OBJECT = new Object[0];

	private static final long REFRESH_DELAY = 100;

	private IWorkspaceRoot workspaceRoot;

	private final AbstractModelIndexListener modelListener = new AbstractModelIndexListener() {

		public void projectsClosed(IProject[] projects) {
			handleRefresh();
		}

		public void projectsOpened(IProject[] projects) {
			handleRefresh();
		}

		public void projectsAdded(IProject[] projects) {
			handleRefresh();
		}

		public void projectsRemoved(IProject[] projects) {
			handleRefresh();
		}

		public void modelsAdded(IFile[] modelFiles) {
			handleRefresh();
		}

		public void modelsRemoved(IFile[] modelFiles) {
			handleRefresh();
		}

		private void handleRefresh() {
			if (refreshJob != null) {
				refreshJob.enqueue(workspaceRoot);
			}
		}
	};

	private RefreshJob refreshJob;

	public void init(ICommonContentExtensionSite aConfig) {
		DeployCorePlugin.getDefault().getIndexer().addModelListener(modelListener);

	}

	public Object[] getChildren(Object parentElement) {
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof IProject) {
			return ((IProject) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IWorkspaceRoot)
			return true;
		return false;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
		DeployCorePlugin.getDefault().getIndexer().removeModelListener(modelListener);

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput != null && newInput instanceof IWorkspaceRoot) {
			workspaceRoot = (IWorkspaceRoot) newInput;
		}

		Assert.isTrue(viewer instanceof AbstractTreeViewer);
		refreshJob = new RefreshJob((AbstractTreeViewer) viewer, REFRESH_DELAY);
	}

	public void restoreState(IMemento aMemento) {

	}

	public void saveState(IMemento aMemento) {
	}

}
