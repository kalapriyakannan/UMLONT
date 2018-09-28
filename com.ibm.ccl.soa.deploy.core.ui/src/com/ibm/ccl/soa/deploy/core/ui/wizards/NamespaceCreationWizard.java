package com.ibm.ccl.soa.deploy.core.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateNamespaceDataModelProvider;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceCreationWizardPage1;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.DecoratingDataModelWizardPage.IDecoratingWizard;

public class NamespaceCreationWizard extends DataModelWizard implements INewWizard,
		IExecutableExtension, IDecoratingWizard {

	private CreateNamespaceDataModel namespaceDataModel;

	public void init(IWorkbench workbench, IStructuredSelection aSelection) {
		setNeedsProgressMonitor(true);
		IStructuredSelection selection = aSelection;
		setWindowTitle(Messages.NamespaceCreationWizard_Topology_Namespace_Wizar_);
		setDefaultPageImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOP_WIZ_BAN));
		if (getDataModel() != null) {
			namespaceDataModel = new CreateNamespaceDataModel(getDataModel());
			if (selection != null && !selection.isEmpty()) {
				Object sel = selection.getFirstElement();
				if (sel instanceof INamespaceElement) {
					setInitialSelections((INamespaceElement) sel);
				} else {
					IResource resource = (IResource) Platform.getAdapterManager().getAdapter(sel,
							IResource.class);
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
			}
		}
	}

	private void setInitialSelections(INamespaceElement element) {
		switch (element.getType())
		{
		case INamespaceElement.TOPOLOGY_NAMESPACE_ROOT:
			namespaceDataModel.setSourcePath(((INamespaceFragmentRoot) element)
					.getCorrespondingResource().getFullPath().toString());
			break;
		case INamespaceElement.TOPOLOGY_NAMESPACE:
			INamespaceFragment namespaceFragment = (INamespaceFragment) element;
			namespaceDataModel.setNamespacePath(namespaceFragment.getQualifiedName());
			namespaceDataModel.setSourcePath(namespaceFragment.getRoot().getCorrespondingResource()
					.getFullPath().toString());
		}
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
					namespaceDataModel.setSourcePath(root.getCorrespondingResource().getFullPath()
							.toString());
					if (!container.equals(folder)) {
						IPath namespacePath = folder.getFullPath().removeFirstSegments(
								container.getFullPath().segmentCount());
						INamespaceFragment namespaceFragment = root.resolveNamespace(namespacePath
								.segments());
						if (namespaceFragment != null) {
							namespaceDataModel.setNamespacePath(namespaceFragment.getQualifiedName());
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
				namespaceDataModel.setSourcePath(path.toString());
			}
		}
	}

	private void setInitialSelections(IProject project) {
		//make project have default source folder of "topologies"
		namespaceDataModel.setSourcePath(project.getName() + "/topologies"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#getDefaultProvider()
	 */
	protected IDataModelProvider getDefaultProvider() {
		return new CreateNamespaceDataModelProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#doAddPages()
	 */
	protected void doAddPages() {
		addPage(new NamespaceCreationWizardPage1(namespaceDataModel,
				Messages.NamespaceCreationWizard_Namespac_));
	}

	// refresh the project explorer view
	protected void postPerformFinish() {
		// give a chance for the creation wizard to exit first
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Workbench workbench = Workbench.getInstance();
				if (null != workbench) {
					IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
					for (int i = 0; i < windows.length; i++) {
						IWorkbenchPage[] pages = windows[i].getPages();
						for (int p = 0; p < pages.length; p++) {
							IViewPart part = pages[p].findView(ProjectExplorer.VIEW_ID);
							if (null != part && part instanceof CommonNavigator) {
								CommonNavigator navigator = (CommonNavigator) part;
								navigator.getCommonViewer().refresh(
										namespaceDataModel.getSourceContainer().getProject());
							}
						}
					}
				}
			}
		});
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	/*
	 * Exposing as public for others to call.
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#isExecuting()
	 */
	public boolean isExecuting() {
		return super.isExecuting();
	}

}
