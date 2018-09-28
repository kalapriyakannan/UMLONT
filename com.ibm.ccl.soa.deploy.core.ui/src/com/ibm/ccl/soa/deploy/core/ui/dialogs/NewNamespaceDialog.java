package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateNamespaceDataModelProvider;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.CreateNamespaceComposite;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.TextProcessorDataModelSynchHelper;

public class NewNamespaceDialog extends TitleAreaDialog implements IDataModelListener {

	private TextProcessorDataModelSynchHelper synchHelper;
	private IDataModel dataModel;
	private CreateNamespaceDataModel createNamespaceDataModel;

	public NewNamespaceDialog(Shell parentShell, IStructuredSelection aSelection) {
		super(parentShell);
		initialize(aSelection);
	}

	public NewNamespaceDialog(Shell parentShell) {
		super(parentShell);
		dataModel = getDataModel();
		initialize(null);
	}

	protected void initialize(IStructuredSelection selection) {
		dataModel = getDataModel();
		if (dataModel != null) {
			createNamespaceDataModel = new CreateNamespaceDataModel(dataModel);
			synchHelper = new TextProcessorDataModelSynchHelper(dataModel);
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
			dataModel.addListener(this);
		}
	}

	private void setInitialSelections(INamespaceElement element) {
		switch (element.getType())
		{
		case INamespaceElement.TOPOLOGY_NAMESPACE_ROOT:
			createNamespaceDataModel.setSourcePath(((INamespaceFragmentRoot) element)
					.getCorrespondingResource().getFullPath().toString());
			break;
		case INamespaceElement.TOPOLOGY_NAMESPACE:
			INamespaceFragment namespaceFragment = (INamespaceFragment) element;
			createNamespaceDataModel.setNamespacePath(namespaceFragment.getQualifiedName());
			createNamespaceDataModel.setSourcePath(namespaceFragment.getRoot()
					.getCorrespondingResource().getFullPath().toString());
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
					createNamespaceDataModel.setSourcePath(root.getCorrespondingResource().getFullPath()
							.toString());
					if (!container.equals(folder)) {
						IPath namespacePath = folder.getFullPath().removeFirstSegments(
								container.getFullPath().segmentCount());
						INamespaceFragment namespaceFragment = root.resolveNamespace(namespacePath
								.segments());
						if (namespaceFragment != null) {
							createNamespaceDataModel
									.setNamespacePath(namespaceFragment.getQualifiedName());
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
				createNamespaceDataModel.setSourcePath(path.toString());
			}
		}
	}

	private void setInitialSelections(IProject project) {
		//make project have default source folder of "topologies"
		createNamespaceDataModel.setSourcePath(project.getName() + "/topologies"); //$NON-NLS-1$
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		return new CreateNamespaceComposite((Composite) super.createDialogArea(parent), SWT.NONE,
				synchHelper, createNamespaceDataModel);
	}

	public void create() {
		super.create();
		setTitle(Messages.NewNamespaceDialog_Topology_Namespac_);
		setMessage(Messages.NewNamespaceDialog_Create_a_Topology_namespace_);
		getOKButton().setEnabled(false);
	}

	public void propertyChanged(DataModelEvent event) {
		setErrorMessage(null);
		IStatus status = dataModel.validate();
		if (status.isOK()) {
			getOKButton().setEnabled(true);
		} else {
			getOKButton().setEnabled(false);
			setErrorMessage(getStatusWithHighestSeverity(status).getMessage());
		}
	}

	@Override
	protected void okPressed() {
		getOKButton().setEnabled(false);
		getCancelButton().setEnabled(false);
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
								createNamespaceDataModel.getSourceContainer().getProject());
					}
				}
			}
		}
		super.okPressed();
	}

	public INamespaceElement getNamespace() {
		IContainer src = createNamespaceDataModel.getSourceContainer();
		INamespaceFragmentRoot root = NamespaceCore.getRoot(src);
		if (createNamespaceDataModel.getNamespaceContainer() != null) {
			return root.resolveNamespace(createNamespaceDataModel.getNamespacePath());
		}

		return root;
	}

	protected CreateNamespaceDataModel getCreateNamespaceDataModel() {
		return createNamespaceDataModel;
	}

	protected IDataModel getDataModel() {
		if (null == dataModel) {
			dataModel = DataModelFactory.createDataModel(getDefaultProvider());
		}

		return dataModel;
	}

	protected IDataModelProvider getDefaultProvider() {
		return new CreateNamespaceDataModelProvider();
	}

	private IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}

}
