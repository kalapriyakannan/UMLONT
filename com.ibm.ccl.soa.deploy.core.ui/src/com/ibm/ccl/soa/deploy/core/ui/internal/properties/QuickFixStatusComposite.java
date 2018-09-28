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

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;

public class QuickFixStatusComposite extends Composite {

	static class StatusViewFilter extends ViewerFilter {
		private boolean filterError;
		private boolean filterInfo;
		private boolean filterWarning;
		private final QuickFixStausContentProvider contentProvider;

		public StatusViewFilter(QuickFixStausContentProvider aProvider) {
			contentProvider = aProvider;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return !shouldFilter(element);
		}

		private boolean shouldFilter(Object element) {
			if (element instanceof IStatus) {
				return shouldFilter((IStatus) element);
			} else if (element instanceof Unit) {
				return shouldFilter((Unit) element);
			}
			return false;
		}

		/*
		 * Check if this unit has any non-filtered statuses or any children with non-filtered
		 * statuses. Only filter if no statuses are visible locally or by any children.
		 */
		private boolean shouldFilter(Unit unit) {
			Object[] children = contentProvider.getChildren(unit);
			for (int i = 0; i < children.length; i++) {
				if (!shouldFilter(children[i])) {
					return false;
				}
			}
			return true;
		}

		public void toggleFilterErrors() {
			filterError = !filterError;
		}

		public void toggleFilterInfos() {
			filterInfo = !filterInfo;
		}

		public void toggleFilterWarnings() {
			filterWarning = !filterWarning;
		}

		/**
		 * @param status
		 * @return <code>true</code> if status should not appear in the tree
		 */
		private boolean shouldFilter(IStatus status) {
			switch (status.getSeverity())
			{
			case IStatus.ERROR: {
				return filterError;
			}
			case IStatus.WARNING: {
				return filterWarning;
			}
			case IStatus.INFO: {
				return filterInfo;
			}
			default:
				break;
			}
			return false;
		}
	};

	public class GroupHolder {
		DeployModelObject obj;

		public GroupHolder(DeployModelObject obj) {
			super();
			this.obj = obj;
		}

		public DeployModelObject getObj() {
			return obj;
		}

	};

	public class DmoListHolder {
		List<DeployModelObject> dmoList;

		public DmoListHolder(List<DeployModelObject> dmoList) {
			super();
			this.dmoList = dmoList;
		}

		public List<DeployModelObject> getList() {
			return dmoList;
		}

	};

	private final IMarker[] markers;
	private final boolean includeUnits = false;
	private TreeViewer treeViewer;
	private final DeployModelObject dmo;
	private ErrorMarkerDecorator decorator;
	private List<DeployModelObject> dmoList;
	boolean isGroup;
	private StatusViewFilter statusFilter;

	public QuickFixStatusComposite(Composite parent, int style, DeployModelObject dmo) {
		super(parent, style);
		setLayout(new GridLayout());
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.dmo = dmo;
		markers = null;
		createContents(this);
	}

	public QuickFixStatusComposite(Composite parent, int style, DeployModelObject dmo,
			IMarker[] markers, boolean includeUnits, ErrorMarkerDecorator decorator,
			List<DeployModelObject> dmoList, boolean isGroup) {
		super(parent, style);
		this.markers = markers;
		this.dmo = dmo;
		this.decorator = decorator;
		this.dmoList = dmoList;
		this.isGroup = isGroup;
		setLayout(new GridLayout());
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createContents(this);
	}

	private void createContents(Composite parent) {
		Tree tree = new Tree(parent, SWT.None);
		treeViewer = new TreeViewer(tree);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 200;
		gd.widthHint = 400;
		treeViewer.getTree().setLayoutData(gd);
		ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager()
				.getLabelDecorator();
		if (decorator == null) {
			return;
		}
		DecoratingLabelProvider decoratingLabelProvider = new DecoratingLabelProvider(
				new QuickFixStatusLabelProvider(), decorator);
		treeViewer.setLabelProvider(decoratingLabelProvider);
		QuickFixStausContentProvider contentProvider = new QuickFixStausContentProvider(
				this.decorator);
		treeViewer.setContentProvider(contentProvider);
		if (this.decorator != null) {
			treeViewer.setInput(this.decorator);
		} else if (dmoList != null) {
			treeViewer.setInput(new DmoListHolder(dmoList));
		} else {
			treeViewer.setInput(dmo);
		}
		//treeViewer.expandToLevel(2);
		expandAll();
		statusFilter = new StatusViewFilter(contentProvider);
		treeViewer.setFilters(new ViewerFilter[] { statusFilter });
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public void expandAll() {
		if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
			treeViewer.expandAll();
		}
	}

	public void collapseAll() {
		if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
			treeViewer.collapseAll();
		}
	}

	public StatusViewFilter getStatusFilter() {
		return statusFilter;
	}

}
