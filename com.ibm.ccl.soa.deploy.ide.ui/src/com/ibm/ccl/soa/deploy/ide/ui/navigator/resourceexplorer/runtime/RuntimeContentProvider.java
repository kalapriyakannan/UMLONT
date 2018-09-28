/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.ui.navigator.resourceexplorer.runtime;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeLifecycleListener;
import org.eclipse.wst.server.core.ServerCore;

import com.ibm.ccl.soa.deploy.ide.asset.management.DiscoveredAssetManager;
import com.ibm.ccl.soa.deploy.ide.ui.Messages;

/**
 * @since 1.0
 * 
 */
public class RuntimeContentProvider extends
		org.eclipse.wst.server.ui.internal.viewers.RuntimeContentProvider implements
		ICommonContentProvider {
	private static final Object[] EMPTY_ELEMENT_ARRAY = new Object[0];

	private IVirtualNode applicationServerRoot;

	private CommonViewer viewer;

	private class RuntimeLifecycleListener implements IRuntimeLifecycleListener {

		public void runtimeAdded(final IRuntime runtime) {
			if (getViewer() == null) {
				return;
			}

			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (!getViewer().getControl().isDisposed()) {
						getViewer().refresh(applicationServerRoot);
						getViewer().reveal(runtime);
					}
				}
			});

		}

		public void runtimeChanged(final IRuntime runtime) {
			if (getViewer() == null) {
				return;
			}

			refreshViewer(runtime);

		}

		public void runtimeRemoved(final IRuntime runtime) {
			if (getViewer() == null) {
				return;
			}
			// temporary, need to refresh children not entire tree
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (!getViewer().getControl().isDisposed()) {
						getViewer().refresh(applicationServerRoot);
						getViewer().expandToLevel(applicationServerRoot, 1);

					}
				}
			});

		}

	}

	private final RuntimeLifecycleListener listener = new RuntimeLifecycleListener();

	/**
	 * 
	 */
	public RuntimeContentProvider() {
		ServerCore.addRuntimeLifecycleListener(listener);
		DiscoveredAssetManager.getInstance().addProvider(this);
	}

	public void dispose() {
		ServerCore.removeRuntimeLifecycleListener(listener);
		DiscoveredAssetManager.getInstance().removeProvider(this);
		super.dispose();
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ApplicationServerNode) {
			return super.getElements(parentElement);
		} else if (parentElement instanceof IWorkspaceRoot) {
			return new Object[] { getOrCreateApplicationServerRoot((IWorkspaceRoot) parentElement) };
		}

		return EMPTY_ELEMENT_ARRAY;
	}

	public Object getParent(Object element) {
		if (element instanceof IVirtualNode) {
			return ((IVirtualNode) element).getParent();
		} else if (element instanceof IRuntime) {
			return applicationServerRoot;
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IWorkspaceRoot) {
			return true;
		}
		if (element instanceof ApplicationServerNode) {
			return getElements(element).length > 0 ? true : false;
		}
		if (element instanceof IRuntime) {
			return DiscoveredAssetManager.getInstance().hasConfigurations((IRuntime) element);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.server.ui.internal.viewers.RuntimeContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @param root
	 * @return IVirtualNode
	 */
	private IVirtualNode getOrCreateApplicationServerRoot(IWorkspaceRoot root) {
		if (applicationServerRoot != null) {
			return applicationServerRoot;
		}

		synchronized (this) {
			if (applicationServerRoot == null) {
				applicationServerRoot = new ApplicationServerNode(Messages.APPLICATION_SERVERS,
						Messages.APPLICATION_SERVERS, root);
			}
		}
		return applicationServerRoot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento aMemento) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento aMemento) {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if (this.viewer != null && newInput instanceof IRuntime) {
			IRuntime runtime = (IRuntime) newInput;
			refreshViewer(runtime);
		}
		if (viewer != null) {
			this.viewer = (CommonViewer) viewer;
		}

	}

	/**
	 * @return CommonViewer
	 */
	public CommonViewer getViewer() {
		return viewer;
	}

	public void init(ICommonContentExtensionSite aConfig) {

	}

	private void refreshViewer(final IRuntime runtime) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (!getViewer().getControl().isDisposed()) {
					getViewer().refresh(runtime, true);
				}
			}
		});
	}
}
