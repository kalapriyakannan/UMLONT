package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceProcessor;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceRefactoringDescriptor;

public class RenameNamespaceWizard extends RefactoringWizard {

	private final RenameNamespaceRefactoringDescriptor dataModel;

	public RenameNamespaceWizard(RenameRefactoring refactoring, String pageTitle) {
		super(refactoring, RefactoringWizard.DIALOG_BASED_UESR_INTERFACE | PREVIEW_EXPAND_FIRST_NODE);
		super.setDefaultPageTitle(pageTitle);
		super.setForcePreviewReview(false);
		super.setForcePreviousAndNextButtons(false);
		dataModel = ((RenameNamespaceProcessor) ((RenameRefactoring) super.getRefactoring())
				.getProcessor()).getDataModel();
		IResource resource = dataModel.getPreviousNamespaceContainer();
		if (resource != null) {
			switch (resource.getType())
			{
			case IResource.PROJECT:
				setInitialSelections((IProject) resource);
				break;
			case IResource.FOLDER:
				setInitialSelections((IFolder) resource);
				break;
			case IResource.FILE:
				setInitialSelections((IFile) resource);
				break;
			}
		}
	}

	@Override
	protected void addUserInputPages() {
		addPage(new RenameNamespaceWizardPage1(dataModel, RenameNamespaceWizardPage1.PAGE_NAME));
	}

	private void setInitialSelections(IFile file) {
		IContainer parent = file.getParent();
		if (parent != null) {
			switch (parent.getType())
			{
			case IResource.PROJECT:
				setInitialSelections((IProject) parent);
				break;

			case IResource.FOLDER:
				setInitialSelections((IFolder) parent);
				break;
			}
		}
	}

	private void setInitialSelections(IFolder folder) {
		ITopologyNamespaceRootIndexer indexer = DeployCorePlugin.getDefault()
				.getTopologyNamespaceRootIndexer();
		ITopologyNamespaceRootIndex index = indexer.getTopologyNamespaceRootIndex(
				folder.getProject(), null);
		if (index != null) {
			INamespaceFragmentRoot root = index.getRoot(folder);
			if (root != null) {
				IContainer container = root.getCorrespondingResource();
				if (container != null) {
					dataModel.setSourcePath(container.getFullPath().toString());
					if (!container.equals(folder)) {
						IPath namespacePath = folder.getFullPath().removeFirstSegments(
								container.getFullPath().segmentCount());
						INamespaceFragment namespaceFragment = root.resolveNamespace(namespacePath
								.segments());
						if (namespaceFragment != null) {
							dataModel.setPreviousNamespacePath(namespaceFragment.getQualifiedName());
						}
					}
				}
			} else {
				IPath path = folder.getFullPath();
				if (path.segmentCount() > 2) {
					//Trim the path to no more than 2 segments for now.
					path = path.removeLastSegments(path.segmentCount() - 2);
				}
				path = path.makeRelative();
				dataModel.setSourcePath(path.toString());
			}
		}
	}

	private void setInitialSelections(IProject project) {
		//make project have default source folder of "topologies"
		dataModel.setSourcePath(project.getName() + "/topologies"); //$NON-NLS-1$
	}

	@Override
	public void dispose() {
		super.dispose();
		if (dataModel != null) {
			dataModel.dispose();
		}
	}

}
