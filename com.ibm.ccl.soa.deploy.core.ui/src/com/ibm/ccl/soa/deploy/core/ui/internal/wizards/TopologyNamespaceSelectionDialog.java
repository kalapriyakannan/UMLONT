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
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * A {@link SelectionDialog} that is used to provide a selection of the available namespaces for a
 * given source {@link IContainer}.
 * 
 */
public class TopologyNamespaceSelectionDialog extends ElementListSelectionDialog {
	private static final IFolder[] EMPTY_FOLDERS = new IFolder[0];

	private String selectedNamespace;
	private IContainer sourceContainer;

	/**
	 * 
	 * @param parent -
	 *           The parent {@link Shell}.
	 * @param aSourceContainer -
	 *           The {@link IContainer} representing the source root.
	 */
	public TopologyNamespaceSelectionDialog(Shell parent, IContainer aSourceContainer) {
		super(parent, new NamespaceLabelProvider(aSourceContainer));
		setSourceContainer(aSourceContainer);
		initDialogParameters();
	}

	private void initDialogParameters() {
		setTitle(Messages.TopologyNamespaceSelectionDialog_Namespace_Selectio_);
		setHelpAvailable(false);
	}

	protected void okPressed() {
		Object[] selection = fFilteredList.getSelection();
		if (selection.length == 1) {
			IContainer namespaceContainer = (IContainer) selection[0];
			NamespaceLabelProvider namespaceProvider = (NamespaceLabelProvider) fFilteredList
					.getLabelProvider();
			selectedNamespace = namespaceProvider.getText(namespaceContainer);
		}
		super.okPressed();
	}

	/**
	 * 
	 * @return - The selected {@link IFolder} converted to a fully qualified namespace {@link String}.
	 */
	public String getSelectedNamespace() {
		return selectedNamespace;
	}

	private void setSourceContainer(IContainer aSourceContainer) {
		sourceContainer = aSourceContainer;
		if (sourceContainer != null && sourceContainer.exists()) {
			setElements(getNamespaces(aSourceContainer));
		}
	}

	/**
	 * 
	 * @param aSourceContainer -
	 *           The {@link IContainer} representing the source root.
	 * @return - An array of {@link IFolder}s that are namespaces defined in the aSourceContainer.
	 */
	public static IFolder[] getNamespaces(IContainer aSourceContainer) {
		List namespaceList = new ArrayList();
		collectNamespaceFolders(aSourceContainer, namespaceList);
		if (namespaceList.isEmpty()) {
			return EMPTY_FOLDERS;
		}
		IFolder[] namespaces = new IFolder[namespaceList.size()];
		namespaceList.toArray(namespaces);
		return namespaces;
	}

	private static void collectNamespaceFolders(IContainer container, List namespaceList,
			INamespaceFragmentRoot[] roots) {
		try {
			IResource[] members = container.members();
			if (members.length > 0) {
				for (int i = 0; i < members.length; i++) {
					if (members[i].getType() == IResource.FOLDER
							&& (roots == null || !isRoot(members[i], roots))) {
						namespaceList.add(members[i]);
						collectNamespaceFolders((IContainer) members[i], namespaceList);
					}
				}
			}
		} catch (CoreException e) {
			//Fail gracefully.
		}
	}

	private static boolean isRoot(IResource resource, INamespaceFragmentRoot[] roots) {
		for (int i = 0; i < roots.length; i++) {
			if (resource.equals(roots[i].getCorrespondingResource())) {
				return true;
			}
		}
		return false;
	}

	private static void collectNamespaceFolders(IContainer container, List namespaceList) {
		if (container != null && container.exists()) {
			switch (container.getType())
			{
			case IResource.PROJECT:
				INamespaceFragmentRoot[] roots = null;
				roots = DeployCorePlugin.getDefault().getTopologyNamespaceRootIndexer()
						.getTopologyNamespaceRootIndex((IProject) container, null).getRootNamespaces();
				collectNamespaceFolders(container, namespaceList, roots);
				break;
			case IResource.FOLDER:
				collectNamespaceFolders(container, namespaceList, null);
				break;
			}
		}
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_NEW_TOPOLOGY_WIZARD_NAMESPACE_SEL_WINDOW);

		return super.createDialogArea(parent);

	}
}
