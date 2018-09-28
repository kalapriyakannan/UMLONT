/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.NamespaceElementLabelProvider;

/**
 * This is a {@link SelectionDialog} used to browse the available source folders.
 * 
 */
public class TopologySourceFolderSelectionDialog extends SelectionDialog {

	private static final Object[] EMPTY_FOLDERS = new Object[0];

	private Tree sourceFolderTree;
	private TreeViewer sourceFolderTreeViewer = null;
	private IContainer selectedSourceFolder;

	private class SourceFolderTreeContentProvider implements ITreeContentProvider {

		public SourceFolderTreeContentProvider() {
			super();
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof IProject) {
				return getSourceFolders((IProject) parentElement);
			}
			//Ignore all other types since we don't yet support
			//nested roots.
			return EMPTY_FOLDERS;
		}

		/*
		 * TODO Need to update to stop at true source folders.
		 */
		private Object[] getSourceFolders(IProject project) {
			Object[] possibleRoots = null;
			try {
				IResource[] members = project.members();
				List memberFolders = null;
				for (int i = 0; i < members.length; i++) {
					//Filter out ".*" folders.
					if (members[i].getType() == IResource.FOLDER
							&& !members[i].getName().startsWith(String.valueOf(IConstants.DOT_SEPARATOR))) {
						//Filter Java output locations.
						IJavaProject javaProject = JavaCore.create(project);
						if (javaProject != null && javaProject.exists()) {
							//Ignore output folders.
							IPath defaultOutput = javaProject.getOutputLocation();
							if (defaultOutput.equals(members[i].getFullPath())) {
								continue;
							}
						}
						if (memberFolders == null) {
							memberFolders = new ArrayList();
						}
						INamespaceElement namespaceElement = NamespaceCore.create((IFolder) members[i]);
						if (namespaceElement != null && namespaceElement.exists()) {
							if (namespaceElement.getType() == INamespaceElement.TOPOLOGY_NAMESPACE_ROOT) {
								//Do not add namespace folders as possible source folders.
								memberFolders.add(namespaceElement);
							}
						} else {
							memberFolders.add(members[i]);
						}
					}
				}
				if (memberFolders != null) {
					//Sort members.
					Collections.sort(memberFolders, new Comparator() {
						public int compare(Object obj1, Object obj2) {
							Assert.isNotNull(obj1);
							Assert.isNotNull(obj2);
							String name1 = obj1 instanceof INamespaceElement ? ((INamespaceElement) obj1)
									.getName() : ((IResource) obj1).getName();
							String name2 = obj2 instanceof INamespaceElement ? ((INamespaceElement) obj2)
									.getName() : ((IResource) obj2).getName();
							return name1.compareToIgnoreCase(name2);
						}
					});
					possibleRoots = new Object[memberFolders.size()];
					memberFolders.toArray(possibleRoots);
				}
			} catch (CoreException e) {
				// Fail gracefully.  There is no reason to
				//log this event since it is not critical to the operation.
			}
			return possibleRoots != null ? possibleRoots : EMPTY_FOLDERS;
		}

		public Object[] getElements(Object inputElement) {
			//Get all project in the workspace.
			return ResourcesPlugin.getWorkspace().getRoot().getProjects();
		}

		public void dispose() {
			//Do nothing.
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//Do nothing
		}

		public boolean hasChildren(Object element) {
			if (element instanceof IProject) {
				return hasSourceFolders((IProject) element);
			}
			return false;
		}

		private boolean hasSourceFolders(IProject project) {

			try {
				IResource[] members = project.members();
				if (members.length > 0) {
					for (int i = 0; i < members.length; i++) {
						if (members[i].getType() == IResource.FOLDER) {
							return true;
						}
					}
				}
			} catch (CoreException e) {
				//Fail gracefully.
			}
			return false;
		}

		public Object getParent(Object element) {
			if (element instanceof INamespaceFragmentRoot) {
				IContainer container = ((INamespaceFragmentRoot) element).getCorrespondingResource();
				return container.getParent();
			}
			if (element instanceof IFolder) {
				return ((IFolder) element).getParent();
			}
			return null;
		}

	}

	/**
	 * @param parentShell
	 */
	public TopologySourceFolderSelectionDialog(Shell parentShell) {
		super(parentShell);
		initDialogParameters();
		int shellStyle = getShellStyle();
		setShellStyle(shellStyle | SWT.MAX | SWT.RESIZE);
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_NEW_TOPOLOGY_WIZARD_SOURCE_FOLDER_SEL_WINDOW);

		Composite composite = (Composite) super.createDialogArea(parent);
		createMessageArea(composite);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		sourceFolderTree = new Tree(composite, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
		sourceFolderTree.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				buttonPressed(IDialogConstants.OK_ID);
			}

			public void widgetSelected(SelectionEvent e) {
				//do nothing
			}
		});
//        gridData.widthHint = convertWidthInCharsToPixels(28);
//        gridData.heightHint = convertHeightInCharsToPixels(28);
		sourceFolderTree.setLayoutData(gridData);
		sourceFolderTreeViewer = new TreeViewer(sourceFolderTree);
		setTreeProviders();
		setInput();
		return composite;
	}

	private void initDialogParameters() {
		setTitle(Messages.TopologySourceFolderSelectionDialog_Source_Folder_Selectio_);
		setMessage(Messages.TopologySourceFolderSelectionDialog_Select_a_source_folder_);
		setHelpAvailable(false);
	}

	private void setInput() {
		sourceFolderTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
	}

	private void setTreeProviders() {
		sourceFolderTreeViewer.setContentProvider(new SourceFolderTreeContentProvider());
		sourceFolderTreeViewer.setLabelProvider(new NamespaceElementLabelProvider());
	}

	protected void okPressed() {
		IStructuredSelection selection = (IStructuredSelection) sourceFolderTreeViewer.getSelection();
		if (!selection.isEmpty()) {
			Object first = selection.getFirstElement();
			if (first instanceof IProject) {
				selectedSourceFolder = (IContainer) first;
			} else if (first instanceof INamespaceFragmentRoot) {
				selectedSourceFolder = ((INamespaceFragmentRoot) first).getCorrespondingResource();
			} else if (first instanceof IContainer) {
				selectedSourceFolder = (IContainer) first;
			}
		}
		super.okPressed();
	}

	public IContainer getSelectedSourceFolder() {
		return selectedSourceFolder;
	}

	/**
	 * Set the current selection in the tree to the passed {@link IContainer}.
	 * 
	 * @param aContainer
	 */
	public void setSelection(IContainer aContainer) {
		if (aContainer != null && aContainer.exists()) {
			sourceFolderTreeViewer.setSelection(new StructuredSelection(aContainer));
		}
	}

}
