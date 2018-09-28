/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixStatusComposite.StatusViewFilter;

public class QuickFixPrimaryDialogToolBarManager {

	private com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixStatusComposite.StatusViewFilter statusFilter;
	private final ToolBarManager toolBarManager;
	private TreeViewer treeViewer;

	public QuickFixPrimaryDialogToolBarManager(ToolBarManager toolBarManager) {
		this.toolBarManager = toolBarManager;
		initalizeToolBar();
	}

	private void initalizeToolBar() {
		QuickFixFilterAction filterErrorAction = new QuickFixFilterAction(IStatus.ERROR);
		filterErrorAction.setChecked(true);
		QuickFixFilterAction filterWarningAction = new QuickFixFilterAction(IStatus.WARNING);
		filterWarningAction.setChecked(true);
		QuickFixFilterAction filterInfoAction = new QuickFixFilterAction(IStatus.INFO);
		filterInfoAction.setChecked(true);
		toolBarManager.add(filterErrorAction);
		toolBarManager.add(new Separator());
		toolBarManager.add(filterWarningAction);
		toolBarManager.add(new Separator());
		toolBarManager.add(filterInfoAction);
		toolBarManager.add(new Separator());

	}

	public class QuickFixFilterAction extends Action {

		int filterType;

		public QuickFixFilterAction(int filterType) {
			super();
			this.filterType = filterType;
		}

		@Override
		public int getStyle() {
			return IAction.AS_CHECK_BOX;
		}

		@Override
		public void run() {
			switch (filterType)
			{
			case IStatus.ERROR: {
				statusFilter.toggleFilterErrors();
				break;
			}
			case IStatus.WARNING: {
				statusFilter.toggleFilterWarnings();
				break;
			}

			case IStatus.INFO: {
				statusFilter.toggleFilterInfos();
				break;
			}

			default:
				break;
			}

			treeViewer.refresh();
			//Expand the view so the user can see the problems.
			treeViewer.expandAll();

		}

		public ImageDescriptor getImageDescriptor() {

			switch (filterType)
			{
			case IStatus.ERROR: {
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
						ISharedImages.IMG_ERROR16);

			}
			case IStatus.WARNING: {
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
						ISharedImages.IMG_WARNING16);
			}
			case IStatus.INFO: {
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
						ISharedImages.IMG_INFO16);

			}

			default:
				break;
			}

			return null;
		}
	};

	void cacheViewerAndFilter(TreeViewer treeViewer, StatusViewFilter filter) {
		this.treeViewer = treeViewer;
		statusFilter = filter;
	};

}
