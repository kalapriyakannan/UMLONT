/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.NamespaceElementContentProvider;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.NamespaceElementLabelProvider;

/**
 * This dialog shows a filtered tree view of project explorer, in which the user can easily browse
 * for topology files, and filter the tree through a text entry field.
 * 
 * @author NKruk
 * 
 */
public class OpenTopologyDialog extends SelectionDialog {
	protected String description;
	protected TreeViewer viewer;
	private Object currentSelection;

	/**
	 * Create a new Open Topology Dialog
	 * 
	 * @param parentShell
	 */
	public OpenTopologyDialog(Shell parentShell) {
		super(parentShell);
		this.setTitle(Messages.OpenTopologyDialog_Open_Topolog_);
		this.setHelpAvailable(false);
		description = Messages.OpenTopologyDialog_Select_a_topology_file_to_open_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_OPEN_DIALOG);
		Label l = new Label(dialogArea, SWT.NONE);
		l.setText(description);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		l.setLayoutData(data);

		PatternFilter filter = new PatternFilter() {
			private Set<Object> visible = new HashSet<Object>(); //Set of visible items in tree

			//Clear the visible elements when pattern changes
			public void setPattern(String patternString) {
				visible.clear();
				super.setPattern(patternString);
			}

			//Hack to show all contents underneath a parent if it matches
			//the filter text since we cant override filter() or isAnyVisible()
			public boolean isElementVisible(Viewer viewer, Object element) {
				//Always need to evaluate super.isElementVisible so isAnyVisible() gets called
				return visible.contains(element) | super.isElementVisible(viewer, element);
			}

			//If a parent is a leaf match, make sure we show all children
			protected boolean isParentMatch(Viewer viewer, Object element) {
				if (isLeafMatch(viewer, element)) {
					Object[] children = ((ITreeContentProvider) ((AbstractTreeViewer) viewer)
							.getContentProvider()).getChildren(element);
					visible.addAll(Arrays.asList(children));
				}
				return super.isParentMatch(viewer, element);
			}

			//Makes sure all levels of children get shown underneath a visible parent
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				return visible.contains(element) || super.isLeafMatch(viewer, element);
			}

		};
		filter.setIncludeLeadingWildcard(false);
		filter.setPattern("*"); //$NON-NLS-1$
		FilteredTree tree = new FilteredTree(dialogArea, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER, filter);

		viewer = tree.getViewer();
		//Filter to be used in combination with Custom Content Provider
		//TODO filter empty namespaces
		ViewerFilter topFilter = new ViewerFilter() {
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				//Filter non topology projects
				if (element instanceof IProject) {
					return NamespaceCore.locateRoots((IProject) element, new NullProgressMonitor()).length > 0;
				}
				//Filter non topology files
				if (element instanceof IFile) {
					if (((IFile) element).getFileExtension() != null) {
						return IConstants.TOPOLOGY_EXTENSION.equals(((IFile) element).getFileExtension());
					}
					return false;
				}
				return true;
			}
		};
		viewer.addFilter(topFilter);
		viewer.setSorter(new TreePathViewerSorter());

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof IFile) {
						currentSelection = obj;
						okPressed();
					}
				}
			}
		});

		//Get rid of .topology extension
		ILabelProvider lp = new NamespaceElementLabelProvider() {
			public String getText(Object element) {
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					if (INamespaceElement.DEFAULT_TOPOLOGYFILE_EXTENSION.equalsIgnoreCase(file
							.getFileExtension())) {
						return file.getName().substring(0, file.getName().lastIndexOf(".")); //$NON-NLS-1$
					}
				}
				return super.getText(element);
			}
		};
		ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager()
				.getLabelDecorator();
		viewer.setContentProvider(new Content());
		viewer.setLabelProvider(new DecoratingLabelProvider(lp, decorator));
		viewer.setInput(ResourcesPlugin.getWorkspace().getRoot());

		data = new GridData(GridData.FILL_BOTH);
		data.heightHint = 370;
		data.widthHint = 325;
		tree.setLayoutData(data);

		//Listen for changes to the selection so that we can enable the ok button
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof IFile) {
						currentSelection = obj;
						getOkButton().setEnabled(true);
					} else {
						getOkButton().setEnabled(false);
					}
				}
			}
		});
		return dialogArea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		//set the result then return
		ArrayList result = new ArrayList();
		result.add(currentSelection);
		setResult(result);
		super.okPressed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#create()
	 */
	public void create() {
		//Override so we can disable the ok button
		super.create();
		this.getOkButton().setEnabled(false);
	}

	/**
	 * Modified version of the NamespaceElementContentProvider. Overrides getParent and getChildren
	 * to not display INamespaceFragmentRoot's that are the same as the project.
	 * 
	 * @author NKruk
	 * 
	 * TODO-- This may not be needed when topologies are restricted to src folders which are not the
	 * Project root
	 */
	private class Content extends NamespaceElementContentProvider {
		public Object getParent(Object child) {
			if (child instanceof IProject) {
				return ((IProject) child).getParent();
			}
			//If the parent is the namespaceroot and project, return the resource
			Object parent = super.getParent(child);
			if (parent instanceof INamespaceFragmentRoot
					&& ((INamespaceFragmentRoot) parent).getCorrespondingResource() instanceof IProject) {
				return ((INamespaceFragmentRoot) parent).getCorrespondingResource();
			}
			return parent;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public Object[] getChildren(Object o) {
			if (o instanceof IWorkspaceRoot) {
				return ((IWorkspaceRoot) o).getProjects();
			}
			//if project is namespace root, return children of it
			if (o instanceof IProject) {
				List children = Arrays.asList(NamespaceCore.locateRoots((IProject) o,
						new NullProgressMonitor()));
				for (int i = 0; i < children.size(); i++) {
					if (children.get(i) instanceof INamespaceFragmentRoot
							&& ((INamespaceFragmentRoot) children.get(i)).getCorrespondingResource() instanceof IProject) {
						return super.getChildren(children.get(i));
					}
				}
			}
			return super.getChildren(o);
		}
	};
}
